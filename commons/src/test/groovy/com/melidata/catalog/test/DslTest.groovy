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
                "/search"(platform: "/mobile") {
                    position(values: ["horizonal","landscape"])
                }
                "/search/refine"(platform: "/") {

                }
                "/tucarro"(platform: "/", business: "tucarro") {
                    id()
                }
            }
        }

        Track t =  new Track(path:"/search", event_data: ["limit":50,"offset":1])
        assertTrue(j.validate(t).status)


        Track t2 =  new Track(path:"/tucarro", event_data: ["id":5], business: "tucarro")
        assertTrue(j.validate(t2).status)
    }

    @Test void shouldFailTrackPropertyTypeIncorrect() {

        def catalogo = catalog {

            defaultBusiness = "ml"
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

            defaultBusiness = "ml"

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
        println result.messages
    }

    @Test void shouldFailTrackWithPropertyCatalogedAndNotTracked() {

        def catalogo = catalog {

            defaultBusiness = "ml"

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
            defaultBusiness = "ml"

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

    @Test void includeTest() {

        def catalogo = catalog {

            baseDir = "mocks/"

            platforms = [
                    "/mobile",
                    "/mobile/ios",
            ]

            include "b1", "file1.groovy"
            include "b2", "file2.groovy"
        }

        def result = catalogo.validate(new Track(path:"/search1", event_data: ["category":"MLA234"], business: "b1"))
        assertTrue(result.status)


        result = catalogo.validate(new Track(path:"/search2", event_data: ["category":"MLA234"], business: "b2"))
        assertTrue(result.status)
    }

    @Test void includeReuseTest() {

        def catalogo = catalog {

            baseDir = "mocks/"

            platforms = [
                    "/mobile",
                    "/mobile/ios",
            ]

            include "b1", "file1.groovy"
            include "b2", "file1.groovy"
        }

        def result = catalogo.validate(new Track(path:"/search1", event_data: ["category":"MLA234"], business: "b1"))
        assertTrue(result.status)


        result = catalogo.validate(new Track(path:"/search1", event_data: ["category":"MLA234"], business: "b2"))
        assertTrue(result.status)
    }


    @Test void includeExtendTest() {

        def catalogo = catalog {

            baseDir = "mocks/"

            platforms = [
                    "/mobile",
                    "/mobile/ios",
            ]

            include "b1", "file1.groovy"
            include "b1", "file3.groovy"
        }

        def result = catalogo.validate(new Track(path:"/search1", event_data: ["category":"MLA234", "extra": true], business: "b1"))
        assertTrue(result.status)
    }


    @Test void trackDefinitionsTest() {
        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]

            tracks {

                propertyDefinitions {
                    limit(description:"amount of search items returned")
                    offset(type: PropertyType.Numeric, regex:".*")
                    position(values: ["horizonal","landscape"])
                }

                propertyGroups {
                    searchGroup(limit, offset)
                    searchMobileGroup(position)
                    somePathGroup(limit, offset, position)
                }

                "/search"(platform: "/") {
                    searchGroup
                }
                "/search"(platform: "/mobile") {
                    searchMobileGroup
                }
                "/search/refine"(platform: "/") {

                }

                "/tucarro"(platform: "/", business: "tucarro") {
                    id()
                }

                "/some/path"(platform: "/", business: "tuvieja") {
                    somePathGroup
                }

            }
        }

        Track t =  new Track(path:"/search", event_data: ["limit":50,"offset":1])
        assertTrue(j.validate(t).status)


        Track t2 =  new Track(path:"/tucarro", event_data: ["id":5], business: "tucarro")
        assertTrue(j.validate(t2).status)
    }

    @Test void nestedMapDslTest() {
        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]

            tracks {

                propertyDefinitions {
                    offset(type: PropertyType.Numeric, required: true)
                }

                def item_definition = objectSchemaDefinitions {
                    offset(type: PropertyType.Numeric, required: true)
                    position(type: PropertyType.ArrayList(PropertyType.Numeric), required: true)
                }

                "/search"(platform: "/") {
                    item(type: PropertyType.Map(item_definition), required:true)
                }
                "/search/specific"(platform: "/mobile") {
                    offset(type: PropertyType.Numeric, required: true)
                }
            }
        }

        Track t =  new Track(path:"/search", event_data: [item:[
                offset: 20,
                position: [1,2,3]
        ]])

        Track t2 =  new Track(path:"/search/specific", event_data: [item:[
                offset: 20,
                position: [1,2,3]
        ], offset: 30], platform: "/mobile")


        assertTrue(j.validate(t).status)
        //      Item Map is inherited well via path and platform
        assertTrue(j.validate(t2).status)
    }

    @Test void nestedMapDslAndPropertyDefinitionsIntegrationTest() {
        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]

            tracks {

                propertyDefinitions {
                    offset(type: PropertyType.Numeric, required: true)
                }

                propertyGroups {
                    offsetGroup(offset)
                }

                def item_definition = objectSchemaDefinitions {
                    offsetGroup
                    position(type: PropertyType.ArrayList(PropertyType.Numeric), required: true)
                }

                "/search"(platform: "/") {
                    item(type: PropertyType.Map(item_definition), required:true)
                }
                "/search/specific"(platform: "/mobile") {
                    offsetGroup
                }
            }
        }

        Track t =  new Track(path:"/search", event_data: [item:[
                offset: 20,
                position: [1,2,3]
        ]])

        Track t2 =  new Track(path:"/search/specific", event_data: [item:[
                offset: 20,
                position: [1,2,3]
        ], offset: 30], platform: "/mobile")


        assertTrue(j.validate(t).status)
        //      Item Map is inherited well via path and platform
        assertTrue(j.validate(t2).status)
    }

    @Test void abPlatformsTest() {
        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]

            abPlatforms = [
                    "/web/desktop",
                    "/web/mobile",
                    "/mobile/android",
                    "/mobile/ios"
            ]

        }

        assertTrue(j.getAbPlatforms() == ["/web/desktop",
                                          "/web/mobile",
                                          "/mobile/android",
                                          "/mobile/ios"])
    }


    @Test void abPlatformsSubscriptionsTest() {
        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]

            abPlatformsSubscriptions = [
                    "/web/desktop",
                    "/web/mobile",
                    "/mobile/android",
                    "/mobile/ios"
            ]

        }

        assertTrue(j.getAbPlatformsSubscriptions() == ["/web/desktop",
                                          "/web/mobile",
                                          "/mobile/android",
                                          "/mobile/ios"])
    }



}
