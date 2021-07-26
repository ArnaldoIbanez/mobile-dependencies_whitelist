package com.melidata.definitions.uploaders

import com.google.gson.GsonBuilder

class WhitelistPathUploader {

    def static FILE_NAME = "path.json"
    def pathWhitelistDir
    def S3Service s3Service

    def WhitelistPathUploader(pathWhitelistDir) {
        this.pathWhitelistDir = pathWhitelistDir
        this.s3Service = new S3Service("melidata-api-whitelist")
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


        this.s3Service.saveFile( FILE_NAME, json)
        this.s3Service.saveFile( versionedName, json)

        println("Finish")
    }
}
