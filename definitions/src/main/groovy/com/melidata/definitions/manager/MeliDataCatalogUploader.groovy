package com.melidata.definitions.manager

class MeliDataCatalogUploader extends CatalogUploader {

    public static String CATALOG_DIR = "src/main/resources/catalog"
    public static String LAST_VERSION_OBJECT = "lastMeliDataVersion"
    public static String LAST_VERSION_FILE_NAME = "lastMeliData"
    public static String S3_CATALOG_FILE = "melidata_catalog.groovy"
    public static String CSV_FILE_NAME = "melidata_last.csv/melidata_catalog.csv"

    MeliDataCatalogUploader() {
        super(CATALOG_DIR, S3_CATALOG_FILE, LAST_VERSION_OBJECT, LAST_VERSION_FILE_NAME, CSV_FILE_NAME)
    }

    static void main(String[] args) {
        new MeliDataCatalogUploader()
    }

}
