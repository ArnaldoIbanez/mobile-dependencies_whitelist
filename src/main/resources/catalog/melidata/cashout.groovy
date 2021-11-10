package catalog.melidata

import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1240'

    /**
        Cashout Lib Tracks
    **/

    "/cashout"(platform: "/", isAbstract: true) {}
    "/cashout/hub/kyc"(platform: "/", isAbstract: true) {}
    "/cashout/hub/lighthouses"(platform: "/", isAbstract: true) {}
    "/cashout/hub/lighthouses/details"(platform: "/", isAbstract: true) {}

    "/cashout/hub"(platform: "/", type: TrackType.View) {}
    "/cashout/hub/select"(platform: "/", type: TrackType.Event) {
        cashout_method (required:true, description: "Selected cashout method")
    }

    "/cashout/hub/lighthouses"(platform: "/", type: TrackType.View) {}

    "/cashout/hub/lighthouses/details"(platform: "/", type: TrackType.View) {
        id (required:true, description: "Selected lighthouse id")
    }
    "/cashout/hub/lighthouses/details/scanqr"(platform: "/", type: TrackType.Event) {
        id (required:true, description: "Selected lighthouse id")
    }

    "/cashout/hub/congrats"(platform: "/", isAbstract: true) {}
    "/cashout/hub/congrats/success"(platform: "/", type: TrackType.View) {}
    "/cashout/hub/congrats/success/continue"(platform: "/", type: TrackType.Event) {}
    "/cashout/hub/congrats/success/close"(platform: "/", type: TrackType.Event) {}

    "/cashout/modal"(platform: "/", type: TrackType.View) {}
    "/cashout/modal/close"(platform: "/", type: TrackType.Event) {}
    "/cashout/modal/withdraw"(platform: "/", type: TrackType.Event) {}

    "/cashout/extracash"(platform: "/", isAbstract: true) {}
    "/cashout/extracash/onboarding"(platform: "/", type: TrackType.View) {}
    "/cashout/extracash/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/cashout/extracash/onboarding/close"(platform: "/", type: TrackType.Event) {}

}
