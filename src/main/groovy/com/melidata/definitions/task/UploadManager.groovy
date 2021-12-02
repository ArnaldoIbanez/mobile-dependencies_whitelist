package com.melidata.definitions.task

import com.melidata.definitions.uploaders.CatalogUploader
import com.melidata.definitions.uploaders.MetricsUploader
import com.melidata.definitions.uploaders.WhitelistPathUploader

class UploadManager {

    static void main(String[] args) {
        def context = System.getenv('BUILD_CONTEXT')
        def parser = new JsonSlurper()
        def json = parser.parseText(context)

        if(json && json['git_is_merge']) {
            println("Testing catalog....")
            CatalogTest.main(args)
            println("Testing metrics....")
            MetricsTest.main('false')

            println("Starting upload of all catalogs")
            CatalogUploader.main(args)
            println("Starting upload metrics")
            MetricsUploader.main(args)
            println("Starting upload json for whitelisted paths")
            WhitelistPathUploader.main(args)
        } else {
            println("Melidata upload is only available on productive environments, you probably shouldnt be doing this")
        }

        System.exit(0)
    }
}