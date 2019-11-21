import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/navigation"(platform: "/", isAbstract: true) {}
    "/navigation/login"(platform: "/", isAbstract: true) {
        app_id(required: true, type: PropertyType.String,  description: "Refering app")
    }
    "/navigation/login/show"(platform: "/", type: TrackType.View) {}
    "/navigation/login/close"(platform: "/", type: TrackType.Event) {}
    "/navigation/login/autoclose"(platform: "/", type: TrackType.Event) {}
    "/navigation/login/login-link"(platform: "/", type: TrackType.Event) {}
    "/navigation/login/register-link"(platform: "/", type: TrackType.Event) {}
}
