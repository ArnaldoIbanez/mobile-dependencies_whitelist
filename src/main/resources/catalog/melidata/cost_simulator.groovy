package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1148"

    def item_definition = objectSchemaDefinitions {
        key(required: true, type: PropertyType.String)
        value(required: true, type: PropertyType.String)
    }

    propertyDefinitions {
        error_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of error when simulation flow fails"
        )
        error_message(
            required: false,
            type: PropertyType.String,
            description: "Indicates an error message when simulation flow fails"
        )
        selected_simulation(
            required: true,
            type: PropertyType.String,
            description: "Indicates the selected option in cost simulator",
            values: ["collect", "receive"]
        )
        amount(
            required: true,
            type: PropertyType.String,
            description: "An amount used to simulate"
        )
        modules_id(
            required: true,
            type: PropertyType.ArrayList(PropertyType.String),
            description: "Indicates the ID modules in cost simulator"
        )
        help(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of a help"
        )
        help_action(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of the help action"
        )
        help_action_message(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of the action from the help message"
        )
        selected_options(
            required: true,
            type: PropertyType.ArrayList(PropertyType.Map(item_definition)),
            description: "Indicates the selected options in cost simulator"
        )
        selected_detail(
            required: true,
            type: PropertyType.String,
            description: "Indicates the selected detail in result",
            values: ["view_more", "view_less"]
        )
    }

    propertyGroups {
        error_group(error_id, error_message)
        selected_simulation_group(selected_simulation)
        amount_group(amount)
        simulation_constraint_group(modules_id)
        help_group(help)
        help_action_group(help_action)
        help_action_message_group(help_action_message)
        selected_options_group(selected_options)
        selected_detail_group(selected_detail)
    }

    // Tracks
    "/cost_simulator" (platform: "/", type: TrackType.View) {}
    "/cost_simulator/error" (platform: "/", type: TrackType.View) {
        error_group
    }
    "/cost_simulator/selected_simulation" (platform: "/", type: TrackType.Event) {
        selected_simulation_group
    }
    "/cost_simulator/amount" (platform: "/", type: TrackType.Event) {
        amount_group
    }
    "/cost_simulator/simulation-constraint" (platform: "/", type: TrackType.View) {
        simulation_constraint_group
    }
    "/cost_simulator/simulation-constraint/help" (platform: "/", type: TrackType.View, parentPropertiesInherited:false) {
        help_group
    }
    "/cost_simulator/simulation-constraint/help/actions" (platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        help_action_group
    }
    "/cost_simulator/simulation-constraint/help_action_message/actions" (platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        help_action_message_group
    }
    "/cost_simulator/simulation-constraint/all_selected" (platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        selected_options_group
    }
    "/cost_simulator/simulation/result" (platform: "/", type: TrackType.View) {
        amount_group
    }
    "/cost_simulator/simulation/result/detail" (platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        selected_detail_group
    }
    "/cost_simulator/simulation/result/help" (platform: "/", type: TrackType.View, parentPropertiesInherited:false) {
        help_group
    }
    "/cost_simulator/simulation/result/help/actions" (platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        help_action_group
    }
     "/cost_simulator/guide" (platform: "/", type: TrackType.View) {}
     "/cost_simulator/guide/finish" (platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {}
}