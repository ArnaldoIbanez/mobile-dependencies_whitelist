package src.main.resources.catalog

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    defaultBusiness = "mercadolibre"

    "/"(platform: "/web", isAbstract: true) {
    }

    //Definitions - Consumer
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/credits/consumer/enrollment"(platform: "/", isAbstract: true) {}

    //Landing consumer
    "/credits/consumer/enrollment"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/educational"(platform: "/", type: TrackType.View) {}

    //Public Landing consumer
    "/credits/consumer/public_landing"(platform: "/", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }
    "/credits/consumer/public_landing/click_hero"(platform: "/", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }
    "/credits/consumer/public_landing/click_activation"(platform: "/", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }
    "/credits/consumer/public_landing/click_help"(platform: "/", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }

    /******************************************
    *       Start: Consumers Administrator
    ******************************************/
    //Definitions
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/credits/consumer/administrator"(platform: "/", isAbstract: true) {}
    "/credits/consumer/administrator/history"(platform: "/", isAbstract: true) {}

    /**
    Admin Dashboard
    **/
    // Page views
    "/credits/consumer/administrator"(platform: "/", type: TrackType.View) {}
    "/credits/consumers/administrator/dashboard"(platform: "/", type: TrackType.View) {}
    "/credits/consumers/administrator/empty_state"(platform: "/", type: TrackType.View) {}
    "/credits/consumers/administrator/on_time"(platform: "/", type: TrackType.View) {}
    "/credits/consumers/administrator/late_pay"(platform: "/", type: TrackType.View) {}
    
    // Events
    "/credits/consumers/administrator/tooltip"(platform: "/", type: TrackType.Event) {}
    "/credits/consumers/administrator/pagar"(platform: "/", type: TrackType.Event) {}
    "/credits/consumers/administrator/detalle"(platform: "/", type: TrackType.Event) {}
    "/credits/consumers/administrator/ayuda"(platform: "/", type: TrackType.Event) {}
    "/credits/consumers/administrator/landing_educativa"(platform: "/", type: TrackType.Event) {}
    "/credits/consumers/administrator/ver_producto"(platform: "/", type: TrackType.Event) {}

    /**
    Admin History (Compras Finalizadas)
    **/
    // Page views
    "/credits/consumers/administrator/compras_finalizadas"(platform: "/", type: TrackType.View) {}

    // Events
    "/credits/consumers/administrator/compras_finalizadas/detalle"(platform: "/", type: TrackType.Event) {}
    "/credits/consumers/administrator/compras_finalizadas/landing_educativa"(platform: "/", type: TrackType.Event) {}

    /******************************************
    *       End: Consumers Administrator
    ******************************************/

    //SMS validation
    "/credits/consumer/enrollment/sms_validation"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/sms_validation/cancel"(platform: "/", type: TrackType.Event) {}

    //Verification
    "/credits/consumer/enrollment/code_verification"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/code_verification/cancel"(platform: "/", type: TrackType.Event) {}

    //Congrats
    "/credits/consumer/enrollment/congrats"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/congrats/buy"(platform: "/", type: TrackType.Event) {}

    //Landing Push Native
    //On Time payment
    "/credits/consumer/payinstallment/"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/payinstallment/on_time"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/payinstallment/on_time/pay"(platform: "/", type: TrackType.Event) {}

    //Delayed payment
    "/credits/consumer/payinstallment/late_pay"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/payinstallment/late_pay/pay"(platform: "/", type: TrackType.Event) {}

    //Payed
    "/credits/consumer/payinstallment/payed"(platform: "/", type: TrackType.View) {}
}
