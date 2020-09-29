package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    def pdpInfo = [
            [id: "MLA1", score: 0.2441, status: "grouped"],
            [id: "MLA2", score: 0.2441, status: "shown"]
    ]

    def sparkleInfo = [
            intervention_id  : "1",
            intervention_type: "REDIRECT",
            config_value     : "on",
            url              : "http://example.com"
    ]

    def bestSellerInfo = [
            candidates   : 10,
            selected     : [ "MLA1234" ],
            selected_qty : 1,
            selected_positions : [ 1, 3, 5 ]
    ]

    def tagTrackingInfo = [
        best_seller : [
                [item_id: "MLC510446223", position: 2],
                [item_id: "MLC510446224", position: 3, product_id:"MLC510446224"],
        ],
        shipping_guaranteed : [],
        deal_of_the_day : []
    ]

    def promiseInfo = [
            sameday: ["MLA123411"],
            nextday: ["MLA12345645"]
    ]


    test("Search core tracking") {

        def defaultSearchInformation = {
            total = 5876
            limit = 20
            query = "iphone"
            category_path = ["MLA1051", "MLA1055", "MLA32089"]
            category_id = "MLA32089"
            filters = []
            pads = []
            tracking_id = "dd1ec405-0a55-4b55-aaa5-de29cc3ab5fb"
            pads_info = {
                ids = []
                printed_positions = []
                printed_positions_size = 0
            }
            billboards = []
            offset = 0
            sort_id = "relevance"
            view_mode = "MOSAIC"
            results = ["232232000", "232232001", "232232002"]
            backend_data = {
                sm = "sm"
                ab = "1"
                aa = ["a1", "a2"]
                ac = ["ac1", "ac2"]
                ap = ["ap1", "ap2"]
                fsm = "fsm"
                ab_bucket = "AB1"
                layout = "stack"
                qas = ["232232000", "232232001", "232232002"]
                cli_rel_qty_configured = "12"
                canonical = "http://home.mercadolibre.com.ar/telefonia/"
                cli_rel_qty_link_to_category = "MLA123"
            }
            catalog_product_id = "MLA123"
            show_supermarket_carousel = true
            show_apparel_carousel = false
            items_with_logos = ["MLA1234", "MLA12345"]
            promise_items = promiseInfo
            pdp_grouped_search = true
            pdp_info = pdpInfo
            promoted_items = ["MLA1", "MLA2"]
            location_info = [
                    "zipcode": "1430",
                    "default_zipcode": false,
                    "city_id": "SP-BR",
                    "user_zone": "X1"
            ]
        }

        def defaultWebTrack = {
            total = 0
            sort_id = "relevance"
            view_mode = "MOSAIC"
            filters = { seller_id = "47316577" }
            available_filters = [{ shipping_time_sameday: "250" }]
            only_in_type = "Seller"
            limit = 20
            offset = 0
            official_stores_carousel_shown = ["224", "234", "255"]
            click_banner = {
                exhibitors_id = '12'
            }
            banner = {
                deal_id = '12'
                exhibitors_id = '12'
            }
            click_banner = {
                exhibitors_id = '12'
            }
            related_searches = {
                query = 'ipod'
                position = 1
                quantity = 2
                related_by_category = false
            }
            related_searches_info = {
                quantity = 2
                related_queries = ['ipod', 'ipod nano']
            }
            canonical = {
                url = "https://listado.mercadolibre.com.ar/zapatillas"
                no_follow_tag = true
                mirror_category_canonical = true
            }

            autosuggest = {
                suggest_position = 3
            }
            autosuggest = {
                last_search_position = 1
            }
            autosuggest = {
                block_store_position = 19
            }
            results = ["232232000", "232232001", "232232002"]
            billboards = ["232232000"]
            geolocation = "AR:CABA"

            layout_forced = true
            pads = []
            pads_info = {
                ids = []
                printed_positions = []
                printed_positions_size = 0
            }
            user_zone = ""
            pdp_rows = [
                    [
                            product_id: "MLA123",
                            item_id   : "MLA1234"
                    ]
            ]
            carousel_filters = []
            seo = [
                    is_whitelisted         : true,
                    check_mode             : "GMV",
                    value                  : 15,
                    is_default             : false,
                    is_on_seo_h1_experiment: true
            ]
            pdp_highlight_enabled = true
            pdp_grouped_search = true
            pdp_info = pdpInfo
            promoted_items = ["MLA1", "MLA2"]
            user_profile_type = "BUYER"
            sparkle_info = sparkleInfo
            best_seller_info = bestSellerInfo
            tag_tracking_info = tagTrackingInfo
            location_info = [
                    "zipcode": "1430",
                    "default_zipcode": false,
                    "city_id": "SP-BR",
                    "user_zone": "X1"
            ]
        }

        def category_definition = {
            [
                    carousel_id: "category",
                    selected   : [
                            name       : "Hogar, Muebles y Jardin",
                            selected_id: "MLA1574"
                    ]
            ]
        }

        def action_definition = {
            action_id: "show_all"
            filter_id: "BRAND"
        }

        "/search"(platform: "/web") {
            defaultWebTrack()
            landing = "base"
        }

        "/search"(platform: "/web") {
            defaultWebTrack()
            sort_id="publication_begins_desc"
        }

        "/search"(platform: "/web"){
            defaultWebTrack()
            sort_id="publication_begins_asc"
        }

        "/search"(platform: "/web"){
            defaultWebTrack()
            sort_id="manually_selected"
        }

        "/search"(platform: "/web"){
            defaultWebTrack()
            landing="official_store"
        }

        "/search"(platform: "/web", {
            total = 0
            sort_id = "relevance"
            view_mode = "MOSAIC"
            filters = { seller_id = "47316577" }
            available_filters = []
            only_in_type = "Seller"
            limit = 20
            offset = 0
            official_stores_carousel_shown = ["224", "234", "255"]
            click_banner = {
                exhibitors_id = '12'
            }
            banner = {
                deal_id = '12'
                exhibitors_id = '12'
            }
            click_banner = {
                exhibitors_id = '12'
            }
            related_searches = {
                query = 'ipod'
                position = 1
                quantity = 2
                related_by_category = false
            }
            related_searches_info = {
                quantity = 2
                related_queries = ['ipod', 'ipod nano']
            }
            canonical = {
                url = "https://listado.mercadolibre.com.ar/zapatillas"
                no_follow_tag = true
                mirror_category_canonical = true
            }

            autosuggest = {
                suggest_position = 3
            }
            autosuggest = {
                last_search_position = 1
            }
            autosuggest = {
                block_store_position = 19
            }
            results = ["232232000", "232232001", "232232002"]
            billboards = ["232232000"]
            geolocation = "AR:CABA"
            landing = "cpg"
            layout_forced = true
            pads = []
            pads_info = {
                ids = []
                printed_positions = []
                printed_positions_size = 0
            }
            geo_search = false
            user_zone = ""
            is_googlebot = true
            pdp_rows = [
                    [
                            product_id: "MLA123",
                            item_id   : "MLA1234"
                    ]
            ]
            carousel_filters = ["BRAND", "official_store", "STYLE"]
            seo = [
                    is_whitelisted         : true,
                    check_mode             : "GMV",
                    value                  : 15,
                    is_default             : false,
                    is_on_seo_h1_experiment: true
            ]
            pdp_highlight_enabled = true
            pdp_grouped_search = true
            pdp_info = pdpInfo
            promoted_items = ["MLA1", "MLA2"]
            user_profile_type = "BUYER"
            sparkle_info = sparkleInfo
            best_seller_info = bestSellerInfo
            tag_tracking_info = tagTrackingInfo
            location_info = [
                    "zipcode": "1430",
                    "default_zipcode": false,
                    "city_id": "SP-BR",
                    "user_zone": "X1"
            ]
            top_keywords = [
                    [
                            "key": "sarasa",
                            "type" : "SEARCH"
                    ],
                    [
                            "key": "sarasa2",
                            "type" : "PDP"
                    ]
            ]
            review_pages = ["ventilador", "nintendo"]
        })

        "/search"(platform: "/mobile", defaultSearchInformation)

        "/search"(platform: "/mobile", {
            total = 258
            limit = 0
            view_mode = "MOSAIC"
            results = []
            billboards = []
            category_path = []
            offset = 50.0
            sort_id = "relevance"
            filters = { official_store = "140" }
            autoselected_filters = ["official_store"]
            geo_search = "false"
            filter_tags = "locationFromHistory"
            pads = []
            pads_info = {
                ids = []
                printed_positions = []
                printed_positions_size = 0
            }
            carousel_filters = ["BRAND", "official_store", "STYLE"]
            pdp_grouped_search = true
            pdp_info = pdpInfo
            promoted_items = ["MLA1", "MLA2"]
            carousel_categories_shown = true
            location_info = [
                    "zipcode": "1430",
                    "default_zipcode": false,
                    "city_id": "SP-BR",
                    "user_zone": "X1"
            ]
        })

        "/search/color_picker"(platform: "/web") {
            defaultWebTrack()
            item_id = "MLM1234"
            previous_product_id = "MLA101021"
            product_id = "MLA101022"
        }

        "/search/input"(platform: "/mobile") {}

        "/search/input/back"(platform: "/mobile") {}

        "/search/failure"(platform: "/mobile") {
            defaultSearchInformation()
            error_message = "No connection error"
        }

        "/search/filters"(platform: "/mobile", defaultSearchInformation)

        "/search/filters/action"(platform: "/mobile") {
            multiple_values_qty = 3
            action = action_definition()
        }

        "/search/filters_carousel/click"(platform: "/web", type: TrackType.Event) {
            defaultWebTrack()
            filter_name = "shoes"
            filter = "STYLE"
            position = 4
        }

        "/search/category_carousel"(platform: "/mobile", type: TrackType.Event) {
            carousels = category_definition()
        }

        "/search/breadcrumb/open"(platform: "/mobile", type: TrackType.Event) {
            defaultSearchInformation()
        }
        "/search/breadcrumb/apply"(platform: "/mobile", type: TrackType.Event) {
            defaultSearchInformation()
            filter_id = "9997262-AMLA_7262_2"
        }

        "/search/back"(platform: "/mobile", defaultSearchInformation)
        "/search/long_press"(platform: "/mobile") {
            item_id = "MLA170232"
        }
        "/search/share"(platform: "/mobile") {
            item_id = "MLA170232"
        }
        "/search/abort"(platform: "/mobile", defaultSearchInformation)
        "/search/refine"(platform: "/mobile", defaultSearchInformation)
        "/search/refine/apply"(platform: "/mobile", defaultSearchInformation)
        "/search/refine/back"(platform: "/mobile", defaultSearchInformation)
        "/search/refine/select_filter"(platform: "/mobile") {
            defaultSearchInformation()
            filter_id = "9997262-AMLA_7262_2"
        }
        "/search/refine/select_filter/apply"(platform: "/mobile") {
            defaultSearchInformation()
            filter_id = "9997262-AMLA_7262_2"
            filter_value_id = "9997262-AMLA_7262_1-MMLA6838"
            filter_value_name = "IPod touch"
        }
        "/search/change_view"(platform: "/mobile", defaultSearchInformation)
        "/search/change_view/apply"(platform: "/mobile", type: TrackType.Event) {
            defaultSearchInformation()
            list_mode = "mosaic"
        }
        "/search/change_view/apply"(platform: "/web", type: TrackType.Event) {
            defaultWebTrack()
            list_mode = "mosaic"
            available_filters = [{ shipping_time_sameday: "250" }]
            user_zone = ""
        }
        "/search/promoted_items"(platform: "/web") {
            defaultWebTrack()
            available_filters = []
            user_zone = ""
        }
        "/search/promoted_items/show"(platform: "/web") {
            defaultWebTrack()
            item_type = "projects"
            available_filters = []
            user_zone = ""
        }
        "/search/billboard"(platform: "/") {
            defaultSearchInformation()
            position_shown = 1
            move = "forward"
            is_new_billboard = true
            item_id = "MLC462810643"
        }
        "/search/billboard/resize"(platform: "/web") {
            defaultWebTrack()
            action = "expand"
            available_filters = []
            user_zone = ""
        }
        "/search/billboard/click"(platform: "/") {
            defaultSearchInformation()
            position = 2
            is_new_billboard = true
            item_id = "MLC462810643"
        }
        "/search/save"(platform: "/") {
            defaultSearchInformation()
        }
        "/search/alert_intention"(platform: "/") {
            defaultSearchInformation()
        }
        "/search/official_stores_carousel"(platform: "/") {
            defaultSearchInformation()
        }
        "/search/official_stores_carousel/click"(platform: "/") {
            defaultSearchInformation()
            to_name = "adidas"
            to_position = 2
        }
        "/search/banner"(platform: "/web", defaultWebTrack)
        "/search/banner/click"(platform: "/web", type: TrackType.Event) {
            defaultWebTrack()
        }
    }

    test("Search gallery with 10 items, first page") {
        "/search"(platform: "/mobile") {
            limit = 10
            offset = 0
            total = 0
            sort_id = "relevance"
            filters = []
            pads = []
            pads_info = {
                ids = []
                printed_positions = []
                printed_positions_size = 0
            }
            view_mode = "LIST"
            results = []
            billboards = []
            category_id = "MLA32089"
            query = "iphone"
            pdp_grouped_search = true
            pdp_info = pdpInfo
            promoted_items = ["MLA1", "MLA2"]
            location_info = [
                    "zipcode": "1430",
                    "default_zipcode": false,
                    "city_id": "SP-BR",
                    "user_zone": "X1"
            ]
        }
    }

    test("Search category_id ROOT") {
        "/search"(platform: "/mobile") {
            limit = 10
            offset = 0
            total = 0
            sort_id = "relevance"
            filters = []
            pads = []
            pads_info = {
                ids = []
                printed_positions = []
                printed_positions_size = 0
            }
            view_mode = "LIST"
            results = []
            billboards = []
            category_id = "ROOT"
            query = "iphone"
            pdp_grouped_search = true
            pdp_info = pdpInfo
            promoted_items = ["MLA1", "MLA2"]
            location_info = [
                    "zipcode": "1430",
                    "default_zipcode": false,
                    "city_id": "SP-BR",
                    "user_zone": "X1"
            ]
        }
    }

    test("Search carousel next") {
        "/search/carousel"(platform: "/web") {
            carousel_used = "next"
        }
    }

    test("Search go local") {
        "/search/golocal"(platform: "/web") {
            limit = 10
            offset = 0
            total = 0
            sort_id = "relevance"
            filters = []
            available_filters = []
            pads = []
            pads_info = {
                ids = []
                printed_positions = []
                printed_positions_size = 0
            }
            view_mode = "LIST"
            results = []
            billboards = []
            category_id = "MLA32089"
            query = "iphone"
            user_zone = ""
            pdp_rows = []
            carousel_filters = []
            seo = [
                    is_whitelisted         : true,
                    check_mode             : "GMV",
                    value                  : 15,
                    is_default             : false,
                    is_on_seo_h1_experiment: true
            ]
            pdp_highlight_enabled = true
            pdp_grouped_search = true
            pdp_info = pdpInfo
            promoted_items = ["MLA1", "MLA2"]
            user_profile_type = "BUYER"
            sparkle_info = sparkleInfo
            location_info = [
                    "zipcode": "1430",
                    "default_zipcode": false,
                    "city_id": "SP-BR",
                    "user_zone": "X1"
            ]
        }
    }

    test("Search Recommendations ") {
        "/search/category_recommendations"(platform: "/web") {
            item_id = "MLM1234"
            category_id = "MLM123456"
            category_path = ["MLM1234", "MLM12345", "MLM123456"]
            recommended_categories = [
                    "MLM4321",
                    "MLM54321"
            ]

        }
    }

    test("Search fintie navigation experiment") {
        "/search/finite_navigation"(platform: "/mobile/android") {
        }
        "/search/finite_navigation_os_filter"(platform: "/mobile/android") {
        }
    }

    test("Search Sparkle Custom Track ") {
        "/search/sparkle"(platform: "/") {
            query = "this is a query"
            sparkle_info = sparkleInfo

        }
    }

    test("Search Advertising banners") {
        "/search/advertising"(platform: "/", type: TrackType.Event) {
            advertising_id = "sky"
        }
    }

}
