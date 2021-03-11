package src.test.resources.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

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

        "/crowd/offers/not_available_detail"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            offer_id = "offer123"
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

    test("MercadoEnvios - Crowd App - Testing login tracks") {

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

        "/crowd/login/result"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            type = "pending/disabled/unknown status driver"
        }

        "/crowd/login/success"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            type = "active/inactive status driver"
        }

        "/crowd/login/join"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
        }

        "/crowd/login/already_registered"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
        }

        "/crowd/login/faq"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
        }

        "/crowd/login/requirements"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
        }

        "/crowd/next_trip"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            defaultOrdersInfo()
            vehicle_id = "123456"
        }

        "/crowd/next_trip/checkin_in"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultOrdersInfo()
            vehicle_id = "123456"
        }

        "/crowd/next_trip/map"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultOrdersInfo()
            vehicle_id = "123456"
        }

        //Tracks lib flux
        "flux-client/list-shipments/geofence/mock"(platform: "/mobile", type: TrackType.Event) {
            user_id = "1234"
        }

    }
}