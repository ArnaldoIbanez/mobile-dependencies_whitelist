package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    test("MercadoEnvios - Crowd App - Testing offers tracks") {

        def defaultLocation =
                {
                    latitude = "-36.34443"
                    longitude = "-35.34332"
                }

        def defaultOfferInfo = {
            offers_info = [
                    [
                            offer_price: 33443.33,
                            facility_id: "SMX1",
                            start_date: "2020/11/26T10:00:00",
                            end_date: "2020/11/26T15:00:00",
                            order_id: "24434343"
                    ]
            ]
        }

        //Full error view page success
        "/crowd/offers"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            defaultOfferInfo()
        }

        "/crowd/offers/detail"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            defaultOfferInfo()
        }

        "/crowd/offers/detail/map"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultOfferInfo()
        }

        "/crowd/offers/detail/confirm"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultOfferInfo()
        }
    }

    test("MercadoEnvios - Crowd App - Testing confirmations tracks") {

        def defaultLocation =
                {
                    latitude = "-36.34443"
                    longitude = "-35.34332"
                }

        def defaultOrdersInfo = {
            orders_info = [
                    [
                            order_price: 33443.33,
                            facility_id: "SMX1",
                            start_date: "2020/11/26T10:00:00",
                            end_date: "2020/11/26T15:00:00",
                            order_id: "24434343"
                    ]
            ]
        }

        //Full error view page success
        "/crowd/confirmations"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            defaultOrdersInfo()
        }

        "/crowd/confirmations/detail"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            defaultOrdersInfo()
        }

        "/crowd/confirmations/detail/map"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultOrdersInfo()
        }

        "/crowd/confirmations/detail/cancel"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultOrdersInfo()
        }

        "/crowd/confirmations/detail/cancel_modal"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            defaultOrdersInfo()
        }

        "/crowd/confirmations/cancellation/reasons"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            defaultOrdersInfo()
        }

        "/crowd/confirmations/cancellation/reasons/cancel"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultOrdersInfo()
            reason = "reason_description"
        }
    }
}