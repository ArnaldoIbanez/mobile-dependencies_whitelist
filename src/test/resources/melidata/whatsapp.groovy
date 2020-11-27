package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    test("Whatsapp message status") {
        "/whatsapp/generic"(platform: "/") {
            template_name = "testtemp"
            event_type = "sent"
        }

        "/whatsapp/generic"(platform: "/") {
            template_name = "testtemp"
            event_type = "answered"
            message_id = "abc123"
        }
    }
}

