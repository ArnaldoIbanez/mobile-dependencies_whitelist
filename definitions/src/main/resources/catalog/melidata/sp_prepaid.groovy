import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    /**
    * Single Player Prepaid Tracks 
    */

    "/sp_prepaid"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Name of the current flow")
        session_id (required: true, type: PropertyType.String, description: "Session id of the user")
    }


    // FTU
    "/sp_prepaid/first_time_use"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/first_time_use/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Add device number
    "/sp_prepaid/add_device_number"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/add_device_number/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/sp_prepaid/add_device_number/invalid_input"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        device_number(required: true, PropertyType.String, description: "Device number added by user")
    }
    "/sp_prepaid/add_device_number/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/sp_prepaid/add_device_number/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Products
    "/sp_prepaid/product_list"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/product_list/selected_product"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        item_id(required: true, PropertyType.String, description: "Id of the selected product")
    }


    // Recommended products
    "/sp_prepaid/recommended_product"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/recommended_product/selected_product"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        item_id(required: true, PropertyType.String, description: "Id of the selected product")
    }
    "/sp_prepaid/recommended_product/more_products"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Add alias
    "/sp_prepaid/add_alias"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/add_alias/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/sp_prepaid/add_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        alias(required: true, PropertyType.String, description: "Alias added by user")
    }


    // Edit alias
    "/sp_prepaid/edit_alias"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/edit_alias/confirm_edit"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/sp_prepaid/edit_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        alias(required: true, PropertyType.String, description: "Alias added by user")
    }
    "/sp_prepaid/edit_alias/delete"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/sp_prepaid/edit_alias/confirm_delete"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/sp_prepaid/edit_alias/cancel_delete"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // One device
    "/sp_prepaid/one_device"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/one_device/edit_alias"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/sp_prepaid/one_device/selected_product"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        item_id(required: true, PropertyType.String, description: "Id of the selected product")
    }
    "/sp_prepaid/one_device/more_products"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/sp_prepaid/one_device/another_device"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Multiple devices
    "/sp_prepaid/multiple_devices"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/multiple_devices/selected_device"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        item_id(required: true, PropertyType.String, description: "Id of the selected device")
    }
    "/sp_prepaid/multiple_devices/another_device"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Congrats
    "/sp_prepaid/congrats"(platform: "/mobile", isAbstract: true) {}
    "/sp_prepaid/congrats/show_receipt"(platform: "/mobile", type: TrackType.Event) {}
    "/sp_prepaid/congrats/add_alias"(platform: "/mobile", type: TrackType.Event) {}
    "/sp_prepaid/congrats/another_recharge"(platform: "/mobile", type: TrackType.Event) {}
    "/sp_prepaid/congrats/back_to_home"(platform: "/mobile", type: TrackType.Event) {}


    // Congrats alias
    "/sp_prepaid/congrats_alias"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/congrats_alias/another_recharge"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }
    "/sp_prepaid/congrats_alias/back_to_home"(platform: "/mobile", type: TrackType.Event) {
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
    }


    // Errors
    "/sp_prepaid/error"(platform: "/mobile", isAbstract: true) {}

    // Errors - Internal error
    "/sp_prepaid/error/internal"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/error/internal/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    "/sp_prepaid/error/internal/back"(platform: "/mobile", type: TrackType.Event) {}


    // Errors - Server error
    "/sp_prepaid/error/server"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/error/server/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    "/sp_prepaid/error/server/back"(platform: "/mobile", type: TrackType.Event) {}


    // Errors - Connection error
    "/sp_prepaid/error/connection"(platform: "/mobile", type: TrackType.View) {}

    "/sp_prepaid/error/connection/retry"(platform: "/mobile", type: TrackType.Event) {}
    "/sp_prepaid/error/connection/back"(platform: "/mobile", type: TrackType.Event) {}
}
