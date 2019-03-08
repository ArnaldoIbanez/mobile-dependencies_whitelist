package src.main.resources.catalog

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    defaultBusiness = "mercadolibre"

    "/"(platform: "/web", isAbstract: true) {
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
    }
    "/credits/consumer/public_landing/application_result"(platform: "/", type: TrackType.View) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected"])
    }
    "/credits/consumer/public_landing/application_result/click_credits"(platform: "/", type: TrackType.Event) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected"])
    }
    "/credits/consumer/public_landing/application_start"(platform: "/", type: TrackType.View) {}

    //Events
    "/credits/consumer/public_landing/click_hero"(platform: "/", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
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
    /******************************************
     *       End: Consumers Public Landings
     ******************************************/

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
        dashboard_status(description: "Current status of the loan summary", type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
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
    }

    //Admin History (Compras Finalizadas)

    //Page views
    "/credits/consumer/administrator/history"(platform: "/", type: TrackType.View) {}

    //Events
    "/credits/consumer/administrator/history/details_button"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/administrator/history/educational_landing"(platform: "/", type: TrackType.Event) {}

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
    "/credits/consumer/administrator/detail/see_ccb"(platform: "/", type: TrackType.Event) {}
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
    }

    /******************************************
     *       Start: Consumers Admin Detail
     ******************************************/

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
        context(required: false, values: ["search", "vip", "home"],
                description: "The page or section where the nav action is taking place")
    }

    propertyGroups {
        pursue_nav_properties(status, milestone, context)
        pursue_modal_properties(milestone, context)
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

    "/credits/consumer/administrator/checkout"(platform: "/web/desktop", type: TrackType.View) {}

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

}
