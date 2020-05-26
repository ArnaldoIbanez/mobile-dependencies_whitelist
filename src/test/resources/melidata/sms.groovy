package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("melidata sms track") {

        def defaultTrackInformation = {
            sent_date = new Date().toString()
            text_message = "Test"
            communication_id='comm1'
            segment_id="default"
            experiment_id="exp1"
        }

        "/sms/generic"(platform: "/") {
            defaultTrackInformation()
        }

    }
}
