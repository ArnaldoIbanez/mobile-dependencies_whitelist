package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1131"

    "/cellphone_recharge"(platform: "/", isAbstract: true) {
        session_id (required:false, type: PropertyType.String, description: "Session Id of flow")
    }
    
    "/cellphone_recharge/recents"(platform: "/mobile") {}
    "/cellphone_recharge/set_telephone_number"(platform: "/mobile") {}
    "/cellphone_recharge/contacts"(platform: "/mobile") {}
    "/cellphone_recharge/carriers"(platform: "/mobile") {}
    "/cellphone_recharge/recommended"(platform: "/mobile") {}
    "/cellphone_recharge/packages"(platform: "/mobile") {}
    "/cellphone_recharge/carrier_disabled"(platform: "/mobile") {}
    "/cellphone_recharge/terms_and_conditions"(platform: "/mobile") {}
    "/cellphone_recharge/categories"(platform: "/mobile", type: TrackType.View) {}

    "/cellphone_recharge/px_payment_method_search"(platform: "/mobile") {}
    "/cellphone_recharge/px_discount_summary"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_vault"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_number"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_holder_name"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_expiry_date"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_security_code"(platform: "/mobile") {}
    "/cellphone_recharge/px_identification_number"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_issuers"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_installments"(platform: "/mobile") {}
    "/cellphone_recharge/px_review_and_confirm"(platform: "/mobile") {}
    "/cellphone_recharge/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }       

    "/cellphone_recharge/push_handler"(platform: "/mobile") {}
    "/cellphone_recharge/pay"(platform: "/mobile") {}
    "/cellphone_recharge/deals"(platform: "/mobile") {}
    "/cellphone_recharge/deals/terms"(platform: "/mobile") {}
    "/cellphone_recharge/payment_methods"(platform: "/mobile") {}
    "/cellphone_recharge/other_payment_methods"(platform: "/mobile") {}
    "/cellphone_recharge/cards"(platform: "/mobile") {}
    "/cellphone_recharge/add_card"(platform: "/mobile") {}
    "/cellphone_recharge/issuers"(platform: "/mobile") {}
    "/cellphone_recharge/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/cellphone_recharge/contingency"(platform: "/mobile", type: TrackType.View) {
        company_id (required: true, type: PropertyType.String, description: "Company with contingency")
    }

    "/cellphone_recharge/understood_contingency"(platform: "/mobile", type: TrackType.Event) {
        company_id (required: true, type: PropertyType.String, description: "Company with contingency")
    }

    "/cellphone_recharge/confirm"(platform: "/web"){}

    // Cellphone Recharge Frontend
    "/cellphone_recharge/suggested_phones"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/second_password"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/phone_income"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
        status (required:true, type: PropertyType.String, description: "Payment status (approved, pending, rejected)")
    }
    "/cellphone_recharge/companies"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/checkout"(platform: "/web/desktop", type: TrackType.View) {}
    "/cellphone_recharge/amounts"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/amount_recommended"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/alias_income"(platform: "/web/mobile", type: TrackType.View) {}
    "/cellphone_recharge/account_money"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/error"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/not-found"(platform: "/web", type: TrackType.View) {}

    // Recharge Marketing Performance landing 
    "/cellphone_recharge/mkt_landing"(platform: "/", type: TrackType.View, initiative: "1176") {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/cellphone_recharge/mkt_landing/sms"(platform: "/web", type: TrackType.Event) { 
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/cellphone_recharge/mkt_landing/copy-clipboard"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["coupon", "steps"], description: "Indicates position of copy button")
    }
    "/cellphone_recharge/mkt_landing/button"(platform: "/", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["hero", "fixed", "footer"], description: "Indicates position of button in landing")
    }

    "/set_telephone_number"(platform: "/mobile", isAbstract: true){
        category(required: true, type: PropertyType.String, description: "Event Category")
        label(required: false, type: PropertyType.String, description: "Optional Description")
    }
    "/set_telephone_number/blacklist"(platform: "/mobile", type: TrackType.Event) {}
    "/set_telephone_number/invalid_country_code"(platform: "/mobile", type: TrackType.Event) {}
    "/set_telephone_number/missing_area_code"(platform: "/mobile", type: TrackType.Event) {}
    "/set_telephone_number/invalid_area_code"(platform: "/mobile", type: TrackType.Event) {}
    "/set_telephone_number/missing_phone_number"(platform: "/mobile", type: TrackType.Event) {}
    "/set_telephone_number/invalid_phone_number"(platform: "/mobile", type: TrackType.Event) {}
    "/set_telephone_number/short_phone_number"(platform: "/mobile", type: TrackType.Event) {}
    "/set_telephone_number/long_phone_number"(platform: "/mobile", type: TrackType.Event) {}
    "/set_telephone_number/invalid_sum_up"(platform: "/mobile", type: TrackType.Event) {}
    "/set_telephone_number/unknown"(platform: "/mobile", type: TrackType.Event) {}
    "/contacts_invalid"(platform: "/mobile", type: TrackType.Event) {
        category(required: true, type: PropertyType.String, description: "Event Category")
        label(required: false, type: PropertyType.String, description: "Optional Description")
    }
}