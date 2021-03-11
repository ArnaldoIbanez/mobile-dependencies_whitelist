package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1148"

    propertyDefinitions {
        section_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of a section"
        )
        card_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of a card"
        )
        component_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of an external component"
        )
        row_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of a row"
        )
        message_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of a message"
        )
        url(
            required: true,
            type: PropertyType.String,
            description: "Represents an URL to open"
        )
        tooltip_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of a tooltip"
        )
        shield_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of Shield in OptIn A12 and PSJ"
        )
        link_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates an ID of Link in OptIn A12 and PSJ"
        )
        channels(
            required: true,
            type: PropertyType.ArrayList,
            description: "Indicates the selected channels in OptIn A12"
        )
        schema(
            required: true,
            type: PropertyType.String,
            description: "Indicates the selected schema in OptIn A12"
        )
        installments(
            required: true,
            type: PropertyType.Numeric,
            description: "Indicates the selected schema installments in OptIn PSJ"
        )
        status(
            required: true,
            type: PropertyType.String,
            description: "The status code of and error"
        )
        message(
            required: false,
            type: PropertyType.String,
            description: "An error message"
        )
    }

    propertyGroups {
        top_message_action_group(message_id, url)
        top_message_dismiss_group(message_id)
        section_message_action_group(message_id, url, section_id)
        section_message_dismiss_group(message_id, section_id)
        component_event_group(section_id, component_id)
        card_message_action_group(message_id, url, section_id, card_id)
        card_message_dismiss_group(message_id, section_id, card_id)
        row_message_action_group(message_id, url, section_id, card_id, row_id)
        row_message_dismiss_group(message_id, section_id, card_id, row_id)
        row_action_group(section_id, card_id, row_id, url)
        tooltip_event_group(section_id, card_id, row_id, tooltip_id)
        optin_shield_group(shield_id)
        optin_link_group(link_id)
        optin_a12_save_group(channels, schema)
        optin_psj_save_group(installments)
        result_request_group(status, message)
    }

    // Abstract paths

    "/pricing_section" (platform: "/", isAbstract: true) { }
    "/pricing_section/message" (platform: "/", isAbstract: true) { }
    "/pricing_section/message/action" (platform: "/", isAbstract: true) { }
    "/pricing_section/section" (platform: "/", isAbstract: true) { }
    "/pricing_section/section/message" (platform: "/", isAbstract: true) { }
    "/pricing_section/section/message/action" (platform: "/", isAbstract: true) { }
    "/pricing_section/section/card" (platform: "/", isAbstract: true) { }
    "/pricing_section/section/component" (platform: "/", isAbstract: true) { }
    "/pricing_section/section/card/message" (platform: "/", isAbstract: true) { }
    "/pricing_section/section/card/message/action" (platform: "/", isAbstract: true) { }
    "/pricing_section/section/card/row" (platform: "/", isAbstract: true) { }
    "/pricing_section/section/card/row/message" (platform: "/", isAbstract: true) { }
    "/pricing_section/section/card/row/message/action" (platform: "/", isAbstract: true) { }
    "/pricing_section/section/card/row/tooltip" (platform: "/", isAbstract: true) { }
    "/pricing_section/a12" (platform: "/", isAbstract: true) { }
    "/pricing_section/a12/save" (platform: "/", isAbstract: true) { }
    "/pricing_section/psj" (platform: "/", isAbstract: true) { }
    "/pricing_section/psj/save" (platform: "/", isAbstract: true) { }
    "/pricing_section/coachmark" (platform: "/", isAbstract: true) { }

    // Tracks

    // Coachmark
    "/pricing_section/coachmark/start" (platform: "/", type: TrackType.Event) { }
    "/pricing_section/coachmark/finish" (platform: "/", type: TrackType.Event) { }
    "/pricing_section/coachmark/dismiss" (platform: "/", type: TrackType.Event) { }

    "/pricing_section/success" (platform: "/", type: TrackType.View) { }
    "/pricing_section/error" (platform: "/", type: TrackType.View) {
        result_request_group
    }
    "/pricing_section/close" (platform: "/mobile", type: TrackType.Event) { }
    "/pricing_section/message/dismiss" (platform: "/", type: TrackType.Event) {
        top_message_dismiss_group
    }
    "/pricing_section/message/action/primary" (platform: "/", type: TrackType.Event) {
        top_message_action_group
    }
    "/pricing_section/message/action/secondary" (platform: "/", type: TrackType.Event) {
        top_message_action_group
    }
    "/pricing_section/section/message/dismiss" (platform: "/", type: TrackType.Event) {
        section_message_dismiss_group
    }
    "/pricing_section/section/message/action/primary" (platform: "/", type: TrackType.Event) {
        section_message_action_group
    }
    "/pricing_section/section/message/action/secondary" (platform: "/", type: TrackType.Event) {
        section_message_action_group
    }
    "/pricing_section/section/component/success" (platform: "/", type: TrackType.Event) {
        component_event_group
    }
    "/pricing_section/section/component/error" (platform: "/", type: TrackType.Event) {
        component_event_group
    }
    "/pricing_section/section/card/message/dismiss" (platform: "/", type: TrackType.Event) {
        card_message_dismiss_group
    }
    "/pricing_section/section/card/message/action/primary" (platform: "/", type: TrackType.Event) {
        card_message_action_group
    }
    "/pricing_section/section/card/message/action/secondary" (platform: "/", type: TrackType.Event) {
        card_message_action_group
    }
    "/pricing_section/section/card/row/message/dismiss" (platform: "/", type: TrackType.Event) {
        row_message_dismiss_group
    }
    "/pricing_section/section/card/row/message/action/primary" (platform: "/", type: TrackType.Event) {
        row_message_action_group
    }
    "/pricing_section/section/card/row/message/action/secondary" (platform: "/", type: TrackType.Event) {
        row_message_action_group
    }
    "/pricing_section/section/card/row/action" (platform: "/", type: TrackType.Event) {
        row_action_group
    }
    "/pricing_section/section/card/row/tooltip/show" (platform: "/", type: TrackType.Event) {
        tooltip_event_group
    }
    "/pricing_section/section/card/row/tooltip/hide" (platform: "/", type: TrackType.Event) {
        tooltip_event_group
    }

    // Tracks Ahora 12
    "/pricing_section/a12/error" (platform: "/", type: TrackType.View) { }
    "/pricing_section/a12/success" (platform: "/", type: TrackType.View) { }
    "/pricing_section/a12/optin" (platform: "/", type: TrackType.View) { }
    "/pricing_section/a12/shield" (platform: "/", type: TrackType.View) {
        optin_shield_group
    }
    "/pricing_section/a12/cuit_verification" (platform: "/", type: TrackType.View) { }
    "/pricing_section/a12/back" (platform: "/", type: TrackType.Event) { }
    "/pricing_section/a12/navigate" (platform: "/", type: TrackType.Event) {
        optin_link_group
    }
    "/pricing_section/a12/save/success" (platform: "/", type: TrackType.Event) {
        optin_a12_save_group
    }
    "/pricing_section/a12/save/error" (platform: "/", type: TrackType.Event) {
        result_request_group
    }
    "/pricing_section/a12/cuit_verification/accept" (platform: "/", type: TrackType.Event) { }

    // Tracks PSJ
    "/pricing_section/psj/error" (platform: "/", type: TrackType.View) { }
    "/pricing_section/psj/success" (platform: "/", type: TrackType.View) { }
    "/pricing_section/psj/optin" (platform: "/", type: TrackType.View) { }
    "/pricing_section/psj/shield" (platform: "/", type: TrackType.View) {
        optin_shield_group
    }
    "/pricing_section/psj/back" (platform: "/", type: TrackType.Event) { }
    "/pricing_section/psj/navigate" (platform: "/", type: TrackType.Event) {
        optin_link_group
    }
    "/pricing_section/psj/help" (platform: "/", type: TrackType.Event) { }
    "/pricing_section/psj/save/success" (platform: "/", type: TrackType.Event) {
        optin_psj_save_group
    }
    "/pricing_section/psj/save/error" (platform: "/", type: TrackType.Event) {
        result_request_group
    }
}
