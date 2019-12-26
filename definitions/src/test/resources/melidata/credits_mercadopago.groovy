package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("Merchant Credits Enrollment Mobile") {
        def full_offer_detail = {
            [
                segment: 'online',
                offer_type: 'early_offer'
            ]
        }

        def offer_detail_without_offer_type = {
            [
                segment: 'online'
            ]
        }

        def offer_detail_without_segment = {
            [
                offer_type: 'early_offer'
            ]
        }

        "/credits/merchant/enrollment/onboarding"(platform: "/mobile/android") {
            offer = full_offer_detail
            product_types = ['fixed_term_loan']
        }
        "/credits/merchant/enrollment/onboarding"(platform: "/mobile/android") {
            offer = offer_detail_without_offer_type
            product_types = ['sales_percentage_loan']
        }
        "/credits/merchant/enrollment/onboarding"(platform: "/mobile/android") {
            offer = offer_detail_without_segment
            product_types = ['fixed_term_loan', 'sales_percentage_loan']
        }
    }

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
        def express_money_map = {
            [
                product_type: 'express_money',
                segment: 'online',
                is_first_offer: true,
                offer_type: 'early_offer'
            ]
        }

        def fixed_term_map = {
            [
                product_type: 'fixed_term',
                segment: 'online',
                category: 'regular',
                offer_type: 'early_offer'
            ]
        }

        def sales_percentage_map = {
            [
                product_type: 'fixed_term',
                segment: 'online',
                category: 'regular',
                offer_type: 'early_offer',
                status: 'on_time'
            ]
        }

        def express_money = {
            product_type = 'express_money'
            segment = 'online'
            offer_type = 'early_offer'
        }

        def express_money_overdue = {
            product_type = 'express_money'
            segment = 'online'
            offer_type = 'early_offer'
            status = 'overdue'
        }

        def sales_percentage = {
            product_type = 'sales_percentage'
            segment = 'in_store'
            offer_type = 'full_offer'
        }

        def sales_percentage_on_time = {
            product_type = 'sales_percentage'
            segment = 'in_store'
            offer_type = 'full_offer'
            status = 'on_time'
        }

        def fixed_term = {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
        }

        def fixed_term_on_time = {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'on_time'
        }

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
        "/credits/merchant/administrator"(platform: "/", {
            offers = [
                express_money_map()
            ]
            products = [
                fixed_term_map()
            ]
            show_cx_widget = true
        })

        "/credits/merchant/administrator/spc_click"(platform: "/web/desktop") {}
        
        "/credits/merchant/administrator/spc_click"(platform: "/web/desktop") {
            sales_percentage_map()
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
            fixed_term_on_time()
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            express_money_overdue()
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            sales_percentage_on_time()
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            fixed_term_on_time()
        }

        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            fixed_term_on_time()
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            express_money_overdue()
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            sales_percentage_on_time()
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            fixed_term_on_time()
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            fixed_term_on_time()
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            express_money_overdue()
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            sales_percentage_on_time()
        }

        "/credits/merchant/administrator/history"(platform: "/web/desktop") {}

        "/credits/merchant/administrator/payment_history"(platform: "/web/desktop") {
            sales_percentage_map()
        }

        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {}
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {
            fixed_term()
        }
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {
            express_money()
        }

        "/credits/merchant/proactive_payment/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/proactive_payment/congrats"(platform: "/web/desktop") {
            fixed_term()
        }
        "/credits/merchant/proactive_payment/congrats"(platform: "/web/desktop") {
            express_money()
        }

        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'insufficient_account_money'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'lender_cannot_collect_installments'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'installment_paid'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'default'
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'insufficient_account_money'
            fixed_term()
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'lender_cannot_collect_installments'
            express_money()
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'default'
            fixed_term()
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'insufficient_account_money'
            fixed_term()
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'lender_cannot_collect_installments'
            express_money()
        }
        "/credits/merchant/proactive_payment/error"(platform: "/web/desktop") {
            reason = 'default'
            fixed_term()
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
        "/credits/express_money/amount_input"(platform: "/web/desktop") {
            show_onboarding = true
        }

        "/credits/express_money/amount_input"(platform: "/mobile/android") {
            show_onboarding = true
        }

        "/credits/express_money/amount_input"(platform: "/web/desktop") {
            show_onboarding = false
        }

        "/credits/express_money/amount_input"(platform: "/mobile/android") {
            show_onboarding = false
        }

        "/credits/express_money/amount_input"(platform: "/web/desktop") {}

        "/credits/express_money/amount_input"(platform: "/mobile/android") {}

        "/credits/express_money/summary"(platform: "/web/desktop") {
            requested_amount = 700
            max_amount = 1000
			min_amount = 500
        }

        "/credits/express_money/summary"(platform: "/mobile/android") {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
        }

        "/credits/express_money/congrats"(platform: "/web/desktop") {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
            has_prepaid = true
        }

        "/credits/express_money/congrats"(platform: "/mobile/android") {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
            has_prepaid = true
        }

        "/credits/express_money/congrats"(platform: "/web/desktop") {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
            has_prepaid = false
        }

        "/credits/express_money/congrats"(platform: "/mobile/android") {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
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

        "/credits/express_money/error"(platform: "/mobile/android") {
            reason = 'default'
        }

        "/credits/express_money/error"(platform: "/mobile/android") {
            reason = 'server_error'
        }

        "/credits/express_money/error"(platform: "/mobile/android") {
            reason = 'loan_creation'
        }

        "/credits/express_money/error"(platform: "/mobile/android") {
            reason = 'ccb_creation'
        }

        "/credits/express_money/error"(platform: "/mobile/android") {
            reason = 'simulation'
        }

        "/credits/express_money/onboarding"(platform: "/mobile/android") {}
    }

    test("Merchant Public Landing") {
        "/credits/merchant/public_landing"(platform: "/web/desktop") {
            user_profile = 'offer'
        }
        "/credits/merchant/public_landing"(platform: "/web/desktop") {
            user_profile = 'no_offer'
        }

        "/credits/merchant/declarative_form"(platform:"/web/desktop", type: TrackType.View) {}

        "/credits/merchant/declarative_form/congrats"(platform:"/web/desktop", type: TrackType.View) {}
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

        "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
            medium = "email"
            campaign = "updates"
            stage= "em_congrats_credited_loan"
            milestone= -7
        }

        "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
            medium = "email"
            campaign = "updates"
            stage= "em_congrats_debit_installment"
            milestone= 0
        }

        "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
            medium = "email"
            campaign = "collection"
            stage= "em_insufficient_funds"
            milestone= 0
        }

        "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
            medium = "email"
            campaign = "collection"
            stage= "em_expired_daily_charges"
            milestone= 1
        }
    }
}
