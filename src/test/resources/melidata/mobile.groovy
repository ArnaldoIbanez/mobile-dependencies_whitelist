package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Application-iOS"){
        "/application/open" (platform:"/mobile/ios", type: TrackType.Event) {}
        "/application/open" (platform:"/mobile/ios", type: TrackType.Event, business: "mercadopago") {}
    }

    test("Application-Android"){
        "/application/open" (platform:"/mobile/android", type: TrackType.Event) {}
        "/application/open" (platform:"/mobile/android", type: TrackType.Event, business: "mercadopago") {}
    }

    test("Application-Android"){
        "/application/workaround/nohistory" (platform:"/mobile/android", type: TrackType.Event) {}
        "/application/workaround/nohistory" (platform:"/mobile/android", type: TrackType.Event, business: "mercadopago") {}
    }

    test("install_event"){
        "/application/install_event" (platform: "/mobile", type: TrackType.Event){}
        "/application/install_event" (platform: "/mobile", type: TrackType.Event, business: "mercadopago"){}
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
            app_storage = 61779968
            free_storage = 58936602624
            total_storage = 114778902528
        }
        "/application/uninstall_event" (platform: "/mobile", type: TrackType.Event, business: "mercadopago"){
            type = "mobile"
            date_created = "2019-08-08T09:25:01.000-04:00"
            lang = "es-ar"
            timezone = "-0300"
            last_seen = "2020-03-06"
            source = "uninstalls_checker_flow"
            current_checking_day = 23
            execution_id = "eac9e889bb478758"
            app_storage = 61779968
            free_storage = 58936602624
            total_storage = 114778902528
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
            app_storage = 61779968
            free_storage = 58936602624
            total_storage = 114778902528
        }
        "/application/not_engaged" (platform: "/mobile", type: TrackType.Event, business: "mercadopago"){
            type = "mobile"
            date_created = "2019-08-08T09:25:01.000-04:00"
            lang = "es-ar"
            timezone = "-0300"
            last_seen = "2020-03-06"
            source = "uninstalls_checker_flow"
            current_checking_day = 23
            execution_id = "eac9e889bb478758"
            app_storage = 61779968
            free_storage = 58936602624
            total_storage = 114778902528
        }
    }

    test("Mobile Navigation Menu"){
        "/navigation"(platform: "/mobile/android"){
            origin = "/HOME"
        }
        "/navigation"(platform: "/mobile/android", business: "mercadopago"){
            origin = "/HOME"
        }
    }

    test("Mobile Navigation Drawer"){
        "/navigation/drawer"(platform: "/mobile/android", type: TrackType.Event) {
            section = "my_account"
        }
        "/navigation/drawer"(platform: "/mobile/android", type: TrackType.Event, business: "mercadopago") {
            section = "my_account"
        }
    }

    test("Mobile Navigation Tabs"){
        "/navigation/tabs"(platform: "/mobile/ios", type: TrackType.Event) {
            action = "TAB_SELECTED"
            tab = "BOOKMARKS"
        }
        "/navigation/tabs"(platform: "/mobile/ios", type: TrackType.Event, business: "mercadopago") {
            action = "TAB_SELECTED"
            tab = "BOOKMARKS"
        }
    }

    test("Mobile Navigation to Cart"){
        "/navigation/cart"(platform: "/mobile/ios", type: TrackType.Event) {
            action = "CART_SELECTED"
            origin = "SEARCH"
        }
        "/navigation/cart"(platform: "/mobile/ios", type: TrackType.Event, business: "mercadopago") {
            action = "CART_SELECTED"
            origin = "SEARCH"
        }
    }

    test("Permission location dialog") {
        "/permissions/location"(platform: "/mobile") {
            context="HOME"
        }
        "/permissions/location"(platform: "/mobile", business: "mercadopago") {
            context="HOME"
        }
    }

    test("Custom Permission location dialog accepted") {
        "/permissions/location/custom/accept"(platform: "/mobile") {
            context="HOME"
        }
        "/permissions/location/custom/accept"(platform: "/mobile", business: "mercadopago") {
            context="HOME"
        }
    }

    test("Custom Permission location dialog denied") {
        "/permissions/location/custom/deny"(platform: "/mobile") {
            context="HOME"
        }
        "/permissions/location/custom/deny"(platform: "/mobile", business: "mercadopago") {
            context="HOME"
        }
    }

    test("Native Permission location dialog accepted") {
        "/permissions/location/native/accept"(platform: "/mobile") {
            context="HOME"
        }
        "/permissions/location/native/accept"(platform: "/mobile", business: "mercadopago") {
            context="HOME"
        }
    }


    test("Native Permission location dialog denied") {
        "/permissions/location/native/deny"(platform: "/mobile") {
            context="HOME"
        }
        "/permissions/location/native/deny"(platform: "/mobile", business: "mercadopago") {
            context="HOME"
        }
    }

    test("IDFA Permission dialog") {
        "/permissions/idfa"(platform: "/mobile") {}
        "/permissions/idfa"(platform: "/mobile", business: "mercadopago") {}
    }

    test("IDFA Permission dialog shown") {
        "/permissions/idfa/shown"(platform: "/mobile") {}
        "/permissions/idfa/shown"(platform: "/mobile", business: "mercadopago") {}
    }

    test("IDFA Permission dialog accepted") {
        "/permissions/idfa/accept"(platform: "/mobile") {}
        "/permissions/idfa/accept"(platform: "/mobile", business: "mercadopago") {}
    }

    test("IDFA Permission dialog denied") {
        "/permissions/idfa/denied"(platform: "/mobile") {}
        "/permissions/idfa/denied"(platform: "/mobile", business: "mercadopago") {}
    }

    test("Devices Metadata") {
        "/devices/metadata"(platform:"/mobile") {
            total_storage = 12582912
            free_storage = 6291456
            app_storage = 307200
            app_cache = 76800
            app_data = 230400
            dark_mode_status = "enabled"
            font_scale = "large"
            voice_over = false
            high_contrast = true
            battery_save_mode = "disabled"
            data_save_mode = "whitelisted"
            do_not_disturb_mode = "disabled"
            carrier_code = "722341"
            carrier_name = "Personal"
            nfc_compatible = ["nfc_mifare"]
            nfc_enabled = false
        }

        "/devices/metadata"(platform:"/mobile", business: "mercadopago") {
            total_storage = 12582912
            free_storage = 6291456
            app_storage = 307200
            app_cache = 76800
            app_data = 230400
            dark_mode_status = "enabled"
            font_scale = "medium"
            voice_over = true
            high_contrast = false
            battery_save_mode = "disabled"
            data_save_mode = "whitelisted"
            do_not_disturb_mode = "disabled"
            carrier_code = "722341"
            carrier_name = "Personal"
            nfc_compatible = ["nfc_mifare"]
            nfc_enabled = true
        }
    }

    test("Devices Notification Settings") {
        "/devices_settings/notifications"(platform:"/mobile") {
            enable = true
            registration_id = "1234567890ASDVH7766527892"
            device_id = "12345678"
        }
        "/devices_settings/notifications"(platform:"/mobile", business: "mercadopago") {
            enable = true
            registration_id = "1234567890ASDVH7766527892"
            device_id = "12345678"
        }
    }

    test("About settings") {
        "/settings/about"(platform: "/mobile", type: TrackType.View) {}
        "/settings/about"(platform: "/mobile", type: TrackType.View, business: "mercadopago") {}
    }

    test("Choose Country settings") {
        "/settings/country"(platform: "/mobile", type: TrackType.View) {}
        "/settings/country"(platform: "/mobile", type: TrackType.View, business: "mercadopago") {}
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
        "/devices/websec/deeplinks_data"(platform:"/mobile/android", business: "mercadopago") {
            from = "com.mercadolibre.android"
            destination = "MainActivity"
            scheme = "meli"
            encodedUri = "mercadolibre.com"
            segments = "webkit"
            query = "url=https://www.mercadolibre.com.ar/"
        }
    }

    test("MercadoPago wallet apprater") {

        "/apprater/add_track"(platform: "/mobile") {
            type_track="CRASHED"
        }
        "/apprater/add_track"(platform: "/mobile", business: "mercadopago") {
            type_track="CRASHED"
        }
        "/apprater/add_track"(platform: "/mobile") {
            type_track="PAYMENT_APPROVED"
        }
        "/apprater/add_track"(platform: "/mobile", business: "mercadopago") {
            type_track="PAYMENT_APPROVED"
        }
        "/apprater/add_track"(platform: "/mobile") {
            type_track="WITHDRAW"
        }
        "/apprater/add_track"(platform: "/mobile", business: "mercadopago") {
            type_track="WITHDRAW"
        }
        "/apprater/error_service_rules"(platform: "/mobile") {}
        "/apprater/error_service_rules"(platform: "/mobile", business: "mercadopago") {}
        "/apprater/popup"(platform: "/mobile") {}
        "/apprater/popup"(platform: "/mobile", business: "mercadopago") {}
        "/apprater/accept"(platform: "/mobile") {}
        "/apprater/accept"(platform: "/mobile", business: "mercadopago") {}
        "/apprater/cancel"(platform: "/mobile") {}
        "/apprater/cancel"(platform: "/mobile", business: "mercadopago") {}
        "/apprater/remind_me_later"(platform: "/mobile") {}
        "/apprater/remind_me_later"(platform: "/mobile", business: "mercadopago") {}
    }

    test("MercadoLibre apprater") {
        "/apprater/popup"(platform: "/mobile") {}
        "/apprater/accept"(platform: "/mobile") {}
        "/apprater/remind_me_later"(platform: "/mobile") {}
    } 

    test("Landing Deeplinks in Mobile") {
        "/landing/deeplinks"(platform:"/mobile") {
            desired_link = "https://www.mercadolibre.com.ar/mercado-puntos"
            target_link = "meli://loyalty"
            message = "Could not parse Target Link"
        }
        "/landing/deeplinks"(platform:"/mobile", business: "mercadopago") {
            desired_link = "https://www.mercadolibre.com.ar/mercado-puntos"
            target_link = "meli://loyalty"
            message = "Could not parse Target Link"
        }
    }

}
