package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    def offer_data_scoring_a = [
        scoring: "A"
    ]

    def offer_data_scoring_b = [
        scoring: "B"
    ]

    def amount_input_data = [
        amount: 100,
        statement_min_amount: 10,
        statement_max_amount: 100,
        account_total_amount: 300
    ]

    def payment_plan_data = [
        payment_plan_number: 6,
        min_payment_plan: 3,
        max_payment_plan: 12,
    ]

    test("Credits Credit Card - Payment tests") {
        /***********************************************
         *       Start: Credit Card Payment
         ***********************************************/
        //Hub
        "/credits/credit_card/payment/hub"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_a
            statement_status = "closed"
        }

        "/credits/credit_card/payment/total_payment_action"(platform: "/", type: TrackType.Event) {
            amount = 100.5
        }

        //Payment plan
        "/credits/credit_card/payment/payment_plan_selection"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_b
            statement_status = "open"
        }

        //Amount input
        "/credits/credit_card/payment/amount_input"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_a
            statement_status = "overdue"
        }

        //Summary
        "/credits/credit_card/payment/summary"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_a
            statement_status = "closed"
            payment_option = "total"
            amount_input = amount_input_data
        }

        "/credits/credit_card/payment/summary"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_b
            statement_status = "closed"
            payment_option = "payment_plan"
            payment_plan = payment_plan_data
        }

        "/credits/credit_card/payment/payment_action"(platform: "/", type: TrackType.Event) {
            offer = offer_data_scoring_a
            statement_status = "closed"
            payment_option = "total"
            amount_input = amount_input_data
        }

        "/credits/credit_card/payment/payment_action"(platform: "/", type: TrackType.Event) {
            offer = offer_data_scoring_b
            statement_status = "closed"
            payment_option = "payment_plan"
            payment_plan = payment_plan_data
        }
        /*********************************************
         *       End: Credit Card Payment
         *********************************************/
    }

    test("Credits Credit Card - Upgrade tests") {
        /***********************************************
         *       Start: Credit Card Upgrade
         ***********************************************/

        def congrats_approved_status = "approved"
        def congrats_pending_status = "pending"
        def congrats_rejected_status = "rejected"

        // Onboarding
        "/credits/credit_card/upgrade/onboarding"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_b
            is_card_active = true
            page = 1
        }

        // Payment due date selection
        "/credits/credit_card/upgrade/payment_due_date_selection"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_b
            is_card_active = true
            buckets = [1, 15, 25]
        }

        // Summary
        "/credits/credit_card/upgrade/summary"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_b
            is_card_active = true
            bucket = 15
            limit = 2000
            annuity_cost = 150
        }

        "/credits/credit_card/upgrade/summary/payment_due_date_selection_action"(platform: "/", type: TrackType.Event) {
            bucket = 15
        }

        // Congrats
        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_b
            is_card_active = true
            status = congrats_approved_status
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_a
            is_card_active = true
            status = congrats_pending_status
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_b
            is_card_active = true
            status = congrats_rejected_status
        }

        "/credits/credit_card/upgrade/congrats/promotion_action"(platform: "/", type: TrackType.Event) {}

        "/credits/credit_card/upgrade/congrats/go_dashboard_action"(platform: "/", type: TrackType.Event) {}

        // Error
        "/credits/credit_card/upgrade/error"(platform: "/", type: TrackType.View) {
            reason = "Network error"
        }

        /*********************************************
         *       End: Credit Card Upgrade
         *********************************************/
    }

    test("Credits Credit Card - Statement tests") {
        /***********************************************
         *       Start: Credit Card Statement
         ***********************************************/

        def statement_open_status = "open"
        def statement_closed_status = "closed"
        def statement_overdue_status = "overdue"
        def statement_paid_status = "paid"

        // Statement
        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_open_status
        }

        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_closed_status
        }

        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_overdue_status
        }

        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_paid_status
        }

        "/credits/credit_card/statement/download_pdf_action"(platform: "/", type: TrackType.Event) {
            month = 10
            year = 2020
        }

        "/credits/credit_card/statement/statement_action"(platform: "/", type: TrackType.Event) {
            month = 9
            year = 2020
            month_diff = -1
        }

        "/credits/credit_card/statement/payment_action"(platform: "/", type: TrackType.Event) {
            statement_status = statement_overdue_status
        }

        /*********************************************
         *       End: Credit Card Statement
         *********************************************/
    }
}