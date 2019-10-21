package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS QR_DISCOUNT
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("QR_DISCOUNT - views") {
        "/qr_discount/couchmark"(platform: "/mobile", type: TrackType.View) {}
        "/qr_discount/how_to"(platform: "/mobile", type: TrackType.View) {}
        "/qr_discount/onboarding"(platform: "/mobile", type: TrackType.View) {}
        "/qr_discount/pending"(platform: "/mobile", type: TrackType.View) {}
        "/qr_discount/game_result"(platform: "/mobile", type: TrackType.View) {}
        "/qr_discount/router"(platform: "/mobile", type: TrackType.View) {}
        "/qr_discount/begin_game"(platform: "/mobile", type: TrackType.View) {}
    }

}
