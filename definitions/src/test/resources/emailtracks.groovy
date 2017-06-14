import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("melidata emails track") {


        def defaultTrackInformation = {
            email_id = 123456
            subject = "Test"
            email_template = "CHO_PAGO_AGREE"
            event_type = "send"
            sent_date = new Date().toString()
        }

        "/email/generic"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/question"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/checkout"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/reputation"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/access"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/sale"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/mediation"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/auction_end"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/withdrawal"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/fup_feedback"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/message"(platform: "/email") {
            defaultTrackInformation()
        }

//        "/email/congrats"(platform: "/email") {
////            days = 0
//        }
//
//        "/email/next_to_overdue"(platform: "/email") {
////            days = 2
//        }
//
//        "/email/late_fee"(platform: "/email") {
//            //days = 3
//        }
    }

}
