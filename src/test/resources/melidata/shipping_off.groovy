package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadopago"

    test("shipping off - Selecting Address") {

        "/shipping_activation/address-selection/list"(platform: "/",type: TrackType.View) {
        }

        "/shipping_config/checkout/preference"(platform: "/", type: TrackType.View) {
        }
    }
}