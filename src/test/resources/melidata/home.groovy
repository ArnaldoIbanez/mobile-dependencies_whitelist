package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Home Tracking") {
        "/home"(platform: "/web") {
            from="breadcrumb"
        }
    }

     test("Home Navigation") {
        "/home/navigation"(platform: "/", type: TrackType.View) {}
        "/home/navigation_history/admin"(platform: "/", type: TrackType.View) {}
    }

    test("Home Portal Inmobiliario") {
        def dataSet = {
            category_id = 'MLC1459'
            category_path = ['MLC1459']
        }

        "/home/category/real_estate"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/bookmarks"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/bookmarks/recommendation"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/help"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/tyc"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/about"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/pricing"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/pricing/fsbo"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/pricing/professional"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/pricing/development"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/property"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/property/recommendation"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/development"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/development/recommendation"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/navigation"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/navigation/recommendation"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/map"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/landing"(platform: "/"){
            id = 'absal'
            category_id = 'MLC1459'
            category_path = ['MLC1459']
        }
    }

    test("Test Official store tracking") {
        def dataSet = {
            official_store_name = "test123"
            official_store_id = 123
        }

        "/home/category/real_estate/official_store/developer/action"(platform: "/", type: TrackType.Event, dataSet)
        "/home/category/real_estate/official_store/developer/print"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/official_store/developer/all_brands"(platform: "/", type: TrackType.Event) {}
        "/home/category/real_estate/official_store/realtor/action"(platform: "/", type: TrackType.Event, dataSet)
        "/home/category/real_estate/official_store/realtor/print"(platform: "/", type: TrackType.View, dataSet)
        "/home/category/real_estate/official_store/realtor/all_brands"(platform: "/", type: TrackType.Event) {}
    }

    test("Home core tracking") {
        "/home"(platform: "/mobile") {
            mp_installed = true
        }

        "/home/navigation_history"(platform: "/") {
            privacy_config_state = true
        }

        "/home/navigation_history/privacy_config_on"(platform: "/") {
            privacy_config_state = false
        }

        "/home/navigation_history/privacy_config_off"(platform: "/") {
            privacy_config_state = true
        }

        "/home/navigation_history/remove_all"(platform: "/") {
            privacy_config_state = false
        }

        "/home/navigation_history/remove"(platform: "/") {
            item_id = "MLB681933310"
            privacy_config_state = true
        }

        "/home/abort"(platform: "/mobile") {}

        "/home/back"(platform: "/mobile") {}

        "/home/failure"(platform: "/mobile", {
            error_message = "error loading home"
        })

        "/home/long_press"(platform: "/mobile") {}

        "/home/contextual_menu"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLB681933310"
        }

        "/home/share"(platform: "/mobile") {}

        "/home/contextual_menu/share"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLB681933310"
        }

        "/home/pulltorefresh"(platform:"/mobile") {}

        "/home/pulltorefresh/failure"(platform:"/mobile") {}

        "/home/pulltorefresh/abort"(platform:"/mobile") {}

        "/home/scroll"(platform: "/mobile") {}

        "/home/page"(platform: "/mobile") {
            page_number = 2
        }

        "/home/scroll/failure"(platform: "/mobile") {}

        "/home/scroll/abort"(platform: "/mobile") {}

        "/home/tap"(platform: "/mobile", {
            position = 1
            section = "history"
            tag_id = "MLB681933310"
            is_modal = true
        })

        "/home/carousel/firstto"(platform: "/mobile") {}

        "/home/carousel/lastcard"(platform: "/mobile") {}
    }

    test("Home Categories Listing") {
        "/home/categories"(platform: "/", type: TrackType.View) {}
    }

    test("Home Category Tracking") {
        "/home/category"(platform: "/web") {
            from="breadcrumb"
            category_id='MLA1051'
            category_path=['MLA1051']
            last_modified='2020-06-12T13:12:16.534Z'
        }
    }

    test("Real estate home tracking") {
        def dataSetViewEmpty = {
            filters = ''
            carousels = ''
            category_id = 'MLA1459'
            category_path = ['MLA1459']
        }

        def dataSetView = {
            category_id = "MLA1459"
            category_path = ['MLA1459']
            filters = {
                cityId: 1
                cityName: 'Santiago'
                stateId: 1
                stateName: 'Santiago'
                neighborhoodId: 1
                neighborhoodName: 'La rioja'
                categories: 11
                operations: 11
            }
            carousels = {
                premium: [1,2,3]
                gold: [11,12,13]
                used: [111,122,133]
            }
        }

        "/home/category/real-estate"(platform: "/", dataSetViewEmpty)
        "/home/category/real-estate"(platform: "/web", dataSetViewEmpty)

        "/home/category/real-estate"(platform: "/", dataSetView)
        "/home/category/real-estate"(platform: "/web", dataSetView)
        "/home/category/real-estate"(platform: "/mobile", dataSetView)
    }

    test("Motors home tracking") {
        def dataSet = {
            category_id = 'MLB1743'
            category_path = ['MLB1743']
        }

        "/home/category/motors"(platform: "/web/mobile", dataSet)
        "/home/category/motors"(platform: "/web/desktop", dataSet)

    }

    test("Home Server Side") {
        def dataSet = {
            component_count = 25
            newbie = true
            home_version = 'new'
            is_logged = true
        }
        def dataSet2 = {
            component_count = 25
        }
        "/backend/home"(platform: "/web/mobile", dataSet)
        "/home/backend/take_over"(platform: "/web") {}
        "/korriban"(platform: "/web/desktop", dataSet2)
    }

    test("Home Discovery Mobile") {
        def dataSet = {
            component_count = 25
            newbie = true
            home_version = 'new'
            is_logged = true
            realestates = {
                discovery = [
                        {
                            audience = '1'
                            bu = '1'
                            bu_line = '1'
                            component_id = '2'
                            content_id = '1'
                            flow = '2'
                            logic = '2'
                            position = 2
                        }
                ]
            }
        }
        "/home"(platform: "/mobile", dataSet)
    }

    test("Home Discovery Web") {
        def dataSet = {
            realestates = {
                discovery = [
                        {
                            audience = '1'
                            bu = '1'
                            bu_line = '1'
                            component_id = '2'
                            content_id = '1'
                            flow = '2'
                            logic = '2'
                            position = '2'
                        }
                ]
            }
        }
        "/home"(platform: "/web", dataSet)
    }

    test("Home Main Slider Mobile") {
        def dataSet = {
            component_count = 25
            newbie = true
            home_version = 'new'
            is_logged = true
            realestates = {
                main_slider = [
                        {
                            audience = '1'
                            bu = '1'
                            bu_line = '1'
                            component_id = '2'
                            content_id = '1'
                            flow = '2'
                            logic = '2'
                            position = 2
                        }
                ]
            }
        }
        "/home"(platform: "/mobile", dataSet)
    }

    test("Home Main Slider Web") {
        def dataSet = {
            realestates = {
                main_slider = [
                        {
                            audience = '1'
                            bu = '1'
                            bu_line = '1'
                            component_id = '2'
                            content_id = '1'
                            flow = '2'
                            logic = '2'
                            position = '2'
                        }
                ]
            }
        }
        "/home"(platform: "/web", dataSet)
    }

    test("Home Collections Web") {
        def dataSet = {
            realestates = {
                collections = [
                        {
                            audience = '2'
                            bu = '1'
                            bu_line = '1'
                            component_id = '2'
                            content_id = '1'
                            flow = '1'
                            logic = '2'
                            position = '4'
                        }
                ]
            }
        }
        "/home"(platform: "/web", dataSet)
    }

    test("Supermarket home tracking") {
        "/home/supermarket"(platform: "/") {}
    }

    test("Home.com tracking") {
        "/home_com"(platform: "/", type: TrackType.View) {}

        "/home_com/site_click"(platform: "/") {
            site_click = 'AR'
        }
    }

    test("Contract home tracking") {
        def dataSet = {
            category_id = 'MLC1459'
            category_path = ['MLC1459']
        }
        "/home/category/real_estate/request_contract"(platform: "/", type: TrackType.View, dataSet)
    }

    test("Home Advertising banners") {
        "/home/advertising"(platform: "/", type: TrackType.Event) {}
        "/home/advertising/billboard"(platform: "/", type: TrackType.Event) {}
    }

    test("Home Motors Sell Action") {
        "/home/motors"(platform: "/web/mobile", type: TrackType.Event) {}
        "/home/motors/sell"(platform: "/web/mobile", type: TrackType.Event) {}
    }
}
