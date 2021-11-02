package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Vendor Central - TaxManager
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/1P_TAX_MANAGER/PROCESS/SAP/RETURN/SUCCESS"(platform: "/web", type: TrackType.Event) {
        sku(required: true, type: PropertyType.String, description: "this property indicates the sku")
        site_id(required: true, type: PropertyType.String, description: "this property indicates the site_id")
        sap_user_id(required: true, type: PropertyType.String, description: "this property indicates the sap_user_id")
    }
    "/1P_TAX_MANAGER/PROCESS/SAP/RETURN/FAIL"(platform: "/web", type: TrackType.Event) {
        sku(required: true, type: PropertyType.String, description: "this property indicates the sku")
        site_id(required: true, type: PropertyType.String, description: "this property indicates the site_id")
        sap_user_id(required: true, type: PropertyType.String, description: "this property indicates the sap_user_id")
    }
    "/1P_TAX_MANAGER/PRE_PROCESS/CONFLICT_CREATION"(platform: "/web", type: TrackType.Event) {
        sku(required: true, type: PropertyType.String, description: "this property indicates the sku")
        site_id(required: true, type: PropertyType.String, description: "this property indicates the site_id")
        sap_user_id(required: true, type: PropertyType.String, description: "this property indicates the sap_user_id")
        site_conflict(required: true, type: PropertyType.Boolean, description: "this property indicates the site_conflict")
        combination_conflict(required: true, type: PropertyType.Boolean, description: "this property indicates the combination_conflict")
    }
    "/1P_TAX_MANAGER/PROCESS/SAP/RETURN_SPREADSHEET/SUCCESS"(platform: "/web", type: TrackType.Event) {
        sku(required: true, type: PropertyType.String, description: "this property indicates the sku")
        site_id(required: true, type: PropertyType.String, description: "this property indicates the site_id")
        sap_user_id(required: true, type: PropertyType.String, description: "this property indicates the sap_user_id")
    }
    "/1P_TAX_MANAGER/PRE_PROCESS/TAX_COMBINATION"(platform: "/web", type: TrackType.Event) {
        sku(required: true, type: PropertyType.String, description: "this property indicates the sku")
        site_id(required: true, type: PropertyType.String, description: "this property indicates the site_id")
        sap_user_id(required: true, type: PropertyType.String, description: "this property indicates the sap_user_id")
    }
}
