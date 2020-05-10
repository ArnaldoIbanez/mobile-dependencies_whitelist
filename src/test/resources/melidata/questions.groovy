package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Questions tracking in web") {
        "/questions/ask/post" (platform:"/", type: TrackType.Event) {
            item_id = "MLA533657947"
            failed = false
            context = "/questions"
            catalog_product_id = "MLA533657234"
        }
    }

    test("Questions") {

        "/questions/ask"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
        }

        "/questions/ask/post"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
            question_id = "12346"
            failed = false
        }

        "/questions/ask/post"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
            question_id = "12346"
            failed = true
			error = 403
			error_cause = "Question quota exceeded for the day"
        }

        "/questions/answer/post"(platform: "/mobile") {
            context = "/questions"
            item_id = "MLA12345"
            question_id = "12346"
            attach_id = "MLA12347"
            failed = false
        }

        "/questions/ask/back"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
        }

        "/questions/answer"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/notifications"
        }

        "/questions/answer"(platform: "/mobile") {
            context = "/questions"
            item_id = "MLA12345"
            from_deeplink = true
        }

        "/questions/answer/post"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/notifications"
            question_id = "12346"
            failed = false
        }

        "/questions/answer/post"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/notifications"
            question_id = "12346"
            failed = true
        }

        "/questions/back"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
        }

        "/questions/input_focus"(platform: "/mobile") {
            item_id = "MLA12345"
            catalog_product_id = "MLA15183"
            context = "PDP"
        }
    }

}
