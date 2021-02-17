package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    // *********************************************
    // *************** MERCADO PAGO ****************
    // *********************************************

    defaultBusiness = "mercadopago"

    test("Mercado Pago discount center payers touchpoint px congrats tap") {
        "/discount_center/payers/touchpoint/px_congrats/tap" (platform: "/mobile", type: TrackType.Event) {
            tracking_id= "346859234"
            flow= "/instore"
            checkout_type= "one_tap"
            security_enabled= false
            session_id= "65c7168b-cf25-4033-ad7a-e7874868a164"
            session_time= 58
            flow_detail= [
                store_id: "30974197",
                pos_id: "7414488"
            ]
            category="category_test"
            experiments="experiment_test"
        }
    }

    test("Mercado Pago discount center payers touchpoint px congrats show") {
        "/discount_center/payers/touchpoint/px_congrats/show" (platform: "/mobile", type: TrackType.Event) {
            items= [
                [
                    tracking_id: "346859234"
                ]
            ]
            flow= "/instore"
            checkout_type= "one_tap"
            security_enabled= false
            session_id= "65c7168b-cf25-4033-ad7a-e7874868a164"
            session_time= 58
            flow_detail= [
                store_id: "30974197",
                pos_id: "7414488"
            ]
            category="category_test"
            experiments="experiment_test"
        }
    }

    test("Mercado Pago discount center payers touchpoint px congrats print") {
        "/discount_center/payers/touchpoint/px_congrats/print" (platform: "/mobile", type: TrackType.Event) {
            items= [
                    [
                        tracking_id: "346859234"
                    ]
            ]
            flow= "/instore"
            checkout_type= "one_tap"
            security_enabled= false
            session_id= "65c7168b-cf25-4033-ad7a-e7874868a164"
            session_time= 58
            flow_detail= [
                    store_id: "30974197",
                    pos_id: "7414488"
            ]
            category="category_test"
            experiments="experiment_test"
        }
    }

    // *********************************************
    // *************** MERCADO LIBRE ***************
    // *********************************************

    defaultBusiness = "mercadolibre"

    test("Mercado Libre discount center payers touchpoint px congrats tap") {
        "/discount_center/payers/touchpoint/px_congrats/tap" (platform: "/mobile", type: TrackType.Event) {
            tracking_id= "346859234"
            flow= "/instore"
            checkout_type= "one_tap"
            security_enabled= false
            session_id= "65c7168b-cf25-4033-ad7a-e7874868a164"
            session_time= 58
            flow_detail= [
                store_id: "30974197",
                pos_id: "7414488"
            ]
            category="category_test"
            experiments="experiment_test"
        }
    }

    test("Mercado Libre discount center payers touchpoint px congrats show") {
        "/discount_center/payers/touchpoint/px_congrats/show" (platform: "/mobile", type: TrackType.Event) {
            items= [
                [
                    tracking_id: "346859234"
                ]
            ]
            flow= "/instore"
            checkout_type= "one_tap"
            security_enabled= false
            session_id= "65c7168b-cf25-4033-ad7a-e7874868a164"
            session_time= 58
            flow_detail= [
                store_id: "30974197",
                pos_id: "7414488"
            ]
            category="category_test"
            experiments="experiment_test"
        }
    }

    test("Mercado Libre discount center payers touchpoint px congrats print") {
        "/discount_center/payers/touchpoint/px_congrats/print" (platform: "/mobile", type: TrackType.Event) {
            items= [
                    [
                        tracking_id: "346859234"
                    ]
            ]
            flow= "/instore"
            checkout_type= "one_tap"
            security_enabled= false
            session_id= "65c7168b-cf25-4033-ad7a-e7874868a164"
            session_time= 58
            flow_detail= [
                    store_id: "30974197",
                    pos_id: "7414488"
            ]
            category="category_test"
            experiments="experiment_test"
        }
    }
}
