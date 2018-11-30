package com.melidata.definitions.manager

import com.amazonaws.services.s3.model.ListObjectsRequest
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.services.s3.model.S3ObjectInputStream
import com.amazonaws.services.s3.model.S3ObjectSummary
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.DslUtils

/**
 * Created by mtencer on 5/4/16.
 */
class CatalogHandler {

	private static final String AWS_ACCESS_KEY = 'AKIAIRJ4DFA72UDCX7QA'//'AKIAI2AFLMRLNMSP3IJA'
	private static final String AWS_SECRET_KEY = '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'//'BZUVcUw7CfLgoJVr06w15sJ308Tnxv+c42Hhul6G'

	public static String S3BUCKET = "melidata-catalog-versions"

	public static String LAST_VERSION_OBJECT
	public static String LAST_VERSION_FILE_NAME
	public static String LOCAL_FOLDER
	public static String S3_CONTAINER
	public static String S3_CATALOG_FILE
	public static String CSV_FILE_NAME

	private S3Controller cli
	private Map<String, String> lastEtag = [:]
	private Catalog catalog
	private int version
	private String catalogName

	CatalogHandler(String lastVersionObject, String lastVersionFileName, String localFolder, String s3Container, String s3CatalogFile, String csvFileName, String catalogName) {
		LAST_VERSION_OBJECT = lastVersionObject
		LAST_VERSION_FILE_NAME = lastVersionFileName
		LOCAL_FOLDER = localFolder
		S3_CONTAINER = s3Container
		S3_CATALOG_FILE = s3CatalogFile
		CSV_FILE_NAME = csvFileName
		cli = new S3Controller(S3BUCKET, AWS_ACCESS_KEY, AWS_SECRET_KEY)
		this.catalogName = catalogName
	}

	boolean reload() {
		//check if some file of BUCKET/S3_CONTAINER has changed (etag)
		List<S3ObjectSummary> objectSummaries = cli.listObjects(new ListObjectsRequest().withBucketName(S3BUCKET).withPrefix(S3_CONTAINER)).getObjectSummaries()

		boolean reload = false
		for ( S3ObjectSummary obj : objectSummaries ) {
			if ( !lastEtag[obj.getKey()] || lastEtag[obj.getKey()] != obj.getETag() ){
				reload = true
				break
			}
		}

		if ( reload ) {
			S3Object object = downloadCatalog(objectSummaries)
			if ( object != null ) {
				try {
					reloadCatalog(object, objectSummaries)
				} finally {
					object.close()
				}
				return true
			}
		}

		return false
	}

	Catalog getCatalog() {
		return catalog
	}

	int getVersion() {
		version
	}

	String getCatalogName() {
		catalogName
	}

	private reloadCatalog(S3Object object, List<S3ObjectSummary> objectSummaries) {
		Integer newVersion = Integer.parseInt(object.getObjectMetadata().getUserMetaDataOf("catalog-version"))
		if (catalog == null || !newVersion.equals(version)) {
			DslUtils.setBaseDir(LOCAL_FOLDER)
			this.catalog = DslUtils.parseCatalog(new File(LOCAL_FOLDER, S3_CATALOG_FILE))
			this.version = newVersion
			this.lastEtag.clear()
			for ( S3ObjectSummary obj : objectSummaries ) {
				this.lastEtag[obj.getKey()] = obj.getETag()
			}
		}
	}

	private S3Object downloadCatalog(List<S3ObjectSummary> objectSummaries) throws IOException {
		S3Object object = null
		for ( S3ObjectSummary obj : objectSummaries ) {
			S3Object s3Object = cli.getObject(obj.getKey())
			S3ObjectInputStream objectContent = s3Object.getObjectContent()

			BufferedWriter writer = null
			BufferedReader reader = null
			try {
				def output = new File(LOCAL_FOLDER, obj.getKey().replace(S3_CONTAINER, ""))
				output.getParentFile().mkdirs()
				writer = new BufferedWriter(new FileWriter(output))
				reader = new BufferedReader(new InputStreamReader(objectContent))
				String line
				while ((line = reader.readLine()) != null) {
					writer.write(line + "\n")
				}
			} finally {
				if ( reader != null )
					reader.close()
				if ( writer != null )
					writer.close()
			}

			if ( isMainFile(obj.getKey()) ) object =  s3Object
		}

		return object

	}

	private boolean isMainFile(String key) {
		return (key.contains("/") && key.endsWith("/" + S3_CATALOG_FILE)) ||
				(!key.contains("/") && key.endsWith(S3_CATALOG_FILE))
	}

}

