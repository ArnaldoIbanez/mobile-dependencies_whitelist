package catalog.component_prints

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("test path") {
        "/"(platform: "/") {}
    }

<<<<<<< HEAD
    .test("Home Discovery Component") {
        def dataSet = {
            component_count = 25
            newbie = true
            home_version = 'new'
            is_logged = true
        }
=======
    test("Home Discovery Component") {
>>>>>>> upstream/master
        def component = {
            c_id = 1
            c_event = 1
            c_campaign = 1
            c_element_order = 1
            c_original_target = 1
<<<<<<< HEAD
            merch_data = []
        }
        "/component"(platform: "/web", dataSet)
        "/component"(platform: "/web") {component}
=======
            merch_data = {
                content_id = "MKT_SUPERMERCADO"
                component_id = "discovery-second"
                audience = "all"
                bu = "3"
                bu_line = "26"
                flow = "-1"
                logic = "campaign"
                position = "2"
            }
        }
        "/component"(platform: "/web", component)
>>>>>>> upstream/master
    }

}
