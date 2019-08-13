package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"


    test("Mercadopago discount sellers form") {
        "/discount_sellers/form" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago discount sellers history") {
        "/discount_sellers/history" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago discount sellers detail") {
        "/discount_sellers/detail" (platform: "/mobile", type: TrackType.View) {}
    }

}