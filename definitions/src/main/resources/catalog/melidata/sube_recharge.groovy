import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

"/recharge_sube"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
        session_id (required:false, type: PropertyType.String, description: "Session Id of flow")
    }
    "/recharge_sube/first_time_use"(platform: "/mobile") {}
    "/recharge_sube/no_money"(platform: "/mobile") {}
    "/recharge_sube/choose_amount_information"(platform: "/mobile") {}
    "/recharge_sube/localization"(platform: "/mobile") {}
    "/recharge_sube/localization_permission"(platform: "/mobile") {}
    "/recharge_sube/select_recharge_card"(platform: "/mobile") {}
    "/recharge_sube/information"(platform: "/mobile") {}
    "/recharge_sube/add_bus_card"(platform: "/mobile") {}
    "/recharge_sube/add_card_name"(platform: "/mobile") {}
    "/recharge_sube/choose_amount"(platform: "/mobile") {}
    "/recharge_sube/second_password"(platform: "/mobile") {}
    "/recharge_sube/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
    }
    "/recharge_sube/px_payment_method_search"(platform: "/mobile") {}
    "/recharge_sube/px_discount_summary"(platform: "/mobile") {}
    "/recharge_sube/px_card_vault"(platform: "/mobile") {}
    "/recharge_sube/px_card_number"(platform: "/mobile") {}
    "/recharge_sube/px_card_holder_name"(platform: "/mobile") {}
    "/recharge_sube/px_card_expiry_date"(platform: "/mobile") {}
    "/recharge_sube/px_card_security_code"(platform: "/mobile") {}
    "/recharge_sube/px_identification_number"(platform: "/mobile") {}
    "/recharge_sube/px_card_issuers"(platform: "/mobile") {}
    "/recharge_sube/px_card_installments"(platform: "/mobile") {}
    "/recharge_sube/px_review_and_confirm"(platform: "/mobile") {}
    "/recharge_sube/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/recharge_sube/redirect_sube_app"(platform: "/mobile", type: TrackType.Event) {}
    "/recharge_sube/show_terminals_information"(platform: "/mobile", type: TrackType.Event) {}
    "/recharge_sube/show_terminals_congrats"(platform: "/mobile", type: TrackType.Event) {}
    "/recharge_sube/show_terminals_ftu"(platform: "/mobile", type: TrackType.Event) {}

}