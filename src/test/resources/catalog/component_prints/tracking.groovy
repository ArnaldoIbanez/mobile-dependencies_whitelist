package catalog.component_prints

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("test path") {
        "/"(platform: "/") {}
    }

    .test("Home Discovery Component") {
        def dataSet = {
            component_count = 25
            newbie = true
            home_version = 'new'
            is_logged = true
        }
        def component = {
            c_id = 1
            c_event = 1
            c_campaign = 1
            c_element_order = 1
            c_original_target = 1
            merch_data = []
        }
        "/component"(platform: "/web", dataSet)
        "/component"(platform: "/web") {component}
    }

}
