package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1202"
    defaultBusiness = "mercadolibre"

    //Landings Deals - retrocompatibility
    "/deals"(platform: "/", isAbstract: true) {}

    "/deals/landing"(platform: "/") {
        deal_id(required: false, type: PropertyType.String, description: "Deal id")
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }

    // Pageviews
    "/splinter"(platform: "/", isAbstract: true) {}
    "/splinter/landing"(platform: "/", isAbstract: true) {}
    "/splinter/landing/all"(platform: "/", isAbstract: true) {}
    "/splinter/landing/all/vertical"(platform: "/", isAbstract: true) {}



    "/splinter/landing/all/deals"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/tier1"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/video"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/discovery"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/communicationals"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/sparkle"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/promotions"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/moda"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/deportes"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/belleza"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/juguetes"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/electronica"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/hogar"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/servicios"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }

    // events

    "/splinter/landing/all/deals"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/tier1"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/video"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/discovery"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/communicationals"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/sparkle"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/promotions"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/moda"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/deportes"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/belleza"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/juguetes"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/electronica"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/hogar"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/servicios"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
}