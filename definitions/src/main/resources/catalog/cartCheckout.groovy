import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Inicio All platforms
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

"/cart"(platform: "/", isAbstract: true) {}

"/cart/checkout"(platform: "/", isAbstract: true) { 

    status(required: false, description: "status")
    purchase_id(required: false, description: "Identifier of the purchase")   
    
    seller(required: true, type:PropertyType.ArrayList, description: "Array of sellers with their data")
    //id
    //nickname
    //mercado_lider
    //reputation_level

    shipping(required: false, type:PropertyType.ArrayList)
    // shipping_type,
    // cost,
    // shipping_option,
    // id, -> Solo para CHO Normal (no para cart)
    // name,
    // shipping_method_id,
    // shipping_mode
    // free_shipping_benefit

    payments(required: false, description: "Array of payments information")
    // id
    // payment_splitted -> Indica si hubo que splittear el pago
    // payment_method,
    // payment_type,
    // installments,
    // paid_amount,
    // installment_amount
    // without_fee
    // status
    // status_detail
    // bank -> Indica el banco seleccionado

    items(required: true, type:PropertyType.ArrayList, description: "Array of items in the cart with following data")
    //currency_id
    //item
        //id
        //review_rate -> Lo completa Melidata automaticamente
        //shipping_mode
        //category_path -> Lo completa Melidata automaticamente
        //deal_id -> Lo completa Melidata automaticamente
        //buying_mode -> Lo completa Melidata automaticamente
        //category_id -> Lo completa Melidata automaticamente
        //official_store
        //condition (new / used)
        //listing_type
        //variation_id   
    //quantity
    //unit_price

    total_amount(required: true, description: "totalAmount")
    total_amount_local(serverSide: true) // -> Lo completa Melidata automaticamente
    total_amount_usd(serverSide: true) // -> Lo completa Melidata automaticamente

    total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
    total_paid_amount(required: true, description: "total pais Amount is total_amount_with_shipping plus installments fee")
    
    recovery_flow(required: true, description: "Is recovery CHO flow")
    register_int(required: false, description: "Integrated registration")

    buy_equal_pay(required: true, description: "BP flag")

    resolution(required:false, type: PropertyType.String, description: "Indica si el flujo de compra lo renderiza como la version Low o High")
    precharged_cards(required:false, type: PropertyType.Boolean, description: "Indica si el comprador tiene tarjetas precargadas")

    success(required: false, type: PropertyType.Boolean, description: "Indica que la localizacion del usuario fue exitosa")
    location(required: false, type: PropertyType.String)
    geolocation_method(required: false, type: PropertyType.String)

    billing_info(required:false type:PropertyType.Map, description: "Dictionary containing the user selected billing info")
}

"/cart/checkout/geolocation" (platform: "/", type: TrackType.Event) {
        geolocation_error(required: true, description: "Why the geo failed")
}

"/cart/checkout/items_not_available"(platform:"/", type: TrackType.View) {}

"/cart/checkout/error"(platform:"/", type: TrackType.View) {}

"/cart/checkout/payment"(platform: "/", isAbstract: true) {}

"/cart/checkout/payment/select_method"(platform:"/", type: TrackType.View) {}

"/cart/checkout/payment/select_method/edit_payment"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/payment/select_method/show_distances"(platform:"/", type: TrackType.Event) {}

"/cart/checkout/payment/select_store"(platform:"/", type: TrackType.View) {}

"/cart/checkout/payment/select_bank"(platform:"/", type: TrackType.View) {}

"/cart/checkout/payment/view_location"(platform:"/", type: TrackType.View) {}

"/cart/checkout/payment/input_card"(platform:"/", type: TrackType.View) {}

"/cart/checkout/payment/input_card/edit_payment"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/payment/input_card/security_code_tooltip"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/payment/security_code"(platform:"/", type: TrackType.View) {
    //List of visible fields
    user_identification_fields(required: false, type: PropertyType.ArrayList)
    //user_identification_fields: ["doc_type", "doc_number"]
}

"/cart/checkout/payment/select_installments"(platform:"/", type: TrackType.View) {}

"/cart/checkout/payment/select_installments/close_splitter_message"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/payment/select_installments/click_payment_detail"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/payment/select_installments/click_box_installments"(platform:"/", type: TrackType.Event) {
    payment_with_click(required:false, type: PropertyType.String, values: ["FirstPayment", "SecondPayment"])
}

"/cart/checkout/payment/billing_information"(platform:"/", type: TrackType.View) {
    //List of visible fields
    user_identification_fields(required: false, type: PropertyType.ArrayList)
    //user_identification_fields: ["doc_type", "doc_number", "name", "las_name"]
}

"/cart/checkout/payment/create_second_password"(platform:"/", type: TrackType.View) {}

"/cart/checkout/payment/input_second_password"(platform:"/", type: TrackType.View) {}

"/cart/checkout/payment/input_second_password/edit_payment"(platform:"/", type: TrackType.Event) {}

"/cart/checkout/review"(platform:"/", type: TrackType.View) {
}

"/cart/checkout/review/edit_payment"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/review/edit_first_payment"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/review/edit_second_payment"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/review/edit_shipping"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/review/change_installments"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/review/change_shipping"(platform:"/", type: TrackType.Event) {}

"/cart/checkout/review/change_address"(platform:"/", type: TrackType.View) {}

"/cart/checkout/review/edit_shipping"(platform:"/", type: TrackType.View) {}

"/cart/checkout/review/edit_payment_method"(platform:"/", type: TrackType.View) {}

"/cart/checkout/congrats"(platform:"/", type: TrackType.View) {
    congrats_seq(serverSide: true) // Lo completa Melidata automaticamente
    first_for_order(serverSide: true) // Lo completa Melidata automaticamente         
}

"/cart/checkout/congrats/keep_buying"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/congrats/go_to_myml"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/congrats/go_to_page_bank"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/congrats/view_ticket"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/congrats/download_ticket"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/congrats/show_map"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/congrats/save_data"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/congrats/contact_us"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/congrats/go_to_mercado_puntos"(platform:"/", type: TrackType.Event) {}
"/cart/checkout/congrats/added_points"(platform:"/", type: TrackType.Event) {}

"/cart/checkout/show_ticket"(platform:"/", type: TrackType.View) {}

"/cart/checkout/invalid_sec_code"(platform:"/", type: TrackType.View) {}

"/cart/checkout/invalid_sec_code/input_code"(platform:"/", type: TrackType.View) {}

"/cart/checkout/call_for_auth"(platform:"/", type: TrackType.View) {}

"/cart/checkout/call_for_auth/instructions"(platform:"/", type: TrackType.View) {}

"/cart/checkout/call_for_auth/call_later"(platform:"/", type: TrackType.View) {}

"/cart/checkout/call_for_auth/input_code"(platform:"/", type: TrackType.View) {}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Fin All platforms
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Inicio Mobile platform
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

"/cart"(platform:"/mobile", type: TrackType.View, isAbstract: true) {
    geolocated(required:false, type: PropertyType.Boolean, description: "Indica si se geolocalizo al usuario")    
}

"/cart/checkout"(platform:"/mobile", type: TrackType.View, isAbstract: true) {}

"/cart/checkout/shipping"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/edit_address"(platform:"/mobile", type: TrackType.Event) {}

"/cart/checkout/loading"(platform: "/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/geolocation_permissions"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/geolocation_permissions/allow_geolocation"(platform:"/mobile", type: TrackType.Event, isAbstract: true) {}
"/cart/checkout/shipping/geolocation_permissions/allow_geolocation/Yes"(platform:"/mobile", type: TrackType.Event) {}
"/cart/checkout/shipping/geolocation_permissions/allow_geolocation/No"(platform:"/mobile", type: TrackType.Event) {}

"/cart/checkout/shipping/geolocation_error"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/select_method_geolocated"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/select_method_geolocated/send_to_cp_located"(platform:"/mobile", type: TrackType.Event) {}
"/cart/checkout/shipping/select_method_geolocated/send_to_another_location"(platform:"/mobile", type: TrackType.Event) {}

"/cart/checkout/shipping/select_option"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/select_method_ask_geolocation"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/input_zipcode"(platform:"/mobile", type: TrackType.View) {}
"/cart/checkout/shipping/input_zipcode/i_dont_know_my_cp"(platform:"/mobile", type: TrackType.Event) {}

"/cart/checkout/shipping/input_address"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/input_address_number"(platform:"/mobile", type: TrackType.View) {}
"/cart/checkout/shipping/input_address_number/whithout_number"(platform:"/mobile", type: TrackType.Event) {}

"/cart/checkout/shipping/select_address"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/select_option_detail"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/input_address_apartment"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/select_contact_info"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/add_contact_info"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/shipping/input_contact_info"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/payment"(platform:"/mobile", type: TrackType.View, isAbstract: true) {}

"/cart/checkout/payment/select_unique_installment"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/payment/select_split_installments"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/payment/select_split_installments/split_detail"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/payment/select_first_installment"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/payment/select_second_installment"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/review"(platform:"/mobile", type: TrackType.View, isAbstract: true) {}

"/cart/checkout/review/edit_unique_installment"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/review/edit_first_installment"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/review/edit_second_installment"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/show_geolocation_map"(platform:"/mobile", type: TrackType.View) {}

// 2MP
"/cart/checkout/payments"(platform:"/mobile", type: TrackType.View, isAbstract: true) {}

// switch tracks
"/cart/checkout/payments/2mp"(platform: "/mobile", isAbstract: true) {}
"/cart/checkout/payments/2mp/split"(platform: "/mobile", type: TrackType.Event) {}

"/cart/checkout/payments/2mp#use"(platform: "/mobile", type: TrackType.Event) {}
"/cart/checkout/payments/2mp#not_use"(platform: "/mobile", type: TrackType.Event) {}



//2MP Disclaimer combination modal view.
"/cart/checkout/payments/payment_combination"(platform: "/mobile", isAbstract: true) {}
"/cart/checkout/payments/payment_combination/payment_method_not_supported"(platform:"/mobile", type: TrackType.View) {}

// Discount coupons
"/cart/checkout/payments/add_coupon"(platform:"/mobile", type: TrackType.View) {}
"/cart/checkout/payments/coupon_ok"(platform:"/mobile", type: TrackType.View) {
    coupon(required: true, type: PropertyType.String)
}
"/cart/checkout/payments/add_another_coupon"(platform:"/mobile", type: TrackType.View) {}
"/cart/checkout/payments/coupon_error"(platform:"/mobile", type: TrackType.View) {}

"/cart/checkout/payments/invalid_coupon"(platform:"/mobile", type: TrackType.Event) {}
"/cart/checkout/payments/expired_coupon"(platform:"/mobile", type: TrackType.Event) {}
"/cart/checkout/payments/add_another_coupon/delete_coupon"(platform:"/mobile", type: TrackType.Event) {}

// 2MP Cancelation
"/cart/checkout/payments_cancelation"(platform: "/mobile", type: TrackType.View) {}

//Billing info
    "/checkout/billing/physical_person"(platform: "/mobile") {}
    "/checkout/billing/legal_person"(platform: "/mobile") {}
    "/checkout/review/edit_billing_info"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
    }

// 2MP Inconsistencias
"/cart/checkout/review/discard_payment_combination"(platform: "/mobile") {}

"/cart/checkout/review/inconsistency"(platform: "/mobile", isAbstract: true) {}
"/cart/checkout/review/inconsistency/payment_combination"(platform: "/mobile", isAbstract: true) {}
"/cart/checkout/review/inconsistency/payment_combination/payment"(platform: "/mobile") {}
"/cart/checkout/review/inconsistency/payment_combination/installments"(platform: "/mobile") {}
"/cart/checkout/review/inconsistency/payment_combination/shipping"(platform: "/mobile") {}
"/cart/checkout/review/inconsistency/payment_combination/new_split"(platform: "/mobile") {}



// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Fin Mobile platform
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Inicio Web platform
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

"/cart/checkout/shipping"(platform:"/web", type: TrackType.View) {}

"/cart/checkout/shipping/confirm_geolocation"(platform:"/web", type: TrackType.View) {}
"/cart/checkout/shipping/confirm_geolocation/send_to_cp_located"(platform:"/web", type: TrackType.Event) {}
"/cart/checkout/shipping/confirm_geolocation/send_to_another_location"(platform:"/web", type: TrackType.Event) {}

"/cart/checkout/shipping/input_new_address"(platform:"/web", type: TrackType.View) {}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Fin Web platform
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
