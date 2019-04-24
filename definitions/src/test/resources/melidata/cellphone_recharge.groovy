package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Cellphone recharge") {
        "/cellphone_recharge"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/recents"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/set_telephone_number"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/contacts"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/carriers"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/recommended"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/packages"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/carrier_disabled"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/terms_and_conditions"(platform: "/mobile") {
           
        }

        "/cellphone_recharge/px_payment_method_search"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_discount_summary"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_vault"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_number"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_holder_name"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_expiry_date"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_security_code"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_identification_number"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_issuers"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_installments"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_review_and_confirm"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_result"(platform: "/mobile") {
            result_status = "rejected"
        }


"/cellphone_recharge/push_handler"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/pay"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/deals"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/deals/terms"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/payment_methods"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/other_payment_methods"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/cards"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/add_card"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/issuers"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/result"(platform: "/mobile") {
           
            result_status = "rejected"
            status_detail = "call_for_auth"
        }

        "/cellphone_recharge/confirm"(platform: "/web"){

        }

        "/cellphone_recharge/suggested_phones"(platform: "/web", type: TrackType.View) {
            
        }
        "/cellphone_recharge/second_password"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/phone_income"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {

            status = "approved"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {

            status = "pending"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {

            status = "rejected"
        }
        "/cellphone_recharge/companies"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/checkout"(platform: "/web/desktop", type: TrackType.View) {

        }
        "/cellphone_recharge/amounts"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/amount_recommended"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/alias_income"(platform: "/web/mobile", type: TrackType.View) {

        }
        "/cellphone_recharge/account_money"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/error"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/not-found"(platform: "/web", type: TrackType.View) {

        }
        "/set_telephone_number_invalid_country_code"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }

    }

    defaultBusiness = "mercadolibre"

    test("Cellphone recharge") {
        "/cellphone_recharge"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/recents"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/set_telephone_number"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/contacts"(platform: "/mobile") {
          
        }

        "/cellphone_recharge/carriers"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/recommended"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/packages"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/carrier_disabled"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/terms_and_conditions"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/px_payment_method_search"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_discount_summary"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_vault"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_number"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_holder_name"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_expiry_date"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_security_code"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_identification_number"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_issuers"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_card_installments"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_review_and_confirm"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/px_result"(platform: "/mobile") {
           
            result_status = "rejected"
        }

        "/cellphone_recharge/push_handler"(platform: "/mobile") {
            
        }

        "/cellphone_recharge/pay"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/deals"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/deals/terms"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/payment_methods"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/other_payment_methods"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/cards"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/add_card"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/issuers"(platform: "/mobile") {
            
        }
        "/cellphone_recharge/result"(platform: "/mobile") {
           
            result_status = "rejected"
            status_detail = "call_for_auth"
        }

        "/cellphone_recharge/confirm"(platform: "/web"){

        }

        "/cellphone_recharge/suggested_phones"(platform: "/web", type: TrackType.View) {
            
        }
        "/cellphone_recharge/second_password"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/phone_income"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {

            status = "approved"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {

            status = "pending"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {

            status = "rejected"
        }
        "/cellphone_recharge/companies"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/checkout"(platform: "/web/desktop", type: TrackType.View) {

        }
        "/cellphone_recharge/amounts"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/amount_recommended"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/alias_income"(platform: "/web/mobile", type: TrackType.View) {

        }
        "/cellphone_recharge/account_money"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/error"(platform: "/web", type: TrackType.View) {

        }
        "/cellphone_recharge/not-found"(platform: "/web", type: TrackType.View) {

        }

        "/set_telephone_number_invalid_country_code"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }






    }
}