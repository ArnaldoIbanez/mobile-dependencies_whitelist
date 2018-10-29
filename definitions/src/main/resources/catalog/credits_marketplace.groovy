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
    "/credits/consumer/unified_payment_hack"(platform: "/", isAbstract: true) {}
    "/credits/consumer/unified_payment_hack/intermediate_landing"(platform: "/", isAbstract: true) {}
    "/credits/pursue"(platform: "/", isAbstract: true) {}

    "/vip"(platform: "/", isAbstract: true) {}
    "/vip/credits"(platform: "/", isAbstract: true) {}
    "/vip/credits/pursue"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Consumers Public Landings
     ******************************************/
    //Public Landing

    //Page views
    "/credits/consumer/public_landing"(platform: "/", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }

    //Events
    "/credits/consumer/public_landing/click_hero"(platform: "/", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }
    "/credits/consumer/public_landing/click_activation"(platform: "/", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }
    "/credits/consumer/public_landing/click_help"(platform: "/", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, values: ["guest", "no_offer"])
    }
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
        context(required: true, values: ["search", "vip", "home"],
                description: "The page or section where the nav action is taking place")
    }

    propertyGroups {
        pursue_nav_properties(status, milestone, context)
    }

    //Page Views

     "/vip/credits/pursue/overdue_modal"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {
       status(type: PropertyType.String, required: true,
         values: ["payment_intention_pre_restriction", "payment_intention_post_restriction"])
       milestone(type: PropertyType.Numeric , required: true)
     }

     //Event Views
     "/vip/credits/pursue/overdue_modal/payment_intention"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
       status(type: PropertyType.String, required: true,
         values: ["payment_intention_pre_restriction", "payment_intention_post_restriction"])
       milestone(type: PropertyType.Numeric , required: true)
     }

    "/credits/pursue/overdue_nav"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {
        pursue_nav_properties
    }

    "/credits/pursue/overdue_nav/payment_intention"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        pursue_nav_properties
    }
     /******************************************
      *       End: Consumers Persue Campaign
      ******************************************/

      /******************************************
      *   Start: Consumers Unified Payment Hack
      ******************************************/

      propertyDefinitions {
        loans_installments_status(
          description: "Installment status to be considered when paying debt",
          required: true,
          values: ["to_expire_soft", "to_expire_hard", "no_charge_period"]
        )
        installments_count(
          description: "Installments count to pay",
          type: PropertyType.Numeric,
          required: true,
        )
        money_account_status(
          description: "User account status related to the total debt",
          required: true,
          values: ["enough_money", "not_enough_money", "without_money"]
        )
      }

      propertyGroups {
          unified_payment_hack_properties(loans_installments_status, installments_count, money_account_status)
      }

      "/credits/consumer/unified_payment_hack/intermediate_landing"(platform:"/", type: TrackType.View) {
        unified_payment_hack_properties
        days_apart(
          description: "Positive number indicanting the difference of days between now and the installments' due date",
          type: PropertyType.Numeric,
          required: true,
        )
      }


      "/credits/consumer/unified_payment_hack/intermediate_landing/insert_money_and_payment_intention"(platform:"/", parentPropertiesInherited: false, type: TrackType.Event) {
        unified_payment_hack_properties
      }

      /******************************************
      *   End: Consumers Unified Payment Hack
      ******************************************/
}
