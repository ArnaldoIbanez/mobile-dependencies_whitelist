import com.melidata.definitions.outs.StdOut
import com.melidata.definitions.TestRunner
import com.ml.melidata.catalog.parsers.dsl.CatalogDsl


static void main(String[] args) {
    String catalogName = args[0]

    CatalogDsl.setBaseDir("src/main/resources/catalog/" + catalogName + "/")
    println( "Preparing....")
    def status = TestRunner.run(catalogName, new StdOut())

    //If any test fails main program will exit with status=1
    if(!status)
        System.exit(1)

}