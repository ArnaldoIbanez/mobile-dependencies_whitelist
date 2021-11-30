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

    def banking_balance_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Balance id")
        balance_histogram(required: true, type: PropertyType.Numeric, description: "Balance histogram")
        hidden(required: true, type: PropertyType.Boolean, description: "Balance hidden by user")
        pending_balance(required: true, type: PropertyType.Boolean, description: "Balance pending")
    }

    def banking_action_item_definition = objectSchemaDefinitions {
        component_id(type: PropertyType.String, required: true, description: "Action id")
        content_id(type: PropertyType.String, required: true, description: "Content id")
        position(type: PropertyType.Numeric, required: true, description: "Position")
        enabled(type: PropertyType.Boolean, required: true, description: "Enabled")
    }

    def banking_cards_item_definition = objectSchemaDefinitions {
        quantity(type: PropertyType.Numeric, required: true, description: "Quantity")
        prepaid(type: PropertyType.Boolean, required: true, description: "Prepaid")
        component_id(type: PropertyType.String, required: true, description: "Action id")
        debit(type: PropertyType.Boolean, required: true, description: "Debit")
    }

    def shortcuts_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Component id")
        is_favorite(required: true, type: PropertyType.Boolean, description: "Is favorite")
        content_id(required: true, type: PropertyType.String, description: "Content id")
        has_label(required: true, type: PropertyType.Boolean, description: "Has label")
        from(required: true, type: PropertyType.String, description: "from")
        position(required: true, type: PropertyType.Numeric, description: "Position")
        user_profile(required: true, type: PropertyType.String, description: "User profile")
        enabled(required: true, type: PropertyType.Boolean, description: "Is enabled")
        has_aware(required: true, type: PropertyType.Boolean, description: "Has aware")
        has_ripple(required: false, type: PropertyType.Boolean, description: "Has Ripple")
        logic(required: false, type: PropertyType.String, description: "Logic")
        group_id(required: false, type: PropertyType.String, description: "Group id")
        group_position(required: false, type: PropertyType.Numeric, description: "Group position")
    }

    def discount_center_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Component id")
    }

    def pendings_item_definition = objectSchemaDefinitions {
        logic(type: PropertyType.String, required: true, description: "Priority")
        criticality(type: PropertyType.Numeric, required: true, description: "Criticality")
        position(type: PropertyType.Numeric, required: true, description: "Position")
        from(type: PropertyType.String, required: true, description: "Section or Sheet")
        content_id(type: PropertyType.String, required: true, description: "Content id")
        flow(type: PropertyType.String, required: true, description: "Flow")
        bu_line(type: PropertyType.String, required: true, description: "Bu line")
        component_id(type: PropertyType.String, required: true, description: "Action id")
        bu(type: PropertyType.String, required: true, description: "Bu")
        audience(type: PropertyType.String, required: true, description: "Audience")
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

    def credits_item_definition = objectSchemaDefinitions {
        component_id(type: PropertyType.String, required: true, description: "Action id")
    }

    def loyalty_item_definition = objectSchemaDefinitions {
        component_id(type: PropertyType.String, required: true, description: "Action id")
        level(type: PropertyType.Numeric, required: true, description: "Level")
        percentage(type: PropertyType.Numeric, required: true, description: "Percentage")
    }

    def prepaid_banner_item_definition = objectSchemaDefinitions {
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

    def survey_item_definition = objectSchemaDefinitions {
        component_id(type: PropertyType.String, required: true, description: "Survey id")
    }

    def subscription_item_definition = objectSchemaDefinitions {
        component_id(type: PropertyType.String, required: true, description: "Subscription id")
    }

    def buy_level_subscription_item_definition = objectSchemaDefinitions {
        component_id(type: PropertyType.String, required: true, description: "Buy level subscription id")
    }

    "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
        banking_v2_balance(required: false, type: PropertyType.ArrayList(PropertyType.Map(banking_balance_item_definition)), description: "The balance information")
        banking_v2_actions(required: false, type: PropertyType.ArrayList(PropertyType.Map(banking_action_item_definition)), description: "The balance information")
        banking_v2_cards(required: false, type: PropertyType.ArrayList(PropertyType.Map(banking_cards_item_definition)), description: "The cardsinformation")
        shortcuts(required: false, type: PropertyType.ArrayList(PropertyType.Map(shortcuts_item_definition)), description: "Shortcuts")
        discount_center(required: false, type: PropertyType.ArrayList(PropertyType.Map(discount_center_item_definition)), description: "Discount center")
        pendings(required: false, type: PropertyType.ArrayList(PropertyType.Map(pendings_item_definition)), description: "Pendings")
        loyalty(required: false, type: PropertyType.ArrayList(PropertyType.Map(loyalty_item_definition)), description: "Loyalty")
        cross_selling(required: false, type: PropertyType.ArrayList(PropertyType.Map(cross_selling_item_definition)), description: "Cross selling")
        benefits(required: false, type: PropertyType.ArrayList(PropertyType.Map(benefits_item_definition)), description: "Benefits")
        prepaid_banner(required: false, type: PropertyType.Map(prepaid_banner_item_definition), description: "Prepaid banner")
        credits(required: false, type: PropertyType.Map(credits_item_definition), description: "Credits")
        activities(required: false, type: PropertyType.Map(activities_item_definition), description: "Activities")
        survey(required: false, type: PropertyType.Map(survey_item_definition), description: "Survey")
        subscription(required: false, type: PropertyType.Map(subscription_item_definition), description: "Subscription")
        buy_level_subscription(required: false, type: PropertyType.Map(buy_level_subscription_item_definition), description: "Buy level subscription")
        repentance_button(required: false, type: PropertyType.Map(repentance_button_item_definition), description: "Repentance button")
        bcra_regulation(required: false, type: PropertyType.Map(bcra_regulation_item_definition), description: "BCRA regulation")
    }
}
