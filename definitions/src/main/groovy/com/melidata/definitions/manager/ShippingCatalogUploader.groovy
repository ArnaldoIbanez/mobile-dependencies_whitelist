package com.melidata.definitions.manager

class ShippingCatalogUploader extends CatalogUploader {

    public static String CATALOG_DIR = "src/main/resources/catalog"
    public static String LAST_VERSION_OBJECT = "shippingLastVersion"
    public static String LAST_VERSION_FILE_NAME = "shippingLast"
    public static String S3_CATALOG_FILE = "shipping_catalog.groovy"
    public static String CSV_FILE_NAME = "shipping_last.csv/shipping_catalog.csv"

    def ShippingCatalogUploader() {
        super(CATALOG_DIR, S3_CATALOG_FILE, LAST_VERSION_OBJECT, LAST_VERSION_FILE_NAME, CSV_FILE_NAME)
    }

    def static void main(String[] args) {
        new ShippingCatalogUploader()
    }

}