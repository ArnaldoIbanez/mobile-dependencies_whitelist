package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"
    
    test("Stores frontend admin") {
        "/stores/create"(platform: "/web", type: TrackType.View) {}
        "/stores/create_poses"(platform: "/web", type: TrackType.View) {}
        "/stores/create_schedule/start"(platform: "/web", type: TrackType.View) {}
        "/stores/create_schedule/end"(platform: "/web", type: TrackType.Event) {}
        "/stores/create_delivery/start"(platform: "/web", type: TrackType.View) {}
        "/stores/create_delivery/end"(platform: "/web", type: TrackType.Event) {
            types = 'both'
        }
        "/stores/link_operators"(platform: "/web", type: TrackType.View) {}
        "/stores/list"(platform: "/web", type: TrackType.View) {}
        "/stores/update"(platform: "/web", type: TrackType.View) {}
        "/stores/update_schedule/start"(platform: "/web", type: TrackType.View) {}
        "/stores/update_schedule/end"(platform: "/web", type: TrackType.Event) {}
        "/stores/update_delivery/start"(platform: "/web", type: TrackType.View) {}
        "/stores/update_delivery/end"(platform: "/web", type: TrackType.Event) {
            types = 'both'
        }
        "/stores/details"(platform: "/web", type: TrackType.View) {}
        "/stores/pos/create"(platform: "/web", type: TrackType.View) {}
        "/stores/pos/update"(platform: "/web", type: TrackType.View) {}
        "/stores/standalone_pos"(platform: "/web", type: TrackType.View) {}
        "/stores/move_pos"(platform: "/web", type: TrackType.View) {}
        "/stores/details_pos"(platform: "/web", type: TrackType.View) {}
        "/stores/details_devices"(platform: "/web", type: TrackType.View) {}
        "/stores/details_collaborators"(platform: "/web", type: TrackType.View) {}
        "/stores/device/device_issues"(platform: "/web", type: TrackType.Event) {}
        "/stores/device/out_of_paper"(platform: "/web", type: TrackType.Event) {}
        "/stores/device/associate/start"(platform: "/web", type: TrackType.Event) {
            tab_context = "/stores/details_pos"
        }
        "/stores/device/associate/start"(platform: "/web", type: TrackType.Event) {
            tab_context = "/stores/details_devices"
        }
        "/stores/device/associate/end"(platform: "/web", type: TrackType.Event) {
            tab_context = "/stores/details_pos"
        }
        "/stores/device/associate/end"(platform: "/web", type: TrackType.Event) {
            tab_context = "/stores/details_devices"
        }
        "/stores/device/link/start"(platform: "/web", type: TrackType.Event) {
            tab_context = "/stores/details_pos"
        }
            "/stores/device/link/start"(platform: "/web", type: TrackType.Event) {
            tab_context = "/stores/details_devices"
        }
        "/stores/device/link/end"(platform: "/web", type: TrackType.Event) {
            tab_context = "/stores/details_pos"
        }
        "/stores/device/link/end"(platform: "/web", type: TrackType.Event) {
            tab_context = "/stores/details_devices"
        }
        "/stores/device/associate/start"(platform: "/web", type: TrackType.Event) {
            tab_context = "/stores/details_devices?walkthrough"
        }
        "/stores/device/associate/end"(platform: "/web", type: TrackType.Event) {
            tab_context = "/stores/details_devices?walkthrough"
        }
        "/stores/walkthrough/view"(platform: "/web", type: TrackType.Event) {
            id = "walkthroughIDTEST"
            step_id = "step1"
        }
        "/stores/walkthrough/finish"(platform: "/web", type: TrackType.Event) {
            id = "walkthroughIDTEST"
        }


        "/stores/create"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/create_poses"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/create_schedule/start"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/create_schedule/end"(platform: "/web/mobile", type: TrackType.Event) {}
        "/stores/create_delivery/start"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/create_delivery/end"(platform: "/web/mobile", type: TrackType.Event) {
            types = 'pickup'
        }
        "/stores/link_operators"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/list"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/update"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/update_schedule/start"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/update_schedule/end"(platform: "/web/mobile", type: TrackType.Event) {}
        "/stores/update_delivery/start"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/update_delivery/end"(platform: "/web/mobile", type: TrackType.Event) {
            types = 'pickup'
        }
        "/stores/details"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/pos/create"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/pos/update"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/standalone_pos"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/move_pos"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/details_pos"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/details_devices"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/details_collaborators"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/device/device_issues"(platform: "/web/mobile", type: TrackType.Event) {}
        "/stores/device/out_of_paper"(platform: "/web/mobile", type: TrackType.Event) {}
        "/stores/device/associate/start"(platform: "/web/mobile", type: TrackType.Event) {
            tab_context = "/stores/details_pos"
        }
        "/stores/device/associate/start"(platform: "/web/mobile", type: TrackType.Event) {
            tab_context = "/stores/details_devices"
        }
        "/stores/device/associate/end"(platform: "/web/mobile", type: TrackType.Event) {
            tab_context = "/stores/details_pos"
        }
        "/stores/device/associate/end"(platform: "/web/mobile", type: TrackType.Event) {
            tab_context = "/stores/details_devices"
        }
        
        "/stores/device/associate/start"(platform: "/web/mobile", type: TrackType.Event) {
            tab_context = "/stores/details_devices?walkthrough"
        }
        "/stores/device/associate/end"(platform: "/web/mobile", type: TrackType.Event) {
            tab_context = "/stores/details_devices?walkthrough"
        }
        "/stores/walkthrough/view"(platform: "/web/mobile", type: TrackType.Event) {
            id = "walkthroughIDTEST"
            step_id = "step1"
        }
        "/stores/walkthrough/finish"(platform: "/web/mobile", type: TrackType.Event) {
            id = "walkthroughIDTEST"
        }
    }
}
