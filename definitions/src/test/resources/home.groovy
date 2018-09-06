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
        "/home/navigation"(platform: "/web/mobile") {}
    }

    test("Home core tracking") {
        "/home"(platform: "/mobile") {}

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

        "/home/scroll/failure"(platform: "/mobile") {}

        "/home/scroll/abort"(platform: "/mobile") {}

        "/home/tap"(platform: "/mobile", {
            position = 1
            section = "history"
            tag_id = "MLB681933310"
        })

        "/home/carousel/firstto"(platform: "/mobile") {}

        "/home/carousel/lastcard"(platform: "/mobile") {}
    }


    test("Home Category Tracking") {
        "/home/category"(platform: "/web") {
            from="breadcrumb"
            category_id='MLA1051'
            category_path=['MLA1051']
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



}
