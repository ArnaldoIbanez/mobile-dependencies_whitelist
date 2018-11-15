package com.melidata.definitions.format


import com.melidata.definitions.manager.MeliDataCatalogUploader


class MeliDataCatalogHiveFormatter extends HiveFormatter {


    MeliDataCatalogHiveFormatter(String catalogDir, String s3CatalogFile) {
        super(catalogDir, s3CatalogFile)
    }

    static void main(String[] args) {
        String catalogDir = MeliDataCatalogUploader.CATALOG_DIR
        String s3CatalogFile = MeliDataCatalogUploader.S3_CATALOG_FILE
        String csvFileName = MeliDataCatalogUploader.CSV_FILE_NAME
        def file = new File(csvFileName) //antes: catalog.csv - para que esta el del handler?
        file.delete()

        file << new MeliDataCatalogHiveFormatter(catalogDir, s3CatalogFile).output
    }
}
