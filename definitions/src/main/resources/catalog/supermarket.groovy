import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    // Supermarket
    "/supermarket"(platform: "/", isAbstract: true) {}
    "/supermarket/header"(platform: "/", type: TrackType.Event) {}
    "/supermarket/discovery"(platform: "/", type: TrackType.Event) {}
}