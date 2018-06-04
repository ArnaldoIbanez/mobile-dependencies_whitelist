import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/shipping/flex/optin"(platform: "/", type: TrackType.View) {
        view(required: true, type: PropertyType.String, description: "specific view the user was shown")
    }
}
