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

    test("Mercadopago discount sellers tap") {
        "/discount_sellers/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://discount_sellers/detail"
        }
    }

    test("Mercadopago discount sellers form back") {
        "/discount_sellers/form/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago discount sellers history back") {
        "/discount_sellers/history/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago discount sellers detail back") {
        "/discount_sellers/detail/back" (platform: "/mobile", type: TrackType.Event) {}
    }

}