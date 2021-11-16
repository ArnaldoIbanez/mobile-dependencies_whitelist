package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    // reseller
    test("reseller") {
        "/reseller/scanner"(platform: "/mobile", type: TrackType.View) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
            seller_id = "342713"
            store_id = "43678"
            campaign_zone_id = "1"
            show_store_in_map = "true"
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }
}
