package com.melidata.definitions.uploader

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.parsers.json.CatalogJsonOutput
import org.apache.commons.io.IOUtils

/**
 * Created by geisbruch on 12/16/14.
 */
class CatalogUploader {

    def static JSON_CONTENT="application/json"
    def static DSL_CONTENT="application/dsl"
    def static LAST_VERSION_FILE_NAME="last"

    def catalogFile
    def S3Controller s3Controller

    def CatalogUploader(catalogFile, s3Bucket, accessKey, secretKey) {
        this.catalogFile = catalogFile
        s3Controller = new S3Controller(s3Bucket, accessKey, secretKey)
    }

    def static void main(String[] args) {
        def catalogFile = System.getenv().get("CATALOG_DSL_FILE")
        def s3Bucket = System.getenv().get("S3_BUCKET")
        def accessKey = System.getenv().get("CAT_AWS_ACCESS_KEY_ID")
        def secretKey = System.getenv().get("CAT_AWS_SECRET_KEY")
        if(catalogFile == null || s3Bucket == null || accessKey == null || secretKey == null) {
            println """
                    This program espect 4 env variables
                    - CATALOG_DSL_FILE 
                    - CATALOG_S3_BUCKET
                    - CAT_AWS_ACCESS_KEY_ID
                    - CAT_AWS_SECRET_KEY 
            """
            System.exit(1)
        }
        new CatalogUploader(catalogFile,s3Bucket,accessKey,secretKey).upload();
    }

    def upload() {
        println("Starting uploader")
        println("Reading [${catalogFile}]")
        def dsl = IOUtils.toString(new FileInputStream(catalogFile))
        println("DSL loaded")
        println("Loading catalog")
        def Catalog catalog = parseCatalogFromDsl(dsl);
        println("Catalog loaded")
        println("Making json")
        def json = new CatalogJsonOutput().toJson(catalog)
        println("JSON ready")
        println("Getting last catalog version")
        Integer lastVersion = s3Controller.getLastVersion();
        lastVersion++;
        println("New version: ${lastVersion}")
        println("Uploading ${lastVersion}.dsl")
        s3Controller.saveCatalogVersion(dsl,DSL_CONTENT,lastVersion.toString(),lastVersion)
        println("Uploading ${lastVersion}.json")
        s3Controller.saveCatalogVersion(json,JSON_CONTENT,lastVersion.toString(),lastVersion)
        println("Uploading last.dsl")
        s3Controller.saveCatalogVersion(dsl,DSL_CONTENT,LAST_VERSION_FILE_NAME,lastVersion)
        println("Uploading last.dsl")
        s3Controller.saveCatalogVersion(json,JSON_CONTENT,LAST_VERSION_FILE_NAME,lastVersion)
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
