package com.melidata.definitions.manager

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.parsers.json.CatalogJsonOutput
import org.apache.commons.io.IOUtils

/**
 * Created by geisbruch on 12/16/14.
 */
class Uploader {

    def static CATALOG_DIR = "src/main/resources"

    def S3Controller s3Controller

    def Uploader(accessKey, secretKey) {
        s3Controller = new S3Controller(accessKey, secretKey)
    }

    def static void main(String[] args) {
        def accessKey = System.getProperty("AWS_ACCESS_KEY_ID")
        def secretKey = System.getProperty("AWS_SECRET_KEY")
        if(accessKey == null || secretKey == null) {
            println """
                    This program expect 4 env variables
                    - AWS_ACCESS_KEY_ID
                    - Secret key
            """
            System.exit(1)
        }
        new Uploader(accessKey,secretKey).upload();
    }

    def upload() {
        println("Starting uploader")
        def catalogFile = new File(CATALOG_DIR, CatalogHandler.S3_CATALOG_FILE)
        println("Reading [${catalogFile}]")
        def dsl = IOUtils.toString(new FileInputStream(catalogFile))
        println("DSL loaded")
        println("Loading catalog")
        def Catalog catalog = parseCatalogFromDsl(dsl);
        catalog.addFile(catalogFile)
        println("Catalog loaded")

        println("Making json")
        def json = new CatalogJsonOutput().toJson(catalog)
        println("JSON ready")

        println("Getting last catalog version")
        Integer lastVersion = s3Controller.getLastVersion();
        lastVersion++;
        println("New version: ${lastVersion}")

        println("Uploading ${lastVersion}.dsl")
        s3Controller.saveCatalogVersion(catalog,lastVersion.toString(),lastVersion)
        println("Uploading ${lastVersion}.json")
        s3Controller.saveCatalogVersion(json,lastVersion.toString(),lastVersion)

        println("Uploading last.dsl")
        s3Controller.saveCatalogVersion(catalog,CatalogHandler.LAST_VERSION_FILE_NAME,lastVersion)
        println("Uploading last.dsl")
        s3Controller.saveCatalogVersion(json,CatalogHandler.LAST_VERSION_FILE_NAME,lastVersion)
        println("Setting last version")
        s3Controller.setLastServersion(lastVersion)
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
