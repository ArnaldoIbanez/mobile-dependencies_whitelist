import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    defaultBusiness = "mercadopago"

    // General Path
    "/"(platform: "/", isAbstract: true) {}
    "/prepaid"(platform: "/", isAbstract: true) {}

    // Consulta - Se declara Event o View? o uno y uno?
    // Consulta - user_profile se hereda a los hijos por ser abstract?
    "/prepaid/acquisition/landing"(platform: "/", type: TrackType.Event){ 
        user_profile(
            required: false, 
            type: PropertyType.String, 
            values: ["buyers", "sellers"],
            description: "User profiles."
        )
    }
    "/prepaid/acquisition"(platform: "/", isAbstract: true){}
    "/prepaid/activation"(platform: "/", isAbstract: true){}
    "/prepaid/tracking"(platform: "/", isAbstract: true){}

    // Landing
    // MLA => https://www.mercadopago.com.ar/tarjeta-prepaga
    // MLB => https://www.mercadopago.com.br/cartao-prepago
    "/prepaid/acquisition/landing/card_request"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/on_delivery_card"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/delivered_card"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/inactive/user_request"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/inactive/not_delivered_stolen_card"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/inactive/not_delivered_card"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/landing/active_card"(platform: "/", type: TrackType.View) {}

    // Acquisition Flow
    // MLA => https://www.mercadopago.com.ar/prepaid/acquisition
    // MLB => https://www.mercadopago.com.br/prepaid/acquisition
    "/prepaid/acquisition/confirmation_account"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/congrats/registration"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/juridical_info"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/personal_info"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/personal_info/identity"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/personal_info/gender"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/personal_info/activity"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/review"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/review/welcome"(platform: "/web/mobile", type: TrackType.View) {}
    "/prepaid/acquisition/need_fund"(platform: "/", type: TrackType.View) {}
    "/prepaid/acquisition/congrats"(platform: "/", type: TrackType.Event) {
        congrats_type(
            required: true, 
            type: PropertyType.String, 
            values: ["bapropagos", "pagofacil", "rapipago", "cobroexpress", "cargavirtual", "redlink", "maestro", "debcabal", "bolbradesco"],
            description: "Types of congrats pages by payment method ID."
        )
    }
    "/prepaid/acquisition/error"(platform: "/", type: TrackType.Event) {
        error_type(
            required: true, 
            type: PropertyType.String, 
            values: ["main_error", "have_a_card", "juridical_error", "personal_error", "deceased_error", "underage_error", "denied_error"],
            description: "Types of error pages in acquisition flow."
        )
    }

    // Activation Flow
    // MLA => https://www.mercadopago.com.ar/prepaid/activation
    // MLB => https://www.mercadopago.com.br/prepaid/activation
    "/prepaid/activation/last_digits"(platform: "/", type: TrackType.View) {}
    "/prepaid/activation/marital_status"(platform: "/", type: TrackType.View) {}
    "/prepaid/activation/congrats"(platform: "/", type: TrackType.View) {}
    "/prepaid/activation/error"(platform: "/", type: TrackType.Event) {
        error_type(
            required: true, 
            type: PropertyType.String, 
            values: ["main_error", "not_found"],
            description: "Types of error pages in activitation flow."
        )
    }

    // Shipment tracking
    // MLA => https://www.mercadopago.com.ar/prepaid/tracking
    "/prepaid/tracking"(platform: "/", type: TrackType.Event) {
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
}




























