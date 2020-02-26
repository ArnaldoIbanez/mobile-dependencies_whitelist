import com.melidata.definitions.outs.StdOut
import com.melidata.definitions.validators.CatalogValidator
import com.ml.melidata.catalog.parsers.dsl.CatalogDsl


static void main(String[] args) {
    def status = false
    args.each { catalogName ->
        CatalogDsl.setBaseDir("src/main/resources/catalog/" + catalogName + "/")

        status = status && CatalogValidator.run(catalogName, new StdOut())
    }

    //If any test fails main program will exit with status=1
    if(!status)
        System.exit(1)
}