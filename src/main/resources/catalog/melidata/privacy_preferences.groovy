package src.main.resources.catalog.reviews

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1208"

    "/privacy_preferences"(platform: "/") {}
    "/privacy_preferences/export"(platform: "/") {}
    "/privacy_preferences/export/download"(platform: "/") {}
    "/privacy_preferences/export/create"(platform: "/", type: TrackType.Event) {
        entity_groups(type: PropertyType.ArrayList, required: true, description: "Entity groups identifiers")
    }
    "/privacy_preferences/onboarding"(platform: "/") {}
    "/privacy_preferences/data_usage"(platform: "/", type: TrackType.Event) {
        denied(type: PropertyType.Boolean, required: true, description: "Denied or not user data usage")
    }
}
