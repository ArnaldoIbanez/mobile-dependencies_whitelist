import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/navigation"(platform: "/", isAbstract: true) {}
    "/navigation/download_app"(platform: "/", isAbstract: true) {
        app_id(required: true, type: PropertyType.String,  description: "Refering app")
    }
    "/navigation/download_app/show"(platform: "/", type: TrackType.View) {}
    "/navigation/download_app/close"(platform: "/", type: TrackType.Event) {}
    "/navigation/download_app/download"(platform: "/", type: TrackType.Event) {}
}
