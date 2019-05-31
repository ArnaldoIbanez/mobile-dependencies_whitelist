package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


/**************************
* WALLET HOME TEST TRACKS *
**************************/


trackTests {

    defaultBusiness = "mercadopago"

    test("Mercadopago Home") {
        "/wallet/home" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Tap") {
        "/wallet/home/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
        }
    }

    test("Mercadopago Home Show") {
        "/wallet/home/show" (platform: "/mobile", type: TrackType.Event) {
            header = "name"
            items = [
                [
                    id: "banking",
                    ordinal: 1,
                    type: "BANKING"
            ]
            ]
        }
    }

    test("Mercadopago Secondary Actions Section Show") {
        "/wallet/home/show/secondary_actions" (platform: "/mobile", type: TrackType.Event) {
            realestates_payers = [
                    [
                            realestate_id: "secondary_actions_mp_pay_services",
                            content_id: "pay_services",
                            origin: "secondary_actions"
                    ]
            ]
            realestates_sellers = [
                    [
                            realestate_id: "secondary_actions_mp_charge_with_qr",
                            content_id: "charge_with_qr",
                            origin: "secondary_actions"
                    ]
            ]
        }
    }

    test("Mercadopago Discount Benefits Section Show") {
        "/wallet/home/show/discount_benefits" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                        realestate_id : "discount_benefits_advice",
                        content_id : "mgm_payer",
                        origin : "user_journey"
                    ],
                    [
                        realestate_id : "discount_benefits_coupon",
                        content_id : "coupon",
                        origin : "user_journey"
                    ]
            ]
        }
    }

    test("Mercadopago Dismissible Row Section Show") {
        "/wallet/home/show/dismissible_row" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                        realestate_id : "dismissible_row",
                        content_id : "available_acquisition",
                        origin : "user_journey"
                    ]
            ]
        }
    }

    test("Mercadopago Cross Selling Section Show") {
        "/wallet/home/show/cross_selling" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                        realestate_id : "cross_selling_home_mp_prepaid",
                        content_id : "cross_selling_prepaid",
                        origin : "user_journey"
                    ],
                    [
                        realestate_id : "cross_selling_home_mp_point",
                        content_id : "cross_selling_point",
                        origin : "user_journey"
                    ]
            ]
        }
    }
}