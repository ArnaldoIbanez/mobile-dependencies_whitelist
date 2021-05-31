package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1813"

    /**
    * Dynamic Features Tracks Definition
    */

    "/dynamic_features"(platform: "/mobile", isAbstract: true) {
        module_name( required: false, description: "the dynamic module name", type: PropertyType.String)
        new_deeplink( required: false, description: "the dynamic feature module deeplink", type: PropertyType.String)
        old_deeplink( required: true, description: "the old deeplink to enter to dynamic feature module", type: PropertyType.String)
    }

    // Dynamic Features Events
    "/dynamic_features/downloaded"(platform: "/mobile", type: TrackType.Event) {}
    "/dynamic_features/canceled"(platform: "/mobile", type: TrackType.Event) {}
    "/dynamic_features/failed"(platform: "/mobile", type: TrackType.Event) {}
    "/dynamic_features/launched"(platform: "/mobile", type: TrackType.Event) {}
}