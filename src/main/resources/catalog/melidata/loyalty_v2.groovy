package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1018"

    "/loyalty"(platform: "/", isAbstract: true) {
        level(type: PropertyType.Numeric, required: false, description: "The user Loyalty level.")
        points(type: PropertyType.Numeric, required: false, description: "User's Loyalty points.")
        percentage(type: PropertyType.Numeric, required: false, description: "Percentage related to amount of points needed to reach next Loyalty level.")
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

    // CrossSelling Component
    "/loyalty/crossselling"(platform: "/", isAbstract: true) {
        origin(type: PropertyType.String, required: false, description: "where is the component")
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


    // Loyalty Partners VDP
    "/loyalty/partners"(platform: "/", isAbstract: true) {
        subscription_partner(required: false, description: "VDP partner name (HBO, Paramount, etc.)", type: PropertyType.String)
        discount_percent(required: false, description: "User discount", type: PropertyType.Numeric)
        origin(required: false, description: "Where was the vdp initiated from")
        loyalty_level(type: PropertyType.Numeric, required: false)
        plan_id(required: false, description: "User selected subscription plan id", type: PropertyType.Numeric)
    }

    "/loyalty/partners/vdp"(platform: "/", type: TrackType.View) {
        content(required: true, description: "Content of the partner. Ex: Game Of Thrones", type: PropertyType.String)
        subscription_status(required: false, description: "Subscription Status", type: PropertyType.String)
    }

    "/loyalty/partners/vdp/action"(platform: "/", type: TrackType.Event) {
        type(required: true, description: "User discount", values: ["content", "primary", "secondary", "tyc"], type: PropertyType.String)
        name(required: false, description: "Action pressed name", type: PropertyType.String)
        position(required: false, description: "Action position in carousel", type: PropertyType.Numeric)
        subscription_type(required: false, description: "Selected subscription pack Type", type: PropertyType.String)
    }

    "/loyalty/partners/vdp/content"(platform: "/", type: TrackType.View) {}

    "/loyalty/partners/vdp/content/action"(platform: "/", type: TrackType.Event) {
        type(required: true, description: "User discount", values: ["primary", "secondary", "tyc"], type: PropertyType.String)
    }

    "/loyalty/partners/teaser"(platform: "/", type: TrackType.View) {}

    // Loyalty Subscription Congrats
    "/loyalty/partners/checkout"(platform: "/", isAbstract: true) {}

    "/loyalty/partners/checkout/congrats"(platform: "/", type: TrackType.View) {
        payment_status(required: false, description: "Payment status", type: PropertyType.String)
        payment_status_detail(required: false, description: "Payment detail", type: PropertyType.String)
        payment_id(required: false, description: "Payment id", type: PropertyType.String)
        is_free_trial(required: false, description: "If checkout is for activate a free trial", type: PropertyType.String)
        subscription_type(required: false, description: "Subscription pack type", type: PropertyType.String)
    }

    "/loyalty/partners/checkout/congrats/action"(platform: "/", type: TrackType.Event) {
        type(required: true, description: "Action type", values: ["close", "back", "action", "tyc"], type: PropertyType.String)
        label(required: false, description: "Action pressed label", type: PropertyType.String)
        deeplink(required: false, description: "Action link to go", type: PropertyType.String)
        subscription_type(required: false, description: "Subscription pack type", type: PropertyType.String)
    }

    "/loyalty/partners/checkout/congrats/info"(platform: "/", type: TrackType.Event) {
        type(required: true, description: "Info showed in description", type: PropertyType.String)
    }

    // Loyalty Subscription Login
    "/loyalty/partners/login"(platform: "/", type: TrackType.View) {}

    "/loyalty/partners/login/action"(platform: "/", type: TrackType.Event) {}

    "/loyalty/partners/login/verify"(platform: "/", type: TrackType.View) {}

    "/loyalty/partners/login/verify/action"(platform: "/", type: TrackType.Event) {
        type(required: true, description: "Action type", values: ["push", "email", "another"], type: PropertyType.String)
    }


    "/loyalty/partners/login/code"(platform: "/", type: TrackType.View) {
        viewType(required: false, description: "View type", values: ["email", "notification"], type: PropertyType.String)
    }

    "/loyalty/partners/login/code/action"(platform: "/", type: TrackType.Event) {
        type(required: true, description: "Action type", values: ["verify", "resend", "another"], type: PropertyType.String)
    }

    "/loyalty/partners/login/verified"(platform: "/", type: TrackType.Event) {
        url(required: false, description: "Url to go", type: PropertyType.String)
    }

    "/loyalty/partners/login/invalid"(platform: "/", type: TrackType.Event) {
        server_error(required: false, description: "Server error", type: PropertyType.String)
    }

    "/loyalty/partners/comboplus"(platform: "/", isAbstract: true, type: TrackType.View) {
        level(required: false, description: "Level", type: PropertyType.Numeric)
        subscribed_plans(required: false, description: "Subscribed plans", type: PropertyType.ArrayList(PropertyType.String))
    }

    "/loyalty/partners/comboplus/modal"(platform: "/", type: TrackType.View) {
        type(required: false, description: "Action type",values: ["widgetBuyLevel", "floating", "primary", "secondary", "close", "login", "activate"], type: PropertyType.String)
        selected_option(required: false, description: "Option to pay if there is more than one", values: ["option-1", "option-2", "option-3", "option-4", "option-5", "option-6"], type: PropertyType.String)
    }

    "/loyalty/partners/comboplus/action"(platform: "/", type: TrackType.Event) {
        type(required: false, description: "Action type"
                ,values: ["widgetBuyLevel", "floating", "primary", "secondary", "close", "login", "activate"], type: PropertyType.String)
    }
    "/loyalty/partners/comboplus/modal/action"(platform: "/", type: TrackType.Event) {
        type(required: false, description: "Action type"
                ,values: ["widgetBuyLevel", "floating", "primary", "secondary", "close", "login", "activate"], type: PropertyType.String)
    }

    // Loyalty Subscription Admin
    "/loyalty/partners/admin"(platform: "/", type: TrackType.View) {
        subscription_partner(required: true, description: "VDP partner name (HBO, Paramount, etc.)", type: PropertyType.String)
        level(type: PropertyType.Numeric, required: false)
        subscription_status(required: false, description: "Subscription Status", values: ["inactive", "active", "pending", "ended", "expired"], type: PropertyType.String)
        subscribed_plans(required: false, description: "Subscribed plans", type: PropertyType.ArrayList(PropertyType.String))
    }

    "/loyalty/partners/admin/action"(platform: "/", type: TrackType.Event) {
        type(required: false, description: "Action type" ,values: ["primary", "secondary", "dismiss", "tyc-button", "cancel", "modify", "change-code", "close"], type: PropertyType.String)
    }

    "/loyalty/partners/summary"(platform: "/", type: TrackType.View) {
        level(type: PropertyType.Numeric, required: false)
    }

    "/loyalty/buylevel"(platform: "/", isAbstract: true, type: TrackType.View) {
        level( required: false, type: PropertyType.Numeric, description: "Level")
        subscription_status(required: false, type: PropertyType.String, values: ["inactive", "active", "pending"], description: "Subscription Status")
        subscription_partner(required: false, description: "Partner name (HBO, Paramount, Disney, etc.)", type: PropertyType.String)
    }

    "/loyalty/buylevel/action"(platform: "/", type: TrackType.Event) {
        type(required: false, values: ["primary", "secondary", "close", "login", "activate", "default", "tyc"], type: PropertyType.String, description: "Action type")
    }

    "/loyalty/buylevel/admin"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/buylevel/congrats"(platform: "/", type: TrackType.View) {
        discount_percent(required: false, description: "User discount", type: PropertyType.Numeric)
        subscription_type(required: false, description: "Subscription pack type", type: PropertyType.String)
        loyalty_level(required: false , descripcion: "loyalty level",type: PropertyType.Numeric )
        payment_status_detail(required: false, description: "Payment detail", type: PropertyType.String)
        payment_id(required: false, description: "Payment id", type: PropertyType.String)
        payment_status(required: false, description: "Payment status", type: PropertyType.String)
        content(required: false, description: "Specific content (banner, promo, etc.) shown in VDP (first step)", type: PropertyType.String)
    }

    "/loyalty/interstitial/modal"(platform: "/", type: TrackType.Event) {
        status(required: true, description: "Diferentes estados que pueden tener los eventos del interstitial que pueden ser enviados por el BE o acciones de usuarios", type: PropertyType.String)
    }

    "/loyalty/interstitial/data"(platform: "/", type: TrackType.Event) {}

    "/loyalty/drawer/pill"(platform: "/", type: TrackType.Event) {}
}
