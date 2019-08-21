package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

def model_product_fixed_term(String product_status) {
    def model_product_fixed_term = {
        product_type = 'fixed_term'
        segment = 'online'
        category = 'regular'
        offer_type = 'early_offer'
    }

    if (product_status != '')
        model_product_fixed_term.status = product_status

    return model_product_fixed_term
}
def model_product_express_money(String product_status) {
    def model_product_express_money = {
        product_type = 'express_money'
        segment = 'in_store'
        category = 'refinance'
        offer_type = 'full_offer'
        if (product_status != '')
            status = product_status
    }
    return model_product_express_money
}
def model_product_sales_percentage(String product_status) {
    def model_product_sales_percentage = {
        product_type = 'express_money'
        segment = 'in_store'
        category = 'refinance'
        offer_type = 'full_offer'
        if (product_status != '')
            status = product_status
    }
    return model_product_sales_percentage
}


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
        def model_offer_fixed_term = {
            product_type = 'fixed_term'
            segment = 'in_store'
            offer_type = 'full_offer'
            is_first_offer = false
        }
        def model_offer_express_money = {
            product_type = 'express_money'
            segment = 'online'
            offer_type = 'early_offer'
            is_first_offer = true
        }
        def model_offer_sales_percentage = {
            product_type = 'sales_percentage'
            segment = 'in_store'
            offer_type = 'full_offer'
            is_first_offer = false
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
        "/credits/merchant/administrator"(platform: "/") {
            offers = [
                    model_offer_express_money(),
                    model_offer_sales_percentage()
            ]
            products = [
                model_product_fixed_term('on_time')
            ]
            show_widget = true
        }
        "/credits/merchant/administrator"(platform: "/") {
            offers = [
                model_offer_fixed_term()
            ]
            products = [
                model_product_fixed_term('on_time'),
                model_product_express_money('overdue'),
                model_product_sales_percentage('on_time')
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
            model_product_fixed_term('on_time')
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            model_product_express_money('overdue')
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            model_product_sales_percentage('on_time')
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            model_product_fixed_term('finished')
        }
        
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            model_product_fixed_term('on_time')
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            model_product_express_money('overdue')
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            model_product_sales_percentage('overdue')
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            model_product_fixed_term('finished')
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            model_product_fixed_term('overdue')
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            model_product_express_money('on_time')
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            model_product_sales_percentage('on_time')
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            model_product_fixed_term('finished')
        }
        
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {}
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {
            model_product_fixed_term('')
        }
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {
            model_product_express_money('')
        }
        
        "/credits/merchant/proactive_payment/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/proactive_payment/congrats"(platform: "/web/desktop") {
            model_product_fixed_term('')
        }
        "/credits/merchant/proactive_payment/congrats"(platform: "/web/desktop") {
            model_product_express_money('')
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
