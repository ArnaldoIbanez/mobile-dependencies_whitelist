import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/push_checkout_recovery"(platform: "/web/mobile", type: TrackType.View) {
        item_status(required: true, type: PropertyType.String, description: "main item status (no-stock, inative, etc)")
    }
    "/push_checkout_recovery/error"(platform: "/web/mobile", type: TrackType.View) {}
    "/push_checkout_recovery/notfound"(platform: "/web/mobile", type: TrackType.View) {}

}
