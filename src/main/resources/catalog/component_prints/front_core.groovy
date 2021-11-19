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

    def shortcuts_item_definition = objectSchemaDefinitions {
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

    def discount_center_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Component id")
    }

    def cross_selling_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Component id")
        audience(required: true, type: PropertyType.String, description: "Audience")
        bu(required: true, type: PropertyType.String, description: "Bu")
        content_id(required: true, type: PropertyType.String, description: "Content id")
        action_id(required: true, type: PropertyType.String, description: "Action id")
        bu_line(required: true, type: PropertyType.String, description: "Bu line")
        logic(required: true, type: PropertyType.String, description: "Logic")
        position(required: true, type: PropertyType.Numeric, description: "Position")
        flow(required: true, type: PropertyType.String, description: "Flow")
    }

    def benefits_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Component id")
        audience(required: true, type: PropertyType.String, description: "Audience")
        bu(required: true, type: PropertyType.String, description: "Bu")
        content_id(required: true, type: PropertyType.String, description: "Content id")
        action_id(required: true, type: PropertyType.String, description: "Action id")
        bu_line(required: true, type: PropertyType.String, description: "Bu line")
        logic(required: true, type: PropertyType.String, description: "Logic")
        position(required: true, type: PropertyType.Numeric, description: "Position")
        flow(required: true, type: PropertyType.String, description: "Flow")    }

    def activities_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Component id")
        contains_rta(required: true, type: PropertyType.Boolean, description: "Contains RTA")
    }

    def repentance_button_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Component id")
    }

    def bcra_regulation_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Component id")
    }

    "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
        banking_v2-balance(required: false, type: PropertyType.ArrayList(PropertyType.Map(banking_balance_item_definition), description: "The balance information")
        //banking_v2-actions(required: false, type: PropertyType.ArrayList(PropertyType.Map(banking_action_item_definition), description: "The balance information")
        shortcuts(required: false, type: PropertyType.ArrayList(PropertyType.Map(shortcuts_item_definition)), description: "Shortcuts")
        discount_center(required: false, type: PropertyType.ArrayList(PropertyType.Map(discount_center_item_definition)), description: "Shortcuts")
        //cross_selling(required: false, type: PropertyType.ArrayList(PropertyType.Map(cross_selling_item_definition)), description: "Cross selling")
        //benefits(required: false, type: PropertyType.ArrayList(PropertyType.Map(benefits_item_definition)), description: "Benefits")
        //activities(required: false, type: PropertyType.Map(activities_item_definition), description: "Activities")
        //repentance_button(required: false, type: PropertyType.Map(repentance_button_item_definition), description: "Repentance button")
        //bcra_regulation(required: false, type: PropertyType.Map(bcra_regulation_item_definition), description: "BCRA regulation")
    }
}
