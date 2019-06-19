import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks


tracks {

    def propertyCampaignDetail  = objectSchemaDefinitions {
        source(required: false, type: PropertyType.String, description:  "indicates the component that starts capaign")
        brand(required: false, type: PropertyType.String, description:  "brands associated to capamign")
    }

    def propertyActionDetail  = objectSchemaDefinitions {
        tag(required: false, type: PropertyType.String, description:  "brands to filter")
    }

    /**
    * INSTORES Screen Tracks
    */

    "/instore"(platform: "/mobile", isAbstract: true) {
        session_id(required: true, PropertyType.String, description: "a unique identifier to track the users flow through the app since they enters the view until they exist")
        new_session(required: false, PropertyType.Boolean, description: "indicates if a new session_id was created")
    }


    // Scan QR
    "/instore/scan_qr"(platform: "/mobile", type: TrackType.View) {
        camera_permissions(required: false, PropertyType.Boolean)
        location_permissions(required: false, PropertyType.Boolean)
        notification_permissions(required: false, PropertyType.Boolean)
        bluetooth_permissions(required: false, PropertyType.Boolean)
        qr_data(required: false, PropertyType.String)

        camera_flash(required: false, PropertyType.Boolean)
        view_time_in_millis(required: false, PropertyType.String)
    }
    "/instore/scan_qr/qr_discovery"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/scan_qr/qr_resolved"(platform: "/mobile", type: TrackType.Event) {
        qr_data(required: false, PropertyType.String)
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        success(required: false, PropertyType.Boolean)
        next_step_deeplink(required: false, PropertyType.String)
        currency(required: false, PropertyType.String)
        status_code(required: false, PropertyType.Numeric, description: "error code sent when resolve service fail")
    }
    "/instore/scan_qr/flash"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/scan_qr/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/scan_qr/help"(platform: "/mobile", type: TrackType.Event) {}
	"/instore/scan_qr/back"(platform: "/mobile", type: TrackType.Event) {}


    // Amount
    "/instore/amount"(platform: "/mobile", isAbstract: true) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/amount/calculator"(platform: "/mobile", type: TrackType.View) {}
    "/instore/amount/calculator/back"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/amount/price_list"(platform: "/mobile", type: TrackType.View) {
        available_prices(required: false, PropertyType.String)
        available_prices(required: false, PropertyType.ArrayList)
        visible_prices(required: false, PropertyType.Numeric)
    }
    "/instore/amount/price_list/back"(platform: "/mobile", type: TrackType.Event) {}


    // Generic Error
    "/instore/error"(platform: "/mobile", isAbstract: true) {
        collector_id(required: false, PropertyType.String, description: "collector user unique identifier")
        brand_name(required: false, PropertyType.String, description: "collector brand name")
        store_id(required: false, PropertyType.String, description: "collector store unique identifier")
        pos_id(required: false, PropertyType.String, description: "collector point of sale unique identifier")
        qr_data(required: false, PropertyType.String, description: "data scanned on the payment flow")
    }

    "/instore/error/unrecognized_qr_code"(platform: "/mobile", type: TrackType.View) {}
    "/instore/error/unrecognized_qr_code/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/unrecognized_qr_code/abort"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/error/something_went_wrong"(platform: "/mobile", type: TrackType.View) {}
    "/instore/error/something_went_wrong/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/something_went_wrong/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/something_went_wrong/retry"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/error/gas_station_cant_process_qr_payment"(platform: "/mobile", type: TrackType.View) {}
    "/instore/error/gas_station_cant_process_qr_payment/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/gas_station_cant_process_qr_payment/abort"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/error/cant_pay_to_yourself"(platform: "/mobile", type: TrackType.View) {}
    "/instore/error/cant_pay_to_yourself/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/cant_pay_to_yourself/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/cant_pay_to_yourself/retry"(platform: "/mobile", type: TrackType.Event) {
        qr_data(required: true, PropertyType.String)
    }

    "/instore/error/payment_timeout"(platform: "/mobile", type: TrackType.View) {}
    "/instore/error/payment_timeout/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/payment_timeout/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/payment_timeout/retry"(platform: "/mobile", type: TrackType.Event) {
        qr_data(required: true, PropertyType.String)
    }

    "/instore/error/cant_pay_in_different_sites"(platform: "/mobile", type: TrackType.View) {}
    "/instore/error/cant_pay_in_different_sites/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/cant_pay_in_different_sites/abort"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/error/gas_station_pumping_not_started"(platform: "/mobile", type: TrackType.View) {}
    "/instore/error/gas_station_pumping_not_started/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/gas_station_pumping_not_started/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/gas_station_pumping_not_started/try_again"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/error/cant_resolve_qr"(platform: "/mobile", type: TrackType.Event) {
        error(required: true, PropertyType.String, description: "error type", inheritable: false)
    }
    "/instore/error/cant_resolve_qr/retry"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/error/cant_start_checkout"(platform: "/mobile", type: TrackType.Event) {
        error(required: true, PropertyType.String, description: "error type", inheritable: false)
    }
    "/instore/error/cant_start_checkout/retry"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/error/cant_get_waiting_preference"(platform: "/mobile", type: TrackType.Event) {
        error(required: true, PropertyType.String, description: "error type", inheritable: false)
    }
    "/instore/error/cant_get_waiting_preference/retry"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/error/cant_set_required_data"(platform: "/mobile", type: TrackType.Event) {
        error(required: true, PropertyType.String, description: "error type", inheritable: false)
    }
    "/instore/error/cant_set_required_data/retry"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/error/cant_execute_required_action"(platform: "/mobile", type: TrackType.Event) {
        error(required: true, PropertyType.String, description: "error type", inheritable: false)
    }

    // Permissions
    "/ask_device_permission"(platform: "/mobile", isAbstract: true) {
        session_id(required: false, PropertyType.String, description: "a unique identifier to track the users flow through the app since they enters the view until they exist")
        new_session(required: false, PropertyType.Boolean, description: "indicates if a new session_id was created")
        context(required: true, PropertyType.String, values: ["/instore", "/instore/map"])
    }

    "/ask_device_permission/location"(platform: "/mobile", type: TrackType.View) {
        location_permission_enabled(required: false, PropertyType.Boolean)
        device_gps_enabled(required: false, PropertyType.Boolean)
        type(required: false, PropertyType.String, description: "type of app launching the map")
        tags(required: false, PropertyType.ArrayList(PropertyType.String), description: "an array of strings used to know the type of stores to show on the map")
    }
    "/ask_device_permission/location/back"(platform: "/mobile", type: TrackType.Event) {}
    "/ask_device_permission/location/granted"(platform: "/mobile", type: TrackType.Event) {}
    "/ask_device_permission/location/rejected"(platform: "/mobile", type: TrackType.Event) {}

    "/ask_device_permission/bluetooth"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/ask_device_permission/bluetooth/back"(platform: "/mobile", type: TrackType.Event) {}
    "/ask_device_permission/bluetooth/granted"(platform: "/mobile", type: TrackType.Event) {}
    "/ask_device_permission/bluetooth/rejected"(platform: "/mobile", type: TrackType.Event) {}

    "/ask_device_permission/camera"(platform: "/mobile", type: TrackType.View) {}
    "/ask_device_permission/camera/back"(platform: "/mobile", type: TrackType.Event) {}
    "/ask_device_permission/camera/granted"(platform: "/mobile", type: TrackType.Event) {}
    "/ask_device_permission/camera/rejected"(platform: "/mobile", type: TrackType.Event) {}


    // Landing
    "/instore/qr_first_time_use"(platform: "/mobile", type: TrackType.View) {}
    "/instore/qr_first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/qr_first_time_use/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/qr_first_time_use/next"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/shell_first_time_use"(platform: "/mobile", type: TrackType.View) {}
    "/instore/shell_first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/shell_first_time_use/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/shell_first_time_use/next"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/landing"(platform: "/mobile", type: TrackType.View) {
        campaign(required: false, type: PropertyType.String, description: "the Campaign name send when user open landing campaign")
        campaign_details(required: false, PropertyType.Map(propertyCampaignDetail), description: "extra info about campaign like source")
    }
    "/instore/landing/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/landing/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/landing/next"(platform: "/mobile", type: TrackType.Event) {
        action(required: false, type: PropertyType.String, description: "the action name send when user select action")
        action_details(required: false, PropertyType.Map(propertyActionDetail), description: "extra info about action like tags")
    }


    // Waiting
    "/instore/waiting"(platform: "/mobile", isAbstract: true) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }

    "/instore/waiting/gas_jockey"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gas_jockey/next"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/waiting/gas_jockey/back"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/waiting/gas_add_card"(platform: "/mobile", type: TrackType.View) {
        skippable(required: false, PropertyType.Boolean, description: "indicates if the add card flow is mandatory")
    }
    "/instore/waiting/gas_add_card/add_card"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/waiting/gas_add_card/skip"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/waiting/gas_add_card/back"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/waiting/gas_pump"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gas_pump/next"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/waiting/gas_pump/back"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/waiting/gas_clock"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gas_clock/back"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/waiting/gastronomy_cashier"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gastronomy_cashier/next"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/waiting/gastronomy_cashier/back"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/waiting/gastronomy_order"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gastronomy_order/next"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/waiting/gastronomy_order/back"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/waiting/generic_cashier"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/generic_cashier/next"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/waiting/generic_cashier/back"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/waiting/generic_ticket"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/generic_ticket/next"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/waiting/generic_ticket/back"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/waiting/vending_product_selection"(platform: "/mobile", type: TrackType.View) {}


    // Shell
    "/instore/shell"(platform: "/mobile", isAbstract: true) {}
    "/instore/shell/pump_code"(platform: "/mobile", type: TrackType.View) {}
    "/instore/shell/pump_code_check"(platform: "/mobile", type: TrackType.Event) {
        pump_code(required: false, PropertyType.String)
        latitude(required: false, PropertyType.String)
        longitude(required: false, PropertyType.String)
    }
    "/instore/shell/pump_code_resolved"(platform: "/mobile", type: TrackType.Event) {
        pump_code(required: false, PropertyType.String)
        success(required: true, PropertyType.Boolean)
        next_step(required: true, PropertyType.String)
    }
    "/instore/shell/pump_code/abort"(platform: "/mobile", type: TrackType.Event) {}


    // Required action
    "/instore/data_required"(platform: "/mobile", isAbstract: true) {}
    "/instore/data_required/identification_number"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        data_key(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/data_required/identification_number/back"(platform: "/mobile", type: TrackType.Event) {}


    // Vending
    "/instore/vending"(platform: "/mobile", isAbstract: true) {
        collector_id(required: true, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        vending_id(required: true, PropertyType.String)
        external_reference(required: true, PropertyType.String)
        id(required: true, PropertyType.Numeric)
        status(required: true, PropertyType.String)
        status_detail(required: true, PropertyType.String)
        total_price(required: true, PropertyType.Numeric)
        currency(required: true, PropertyType.String)
    }
    "/instore/vending/machine_response_final_result"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/vending/machine_response_state"(platform: "/mobile", type: TrackType.Event) {
        machine_response_state(required: true, PropertyType.String)
    }
    "/instore/vending/st_machine_disconnected"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/vending/st_machine_connection_error"(platform: "/mobile", type: TrackType.Event) {
        st_machine_connection_error(required: true, PropertyType.String)
    }
    "/instore/vending/st_machine_not_available"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/vending/st_machine_connected"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/vending/response_end_transaction"(platform: "/mobile", type: TrackType.Event) {
        end_transaction_status(required: true, PropertyType.String)
        item_price(required: false, PropertyType.Numeric)
    }


    // Post Payment
    "/instore/post_payment"(platform: "/mobile", type: TrackType.Event) {
        currency_id(required: false, PropertyType.String)
        statement_descriptor(required: false, PropertyType.String)
        collector_id(required: false, PropertyType.String)
        status(required: false, PropertyType.String)
        payment_method_id(required: false, PropertyType.String)
        site_id(required: false, PropertyType.String)
        date_created(required: false, PropertyType.String)
        status_detail(required: false, PropertyType.String)
        operation_type(required: false, PropertyType.String)
        installments(required: false, PropertyType.Numeric)
        id(required: false, PropertyType.Numeric)
        payer_id(required: false, PropertyType.Numeric)
        collector(required: false, description: "collector information")
        issuer_id(required: false, PropertyType.Numeric)
        payer(required: false, description: "payer information")
        transaction_amount(required: false, PropertyType.Numeric)
        coupon_amount(required: false, PropertyType.Numeric)
        marketplace(required: false, PropertyType.String)
        external_reference(required: false, PropertyType.String)
        vending_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        total_price(required: false, PropertyType.Numeric)
        currency(required: false, PropertyType.String)
    }
    "/instore/payment_info"(platform: "/mobile", type: TrackType.Event) {
        payment_info_tag(required: false, "Execute post payment")
        remaining_attempts(required: false, PropertyType.Numeric)
    }


    // Discovery
    "/instore/map"(platform: "/mobile", type: TrackType.View) {
        location(required: false, inheritable: false, PropertyType.String, description: "a location coming from the deeplink")
        radius_in_meters(required: false, inheritable: false, PropertyType.Numeric, description: "a radius from the location in the deeplink from where to search for stores")
        type(required: true, inheritable: false, PropertyType.String, description: "type of stores to show on the map")
        tags(required: true, inheritable: false, PropertyType.ArrayList(PropertyType.String), description: "an array of strings used to know the type of stores to show on the map")
    }
    "/instore/map/first_user_location"(platform: "/mobile", type: TrackType.Event) {
        northeast(required: true, PropertyType.String, description: "latitude and longitude of the northeast corner of the visible area on the map")
        southwest(required: true, PropertyType.String, description: "latitude and longitude of the southwest corner of the visible area on the map")
        location(required: true, PropertyType.String)
    }
    "/instore/map/data_retrieved"(platform: "/mobile", type: TrackType.Event) {
        action_type(required: true, PropertyType.String, description: "type of action that triggered the data request", values: ["init", "search_in_this_area", "filters_applied", "text_search"])
        stores_quantity(required: true, PropertyType.String)
    }
    "/instore/map/pin_selected"(platform: "/mobile", type: TrackType.Event) {
        store_name(required: true, PropertyType.String, description: "the name of the selected store")
        store_id(required: true, PropertyType.String, description: "the store's id")
        store_location(required: true, PropertyType.String, description: "the stores lat and long")
    }
    "/instore/map/locate_by_gps"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/map/search_in_this_area"(platform: "/mobile", type: TrackType.Event) {
        northeast(required: true, PropertyType.String, description: "latitude and longitude of the northeast corner of the visible area on the map")
        southwest(required: true, PropertyType.String, description: "latitude and longitude of the southwest corner of the visible area on the map")
        tags(required: true, PropertyType.ArrayList(PropertyType.String), description: "an array of strings used to know the type of stores to show on the map")
        includes_user_position(required: true, PropertyType.Boolean)
        center(required: true, PropertyType.String)
    }
    "/instore/map/navigate_to_store"(platform: "/mobile", type: TrackType.Event) {
        store_name(required: true, PropertyType.String)
        store_location(required: true, PropertyType.String)
        navigation_apps(required: true, PropertyType.ArrayList(PropertyType.String), description: "all the apps available to handle the requested navigation")
    }
    "/instore/map/navigate_to_store_app_chosen"(platform: "/mobile", type: TrackType.Event) {
        store_name(required: true, PropertyType.String)
        store_location(required: true, PropertyType.String)
        navigation_apps(required: true, PropertyType.ArrayList(PropertyType.String))
        chosen_app(required: true, PropertyType.String)
        view_time_in_millis(required: true, PropertyType.String)
    }
    "/instore/map/quick_filters_selected"(platform: "/mobile", type: TrackType.Event) {
        selected_filters(required: true, PropertyType.ArrayList(PropertyType.String))
    }
    "/instore/map/back"(platform: "/mobile", type: TrackType.Event) {
        view_time_in_millis(required: true, PropertyType.String)
    }
    "/instore/map/error"(platform: "/mobile", isAbstract: true) {}
    "/instore/map/error/server_error"(platform: "/mobile", type: TrackType.View) {
        style(required: true, PropertyType.String, description: "how the error is presented to the user (screen, snackbar")
        id(required: true, PropertyType.String, description:"an identifer for the type of error")
        message(required: true, PropertyType.String, description: "server error description")
        attributable_to(required: true, PropertyType.String)
    }
    "/instore/my_qr"(platform: "/mobile", type: TrackType.Event) {}

    // Scale Features
    // QR Assignment
    
    "/instore"(platform:"/web", isAbstract:true) {}
    "/instore/scale_feature"(platform:"/web", isAbstract:true) {}
    "/instore/scale_feature/qr-assignment"(platform:"/web", isAbstract:true) {
        transaction_id (type: PropertyType.String, required: true, description:"UUID for transaction tracking")
    }
    "/instore/scale_feature/qr-assignment/start_process"(platform:"/web", type: TrackType.View) {}
    "/instore/scale_feature/qr-assignment/company_info"(platform:"/web", type: TrackType.View) {}
    "/instore/scale_feature/qr-assignment/store_info"(platform:"/web", type: TrackType.View) {}
    "/instore/scale_feature/qr-assignment/qr_camera"(platform:"/web", type: TrackType.View) {}
    "/instore/scale_feature/qr-assignment/success"(platform:"/web", type: TrackType.View) {
        status (type: PropertyType.String, required: true, description:"Store create status")
    }
    "/instore/scale_feature/qr-assignment/error"(platform:"/web", type: TrackType.View) {
       status (type: PropertyType.String, required: true, description: "Error Status, ex: invalidAccess, error")
    }

    "/instore/scale_feature/qr-assignment/validate_email"(platform:"/web", type: TrackType.Event) {
      valid (type: PropertyType.Boolean, required: true, description: "Ex: true or false")
    }
    "/instore/scale_feature/qr-assignment/fill_store_address"(platform:"/web", type: TrackType.Event) {
      get_address_method (type: PropertyType.String, required: true, description: "Ex: [text | gps | map]")
    }
    "/instore/scale_feature/qr-assignment/qr_scan"(platform:"/web", type: TrackType.Event) {
      qr_content (type: PropertyType.String, required: true, description: "Ex: http://qrContent")
    }

    //TODO this path will be deprecated in the next release where all show's track will unifique
    // Instore home sections
    "/instore/home_sections"(platform: "/mobile", isAbstract: true) {}
    "/instore/home_sections/promotion"(platform: "/mobile", isAbstract: true) {}
    "/instore/home_sections/promotion/generic"(platform: "/mobile", isAbstract: true) {}
    "/instore/home_sections/promotion/generic/show"(platform: "/mobile", type: TrackType.Event) {
        session_id(required: false, PropertyType.String, description: "suppress session_id for home_sections")
        header_title(required: true, PropertyType.String, description: "the title form endpoint or cache")
        link(required: true, PropertyType.String, description: "the deeplink recived form endpoint or cache")
        items(required: true, PropertyType.ArrayList(PropertyType.String), description: "the items recived form endpoint or cache")
        items_size(required: true, PropertyType.Numeric, description: "the size of items recived form endpoint or cache")
    }
    "/instore/home_sections/promotion/qr_map"(platform: "/mobile", isAbstract: true) {}
    "/instore/home_sections/promotion/qr_map/show"(platform: "/mobile", type: TrackType.Event) {
        session_id(required: false, PropertyType.String, description: "suppress session_id for home_sections")
        header_title(required: true, PropertyType.String, description: "the title form endpoint or cache")
        link(required: true, PropertyType.String, description: "the title form endpoint or cache")
        items(required: true, PropertyType.ArrayList(PropertyType.String), description: "the items recived form endpoint or cache")
        items_size(required: true, PropertyType.Numeric, description: "the size of items recived form endpoint or cache")
    }

}
