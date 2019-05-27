package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("consumer credits") {

        /******************************************
         *       Start: Consumers Public Landings
         ******************************************/
        //Public Landing

        //Page views
        "/credits/consumer/public_landing"(platform: "/web/desktop") {
            user_profile = 'no_offer'
        }
        "/credits/consumer/public_landing/application_result"(platform: "/web/desktop") {
            result = 'manual_review'
        }
        "/credits/consumer/public_landing/application_result/click_credits"(platform: "/web/desktop") {
            result = 'manual_review'
        }
        "/credits/consumer/public_landing/application_start"(platform: "/web/desktop") {}

        //Events
        "/credits/consumer/public_landing/click_hero"(platform: "/web/mobile", type: TrackType.Event) {
            user_profile = 'no_offer'
        }
        "/credits/consumer/public_landing/credit_line_request"(platform: "/web/desktop", type: TrackType.Event) {
            user_profile = 'no_offer'
        }
        "/credits/consumer/public_landing/click_help"(platform: "/web/mobile", type: TrackType.Event) {
            user_profile = 'guest'
        }
        "/credits/consumer/public_landing/click_application_start"(platform: "/web/mobile", type: TrackType.Event) {}
        "/credits/consumer/public_landing/application_result/click_home"(platform: "/web/desktop") {
            result = 'manual_review'
        }
        "/credits/consumer/public_landing/application_result/more_info"(platform: "/web/desktop") {
            result = 'manual_review'
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
         *       Start: Consumers Enrollment
         ******************************************/
        //Admin Dashboard

        //Page Views
        "/credits/consumer/enrollment"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/educational"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/sms_validation"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/code_verification"(platform: "/web/desktop") {}
        "/credits/consumer/enrollment/congrats"(platform: "/web/desktop") {}
        "/credits/consumer/payinstallment"(platform: "/web/mobile") {
            status = 'overdue'
        }
        "/credits/consumer/breaking_landing"(platform: "/web/desktop") {}

        //Events
        "/credits/consumer/enrollment/sms_validation/cancel"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/enrollment/code_verification/cancel"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/enrollment/congrats/buy"(platform: "/web/desktop", type: TrackType.Event) {}

        /******************************************
         *       End: Consumers Enrollment
         ******************************************/

        /******************************************
         *       Start: Consumers Administrator
         ******************************************/
        //Admin Dashboard

        //Views
        "/credits/consumer/administrator"(platform: "/web/desktop") {}
        "/credits/consumer/administrator/dashboard"(platform: "/web/desktop", type: TrackType.View) {
            dashboard_status = 'empty_state'
        }
        "/credits/consumer/administrator/summary"(platform: "/mobile", type: TrackType.View) {
            summary_status = 'empty_state'
        }

        //Events
        "/credits/consumer/administrator/tooltip"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {
            installment_status = 'on_time'
            payment_intention = 'cho'
        }
        "/credits/consumer/installment_payment"(platform: "/mobile", type: TrackType.Event) {
            payment_id = '123456'
            payment_method = 'visa debito'
            payment_type = 'debit'
            payment_result = 'pending'
            payment_result_detail = 'pending_waiting_payment'
        }
        "/credits/consumer/administrator/details_button"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/help"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/educational_landing"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/see_product"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/summary/payment_intention"(platform: "/mobile", type: TrackType.Event) {
            summary_status = 'on_time'
        }
        "/credits/consumer/administrator/summary/cx_contact"(platform: "/mobile", type: TrackType.Event) {
            summary_status = 'on_time'
        }
        "/credits/consumer/administrator/summary/go_shopping"(platform: "/mobile", type: TrackType.Event) {
            summary_status = 'on_time'
        }
        "/credits/consumer/administrator/summary/get_help"(platform: "/mobile", type: TrackType.Event) {
            summary_status = 'on_time'
        }
        "/credits/consumer/administrator/summary/get_educative"(platform: "/mobile", type: TrackType.Event) {
            summary_status = 'on_time'
        }

        //Admin Dashboard v2

        //Views
        "/credits/consumer/administrator_v2"(platform: "/web/desktop") {}
        "/credits/consumer/administrator_v2/dashboard"(platform: "/web/desktop", type: TrackType.View) {
            dashboard_status = 'overdue'
        }

        //Events
        "/credits/consumer/administrator_v2/payment_intention_all"(platform: "/web/desktop", type: TrackType.Event) {
            installments_qty = 3
        }
        "/credits/consumer/administrator_v2/details_button"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/choose_installments"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/help"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/contact_card"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/educational_landing"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/suggested_product"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/home"(platform: "/web/desktop", type: TrackType.Event) {}

        //Admin History (Compras Finalizadas)

        // Views
        "/credits/consumer/administrator/history"(platform: "/web/desktop") {}

        //Events
        "/credits/consumer/administrator/history/details_button"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/history/educational_landing"(platform: "/web/desktop", type: TrackType.Event) {
        }


        /******************************************
         *       End: Consumers Administrator
         ******************************************/

        /******************************************
         *       Start: Consumers Admin Detail
         ******************************************/

        //Views
        "/credits/consumer/administrator/detail"(platform: "/web/desktop", type: TrackType.View) {
            loan_id = 123456
            next_installment_status = "on_time"
        }

        //Events
        "/credits/consumer/administrator/detail/see_loan_conditions"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/see_tac"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/see_voucher"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/see_ccb"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/download_plan"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/get_help"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/purchase_detail"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/back_to_dashboard"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {
            installment_status = 'on_time'
            payment_intention = 'cho'
        }
        "/credits/consumer/administrator/detail/payment_intention_list"(platform: "/web/desktop", type: TrackType.Event) {
            installment_status = 'on_time'
            payment_intention = 'cho'
        }

        /******************************************
         *       End: Consumers Admin Detail
         ******************************************/

        /****************************************************
         *       Start: Consumers Installment Selection Page
         ****************************************************/

        //Views
        "/credits/consumer/administrator_v2/installment_selection"(platform: "/web/desktop", type: TrackType.View) {
            page_status = 'overdue'
        }

        //Events
        "/credits/consumer/administrator_v2/installment_selection/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {
            total_installments = 3
            paid_installments = 2
        }
        "/credits/consumer/administrator_v2/installment_selection/back_to_dashboard"(platform: "/web/desktop", type: TrackType.Event) {}

        /****************************************************
         *       End: Consumers Installment Selection Page
         ****************************************************/

        /******************************************
         *       Start: Consumers Push
         ******************************************/

        //Landing Push Native
        // Page views
        "/credits/consumer/payinstallment"(platform: "/", type: TrackType.View) {
            status = 'on_time'
        }

        // Events views
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
        "/credits/consumer/recurring_landing_test"(platform: "/web/desktop", type: TrackType.View) {}
        "/credits/consumer/recurring_congrats_test"(platform: "/web/desktop", type: TrackType.View) {}

        //Events
        "/credits/consumer/like_recurring"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/dislike_recurring"(platform: "/web/desktop", type: TrackType.Event) {}
        /******************************************
         *       End: Consumers Recurring Campaign
         ******************************************/

        /******************************************
         *       Start: Consumers Pursue Campaign
         ******************************************/
        //Page Views
        "/credits/consumer/overdue_modal"(platform: "/web/desktop", type: TrackType.View) {
            status = "pre_restriction"
            milestone = 20
            context = "vip"
        }

        "/credits/consumer/overdue_nav"(platform: "/web/desktop", type: TrackType.Event) {
            status = "fixed_charge_period_1"
            milestone = 4
            context = "vip"
        }

        //Events
        //Vip
        "/credits/consumer/overdue_modal/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {
            status = "post_restriction"
            milestone = 28
            context = "vip"
        }

        "/credits/consumer/overdue_nav/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {
            status = "fixed_charge_period_1"
            milestone = 4
            context = "vip"
        }

        "/credits/consumer/myml/summary/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {
            loan_status = "daily_charge_period"
            place = "right_section_message"
        }

        "/credits/consumer/my_account/left_nav"(platform: "/mobile/android", type: TrackType.Event) {
        }
        /******************************************
         *       End: Consumers Pursue Campaign
         ******************************************/

        /******************************************
         *   Start: Consumers Unified Payment Hack
         ******************************************/

        "/credits/consumer/administrator/unified_payment_hack/payment_intention"(platform: "/", type: TrackType.Event) {
            loans_installments_status = "to_expire_soft"
            installments_count = 3
            days_apart = 10
        }

        "/credits/consumer/administrator/unified_payment_hack/payment_intention"(platform: "/", type: TrackType.Event) {
            loans_installments_status = "to_expire_hard"
            installments_count = 2
            days_apart = 1
        }

        "/credits/consumer/administrator/unified_payment_hack/payment_intention"(platform: "/", type: TrackType.Event) {
            loans_installments_status = "no_charge_period"
            installments_count = 8
            days_apart = 1
        }

        "/credits/consumer/unified_payment_hack/intermediate_landing"(platform: "/", type: TrackType.View) {
            loans_installments_status = "to_expire_soft"
            installments_count = 3
            days_apart = 10
            money_account_status = "enough_money"
        }

        "/credits/consumer/unified_payment_hack/intermediate_landing"(platform: "/", type: TrackType.View) {
            loans_installments_status = "to_expire_soft"
            installments_count = 3
            days_apart = 5
            money_account_status = "not_enough_money"
        }

        "/credits/consumer/unified_payment_hack/intermediate_landing"(platform: "/", type: TrackType.View) {
            loans_installments_status = "to_expire_hard"
            installments_count = 3
            days_apart = 1
            money_account_status = "without_money"
        }

        "/credits/consumer/unified_payment_hack/intermediate_landing"(platform: "/", type: TrackType.View) {
            loans_installments_status = "no_charge_period"
            installments_count = 3
            days_apart = 2
            money_account_status = "without_money"
        }

        "/credits/consumer/unified_payment_hack/intermediate_landing/insert_money_and_payment_intention"(platform: "/", type: TrackType.Event) {
            loans_installments_status = "to_expire_soft"
            installments_count = 2
            money_account_status = "enough_money"
        }

        "/credits/consumer/unified_payment_hack/intermediate_landing/insert_money_and_payment_intention"(platform: "/", type: TrackType.Event) {
            loans_installments_status = "no_charge_period"
            installments_count = 4
            money_account_status = "not_enough_money"
        }

        "/credits/consumer/unified_payment_hack/intermediate_landing/insert_money_and_payment_intention"(platform: "/", type: TrackType.Event) {
            loans_installments_status = "to_expire_hard"
            installments_count = 5
            money_account_status = "without_money"
        }

        /******************************************
         *      End: Consumers Unified Payment Hack
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

        "/credits/consumer/contacts"(platform: "/", type: TrackType.View) {
            credits_type = "consumer"
            site_id = "mla"
            medium = "email"
            campaign = "collection"
            status_from_medium = "overdue"
            action_label = "contact"
            loan_status = "on_time"
            next_installment_status = "on_time"
            output_label = "faqs"
        }

        "/credits/consumer/contacts"(platform: "/", type: TrackType.View) {
            credits_type = "consumer"
            site_id = "mla"
            medium = "webapp"
            campaign = "activities"
            action_label = "have_a_problem"
            loan_status = "overdue"
            next_installment_status = "overdue"
            output_label = "widget"
        }

        /******************************************
         *   End: Consumers Contacts
         ******************************************/

       /******************************************
        *    Start: Consumers Enhance Adoption
        ******************************************/

        "/credits/consumer/adoption_modal"(platform: "/web/desktop", type: TrackType.View) {
            credits_user_mark = "open_market"
            context = "vip"
        }

        "/credits/consumer/adoption_modal/understood"(platform: "/web/desktop", type: TrackType.Event) {
            credits_user_mark = "open_market"
            context = "vip"
        }


        "/credits/consumer/adoption_modal/close"(platform: "/web/desktop", type: TrackType.Event) {
            credits_user_mark = "priority_1"
            context = "vip"
        }


        "/credits/consumer/adoption_modal/go_back"(platform: "/web/desktop", type: TrackType.Event) {
            credits_user_mark = "priority_2"
            context = "vip"
        }

       /******************************************
        *    End: Consumers Enhance Adoption
        ******************************************/

        /******************************************
         *    Start: Consumers Experiments
         ******************************************/

        "/credits/consumer/notification"(platform: "/web/desktop") {}

        "/credits/consumer/notification/new_channels_stimulous"(platform: "/web/mobile", type: TrackType.Event) {
            milestone = -10
            notification_type = "web"
        }

        "/credits/consumer/notification/new_channels_stimulous"(platform: "/web/desktop", type: TrackType.Event) {
            milestone = 0
            notification_type = "email"
        }

        "/credits/consumer/notification/new_channels_stimulous"(platform: "/", type: TrackType.Event) {
            milestone = 45
            notification_type = "wapp"
        }

        /******************************************
         *   End: Consumers Experiments
         ******************************************/
    }
}
