package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Portal") {
        "/portal/faq"(platform: "/", type: TrackType.View) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_content_id = 96
            portal_has_channels_configured = true
        }
        "/portal/faq/click"(platform: "/", type: TrackType.Event) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_content_id = 96
            portal_has_channels_configured = true
        }
        "/portal/faq/effectivity_survey/click"(platform: "/", type: TrackType.Event) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_content_id = 96
            portal_has_channels_configured = true
            portal_effectivity_survey_value = 1
        }
        "/portal/hub"(platform: "/", type: TrackType.View) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_content_id = 96
            portal_has_channels_configured = true
            portal_source_id = 55
        }
        "/portal/form"(platform: "/", type: TrackType.View) {
            portal_form_id = 96
            portal_source_id = 15
        }
        "/portal/folder"(platform: "/", type: TrackType.View) {
            portal_content_id = 96
        }
        "/portal/folder/click"(platform: "/", type: TrackType.Event) {
            portal_content_id = 96
        }
        "/portal/create_case"(platform: "/", type: TrackType.Event) {
            portal_form_id = 15
            portal_source_id = 124
        }
        "/portal/folder_rules"(platform: "/", type: TrackType.View) {}
        "/portal/folder_rules/click"(platform: "/", type: TrackType.Event) {}
        "/portal/home"(platform: "/", type: TrackType.View) { portal_has_one_click = false }
        "/portal/zrp"(platform: "/", type: TrackType.View) {}

        "/portal/search"(platform: "/", type: TrackType.View) {
            portal_contents_result = []
        }
        "/portal/validate_user"(platform: "/", type: TrackType.View) {}
        "/portal/search/click"(platform: "/", type: TrackType.Event) {
            portal_source_id = 1627
            portal_content_id = 1
        }
    }

    test("Support Widget") {
        "/support/widget/folder"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 999
        }
        "/support/widget/folder/click"(platform: "/", type: TrackType.Event) {
            portal_content_id = 987
            portal_source_id = 999
        }
        "/support/widget/folder_rules"(platform: "/", type: TrackType.View) {
            portal_source_id = 999
        }
        "/support/widget/folder_rules/click"(platform: "/", type: TrackType.Event) {
            portal_source_id = 999
        }
        "/support/widget/home"(platform: "/", type: TrackType.View) {
            portal_source_id = 999
        }
        "/support/widget/zrp"(platform: "/", type: TrackType.View) {
            portal_source_id = 999
        }
        "/support/widget/faq"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/faq/click"(platform: "/", type: TrackType.Event) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/faq/effectivity_survey/click"(platform: "/", type: TrackType.Event) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
            portal_effectivity_survey_value = 1
        }
        "/support/widget/problem"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_problem_id = 456
            portal_contact = [form: true, c2c: "api_timeout", chat: "api_timeout"]
            portal_contact_predicted_team = 'Cuentas Digitales'
            portal_contact_prediction_score = 0.79
            portal_contact_predicted_problem_id = 123
        }
        "/support/widget/form"(platform: "/", type: TrackType.View) {
            portal_form_id = 56
            portal_source_id = 123
            portal_content_id = 987
            portal_problem_id = 456
        }
        "/support/widget/create_case"(platform: "/", type: TrackType.Event) {
            portal_form_id = 56
            portal_source_id = 123
            portal_content_id = 987
            portal_problem_id = 456
        }
        "/support/widget/search"(platform: "/", type: TrackType.View) {
            portal_source_id = 123
        }
        "/portal/problem"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_problem_id = 456
            portal_contact = [form: true, c2c: "api_timeout", chat: "api_timeout"]
        }
         "/portal/cancel_card"(platform: "/", type: TrackType.Event) {
            portal_source_id = 1628
            portal_custom_order_id = 12345678
            portal_prediction_id = 1234
        }
        "/portal/delay_card"(platform: "/", type: TrackType.Event) {
            portal_source_id = 1628
            portal_delayed_pack_id = 12345678
        }
    }

    test("Support Widget having Content Type") {
        "/support/widget/folder"(platform: "/", type: TrackType.View) {
            portal_content_id = 123
            portal_content_type = 'HOME'
            portal_source_id = 999
        }
        "/support/widget/folder/click"(platform: "/", type: TrackType.Event) {
            portal_content_id = 123
            portal_content_type = 'HOME'
            portal_source_id = 999
        }
        "/support/widget/folder"(platform: "/", type: TrackType.View) {
            portal_content_id = 123
            portal_content_type = 'FOLDER'
            portal_source_id = 999
        }
        "/support/widget/folder/click"(platform: "/", type: TrackType.Event) {
            portal_content_id = 123
            portal_content_type = 'FOLDER'
            portal_source_id = 999
        }
        "/support/widget/faq"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_content_type = 'RENDER'
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/faq/click"(platform: "/", type: TrackType.Event) {
            portal_content_id = 987
            portal_content_type = 'RENDER'
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/faq"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_content_type = 'SHOW_CONTACT'
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/faq/click"(platform: "/", type: TrackType.Event) {
            portal_content_id = 987
            portal_content_type = 'SHOW_CONTACT'
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/problem"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_content_type = 'REDIRECT'
            portal_source_id = 123
            portal_problem_id = 456
            portal_contact = [form: true, c2c: "api_timeout", chat: "api_timeout"]
            portal_contact_predicted_team = 'Cuentas Digitales'
            portal_contact_prediction_score = 0.79
            portal_contact_predicted_problem_id = 123
        }
        "/support/widget/form"(platform: "/", type: TrackType.View) {
            portal_form_id = 56
            portal_content_type = 'SHOW_CONTACT'
            portal_source_id = 123
            portal_content_id = 987
            portal_problem_id = 456
        }
        "/support/widget/create_case"(platform: "/", type: TrackType.Event) {
            portal_form_id = 56
            portal_content_type = 'SHOW_CONTACT'
            portal_source_id = 123
            portal_content_id = 987
            portal_problem_id = 456
        }
        "/support/widget/faq"(platform: "/", type: TrackType.View) {
            portal_content_id = 123
            portal_content_type = 'FOLDER_DYNAMIC'
            portal_source_id = 999
            portal_has_channels_configured = true
        }
    }

    test("Support Cases") {
        "/support/cases"(platform: "/", type: TrackType.View) {}
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

    test("Daisy") {
        "/support/helpcard"(platform: "/", type: TrackType.View) {}
        "/support/helpcard/contents"(platform: "/", type: TrackType.View) {
            portal_source_id = 1628
            helpcard_contents = [
                [
                    title: "Ayuda con tus compras",
                    redirect_url: "https://myaccount.mercadolibre.com.ar/listings",
                    directAccess: []
                ]
            ]
        }
        "/support/helpcard/contents"(platform: "/", type: TrackType.View) {
            portal_source_id = 1628
            helpcard_contents = [:]
        }
    }

    defaultBusiness = "mercadopago"

    test("Portal") {
        "/portal/faq"(platform: "/", type: TrackType.View) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_content_id = 96
            portal_has_channels_configured = true
        }
        "/portal/faq/click"(platform: "/", type: TrackType.Event) {
            portal_contact = [
                    channels: [:],
                    contact_config: false
            ]
            portal_content_id = 96
            portal_has_channels_configured = true
        }
        "/portal/faq/effectivity_survey/click"(platform: "/", type: TrackType.Event) {
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
            portal_has_channels_configured = true
            portal_source_id = 55
        }
        "/portal/form"(platform: "/", type: TrackType.View) {
            portal_form_id = 96
            portal_source_id = 15
        }
        "/portal/folder"(platform: "/", type: TrackType.View) {
            portal_content_id = 96
        }
        "/portal/folder/click"(platform: "/", type: TrackType.Event) {
            portal_content_id = 96
        }
        "/portal/create_case"(platform: "/", type: TrackType.Event) {
            portal_form_id = 15
            portal_source_id = 124
        }
        "/portal/folder_rules"(platform: "/", type: TrackType.View) {}
        "/portal/folder_rules/click"(platform: "/", type: TrackType.Event) {}
        "/portal/home"(platform: "/", type: TrackType.View) { portal_has_one_click = false }
        "/portal/home"(platform: "/", type: TrackType.View) {
            portal_source_id = 1627
            portal_show_cancel_card = true
            portal_prediction_id = 1234
            portal_has_one_click = false
        }
         "/portal/home"(platform: "/", type: TrackType.View) {
            portal_source_id = 1627
            portal_show_cancel_card = false
            portal_prediction_id = 1234
            portal_has_one_click = false
            portal_predicted_contents = [123, 456]
        }
         "/portal/home"(platform: "/", type: TrackType.View) {
            portal_source_id = 1627
            portal_show_delay_cards = true
            portal_delayed_packs_ids = [123]
            portal_prediction_id = 1234
            portal_has_one_click = false
        }
         "/portal/home"(platform: "/", type: TrackType.View) {
            portal_source_id = 1627
            portal_show_delay_cards = false
            portal_prediction_id = 1234
            portal_has_one_click = false
            portal_predicted_contents = [123, 456]
        }
         "/portal/home"(platform: "/", type: TrackType.View) {
            portal_source_id = 1627
            portal_oneclick_cluster_id = 3
            portal_oneclick_contents_predicted = [1234, 5678]
            portal_oneclick_features = [ "TPV_USER" : 85443 ]
            portal_has_one_click = true
        }
        "/portal/zrp"(platform: "/", type: TrackType.View) {}
        "/portal/search"(platform: "/", type: TrackType.View) {
            portal_contents_result = [1234, 4321, 6543]
        }
        "/portal/search/click"(platform: "/", type: TrackType.Event) {
            portal_source_id = 1628
            portal_content_id = 637
        }
        "/portal/problem"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_problem_id = 456
            portal_contact = [form: true, c2c: "api_timeout", chat: "api_timeout"]
        }
        "/portal/validate_user"(platform: "/", type: TrackType.View) {}

        "/portal/cancel_card"(platform: "/", type: TrackType.Event) {
            portal_source_id = 1628
            portal_custom_order_id = 12345678
            portal_prediction_id = 1234
        }
        "/portal/delay_card"(platform: "/", type: TrackType.Event) {
            portal_source_id = 1628
            portal_delayed_pack_id = 12345678
        }
    }


    test("Support Widget") {
        "/support/widget/folder"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 999
        }
        "/support/widget/folder/click"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 999
        }
        "/support/widget/folder_rules"(platform: "/", type: TrackType.View) {
            portal_source_id = 999
        }
        "/support/widget/folder_rules/click"(platform: "/", type: TrackType.View) {
            portal_source_id = 999
        }
        "/support/widget/home"(platform: "/", type: TrackType.View) {
            portal_source_id = 999
        }
        "/support/widget/zrp"(platform: "/", type: TrackType.View) {
            portal_source_id = 999
        }
        "/support/widget/faq"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/faq/click"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
        }
        "/support/widget/faq/effectivity_survey/click"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_has_channels_configured = true
            portal_effectivity_survey_value = 1
        }
        "/support/widget/problem"(platform: "/", type: TrackType.View) {
            portal_content_id = 987
            portal_source_id = 123
            portal_problem_id = 456
            portal_contact = [form: true, c2c: "api_timeout", chat: "api_timeout"]
            portal_predicted_features = [tpv: 1234]
        }
        "/support/widget/form"(platform: "/", type: TrackType.View) {
            portal_form_id = 56
            portal_source_id = 123
            portal_content_id = 987
            portal_problem_id = 456
        }
        "/support/widget/create_case"(platform: "/", type: TrackType.Event) {
            portal_form_id = 56
            portal_source_id = 123
            portal_content_id = 987
            portal_problem_id = 456
        }
        "/support/widget/search"(platform: "/", type: TrackType.View) {
            portal_source_id = 123
        }
    }

    test("Support Cases") {
        "/support/cases"(platform: "/", type: TrackType.View) {}
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

    test("Daisy") {
        "/support/helpcard"(platform: "/", type: TrackType.View) {}
        "/support/helpcard/contents"(platform: "/", type: TrackType.View) {
            portal_source_id = 1628
            helpcard_contents = [
                [
                    title: "Ayuda con tus compras",
                    redirect_url: "https://myaccount.mercadolibre.com.ar/listings",
                    directAccess: []
                ]
            ]
        }
        "/support/helpcard/contents"(platform: "/", type: TrackType.View) {
            portal_source_id = "1628"
            helpcard_contents = [:]
        }
    }
}
