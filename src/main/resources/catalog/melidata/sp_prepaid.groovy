import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1131"

    propertyDefinitions {
        flow(required:true, type: PropertyType.String, description: "Name of the current flow")
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        item_id(required: true, PropertyType.String, description: "Id of the item")
        type(required: true, PropertyType.String, description: "Type of item")
        content(required: true, PropertyType.ArrayList, description: "Content of the item")
        view_time(required: true, PropertyType.Numeric, description: "Time that the user kept in the view until this event")
        available_items(required: true, type: PropertyType.ArrayList, description: "Available items to select")
        //item_id
        //type
        //content
        latitude(required: true, PropertyType.String, description: "Latitude of the selected point")
        longitude(required: true, PropertyType.String, description: "Longitude of the selected point")
        description(required: false, PropertyType.String, description: "Description of the point")
        address_line_1(required: false, PropertyType.String, description: "Address line 1 of the point")
        address_line_2(required: false, PropertyType.String, description: "Address line 2 of the point")
        schedule(required: false, PropertyType.String, description: "Type of interest point")
        icon(required: false, PropertyType.String, description: "Icon of the point")

        device_id(required: false, type: PropertyType.String, description: "Push device id")
        device_number(required: false, type: PropertyType.String, description: "Device number of the recharge")
        product_id(required: false, type: PropertyType.String, description: "Product id")
        vertical_id(required: false, type: PropertyType.String, description: "Vertical of the flow")
        provider_id(required: false, type: PropertyType.String, description: "Provider of the operation")
        flavor(required:false, type: PropertyType.String, description: "Name of the current flavor")
        last_recharge(required:false, type: PropertyType.String, description: "Device id of the last recharge")
    }

    propertyGroups { 
        mandatory(flow, session_id)
        step_information(device_id, device_number, product_id, vertical_id, provider_id, flavor, last_recharge)
        item_structure(item_id, type, content)
        view_time(view_time)
        available_items(available_items)
        point_structure(latitude, longitude, description, address_line_1, address_line_2, type, schedule, icon)
    }

    def notification_panel_structure = objectSchemaDefinitions {
        type(required: true, PropertyType.String, description: "Type of notification panel")
        content(required: true, PropertyType.ArrayList, description: "Content of the notification panel")
    }

    def button_card_structure = objectSchemaDefinitions {
        type(required: true, PropertyType.String, description: "Type of button card")
        content(required: true, PropertyType.ArrayList, description: "Content of the button card")
    }

    /**
    * Single Player Prepaid Tracks  
    */
    "/single_player"(platform: "/mobile", isAbstract: true) {}
    
    
    "/single_player/prepaid"(platform: "/mobile", isAbstract: true) {
        mandatory
        step_information
    }


    // Start flow
    "/single_player/prepaid/start_flow"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        flow(required:true, type: PropertyType.String, description: "Name of the current flow")
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        method(required: true, PropertyType.String, description: "Specific way to start single player prepaid flow")
        extra_info(required: false, description: "Extra information about the user and device.")
    }


    // FTU
    "/single_player/prepaid/first_time_use"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/first_time_use/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/first_time_use/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Add device number
    "/single_player/prepaid/add_device_number"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/add_device_number/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/add_device_number/invalid_input"(platform: "/mobile", type: TrackType.Event) {
        view_time
        device_number(required: true, PropertyType.String, description: "Device number added by user")
    }
    "/single_player/prepaid/add_device_number/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/add_device_number/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/add_device_number/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/add_device_number/show_contacts"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Invalid input
    "/single_player/prepaid/invalid_input"(platform: "/mobile", type: TrackType.View) {
        error_code(required: false, PropertyType.String, description: "Error code in server")
    }

    "/single_player/prepaid/invalid_input/retry"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/invalid_input/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Products
    "/single_player/prepaid/product_list"(platform: "/mobile", type: TrackType.View) {
        available_items
        notification_panel(required: false, PropertyType.Map(notification_panel_structure), description: "Information about the notification panel showed")
    }

    "/single_player/prepaid/product_list/selected_product"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/prepaid/product_list/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/product_list/more_information"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/product_list/understood_information"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }


    // Recommended products
    "/single_player/prepaid/recommended_products"(platform: "/mobile", type: TrackType.View) {
        available_items
        notification_panel(required: false, PropertyType.Map(notification_panel_structure), description: "Information about the notification panel showed")
    }

    "/single_player/prepaid/recommended_products/selected_product"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/prepaid/recommended_products/more_products"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/prepaid/recommended_products/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/recommended_products/more_information"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/recommended_products/understood_information"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }


    // Add alias
    "/single_player/prepaid/add_alias"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/add_alias/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/add_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
        view_time
        alias(required: true, PropertyType.String, description: "Alias added by user")
    }
    "/single_player/prepaid/add_alias/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Edit alias
    "/single_player/prepaid/edit_alias"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/edit_alias/confirm_edit"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/edit_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
        view_time
        alias(required: true, PropertyType.String, description: "Alias added by user")
    }
    "/single_player/prepaid/edit_alias/delete"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/edit_alias/confirm_delete"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/edit_alias/cancel_delete"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/edit_alias/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // One device
    "/single_player/prepaid/one_device"(platform: "/mobile", type: TrackType.View) {
        button_card(required: true, PropertyType.Map(button_card_structure), description: "Information about the button card")
        notification_panel(required: false, PropertyType.Map(notification_panel_structure), description: "Information about the notification panel showed")
        available_items
    }

    "/single_player/prepaid/one_device/edit_alias"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/one_device/selected_product"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/prepaid/one_device/more_information"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/one_device/understood_information"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/one_device/more_products"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/prepaid/one_device/another_device"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/one_device/back"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }


    // Multiple devices
    "/single_player/prepaid/multiple_devices"(platform: "/mobile", type: TrackType.View) {
        quantity(required: true, PropertyType.Numeric, description: "Quantity of items")
        notification_panel(required: false, PropertyType.Map(notification_panel_structure), description: "Information about the notification panel showed")
        available_items
    }

    "/single_player/prepaid/multiple_devices/more_information"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/multiple_devices/understood_information"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/multiple_devices/selected_device"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/prepaid/multiple_devices/another_device"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
    }
    "/single_player/prepaid/multiple_devices/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
    }


    // Companies
    "/single_player/prepaid/companies"(platform: "/mobile", type: TrackType.View) {
        available_items
    }

    "/single_player/prepaid/companies/selected_company"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/prepaid/companies/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
    }
   "/single_player/prepaid/companies/more_information"(platform: "/mobile",  parentPropertiesInherited: false, type: TrackType.Event) {
       mandatory
       step_information  
       view_time
    }
    "/single_player/prepaid/companies/understood_information"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
       mandatory
       step_information
       view_time
    }


    // One Tap
    "/single_player/prepaid/one_tap"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/one_tap/pay"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/one_tap/back"(platform: "/mobile", type: TrackType.Event) {}


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
    "/single_player/prepaid/congrats_success/back"(platform: "/mobile", type: TrackType.Event) {}


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
        view_time
    }
    "/single_player/prepaid/congrats_alias/back_to_home"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/congrats_alias/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Accreditation information
    "/single_player/prepaid/accreditation_information"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/accreditation_information/download_external_application"(platform: "/mobile", type: TrackType.Event) {
        application_name(required: true, PropertyType.String, description: "Name of the external application that was opened")
        view_time
    }
    "/single_player/prepaid/accreditation_information/show_terminals"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/accreditation_information/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Carousel
    "/single_player/prepaid/carousel"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/carousel/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/carousel/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
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
        view_time
    }
    "/single_player/prepaid/error/server/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Errors - Connection error
    "/single_player/prepaid/error/connection"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/error/connection/retry"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/error/connection/back"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/error/connection/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    

    // Errors - Timeout error
    "/single_player/prepaid/error/timeout"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/error/timeout/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/error/timeout/back"(platform: "/mobile", type: TrackType.Event) {}


    // Shield
    "/single_player/prepaid/shield"(platform: "/mobile", type: TrackType.View) {}


    // Contingency
    "/single_player/prepaid/contingency"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/contingency/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/contingency/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/contingency/abort"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Map
    "/single_player/prepaid/locations"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/locations/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/locations/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/locations/selected_point"(platform: "/mobile", type: TrackType.Event) {
        view_time
        point_structure
    }
    "/single_player/prepaid/locations/want_to_go"(platform: "/mobile", type: TrackType.Event) {
        view_time
        point_structure
    }
    "/single_player/prepaid/locations/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Payment rejected
    "/single_player/prepaid/payment_rejected"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/payment_rejected/back_to_home"(platform: "/mobile", type: TrackType.Event) {}


    // Contacts
    "/single_player/prepaid/contacts"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/contacts/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/contacts/selected_contact"(platform: "/mobile", type: TrackType.Event) {
        view_time
        validation_result(required: true, PropertyType.String, description: "Result of apply site's validations")
    }


    // Receipt
    "/single_player/prepaid/receipt"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/receipt/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/receipt/share"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/receipt/download"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
}
