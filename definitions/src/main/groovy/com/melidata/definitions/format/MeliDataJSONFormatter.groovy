package com.melidata.definitions.format

import com.melidata.definitions.manager.MeliDataCatalogUploader

class MeliDataJSONFormatter extends JSONFormatter {

    public static String CATALOG_DIR = MeliDataCatalogUploader.CATALOG_DIR
    public static String CATALOG_JSON = "melidata_catalog.json"
    public static String S3_CATALOG_FILE = MeliDataCatalogUploader.S3_CATALOG_FILE

    MeliDataJSONFormatter(String catalogDir, String s3CatalogFile) {
        super(catalogDir, s3CatalogFile)
    }

    static void main(String[] args) {
        def file = new File(CATALOG_JSON)
        file.delete()

        file << new MeliDataJSONFormatter(CATALOG_DIR, S3_CATALOG_FILE).output
    }

}
