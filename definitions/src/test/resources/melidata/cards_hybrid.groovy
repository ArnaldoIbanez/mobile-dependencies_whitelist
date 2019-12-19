package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    //-----------------
    // HYBRID MP
    //-----------------

    defaultBusiness = "mercadopago"

    // SHIPPING
    // --------

    //Shipping: Tracking
    test("cards hybrid shipping tracking") {
        "/cards/hybrid/shipping/tracking"(platform: "/", type: TrackType.View) {
            banner_is_present = false
            contact_is_present = true
        }
        "/cards/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
            action = "contact"
        }
        "/cards/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
            component_id = "banner_unlock"
        }

    }
    //Shipping: Delayed
    test("cards hybrid shipping delayed") {
        "/cards/hybrid/shipping/delayed"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/shipping/delayed/tap"(platform:"/", type: TrackType.Event) {
            action = "reissue"
        }
    }   


    // UNLOCK
    // ------

    // Unlock: Update App
    test("cards hybrid unlock update app") {
        "/cards/hybrid/unlock/update-app"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "update"
        }
        "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "exit"
        }
    }

    // ENGAGEMENT
    // --------
    // Change-Pin: Flow to change the pin of the hybrid card

    test("cards hybrid change pin") {
        "/cards/hybrid/engagement/change-pin"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/engagement/change-pin/tap"(platform:"/", type: TrackType.Event) {
            action = "back"
        }
        "/cards/hybrid/engagement/change-pin/tap"(platform:"/", type: TrackType.Event) {
            action = "change-pin"
        }
    }

    //-----------------
    // HYBRID ML
    //-----------------

    defaultBusiness = "mercadolibre"

    // SHIPPING
    // --------

    //Shipping: Tracking
    test("cards hybrid shipping tracking") {
        "/cards/hybrid/shipping/tracking"(platform: "/", type: TrackType.View) {
            banner_is_present = false
            contact_is_present = true
        }
        "/cards/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
            action = "contact"
        }
        "/cards/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
            component_id = "banner_unlock"
        }

    }
    //Shipping: Delayed
    test("cards hybrid shipping delayed") {
        "/cards/hybrid/shipping/delayed"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/shipping/delayed/tap"(platform:"/", type: TrackType.Event) {
            action = "reissue"
        }
    }



    // UNLOCK
    // ------

    // Unlock: Update App
    test("cards hybrid unlock update app") {
        "/cards/hybrid/unlock/update-app"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "update"
        }
        "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "exit"
        }
    }

    // ENGAGEMENT
    // --------
    // Change-Pin: Flow to change the pin of the hybrid card

    test("cards hybrid change pin") {
        "/cards/hybrid/engagement/change-pin"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/engagement/change-pin/tap"(platform:"/", type: TrackType.Event) {
            action = "back"
        }
        "/cards/hybrid/engagement/change-pin/tap"(platform:"/", type: TrackType.Event) {
            action = "change-pin"
        }
    }
}