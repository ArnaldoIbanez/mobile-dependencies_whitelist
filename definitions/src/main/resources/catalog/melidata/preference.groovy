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
        url(required: false, type: PropertyType.String , description: "Preference url")
        pref_id(required: false, type: PropertyType.String, description: "Preference id")
        short_id(required: false, type: PropertyType.String, description: "Short id")
    }
}
