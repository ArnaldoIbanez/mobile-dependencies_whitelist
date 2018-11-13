package com.melidata.definitions.manager

import com.amazonaws.services.s3.model.ListObjectsRequest
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.services.s3.model.S3ObjectInputStream
import com.amazonaws.services.s3.model.S3ObjectSummary
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.DslUtils

/**
 * Created by mtencer on 5/4/16.
 */
class ShippingCatalogHandler extends CatalogHandler {

    def ShippingCatalogHandler() {
        super("shippingLastVersion", "shippingLast", "/data/catalog/", ".dsl/", "shipping_catalog.groovy", "shipping_last.csv/shipping_catalog.csv") //leerlos de una config
    }

}
