package catalog.melidata

import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
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

    // Tracks

    "/pricing_section/success" (platform: "/", type: TrackType.View) { }
    "/pricing_section/error" (platform: "/", type: TrackType.Event) { 
        status(
            required: true,
            type: PropertyType.String,
            description: "The status code of and error"
        )
        message(
            required: true,
            type: PropertyType.String,
            description: "An error message"
        )
    }
    "/pricing_section/close" (platform: "/mobile", type: TrackType.Event) { }
    "/pricing_section/message/dismiss" (platform: "/", type: TrackType.Event) { 
        message_id
    }
    "/pricing_section/message/action/primary" (platform: "/", type: TrackType.Event) { 
        message_id, 
        url
    }
    "/pricing_section/message/action/secondary" (platform: "/", type: TrackType.Event) { 
        message_id, 
        url
    }
    "/pricing_section/section/message/dismiss" (platform: "/", type: TrackType.Event) { 
        message_id, 
        section_id
    }
    "/pricing_section/section/message/action/primary" (platform: "/", type: TrackType.Event) { 
        message_id, 
        url, 
        section_id
    }
    "/pricing_section/section/message/action/secondary" (platform: "/", type: TrackType.Event) { 
        message_id, 
        url, 
        section_id
    }
    "/pricing_section/section/component/success" (platform: "/", type: TrackType.Event) { 
        section_id, 
        component_id
    }
    "/pricing_section/section/component/error" (platform: "/", type: TrackType.Event) {
        section_id, 
        component_id
    }
    "/pricing_section/section/card/message/dismiss" (platform: "/", type: TrackType.Event) { 
        message_id, 
        section_id, 
        card_id
    }
    "/pricing_section/section/card/message/action/primary" (platform: "/", type: TrackType.Event) { 
        message_id, 
        url, 
        section_id, 
        card_id
    }
    "/pricing_section/section/card/message/action/secondary" (platform: "/", type: TrackType.Event) { 
        message_id, 
        url, 
        section_id, 
        card_id
    }
    "/pricing_section/section/card/row/message/dismiss" (platform: "/", type: TrackType.Event) { 
        message_id, 
        section_id, 
        card_id, 
        row_id
    }
    "/pricing_section/section/card/row/message/action/primary" (platform: "/", type: TrackType.Event) { 
        message_id, 
        url, 
        section_id, 
        card_id, 
        row_id
    }
    "/pricing_section/section/card/row/message/action/secondary" (platform: "/", type: TrackType.Event) { 
        message_id, 
        url, 
        section_id, 
        card_id, 
        row_id
    }
    "/pricing_section/section/card/row/action" (platform: "/", type: TrackType.Event) { 
        section_id, 
        card_id, 
        row_id,
        url
    }
    "/pricing_section/section/card/row/tooltip/show" (platform: "/", type: TrackType.Event) { 
        section_id, 
        card_id, 
        row_id,
        tooltip_id
    }
    "/pricing_section/section/card/row/tooltip/hide" (platform: "/", type: TrackType.Event) { 
        section_id, 
        card_id, 
        row_id,
        tooltip_id
    }

}