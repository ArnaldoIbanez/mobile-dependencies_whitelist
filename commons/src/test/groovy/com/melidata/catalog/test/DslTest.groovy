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

    @Test void tryingToSolvePDPProblems() {
        def j = catalog {

            defaultBusiness = "mercadolibre"

            platforms = [
                    "/web",
                    "/web/desktop"
            ]

            tracks {

                def product_picker_definition = objectSchemaDefinitions {
                    catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
                    selected(required: true, type: PropertyType.Boolean, description: "indicates if the product picker is selected or not")
                    disabled(required: true, type: PropertyType.Boolean, description: "indicates if the product picker is disabled or not")
                }
                def item_info_definition = objectSchemaDefinitions {
                    item_id(required: true, type: PropertyType.String, description: "")
                    price(required: false, type: PropertyType.Numeric, description: "")
                    original_price(required: false, type: PropertyType.Numeric, description: "")
                    currency_id(required: false, type: PropertyType.String, description: "")
                    installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")
                    item_condition(required: false, type: PropertyType.String, description: "")
                    sold_quantity(required: false, type: PropertyType.Numeric, description: "")
                    shipping_conditions(required: true, type: PropertyType.String, values: ["no_shipping", "free_mandatory", "free_loyal", "discount_mandatory", "discount_loyal", "free_special", "discount_special", "free_ratio", "discount_ratio", "free_gap", "discount_gap", "free_other", "discount_other", "no_discount"],
                            description: "Shipping conditions for product")

                    //BRACH_OFFICE CONDITIONS
                    bo_pick_up_conditions(required: true, type: PropertyType.String, values: ["no_bo_pick_up", "free_mandatory", "free_loyal", "discount_mandatory", "discount_loyal", "free_special", "discount_special", "free_ratio", "discount_ratio", "free_gap", "discount_gap", "free_other", "discount_other", "no_discount"],
                            description: "Branch office pick up conditions for product")

                    //PUIS
                    showing_puis(required: false, type: PropertyType.Boolean, description: "Indicates if PDP BBW is showing PUIS pickup option in pickup row")
                    pushing_puis(required: false, type: PropertyType.Boolean, description: "Indicates PUIS is being pushed over branch office pickup option")
                    official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
                    seller_id(required: false, type: PropertyType.Numeric, description: "")
                    seller_name(required: false, type: PropertyType.String, description: "")
                    available_quantity(required: false, type: PropertyType.Numeric, description: "Available product quantity at this pdp")
                    cart_content(required: false, type: PropertyType.Boolean, description: "")
                    has_full_filment(required: false, type: PropertyType.Boolean, description: "")
                    logistic_type(required: false,
                            values: ["not_specified", "default", "drop_off", "xd_drop_off", "custom", "cross_docking", "fulfillment"],
                            type: PropertyType.String, description: "Indicates the logistic type of the item")

                }

                "/pdp"(platform: "/") {

                    //Product fields
                    catalog_product_id(required: true, type: PropertyType.String, description: "Catalog Product ID")
                    catalog_parent_id(required: false, type: PropertyType.String, description: "Parent Catalog Product ID")
                    item_id(required: true, type: PropertyType.String, description: "Item ID")
                    domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
                    //TODO: set to required true when it is fixed in products api
                    category_id(required: false, type: PropertyType.String, description: "Item's category id")
                    previous_catalog_product_id(required: false, type: PropertyType.String, description: "Previous Catalog Product ID")

                    //picker definition
                    pickers(required: true, type: PropertyType.Map(PropertyType.String, PropertyType.ArrayList(PropertyType.Map(product_picker_definition))), description: "Available pickers for the given product")

                    category_path(required: false, type: PropertyType.ArrayList, description: "Category path of the the item")
                    vertical(required: true, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
                    item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                            description: "Whether the item is new, used or refurbished")
                    listing_type_id(required: true, type: PropertyType.String,
                            values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                            description: "Listing type of the item")

                    // ONLY CORE FIELDS
                    quantity(required: false, type: PropertyType.Numeric, description: "Available product quantity at this pdp")
                    available_quantity(required: false, type: PropertyType.Numeric, description: "Available product quantity at this pdp")

                    price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
                    original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
                    currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")

                    review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")

                    // CART
                    add_cart_info

                    //SELLER FIELDS
                    seller_id(required: true, type: PropertyType.Numeric)
                    seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
                    power_seller_status(required: false, type: PropertyType.String, values: ["silver", "gold", "platinum"],
                            description: "Seller's Mercado Lider level")
                    reputation_level(required: false, type: PropertyType.String,
                            values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"],
                            description: "Seller's reputation level")

                    // OFFICIAL_STORES
                    official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
                    store_type(required: false, type: PropertyType.String, values: ["normal", "brand"], description: "Indicates store type")

                    // PAYMENT
                    installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")

                    // SHIPPING
                    shipping_info

                    // PICKUP
                    pickup_info

                    // USER FIELD
                    loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")
                }

                "/pdp/sellers"(platform: "/", parentPropertiesInherited: false) {
                    catalog_parent_id(required: true, type: PropertyType.String, description: "Product ID")
                    catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
                    vertical(required: true, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
                    domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
                    review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")
                    loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")
                    pickers(required: true, type: PropertyType.Map(PropertyType.String, PropertyType.ArrayList(PropertyType.Map(product_picker_definition))), description: "Available pickers for the given product")
                    items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_info_definition)), description: "Items listed on the page")
                }
            }
        }

        Track t2 =  new Track(path:"/pdp/sellers", event_data: [
                catalog_parent_id: "MLA11137440",
                catalog_product_id: "MLA11137441",
                vertical: "core",
                domain_id: "MLA-CELLPHONES",
                review_rate: 4,
                loyalty_level: 2,
                pickers: [
                        "INTERNAL_MEMORY" : [
                                [
                                        catalog_product_id: "MLA11137441",
                                        selected          : true,
                                        disabled          : false
                                ],
                                [
                                        catalog_product_id: "MLA11137444",
                                        selected          : false,
                                        disabled          : false
                                ]
                        ],
                        "COLOR": [
                                [
                                        catalog_product_id: "MLA11137443",
                                        selected          : false,
                                        disabled          : false
                                ],
                                [
                                        catalog_product_id: "MLA11137442",
                                        selected          : false,
                                        disabled          : true
                                ],
                                [
                                        catalog_product_id: "MLA11137441",
                                        selected          : true,
                                        disabled          : false
                                ]
                        ],
                        "IS_DUAL_SIM": [
                                [
                                        catalog_product_id: "MLA11137441",
                                        selected          : true,
                                        disabled          : false
                                ],
                                [
                                        catalog_product_id: "MLA11137431",
                                        selected          : false,
                                        disabled          : false
                                ]
                        ]
                ],
                items: [
                        [
                                item_id: "MLA789183405",
                                price: 17622.5,
                                original_price: 18550,
                                currency_id: "ARS",
                                installment_info: "6f",
                                item_condition: "new",
                                sold_quantity: 0,
                                shipping_conditions: "free_loyal",
                                pushing_puis: false,
                                showing_puis: false,
                                bo_pick_up_conditions: "no_bo_pick_up",
                                seller_id: 31077387,
                                seller_name: "SETECH-OFERTAS",
                                cart_content: true,
                                has_full_filment: true
                        ],


                ]
        ], platform: "/web/desktop")


        def result = j.validate(t2)
        print(result.messages)
        assertTrue(result.status)
    }

    /**
     *
     * TESTING APPLICATOIN HIERARCHY
     *
     */

    @Test void shouldDefineDefaultApplicationForPlatform() {

        def catalogo = catalog {

            defaultBusiness = "ml"

            platforms = [
                    "/web",
                    "/mobile",
                    "/mobile/ios",
                    "/mobile/android"
            ]


            tracks {
                applicationForPlatform = [
                        "/mobile/android": "search_android",
                        "/mobile/ios": "search_ios",
                        "/web": "search_infraestructure",
                        "/": "search_backend"
                ]

                "/search"(platform: "/") {}
            }
        }

        def applicationRoot = catalogo.getTrackApplication(new Track(path:"/search", business: "ml", platform: "/"))
        def applicationWeb = catalogo.getTrackApplication(new Track(path:"/search", business: "ml", platform: "/web"))
        def applicationMobile = catalogo.getTrackApplication(new Track(path:"/search", business: "ml", platform: "/mobile"))
        def applicationIOS = catalogo.getTrackApplication(new Track(path:"/search", business: "ml", platform: "/mobile/ios"))
        def applicationAndroid = catalogo.getTrackApplication(new Track(path:"/search", business: "ml", platform: "/mobile/android"))

        assertEquals("search_backend", applicationRoot)
        assertEquals("search_infraestructure", applicationWeb)
        assertEquals("search_backend", applicationMobile)
        assertEquals("search_ios", applicationIOS)
        assertEquals("search_android", applicationAndroid)

    }

    @Test void shouldDefineApplicationForAllTracksInHierarchy() {

        def catalogo = catalog {

            defaultBusiness = "ml"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]


            tracks {
                applicationForPlatform = ["/": "search_backend"]

                "/search"(platform: "/") {}

                "/search/description"(platform: "/") {}

                "/search/refined"(platform: "/mobile") {}

                "/search/refined/details"(platform: "/mobile/ios") {}
            }
        }

        def applicationRoot = catalogo.getTrackApplication(new Track(path:"/search", business: "ml", platform: "/mobile/ios"))
        def applicationPath = catalogo.getTrackApplication(new Track(path:"/search/description", business: "ml", platform: "/mobile/ios"))
        def applicationPlatform = catalogo.getTrackApplication(new Track(path:"/search/refined", business: "ml", platform: "/mobile/ios"))
        def applicationPlatformSpecific = catalogo.getTrackApplication(new Track(path:"/search/refined/details", business: "ml", platform: "/mobile/ios"))

        assertEquals("search_backend", applicationRoot)
        assertEquals("search_backend", applicationPath)
        assertEquals("search_backend", applicationPlatform)
        assertEquals("search_backend", applicationPlatformSpecific)
    }

    @Test void shouldOverrideApplication() {

        def catalogo = catalog {

            defaultBusiness = "ml"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]


            tracks {
                applicationForPlatform = ["/": "search_backend"]

                "/search"(platform: "/") {}

                "/search/description"(platform: "/") {}

                "/search/refined"(platform: "/mobile", application: "search_native") {}

                "/search/refined/details"(platform: "/mobile") {}
            }
        }

        def applicationRoot = catalogo.getTrackApplication(new Track(path:"/search", business: "ml", platform: "/mobile/ios"))
        def applicationPath = catalogo.getTrackApplication(new Track(path:"/search/description", business: "ml", platform: "/mobile/ios"))
        def applicationPlatform = catalogo.getTrackApplication(new Track(path:"/search/refined", business: "ml", platform: "/mobile"))
        def applicationPlatformInherited = catalogo.getTrackApplication(new Track(path:"/search/refined", business: "ml", platform: "/mobile/ios"))
        def applicationPathInherited = catalogo.getTrackApplication(new Track(path:"/search/refined/details", business: "ml", platform: "/mobile"))
        def applicationPathPlatformInherited = catalogo.getTrackApplication(new Track(path:"/search/refined/details", business: "ml", platform: "/mobile/ios"))

        assertEquals("search_backend", applicationRoot)
        assertEquals("search_backend", applicationPath)
        assertEquals("search_native", applicationPlatform)
        assertEquals("search_native", applicationPlatformInherited)
        assertEquals("search_native", applicationPathInherited)
        assertEquals("search_native", applicationPathPlatformInherited)
    }

    @Test void shouldTakeClosestParentApplicationRedefinition() {

        def catalogo = catalog {

            defaultBusiness = "ml"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]


            tracks {
                applicationForPlatform = ["/": "search_backend"]

                "/search"(platform: "/", application: "search_infraestructure") {}

                "/search/refined"(platform: "/") {}

                "/search/refined"(platform: "/mobile", application: "search_native") {}

                "/search/refined/details"(platform: "/") {}

                "/search/refined/details"(platform: "/mobile") {}
            }
        }

        def applicationRoot = catalogo.getTrackApplication(new Track(path:"/search", business: "ml", platform: "/mobile/ios"))
        def applicationDefaultRefined = catalogo.getTrackApplication(new Track(path:"/search/refined", business: "ml", platform: "/"))
        def applicationDoubleRefined = catalogo.getTrackApplication(new Track(path:"/search/refined", business: "ml", platform: "/mobile"))
        def applicationDefaultTree = catalogo.getTrackApplication(new Track(path:"/search/refined/details", business: "ml", platform: "/"))
        def applicationDoubleDefineTree = catalogo.getTrackApplication(new Track(path:"/search/refined/details", business: "ml", platform: "/mobile/ios"))

        assertEquals("search_infraestructure", applicationRoot)
        assertEquals("search_infraestructure", applicationDefaultRefined)
        assertEquals("search_native", applicationDoubleRefined)
        assertEquals("search_infraestructure", applicationDefaultTree)
        assertEquals("search_native", applicationDoubleDefineTree)
    }

    @Test void shouldDeclareApplicationForWholePlatform() {

        def catalogo = catalog {

            defaultBusiness = "ml"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]


            tracks {
                applicationForPlatform = [
                        "/mobile/android": "search_android",
                        "/mobile/ios": "search_ios",
                        "/web": "search_infraestructure",
                        "/": "search_backend"
                ]

                "/search"(platform: "/") {}

                "/search/refined"(platform: "/") {}

                "/search/refined"(platform: "/mobile", application: "search_native") {}

                "/search/refined/details"(platform: "/") {}

                "/search/refined/details"(platform: "/mobile") {}
            }
        }

        def applicationRoot = catalogo.getTrackApplication(new Track(path:"/search", business: "ml", platform: "/mobile/ios"))
        def applicationDefaultRefined = catalogo.getTrackApplication(new Track(path:"/search/refined", business: "ml", platform: "/"))
        def applicationDoubleRefined = catalogo.getTrackApplication(new Track(path:"/search/refined", business: "ml", platform: "/mobile"))
        def applicationDefaultTree = catalogo.getTrackApplication(new Track(path:"/search/refined/details", business: "ml", platform: "/"))
        def applicationDoubleDefineTree = catalogo.getTrackApplication(new Track(path:"/search/refined/details", business: "ml", platform: "/mobile/ios"))

        assertEquals("search_ios", applicationRoot)
        assertEquals("search_backend", applicationDefaultRefined)
        assertEquals("search_native", applicationDoubleRefined)
        assertEquals("search_backend", applicationDefaultTree)
        assertEquals("search_native", applicationDoubleDefineTree)
    }

    /**
     *
     * TESTING INITIATIVE HIERARCHY
     *
     */

    @Test void shouldDeclareInitiativeForWholeFile() {

        def catalogo = catalog {

            defaultBusiness = "ml"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]


            tracks {
                initiative = "search"

                "/search"(platform: "/") {}

                "/search/refined"(platform: "/") {}

                "/search/refined"(platform: "/mobile") {}

                "/search/refined/details"(platform: "/") {}

                "/search/refined/details"(platform: "/mobile") {}
            }
        }

        def initiativeRoot = catalogo.getTrackInitiative(new Track(path:"/search", business: "ml", platform: "/mobile/ios"))
        def initiativeDefaultRefined = catalogo.getTrackInitiative(new Track(path:"/search/refined", business: "ml", platform: "/"))
        def initiativeDoubleRefined = catalogo.getTrackInitiative(new Track(path:"/search/refined", business: "ml", platform: "/mobile"))
        def initiativeDefaultTree = catalogo.getTrackInitiative(new Track(path:"/search/refined/details", business: "ml", platform: "/"))
        def initiativeDoubleDefineTree = catalogo.getTrackInitiative(new Track(path:"/search/refined/details", business: "ml", platform: "/mobile/ios"))

        assertEquals("search", initiativeRoot)
        assertEquals("search", initiativeDefaultRefined)
        assertEquals("search", initiativeDoubleRefined)
        assertEquals("search", initiativeDefaultTree)
        assertEquals("search", initiativeDoubleDefineTree)
    }

    @Test void shouldDeclareInitiativeForInheritance() {

        def catalogo = catalog {

            defaultBusiness = "ml"

            platforms = [
                    "/mobile",
                    "/mobile/ios"
            ]


            tracks {
                initiative = "search"

                "/search"(platform: "/") {}

                "/search/refined"(platform: "/") {}

                "/search/refined"(platform: "/mobile", initiative: "qadb") {}

                "/search/refined/details"(platform: "/") {}

                "/search/refined/details"(platform: "/mobile") {}
            }
        }

        def initiativeRoot = catalogo.getTrackInitiative(new Track(path:"/search", business: "ml", platform: "/mobile/ios"))
        def initiativeDefaultRefined = catalogo.getTrackInitiative(new Track(path:"/search/refined", business: "ml", platform: "/"))
        def initiativeDoubleRefined = catalogo.getTrackInitiative(new Track(path:"/search/refined", business: "ml", platform: "/mobile"))
        def initiativeDefaultTree = catalogo.getTrackInitiative(new Track(path:"/search/refined/details", business: "ml", platform: "/"))
        def initiativeDoubleDefineTree = catalogo.getTrackInitiative(new Track(path:"/search/refined/details", business: "ml", platform: "/mobile/ios"))

        assertEquals("search", initiativeRoot)
        assertEquals("search", initiativeDefaultRefined)
        assertEquals("qadb", initiativeDoubleRefined)
        assertEquals("search", initiativeDefaultTree)
        assertEquals("qadb", initiativeDoubleDefineTree)
    }
}
