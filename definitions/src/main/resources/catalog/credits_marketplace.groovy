package src.main.resources.catalog

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    defaultBusiness = "mercadolibre"

    "/"(platform: "/web", isAbstract: true) {
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/vip"(platform: "/", isAbstract: true) {}
    "/vip/credits"(platform: "/", isAbstract: true) {}
    "/vip/credits/pursue"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Consumers Public Landings
     ******************************************/
    //Public Landing

    //Page views
    "/credits/consumer/public_landing"(platform: "/", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }

    //Events
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
     *       End: Consumers Public Landings
     ******************************************/


    /******************************************
    *       Start: Consumers Administrator
    ******************************************/
    //Admin Dashboard

    //Page Views
    "/credits/consumer/administrator"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/administrator/dashboard"(platform: "/", type: TrackType.View) {
        dashboard_status(type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
    }

    //Events
    "/credits/consumer/administrator/tooltip"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/payment_intention"(platform: "/", type: TrackType.Event) {
        installment_status(
            type: PropertyType.String,
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
        payment_intention(type: PropertyType.String, required: true, values: ['cho','ticket'])
    }
    "/credits/consumer/administrator/details_button"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/help"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/educational_landing"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/see_product"(platform: "/", type: TrackType.Event) {}

    //Admin History (Compras Finalizadas)

    //Page views
    "/credits/consumer/administrator/history"(platform: "/", type: TrackType.View) {}

    //Events
    "/credits/consumer/administrator/history/details_button"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/history/educational_landing"(platform: "/", type: TrackType.Event) {}

    /******************************************
    *       End: Consumers Administrator
    ******************************************/

    /******************************************
     *       Start: Consumers Admin Detail (mobile in ML)
     ******************************************/

    "/credits/consumer/administrator/detail"(platform: "/mobile/android", type: TrackType.View) {}

    /******************************************
     *       Start: Consumers Admin Detail
     ******************************************/

    /******************************************
     *       Start: Consumers Enrollment
     ******************************************/
    //Landing consumer
    "/credits/consumer/enrollment"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/educational"(platform: "/", type: TrackType.View) {}

    //SMS validation
    "/credits/consumer/enrollment/sms_validation"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/sms_validation/cancel"(platform: "/", type: TrackType.Event) {}

    //Verification
    "/credits/consumer/enrollment/code_verification"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/code_verification/cancel"(platform: "/", type: TrackType.Event) {}

    //Congrats
    "/credits/consumer/enrollment/congrats"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/congrats/buy"(platform: "/", type: TrackType.Event) {}

    /******************************************
     *       End: Consumers Enrollment
     ******************************************/

    /******************************************
     *       Start: Consumers Push
     ******************************************/

    //Landing Push Native
    //Page views
    "/credits/consumer/payinstallment"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: false)
    }

    //Events
    "/credits/consumer/payinstallment/on_time_pay"(platform: "/", type: TrackType.Event) {}

    //Delayed payment
    "/credits/consumer/payinstallment/overdue_pay"(platform: "/", type: TrackType.Event) {}

    /******************************************
     *       End: Consumers Push
     ******************************************/

    /******************************************
     *       Start: Consumers Recurring Campaign
     ******************************************/
    //Page Views
    "/credits/consumer/recurring_landing_test"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/recurring_congrats_test"(platform: "/", type: TrackType.View) {}

    //Event Views
    "/credits/consumer/like_recurring"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/dislike_recurring"(platform: "/", type: TrackType.Event) {}
    /******************************************
     *       End: Consumers Recurring Campaign
     ******************************************/

     /******************************************
      *       Start: Consumers Persue Campaign
      ******************************************/
     //Page Views

     "/vip/credits/pursue/overdue_modal"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {
       status(type: PropertyType.String, required: true,
         values: ["PAYMENT_INTENTION_PRE_RESTRICTION", "PAYMENT_INTENTION_POST_RESTRICTION"])
       milestone(type: PropertyType.Numeric , required: true)
     }

     //Event Views
     "/vip/credits/pursue/overdue_modal/payment_intention"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
       status(type: PropertyType.String, required: true,
         values: ["PAYMENT_INTENTION_PRE_RESTRICTION", "PAYMENT_INTENTION_POST_RESTRICTION"])
       milestone(type: PropertyType.Numeric , required: true)
     }
     /******************************************
      *       End: Consumers Persue Campaign
      ******************************************/


}
