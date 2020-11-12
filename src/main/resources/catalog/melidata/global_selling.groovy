package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative = "1103"
    defaultBusiness = "mercadolibre"

    // GLOBAL SELLING TRACKS
    "/global-selling"(platform: "/", isAbstract: true) {}

    // Deposit Methods
    "/global-selling/deposit-methods"(platform: "/", type: TrackType.View) {}

    // Payment Reports
    "/global-selling/payment-reports"(platform: "/", type: TrackType.View) {}

    // Selling Preferences
    "/global-selling/selling-preferences"(platform: "/", type: TrackType.View) {}

    // Shipping Methods
    "/global-selling/shipping-methods"(platform: "/", type: TrackType.View) {}

}
