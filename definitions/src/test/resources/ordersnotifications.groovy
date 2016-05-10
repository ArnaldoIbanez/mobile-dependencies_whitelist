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
        }

        "/email/orders"(platform:"/email") {
            defaultTrackInformation()
        }

    }

}
