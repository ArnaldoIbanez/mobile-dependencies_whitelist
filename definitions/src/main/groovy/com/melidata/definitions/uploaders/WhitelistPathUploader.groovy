package com.melidata.definitions.uploaders

import com.melidata.definitions.manager.S3Controller
import com.google.gson.GsonBuilder

class WhitelistPathUploader {

    def static JSON_CONTENT="application/json"
    def static FILE_NAME = "path.json"

    def pathWhitelistDir
    def S3Controller s3Controller

    def WhitelistPathUploader(pathWhitelistDir, s3Bucket, accessKey, secretKey) {
        this.pathWhitelistDir = pathWhitelistDir
        s3Controller = new S3Controller(s3Bucket, accessKey, secretKey)
    }

    def static void main(String[] args) {
        def pathWhitelistDir = "./src/main/resources/whitelist/"
        def s3Bucket = "melidata-api-whitelist"
        def accessKey = "AKIAJ4K4ZOXUNJLTL4NQ"
        def secretKey = "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"

        new WhitelistPathUploader(pathWhitelistDir,s3Bucket,accessKey,secretKey).upload();
    }

    def upload() {
        println("Starting whitelist uploader")
        println("Reading [${pathWhitelistDir}${this.FILE_NAME}]")

        String pathContents = new File( this.pathWhitelistDir + this.FILE_NAME).text
        def gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()
        def json =  gson.toJson(gson.fromJson(pathContents, Map))


        String versionedName = "versions/path_" + new Date().format("yyyMMddHHmmss") + ".json"

        println("JSON loaded")
        println("Uploading ${FILE_NAME}")


        s3Controller.saveFile( FILE_NAME, json, JSON_CONTENT)
        s3Controller.saveFile(versionedName, json, JSON_CONTENT)

        println("Finish")
    }
}
