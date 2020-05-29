package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Application-iOS"){
        "/application/open" (platform:"/mobile/ios", type: TrackType.Event) {}
    }

    test("Application-Android"){
        "/application/open" (platform:"/mobile/android", type: TrackType.Event) {}
    }

    test("Application-Android"){
        "/application/workaround/nohistory" (platform:"/mobile/android", type: TrackType.Event) {}
    }

    test("install_event"){
        "/application/install_event" (platform: "/mobile", type: TrackType.Event){
        }
    }

    test("uninstall_event"){
        "/application/uninstall_event" (platform: "/mobile", type: TrackType.Event){
            type = "mobile"
            date_created = "2019-08-08T09:25:01.000-04:00"
            lang = "es-ar"
            timezone = "-0300"
            last_seen = "2020-03-06"
            source = "uninstalls_checker_flow"
            current_checking_day = 23
            execution_id = "eac9e889bb478758"
        }
    }

    test("not_engaged"){
        "/application/not_engaged" (platform: "/mobile", type: TrackType.Event){
            type = "mobile"
            date_created = "2019-08-08T09:25:01.000-04:00"
            lang = "es-ar"
            timezone = "-0300"
            last_seen = "2020-03-06"
            source = "uninstalls_checker_flow"
            current_checking_day = 23
            execution_id = "eac9e889bb478758"
        }
    }

    test("Mobile Navigation Menu"){
        "/navigation"(platform: "/mobile/android"){
            origin = "/HOME"
        }
    }

    test("Mobile Navigation Drawer"){
        "/navigation/drawer"(platform: "/mobile/android", type: TrackType.Event) {
            section = "my_account"
        }
    }

    test("Mobile Navigation Tabs"){
        "/navigation/tabs"(platform: "/mobile/ios", type: TrackType.Event) {
            action = "TAB_SELECTED"
            tab = "BOOKMARKS"
        }
    }

    test("Mobile Navigation to Cart"){
        "/navigation/cart"(platform: "/mobile/ios", type: TrackType.Event) {
            action = "CART_SELECTED"
            origin = "SEARCH"
        }
    }

    test("Permission location dialog") {
        "/permissions/location"(platform: "/mobile") {
            context="HOME"
        }
    }

    test("Custom Permission location dialog accepted") {
        "/permissions/location/custom/accept"(platform: "/mobile") {
            context="HOME"
        }
    }

    test("Custom Permission location dialog denied") {
        "/permissions/location/custom/deny"(platform: "/mobile") {
            context="HOME"
        }
    }

    test("Native Permission location dialog accepted") {
        "/permissions/location/native/accept"(platform: "/mobile") {
            context="HOME"
        }
    }


    test("Native Permission location dialog denied") {
        "/permissions/location/native/deny"(platform: "/mobile") {
            context="HOME"
        }
    }

    test("Devices Metadata") {
        "/devices/metadata"(platform:"/mobile") {
            total_storage = 12582912
            free_storage = 6291456
            app_storage = 307200
            dark_mode_status = "enabled"
            battery_save_mode = "disabled"
            data_save_mode = "whitelisted"
            do_not_disturb_mode = "disabled"
        }
    }

    test("Devices Notification Settings") {
        "/devices_settings/notifications"(platform:"/mobile") {
            enable = true
            registration_id = "1234567890ASDVH7766527892"
            device_id = "12345678"
        }
    }

    test("About settings") {
        "/settings/about"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Choose Country settings") {
        "/settings/country"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Security Tracks") {
        "/devices/websec/deeplinks_data"(platform:"/mobile/android") {
            from = "com.mercadolibre.android"
            destination = "MainActivity"
            scheme = "meli"
            encodedUri = "mercadolibre.com"
            segments = "webkit"
            query = "url=https://www.mercadolibre.com.ar/"
        }
    }

    test("MercadoPago wallet apprater") {

        "/application/apprater/add_track"(platform: "/mobile") {
            type_track="CRASHED"
        }
        "/application/apprater/add_track"(platform: "/mobile") {
            type_track="PAYMENT_APPROVED"
        }
        "/application/apprater/add_track"(platform: "/mobile") {
            type_track="WITHDRAW"
        }
        "/application/apprater/error_service_rules"(platform: "/mobile") {}
        "/application/apprater/popup"(platform: "/mobile") {}
    }

    test("Landing Deeplinks in Mobile") {
        "/landing/deeplinks"(platform:"/mobile") {
            desiredLink = "https://www.mercadolibre.com.ar/mercado-puntos"
            targetLink = "meli://loyalty"
            message = "Could not parse Target Link"
        }
    }
}
