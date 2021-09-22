package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1155"

    "/cx"(platform: "/web/desktop", isAbstract: true) {}
    "/cx/c2c"(platform: "/web/desktop", isAbstract: true) {}
    "/cx/c2c/console"(platform: "/web/desktop", isAbstract: true) {}
    "/cx/c2c/console/twilio"(platform: "/web/desktop", isAbstract: true) {}
    
    "/cx/c2c/console/twilio/errors"(platform: "/web/desktop", type: TrackType.Event) {
        error_code(type: PropertyType.String, description: "Twilio Error code")
        error_text(type: PropertyType.String, description: "Twilio Error text")
        call_sid(type: PropertyType.String, description: "Twilio Call SID")
        call_id(type: PropertyType.String, description: "Internal Call ID")
        case_id(type: PropertyType.String, description: "Case ID")
    }
}
