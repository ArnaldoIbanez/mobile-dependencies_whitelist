import org.junit.Test
import static org.junit.Assert.*
import static TrackTestDsl.trackTests

/**
 * Created by apetalas on 19/11/14.
 */
class TrackDslTest {


    @Test void ShouldCreateATestTrackWithTrackDSL(){


        def tracks = trackTests {
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

        assertEquals(tracks.size(), 3)
    }


}
