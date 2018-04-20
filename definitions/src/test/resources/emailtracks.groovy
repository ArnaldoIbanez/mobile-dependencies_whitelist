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

        "/email/shpbo"(platform: "/email") {
            defaultTrackInformation()
            campaign_name = "mail_camp_prueba"
            campaign_date = "2018-04-17T19:34:57.121Z"
            is_test = true
        }
    }

}
