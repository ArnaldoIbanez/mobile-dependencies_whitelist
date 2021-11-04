package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1015'

    "/tax_manager"(platform: "/", isAbstract: true) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Vendor Central - TaxManager
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/tax_manager/process"(platform: "/", isAbstract: true) {}
    "/tax_manager/process/sap"(platform: "/", isAbstract: true) {}
    "/tax_manager/process/sap/return"(platform: "/", isAbstract: true) {}

    "/tax_manager/process/sap/return/success"(platform: "/web", type: TrackType.Event) {
        sku(required: true, type: PropertyType.String, description: "this property indicates the sku")
        taxes_site_id(required: true, type: PropertyType.String, description: "this property indicates the site_id where taxes come from")
        sap_user_id(required: true, type: PropertyType.String, description: "this property indicates the sap_user_id")
    }

    "/tax_manager/process/sap/return/fail"(platform: "/web", type: TrackType.Event) {
        sku(required: true, type: PropertyType.String, description: "this property indicates the sku")
        taxes_site_id(required: true, type: PropertyType.String, description: "this property indicates the site_id where taxes come from")
        sap_user_id(required: true, type: PropertyType.String, description: "this property indicates the sap_user_id")
    }

    "/tax_manager/pre_process"(platform: "/", isAbstract: true) {}
    "/tax_manager/pre_process/conflict_creation"(platform: "/web", type: TrackType.Event) {
        sku(required: true, type: PropertyType.String, description: "this property indicates the sku")
        taxes_site_id(required: true, type: PropertyType.String, description: "this property indicates the site_id where taxes come from")
        sap_user_id(required: true, type: PropertyType.String, description: "this property indicates the sap_user_id")
        site_conflict(required: true, type: PropertyType.Boolean, description: "this property indicates the site_conflict")
        combination_conflict(required: true, type: PropertyType.Boolean, description: "this property indicates the combination_conflict")
    }

    "/tax_manager/process/sap/return_spreadsheet"(platform: "/", isAbstract: true) {}
    "/tax_manager/process/sap/return_spreadsheet/success"(platform: "/web", type: TrackType.Event) {
        sku(required: true, type: PropertyType.String, description: "this property indicates the sku")
        taxes_site_id(required: true, type: PropertyType.String, description: "this property indicates the site_id where taxes come from")
        sap_user_id(required: true, type: PropertyType.String, description: "this property indicates the sap_user_id")
    }

    "/tax_manager/pre_process/tax_combination"(platform: "/web", type: TrackType.Event) {
        sku(required: true, type: PropertyType.String, description: "this property indicates the sku")
        taxes_site_id(required: true, type: PropertyType.String, description: "this property indicates the site_id where taxes come from")
        sap_user_id(required: true, type: PropertyType.String, description: "this property indicates the sap_user_id")
    }
}
