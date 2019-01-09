package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("merchant credits") {
        def defaultTrackInformation = {
            email_id = 123456
            subject = "Test"
            email_template = "MCRDT_EXPIRED"
            event_type = "send"
            sent_date = new Date().toString()
        }

        "/email/generic"(platform: "/email") {
            defaultTrackInformation()
        }

        "/email/congrats"(platform: "/email") {
            defaultTrackInformation()
            days = 0
        }

        "/email/next_to_overdue"(platform: "/email") {
            defaultTrackInformation()
            days = 2
        }

        "/email/late_fee"(platform: "/email") {
            defaultTrackInformation()
            days = 3
        }

        "/email/new/optout"(platform: "/email") {
            defaultTrackInformation()
            email_template = "MCRDT_OPTOUT"
        }
    }
}
