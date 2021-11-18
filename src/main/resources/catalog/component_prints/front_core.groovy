package catalog.component_prints

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/**************************************************************
 * CONTACT: In case of changes over this file, please send us
 *  a message to our e-mail: front_native_devs@mercadolibre.com
 **************************************************************/

/********************************
 *   WALLET HOME PRINT TRACKS   *
 ********************************/

tracks {

    def banking_action_item_definition = objectSchemaDefinitions {
        component_id(type: PropertyType.String, required: true, description: "Action id")
        content_id(type: PropertyType.String, required: true, description: "Content id")
        position(type: PropertyType.Numeric, required: true, description: "Position")
        enabled(type: PropertyType.Boolean, required: true, description: "Enabled")
    }

    def banking_balance_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Balance id")
        balance_histogram(required: true, type: PropertyType.Numeric, description: "Balance histogram")
        hidden(required: true, type: PropertyType.Boolean, description: "Balance hidden by user")
        pending_balance(required: true, type: PropertyType.Boolean, description: "Balance pending")
    }

    def shortcut_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Component id")
        group_position(required: true, type: PropertyType.Numeric, description: "Group position")
        is_favorite(required: true, type: PropertyType.Boolean, description: "Is favorite")
        content_id(required: true, type: PropertyType.String, description: "Content id")
        group_id(required: true, type: PropertyType.String, description: "Group id")
        has_label(required: true, type: PropertyType.Boolean, description: "Has label")
        from(required: true, type: PropertyType.String, description: "from")
        position(required: true, type: PropertyType.Numeric, description: "Position")
        user_profile(required: true, type: PropertyType.String, description: "User profile")
        enabled(required: true, type: PropertyType.Boolean, description: "Is enabled")
        has_aware(required: true, type: PropertyType.Boolean, description: "Has aware")
    }

    "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
        //banking_v2-balance(required: false, type: PropertyType.Map(banking_balance_item_definition), description: "The balance information")
        //banking_v2-balance(required: false, type: PropertyType.Map(banking_balance_item_definition), description: "The balance information")
        shortcuts(required: false, type: PropertyType.Map(shortcut_item_definition), description: "Shortcuts")
    }
}
