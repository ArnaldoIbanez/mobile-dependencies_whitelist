package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("Merchant Credits Enrollment Mobile") {

        def fixed_term = {
            product_type = 'fixed_term'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
        }

        //Onboarding
        "/credits/merchant/enrollment/onboarding"(platform: "/mobile/android") {
            offer = [
                segment : 'online',
                offer_type : 'early_offer'
            ]
            product_types = ['sales_percentage_loan']
            is_kyc_compliant = true
        }
        "/credits/merchant/enrollment/onboarding"(platform: "/mobile/android") {
            offer = [
                segment : 'online'
            ]
            product_types = ['fixed_term_loan']
            is_kyc_compliant = true
        }
        "/credits/merchant/enrollment/onboarding"(platform: "/mobile/android") {
            offer = [
                offer_type : 'early_offer'
            ]
            product_types = ['sales_percentage_loan', 'fixed_term_loan']
            is_kyc_compliant = false
        }
        "/credits/merchant/enrollment/onboarding"(platform: "/mobile/android") {
            offer = [
                    segment : 'online'
            ]
            product_types = ['fixed_term_loan']
            is_kyc_compliant = false
        }
        "/credits/merchant/enrollment/onboarding"(platform: "/mobile/android") {
            product_types = ['fixed_term_loan']
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

        //Kyc Onboarding
        "/credits/merchant/enrollment/kyc_onboarding"(platform: "/mobile/android") {
            offer = [
                    offer_type : 'early_offer'
            ]
            product_types = ['sales_percentage_loan', 'fixed_term_loan']
        }


        "/credits/merchant/enrollment/kyc_onboarding"(platform: "/mobile/android") {
            offer = [
                    offer_type : 'online'
            ]
            product_types = ['sales_percentage_loan', 'fixed_term_loan']
        }

        "/credits/merchant/enrollment/kyc_onboarding"(platform: "/mobile/android") {
            offer = [
                    offer_type : 'online'
            ]
            product_types = ['sales_percentage_loan']
        }

        "/credits/merchant/enrollment/kyc_onboarding"(platform: "/mobile/android") {
            offer = [
                    offer_type : 'online'
            ]
            product_types = ['fixed_term_loan']
        }

        "/credits/merchant/enrollment/kyc_onboarding"(platform: "/mobile/android") {
            product_types = ['fixed_term_loan']
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

        //Hub
        "/credits/merchant/enrollment/hub"(platform: "/mobile/android") {
            offer = [
                segment : 'online',
                offer_type : 'early_offer'
            ]
            product_types = ['sales_percentage_loan']
            is_kyc_compliant = true
        }
        "/credits/merchant/enrollment/hub"(platform: "/mobile/android") {
            offer = [
                segment : 'online'
            ]
            product_types = ['fixed_term_loan']
            is_kyc_compliant = true
        }
        "/credits/merchant/enrollment/hub"(platform: "/mobile/android") {
            offer = [
                    segment : 'online',
                    offer_type : 'early_offer'
            ]
            product_types = ['sales_percentage_loan']
            is_kyc_compliant = false
        }
        "/credits/merchant/enrollment/hub"(platform: "/mobile/android") {
            offer = [
                    segment : 'online'
            ]
            product_types = ['fixed_term_loan']
            is_kyc_compliant = false
        }
        "/credits/merchant/enrollment/hub"(platform: "/mobile/android") {
            offer = [
                offer_type : 'early_offer'
            ]
            product_types = ['sales_percentage_loan', 'fixed_term_loan']
            is_kyc_compliant = false
        }
        "/credits/merchant/enrollment/hub"(platform: "/mobile/android") {
            offer = [
                    offer_type : 'early_offer'
            ]
            product_types = ['sales_percentage_loan', 'fixed_term_loan']
            is_kyc_compliant = true
        }
        "/credits/merchant/enrollment/hub"(platform: "/mobile/android") {
            product_types = ['sales_percentage_loan', 'fixed_term_loan']
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

        //Simulator
        "/credits/merchant/enrollment/simulator"(platform: "/mobile/android") {
            offer = [
                segment : 'online',
                offer_type : 'early_offer'
            ]
            product_type = 'sales_percentage_loan'
            variant = 'fixed_amount'
            is_kyc_compliant = false
        }
        "/credits/merchant/enrollment/simulator"(platform: "/mobile/android") {
            offer = [
                    segment : 'online',
                    offer_type : 'early_offer'
            ]
            product_type = 'sales_percentage_loan'
            variant = 'fixed_amount'
            is_kyc_compliant = true
        }
        "/credits/merchant/enrollment/simulator"(platform: "/mobile/android") {
            offer = [
                segment : 'online'
            ]
            product_type = 'fixed_term_loan'
            variant = 'fixed'
            is_kyc_compliant = false
        }
        "/credits/merchant/enrollment/simulator"(platform: "/mobile/android") {
            offer = [
                    segment : 'online'
            ]
            product_type = 'fixed_term_loan'
            variant = 'fixed'
            is_kyc_compliant = true
        }
        "/credits/merchant/enrollment/simulator"(platform: "/mobile/android") {
            offer = [
                offer_type: 'early_offer'
            ]
            product_type = 'sales_percentage_loan'
            variant = 'normal'
            is_kyc_compliant = true
        }
        "/credits/merchant/enrollment/simulator"(platform: "/mobile/android") {
            offer = [
                    offer_type: 'early_offer'
            ]
            product_type = 'sales_percentage_loan'
            variant = 'normal'
            is_kyc_compliant = false
        }

        //Summary
        "/credits/merchant/enrollment/summary"(platform: "/mobile/android") {
            requested_amount = 10000
            max_amount = 20000
            min_amount = 5000
            max_option = 12
            option = 12
            product_type = 'fixed_term_loan'
        }
        "/credits/merchant/enrollment/summary"(platform: "/mobile/android") {
            requested_amount = 10000
            max_amount = 10000
            min_amount = 10000
            max_option = 120030
            option = 30
            product_type = 'sales_percentage_loan'
        }

        //Summary event
        "/credits/merchant/enrollment/summary/accept_loan_action"(platform: "/mobile/android", type: TrackType.Event) {
            action = 'summary_confirm_action'
            label = 'confirm_button'
        }

        //Conditions
        "/credits/merchant/documents/simulation/conditions"(platform: "/") {}
        "/credits/merchant/documents/simulation/conditions"(platform: "/") {
            fixed_term()
        }

        //Congrats
        "/credits/merchant/enrollment/congrats"(platform: "/mobile/android") {
            requested_amount = 10000
            max_amount = 20000
            min_amount = 5000
            max_option = 12
            option = 12
            product_type = 'fixed_term_loan'
            has_prepaid = true
            loan_created_with_retry = true
        }
        "/credits/merchant/enrollment/congrats"(platform: "/mobile/android") {
            requested_amount = 10000
            max_amount = 10000
            min_amount = 10000
            max_option = 120030
            option = 30
            product_type = 'sales_percentage_loan'
            has_prepaid = false
            loan_created_with_retry = false
        }

        "/credits/merchant/enrollment/kyc_user_challenges_onboarding"(platform: "/mobile", type: TrackType.Event) {}

        "/credits/merchant/enrollment/kyc_user_challenges_onboarding"(platform: "/mobile", type: TrackType.Event) {
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

        "/credits/merchant/enrollment/kyc_back_office_congrats"(platform: "/mobile", type: TrackType.Event) {}

        "/credits/merchant/enrollment/kyc_back_office_congrats"(platform: "/mobile", type: TrackType.Event) {
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }
    }

    test("Merchant Credits Enrollment") {
        "/credits/merchant/enrollment"(platform: "/web/desktop") {
            status = 'pending'
            product_type = 'default'
            is_capped_offer= true
            is_kyc_compliance=true
        }
        "/credits/merchant/enrollment"(platform: "/web/desktop") {
            status = 'rejected'
            product_type = 'early_offer'
            is_capped_offer= false
            is_kyc_compliance=true
        }
        "/credits/merchant/enrollment"(platform: "/web/desktop") {
            status = 'approved'
            sub_status = 'review_pending'
            product_type = 'point'
            is_capped_offer= false
            is_kyc_compliance=true
        }
        "/credits/merchant/enrollment"(platform: "/web/desktop") {
            offer = [
                segment : 'online',
                offer_type : 'early_offer',
                is_capped_offer: false
            ]
            product_types = [
                [
                    product_type: 'sales_percentage_loan',
                    variant: 'normal'
                ]
            ]
        }
        "/credits/merchant/enrollment"(platform: "/mobile/android") {
            status = 'pending'
            product_type = 'default'
            is_capped_offer= true
            is_kyc_compliance=true
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }
        "/credits/merchant/enrollment"(platform: "/mobile/ios") {
            status = 'pending'
            product_type = 'default'
            is_capped_offer= true
            is_kyc_compliance=true
            from = 'hub'
            additional_info = 'clicked_on_access_row'
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
        "/credits/merchant/enrollment/error"(platform: "mobile") {
            reason = 'loan_creation'
            from = "hub"
            additional_info = 'clicked_on_access_row'
        }
        "/credits/merchant/enrollment/info"(platform: "/mobile") {
            reason = 'already_taken_credit_line'
        }
        "/credits/merchant/enrollment/info"(platform: "/mobile") {
            reason = 'already_taken_credit_line'
            from = "hub"
            additional_info = 'clicked_on_access_row'
        }
        "/credits/merchant/enrollment/info"(platform: "/mobile") {
            reason = 'no_credit_lines_present'
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

        //Summary
        "/credits/merchant/enrollment/summary"(platform: "/web/desktop") {
            requested_amount = 10000
            max_amount = 20000
            min_amount = 5000
            max_option = 12
            option = 12
            product_type = 'fixed_term_loan'
        }
        "/credits/merchant/enrollment/summary"(platform: "/web/desktop") {
            requested_amount = 10000
            max_amount = 10000
            min_amount = 10000
            max_option = 120030
            option = 30
            product_type = 'sales_percentage_loan'
        }

        //Congrats
        "/credits/merchant/enrollment/congrats"(platform: "/web/desktop") {
            requested_amount = 10000
            max_amount = 20000
            min_amount = 5000
            max_option = 12
            option = 12
            product_type = 'fixed_term_loan'
            has_prepaid = true
            through_kyc = true
        }
        "/credits/merchant/enrollment/congrats"(platform: "/web/desktop") {
            requested_amount = 10000
            max_amount = 10000
            min_amount = 10000
            max_option = 120030
            option = 30
            product_type = 'sales_percentage_loan'
            has_prepaid = false
            through_kyc = true
        }
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
                offer_type: 'early_offer',
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

        def sales_percentage_loan_on_time = {
            product_type = 'sales_percentage_loan'
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

        def fixed_term_loan_on_time = {
            product_type = 'fixed_term_loan'
            segment = 'online'
            category = 'regular'
            offer_type = 'early_offer'
            status = 'on_time'
        }

        "/credits/merchant/administrator"(platform: "/") {
           promise = 'none'
        }
        "/credits/merchant/administrator"(platform: "/") {
           status = 'on_time'
           promise = 'none'
        }
        "/credits/merchant/administrator"(platform: "/") {
            status = 'overdue'
            promise = 'view_promise'

        }
        "/credits/merchant/administrator"(platform: "/") {
            status = 'empty'
            promise = 'none'
        }
        "/credits/merchant/administrator"(platform: "/", {
            offers = [
                express_money_map()
            ]
            products = [
                fixed_term_map()
            ]
            promise = 'create_promise'
            show_cx_widget = true
        })
        "/credits/merchant/administrator"(platform: "/") {
            promise = 'none'
            from = 'enrollment'
            additional_info = 'credit_line_taken'
        }
        "/credits/merchant/administrator"(platform: "/") {
            promise = 'none'
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }
        "/credits/merchant/administrator"(platform: "/") {
            promise = 'none'
            accesses = 'open_market'
        }

        "/credits/merchant/administrator/spc_click"(platform: "/web/desktop") {}

        "/credits/merchant/administrator/spc_click"(platform: "/web/desktop") {
            sales_percentage_map()
        }

        "/credits/merchant/administrator/error"(platform: "/web/desktop") {}

        "/credits/merchant/administrator/error"(platform: "/mobile") {
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

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
            fixed_term_loan_on_time()
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            express_money_overdue()
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            sales_percentage_on_time()
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            sales_percentage_loan_on_time()
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            fixed_term_on_time()
        }
        "/credits/merchant/administrator/detail"(platform: "/web/desktop") {
            fixed_term_loan_on_time()
        }

        "/credits/merchant/administrator/late_debt"(platform: "/") {
            offers = [
                express_money_map()
            ]
            products = [
                fixed_term_map(),
                sales_percentage_map()
            ]
        }

        "/credits/merchant/administrator/late_debt"(platform: "/mobile") {
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            fixed_term_on_time()
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            fixed_term_loan_on_time()
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            express_money_overdue()
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            sales_percentage_on_time()
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            sales_percentage_loan_on_time()
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            fixed_term_on_time()
        }
        "/credits/merchant/administrator/detail/conditions"(platform: "/web/desktop") {
            fixed_term_loan_on_time()
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            fixed_term_on_time()
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            fixed_term_loan_on_time()
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            express_money_overdue()
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            sales_percentage_on_time()
        }
        "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/web/desktop") {
            sales_percentage_loan_on_time()
        }

        "/credits/merchant/administrator/detail/conditions/case_resolution_click"(platform: "/web/desktop") {}
        "/credits/merchant/administrator/detail/conditions/case_resolution_click"(platform: "/web/desktop") {
            fixed_term_on_time()
        }
        "/credits/merchant/administrator/detail/conditions/case_resolution_click"(platform: "/web/desktop") {
            fixed_term_loan_on_time()
        }
        "/credits/merchant/administrator/detail/conditions/case_resolution_click"(platform: "/web/desktop") {
            express_money_overdue()
        }
        "/credits/merchant/administrator/detail/conditions/case_resolution_click"(platform: "/web/desktop") {
            sales_percentage_on_time()
        }
        "/credits/merchant/administrator/detail/conditions/case_resolution_click"(platform: "/web/desktop") {
            sales_percentage_loan_on_time()
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
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {
            account_money = 'sufficient'
            fixed_term()
        }
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {
            account_money = 'insufficient'
            fixed_term()
        }
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {
            account_money = 'sufficient'
            express_money()
        }
        "/credits/merchant/proactive_payment"(platform: "/web/desktop") {
            account_money = 'insufficient'
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

        "/credits/merchant/early_repayment"(platform: "/web/desktop") {
            account_money = 'sufficient'
            fixed_term()
        }
        "/credits/merchant/early_repayment"(platform: "/web/desktop") {
            account_money = 'insufficient'
            fixed_term()
        }

        "/credits/merchant/early_repayment/congrats"(platform: "/web/desktop") {}
        "/credits/merchant/early_repayment/congrats"(platform: "/web/desktop") {
            fixed_term()
        }

        "/credits/merchant/early_repayment/active_early_repayment"(platform: "/web/desktop") {}
        "/credits/merchant/early_repayment/active_early_repayment"(platform: "/web/desktop") {
            fixed_term()
        }

        "/credits/merchant/early_repayment/error"(platform: "/web/desktop") {
            reason = 'early_repayment_error'
        }
        "/credits/merchant/early_repayment/error"(platform: "/web/desktop") {
            reason = 'early_repayment_error'
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
            offer = 'none'
            release_attemps_number = 4
        }
        "/credits/merchant/money_advance/congrats"(platform: "/web/desktop") {
            status = 'delayed'
            user_status = 'overdue'
            offer = 'none'
            release_attemps_number = 4
        }
          "/credits/merchant/money_advance/congrats"(platform: "/web/desktop") {
            status = 'on_time'
            user_status = 'on_time'
            offer = 'express_money'
              release_attemps_number = 4
        }
        "/credits/merchant/money_advance/congrats"(platform: "/mobile/android", type: TrackType.View) {
            offer = 'none'
        }
        "/credits/merchant/money_advance/congrats"(platform: "/mobile/android", type: TrackType.View) {
            offer = 'express_money'
        }
        "/credits/merchant/money_advance/congrats"(platform: "/mobile/ios", type: TrackType.View) {
            offer = 'none'
        }
        "/credits/merchant/money_advance/congrats"(platform: "/mobile/ios", type: TrackType.View) {
            offer = 'express_money'
        }
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

        "/credits/express_money/amount_input"(platform: "/web/desktop", type: TrackType.View) {
            show_onboarding = true
        }

        "/credits/express_money/amount_input"(platform: "/mobile/android", type: TrackType.View) {
            show_onboarding = true
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

        "/credits/express_money/amount_input"(platform: "/mobile/ios", type: TrackType.View) {
            show_onboarding = false
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

        "/credits/express_money/amount_input"(platform: "/web/desktop", type: TrackType.View) {
            show_onboarding = true
            default_amount = 1000
            max_amount = 1000
            min_amount = 100
            default_payment_term = "7"
            payment_terms = ["7", "14", "21"]
        }

        "/credits/express_money/amount_input"(platform: "/mobile/android") {
            show_onboarding = true
            default_amount = 1000
            max_amount = 1000
            min_amount = 100
            default_payment_term = "7"
            payment_terms = ["7", "14", "21"]
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

        "/credits/express_money/amount_input"(platform: "/mobile/ios") {
            show_onboarding = false
            default_amount = 1000
            max_amount = 1000
            min_amount = 100
            default_payment_term = "7"
            payment_terms = ["7", "14", "21"]
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

        "/credits/express_money/amount_input"(platform: "/web/desktop") {}

        "/credits/express_money/amount_input"(platform: "/mobile/android") {}

        "/credits/express_money/amount_input"(platform: "/mobile/ios") {}

        "/credits/express_money/amount_input/simulation"(platform: "/web/desktop", type: TrackType.Event) {
            requested_amount = 1000
            max_amount = 1000
            min_amount = 100
            default_payment_term = "7"
        }

        "/credits/express_money/amount_input/simulation"(platform: "/mobile/android", type: TrackType.View) {
            requested_amount = 1000
            max_amount = 1000
            min_amount = 100
            default_payment_term = "7"
        }

        "/credits/express_money/amount_input/simulation"(platform: "/mobile/ios", type: TrackType.View) {
            requested_amount = 1000
            max_amount = 1000
            min_amount = 100
            default_payment_term = "7"
        }

        "/credits/express_money/amount_input/simulation"(platform: "/mobile/android", type: TrackType.Event) {
            requested_amount = 1000
            max_amount = 1000
            min_amount = 100
            default_payment_term = "7"
        }

        "/credits/express_money/amount_input/simulation"(platform: "/mobile/ios", type: TrackType.Event) {
            requested_amount = 1000
            max_amount = 1000
            min_amount = 100
            default_payment_term = "7"
        }

        "/credits/express_money/amount_input/term_option"(platform: "/web/desktop", type: TrackType.Event) {
            selected_payment_term = "7"
        }

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

        "/credits/express_money/summary"(platform: "/web/desktop", type: TrackType.View) {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
            default_payment_term = "7"
            selected_payment_term = "7"
            payment_terms = ["7", "14", "21"]
        }

        "/credits/express_money/summary"(platform: "/mobile/android", type: TrackType.View) {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
            default_payment_term = "7"
            selected_payment_term = "7"
            payment_terms = ["7", "14", "21"]
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

        "/credits/express_money/congrats"(platform: "/mobile/ios") {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
            has_prepaid = false
        }

        "/credits/express_money/congrats"(platform: "/web/desktop", type: TrackType.View) {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
            has_prepaid = true
            default_payment_term = "7"
            selected_payment_term = "7"
            payment_terms = ["7", "14", "21"]
        }

        "/credits/express_money/congrats"(platform: "/mobile/android", type: TrackType.View) {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
            has_prepaid = true
            default_payment_term = "7"
            selected_payment_term = "7"
            payment_terms = ["7", "14", "21"]
        }

        "/credits/express_money/congrats"(platform: "/web/desktop", type: TrackType.View) {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
            has_prepaid = false
            default_payment_term = "7"
            selected_payment_term = "7"
            payment_terms = ["7", "14", "21"]
        }

        "/credits/express_money/congrats"(platform: "/mobile/ios", type: TrackType.View) {
            requested_amount = 700
            max_amount = 1000
            min_amount = 500
            has_prepaid = false
            default_payment_term = "7"
            selected_payment_term = "7"
            payment_terms = ["7", "14", "21"]
        }

        "/credits/express_money/congrats"(platform: "/mobile/ios", type: TrackType.View) {
            reason = "already_taken_credit_line"
            from = 'hub'
            additional_info = 'clicked_on_access_row'
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

        "/credits/express_money/info"(platform: "/mobile/android") {
            reason = 'no_credit_lines_present'
            from = 'hub'
            additional_info = 'clicked_on_access_row'
        }

        "/credits/express_money/onboarding"(platform: "/mobile/android") {}
    }

    test("Credits Hub") {
        "/credits/mp-hub"(platform: "/", type: TrackType.View) {}

        "/credits/mp-hub/redirect"(platform: "/", type: TrackType.View) {
            flow = "open_sea_mp"
        }

        "/credits/mp-hub/no-credit-line"(platform: "/", type: TrackType.View) {}

        "/credits/mp-hub/no-credit-line/access_click"(platform: "/", type: TrackType.Event) {
            flow = "consumer"
        }

        "/credits/mp-hub/no-credit-line/access_click"(platform: "/", type: TrackType.Event) {
            flow = "merchant"
        }

        "/credits/mp-hub/no-credit-line/stop"(platform: "/", type: TrackType.View) {
            flow = "merchant"
        }

        "/credits/mp-hub/no-credit-line/stop/faqs_click"(platform: "/", type: TrackType.Event) {
            flow = "merchant"
        }

        "/credits/mp-hub/no-credit-line/stop"(platform: "/", type: TrackType.View) {
            flow = "generic"
        }

        "/credits/mp-hub/error"(platform: "/", type: TrackType.View) {}

        "/credits/mp-hub/error/access_click"(platform: "/", type: TrackType.Event) {
            flow = "merchant"
        }

        "/credits/mp-hub/error/access_click"(platform: "/", type: TrackType.Event) {
            flow = "consumer"
        }
    }

    test("Merchant Open Market") {
        "/credits/merchant/open-market/statements_upload"(platform: "/", type: TrackType.Event) {}

        "/credits/merchant/open-market/statements_upload/error"(platform: "/", type: TrackType.Event) {
            reason = "wrong_extension"
        }

        "/credits/merchant/open-market/statements_upload/error"(platform: "/", type: TrackType.Event) {
            reason = "generic"
        }

        "/credits/merchant/open-market/statements-upload_click"(platform: "/", type: TrackType.Event) {}

        "/credits/merchant/open-market/no-upsell_click"(platform: "/", type: TrackType.Event) {}

        "/credits/merchant/open-market/how-to-download_click"(platform: "/", type: TrackType.Event) {}

        "/credits/merchant/open-market/bank_click"(platform: "/", type: TrackType.Event) {
            bank = "caixa"
        }

        "/credits/merchant/open-market"(platform: "/", type: TrackType.View) {}

        "/credits/merchant/open-market/congrats"(platform: "/", type: TrackType.View) {
            reason = "financial_files"
        }

        "/credits/merchant/open-market/congrats"(platform: "/", type: TrackType.View) {
            reason = "financial_scraping"
        }

        "/credits/merchant/open-market/congrats"(platform: "/", type: TrackType.View) {
            reason = "finished_flow"
        }

        "/credits/merchant/open-market/financial-scraping_click"(platform: "/", type: TrackType.Event) {}

        "/credits/merchant/open-market/financial-scraping/error"(platform: "/", type: TrackType.Event) {
            reason = "integration_error"
        }

        "/credits/merchant/open-market/financial-scraping/error"(platform: "/", type: TrackType.Event) {
            reason = "generic"
        }

        "/credits/merchant/open-market/financial-scraping/message"(platform: "/", type: TrackType.Event) {
            reason = "finished_flow"
        }

        "/credits/merchant/open-market/financial-scraping/message"(platform: "/", type: TrackType.Event) {
            reason = "finished_session"
        }

        "/credits/merchant/open-market/financial-scraping/message"(platform: "/", type: TrackType.Event) {
            reason = "not_available"
        }

        "/credits/merchant/open-market/stop"(platform: "/", type: TrackType.View) {
            reason = "financial_files_uploaded"
        }

        "/credits/merchant/open-market/stop"(platform: "/", type: TrackType.View) {
            reason = "financial_scraping_done"
        }

        "/credits/merchant/open-market/form"(platform: "/", type: TrackType.View) {
            bank = "caixa"
        }

        "/credits/merchant/open-market/form/sent"(platform: "/", type: TrackType.Event) {}
    }

    test("Merchant Public Landing") {
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

        "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
            medium = "email"
            campaign = "updates"
            stage= "congrats_upsell"
        }

        "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
            medium = "email"
            campaign = "updates"
            stage= "cm_expired_early_repayment"
        }

        "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
            medium = "email"
            campaign = "updates"
            stage= "cm_congrats_debit_lastinstallment"
        }

        "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
            medium = "email"
            campaign = "updates"
            stage= "spl_congrats_credited_loan"
        }
    }

    test("Personal Loans Adoption from Mercadopago") {

        /******************************************
         *   Start: Personal Loans Adoption
         ******************************************/

        "/credits/consumer/personal"(platform: "/mobile", type: TrackType.View) {
        }

        "/credits/consumer/personal/adoption"(platform: "/mobile", type: TrackType.View) {
            prepaid = true
            virtual_card = true
            physical_card = false
        }

        "/credits/consumer/personal/adoption/onboarding"(platform: "/mobile", type: TrackType.View) {
            prepaid = false
            page = 1
            sk = 'sk1234'
        }

        "/credits/consumer/personal/adoption/onboarding/go_simulation"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
            page = 4
        }

        "/credits/consumer/personal/adoption/onboarding/close"(platform: "/mobile", type: TrackType.Event) {
            prepaid = true
        }

        "/credits/consumer/personal/adoption/simulator"(platform: "/mobile", type: TrackType.View) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/simulator/go_review"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review"(platform: "/mobile", type: TrackType.View) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/general_terms"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/particular_terms"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/above_confirm"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/below_confirm"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/congrats"(platform: "/mobile", type: TrackType.View) {
            status = 'no_prepaid'
        }

        "/credits/consumer/personal/adoption/congrats/go_wallet"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_enabled'
        }

        "/credits/consumer/personal/adoption/congrats/go_prepaid"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_disabled'
        }

        "/credits/consumer/personal/adoption/congrats/go_withdrawals"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_enabled'
        }

        "/credits/consumer/personal/adoption/generic_message"(platform: "/mobile", type: TrackType.View) {
            status = 'prepaid_enabled'
        }

        "/credits/consumer/personal/adoption/generic_message/go_prepaid"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_disabled'
        }


        /******************************************
         *   End: Personal Loans Adoption
         ******************************************/
    }

    test("Consumer Admin from Mercadopago") {
    /******************************************
     *   Start: Consumer Admin Detail
     ******************************************/
         //Views
        "/credits/consumer/administrator"(platform: "/mobile", type: TrackType.View) {
        }

        "/credits/consumer/administrator/dashboard"(platform: "/mobile", type: TrackType.View) {
                dashboard_status = 'empty_state'
        }

        "/credits/consumer/administrator/summary"(platform: "/mobile", type: TrackType.View) {
                summary_status = 'empty_state'
        }

        "/credits/consumer/administrator/payment_intention"(platform: "/mobile", type: TrackType.View) {
            installment_status = 'on_time'
            payment_intention = 'cho'
        }

        "/credits/consumer/administrator/summary/payment_intention"(platform: "/mobile", type: TrackType.Event) {
            summary_status = 'on_time'
        }
        "/credits/consumer/administrator/summary/cx_contact"(platform: "/mobile", type: TrackType.Event) {
            summary_status = 'on_time'
        }
        "/credits/consumer/administrator/summary/go_shopping"(platform: "/mobile", type: TrackType.Event) {
            summary_status = 'on_time'
        }
        "/credits/consumer/administrator/summary/get_help"(platform: "/mobile", type: TrackType.Event) {
            summary_status = 'on_time'
        }
        "/credits/consumer/administrator/summary/get_educative"(platform: "/mobile", type: TrackType.Event) {
            summary_status = 'on_time'
        }

        //V2
        //Views
        "/credits/consumer/administrator_v2"(platform: "/mobile", type: TrackType.View) {

        }
        "/credits/consumer/administrator_v2/error_message"(platform: "/mobile", type: TrackType.View) {
            user_status = 'manually_paused'
        }
        "/credits/consumer/administrator_v2/dashboard"(platform: "/mobile", type: TrackType.View) {
            dashboard_status = 'on_time'
        }
        "/credits/consumer/administrator_v2/dashboard"(platform: "/mobile", type: TrackType.View) {
            dashboard_status = 'overdue'
            offer = ['payment_not_credited', 'create_promise']
        }

        //Events

        "/credits/consumer/administrator_v2/dashboard/payment_intention_all"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
            installments_qty = 3
        }
        "/credits/consumer/administrator_v2/dashboard/choose_installments"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'overdue'
        }
        "/credits/consumer/administrator_v2/dashboard/get_help"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
        }
        "/credits/consumer/administrator_v2/dashboard/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'empty_state'
        }
        "/credits/consumer/administrator_v2/dashboard/cx_contact"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'overdue'
        }
        "/credits/consumer/administrator_v2/dashboard/go_shopping"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
        }
        "/credits/consumer/administrator_v2/dashboard/get_educative"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
        }
        "/credits/consumer/administrator_v2/dashboard/go_mp"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'empty_state'
            has_mp = true
        }
        "/credits/consumer/administrator_v2/dashboard/close_mp_modal"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'empty_state'
        }
        "/credits/consumer/administrator_v2/dashboard/go_store_mp"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'empty_state'
        }
        "/credits/consumer/administrator_v2/error_message/button_pressed"(platform: "/mobile", type: TrackType.Event) {
            user_status = 'manually_paused'
        }

        "/credits/consumer/administrator/summary/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {
            summary_status = "on_time"
        }

        "/credits/consumer/administrator_v2/promises/create"(platform: "/mobile", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/promises/view"(platform: "/mobile", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/payment_not_credited"(platform: "/mobile", type: TrackType.Event) {}

        /******************************************
            *       End: Consumers Admin Detail
        ******************************************/

        /****************************************************
        *       Start: Consumers Installment Selection Page
        ****************************************************/
        //View
        "/credits/consumer/administrator_v2/installment_selection"(platform: "/mobile", type: TrackType.View) {
            page_status = 'overdue'
        }

        //Events
        "/credits/consumer/administrator_v2/installment_selection/payment_intention"(platform: "/mobile", type: TrackType.Event) {
            page_status = 'overdue'
            total_installments = 3
            paid_installments = 2
        }
        "/credits/consumer/administrator_v2/installment_selection/secondary_payment_intention"(platform: "/mobile", type: TrackType.Event) {
            total_installments = 3
            page_status = 'overdue'
        }
        "/credits/consumer/administrator_v2/installment_selection/back_to_dashboard"(platform: "/mobile", type: TrackType.Event) {
            page_status = 'overdue'
        }
    }
    test("Due date selection from Mercadopago"){
      /******************************************
        *    Start: Consumers Change Due Date FLow
        ******************************************/
        "/credits/consumer/duedate_selection"(platform: "/", type: TrackType.View) {
            available_products = ["consumer_loan", "personal_loan"]
            due_date = 10
        }

        "/credits/consumer/duedate_selection/not_allowed"(platform: "/", type: TrackType.View) {
            available_products = ["consumer_loan", "personal_loan"]
            due_date = 10
        }

        "/credits/consumer/duedate_selection/error"(platform: "/", type: TrackType.View) {
            available_products = ["consumer_loan", "personal_loan"]
            due_date = 10
        }

        "/credits/consumer/duedate_selection/success"(platform: "/", type: TrackType.View) {
            available_products = ["consumer_loan", "personal_loan"]
            due_date = 10
            new_due_date = 15
        }

        "/credits/consumer/duedate_selection/cancel"(platform: "/", type: TrackType.Event) {
            available_products = ["consumer_loan", "personal_loan"]
            due_date = 10
        }


        /******************************************
        *    End: Consumers Change Due Date FLow
        ******************************************/
    }

    test("Self service from MercadoPago") {
        /******************************************
        *    Start: Self Service
        ******************************************/
        "/credits/self_service/promises/create_form"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/create_form/submit"(platform: "/", type: TrackType.Event) {
            user_type = "consumer"
            is_partial_amount = true
            bulk_amount = 7000
            promise_amount = 5000
            payment_method = "CASH"
            promise_due_days = 4
        }

        "/credits/self_service/promises/create_form/cancel"(platform: "/", type: TrackType.Event) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/congrats"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/error"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/view"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        /******************************************
        *    End: Self Service
        ******************************************/
    }

    test("Credits Consumer from MercadoPago"){
        "/credits/consumer/public_landing"(platform: "/") {
            user_profile = 'no_offer'
            sk = 'landing'
        }
    }
}
