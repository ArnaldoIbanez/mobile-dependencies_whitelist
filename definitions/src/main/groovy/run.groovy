import com.melidata.definitions.outs.StdOut
import com.melidata.definitions.TestRunner

def status = TestRunner.run("src/main/resources/catalog.groovy", "src/test/resources/tests.groovy", new StdOut())

//If any test fails main program will exit with status=1
if(!status)
    System.exit(1)
