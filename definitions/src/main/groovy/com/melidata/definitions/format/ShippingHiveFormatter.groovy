package com.melidata.definitions.format

import com.melidata.definitions.manager.ShippingCatalogUploader

class ShippingHiveFormatter extends HiveFormatter {

    public static String CATALOG_DIR = ShippingCatalogUploader.CATALOG_DIR
    public static String CATALOG_CSV = "shipping_catalog.csv"
    public static String S3_CATALOG_FILE = ShippingCatalogUploader.S3_CATALOG_FILE

    ShippingHiveFormatter(String catalogDir, String s3CatalogFile) {
        super(catalogDir, s3CatalogFile)
    }

    static void main(String[] args) {
        def file = new File(CATALOG_CSV)
        file.delete()

        file << new ShippingHiveFormatter(CATALOG_DIR, S3_CATALOG_FILE).output
    }
}
