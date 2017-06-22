import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("merchant credits") {
        //Views
        "/credits/merchant/enrollment"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/not_interested"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/continue"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/administrator"(platform: "/web/desktop") {}
        "/credits/merchant/offer"(platform: "/web/desktop") {}
        "/credits/merchant/no_offer"(platform: "/web/desktop") {}

        //Events
        //Landing merchant
        "/credits/merchant/enrollment/choose_amount"(platform: "/web/desktop", type: TrackType.Event) {
            amount = 200000
        }
        "/credits/merchant/enrollment/choose_installment"(platform: "/web/desktop", type: TrackType.Event) {
            installment = 9
        }

        //Modal merchant
        "/credits/merchant/enrollment/continue"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/merchant/enrollment/preconfirm"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/merchant/enrollment/cancel"(platform: "/web/desktop", type: TrackType.Event) {}

        //Congrats merchant
        "/credits/merchant/enrollment/withdrawal"(platform: "/web/desktop", type: TrackType.Event) {}

        //Dashboard merchant
        "/credits/merchant/hero_cta"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/merchant/help"(platform: "/web/desktop", type: TrackType.Event) {}
    }

    test("consumer credits"){
        //Views
        "/credits/consumer/administrator"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail"(platform: "/web/desktop", type: TrackType.Event) {}
    }
}
