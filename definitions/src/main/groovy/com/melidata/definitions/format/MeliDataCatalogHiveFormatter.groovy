package com.melidata.definitions.format

import com.melidata.definitions.manager.CatalogUploader
import com.melidata.definitions.manager.MeliDataCatalogHandler

class MeliDataCatalogHiveFormatter extends HiveFormatter {


    MeliDataCatalogHiveFormatter(String catalogDir, String s3CatalogFile) {
        super(catalogDir, s3CatalogFile)
    }

    static void main(String[] args) {
        String catalogDir = CatalogUploader.CATALOG_DIR
        String s3CatalogFile = MeliDataCatalogHandler.S3_CATALOG_FILE
        String csvFileName = MeliDataCatalogHandler.CSV_FILE_NAME
        def file = new File(csvFileName) //antes: catalog.csv - para que esta el del handler?
        file.delete()

        file << new MeliDataCatalogHiveFormatter(catalogDir, s3CatalogFile).output
    }
}
