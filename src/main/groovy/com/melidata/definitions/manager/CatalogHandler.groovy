package com.melidata.definitions.manager

import com.amazonaws.services.s3.model.ListObjectsRequest
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.services.s3.model.S3ObjectInputStream
import com.amazonaws.services.s3.model.S3ObjectSummary
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.DslUtils
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import org.apache.commons.io.FileUtils

/**
 * Created by mtencer on 5/4/16.
 */
class CatalogHandler {

	private static final String AWS_ACCESS_KEY = 'AKIAIRJ4DFA72UDCX7QA'//'AKIAI2AFLMRLNMSP3IJA'
	private static final String AWS_SECRET_KEY = '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'//'BZUVcUw7CfLgoJVr06w15sJ308Tnxv+c42Hhul6G'
	public static String S3_BUCKET = "melidata-catalog-versions"
	public static String S3_CATALOG_FILE = "catalog.groovy"

	public String LAST_VERSION_OBJECT
	public String LAST_VERSION_FILE_NAME
	public String LOCAL_FOLDER
	public String S3_CONTAINER
	public String CSV_FILE_NAME

	S3Controller cli
	Map<String, String> lastEtag = [:]
	Catalog catalog
	int version
	String catalogName;

	CatalogHandler(String catalogName) {

		LAST_VERSION_OBJECT = "last" + catalogName.capitalize() + "Version"
		LAST_VERSION_FILE_NAME = "last" + catalogName.capitalize()
		LOCAL_FOLDER = "/tmp/data/catalog/" + catalogName + "/"
		S3_CONTAINER = catalogName + "-fury" + "/" + LAST_VERSION_FILE_NAME + ".dsl/"
		CSV_FILE_NAME = catalogName + "_last.csv/" + catalogName + "_catalog.csv"
		this.catalogName = catalogName

		cli = new S3Controller(S3_BUCKET, AWS_ACCESS_KEY, AWS_SECRET_KEY)
	}

	boolean reload() {
		//check if some file of BUCKET/S3_CONTAINER has changed (etag)
		List<S3ObjectSummary> objectSummaries = cli.listObjects(new ListObjectsRequest().withBucketName(S3_BUCKET).withPrefix(S3_CONTAINER)).getObjectSummaries()

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

	boolean catalogIsUpdated(String catalogFolder) {
		def provisionalCatalogFolder = "/tmp/" + catalogName + "/"

		List<S3ObjectSummary> objectSummaries = cli.listObjects(new ListObjectsRequest().withBucketName(S3_BUCKET).withPrefix(S3_CONTAINER)).getObjectSummaries()
        downloadCatalog(objectSummaries, provisionalCatalogFolder, "")

		return compareDirs(catalogFolder, provisionalCatalogFolder) && compareDirs(provisionalCatalogFolder, catalogFolder)
	}

	Catalog getCatalog() {
		return catalog
	}

	int getVersion() {
		version
	}

	protected reloadCatalog(S3Object object, List<S3ObjectSummary> objectSummaries) {
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

	protected S3Object downloadCatalog(List<S3ObjectSummary> objectSummaries, String folder = LOCAL_FOLDER, String keyPrefixReplacement = "") throws IOException {
		S3Object object = null
		for ( S3ObjectSummary obj : objectSummaries ) {
			S3Object s3Object = cli.getObject(obj.getKey())
			S3ObjectInputStream objectContent = s3Object.getObjectContent()

			def output = new File(folder, obj.getKey().replace(S3_CONTAINER, keyPrefixReplacement))
			output.getParentFile().mkdirs()
			FileUtils.copyInputStreamToFile(objectContent, output);

			if ( isMainFile(obj.getKey()) ) object =  s3Object
		}

		return object

	}

	protected boolean isMainFile(String key) {
		return key.endsWith(S3_CATALOG_FILE)
	}

	private boolean compareDirs(actualCatalog, uploadedCatalog) {

		def areEquals = true

		new File(actualCatalog).listFiles().each { actualFile ->

			try {
				def fileUploaded = new File(uploadedCatalog + actualFile.name)

				if (actualFile.text != fileUploaded.text) {
					areEquals = false
				}
			}
			catch (FileNotFoundException e){
				areEquals = false
			}
		}

		return areEquals
	}

}

