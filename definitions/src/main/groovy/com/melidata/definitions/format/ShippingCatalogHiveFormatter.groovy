package com.melidata.definitions.format

import com.melidata.definitions.manager.ShippingCatalogUploader

class ShippingCatalogHiveFormatter extends HiveFormatter {


    ShippingCatalogHiveFormatter(String catalogDir, String s3CatalogFile) {
        super(catalogDir, s3CatalogFile)
    }

    static void main(String[] args) {
        String catalogDir = ShippingCatalogUploader.CATALOG_DIR
        String s3CatalogFile = ShippingCatalogUploader.S3_CATALOG_FILE
        String csvFileName = ShippingCatalogUploader.CSV_FILE_NAME
        def file = new File(csvFileName) //antes: catalog.csv - para que esta el del handler?
        file.delete()

        file << new ShippingCatalogHiveFormatter(catalogDir, s3CatalogFile).output
    }
}
