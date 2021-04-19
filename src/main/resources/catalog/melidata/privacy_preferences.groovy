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
    "/privacy_preferences/cookies"(platform: "/") {}
    "/privacy_preferences/cookies/save"(platform: "/", type: TrackType.Event) {
        advertising(type: PropertyType.Boolean, required: true, description: "User preferences, advertising category")
    }
    "/privacy_preferences/cookies/cancel"(platform: "/") {}

    //Privacy view for LGPD
    "/advertising"(platform: "/", isAbstract: true) {}
    "/advertising/privacy"(platform: "/", type: TrackType.View) {}
    "/advertising/privacy/modal"(platform: "/", type: TrackType.Event, isAbstract: true){}
    "/advertising/privacy/modal/show"(platform: "/", type: TrackType.Event) {
        switch_status(required: true, description: "Current state of switch")
    }
    "/advertising/privacy/modal/deactivate_ads"(platform: "/", type: TrackType.Event) {}
    "/advertising/privacy/modal/keep_ads_active"(platform: "/", type: TrackType.Event) {}
    "/advertising/privacy/modal/dismiss"(platform: "/", type: TrackType.Event) {
        switch_status(required: true, description: "Current state of switch")
    }
    "/advertising/privacy/switch"(platform: "/", type: TrackType.Event, isAbstract: true) {}
    "/advertising/privacy/switch/activated"(platform: "/", type: TrackType.Event) {
        switch_status(required: true, description: "Current state of switch")
    }
}
