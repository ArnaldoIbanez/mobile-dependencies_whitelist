package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1205"

    propertyDefinitions {
        status(
            type: PropertyType.String,
            required: false,
            description: "Loan status",
            values: [
                'on_time',
                'overdue',
                'finished'
            ]
        )
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/express_money"(platform: "/web", isAbstract: true) {}
    "/credits/merchant"(platform: "/web", isAbstract: true) {}
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/credits/self_service"(platform: "/", isAbstract: true) {}
    "/credits/self_service/promises"(platform: "/", isAbstract: true) {}
    "/credits/self_service/debt-relief"(platform: "/", isAbstract: true) {}
    "/credits/merchant/open_market"(platform: "/", isAbstract: true) {
        flow(
            type: PropertyType.String,
            required: true,
            description: "From which flow was landing accessed",
            values: [
                'upsell_offer',
                'request_offer',
            ]
        )
    }
    "/credits/merchant/open_market/financial_scraping"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Consumer Public Landings
     ******************************************/
    "/credits/consumer/public_landing"(platform: "/", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, inheritable: false, values: ["guest", "no_offer"])
        sk(description: "Source key", type: PropertyType.String, required: false)
    }
    /******************************************
     *       End: Consumer Public Landings
     ******************************************/

     /******************************************
     *   Start: Consumer Admin Detail
     ******************************************/

    "/credits/consumer/administrator"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/administrator/detail"(platform: "/", type: TrackType.View) {
        loan_id(
                type: PropertyType.Numeric,
                description: "The id of the current loan",
                required: true,
                inheritable: false
        )
        next_installment_status(
                type: PropertyType.String,
                description: "Status of the closest to expire installment",
                required: true,
                inheritable: false,
                values: [
                        'on_time',
                        'to_expire_soft',
                        'to_expire_hard',
                        'expired_today',
                        'no_charge_period',
                        'fixed_charge_period_1',
                        'fixed_charge_period_2',
                        'daily_charge_period',
                        'paid'
                ])
    }
    "/credits/consumer/administrator/dashboard"(platform: "/", type: TrackType.View) {
        dashboard_status(type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
    }
    "/credits/consumer/administrator/summary"(platform: "/", type: TrackType.View) {
        summary_status(description: "Current status of the loan summary", type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
    }

    //Events
    "/credits/consumer/administrator/detail/see_loan_conditions"(platform: "/", type: TrackType.Event) {}

    "/credits/consumer/administrator/detail/see_tac"(platform: "/", type: TrackType.Event) {}

    "/credits/consumer/administrator/payment_intention"(platform: "/", type: TrackType.Event) {
        installment_status(
                type: PropertyType.String,
                required: true,
                description: "Current status of clicked pay button",
                values: [
                        'on_time',
                        'to_expire_soft',
                        'to_expire_hard',
                        'expired_today',
                        'no_charge_period',
                        'fixed_charge_period_1',
                        'fixed_charge_period_2',
                        'daily_charge_period'
                ]
        )
        payment_intention(type: PropertyType.String, required: true, values: ['cho', 'ticket'])
    }

    "/credits/consumer/administrator/summary/payment_intention"(platform: "/", type: TrackType.Event) {
    }
    "/credits/consumer/administrator/summary/cx_contact"(platform: "/", type: TrackType.Event) {
    }
    "/credits/consumer/administrator/summary/go_shopping"(platform: "/", type: TrackType.Event) {
    }
    "/credits/consumer/administrator/summary/get_help"(platform: "/", type: TrackType.Event) {
        summary_status(description: "Current status of the loan summary", type: PropertyType.String, required: false, values: ["empty_state", "on_time", "overdue"])
    }
    "/credits/consumer/administrator/summary/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {
        summary_status(description: "Current status of the loan summary", type: PropertyType.String, required: false, values: ["empty_state", "on_time", "overdue"])
    }
    "/credits/consumer/administrator/summary/get_educative"(platform: "/", type: TrackType.Event) {
    }

    //Admin Dashboard v2

    //Page Views
    "/credits/consumer/administrator_v2"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/administrator_v2/dashboard"(platform: "/", type: TrackType.View) {
        dashboard_status(
                            required: true,
                            description: "Current status of the Dashboard",
                            type: PropertyType.String,
                            values: [
                                        "empty_state",
                                        "on_time",
                                        "overdue"
                                    ]
                        )
        personalLoanAccessShown(
                required: false,
                description: "Personal loan access type",
                type: PropertyType.String,
                values: [
                        "row",
                        "banner"
                ]
        )
        offer(
            required: false,
            description: "Self service option shown to the user",
            type: PropertyType.ArrayList(PropertyType.String)
        )
        opt_in_separator(
                required: false,
                description: "It is only shown when user needs to allow notifications",
                type: PropertyType.String,
                values: [
                        "visible",
                        "not visible"
                ]
        )
        source_key(
                required: false,
                description: "Identifies the origin of the user",
                type: PropertyType.String,
        )
    }
    "/credits/consumer/administrator_v2/error_message"(platform: "/mobile", type: TrackType.View) {
        user_status(
                            required: true,
                            description: "Credit line's current status",
                            type: PropertyType.String,
                            values: [
                                        "manually_paused"
                                    ]
                    )
    }

    //Events
    "/credits/consumer/administrator_v2/dashboard/go_know_more_faq"(platform: "/", type: TrackType.Event) {
        dashboard_status(
                required: true,
                description: "Defines if the user accesses the FAQ of the button Know more",
                type: PropertyType.String,
                values: [
                        "empty_state",
                        "on_time",
                        "overdue",
                        "finished"
                ]
        )
    }
    "/credits/consumer/administrator_v2/dashboard/go_upsell_cx"(platform: "/", type: TrackType.Event) {
        dashboard_status(
                required: true,
                description: "Defines if the user accesses the FAQ of the button Know more",
                type: PropertyType.String,
                values: [
                        "empty_state",
                        "on_time",
                        "overdue",
                        "finished"
                ]
        )
        list_status(
                required: true,
                description: "Defines if the user can increase his limit",
                type: PropertyType.String,
                values: [
                        "black_list",
                        "white_list"
                ]
        )
    }

    //Mobile Events
    "/credits/consumer/administrator_v2/dashboard/opt_in_wsp"(platform: "/", type: TrackType.Event) {
        status(
                required: true,
                description: "Define if user allows or not whatsapp notifications",
                type: PropertyType.Boolean,
        )
    }
    "/credits/consumer/administrator_v2/dashboard/payment_intention_all"(platform: "/mobile", type: TrackType.Event) {
        installments_group
        installments_qty(
                type: PropertyType.Numeric,
                description: "Tne number of the installments to pay",
                required: true,
                inheritable: false
        )
        advance_installment(
            required: false,
            description: "User wanted to pay in advance and was redirected to CX widget",
            type: PropertyType.Boolean,
        )
    }
    "/credits/consumer/administrator_v2/details_button"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/choose_installments"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_help"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_help/how_to_pay_installments"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_uses_modal"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_how_to_use_modal"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/cx_contact"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_shopping"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_educative"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_mp"(platform: "/mobile", type: TrackType.Event) {
        has_mp(type: PropertyType.Boolean, required: true)
    }
    "/credits/consumer/administrator_v2/dashboard/close_mp_modal"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_store_mp"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_installments_detail"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/error_message/button_pressed"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/administrator_v2/promises"(platform: "/mobile", isAbstract: true) {}
    "/credits/consumer/administrator_v2/promises/create"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/promises/view"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/debt_relief"(platform: "/mobile", isAbstract: true) {}
    "/credits/consumer/administrator_v2/debt_relief/create"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/debt_relief/info"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/payment_not_credited"(platform: "/mobile", type: TrackType.Event) {}

    //Event PX Congrats Extra Component
    "/credits/consumer/administrator_v2/dashboard/opt_in_wsp_px_access"(platform: "/mobile", type: TrackType.Event) {}

    //Onboarding view
    "/credits/consumer/administrator_v2/onboarding"(platform: "/mobile", type: TrackType.View) {}

    //Events
    "/credits/consumer/administrator_v2/onboarding/how_to_pay_installments"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/onboarding/go_mc"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/onboarding/close"(platform: "/mobile", type: TrackType.Event) {}


    /******************************************
     *       End: Consumers Administrator
     ******************************************/


    /****************************************************
     *       Start: Consumers Installment Selection Page
     ****************************************************/

    //Views
    "/credits/consumer/administrator_v2/installment_selection"(platform: "/mobile", type: TrackType.View) {
        page_status(type: PropertyType.String, required: true, values: ["empty_state","on_time", "overdue"])
    }

    //Events
    "/credits/consumer/administrator_v2/installment_selection/payment_intention"(platform: "/", type: TrackType.Event) {
        total_installments(
                type: PropertyType.Numeric,
                required: true,
                description: "The total number of payable installments"
        )
        paid_installments(
                type: PropertyType.Numeric,
                required: true,
                description: "The selected number of installments to pay"
        )
    }
    "/credits/consumer/administrator_v2/installment_selection/secondary_payment_intention"(platform: "/", type: TrackType.Event) {
        total_installments(
                type: PropertyType.Numeric,
                required: true,
                description: "The total number of payable installments"
        )
    }
    "/credits/consumer/administrator_v2/installment_selection/back_to_dashboard"(platform: "/", type: TrackType.Event) {
    }

    /****************************************************
     *       End: Consumers Installment Selection Page
     ****************************************************/

    /******************************************
     *    Start: Consumers Change Due Date FLow
     ******************************************/
    "/credits/consumer/duedate_selection"(platform: "/", type: TrackType.View) {
        available_products(description: "products that user was used", type: PropertyType.ArrayList, required: true)
        due_date (description: "Positive number for actuall due date",type: PropertyType.Numeric,required: true)
    }

    "/credits/consumer/duedate_selection/success"(platform: "/", type: TrackType.View) {
        new_due_date(description: "Positive number for actuall due date",type: PropertyType.Numeric,required: true)
    }

    "/credits/consumer/duedate_selection/not_allowed"(platform: "/", type: TrackType.View) {}

    "/credits/consumer/duedate_selection/error"(platform: "/", type: TrackType.View) {}

    "/credits/consumer/duedate_selection/cancel"(platform: "/", type: TrackType.Event) {}

     /******************************************
     *    End: Consumers Change Due Date FLow
     ******************************************/

    /******************************************
     *    Start: Consumers Early Repayments FLow
     ******************************************/
    "/credits/consumer/early_repayments"(platform: "/", type: TrackType.View) {
        total_amount(
            required: false,
            description: "total installments amount",
            type: PropertyType.Numeric
        )
        total_amount_with_discount(
            required: false,
            description: "total amount offerted to user",
            type: PropertyType.Numeric
        )
        total_discount(
            required: false,
            description: "Total discount",
            type: PropertyType.Numeric
        )
        installments_ids(
            required: false,
            description: "Array of Installments",
            type: PropertyType.ArrayList
        )
    }

    "/credits/consumer/early_repayments/success"(platform: "/", type: TrackType.View) {}

    "/credits/consumer/early_repayments/error"(platform: "/", type: TrackType.View) {}

    "/credits/consumer/early_repayments/warning"(platform: "/", type: TrackType.View) {}

    "/credits/consumer/early_repayments/accept"(platform: "/", type: TrackType.Event) {
        total_amount(
            required: false,
            description: "total installments amount",
            type: PropertyType.Numeric
        )
        total_amount_with_discount(
            required: false,
            description: "total amount offerted to user",
            type: PropertyType.Numeric
        )
        total_discount(
            required: false,
            description: "Total discount",
            type: PropertyType.Numeric
        )
        installments_ids(
            required: false,
            description: "Array of Installments",
            type: PropertyType.ArrayList
        )
    }

     /******************************************
     *    End: Consumers Early Repayments FLow
     ******************************************/
}
