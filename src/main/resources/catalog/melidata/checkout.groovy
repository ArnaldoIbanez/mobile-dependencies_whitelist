package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1104"

    propertyDefinitions {

        // For shipping inconsistencies
        selections(required: true, type: PropertyType.ArrayList)
        error_code(required: false, type: PropertyType.String)
        inconsistency(required: false, type: PropertyType.String)
    }

    propertyGroups {
        shipping_inconsistency(selections, error_code, inconsistency)
    }

    def garexTrackStructure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String)
        period(required: true, type: PropertyType.Numeric)
        cost(required: true, type: PropertyType.Numeric)
        revenue_share_fee(required: true, type: PropertyType.Numeric)
        revenue(required: true, type: PropertyType.Numeric)
        currency_id(required: true, type: PropertyType.String)
    }

    def coordinatesStructure = objectSchemaDefinitions {
      latitude(required: true, type: PropertyType.Numeric)
      longitude(required: true, type: PropertyType.Numeric)
    }

    //CHECKOUT FLOW

    "/checkout"(platform: "/") {
        order_id(required: false)
        status(required: false)
        checkout_version(required: false, description: "Checkout Version")
        total_amount(required: false, type: PropertyType.Numeric)
        total_amount_with_shipping(required: false, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")
        order_items(required: false, description: "Array of items in the order. New: optional for old versions of mobile")
        //item
        //id
        //variation_id
        //buying_mode
        //category_id
        //deal_ids
        //quantity
        //unit_price
        //currency_id

        resolution(required: false)
        precharged_cards(required: false)
        geolocated(required: false)

        //shipping(required: false)
        shipping(required: false, type:PropertyType.ArrayList)
        // shipping_type,
        // cost,
        // shipping_option,
        // id, -> Solo para CHO Normal (no para cart)
        // name,
        // shipping_method_id,
        // shipping_mode
        // free_shipping_benefit
        // fulfillment

        payments(required: false, description: "Array of payment information") //
        // id
        // payment_method,
        // payment_type,
        // installments,
        // selected_card
        // financed_order_cost_for_card
        // payment_must_call_for_authorize

        items(required: false, type: PropertyType.ArrayList, description: "Array of items in the order with following data")
        //item
        //id
        //variation_id
        //buying_mode
        //shipping_mode
        //category_id
        //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: false)
        //id
        //nickname

        seller(required: false, type: PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname

        errors(required: false)
        status_detail(required: false)
        reloaded(required: false)
        quantity_pre_selected(required: false)
        order_payment_required(required: false)
        shipping_pre_selected(required: false)

        buy_equal_pay(required: false, description: "BP flag")
        recovery_flow(required: false, description: "Is recovery CHO flow")
        register_int(required: false, description: "Integrated registration")
        platform(required: false)
        available_actions(required: false, type: PropertyType.ArrayList, description: "Action presented on the screen, for ex: call_seller, email_seller, etc.")

        //Legacy App Congrats Tracks
        duplicated_error(required: false)
        congrats_seq(serverSide: true)
        total_amount_local(serverSide: true)
        total_amount_usd(serverSide: true)
        first_for_order(serverSide: true)

        // Checkout flows
        checkout_flow(required: false, type: PropertyType.String, values: ["contract", "reservation", "subscription", "direct", "purchase"])

        //Billing info
        billing_info(required:false, description: "Dictionary containing the user selected billing info")

        vertical(required:false, description: "Vertical of the item to be bought")

        session_id(required:false, description:"Session in which the checkout is being held")

        shipping_pick_up_in_store(required:false, type: PropertyType.String, description: "If the item has puis available")

        account_money_info(required:false, type: PropertyType.Map, description: "Map with data of the account money of the buyer")
        //skipPassword
        //useAccountMoneyWithAnotherPM
        //availableAccountMoney

        loyalty_level(required:false, description:"The loyalty level of the buyer")

        investor(required:false, type: PropertyType.String, values:["YES", "NO"], description:"If the user is an investor")

        available_consumer_credit(required:false, type: PropertyType.String, values:["YES", "NO"], description:"If the user has active consumer credits")

        context(required: false, type: PropertyType.String, description: "Reference to the context that started checkout flow")

        operation_status(required: false, description: "status")
        user_identification(required: false, description: "User identification data")
        available_methods(required: false, type: PropertyType.ArrayList, description: "Available payment methods for this flow")
        nearest_store_distance(required: false, description: "Distance to the nearest store")
        flow_type(required: false, type: PropertyType.String, description: "Type of operation")

        item_with_garex(required: false, type: PropertyType.Boolean, description: 'Item has available warranty')
        total_amount_including_garex(required: false, type: PropertyType.Numeric, description: 'Total amount (include garex if applies)')
        garex(required: false, type: PropertyType.Map(garexTrackStructure), description: 'User selects a warranty option')
        stored_cards_quantity(required: false, type: PropertyType.Numeric, description: "Stored cards quantity of the buyer")

        //Router
        checkout_flow_reason(required: false, type: PropertyType.String, description:"Reason why the purchase went through cart flow or direct flow" )

        //@SMELL -> https://mercadolibre.atlassian.net/browse/CHKON-9650 Aplicar logica utilizada en G.A. de filtrar en las paginas que se necesite y no arrastrar mediante backs
        token_generated_with_esc(required: false, type: PropertyType.String, values: ["YES", "NO"])
        congrats_status(required: false, type: PropertyType.String, values: ["APPROVED", "REJECTED", "IN_PROCESS", "PENDING", "CANCELLED", "AUTHORIZED", "REFUNDED", "ERROR_NON_RECOVERABLE_BI", "ERROR_RECOVERABLE_BI"])
        payment_status_detail(required: false, type: PropertyType.String, values: ["PENDING_CAPTURE","ACCREDITED", "CC_REJECTED_BLACKLIST", "CC_REJECTED_HIGH_RISK", "CC_REJECTED_INSUFFICIENT_AMOUNT", "CC_REJECTED_INVALID_INSTALLMENTS", "CC_REJECTED_OTHER_REASON", "CC_REJECTED_MAX_ATTEMPTS", "CC_REJECTED_BAD_FILLED_CARD_NUMBER", "CC_REJECTED_BAD_FILLED_OTHER", "CC_REJECTED_BAD_FILLED_DATE", "CC_REJECTED_BAD_FILLED_SECURITY_CODE", "CC_REJECTED_CALL_FOR_AUTHORIZE", "CC_REJECTED_CARD_DISABLED", "DEFAULT", "ACCORD", "PENDING_CONTINGENCY", "PENDING_REVIEW_MANUAL", "PENDING_CHALLENGE", "CC_REJECTED_FRAUD", "CC_REJECTED_DUPLICATED_PAYMENT", "CC_REJECTED_BAD_FILLED_INVALID_DATE", "ACCOUNT_REJECTED_HIGH_RISK", "REJECTED_BY_REGULATIONS", "REJECTED_INSUFFICIENT_DATA", "REJECTED_BY_BANK", "ERROR_BI_WITHOUT_CNPJ", "ERROR_BI_DIFFERENT_IE", "ERROR_BI_CNPJ_NON_OPERATIONAL", "ERROR_BI_IE_INVALID_STATE", "PHONE_VERIFICATION"])
    }

    /*
    * CHECKOUT V4
    */
    "/checkout/ordercreated"(platform: "/web", type: TrackType.Event) {
    }

    "/checkout/login"(platform: "/web", isAbstract: true) {
        vip_parameters(required: true, description: "Parameters that came from the VIP")
        //cht
        //pm
        //inst
        //bp
        //zip_code
        //shipping_method_id
        //ship_method_id
        //ship_option_id
        //cc_issuer
        //is_logged
        //prefs_on
    }
    "/checkout/login/confirm_authenticated"(platform: "/web") {}
    "/checkout/login/first_purchase_not_authenticated"(platform: "/web") {}
    "/checkout/login/confirm_not_authenticated"(platform: "/web") {}

    "/checkout/payment"(platform: "/", isAbstract: true) {
    }
    "/checkout/payment/input_sec_code"(platform: "/web", type: TrackType.View) {}
    "/checkout/payment/esc_input_sec_code"(platform: "/web", type: TrackType.View) {}
    "/checkout/payments"(platform: "/", isAbstract: true) {
    }

    "/checkout/payment/select_type"(platform: "/web", type: TrackType.View) {}
    "/checkout/payments/select_payment_method"(platform: "/web") {}
    "/checkout/payments/select_payment_type"(platform: "/web") {}
    "/checkout/payments/select_split_payment"(platform: "/web") {}
    "/checkout/payments/input_proactive_payment_amount"(platform: "/web") {}
    "/checkout/payments/installments#submit"(platform: "/web", type: TrackType.Event) {
        pay_pref_id(required: true, description: "payment preference Id")
        total_price(required: true, description: "Total price")
        preferred_installment(required: true, description: "preferred Installment")
        max_installments_without_fee(required: true, description: "max Installments Without Fee")
        selected_installment(required: true, description: "selected Installment")
    }

    //Web and Apps track is the same
    "/checkout/review"(platform: "/") {
    }

    /** *****************************************************************/
    //Mobile Checkout Apps
    "/checkout"(platform: "/mobile") {
        combination_2mp(required:false, description: "2MP switch state")
        reservation_price(required: false, description: "price of a reservation transaction")
    }

    "/checkout/wrapper"(platform: "/mobile") {} //Melidata experiment
    "/checkout/init"(platform: "/mobile") {
        // items is required for this call
        items(required: true, type: PropertyType.ArrayList, description: "Array of items in the order with following data")
        //item
        //id
        //variation_id
        //buying_mode
        //shipping_mode
        //category_id
        //deal_ids
        //quantity
        //unit_price
        //currency_id

        success(required: true, type: PropertyType.Boolean)
        location(required: false, type: PropertyType.String)
        geolocation_method(required: false, type: PropertyType.String)
    }

    "/checkout/init/back"(platform: "/mobile", type: TrackType.Event) {
        success(required: false, type: PropertyType.Boolean)
    }

    "/checkout/init/options"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        shipping_data(required: true, type: PropertyType.ArrayList, description: "Shipping options available for the buyer")
        payment_data(required: true, type: PropertyType.String, description: "Payment options available for the buyer")
        shipping(required: false)
        payments(required: false)
    }

    "/checkout/payments_cancelation"(platform: "/mobile") {}

    "/checkout/onboard"(platform: "/mobile") {}

    "/checkout/geolocation"(platform: "/", type: TrackType.Event) {
        geolocation_error(required: true, description: "Why the geo failed")
    }

    "/checkout/shipping"(platform: "/", type: TrackType.View) {
    }

    //Address Hub
    "/checkout/shipping/delivery_instructions"(platform:"/", type: TrackType.View) {}
    "/checkout/shipping/address_hub"(platform:"/", type: TrackType.View) {}

    //First Visit
    //Page
    "/checkout/shipping/address_profile"(platform: "/", type: TrackType.View) {}

    //Event
    "/checkout/shipping/address_profile/delivered_time"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        label(required: false, type: PropertyType.String)
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }

    //Fallback/Custom shipping
    "/checkout/shipping/select_method"(platform: "/mobile") {
        //View specific data
        selections(required: true, type: PropertyType.ArrayList)
    }
    //Fallback/inconsistency
    "/checkout/shipping/select_method/inconsistency"(platform: "/mobile") {
        shipping_inconsistency
    }
    "/checkout/shipping/accord"(platform: "/mobile") {
        shipping_inconsistency
    }
    "/checkout/shipping/accord/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/shipping/accord_shipping_and_payment"(platform: "/mobile") {
        shipping_inconsistency
    }
    //Geolocation on fallback
    "/checkout/shipping/select_method/ask_enable_geolocation"(platform: "/mobile") {}
    "/checkout/shipping/select_method/ask_enable_geolocation#geolocation_permission_ask"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        granted(required: true, type: PropertyType.String)
    }
    "/checkout/shipping/select_method/ask_enable_geolocation#geolocation_enabled"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        status(required: true, type: PropertyType.String)
    }
    "/checkout/shipping/select_method/ask_enable_geolocation#unable_to_use_location_services"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    //Geolocation
    "/checkout/shipping/select_method/geolocated"(platform: "/mobile") {}
    "/checkout/shipping/custom_address"(platform: "/mobile", isAbstract: true) {}
    //Input zip_code
    "/checkout/shipping/custom_address/zip_code"(platform: "/mobile") {
        edit_flow(required: false, type: PropertyType.Boolean, description: "Represents the state of user editing address flow")
    }
    "/checkout/shipping/custom_address/zip_code/back"(platform: "/mobile", type: TrackType.Event) {
        edit_flow(required: false, type: PropertyType.Boolean, description: "Represents the state of user editing address flow")
    }
    "/checkout/shipping/custom_address/zip_code#zip_code"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        zip_code(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/custom_address/zip_code#street_name"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        street_name(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/custom_address/zip_code#street_number"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        street_number(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/custom_address/zip_code#internal_number"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        internal_number(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/custom_address/zip_code#between_streets"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        between_streets(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/custom_address/zip_code#references"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        references(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/custom_address/zip_code#neighborhood"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        neighborhood(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/custom_address/zip_code#additional_info"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        additional_info(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/custom_address/zip_code#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        success(required: false, type: PropertyType.Boolean, description: "API Call when success on loading shipping options")
    }
    //Query zip code
    "/checkout/shipping/custom_address/zip_code/query"(platform: "/mobile", type: TrackType.View) {
        edit_flow(required: false, type: PropertyType.Boolean, description: "Represents the state of user editing address flow")
    }
    "/checkout/shipping/custom_address/zip_code/query/back"(platform: "/mobile", type: TrackType.Event) {
        edit_flow(required: false, type: PropertyType.Boolean, description: "Represents the state of user editing address flow")
    }
    "/checkout/shipping/custom_address/zip_code/query#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        query_parameters(required: false, type: PropertyType.String)
        failing_url(required: false, type: PropertyType.String)
    }

    "/checkout/shipping/select_option"(platform: "/", isAbstract: true) {
        //View specific data
        shipping_options(required: false, type: PropertyType.ArrayList)
        //shipping_options: [
        //  [
        //    method_name: "Normal",
        //    price: 0.0,
        //    currency_id: "ARS",
        //    free_shipping: true
        //  ]
        //]
        // Visual type of shipping options list
        view_type(required: false, type: PropertyType.String, values: ["legacy", "grouped"])
    }
    //Select shippingOptions
    "/checkout/shipping/select_option/mercado_envios"(platform: "/mobile") {}
    "/checkout/shipping/select_option/free_shipping"(platform: "/mobile") {}
    "/checkout/shipping/select_option/custom"(platform: "/mobile") {}
    //Input address flow
    "/checkout/shipping/select_contact"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        is_from_preload_address(required: true, type: PropertyType.Boolean)
    }

    "/checkout/shipping/location"(platform: "/mobile", isAbstract: true) {}
    "/checkout/shipping/location/address"(platform: "/mobile") {
        //View specific data
        edit_flow(required: true, type: PropertyType.Boolean)
    }
    "/checkout/shipping/location/address/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/shipping/location/select_state"(platform: "/mobile") {}
    "/checkout/shipping/location/select_city"(platform: "/mobile") {}
    "/checkout/shipping/location/select_city/invalid_destination"(platform: "/mobile") {}
    "/checkout/shipping/location/select_contact#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        success(required: true, type: PropertyType.Boolean)
        error_codes(required: false, type: PropertyType.ArrayList)
    }
    "/checkout/shipping/location/select_contact"(platform: "/mobile") {
        //View specific data
        available_options(required: true, type: PropertyType.Numeric)
    }
    "/checkout/shipping/location/select_contact/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/shipping/location/find_contact"(platform: "/mobile") {}
    "/checkout/shipping/location/new_contact"(platform: "/mobile") {
        //View specific data
        //Contact name/phone
        contact_name(required: false, type: PropertyType.String)
        contact_phone(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/new_contact#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        success(required: false, type: PropertyType.Boolean)
        error_codes(required: false, type: PropertyType.ArrayList)
    }
    "/checkout/shipping/location/new_contact/back"(platform: "/mobile", type: TrackType.Event) {}

    //Select address
    "/checkout/shipping/select_address"(platform: "/") {
        //View specific data
        //List of available shipping_options
        shipping_options(required: false, type: PropertyType.ArrayList)
        //shipping_options: [
        //  [
        //    method_name: "Normal",
        //    price: 0.0,
        //    currency_id: "ARS",
        //    free_shipping: true
        //  ]
        //]
    }
    "/checkout/shipping/select_address/list"(platform: "/") {
        shipping_options(required: false, type: PropertyType.ArrayList)
    }

    // Store map
    "/checkout/shipping/select_store_map"(platform: "/mobile") {}
    "/checkout/shipping/select_store_map/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/shipping/select_store_map#agencies_request"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        agencies(required: true, description: "the number of agencies returned by the request")
        item_id(required: true, description: "the item id for which we are requesting agencies")
        latitude(required: false, description: "the latitude at which we are requesting agencies")
        longitude(required: false, description: "the longitude at which we are requesting agencies")
    }

    // --- Map v2 --- //

    "/checkout/shipping/puis"(platform: "/", isAbstract: true) {}
    "/checkout/shipping/puis/select_store"(platform: "/", type: TrackType.View) {}
    "/checkout/shipping/select_store"(platform: "/", type: TrackType.View) {}

    // Event Back
    "/checkout/shipping/puis/select_store/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/shipping/select_store/back"(platform: "/mobile", type: TrackType.Event) {}

    // Event for Defaults
    "/checkout/shipping/puis/select_store/selected_store"(platform: "/", type: TrackType.Event) {
        default_location_info(required: true, description: "that indicate the type of default")
        latitude(type: PropertyType.Numeric, required: true, description: "the latitude at which we are requesting agencies")
        longitude(type: PropertyType.Numeric, required: true, description: "the longitude at which we are requesting agencies")
        last_action(type: PropertyType.String, required: true, description: "That indicate the last action the user on the map")
        distance(type: PropertyType.Numeric, required: false, description: "indicate the distance of the agencie selected to the default center point")
        selected_filters(type: PropertyType.ArrayList, required: false, description: "indicates the selected filters when an agency is selected")
        agency_latitude(type: PropertyType.Numeric, required: false, description: "the latitude of the selected agency")
        agency_longitude(type: PropertyType.Numeric, required: false, description: "the longitude of the selected agency")
        filters_present(type: PropertyType.Boolean, required: false, description: "indicates if the last request for agencies contains filters or not")
    }

    "/checkout/shipping/select_store/selected_store"(platform: "/", type: TrackType.Event) {
        default_location_info(required: true, description: "that indicate the type of default")
        latitude(type: PropertyType.Numeric, required: true, description: "the latitude at which we are requesting agencies")
        longitude(type: PropertyType.Numeric, required: true, description: "the longitude at which we are requesting agencies")
        last_action(type: PropertyType.String, required: true, description: "That indicate the last action the user on the map")
        distance(type: PropertyType.Numeric, required: false, description: "indicate the distance of the agencie selected to the default center point")
        selected_filters(type: PropertyType.ArrayList, required: false, description: "indicates the selected filters when an agency is selected")
        agency_latitude(type: PropertyType.Numeric, required: false, description: "the latitude of the selected agency")
        agency_longitude(type: PropertyType.Numeric, required: false, description: "the longitude of the selected agency")
        filters_present(type: PropertyType.Boolean, required: false, description: "indicates if the last request for agencies contains filters or not")
    }

    // No agencies
    "/checkout/shipping/puis/select_store/store_not_found"(platform: "/",type: TrackType.Event) {
        latitude(type: PropertyType.Numeric,required: false, description: "the latitude at which we are requesting agencies")
        longitude(type: PropertyType.Numeric,required: false, description: "the longitude at which we are requesting agencies")
    }
    "/checkout/shipping/select_store/store_not_found"(platform: "/",type: TrackType.Event) {
        latitude(type: PropertyType.Numeric,required: false, description: "the latitude at which we are requesting agencies")
        longitude(type: PropertyType.Numeric,required: false, description: "the longitude at which we are requesting agencies")
    }

    //Select paymentMethod
    "/checkout/payment/preload_credit_card"(platform: "/mobile", type: TrackType.View) {}//Melidata experiment

    "/checkout/payment/select_method"(platform: "/mobile") {
        //List of available payment_methods and coupon info
        available_methods(required: true, type: PropertyType.ArrayList)
        coupon(required: false, type: PropertyType.Boolean)
        coupon_discount(required: false, type: PropertyType.Numeric)
    }
    "/checkout/payment/select_method#new_payment_method_selected"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        payment_method_id(required: false, type: PropertyType.String)
        payment_type_id(required: false, type: PropertyType.String)
    }
    "/checkout/payment/coupon_detail"(platform: "/mobile") {}
    // Add card form
    "/checkout/payment/add_debit_card"(platform: "/mobile") {}
    "/checkout/payment/add_debit_card#card_config"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        bin(required: true, type: PropertyType.String)
        success(required: true, type: PropertyType.Boolean)
    }
    "/checkout/payment/add_debit_card/select_bank"(platform: "/mobile") {
        available_issuers(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payment/add_debit_card/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/payment/add_prepaid_card"(platform: "/mobile") {}
    "/checkout/payment/add_prepaid_card#card_config"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        bin(required: true, type: PropertyType.String)
        success(required: true, type: PropertyType.Boolean)
    }
    "/checkout/payment/add_card"(platform: "/mobile") {}
    "/checkout/payment/add_card/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/payment/add_card#card_config"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        bin(required: true, type: PropertyType.String)
        success(required: true, type: PropertyType.Boolean)
    }
    "/checkout/payment/add_card/select_bank"(platform: "/mobile") {
        available_issuers(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payment/add_card/installments"(platform: "/mobile") {
        //List of available installments
        available_installments(required: true, type: PropertyType.ArrayList)
        //installments: [
        //    [
        //      installment: 1,
        //      amount: 20.6,
        //      without_fee: true
        //    ]
    }
    "/checkout/payment/add_card/installments/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/payment/stored_card"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payment/stored_card/select_bank"(platform: "/mobile") {
        available_methods(required: true, type: PropertyType.ArrayList, description: "list of available banks")
    }
    "/checkout/payment/stored_card/security_code"(platform: "/mobile") {
        //List of visible fields
        user_identification_fields(required: false, type: PropertyType.ArrayList)
        //user_identification_fields: ["doc_type", "doc_number"]
    }
    "/checkout/payment/stored_card/installments"(platform: "/mobile") {
        credit_card_id(required: false, type: PropertyType.String)
        //List of available installments
        available_installments(required: true, type: PropertyType.ArrayList)
        //installments: [
        //    [
        //      installment: 1,
        //      amount: 20.6,
        //      without_fee: true
        //    ]
    }
    "/checkout/payment/stored_card/installments/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/payment/stored_card/installments#change_payment_method"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        event_source(required: true, type: PropertyType.String)
    }
    "/checkout/payment/account_money"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payment/account_money/create"(platform: "/mobile") {}
    "/checkout/payment/account_money/password"(platform: "/mobile") {}
    "/checkout/payment/account_money/password#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    "/checkout/payment/select_issuer"(platform: "/mobile") {}
    // mlm grouping
    "/checkout/payment/cash"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payment/cash/select_store"(platform: "/mobile") {
        available_methods(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payment/cash/select_store/back"(platform: "/mobile", type:TrackType.Event) {}
    "/checkout/payment/cash/select_store/select_address"(platform: "/mobile", parentPropertiesInherited: false) {}
    "/checkout/payment/cash/select_store#request_permissions"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        permissions(required: true, type: PropertyType.String)
        extended(required: true, type: PropertyType.Boolean)
    }
    "/checkout/payment/transfer"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payment/transfer/select_bank"(platform: "/mobile") {
        available_methods(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payment/billing_info"(platform: "/mobile") {
        //List of visible fields
        user_identification_fields(required: false, type: PropertyType.ArrayList)
        //user_identification_fields: ["doc_type", "doc_number", "name", "las_name"]
    }
    "/checkout/payment/billing_info#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        billing_info_state(required: true, type: PropertyType.String)
    }
    "/checkout/payment/consumer_credits"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payment/consumer_credits/installments"(platform: "/mobile") {
        //List of available installments
        available_installments(required: true, type: PropertyType.ArrayList)
        //installments: [
        //    [
        //      installment: 1,
        //      amount: 20.6,
        //      without_fee: true
        //    ]
    }
    "/checkout/payment/consumer_credits/installments/back"(platform: "/mobile", type: TrackType.Event) {}
    // payment promotions screen. Eg: bank promos in MLA
    "/checkout/payment/promotions"(platform: "/mobile") {}

    "/checkout/payment/select_type"(platform: "/mobile", type: TrackType.View) {
        available_methods(required: false, type: PropertyType.ArrayList)
        coupon(required: false, type: PropertyType.Boolean)
        coupon_discount(required: false, type: PropertyType.Numeric)
    }
    "/checkout/payment/select_type/back"(platform: "/mobile", type: TrackType.Event) {}

    // 2MP switch tracks
    "/checkout/payment/2mp#use"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/payment/2mp#not_use"(platform: "/mobile", type: TrackType.Event) {}

    //2MP Disclaimer combination modal view.
    "/checkout/payment/payment_combination"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payment/payment_combination/debit_card"(platform: "/mobile") {}
    "/checkout/payment/payment_combination/payment_method_not_supported"(platform:"/mobile", type: TrackType.View) {}

    // Discount coupons
    "/checkout/payment/add_coupon"(platform:"/mobile", type: TrackType.View) {}
    "/checkout/payment/coupon_ok"(platform:"/mobile", type: TrackType.View) {
        coupon(required: true, type: PropertyType.String)
    }
    "/checkout/payment/add_another_coupon"(platform:"/mobile", type: TrackType.View) {}
    "/checkout/payment/coupon_error"(platform:"/mobile", type: TrackType.View) {}

    "/checkout/payment/invalid_coupon"(platform:"/mobile", type: TrackType.Event) {}
    "/checkout/payment/expired_coupon"(platform:"/mobile", type: TrackType.Event) {}
    "/checkout/payment/add_another_coupon/delete_coupon"(platform:"/mobile", type: TrackType.Event) {}

    // Step Curp Credits MLM
    "/checkout/payment/curp"(platform:"/", type: TrackType.View) {}
    "/checkout/payment/curp/not_my_curp"(platform:"/", type: TrackType.Event) {}
    "/checkout/payment/curp/view_authorization"(platform:"/", type: TrackType.Event) {}

    //Credits Review
    "/checkout/review/credits_cover"(platform:"/", type: TrackType.Event) {}
    "/checkout/review/credits_terms_and_conditions"(platform:"/", type: TrackType.Event) {}

    // ESC: Enter the Sec Code to generate an Encrypted Security Code
    "/checkout/payment/encrypted_security_code_add"(platform:"/mobile") {}
    "/checkout/payment/encrypted_security_code_add#submit"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        status(required: true, type: PropertyType.String)
        checkout_flow(required: true, type: PropertyType.String, values: ["contract", "reservation", "subscription", "checkout"])
    }

    //Billing info
    "/checkout/billing"(platform: "/mobile", isAbstract: true) {}
    "/checkout/billing/physical_person"(platform: "/mobile") {}
    "/checkout/billing/physical_person/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/billing/legal_person"(platform: "/mobile") {}
    "/checkout/billing/legal_person/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/review/edit_billing_info"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }

    //"/checkout/review" //shared between web and app, already defined in web section.
    "/checkout/review#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        status(required: true, type: PropertyType.String)
        checkout_flow(required: true, type: PropertyType.String, values: ["contract", "reservation", "subscription", "checkout"])
    }

    "/checkout/review#submit/abort"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        checkout_flow(required: false, type: PropertyType.String, values: ["contract", "reservation", "subscription", "checkout", "purchase"])
    }

    "/checkout/review/quantity#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        old_quantity(required: true, type: PropertyType.Numeric)
        selected_quantity(required: true, type: PropertyType.Numeric)
    }
    "/checkout/review/quantity"(platform: "/mobile") {}
    "/checkout/review/quantity/input"(platform: "/mobile") {}
    "/checkout/review/inconsistency"(platform: "/mobile", isAbstract: true) {}
    "/checkout/review/inconsistency/quantity"(platform: "/mobile") {
        error_code(required: false, type: PropertyType.String)
    }
    "/checkout/review/inconsistency/price_changed"(platform: "/mobile") {}
    "/checkout/review/edit_shipping#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        //old_value, new_value
        old_value(required: true, type: PropertyType.String)
        new_value(required: true, type: PropertyType.String)
    }
    "/checkout/review/edit_shipping"(platform: "/") {
        //List of available shipping_options
        shipping_options(required: false, type: PropertyType.ArrayList)
        //shipping_options: [
        //  [
        //    method_name: "Normal",
        //    price: 0.0,
        //    currency_id: "ARS",
        //    free_shipping: true
        //  ]
        //]
    }
    "/checkout/review/inconsistency/edit_shipping"(platform: "/mobile") {
        error_code(required: true, type: PropertyType.String)
    }
    "/checkout/review/edit_installments#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        //old_value, new_value
        old_value(required: true, type: PropertyType.Numeric)
        new_value(required: true, type: PropertyType.Numeric)
    }
    "/checkout/review/edit_installments"(platform: "/") {
        // TODO: Include this tracking in we version => https://mercadolibre.atlassian.net/browse/CHKON-6166

        //List of available installments
        available_installments(required: false, type: PropertyType.ArrayList)
        //installments: [
        //    [
        //      installment: 1,
        //      amount: 20.6,
        //      without_fee: true
        //    ]
    }
    "/checkout/review/terms"(platform: "/mobile") {}
    "/checkout/review/discard_payment_combination"(platform: "/mobile") {}
    "/checkout/review/inconsistency/payment_combination"(platform: "/mobile", isAbstract: true) {}
    "/checkout/review/inconsistency/payment_combination/payment"(platform: "/mobile") {}
    "/checkout/review/inconsistency/payment_combination/installments"(platform: "/mobile") {}
    "/checkout/review/inconsistency/payment_combination/shipping"(platform: "/mobile") {}

    //Review summary header payment detail list
    "/checkout/review/display_detail#displayed"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/review/display_detail#closed"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/additional_info"(platform: "/mobile") {
        // amounts, items, shipping and payment are required for this track
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")

        payments(required: true, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: true)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items(required: true, type: PropertyType.ArrayList, description: "Array of items in the order with following data")
        //item
        //id
        //variation_id
        //buying_mode
        //shipping_mode
        //category_id
        //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: true)
        //id
        //nickname

        seller(required: true, type: PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
    }
    //Congrats tracks - shared between Legacy App and new App (Required False to prevent catalog validation failures)
    "/checkout/congrats"(platform: "/") {
        status(required: false, type: PropertyType.String)
        purchase_status(required: false, type: PropertyType.String, values: ["payment_required", "payment_in_process", "partially_paid", "paid", "pending_cancel", "cancelled", "confirmed"], description: "Status of the purchase")
        purchase_id(required: false, type: PropertyType.Numeric, description: "Id of the purchase")
        buyer_segment(serverSide: true) // -> Lo completa Melidata automaticamente
        loyalty_buyer(serverSide: true) // -> Lo completa Melidata automaticamente
    }
    "/checkout/congrats"(platform: "/web") {
        token_generated_with_esc(required: true, type: PropertyType.String, values: ["YES", "NO"])
        congrats_status(required: true, type: PropertyType.String, values: ["APPROVED", "REJECTED", "IN_PROCESS", "PENDING", "CANCELLED", "AUTHORIZED", "REFUNDED", "ERROR_NON_RECOVERABLE_BI", "ERROR_RECOVERABLE_BI"])
        payment_status_detail(required: true, type: PropertyType.String, values: ["PENDING_CAPTURE","ACCREDITED", "CC_REJECTED_BLACKLIST", "CC_REJECTED_HIGH_RISK", "CC_REJECTED_INSUFFICIENT_AMOUNT", "CC_REJECTED_INVALID_INSTALLMENTS", "CC_REJECTED_OTHER_REASON", "CC_REJECTED_MAX_ATTEMPTS", "CC_REJECTED_BAD_FILLED_CARD_NUMBER", "CC_REJECTED_BAD_FILLED_OTHER", "CC_REJECTED_BAD_FILLED_DATE", "CC_REJECTED_BAD_FILLED_SECURITY_CODE", "CC_REJECTED_CALL_FOR_AUTHORIZE", "CC_REJECTED_CARD_DISABLED", "DEFAULT", "ACCORD", "PENDING_CONTINGENCY", "PENDING_REVIEW_MANUAL", "PENDING_CHALLENGE", "CC_REJECTED_FRAUD", "CC_REJECTED_DUPLICATED_PAYMENT", "CC_REJECTED_BAD_FILLED_INVALID_DATE", "ACCOUNT_REJECTED_HIGH_RISK", "REJECTED_BY_REGULATIONS", "REJECTED_INSUFFICIENT_DATA", "REJECTED_BY_BANK", "ERROR_BI_WITHOUT_CNPJ", "ERROR_BI_DIFFERENT_IE", "ERROR_BI_CNPJ_NON_OPERATIONAL", "ERROR_BI_IE_INVALID_STATE", "PHONE_VERIFICATION"])
    }

    "/checkout/congrats/recommendations"(platform: "/", type: TrackType.View) {}

    "/checkout/finish/click"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        action(required: true, description: "Action executed, for ex: call_seller, email_seller, etc")
    }

    "/checkout/finish/call_for_auth"(platform:"/", type: TrackType.View, isAbstract: true) {}
    "/checkout/finish/call_for_auth/instructions"(platform: "/mobile") {}
    "/checkout/finish/call_for_auth/instructions#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        status(required: true, type: PropertyType.String)
        checkout_flow(required: true, type: PropertyType.String, values: ["contract", "reservation", "subscription", "checkout"])
    }
    "/checkout/finish/call_for_auth/instructions#submit/abort"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        checkout_flow(required: false, type: PropertyType.String, values: ["contract", "reservation", "subscription", "checkout", "purchase"])
    }
    "/checkout/finish/call_for_auth/later"(platform: "/mobile") {}

    "/checkout/finish/invalid_sec_code"(platform:"/", type: TrackType.View, isAbstract: true) {}
    "/checkout/finish/invalid_sec_code/input"(platform: "/mobile") {}

    "/checkout/finish/invalid_sec_code/input#submit"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/features"(platform: "/mobile", type: TrackType.Event, isAbstract: true) {}

    "/checkout/features/bridge"(platform: "/mobile", type: TrackType.Event) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        is_experiment_on(required: false, type: PropertyType.Boolean, description: "Check if the bridge is on or not")
        can_navigate_to(required: false, type: PropertyType.Boolean, description: "Check if the navigation is to a internal flow screen")
        screen(required: false, type: PropertyType.String, "Destination screen name")
    }

    "/checkout/finish"(platform: "/mobile", isAbstract: true) {
        /** **************************************/
        // order id, payments and items are required
        order_id(required: true, description: "OrderId")
        status(required: false, description: "status")

        payments(required: true, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        items(required: true, type: PropertyType.ArrayList, description: "Array of items in the order with following data")
        //item
        //id
        //variation_id
        //buying_mode
        //shipping_mode
        //category_id
        //deal_ids
        //quantity
        //unit_price
        //currency_id
    }

    "/checkout/finish/choose_action"(platform: "/mobile") {
        /* choose from a list of actions what to do. Eg: choose user homebanking */
    }

    "/checkout/finish/second_step"(platform: "/mobile", isAbstract: true) {}

    "/checkout/finish/second_step/error_details"(platform: "/mobile") {}

    "/checkout/error"(platform: "/") {
        status(required: false, description: "status")
        error_code(required: false, type: PropertyType.String)
    }

    "/checkout/show_ticket"(platform: "/") {}

    "/checkout/show_ticket#save"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }

    "/checkout/show_geolocation_map"(platform: "/mobile") {
        // amounts, payment, shipping, items, seller and buyer are required for this track
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        payment_method(required: true)

        payments(required: true, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: true)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items(required: true, type: PropertyType.ArrayList, description: "Array of items in the order with following data")
        //item
        //id
        //variation_id
        //buying_mode
        //shipping_mode
        //category_id
        //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: true)
        //id
        //nickname

        seller(required: true, type: PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
    }
    "/checkout/show_geolocation_map/back"(platform: "/mobile", type: TrackType.Event) {}
    "/checkout/show_geolocation_map/search"(platform: "/mobile") {}
    "/checkout/show_geolocation_map/search#location"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    "/checkout/show_geolocation_map/search#preloaded"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    "/checkout/show_geolocation_map/search#select"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    "/checkout/show_geolocation_map#agencies_request"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
        agencies(required: true)
        payment_method(required: true)

    }

    //Payment form input tack events:
    "/checkout/payment/input_card/card_number"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        session_id(required: true, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    "/checkout/payment/input_card/holder_name"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        session_id(required: true, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    "/checkout/payment/input_card/expiry_date"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        session_id(required: true, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    "/checkout/payment/input_card/security_code"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        session_id(required: true, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    "/checkout/payment/input_card/identification_number"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        session_id(required: true, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    "/checkout/payment/input_card/error_card_number"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        session_id(required: true, type: PropertyType.String, description: "Session in which the checkout is being held")
        error(required: true, type: PropertyType.String, description: "Error that was shown to the user")
    }
    "/checkout/payment/input_card/error_holder_name"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        session_id(required: true, type: PropertyType.String, description: "Session in which the checkout is being held")
        error(required: true, type: PropertyType.String, description: "Error that was shown to the user")
    }
    "/checkout/payment/input_card/error_expiry_date"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        session_id(required: true, type: PropertyType.String, description: "Session in which the checkout is being held")
        error(required: true, type: PropertyType.String, description: "Error that was shown to the user")
    }
    "/checkout/payment/input_card/error_security_code"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        session_id(required: true, type: PropertyType.String, description: "Session in which the checkout is being held")
        error(required: true, type: PropertyType.String, description: "Error that was shown to the user")
    }
    "/checkout/payment/input_card/error_identification_number"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        session_id(required: true, type: PropertyType.String, description: "Session in which the checkout is being held")
        error(required: true, type: PropertyType.String, description: "Error that was shown to the user")
    }

    /*
    * CHECKOUT V4
    */

    /*
    * CHECKOUT V5
    */

    "/checkout/shipping/confirm_geolocation"(platform:"/web", type: TrackType.View) {}

    "/checkout/shipping/select_method_ask_geolocation"(platform:"/web", type: TrackType.View) {}

    "/checkout/shipping/confirm_geolocation/send_to_cp_located"(platform:"/web", type: TrackType.Event) {}
    "/checkout/shipping/confirm_geolocation/send_to_another_location"(platform:"/web", type: TrackType.Event) {}

    "/checkout/shipping/input_new_address"(platform:"/web", type: TrackType.View) {}

    "/checkout/shipping/select_option/send_to_my_address/"(platform:"/web", type: TrackType.View) {}

    "/checkout/shipping/select_option/agency_pickup/"(platform:"/web", type: TrackType.View) {}

    "/checkout/shipping/accord"(platform:"/web", type: TrackType.View) {}

    "/checkout/items_not_available"(platform:"/", type: TrackType.View) {}

    "/checkout/payment/select_method"(platform:"/", type: TrackType.View) {}

    "/checkout/payment/select_method/edit_payment"(platform:"/", type: TrackType.Event) {}
    "/checkout/payment/select_method/show_distances"(platform:"/", type: TrackType.Event) {}

    "/checkout/payment/select_store"(platform:"/", type: TrackType.View) {}

    "/checkout/payment/select_bank"(platform:"/", type: TrackType.View) {}

    "/checkout/payment/view_location"(platform:"/", type: TrackType.View) {}
    "/checkout/payment/view_location/location"(platform:"/", type: TrackType.Event) {}
    "/checkout/payment/view_location/preloaded"(platform:"/", type: TrackType.Event) {}

    "/checkout/payment/input_card"(platform:"/", type: TrackType.View) {}

    "/checkout/payment/input_card/edit_payment"(platform:"/", type: TrackType.Event) {}
    "/checkout/payment/input_card/security_code_tooltip"(platform:"/", type: TrackType.Event) {}
    "/checkout/payment/security_code"(platform:"/", type: TrackType.View) {}

    "/checkout/payment/select_installments"(platform:"/", type: TrackType.View) {}

    "/checkout/payment/select_installments/close_splitter_message"(platform:"/", type: TrackType.Event) {}
    "/checkout/payment/select_installments/click_payment_detail"(platform:"/", type: TrackType.Event) {}
    "/checkout/payment/select_installments/click_box_installments"(platform:"/", type: TrackType.Event) {
        payment_with_click(required:false, type: PropertyType.String, values: ["FirstPayment", "SecondPayment"])
    }

    "/checkout/payment/create_second_password"(platform:"/", type: TrackType.View) {}

    "/checkout/payment/input_second_password"(platform:"/", type: TrackType.View) {}

    "/checkout/payment/input_second_password/edit_payment"(platform:"/", type: TrackType.Event) {}

    "/checkout/payment/billing_information"(platform:"/web", type: TrackType.View) {}

    "/checkout/billing"(platform: "/web", isAbstract: true) {}
    "/checkout/billing/physical_person"(platform:"/web", type: TrackType.View) {}
    "/checkout/billing/legal_person"(platform:"/web", type: TrackType.View) {}

    "/checkout/review/edit_payment"(platform:"/", type: TrackType.Event) {}

    "/checkout/review/edit_first_payment"(platform:"/", type: TrackType.Event) {}

    "/checkout/review/edit_second_payment"(platform:"/", type: TrackType.Event) {}

    "/checkout/review/edit_shipping"(platform:"/", type: TrackType.Event) {}

    "/checkout/review/change_installments"(platform:"/", type: TrackType.Event) {}

    "/checkout/review/change_shipping"(platform:"/", type: TrackType.Event) {}

    "/checkout/review/confirm_purchase"(platform:"/", type: TrackType.Event) {}

    "/checkout/review/change_address"(platform:"/", type: TrackType.View) {}

    "/checkout/review/edit_payment_method"(platform:"/", type: TrackType.View) {}

    "/checkout/review/insufficient_account_money"(platform:"/", type: TrackType.View) {}

    "/checkout/review/high_amount_error"(platform:"/", type: TrackType.View) {}

    "/checkout/review/low_amount_error"(platform:"/", type: TrackType.View) {}

    "/checkout/review/installments_error"(platform:"/", type: TrackType.View) {}

    "/checkout/shipping/store_selection"(platform:"/", type: TrackType.View) {}

    "/checkout/shipping/agencies_contact_info"(platform:"/", type: TrackType.View) {}



    // Suscripciones
    "/checkout/review/edit_frequency"(platform:"/", type: TrackType.Event) {
        frequency(required: true, type: PropertyType.String)
        frequency_before(required: true, type: PropertyType.String)
    }

    //Eventos en la "/checkout/congrats"
    //------------------------------------------------------------------------------------
    "/checkout/finish"(platform:"/", isAbstract: true) {}

    "/checkout/finish/keep_buying"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/go_to_myml"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/go_to_page_bank"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/view_ticket"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/download_ticket"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/show_map"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/save_data"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/contact_us"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/go_to_mercado_puntos"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/added_points"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/send_message"(platform:"/", type: TrackType.Event) {}
    "/checkout/finish/call_seller"(platform:"/", type: TrackType.Event) {}
    //------------------------------------------------------------------------------------

    "/checkout/invalid_sec_code"(platform:"/", type: TrackType.View) {}

    "/checkout/invalid_sec_code/input_code"(platform:"/", type: TrackType.View) {}

    "/checkout/call_for_auth"(platform:"/", isAbstract: true) {}

    "/checkout/call_for_auth/instructions"(platform:"/", type: TrackType.View) {}

    "/checkout/call_for_auth/call_later"(platform:"/", type: TrackType.View) {}

    "/checkout/call_for_auth/input_code"(platform:"/", type: TrackType.View) {}

    "/checkout/session_expire"(platform:"/", type: TrackType.View) {}
    "/checkout/loading"(platform: "/", type: TrackType.View) {}
    "/checkout/loading/error"(platform: "/", type: TrackType.View) {}
    "/checkout/shipping/edit_address"(platform:"/", type: TrackType.Event) {}
    "/checkout/shipping"(platform:"/", type: TrackType.View) {}
    "/checkout/shipping/input_zipcode"(platform:"/", type: TrackType.View) {}
    "/checkout/shipping/input_zipcode/i_dont_know_my_cp"(platform:"/", type: TrackType.Event) {}

    // Addresses

    // Page
    "/checkout/shipping/input_address"(platform:"/", type: TrackType.View, isAbstract: true) {
        items(required: false, type: PropertyType.ArrayList, description: "Array of items in the cart with following data")
        recovery_flow(required: false, description: "Is recovery CHO flow")
    }
    "/checkout/shipping/input_address/map"(platform:"/", type: TrackType.View, isAbstract: true) {
        items(required: false, type: PropertyType.ArrayList, description: "Array of items in the cart with following data")
        recovery_flow(required: false, description: "Is recovery CHO flow")
    }

    // Event
    "/checkout/shipping/input_address/name"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the name")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the name track the name value")
    }
    "/checkout/shipping/input_address/street_name"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the street_name")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the street_name track the street_name value")
    }
    "/checkout/shipping/input_address/zip_code"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the zip_code")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the zip_code track the zip_code value")
    }
    "/checkout/shipping/input_address/city"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the city")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the city track the city value")
    }
    "/checkout/shipping/input_address/colony"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the colony")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the colony track the colony value")
    }
    "/checkout/shipping/input_address/street_number"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the street_number")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the street_number track the street_number value")
    }
    "/checkout/shipping/input_address/references"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the references")
    }
    "/checkout/shipping/input_address/delivery"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the delivery")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the delivery track the delivery value")
    }
    "/checkout/shipping/input_address/delivery_instructions"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the delivery_instructions")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the delivery_instructions track the delivery_instructions value")
    }
    "/checkout/shipping/input_address/phone"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the phone")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the phone track the phone value")
    }
    "/checkout/shipping/input_address/telephone_input"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the telephone_input")
    }
    "/checkout/shipping/input_address/additional_info"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the additional info")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the additional info track the additional info value")
    }
    "/checkout/shipping/input_address/internal_number"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the internal number")
    }
    "/checkout/shipping/input_address/caixa_postal_number"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the caixa postal number")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the caixa postal number track the caixa postal number value")
        items(required: false, type: PropertyType.ArrayList, description: "Array of items in the cart with following data")
        recovery_flow(required: false, description: "Is recovery CHO flow")
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    "/checkout/shipping/input_address/error_map"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the map step")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the map step track the map coordiantes value")
        items(required: false, type: PropertyType.ArrayList, description: "Array of items in the cart with following data")
        recovery_flow(required: false, description: "Is recovery CHO flow")
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }

    "/checkout/shipping/input_address/select_street_name"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        written(required: true, type: PropertyType.String, description: "The written text before selecting a street suggestion")
        finalText(required: true, type: PropertyType.String, description: "The final text after selecting a street suggestion")
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }

    "/checkout/shipping/input_address/select_phone"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        written(required: true, type: PropertyType.String, description: "The written text before selecting a phone suggestion")
        finalText(required: true, type: PropertyType.String, description: "The final text after selecting a phone suggestion")
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    
    "/checkout/shipping/input_address/search_replaced_zip_code"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        count(required: true, type: PropertyType.Numeric, description: "The count of zip codes that are shown after opening the replace zip codes modal")
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }
    
    "/checkout/shipping/input_address/select_replaced_zip_code"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        count(required: true, type: PropertyType.Numeric, description: "The count of zip codes that were shown on the replace zip codes modal")
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }

    "/checkout/shipping/input_address/select_map_position"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        suggested(required: true, type: PropertyType.Map(coordinatesStructure), description: "The suggested coordinates where we positioned the user on the map")
        finalCoordinates(required: true, type: PropertyType.Map(coordinatesStructure), description: "The final coordinates where the user finally positioned on the map")
        session_id(required: false, type: PropertyType.String, description: "Session in which the checkout is being held")
    }

    "/checkout/shipping/input_address/back"(platform:"/", type: TrackType.Event) {}


    "/checkout/shipping/input_address_number"(platform:"/", type: TrackType.View) {}
    "/checkout/shipping/input_address_number/whithout_number"(platform:"/", type: TrackType.Event) {}
    "/checkout/shipping/select_option_detail"(platform:"/", type: TrackType.View) {}
    "/checkout/shipping/input_address_apartment"(platform:"/", type: TrackType.View) {}
    "/checkout/shipping/select_contact_info"(platform:"/", type: TrackType.View) {}
    "/checkout/shipping/add_contact_info"(platform:"/", type: TrackType.View) {}
    "/checkout/shipping/input_contact_info"(platform:"/", type: TrackType.View) {}
    "/checkout/payment/select_unique_installment"(platform:"/", type: TrackType.View) {}
    "/checkout/payment/select_unique_installment/select_installment"(platform: "/", type: TrackType.Event) {}
    "/checkout/payment/select_unique_installment/edit_installment_options"(platform: "/", type: TrackType.Event) {}
    "/checkout/payment/select_first_installment"(platform:"/", type: TrackType.View) {}
    "/checkout/payment/select_second_installment"(platform:"/", type: TrackType.View) {}
    "/checkout/review/edit_unique_installment"(platform:"/", type: TrackType.View) {}
    "/checkout/review/edit_first_installment"(platform:"/", type: TrackType.View) {}
    "/checkout/review/edit_second_installment"(platform:"/", type: TrackType.View) {}

    //Switch track
    "/checkout/payment/select_type/account_money"(platform: "/web", type: TrackType.Event, isAbstract: true) {}
    "/checkout/payment/select_type/account_money/use"(platform: "/web", type: TrackType.Event) {}
    "/checkout/payment/select_type/account_money/not_use"(platform: "/web", type: TrackType.Event) {}

    /*
    * GarEx tracks
    *
    * GarEx es una entidad que representa la garantia que el usuario elige para su producto
    * */

    //mobile
    "/checkout/garex"(platform:"/mobile", type: TrackType.View) {}
    "/checkout/garex/more_info"(platform:"/mobile", type: TrackType.Event) {}
    "/checkout/garex/selected_garex"(platform:"/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Selected warranty id")
        period(required: true, type: PropertyType.Numeric, description: "Contracted warranty period")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for mercado libre")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for mercado libre")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }
    "/checkout/garex/not_selected_garex"(platform:"/mobile", type: TrackType.Event) {}
    "/checkout/garex/delete"(platform:"/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Warranty id removed")
        period(required: true, type: PropertyType.Numeric, description: "Contracted warranty period")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for mercado libre")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for mercado libre")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    /*
    * end GarEx tracks
    * */

    /*
    * CHECKOUT V5
    */


    "/checkout/abort"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/back"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/congrats/back"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/failure"(platform: "/mobile", type: TrackType.Event) {
        error()
        message()
    }

    "/checkout/quantity_changed"(platform: "/mobile", type: TrackType.Event) {
        quantity()
    }

    //--> SHIPPING flow

    "/checkout/shipping_selection"(platform: "/mobile") {  //TODO flow
        available_types()
        current_type(required: false)
        current_option(required: false)
        available_other_methods(required: false)
    }

    "/checkout/shipping_selection/apply"(platform: "/mobile", type: TrackType.Event) {
        type()
        option(required: false)
    }

    "/checkout/shipping_selection/back"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/shipping_selection/address_selection"(platform: "/mobile", type: TrackType.View) {
        invalid_address()
        valid_address()
        available_other_methods(required: false)
    }

    "/checkout/shipping_selection/address_selection/back"(platform: "/mobile", type: TrackType.Event) {
        invalid_address()
        valid_address()
    }

    "/checkout/shipping_cost"(platform: "/mobile") {}

    "/checkout/shipping_cost/back"(platform: "/mobile") {}

    "/checkout/shipping_cost/apply"(platform: "/mobile", type: TrackType.Event) {
        //TODO
    }

    "/checkout/payment_selection"(platform: "/mobile") {
        available_types(type: PropertyType.ArrayList)
        available_other_methods(type: PropertyType.Boolean)
        current_type(required: false)
        current_method(required: false)
        method(required: false)
    }

    "/checkout/payment_selection/apply"(platform: "/mobile", type: TrackType.Event) {
        type()
    }

    "/checkout/payment_selection/back"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/payment_selection/othertype"(platform: "/mobile") {
        available_methods()
    }

    "/checkout/payment_selection/othertype/back"(platform: "/mobile") {}

    "/checkout/order_total"(platform: "/mobile") {}

    "/checkout/order_total/back"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/contact_seller_call"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/contact_seller_email"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/contact_add"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/screenshot"(platform: "/mobile", type: TrackType.Event) {}

    // CREDIT CARDS

    "/credit_cards"(platform: "/mobile", type: TrackType.View) {
        available_cards()
        context()
    }

    "/credit_cards/abort"(platform: "/mobile", type: TrackType.Event) {
        available_cards(required: false)
    }

    "/credit_cards/back"(platform: "/mobile", type: TrackType.Event) {
        available_cards(required: false)
    }

    "/credit_cards/new_card"(platform: "/mobile", type: TrackType.View) {
        available_cards(required: false)
        payment_method_id()
    }

    "/credit_cards/new_card/apply"(platform: "/mobile", type: TrackType.Event) {
        available_cards(required: false)
        card_number()
    }

    "/credit_cards/new_card/back"(platform: "/mobile", type: TrackType.Event) {}

    "/credit_cards/new_card/installments"(platform: "/mobile", type: TrackType.View) {
        available_cards(required: false)
        available_installments()
        payment_method_id(required: false)
    }

    "/credit_cards/new_card/installments/apply"(platform: "/mobile", type: TrackType.Event) {
        available_cards(required: false)
        installment()
    }

    // Checkout V1
    "/checkout/legacy"(platform: "/mobile", isAbstract: true) {}
    "/checkout/legacy/entry"(platform: "/mobile", type: TrackType.Event){
        checkout_version(required: true, PropertyType.String)
        order_payment_required(required: true, PropertyType.String)
        payment_pre_selected(required: true, PropertyType.String)
        shipping_pre_selected(required: true, PropertyType.String)
        quantity_pre_selected(required: true, PropertyType.String)
    }
    "/checkout/legacy/exit"(platform: "/mobile", type: TrackType.Event){
        checkout_version(required: true, PropertyType.String)
        payment_method(required: true, PropertyType.String)
        buy_equals_pay(required: true, PropertyType.String)
        shipping_type(required: true, PropertyType.String)
    }

    "/checkout/user_contact_information"(platform: "/", type: TrackType.Event) {

    }

    "/checkout/payment/select_unique_installment/select_installment"(platform: "/web", type: TrackType.Event) {}

    "/checkout/congrats/pay_with_another"(platform: "/", type: TrackType.Event) {
        items(required: true, type: PropertyType.ArrayList, description: "Array of items in the order with following data")
        recovery_flow(required: false, description: "Is recovery CHO flow")
    }

    "/checkout/congrats/pay_now"(platform: "/", type: TrackType.Event) {
        items(required: true, type: PropertyType.ArrayList, description: "Array of items in the order with following data")
        recovery_flow(required: false, description: "Is recovery CHO flow")
    }

    "/checkout/congrats/use_now"(platform: "/", type: TrackType.Event) {
        items(required: true, type: PropertyType.ArrayList, description: "Array of items in the order with following data")
        recovery_flow(required: false, description: "Is recovery CHO flow")
    }

    //notifications
    "/checkout_recovery"(platform: "/", type: TrackType.View, initiative: "1171") {
        item_id(required: true, type: PropertyType.String, description: "main item id")
        item_status(required: true, type: PropertyType.String, description: "main item status (no-stock, inative, etc)")
    }
    "/checkout_recovery/error"(platform: "/", type: TrackType.View) {}
    "/checkout_recovery/notfound"(platform: "/", type: TrackType.View) {}
}
