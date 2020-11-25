import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("ESC Manager") {

        // Save ESC with session id
        "/esc_manager/save"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            key = "1234"
            esc_length = 44
            flow = "/instore"
        }

        // Save ESC without session id
        "/esc_manager/save"(platform: "/mobile", type: TrackType.Event) {
            key = "1234"
        }

        // Delete ESC with session id
        "/esc_manager/delete"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            key = "1234"
        }

        // Delete without session id
        "/esc_manager/delete"(platform: "/mobile", type: TrackType.Event) {
            key = "1234"
            flow = "/instore"
            reason = "unexpected_tokenization_error"
            detail = "123;456;789"
        }

        // Delete all without session id
        "/esc_manager/delete/all"(platform: "/mobile", type: TrackType.Event) {
        }

        // Delete all with session id
        "/esc_manager/delete/all"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
        }

        "/esc_manager/unavailable"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            key = "1234"
            error_code = "12"
        }

        "/esc_manager/unavailable"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            key = "1234"
            flow = "/instore"
        }

        "/esc_manager/invalid/esc"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            key = "1234"
        }

        "/esc_manager/invalid/key"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
        }

        "/esc_manager/sync"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            flow = "flow"
            type = "single_esc_sync_request"
            quantity = 1
        }
    }

    defaultBusiness = "mercadopago"

    test("ESC Manager") {

        // Save ESC with session id
        "/esc_manager/save"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            key = "1234"
            esc_length = 88
            flow = "/instore"
        }

        // Save ESC without session id
        "/esc_manager/save"(platform: "/mobile", type: TrackType.Event) {
            key = "1234"
        }

        // Delete ESC with session id
        "/esc_manager/delete"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            key = "1234"
        }

        // Delete without session id
        "/esc_manager/delete"(platform: "/mobile", type: TrackType.Event) {
            key = "1234"
            flow = "/instore"
            reason = "unexpected_tokenization_error"
            detail = "123;456;789"
        }

        // Delete all without session id
        "/esc_manager/delete/all"(platform: "/mobile", type: TrackType.Event) {
        }

        // Delete all with session id
        "/esc_manager/delete/all"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
        }

        "/esc_manager/unavailable"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            key = "1234"
            error_code = "12"
            flow = "/instore"
        }

        "/esc_manager/unavailable"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            key = "1234"
        }

        "/esc_manager/invalid/esc"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            key = "1234"
        }

        "/esc_manager/invalid/key"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
        }

        "/esc_manager/sync"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            flow = "flow"
            type = "single_esc_sync_request"
            quantity = 1
        }
    }
}
