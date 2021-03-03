package com.melidata.definitions.manager

import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.services.s3.model.S3ObjectInputStream
import com.amazonaws.services.s3.model.S3ObjectSummary

class LambdaCatalogHandler extends CatalogHandler{

    Set<String> filesNameToDownloadForLambdaCatalog

    LambdaCatalogHandler(String catalogName) {
        super(catalogName)
        filesNameToDownloadForLambdaCatalog = new HashSet<>()
    }

    @Override
    boolean reload() {
        List<S3ObjectSummary> toDownload = new ArrayList<>()
        S3ObjectSummary catalogObjectSummary = new S3ObjectSummary()
        catalogObjectSummary.setKey(S3_CONTAINER+"catalog.groovy")
        toDownload.add(catalogObjectSummary)

        // download catalog.groovy file and get the names of the other files to download from s3
        S3Object object = downloadCatalog(toDownload)

        if ( object != null ) {

            toDownload.clear() //remove catalog.groovy from teh list. It is already downloaded
            for (String fileName : filesNameToDownloadForLambdaCatalog) {
                S3ObjectSummary objectSummary = new S3ObjectSummary()
                objectSummary.setKey(S3_CONTAINER+fileName)
                toDownload.add(objectSummary)
            }
            // download other files that are necessary for the catalog to be parsed
            downloadCatalog(toDownload)

            try {
                // Empty list as there is no need to update the etag for each file downloaded
                reloadCatalog(object, Collections.emptyList())
            } finally {
                object.close()
            }
            return true
        }
        return false
    }

    @Override
    S3Object downloadCatalog(List<S3ObjectSummary> objectSummaries, String folder = LOCAL_FOLDER, String keyPrefixReplacement = "") throws IOException {
        S3Object object = null
        for ( S3ObjectSummary obj : objectSummaries ) {
            boolean isMainFile = isMainFile(obj.getKey())
            S3Object s3Object = cli.getObject(obj.getKey())
            S3ObjectInputStream objectContent = s3Object.getObjectContent()

            BufferedWriter writer = null
            BufferedReader reader = null
            try {
                def output = new File(folder, obj.getKey().replace(S3_CONTAINER, keyPrefixReplacement))
                output.getParentFile().mkdirs()
                writer = new BufferedWriter(new FileWriter(output))
                reader = new BufferedReader(new InputStreamReader(objectContent))
                String line
                while ((line = reader.readLine()) != null) {
                    if (isMainFile) checkAndAddFileToDownload(line)
                    writer.write(line + "\n")
                }
            } finally {
                if ( reader != null )
                    reader.close()
                if ( writer != null )
                    writer.close()
            }

            if ( isMainFile ) object =  s3Object
        }

        return object

    }

    private void  checkAndAddFileToDownload(String catalogLine) {
        if (catalogLine.contains("include") && catalogLine.contains("business")) {
            String fileName = catalogLine.split("\"")[1]
            this.filesNameToDownloadForLambdaCatalog.add(fileName)
        }
    }
}
