package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1315"

    Object attributes_values_map = objectSchemaDefinitions {
        brand(type: PropertyType.String, required: false, description: "Attribute Item brand")
        model(type: PropertyType.String, required: false, description: "Attribute Item model")
        year(type: PropertyType.String, required: false, description: "Attribute Item year")
    }

    propertyDefinitions {
        bank(
                required: true,
                type: PropertyType.String,
                description: "bank identifier",
                values: [
                        "caixa",
                        "santander",
                        "banco_do_brasil",
                        "bradesco",
                        "itau",
                        "votorantim",
                        "not_specified",
                ]
        )
        domain_id(required: false, type: PropertyType.String, description: "Id of the product")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: true, type: PropertyType.ArrayList, description: "Item's category tree", serverSide: true)
        city(required: false, type: PropertyType.String, description: "Item city name")
        flow_type(
                required: false,
                type: PropertyType.String,
                description: "Bank flow type",
                values: [
                        "INVALID",
                        "C2FREE_ITAU",
                        "PACC",
                        "CORBAN_ITAU",
                ]
        )
        item_condition(required: false, type: PropertyType.String, description: "Indicates whether the item is new, used or refurbished", values: ["new", "used", "refurbished", "not_specified"])
        item_id(required: true, type: PropertyType.String, description: "Item id")
        item_seller_type(required: false, type: PropertyType.String, description: "Seller type: normal, real_estate_user, etc", values: ["branch", "brand", "car_dealer", "franchise", "normal", "real_estate_agency"])
        map_item_attributes(required: false, type: PropertyType.ArrayList(PropertyType.Map(attributes_values_map)), description: "Map of items attributes")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        vertical(required: true, type: PropertyType.String, values: ["core", "motors", "realEstate", "services", "none"], description: "Vertical of the item")
    }

    propertyGroups {
        vis_credits_required(
                bank,
                category_id,
                category_path,
                item_id,
                seller_id,
                vertical
        )
        vis_credits_optional(
                city,
                domain_id,
                flow_type,
                item_condition,
                item_seller_type,
                map_item_attributes
        )
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/vis_credits"(platform: "/", isAbstract: true) {}
    "/vis_credits/application_form"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Vis Credits
     ******************************************/
    // Page-views
    "/vis_credits/pre_analysis"(platform: "/", type: TrackType.View) {
        vis_credits_required
        vis_credits_optional
    }

    "/vis_credits/simulator"(platform: "/", type: TrackType.View) {
        vis_credits_required
        vis_credits_optional
    }

    "/vis_credits/simulation_details"(platform: "/", type: TrackType.View) {
        vis_credits_required
        vis_credits_optional
    }

    "/vis_credits/application_form/step_1"(platform: "/", type: TrackType.View) {
        vis_credits_required
        vis_credits_optional
    }

    "/vis_credits/application_form/step_2"(platform: "/", type: TrackType.View) {
        vis_credits_required
        vis_credits_optional
    }

    "/vis_credits/application_form/step_3"(platform: "/", type: TrackType.View) {
        vis_credits_required
        vis_credits_optional
    }

    "/vis_credits/application_form/step_4"(platform: "/", type: TrackType.View) {
        vis_credits_required
        vis_credits_optional
    }

    "/vis_credits/congrats"(platform: "/", type: TrackType.View) {
        congrats_status(required: true, type: PropertyType.String, description: "Status credits", values: ["APPROVED", "IN_ANALYSIS", "REJECTED", "ERROR", "PRE_ANALYSIS_REJECTED", "PRE_ANALYSIS_ERROR"])
        context( required: false, type: PropertyType.String, description: "Context of type of approve in congrats" , values: ["high_score", "high_score"])
        error(required: false, type: PropertyType.String, description: "Error that was shown to the user")
        vis_credits_required
        vis_credits_optional
    }

    "/vis_credits/not_found"(platform: "/", type: TrackType.View) {
        error(required: false, type: PropertyType.String, description: "Error that was shown to the user")
        vis_credits_required
        vis_credits_optional
    }

    "/vis_credits/error"(platform: "/", type: TrackType.View) {
        error(required: false, type: PropertyType.String, description: "Error that was shown to the user")
        vis_credits_required
        vis_credits_optional
    }
    /******************************************
     *       End: Vis Credits
     ******************************************/
}
