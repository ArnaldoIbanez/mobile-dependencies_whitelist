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
            sk = 'landing'
        }
        "/credits/consumer/public_landing/application_result"(platform: "/web/desktop") {
            result = 'manual_review'
        }
        "/credits/consumer/public_landing/application_result/click_credits"(platform: "/web/desktop") {
            result = 'manual_review'
        }
        "/credits/consumer/public_landing/application_start"(platform: "/web/desktop") {}
        "/credits/consumer/public_landing/error"(platform: "/web/desktop") {}
        "/credits/consumer/public_landing/paused"(platform: "/web/desktop") {}
        "/credits/consumer/public_landing/remedy"(platform: "/web/desktop") {
            remedy_name = 'declarative_info'
        }

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

        //Remedy
        "/credits/consumer/opensea/add_receipt"(platform: "/web", type: TrackType.Event) {}
        "/credits/consumer/opensea/summary"(platform: "/web", type: TrackType.View) {
            process = 'receipt'
        }

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
        "/credits/consumer/administrator_v2/dashboard"(platform: "/web/desktop", type: TrackType.View) {
            dashboard_status = 'overdue'
            personalLoanAccessShown = 'banner'
            opt_in_separator = 'visible'
        }
        "/credits/consumer/administrator_v2/dashboard"(platform: "/", type: TrackType.View) {
            dashboard_status = 'overdue'
            offer = ['payment_not_credited', 'create_promise']
        }
        "/credits/consumer/administrator_v2/error_message"(platform: "/mobile", type: TrackType.View) {
            user_status = 'manually_paused'
        }
        "/credits/consumer/administrator_v2/suggested_modal"(platform: "/web/desktop", type: TrackType.View) {}

        //Events
        "/credits/consumer/administrator_v2/payment_intention_all"(platform: "/web/desktop", type: TrackType.Event) {
            installments_qty = 3
            advance_installment = false
        }
        "/credits/consumer/administrator_v2/details_button"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/choose_installments"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/help"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/contact_card"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/educational_landing"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/suggested_product"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/home"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/suggested_modal/suggested_product_modal"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/suggested_modal/weekly_deals_link"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/suggested_modal/close_product_modal"(platform: "/web/desktop", type: TrackType.Event) {}

        "/credits/consumer/administrator_v2/promises/create"(platform: "/", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/promises/view"(platform: "/", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/debt_relief/create"(platform: "/", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/payment_not_credited"(platform: "/", type: TrackType.Event) {}

        //Event Mobile
        "/credits/consumer/administrator_v2/dashboard"(platform: "/mobile", type: TrackType.View) {
            dashboard_status = 'on_time'
            opt_in_separator = 'visible'
        }
        "/credits/consumer/administrator_v2/dashboard/payment_intention_all"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
            installments_qty = 3
            advance_installment = false
        }
        "/credits/consumer/administrator_v2/dashboard/choose_installments"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'overdue'
        }
        "/credits/consumer/administrator_v2/dashboard/get_help"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
        }
        "/credits/consumer/administrator_v2/dashboard/get_help/how_to_pay_installments"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
        }
        "/credits/consumer/administrator_v2/dashboard/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'empty_state'
        }
        "/credits/consumer/administrator_v2/dashboard/cx_contact"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'overdue'
        }
        "/credits/consumer/administrator_v2/dashboard/cx_contact"(platform: "/web/desktop", type: TrackType.Event) {
            dashboard_status = 'overdue'
        }
        "/credits/consumer/administrator_v2/dashboard/go_shopping"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
        }
        "/credits/consumer/administrator_v2/dashboard/get_educative"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
        }
        "/credits/consumer/administrator_v2/dashboard/go_mp"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'empty_state'
            has_mp = true
        }
        "/credits/consumer/administrator_v2/dashboard/close_mp_modal"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'empty_state'
        }
        "/credits/consumer/administrator_v2/dashboard/go_store_mp"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'empty_state'
        }
        "/credits/consumer/administrator_v2/dashboard/go_installments_detail"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
        }
        "/credits/consumer/administrator_v2/error_message/button_pressed"(platform: "/mobile", type: TrackType.Event) {
            user_status = 'manually_paused'
        }
        "/credits/consumer/administrator_v2/dashboard/opt_in_wsp"(platform: "/mobile", type: TrackType.Event) {
            status = true
            dashboard_status = 'on_time'
        }


        // "/credits/consumer/administrator_v2/suggested_product_modal"(platform: "/mobile", type: TrackType.Event) {}
        // "/credits/consumer/administrator_v2/weekly_deals_link"(platform: "/web/desktop", type: TrackType.Event) {}
        // "/credits/consumer/administrator_v2/close_product_modal"(platform: "/mobile", type: TrackType.Event) {}

        //Admin History (Compras Finalizadas)

        // Views
        "/credits/consumer/administrator/history"(platform: "/web/desktop") {}

        //Events
        "/credits/consumer/administrator/history/details_button"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/history/educational_landing"(platform: "/web/desktop", type: TrackType.Event) {
        }
        //Event PX Congrats Extra Component
        "/credits/consumer/administrator_v2/dashboard/opt_in_wsp_px_access"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
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
        "/credits/consumer/administrator/detail/see_contract"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/download_plan"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/get_help"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/purchase_detail"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/back_to_dashboard"(platform: "/web/desktop", type: TrackType.Event) {}
        "/credits/consumer/administrator/detail/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {
            installment_status = 'on_time'
            payment_intention = 'cho'
            advance_installment = false
        }
        "/credits/consumer/administrator/detail/payment_intention_list"(platform: "/web/desktop", type: TrackType.Event) {
            installment_status = 'on_time'
            payment_intention = 'cho'
            advance_installment = false
        }

        /******************************************
         *       End: Consumers Admin Detail
         ******************************************/

        /****************************************************
         *       Start: Consumers Installment Selection Page
         ****************************************************/

        //Views
        "/credits/consumer/administrator_v2/installment_selection"(platform: "/", type: TrackType.View) {
            page_status = 'overdue'
        }

        //Events
        "/credits/consumer/administrator_v2/installment_selection/payment_intention"(platform: "/mobile", type: TrackType.Event) {
            page_status = 'overdue'
            total_installments = 3
            paid_installments = 2
        }

        //Events
        "/credits/consumer/administrator_v2/installment_selection/payment_intention"(platform: "/web", type: TrackType.Event) {
            total_installments = 3
            paid_installments = 2
        }

         "/credits/consumer/administrator_v2/installment_selection/secondary_payment_intention"(platform: "/web", type: TrackType.Event) {
            total_installments = 3
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
         *   Start: Personal Loans Adoption
         ******************************************/

        "/credits/consumer/administrator/summary/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {
            summary_status = "on_time"
        }

        "/credits/consumer/personal"(platform: "/mobile", type: TrackType.View) {
        }

        "/credits/consumer/personal/adoption"(platform: "/mobile", type: TrackType.View) {
            prepaid = true
            virtual_card = true
            physical_card = false
        }

        "/credits/consumer/personal/adoption/onboarding"(platform: "/mobile", type: TrackType.View) {
            prepaid = false
            page = 1
            sk = 'sk1234'
        }

        "/credits/consumer/personal/adoption/onboarding/go_simulation"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
            page = 4
        }

        "/credits/consumer/personal/adoption/onboarding/close"(platform: "/mobile", type: TrackType.Event) {
            prepaid = true
        }

        "/credits/consumer/personal/adoption/simulator"(platform: "/mobile", type: TrackType.View) {
            prepaid = false
            sk = 'sk1234'
        }

        "/credits/consumer/personal/adoption/simulator/go_review"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review"(platform: "/mobile", type: TrackType.View) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/general_terms"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/particular_terms"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/above_confirm"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/below_confirm"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/congrats"(platform: "/mobile", type: TrackType.View) {
            status = 'no_prepaid'
        }

        "/credits/consumer/personal/adoption/congrats/go_wallet"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_enabled'
        }

        "/credits/consumer/personal/adoption/congrats/go_prepaid"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_disabled'
        }

        "/credits/consumer/personal/adoption/congrats/go_withdrawals"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_enabled'
        }

        "/credits/consumer/personal/adoption/generic_message"(platform: "/mobile", type: TrackType.View) {
            status = 'prepaid_enabled'
        }

        "/credits/consumer/personal/adoption/generic_message/go_prepaid"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_disabled'
        }


        /******************************************
         *   End: Personal Loans Adoption
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

        /******************************************
         *    Start: Consumers Opensea Integrations
         ******************************************/

        "/credits/consumer/opensea/redirect"(platform: "/mobile", type: TrackType.View) {}
        "/credits/consumer/opensea/integrated_flow/vip"(platform: "/web/desktop", type: TrackType.Event) {}

        /******************************************
         *   End: Consumers  Opensea Integrations
         ******************************************/

        /******************************************
        *    Start: Consumers Change Due Date FLow
        ******************************************/
        "/credits/consumer/duedate_selection"(platform: "/", type: TrackType.View) {
            available_products = ["consumer_loan", "personal_loan"]
            due_date = 10
        }

        "/credits/consumer/duedate_selection/not_allowed"(platform: "/", type: TrackType.View) {
            available_products = ["consumer_loan", "personal_loan"]
            due_date = 10
        }

        "/credits/consumer/duedate_selection/error"(platform: "/", type: TrackType.View) {
            available_products = ["consumer_loan", "personal_loan"]
            due_date = 10
        }

        "/credits/consumer/duedate_selection/success"(platform: "/", type: TrackType.View) {
            available_products = ["consumer_loan", "personal_loan"]
            due_date = 10
            new_due_date = 15
        }

        "/credits/consumer/duedate_selection/cancel"(platform: "/", type: TrackType.Event) {
            available_products = ["consumer_loan", "personal_loan"]
            due_date = 10
        }


        /******************************************
        *    End: Consumers Change Due Date FLow
        ******************************************/

        /******************************************
        *    Start: Self Service
        ******************************************/
        "/credits/self_service/promises/create_form"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/create_form/submit"(platform: "/", type: TrackType.Event) {
            user_type = "consumer"
            is_partial_amount = true
            bulk_amount = 7000
            promise_amount = 5000
            payment_method = "CASH"
            promise_due_days = 4
        }

        "/credits/self_service/promises/create_form/cancel"(platform: "/", type: TrackType.Event) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/congrats"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/error"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/view"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/debt_relief"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/debt_relief/summary"(platform: "/", type: TrackType.View) {
            bulk_amount = 7000
            total_amount = 14000
            min_amount = true
            user_type = "consumer"
        }

        "/credits/self_service/debt_relief/accept_summary"(platform: "/", type: TrackType.Event) {
            bulk_amount = 7000
            total_amount = 14000
            installments_id = [ 1002, 1003, 1004]
            user_type = "consumer"
            debt_relief_amount = 6000
        }

        "/credits/self_service/debt_relief/error"(platform: "/", type: TrackType.View) {
            user_type = "merchant"
            error_type = "no_offer"
        }

        /******************************************
        *    End: Self Service
        ******************************************/
    }
}
