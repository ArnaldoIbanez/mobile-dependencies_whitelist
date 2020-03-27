package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1018"

    "/loyalty"(platform: "/", isAbstract: true) {
        level(type: PropertyType.Numeric, required: false)
        points(type: PropertyType.Numeric, required: false)
        percentage(type: PropertyType.Numeric, required: false)
        origin(required: false, values: ["mail", "push", "vip", "marketplace", "loyalty_frontend", "new_vip", "landing", "aerolineas"], description: "Where was the path flow initiated from.")
    }

    // Loyalty v2 pageviews
    "/loyalty/hub"(platform: "/", type: TrackType.View) {}
    "/loyalty/hub/skeleton"(platform: "/", type: TrackType.View) {}
    "/loyalty/status"(platform: "/", type: TrackType.View) {}
    "/loyalty/status/skeleton"(platform: "/", type: TrackType.View) {}
    "/loyalty/milestones_v2"(platform: "/", type: TrackType.View) {}
    "/loyalty/milestone_v2"(platform: "/", type: TrackType.View) {
        milestone_id(required: true, description: "id of the milestone", type: PropertyType.String)
        is_accomplished(required: true, descripcion: "wheter the milestone is already accomplish or not", type: PropertyType.Boolean)
    }

    // Loyalty v2 events
    "/loyalty/messages_close"(platform: "/", type: TrackType.Event) {
        id(required: true, description: "id the message closed by the user", type: PropertyType.String, values: ["points-expiration-tooltip", "push-level-up-tooltip", "info-tooltip", "info-tooltip-blue", "status-info-tooltip", "onboarding"])
    }

    "/loyalty/onboarding"(platform: "/", isAbstract: true) {
        step(required: true, description: "type of the element that the onboarding is showing", type: PropertyType.String)
    }

    "/loyalty/onboarding/open"(platform: "/", type: TrackType.Event) {}
    "/loyalty/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/loyalty/onboarding/previous"(platform: "/", type: TrackType.Event) {}
    "/loyalty/onboarding/close"(platform: "/", type: TrackType.Event) {}


    "/loyalty/card"(platform: "/", isAbstract: true) {
        page(required: true, description: "On which page does the event takes place", type: PropertyType.String, values: ["hub", "status", "offers"])
        type(required: true, description: "type of the card where the event is taking place", type: PropertyType.String)
        position(required: true, descripcion: "Position of the card in the page where the event is taking place", type: PropertyType.Numeric)
    }

    "/loyalty/card/item_action"(platform: "/", type: TrackType.Event) {
        id(required: true, description: "id of the sub component where the event is taking place", type: PropertyType.String)
        item_position(required: true, description: "position of the action where the event is taking place", type: PropertyType.Numeric)
    }

    "/loyalty/card/action"(platform: "/", type: TrackType.Event) {}

    "/loyalty/card/download"(platform: "/", type: TrackType.Event) {}
    "/loyalty/card/update"(platform: "/", type: TrackType.Event) {}

    "/loyalty/card/benefits_swipe"(platform: "/", type: TrackType.Event) {
        card_level(required: true, description: "position of the action where the event is taking place", type: PropertyType.Numeric)
    }

    "/loyalty/milestone_v2/action"(platform: "/", type: TrackType.Event) {}

    // CrossSelling Componente
    "/loyalty/crossselling"(platform: "/", isAbstract: true) {
        origin(type: PropertyType.String, required: true, description: "where is the component")
        title(type: PropertyType.String, required: false, description: "partner title")
        level(type: PropertyType.Numeric, required: false, description: "loyalty level of user")
    }

    "/loyalty/crossselling/carousel"(platform: "/", isAbstract: true) {}

    "/loyalty/crossselling/carousel/action"(platform: "/", type: TrackType.Event) {
        item_number(required: true, description: "position of the card", type: PropertyType.Numeric)
        item_link(required: false, description: "link of the card", type: PropertyType.String)
    }

    "/loyalty/crossselling/action"(platform: "/", type: TrackType.Event) {
        button_deeplink(required: true, description: "cta action", type: PropertyType.String)
    }
}
