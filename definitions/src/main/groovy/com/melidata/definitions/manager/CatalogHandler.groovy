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

	private static final String AWS_KEY = 'AKIAI2AFLMRLNMSP3IJA'
	private static final String AWS_SECRET = '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'

	public static String LAST_VERSION_OBJECT = "last2Version"
	public static String LAST_VERSION_FILE_NAME = "last2"

	public static String LOCAL_FOLDER = "/data/catalog/";
	public static String S3_CONTAINER = LAST_VERSION_FILE_NAME + ".dsl/";
	public static String S3_CATALOG_FILE = "catalog.groovy";
	public static String BUCKET = "melidata-catalog-versions"

	private S3Controller cli
	private String lastEtag
	private Catalog catalog
	private int version

	def CatalogHandler() {
		cli = new S3Controller(BUCKET, AWS_KEY, AWS_SECRET)
	}

	def boolean reload() {
		List<S3ObjectSummary> objectSummaries = cli.listObjects(new ListObjectsRequest().withBucketName(BUCKET).withPrefix(S3_CONTAINER)).getObjectSummaries();

		boolean reload = false
		for ( S3ObjectSummary obj : objectSummaries ) {
			if ( isMainFile(obj.getKey()) ){
				if ( lastEtag != obj.getETag() ) {
					reload = true;
					break;
				}
			}
		}

		if ( reload ) {
			S3Object object = downloadCatalog(objectSummaries)
			if ( object != null ) {
				try {
					reloadCatalog(object)
				} finally {
					object.close()
				}
				return true
			}
		}

		return false
	}

	def Catalog getCatalog() {
		return catalog
	}

	def int getVersion() {
		version
	}

	def String getLastEtag() {
		lastEtag
	}

	private reloadCatalog(S3Object object) {
		Integer newVersion = Integer.parseInt(object.getObjectMetadata().getUserMetaDataOf("catalog-version"));
		if (catalog == null || !newVersion.equals(version)) {
			DslUtils.setBaseDir(LOCAL_FOLDER);
			this.catalog = DslUtils.parseCatalog(new File(LOCAL_FOLDER, S3_CATALOG_FILE));
			this.version = newVersion
			this.lastEtag = object.getObjectMetadata().getETag();
		}
	}

	private S3Object downloadCatalog(List<S3ObjectSummary> objectSummaries) throws IOException {
		S3Object object = null;
		for ( S3ObjectSummary obj : objectSummaries ) {
			S3Object s3Object = cli.getObject(obj.getKey());
			S3ObjectInputStream objectContent = s3Object.getObjectContent();

			BufferedWriter writer = null;
			BufferedReader reader = null;
			try {
				def output = new File(LOCAL_FOLDER, obj.getKey().replace(S3_CONTAINER, ""))
				output.getParentFile().mkdirs()
				writer = new BufferedWriter(new FileWriter(output));
				reader = new BufferedReader(new InputStreamReader(objectContent));
				String line;
				while ((line = reader.readLine()) != null) {
					writer.write(line + "\n");
				}
			} finally {
				if ( reader != null )
					reader.close();
				if ( writer != null )
					writer.close();
			}

			if ( isMainFile(obj.getKey()) ) object =  s3Object;
		}

		return object;

	}

	private boolean isMainFile(String key) {
		return (key.contains("/") && key.endsWith("/" + S3_CATALOG_FILE)) ||
				(!key.contains("/") && key.endsWith(S3_CATALOG_FILE))
	}

}

