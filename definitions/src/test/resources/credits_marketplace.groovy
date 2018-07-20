package src.test.resources
import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("consumer credits") {
        //Views
        "/credits/consumer/enrollment"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/educational"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/sms_validation"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/code_verification"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/congrats"(platform: "/web/desktop") {}
        "/credits/consumer/payinstallment"(platform: "/web/mobile") {}
        "/credits/consumer/payinstallment/on_time"(platform: "/web/mobile") {}
        "/credits/consumer/payinstallment/late_pay"(platform: "/web/mobile") {}
        "/credits/consumer/payinstallment/payed"(platform: "/web/mobile") {}

        // Public Landing
        "/credits/consumer/public_landing"(platform: "/web/desktop") {
            user_profile = 'no_offer'
        }

        //Events
        "/credits/consumer/enrollment/sms_validation/cancel"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/enrollment/code_verification/cancel"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/enrollment/congrats/buy"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/payinstallment/on_time/pay"(platform: "/web/mobile", type: TrackType.Event) {}
        "/credits/consumer/payinstallment/late_pay/pay"(platform: "/web/mobile", type: TrackType.Event) {}
        "/credits/consumer/public_landing/click_hero"(platform: "/web/mobile", type: TrackType.Event) { user_profile = 'no_offer' }
        "/credits/consumer/public_landing/click_activation"(platform: "/web/desktop", type: TrackType.Event) { user_profile = 'no_offer' }
        "/credits/consumer/public_landing/click_help"(platform: "/web/mobile", type: TrackType.Event) { user_profile = 'guest' }

        /******************************************
        *       Start: Consumers Administrator
        ******************************************/
        /**
        Admin Dashboard
        **/
        // Views
        "/credits/consumer/administrator"(platform: "/web/desktop") {}
        "/credits/consumer/administrator/dashboard"(platform: "/web/desktop") {}
        "/credits/consumer/administrator/dashboard"(platform: "/web/desktop", type: TrackType.View) { loan_status = 'empty_state' }
        "/credits/consumer/administrator/dashboard"(platform: "/web/desktop", type: TrackType.View) { loan_status = 'on_time' }
        "/credits/consumer/administrator/dashboard"(platform: "/web/desktop", type: TrackType.View) { loan_status = 'overdue' }

        //Events
        "/credits/consumer/administrator/tooltip"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/help"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/educational_landing"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/see_product"(platform: "/web/desktop", type: TrackType.Event) {}

        /**
        Admin History (Compras Finalizadas)
        **/
        // Views
        "/credits/consumer/administrator/history"(platform: "/web/desktop") {}

        //Events
        "/credits/consumer/administrator/history/detail"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/history/educational_landing"(platform: "/web/desktop", type: TrackType.Event) {}

        /******************************************
        *       End: Consumers Administrator
        ******************************************/
    }
}
