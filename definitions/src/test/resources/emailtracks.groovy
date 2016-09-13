import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("melidata emails track") {


        def defaultTrackInformation = {
            email_id = 123456
            recipient = "test@test.com"
            sender = "testSender@test.com"
            subject = "Test"
            sent_date = "2011-05-31T11:27:30.292-04:00"
            email_template = "CHO_PAGO_AGREE"
            event_type = "send"
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

    }

}
