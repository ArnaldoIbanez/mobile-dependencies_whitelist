package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("melidata sms track") {

        def defaultTrackInformation = {
            sent_date = new Date().toString()
            communication_id='comm1'
            segment_name="default"
            experiment_name="exp1"
            communication_data = "Test"
            event_type = "sent"
        }

        "/sms/generic"(platform: "/") {
            defaultTrackInformation()
        }

    }
}
