import com.melidata.definitions.validators.CatalogValidator
import com.melidata.definitions.outs.DefinitionsOut
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.parsers.dsl.CatalogDsl
import org.junit.Before
import org.junit.Test
import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
import static org.junit.Assert.*
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests


/**
 * Created by apetalas on 21/11/14.
 */
class TestRunnerTest {
    def catalog = null

    @Before void createCatalogAndTest(){
        CatalogDsl.baseDir="src/main/resources/catalog/"
        this.catalog  = catalog {
            /**
             * All available platfrom
             */
            platforms = [
                    "/",
                    "/desktop",
                    "/mobile",
                    "/mobile/android",
                    "/mobile/ios",
                    "/mobile/web",
            ]

            defaultBusinesses = ["mercadolibre"]

            tracks {
                initiative = "1148"

                "/search"(platform: "/") {
                    limit(description:"amount of search items returned")
                    offset(type: PropertyType.Numeric, regex:".*")
                }
                "/search"(platform: "/mobile") {
                    position(values: ["horizontal","landscape"])
                }
                "/checkout"(platform: "/") {
                    category(regex:/[a-zA-Z]{1,3}[0-9]+/)
                }
            }
        }
    }

    @Test void shouldRunTestRunner() {
        def tests = trackTests {
            test("Search gallery with 50 items, first page") {
                "/search"(platform:"/mobile") {
                    position = "horizontal"
                    limit = 0
                    offset = 0
                }
            }

            test("Search gallery with 50 items, first page"){
            }
        }

        def result = CatalogValidator.run(this.catalog, tests, new OutTest())
        assertTrue(result)
    }

    @Test void shouldCallDefinitionsOutWhenFailAndSuccessSingleTest(){

        def std = new OutTest()
        def tests = trackTests {

            test("Search gallery with 50 items, first page") {
                "/search"(platform:"/mobile") {
                    position = "horizontal"
                    offset = 0
                }
            }

            test("Search gallery with 50 items, first page"){
            }
        }

        def result = CatalogValidator.run(this.catalog, tests, std)

        assertFalse(result)
        assertEquals(std.successTests, 1)
        assertEquals(std.failTests, 1)
        assertEquals(std.beforeRunCalls, 1)
        assertEquals(std.afterRunCalls,1)
    }
}

public class OutTest implements DefinitionsOut{

    def successTests = 0
    def failTests = 0
    def beforeRunCalls = 0
    def afterRunCalls = 0

    @Override
    def fail(Object test) {
        failTests++
    }

    @Override
    def success(Object test) {
        successTests++
    }

    @Override
    def beforeRun(Object catalog, Object tests) {
        beforeRunCalls++
    }

    @Override
    def afterRun(Object catalog) {
        afterRunCalls++
    }
}
