package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1096"

    /**
    * Dynamic Features Tracks Definition
    */
    "/dynamic_feature"(platform: "/mobile", isAbstract: true) {
        module_name( required: false, description: "the dynamic module name", type: PropertyType.String)
        dynamic_deeplink( required: false, description: "the dynamic feature module deeplink", type: PropertyType.String)
        dynamic_module_size( required: false, description: "the dynamic feature module size", type: PropertyType.String)
        failed_reason( required: false, description: "the dynamic feature module failed downloading / installed reason", type: PropertyType.String)
        static_deeplink( required: false, description: "the old deeplink to enter to dynamic feature module", type: PropertyType.String)
        mode(required: true, values: ["on_demand", "background"], description: "the mode of delivery", type: PropertyType.String)
    }

    // Dynamic Features Events
    "/dynamic_feature/canceled"(platform: "/mobile", type: TrackType.Event) {}
    "/dynamic_feature/failed"(platform: "/mobile", type: TrackType.Event) {}
    "/dynamic_feature/started"(platform: "/mobile", type: TrackType.Event) {}
    "/dynamic_feature/launched"(platform: "/mobile", type: TrackType.Event) {}
    "/dynamic_feature/dispatched"(platform: "/mobile", type: TrackType.Event) {}
    "/dynamic_feature/installed"(platform: "/mobile", type: TrackType.Event) {
        flow_time( required: false, description: "flow time", type: PropertyType.Numeric)
        download_time( required: false, description: "download time for module", type: PropertyType.Numeric)
    }

}
