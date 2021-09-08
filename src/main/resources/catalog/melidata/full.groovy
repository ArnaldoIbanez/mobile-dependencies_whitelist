package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1196"
    
    //Views
    "/fbm/landing"(platform: "/", type: TrackType.View) {}
    "/fbm/landing/optin"(platform: "/", type: TrackType.View) {}
    "/fbm/landing/congrats"(platform: "/", type: TrackType.View) {}

    // Events
    //Contact me Button
    "/fbm/landing/contact_me"(platform: "/", type: TrackType.Event) {
        location(
            required: true,
            type: PropertyType.String,
            description: "Location of the CTA Button.",
            values: ["top", "bottom"]
        )
    }

    //FAQs about Fulfillment
    "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) {
        faq(
            required: true,
            type: PropertyType.String,
            description: "Which FAQ has been opened.",
            values: ["opt_in", "dc_location", "send_my_inventory", "send_inventory_from_supplier", "fees", "manage_inventory", "send_any_product","billing_warehouse","cost_fulfillment"]
        )
    }

    //Cancel Fulfillment Opt-in
    "/fbm/landing/cancel_opt_in"(platform: "/", type: TrackType.Event) { }
}
