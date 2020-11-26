package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("cards prepaid landing") {

        // View
        "/prepaid/"(platform: "/", type: TrackType.View) {}
        "/prepaid/"(platform: "/", type: TrackType.View) { user_profile = "buyers" }
        "/prepaid/hotjar"(platform: "/", type: TrackType.Event) { hotjar_user_id = "9PW342" }
        "/prepaid/acquisition"(platform: "/web/desktop") {}
        "/prepaid/acquisition"(platform: "/web/desktop") { is_point = true }
        "/prepaid/acquisition"(platform: "/web/desktop") { is_point = false }
        "/prepaid/acquisition/landing/card_request"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/card_request"(platform: "/", type: TrackType.View) { user_profile = "sellers" }
        "/prepaid/acquisition/landing/on_delivery_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/delivered_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/inactive/user_request"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/inactive/not_delivered_stolen_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/inactive/not_delivered_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/need_fund"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/active_card"(platform: "/web/desktop") {}
    }


    test("cards prepaid acquisition flow - anses") {
        // View
        "/prepaid/acquisition/init_point"(platform: "/", type: TrackType.View) {
            referral = "some"
            flow = "anses"
        }
    }

    test("cards prepaid acquisition flow without challenge") {
        // View
        "/prepaid/acquisition/init_point"(platform: "/", type: TrackType.View) {
            referral = "some"
            flow = "prepaid"
            is_challenge = false
        }
    }

    test("cards prepaid acquisition flow with challenge") {

        // View
        "/prepaid/acquisition/init_point"(platform: "/", type: TrackType.View) {
            referral = "some"
            flow = "prepaid"
            is_challenge = true
            challenge_reason = "need_funding"
            has_challenged_prepaid = false
            had_prepaid = false
            has_prepaid = false
            had_money_last_7d = false
            had_money_last_7d = false
            is_point_seller = false
            bought_point_device = false
            current_balance_amount = "zero"
            needed_funding_amount = 20
            has_money = false
            pending_ticket = false
        }
        "/prepaid/acquisition/change_dni"(platform: "/web/desktop") {}
        "/prepaid/acquisition/confirmation_account"(platform: "/web/desktop") {}
        "/prepaid/acquisition/registration/congrats"(platform: "/web/desktop") {}
        "/prepaid/acquisition/juridical_info"(platform: "/web/desktop") {}
        "/prepaid/acquisition/personal_info"(platform: "/") {}
        "/prepaid/acquisition/personal_info/identity"(platform: "/web/mobile") {}
        "/prepaid/acquisition/personal_info/gender"(platform: "/web/mobile") {}
        "/prepaid/acquisition/personal_info/activity"(platform: "/web/mobile") {}
        "/prepaid/acquisition/review"(platform: "/") {}
        "/prepaid/acquisition/review/welcome"(platform: "/web/desktop") {}
        "/prepaid/acquisition/need_fund"(platform: "/web/desktop") {}
        "/prepaid/acquisition/legal_representative" (platform: "/") {}
        "/prepaid/acquisition/no_complies" (platform: "/") {}
        "/prepaid/acquisition/welcome_company" (platform: "/") {}
        "/prepaid/acquisition/dark_side_shield"(platform: "/") {}
        "/prepaid/acquisition/dark_side_shield/cta"(platform: "/", type: TrackType.Event) { }

        "/prepaid/acquisition/congrats"(platform: "/", type: TrackType.View) {congrats_type = "prepaid" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) {congrats_type = "prepaid_delay" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) {congrats_type = "prepaid_point_different_address" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) {congrats_type = "prepaid_point_same_address" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) { congrats_type = "bapropagos" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) { congrats_type = "pagofacil" }
        "/prepaid/acquisition/congrats"(platform: "/web/mobile", type: TrackType.View) { congrats_type = "rapipago" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) { congrats_type = "redlink" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) { congrats_type = "maestro" }
        "/prepaid/acquisition/congrats"(platform: "/web/mobile", type: TrackType.View) { congrats_type = "bolbradesco" }

        "/prepaid/acquisition/error"(platform: "/web", type: TrackType.View) { error_type = "limited" }
        "/prepaid/acquisition/error"(platform: "/web/desktop", type: TrackType.View) { error_type = "main_error" }
        "/prepaid/acquisition/error"(platform: "/web/desktop", type: TrackType.View) { error_type = "hasprepaid" }
        "/prepaid/acquisition/error"(platform: "/web/mobile", type: TrackType.View) { error_type = "juridical" }
        "/prepaid/acquisition/error"(platform: "/web/mobile", type: TrackType.View) { error_type = "identification" }
        "/prepaid/acquisition/error"(platform: "/web/mobile", type: TrackType.View) { error_type = "denied" }
        "/prepaid/acquisition/error"(platform: "/web/mobile", type: TrackType.View) { error_type = "operator" }

        "/prepaid/acquisition/cellphone"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/onboarding"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/onboarding/slide/first"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/onboarding/slide/second"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/onboarding/slide/third"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/onboarding/slide/fourth"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/onboarding/slide/fifth"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/challenge/onboarding/slide/first"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/challenge/onboarding/slide/second"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/challenge/onboarding/slide/third"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/challenge/onboarding/slide/fourth"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/challenge/onboarding/slide/fifth"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/onboarding/slide/exit"(platform:"/mobile", type: TrackType.Event) {
            slide = 1
            cause = "close"
        }
        "/prepaid/challenge/onboarding/slide/exit"(platform:"/mobile", type: TrackType.Event) {
            slide = 2
            cause = "back"
        }
        "/prepaid/acquisition/rootfaq"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/detailfaq"(platform: "/mobile", type: TrackType.View) {}

        "/prepaid/acquisition/occupation"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/preview"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/review"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/has_prepaid"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/no_identity"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/is_collaborator"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/acquisition/limited"(platform: "/mobile", type: TrackType.View) {}
    }


    test("cards prepaid challenge flow") {
        "/prepaid/challenge/pending_ticket"(platform: "/mobile", type: TrackType.View) {
            referral = "some"
        }
        "/prepaid/challenge/delivery"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/challenge/money_in/onboarding"(platform: "/mobile", type: TrackType.View) {}
        "/prepaid/challenge/money_in/onboarding/slide/exit"(platform:"/mobile", type: TrackType.Event) {
            slide = 1
            cause = "close"
        }
        "/prepaid/challenge/onboarding"(platform: "/mobile", type: TrackType.View) {}
    }

    test("cards prepaid activation flow") {

        // View
        "/prepaid/activation"(platform: "/web/desktop") {}
        "/prepaid/activation/last_digits"(platform: "/web/desktop") {}
        "/prepaid/activation/marital_status"(platform: "/web/desktop") {}
        "/prepaid/activation/congrats"(platform: "/web/desktop") {}
        "/prepaid/activation/congrats/change_pin_tap"(platform: "/", type: TrackType.Event) {}
        "/prepaid/activation/congrats/home_tap"(platform: "/", type: TrackType.Event) {}
        "/prepaid/activation/congrats/add_money_tap"(platform: "/", type: TrackType.Event) {}
        "/prepaid/activation/error"(platform: "/", type: TrackType.View) { error_type = "main_error" }
        "/prepaid/activation/error"(platform: "/", type: TrackType.View) { error_type = "not_found" }
        "/prepaid/activation/error"(platform: "/", type: TrackType.View) { error_type = "max_attempt" }
        "/prepaid/activation/error"(platform: "/", type: TrackType.View) { error_type = "mismatch_dni" }
    }


    test("cards prepaid shipment tracking") {

        // View
        "/prepaid/tracking"(platform: "/", type: TrackType.View) { status = "on_track" }
        "/prepaid/tracking"(platform: "/", type: TrackType.View) { status = "delayed" }
        "/prepaid/tracking"(platform: "/", type: TrackType.View) { status = "to_collect" }
        "/prepaid/tracking"(platform: "/", type: TrackType.View) { status = "not_delivered" }
        "/prepaid/tracking"(platform: "/", type: TrackType.View) { status = "soon_deliver" }
        "/prepaid/tracking"(platform: "/", type: TrackType.View) { status = "reprogrammed" }
    }


    test("cards prepaid block") {

        // View
        "/prepaid/block"(platform: "/web/desktop") {}
    }
    
    test("My card webview") {
        "/my_cards_webview" (platform: "/mobile") { from = "/deep_link" }
    }

    test("Upgrade Webview") {
        "/prepaid/update_app" (platform: "/mobile", type: TrackType.View) { }
        "/prepaid/update_app/cta"(platform: "/mobile", type: TrackType.Event) { }
    }

    test("Ask form App") {
        "/prepaid/ask_from_app" (platform: "/mobile", type: TrackType.View) { }
    }

    test("Landing App Download button") {
        "/prepaid/acquisition/sellers_landing/store_button" (platform: "/", type: TrackType.Event) { }
    }

    test("Prepaid cards MLM") {
        
        "/prepaid_card/action_picker"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }
        "/prepaid_card/web_view"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }

        "/prepaid_card/result"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
            result_status = "approved"
        }
        "/prepaid_card/pay"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }
        "/prepaid_card/payment_methods"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }
        "/prepaid_card/other_payment_methods"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }
        "/prepaid_card/final_scene"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }
        "/prepaid_card/final_scene/prepaid"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }
        "/prepaid_card/final_scene/prepaid/success"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }


        "/prepaid_recharge/fill_recharge_data"(platform: "/mobile") {
            flow = "/prepaid_recharge"
            from = "/deep_link"
        }
        "/prepaid_recharge/recipients"(platform: "/mobile") {
            flow = "/prepaid_recharge"
            from = "/deep_link"
        }
        "/prepaid_recharge/result"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "internal_server_error"
        }
        "/prepaid_recharge/add_recipient"(platform: "/mobile") {
            flow = "/prepaid_recharge"
            from = "/deep_link"
        }
        "/prepaid_recharge/recipient"(platform: "/mobile") {
            flow = "/prepaid_recharge"
            from = "/deep_link"
        }
    }

    test ("Prepaid Setup") {
        "/wallet"(platform: "/", type: TrackType.View) {} 
        "/wallet/cards"(platform: "/", type: TrackType.View) {} 
        "/wallet/cards/prepaid"(platform: "/", type: TrackType.View) {} 
        "/wallet/cards/prepaid/detail" (platform: "/", type: TrackType.View) {}
        "/wallet/cards/prepaid/detail/freeze" (platform: "/", type: TrackType.Event) {}
        "/wallet/cards/prepaid/detail/unfreeze" (platform: "/", type: TrackType.Event) {}
        "/prepaid/change_pin" (platform: "/", type: TrackType.View) {}
        "/prepaid/change_pin/phone_info" (platform: "/", type: TrackType.View) {}
        "/prepaid/change_pin/new_pin" (platform: "/", type: TrackType.View) {}
        "/prepaid/change_pin/congrats" (platform: "/", type: TrackType.View) {}
        "/prepaid/reissue" (platform: "/", type: TrackType.View) {}
        "/prepaid/reissue/inactivate_card" (platform: "/", type: TrackType.View) {}
        "/prepaid/reissue/phone_info" (platform: "/", type: TrackType.View) {}
    }

    test ("Cards activation modal in card list") {
        "/wallet/cards/activation_modal/activation"(platform: "/", type: TrackType.View) {}
        "/wallet/cards/activation_modal/close"(platform: "/", type: TrackType.Event) {} 
        "/wallet/cards/activation_modal/activate_card"(platform: "/", type: TrackType.Event) {} 
        "/wallet/cards/activation_modal/not_receive_card"(platform: "/", type: TrackType.Event) {} 
    }
    
    test ("Prepaid FAQs") {
        "/prepaid/faq" (platform: "/", type: TrackType.View) {}
        "/prepaid/faq/detail" (platform: "/", type: TrackType.View) {}
        "/prepaid/faq/detail/payment_rejected" (platform: "/", type: TrackType.View) {}
        "/prepaid/faq/detail/extraction_rejected" (platform: "/", type: TrackType.View) {}
        "/prepaid/faq/detail/rejected_international_authorization" (platform: "/", type: TrackType.View) {}
        "/prepaid/faq/detail/payment_rejected/money_in" (platform: "/", type: TrackType.Event) {}
        "/prepaid/faq/detail/payment_rejected/reissue" (platform: "/", type: TrackType.Event) {}
        "/prepaid/faq/detail/extraction_rejected/reissue" (platform: "/", type: TrackType.Event) {}
        "/prepaid/faq/detail/rejected_international_authorization/money_in" (platform: "/", type: TrackType.Event) {}
        "/prepaid/faq/detail/rejected_international_authorization/reissue" (platform: "/", type: TrackType.Event) {}
    }

    test ("Cards acquisition pj onboarding") {
        "/prepaid/acquisition/pj_onboarding"(platform: "/", type: TrackType.View) {}
        "/prepaid/acquisition/pj_onboarding/tap"(platform: "/", type: TrackType.Event) {} 
        "/prepaid/acquisition/pj_onboarding/error"(platform: "/", type: TrackType.Event) {} 
    }

    test ("Cards acquisition Onboarding Adapt KYC") {
        "/prepaid/acquisition/onboarding_adapt_kyc"(platform: "/", type: TrackType.View) {}
        "/prepaid/acquisition/onboarding_adapt_kyc/tap"(platform: "/", type: TrackType.Event) {}
        "/prepaid/acquisition/onboarding_adapt_kyc/error"(platform: "/", type: TrackType.Event) {}
    }

    test ("Cards acquisition Congrats Adapt KYC") {
        "/prepaid/acquisition/adapt_kyc/congrats"(platform: "/", type: TrackType.View) {}
        "/prepaid/acquisition/adapt_kyc/congrats/tap"(platform: "/", type: TrackType.Event) { deeplink = "deeplink" }
        "/prepaid/acquisition/adapt_kyc/congrats/error"(platform: "/", type: TrackType.Event) {}
    }

    test ("Prepaid Detail") {
        "/cards/prepaid-detail/click-ask-for-card" (platform: "/web/desktop", type: TrackType.Event) { }
        "/cards/prepaid-detail/click-ask-for-card" (platform: "/web/mobile", type: TrackType.Event) {
             osName = "android"
        }
    }
}
