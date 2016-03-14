package com.melidata.definitions.uploader

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.parsers.json.CatalogJsonOutput
import org.apache.commons.io.IOUtils

/**
 * Created by geisbruch on 12/16/14.
 */
class S3Uploader {

    def static DSL_CONTENT="application/dsl"

    def catalogFile
    def S3Controller s3Controller

    def S3Uploader(catalogFile, s3Bucket, accessKey, secretKey) {
        this.catalogFile = catalogFile
        s3Controller = new S3Controller(s3Bucket, accessKey, secretKey)
    }

    def static void main(String[] args) {
        def catalogFile = System.getenv().get("CATALOG_FILE")
        def s3Bucket = System.getenv().get("PRESTO_S3_BUCKET")
        def accessKey = System.getenv().get("PRESTO_AWS_ACCESS_KEY_ID")
        def secretKey = System.getenv().get("PRESTO_AWS_SECRET_KEY")
        if(catalogFile == null || s3Bucket == null || accessKey == null || secretKey == null) {
            println """
                    This program espect 4 env variables
                    - CATALOG_FILE
                    - PRESTO_S3_BUCKET
                    - PRESTO_AWS_ACCESS_KEY_ID
                    - Secret key
            """
            System.exit(1)
        }
        new S3Uploader(catalogFile,s3Bucket,accessKey,secretKey).upload();
    }

    def upload() {
        println("Starting s3 uploader")
        s3Controller.saveFile("catalog.csv", catalogFile)
    }
}
