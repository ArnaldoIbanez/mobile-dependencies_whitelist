package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType

tracks {
    initiative = "1101"

    "/whatsapp"(platform: "/", isAbstract: true) {
        template_name(required: true, type: PropertyType.String, description: "Message template name")
        event_type(required: true, type: PropertyType.String, values: ["sent", "delivered", "failed", "read", "sending", "deleted", "answered"], description: "Message status")
        message_id(required: false, type: PropertyType.String, description: "Message Id")
    }

    "/whatsapp/generic"(platform: "/") {
    }
}