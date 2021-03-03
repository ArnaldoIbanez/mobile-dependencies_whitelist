package com.melidata.definitions.uploaders

import com.melidata.definitions.manager.CatalogHandler
import com.melidata.definitions.format.HiveFormatter
import com.melidata.definitions.manager.S3Controller
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.parsers.dsl.CatalogDsl
import com.ml.melidata.catalog.parsers.json.CatalogJsonOutput
import org.apache.commons.io.IOUtils

/**
 * Created by geisbruch on 12/16/14.
 */
class CatalogUploader {

    private static final String AWS_ACCESS_KEY = "AKIAIRJ4DFA72UDCX7QA"
    private static final String AWS_SECRET_KEY = "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"
    private static String S3_BUCKET = "melidata-catalog-versions"
    public static String BASE_CATALOG_DIR = "src/main/resources/catalog/"

    String CATALOG_DIR
    S3Controller s3Controller
    CatalogHandler catalogHandler
    HiveFormatter hiveFormatter

    CatalogUploader(String catalogName) {
        s3Controller = new S3Controller(S3_BUCKET + "/" + catalogName + '-fury',  AWS_ACCESS_KEY, AWS_SECRET_KEY)
        this.catalogHandler = new CatalogHandler(catalogName)
        this.hiveFormatter = new HiveFormatter(catalogName)
        CatalogDsl.setBaseDir(BASE_CATALOG_DIR + catalogName + "/")
        CATALOG_DIR = BASE_CATALOG_DIR + catalogName + "/"
    }

    def upload() {
        println("Starting uploader")
        def catalogFile = new File(CATALOG_DIR + "/", CatalogHandler.S3_CATALOG_FILE)
        if (catalogHandler.catalogIsUpdated(CATALOG_DIR)) {
            println("Catalog doesn't have changes")
            return
        }
        println("Reading [${catalogFile}]")
        def dsl = IOUtils.toString(new FileInputStream(catalogFile))
        println("DSL loaded")
        println("Loading catalog")
        Catalog catalog = parseCatalogFromDsl(dsl)
        catalog.addFile(catalogFile)
        println("Catalog loaded")
        println("Making json")
        String json = new CatalogJsonOutput().toJson(catalog)
        println("JSON ready")
        println("Getting last catalog version")
        Integer lastVersion = s3Controller.getLastVersion(catalogHandler.LAST_VERSION_OBJECT)
        lastVersion++
        println("New version: ${lastVersion}")
        println("Uploading ${lastVersion}.dsl")
        s3Controller.saveCatalogVersion(catalog,lastVersion.toString(),lastVersion)

        println("Uploading last.dsl")
        s3Controller.saveCatalogVersion(catalog,catalogHandler.LAST_VERSION_FILE_NAME,lastVersion)
        println("Uploading last.json")
        s3Controller.saveCatalogVersion(json,catalogHandler.LAST_VERSION_FILE_NAME,lastVersion)
        println("Setting last version")
        s3Controller.setLastServersion(catalogHandler.LAST_VERSION_OBJECT, lastVersion)
        println("Upload catalog csv hive format")
        String csv = hiveFormatter.output
        s3Controller.saveFile(catalogHandler.CSV_FILE_NAME, csv)
    }


    Catalog parseCatalogFromDsl(dslStr) {
        GroovyShell shell = new GroovyShell()
        try {
            def catalog = shell.parse(dslStr).run()
            if(!(catalog instanceof Catalog)) {
                throw new CatalogException("Script doesn't generate a catalog object")
            }
            return catalog
        } catch(CatalogException e) {
            throw e
        } catch (Throwable e) {
            e.printStackTrace()
            throw new CatalogException("Error parsing catalog")
        }
    }

    static void main(String[] args) {

        args.each { catalogName ->
            new CatalogUploader(catalogName).upload()
        }
    }

}
