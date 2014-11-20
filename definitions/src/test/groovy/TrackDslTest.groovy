import com.ml.melidata.catalog.PropertyType
import org.junit.Test

import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
import static org.junit.Assert.*
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

/**
 * Created by apetalas on 19/11/14.
 */
class TrackDslTest {


    @Test void ShouldCreateATestTrackWithTrackDSL(){

        def catalog = catalog {
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

            tracks {
                "/search"(platform: "/") {
                    limit(description:"amount of search items returned")
                    offset(type: PropertyType.Numeric, regex:".*")
                }
                "/search"(platform: "/mobile") {
                    position(values: ["horizonal","landscape"])
                }
                "/checkout"(platform: "/") {
                    category(regex:/[a-zA-Z]{1,3}[0-9]+/)
                }
            }
        }

        def tests = trackTests {
            test("Search gallery with 50 items, first page" ) {
                "/search"(platform:"/mobile") {
                    limit = 10
                    offset = 0
                }
                "/search/refine" {
                    limit = 10
                    offset = 0
                }
            }

            test("dos"){
                "/checkout"{
                    limit = 0
                }
            }
        }

        tests.each { assertTrue(it.assertThat(catalog)) }
    }
}
