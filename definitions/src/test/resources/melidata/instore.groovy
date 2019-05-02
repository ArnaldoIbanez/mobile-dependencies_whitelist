package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Instore") {

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Instore Meli
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        // Scan QR
        "/instore/scan_qr"(platform: "/mobile", type: TrackType.View) {
            camera_permissions = true
            location_permissions = true
            notification_permissions = true
            bluetooth_permissions = true
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            new_session = true
        }
        "/instore/scan_qr/qr_discovery"(platform: "/mobile", type: TrackType.Event) {
            qr_data = "Any scanned data"
            camera_flash = false
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/scan_qr/qr_resolved"(platform: "/mobile", type: TrackType.Event) {
            qr_data = "Any scanned data"
            camera_flash = false
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            success = true
            next_step_deeplink = "Any deeplink"
            currency = "ARS"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            status_code = 403
        }
        "/instore/scan_qr/abort"(platform: "/mobile", type: TrackType.Event) {
            view_time_in_millis = "453282"
            camera_flash = false
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/scan_qr/back"(platform: "/mobile", type: TrackType.Event) {
            view_time_in_millis = "125638"
            camera_flash = false
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/scan_qr/flash"(platform: "/mobile", type: TrackType.Event) {
            camera_flash = false
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
		"/instore/scan_qr/help"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        // Permissions
        "/ask_device_permission/bluetooth"(platform: "/mobile", type: TrackType.View) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/bluetooth/back"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/bluetooth/granted"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/bluetooth/rejected"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/camera"(platform: "/mobile", type: TrackType.View) {
            context = "/instore"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/camera/back"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/camera/granted"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/camera/rejected"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/location"(platform: "/mobile", type: TrackType.View) {
            session_id = "wi234nuHSd83h478"
            context = "/instore/map"
            location_permission_enabled = true
            device_gps_enabled = true
            type = "qr"
            tags = "shell"
        }
        "/ask_device_permission/location/back"(platform: "/mobile", type: TrackType.Event) {
            session_id = "wi234nuHSd83h478"
            context = "/instore/map"
        }
        "/ask_device_permission/location/granted"(platform: "/mobile", type: TrackType.Event) {
            session_id = "wi234nuHSd83h478"
            context = "/instore/map"
        }
        "/ask_device_permission/location/rejected"(platform: "/mobile", type: TrackType.Event) {
            session_id = "wi234nuHSd83h478"
            context = "/instore/map"
        }

        // Error
        "/instore/error/unrecognized_qr_code"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/unrecognized_qr_code/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/unrecognized_qr_code/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/something_went_wrong"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/something_went_wrong/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/something_went_wrong/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/something_went_wrong/retry"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/gas_station_cant_process_qr_payment"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/gas_station_cant_process_qr_payment/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/gas_station_cant_process_qr_payment/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_to_yourself"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_to_yourself/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_to_yourself/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_to_yourself/retry"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/payment_timeout"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/payment_timeout/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/payment_timeout/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_in_different_sites"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_in_different_sites/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_in_different_sites/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Amount
        "/instore/amount/price_list"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/amount/price_list/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/amount/calculator"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/amount/calculator/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Required action
        "/instore/data_required/identification_number"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            data_key = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/data_required/identification_number/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            data_key = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Landing
        "/instore/qr_first_time_use"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/qr_first_time_use/next"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/qr_first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell_first_time_use"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell_first_time_use/next"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell_first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell_first_time_use/back"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/qr_first_time_use/back"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/landing"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/landing/next"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/landing/abort"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/landing/back"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }


        // Shell
        "/instore/shell/pump_code"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell/pump_code_check"(platform: "/mobile", type: TrackType.Event) {
            pump_code = "13423"
            latitude = "16826323"
            longitude = "1826323"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell/pump_code_resolved"(platform: "/mobile", type: TrackType.Event) {
            pump_code = "13423"
            success = true
            next_step = "Any deeplink"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell/pump_code/abort"(platform: "/mobile", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Waiting
        "/instore/waiting/gas_jockey"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_jockey/next"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_jockey/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_pump"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_pump/next"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_pump/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_clock"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_clock/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_cashier"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_cashier/next"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_cashier/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_order"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_order/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_cashier"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_cashier/next"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_cashier/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_ticket"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_ticket/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Vending
        "/instore/waiting/vending_product_selection"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/vending/st_machine_disconnected"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/machine_response_final_result"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/st_machine_connection_error"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            st_machine_connection_error = "Any machine error"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/machine_response_state"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            machine_response_state = "available"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/st_machine_not_available"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/st_machine_connected"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/response_end_transaction"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
            end_transaction_status = "success"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
            item_price = 130
        }
        "/instore/post_payment"(platform: "/mobile", type: TrackType.Event) {
            currency_id = "ARS"
            statement_descriptor = "WWW.MERCADOPAGO.COM"
            collector_id = "244110353"
            status = "approved"
            payment_method_id = "visa"
            site_id = "MLA"
            date_created = "2018-11-25T00:10:26.000-0300"
            status_detail = "accredited"
            operation_type = "regular_payment"
            installments = 1
            id = 4315937273
            payer_id = 79063514
            collector = {
                id = 244110353
                identification = {
                    number = "34214555"
                    type : "DNI"
                }
            }
            issuer_id = 310
            payer = {
                id = 79063514
                identification = {
                    number = "30114956"
                    type = "DNI"
                }
            }
            transaction_amount = 130
            coupon_amount = 0
            marketplace = "NONE"
            external_reference = "nicaragua2"
            transaction_amount = 560
            site_id = "MLA"
            operation_type = "regular_payment"
            installments = 1
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            pos_id = "9355"
            store_id = "12964038"
        }

        "/instore/payment_info"(platform: "/mobile", type: TrackType.Event) {
            payment_info_tag = "Execute post payment"
            remaining_attempts = 2
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        //Deprecated
        "/instore/waiting"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_jockey"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_pump"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_clock"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_cashier"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_order"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_cashier"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_ticket"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell_first_time_use"(platform: "/mobile", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        "/instore/map"(platform: "/mobile", type: TrackType.View) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            location = "-34.612112,-58.366109"
            radius_in_meters = 1000
            type = "qr"
            tags = "shell"
        }
        "/instore/map/first_user_location"(platform: "/mobile", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            northeast = "-34.5442707,-58.5001586,15"
            southwest = "-34.532499, -58.493422"
            location = "-34.532499, -58.493422"
        }
        "/instore/map/data_retrieved"(platform: "/mobile", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            action_type = "init"
            stores_quantity = "5"
        }
        "/instore/map/pin_selected"(platform: "/mobile", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            store_name = "shell"
            store_id = "2373810"
            store_location = "-34.532499, -58.493422"
        }
        "/instore/map/search_in_this_area"(platform: "/mobile", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            includes_user_position = true
            center = "20.323595,-95.951633"
            northeast = "24.207090,-92.486475"
            southwest = "16.440100,-99.416791"
            tags = "shell"
        }
        "/instore/map/locate_by_gps"(platform: "/mobile", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
        }
        "/instore/map/back"(platform: "/mobile", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            view_time_in_millis = "14519"
        }
        "/instore/map/navigate_to_store"(platform: "/mobile", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            store_name = "Burger King"
            store_location = "-32.895112, -68.840782"
            navigation_apps = "Maps, Waze"
        }
        "/instore/map/navigate_to_store_app_chosen"(platform: "/mobile", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            store_name = "Burger King"
            store_location = "-32.895112, -68.840782"
            navigation_apps = "maps, waze"
            chosen_app = "waze"
            view_time_in_millis = "4508"
        }
        "/instore/map/quick_filters_selected"(platform: "/mobile", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            selected_filters = ["combustibles", "mercados", "gastronomia"]
        }

        "/instore/map/error/server_error"(platform: "/mobile", type: TrackType.View) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            style = "screen"
            id = "operation_error"
            message = "server error"
            attributable_to = "server"
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Mercado Pago
        //------------------------------------------------------------------------------------------------------------------------------------------------------


        // Scan QR
        "/instore/scan_qr"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            camera_permissions = true
            location_permissions = true
            notification_permissions = true
            bluetooth_permissions = true
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            new_session = true
        }
        
        "/instore/scan_qr/qr_discovery"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            qr_data = "Any scanned data"
            camera_flash = false
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/scan_qr/qr_resolved"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            qr_data = "Any scanned data"
            camera_flash = false
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            success = true
            next_step_deeplink = "Any deeplink"
            currency = "ARS"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            status_code = 403
        }
        "/instore/scan_qr/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            view_time_in_millis = "453282"
            camera_flash = false
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/scan_qr/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            view_time_in_millis = "125638"
            camera_flash = false
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/scan_qr/flash"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            camera_flash = false
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
		"/instore/scan_qr/help"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
		// Permissions
        "/ask_device_permission/bluetooth"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/bluetooth/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/bluetooth/granted"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/bluetooth/rejected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/bluetooth/rejected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/camera"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            context = "/instore"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/camera/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/camera/granted"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/camera/rejected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/ask_device_permission/location"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "wi234nuHSd83h478"
            context = "/instore/map"
            location_permission_enabled = true
            device_gps_enabled = true
            type = "qr"
            tags = "shell"
        }
        "/ask_device_permission/location/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "wi234nuHSd83h478"
            context = "/instore"
        }
        "/ask_device_permission/location/granted"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "wi234nuHSd83h478"
            context = "/instore"
        }
        "/ask_device_permission/location/rejected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "wi234nuHSd83h478"
            context = "/instore"
        }

        // Amount
        "/instore/amount/price_list"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/amount/price_list/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/amount/calculator"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/amount/calculator/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Required action
        "/instore/data_required/identification_number"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            data_key = "Any data key"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/data_required/identification_number/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            data_key = "Any data key"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Error
        "/instore/error/unrecognized_qr_code"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/unrecognized_qr_code/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/unrecognized_qr_code/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/something_went_wrong"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/something_went_wrong/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/something_went_wrong/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/something_went_wrong/retry"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/gas_station_cant_process_qr_payment"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/gas_station_cant_process_qr_payment/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/gas_station_cant_process_qr_payment/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_to_yourself"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_to_yourself/back"(platform: "/mobile", business:"mercadopago",  type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_to_yourself/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_to_yourself/retry"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/payment_timeout"(platform: "/mobile", business:"mercadopago",  type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/payment_timeout/back"(platform: "/mobile", business:"mercadopago",  type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/payment_timeout/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_in_different_sites"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_in_different_sites/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/error/cant_pay_in_different_sites/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Landing
        "/instore/qr_first_time_use"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/qr_first_time_use/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/qr_first_time_use/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell_first_time_use"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell_first_time_use/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell_first_time_use/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell_first_time_use/back"(platform: "/mobile", business:"mercadopago",type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/qr_first_time_use/back"(platform: "/mobile", business:"mercadopago",type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/landing"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
       "/instore/landing/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
           session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
       }
        "/instore/landing/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/landing/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Shell
        "/instore/shell/pump_code"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell/pump_code_check"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            pump_code = "13423"
            latitude = "16826323"
            longitude = "1826323"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell/pump_code_resolved"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            pump_code = "13423"
            success = true
            next_step = "Any deeplink"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/shell/pump_code/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Vending
        "/instore/waiting/vending_product_selection"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/vending/st_machine_disconnected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/machine_response_final_result"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/st_machine_connection_error"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            st_machine_connection_error = "Any machine error"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/machine_response_state"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            machine_response_state = "available"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/st_machine_not_available"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/st_machine_connected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
        }
        "/instore/vending/response_end_transaction"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
            end_transaction_status = "success"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
            external_reference = "nicaragua2"
            id = 4315937273
            status = "approved"
            status_detail = "accredited"
            item_price = 130
        }

        // Waiting
        "/instore/waiting/gas_jockey"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_jockey/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_jockey/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_pump"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_pump/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_pump/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_clock"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_clock/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_cashier"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_cashier/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_cashier/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_order"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_order/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_cashier"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_cashier/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_cashier/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_ticket"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_ticket/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        "/instore/post_payment"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
                currency_id = "ARS"
                statement_descriptor = "WWW.MERCADOPAGO.COM"
                collector_id = "244110353"
                status = "approved"
                payment_method_id = "visa"
                site_id = "MLA"
                date_created = "2018-11-25T00:10:26.000-0300"
                status_detail = "accredited"
                operation_type = "regular_payment"
                installments = 1
                id = 4315937273
                session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
                payer_id = 79063514
                collector = {
                    id = 244110353
                    identification = {
                        number = "34214555"
                        type : "DNI"
                    }
                }
                issuer_id = 310
                payer = {
                    id = 79063514
                    identification = {
                        number = "30114956"
                        type = "DNI"
                    }
                }
                transaction_amount = 130
                coupon_amount = 0
                marketplace = "NONE"
                external_reference = "nicaragua2"
                transaction_amount = 560
                site_id = "MLA"
                operation_type = "regular_payment"
                installments = 1
                vending_id = "12345"
                session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
                pos_id = "9355"
                store_id = "12964038"
        }

        "/instore/payment_info"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            payment_info_tag = "Execute post payment"
            remaining_attempts = 2
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        // Deprecated
        "/instore/shell_first_time_use"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_jockey"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_pump"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gas_clock"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_cashier"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/gastronomy_order"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_cashier"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }
        "/instore/waiting/generic_ticket"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            session_id = "8778E611-A48A-4CAF-9E7B-3700D1AC2692"
        }

        "/instore/map"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            location = "-34.612112,-58.366109"
            radius_in_meters = 1000
            type = "qr"
            tags = ["shell"]
        }
        "/instore/map/first_user_location"(platform: "/mobile", business: "mercadopago", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            northeast = "-34.5442707,-58.5001586,15"
            southwest = "-34.532499, -58.493422"
            location = "-34.532499, -58.493422"
        }
        "/instore/map/data_retrieved"(platform: "/mobile", business: "mercadopago", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            action_type = "init"
            stores_quantity = "5"
        }
        "/instore/map/pin_selected"(platform: "/mobile", business: "mercadopago", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            store_name = "shell"
            store_id = "2373810"
            store_location = "-34.532499, -58.493422"
        }
        "/instore/map/search_in_this_area"(platform: "/mobile", business: "mercadopago", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            includes_user_position = true
            center = "20.323595,-95.951633"
            northeast = "24.207090,-92.486475"
            southwest = "16.440100,-99.416791"
            tags = "shell"
        }
        "/instore/map/locate_by_gps"(platform: "/mobile", business:  "mercadopago", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
        }
        "/instore/map/back"(platform: "/mobile", business: "mercadopago", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            view_time_in_millis = "14519"
        }
        "/instore/map/navigate_to_store"(platform: "/mobile", business: "mercadopago",type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            store_name = "Burger King"
            store_location = "-32.895112, -68.840782"
            navigation_apps = "Maps, Waze"
        }
        "/instore/map/navigate_to_store_app_chosen"(platform: "/mobile", business: "mercadopago", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            store_name = "Burger King"
            store_location = "-32.895112, -68.840782"
            navigation_apps = ["maps", "waze"]
            chosen_app = "waze"
            view_time_in_millis = "4508"
        }
        "/instore/map/quick_filters_selected"(platform: "/mobile", business: "mercadopago", type: TrackType.Event) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            selected_filters = ["combustibles", "mercados", "gastronomia"]
        }
        "/instore/map/error/server_error"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            style = "screen"
            id = "operation_error"
            message = "server error"
            attributable_to = "server"
        }
    }

}
