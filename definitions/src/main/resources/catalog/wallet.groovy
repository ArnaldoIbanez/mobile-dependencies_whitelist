import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * Wallet screen tracks
    */

    "/wallet"(platform: "/mobile", isAbstract: true) {}

    // Cards screen
    "/wallet/cards"(platform: "/mobile", isAbstract: true) {}

    // Empty State
    "/wallet/cards/empty"(platform: "/mobile", type: TrackType.View) {}
    "/wallet/cards/empty/add_card"(platform: "/mobile", type: TrackType.Event) {}
    "/wallet/cards/empty/abort"(platform: "/mobile", type: TrackType.Event) {}
    
    // Show Results State
    "/wallet/cards/result"(platform: "/mobile", type: TrackType.View) {}
    "/wallet/cards/result/add_card"(platform: "/mobile", type: TrackType.Event) {}
    "/wallet/cards/result/abort"(platform: "/mobile", type: TrackType.Event) {}
}
