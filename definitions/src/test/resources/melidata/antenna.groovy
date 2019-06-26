package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Billpayments") {
        "/antenna/manual_input"(platform: "/mobile") {}
        "/antenna/topup_helper" (platform: "/mobile") {}
    }
}
