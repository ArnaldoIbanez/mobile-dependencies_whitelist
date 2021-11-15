package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Cost simulator finish loading successful") {
        "/cost_simulator" (platform: "/", type: TrackType.View) {}
    }
    test("Renders error page") {
        "/cost_simulator/error" (platform: "/", type: TrackType.View) {
            error_id = "error_id"
            error_message = ""
        }
    }
    test("One of the option is clicked") {
        "/cost_simulator/selected_simulation" (platform: "/", type: TrackType.Event) {
            selected_simulation = "receive"
        }
    }
    test("A value in the input, press Enter or after the timeout has elapsed") {
        "/cost_simulator/amount" (platform: "/", type: TrackType.Event) {
            amount = "500"
        }
    }
    test("Render Module Chooser component") {
        "/cost_simulator/simulation-constraint" (platform: "/", type: TrackType.View) {
            modules_id = [
                "channel",
                "payment_method_type",
                "installment_type",
                "installment_schema",
                "release_option"
            ]
        }
    }
    test("A tooltip (triggered by a click in a row) was closed") {
        "/cost_simulator/simulation-constraint/help" (platform: "/", type: TrackType.View) {
            help = "release_option_tooltip"
        }
    }
    test("A tooltip primary action is clicked") {
        "/cost_simulator/simulation-constraint/help/actions" (platform: "/", type: TrackType.Event) {
            help_action = "action_to_faq_point_mlb"
        }
    }
    test("A message primary action is clicked") {
        "/cost_simulator/simulation-constraint/help_action_message/actions" (platform: "/", type: TrackType.Event) {
            help_action_message = "action_to_faq_costs_point_mlb"
        }
    }
    test("All selected options required for simulation") {
        "/cost_simulator/simulation-constraint/all_selected" (platform: "/", type: TrackType.Event) {
            selected_options = [
                [
                    key : "channel",
                    value : "point"
                ],
                [
                    key : "payment_method_type",
                    value : "debit"
                ],
                [
                    key : "release_option",
                    value : "MLA_point_debit_value_1500"
                ]
            ]
        }
    }
    test("Successful completion of the simulation") {
        "/cost_simulator/simulation/result" (platform: "/", type: TrackType.View) {
            amount = "200"
        }
    }
    test("By clicking on the action see more / see less") {
        "/cost_simulator/simulation/result/detail" (platform: "/", type: TrackType.Event) {
            selected_detail = "view_more"
        }
    }
    test("A tooltip (triggered by a click in a row) was closed") {
        "/cost_simulator/simulation/result/help" (platform: "/", type: TrackType.View) {
            help = "result_financing_tooltip"
        }
    }
    test("A tooltip primary action is clicked") {
        "/cost_simulator/simulation/result/help/actions" (platform: "/", type: TrackType.Event) {
            help_action = "action_to_cost_section"
        }
    }
    test("Coach Mark finish loading successful") {
        "/cost_simulator/guide" (platform: "/", type: TrackType.View) {}
    }
    test("Successful completion of the coach mark") {
        "/cost_simulator/guide/finish" (platform: "/", type: TrackType.Event) {}
    }
}
