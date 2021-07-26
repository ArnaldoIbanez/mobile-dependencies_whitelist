package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative = "1323"

    propertyDefinitions {

        seller(required: true, type: PropertyType.Map, description: "Object that represent seller id")
        // meli_id

        context(required: true, type: PropertyType.String, description: "Action that represent open navigation or logout from any screen")
        // picking_product
        // stagein_location
        // stagein_parcel
        // auth

        error(required: true, type: PropertyType.String, description: "Type of error")
        // validation_error
        // failure_scan
        // parcel_not_found
        // stage_not_found
        // wrong_conservation
        // wrong_logistic_center
        // wrong_parcel_status
        // no_permission

        available_sections(required: true, type: PropertyType.ArrayList, description: "Availables sections in the app")
        // picking
        // stagein

        label(required: true, type: PropertyType.String, description: "Detail for the event action")
        // path
        // route_sheet
        // nfe

        pickup(required: true, type: PropertyType.Map, description: "Object that represent the pack order")
        // id
        // wave_id

        scan_mode(required: true, type: PropertyType.String, description: "Type of the scan device")
        // handheld
        // camera
        // none

        measure(required: true, type: PropertyType.String, description: "Unit of measure to calculate the quantity of product")
        // unit
        // kg
        // g
        // ml

        finish_enabled(required: true, type: PropertyType.Boolean, description: "Status true when the picked is finished")
        items_total(required: true, type: PropertyType.Numeric, description: "Total items in the pack")
        items_found(required: true, type: PropertyType.Numeric, description: "Total found items in the pack")
        items_not_found(required: true, type: PropertyType.Numeric, description: "Total not found items in the pack")
        item_id(required: true, type: PropertyType.String, description: "Id item")
        variation_id(required: true, type: PropertyType.String, description: "Id variation item")
        page(required: true, type: PropertyType.Numeric, description: "Number of the page the user is on")
        page_count(required: true, type: PropertyType.Numeric, description: "Number of the total pages in the backlog")
        filters(required: true, type: PropertyType.ArrayList, description: "Object that represent the filters implemented in the list")
    }

    propertyGroups {
        error_data(seller, context, error)
        home_data(seller, available_sections)
        label_data(label)
        context_data(context)
        picking_data(pickup)
        pickup_list(finish_enabled, items_total, items_found, items_not_found)
        picked_list(items_total, items_found, items_not_found)
        product_scan(item_id, variation_id, scan_mode, items_total, items_found)
        scan_mode_data(scan_mode)
        product_weight_or_unit(item_id, variation_id, scan_mode, measure, items_total)
        product_quantity(item_id, variation_id, measure, items_total)
        product_not_found_or_less_units(item_id, variation_id)
        seller_data(seller)
        oms_list(page, page_count, filters)
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // BASE PATH FOR PREPARATION APP
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/prepapp"(platform:"/", isAbstract: true) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PREPARATION APP GENERAL
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/prepapp/splash"(platform:"/", type: TrackType.View) {
    }

    "/prepapp/enter"(platform:"/", type: TrackType.View) {
    }

    "/prepapp/auth"(platform:"/", type: TrackType.View) {
    }

    "/prepapp/error"(platform:"/", type: TrackType.View) {
        error_data
    }

    "/prepapp/home"(platform:"/", type: TrackType.View) {
        home_data
    }

    "/prepapp/navigation/open"(platform:"/", type: TrackType.Event) {
        label_data
    }

    "/prepapp/navigation/log_out"(platform:"/", type: TrackType.Event) {
        label_data
    }

    "/prepapp/success"(platform:"/", type: TrackType.View) {
        context_data
    }

    "/prepapp/cancelled"(platform:"/", type: TrackType.View) {
        context_data
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PREPARATION APP PICKING SECTION
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/prepapp/picking"(platform:"/", type: TrackType.View) {
        picking_data
    }

    "/prepapp/picking/get_pickup"(platform:"/", type: TrackType.View) {
    }

    "/prepapp/picking/summary"(platform:"/", type: TrackType.View) {
    }

    "/prepapp/picking/pickup_list"(platform:"/", type: TrackType.View) {
        pickup_list
    }

    "/prepapp/picking/pickup_list/filter_pending"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
    }

    "/prepapp/picking/pickup_list/filter_not_found"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
    }

    "/prepapp/picking/picked_list"(platform:"/", type: TrackType.View) {
        picked_list
    }

    "/prepapp/picking/product/scan"(platform:"/", type: TrackType.View) {
        product_scan
    }

    "/prepapp/picking/product/input"(platform:"/", type: TrackType.View) {
        scan_mode_data
    }

    "/prepapp/picking/product/weight"(platform:"/", type: TrackType.View) {
        product_weight_or_unit
    }

    "/prepapp/picking/product/unit"(platform:"/", type: TrackType.View) {
        product_weight_or_unit
    }

    "/prepapp/picking/product/quantity"(platform:"/", type: TrackType.View) {
        product_quantity
    }

    "/prepapp/picking/parcel/scan"(platform:"/", type: TrackType.View) {
        scan_mode_data
    }

    "/prepapp/picking/parcel/input"(platform:"/", type: TrackType.View) {
        scan_mode_data
    }

    "/prepapp/picking/product/not_found"(platform:"/", type: TrackType.View) {
        product_not_found_or_less_units
    }

    "/prepapp/picking/product/less_units"(platform:"/", type: TrackType.View) {
        product_not_found_or_less_units
    }

    "/prepapp/picking/no_pickup"(platform:"/", type: TrackType.View, parentPropertiesInherited: false) {
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PREPARATION APP STAGE IN SECTION
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/prepapp/stagein"(platform:"/", type: TrackType.View) {
        seller_data
    }

    "/prepapp/stagein/parcel/scan"(platform:"/", type: TrackType.View) {
        scan_mode_data
    }

    "/prepapp/stagein/parcel/input"(platform:"/", type: TrackType.View) {
        scan_mode_data
    }

    "/prepapp/stagein/location/scan"(platform:"/", type: TrackType.View) {
        scan_mode_data
    }

    "/prepapp/stagein/location/input"(platform:"/", type: TrackType.View) {
        scan_mode_data
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PREPARATION APP ORDER MANAGEMENT SYSTEM
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/prepapp/oms"(platform:"/", type: TrackType.View) {
        seller_data
    }

    "/prepapp/oms/backlog"(platform:"/", type: TrackType.View) {
        oms_list
    }

    "/prepapp/oms/backlog/filter"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
    }

    "/prepapp/oms/backlog/download"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
    }

    "/prepapp/oms/backlog/prioritize"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
    }

    "/prepapp/oms/routes"(platform:"/", type: TrackType.View) {
        oms_list
    }

    "/prepapp/oms/routes/delete"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
    }

    "/prepapp/oms/routes/print"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        label_data
    }

    "/prepapp/oms/routes/upload"(platform:"/", type: TrackType.View) {
    }
}