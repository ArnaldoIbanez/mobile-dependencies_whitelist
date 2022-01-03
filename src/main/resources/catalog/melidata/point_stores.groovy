import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1300"

    /**
    * Point Stores section tracks
    */
    "/stores"(platform: "/", isAbstract: true) {}

    "/stores/create"(platform: "/", type: TrackType.View) {}
    "/stores/create_poses"(platform: "/", type: TrackType.View) {}
    "/stores/create_schedule"(platform: "/", isAbstract: true) {}
    "/stores/create_schedule/start"(platform: "/", type: TrackType.View) {}
    "/stores/create_schedule/end"(platform: "/", type: TrackType.Event) {}
    "/stores/create_delivery"(platform: "/", isAbstract: true) {}
    "/stores/create_delivery/start"(platform: "/", type: TrackType.View) {}
    "/stores/create_delivery/end"(platform: "/", type: TrackType.Event) {
        types(required: true, type: PropertyType.String, description: "the delivery types selected by the user", values: ['none', 'pickup', 'delivery', 'both'])
    }
    "/stores/link_operators"(platform: "/", type: TrackType.View) {}
    "/stores/list"(platform: "/", type: TrackType.View) {}
    "/stores/update"(platform: "/", type: TrackType.View) {}
    "/stores/update_schedule"(platform: "/", isAbstract: true) {}
    "/stores/update_schedule/start"(platform: "/", type: TrackType.View) {}
    "/stores/update_schedule/end"(platform: "/", type: TrackType.Event) {}
    "/stores/update_delivery"(platform: "/", isAbstract: true) {}
    "/stores/update_delivery/start"(platform: "/", type: TrackType.View) {}
    "/stores/update_delivery/end"(platform: "/", type: TrackType.Event) {
        types(required: true, type: PropertyType.String, description: "the delivery types selected by the user", values: ['none', 'pickup', 'delivery', 'both'])
    }
    "/stores/details"(platform: "/", type: TrackType.View) {}
    "/stores/details_pos"(platform: "/", type: TrackType.View) {}
    "/stores/details_devices"(platform: "/", type: TrackType.View) {}
    "/stores/details_collaborators"(platform: "/", type: TrackType.View) {}
    "/stores/device"(platform: "/", isAbstract: true) {}
    "/stores/device/device_issues"(platform: "/", type: TrackType.Event) {}
    "/stores/device/out_of_paper"(platform: "/", type: TrackType.Event) {}
    "/stores/device/associate"(platform: "/", isAbstract: true) {}
    "/stores/device/associate/start"(platform: "/", type: TrackType.Event) {
        tab_context(required: true, type: PropertyType.String, description: "the tab where the associate action starts", values: ["/stores/details_pos", "/stores/details_devices", "/stores/details_devices?walkthrough"])
    }
    "/stores/device/associate/end"(platform: "/", type: TrackType.Event) {
        tab_context(required: true, type: PropertyType.String, description: "the tab where the associate action ends", values: ["/stores/details_pos", "/stores/details_devices", "/stores/details_devices?walkthrough"])
    }
    "/stores/device/link"(platform: "/web", isAbstract: true) {}
    "/stores/device/link/start"(platform: "/web", type: TrackType.Event) {
        tab_context(required: true, type: PropertyType.String, description: "the tab where the link action starts", values: ["/stores/details_pos", "/stores/details_devices"])
    }
    "/stores/device/link/end"(platform: "/web", type: TrackType.Event) {
        tab_context(required: true, type: PropertyType.String, description: "the tab where the link action ends", values: ["/stores/details_pos", "/stores/details_devices"])
    }
    "/stores/pos"(platform: "/", type: TrackType.View, isAbstract:true) {}
    "/stores/pos/create"(platform: "/", type: TrackType.View) {}
    "/stores/pos/update"(platform: "/", type: TrackType.View) {}
    "/stores/standalone_pos"(platform: "/", type: TrackType.View) {}
    "/stores/move_pos"(platform: "/", type: TrackType.View) {}

    "/stores/walkthrough" (platform: "/", isAbstract: true) {}
    "/stores/walkthrough/step" (platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Walkthrough id")    
        step_id(type: PropertyType.String, required: true, description: "Walkthrough's step id")
    }
    "/stores/walkthrough/finish" (platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Walkthrough id")
    }
}
