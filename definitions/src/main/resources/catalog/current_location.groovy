import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/current_location"(platform: "/", isAbstract: true) {}
    "/current_location/navigation"(platform: "/", isAbstract: true) {}
    "/current_location/navigation/pick"(platform: "/", type: TrackType.Event) {}
    "/current_location/navigation/close"(platform: "/", type: TrackType.Event) {}
    "/current_location/hub"(platform: "/", type: TrackType.View) {}
    "/current_location/hub/pick"(platform: "/", type: TrackType.Event) {
        action(
            required: true,
            type: PropertyType.String,
            description: "The action that triggers selected address",
            values: ["address", "zipcode"]
        )
    }
    "/current_location/hub/pick/error"(platform: "/", type: TrackType.Event) {
        action(
            required: true,
            type: PropertyType.String,
            description: "The action that triggers selected address",
            values: ["address", "zipcode"]
        )
        text(
            required: true,
            type: PropertyType.String,
            description: "Error text",
        )
    }
    "/current_location/hub/create_address"(platform: "/", type: TrackType.Event) {}
    "/current_location/hub/zipcode_finder"(platform: "/", type: TrackType.Event) {}

}
