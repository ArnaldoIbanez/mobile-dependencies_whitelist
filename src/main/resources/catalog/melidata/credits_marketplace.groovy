package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1205"

    propertyDefinitions {
        installments_qty( type: PropertyType.Numeric, required: true, description: "The total number of installments to pay")
    }

     propertyGroups {
        installments_group(installments_qty)
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/credits/pursue"(platform: "/", isAbstract: true) {}
    "/credits/consumer/myml"(platform: "/", isAbstract: true) {}
    "/credits/consumer/myml/summary"(platform: "/", isAbstract: true) {}
    "/credits/consumer/my_account"(platform: "/", isAbstract: true) {}
    "/credits/consumer/opensea"(platform: "/", isAbstract: true) {}
    "/credits/self_service"(platform: "/", isAbstract: true) {}
    "/credits/self_service/promises"(platform: "/", isAbstract: true) {}
    "/credits/self_service/debt-relief"(platform: "/", isAbstract: true) {}

    "/vip"(platform: "/", isAbstract: true) {}
    "/vip/credits"(platform: "/", isAbstract: true) {}
    "/vip/credits/pursue"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Consumers Public Landings
     ******************************************/
    //Public Landing

    //Page views
    "/credits/consumer/public_landing"(platform: "/", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, inheritable: false, values: ["guest", "no_offer"])
        sk(description: "Source key", type: PropertyType.String, required: false)
    }
    "/credits/consumer/public_landing/application_result"(platform: "/", type: TrackType.View) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected"])
    }
    "/credits/consumer/public_landing/application_result/click_credits"(platform: "/", type: TrackType.Event) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected"])
    }
    "/credits/consumer/public_landing/application_start"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/public_landing/error"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/public_landing/remedy"(platform: "/", type: TrackType.View) {
        remedy_name(description: "Remedy name", type: PropertyType.String, required: true)
    }

    //Events
    "/credits/consumer/public_landing/click_hero"(platform: "/", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
        variant(type: PropertyType.String, required: false)
    }
    "/credits/consumer/public_landing/credit_line_request"(platform: "/", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }
    "/credits/consumer/public_landing/click_help"(platform: "/", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }
    "/credits/consumer/public_landing/application_result/click_home"(platform: "/", type: TrackType.Event) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected"])
    }
    "/credits/consumer/public_landing/application_result/more_info"(platform: "/", type: TrackType.Event) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected"])
    }
    "/credits/consumer/public_landing/click_application_start"(platform: "/", type: TrackType.Event) {}

    //Remedy
    "/credits/consumer/opensea/add_receipt"(platform: "/web", type: TrackType.Event){}
    "/credits/consumer/opensea/summary"(platform: "/web", type: TrackType.View) {
        process(description: "Name of the finished process", type: PropertyType.String, required: true, values: ["receipt"])
    }

    /******************************************
     *       End: Consumers Public Landings
     ******************************************/

    /***********************************************
     *       Start: Consumers Intermediate Landing
     ***********************************************/
    //Intermediate Landing

    //Page view
    "/credits/consumer/opensea/intermediate_landing"(platform: "/mobile", type: TrackType.View) {}

    //Events
    "/credits/consumer/opensea/intermediate_landing/more_info"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/opensea/intermediate_landing/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    /*********************************************
     *       End: Consumers Intermediate Landing
     *********************************************/

    /******************************************
     *       Start: Consumers Administrator
     ******************************************/
    //Admin Dashboard

    //Page Views
    "/credits/consumer/administrator"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/administrator/dashboard"(platform: "/", type: TrackType.View) {
        dashboard_status(type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
    }
    "/credits/consumer/administrator/summary"(platform: "/", type: TrackType.View) {
        summary_status(description: "Current status of the loan summary", type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
    }

    //Events
    "/credits/consumer/administrator/tooltip"(platform: "/", type: TrackType.Event) {}
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
    "/credits/consumer/installment_payment"(platform: "/", type: TrackType.Event) {
        payment_id(type: PropertyType.String, required: true, description: "ID of payment")
        payment_method(type: PropertyType.String, required: true, description: "Payment method")
        payment_type(type: PropertyType.String, required: true, description: "Payment type")
        payment_result(type: PropertyType.String, required: true, description: "Result of the payment")
        payment_result_detail(type: PropertyType.String, required: false, description: "Detail of a rejected payment")
    }
    "/credits/consumer/administrator/details_button"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/help"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/educational_landing"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/see_product"(platform: "/", type: TrackType.Event) {}
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
    "/credits/consumer/administrator_v2/suggested_modal"(platform: "/", type: TrackType.View) {}

    //Events
    "/credits/consumer/administrator_v2/dashboard/opt_in_wsp"(platform: "/", type: TrackType.Event) {
        status(
                required: true,
                description: "Define if user allows or not whatsapp notifications",
                type: PropertyType.Boolean,
        )
    }
    "/credits/consumer/administrator_v2/payment_intention_all"(platform: "/", type: TrackType.Event) {
        installments_group
        advance_installment(
            required: false,
            description: "User wanted to pay in advance and was redirected to CX widget",
            type: PropertyType.Boolean,
        )
    }
    "/credits/consumer/administrator_v2/details_button"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/choose_installments"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/help"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/contact_card"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/educational_landing"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/suggested_product"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/home"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/suggested_modal/suggested_product_modal"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/suggested_modal/weekly_deals_link"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/suggested_modal/close_product_modal"(platform: "/", type: TrackType.Event) {}

    "/credits/consumer/administrator_v2/promises"(platform: "/", isAbstract: true) {}
    "/credits/consumer/administrator_v2/promises/create"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/promises/view"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/debt_relief"(platform: "/", isAbstract: true) {}
    "/credits/consumer/administrator_v2/debt_relief/create"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/payment_not_credited"(platform: "/", type: TrackType.Event) {}

    //Mobile Events
    "/credits/consumer/administrator_v2/dashboard/payment_intention_all"(platform: "/mobile", type: TrackType.Event) {
        installments_group
        advance_installment(
            required: false,
            description: "User wanted to pay in advance and was redirected to CX widget",
            type: PropertyType.Boolean,
        )
    }
    "/credits/consumer/administrator_v2/dashboard/choose_installments"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_help"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_help/how_to_pay_installments"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_uses_modal"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_how_to_use_modal"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/cx_contact"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_shopping"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_educative"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_mp"(platform: "/mobile", type: TrackType.Event) {
        has_mp(type: PropertyType.Boolean, required: true)
    }
    "/credits/consumer/administrator_v2/dashboard/close_mp_modal"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_store_mp"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_installments_detail"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/error_message/button_pressed"(platform: "/mobile", type: TrackType.Event) {}

    //Event PX Congrats Extra Component
    "/credits/consumer/administrator_v2/dashboard/opt_in_wsp_px_access"(platform: "/mobile", type: TrackType.Event) {}

    //Admin History (Compras Finalizadas)

    //Page views
    "/credits/consumer/administrator/history"(platform: "/", type: TrackType.View) {}

    //Events
    "/credits/consumer/administrator/history/details_button"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/history/educational_landing"(platform: "/", type: TrackType.Event) {}

    //Onboarding view
    "/credits/consumer/administrator_v2/onboarding"(platform: "/mobile", type: TrackType.View) {}

    //Events
    "/credits/consumer/administrator_v2/onboarding/how_to_pay_installments"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/onboarding/go_mc"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/onboarding/close"(platform: "/mobile", type: TrackType.Event) {}


    /******************************************
     *       End: Consumers Administrator
     ******************************************/

    /******************************************
     *       Start: Consumers Admin Detail
     ******************************************/

    //Page Views
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

    //Events
    "/credits/consumer/administrator/detail/see_loan_conditions"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/detail/see_tac"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/detail/see_voucher"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/detail/see_contract"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/detail/download_plan"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/detail/get_help"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/detail/purchase_detail"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/detail/back_to_dashboard"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/detail/payment_intention"(platform: "/", type: TrackType.Event) {
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
        payment_intention(
                type: PropertyType.String,
                description: "Current selected 'path' to payment",
                required: true,
                values: ['cho', 'ticket']
        )
        advance_installment(
            required: false,
            description: "User wanted to pay in advance and was redirected to CX widget",
            type: PropertyType.Boolean,
        )
    }
    "/credits/consumer/administrator/detail/payment_intention_list"(platform: "/", type: TrackType.Event) {
        installment_status(
                type: PropertyType.String,
                required: true,
                description: "Current status of clicked pay button in the installments table",
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
        payment_intention(
                type: PropertyType.String,
                description: "Current selected 'path' to payment",
                required: true,
                values: ['cho', 'ticket']
        )
        advance_installment(
            required: false,
            description: "User wanted to pay in advance and was redirected to CX widget",
            type: PropertyType.Boolean,
        )
    }

    /******************************************
     *       End: Consumers Admin Detail
     ******************************************/

    /****************************************************
     *       Start: Consumers Installment Selection Page
     ****************************************************/

    //Views
    "/credits/consumer/administrator_v2/installment_selection"(platform: "/", type: TrackType.View) {
        page_status(type: PropertyType.String, required: true, values: ["empty_state","on_time", "overdue"], inheritable: false)
    }
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
     *       Start: Consumers Enrollment
     ******************************************/
    //Landing consumer
    "/credits/consumer/enrollment"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/educational"(platform: "/", type: TrackType.View) {}

    //SMS validation
    "/credits/consumer/enrollment/sms_validation"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/sms_validation/cancel"(platform: "/", type: TrackType.Event) {}

    //Verification
    "/credits/consumer/enrollment/code_verification"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/code_verification/cancel"(platform: "/", type: TrackType.Event) {}

    //Congrats
    "/credits/consumer/enrollment/congrats"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/enrollment/congrats/buy"(platform: "/", type: TrackType.Event) {}

    //BreakingLanding
    "/credits/consumer/breaking_landing"(platform: "/", type: TrackType.View) {}

    /******************************************
     *       End: Consumers Enrollment
     ******************************************/

    /******************************************
     *       Start: Consumers Push
     ******************************************/

    //Landing Push Native
    //Page views
    "/credits/consumer/payinstallment"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: false)
    }

    //Events
    "/credits/consumer/payinstallment/on_time_pay"(platform: "/", type: TrackType.Event) {}

    //Delayed payment
    "/credits/consumer/payinstallment/overdue_pay"(platform: "/", type: TrackType.Event) {}

    /******************************************
     *       End: Consumers Push
     ******************************************/

    /******************************************
     *       Start: Consumers Recurring Campaign
     ******************************************/
    //Page Views
    "/credits/consumer/recurring_landing_test"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/recurring_congrats_test"(platform: "/", type: TrackType.View) {}

    //Event Views
    "/credits/consumer/like_recurring"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/dislike_recurring"(platform: "/", type: TrackType.Event) {}
    /******************************************
     *       End: Consumers Recurring Campaign
     ******************************************/

    /******************************************
     *       Start: Consumers Persue Campaign
     ******************************************/

    propertyDefinitions {
        status(required: true, type: PropertyType.String, values: ["no_charge_period", "fixed_charge_period_1", "fixed_charge_period_2", "daily_charge_period"],
                description: "Indicates user status")
        milestone(type: PropertyType.Numeric, required: true)
        context(required: false, values: ["search", "vip", "pdp", "pdpd", "home"],
                description: "The page or section where the nav action is taking place")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    propertyGroups {
        pursue_nav_properties(status, milestone, context)
        pursue_modal_properties(milestone, context, vip_version)
    }

    //Page Views
    "/credits/consumer/overdue_modal"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {
        pursue_modal_properties
        status(type: PropertyType.String, required: true,
                description: "Summary status for pre and post marketplace restriction who consumers with debt",
                values: ["pre_restriction", "post_restriction"])
    }

    //Event Views
    "/credits/consumer/overdue_modal/payment_intention"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        pursue_modal_properties
        status(type: PropertyType.String, required: true,
                description: "Summary status for pre and post marketplace restriction who consumers with debt",
                values: ["pre_restriction", "post_restriction"])
    }

    "/credits/consumer/overdue_nav"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        pursue_nav_properties
    }

    "/credits/consumer/overdue_nav/payment_intention"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        pursue_nav_properties
    }

    "/credits/consumer/myml/summary/payment_intention"(platform: "/", type: TrackType.Event) {
        loan_status(required: true, type: PropertyType.String, description: "Indicates loan status")
        place(
                type: PropertyType.String,
                required: true,
                values: ["left_section_message", "right_section_message"])
    }

    "/credits/consumer/my_account/left_nav"(platform: "/mobile", type: TrackType.Event) {}
    /******************************************
     *       End: Consumers Persue Campaign
     ******************************************/

    /******************************************
     *   Start: Consumers Unified Payment Hack
     ******************************************/

    "/credits/consumer/unified_payment_hack"(platform: "/", isAbstract: true) {}
    "/credits/consumer/unified_payment_hack/intermediate_landing"(platform: "/", isAbstract: true) {}
    "/credits/consumer/administrator/unified_payment_hack"(platform: "/", isAbstract: true) {}

    propertyDefinitions {
        loans_installments_status(
                description: "Installment status to be considered when paying debt",
                required: true,
                values: ["on_time", "to_expire_soft", "to_expire_hard", "expired_today", "no_charge_period"]
        )
        installments_count(
                description: "Installments count to pay",
                type: PropertyType.Numeric,
                required: true,
        )
    }

    propertyGroups {
        unified_payment_hack_properties(loans_installments_status, installments_count)
    }

    "/credits/consumer/administrator/unified_payment_hack/payment_intention"(platform: "/", type: TrackType.Event) {
        unified_payment_hack_properties
        days_apart(
                description: "Positive number indicanting the difference of days between now and the installments' due date",
                type: PropertyType.Numeric,
                required: true,
        )
    }

    "/credits/consumer/unified_payment_hack/intermediate_landing"(platform: "/", type: TrackType.View) {
        unified_payment_hack_properties
        money_account_status(
                description: "User account status related to the total debt",
                required: true,
                values: ["enough_money", "not_enough_money", "without_money"]
        )
        days_apart(
                description: "Positive number indicanting the difference of days between now and the installments' due date",
                type: PropertyType.Numeric,
                required: true,
        )
    }

    "/credits/consumer/unified_payment_hack/intermediate_landing/insert_money_and_payment_intention"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        unified_payment_hack_properties
        money_account_status(
                description: "User account status related to the total debt",
                required: true,
                values: ["enough_money", "not_enough_money", "without_money"]
        )
    }

    /******************************************
     *   End: Consumers Unified Payment Hack
     ******************************************/

    /******************************************
     *   Start: Consumers Checkout
     ******************************************/

    "/credits/consumer/administrator/checkout"(platform: "/", type: TrackType.View) {
        summary_status(description: "Current status of the loan summary", type: PropertyType.String, required: false, values: ["empty_state", "on_time", "overdue"])
    }

    /******************************************
     *   End: Consumers Checkout
     ******************************************/

    /******************************************
     *    Start: Consumers Contacts
     ******************************************/

    //Page Views
    "/credits/consumer/contacts"(platform: "/", type: TrackType.View) {
        credits_type(description: "Type of credit user", type: PropertyType.String, required: true, values: ["consumer", "merchant"])
        site_id(description: "Site of the user", type: PropertyType.String, required: true)
        medium(description: "Medium of the contact", type: PropertyType.String, required: true)
        campaign(description: "Source of the contact", type: PropertyType.String, required: true)
        status_from_medium(description: "Initial state from the medium", type: PropertyType.String, required: false)
        action_label(description: "Label of the action", type: PropertyType.String, required: true)
        loan_status(description: "Current loan status", type: PropertyType.String, required: true)
        next_installment_status(description: "Current installment to pay status", type: PropertyType.String, required: true)
        output_label(description: "Redirection result", type: PropertyType.String, required: true)
    }

    /******************************************
     *   End: Consumers Contacts
     ******************************************/

    /******************************************
     *    Start: Consumers Enhance Adoption
     ******************************************/

    propertyDefinitions {
        credits_user_mark(
                type: PropertyType.String,
                description: "Credits user mark related to consumer adoption",
                required: true,
                values: ["open_market", "priority_1", "priority_2"]
        )
    }

    propertyGroups {
        adoption_modal_properties(credits_user_mark, context)
    }

    "/credits/consumer/adoption_modal"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {
        adoption_modal_properties
    }

    "/credits/consumer/adoption_modal/understood"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        adoption_modal_properties
    }

    "/credits/consumer/adoption_modal/close"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        adoption_modal_properties
    }

    "/credits/consumer/adoption_modal/go_back"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        adoption_modal_properties
    }

    /******************************************
     *    End: Consumers Enhance Adoption
     ******************************************/

    /******************************************
     *   Start: Personal Loans Adoption
     ******************************************/
    "/credits/consumer/personal"(platform: "/mobile", type: TrackType.View) {}

    "/credits/consumer/personal/adoption"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: true)
        virtual_card(description: "Identifies if the user has virtual card", type: PropertyType.Boolean, required: false)
        physical_card(description: "Identifies if the user has physical card", type: PropertyType.Boolean, required: false)
    }

    "/credits/consumer/personal/adoption/onboarding"(platform: "/mobile", type: TrackType.View) {
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: true)
        sk(description: "Source key", type: PropertyType.String, required: false)
    }

    "/credits/consumer/personal/adoption/onboarding/go_simulation"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/onboarding/close"(platform: "/mobile", type: TrackType.Event) {
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: false)
    }

    "/credits/consumer/personal/adoption/simulator"(platform: "/mobile", type: TrackType.View) {
        sk(description: "Source key", type: PropertyType.String, required: false)
    }

    "/credits/consumer/personal/adoption/simulator/go_review"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review"(platform: "/mobile", type: TrackType.View) {}

    "/credits/consumer/personal/adoption/review/general_terms"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review/particular_terms"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review/above_confirm"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review/below_confirm"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/congrats"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: false)
        status(
            description: "Status of the user prepaid",
            type: PropertyType.String,
            required: true,
            values: [
                "no_prepaid",
                "prepaid_enabled",
                "prepaid_disabled",
                "physical_card",
                "virtual_card"
            ]
        )
    }

    "/credits/consumer/personal/adoption/congrats/go_wallet"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/congrats/go_prepaid"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/congrats/go_withdrawals"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/generic_message"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: false)
        status(description: "Status of the user prepaid", type: PropertyType.String, required: true, values: ["no_prepaid", "prepaid_enabled", "prepaid_disabled"])
    }

    "/credits/consumer/personal/adoption/generic_message/go_prepaid"(platform: "/mobile", type: TrackType.Event) {}


    /******************************************
     *   End: Personal Loans Adoption
     ******************************************/

    /******************************************
     *    Start: Consumers Experiments
     ******************************************/

    "/credits/consumer/notification"(platform: "/") {}

    "/credits/consumer/notification/new_channels_stimulous"(platform: "/", type: TrackType.Event) {
        milestone(description: "Milestone of the user", type: PropertyType.Numeric, required: true)
        notification_type(description: "Notification type for the user", type: PropertyType.String, required: true, values: ["email", "web", "mobile", "push", "wapp", "sms"])
    }

    /******************************************
     *   End: Consumers Experiments
     ******************************************/

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
            required: true,
            description: "total installments amount",
            type: PropertyType.Numeric
        )
        total_amount_with_discount(
            required: true,
            description: "total amount offerted to user",
            type: PropertyType.Numeric
        )
        total_discount(
            required: true,
            description: "Total discount",
            type: PropertyType.Numeric
        )
        installments_ids(
            required: true,
            description: "Array of Installments",
            type: PropertyType.ArrayList
        )
    }

     /******************************************
     *    End: Consumers Early Repayments FLow
     ******************************************/


     /******************************************
     *    Start: Self service
     ******************************************/
    "/credits/self_service/promises/create_form"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer, mix or no credit)",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix",
                "no_credit"
            ]
        )
    }

    "/credits/self_service/promises/create_form/submit"(platform: "/", type: TrackType.Event) {
        is_partial_amount(
            required: true,
            description: "Whether promise amount is less than bulk amount",
            type: PropertyType.Boolean
        )
        bulk_amount(
            required: true,
            description: "Bulk amount or total debt amount for user",
            type: PropertyType.Numeric
        )
        promise_amount(
            required: true,
            description: "Promise amount filled in by user",
            type: PropertyType.Numeric
        )
        payment_method(
            required: true,
            description: "Payment method selected for promise",
            type: PropertyType.String
        )
        promise_due_days(
            required: true,
            description: "How many days until the promise is due from the day it was created",
            type: PropertyType.Numeric
        )
    }

    "/credits/self_service/promises/create_form/cancel"(platform: "/", type: TrackType.Event) {}

    "/credits/self_service/promises/congrats"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer, mix or no credit)",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix",
                "no_credit"
            ]
        )
    }

    "/credits/self_service/promises/error"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer, mix or no credit)",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix",
                "no_credit"
            ]
        )
    }

    "/credits/self_service/promises/view"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer, mix or no credit)",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix",
                "no_credit"
            ]
        )
    }

    "/credits/self_service/debt_relief"(platform: "/", type: TrackType.View) {
            user_type(
                required: true,
                description: "User type (merchant, consumer or mix)",
                type: PropertyType.String,
                values: [
                    "merchant",
                    "consumer",
                    "mix"
                ]
            )
        }

        "/credits/self_service/debt_relief/summary"(platform: "/", type: TrackType.View) {
                bulk_amount(
                    required: true,
                    description: "Bulk amount of the debt relief proposed by the user",
                    type: PropertyType.Numeric
                )
                total_amount(
                    required: true,
                    description: "Total debt amount",
                    type: PropertyType.Numeric
                )
                min_amount(
                    required: false,
                    description: "Total debt amount",
                    type: PropertyType.Boolean
                )
            }

        "/credits/self_service/debt_relief/accept_summary"(platform: "/", type: TrackType.Event) {
                bulk_amount(
                    required: true,
                    description: "Bulk amount of the debt relief proposed by the user",
                    type: PropertyType.Numeric
                )
                total_amount(
                    required: true,
                    description: "Total debt amount",
                    type: PropertyType.Numeric
                )
                installments_id(
                    required: true,
                    description: "Array of Installments reached by the punitive condonation",
                    type: PropertyType.ArrayList
                )
                debt_relief_amount(
                    required: true,
                    description: "final Debt relief amount",
                    type: PropertyType.Numeric
                )
            }

        "/credits/self_service/debt_relief/error"(platform: "/", type: TrackType.View) {
               error_type(
                       required: true,
                       description: "Error type message",
                       type: PropertyType.String,
                       values: [
                           "no_offer",
                           "not_found",
                           "invalid_offer",
                           "unknown",
                       ]
                   )
               }
     /******************************************
     *    End: Self service
     ******************************************/
}
