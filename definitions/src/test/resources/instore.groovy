import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Instore") {

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Instore Meli
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        // Error
        "/instore/generic_error"(platform: "/mobile", type: TrackType.View) {
            additional_info = {
                message = "Escanear código QR"
                icon = "error"
                description = "Solo puedes pagar usando códigos de Mercado Pago"
                message = "¿Estas seguro que ese código es para pagar?"
                actions = [{
                               id = "try_again"
                               link = "meli://mp/scan_qr"
                               label = "Intentar nuevamente"
                               type = "link"
                           }]
            }
        }

        // Scan QR
        "/instore/scan_qr"(platform: "/mobile", type: TrackType.View) {
            camera_permissions = true
            location_permissions = true
            notifications_permissions = true
        }
        "/instore/scan_qr/qr_discovery"(platform: "/mobile", type: TrackType.Event) {
            qr_data = "Any scanned data"
            qr_discovery_time_in_millis = "323223"
            camera_flash = false
        }
        "/instore/scan_qr/qr_resolved"(platform: "/mobile", type: TrackType.Event) {
            qr_data = "Any scanned data"
            qr_discovery_time_in_millis = "323223"
            qr_server_time_in_millis = "123443"
            camera_flash = false
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            success = true
            next_step_deeplink = "Any deeplink"
        }
        "/instore/scan_qr/abort"(platform: "/mobile", type: TrackType.Event) {
            view_time_in_millis = "453282"
            camera_flash = false
        }
        "/instore/scan_qr/back"(platform: "/mobile", type: TrackType.Event) {
            view_time_in_millis = "125638"
            camera_flash = false
        }
        "/instore/scan_qr/flash"(platform: "/mobile", type: TrackType.Event) {
            camera_flash = false
        }
        // Permissions
        "/ask_device_permission/bluetooth"(platform: "/mobile", type: TrackType.View) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/ask_device_permission/bluetooth/back"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/ask_device_permission/bluetooth/granted"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/ask_device_permission/bluetooth/rejected"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/ask_device_permission/camera"(platform: "/mobile", type: TrackType.View) {
            context = "/instore"
        }
        "/ask_device_permission/camera/back"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
        }
        "/ask_device_permission/camera/granted"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
        }
        "/ask_device_permission/camera/rejected"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
        }
        "/ask_device_permission/location"(platform: "/mobile", type: TrackType.View) {
            context = "/instore"
        }
        "/ask_device_permission/location/back"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
        }
        "/ask_device_permission/location/granted"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
        }
        "/ask_device_permission/location/rejected"(platform: "/mobile", type: TrackType.Event) {
            context = "/instore"
        }

        // Error
        "/instore/error/unrecognized_qr_code"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/unrecognized_qr_code/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/unrecognized_qr_code/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/something_went_wrong"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/something_went_wrong/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/something_went_wrong/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/something_went_wrong/retry"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/gas_station_cant_process_qr_payment"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/gas_station_cant_process_qr_payment/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/gas_station_cant_process_qr_payment/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/cant_pay_to_yourself"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/cant_pay_to_yourself/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/cant_pay_to_yourself/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/payment_timeout"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/payment_timeout/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/payment_timeout/abort"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }

        // Amount
        "/instore/amount/price_list"(platform: "/mobile", type: TrackType.View) {}
        "/instore/amount/price_list/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/amount/calculator"(platform: "/mobile", type: TrackType.View) {}
        "/instore/amount/calculator/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }

        // Required action
        "/instore/data_required/identification_number"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            data_key = "Any scanned data"
        }
        "/instore/data_required/identification_number/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            data_key = "Any scanned data"
        }

        // FTU
        "/instore/qr_first_time_use"(platform: "/mobile", type: TrackType.View) {}
        "/instore/qr_first_time_use/next"(platform: "/mobile", type: TrackType.Event) {
            view_time_in_millis = "134231"
        }
        "/instore/qr_first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {
            view_time_in_millis = "134231"
        }
        "/instore/shell_first_time_use"(platform: "/mobile", type: TrackType.View) {}
        "/instore/shell_first_time_use/next"(platform: "/mobile", type: TrackType.Event) {
            view_time_in_millis = "134231"
        }
        "/instore/shell_first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {
            view_time_in_millis = "134231"
        }

        // Shell
        "/instore/shell/pump_code"(platform: "/mobile", type: TrackType.View) {}
        "/instore/shell/pump_code_check"(platform: "/mobile", type: TrackType.Event) {
            pump_code = "13423"
            latitude = "16826323"
            longitude = "1826323"
        }
        "/instore/shell/pump_code_resolved"(platform: "/mobile", type: TrackType.Event) {
            pump_code = "13423"
            success = true
            next_step = "Any deeplink"
        }

        // Waiting
        "/instore/waiting/gas_jockey"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_jockey/next"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_jockey/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_pump"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_pump/next"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_pump/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_clock"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_clock/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gastronomy_cashier"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gastronomy_cashier/next"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gastronomy_cashier/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gastronomy_order"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gastronomy_order/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/generic_cashier"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/generic_cashier/next"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/generic_cashier/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/generic_ticket"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/generic_ticket/back"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }

        // Vending
        "/instore/waiting/vending_product_selection"(platform: "/mobile", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/vending/st_machine_disconnected"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/vending/machine_response_final_result"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            machine_response_final_result = "Any machine response"
        }
        "/instore/vending/st_machine_connection_error"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            st_machine_connection_error = "Any machine error"
        }
        "/instore/vending/machine_response_state"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            machine_response_state = "Any response state"
        }
        "/instore/vending/st_machine_not_available"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/vending/st_machine_connected"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/vending/response_end_transaction"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            response_end_transaction = "Transaction response"
        }
        "/instore/vending/response_payment"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            response_payment = "Payment response"
        }

        "/instore/post_payment"(platform: "/mobile", type: TrackType.Event) {
            currency_id = "ARS"
            statement_descriptor = "WWW.MERCADOPAGO.COM"
            collector_id = 244110353
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
            shipping_amount = 0
            coupon_id = 43427906
            captured = true
            fee_details = [
                    {
                        amount = 40.6
                        fee_payer = "collector"
                        type = "mercadopago_fee"
                    }
            ]
            date_last_updated = "2018-11-24T21:00:16.000-04:00"
            api_version = "2"
            money_release_days = 0
            order = {
                id = 909650158
                type = mercadopago
            }
            external_reference = "nicaragua2"
            transaction_amount = 560
            description = "Producto de Williamsburg"
            transaction_details = {
                total_paid_amount = 460
                payable_deferral_period = 0
                installment_amount = 460
                overpaid_amount = 0
            }
            client_id = "1945000207238192"
            site_id = "MLA"
            operation_type = "regular_payment"
            binary_mode = true
            transaction_id = "8652928979_777b7f7e776373697b3c"
            installments = 1
            money_release_date = "2018-11-24T21:00:16.000-04:00"
            internal_metadata = {
                subtype = "store"
                app_version = "2.50.0.4"
                pos_id = "nicaragua2"
                type = "qr"
            }
            transaction_amount_refunded = 0
            payment_type_id = "credit_card"
        }
        "/instore/payment_info"(platform: "/mobile", type: TrackType.Event) {
            payment_info_tag = "Execute post payment"
        }

        //Deprecated
        "/instore/scan_qr/read"(platform: "/mobile", type: TrackType.Event) {
            data = "Any scanned data"
        }
        "/instore/camera_permission"(platform: "/mobile", type: TrackType.View) {}
        "/instore/permission/location"(platform: "/mobile", type: TrackType.View) {}
        "/instore/map"(platform: "/mobile", type: TrackType.View) {}
        "/instore/required_action/bluetooth_on"(platform: "/mobile", type: TrackType.View) {}
        "/instore/map"(platform: "/mobile", type: TrackType.View) {}
        "/instore/scan_qr/ftu"(platform: "/mobile", type: TrackType.View) {}
        "/instore/manual_price"(platform: "/mobile", type: TrackType.View) {}
        // Error
        "/instore/generic_error"(platform: "/mobile", type: TrackType.View) {
            additional_info = {
                message = "Escanear código QR"
                icon = "error"
                description = "Solo puedes pagar usando códigos de Mercado Pago"
                message = "¿Estas seguro que ese código es para pagar?"
                actions = [{
                               id = "try_again"
                               link = "meli://mp/scan_qr"
                               label = "Intentar nuevamente"
                               type = "link"
                           }]
            }
        }
        "/instore/activity/list"(platform: "/mobile", type: TrackType.View) {}
        "/instore/vending/select_product"(platform: "/mobile", type: TrackType.View) {}
        "/instore/required_action/data_required"(platform: "/mobile", type: TrackType.View) {}
        "/instore/required_action/data_required/dni"(platform: "/mobile", type: TrackType.View) {}
        "/instore/required_action/bluetooth_permission"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/gas_jockey"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/gas_pump"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/gas_clock"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/gastronomy_cashier"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/gastronomy_order"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/generic_cashier"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/generic_ticket"(platform: "/mobile", type: TrackType.View) {}
        "/instore/gas_station_shell"(platform: "/mobile", type: TrackType.View) {}
        "/instore/shell_first_time_use"(platform: "/mobile", type: TrackType.View) {}
        "/instore/price_picker"(platform: "/mobile", type: TrackType.View) {}
        // Deprecated PX
        "/instore/checkout/card/number"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card/installments"(platform: "/mobile", type: TrackType.View) {
            payment_method = "amex"
        }
        "/instore/checkout/security_code_card"(platform: "/mobile", type: TrackType.View) {
            security_code_view_reason = "saved_card"
        }
        "/instore/checkout/congrats/business"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/congrats/rejected"(platform: "/mobile", type: TrackType.View) {
            issuer ="24"
            payment_id  = "4318458695"
            is_express = "false"
            payment_method = "master"
            payment_status = "rejected"
            payment_status_detail = "cc_rejected_high_risk"
        }
        "/instore/checkout/card/credit_card/security_code"(platform: "/mobile", type: TrackType.View) {
            security_code_view_reason = "saved_card"
        }
        "/instore/checkout/card/debit_card/security_code"(platform: "/mobile", type: TrackType.View) {
            security_code_view_reason = "saved_card"
        }
        "/instore/checkout/card_expiry_date"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card_holder_name"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card_installments"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card_number"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card_security_code"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card_vault credit_card"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card_vault debit_card"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/identification_number"(platform: "/mobile", type: TrackType.View) {
            payment_method =  "visa"
            payment_type = "credit_card"
        }
        "/instore/checkout/installments"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/payment_method_search"(platform: "/mobile", type: TrackType.View) {
            options = "visa:credit_card|master:credit_card|amex:credit_card|mercadopago_cc:credit_card" +
                    "|naranja:credit_card|nativa:credit_card|cabal:credit_card|tarshop:credit_card" +
                    "|cencosud:credit_card|diners:credit_card|argencard:credit_card|maestro:debit_card" +
                    "|debmaster:debit_card|debcabal:debit_card|debvisa:debit_card|cordial:credit_card" +
                    "|cordobesa:credit_card|cmr:credit_card|debvisa:debit_card:7775245748:ESC" +
                    "|visa:credit_card:8237344527"
        }
        "/instore/checkout/payment_option"(platform: "/mobile", type: TrackType.View) {
            options = "visa:credit_card|master:credit_card|amex:credit_card|mercadopago_cc:credit_card" +
                    "|naranja:credit_card|nativa:credit_card|cabal:credit_card|tarshop:credit_card" +
                    "|cencosud:credit_card|diners:credit_card|argencard:credit_card|maestro:debit_card" +
                    "|debmaster:debit_card|debcabal:debit_card|debvisa:debit_card|cordial:credit_card" +
                    "|cordobesa:credit_card|cmr:credit_card|debvisa:debit_card:7775245748:ESC" +
                    "|visa:credit_card:8237344527"
        }
        "/instore/checkout/result"(platform: "/mobile", type: TrackType.View) {
            issuer = "24"
            payment_id = "4319318405"
            is_express = "false"
            payment_method = "master"
            payment_type = "credit_card"
            payment_status_detail = "cc_rejected_plugin_pm"
            payment_status = "rejected"
        }
        "/instore/checkout/review"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/review_and_confirm"(platform: "/mobile", type: TrackType.View) {
            issuer = "0"
            has_shipping = "false"
            payment_method = "account_money"
            payment_type = "payment_method_plugin"
        }
        "/instore/checkout/payment_option/cards"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/error_view"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/number"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card/credit_card/number"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card/credit_card/name"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card/credit_card/expiration"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card/credit_card/cvv"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/name"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/expiration"(platform: "/mobile", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/cvv"(platform: "/mobile", type: TrackType.View) {}

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Mercado Pago
        //------------------------------------------------------------------------------------------------------------------------------------------------------


        // Scan QR
        "/instore/scan_qr"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/scan_qr/qr_discovery"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            qr_data = "Any scanned data"
            qr_discovery_time_in_millis = "323223"
            camera_flash = false
        }
        "/instore/scan_qr/qr_resolved"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            qr_data = "Any scanned data"
            qr_discovery_time_in_millis = "323223"
            qr_server_time_in_millis = "123443"
            camera_flash = false
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            success = true
            next_step_deeplink = "Any deeplink"
        }
        "/instore/scan_qr/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            view_time_in_millis = "453282"
            camera_flash = false
        }
        "/instore/scan_qr/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            view_time_in_millis = "125638"
            camera_flash = false
        }
        "/instore/scan_qr/flash"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            camera_flash = false
        }
        // Permissions
        "/ask_device_permission/bluetooth"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/ask_device_permission/bluetooth/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/ask_device_permission/bluetooth/granted"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/ask_device_permission/bluetooth/rejected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/ask_device_permission/bluetooth/rejected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/ask_device_permission/camera"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            context = "/instore"
        }
        "/ask_device_permission/camera/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
        }
        "/ask_device_permission/camera/granted"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
        }
        "/ask_device_permission/camera/rejected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
        }
        "/ask_device_permission/location"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            context = "/instore"
        }
        "/ask_device_permission/location/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
        }
        "/ask_device_permission/location/granted"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
        }
        "/ask_device_permission/location/rejected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            context = "/instore"
        }

        // Amount
        "/instore/amount/price_list"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/amount/price_list/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/amount/calculator"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/amount/calculator/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }

        // Required action
        "/instore/data_required/identification_number"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            data_key = "Any data key"
            qr_data = "Any scanned data"
        }
        "/instore/data_required/identification_number/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            data_key = "Any data key"
            qr_data = "Any scanned data"
        }

        // Error
        "/instore/error/unrecognized_qr_code"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/unrecognized_qr_code/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/unrecognized_qr_code/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/something_went_wrong"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/something_went_wrong/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/something_went_wrong/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/something_went_wrong/retry"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/gas_station_cant_process_qr_payment"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/gas_station_cant_process_qr_payment/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/gas_station_cant_process_qr_payment/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/cant_pay_to_yourself"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/cant_pay_to_yourself/back"(platform: "/mobile", business:"mercadopago",  type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/cant_pay_to_yourself/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/payment_timeout"(platform: "/mobile", business:"mercadopago",  type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/payment_timeout/back"(platform: "/mobile", business:"mercadopago",  type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }
        "/instore/error/payment_timeout/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            qr_data = "Any scanned data"
        }

        // FTU
        "/instore/qr_first_time_use"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/qr_first_time_use/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            view_time_in_millis = "134231"
        }
        "/instore/qr_first_time_use/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            view_time_in_millis = "134231"
        }
        "/instore/shell_first_time_use"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/shell_first_time_use/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            view_time_in_millis = "134231"
        }
        "/instore/shell_first_time_use/abort"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            view_time_in_millis = "134231"
        }

        // Shell
        "/instore/shell/pump_code"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/shell/pump_code_check"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            pump_code = "13423"
            latitude = "16826323"
            longitude = "1826323"
        }
        "/instore/shell/pump_code_resolved"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            pump_code = "13423"
            success = true
            next_step = "Any deeplink"
        }

        // Vending
        "/instore/waiting/vending_product_selection"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/vending/st_machine_disconnected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/vending/machine_response_final_result"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            machine_response_final_result = "Any machine response"
        }
        "/instore/vending/st_machine_connection_error"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            st_machine_connection_error = "Any machine error"
        }
        "/instore/vending/machine_response_state"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            machine_response_state = "Any response state"
        }
        "/instore/vending/st_machine_not_available"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/vending/st_machine_connected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/vending/response_end_transaction"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            response_end_transaction = "Transaction response"
        }
        "/instore/vending/response_payment"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            response_payment = "Payment response"
        }

        // Waiting
        "/instore/waiting/gas_jockey"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_jockey/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_jockey/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_pump"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_pump/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_pump/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_clock"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gas_clock/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gastronomy_cashier"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gastronomy_cashier/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gastronomy_cashier/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gastronomy_order"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/gastronomy_order/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/generic_cashier"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/generic_cashier/next"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/generic_cashier/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/generic_ticket"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }
        "/instore/waiting/generic_ticket/back"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
        }

        "/instore/post_payment"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
                currency_id = "ARS"
                statement_descriptor = "WWW.MERCADOPAGO.COM"
                collector_id = 244110353
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
                shipping_amount = 0
                coupon_id = 43427906
                captured = true
                fee_details = [
                        {
                            amount = 40.6
                            fee_payer = "collector"
                            type = "mercadopago_fee"
                        }
                ]
                date_last_updated = "2018-11-24T21:00:16.000-04:00"
                api_version = "2"
                money_release_days = 0
                order = {
                    id = 909650158
                    type = mercadopago
                }
                external_reference = "nicaragua2"
                transaction_amount = 560
                description = "Producto de Williamsburg"
                transaction_details = {
                    total_paid_amount = 460
                    payable_deferral_period = 0
                    installment_amount = 460
                    overpaid_amount = 0
                }
                client_id = "1945000207238192"
                site_id = "MLA"
                operation_type = "regular_payment"
                binary_mode = true
                transaction_id = "8652928979_777b7f7e776373697b3c"
                installments = 1
                money_release_date = "2018-11-24T21:00:16.000-04:00"
                internal_metadata = {
                    subtype = "store"
                    app_version = "2.50.0.4"
                    pos_id = "nicaragua2"
                    type = "qr"
                }
                transaction_amount_refunded = 0
                payment_type_id = "credit_card"
        }

        "/instore/post_payment"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            raw = {
                statement_descriptor = "WWW.MERCADOPAGO.COM"
                shipping_amount = 0
                coupon_id = 43427906
                captured = true
                fee_details = [
                        {
                            amount = 40.6
                            fee_payer = "collector"
                            type = "mercadopago_fee"
                        }
                ]
                date_created = "2018-11-24T21:00:13.000-04:00"
                date_last_updated = "2018-11-24T21:00:16.000-04:00"
                api_version = "2"
                id = 4315374212
                collector = {
                    id = 350075398
                    phone = {
                        area_code = "011"
                        number = "47842600"
                    }
                    identification = {
                        number = "30716032384"
                        type = "Otro"
                    }
                }
                payer_id = 89648396
                issuer_id = 338
                money_release_days = 0
                order = {
                    id = 909650158
                    type = mercadopago
                }
                external_reference = "nicaragua2"
                transaction_amount = 560
                description = "Producto de Williamsburg"
                transaction_details = {
                    total_paid_amount = 460
                    payable_deferral_period = 0
                    installment_amount = 460
                    overpaid_amount = 0
                }
                coupon_amount = 100
                client_id = "1945000207238192"
                marketplace = "NONE"
                currency_id = "ARS"
                collector_id = 350075398
                status = "approved"
                payment_method_id = "visa"
                site_id = "MLA"
                status_detail = "accredited"
                operation_type = "regular_payment"
                binary_mode = true
                transaction_id = "8652928979_777b7f7e776373697b3c"
                installments = 1
                money_release_date = "2018-11-24T21:00:16.000-04:00"
                internal_metadata = {
                    subtype = "store"
                    app_version = "2.50.0.4"
                    pos_id = "nicaragua2"
                    type = "qr"
                }
                payer = {
                    id : 89648396
                    phone = {
                        area_code = "011"
                        number = "47842600"
                    }
                    identification = {
                        number = "27258766"
                        type = "DNI"
                    }
                }
                transaction_amount_refunded = 0
                payment_type_id = "credit_card"
            }
        }

        "/instore/payment_info"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            payment_info_tag = "Execute post payment"
        }

        // Deprecated
        "/instore/scan_qr/read"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            data = "Any scanned data"
        }
        "/instore/generic_error"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            additional_info = {
                message = "Escanear código QR"
                icon = "error"
                description = "Solo puedes pagar usando códigos de Mercado Pago"
                message = "¿Estas seguro que ese código es para pagar?"
                actions = [{
                               id = "try_again"
                               link = "meli://mp/scan_qr"
                               label = "Intentar nuevamente"
                               type = "link"
                           }]
            }
        }
        "/instore/gas_station_shell"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/shell_first_time_use"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/vending/select_product"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/gas_jockey"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/gas_pump"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/gas_clock"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/gastronomy_cashier"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/gastronomy_order"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/generic_cashier"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/generic_ticket"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/camera_permission"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/permission/location"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/map"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/required_action/bluetooth_on"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/map"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/scan_qr/ftu"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/manual_price"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/activity/list"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/required_action/data_required"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/required_action/data_required/dni"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/required_action/bluetooth_permission"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/price_picker"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        // Deprecated PX
        "/instore/checkout/card/installments"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            payment_method = "amex"
        }
        "/instore/checkout/security_code_card"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            security_code_view_reason = "saved_card"
        }
        "/instore/checkout/congrats/business"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/congrats/rejected"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            issuer ="24"
            payment_id  = "4318458695"
            is_express = "false"
            payment_method = "master"
            payment_status = "rejected"
            payment_status_detail = "cc_rejected_high_risk"
        }
        "/instore/checkout/card/credit_card/security_code"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            security_code_view_reason = "saved_card"
        }
        "/instore/checkout/card/debit_card/security_code"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            security_code_view_reason = "saved_card"
        }
        "/instore/checkout/card_expiry_date"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card_holder_name"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card_installments"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card_number"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card_security_code"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card_vault credit_card"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card_vault debit_card"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/identification_number"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            payment_method =  "visa"
            payment_type = "credit_card"
        }
        "/instore/checkout/installments"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/payment_method_search"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            options = "visa:credit_card|master:credit_card|amex:credit_card|mercadopago_cc:credit_card" +
                    "|naranja:credit_card|nativa:credit_card|cabal:credit_card|tarshop:credit_card" +
                    "|cencosud:credit_card|diners:credit_card|argencard:credit_card|maestro:debit_card" +
                    "|debmaster:debit_card|debcabal:debit_card|debvisa:debit_card|cordial:credit_card" +
                    "|cordobesa:credit_card|cmr:credit_card|debvisa:debit_card:7775245748:ESC" +
                    "|visa:credit_card:8237344527"
        }
        "/instore/checkout/payment_option"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            options = "visa:credit_card|master:credit_card|amex:credit_card|mercadopago_cc:credit_card" +
                    "|naranja:credit_card|nativa:credit_card|cabal:credit_card|tarshop:credit_card" +
                    "|cencosud:credit_card|diners:credit_card|argencard:credit_card|maestro:debit_card" +
                    "|debmaster:debit_card|debcabal:debit_card|debvisa:debit_card|cordial:credit_card" +
                    "|cordobesa:credit_card|cmr:credit_card|debvisa:debit_card:7775245748:ESC" +
                    "|visa:credit_card:8237344527"
        }
        "/instore/checkout/result"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            issuer = "24"
            payment_id = "4319318405"
            is_express = "false"
            payment_method = "master"
            payment_type = "credit_card"
            payment_status_detail = "cc_rejected_plugin_pm"
            payment_status = "rejected"
        }
        "/instore/checkout/card/number"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/review"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/review_and_confirm"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            issuer = "0"
            has_shipping = "false"
            payment_method = "account_money"
            payment_type = "payment_method_plugin"
        }
        "/instore/checkout/payment_option/cards"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/error_view"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/number"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/credit_card/number"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/credit_card/name"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/credit_card/expiration"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/credit_card/cvv"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/name"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/expiration"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/cvv"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
    }

}
