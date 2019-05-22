package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    def defaultCaseInfo = {
        case_status = "pending"
        case_id = 12345678
        has_parent = false
        expired = false
    }


    def defaultPortalInfo = {
        portal_content_id = 987
        portal_form_id = 54
        portal_source_id = 123
        portal_has_channels_configured = true
        portal_contact = [form: true, c2c: "api_timeout", chat: "api_timeout"]
    }


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
            portal_has_channels_configured = true
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
            portal_has_channels_configured = true
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
            portal_has_channels_configured = true
        }
        "/portal/search/result"(platform: "/", type: TrackType.View) {
            user_type = "normal"
            reputation_level  = "5_green"
            seller_profile = "ADVANCED"
            loyalty_level = 5
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_has_channels_configured = true
        }
        "/portal/search/empty"(platform: "/", type: TrackType.View) {
            user_type = "normal"
            reputation_level  = "5_green"
            seller_profile = "ADVANCED"
            loyalty_level = 5
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_has_channels_configured = true
        }
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

    test("Support Widget having Content Type") {
        "/support/widget/folder"(platform: "/", type: TrackType.View) {
            portal_content_id = 123
            portal_content_type = 'FOLDER'
            portal_source_id = 999
        }
        "/support/widget/faq"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_content_type = 'CONTENT'
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/faq"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_content_type = 'SHOW_CONTACTS'
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/problem"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_content_type = 'SHOW_CONTACTS'
            portal_source_id = 123
            portal_problem_id = 456
            portal_contact = [form: true, c2c: "api_timeout", chat: "api_timeout"]
        }
        "/support/widget/form"(platform: "/", type: TrackType.View) {
            portal_form_id = 56
            portal_content_type = 'SHOW_CONTACTS'
            portal_source_id = 123
            portal_content_id = 987
            portal_problem_id = 456
        }
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

    defaultBusiness = "mercadopago"

    test("cx"){
        "/cx/click_on_article" (platform: "/mobile", type: TrackType.Event){
            article_id = "MLA754486062"
        }
        "/cx/click_on_help" (platform: "/mobile", type: TrackType.Event){}
        "/cx/click_on_error" (platform: "/mobile", type: TrackType.Event){}
        "/cx/click_on_suggestion" (platform: "/mobile", type: TrackType.Event){}
        "/cx/contact_types/click_on_contact_form" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Portal") {
        "/portal/faq"(platform: "/", type: TrackType.View) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_content_id = 96
            portal_has_channels_configured = true
        }
        "/portal/hub"(platform: "/", type: TrackType.View) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_content_id = 96
            user_profile = ""
            portal_has_channels_configured = true
        }
        "/portal/form"(platform: "/", type: TrackType.View) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_form_id = 96
            portal_content_id = 96
            portal_has_channels_configured = true
        }
        "/portal/folder"(platform: "/", type: TrackType.View) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_content_id = 96
            user_profile = ""
        }
        "/portal/create_case"(platform: "/", type: TrackType.View) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
                        portal_has_channels_configured = true

        }
        "/portal/search/result"(platform: "/", type: TrackType.View) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_has_channels_configured = true
        }
        "/portal/search/empty"(platform: "/", type: TrackType.View) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_has_channels_configured = true
        }
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
