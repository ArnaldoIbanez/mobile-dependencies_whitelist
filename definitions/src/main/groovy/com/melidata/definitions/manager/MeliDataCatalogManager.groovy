package com.melidata.definitions.manager

class MeliDataCatalogManager extends CatalogManager {

    public static String LAST_VERSION_OBJECT = "lastMeliDataVersion"
    public static String LAST_VERSION_FILE_NAME = "lastMeliData"
    public static String LOCAL_FOLDER = "src/main/resources/catalog/"//"/data/catalog/"
    public static String S3_CONTAINER = LAST_VERSION_FILE_NAME + ".dsl/"
    public static String S3_CATALOG_FILE = "melidata_catalog.groovy"
    public static String CSV_FILE_NAME = "melidata_last.csv/melidata_catalog.csv"

    MeliDataCatalogManager() {
        super(LAST_VERSION_OBJECT, LAST_VERSION_FILE_NAME, LOCAL_FOLDER, S3_CONTAINER, S3_CATALOG_FILE, CSV_FILE_NAME)
    }

}
