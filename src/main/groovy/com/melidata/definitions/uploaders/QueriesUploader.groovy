package com.melidata.definitions.uploaders

import com.melidata.definitions.manager.S3Controller
import com.melidata.metrics.format.QueryFormatter

class QueriesUploader {

    def static JSON_CONTENT="application/json"
    def static LAST_VERSION_FILE_NAME = "jsonmelidata.json"

    def queriesDir
    def S3Controller s3Controller

    def QueriesUploader(queriesDir, s3Bucket, accessKey, secretKey) {
        this.queriesDir = queriesDir
        s3Controller = new S3Controller(s3Bucket, accessKey, secretKey)
    }

    def static void main(String[] args) {
        def queriesDir = "./src/main/resources/data-dependencies-catalog/"
        def s3Bucket = "melidata-croned-queries"
        def accessKey = "AKIAJFRFUW5LZXNX5TWQ"
        def secretKey = "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"

        new QueriesUploader(queriesDir,s3Bucket,accessKey,secretKey).upload();
    }

    def upload() {
        println("Starting uploader")
        println("Reading [${queriesDir}]")

        def json =  new QueryFormatter().buildJson()
        String versionedName = "versions/jsonmelidata_" + new Date().format("yyyMMddHHmmss") + ".json"

        println("JSON loaded")

        println("Uploading ${LAST_VERSION_FILE_NAME}")

        s3Controller.saveFile(LAST_VERSION_FILE_NAME, json, JSON_CONTENT)
        s3Controller.saveFile(versionedName, json, JSON_CONTENT)

        println("Finish")
    }
}
