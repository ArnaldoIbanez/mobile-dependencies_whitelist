import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1131"

    //Digital Goods
    "/digital_goods"(platform: "/mobile", isAbstract: true) {
        flow(required: true, type: PropertyType.String, description: "Use case that has been executed")
        from(required: false, type: PropertyType.String, description: "Where the flow start")
        session_id(required: false, type: PropertyType.String, description: "Session Id of flow")
    }
    "/digital_goods/list"(platform: "/mobile") {}
    "/digital_goods/no_money"(platform: "/mobile") {}
    "/digital_goods/search_entities"(platform: "/mobile") {}
    "/digital_goods/products"(platform: "/mobile") {
        type(required: true, type: PropertyType.String, description: "Option")
    }
    "/digital_goods/px_payment_method_search"(platform: "/mobile") {}
    "/digital_goods/px_discount_summary"(platform: "/mobile") {}
    "/digital_goods/px_card_vault"(platform: "/mobile") {}
    "/digital_goods/px_card_number"(platform: "/mobile") {}
    "/digital_goods/px_card_holder_name"(platform: "/mobile") {}
    "/digital_goods/px_card_expiry_date"(platform: "/mobile") {}
    "/digital_goods/px_card_security_code"(platform: "/mobile") {}
    "/digital_goods/px_identification_number"(platform: "/mobile") {}
    "/digital_goods/px_card_issuers"(platform: "/mobile") {}
    "/digital_goods/px_card_installments"(platform: "/mobile") {}
    "/digital_goods/px_review_and_confirm"(platform: "/mobile") {}
    "/digital_goods/px_result"(platform: "/mobile") {
        result_status(required: true, type: PropertyType.String, description: "Operation result status")
        status_detail(required: false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/digital_goods/terms_and_conditions"(platform: "/mobile") {}
    "/digital_goods/recommended_click"(platform: "/mobile", type: TrackType.Event) {}
}