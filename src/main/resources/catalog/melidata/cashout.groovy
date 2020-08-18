package catalog.melidata

import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1240'

    /**
        Cashout Lib Tracks
    **/

    "/cashout"(platform: "/", isAbstract: true) {}
    "/cashout/hub"(platform: "/", isAbstract: true) {}
    "/cashout/hub/kyc"(platform: "/", isAbstract: true) {}

    "/cashout/hub/kyc/onboarding"(platform: "/", type: TrackType.View) {}
    "/cashout/hub/kyc/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/cashout/hub/kyc/onboarding/close"(platform: "/", type: TrackType.Event) {}

    "/cashout/hub/congrats"(platform: "/", isAbstract: true) {}
    "/cashout/hub/congrats/success"(platform: "/", type: TrackType.View) {}
    "/cashout/hub/congrats/success/continue"(platform: "/", type: TrackType.Event) {}
    "/cashout/hub/congrats/success/close"(platform: "/", type: TrackType.Event) {}

    "/cashout/extracash"(platform: "/", isAbstract: true) {}
    "/cashout/extracash/onboarding"(platform: "/", type: TrackType.View) {}
    "/cashout/extracash/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/cashout/extracash/onboarding/close"(platform: "/", type: TrackType.Event) {}

}
