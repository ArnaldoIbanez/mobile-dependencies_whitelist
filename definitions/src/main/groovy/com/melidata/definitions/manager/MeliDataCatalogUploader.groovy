package com.melidata.definitions.manager

class MeliDataCatalogUploader extends CatalogUploader {

    def MeliDataCatalogUploader(String s3CatalogFile, String lastVersionObject, String lastVersionFileName, String csvFileName) {
        super(s3CatalogFile, lastVersionObject, lastVersionFileName, csvFileName)
    }

    def static void main(String[] args) {
        String s3CatalogFile = MeliDataCatalogHandler.S3_CATALOG_FILE
        String lastVersionObject = MeliDataCatalogHandler.LAST_VERSION_OBJECT
        String lastVersionFileName = MeliDataCatalogHandler.LAST_VERSION_FILE_NAME
        String csvFileName = MeliDataCatalogHandler.CSV_FILE_NAME
        new MeliDataCatalogUploader(s3CatalogFile, lastVersionObject, lastVersionFileName, csvFileName)
    }

}
