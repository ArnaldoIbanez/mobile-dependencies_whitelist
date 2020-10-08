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
            statement_status = "open"
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

        // Statement
        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_open_status
        }

        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_closed_status
        }

        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_open_status
        }

        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_open_status
        }

        "/credits/credit_card/statement/download_pdf_action"(platform: "/", type: TrackType.Event) {
            month = 10
            year = 2020
        }

        "/credits/credit_card/statement/month_selected_action"(platform: "/", type: TrackType.Event) {
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

    test("Credits Credit Card - Dashboard tests") {
        /***********************************************
         *       Start: Credit Card Dashboard
         ***********************************************/

        def rating_a = "A"
        def rating_b = "B"
        def status_pending = "pending"
        def status_active = "active"
        def status_blocked = "blocked"
        def status_cancelled = "cancelled"

        def statement_open_status = "open"
        def statement_closed_status = "closed"

        def account_data_pending = [
                rating = rating_a,
                status = status_pending,
                status_detail = "",
                overdue_days = 4
        ]

        def account_data_active = [
                rating = rating_b,
                status = status_active,
                status_detail = "",
                overdue_days = 0
        ]

        def account_data_blocked = [
                rating = rating_b,
                status = status_blocked,
                status_detail = "",
                overdue_days = 0
        ]

        def account_data_cancelled = [
                rating = rating_b,
                status = status_cancelled,
                status_detail = "",
                overdue_days = 0
        ]

        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            account = account_data_pending
            statement_status = statement_open_status
            pending_payments = true
        }

        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            account = account_data_active
            statement_status = statement_open_status
            pending_payments = false
        }

        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            account = account_data_blocked
            statement_status = statement_closed_status
            pending_payments = false
        }

        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            account = account_data_cancelled
            statement_status = statement_closed_status
            pending_payments = false
        }

        /*********************************************
         *       End: Credit Card Dashboard
         *********************************************/
    }
}