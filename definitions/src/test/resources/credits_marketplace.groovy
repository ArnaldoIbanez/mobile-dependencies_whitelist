package src.test.resources

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

        /******************************************
         *       End: Consumers Public Landings
         ******************************************/

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
         *       Start: Consumers Admin Detail
         ******************************************/

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
        "/vip/credits/pursue/overdue_modal"(platform: "/web/desktop", type: TrackType.View) {
            status = "payment_intention_pre_restriction"
            milestone = 20
        }

        "/credits/consumer/overdue_nav"(platform: "/web/desktop", type: TrackType.View) {
            status = "fixed_charge_period_1"
            milestone = 4
            context = "vip"
        }

        //Events
        //Vip
        "/vip/credits/pursue/overdue_modal/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {
            status = "payment_intention_post_restriction"
            milestone = 28
        }

        "/credits/consumer/overdue_nav/payment_intention"(platform: "/web/desktop", type: TrackType.Event) {
            status = "fixed_charge_period_1"
            milestone = 4
            context = "vip"
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
    }
}
