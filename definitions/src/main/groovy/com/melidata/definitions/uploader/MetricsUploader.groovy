package com.melidata.definitions.uploader

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.parsers.json.CatalogJsonOutput
import org.apache.commons.io.IOUtils

/**
 * Created by geisbruch on 12/16/14.
 */
class MetricsUploader {

    def static JSON_CONTENT="application/json"

    def static LAST_VERSION_FILE_NAME = "metrics"

    def metricsDir
    def S3Controller s3Controller

    def MetricsUploader(metricsDir, s3Bucket, accessKey, secretKey) {
        this.metricsDir = metricsDir
        s3Controller = new S3Controller(s3Bucket, accessKey, secretKey)
    }

    def static void main(String[] args) {
        def metricsDir = System.getenv().get("METRICS_DSL_DIR")
        def s3Bucket = System.getenv().get("METRICS_S3_BUCKET")
        def accessKey = System.getenv().get("CAT_AWS_ACCESS_KEY_ID")
        def secretKey = System.getenv().get("CAT_AWS_SECRET_KEY")

        if(metricsDir == null || s3Bucket == null || accessKey == null || secretKey == null) {
            println """
                    This program espect 4 env variables
                    - METRICS_DSL_DIR ${metricsDir}
                    - METRICS_S3_BUCKET ${s3Bucket}
                    - CAT_AWS_ACCESS_KEY_ID ${accessKey}
                    - CAT_AWS_SECRET_KEY ${secretKey}
            """
            System.exit(1)
        }
        new MetricsUploader(metricsDir,s3Bucket,accessKey,secretKey).upload();
    }

    def upload() {
        println("Starting uploader")
        println("Reading [${metricsDir}]")

        def json =  new com.melidata.metrics.format.MetricsFormatter(com.ml.melidata.metrics.MetricsFactory.metrics).output

        println("JSON loaded")

        println("Uploading ${LAST_VERSION_FILE_NAME}.json")
        s3Controller.saveCatalogVersion(json,JSON_CONTENT, LAST_VERSION_FILE_NAME, 0)

        println("Finish")
    }
}
