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

    private static final String AWS_ACCESS_KEY = "AKIAIRJ4DFA72UDCX7QA"
    private static final String AWS_SECRET_KEY = "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"
    private static String S3BUCKET = "melidata-catalog-versions"

    S3Controller s3Controller

    CatalogUploader(String catalogDir, String s3CatalogFile, String lastVersionObject, String lastVersionFileName, String csvFileName) {
        s3Controller = new S3Controller(S3BUCKET, AWS_ACCESS_KEY, AWS_SECRET_KEY)
        upload(catalogDir, s3CatalogFile, lastVersionObject, lastVersionFileName, csvFileName)
    }

    def upload(String catalogDir, String s3CatalogFile, String lastVersionObject, String lastVersionFileName, String csvFileName) {
        println("Starting uploader")
        def catalogFile = new File(catalogDir, s3CatalogFile)
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
        Integer lastVersion = s3Controller.getLastVersion(lastVersionObject)
        lastVersion++
        println("New version: ${lastVersion}")
        println("Uploading ${lastVersion}.dsl")
        s3Controller.saveCatalogVersion(catalog,lastVersion.toString(),lastVersion)
        println("Uploading ${lastVersion}.json")
        s3Controller.saveCatalogVersion(json,lastVersion.toString(),lastVersion)
        println("Uploading last dsl")
        s3Controller.saveCatalogVersion(catalog,lastVersionFileName,lastVersion)
        println("Uploading last json")
        s3Controller.saveCatalogVersion(json,lastVersionFileName,lastVersion)
        println("Setting last version")
        s3Controller.setLastServersion(lastVersionFileName, lastVersion)
        println("Upload catalog csv hive format")
        def csv = new HiveFormatter(catalogDir, s3CatalogFile).output
        s3Controller.saveFile(csvFileName, csv)
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
}
