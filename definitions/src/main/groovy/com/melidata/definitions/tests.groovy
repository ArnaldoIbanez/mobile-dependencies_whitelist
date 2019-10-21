import com.melidata.definitions.JsonUploaderValidator
import com.melidata.definitions.outs.StdOut
import com.melidata.definitions.TestRunner
import com.ml.melidata.catalog.parsers.dsl.CatalogDsl

static void main(String[] args) {

    println( "Preparing....")
    def status = true

    args.each { catalogName ->
        CatalogDsl.setBaseDir("src/main/resources/catalog/" + catalogName + "/")

        status = status && TestRunner.run(catalogName, new StdOut())
    }

    status = status && JsonUploaderValidator.validate()

    //If any test fails main program will exit with status=1
    if(!status)
        System.exit(1)
}