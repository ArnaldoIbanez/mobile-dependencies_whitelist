import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //CHECKOUT FLOW

    "/checkout"(platform: "/", isAbstract: true) {
    }

    "/checkout/ordercreated"(platform: "/web", type: TrackType.Event) {
        order_id()
        status()
        total_amount()
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
        platform()

        buyer()
        //id
        //nickname
        seller(type: PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
        errors()

        congrats_seq(serverSide: true)
        first_for_order(serverSide: true)
        total_amount_local(serverSide: true)
        total_amount_usd(serverSide: true)
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

    "/checkout/payments"(platform: "/web", isAbstract: true) {
        order_id(required: true, description: "OrderId")
        status(required: true, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: true, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        register_int(required: false, description: "Integrated registration")
        platform()

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee

        shipping(required: false)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id

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

        tracking_referer_page(required: false, description: "tracking referer page from where the request came")
    }
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
        order_id(required: false, description: "OrderId") //Apps might not have an order
        status(required: false, description: "status") //Apps might not have an order
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: true, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        register_int(required: false, description: "Integrated registration")
        platform()

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee

        shipping(required: false)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id

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
        buyer(required: false)
        //id
        //nickname

        seller(required: false, type: PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
    }

    "/checkout/congrats"(platform: "/web") {
        order_id(required: true, description: "OrderId")
        status(required: true, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: true, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        register_int(required: false, description: "Integrated registration")
        platform()

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: false)
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

        proactive_two_payment(required: false, description: "tracking proactive two payment selection")
        total_amount_local(serverSide: true)
        total_amount_usd(serverSide: true)
    }

    /** *****************************************************************/
    //Mobile Checkout Apps
    "/checkout/wrapper"(platform: "/mobile") {} //Melidata experiment
    "/checkout/init"(platform: "/mobile") {
        //Might not have most of status values in case of requestFailure
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: false, description: "totalAmount")
        total_amount_with_shipping(required: false, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: false, description: "BP flag")
        recovery_flow(required: false, description: "Is recovery CHO flow")
        platform(required: true)

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: false)
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

        buyer(required: false)
        //id
        //nickname

        seller(required: false, type: PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
        //View specific data
        success(required: true, type: PropertyType.Boolean)
        location(required: false, type: PropertyType.String)
        geolocation_method(required: false, type: PropertyType.String)
    }
    "/checkout/geolocation"(platform: "/mobile", type: TrackType.Event) {
        geolocation_error(required: true, description: "Why the geo failed")
    }
    "/checkout/shipping"(platform: "/mobile", isAbstract: true) {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        platform(required: true)

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
    //Fallback/Custom shipping
    "/checkout/shipping/select_method"(platform: "/mobile") {
        //View specific data
        selections(required: true, type: PropertyType.ArrayList)
    }
    //Fallback/inconsistency
    "/checkout/shipping/select_method/inconsistency"(platform: "/mobile") {
        //View specific data
        error_code(required: false, type: PropertyType.String)
        inconsistency(required: false, type: PropertyType.String)
    }
    //Geolocation on fallback
    "/checkout/shipping/select_method/ask_enable_geolocation"(platform: "/mobile") {}
    "/checkout/shipping/select_method/ask_enable_geolocation#geolocation_permission_ask"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        granted(required: true, type: PropertyType.String)
    }
    "/checkout/shipping/select_method/ask_enable_geolocation#geolocation_enabled"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        status(required: true, type: PropertyType.String)
    }
    "/checkout/shipping/select_method/ask_enable_geolocation#unable_to_use_location_services"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
    }
    //Geolocation
    "/checkout/shipping/select_method/geolocated"(platform: "/mobile") {}
    "/checkout/shipping/custom_address"(platform: "/mobile", isAbstract: true) {}
    //Input zip_code
    "/checkout/shipping/custom_address/zip_code"(platform: "/mobile") {}
    "/checkout/shipping/custom_address/zip_code#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
    }
    //Query zip code
    "/checkout/shipping/custom_address/zip_code/query"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {
    }
    "/checkout/shipping/custom_address/zip_code/query#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        query_parameters(required: false, type: PropertyType.String)
        failing_url(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/custom_address/zip_code/query/back"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
    }
    "/checkout/shipping/select_option"(platform: "/mobile", isAbstract: true) {
        //View specific data
        shipping_options(required: true, type: PropertyType.ArrayList)
        //shipping_options: [
        //  [
        //    method_name: "Normal",
        //    price: 0.0,
        //    currency_id: "ARS",
        //    free_shipping: true
        //  ]
        //]
    }
    //Select shippingOptions
    "/checkout/shipping/select_option/mercado_envios"(platform: "/mobile") {}
    "/checkout/shipping/select_option/free_shipping"(platform: "/mobile") {}
    "/checkout/shipping/select_option/custom"(platform: "/mobile") {}
    //Input address flow
    "/checkout/shipping/select_contact"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        is_from_preload_address(required: true, type: PropertyType.Boolean)
    }

    "/checkout/shipping/location"(platform: "/mobile", isAbstract: true) {}
    "/checkout/shipping/location/address#street_name"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        street_name(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#street_number"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        street_number(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#additional_info"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        additional_info(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#internal_number"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        internal_number(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#between_streets"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        between_streets(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#references"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        references(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#neighborhood"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        neighborhood(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address"(platform: "/mobile") {
        //View specific data
        edit_flow(required: true, type: PropertyType.Boolean)
    }
    "/checkout/shipping/location/select_state"(platform: "/mobile") {}
    "/checkout/shipping/location/select_city"(platform: "/mobile") {}
    "/checkout/shipping/location/select_city/invalid_destination"(platform: "/mobile") {}
    "/checkout/shipping/location/select_contact#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        success(required: true, type: PropertyType.Boolean)
        error_codes(required: false, type: PropertyType.ArrayList)
    }
    "/checkout/shipping/location/select_contact"(platform: "/mobile") {
        //View specific data
        available_options(required: true, type: PropertyType.Numeric)
    }
    "/checkout/shipping/location/find_contact"(platform: "/mobile") {}
    "/checkout/shipping/location/new_contact"(platform: "/mobile") {
        //View specific data
        //Contact name/phone
        contact_name(required: false, type: PropertyType.String)
        contact_phone(required: false, type: PropertyType.String)
    }
    //Select address
    "/checkout/shipping/select_address"(platform: "/mobile") {
        //View specific data
        //List of available shipping_options
        shipping_options(required: true, type: PropertyType.ArrayList)
        //shipping_options: [
        //  [
        //    method_name: "Normal",
        //    price: 0.0,
        //    currency_id: "ARS",
        //    free_shipping: true
        //  ]
        //]
    }
    "/checkout/shipping/select_address/list"(platform: "/mobile") {
        shipping_options(required: false, type: PropertyType.ArrayList)
    }

    // Store map
    "/checkout/shipping/select_store_map"(platform: "/mobile") {}
    "/checkout/shipping/select_store_map#agencies_request"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        agencies(required: true, description: "the number of agencies returned by the request")
        item_id(required: true, description: "the item id for which we are requesting agencies")
        latitude(required: false, description: "the latitude at which we are requesting agencies")
        longitude(required: false, description: "the longitude at which we are requesting agencies")
    }

    //Select paymentMethod
    "/checkout/payments/preload_credit_card"(platform: "/mobile", type: TrackType.View) {}//Melidata experiment
    "/checkout/payments"(platform: "/mobile", isAbstract: true) {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        platform(required: true)

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
    "/checkout/payments/select_method"(platform: "/mobile") {
        //List of available payment_methods and coupon info
        available_methods(required: true, type: PropertyType.ArrayList)
        coupon(required: false, type: PropertyType.Boolean)
        coupon_discount(required: false, type: PropertyType.Numeric)
    }
    "/checkout/payments/select_method#new_payment_method_selected"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        payment_method_id(required: false, type: PropertyType.String)
        payment_type_id(required: false, type: PropertyType.String)
    }
    "/checkout/payments/coupon_detail"(platform: "/mobile") {}
    // Add card form
    "/checkout/payments/add_debit_card"(platform: "/mobile") {}
    "/checkout/payments/add_debit_card#card_config"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        bin(required: true, type: PropertyType.String)
        success(required: true, type: PropertyType.Boolean)
    }
    "/checkout/payments/add_debit_card/select_bank"(platform: "/mobile") {
        available_issuers(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payments/add_prepaid_card"(platform: "/mobile") {}
    "/checkout/payments/add_prepaid_card#card_config"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        bin(required: true, type: PropertyType.String)
        success(required: true, type: PropertyType.Boolean)
    }
    "/checkout/payments/add_card"(platform: "/mobile") {}
    "/checkout/payments/add_card#card_config"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        bin(required: true, type: PropertyType.String)
        success(required: true, type: PropertyType.Boolean)
    }
    "/checkout/payments/add_card/select_bank"(platform: "/mobile") {
        available_issuers(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payments/add_card/installments"(platform: "/mobile") {
        //List of available installments
        available_installments(required: true, type: PropertyType.ArrayList)
        //installments: [
        //    [
        //      installment: 1,
        //      amount: 20.6,
        //      without_fee: true
        //    ]
    }
    "/checkout/payments/stored_card"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payments/stored_card/select_bank"(platform: "/mobile") {
        available_methods(required: true, type: PropertyType.ArrayList, description: "list of available banks")
    }
    "/checkout/payments/stored_card/security_code"(platform: "/mobile") {}
    "/checkout/payments/stored_card/installments"(platform: "/mobile") {
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
    "/checkout/payments/stored_card/installments#change_payment_method"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        event_source(required: true, type: PropertyType.String)
    }
    "/checkout/payments/account_money"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payments/account_money/create"(platform: "/mobile") {}
    "/checkout/payments/account_money/password"(platform: "/mobile") {}
    "/checkout/payments/account_money/password#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
    }
    "/checkout/payments/select_issuer"(platform: "/mobile") {}
    // mlm grouping
    "/checkout/payments/cash"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payments/cash/select_store"(platform: "/mobile") {
        available_methods(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payments/cash/select_store/select_address"(platform: "/mobile", parentPropertiesInherited: false) {}
    "/checkout/payments/cash/select_store#request_permissions"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        permissions(required: true, type: PropertyType.String)
        extended(required: true, type: PropertyType.Boolean)
    }
    "/checkout/payments/transfer"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payments/transfer/select_bank"(platform: "/mobile") {
        available_methods(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payments/billing_info"(platform: "/mobile") {}
    "/checkout/payments/billing_info#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        billing_info_state(required: true, type: PropertyType.String)
    }
    "/checkout/payments/consumer_credits"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payments/consumer_credits/installments"(platform: "/mobile") {
        //List of available installments
        available_installments(required: true, type: PropertyType.ArrayList)
        //installments: [
        //    [
        //      installment: 1,
        //      amount: 20.6,
        //      without_fee: true
        //    ]
    }
    // payment promotions screen. Eg: bank promos in MLA
    "/checkout/payments/promotions"(platform: "/mobile") {}
    //"/checkout/review" //shared between web and app, already defined in web section.
    "/checkout/review#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        status(required: true, type: PropertyType.String)
        credit_card_id(required: false, type: PropertyType.String)
    }
    "/checkout/review/quantity#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
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
        //old_value, new_value
        old_value(required: true, type: PropertyType.String)
        new_value(required: true, type: PropertyType.String)
    }
    "/checkout/review/edit_shipping"(platform: "/mobile") {
        //List of available shipping_options
        shipping_options(required: true, type: PropertyType.ArrayList)
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
        //old_value, new_value
        old_value(required: true, type: PropertyType.Numeric)
        new_value(required: true, type: PropertyType.Numeric)
    }
    "/checkout/review/edit_installments"(platform: "/mobile") {
        //List of available installments
        available_installments(required: true, type: PropertyType.ArrayList)
        //installments: [
        //    [
        //      installment: 1,
        //      amount: 20.6,
        //      without_fee: true
        //    ]
    }
    "/checkout/review/terms"(platform: "/mobile") {}
    "/checkout/additional_info"(platform: "/mobile") {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        platform(required: true)

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
    "/checkout/congrats"(platform: "/mobile") {
        /** **************************************/
        //Desktop and New CHO congrats tracs
        //TODO chage to required: true once legacy
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: false, description: "totalAmount")
        total_amount_with_shipping(required: false, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: false, description: "BP flag")
        recovery_flow(required: false, description: "Is recovery CHO flow")
        register_int(required: false, description: "Integrated registration")
        platform(required: false)

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: false)
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

        buyer(required: false)
        //id
        //nickname

        seller(required: false, type: PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
        available_actions(required: false, type: PropertyType.ArrayList, description: "Action presented on the screen, for ex: call_seller, email_seller, etc.")

        checkout_version(required: false, type: PropertyType.String)
        /** **************************************/
        //Legacy App Congrats Tracks
        duplicated_error(required: false)
        congrats_seq(serverSide: true)
        total_amount_local(serverSide: true)
        total_amount_usd(serverSide: true)
        first_for_order(serverSide: true)
    }
    "/checkout/finish#click"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        action(required: true, description: "Action executed, for ex: call_seller, email_seller, etc")
    }
    "/checkout/congrats/error"(platform: "/mobile") {}

    "/checkout/congrats/call_for_auth"(platform: "/mobile") {}

    "/checkout/congrats/call_for_auth/instructions"(platform: "/mobile") {}

    "/checkout/congrats/call_for_auth/later"(platform: "/mobile") {}

    "/checkout/congrats/invalid_sec_code"(platform: "/mobile") {}

    "/checkout/congrats/invalid_sec_code/input"(platform: "/mobile", parentPropertiesInherited: false) {

    }

    "/checkout/finish"(platform: "/mobile", isAbstract: true) {
        /** **************************************/
        // Same as congrats tracks
        order_id(required: true, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: false, description: "totalAmount")
        total_amount_with_shipping(required: false, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: false, description: "BP flag")
        recovery_flow(required: false, description: "Is recovery CHO flow")
        register_int(required: false, description: "Integrated registration")
        platform(required: false)

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

        shipping(required: false)
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

        buyer(required: false)
        //id
        //nickname

        seller(required: false, type: PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
    }

    "/checkout/finish/choose_action"(platform: "/mobile") {
        /* choose from a list of actions what to do. Eg: choose user homebanking */
    }

    "/checkout/congrats/pending"(platform: "/mobile") {}

    "/checkout/error"(platform: "/mobile") {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: false, description: "totalAmount")
        total_amount_with_shipping(required: false, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: false, description: "BP flag")
        recovery_flow(required: false, description: "Is recovery CHO flow")
        platform(required: false)

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: false)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

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
        error_code(required: true, type: PropertyType.String)
    }

    "/checkout/show_ticket"(platform: "/mobile") {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        platform(required: true)
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
    "/checkout/show_ticket#save"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/checkout/show_geolocation_map"(platform: "/mobile") {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        platform(required: true)
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
    "/checkout/show_geolocation_map/search"(platform: "/mobile") {}
    "/checkout/show_geolocation_map/search#location"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
    }
    "/checkout/show_geolocation_map/search#preloaded"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
    }
    "/checkout/show_geolocation_map/search#select"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
    }
    "/checkout/show_geolocation_map#agencies_request"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        agencies(required: true)
        payment_method(required: true)

    }

    /** *****************************************************************/
    //Mobile Checkout Legacy Apps
    "/checkout"(platform: "/mobile") {
        order_id(required: false)
        status(required: false)
        checkout_version(required: false, description: "Checkout Version")
        total_amount(required: false, type: PropertyType.Numeric)
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

        shipping(required: false)
        //shipping_type
        //shipping_option

        payments(required: false, description: "Array of payment information") //
        // id
        // payment_method,
        // payment_type,
        // installments,
        // selected_card
        // financed_order_cost_for_card
        // payment_must_call_for_authorize

        status_detail(required: false)
        reloaded(required: false)
        quantity_pre_selected(required: false)
        order_payment_required(required: false)
        shipping_pre_selected(required: false)

        item_id(deprecated: true, required: false)
        quantity(deprecated: true, required: false)
        order_cost(deprecated: true, required: false)
    }

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
}
