package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    def account_rating_a = [
        rating: "A"
    ]

    def account_rating_b = [
            rating: "B"
    ]

    def amount_input_data = [
        amount: 100,
        statement_min_amount: 10,
        statement_max_amount: 100,
        account_total_amount: 300
    ]

    def amount_input_without_total_amount_data = [
            amount: 100,
            statement_min_amount: 10,
            statement_max_amount: 100,
            account_total_amount: null
    ]

    def payment_plan_data = [
        payment_plan_number: 6,
        min_payment_plan: 3,
        max_payment_plan: 12,
    ]

    def account_pending_data = [
            rating: "A",
            status: "pending",
            status_detail: "",
            overdue_days: 0,
    ]

    def account_active_data = [
            rating: "A",
            status: "active",
            status_detail: "",
            overdue_days: 0,
    ]

    def account_blocked_data = [
            rating: "B",
            status: "blocked",
            status_detail: "",
            overdue_days: 30,
    ]

    def account_cancelled_data = [
            rating: "C",
            status: "cancelled",
            status_detail: "",
            overdue_days: 15,
    ]

    def account_blocked_locked_product_data = [
            rating: "D",
            status: "blocked",
            status_detail: "",
            overdue_days: 60,
    ]

    def reasons_data = ["A anuidade é muito alta", "O limite é muito baixo"]

    def other_reason_data = "A anuidade é muito alta"

    def disable_option_data_a = "one_payment"

    def disable_option_data_b = "monthly_payment"

    def error_timeout_data = [
            type: "timeout",
            cause: "account"
    ]

    def error_internal_error_data = [
            type: "internal_error",
            cause: "dashboard"
    ]

    def error_failed_dependency_data = [
            type: "failed_dependency",
            cause: "payment"
    ]

    test("Credits Credit Card - Payment tests") {
        /***********************************************
         *       Start: Credit Card Payment
         ***********************************************/
        //Hub
        "/credits/credit_card/payment/hub"(platform: "/", type: TrackType.View) {
            account = account_rating_a
            statement_status = "closed"
        }

        "/credits/credit_card/payment/hub/total_payment_action"(platform: "/", type: TrackType.Event) {
            amount = 100.5
        }

        //Payment plan
        "/credits/credit_card/payment/hub/payment_plan_selection"(platform: "/", type: TrackType.View) {
            account = account_rating_b
            statement_status = "open"
        }

        //Amount input
        "/credits/credit_card/payment/amount_input"(platform: "/", type: TrackType.View) {
            account = account_rating_a
            statement_status = "open"
        }

        //Summary
        "/credits/credit_card/payment/summary"(platform: "/", type: TrackType.View) {
            account = account_rating_a
            statement_status = "closed"
            payment_option = "total"
            amount_input = amount_input_data
        }

        "/credits/credit_card/payment/summary"(platform: "/", type: TrackType.View) {
            account = account_rating_a
            statement_status = "closed"
            payment_option = "total"
            amount_input = amount_input_without_total_amount_data
        }

        "/credits/credit_card/payment/summary"(platform: "/", type: TrackType.View) {
            account = account_rating_b
            statement_status = "closed"
            payment_option = "payment_plan"
            payment_plan = payment_plan_data
        }

        "/credits/credit_card/payment/summary/payment_action"(platform: "/", type: TrackType.Event) {
            account = account_rating_a
            statement_status = "closed"
            payment_option = "total"
            amount_input = amount_input_data
        }

        "/credits/credit_card/payment/summary/payment_action"(platform: "/", type: TrackType.Event) {
            account = account_rating_a
            statement_status = "closed"
            payment_option = "total"
            amount_input = amount_input_without_total_amount_data
        }

        "/credits/credit_card/payment/summary/payment_action"(platform: "/", type: TrackType.Event) {
            account = account_rating_b
            statement_status = "closed"
            payment_option = "payment_plan"
            payment_plan = payment_plan_data
        }
        /*********************************************
         *       End: Credit Card Payment
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
            account = account_pending_data
        }

        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_closed_status
            account = account_pending_data
        }

        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_open_status
            account = account_pending_data
        }

        "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
            statement_status = statement_open_status
            account = account_pending_data
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
            statement_status = statement_open_status
        }

        /*********************************************
         *       End: Credit Card Statement
         *********************************************/
    }

    test("Credits Credit Card - Dashboard tests") {
        /***********************************************
         *       Start: Credit Card Dashboard
         ***********************************************/

        //View Dashboard
        //Dashboard View Account Status PENDING and Status Open
        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            account = account_pending_data
            statement_status = "open"
            pending_payments = true
        }

        //Dashboard View Account Status Active and Status Open
        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            account = account_active_data
            statement_status = "open"
            pending_payments = false
        }

        //Dashboard View Account Status Blocked and Status Closed
        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            account = account_blocked_data
            statement_status = "closed"
            pending_payments = false
        }

        //Dashboard View Account Status Cancelled and Status Closed
        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            account = account_cancelled_data
            statement_status = "closed"
            pending_payments = false
        }

        //Dashboard View Error with Fallback Timeout
        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            error = error_timeout_data
        }

        //Dashboard View Error with Fallback Internal Error
        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            error = error_internal_error_data
        }

        //Dashboard View Error with Fallback Failed Dependency
        "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
            error = error_failed_dependency_data
        }

        //Event Payment
        //Dashboard Event Payment Button Account Status Pending and Status Open
        "/credits/credit_card/dashboard/payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "open"
        }

        //Dashboard Event Payment Button Account Status Pending and Status Closed
        "/credits/credit_card/dashboard/payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "closed"
        }

        //Dashboard Event Payment Button Account Status Active and Status Open
        "/credits/credit_card/dashboard/payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "open"
        }

        //Dashboard Event Payment Button Account Status Active and Status Closed
        "/credits/credit_card/dashboard/payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "closed"
        }

        //Dashboard Event Payment Button Account Status Blocked and Status Open
        "/credits/credit_card/dashboard/payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "open"
        }

        //Dashboard Event Payment Button Account Status Blocked and Status Closed
        "/credits/credit_card/dashboard/payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "closed"
        }

        //Dashboard Event Payment Button Account Status Cancelled and Status Open
        "/credits/credit_card/dashboard/payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "open"
        }

        //Dashboard Event Payment Button Account Status Cancelled and Status Closed
        "/credits/credit_card/dashboard/payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "closed"
        }

        //Payment Limit Modal
        //Dashboard Event Payment Limit Modal Button Account Status Pending and Status Open
        "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "open"
        }

        //Dashboard Event Payment Limit Modal Button Account Status Pending and Status Closed
        "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "closed"
        }

        //Dashboard Event Payment Limit Modal Button Account Status Active and Status Open
        "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "open"
        }

        //Dashboard Event Payment Limit Modal Button Account Status Active and Status Closed
        "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "closed"
        }

        //Dashboard Event Payment Limit Modal Button Account Status Blocked and Status Open
        "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "open"
        }

        //Dashboard Event Payment Limit Modal Button Account Status Blocked and Status Closed
        "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "closed"
        }

        //Dashboard Event Payment Limit Modal Button Account Status Cancelled and Status Open
        "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "open"
        }

        //Dashboard Event Payment Limit Modal Button Account Status Cancelled and Status Closed
        "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "closed"
        }

        //Event Loyalty
        //Dashboard Event Loyalty Button Account Status Pending and Status Open
        "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "open"
        }

        //Dashboard Event Loyalty Button Account Status Pending and Status Closed
        "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "closed"
        }

        //Dashboard Event Loyalty Button Account Status Active and Status Open
        "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "open"
        }

        //Dashboard Event Loyalty Button Account Status Active and Status Closed
        "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "closed"
        }

        //Dashboard Event Loyalty Button Account Status Blocked and Status Open
        "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "open"
        }

        //Dashboard Event Loyalty Button Account Status Blocked and Status Closed
        "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "closed"
        }

        //Dashboard Event Loyalty Button Account Status Cancelled and Status Open
        "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "open"
        }

        //Dashboard Event Loyalty Button Account Status Cancelled and Status Closed
        "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "closed"
        }

        //Event Statement
        //Dashboard Event Statement Button Account Status Pending and Status Open
        "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "open"
        }

        //Dashboard Event Statement Button Account Status Pending and Status Closed
        "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "closed"
        }

        //Dashboard Event Statement Button Account Status Active and Status Open
        "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "open"
        }

        //Dashboard Event Statement Button Account Status Active and Status Closed
        "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "closed"
        }

        //Dashboard Event Statement Button Account Status Blocked and Status Open
        "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "open"
        }

        //Dashboard Event Statement Button Account Status Blocked and Status Closed
        "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "closed"
        }

        //Dashboard Event Statement Button Account Status Cancelled and Status Open
        "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "open"
        }

        //Dashboard Event Statement Button Account Status Cancelled and Status Closed
        "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "closed"
        }

        //Event Row Statement
        //Dashboard Event Row Statement Button Account Status Pending and Status Open
        "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "open"
        }

        //Dashboard Event Row Statement Button Account Status Pending and Status Closed
        "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "closed"
        }

        //Dashboard Event Row Statement Button Account Status Active and Status Open
        "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "open"
        }

        //Dashboard Event Row Statement Button Account Status Active and Status Closed
        "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "closed"
        }

        //Dashboard Event Row Statement Button Account Status Blocked and Status Open
        "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "open"
        }

        //Dashboard Event Row Statement Button Account Status Blocked and Status Closed
        "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "closed"
        }

        //Dashboard Event Row Statement Button Account Status Cancelled and Status Open
        "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "open"
        }

        //Dashboard Event Row Statement Button Account Status Cancelled and Status Closed
        "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "closed"
        }

        //Event Limit Modal Statement
        //Dashboard Event Limit Modal Statement Button Account Status Pending and Status Open
        "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "open"
        }

        //Dashboard Event Limit Modal Statement Button Account Status Pending and Status Closed
        "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "closed"
        }

        //Dashboard Event Limit Modal Statement Button Account Status Active and Status Open
        "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "open"
        }

        //Dashboard Event Limit Modal Statement Button Account Status Active and Status Closed
        "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "closed"
        }

        //Dashboard Event Limit Modal Statement Button Account Status Blocked and Status Open
        "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "open"
        }

        //Dashboard Event Limit Modal Statement Button Account Status Blocked and Status Closed
        "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "closed"
        }

        //Dashboard Event Limit Modal Statement Button Account Status Cancelled and Status Open
        "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "open"
        }

        //Dashboard Event Limit Modal Statement Button Account Status Cancelled and Status Closed
        "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "closed"
        }

        //Event Help
        //Dashboard Event Help Button Account Status Pending and Status Open
        "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "open"
        }

        //Dashboard Event Help Button Account Status Pending and Status Closed
        "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "closed"
        }

        //Dashboard Event Help Button Account Status Active and Status Open
        "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "open"
        }

        //Dashboard Event Help Button Account Status Active and Status Closed
        "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "closed"
        }

        //Dashboard Event Help Button Account Status Blocked and Status Open
        "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "open"
        }

        //Dashboard Event Help Button Account Status Blocked and Status Closed
        "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "closed"
        }

        //Dashboard Event Help Button Account Status Cancelled and Status Open
        "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "open"
        }

        //Dashboard Event Help Button Account Status Cancelled and Status Closed
        "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "closed"
        }

        //Event Show Limit Modal
        //Dashboard Event Show Limit Modal Button Account Status Pending and Status Open
        "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "open"
            available_limit = 900
            total_limit = 1000
        }

        //Dashboard Event Show Limit Modal Button Account Status Pending and Status Closed
        "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event) {
            account = account_pending_data
            statement_status = "closed"
            available_limit = 900
            total_limit = 1000
        }

        //Dashboard Event Show Limit Modal Button Account Status Active and Status Open
        "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "open"
            available_limit = 900
            total_limit = 1000
        }

        //Dashboard Event Show Limit Modal Button Account Status Active and Status Closed
        "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event) {
            account = account_active_data
            statement_status = "closed"
            available_limit = 500
            total_limit = 1000
        }

        //Dashboard Event Show Limit Modal Button Account Status Blocked and Status Open
        "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "open"
            available_limit = 300
            total_limit = 1000
        }

        //Dashboard Event Show Limit Modal Button Account Status Blocked and Status Closed
        "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_data
            statement_status = "closed"
            available_limit = 4000
            total_limit = 5000
        }

        //Dashboard Event Show Limit Modal Button Account Status Cancelled and Status Open
        "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "open"
            available_limit = 1500
            total_limit = 2000
        }

        //Dashboard Event Show Limit Modal Button Account Status Cancelled and Status Closed
        "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event) {
            account = account_cancelled_data
            statement_status = "closed"
            available_limit = 900
            total_limit = 1000
        }

        //Dashboard Event Collection Dialer Button when Account Status Overdue 60 days and Status Closed
        "/credits/credit_card/dashboard/collection_dialer_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_locked_product_data
            statement_status = "closed"
        }

        //Dashboard Event Collection Dialer Button when Account Status Overdue 60 days and Status Open
        "/credits/credit_card/dashboard/collection_dialer_button_action"(platform: "/", type: TrackType.Event) {
            account = account_blocked_locked_product_data
            statement_status = "open"
        }

        //Dashboard Event Dialer Button when Error by Internal Error and Status Closed
        "/credits/credit_card/dashboard/fallback_dialer_button_action"(platform: "/", type: TrackType.Event) {
            error = error_internal_error_data
        }

        //Dashboard Event Dialer Button when Error by Timeout and Status Closed
        "/credits/credit_card/dashboard/fallback_retry_action"(platform: "/", type: TrackType.Event) {
            error = error_timeout_data
        }

        //Dashboard Event Request calling dashboard when rendering skeleton is Empty
        "/credits/credit_card/dashboard/load_credit_sections_event"(platform: "/", type: TrackType.Event) { }
    }
        /*********************************************
         *       End: Credit Card Dashboard
         *********************************************/

        test("Credits Credit Card - Disable tests") {
            /***********************************************
             *       Start: Credit Card Disable
             ***********************************************/

            //Separator
            "/credits/credit_card/disable/separator"(platform: "/", type: TrackType.View) {
                account = account_rating_a
            }

            //Hub
            "/credits/credit_card/disable/hub"(platform: "/", type: TrackType.View) {
                account = account_rating_a
            }

            //Reason Selection
            "/credits/credit_card/disable/reasons"(platform: "/", type: TrackType.View) {
                account = account_rating_a
            }

            //Confirmation modal
            "/credits/credit_card/disable/modal"(platform: "/", type: TrackType.View) {
                account = account_rating_a
            }

            //Summary
            "/credits/credit_card/disable/summary"(platform: "/", type: TrackType.View) {
                account = account_rating_a
                disable_option = disable_option_data_a
            }

            "/credits/credit_card/disable/summary"(platform: "/", type: TrackType.View) {
                account = account_rating_a
                disable_option = disable_option_data_b
            }

            //Congrats
            "/credits/credit_card/disable/congrats"(platform: "/", type: TrackType.View) {
                account = account_rating_a
                disable_option = disable_option_data_b
                reasons = reasons_data
                other_reason = other_reason_data
            }
            /***********************************************
             *       End: Credit Card Disable
             ***********************************************/
        }

        test("Credits Credit Card - Landings tests") {
            /***********************************************
             *       Start: Credit Card Landings
             ***********************************************/

            // Generic Stop Page
            "/credits/credit_card/landing/generic"(platform: "/web", type: TrackType.View) {}

            /***********************************************
             *       End: Credit Card Landings
             ***********************************************/
        }
        test("Credits Credit Card - Wait List tests") {
            /***********************************************
             *       Start: Credit Card Wait List
             ***********************************************/

            // Landing
            "/credits/credit_card/waitlist/landing"(platform: "/", type: TrackType.View) {}

            //Congrats

            "/credits/credit_card/waitlist/congrats"(platform: "/", type: TrackType.View) {
                status = "registered"
            }

            "/credits/credit_card/waitlist/congrats"(platform: "/", type: TrackType.View) {
                status = "already_registered"
            }

            //Error
            "/credits/credit_card/waitlist/error"(platform: "/", type: TrackType.View) {
                reason = "Wait list error"
            }


                /***********************************************
             *       End: Credit Card Wait List
             ***********************************************/
        }
        test("Credits Credit Card - Reissue tests") {
            /***********************************************
             *       Start: Credit Card Reissue
             ***********************************************/

            //Separator
            "/credits/credit_card/block_card/virtual/separator"(platform: "/", type: TrackType.View) {
                card_id = "1234abcd"
            }

            "/credits/credit_card/block_card/virtual/separator/button"(platform: "/", type: TrackType.Event) {
                card_id = "1234abcd"
                action = "primary_button"
            }

            "/credits/credit_card/block_card/virtual/separator/button"(platform: "/", type: TrackType.Event) {
                card_id = "1234abcd"
                action = "secondary_button"
            }

            //Congrats
            "/credits/credit_card/block_card/virtual/congrats"(platform: "/", type: TrackType.View) {
                type = "virtual_credit_reissue_congrats"
                status = "200"
            }

            //Error
            "/credits/credit_card/block_card/virtual/error"(platform: "/", type: TrackType.View) {
                type = "virtual_credit_reissue_error"
                status = "404"
            }


            /***********************************************
             *       End: Credit Card Reissue
             ***********************************************/
        }
}