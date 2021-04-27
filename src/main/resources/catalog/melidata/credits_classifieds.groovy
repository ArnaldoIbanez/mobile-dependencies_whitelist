package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1206"

    propertyDefinitions {
        vertical(required: true, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        item_id(required: true, type: PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: false, type: PropertyType.Numeric, description: "Buyer id")
        flow_type(
            required: false,
            type: PropertyType.String,
            description: "Bank flow type",
            values: [
                "INVALID",
                "C2FREE_ITAU",
                "PACC",
            ]
        )
        bank(
            type: PropertyType.String,
            required: true,
            inheritable: false,
            description: "bank identifier",
            values: [
                "caixa",
                "santander",
                "banco_do_brasil",
                "bradesco",
                "itau",
                "votorantim",
                "not_specified"
            ]
        )
        congrats_status(required: false, type: PropertyType.String, description: "Status credits", values: ["APPROVED", "IN_ANALYSIS", "REJECTED", "ERROR", "PRE_ANALYSIS_REJECTED", "PRE_ANALYSIS_ERROR"])
        category_path(required: true, type: PropertyType.ArrayList, description: "Item's category tree", serverSide: true) // -> Lo completa Melidata automaticamente
        errors( required: false, type: PropertyType.ArrayList(PropertyType.String), description: "error fallback banks")
        item_seller_type(required: false, type: PropertyType.String, description: "Seller Type", values: ["branch", "brand", "car_dealer", "franchise", "normal","real_estate_agency"])
    }

    propertyGroups {
        creditGroup(vertical, seller_id, item_id, category_id, buyer_id, flow_type, bank, congrats_status, errors, item_seller_type, category_path)
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/classi_credits"(platform: "/", isAbstract: true) {}
    "/classi_credits/application_form"(platform: "/", isAbstract: true) {}
    "/classi_credits/evaluation"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Classifieds Credits
     ******************************************/
    //Page-views

    "/classi_credits/pre_analysis"(platform: "/", type: TrackType.View) {
        creditGroup
    }

    "/classi_credits/simulator"(platform: "/", type: TrackType.View) {
        creditGroup
    }

    "/classi_credits/simulation_details"(platform: "/", type: TrackType.View) {
        creditGroup
    }

    "/classi_credits/application_form/step_1"(platform: "/", type: TrackType.View) {
        creditGroup
    }

    "/classi_credits/application_form/step_2"(platform: "/", type: TrackType.View) {
        creditGroup
    }

    "/classi_credits/application_form/step_3"(platform: "/", type: TrackType.View) {
        creditGroup
    }

    "/classi_credits/application_form/step_4"(platform: "/", type: TrackType.View) {
        creditGroup
    }

    "/classi_credits/evaluation/congrats"(platform: "/", type: TrackType.View) {
        creditGroup
    }

    "/classi_credits/evaluation/reject"(platform: "/", type: TrackType.View) {
        creditGroup
    }

    "/classi_credits/container_congrats"(platform: "/", type: TrackType.View) {
        creditGroup
    }

    /******************************************
     *       End: Classifieds Credits
     ******************************************/
}
