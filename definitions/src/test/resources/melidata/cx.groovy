package src.test.resources.melidata

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
        portal_contact = [form: true, c2c: "api_timeout", chat: "api_timeout"]
    }

    test("Portal") {
        "/portal/faq"(platform: "/", type: TrackType.View) {
            portal_contact = [
                channels: [:],
                contact_config: false
            ]
            user_type = "normal"
            reputation_level  = "5_green"
            seller_profile = "ADVANCED"
            loyalty_level = 5
            portal_content_id = 96
            portal_has_channels_configured = true
        }
        "/portal/hub"(platform: "/", type: TrackType.View) {
            portal_contact = [
                channels: [:],
                contact_config: false
            ]
            user_type = "normal"
            reputation_level  = "5_green"
            seller_profile = "ADVANCED"
            loyalty_level = 5
            portal_content_id = 96
            user_profile = ""
        }
        "/portal/form"(platform: "/", type: TrackType.View) {
            portal_contact = [
                channels: [:],
                contact_config: false
            ]
            user_type = "normal"
            reputation_level  = "5_green"
            portal_form_id = 96
            seller_profile = "ADVANCED"
            loyalty_level = 5
            portal_content_id = 96
        }
        "/portal/folder"(platform: "/", type: TrackType.View) {
            portal_contact = [
                channels: [:],
                contact_config: false
            ]
            user_type = "normal"
            reputation_level  = "5_green"
            seller_profile = "ADVANCED"
            loyalty_level = 5
            portal_content_id = 96
            user_profile = ""
        }
        "/portal/create_case"(platform: "/", type: TrackType.View) {
            portal_contact = [
                channels: [:],
                contact_config: false
            ]
            user_type = "normal"
            reputation_level  = "5_green"
            seller_profile = "ADVANCED"
            loyalty_level = 5
        }
        "/portal/search/result"(platform: "/", type: TrackType.View) {}
        "/portal/search/empty"(platform: "/", type: TrackType.View) {}
        "/portal/folder_rules"(platform: "/", type: TrackType.View) {}
    }


    test("Support Widget") {
        "/support/widget/folder"(platform: "/", type: TrackType.View) {
            portal_source_id = 999
        }
        "/support/widget/faq"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/problem"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_problem_id = 456
            portal_contact = [form: true, c2c: "api_timeout", chat: "api_timeout"]
        }
        "/support/widget/form"(platform: "/", type: TrackType.View) {
            portal_form_id = 56
            portal_source_id = 123
            portal_content_id = 987
            portal_problem_id = 456
        }
    }

    def defaultCaseInfo = {
        case_status = "pending"
        case_id = 12345678
        has_parent = false
        expired = false
    }

    test("Support Cases") {
        "/support/cases/detail"(platform: "/", type: TrackType.View) {
            case_status = "pending"
            case_id = 12345678
            has_parent = false
            expired = false
        }
        "/support/cases/new_contact"(platform: "/", type: TrackType.Event) {
            case_id = 12345555
            type = "greetings"
        }
    }
}
