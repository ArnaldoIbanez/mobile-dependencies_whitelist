package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    //Landings Deals - retrocompatibility
    "/deals"(platform: "/", isAbstract: true) {}

    "/deals/landing"(platform: "/") {
        deal_id(required: false, type: PropertyType.String)
        deal_print_id(required: false, type: PropertyType.String)
    }

    // Pageviews

    "/splinter/landing/all/deals"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/tier1"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/video"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/discovery"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/communicationals"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/sparkle"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/promotions"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/moda"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/deportes"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/belleza"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/juguetes"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/electronica"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/hogar"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/servicios"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String)
    }

    // events

    "/splinter/landing/all/deals"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/tier1"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/video"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/discovery"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/communicationals"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/sparkle"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/promotions"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/moda"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/deportes"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/belleza"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/juguetes"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/electronica"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/hogar"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
    "/splinter/landing/all/vertical/servicios"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String)
        action(required: false, type: PropertyType.String)
        label(required: false, type: PropertyType.String)
    }
}