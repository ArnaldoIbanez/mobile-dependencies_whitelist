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
                            start_date : "2020/11/26T10:00:00",
                            end_date   : "2020/11/26T15:00:00",
                            order_id   : "24434343"
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
                            start_date : "2020/11/26T10:00:00",
                            end_date   : "2020/11/26T15:00:00",
                            order_id   : "24434343"
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
                            start_date : "2020/11/26T10:00:00",
                            end_date   : "2020/11/26T15:00:00",
                            order_id   : "24434343"
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

    test("MercadoEnvios - Crowd App - Testing earning history tracks") {
        def defaultLocation =
                {
                    latitude = "-36.34443"
                    longitude = "-35.34332"
                }

        def defaultPaginationMetadata = {
            pagination_metadata =
                    [
                            offset               : 1,
                            limit                : 10,
                            count                : 100,
                            latest_visible_period: "202103W5"
                    ]
        }

        def defaultDailyDetail = {
            daily_detail =
                    [
                            preinvoice_id    : "1",
                            preinvoice_status: "billed",
                            date             : "2021-03-09"
                    ]
        }

        def defaultWeeklyDetail = {
            weekly_detail =
                    [
                            preinvoice_id    : "1",
                            preinvoice_status: "billed",
                            period           : "202103W5",
                            type             : "regular"
                    ]
        }

        "/crowd/earning_history/hub"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/earning_history/hub/paginate"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPaginationMetadata()
        }

        "/crowd/earning_history/hub/daily_detail"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            defaultDailyDetail()
        }

        "/crowd/earning_history/hub/daily_detail/tooltip"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultDailyDetail()
        }

        "/crowd/earning_history/hub/daily_detail/help"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultDailyDetail()
        }

        "/crowd/earning_history/weekly_detail"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            defaultWeeklyDetail()
        }

        "/crowd/earning_history/weekly_detail/invoice/tap"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultWeeklyDetail()
        }

        "/crowd/earning_history/weekly_detail/payment/tap"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultWeeklyDetail()
        }

        "/crowd/earning_history/weekly_detail/help"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultWeeklyDetail()
        }

        "/crowd/earning_history/weekly_detail/tooltip"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultWeeklyDetail()
        }

        // Registration
        "/crowd/registration/tyc"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/hub"(platform: "/mobile", type: TrackType.View) {
            bullet = "kyc"
            defaultLocation()
        }

        "/crowd/registration/kyc/start"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/kyc/end"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/blocked"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/kyc/failure/logistics"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/city"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/city/selected"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            city = "La plata"
        }

        "/crowd/registration/city/other"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/vehicle"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/vehicle/selected"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            vehicle = "camion"
        }

        "/crowd/registration/vehicle/other"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/vehicle/old"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/vehicle/data"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/billing/start"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/billing/city"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/billing/tralix"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/vehicle_verification"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/city/unavailable"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/crowd/registration/create/driver/error"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }
    }
}