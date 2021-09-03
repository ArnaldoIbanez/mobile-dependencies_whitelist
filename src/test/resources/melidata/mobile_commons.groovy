package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("splash_activity") {
        "/splash_activity"(platform:"/mobile", type:TrackType.View) {}
    }

    test("Generic error") {

        "/friction"(platform:"/mobile", type:TrackType.Event) {
            path = "/px_checkout/generic_error"
            style = "screen"
            id = "px_generic_error"
            message = "Hubo un error"
            extra_info = {
                api_status_code = "code"
                api_error_message = "message"
                api_url = "get_preference"
                retry_available = true
            }
            attributable_to = "mercadopago"
        }
    }

    test("In-App Updates") {
        //showed
        "/in_app_updates/inactive/showed"(platform:"/mobile") {
            version = "v1"
            type = "bump"
        }
        "/in_app_updates/inactive/showed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        "/in_app_updates/inactive/showed"(platform:"/mobile") {
            version = "v2"
            type = "bump"
        }
        "/in_app_updates/updatable/showed"(platform:"/mobile") {
            version = "v1"
            type = "bump"
        }
        "/in_app_updates/updatable/showed"(platform:"/mobile") {
            version = "v2"
            type = "bump"
        }
        "/in_app_updates/updatable/showed"(platform:"/mobile") {
            version = "v2"
            type = "google_flexible"
        }
        "/in_app_updates/updatable/showed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        //accepted
        "/in_app_updates/inactive/accepted"(platform:"/mobile") {
            version = "v1"
            type = "bump"
        }
        "/in_app_updates/inactive/accepted"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        "/in_app_updates/inactive/accepted"(platform:"/mobile") {
            version = "v2"
            type = "bump"
        }
        "/in_app_updates/updatable/accepted"(platform:"/mobile") {
            version = "v1"
            type = "bump"
        }
        "/in_app_updates/updatable/accepted"(platform:"/mobile") {
            version = "v2"
            type = "bump"
        }
        "/in_app_updates/updatable/accepted"(platform:"/mobile") {
            version = "v2"
            type = "google_flexible"
        }
        "/in_app_updates/updatable/accepted"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        // postponed
        "/in_app_updates/updatable/postponed"(platform:"/mobile") {
            version = "v1"
            type = "bump"
        }
        "/in_app_updates/updatable/postponed"(platform:"/mobile") {
            version = "v2"
            type = "bump"
        }
        "/in_app_updates/updatable/postponed"(platform:"/mobile") {
            version = "v2"
            type = "google_flexible"
        }
        "/in_app_updates/updatable/postponed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        // Installed
        "/in_app_updates/updatable/installed"(platform:"/mobile") {
            version = "v2"
            type = "google_flexible"
        }
        "/in_app_updates/updatable/installed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        "/in_app_updates/inactive/installed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        // Update Failed update_failed
        "/in_app_updates/updatable/update_failed"(platform:"/mobile") {
            version = "v2"
            type = "google_flexible"
        }
        "/in_app_updates/updatable/update_failed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        "/in_app_updates/inactive/update_failed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
            cause = "google info"
        }
        "/in_app_updates/inactive/postponed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        // Update Unavailable
        "/in_app_updates/updatable/update_not_available"(platform:"/mobile") {
            cause = "Google not Recommended"
            type = "google_flexible"
            version = "v2"
        }
    }

    test("Cross App Links") {
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_SUCCESS"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_FAILURE"
            reason = "APP_TARGET_NOT_INSTALLED"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_FAILURE"
            reason = "APP_TARGET_NOT_UPDATED"
        }
        "/cross_app_links/fetch"(platform:"/mobile") {
            link = "meli://test"
            provider = "ADJUST_PROVIDER"
        }
        "/cross_app_links/fetch_time"(platform:"/mobile") {
            link = "meli://test"
            provider = "ADJUST_PROVIDER"
            spent_time = "123"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_SUCCESS"
            from = "drawer"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_FAILURE"
            reason = "APP_TARGET_NOT_INSTALLED"
            from = "drawer"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_FAILURE"
            reason = "APP_TARGET_NOT_UPDATED"
            from = "drawer"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_FAILURE"
            reason = "APP_TARGET_NOT_INSTALLED"
            from = "drawer"
            id = "cross_link1"
            store_replacement_link = "meli://modal/full?id=test"
            store_replacement_link_scheme_is_valid = true
        }
        "/cross_app_links/fetch"(platform:"/mobile") {
            link = "meli://test"
            provider = "ADJUST_PROVIDER"
            from = "drawer"
        }
        "/cross_app_links/fetch_time"(platform:"/mobile") {
            link = "meli://test"
            provider = "ADJUST_PROVIDER"
            from = "drawer"
            spent_time = "123"
        }
        "/cross_app_links/fetch"(platform:"/mobile") {
            link = "meli://test"
            provider = "KEYCHAIN"
            from = "drawer"
            id = "cross_link1"
        }
        "/cross_app_links/fetch_time"(platform:"/mobile") {
            link = "meli://test"
            provider = "KEYCHAIN"
            from = "drawer"
            id = "cross_link1"
            spent_time = "123"
        }
    }

    defaultBusiness = "mercadopago"

    test("splash_activity") {
        "/splash_activity"(platform:"/mobile", type:TrackType.View) {}
    }

    test("Generic error") {

        "/friction"(platform:"/mobile", type:TrackType.Event) {
            path = "/px_checkout/generic_error"
            style = "screen"
            id = "px_generic_error"
            message = "Hubo un error"
            extra_info = {
                api_status_code = "code"
                api_error_message = "message"
                api_url = "get_preference"
                retry_available = true
            }
            attributable_to = "mercadopago"
        }


        "/friction"(platform:"/mobile", type:TrackType.Event) {
            path = "/checkout/review"
            style = "non_screen"
            id = "invalid_esc"
            extra_info = {
                api_status_code = "code"
                api_error_message = "message"
                api_url = "get_preference"
                retry_available = true
            }
            attributable_to = "mercadopago"
            session_id = "user_session_id"
        }
    }


    test("In-App Updates") {
        //showed
        "/in_app_updates/inactive/showed"(platform:"/mobile") {
            version = "v1"
            type = "bump"
        }
        "/in_app_updates/inactive/showed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        "/in_app_updates/inactive/showed"(platform:"/mobile") {
            version = "v2"
            type = "bump"
        }
        "/in_app_updates/updatable/showed"(platform:"/mobile") {
            version = "v1"
            type = "bump"
        }
        "/in_app_updates/updatable/showed"(platform:"/mobile") {
            version = "v2"
            type = "bump"
        }
        "/in_app_updates/updatable/showed"(platform:"/mobile") {
            version = "v2"
            type = "google_flexible"
        }
        "/in_app_updates/updatable/showed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        //accepted
        "/in_app_updates/inactive/accepted"(platform:"/mobile") {
            version = "v1"
            type = "bump"
        }
        "/in_app_updates/inactive/accepted"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        "/in_app_updates/inactive/accepted"(platform:"/mobile") {
            version = "v2"
            type = "bump"
        }
        "/in_app_updates/updatable/accepted"(platform:"/mobile") {
            version = "v1"
            type = "bump"
        }
        "/in_app_updates/updatable/accepted"(platform:"/mobile") {
            version = "v2"
            type = "bump"
        }
        "/in_app_updates/updatable/accepted"(platform:"/mobile") {
            version = "v2"
            type = "google_flexible"
        }
        "/in_app_updates/updatable/accepted"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        // postponed
        "/in_app_updates/updatable/postponed"(platform:"/mobile") {
            version = "v1"
            type = "bump"
        }
        "/in_app_updates/updatable/postponed"(platform:"/mobile") {
            version = "v2"
            type = "bump"
        }
        "/in_app_updates/updatable/postponed"(platform:"/mobile") {
            version = "v2"
            type = "google_flexible"
        }
        "/in_app_updates/updatable/postponed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        // installed
        "/in_app_updates/updatable/installed"(platform:"/mobile") {
            version = "v2"
            type = "google_flexible"
        }
        "/in_app_updates/updatable/installed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        "/in_app_updates/inactive/installed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        // Update Failed
        "/in_app_updates/inactive/update_failed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
            cause = "google info"
        }
        "/in_app_updates/inactive/postponed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        "/in_app_updates/updatable/update_failed"(platform:"/mobile") {
            version = "v2"
            type = "google_immediate"
        }
        "/in_app_updates/updatable/update_failed"(platform:"/mobile") {
            version = "v2"
            type = "google_flexible"
        }
        // Update Unavailable
        "/in_app_updates/updatable/update_not_available"(platform:"/mobile") {
            cause = "Google not Recommended"
            type = "google_flexible"
            version = "v2"
        }
    }

    test("Cross App Links") {
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_SUCCESS"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_FAILURE"
            reason = "APP_TARGET_NOT_INSTALLED"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_FAILURE"
            reason = "APP_TARGET_NOT_UPDATED"
        }
        "/cross_app_links/fetch"(platform:"/mobile") {
            link = "meli://test"
            provider = "ADJUST_PROVIDER"
        }
        "/cross_app_links/fetch_time"(platform:"/mobile") {
            link = "meli://test"
            provider = "ADJUST_PROVIDER"
            spent_time = "123"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_SUCCESS"
            from = "drawer"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_FAILURE"
            reason = "APP_TARGET_NOT_INSTALLED"
            from = "drawer"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_FAILURE"
            reason = "APP_TARGET_NOT_UPDATED"
            from = "drawer"
        }
        "/cross_app_links/dispatch"(platform:"/mobile") {
            link = "meli://test"
            result = "LINK_FAILURE"
            reason = "APP_TARGET_NOT_INSTALLED"
            from = "drawer"
            id = "cross_link1"
            store_replacement_link = "meli://modal/full?id=test"
            store_replacement_link_scheme_is_valid = true
        }
        "/cross_app_links/fetch"(platform:"/mobile") {
            link = "meli://test"
            provider = "ADJUST_PROVIDER"
            from = "drawer"
        }
        "/cross_app_links/fetch_time"(platform:"/mobile") {
            link = "meli://test"
            provider = "ADJUST_PROVIDER"
            from = "drawer"
            spent_time = "123"
        }
        "/cross_app_links/fetch"(platform:"/mobile") {
            link = "meli://test"
            provider = "KEYCHAIN"
            from = "drawer"
            id = "cross_link1"
        }
        "/cross_app_links/fetch_time"(platform:"/mobile") {
            link = "meli://test"
            provider = "KEYCHAIN"
            from = "drawer"
            id = "cross_link1"
            spent_time = "123"
        }
    }
}
