package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Dynamic Features
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Dynamic features track - ML") {

        "/dynamic_feature/failed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            failed_reason = "some failed reason"
            mode="on_demand"
        }
        "/dynamic_feature/started"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_deeplink = "meli://new_deeplink"
            static_deeplink = "meli://old_deeplink"
            mode="background"
        }
        "/dynamic_feature/launched"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_deeplink = "meli://new_deeplink"
            static_deeplink = "meli://old_deeplink"
            mode="background"
        }
        "/dynamic_feature/canceled"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            static_deeplink = "meli://old_deeplink"
            mode="background"
        }
        "/dynamic_feature/dispatched"(platform: "/mobile", type: TrackType.Event) {
            static_deeplink = "meli://old_deeplink"
            mode="on_demand"
        }
        "/dynamic_feature/installed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_deeplink = "meli://new_deeplink"
            static_deeplink = "meli://old_deeplink"
            mode="on_demand"
            flow_time = 10
            download_time = 20
        }
    }

    defaultBusiness = "mercadopago"

    test("Dynamic features track - MP") {

        "/dynamic_feature/failed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_module_size = "500k"
            static_deeplink = "meli://old_deeplink"
            mode="on_demand"
        }
        "/dynamic_feature/started"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_deeplink = "meli://new_deeplink"
            static_deeplink = "meli://old_deeplink"
            mode="on_demand"
        }
        "/dynamic_feature/launched"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_deeplink = "meli://new_deeplink"
            static_deeplink = "meli://old_deeplink"
            mode="background"
        }
        "/dynamic_feature/canceled"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            static_deeplink = "meli://old_deeplink"
            mode="background"
        }
        "/dynamic_feature/dispatched"(platform: "/mobile", type: TrackType.Event) {
            static_deeplink = "meli://old_deeplink"
            mode="background"
        }

        "/dynamic_feature/installed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_deeplink = "meli://new_deeplink"
            static_deeplink = "meli://old_deeplink"
            mode="background"
            flow_time = 50
            download_time = 100
        }
    }
}
