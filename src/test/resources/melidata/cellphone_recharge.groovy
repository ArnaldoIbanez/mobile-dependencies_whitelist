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

        "/cellphone_recharge/categories"(platform: "/mobile") {

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

        "/cellphone_recharge/contingency"(platform: "/mobile", type: TrackType.View) {
            company_id = "1"
        }

        "/cellphone_recharge/understood_contingency"(platform: "/mobile", type: TrackType.Event) {
            company_id = "1"
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
        "/set_telephone_number/blacklist"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/invalid_country_code"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/missing_area_code"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/invalid_area_code"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/missing_phone_number"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/invalid_phone_number"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/short_phone_number"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/long_phone_number"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/invalid_sum_up"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/unknown"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/contacts_invalid"(platform: "/mobile") {
            category = "CONTACTS_ERROR"
        }

        // Recharge Marketing Landing
        "/cellphone_recharge/mkt_landing"(platform: "/"){
            campaign = 'generic'
        }
        "/cellphone_recharge/mkt_landing/sms"(platform: "/web"){
            campaign = 'generic'
        } 
        "/cellphone_recharge/mkt_landing/copy-clipboard"(platform: "/web"){
            campaign = 'generic'
            position = "coupon"
        } 
        "/cellphone_recharge/mkt_landing/copy-clipboard"(platform: "/web"){
            campaign = 'generic'
            position = "steps"
        } 
        "/cellphone_recharge/mkt_landing/button"(platform: "/"){
            campaign = 'generic'
            position = "hero"
        } 
        "/cellphone_recharge/mkt_landing/button"(platform: "/"){
            campaign = 'generic'
            position = "fixed"
        } 
        "/cellphone_recharge/mkt_landing/button"(platform: "/"){
            campaign = 'generic'
            position = "footer"
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

        "/cellphone_recharge/categories"(platform: "/mobile") {

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

        "/cellphone_recharge/contingency"(platform: "/mobile", type: TrackType.View) {
            company_id = "1"
        }

        "/cellphone_recharge/understood_contingency"(platform: "/mobile", type: TrackType.Event) {
            company_id = "1"
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


        "/set_telephone_number/blacklist"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/invalid_country_code"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/missing_area_code"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/invalid_area_code"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/missing_phone_number"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/invalid_phone_number"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/short_phone_number"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/long_phone_number"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/invalid_sum_up"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/set_telephone_number/unknown"(platform: "/mobile") {
            category = "VALIDATOR_ERROR"
        }
        "/contacts_invalid"(platform: "/mobile") {
            category = "CONTACTS_ERROR"
        }

        // Recharge Marketing Landing
        "/cellphone_recharge/mkt_landing"(platform: "/"){
            campaign = "generic"
        }
        "/cellphone_recharge/mkt_landing"(platform: "/"){
            campaign = "personal"
        }
        "/cellphone_recharge/mkt_landing/sms"(platform: "/web"){
            campaign = "generic"
        } 
        "/cellphone_recharge/mkt_landing/copy-clipboard"(platform: "/web"){
            campaign = "generic"
            position = "coupon"
        } 
        "/cellphone_recharge/mkt_landing/copy-clipboard"(platform: "/web"){
            campaign = "generic"
            position = "steps"
        } 
        "/cellphone_recharge/mkt_landing/button"(platform: "/"){
            campaign = "generic"
            position = "hero"
        } 
        "/cellphone_recharge/mkt_landing/button"(platform: "/"){
            campaign = "generic"
            position = "fixed"
        } 
        "/cellphone_recharge/mkt_landing/button"(platform: "/"){
            campaign = "generic"
            position = "footer"
        } 
    }
}