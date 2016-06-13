package com.melidata.definitions.uploader

import com.melidata.definitions.format.HiveFormatter
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
    def static CSV_FILE_NAME="last.csv/catalog.csv" //must have a directory to be use in a hive table

    def catalogFile
    def S3Controller s3Controller

    def CatalogUploader(catalogFile, s3Bucket, accessKey, secretKey) {
        this.catalogFile = catalogFile
        s3Controller = new S3Controller(s3Bucket, accessKey, secretKey)
    }

    def static void main(String[] args) {
        def catalogFile = "./src/main/resources/catalog.groovy"
        def s3Bucket = "melidata-catalog-versions"
        def accessKey = "AKIAIRJ4DFA72UDCX7QA"
        def secretKey = "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"

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
        println("Upload catalog.csv hive format")
        def csv = new HiveFormatter().output
        s3Controller.saveFile(CSV_FILE_NAME, csv)
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
