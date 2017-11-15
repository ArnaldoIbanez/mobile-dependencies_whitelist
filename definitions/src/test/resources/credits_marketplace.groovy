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
        "/credits/consumer/payinstallment/on_time"(platform: "/web/mobile") {}
        "/credits/consumer/payinstallment/late_pay"(platform: "/web/mobile") {}
        "/credits/consumer/payinstallment/payed"(platform: "/web/mobile") {}

        //Events
        "/credits/consumer/enrollment/sms_validation/cancel"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/enrollment/code_verification/cancel"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/enrollment/congrats/buy"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/payinstallment/on_time/pay"(platform: "/web/mobile", type: TrackType.Event) {}
        "/credits/consumer/payinstallment/late_pay/pay"(platform: "/web/mobile", type: TrackType.Event) {}
    }
}
