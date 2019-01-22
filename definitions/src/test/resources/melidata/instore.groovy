package src.test.resources.melidata

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
            bluetooth_permissions = true
            qr_data = "Any scanned data"
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
            currency = "ARS"
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

        "/instore/qr_first_time_use/back"(platform: "/mobile", type: TrackType.Event) {
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
            vending_id = "12345"
        }
        "/instore/vending/machine_response_final_result"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            machine_response_final_result = "Any machine response"
            vending_id = "12345"
        }
        "/instore/vending/st_machine_connection_error"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            st_machine_connection_error = "Any machine error"
            vending_id = "12345"
        }
        "/instore/vending/machine_response_state"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            machine_response_state = "available"
            vending_id = "12345"
        }
        "/instore/vending/st_machine_not_available"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
        }
        "/instore/vending/st_machine_connected"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
        }
        "/instore/vending/response_end_transaction"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            response_end_transaction = "Transaction response"
            business_result = ["show_payment_method":true, "top_custom_view":[], "title":"¡Listo! Ya le pagaste a FEED", "bottom_custom_view":[], "status":"approved"]
            success = true
            vending_id = "12345"
            end_transaction_status = "success"
        }
        "/instore/vending/response_payment"(platform: "/mobile", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            response_payment = "Payment response"
            screens_info = "screen info"
            raw = ["coupon_amount":31.5, "operation_type":"regular_payment"]
            business_result = ["show_payment_method":true, "top_custom_view":[], "title":"¡Listo! Ya le pagaste a FEED", "bottom_custom_view":[], "status":"approved"]
            vending_operation_context = ["transaction_id":732941543339532, "vending_code":"GOtm10Y=", "service_uuid":"455a0001-0000-4000-4541-5a59434f494e", "connection_id":"EZ_50000131", "vending_id":"50000131", "mac":"00:1E:C0:27:77:25"]
            dispatching_time = 1000
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
            notification_url = "http://181.30.31.180:23080/gap-backend/notificaciones/notificar"
            sponsor_id = 1234567
            vending_id = "12345"
        }

        "/instore/post_payment"(platform: "/mobile", type: TrackType.Event) {
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
                notification_url = "http://181.30.31.180:23080/gap-backend/notificaciones/notificar"
                sponsor_id = 1234567
            }
        }


        "/instore/payment_info"(platform: "/mobile", type: TrackType.Event) {
            payment_info_tag = "Execute post payment"
            remaining_attempts = 2
        }

        //Deprecated
        "/instore/scan_qr/read"(platform: "/mobile", type: TrackType.Event) {
            data = "Any scanned data"
        }
        "/instore/camera_permission"(platform: "/mobile", type: TrackType.View) {}
        "/instore/permission/location"(platform: "/mobile", type: TrackType.View) {}
        "/instore/required_action/bluetooth_on"(platform: "/mobile", type: TrackType.View) {}
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

        "/instore/map"(platform: "/mobile", type: TrackType.View) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
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
            selected_filters = "combustibles, mercados, gastronomia"
        }

        "/instore/map/error/server_error"(platform: "/mobile", type: TrackType.View) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
            context = "/instore/map/error"
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
            notifications_permissions = true
            bluetooth_permissions = true            
        }
        
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
            currency = "ARS"
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

        "/instore/qr_first_time_use/back"(platform: "/mobile", business:"mercadopago",type: TrackType.Event) {
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
            vending_id = "12345"
        }
        "/instore/vending/machine_response_final_result"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            machine_response_final_result = "Any machine response"
            vending_id = "12345"
        }
        "/instore/vending/st_machine_connection_error"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            st_machine_connection_error = "Any machine error"
            vending_id = "12345"
        }
        "/instore/vending/machine_response_state"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            machine_response_state = "available"
            vending_id = "12345"
        }
        "/instore/vending/st_machine_not_available"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
        }
        "/instore/vending/st_machine_connected"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            vending_id = "12345"
        }
        "/instore/vending/response_end_transaction"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            response_end_transaction = "Transaction response"
            business_result = ["show_payment_method":true, "top_custom_view":[], "title":"¡Listo! Ya le pagaste a FEED", "bottom_custom_view":[], "status":"approved"]
            success = true
            vending_id = "12345"
            end_transaction_status = "success"
        }
        "/instore/vending/response_payment"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            collector_id = "12356"
            brand_name = "YPF"
            store_id = "76840"
            pos_id = "65763"
            response_payment = "Payment response"
            screens_info = "screen info"
            raw = ["coupon_amount":31.5, "operation_type":"regular_payment"]
            business_result = ["show_payment_method":true, "top_custom_view":[], "title":"¡Listo! Ya le pagaste a FEED", "bottom_custom_view":[], "status":"approved"]
            vending_operation_context = ["transaction_id":732941543339532, "vending_code":"GOtm10Y=", "service_uuid":"455a0001-0000-4000-4541-5a59434f494e", "connection_id":"EZ_50000131", "vending_id":"50000131", "mac":"00:1E:C0:27:77:25"]
            dispatching_time = 1000
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
                notification_url = "http://181.30.31.180:23080/gap-backend/notificaciones/notificar"
                sponsor_id = 1234567
                vending_id = "12345"

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
                notification_url = "http://181.30.31.180:23080/gap-backend/notificaciones/notificar"
                sponsor_id = 1234567
            }
        }

        "/instore/payment_info"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            payment_info_tag = "Execute post payment"
            remaining_attempts = 2
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
        "/instore/required_action/bluetooth_on"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
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
      
      
        "/instore/checkout/payment_option/cards"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {}
        "/instore/checkout/error_view"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/number"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {
        }
        "/instore/checkout/card/credit_card/number"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {
        }
        "/instore/checkout/card/credit_card/name"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/credit_card/expiration"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {
        }
        "/instore/checkout/card/credit_card/cvv"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/name"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {}
        "/instore/checkout/card/debit_card/expiration"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {
        }
        "/instore/checkout/card/debit_card/cvv"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {}

        "/instore/map"(platform: "/mobile", business: "mercadopago", type: TrackType.View) {
            session_id = "2183nHUADndjsu123yu8N7r73ndf"
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
            context = "/instore/map/error"
            style = "screen"
            id = "operation_error"
            message = "server error"
            attributable_to = "server"
        }
    }

}