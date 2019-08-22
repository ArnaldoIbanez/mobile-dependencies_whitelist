package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("Merchant Credits Enrollment") {
        "/credits/merchant/enrollment"(platform: "/web/desktop") {
            status = 'pending'
            product_type = 'default'
            is_capped_offer= true
        }
        "/credits/merchant/enrollment"(platform: "/web/desktop") {
            status = 'rejected'
            product_type = 'early_offer'
            is_capped_offer= false
        }
        "/credits/merchant/enrollment"(platform: "/web/desktop") {
            status = 'approved'
            sub_status = 'review_pending'
            product_type = 'point'
            is_capped_offer= false
        }
        "/credits/merchant/enrollment/without_proposal"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/confirmation"(platform: "/web/desktop") {
            amount = 200000
            installments = 9
        }
        "/credits/merchant/enrollment/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/enrollment/error"(platform: "/web/desktop") {
            reason = 'loan_creation'
        }
        "/credits/merchant/enrollment/documentation"(platform: "/web/desktop") {
            user_type = 'moral'
        }
        "/credits/merchant/enrollment/documentation"(platform: "/web/desktop") {
            user_type = 'physical'
        }
        "/credits/merchant/enrollment/documentation/congrats"(platform: "/web/desktop") {
            user_type = 'moral'
        }
        "/credits/merchant/enrollment/documentation/congrats"(platform: "/web/desktop") {
            user_type = 'physical'
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
        "/credits/merchant/enrollment/feedback"(platform: "/web/desktop") {
            reason = 'capped'
        }
        "/credits/merchant/enrollment/feedback/congrats"(platform: "/web/desktop") {
            reason = 'interested'
        }
        "/credits/merchant/enrollment/feedback/congrats"(platform: "/web/desktop") {
            reason = 'not_interested'
        }
        "/credits/merchant/enrollment/feedback/congrats"(platform: "/web/desktop") {
            reason = 'capped'
        }
        "/credits/merchant/enrollment/feedback/error"(platform: "/web/desktop") {}
    }

    test("Merchant Credits Administrator") {        
        "/credits/merchant/administrator"(platform: "/") {}
        "/credits/merchant/administrator"(platform: "/") {
            status = 'on_time'
        }
        "/credits/merchant/administrator"(platform: "/") {
            status = 'overdue'
        }
        "/credits/merchant/administrator"(platform: "/") {
            status = 'empty'
        }
        "/credits/merchant/administrator"(platform: "/") {
            offers = [
                {
                    product_type = 'express_money'
                    segment = 'online'
                    offer_type = 'early_offer'
                    is_first_offer = true
                },
                {
                    product_type = 'sales_percentage'
                    segment = 'in_store'
                    offer_type = 'full_offer'
                    is_first_offer = false
                }
            ]
            products = [
                {
                    product_type = 'fixed_term'
                    segment = 'online'
                    category = 'regular'
                    offer_type = 'early_offer'
                    status = 'on_time'
                }
            ]
            show_widget = true
        }
        "/credits/merchant/administrator"(platform: "/") {
            offers = [
                {
                    product_type = 'fixed_term'
                    segment = 'in_store'
                    offer_type = 'full_offer'
                    is_first_offer = false
                }
            ]
            products = [
                {
                    product_type = 'fixed_term'
                    segment = 'online'
                    category = 'regular'
                    offer_type = 'early_offer'
                    status = 'on_time'
                },
                {
                    product_type = 'express_money'
                    segment = 'in_store'
                    category = 'refinance'
                    offer_type = 'full_offer'
                    status = 'overdue'
                },
                {
                    product_type = 'sales_percentage'
                    segment = 'in_store'
                    category = 'regular'
                    offer_type = 'early_offer'
                    status = 'on_time'
                }
            ]
            show_widget = false
        }
        "/credits/merchant/administrator/error"(platform: "/web/desktop") {}

        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            status = 'on_time'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            status = 'overdue'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            status = 'finished'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'on_time'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            product_type = 'express_money'
            segment = 'in_store'
            category = 'refinance'
            offer_type = 'full_offer'
            status = 'overdue'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            product_type = 'sales_percentage'
            segment = 'in_store'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'on_time'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'finished'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'on_time'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            product_type = 'express_money'
            segment = 'in_store'
            category = 'refinance'
            offer_type = 'full_offer'
            status = 'overdue'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            product_type = 'sales_percentage'
            segment = 'in_store'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'on_time'
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'finished'
        }
        
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'on_time'
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            product_type = 'express_money'
            segment = 'in_store'
            category = 'refinance'
            offer_type = 'full_offer'
            status = 'overdue'
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            product_type = 'sales_percentage'
            segment = 'in_store'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'overdue'
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            mproduct_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'finished'
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'overdue'
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            product_type = 'express_money'
            segment = 'in_store'
            category = 'refinance'
            offer_type = 'full_offer'
            status = 'on_time'
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            product_type = 'sales_percentage'
            segment = 'in_store'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'on_time'
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'finished'
        }
        "/credits/merchant/administrator/history"(platform: "/web/desktop") {}
        
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {}
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
        }
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {
            product_type = 'express_money'
            segment = 'in_store'
            category = 'refinance'
            offer_type = 'full_offer'
        }
        
        "/credits/merchant/proactive_payment/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/proactive_payment/congrats"(platform: "/web/desktop") {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
        }
        "/credits/merchant/proactive_payment/congrats"(platform: "/web/desktop") {
            product_type = 'express_money'
            segment = 'in_store'
            category = 'refinance'
            offer_type = 'full_offer'
        }
        
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'insufficient_account_money'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'lender_cannot_collect_installments'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'default'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'insufficient_account_money'
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'lender_cannot_collect_installments'
            product_type = 'express_money'
            segment = 'in_store'
            category = 'refinance'
            offer_type = 'full_offer'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'default'
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'insufficient_account_money'
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'lender_cannot_collect_installments'
            product_type = 'express_money'
            segment = 'in_store'
            category = 'refinance'
            offer_type = 'full_offer'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'default'
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
        }
    }

    test("Money Advance") {
        "/credits/merchant/money_advance/hub"(platform: "/web/desktop") {
            user_status = 'on_time'
        }
        "/credits/merchant/money_advance/hub"(platform: "/web/desktop") {
            user_status = 'overdue'
        }
        "/credits/merchant/money_advance/hub"(platform: "/mobile/android") {}
        "/credits/merchant/money_advance/summary"(platform: "/web/desktop") {}
        "/credits/merchant/money_advance/congrats"(platform: "/web/desktop") {
            status = 'on_time'
            user_status = 'on_time'
        }
        "/credits/merchant/money_advance/congrats"(platform: "/web/desktop") {
            status = 'delayed'
            user_status = 'overdue'
        }
        "/credits/merchant/money_advance/congrats"(platform: "/mobile/android") {}
        "/credits/merchant/money_advance/no_options"(platform: "/web/desktop") {}
        "/credits/merchant/money_advance/error"(platform: "/web/desktop") {
            reason = 'bad_request'
        }
        "/credits/merchant/money_advance/error"(platform: "/web/desktop") {
            reason = 'internal_server_error'
        }
        "/credits/merchant/money_advance/error"(platform: "/web/desktop") {
            reason = 'unknown'
        }
    }

    test("Express money") {
        "/credits/express_money"(platform: "/web/desktop") {
            show_onboarding = true
        }

        "/credits/express_money"(platform: "/web/desktop") {
            show_onboarding = false
        }

        "/credits/express_money/summary"(platform: "/web/desktop") {
            requested_amount = 700
            max_amount = 1000
        }

        "/credits/express_money/congrats"(platform: "/web/desktop") {
            requested_amount = 700
            max_amount = 1000
            has_prepaid = true
        }

        "/credits/express_money/congrats"(platform: "/web/desktop") {
            requested_amount = 700
            max_amount = 1000
            has_prepaid = false
        }

        "/credits/express_money/error"(platform: "/web/desktop") {
            reason = 'default'
        }

        "/credits/express_money/error"(platform: "/web/desktop") {
            reason = 'server_error'
        }

        "/credits/express_money/error"(platform: "/web/desktop") {
            reason = 'loan_creation'
        }

        "/credits/express_money/error"(platform: "/web/desktop") {
            reason = 'ccb_creation'
        }

        "/credits/express_money/error"(platform: "/web/desktop") {
            reason = 'simulation'
        }
    }

    test("Merchant Public Landing") {
        "/credits/merchant/public_landing"(platform: "/web/desktop") {
            user_profile = 'offer'
        }
        "/credits/merchant/public_landing"(platform: "/web/desktop") {
            user_profile = 'no_offer'
        }
    }

    test('Merchant Collection') {
        "/credits/merchant/collection"(platform: "/mobile", type: TrackType.Event) {}
    }

    test('Merchant Contacts') {
        "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
            medium = "email"
            campaign = "engage"
        }

        "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
            medium = "email"
            campaign = "collection"
            stage= "educational"
            milestone= -27
        }

    }
}
