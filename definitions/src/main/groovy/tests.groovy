import com.melidata.definitions.outs.StdOut
import com.melidata.definitions.TestRunner
import com.melidata.definitions.JsonUploaderValidator

println( "Preparing....")
def tests = new File("src/test/resources/").listFiles().collect{ it -> it.getAbsolutePath() }
def status = TestRunner.run("src/main/resources/catalog/catalog.groovy", tests, new StdOut())

status = status && JsonUploaderValidator.validate()

//If any test fails main program will exit with status=1
if(!status)
    System.exit(1)
