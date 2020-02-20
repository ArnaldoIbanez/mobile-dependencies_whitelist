package com.melidata.definitions.uploaders

import com.melidata.definitions.manager.S3Controller
import com.melidata.metrics.format.MetricsFormatter

/**
 * Created by geisbruch on 12/16/14.
 */
class MetricsUploader {

    def static JSON_CONTENT="application/json"
    def static LAST_VERSION_FILE_NAME = "metrics.json"

    def metricsDir
    def S3Controller s3Controller

    def MetricsUploader(metricsDir, s3Bucket, accessKey, secretKey) {
        this.metricsDir = metricsDir
        s3Controller = new S3Controller(s3Bucket, accessKey, secretKey)
    }

    def static void main(String[] args) {
        def metricsDir = "./src/main/resources/metrics/"
        def s3Bucket = "melidata-jobs"
        def accessKey = "AKIAIRJ4DFA72UDCX7QA"
        def secretKey = "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"

        new MetricsUploader(metricsDir,s3Bucket,accessKey,secretKey).upload();
    }

    def upload() {
        println("Starting uploader")
        println("Reading [${metricsDir}]")

        def json =  new MetricsFormatter(com.ml.melidata.metrics.MetricsFactory.metrics).output

        println("JSON loaded")

        println("Uploading ${LAST_VERSION_FILE_NAME}")

        s3Controller.saveFile(LAST_VERSION_FILE_NAME, json, JSON_CONTENT)

        println("Finish")
    }
}
