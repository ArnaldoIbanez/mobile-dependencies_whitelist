package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1205"

    def account_data = objectSchemaDefinitions {
        rating(
                description: "User reputation level",
                type: PropertyType.String,
                required: true
        )
        status(
                description: "Status user's account",
                type: PropertyType.String,
                required: false,
                values: [
                        "pending",
                        "active",
                        "blocked",
                        "cancelled"
                ]
        )
        status_detail(
                description: "Status detail of user's account",
                type: PropertyType.String,
                required: false
        )
        overdue_days(
                description: "Overdue days of user's account",
                type: PropertyType.Numeric,
                required: false
        )
    }

    def proposal_data = objectSchemaDefinitions {
        rating(
                description: "User reputation level",
                type: PropertyType.String,
                required: true
        )
    }

    def amount_input_data = objectSchemaDefinitions {
        amount(
            description: "The amount that the user want to pay",
            type: PropertyType.Numeric,
            required: true
        )
        statement_min_amount(
            description: "The minimum amount that the user must pay",
            type: PropertyType.Numeric,
            required: true
        )
        statement_max_amount(
            description: "The current statement amount",
            type: PropertyType.Numeric,
            required: true
        )
        account_total_amount(
            description: "The user total debt",
            type: PropertyType.Numeric,
            required: false
        )
    }

    def payment_plan_data = objectSchemaDefinitions {
        payment_plan_number(
            description: "The payment plan option that was selected",
            type: PropertyType.Numeric,
            required: true
        )
        min_payment_plan(
            description: "The minimum option available to select",
            type: PropertyType.Numeric,
            required: true
        )
        max_payment_plan(
            description: "The maximum option available to select",
            type: PropertyType.Numeric,
            required: true
        )
    }

    propertyDefinitions {
        amount_input(
            type: PropertyType.Map(amount_input_data),
            required: false
        )
        payment_plan(
            type: PropertyType.Map(payment_plan_data),
            required: false
        )
        statement_status(
            description: "Status from the user's statement",
            type: PropertyType.String,
            required: false,
            values: [
                    "closed",
                    "open",
                    "scheduled",
                    "overdue",
                    "paid"
            ]
        )
        payment_option(
            description: "How the user pays",
            type: PropertyType.String,
            required: true,
            values: [
                "more_than_total",
                "partial",
                "payment_plan",
                "total",
                "total_account"
            ]
        )
        is_card_active(
            description: "Status of the user's card",
            type: PropertyType.Boolean,
            required: false
        )
        bucket(
            description: "Payment due date chosen",
            type: PropertyType.Numeric,
            required: true
        )
        month(
            description: "The month of the selected period",
            type: PropertyType.Numeric,
            required: true
        )
        year(
            description: "The year of the selected period",
            type: PropertyType.Numeric,
            required: true
        )
        account(
                type: PropertyType.Map(account_data),
                required: false
        )
        proposal(
                type: PropertyType.Map(proposal_data),
                required: true
        )
        pending_payments(
                description: "The pending payments",
                type: PropertyType.Boolean,
                required: true
        )
        disable_option(
            description: "The account cancellation type",
            type: PropertyType.String,
            required: true,
            values: [
                "one_payment",
                "monthly_payment"
            ]
        )
        reasons(
            description: "The chosen reasons list",
            type: PropertyType.ArrayList,
            required: true
        )
        other_reason(
            description: "The user input reason",
            type: PropertyType.String,
            required: false
        )
    }

    propertyGroups {
        dashboard_view_group(account, statement_status, pending_payments)
        dashboard_event_group(account, statement_status)
        payment_group(account, statement_status)
        upgrade_info(proposal, is_card_active)
        full_payment_group(account, statement_status, payment_option, amount_input, payment_plan)
        bucket_group(bucket)
        statement_status_group(statement_status , account)
        statement_period(month, year)
        disable_group(account, disable_option)
        disable_full_group(account, disable_option, reasons, other_reason)
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/credit_card"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/payment"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/upgrade"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/statement"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/disable"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/landing"(platform: "/web", isAbstract: true) {}
    "/credits/credit_card/waitlist"(platform: "/", isAbstract: true){}


    /******************************************
     *       Start: Credit Card Payment
     ******************************************/
    //Hub
    "/credits/credit_card/payment/hub"(platform: "/", type: TrackType.View) {
        payment_group
    }

    "/credits/credit_card/payment/hub/total_payment_action"(platform: "/", type: TrackType.Event) {
        amount(
            description: "Statement amount",
            type: PropertyType.Numeric,
            required: true
        )
    }

    //Payment plan
    "/credits/credit_card/payment/hub/payment_plan_selection"(platform: "/", type: TrackType.View) {
        payment_group
    }

    //Amount input
    "/credits/credit_card/payment/amount_input"(platform: "/", type: TrackType.View) {
        payment_group
    }

    //Summary
    "/credits/credit_card/payment/summary"(platform: "/", type: TrackType.View) {
        full_payment_group
    }

    "/credits/credit_card/payment/summary/payment_action"(platform: "/", type: TrackType.Event) {
        full_payment_group
    }
    /******************************************
     *       End: Credit Card Payment
     ******************************************/


    /***********************************************
     *       Start: Credit Card Upgrade
     ***********************************************/
    // Onboarding
    "/credits/credit_card/upgrade/onboarding"(platform: "/", type: TrackType.View) {
        upgrade_info
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: false)
        from(
                description: "Indicates where the onboarding flow was accessed from",
                type: PropertyType.String,
                required: true
        )
    }

    "/credits/credit_card/upgrade/onboarding/change_page"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        upgrade_info
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: true)
    }

    // Payment due date selection
    "/credits/credit_card/upgrade/payment_due_date_selection"(platform: "/", type: TrackType.View) {
        upgrade_info
        buckets(
            description: "Payment due date options",
            type: PropertyType.ArrayList(PropertyType.Numeric),
            required: true
        )
    }

    // Summary
    "/credits/credit_card/upgrade/summary"(platform: "/", type: TrackType.View) {
        upgrade_info
        bucket_group
        limit(
            description: "User's card limit",
            type: PropertyType.Numeric,
            required: true
        )
        annuity_cost(
            description: "User's card annuity cost",
            type: PropertyType.Numeric,
            required: true
        )
    }

    "/credits/credit_card/upgrade/summary/payment_due_date_selection_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        bucket_group
    }

    // Congrats
    "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
        upgrade_info
        status(
            description: "Status from the user's upgrade request",
            type: PropertyType.String,
            required: true,
            values: [
                "approved",
                "pending",
                "rejected"
            ]
        )
        congrats_status(
                description: "Status for the congrats's view",
                type: PropertyType.String,
                required: true,
                values: [
                        "linked_card",
                        "not_linked_card",
                        "physical_not_requested"
                ]
        )
        from(
                description: "Indicates where the upgrade congrats flow was accessed from",
                type: PropertyType.String,
                required: true
        )
    }

    "/credits/credit_card/upgrade/congrats/promotion_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/credits/credit_card/upgrade/congrats/go_dashboard_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/credits/credit_card/upgrade/congrats/physical_card_request"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        status(
                description: "Status from the physical card request",
                type: PropertyType.String,
                required: true,
                values: [
                        "approved",
                        "pending"
                ]
        )
    }

    "/credits/credit_card/upgrade/congrats/physical_card_unlock"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        status(
                description: "Status from the physical card unlock",
                type: PropertyType.String,
                required: true,
                values: [
                        "approved",
                        "pending"
                ]
        )
    }

    // Error
    "/credits/credit_card/upgrade/error"(platform: "/", type: TrackType.View) {
        reason(type: PropertyType.String, required: false)
    }

    // Stop page
    "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View) {
        reason(
                description: "Reason why the Card can't be upgraded",
                type: PropertyType.String,
                required: true,
                values: [
                        "no_proposal_match",
                        "invalid_proposal_status",
                        "kyc_not_compliant",
                        "physical_card_request",
                        "kyc_api_failed"
                ]
        )
    }

    "/credits/credit_card/upgrade/stop_page/redirect_to_dashboard"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        status(
                description: "Indicates the status and then redirect to the dashboard",
                type: PropertyType.String,
                required: true,
                values: [
                        "user_has_active_account"
                ]
        )
    }

    /*********************************************
     *       End: Credit Card Upgrade
     *********************************************/

    /***********************************************
     *       Start: Credit Card Statement
     ***********************************************/
    // Statement
    "/credits/credit_card/statement"(platform: "/", type: TrackType.View) {
        statement_status_group
    }

    "/credits/credit_card/statement/payment_action"(platform: "/", type: TrackType.Event) {}

    "/credits/credit_card/statement/download_pdf_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        statement_period
    }

    "/credits/credit_card/statement/month_selected_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        statement_period
        month_diff(
            description: "The difference in months between the selected & the actual statement",
            type: PropertyType.Numeric,
            required: true
        )
    }

    /*********************************************
     *       End: Credit Card Statement
     *********************************************/

    /***********************************************
     *       Start: Credit Card Dashboard
     ***********************************************/
    // Dashboard
    "/credits/credit_card/dashboard"(platform: "/", type: TrackType.View) {
        dashboard_view_group
    }

    "/credits/credit_card/dashboard/payment_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_event_group
    }

    "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_event_group
    }

    "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_event_group
    }

    "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_event_group
    }

    "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_event_group
    }

    "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_event_group
    }

    "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_event_group
    }

    "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_event_group
        available_limit(
                description: "Amount available limit card",
                type: PropertyType.Numeric,
                required: true
        )
        total_limit(
                description: "Total amount limit card",
                type: PropertyType.Numeric,
                required: true
        )
    }

    /*********************************************
     *       End: Credit Card Dashboard
     *********************************************/

     /***********************************************
     *       Start: Credit Card Disable
     ***********************************************/
    // Disable

    //Hub
    "/credits/credit_card/disable/hub"(platform: "/", type: TrackType.View) {
        account(
                type: PropertyType.Map(account_data),
                required: true
        )
    }

    //Summary
    "/credits/credit_card/disable/summary"(platform: "/", type: TrackType.View) {
        disable_group
    }

    //Separator
    "/credits/credit_card/disable/separator"(platform: "/", type: TrackType.View) {
        account(
                type: PropertyType.Map(account_data),
                required: true
        )
    }

    //Reason
    "/credits/credit_card/disable/reasons"(platform: "/", type: TrackType.View) {
        account(
                type: PropertyType.Map(account_data),
                required: true
        )
    }

    //Confirmation Modal
    "/credits/credit_card/disable/modal"(platform: "/", type: TrackType.View) {
        account(
                type: PropertyType.Map(account_data),
                required: true
        )
    }

    //Congrats
    "/credits/credit_card/disable/congrats"(platform: "/", type: TrackType.View) {
        disable_full_group
    }

    /*********************************************
     *       End: Credit Card Disable
     *********************************************/

    /***********************************************
     *       Start: Credit Card Landings
     ***********************************************/
    // Landings

    // Generic Stop Page
    "/credits/credit_card/landing/generic"(platform: "/web", type: TrackType.View) { }

    /*********************************************
     *       End: Credit Card Landings
     *********************************************/


    /***********************************************
     *       Start: Credit Card Wait List
     ***********************************************/
    // Landings
    "/credits/credit_card/waitlist/landing"(platform: "/", type: TrackType.View) { }

    // Congrats
    "/credits/credit_card/waitlist/congrats"(platform: "/", type: TrackType.View) {
        status(
                description: "Status from the user in Wait list",
                type: PropertyType.String,
                required: true,
                values: [
                        "registered",
                        "already_registered",
                ]
        )
    }

    // Error
    "/credits/credit_card/waitlist/error"(platform: "/", type: TrackType.View) {
        reason(type: PropertyType.String, required: false)
    }

    /*********************************************
     *       End: Credit Card Wait List
     *********************************************/
}