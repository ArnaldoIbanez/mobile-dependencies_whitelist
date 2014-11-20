import com.melidata.definitions.outs.StdOut
import com.melidata.definitions.TestRunner

TestRunner.run("./catalog/catalog.groovy", "./tests/tests.groovy", new StdOut())
