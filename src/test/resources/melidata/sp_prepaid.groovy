package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Single Player Prepaid") {

        def mandatory = {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        
        def view_time = {
            view_time = 38927
        }

        def available_items = {
            available_items = [
                {
                    item_id = 7
                    type = "item6"
                    content = ["400 MB", "R\$ 100", "Incluye Instagram y Snapchat", "¡Vigencia 15 días!"]
                },
                {
                    item_id = 11
                    type = "item4"
                    content = ["Metrô e CPTM", "R\$ 15"]
                }
            ]
        }

        def item_1 = {
            item_id = 7
            type = "item6"
            content = ["400 MB", "R\$ 100", "Incluye Instagram y Snapchat", "¡Vigencia 15 días!"]
        }

        def item_2 = {
            item_id = 11
            type = "item4"
            content = ["Metrô e CPTM", "R\$ 15"]
        }

        def notification_panel = {
            notification_panel = {
                type = "neutral"
                content = ["Diária: ", "Dá direito a realizar até 10 viagens por dia em até 24h, a partir da primeira utilização."]
            }
        }

        def point_info = {
            latitude = "-28.46956"
            longitude = "-65.77934"
            description = "Casa de la Cultura"
            address_line_1 = "VIRGEN DEL VALLE AV. (N) 661"
            address_line_2 = "SAN FDO DEL VALLE DE CATAMARCA"
            type = "Comercio"
            schedule = "07:00 A 13:00 HS"
            icon = "SUBE"
        }

        def button_card = {
            button_card = {
                type = "button4"
                content = ["Ernesto Carrillo", "Código de recarga **6789", "Editar tarjeta"]
            }
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Mercado Pago
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        // Strart flow
        "/single_player/prepaid/start_flow"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            method = "home"
        }


        //FTU
        "/single_player/prepaid/first_time_use"(platform: "/mobile", type: TrackType.View) {
            mandatory()

        }
        "/single_player/prepaid/first_time_use/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/first_time_use/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Add device number
        "/single_player/prepaid/add_device_number"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/add_device_number/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/add_device_number/invalid_input"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            device_number = "548786547821356478"
        }
        "/single_player/prepaid/add_device_number/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/add_device_number/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/add_device_number/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Invalid input
        "/single_player/prepaid/invalid_input"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/invalid_input/retry"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/invalid_input/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Products
        "/single_player/prepaid/product_list"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            available_items()
        }

        "/single_player/prepaid/product_list/selected_product"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/product_list/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Recommended products
        "/single_player/prepaid/recommended_products"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            available_items()
        }

        "/single_player/prepaid/recommended_products/selected_product"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/recommended_products/more_products"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/recommended_products/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Add alias
        "/single_player/prepaid/add_alias"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/add_alias/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/add_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            alias = "^_)(&/843sakdj*-%*L"
        }
        "/single_player/prepaid/add_alias/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Edit alias
        "/single_player/prepaid/edit_alias"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/edit_alias/confirm_edit"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/edit_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            alias = "^_)(&/843sakdj*-%*L"
        }
        "/single_player/prepaid/edit_alias/delete"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/edit_alias/confirm_delete"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/edit_alias/cancel_delete"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/edit_alias/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // One device
        "/single_player/prepaid/one_device"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            button_card()
            notification_panel()
            available_items()
        }

        "/single_player/prepaid/one_device/edit_alias"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/one_device/selected_product"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/one_device/more_products"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/one_device/another_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/one_device/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Multiple devices
        "/single_player/prepaid/multiple_devices"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            quantity = 3
            available_items()
        }

        "/single_player/prepaid/multiple_devices/selected_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/multiple_devices/another_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/multiple_devices/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // One Tap
        "/single_player/prepaid/one_tap"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/one_tap/pay"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/one_tap/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Congrats success
        "/single_player/prepaid/congrats_success"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            device_id = "321"
            device_number = "057000658453238063"
            product_id = "23"
            vertical_id = "antenna"
            provider_id = "antenna_mla_directv_prepago"
        }
        "/single_player/prepaid/congrats_success/show_receipt"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/add_alias"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/open_external_application"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            application_name = "com.sube.cargasube"
        }
        "/single_player/prepaid/congrats_success/credit_charge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/show_terminals"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Congrats rejected
        "/single_player/prepaid/congrats_rejected"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }
        "/single_player/prepaid/congrats_rejected/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_rejected/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Congrats pending
        "/single_player/prepaid/congrats_pending"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }
        "/single_player/prepaid/congrats_pending/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_pending/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Congrats alias
        "/single_player/prepaid/congrats_alias"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/congrats_alias/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/congrats_alias/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/congrats_alias/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Accreditation information
        "/single_player/prepaid/accreditation_information"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }
        "/single_player/prepaid/accreditation_information/show_terminals"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/accreditation_information/download_external_application"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            application_name = "com.sube.cargasube"
        }
        "/single_player/prepaid/accreditation_information/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Internal error
        "/single_player/prepaid/error/internal"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/error/internal/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/error/internal/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Server error
        "/single_player/prepaid/error/server"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            error_code = "3"
        }

        "/single_player/prepaid/error/server/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/error/server/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Connection error
        "/single_player/prepaid/error/connection"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/error/connection/retry"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/error/connection/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Shield
        "/single_player/prepaid/shield"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }


        // Contingency
        "/single_player/prepaid/contingency"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/contingency/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/contingency/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/contingency/abort"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Map
        "/single_player/prepaid/locations"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/locations/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/locations/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/locations/selected_point"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            point_info()
        }
        "/single_player/prepaid/locations/want_to_go"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            point_info()
        }
        "/single_player/prepaid/locations/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Meli
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        
        // Strart flow
        "/single_player/prepaid/start_flow"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            method = "home"
        }


        //FTU
        "/single_player/prepaid/first_time_use"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }
        "/single_player/prepaid/first_time_use/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/first_time_use/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Add device number
        "/single_player/prepaid/add_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/add_device_number/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/add_device_number/invalid_input"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            device_number = "548786547821356478"
        }
        "/single_player/prepaid/add_device_number/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/add_device_number/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/add_device_number/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Invalid input
        "/single_player/prepaid/invalid_input"(platform: "/mobile", business: "mercadolibre", type: TrackType.View)  {
            mandatory()
        }

        "/single_player/prepaid/invalid_input/retry"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/invalid_input/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Products
        "/single_player/prepaid/product_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            available_items()
        }

        "/single_player/prepaid/product_list/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_2()
        }
        "/single_player/prepaid/product_list/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Recommended products
        "/single_player/prepaid/recommended_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            available_items()
        }

        "/single_player/prepaid/recommended_products/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_2()
        }
        "/single_player/prepaid/recommended_products/more_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_2()
        }
        "/single_player/prepaid/recommended_products/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Add alias
        "/single_player/prepaid/add_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/add_alias/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/add_alias/invalid_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            alias = "^_)(&/843sakdj*-%*L"
        }
        "/single_player/prepaid/add_alias/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Edit alias
        "/single_player/prepaid/edit_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/edit_alias/confirm_edit"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/edit_alias/invalid_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            alias = "^_)(&/843sakdj*-%*L"
        }
        "/single_player/prepaid/edit_alias/delete"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/edit_alias/confirm_delete"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/edit_alias/cancel_delete"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/edit_alias/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // One device
        "/single_player/prepaid/one_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            button_card()
            notification_panel()
            available_items() 
        }

        "/single_player/prepaid/one_device/edit_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
          
        }
        "/single_player/prepaid/one_device/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_2()
        }
        "/single_player/prepaid/one_device/more_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_2()
        }
        "/single_player/prepaid/one_device/another_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/one_device/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Multiple devices
        "/single_player/prepaid/multiple_devices"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            quantity = 3
            available_items()
        }

        "/single_player/prepaid/multiple_devices/selected_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_2()
        }
        "/single_player/prepaid/multiple_devices/another_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/multiple_devices/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // One Tap
        "/single_player/prepaid/one_tap"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/one_tap/pay"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/one_tap/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Congrats success
        "/single_player/prepaid/congrats_success"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            device_id = "321"
            device_number = "057000658453238063"
            product_id = "23"
            vertical_id = "antenna"
            provider_id = "antenna_mla_directv_prepago"
        }
        "/single_player/prepaid/congrats_success/show_receipt"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/add_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/another_recharge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/open_external_application"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            application_name = "Sube"
        }
        "/single_player/prepaid/congrats_success/credit_charge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/show_terminals"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Congrats rejected
        "/single_player/prepaid/congrats_rejected"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }
        "/single_player/prepaid/congrats_rejected/another_recharge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_rejected/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Congrats pending
        "/single_player/prepaid/congrats_pending"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }
        "/single_player/prepaid/congrats_pending/another_recharge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_pending/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Congrats alias
        "/single_player/prepaid/congrats_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/congrats_alias/another_recharge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/congrats_alias/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/congrats_alias/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Accreditation information
        "/single_player/prepaid/accreditation_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }
        "/single_player/prepaid/accreditation_information/show_terminals"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/accreditation_information/download_external_application"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            application_name = "sube"
        }
        "/single_player/prepaid/accreditation_information/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Internal error
        "/single_player/prepaid/error/internal"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/error/internal/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/error/internal/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Server error
        "/single_player/prepaid/error/server"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            error_code = "3"
        }

        "/single_player/prepaid/error/server/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/error/server/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Connection error
        "/single_player/prepaid/error/connection"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/error/connection/retry"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/error/connection/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Shield
        "/single_player/prepaid/shield"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }


        // Contingency
        "/single_player/prepaid/contingency"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/contingency/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/contingency/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/contingency/abort"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Map
        "/single_player/prepaid/locations"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/prepaid/locations/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/locations/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/locations/selected_point"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            point_info()
        }
        "/single_player/prepaid/locations/want_to_go"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            point_info()
        }
        "/single_player/prepaid/locations/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
    }


    test("Single Player Paygo") {

        def mandatory = {
            flow = "toll"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        
        def view_time = {
            view_time = 38927
        }

        def available_items = {
            available_items = [
                {
                    item_id = 7
                    type = "item2"
                    content = ["Automóvil"]
                },
                {
                    item_id = 11
                    type = "item2"
                    content = ["Vehículos con ruedas dobles", "Altura mayor a 2,10m"]
                }
            ]
        }

        def item_1 = {
            item_id = 7
            type = "item2"
            content = ["Automóvil"]
        }

        def item_2 = {
            item_id = 11
            type = "item2"
            content = ["Vehículos con ruedas dobles", "Altura mayor a 2,10m"]
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Mercado Pago
        //------------------------------------------------------------------------------------------------------------------------------------------------------


        // FTU
        "/single_player/paygo/first_time_use"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/first_time_use/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/first_time_use/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Break Freeways Available
        "/single_player/paygo/break_freeways_available"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/break_freeways_available/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/break_freeways_available/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Freeways Available
        "/single_player/paygo/freeways_available"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/freeways_available/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/freeways_available/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Add device number
        "/single_player/paygo/add_device_number"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/add_device_number/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_device_number/view_freeways_available"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_device_number/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_device_number/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_device_number/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Category List
        "/single_player/paygo/category_list"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            available_items()
        }

        "/single_player/paygo/category_list/selected_category"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/paygo/category_list/more_categories"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/paygo/category_list/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // New Address
        "/single_player/paygo/new_address"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/new_address/save"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/new_address/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Review Information
        "/single_player/paygo/review_information"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/review_information/edit_device_number"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_information/edit_address"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_information/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Congrats success
        "/single_player/paygo/congrats_success"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            device_id = "321"
            device_number = "057000658453238063"
            product_id = "23"
            vertical_id = "toll"
            provider_id = "toll_mla_v2"
        }
        "/single_player/paygo/congrats_success/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Congrats pending
        "/single_player/paygo/congrats_pending"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }
        "/single_player/paygo/congrats_pending/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Congrats rejected
        "/single_player/paygo/congrats_rejected"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }
        "/single_player/paygo/congrats_rejected/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/congrats_pending/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Recurrence
        "/single_player/paygo/recurrence"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/recurrence/more_charges"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/recurrence/device_list"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/recurrence/another_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/recurrence/add_money"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/recurrence/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Charge List
        "/single_player/paygo/charge_list"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/charge_list/selected_charge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/charge_list/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Charge Detail
        "/single_player/paygo/charge_detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/charge_detail/view_receipt"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/charge_detail/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Debt Detail
        "/single_player/paygo/debt_detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            view_time()
        }

        "/single_player/paygo/debt_detail/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/debt_detail/cancel"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Multiple devices
        "/single_player/paygo/multiple_devices"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            quantity = 3
            available_items()
        }

        "/single_player/paygo/multiple_devices/selected_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/paygo/multiple_devices/another_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/multiple_devices/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Device Detail
        "/single_player/paygo/device_detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/device_detail/activate_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/device_detail/shipping_detail"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/device_detail/cancel_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/device_detail/delete_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/device_detail/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Shipping Detail
        "/single_player/paygo/shipping_detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/shipping_detail/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Cancel Device
        "/single_player/paygo/cancel_device"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/cancel_device/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/cancel_device/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Congrats Cancel Tag
        "/single_player/paygo/congrats_cancel_tag"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/congrats_cancel/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Delete Device
        "/single_player/paygo/delete_device"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/delete_device/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/delete_device/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Congrats Delete Device
        "/single_player/paygo/congrats_delete_tag"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/congrats_delete_tag/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Meli
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        
        / FTU
        "/single_player/paygo/first_time_use"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/first_time_use/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/first_time_use/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Break Freeways Available
        "/single_player/paygo/break_freeways_available"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/break_freeways_available/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/break_freeways_available/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Freeways Available
        "/single_player/paygo/freeways_available"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/freeways_available/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/freeways_available/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Add device number
        "/single_player/paygo/add_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/add_device_number/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_device_number/view_freeways_available"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_device_number/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_device_number/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_device_number/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Category List
        "/single_player/paygo/category_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            available_items()
        }

        "/single_player/paygo/category_list/selected_category"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/paygo/category_list/more_categories"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/paygo/category_list/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // New Address
        "/single_player/paygo/new_address"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/new_address/save"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/new_address/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Review Information
        "/single_player/paygo/review_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/review_information/edit_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_information/edit_address"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_information/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Congrats success
        "/single_player/paygo/congrats_success"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            device_id = "321"
            device_number = "057000658453238063"
            product_id = "23"
            vertical_id = "toll"
            provider_id = "toll_mla_v2"
        }
        "/single_player/paygo/congrats_success/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Congrats pending
        "/single_player/paygo/congrats_pending"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }
        "/single_player/paygo/congrats_pending/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Congrats rejected
        "/single_player/paygo/congrats_rejected"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }
        "/single_player/paygo/congrats_rejected/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/congrats_pending/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Recurrence
        "/single_player/paygo/recurrence"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/recurrence/more_charges"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/recurrence/device_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/recurrence/another_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/recurrence/add_money"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/recurrence/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Charge List
        "/single_player/paygo/charge_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/charge_list/selected_charge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/charge_list/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Charge Detail
        "/single_player/paygo/charge_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/charge_detail/view_receipt"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/charge_detail/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Debt Detail
        "/single_player/paygo/debt_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            view_time()
        }

        "/single_player/paygo/debt_detail/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/debt_detail/cancel"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Multiple devices
        "/single_player/paygo/multiple_devices"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            quantity = 3
            available_items()
        }

        "/single_player/paygo/multiple_devices/selected_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/paygo/multiple_devices/another_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/multiple_devices/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Device Detail
        "/single_player/paygo/device_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/device_detail/activate_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/device_detail/shipping_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/device_detail/cancel_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/device_detail/delete_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/device_detail/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Shipping Detail
        "/single_player/paygo/shipping_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/shipping_detail/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Cancel Device
        "/single_player/paygo/cancel_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/cancel_device/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/cancel_device/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Congrats Cancel Tag
        "/single_player/paygo/congrats_cancel_tag"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/congrats_cancel/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Delete Device
        "/single_player/paygo/delete_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/delete_device/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/delete_device/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Congrats Delete Device
        "/single_player/paygo/congrats_delete_tag"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        "/single_player/paygo/congrats_delete_tag/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
    }
}