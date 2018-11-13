package com.melidata.definitions.manager

import com.melidata.definitions.format.HiveFormatter
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.parsers.json.CatalogJsonOutput
import org.apache.commons.io.IOUtils

/**
 * Created by geisbruch on 12/16/14.
 */
class CatalogUploader {

    private static final String S3BUCKET = "melidata-catalog-versions"
    private static final String ACCESS_KEY = "AKIAIRJ4DFA72UDCX7QA"
    private static final String SECRET_KEY = "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"

    public static String LAST_VERSION_OBJECT
    public static String LAST_VERSION_FILE_NAME
    public static String S3_CATALOG_FILE
    public static String CSV_FILE_NAME

    def static CATALOG_DIR = "src/main/resources/catalog"

    def S3Controller s3Controller

    def CatalogUploader(String s3CatalogFile, String lastVersionObject, String lastVersionFileName, String csvFileName) {
        S3_CATALOG_FILE = s3CatalogFile
        LAST_VERSION_OBJECT = lastVersionObject
        LAST_VERSION_FILE_NAME = lastVersionFileName
        CSV_FILE_NAME = csvFileName
        s3Controller = new S3Controller(S3BUCKET, ACCESS_KEY, SECRET_KEY)
        upload() //o directamente acá pasar por parametro a s3catalogfile,... en vez de usar public static -> DIFERENCIA???!!
    }

    def upload() {
        println("Starting uploader")
        def catalogFile = new File(CATALOG_DIR, S3_CATALOG_FILE)
        println("Reading [${catalogFile}]")
        def dsl = IOUtils.toString(new FileInputStream(catalogFile))
        println("DSL loaded")
        println("Loading catalog")
        Catalog catalog = parseCatalogFromDsl(dsl)
        catalog.addFile(catalogFile)
        println("Catalog loaded")
        println("Making json")
        def json = new CatalogJsonOutput().toJson(catalog)
        println("JSON ready")
        println("Getting last catalog version")
        Integer lastVersion = s3Controller.getLastVersion(LAST_VERSION_OBJECT)
        lastVersion++
        println("New version: ${lastVersion}")
        println("Uploading ${lastVersion}.dsl")
        s3Controller.saveCatalogVersion(catalog,lastVersion.toString(),lastVersion)
        println("Uploading ${lastVersion}.json")
        s3Controller.saveCatalogVersion(json,lastVersion.toString(),lastVersion)

        println("Uploading last.dsl")
        s3Controller.saveCatalogVersion(catalog,LAST_VERSION_FILE_NAME,lastVersion)
        println("Uploading last.dsl")
        s3Controller.saveCatalogVersion(json,LAST_VERSION_FILE_NAME,lastVersion)
        println("Setting last version")
        s3Controller.setLastServersion(LAST_VERSION_OBJECT, lastVersion)
        println("Upload catalog.csv hive format")
        def csv = new HiveFormatter(CATALOG_DIR, S3_CATALOG_FILE).output
        s3Controller.saveFile(CSV_FILE_NAME, csv);
    }


    def Catalog parseCatalogFromDsl(dslStr) {
        GroovyShell shell = new GroovyShell();
        try {
            def catalog = shell.parse(dslStr).run();
            if(!(catalog instanceof Catalog)) {
                throw new CatalogException("Script doesn't generate a catalog object")
            }
            return catalog;
        } catch(CatalogException e) {
            throw e
        } catch (Throwable e) {
            e.printStackTrace()
            throw new CatalogException("Error parsing catalog")
        }
    }
}
