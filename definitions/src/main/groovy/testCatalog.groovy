import com.melidata.definitions.outs.StdOut
import com.melidata.definitions.TestRunner

static void main(String[] args) {
    String catalogName = args[0]
    System.setProperty("CATALOG_NAME", catalogName)

    println( "Preparing....")
    def status = TestRunner.run(catalogName, new StdOut())

    //If any test fails main program will exit with status=1
    if(!status)
        System.exit(1)

}