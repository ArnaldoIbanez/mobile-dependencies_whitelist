package com.melidata.catalog.test

import com.ml.melidata.catalog.CategoryValidator
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.Track

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
                    "/pepito"
            ]

            business = [
                    "mercadolibre",
                    "tucarro"
            ]

            tracks {
                "/search"(platform: "/") {
                    limit(description:"amount of search items returned")
                    offset(type: PropertyType.Numeric, values: [1, 2, 3, 4], validators:[new CategoryValidator()])
                }
            }
        }
        Track t =  new Track(path:"/search", properties: ["limit":50,"offset":0])

        def result = j.validate(t)
        assertNotNull(result)
        assertFalse(result.status)
    }

    @Test void shouldCreateATrackFromTrackDSL(){






        assertNotNull(tracksCreated)
        assertEquals(tracksCreated.size(), 2)
        assertEquals(tracksCreated[0].path, "/search")
        assertEquals(tracksCreated[1].path, "/search/active")

    }
}
