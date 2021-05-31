import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import org.junit.Before
import org.junit.Test

import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
import static org.junit.Assert.*
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

/**
 * Created by apetalas on 19/11/14.
 */
class TrackDslTest {

    def catalog = null
    def tests = null


    @Before void BuildCatalogTest(){
        this.catalog = catalog {

            defaultBusinesses = ["mercadolibre"]

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
                    position(values: ["horizontal","landscape"])
                }
                "/checkout"(platform: "/") {
                    category(regex:/[a-zA-Z]{1,3}[0-9]+/)
                }
            }
        }
    }

    @Test void ShouldCreateATestCountComplaintWithDSL(){

        def tests = trackTests {
            test("Search gallery with 50 items, first page") {
                "/search"(platform:"/mobile") {
                    position = "horizontal"
                    limit = 1
                    offset = 0
                }
            }
            test("Search gallery with 50 items, first page"){
            }
        }
        assertEquals(tests.size(), 2)
    }

    @Test void ShouldCreateATestComplaintWithDSL(){

        def singleTest = trackTests {
            test("Search gallery with 50 items, first page") {
                "/search"(platform:"/mobile") {
                    position = "horizontal"
                    limit = 1
                    offset = 0
                }
            }
        }.first()

        assertEquals(singleTest.name, "Search gallery with 50 items, first page")
    }



    @Test void ShouldCreateATestTrackWithRightProperty(){

        def singleTest = trackTests {
            test("Search gallery with 50 items, first page" ) {
                "/search"(platform:"/mobile") {
                    position = "horizontal"
                    limit = 1
                    offset = 0
                }
            }
        }.first()


        def eventData = singleTest.tracks.first().event_data
        assertEquals(eventData["position"], "horizontal")
        assertEquals(eventData["limit"], 1)
        assertEquals(eventData["offset"], 0)
    }



    @Test void ShouldValidatePropertysHeredadasTrue() {
        //Arrange
        def singleTest = trackTests {
            test("Search gallery with 50 items, first page") {
                "/search"(platform: "/mobile") {
                    position = "horizontal"
                    limit = 1
                    offset = 0
                }
            }
        }.first()

        assertTrue(singleTest.assertValid(this.catalog))
    }

    @Test void ShouldCreateATestTrackWithTrackDSL(){
        def singleTest = trackTests {
            test("Search gallery with 50 items, first page" ) {
                "/search"(platform:"/mobile") {
                    position = "horizontal"
                    limit = 1
                    offset = 0
                }
            }
        }.first()

        assertEquals(singleTest.tracks.size(), 1)
    }

    @Test void ShouldCreateATestTrackWithPlatformSet(){

        def singleTest = trackTests {
            test("Search gallery with 50 items, first page" ) {
                "/search"(platform:"/mobile") {
                    position = "horizontal"
                    limit = 1
                    offset = 0
                }
            }
        }.first()

        def track = singleTest.tracks.first()


        assertEquals(track.path, "/search")
        assertEquals(track.platform, "/mobile")
    }

    @Test void ShouldCreateTaskWithDefaultValues(){
        //Arrange
        def singleTest = trackTests {
            test("Search gallery with 50 items, first page" ) {
                "/search" {
                    position = "horizontal"
                    limit = 1
                    offset = 0
                }
            }
        }.first()

        def track = singleTest.tracks.first()

        assertEquals(track.path, "/search")
        assertEquals(track.platform, "/")
        assertEquals(track.type, TrackType.View)
    }

    @Test void ShouldCreateATestTrackWithAllPropertiesSet(){
        //Arrange
        def singleTest = trackTests {
            test("Search gallery with 50 items, first page" ) {
                "/search" (platform:"/mobile", type:TrackType.Email){
                    position = "horizontal"
                    limit = 1
                    offset = 0
                }
            }
        }.first()

        def track = singleTest.tracks.first()

        assertEquals(track.path, "/search")
        assertEquals(track.platform, "/mobile")
        assertEquals(track.type, TrackType.Email)
    }

    @Test void ShouldCreateATestTrackWithTrackTypeSet(){
        //Arrange
        def singleTest = trackTests {
            test("Search gallery with 50 items, first page" ) {
                "/search" (type:TrackType.Email){
                    position = "horizontal"
                    limit = 1
                    offset = 0
                }
            }
        }.first()

        def track = singleTest.tracks.first()

        assertEquals(track.path, "/search")
        assertEquals(track.platform, "/")
        assertEquals(track.type, TrackType.Email)
    }

    @Test void ShouldValidatePropertysInChildNodeTrue(){
        //Arrange
        def singleTest = trackTests {
            test("Search gallery with 50 items, first page" ) {
                "/search"(platform:"/mobile") {
                    position = "horizontal"
                    limit = 1
                    offset = 0
                }
            }
        }.first()

        assertTrue(singleTest.assertValid(this.catalog))
    }


}
