package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("merchant credits") {
        //Views
        "/credits/merchant/enrollment"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/credits_conditions"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/preconfirm"(platform: "/web/desktop") {
            amount = 200000
            installments = 9
        }
        "/credits/merchant/enrollment/preconfirm"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/load_documents"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/not_interested"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/review"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/error"(platform: "/web/desktop") {}

        "/credits/merchant/enrollment/feedback"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/feedback/interested"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/feedback/not_interested"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/feedback/success"(platform: "/web/desktop")  {}
        "/credits/merchant/enrollment/feedback/error"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/error/accept"(platform: "/web/desktop") {}

        "/credits/merchant/administrator"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/dashboard"(platform: "/") {
            status = 'offer'
        }
        "/credits/merchant/admin_on_time"(platform: "/web/desktop") {}
        "/credits/merchant/admin_late_pay"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {}
        "/credits/merchant/offer"(platform: "/web/desktop") {}
        "/credits/merchant/no_offer"(platform: "/web/desktop") {}
        "/credits/merchant/public_landing"(platform: "/web/desktop") {
            user_profile = 'offer'
        }

        "/credits/merchant/administrator/next_installment_payment"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/congrats"(platform: "/web/desktop") {
            flow = 'voluntary_payment'
        }
        "/credits/merchant/administrator/error"(platform: "/web/desktop") {
            reason = 'insufficient_account_money'
        }
        "/credits/merchant/administrator/error"(platform: "/web/desktop") {
            reason = 'lender_cannot_collect_installments'
        }
        "/credits/merchant/administrator/error"(platform: "/web/desktop") {
            reason = 'default'
        }

        "/credits/merchant/enrollment/documentation"(platform: "/web/desktop") {
            userType = 'moral'
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
        "/credits/merchant/enrollment/load_documents/user_type"(platform: "/web/desktop", type: TrackType.Event) {
            type = 'moral'
        }
        "/credits/merchant/enrollment/load_documents/cancel"(platform: "/web/desktop", type: TrackType.Event) {}

        //Error merchant
        "/credits/merchant/enrollment/error/try_it_again"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/merchant/enrollment/error/contact_us"(platform: "/web/desktop", type: TrackType.Event) {}

        //Congrats merchant
        "/credits/merchant/enrollment/withdrawal"(platform: "/web/desktop", type: TrackType.Event) {}

        //Dashboard merchant
        "/credits/merchant/hero_cta"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/merchant/second_offer_cta"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/merchant/help"(platform: "/web/desktop", type: TrackType.Event) {}

        //Notification Credits Merchant
        "/credits/merchant/collection"(platform: "/mobile", type: TrackType.Event) {}

        //Money advance Credits
        "/credits/merchant/money_advance/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/money_advance/hub"(platform: "/web/desktop") {}
        "/credits/merchant/money_advance/summary"(platform: "/web/desktop") {}
        "/credits/merchant/money_advance/no_options"(platform: "/web/desktop") {}

    }
}
