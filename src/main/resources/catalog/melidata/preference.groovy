package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


tracks {

    propertyDefinitions {   
        session_id(required: true, description: "Session id")
    }

    propertyGroups {
        baseData(session_id)
    }

    // Events:
    "/preference"(platform: "/mobile", isAbstract: true){
        baseData
    }

    // Init event
    "/preference/init"(platform: "/mobile", type: TrackType.Event) {
        origin(required: true, type: PropertyType.String, description: "How it was initialized")
        pref_id(required: true, type: PropertyType.String, description: "Preference id")
    }
}
