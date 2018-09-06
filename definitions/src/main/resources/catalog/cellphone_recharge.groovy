import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/cellphone_recharge"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    
    "/cellphone_recharge/recents"(platform: "/mobile") {}
    "/cellphone_recharge/set_telephone_number"(platform: "/mobile") {}
    "/cellphone_recharge/contacts"(platform: "/mobile") {}
    "/cellphone_recharge/carriers"(platform: "/mobile") {}
    "/cellphone_recharge/recommended"(platform: "/mobile") {}
    "/cellphone_recharge/packages"(platform: "/mobile") {}
    "/cellphone_recharge/carrier_disabled"(platform: "/mobile") {}
    "/cellphone_recharge/terms_and_conditions"(platform: "/mobile") {} 

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
}