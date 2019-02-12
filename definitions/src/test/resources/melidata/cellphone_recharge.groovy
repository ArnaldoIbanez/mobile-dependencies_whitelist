package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Cellphone recharge") {
        "/cellphone_recharge"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/recents"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/set_telephone_number"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/contacts"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/carriers"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/recommended"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/packages"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/carrier_disabled"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/terms_and_conditions"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/px_payment_method_search"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_discount_summary"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_vault"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_number"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_holder_name"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_expiry_date"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_security_code"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_identification_number"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_issuers"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_installments"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_review_and_confirm"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_result"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
            result_status = "rejected"
        }

        "/cellphone_recharge/push_handler"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/pay"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/deals"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/deals/terms"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/payment_methods"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/other_payment_methods"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/cards"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/add_card"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/issuers"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/result"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "call_for_auth"
        }

        "/cellphone_recharge/confirm"(platform: "/web"){
            flow = "/cellphone_recharge"
        }

        "/cellphone_recharge/suggested_phones"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            from = "/sidebar_taladro"
        }
        "/cellphone_recharge/second_password"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/phone_income"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            status = "approved"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            status = "pending"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            status = "rejected"
        }
        "/cellphone_recharge/companies"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/checkout"(platform: "/web/desktop", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/amounts"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/amount_recommended"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/alias_income"(platform: "/web/mobile", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/account_money"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/error"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/not-found"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }

    }

defaultBusiness = "mercadolibre"

    test("Cellphone recharge") {
        "/cellphone_recharge"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/recents"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/set_telephone_number"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/contacts"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/carriers"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/recommended"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/packages"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/carrier_disabled"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/terms_and_conditions"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/px_payment_method_search"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_discount_summary"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_vault"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_number"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_holder_name"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_expiry_date"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_security_code"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_identification_number"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_issuers"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_installments"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_review_and_confirm"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_result"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
            result_status = "rejected"
        }

        "/cellphone_recharge/push_handler"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/pay"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/deals"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/deals/terms"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/payment_methods"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/other_payment_methods"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/cards"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/add_card"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/issuers"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/result"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "call_for_auth"
        }

        "/cellphone_recharge/confirm"(platform: "/web"){
            flow = "/cellphone_recharge"
        }

        "/cellphone_recharge/suggested_phones"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            from = "/sidebar_taladro"
        }
        "/cellphone_recharge/second_password"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/phone_income"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            status = "approved"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            status = "pending"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            status = "rejected"
        }
        "/cellphone_recharge/companies"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/checkout"(platform: "/web/desktop", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/amounts"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/amount_recommended"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/alias_income"(platform: "/web/mobile", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/account_money"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/error"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/not-found"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }

    }


}