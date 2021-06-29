package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    initiative= "1144"

    "/navigation"(platform: "/", isAbstract: true) {}

    "/navigation/cookies_consent"(platform: "/", isAbstract: true) {}

    "/navigation/cookies_consent/show"(platform: "/web", type: TrackType.View) {
        consent_type(required: true, type: PropertyType.String,
                values: ["disclaimer", "bottom", "modal"],
                description: "Describes the type of shown consent"
        )
    }

    "/navigation/cookies_consent/ack"(platform: "/web", type: TrackType.Event) {}
    "/navigation/cookies_consent/accept_all"(platform: "/web", type: TrackType.Event) {
        consent_type(required: true, type: PropertyType.String,
                values: ["bottom", "modal"],
                description: "Describes the type of shown consent"
        )
    }
    "/navigation/cookies_consent/personalize"(platform: "/web", type: TrackType.Event) {
        consent_type(required: true, type: PropertyType.String,
                values: ["bottom", "modal"],
                description: "Describes the type of shown consent"
        )
    }
    "/navigation/cookies_consent/close"(platform: "/web", type: TrackType.Event) {
        consent_type(required: true, type: PropertyType.String,
                values: ["modal"],
                description: "Describes the type of shown consent"
        )
    }
}
