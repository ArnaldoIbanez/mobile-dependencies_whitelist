package com.melidata.definitions.uploaders

import com.ml.melidata.manager.S3Controller
import com.ml.melidata.metrics.MetricsFactory
import com.ml.melidata.metrics.format.MetricsFormatter

/**
 * Created by geisbruch on 12/16/14.
 */
class MetricsUploader {

    def static JSON_CONTENT="application/json"
    def static LAST_VERSION_FILE_NAME = "metrics.json"

    def metricsDir

    def MetricsUploader(metricsDir) {
        this.metricsDir = metricsDir
        S3Controller.initializeAWSService()
    }

    def static void main(String[] args) {
        def metricsDir = "./src/main/resources/metrics/"
        new MetricsUploader(metricsDir).upload()
    }

    def upload() {
        println("Starting uploader")
        println("Reading [${metricsDir}]")

        def json =  new MetricsFormatter(MetricsFactory.metrics).output

        println("JSON loaded")

        println("Uploading ${LAST_VERSION_FILE_NAME}")

        S3Controller.saveFile("melidata-jobs", LAST_VERSION_FILE_NAME, json, JSON_CONTENT)

        println("Finish")
    }
}
