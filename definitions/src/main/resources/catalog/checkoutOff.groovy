import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    // Chekout Flow
    "/checkout_off"(platform: "/", isAbstract: true){
        checkout_flow_id(required: true, description: "checkout flow id")
        collector_id(required: true)
        collector_nickname(required: true)
        preference_id(required: true)
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

}
