package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative = "1104" // Completar

    propertyDefinitions {
    	purchase_status(required: true, type: PropertyType.String, description: "Purchase status")
    	purchases_flow(required: true, type: PropertyType.String, description: "Flow identification to know if it is the new or old flow")
    	checkout_flow(required: false, type: PropertyType.String, values: ["pack", "order"], description: "cart (pack) or direct (order) purchase")
        garex(required: false, type: PropertyType.String, values: ["yes", "no"], description: "the type of extended warranty of this purchase")
        vertical_case_id(required: true, type: PropertyType.String, description: "Case identified for the purchase status")
        vertical_sub_case_id(required: false, type: PropertyType.String, description: "Sub case identified for the purchase status")
        x_mc_request_id(required: true, type: PropertyType.String, description: "Session id for this purchase")
        purchase_id(required: true, type: PropertyType.Numeric, description: "The id of the purchase selected")
        pack_id(required: false, type: PropertyType.Numeric, description: "The id of the pack selected")
        order_id(required: false, type: PropertyType.Numeric, description: "The id of the order selected")
        label(required: false, type: PropertyType.String, description: "The action that was tracked")
    }

    propertyGroups {
        newPurchasesGroup(purchases_flow, purchase_status, checkout_flow, garex, vertical_case_id, vertical_sub_case_id, x_mc_request_id, purchase_id, pack_id, order_id)
        newPurchasesEventGroup(label, x_mc_request_id, vertical_case_id, vertical_sub_case_id)
    }

    // BASE PATH FOR MY PURCHASES

    "/my_purchases"(platform:"/", isAbstract: true) {}

    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES STATUS
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/status"(platform:"/", type: TrackType.View) {
        newPurchasesGroup
    }
}