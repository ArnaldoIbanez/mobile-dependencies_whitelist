import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/current_location"(platform: "/", isAbstract: true) {}
    "/current_location/navigation"(platform: "/", isAbstract: true) {}
    "/current_location/navigation/pick"(platform: "/", type: TrackType.Event) {}
    "/current_location/navigation/close"(platform: "/", type: TrackType.Event) {}
    "/current_location/hub"(platform: "/", type: TrackType.View) {}
    "/current_location/hub/select_address"(platform: "/", type: TrackType.Event) {}
    "/current_location/hub/add_zipcode"(platform: "/", type: TrackType.Event) {}
    "/current_location/hub/create_address"(platform: "/", type: TrackType.Event) {}
    "/current_location/hub/find_zipcode"(platform: "/", type: TrackType.Event) {}
}
