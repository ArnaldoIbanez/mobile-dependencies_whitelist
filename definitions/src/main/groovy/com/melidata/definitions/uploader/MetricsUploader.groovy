package com.melidata.definitions.uploader
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
        def metricsDir = "./src/main/resources/metrics/"
        def s3Bucket = "melidata-jobs"
        def accessKey = "AKIAJ7EIGFFJQC475PBQ"
        def secretKey = "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"

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
