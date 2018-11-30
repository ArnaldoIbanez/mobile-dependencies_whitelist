package com.melidata.definitions.format

import com.melidata.definitions.manager.ShippingCatalogUploader

class ShippingJSONFormatter extends JSONFormatter {

    public static String CATALOG_DIR = ShippingCatalogUploader.CATALOG_DIR
    public static String CATALOG_JSON = "shipping_catalog.json"
    public static String S3_CATALOG_FILE = ShippingCatalogUploader.S3_CATALOG_FILE

    ShippingJSONFormatter(String catalogDir, String s3CatalogFile) {
        super(catalogDir, s3CatalogFile)
    }

    static void main(String[] args) {
        def file = new File(CATALOG_JSON)
        file.delete()

        file << new ShippingJSONFormatter(CATALOG_DIR, S3_CATALOG_FILE).output
    }
}
