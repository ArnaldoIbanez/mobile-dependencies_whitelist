package com.melidata.definitions.manager

class ShippingCatalogManager extends CatalogManager {

    public static String LAST_VERSION_OBJECT = "shippingLastVersion"
    public static String LAST_VERSION_FILE_NAME = "shippingLast"
    public static String LOCAL_FOLDER = "/data/catalog/"
    public static String S3_CONTAINER = LAST_VERSION_FILE_NAME + ".dsl/"
    public static String S3_CATALOG_FILE = "shipping_catalog.groovy"
    public static String CSV_FILE_NAME = "shipping_last.csv/shipping_catalog.csv"

    ShippingCatalogManager() {
        super(LAST_VERSION_OBJECT, LAST_VERSION_FILE_NAME, LOCAL_FOLDER, S3_CONTAINER, S3_CATALOG_FILE, CSV_FILE_NAME, "shipping")
    }

}
