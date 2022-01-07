package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1319"

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

    def error_data = objectSchemaDefinitions {
        type(
                description: "Error type",
                type: PropertyType.String,
                required: true,
                values: [
                        "timeout",
                        "failed_dependency",
                        "internal_error"
                ]
        )
        cause(
                description: "Error cause",
                type: PropertyType.String,
                required: true
        )
    }

    def account_rating = objectSchemaDefinitions {
        rating(
                description: "User reputation level",
                type: PropertyType.String,
                required: true,
                values: [
                        "A",
                        "B",
                        "C"
                ]
        )
    }
    def withdraw_limit = objectSchemaDefinitions {
        total(
                description: "Total amount.",
                type: PropertyType.Numeric,
                required: true
        )
        available(
                description: "Available amount.",
                type: PropertyType.Numeric,
                required: true
        )
    }
    def unavailable_composition_item = objectSchemaDefinitions {
        amount(
                description: "amount",
                type: PropertyType.Numeric,
                required: true
        )
        type(
                description: "type",
                type: PropertyType.String,
                required: true
        )
    }
    def overlimit_data = objectSchemaDefinitions {
        additional_percentage(
                description: "Additional percentage.",
                type: PropertyType.Numeric,
                required: true
        )
        additional_amount(
                description: "Additional amount.",
                type: PropertyType.Numeric,
                required: true
        )
        consumed(
                description: "Amount consumed.",
                type: PropertyType.Numeric,
                required: true
        )
    }
    def limit_data = objectSchemaDefinitions {
        withdraw(
                description: "Limits withdraw.",
                type: PropertyType.Map(withdraw_limit),
                required: true
        )
        total(
                description: "Limits total.",
                type: PropertyType.Numeric,
                required: true
        )
        available(
                description: "Limits available.",
                type: PropertyType.Numeric,
                required: true
        )
        unavailable_composition(
                description: "Limits unavailable composition items.",
                type: PropertyType.ArrayList(PropertyType.Map(unavailable_composition_item)),
                required: true
        )
        over_limit(
                description: "Overlimit data",
                type: PropertyType.Map(overlimit_data),
                required: true
        )
    }
    def agreement_data = objectSchemaDefinitions {
        amount(
                description: "Agreement total amount",
                type: PropertyType.Numeric,
                required: true
        )
        installment_number(
                description: "Agreement's installment number",
                type: PropertyType.Numeric,
                required: true
        )
        next_payment_amount(
                description: "Installment next payment amount",
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
                required: false
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
        error(
            description: "Error Cause and Type on TC Dashboard",
            type: PropertyType.Map(error_data),
            required: false
        )
        agreement(
                description: "User makes an agreement to pay their dues",
                type: PropertyType.Map(agreement_data),
                required: false
        )
        sections(
                description: "Sections rendered in statements view",
                type: PropertyType.String,
                required: false,
                values: [
                        "barchart, payment, movements",
                        "barchart_fallback, payment, movements",
                        "barchart, movements_fallback"
                ]
        )
        error_type(
                description: "Error type",
                type: PropertyType.String,
                required: false,
                values: [
                        "timeout",
                        "failed_dependency",
                        "internal_error"
                ]
        )
        origin(
                description: "Represent the button retry clicked in the fallback",
                type: PropertyType.String,
                required: false,
                values: [
                        "barchart",
                        "movements",
                        "all"
                ]
        )
    }

    propertyGroups {
        dashboard_view_group(account, statement_status, pending_payments, error)
        dashboard_event_group(account, statement_status)
        dashboard_agreement_event_group(account, statement_status, agreement)
        payment_group(account, statement_status)
        full_payment_group(account, statement_status, payment_option, amount_input, payment_plan)
        statement_status_group(statement_status , account, sections)
        statement_period(month, year)
        disable_group(account, disable_option)
        disable_full_group(account, disable_option, reasons, other_reason)
        error_group(error)
        fallback_group(error_type, origin)
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/credit_card"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/payment"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/statement"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/disable"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/landing"(platform: "/web", isAbstract: true) {}
    "/credits/credit_card/benefits"(platform: "/", isAbstract: true){}
    "/credits/credit_card/block_card/virtual"(platform: "/", isAbstract: true){}
    "/credits/credit_card/overlimit"(platform: "/", isAbstract: true){}

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

    "/credits/credit_card/statement/fallback_retry_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        fallback_group
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
        dashboard_agreement_event_group
    }

    "/credits/credit_card/dashboard/limit_modal_payment_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_agreement_event_group
    }

    "/credits/credit_card/dashboard/loyalty_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_agreement_event_group
    }

    "/credits/credit_card/dashboard/statement_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_agreement_event_group
    }

    "/credits/credit_card/dashboard/row_statement_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_agreement_event_group
    }

    "/credits/credit_card/dashboard/limit_modal_statement_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_agreement_event_group
    }

    "/credits/credit_card/dashboard/help_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_agreement_event_group
    }

    "/credits/credit_card/dashboard/show_limit_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_agreement_event_group
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

    "/credits/credit_card/dashboard/collection_dialer_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        dashboard_agreement_event_group
    }

    "/credits/credit_card/dashboard/fallback_dialer_button_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        error_group
    }

    "/credits/credit_card/dashboard/fallback_retry_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        error_group
    }

    "/credits/credit_card/dashboard/load_credit_sections_event"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) { }

    //overlimit button
    "/credits/credit_card/dashboard/overlimit_button_action"(platform: "/", type: TrackType.Event) {
        action (
                required: true,
                type: PropertyType.String,
                values: ["overlimit_button_action"],
                description: "overlimit button"
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
     *       Start: Credit Card Benefits
     ***********************************************/

    // Landings
    "/credits/credit_card/benefits/landing"(platform: "/", type: TrackType.View) {}

    /*********************************************
     *       End: Credit Card Benefits
     *********************************************/

    /***********************************************
     *       Start: Credit Card Overlimit
     ***********************************************/
    // Page view
    "/credits/credit_card/overlimit"(platform: "/", type: TrackType.View) {
        account(
                description: "Account rating",
                type: PropertyType.Map(account_rating),
                required: true,
                inheritable:false
        )
        limit(
                description: "Limits data.",
                type: PropertyType.Map(limit_data),
                required: true,
                inheritable:false
        )
        overlimit_status(
                description: "Overlimit status",
                type: PropertyType.String,
                required: true,
                values: [
                        "enable",
                        "disable"
                ],
                inheritable:false
        )
        overlimit_optin_status(
                description: "Overlimit optin status",
                type: PropertyType.String,
                required: true,
                values: [
                        "authorized",
                        "not_authorized"
                ],
                inheritable:false
        )
    }

    // overlimit switch action
    "/credits/credit_card/overlimit/switch_action"(platform: "/", type: TrackType.Event) {
        status(
                description: "Switch status.",
                type: PropertyType.String,
                required: true,
                values: [
                        "enable",
                        "disable"
                ]
        )
    }

    // overlimit optin action
    "/credits/credit_card/overlimit/optin_action"(platform: "/", type: TrackType.Event) {
        status(
                description: "Optin status.",
                type: PropertyType.String,
                required: true,
                values: [
                        "authorized",
                        "not_authorized"
                ]
        )
    }

    // overlimit help button
    "/credits/credit_card/overlimit/help_button"(platform: "/", type: TrackType.Event) {
        action(
                description: "Overlimit help button action.",
                type: PropertyType.String,
                required: true,
                values: [
                        "help_button_tap"
                ]
        )
    }

    /*********************************************
     *       End: Credit Card Overlimit
     *********************************************/

    /***********************************************
     *       Start: Credit Card Reissue
     ***********************************************/
    //Separator
    "/credits/credit_card/block_card/virtual/separator"(platform: "/", type: TrackType.View) {
        card_id (
                required: true,
                type: PropertyType.String,
                description: "Card id",
                inheritable: false
        )
    }

    "/credits/credit_card/block_card/virtual/separator/button"(platform: "/", type: TrackType.Event) {
        action (
                required: true,
                type: PropertyType.String,
                values: ["primary_button", "secondary_button"],
                description: "The action type tapped in Separator"
        )
        card_id (
                required: true,
                type: PropertyType.String,
                description: "Card id",
                inheritable: false
        )
    }

    //Congrats
    "/credits/credit_card/block_card/virtual/congrats"(platform: "/", type: TrackType.View) {
        type (
                required: true,
                type: PropertyType.String,
                description: "Type of congrats in reissue",
                values: ["virtual_credit_reissue_congrats"]
        )
        status (
                required: true,
                type: PropertyType.String,
                description: "status code",
                inheritable:false
        )

    }

    //Error
    "/credits/credit_card/block_card/virtual/error"(platform: "/", type: TrackType.View) {
        type (
                required: true,
                type: PropertyType.String,
                description: "Type of error in reissue",
                values: ["virtual_credit_reissue_error"]
        )
        status (
                required: true,
                type: PropertyType.String,
                description: "Error code",
                inheritable:false
        )
    }

    /*********************************************
     *       End: Credit Card Reissue
     *********************************************/
}