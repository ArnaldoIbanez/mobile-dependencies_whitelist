package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1048"

    //-----------------
    // PREPAID MLA/MLB
    //-----------------

    // General Path
    "/wallet"(platform: "/", type: TrackType.View) {} 
    "/wallet/cards"(platform: "/", type: TrackType.View) {} 
    "/wallet/cards/prepaid"(platform: "/", type: TrackType.View) {} 

    "/wallet/cards/activation_modal"(platform: "/", isAbstract: true){}
    "/wallet/cards/activation_modal/activation"(platform: "/", type: TrackType.View) {}

    "/wallet/cards/activation_modal/close"(platform: "/", type: TrackType.Event) {} 
    "/wallet/cards/activation_modal/activate_card"(platform: "/", type: TrackType.Event) {} 
    "/wallet/cards/activation_modal/not_receive_card"(platform: "/", type: TrackType.Event) {} 

	"/cards/prepaid-detail"(platform: "/", isAbstract: true) { }

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

    "/prepaid/acquisition/init_point"(platform: "/", type: TrackType.View) {
        referral (required:true, type: PropertyType.String, description: "Where the flow start")
        flow (required:true, type: PropertyType.String, description: "Flow type")
        is_challenge (required:false, type: PropertyType.Boolean, description: "If it is challenge")
        challenge_reason (required:false, type: PropertyType.String, description: "Why challenge has been thrown")
        has_challenged_prepaid (required:false, type: PropertyType.Boolean, description: "If the challenge because of prepaid")
        had_prepaid (required:false, type: PropertyType.Boolean, description: "User had a prepaid")
        has_prepaid (required:false, type: PropertyType.Boolean, description: "User already has a prepaid")
        had_money_last_7d (required:false, type: PropertyType.Boolean, description: "User had money last seven days")
        is_point_seller (required:false, type: PropertyType.Boolean, description: "If user is a point seller")
        bought_point_device (required:false, type: PropertyType.Boolean, description: "User bought a point device")
        current_balance_amount (required:false, type: PropertyType.String, description: "Current balance amount")
        needed_funding_amount (required:false, type: PropertyType.Numeric, description: "User needs fund money to continue")
        has_money (required:false, type: PropertyType.Boolean, description: "User already has money")
        pending_ticket (required:false, type: PropertyType.Boolean, description: "User has a pending ticket")
    }

    "/prepaid/acquisition/change_dni"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/confirmation_account"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/registration/congrats"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/juridical_info"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/personal_info"(platform: "/", isAbstract: true, type: TrackType.View) {}
    "/prepaid/acquisition/personal_info/identity"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/personal_info/gender"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/personal_info/activity"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/review"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/review/welcome"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/need_fund"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/dark_side_shield"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/dark_side_shield/cta"(platform:"/", type: TrackType.Event) {}
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
            values: ["main_error", "hasprepaid", "deceased", "underage", "mobile", "denied", "identification", "juridical", "limited", "operator"],
            description: "Types of error pages in acquisition flow."
        )
    }
    "/prepaid/acquisition/cellphone"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/onboarding/slide"(platform: "/mobile", isAbstract: true) {}
    "/prepaid/acquisition/onboarding/slide/first"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/onboarding/slide/second"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/onboarding/slide/third"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/onboarding/slide/fourth"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/onboarding/slide/fifth"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/onboarding/slide/exit"(platform:"/mobile", type: TrackType.Event) {
        slide(
                required: true,
                type: PropertyType.Numeric,
                description: "Slide number where ocurre the event"
        )
        cause(
                required: true,
                type: PropertyType.String,
                values: ["close", "back"],
                description: "The quit reason"
        )
    }

    "/prepaid/acquisition/rootfaq"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/detailfaq"(platform: "/mobile", type: TrackType.View) {} 

    //Anses Flow
    "/prepaid/acquisition/occupation"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/preview"(platform: "/mobile", type: TrackType.View) {}

    // CNPJ MLB Flow
    "/prepaid/acquisition/legal_representative" (platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/no_complies" (platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/welcome_company" (platform: "/", type: TrackType.View) {}

    // Challenge Flow
    "/prepaid/challenge"(platform: "/mobile", isAbstract: true) {}
    "/prepaid/challenge/pending_ticket"(platform: "/mobile", type: TrackType.View) {
        referral(required: false, type: PropertyType.String, description: "Where the flow start")
    }
    "/prepaid/challenge/delivery"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/challenge/money_in"(platform: "/mobile", isAbstract: true) {}
    "/prepaid/challenge/money_in/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/challenge/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/challenge/onboarding/slide"(platform: "/mobile", isAbstract: true) {}
    "/prepaid/challenge/onboarding/slide/first"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/challenge/onboarding/slide/second"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/challenge/onboarding/slide/third"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/challenge/onboarding/slide/fourth"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/challenge/onboarding/slide/fifth"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/challenge/onboarding/slide/exit"(platform:"/mobile", type: TrackType.Event) {
        slide(
                required: true,
                type: PropertyType.Numeric,
                description: "Slide number where ocurre the event"
        )
        cause(
                required: true,
                type: PropertyType.String,
                values: ["close", "back"],
                description: "The quit reason"
        )
    }

    // Activation Flow
    // MLA => https://www.mercadopago.com.ar/prepaid/activation
    // MLB => https://www.mercadopago.com.br/prepaid/activation
    "/prepaid/acquisition/has_prepaid"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/no_identity"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/is_collaborator"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/limited"(platform: "/mobile", type: TrackType.View) {}
    "/prepaid/activation/last_digits"(platform: "/", type: TrackType.View) {}
    "/prepaid/activation/marital_status"(platform: "/", type: TrackType.View) {}
    "/prepaid/activation/congrats"(platform: "/", type: TrackType.View) {}
    "/prepaid/activation/congrats/change_pin_tap"(platform: "/", type: TrackType.Event) {}
    "/prepaid/activation/congrats/home_tap"(platform: "/", type: TrackType.Event) {}
    "/prepaid/activation/congrats/add_money_tap"(platform: "/", type: TrackType.Event) {}
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
            values: ["on_track", "delayed", "to_collect", "not_delivered", "soon_deliver", "reprogrammed"],
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

    "/prepaid/update_app" (platform: "/mobile", type: TrackType.View) {}
    "/prepaid/ask_from_app" (platform: "/", type: TrackType.View) {}
    "/prepaid/update_app/cta"(platform:"/mobile", type: TrackType.Event) {}
    "/prepaid/acquisition/sellers_landing"(platform: "/", isAbstract: true) {}
    "/prepaid/acquisition/sellers_landing/store_button"(platform:"/", type: TrackType.Event) { }

    // Prepaid Detail
    "/wallet/cards/prepaid/detail" (platform: "/", type: TrackType.View) {}

    // Prepaid Freeze Event
    "/wallet/cards/prepaid/detail/freeze" (platform: "/", type: TrackType.Event) {}

    // Prepaid Unfreeze Event
    "/wallet/cards/prepaid/detail/unfreeze" (platform: "/", type: TrackType.Event) {}

    // Prepaid Change Pin
    "/prepaid/change_pin" (platform: "/", isAbstract: true) {}

    // Prepaid Change Pin Phone Info
    "/prepaid/change_pin/phone_info" (platform: "/", type: TrackType.View) {}

    // Prepaid Change Pin New Pin
    "/prepaid/change_pin/new_pin" (platform: "/", type: TrackType.View) {}

    // Prepaid Change Pin Congrats
    "/prepaid/change_pin/congrats" (platform: "/", type: TrackType.View) {}
    // Prepaid Reissue
    "/prepaid/reissue" (platform: "/", isAbstract: true) {}

    // Prepaid Reissue inactivate card
    "/prepaid/reissue/inactivate_card" (platform: "/", type: TrackType.View) {}

    // Prepaid Change phone info
    "/prepaid/reissue/phone_info" (platform: "/", type: TrackType.View) {}

    // Prepaid FAQ Root
    "/prepaid/faq" (platform: "/", type: TrackType.View) {}

    // Prepaid FAQ Details
    "/prepaid/faq/detail" (platform: "/", type: TrackType.View) {}
    "/prepaid/faq/detail/payment_rejected" (platform: "/", type: TrackType.View) {}
    "/prepaid/faq/detail/extraction_rejected" (platform: "/", type: TrackType.View) {}
    "/prepaid/faq/detail/rejected_international_authorization" (platform: "/", type: TrackType.View) {}

    //Prepaid FAQ Details Events
    "/prepaid/faq/detail/payment_rejected/money_in" (platform: "/", type: TrackType.Event) {}
    "/prepaid/faq/detail/payment_rejected/reissue" (platform: "/", type: TrackType.Event) {}
    "/prepaid/faq/detail/extraction_rejected/reissue" (platform: "/", type: TrackType.Event) {}
    "/prepaid/faq/detail/rejected_international_authorization/money_in" (platform: "/", type: TrackType.Event) {}
    "/prepaid/faq/detail/rejected_international_authorization/reissue" (platform: "/", type: TrackType.Event) {}
    
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

    // PJ Onboarding
    "/prepaid/acquisition/pj_onboarding"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/pj_onboarding/tap"(platform: "/", type: TrackType.Event) {}
    "/prepaid/acquisition/pj_onboarding/error"(platform: "/", type: TrackType.Event) {}

    // Onboarding Adapt KYC
    "/prepaid/acquisition/onboarding_adapt_kyc"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/onboarding_adapt_kyc/tap"(platform: "/", type: TrackType.Event) {}
    "/prepaid/acquisition/onboarding_adapt_kyc/error"(platform: "/", type: TrackType.Event) {}

    // Congrats Adapt KYC 
    "/prepaid/acquisition/adapt_kyc"(platform: "/", isAbstract: true){}
    "/prepaid/acquisition/adapt_kyc/congrats"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/adapt_kyc/congrats/tap"(platform: "/", type: TrackType.Event) {
        deeplink (required:true, type: PropertyType.String, description: "Screen pushed by the action")
    }
    "/prepaid/acquisition/adapt_kyc/congrats/error"(platform: "/", type: TrackType.Event) {}

    //Prepaid click ask for card
    "/cards/prepaid-detail/click-ask-for-card" (platform: "/web/desktop", type: TrackType.Event) {
         deviceType (
            required: true,
            type: PropertyType.String,
            values: ["desktop"],
            description: "Device type click ask for card"
        )
    } 
}
