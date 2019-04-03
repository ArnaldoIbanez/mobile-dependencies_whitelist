import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    defaultBusiness = "mercadopago"
    
    //-----------------
    // PREPAID MLA/MLB
    //-----------------

    // General Path
    "/prepaid"(platform: "/", isAbstract: true) {
        user_profile(
            required: false,
            type: PropertyType.String,
            values: ["buyers", "sellers"],
            description: "User profiles."
        )
    }

    "/prepaid/hotjar"(platform: "/", type: TrackType.Event) {
        hotjar_user_id(
            required: true,
            type: PropertyType.String, 
            description: "Recording id of hotjar."
        )
    }

    "/prepaid/acquisition/landing"(platform: "/", isAbstract: true){}
    "/prepaid/acquisition/landing/inactive"(platform: "/", isAbstract: true){}
    "/prepaid/acquisition/registration"(platform: "/", isAbstract: true){}
    "/prepaid/acquisition"(platform: "/", type: TrackType.View) {
        is_point(
            required: false,
            type: PropertyType.Boolean,
            description: "Flag to indicate if is a user of Point."
        )
    }
    "/prepaid/activation"(platform: "/", type: TrackType.View) {}

    // Landing
    // MLA => https://www.mercadopago.com.ar/tarjeta-prepaga
    // MLB => https://www.mercadopago.com.br/cartao-prepago
    "/prepaid/acquisition/landing/card_request"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/on_delivery_card"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/delivered_card"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/inactive/user_request"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/inactive/not_delivered_stolen_card"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/inactive/not_delivered_card"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/need_fund"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/active_card"(platform: "/", type: TrackType.View) {}

    // Acquisition Flow
    // MLA => https://www.mercadopago.com.ar/prepaid/acquisition
    // MLB => https://www.mercadopago.com.br/prepaid/acquisition
    "/prepaid/acquisition/change_dni"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/confirmation_account"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/registration/congrats"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/juridical_info"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/personal_info"(platform: "/", isAbstract: true, type: TrackType.View) {}
    "/prepaid/acquisition/personal_info/identity"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/personal_info/gender"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/personal_info/activity"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/review"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/review/welcome"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/need_fund"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/congrats"(platform: "/", type: TrackType.View) {
        congrats_type(
            required: true, 
            type: PropertyType.String, 
            values: ["prepaid","prepaid_delay", "prepaid_point_different_address", "prepaid_point_same_address","bapropagos", "pagofacil", "rapipago", "cobroexpress", "cargavirtual", "redlink", "maestro", "debcabal", "bolbradesco"],
            description: "Types of congrats pages by payment method ID."
        )
    }
    "/prepaid/acquisition/error"(platform: "/", type: TrackType.View) {
        error_type(
            required: true, 
            type: PropertyType.String, 
            values: ["main_error", "hasprepaid", "deceased", "underage", "mobile", "denied", "identification", "juridical"],
            description: "Types of error pages in acquisition flow."
        )
    }
    "/prepaid/acquisition/cellphone"(platform: "/mobile", type: TrackType.View) {
        error_type(
                required: true,
                type: PropertyType.String,
                values: ["main_error", "hasprepaid", "deceased", "underage", "mobile", "denied", "identification", "juridical"],
                description: "Types of error pages in acquisition flow."
        )
    }
    "/prepaid/acquisition/onboarding"(platform: "/mobile", type: TrackType.View) {
        error_type(
                required: true,
                type: PropertyType.String,
                values: ["main_error", "hasprepaid", "deceased", "underage", "mobile", "denied", "identification", "juridical"],
                description: "Types of error pages in acquisition flow."
        )
    }
    "/prepaid/acquisition/rootfaq"(platform: "/mobile", type: TrackType.View) {
        error_type(
                required: true,
                type: PropertyType.String,
                values: ["main_error", "hasprepaid", "deceased", "underage", "mobile", "denied", "identification", "juridical"],
                description: "Types of error pages in acquisition flow."
        )
    }
    "/prepaid/acquisition/detailfaq"(platform: "/mobile", type: TrackType.View) {
        error_type(
                required: true,
                type: PropertyType.String,
                values: ["main_error", "hasprepaid", "deceased", "underage", "mobile", "denied", "identification", "juridical"],
                description: "Types of error pages in acquisition flow."
        )
    }

    // Activation Flow
    // MLA => https://www.mercadopago.com.ar/prepaid/activation
    // MLB => https://www.mercadopago.com.br/prepaid/activation
    "/prepaid/activation/last_digits"(platform: "/", type: TrackType.View) {}
    "/prepaid/activation/marital_status"(platform: "/", type: TrackType.View) {}
    "/prepaid/activation/congrats"(platform: "/", type: TrackType.View) {}
    "/prepaid/activation/error"(platform: "/", type: TrackType.View) {
        error_type(
            required: true, 
            type: PropertyType.String, 
            values: ["main_error", "max_attempt", "mismatch_dni", "not_found"],
            description: "Types of error pages in activitation flow."
        )
    }

    // Shipment tracking
    // MLA => https://www.mercadopago.com.ar/prepaid/tracking
    "/prepaid/tracking"(platform: "/", type: TrackType.View) {
        status(
            required: true,
            type: PropertyType.String,
            values: ["on_track", "delayed", "to_collect", "not_delivered"],
            description: "Shipment tracking status."
        )
    }

    // Inactivate, To Block card
    // MLA => https://www.mercadopago.com.ar/prepaid/block/congrats
    "/prepaid/block" (platform: "/", type: TrackType.View) {}

    //Webview Activation Flow MLA 
    "/my_cards_webview" (platform: "/mobile", type: TrackType.View) {
        from(
            required: false,
            type: PropertyType.String,
            description: "Webview trigger."
        )
    }




    //-----------------
    // PREPAID MLM
    //-----------------

    // Acquisition Flow
    "/prepaid_card"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/prepaid_card/action_picker"(platform: "/mobile") {}
    "/prepaid_card/web_view"(platform: "/mobile") {}
    
    //New (invalid)
    "/prepaid_card/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
    }
    "/prepaid_card/pay"(platform: "/mobile") {}
    "/prepaid_card/payment_methods"(platform: "/mobile") {}
    "/prepaid_card/other_payment_methods"(platform: "/mobile") {}
    "/prepaid_card/final_scene"(platform: "/mobile", isAbstract: true) {}
    "/prepaid_card/final_scene/prepaid"(platform: "/mobile", isAbstract: true) {}
    "/prepaid_card/final_scene/prepaid/success"(platform: "/mobile") {}
    
    // Acquisition Recharge
    "/prepaid_recharge"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/prepaid_recharge/fill_recharge_data"(platform: "/mobile") {}
    "/prepaid_recharge/recipients"(platform: "/mobile") {}
    "/prepaid_recharge/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    //New (invalid)
    "/prepaid_recharge/add_recipient"(platform: "/mobile") {}
    "/prepaid_recharge/recipient"(platform: "/mobile") {}

}
