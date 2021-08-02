package com.melidata.definitions.uploaders

import com.amazonaws.services.s3.model.AmazonS3Exception
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.parsers.dsl.CatalogDsl
import com.ml.melidata.catalog.utils.DslUtils
import com.ml.melidata.manager.storage.CatalogService
import com.ml.melidata.manager.storage.S3Service


class CatalogUploader {

    public static String BASE_CATALOG_DIR = "src/main/resources/catalog/"

    String CATALOG_DIR
    CatalogService s3Service

    CatalogUploader(String catalogName) {
        CatalogDsl.setBaseDir(BASE_CATALOG_DIR + catalogName + "/")
        CATALOG_DIR = BASE_CATALOG_DIR + catalogName + "/"
        this.s3Service = new CatalogService(catalogName)
    }

    def upload() {
        def catalogFile = new File(CATALOG_DIR + "/", S3Service.CATALOG_MAIN_FILE)
        Catalog catalog = DslUtils.parseCatalog(catalogFile)
        catalog.addFile(catalogFile)

        Integer lastVersion = 0
        try {
            lastVersion = this.s3Service.getLastCatalogVersion()
            lastVersion++
        } catch(AmazonS3Exception e) {
            println("Catalog doesnt exist, so version will be 0")
        }

        String versionedFolder = lastVersion.toString() + ".dsl/"
        String lastVersionFile = "last" + s3Service.catalogName.capitalize() + "Version"
        this.s3Service.saveCatalogVersion(catalog, versionedFolder, lastVersion)
        this.s3Service.saveCatalogVersion(catalog, this.s3Service.lastCatalogFolder, lastVersion)
        //TODO Deprecated. Delete when catalog-api and consumers have 3.2.+ of commons
        this.s3Service.saveFile(lastVersionFile, lastVersion.toString())
    }

    static void main(String[] args) {

        args.each { catalogName ->
            println("Uploading catalog ${catalogName}")
            new CatalogUploader(catalogName).upload()
        }
    }

}
