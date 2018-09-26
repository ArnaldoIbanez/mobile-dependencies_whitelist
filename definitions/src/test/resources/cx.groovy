import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("cx"){
        "/cx/click_on_article" (platform: "/mobile", type: TrackType.Event){
            article_id = "MLA754486062"
        }
        "/cx/click_on_help" (platform: "/mobile", type: TrackType.Event){}
        "/cx/click_on_error" (platform: "/mobile", type: TrackType.Event){}
        "/cx/click_on_suggestion" (platform: "/mobile", type: TrackType.Event){}
        "/cx/contact_types/click_on_contact_form" (platform: "/mobile", type: TrackType.Event) {}
    }

    def defaultPortalInfo = {
        portal_content_id = 987
        portal_form_id = 54
        portal_source_id = 123
        portal_has_channels_configured = true
        portal_contact = "{form: \"true\", c2c: \"api_timeout\", chat: \"api_timeout\"}"
    }

    test("Portal") {
        "/portal/faq"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/portal/hub"(platform: "/", type: TrackType.View) {
            portal_form_id = 54
            portal_source_id = 123
            portal_contact = "{form: \"true\", c2c: \"api_timeout\", chat: \"api_timeout\"}"
        }
        "/portal/form"(platform: "/", type: TrackType.View) {
            portal_form_id = 54
            portal_source_id = 123
        }
        "/portal/folder"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/portal/create_case"(platform: "/", type: TrackType.View) {}
    }


    test("Support Widget") {
        "/support/widget/faq"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
            portal_problem_id = 456
        }
        "/support/widget/problem"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
            portal_contact = "{form: \"true\", c2c: \"api_timeout\", chat: \"api_timeout\"}"
            portal_problem_id = 456
        }
        "/support/widget/form"(platform: "/", type: TrackType.View) {
            portal_form_id = 56
            portal_source_id = 123
            portal_has_channels_configured = true
            portal_contact = "{form: \"true\", c2c: \"api_timeout\", chat: \"api_timeout\"}"
            portal_problem_id = 456
        }
    }
}
