package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1096"

    "/navigation"(platform: "/", isAbstract: true) {}
    "/navigation/login"(platform: "/", isAbstract: true, initiative: "1127") {
        app_id(required: true, type: PropertyType.String,  description: "Refering app")
        widget_type(required: true, type: PropertyType.String, values: ["modal-register", "modal-login", "banner-register", "banner-login", "tooltip-register", "tooltip-login"],  description: "Type of widget")
    }
    "/navigation/login/show"(platform: "/", type: TrackType.View) {}
    "/navigation/login/close"(platform: "/", type: TrackType.Event) {}
    "/navigation/login/autoclose"(platform: "/", type: TrackType.Event) {}
    "/navigation/login/login_link"(platform: "/", type: TrackType.Event) {}
    "/navigation/login/register_link"(platform: "/", type: TrackType.Event) {}
}
