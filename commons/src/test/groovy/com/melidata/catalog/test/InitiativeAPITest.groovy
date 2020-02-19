package com.melidata.catalog.test

import com.ml.melidata.Track
import com.ml.melidata.catalog.PropertyType
import org.junit.Before
import org.junit.Test
import com.ml.melidata.catalog.initiatives.InitiativeAPI

import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNull

class InitiativeAPITest {

    @Test
    void catalogShouldDefaultOnApplication() {
        InitiativeAPI.getInstance().generateInitiativesList()

        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]



            tracks {
                applicationForPlatform = [
                        "/": "search-frontend"
                ]

                "/search"(platform: "/") {
                    limit(description:"amount of search items returned")
                    offset(type: PropertyType.Numeric, regex:".*")
                }
            }
        }

        Track t =  new Track(path:"/search", event_data: ["limit":50, "offset":1])

        assertEquals("1171", j.getTrackInitiativeWithFallBack(t))
    }

    @Test
    void catalogLoadInitiativesOnInit() {
        InitiativeAPI.getInstance().init()

        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]



            tracks {
                applicationForPlatform = [
                        "/": "search-frontend"
                ]

                "/search"(platform: "/") {
                    limit(description:"amount of search items returned")
                    offset(type: PropertyType.Numeric, regex:".*")
                }
            }
        }

        Track t =  new Track(path:"/search", event_data: ["limit":50, "offset":1])

        assertEquals("1171", j.getTrackInitiativeWithFallBack(t))
    }

    @Test
    void catalogShouldGetInitiativeFromTracks() {
        InitiativeAPI.getInstance().init()

        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]



            tracks {
                initiative = "1171"

                "/search"(platform: "/") {
                    limit(description:"amount of search items returned")
                    offset(type: PropertyType.Numeric, regex:".*")
                }
            }
        }

        Track t =  new Track(path:"/search", event_data: ["limit":50, "offset":1])

        assertEquals("1171", j.getTrackInitiativeWithFallBack(t))
    }

    @Test
    void catalogShouldPriorituzeInitiativeOverApplication() {
        InitiativeAPI.getInstance().init()

        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]



            tracks {
                initiative = "1170"
                applicationForPlatform = [
                        "/": "search-frontend"
                ]

                "/search"(platform: "/") {
                    limit(description:"amount of search items returned")
                    offset(type: PropertyType.Numeric, regex:".*")
                }
            }
        }

        Track t =  new Track(path:"/search", event_data: ["limit":50, "offset":1])

        assertEquals("1170", j.getTrackInitiativeWithFallBack(t))
    }

    @Test
    void catalogReturnsNullWhenNothingDeclared() {
        InitiativeAPI.getInstance().init()

        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]



            tracks {
                "/search"(platform: "/") {
                    limit(description:"amount of search items returned")
                    offset(type: PropertyType.Numeric, regex:".*")
                }
            }
        }

        Track t =  new Track(path:"/search", event_data: ["limit":50, "offset":1])

        assertNull(j.getTrackInitiativeWithFallBack(t))
    }

}
