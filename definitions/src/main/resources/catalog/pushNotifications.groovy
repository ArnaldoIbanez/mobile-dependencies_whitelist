import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/push_checkout_recovery"(platform: "/", type: TrackType.View) {
        item_status(required: false, type: PropertyType.String, description: "main item status (no-stock, inative, etc)")
    }
    "/push_checkout_recovery/error"(platform: "/", type: TrackType.View) {}
    "/push_checkout_recovery/notfound"(platform: "/", type: TrackType.View) {}

}
