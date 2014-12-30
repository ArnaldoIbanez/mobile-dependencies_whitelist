package com.melidata.catalog.test
import com.ml.melidata.Track
import com.ml.melidata.catalog.CategoryValidator
import com.ml.melidata.catalog.PropertyType
import org.junit.Before

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
                    offset(type: PropertyType.Numeric, regex:".*")
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

    @Test void shouldFailTrackPropertyTypeIncorrect() {

        def catalogo = catalog {
            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]

            tracks {
                "/search"(platform: "/") {
                    limit(description: "amount of search items returned")
                    offset(type: PropertyType.Numeric, regex: ".*")
                }
            }
        }

        def result = catalogo.validate(new Track(path:"/search", event_data: ["limit":50,"offset":"1"]))
        assertFalse(result.status)
    }

    @Test void shouldFailTrackRegexValidateIncorrect() {

        def catalogo = catalog {
            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]

            tracks {
                "/search"(platform: "/") {
                    limit(description: "amount of search items returned")
                    category(regex: /[a-zA-Z]{1,3}[0-9]+/)
                }
            }
        }

        def result = catalogo.validate(new Track(path:"/search", event_data: ["category":"MLA323"]))

        assertFalse(result.status)
        println result.menssages
    }

    @Test void shouldFailTrackWithPropertyCatalogedAndNotTracked() {

        def catalogo = catalog {
            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]

            tracks {
                "/search"(platform: "/") {
                    limit(description: "amount of search items returned")
                    category(regex: "/[a-zA-Z]{1,3}[0-9]+/")
                }
            }
        }

        def result = catalogo.validate(new Track(path:"/search", event_data: ["category":"MLA234"]))
        assertFalse(result.status)
    }

    @Test void shouldValidateTrackPropertyNotCataloged() {

        def catalogo = catalog {
            platforms = [
                    "/mobile",
                    "/mobile/ios",
            ]

            tracks {
                "/search"(platform: "/mobile") {

                }
            }
        }

        def result = catalogo.validate(new Track(path:"/search", event_data: ["category":"MLA234"]))
        assertFalse(result.status)
    }



}
