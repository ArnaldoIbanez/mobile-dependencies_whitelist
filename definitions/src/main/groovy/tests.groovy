import com.melidata.definitions.outs.StdOut
import com.melidata.definitions.TestRunner


def tests = new File("src/test/resources/").listFiles().collect{ it -> it.getAbsolutePath() }
def status = TestRunner.run("src/main/resources/catalog/catalog.groovy", tests, new StdOut())

//If any test fails main program will exit with status=1
if(!status)
    System.exit(1)
