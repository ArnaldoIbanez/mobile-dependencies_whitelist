package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1350"

    "/shipping_activation/address-selection/list"(platform: "/", type: TrackType.View) {}

    "/shipping_config/checkout/preference"(platform:"/", type: TrackType.View){}
}