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
        available_items(required: false, type: PropertyType.ArrayList, description: "Available items to select")
        parent_key(required: false, PropertyType.String, description: "Information about the product/category the user is looking at")
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
        segment(required: false, type: PropertyType.String, description: "Segment to which the user belongs")
    }

    propertyGroups { 
        mandatory(flow, session_id)
        step_information(device_id, device_number, product_id, vertical_id, provider_id, flavor, last_recharge, parent_key)
        item_structure(item_id, type, content)
        view_time(view_time)
        available_items(available_items)
        point_structure(latitude, longitude, description, address_line_1, address_line_2, type, schedule, icon)
        segment(segment)
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
    "/single_player/prepaid/add_device_number/close"(platform: "/mobile", type: TrackType.Event) {
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
    "/single_player/prepaid/invalid_input/back_to_home"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Products
    "/single_player/prepaid/product_list"(platform: "/mobile", type: TrackType.View) {
        available_items
        notification_panel(required: false, PropertyType.Map(notification_panel_structure), description: "Information about the notification panel showed")
        segment
    }

    "/single_player/prepaid/product_list/selected_product"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        item_structure
        segment
    }
    "/single_player/prepaid/product_list/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        segment
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
    "/single_player/prepaid/product_list/more_products"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/prepaid/product_list/link"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
        item_id(required: false, PropertyType.String, description: "Id of the item")
        type(required: false, PropertyType.String, description: "Type of item")
        content(required: false, PropertyType.ArrayList, description: "Content of the item")
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
    "/single_player/prepaid/edit_alias/close"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/edit_alias/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // One device
    "/single_player/prepaid/one_device"(platform: "/mobile", type: TrackType.View) {
        button_card(required: false, PropertyType.Map(button_card_structure), description: "Information about the button card")
        notification_panel(required: false, PropertyType.Map(notification_panel_structure), description: "Information about the notification panel showed")
        available_items
        segment
    }

    "/single_player/prepaid/one_device/edit_alias"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
        item_id(required: false, PropertyType.String, description: "Id of the item")
        type(required: false, PropertyType.String, description: "Type of item")
        content(required: false, PropertyType.ArrayList, description: "Content of the item")
    }
    "/single_player/prepaid/one_device/selected_product"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
        item_structure
        segment
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
        item_id(required: false, PropertyType.String, description: "Id of the item")
        type(required: false, PropertyType.String, description: "Type of item")
        content(required: false, PropertyType.ArrayList, description: "Content of the item")
    }
    "/single_player/prepaid/one_device/back"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
        segment
    }


    // Multiple devices
    "/single_player/prepaid/multiple_devices"(platform: "/mobile", type: TrackType.View) {
        quantity(required: false, PropertyType.Numeric, description: "Quantity of items")
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
        item_id(required: false, PropertyType.String, description: "Id of the item")
        type(required: false, PropertyType.String, description: "Type of item")
        content(required: false, PropertyType.ArrayList, description: "Content of the item")
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

    "/single_player/prepaid/one_tap/more_information"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/one_tap/pay"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/prepaid/one_tap/back"(platform: "/mobile", type: TrackType.Event) {}


    // Congrats success
    "/single_player/prepaid/congrats_success"(platform: "/mobile", type: TrackType.View) {
        payment_id(required: true, PropertyType.String, description: "ID of the payment")
    }

    "/single_player/prepaid/congrats_success/copy_to_clipboard"(platform: "/mobile", type: TrackType.Event) {}
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
    "/single_player/prepaid/congrats_success/redirect_to_action"(platform: "/mobile", type: TrackType.Event) {}


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


    // Errors - Blocked error
    "/single_player/prepaid/error/blocked"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/error/blocked/another_device"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/error/blocked/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


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


    // Errors - Not Enough Money
    "/single_player/prepaid/error/not_enough_money"(platform: "/mobile", type: TrackType.View) {
        error_code(required: false, PropertyType.String, description: "Not enough money")
    }

    "/single_player/prepaid/error/not_enough_money/not_enough_money"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Errors - Not Allowed Version
    "/single_player/prepaid/error/not_allowed_version"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/error/not_allowed_version/not_allowed_version"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/error/not_allowed_version/go_to_store"(platform: "/mobile", type: TrackType.Event) {
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


    // Show Action
    "/single_player/prepaid/show_action"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/prepaid/show_action/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/prepaid/show_action/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    /**
    * Single Player Paygo Tracks  
    */

    "/single_player/paygo"(platform: "/mobile", isAbstract: true) {
        mandatory
        step_information
    }


    // Base
    "/single_player/paygo/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/change_detail"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/view_reciept"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // FTU
    "/single_player/paygo/first_time_use"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/first_time_use/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/first_time_use/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Break Freeways Available
    "/single_player/paygo/break_freeways_available"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/break_freeways_available/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/break_freeways_available/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }

    // Break New plate
    "/single_player/paygo/break_new_plate"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/break_new_plate/new_activation_number"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/break_new_plate/activate_activation_number"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/break_new_plate/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }

    // Freeways Available
    "/single_player/paygo/freeways_available"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/freeways_available/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/freeways_available/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }

    // New activation number
    "/single_player/paygo/new_activation_number"(platform: "/mobile", type: TrackType.View) {}

    // Challenge KYC
    "/single_player/paygo/challenge_kyc"(platform: "/mobile", type: TrackType.View) {}

    // New activation number not allowed
    "/single_player/paygo/new_activation_number_not_allowed"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/new_activation_number_not_allowed/back_to_home"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }

    // Add activation number
    "/single_player/paygo/add_activation_number"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/add_activation_number/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/add_activation_number/add_activation_number"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/add_activation_number/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/add_activation_number/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/add_activation_number/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/add_activation_number/close"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }

    // Add device number
    "/single_player/paygo/add_device_number"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/add_device_number/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/add_device_number/view_freeways_available"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/add_device_number/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/add_device_number/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/add_device_number/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/add_device_number/invalid_input"(platform: "/mobile", type: TrackType.Event) {
        view_time
        device_number(required: true, PropertyType.String, description: "Add device number invalid")
    }


    // Category List
    "/single_player/paygo/category_list"(platform: "/mobile", type: TrackType.View) {
        available_items
    }

    "/single_player/paygo/category_list/selected_category"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/paygo/category_list/more_categories"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/paygo/category_list/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
    }


    // New Address
    "/single_player/paygo/new_address"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/new_address/save"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/new_address/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Review New Device
    "/single_player/paygo/review_new_device"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/review_new_device/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/review_new_device/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/review_new_device/edit_device_number"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/review_new_device/edit_address"(platform: "/mobile", type: TrackType.Event) {
        view_time
        item_structure
    }
    "/single_player/paygo/review_new_device/edit_activation_number"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/review_new_device/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/review_new_device/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Review Payment Method Change
    "/single_player/paygo/review_payment_method_change"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/review_payment_method_change/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/review_payment_method_change/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/review_payment_method_change/edit_device_number"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/review_payment_method_change/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/review_payment_method_change/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Congrats success
    "/single_player/paygo/congrats_success"(platform: "/mobile", type: TrackType.View) {
        device_id(required: false, PropertyType.String, description: "Push device id")
        device_number(required: true, PropertyType.String, description: "Device number of the recharge")
        product_id(required: false, PropertyType.String, description: "Product id")
        vertical_id(required: true, PropertyType.String, description: "Vertical of the flow")
        provider_id(required: true, PropertyType.String, description: "Provider of the operation")
    }
    "/single_player/paygo/congrats_success/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
    }
    "/single_player/paygo/congrats_success/back_to_home"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
    }


    // Congrats pending
    "/single_player/paygo/congrats_pending"(platform: "/mobile", type: TrackType.View) {}
    "/single_player/paygo/congrats_pending/back_to_home"(platform: "/mobile", type: TrackType.Event) {}


    // Congrats rejected
    "/single_player/paygo/congrats_rejected"(platform: "/mobile", type: TrackType.View) {
        error_code(required: false, PropertyType.String, description: "Error code in server")
    }
    "/single_player/paygo/congrats_rejected/back"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/paygo/congrats_rejected/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/paygo/congrats_pending/back"(platform: "/mobile", type: TrackType.Event) {}


    // Recurrence
    "/single_player/paygo/recurrence"(platform: "/mobile", type: TrackType.View) {
        segment
    }

    "/single_player/paygo/recurrence/add_money"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/recurrence/another_device"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/recurrence/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/recurrence/device_list"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/recurrence/more_charges"(platform: "/mobile", type: TrackType.Event) {
        item_structure
        view_time
    }
    "/single_player/paygo/recurrence/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/recurrence/selected_charge"(platform: "/mobile", type: TrackType.Event) {
        item_structure
        view_time
    }


    // Charge List
    "/single_player/paygo/charge_list"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/charge_list/selected_charge"(platform: "/mobile", type: TrackType.Event) {
        item_structure
        view_time
    }
    "/single_player/paygo/charge_list/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Charge Detail
    "/single_player/paygo/charge_detail"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/charge_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/charge_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/charge_detail/view_receipt"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/charge_detail/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Debt Detail
    "/single_player/paygo/debt_detail"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/debt_detail/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/debt_detail/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/debt_detail/cancel"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Debt Detail With Others
    "/single_player/paygo/debt_detail_with_others"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/debt_detail_with_others/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/debt_detail_with_others/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/debt_detail_with_others/cancel"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Multiple devices
    "/single_player/paygo/multiple_devices"(platform: "/mobile", type: TrackType.View) {
        quantity(required: false, PropertyType.Numeric, description: "Quantity of items")
        notification_panel(required: false, PropertyType.Map(notification_panel_structure), description: "Information about the notification panel showed")
        available_items
    }

    "/single_player/paygo/multiple_devices/more_information"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }
    "/single_player/paygo/multiple_devices/understood_information"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        mandatory
        step_information
        view_time
    }
    "/single_player/paygo/multiple_devices/selected_device"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
        item_structure
    }
    "/single_player/paygo/multiple_devices/another_device"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
    }
    "/single_player/paygo/multiple_devices/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mandatory
        step_information
        view_time
    }


    // Requested Device Detail
    "/single_player/paygo/requested_device_detail"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/requested_device_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/requested_device_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/requested_device_detail/activate_device"(platform: "/mobile", type: TrackType.Event) {
        view_time
        item_structure
    }
    "/single_player/paygo/requested_device_detail/shipping_detail"(platform: "/mobile", type: TrackType.Event) {
        view_time
        item_structure
    }
    "/single_player/paygo/requested_device_detail/cancel_device"(platform: "/mobile", type: TrackType.Event) {
        view_time
        item_structure
    }
    "/single_player/paygo/requested_device_detail/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }

    // Active Device Detail
    "/single_player/paygo/active_device_detail"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/active_device_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/active_device_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/active_device_detail/delete_device"(platform: "/mobile", type: TrackType.Event) {
        item_structure
        view_time
    }
    "/single_player/paygo/active_device_detail/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Pending Device Detail
    "/single_player/paygo/pending_device_detail"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/pending_device_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/pending_device_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/pending_device_detail/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }

    // Blocked Device Detail
    "/single_player/paygo/blocked_device_detail"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/blocked_device_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/blocked_device_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/blocked_device_detail/delete_device"(platform: "/mobile", type: TrackType.Event) {
        item_structure
        view_time
    }
    "/single_player/paygo/blocked_device_detail/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Shipping Detail
    "/single_player/paygo/shipping_detail"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/shipping_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/shipping_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/shipping_detail/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Cancel Device
    "/single_player/paygo/cancel_device"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/cancel_device/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/cancel_device/cancel"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Congrats Cancel Tag
    "/single_player/paygo/congrats_cancel_tag"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/congrats_cancel_tag/back_to_home"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Delete Device
    "/single_player/paygo/delete_device"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/delete_device/confirm"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/delete_device/cancel"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Congrats Delete Device
    "/single_player/paygo/congrats_delete_tag"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/congrats_delete_tag/back_to_home"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Errors
    "/single_player/paygo/error"(platform: "/mobile", isAbstract: true) {}

    // Errors - Internal error
    "/single_player/paygo/error/internal"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/error/internal/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/paygo/error/internal/back"(platform: "/mobile", type: TrackType.Event) {}


    // Errors - Server error
    "/single_player/paygo/error/server"(platform: "/mobile", type: TrackType.View) {
        error_code(required: false, PropertyType.String, description: "Error code in server")
    }

    "/single_player/paygo/error/server/add_money"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/error/server/back_to_home"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/error/server/back"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }
    "/single_player/paygo/error/server/select_device"(platform: "/mobile", type: TrackType.Event) {
        view_time
    }


    // Errors - Connection error
    "/single_player/paygo/error/connection"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/error/connection/retry"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/paygo/error/connection/back"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/paygo/error/connection/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    

    // Errors - Timeout error
    "/single_player/paygo/error/timeout"(platform: "/mobile", type: TrackType.View) {}

    "/single_player/paygo/error/timeout/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    "/single_player/paygo/error/timeout/back"(platform: "/mobile", type: TrackType.Event) {}
}