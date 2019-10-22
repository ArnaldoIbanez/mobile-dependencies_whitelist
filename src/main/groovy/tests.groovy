static void main(String[] args) {

    println( "Testing catalog....")
    testCatalog.main(args)
    println( "Testing bi-integration....")
    testCronnedQueries.main(args)
    println( "Testing metrics....")
    testMetrics.main(args)
}