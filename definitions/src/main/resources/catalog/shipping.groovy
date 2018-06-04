import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/shipping"(platform: "/", isAbstract: true) {}
    "/shipping/flex"(platform: "/", isAbstract: true) {}
    "/shipping/flex/optin"(platform: "/", type: TrackType.Event) {
        view(required: true, type: PropertyType.String, description: "specific view the app returned")
    }
}
