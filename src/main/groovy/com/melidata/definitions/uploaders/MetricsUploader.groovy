package com.melidata.definitions.uploaders

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ml.melidata.manager.storage.MetricsService
import com.ml.melidata.metrics.MetricsFactory
import com.ml.melidata.metrics.format.MetricsFormatter

/**
 * Created by geisbruch on 12/16/14.
 */
class MetricsUploader {

    MetricsService s3Service

    MetricsUploader() {
        this.s3Service = new MetricsService()
    }

    static void main(String[] args) {
        new MetricsUploader().upload()
    }

    def upload() {
        println("Compiling local metrics")
        String json = new MetricsFormatter(MetricsFactory.metrics).output

        BufferedWriter writer = new BufferedWriter(new FileWriter("metrics-test.json"))
        writer.write(json)
        writer.close()

        println("Uploading metrics")
        s3Service.saveMetrics(json)
    }
}
