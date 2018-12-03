import com.melidata.definitions.outs.StdOut
import com.melidata.definitions.TestRunner
import com.melidata.definitions.JsonUploaderValidator
import com.ml.melidata.catalog.parsers.dsl.CatalogDsl

static void main(String[] args) {
    String catalogName = args[0]
    System.setProperty("CATALOG_NAME", catalogName)

    println( "Preparing....")
    def status = TestRunner.run(catalogName, new StdOut())

    status = status && JsonUploaderValidator.validate()

    //If any test fails main program will exit with status=1
    if(!status)
        System.exit(1)

}