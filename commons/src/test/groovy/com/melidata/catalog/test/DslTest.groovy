package com.melidata.catalog.test

import com.ml.melidata.Track
import com.ml.melidata.catalog.PropertyType



import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
import org.junit.Test
import static org.junit.Assert.*


/**
 * Created by apetalas on 14/11/14.
 */
public class DslTest {

    @Test void platformsTest() {
        def j = catalog {

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]

            business = [
                    "mercadolibre",
                    "tucarro"
            ]

            tracks {
                "/search"(platform: "/") {
                    limit(description:"amount of search items returned")
                    offset(type: PropertyType.Numeric, values: [1, 2, 3, 4])
                }
                "/search"(platform: "/mobile") {
                    position(values: ["horizonal","landscape"])
                }
                "/search/refine"(platform: "/") {

                }
            }
        }
        Track t =  new Track(path:"/search", event_data: ["limit":50,"offset":1])
        assertTrue(j.validate(t).status)
    }


}
