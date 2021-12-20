package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Error UX
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Error UX tracks - ML") {

        "/error_ux/error_screen"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            number = "01"
            screen = "VipActivity"
        }

        "/error_ux/error_screen"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            screen = "VipActivity"
        }

        "/error_ux/error_screen"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            number = "01"
        }

        "/error_ux/error_screen"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
        }

        "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            number = "01"
            screen = "VipActivity"
        }

        "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            number = "01"
            screen = "VipActivity"
        }

        "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            screen = "VipActivity"
        }

        "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            number = "01"
        }

        "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
        }
    }

    defaultBusiness = "mercadopago"

    test("Error UX tracks - ML") {

        "/error_ux/error_screen"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            number = "01"
            screen = "VipActivity"
        }

        "/error_ux/error_screen"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            screen = "VipActivity"
        }

        "/error_ux/error_screen"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            number = "01"
        }

        "/error_ux/error_screen"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
        }

        "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            number = "01"
            screen = "VipActivity"
        }

        "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            number = "01"
            screen = "VipActivity"
        }

        "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            screen = "VipActivity"
        }

        "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            number = "01"
        }

        "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
        }
    }
}
