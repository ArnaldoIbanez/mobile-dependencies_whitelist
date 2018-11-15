package com.melidata.definitions.manager

class MeliDataCatalogUploader extends CatalogUploader {

    public static String CATALOG_DIR = "src/main/resources/catalog"
    public static String LAST_VERSION_OBJECT = "lastMeliDataVersion"
    public static String LAST_VERSION_FILE_NAME = "lastMeliData"
    public static String S3_CATALOG_FILE = "catalog2.groovy"
    public static String CSV_FILE_NAME = "melidata_last.csv/melidata_catalog.csv"

    def MeliDataCatalogUploader() {
        super(CATALOG_DIR, S3_CATALOG_FILE, LAST_VERSION_OBJECT, LAST_VERSION_FILE_NAME, CSV_FILE_NAME)
    }

    def static void main(String[] args) {
        new MeliDataCatalogUploader()
    }

}
