package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1350"

    // fury mp-shipping-off
    "/shipping_off/address-selection"(platform: "/", type: TrackType.View) {}

    // fury mpso-shipping-config
    "/shipping_off/checkout/preference/config"(platform:"/", type: TrackType.View){}
}