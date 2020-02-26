import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1131"

    /**
    * Single Player Prepaid Tracks  
    */
    "/single_player"(platform: "/mobile", isAbstract: true) {}
    
    
    "/single_player/prepaid"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Name of the current flow")
        session_id (required: true, type: PropertyType.String, description: "Session id of the user")
    }


    // FTU
    "/single_player/prepaid/first_time_use"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/first_time_use/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Add device number
    "/single_player/prepaid/add_device_number"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/add_device_number/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/add_device_number/invalid_input"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        device_number(required: true, PropertyType.String, description: "Device number added by user")
    }
    "/single_player/prepaid/add_device_number/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/add_device_number/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Invalid input
    "/single_player/prepaid/invalid_input"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/invalid_input/retry"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Products
    "/single_player/prepaid/product_list"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/product_list/selected_product"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        item_id(required: true, PropertyType.String, description: "Id of the selected product")
    }


    // Recommended products
    "/single_player/prepaid/recommended_products"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/recommended_products/selected_product"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        item_id(required: true, PropertyType.String, description: "Id of the selected product")
    }
    "/single_player/prepaid/recommended_products/more_products"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        item_id(required: true, PropertyType.String, description: "Id of the item")
    }


    // Add alias
    "/single_player/prepaid/add_alias"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/add_alias/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/add_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        alias(required: true, PropertyType.String, description: "Alias added by user")
    }


    // Edit alias
    "/single_player/prepaid/edit_alias"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/edit_alias/confirm_edit"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/edit_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        alias(required: true, PropertyType.String, description: "Alias added by user")
    }
    "/single_player/prepaid/edit_alias/delete"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/edit_alias/confirm_delete"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/edit_alias/cancel_delete"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // One device
    "/single_player/prepaid/one_device"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/one_device/edit_alias"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/one_device/selected_product"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        item_id(required: true, PropertyType.String, description: "Id of the selected product")
    }
    "/single_player/prepaid/one_device/more_products"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        item_id(required: true, PropertyType.String, description: "Id of the item")
    }
    "/single_player/prepaid/one_device/another_device"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Multiple devices
    "/single_player/prepaid/multiple_devices"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/multiple_devices/selected_device"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        item_id(required: true, PropertyType.String, description: "Id of the selected device")
    }
    "/single_player/prepaid/multiple_devices/another_device"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Congrats success
    "/single_player/prepaid/congrats_success"(platform: "/mobile", type: TrackType.View) {}
    "/single_player/prepaid/congrats_success/show_receipt"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/congrats_success/add_alias"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/congrats_success/another_recharge"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/congrats_success/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/congrats_success/open_external_application"(platform: "/mobile", type: TrackType.Event) {
        application_name(required: true, PropertyType.String, description: "Name of the external application that was opened")
    }
    "/single_player/prepaid/congrats_success/credit_charge"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/congrats_success/show_terminals"(platform: "/mobile", type: TrackType.Event) {}


    // Congrats rejected
    "/single_player/prepaid/congrats_rejected"(platform: "/mobile", type: TrackType.View) {}
    "/single_player/prepaid/congrats_rejected/another_recharge"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/congrats_rejected/back_to_home"(platform: "/mobile", type: TrackType.Event) {}


    // Congrats pending
    "/single_player/prepaid/congrats_pending"(platform: "/mobile", type: TrackType.View) {}
    "/single_player/prepaid/congrats_pending/another_recharge"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/congrats_pending/back_to_home"(platform: "/mobile", type: TrackType.Event) {}


    // Congrats alias
    "/single_player/prepaid/congrats_alias"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/congrats_alias/another_recharge"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/congrats_alias/back_to_home"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Accreditation information
    "/single_player/prepaid/accreditation_information"(platform: "/mobile", type: TrackType.View) {}
    "/single_player/prepaid/accreditation_information/open_external_application"(platform: "/mobile", type: TrackType.Event) {
        application_name(required: true, PropertyType.String, description: "Name of the external application that was opened")
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/accreditation_information/show_terminals"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Errors
    "/single_player/prepaid/error"(platform: "/mobile", isAbstract: true) {}

    // Errors - Internal error
    "/single_player/prepaid/error/internal"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/error/internal/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/error/internal/back"(platform: "/mobile", type: TrackType.Event) {}


    // Errors - Server error
    "/single_player/prepaid/error/server"(platform: "/mobile", type: TrackType.View) {
        error_code(required: false, PropertyType.String, description: "Error code in server")
    }

    "/single_player/prepaid/error/server/back_to_home"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/error/server/back"(platform: "/mobile", type: TrackType.Event) {}


    // Errors - Connection error
    "/single_player/prepaid/error/connection"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/error/connection/retry"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/error/connection/back"(platform: "/mobile", type: TrackType.Event) {}


    // Shield
    "/single_player/prepaid/shield"(platform: "/mobile", type: TrackType.View) {}


    // Contingency
    "/single_player/prepaid/contingency"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/contingency/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/contingency/back"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/single_player/prepaid/contingency/abort"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
}
