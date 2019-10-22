package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/checkout_recovery"(platform: "/", type: TrackType.View) {
        item_id(required: true, type: PropertyType.String, description: "main item id")
        item_status(required: true, type: PropertyType.String, description: "main item status (no-stock, inative, etc)")
    }
    "/checkout_recovery/error"(platform: "/", type: TrackType.View) {}
    "/checkout_recovery/notfound"(platform: "/", type: TrackType.View) {}

}
