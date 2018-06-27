import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * QR Discount Screen Tracks
    */
    "/qr_discount"(platform: "/mobile", isAbstract: true) {}

    "/qr_discount/couchmark"(platform: "/mobile", type: TrackType.View) {}
    "/qr_discount/how_to"(platform: "/mobile", type: TrackType.View) {}
    "/qr_discount/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/qr_discount/pending"(platform: "/mobile", type: TrackType.View) {}
    "/qr_discount/game_result"(platform: "/mobile", type: TrackType.View) {}
    "/qr_discount/router"(platform: "/mobile", type: TrackType.View) {}
    "/qr_discount/begin_game"(platform: "/mobile", type: TrackType.View) {}

}
