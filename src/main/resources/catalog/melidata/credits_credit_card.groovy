package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1205"

    def account_data = objectSchemaDefinitions {
        rating(
                description: "Rating user's account",
                type: PropertyType.String,
                required: true
        )
        status(
                description: "Status user's account",
                type: PropertyType.String,
                required: true,
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
                required: true
        )
        overdue_days(
                description: "Overdue days of user's account",
                type: PropertyType.Numeric,
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
            required: true
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

    def offer_data = objectSchemaDefinitions {
        scoring(
            description: "User reputation level",
            type: PropertyType.String,
            required: true,
        )
    }

    propertyDefinitions {
        offer(
            type: PropertyType.Map(offer_data),
            required: true
        )
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
            required: true,
            values: [
                "closed",
                "open"
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
        pending_payments(
                description: "The pending payments",
                type: PropertyType.Boolean,
                required: true
        )
    }

    propertyGroups {
        payment_group(offer, statement_status)
        upgrade_info(offer, is_card_active)
        full_payment_group(offer, statement_status, payment_option, amount_input, payment_plan)
        bucket_group(bucket)
        statement_status_group(statement_status)
        statement_period(month, year)
        pending_payments_group(pending_payments)

    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/credit_card"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/payment"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/upgrade"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/statement"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Credit Card Payment
     ******************************************/
    //Hub
    "/credits/credit_card/payment/hub"(platform: "/", type: TrackType.View) {
        payment_group
    }

    "/credits/credit_card/payment/total_payment_action"(platform: "/", type: TrackType.Event) {
        amount(
            description: "Statement amount",
            type: PropertyType.Numeric,
            required: true
        )
    }

    //Payment plan
    "/credits/credit_card/payment/payment_plan_selection"(platform: "/", type: TrackType.View) {
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

    "/credits/credit_card/payment/payment_action"(platform: "/", type: TrackType.Event) {
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
    }

    "/credits/credit_card/upgrade/congrats/promotion_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/credits/credit_card/upgrade/congrats/go_dashboard_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    // Error
    "/credits/credit_card/upgrade/error"(platform: "/", type: TrackType.View) {
        reason(type: PropertyType.String, required: false)
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
        account
        statement_status_group
        pending_payments_group
    }

    "/credits/credit_card/dashboard/payment_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        account
        statement_status_group
    }

    "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        account
        statement_status_group
    }

    "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        account
        statement_status_group
    }

    "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        account
        statement_status_group
    }

    "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        account
        statement_status_group
    }

    "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        account
        statement_status_group
    }

    "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        account
        statement_status_group
    }

    "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        account
        statement_status_group
    }

    /*********************************************
     *       End: Credit Card Dashboard
     *********************************************/
}