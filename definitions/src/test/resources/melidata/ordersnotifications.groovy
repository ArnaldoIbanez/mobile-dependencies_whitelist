package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("melidata track"){

        def defaultTrackInformation = {
            order_id="11146"
            order_date_created="2011-05-31T11:27:30.292-04:00"
            order_status="closed"
            seller_id="30"
            is_risk_user=true
            email_template="CHO_PAGO_AGREE"
            event_type="send"
            total_amount="100"
            payments = [
                    [
                            id : 3753658455,
                            status : "in_process",
                            date_created : "2018-05-22T18:24:50Z",
                            status_detail : "pending_review_manual",
                            date_approved : "0001-01-01T00:00:00Z",
                            method_id : "hipercard",
                            type : "credit_card",
                            date_last_modified : "2018-05-22T18:24:50Z",
                    ]
            ]
            shipping_type = "custom_shipping"
            buy_equals_pay = true
        }

        "/email/orders"(platform:"/email") {
            defaultTrackInformation()
        }

    }

}
