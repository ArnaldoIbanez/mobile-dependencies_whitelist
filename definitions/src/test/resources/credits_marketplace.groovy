package src.test.resources
import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("consumer credits") {

        /******************************************
         *       Start: Consumers Public Landings
         ******************************************/
        //Public Landing

        //Page views
        "/credits/consumer/public_landing"(platform: "/web/desktop") {
            user_profile = 'no_offer'
        }
        "/credits/consumer/public_landing/click_hero"(platform: "/web/mobile", type: TrackType.Event) { user_profile = 'no_offer' }
        "/credits/consumer/public_landing/click_activation"(platform: "/web/desktop", type: TrackType.Event) { user_profile = 'no_offer' }
        "/credits/consumer/public_landing/click_help"(platform: "/web/mobile", type: TrackType.Event) { user_profile = 'guest' }

        /******************************************
         *       End: Consumers Public Landings
         ******************************************/


        /******************************************
         *       Start: Consumers Enrollment
         ******************************************/
        //Admin Dashboard

        //Page Views
        "/credits/consumer/enrollment"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/educational"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/sms_validation"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/code_verification"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/congrats"(platform: "/web/desktop") {}
        "/credits/consumer/payinstallment"(platform: "/web/mobile") {
            status = 'late_pay'
        }

        //Events
        "/credits/consumer/payinstallment/on_time_pay"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/payinstallment/late_pay"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/enrollment/sms_validation/cancel"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/enrollment/code_verification/cancel"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/enrollment/congrats/buy"(platform: "/web/desktop", type: TrackType.Event) {}

        /******************************************
         *       End: Consumers Enrollment
         ******************************************/


        /******************************************
        *       Start: Consumers Administrator
        ******************************************/
        //Admin Dashboard

        //Views
        "/credits/consumer/administrator"(platform: "/web/desktop") {}
        "/credits/consumer/administrator/dashboard"(platform: "/web/desktop", type: TrackType.View) { dashboard_status = 'empty_state' }
        "/credits/consumer/administrator/detail"(platform: "/web/desktop") {}

        //Events
        "/credits/consumer/administrator/tooltip"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {
            installment_status= 'on_time'
            payment_intention= 'cho'
        }
        "/credits/consumer/administrator/details_button"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/help"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/educational_landing"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/see_product"(platform: "/web/desktop", type: TrackType.Event) {}

        //Admin History (Compras Finalizadas)

        // Views
        "/credits/consumer/administrator/history"(platform: "/web/desktop") {}

        //Events
        "/credits/consumer/administrator/history/details_button"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/history/educational_landing"(platform: "/web/desktop", type: TrackType.Event) {}

        /******************************************
        *       End: Consumers Administrator
        ******************************************/


        /******************************************
         *       Start: Consumers Push
         ******************************************/

        //Landing Push Native
        // Page views
        "/credits/consumer/payinstallment"(platform: "/", type: TrackType.View) {
            status = 'on_time'
        }

        // Events views
        "/credits/consumer/payinstallment/on_time_pay"(platform: "/", type: TrackType.Event) {}

        //Delayed payment
        "/credits/consumer/payinstallment/late_pay"(platform: "/", type: TrackType.Event) {}

        /******************************************
         *       End: Consumers Push
         ******************************************/

        /******************************************
         *       Start: Consumers Recurring Campaign
         ******************************************/
        //Page Views
        "/credits/consumer/recurring_landing_test"(platform: "/web/desktop", type: TrackType.View) {}
        "/credits/consumer/recurring_congrats_test"(platform: "/web/desktop", type: TrackType.View) {}

        //Events
        "/credits/consumer/like_recurring"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/dislike_recurring"(platform: "/web/desktop", type: TrackType.Event) {}
        /******************************************
         *       End: Consumers Recurring Campaign
         ******************************************/
    }
}
