package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("Merchant Credits Enrollment") {
        "/credits/merchant/enrollment"(platform: "/web/desktop") {
            status = 'pending'
        }
        "/credits/merchant/enrollment"(platform: "/web/desktop") {
            status = 'rejected'
        }
        "/credits/merchant/enrollment"(platform: "/web/desktop") {
            status = 'approved'
        }
        "/credits/merchant/enrollment/confirmation"(platform: "/web/desktop") {
            amount = 200000
            installments = 9
        }
        "/credits/merchant/enrollment/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/error"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/error"(platform: "/web/desktop") {
            reason = 'loan_creation_failed'
        }
        "/credits/merchant/enrollment/documentation"(platform: "/web/desktop") {
            userType = 'moral'
        }
        "/credits/merchant/enrollment/documentation"(platform: "/web/desktop") {
            userType = 'physical'
        }
        "/credits/merchant/enrollment/documentation/congrats"(platform: "/web/desktop") {
            userType = 'moral'
        }
        "/credits/merchant/enrollment/documentation/congrats"(platform: "/web/desktop") {
            userType = 'physical'
        }
        "/credits/merchant/enrollment/documentation/error"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/testimonials"(platform: "/web/desktop") {
            brand = 'interfuerzas'
        }
        "/credits/merchant/enrollment/feedback"(platform: "/web/desktop") {
            reason = 'interested'
        }
        "/credits/merchant/enrollment/feedback"(platform: "/web/desktop") {
            reason = 'not_interested'
        }
        "/credits/merchant/enrollment/feedback/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/feedback/error"(platform: "/web/desktop") {}
    }

    test("Merchant Credits Administrator") {
        "/credits/merchant/administrator"(platform: "/") {
            status = 'on_time'
        }
        "/credits/merchant/administrator"(platform: "/") {
            status = 'overdue'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            status = 'on_time'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            status = 'overdue'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            status = 'finished'
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/voluntary_payment"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/voluntary_payment/congrats"(platform: "/web/desktop") {
            flow = 'voluntary_payment'
        }
        "/credits/merchant/administrator/voluntary_payment/error"(platform: "/web/desktop") {
            reason = 'insufficient_account_money'
        }
        "/credits/merchant/administrator/voluntary_payment/error"(platform: "/web/desktop") {
            reason = 'lender_cannot_collect_installments'
        }
        "/credits/merchant/administrator/voluntary_payment/error"(platform: "/web/desktop") {
            reason = 'default'
        }
        "/credits/merchant/offer"(platform: "/web/desktop", type: TrackType.View) {}
        "/credits/merchant/no_offer"(platform: "/web/desktop", type: TrackType.View) {}
        "/credits/merchant/admin_on_time"(platform: "/web/desktop", type: TrackType.View) {}
        "/credits/merchant/admin_late_pay"(platform: "/web/desktop", type: TrackType.View) {}
        "/credits/merchant/hero_cta"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/merchant/second_offer_cta"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/merchant/help"(platform: "/web/desktop", type: TrackType.Event) {}
    }

    test("Money Advance") {
        "/credits/merchant/money_advance"(platform: "/web/desktop") {}
        "/credits/merchant/money_advance/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/money_advance/hub"(platform: "/web/desktop") {}
        "/credits/merchant/money_advance/summary"(platform: "/web/desktop") {}
        "/credits/merchant/money_advance/no_options"(platform: "/web/desktop") {}
    }

    test("Merchant Public Landing") {
        "/credits/merchant/offer"(platform: "/web/desktop") {}
        "/credits/merchant/no_offer"(platform: "/web/desktop") {}
        "/credits/merchant/public_landing"(platform: "/web/desktop") {
            user_profile = 'offer'
        }
    }

    test('Merchant Collection') {
        "/credits/merchant/collection"(platform: "/mobile", type: TrackType.Event) {}
    }
}
