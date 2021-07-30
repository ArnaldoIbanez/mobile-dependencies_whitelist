package com.melidata.definitions.task

class TestManager {

    static void main(String[] args) {

        println("Testing catalog....")
        CatalogTest.main(args)
        println("Testing metrics....")
        MetricsTest.main(args)

        System.exit(0)
    }
}