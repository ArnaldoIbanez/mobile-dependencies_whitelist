package src.test.resources.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    // reseller
    test("reseller") {
        "/reseller/scanner"(platform: "/mobile", type: TrackType.View) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
            seller_id = "342713"
            store_id = "43678"
            campaign_zone_id = "1"
            show_store_in_map = "true"
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }

        "/reseller/scanner/back" (platform: "/mobile", type: TrackType.Event) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }

        "/reseller/scanner/torch" (platform: "/mobile", type: TrackType.Event) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
            torch_enabled = true
        }

        "/reseller/scanner/scanned" (platform: "/mobile", type: TrackType.Event) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
            torch_enabled = true
            code = "https://mpago.la/pos/9962477"
        }

        "/reseller/scanner/camera_permission" (platform: "/mobile", type: TrackType.View) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }

        "/reseller/scanner/camera_permission/granted" (platform: "/mobile", type: TrackType.Event) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }

        "/reseller/scanner/camera_permission/rejected" (platform: "/mobile", type: TrackType.Event) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }

        "/reseller/scanner/camera_permission/configuration" (platform: "/mobile", type: TrackType.Event) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }

        "/reseller/congrats" (platform: "/mobile", type: TrackType.View) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
            status = "rejected"
        }

        "/reseller/congrats/close" (platform: "/mobile", type: TrackType.Event) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }

        "/reseller/congrats/continue" (platform: "/mobile", type: TrackType.Event) {
            action_id = "home"
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }

        "/reseller/scanner/error" (platform: "/mobile", type: TrackType.View) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
            type = "service_error"
            can_retry = false
        }

        "/reseller/scanner/error/retry" (platform: "/mobile", type: TrackType.Event) {
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }
}
