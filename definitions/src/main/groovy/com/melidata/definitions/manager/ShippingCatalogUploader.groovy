package com.melidata.definitions.manager

class ShippingCatalogUploader extends CatalogUploader {

    def ShippingCatalogUploader(String s3CatalogFile, String lastVersionObject, String lastVersionFileName, String csvFileName) {
        super(s3CatalogFile, lastVersionObject, lastVersionFileName, csvFileName)
    }

    def static void main(String[] args) {
        String s3CatalogFile = ShippingCatalogHandler.S3_CATALOG_FILE
        String lastVersionObject = ShippingCatalogHandler.LAST_VERSION_OBJECT
        String lastVersionFileName = ShippingCatalogHandler.LAST_VERSION_FILE_NAME
        String csvFileName = ShippingCatalogHandler.CSV_FILE_NAME
        new ShippingCatalogUploader(s3CatalogFile, lastVersionObject, lastVersionFileName, csvFileName)
    }

}