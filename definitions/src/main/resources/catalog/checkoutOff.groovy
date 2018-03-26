import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    // Chekout Flow
    "/checkout_off"(platform: "/", isAbstract: true){
        checkout_flow_id(required: true, description: "checkout flow id")
        collector_id(required: true)
        collector_nickname(required: true)
        preference_id(required: false)
        scope(required: false, description: "pool that generates the tracks: mla, mlb, mlm, rola, revamp")
    }

    "/checkout_off/init"(platform: "/", type: TrackType.View) {}
    "/checkout_off/congrats"(platform: "/", type: TrackType.View) {
        payment_status(required: true)
        payment_id(required: false)
        payment_status_detail(required: true)
        payment_method_id(required: true)
        payment_type_id(required: true)
        is_express(required: true, type: PropertyType.Boolean)
        is_split(required: false, type: PropertyType.Boolean)
    }

    "/checkout_off/payment_option"(platform: "/", type: TrackType.View){
        top_groups(required: false, description: "Top level groups") //fue borrado este campo.
    }

    "/checkout_off/payment_option/ticket"(platform: "/", type: TrackType.View){}

    "/checkout_off/payment_option/bank_transfer"(platform: "/", type: TrackType.View){}

    "/checkout_off/payment_option/cards"(platform: "/", type: TrackType.View){}

    "/checkout_off/review"(platform: "/", type: TrackType.View){
        payment_type(required: true, description:"Payment type ID")
        payment_method(required: true, description:"Payment method ID")
        issuer (required: false, description:"Card's bank issuer. Null if account money")
        has_shipping(required: true, description:"Does the preference have shipping?")
        has_payer_shipping_data(required: false, description:"Did the payer add/select an address? Applicable only when has_shipping = true")
        shipping_mode(required: false)
    }

    "/checkout_off/express"(platform: "/", type: TrackType.View){
        payment_type(required: true, description:"Payment type ID")
        payment_method(required: true, description:"Payment method ID")
        issuer (required: false, description:"Card's bank issuer. Null if account money")
        only_account_money(required: true, description:"Is account money the only available option for express checkout?")
        has_shipping(required: true, description:"Does the preference have shipping?")
        has_payer_shipping_data(required: false, description:"Did the payer add/select an address? Applicable only when has_shipping = true")
        shipping_mode(required: false)
    }

    "/checkout_off/congrats/approved"(platform: "/", type: TrackType.View){}

    "/checkout_off/congrats/pending"(platform: "/", type: TrackType.View) {}

    "/checkout_off/congrats/instructions"(platform: "/", type: TrackType.View) {}

    "/checkout_off/congrats/rejected"(platform: "/", type: TrackType.View) {}

    "/checkout_off/shipping"(platform: "/", type: TrackType.View) {
        shipping_mode (required: true, description:"Either me2/custom/not_specified")
        local_pickup (required: true, description:"If the payer can pickup the item instead of shipping")
        free_method (required: false, description:"Any free shipping method?")
        payer_addresses (required: false, description:"Payer address count")
    }

    "/checkout_off/shipping/address"(platform: "/", type: TrackType.View) {}

    "/checkout_off/shipping/method"(platform: "/", type: TrackType.View) {
        shipping_method_count (required: true, description:"How many shipping methods are offered to the payer?")
    }

    "/checkout_off/login"(platform: "/", type: TrackType.View) { }

    "/checkout_off/login/guest"(platform: "/", type: TrackType.View) { }

    "/checkout_off/login/discount"(platform: "/", type: TrackType.View) { }

    "/checkout_off/card"(platform: "/", isAbstract: true) {}

    "/checkout_off/card/credit_card"(platform: "/", type: TrackType.View) {}

    "/checkout_off/card/debit_card"(platform: "/", type: TrackType.View) {}

    "/checkout_off/card/split"(platform: "/", type: TrackType.View) {}

    "/checkout_off/error"(platform: "/", isAbstract: true) {}

    "/checkout_off/error/validation"(platform:"/", type: TrackType.View) {
        failure_code (required: false)
    }

    "/checkout_off/error/expired"(platform:"/", type: TrackType.View) {
        ms_since_expiration (required: true)
    }

    "/checkout_off/error/internal"(platform:"/", type: TrackType.View) {
        response_status(required: true)
        exception_message(required: false)
    }

    //-----------------------Unified tracking catalog--------------------

    "/checkout_off/v1"(platform: "/", isAbstract: true){
        client_id(required: true, description: "Application's client_id")
        environment(required: true, description: "Production or staging tracks")
        screen_name(required: false, description: "A describing name of the screen viewed or where an event occurred")
    }

    // A new checkout flow has been started
    "/checkout_off/v1/init"(platform: "/", type: TrackType.Event){
        purchase_amount(required: false)
    }

    "/checkout_off/v1/payment_method_selected"(platform: "/", type: TrackType.Event){
        payment_method(required: true)
        payment_type(required: true)
        purchase_amount(required: true)
        automatic_selection(required:true)
    }

    // The user has completed the checkout and confirmed its intention to pay. This will be used to track conversion, but does not mean that the payment has been processed."
    "/checkout_off/v1/checkout_confirmed"(platform: "/", type: TrackType.Event){
        payment_method(required: false)
        payment_type(required: false)
        purchase_amount(required: false)
    }

    "/checkout_off/v1/payment_created"(platform: "/", type: TrackType.Event){
        payment_id(required: true)
        payment_amount(required: true)
        payment_method(required: true)
        payment_type(required: true)
        payment_status(required: true)
        payment_status_detail(required: true)
    }

    "/checkout_off/v1/payment_canceled"(platform: "/", type: TrackType.Event){
        payment_id(required: true)
        payment_method(required: true)
        payment_type(required: true)
        payment_amount(required: true)
    }

    "/checkout_off/v1/login"(platform: "/", type: TrackType.View){}

    "/checkout_off/v1/login/guest"(platform: "/", type: TrackType.View){}

    "/checkout_off/v1/login/discount"(platform: "/", type: TrackType.View){}

    "/checkout_off/v1/express"(platform: "/", type: TrackType.View){}

    "/checkout_off/v1/payment_option"(platform: "/", type: TrackType.View){}

    "/checkout_off/v1/payment_option/ticket"(platform: "/", type: TrackType.View){}

    "/checkout_off/v1/payment_option/bank_transfer"(platform: "/", type: TrackType.View){}

    "/checkout_off/v1/payment_option/cards"(platform: "/", type: TrackType.View){}

    "/checkout_off/v1/additional_info"(platform: "/", isAbstract: true) {}

    "/checkout_off/v1/additional_info/bolbradesco"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/additional_info/khipu"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/additional_info/redpagos"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/additional_info/abitab"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/additional_info/pse"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/card"(platform: "/", isAbstract: true) {}

    "/checkout_off/v1/card/credit_card"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/card/debit_card"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/card/issuer"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/card/installments"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/identification"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/shipping"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/shipping/address"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/shipping/method"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/review"(platform: "/", type: TrackType.View){}
    
    "/checkout_off/v1/congrats"(platform: "/", isAbstract: true){}

    "/checkout_off/v1/congrats/approved"(platform: "/", type: TrackType.View){}

    "/checkout_off/v1/congrats/pending"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/congrats/instructions"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/congrats/rejected"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/congrats/in_process"(platform: "/", type: TrackType.View) {}

    "/checkout_off/v1/consumer_credit"(platform: "/", isAbstract: true){}

    "/checkout_off/v1/consumer_credit/installments"(platform: "/", type: TrackType.View) {}
}
