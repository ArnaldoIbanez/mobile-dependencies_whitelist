package com.melidata.definitions.format

import com.melidata.definitions.manager.MeliDataCatalogUploader

class MeliDataHiveFormatter extends HiveFormatter {

    public static String CATALOG_DIR = MeliDataCatalogUploader.CATALOG_DIR
    public static String CATALOG_CSV = "melidata_catalog.csv"
    public static String S3_CATALOG_FILE = MeliDataCatalogUploader.S3_CATALOG_FILE

    MeliDataHiveFormatter(String catalogDir, String s3CatalogFile) {
        super(catalogDir, s3CatalogFile)
    }

    static void main(String[] args) {
        def file = new File(CATALOG_CSV)
        file.delete()

        file << new MeliDataHiveFormatter(CATALOG_DIR, S3_CATALOG_FILE).output
    }

}
