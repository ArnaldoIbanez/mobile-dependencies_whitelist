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
    "/credits/consumer/administrator"(platform: "/", isAbstract: true) {}
    "/credits/consumer/administrator/detail"(platform: "/", isAbstract: true) {}

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

    /**
    Admin Dashboard
    **/
    // Page views
    "/credits/consumer/administrator"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/administrator/dashboard"(platform: "/", type: TrackType.View) {
        dashboard_status(type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
    }
    "/credits/consumer/administrator/detail"(platform: "/", type: TrackType.View) {}
    
    // Events
    "/credits/consumer/administrator/tooltip"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/payment_intention"(platform: "/", type: TrackType.Event) {
        installment_status(
            required: true,
            description: "Current status of clicked pay button",
            values: [
                'on_time',
                'to_expire_soft',
                'to_expire_hard',
                'expired_today',
                'no_charge_period',
                'fixed_charge_period_1',
                'fixed_charge_period_2',
                'daily_charge_period'
            ]
        )
    }
    "/credits/consumer/administrator/details_button"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/help"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/educational_landing"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/see_product"(platform: "/", type: TrackType.Event) {}

    /**
    Admin History (Compras Finalizadas)
    **/
    // Page views
    "/credits/consumer/administrator/history"(platform: "/", type: TrackType.View) {}

    // Events
    "/credits/consumer/administrator/history/details_button"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/history/educational_landing"(platform: "/", type: TrackType.Event) {}

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
    "/credits/consumer/payinstallment"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: false)
    }

    "/credits/consumer/payinstallment/on_time_pay"(platform: "/", type: TrackType.Event) {}

    //Delayed payment
    "/credits/consumer/payinstallment/late_pay"(platform: "/", type: TrackType.Event) {}
}
