package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadopago"

    test("Consumer Admin from Mercadopago") {
    /******************************************
     *   Start: Consumer Admin Detail
     ******************************************/
         //Views
        "/credits/consumer/administrator"(platform: "/mobile", type: TrackType.View) {
        }

        "/credits/consumer/administrator/detail"(platform: "/mobile", type: TrackType.View) {
            loan_id = 123456
            next_installment_status = "on_time"
        }

        "/credits/consumer/administrator/dashboard"(platform: "/mobile", type: TrackType.View) {
                dashboard_status = 'empty_state'
        }

        "/credits/consumer/administrator/summary"(platform: "/mobile", type: TrackType.View) {
                summary_status = 'empty_state'
        }

        "/credits/consumer/administrator/payment_intention"(platform: "/mobile", type: TrackType.View) {
            installment_status = 'on_time'
            payment_intention = 'cho'
        }

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

        //V2
        //Views
        "/credits/consumer/administrator_v2"(platform: "/mobile", type: TrackType.View) {

        }
        "/credits/consumer/administrator_v2/error_message"(platform: "/mobile", type: TrackType.View) {
            user_status = 'manually_paused'
        }
        "/credits/consumer/administrator_v2/dashboard"(platform: "/mobile", type: TrackType.View) {
            dashboard_status = 'on_time'
        }
        "/credits/consumer/administrator_v2/dashboard"(platform: "/mobile", type: TrackType.View) {
            dashboard_status = 'overdue'
            offer = ['payment_not_credited', 'create_promise']
            from = 'landing'
            additional_info = 'main_action'
            has_upsell_available = false
        }

        //Events
        "/credits/consumer/administrator/detail/see_loan_conditions"(platform: "/mobile", type: TrackType.Event) {}

        "/credits/consumer/administrator/detail/see_tac"(platform: "/mobile", type: TrackType.Event) {}

        "/credits/consumer/administrator_v2/details_button"(platform: "/mobile", type: TrackType.Event) {}
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
        "/credits/consumer/administrator_v2/dashboard/go_uses_modal"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'empty_state'
        }
        "/credits/consumer/administrator_v2/dashboard/go_how_to_use_modal"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'overdue'
        }
        "/credits/consumer/administrator_v2/dashboard/cx_contact"(platform: "/mobile", type: TrackType.Event) {
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

        "/credits/consumer/administrator/summary/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {
            summary_status = "on_time"
        }

        "/credits/consumer/administrator_v2/promises/create"(platform: "/mobile", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/promises/view"(platform: "/mobile", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/debt_relief/create"(platform: "/mobile", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/debt_relief/info"(platform: "/mobile", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/payment_not_credited"(platform: "/mobile", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/dashboard/opt_in_wsp"(platform: "/mobile", type: TrackType.Event) {
            status = true
            dashboard_status = 'on_time'
        }

        //Event PX Congrats Extra Component
        "/credits/consumer/administrator_v2/dashboard/opt_in_wsp_px_access"(platform: "/mobile", type: TrackType.Event) {
            dashboard_status = 'on_time'
        }

        //Onboarding view
        "/credits/consumer/administrator_v2/onboarding"(platform: "/mobile", type: TrackType.View) {

        }

        //Events
        "/credits/consumer/administrator_v2/onboarding/how_to_pay_installments"(platform: "/mobile", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/onboarding/go_mc"(platform: "/mobile", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/onboarding/close"(platform: "/mobile", type: TrackType.Event) {}
        "/credits/consumer/administrator_v2/dashboard/go_know_more_faq"(platform: "/", type: TrackType.Event) {
            dashboard_status = "on_time"
        }
        "/credits/consumer/administrator_v2/dashboard/go_upsell_cx"(platform: "/", type: TrackType.Event) {
            dashboard_status = "on_time"
            list_status = "black_list"
        }
        "/credits/consumer/administrator_v2/dashboard/go_upsell"(platform: "/", type: TrackType.Event) {
            dashboard_status = "on_time"
            from = "home_mp"
            additional_info = "upsell_row"
        }

        /******************************************
            *       End: Consumers Admin Detail
        ******************************************/

        /****************************************************
        *       Start: Consumers Installment Selection Page
        ****************************************************/
        //View
        "/credits/consumer/administrator_v2/installment_selection"(platform: "/mobile", type: TrackType.View) {
            page_status = 'overdue'
        }

        //Events
        "/credits/consumer/administrator_v2/installment_selection/payment_intention"(platform: "/mobile", type: TrackType.Event) {
            page_status = 'overdue'
            total_installments = 3
            paid_installments = 2
        }
        "/credits/consumer/administrator_v2/installment_selection/secondary_payment_intention"(platform: "/mobile", type: TrackType.Event) {
            total_installments = 3
            page_status = 'overdue'
        }
        "/credits/consumer/administrator_v2/installment_selection/back_to_dashboard"(platform: "/mobile", type: TrackType.Event) {
            page_status = 'overdue'
        }
    }
    test("Due date selection from Mercadopago"){
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
    }

    test("Early Repayments for Consumer Credits users browsing by MP") {
        /******************************************
        *    Start: Consumers Early Repayments FLow
        ******************************************/
        "/credits/consumer/early_repayments"(platform: "/", type: TrackType.View) {
            total_amount = 100
            total_amount_with_discount = 100
            total_discount = 0
            installments_ids = [1111,2222,3333]
        }

        "/credits/consumer/early_repayments/success"(platform: "/", type: TrackType.View) {}
        "/credits/consumer/early_repayments/error"(platform: "/", type: TrackType.View) {}
        "/credits/consumer/early_repayments/warning"(platform: "/", type: TrackType.View) {}
        "/credits/consumer/early_repayments/accept"(platform: "/", type: TrackType.Event) {
            total_amount = 100
            total_amount_with_discount = 100
            total_discount = 0
            installments_ids = [1111,2222,3333]
        }
        /******************************************
        *    End: Consumers Early Repayments FLow
        ******************************************/
    }

    test("Credits Consumer from MercadoPago"){
        "/credits/consumer/public_landing"(platform: "/") {
            user_profile = 'no_offer'
            sk = 'landing'
        }
    }
}
