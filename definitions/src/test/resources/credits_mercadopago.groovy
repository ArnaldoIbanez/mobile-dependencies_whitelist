import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("merchant credits") {
        //Views
        "/credits/merchant/enrollment"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/credits_conditions"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/preconfirm"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/load_documents"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/not_interested"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/review"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/error"(platform: "/web/desktop") {}
        "/credits/merchant/administrator"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {}
        "/credits/merchant/offer"(platform: "/web/desktop") {}
        "/credits/merchant/no_offer"(platform: "/web/desktop") {}
        "/credits/merchant/public_landing"(platform: "/web/desktop") {
            user_profile = 'offer'
        }

        //Events
        //Landing merchant
        "/credits/merchant/enrollment/choose_amount"(platform: "/web/desktop", type: TrackType.Event) {
            amount = 200000
        }
        "/credits/merchant/enrollment/choose_installment"(platform: "/web/desktop", type: TrackType.Event) {
            installment = 9
        }
        "/credits/merchant/enrollment/ask_us"(platform: "/web/desktop", type: TrackType.Event) {}

        //Modal merchant
        "/credits/merchant/enrollment/cancel"(platform: "/web/desktop", type: TrackType.Event) {}

        //Upload Files merchant
        "/credits/merchant/enrollment/user_type"(platform: "/web/desktop", type: TrackType.Event) {
            type = 'moral'
        }
        "/credits/merchant/enrollment/load_documents/cancel"(platform: "/web/desktop", type: TrackType.Event) {}

        //Error merchant
        "/credits/merchant/enrollment/try_it_again"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/merchant/enrollment/contact_us"(platform: "/web/desktop", type: TrackType.Event) {}

        //Congrats merchant
        "/credits/merchant/enrollment/withdrawal"(platform: "/web/desktop", type: TrackType.Event) {}

        //Dashboard merchant
        "/credits/merchant/hero_cta"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/merchant/help"(platform: "/web/desktop", type: TrackType.Event) {}
    }

    test("consumer credits"){
        //Views
        "/credits/consumer/administrator"(platform: "/web/desktop") {}
        "/credits/consumer/administrator/detail"(platform: "/web/desktop") {}
    }
}
