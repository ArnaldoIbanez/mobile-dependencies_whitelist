import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/user_blocker"(platform: "/", isAbstract: true) {}

    "/user_blocker/shield"(platform: "/", type: TrackType.View) {}
    "/user_blocker/webview"(platform: "/", type: TrackType.View) {}
    "/user_blocker/redirect"(platform: "/", type: TrackType.View) {}
}