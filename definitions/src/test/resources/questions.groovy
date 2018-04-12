import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Questions tracking in web") {
        "/questions/ask/post" (platform:"/web", type: TrackType.Event) {
            item_id = "MLA533657947"
            failed = false
        }
    }

    test("Questions") {

        "/questions/list"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
        }

        "/questions/list"(platform: "/mobile") {
            context = "/seller_questions"
        }

        "/questions/list"(platform: "/mobile") {
            context = "/buyer_questions"
        }

        "/questions/ask"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
        }

        "/questions/ask/post"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
            failed = false
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
            failed = false
        }

        "/questions/answer/post"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/notifications"
            failed = true
        }

        "/questions/answer/back"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
        }


        "/questions/back"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
        }
    }

}