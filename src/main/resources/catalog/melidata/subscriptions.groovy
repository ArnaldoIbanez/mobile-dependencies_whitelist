package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    // Subscriptions
    "/subscriptions"(platform: "/", isAbstract: true) {
        order_id(required: true, type: PropertyType.String)
        item_id(required: true, type: PropertyType.String)
        category_id(required: true, type: PropertyType.String)
    }

    "/subscriptions/frequency"(platform: "/", type: TrackType.View) {}
    "/subscriptions/change_frequency"(platform: "/", type: TrackType.Event) {
        frequency(required: true, type: PropertyType.String)
        frequency_before(type: PropertyType.String)
        context(required: true, type: PropertyType.String)
    }

    "/subscriptions/address"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {}
    "/subscriptions/change_address"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        context(required: true, type: PropertyType.String)
    }

    "/subscriptions/review"(platform: "/", type: TrackType.View) {}
    "/subscriptions/review/confirm"(platform: "/", type: TrackType.Event) {
        context(required: true, type: PropertyType.String)
    }

    "/subscriptions/congrats"(platform: "/", type: TrackType.View) {}
    "/subscriptions/congrats/view_subscription"(platform: "/", type: TrackType.Event) {}
    "/subscriptions/congrats/subscribe"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {}

    "/subscriptions/summary"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {}
    "/subscriptions/detail"(platform: "/", type: TrackType.View) {}
    "/subscriptions/detail/modify_frequency"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {}

    "/subscriptions/delivery"(platform: "/", isAbstract: true) {}
    "/subscriptions/delivery/cancel"(platform: "/", type: TrackType.View) {
        context(required: true, type: PropertyType.String)
    }
    "/subscriptions/delivery/cancel"(platform: "/", type: TrackType.Event) {
        context(required: true, type: PropertyType.String)
    }

    "/subscriptions/detail/cancel"(platform: "/", type: TrackType.View) {}
    "/subscriptions/detail/cancel/subscription"(platform: "/", type: TrackType.Event) {}

    //Landings Subscriptions
    "/subscriptions_landing"(platform: "/", type: TrackType.View) {}

    "/subscriptions_landing/select_item_slide"(platform: "/", type: TrackType.Event) {
        category_id(required: true, type: PropertyType.String)
    }

    "/subscriptions_landing/terms_condition"(platform: "/", type: TrackType.Event) {}

}
