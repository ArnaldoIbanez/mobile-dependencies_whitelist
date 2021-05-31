package com.melidata.definitions.uploaders

import com.google.gson.GsonBuilder
import com.ml.melidata.manager.S3Controller

class WhitelistPathUploader {

    def static JSON_CONTENT="application/json"
    def static FILE_NAME = "path.json"

    def pathWhitelistDir
    def S3Controller s3Controller

    def WhitelistPathUploader(pathWhitelistDir) {
        this.pathWhitelistDir = pathWhitelistDir
    }

    def static void main(String[] args) {
        def pathWhitelistDir = "./src/main/resources/whitelist/"
        new WhitelistPathUploader(pathWhitelistDir).upload();
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


        s3Controller.saveFile( "melidata-api-whitelist", FILE_NAME, json, JSON_CONTENT)
        s3Controller.saveFile("melidata-api-whitelist", versionedName, json, JSON_CONTENT)

        println("Finish")
    }
}
