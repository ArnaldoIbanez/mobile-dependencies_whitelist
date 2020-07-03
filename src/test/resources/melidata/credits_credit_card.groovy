package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    def offer_data_scoring_a = [
        scoring: "A"
    ]

    def offer_data_scoring_b = [
        scoring: "B"
    ]

    def amount_input_data = [
        amount: 100,
        statement_min_amount: 10,
        statement_max_amount: 100,
        account_total_amount: 300
    ]

    def payment_plan_data = [
        payment_plan_number: 6,
        min_payment_plan: 3,
        max_payment_plan: 12,
    ]

    test("credits credit card tests") {
        /***********************************************
         *       Start: Credit Card Payment
         ***********************************************/
        //Hub
        "/credits/credit-card/payment/hub"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_a
            statement_status = "closed"
        }

        "/credits/credit-card/payment/total_payment_action"(platform: "/", type: TrackType.Event) {
            amount = 100.5
        }

        //Payment plan
        "/credits/credit-card/payment/payment_plan_selection"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_b
            statement_status = "open"
        }

        //Amount input
        "/credits/credit-card/payment/amount_input"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_a
            statement_status = "overdue"
        }

        //Summary
        "/credits/credit-card/payment/summary"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_a
            statement_status = "closed"
            payment_option = "total"
            amount_input = amount_input_data
        }

        "/credits/credit-card/payment/summary"(platform: "/", type: TrackType.View) {
            offer = offer_data_scoring_b
            statement_status = "closed"
            payment_option = "payment_plan"
            payment_plan = payment_plan_data
        }

        "/credits/credit-card/payment/payment_action"(platform: "/", type: TrackType.Event) {
            offer = offer_data_scoring_a
            statement_status = "closed"
            payment_option = "total"
            amount_input = amount_input_data
        }

        "/credits/credit-card/payment/payment_action"(platform: "/", type: TrackType.Event) {
            offer = offer_data_scoring_b
            statement_status = "closed"
            payment_option = "payment_plan"
            payment_plan = payment_plan_data
        }
        /*********************************************
         *       End: Credit Card Payment
         *********************************************/
    }
}