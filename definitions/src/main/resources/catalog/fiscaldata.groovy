
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

/**
 *
 * The events means actions that happens without launch a View,
 * as example of that we can consider Bookmark an item in a VIP page
 * Every event is an action, so the verbs available are:
 *
 * - back:  the event of back from a page, specially in mobile
 * - abort: the user abort the action (e.g: back pressed before api response)
 * - delete: when something is deleted
 * - apply: when a criteria is applied
 * - post: create a new entity
 */

tracks {
    "/registration"(platform: "/", isAbstract: true) {}
    "/registration/form"(platform: "/", type: TrackType.Event) {}
    "/registration/congrats"(platform: "/", type: TrackType.Event) {}

    "/flow"(platform: "/", isAbstract: true) {}
    "/flow/tax_payer"(platform: "/", type: TrackType.Event) {}
    "/flow/iva"(platform: "/", type: TrackType.Event) {}
    "/flow/load_iva"(platform: "/", type: TrackType.Event) {}
    "/flow/iibb"(platform: "/", type: TrackType.Event) {}
    "/flow/load_iibb"(platform: "/", type: TrackType.Event) {}
    "/flow/province_iibb"(platform: "/", type: TrackType.Event) {}
    "/flow/address"(platform: "/", type: TrackType.Event) {}
    "/flow/summary"(platform: "/", type: TrackType.Event) {}
    "/flow/congrats"(platform: "/", type: TrackType.Event) {}

}
