package src.test.resources.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Single Player Prepaid") {

        def mandatory = {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        def step_information = {
            device_id = "321"
            device_number = "057000658453238063"
            product_id = "23"
            vertical_id = "antenna"
            provider_id = "antenna_mla_directv_prepago"
            flavor = "sube_nfc"
            last_recharge = "1459"
            parent_key = "cellphone_mlm_telcel__100_mb"
            origin_source = "instore"
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

        def item_structure = {
            item_id = 11
            type = "item8"
            content = ["Movistar"]
        }

        def segment = {
            segment = "test_segment"
        }

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Mercado Pago
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        // Strart flow
        "/single_player/prepaid/start_flow"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            method = "mp_home"
        }
        "/single_player/prepaid/start_flow"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            method = "mp_home"
            extra_info = {
                installed_applications = "[com.sube.cargasube]"
                nfc_compatible = "[nfc_mifare]"
                sim = "322008"
            }
        }


        //FTU
        "/single_player/prepaid/first_time_use"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/first_time_use/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/first_time_use/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Add device number
        "/single_player/prepaid/add_device_number"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/add_device_number/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/add_device_number/close"(platform: "/mobile", type: TrackType.Event) {
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
        "/single_player/prepaid/add_device_number/show_contacts"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Invalid input
        "/single_player/prepaid/invalid_input"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/invalid_input/retry"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/invalid_input/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/invalid_input/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Products
        "/single_player/prepaid/product_list"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
            available_items()
            notification_panel()
            segment()
        }

        "/single_player/prepaid/product_list/selected_product"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
            segment()
        }
        "/single_player/prepaid/product_list/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            segment()
        }
        "/single_player/prepaid/product_list/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/product_list/more_products"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/product_list/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/product_list/link"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
            item_1()
        }
        "/single_player/prepaid/product_credits_list"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
            available_items()
            notification_panel()
        }
        "/single_player/prepaid/product_credits_list/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }
        "/single_player/prepaid/product_credits_list/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }
        "/single_player/prepaid/product_credits_list/selected_product"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
            item_structure()
        }



        // Recommended products
        "/single_player/prepaid/recommended_products"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
            notification_panel()
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
        "/single_player/prepaid/recommended_products/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/recommended_products/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/recommended_products/info_balance"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }


        // Add alias
        "/single_player/prepaid/add_alias"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
        }

        "/single_player/prepaid/edit_alias/confirm_edit"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/edit_alias/close"(platform: "/mobile", type: TrackType.Event) {
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
            step_information()
            button_card()
            notification_panel()
            available_items()
            segment()
        }

        "/single_player/prepaid/one_device/edit_alias"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/one_device/selected_product"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
            segment()
        }
        "/single_player/prepaid/one_device/more_products"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/one_device/another_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/one_device/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            segment()
        }
        "/single_player/prepaid/one_device/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/one_device/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/one_device/credits_button"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
            item_structure()
        }
        "/single_player/prepaid/one_device/automatic_recharge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
            item_structure()
        }


        // Multiple devices
        "/single_player/prepaid/multiple_devices"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
            quantity = 3
            notification_panel()
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
            item_1()
        }
        "/single_player/prepaid/multiple_devices/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/multiple_devices/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/multiple_devices/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Companies
        "/single_player/prepaid/companies"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
            available_items()
        }

        "/single_player/prepaid/companies/selected_company"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            item_structure()
        }
        "/single_player/prepaid/companies/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/companies/more_information"(platform: "/mobile",  type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/companies/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Pre One Tap
        "/single_player/prepaid/break_pre_one_tap"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }
        "/single_player/prepaid/break_pre_one_tap/pay"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/break_pre_one_tap/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/break_pre_one_tap/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/prepaid/break_pre_one_tap/checkout"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // One Tap
        "/single_player/prepaid/one_tap"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/one_tap/more_information"(platform: "/mobile", type: TrackType.Event) {
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
            step_information()
            payment_id = "252"
        }

        "/single_player/prepaid/congrats_success/copy_to_clipboard"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            payment_id = "252"
        }
        "/single_player/prepaid/congrats_success/show_receipt"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            payment_id = "252"
        }
        "/single_player/prepaid/congrats_success/add_alias"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            payment_id = "252"
        }
        "/single_player/prepaid/congrats_success/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            payment_id = "252"
        }
        "/single_player/prepaid/congrats_success/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            payment_id = "252"
        }
        "/single_player/prepaid/congrats_success/open_external_application"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            application_name = "com.sube.cargasube"
            payment_id = "252"
        }
        "/single_player/prepaid/congrats_success/credit_charge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            payment_id = "252"
        }
        "/single_player/prepaid/congrats_success/show_terminals"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            payment_id = "252"
        }
        "/single_player/prepaid/congrats_success/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            payment_id = "252"
        }
        "/single_player/prepaid/congrats_success/redirect_to_action"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            payment_id = "252"
        }


        // Congrats rejected
        "/single_player/prepaid/congrats_rejected"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
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
            step_information()
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
            step_information()
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

        // Accreditation information
        "/single_player/prepaid/check_accreditation_information"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/check_accreditation_information/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }
        "/single_player/prepaid/check_accreditation_information/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }

        // Carousel
        "/single_player/prepaid/carousel"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/carousel/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/carousel/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Internal error
        "/single_player/prepaid/error/internal"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
            error_code = "3"
        }

        "/single_player/prepaid/error/server/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/error/server/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Connection error
        "/single_player/prepaid/error/connection"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/error/connection/retry"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/error/connection/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/error/connection/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Timeout error
        "/single_player/prepaid/error/timeout"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/error/timeout/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/error/timeout/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }

        // Not Allowed Version error
        "/single_player/prepaid/error/not_allowed_version"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/error/not_allowed_version/not_allowed_version"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/error/not_allowed_version/go_to_store"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Not Enough money
        "/single_player/prepaid/error/not_enough_money"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/error/not_enough_money/not_enough_money"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/prepaid/error/not_enough_money/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/prepaid/error/not_enough_money/money_in"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/prepaid/error/not_enough_money/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Blocked error
        "/single_player/prepaid/error/blocked"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/error/blocked/another_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/error/blocked/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Shield
        "/single_player/prepaid/shield"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }


        // Contingency
        "/single_player/prepaid/contingency"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
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


        // Payment rejected
        "/single_player/prepaid/payment_rejected"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/payment_rejected/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Contacts
        "/single_player/prepaid/contacts"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/contacts/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/contacts/selected_contact"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            validation_result = "failed"
        }


        // Receipt
        "/single_player/prepaid/receipt"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/receipt/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/receipt/download"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/receipt/share"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Show Action
        "/single_player/prepaid/show_action"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/show_action/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/show_action/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Scanner
        "/single_player/prepaid/scanner"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/scanner/open"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }
        "/single_player/prepaid/scanner/help"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
        }
        "/single_player/prepaid/scanner/error"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
        }
        "/single_player/prepaid/scanner/to_confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
        }
        "/single_player/prepaid/scanner/confirm_number"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/scanner/input_device_number"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            step_information()
        }

        // RA create error
        "/single_player/prepaid/automatic_recharge/create/error"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/create/error/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/create/error/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Congrats
        "/single_player/prepaid/automatic_recharge/create/congrats"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/create/congrats/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/create/congrats/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/create/congrats/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/create/congrats/close"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA FTU
        "/single_player/prepaid/automatic_recharge/ftu"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/ftu/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/ftu/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Product list
        "/single_player/prepaid/automatic_recharge/product_list"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/product_list/selected_recommended_product"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/product_list/selected_product"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/product_list/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Time Period
        "/single_player/prepaid/automatic_recharge/time_period_list"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/time_period_list/selected_time_period"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/time_period_list/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Pick Date
        "/single_player/prepaid/automatic_recharge/pick_date"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/pick_date/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/pick_date/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Confirm subscription
        "/single_player/prepaid/automatic_recharge/subscription"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/subscription/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/subscription/edit_time_period"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/subscription/edit_date"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/subscription/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Detail
        "/single_player/prepaid/automatic_recharge/detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/detail/cancel_subscription"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/detail/add_money"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/detail/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/detail/modal/confirm_cancel_subscription"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/detail/modal/back_to_detail"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/detail/modal/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Congrats Cancel
        "/single_player/prepaid/automatic_recharge/cancel/congrats"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/cancel/congrats/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/cancel/congrats/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/cancel/congrats/close"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/cancel/congrats/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Congrats Cancel error
        "/single_player/prepaid/automatic_recharge/cancel/error"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/cancel/error/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/cancel/error/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Congrats Cancel timeout
        "/single_player/prepaid/automatic_recharge/cancel/timeout"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }
        "/single_player/prepaid/automatic_recharge/cancel/timeout/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/cancel/timeout/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Info cancel pay
        "/single_player/prepaid/automatic_recharge/info_cancel_pay"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_pay/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_pay/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_pay/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_pay/close"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Info cancel product
        "/single_player/prepaid/automatic_recharge/info_cancel_product"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/info_cancel_product/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_product/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_product/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_product/close"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Info cancel unrecover
        "/single_player/prepaid/automatic_recharge/info_cancel_unrecover"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/info_cancel_unrecover/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_unrecover/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_unrecover/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_unrecover/close"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Info fail pay
        "/single_player/prepaid/automatic_recharge/info_fail_pay"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/info_fail_pay/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_pay/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_pay/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_pay/close"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Info fail rech
        "/single_player/prepaid/automatic_recharge/info_fail_rech"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/info_fail_rech/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_rech/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_rech/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_rech/close"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Meli
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        // Strart flow
        "/single_player/prepaid/start_flow"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            method = "ml_home"
        }
        "/single_player/prepaid/start_flow"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            method = "ml_home"
            extra_info = {
                installed_applications = "[com.sube.cargasube]"
                nfc_compatible = "[nfc_mifare]"
                sim = "322018"
            }
        }


        //FTU
        "/single_player/prepaid/first_time_use"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/first_time_use/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/first_time_use/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/first_time_use/abort"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Add device number
        "/single_player/prepaid/add_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/add_device_number/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/add_device_number/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
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
        "/single_player/prepaid/add_device_number/show_contacts"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Invalid input
        "/single_player/prepaid/invalid_input"(platform: "/mobile", business: "mercadolibre", type: TrackType.View)  {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/invalid_input/retry"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/invalid_input/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/invalid_input/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Products
        "/single_player/prepaid/product_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
            available_items()
            notification_panel()
            segment()
        }

        "/single_player/prepaid/product_list/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_2()
            segment()
        }
        "/single_player/prepaid/product_list/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            segment()
        }
        "/single_player/prepaid/product_list/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/product_list/more_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/product_list/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/product_list/link"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
            item_1()
        }
        "/single_player/prepaid/product_credits_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
            available_items()
            notification_panel()
        }
        "/single_player/prepaid/product_credits_list/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }
        "/single_player/prepaid/product_credits_list/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }
        "/single_player/prepaid/product_credits_list/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
            item_structure()
        }


        // Recommended products
        "/single_player/prepaid/recommended_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
            notification_panel()
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
        "/single_player/prepaid/recommended_products/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/recommended_products/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/recommended_products/info_balance"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }


        // Add alias
        "/single_player/prepaid/add_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
        }

        "/single_player/prepaid/edit_alias/confirm_edit"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/edit_alias/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
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
            step_information()
            button_card()
            notification_panel()
            available_items()
            parent_key
            segment()
        }

        "/single_player/prepaid/one_device/edit_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()

        }
        "/single_player/prepaid/one_device/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_2()
            segment()
        }
        "/single_player/prepaid/one_device/more_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_2()
        }
        "/single_player/prepaid/one_device/another_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_1()
        }
        "/single_player/prepaid/one_device/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            segment()
        }
        "/single_player/prepaid/one_device/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/one_device/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/one_device/credits_button"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
            item_structure()
        }
        "/single_player/prepaid/one_device/automatic_recharge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
            item_structure()
        }

        // Multiple devices
        "/single_player/prepaid/multiple_devices"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
            quantity = 3
            notification_panel()
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
            item_1()
        }
        "/single_player/prepaid/multiple_devices/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/multiple_devices/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/multiple_devices/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Companies
        "/single_player/prepaid/companies"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
            available_items()
        }
        "/single_player/prepaid/companies/selected_company"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            item_structure()
        }
        "/single_player/prepaid/companies/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/companies/more_information"(platform: "/mobile", business: "mercadolibre",  type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/companies/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Pre One Tap
        "/single_player/prepaid/break_pre_one_tap"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }
        "/single_player/prepaid/break_pre_one_tap/pay"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/break_pre_one_tap/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/break_pre_one_tap/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/break_pre_one_tap/checkout"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // One Tap
        "/single_player/prepaid/one_tap"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/one_tap/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
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
            step_information()
            payment_id = "232"
        }

        "/single_player/prepaid/congrats_success/copy_to_clipboard"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            payment_id = "252"
        }
        "/single_player/prepaid/congrats_success/show_receipt"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            payment_id = "232"
        }
        "/single_player/prepaid/congrats_success/add_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            payment_id = "232"
        }
        "/single_player/prepaid/congrats_success/another_recharge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            payment_id = "232"
        }
        "/single_player/prepaid/congrats_success/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            payment_id = "232"
        }
        "/single_player/prepaid/congrats_success/open_external_application"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            application_name = "Sube"
            payment_id = "232"
        }
        "/single_player/prepaid/congrats_success/credit_charge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            payment_id = "232"
        }
        "/single_player/prepaid/congrats_success/show_terminals"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            payment_id = "232"
        }
        "/single_player/prepaid/congrats_success/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            payment_id = "232"
        }
        "/single_player/prepaid/congrats_success/redirect_to_action"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            payment_id = "232"
        }


        // Congrats rejected
        "/single_player/prepaid/congrats_rejected"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
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
            step_information()
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
            step_information()
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


        // Accreditation information
        "/single_player/prepaid/check_accreditation_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/check_accreditation_information/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }
        "/single_player/prepaid/check_accreditation_information/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }


        // Carousel
        "/single_player/prepaid/carousel"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/carousel/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/carousel/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Internal error
        "/single_player/prepaid/error/internal"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
            error_code = "3"
        }

        "/single_player/prepaid/error/server/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/error/server/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Connection error
        "/single_player/prepaid/error/connection"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/error/connection/retry"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/error/connection/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/error/connection/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Timeout error
        "/single_player/prepaid/error/timeout"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/error/timeout/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/error/timeout/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Not Allowed Version error
        "/single_player/prepaid/error/not_allowed_version"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/error/not_allowed_version/not_allowed_version"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/error/not_allowed_version/go_to_store"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Not Enough money
        "/single_player/prepaid/error/not_enough_money"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/error/not_enough_money/not_enough_money"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/prepaid/error/not_enough_money/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/prepaid/error/not_enough_money/money_in"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/prepaid/error/not_enough_money/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Blocked error
        "/single_player/prepaid/error/blocked"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/error/blocked/another_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/error/blocked/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Shield
        "/single_player/prepaid/shield"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }


        // Contingency
        "/single_player/prepaid/contingency"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
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


        // Payment rejected
        "/single_player/prepaid/payment_rejected"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/payment_rejected/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Contacts
        "/single_player/prepaid/contacts"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/contacts/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/contacts/selected_contact"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            validation_result = "failed"
        }


        // Receipt
        "/single_player/prepaid/receipt"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/receipt/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/receipt/download"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/receipt/share"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Show Action
        "/single_player/prepaid/show_action"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/show_action/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/show_action/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Scanner
        "/single_player/prepaid/scanner"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/scanner/open"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
            view_time()
        }

        "/single_player/prepaid/scanner/help"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/scanner/error"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/scanner/to_confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/scanner/confirm_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/scanner/input_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            step_information()
        }

        // RA create error
        "/single_player/prepaid/automatic_recharge/create/error"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/create/error/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/create/error/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Congrats
        "/single_player/prepaid/automatic_recharge/create/congrats"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/create/congrats/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/create/congrats/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/create/congrats/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/create/congrats/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA FTU
        "/single_player/prepaid/automatic_recharge/ftu"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/ftu/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/ftu/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Product list
        "/single_player/prepaid/automatic_recharge/product_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/product_list/selected_recommended_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/product_list/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/product_list/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Time Period
        "/single_player/prepaid/automatic_recharge/time_period_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/time_period_list/selected_time_period"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/time_period_list/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Pick Date
        "/single_player/prepaid/automatic_recharge/pick_date"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/pick_date/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/pick_date/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Confirm subscription
        "/single_player/prepaid/automatic_recharge/subscription"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/subscription/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/subscription/edit_time_period"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/subscription/edit_date"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/subscription/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Detail
        "/single_player/prepaid/automatic_recharge/detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/detail/cancel_subscription"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/detail/add_money"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/detail/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/detail/modal/confirm_cancel_subscription"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/detail/modal/back_to_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/detail/modal/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Congrats Cancel
        "/single_player/prepaid/automatic_recharge/cancel/congrats"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/cancel/congrats/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/cancel/congrats/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/cancel/congrats/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/cancel/congrats/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Congrats Cancel error
        "/single_player/prepaid/automatic_recharge/cancel/error"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/cancel/error/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/cancel/error/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Congrats Cancel timeout
        "/single_player/prepaid/automatic_recharge/cancel/timeout"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/cancel/timeout/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/cancel/timeout/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // RA Info cancel pay
        "/single_player/prepaid/automatic_recharge/info_cancel_pay"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/info_cancel_pay/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_pay/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_pay/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_pay/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Info cancel product
        "/single_player/prepaid/automatic_recharge/info_cancel_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/info_cancel_product/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_product/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_product/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_product/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Info cancel unrecover
        "/single_player/prepaid/automatic_recharge/info_cancel_unrecover"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/info_cancel_unrecover/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_unrecover/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_unrecover/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_cancel_unrecover/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Info fail pay
        "/single_player/prepaid/automatic_recharge/info_fail_pay"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/info_fail_pay/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_pay/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_pay/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_pay/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // RA Info fail rech
        "/single_player/prepaid/automatic_recharge/info_fail_rech"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/prepaid/automatic_recharge/info_fail_rech/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_rech/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_rech/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/prepaid/automatic_recharge/info_fail_rech/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
    }


    test("Single Player Paygo") {

        def mandatory = {
            flow = "toll"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        def step_information = {
            device_id = "321"
            device_number = "057000658453238063"
            product_id = "23"
            vertical_id = "toll"
            provider_id = "toll_mla_v2"
            flavor = "toll"
            last_recharge = "1459"
            origin_source = "instore"
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

        def item_structure = {
            item_id = 11
            type = "item2"
            content = ["Vehículos con ruedas dobles", "Altura mayor a 2,10m"]
        }

        def segment = {
            segment = "test_segment"
        }

        def notification_panel = {
            notification_panel = {
                type = "neutral"
                content = ["Diária: ", "Dá direito a realizar até 10 viagens por dia em até 24h, a partir da primeira utilização."]
            }
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Mercado Pago
        //------------------------------------------------------------------------------------------------------------------------------------------------------


        // Base
        "/single_player/paygo/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/change_detail"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/view_reciept"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // FTU
        "/single_player/paygo/first_time_use"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/first_time_use/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/first_time_use/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Break New Plate
        "/single_player/paygo/break_new_plate"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/break_new_plate/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/break_new_plate/new_activation_number"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/break_new_plate/activate_activation_number"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Challenge KYC
        "/single_player/paygo/challenge_kyc"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        // New activation number
        "/single_player/paygo/new_activation_number"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }


        // New activation number not allowed
        "/single_player/paygo/new_activation_number_not_allowed"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }
        "/single_player/paygo/new_activation_number_not_allowed/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Break Freeways Available
        "/single_player/paygo/break_freeways_available"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
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
        "/single_player/paygo/add_activation_number"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/add_activation_number/add_activation_number"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_activation_number/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_activation_number/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_activation_number/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_activation_number/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_activation_number/close"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Add device number
        "/single_player/paygo/add_device_number"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
            origin_source = "instore"
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
        "/single_player/paygo/add_device_number/invalid_input"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
            device_number = "12345678"
        }


        // Category List
        "/single_player/paygo/category_list"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
        }

        "/single_player/paygo/new_address/save"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/new_address/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Review New Device
        "/single_player/paygo/review_new_device"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/review_new_device/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_new_device/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_new_device/edit_device_number"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_new_device/edit_activation_number"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_new_device/edit_address"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/review_new_device/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_new_device/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Review Payment Method Change
        "/single_player/paygo/review_payment_method_change"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/review_payment_method_change/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_payment_method_change/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_payment_method_change/edit_device_number"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_payment_method_change/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_payment_method_change/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Congrats success
        "/single_player/paygo/congrats_success"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }
        "/single_player/paygo/congrats_success/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/congrats_success/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/automatic_recharge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Congrats pending
        "/single_player/paygo/congrats_pending"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }
        "/single_player/paygo/congrats_pending/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/congrats_pending/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Congrats rejected
        "/single_player/paygo/congrats_rejected"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
            error_code = "3"
        }
        "/single_player/paygo/congrats_rejected/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/congrats_rejected/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Recurrence
        "/single_player/paygo/recurrence"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
            segment()
            notification_panel()
        }
        "/single_player/paygo/recurrence/selected_charge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/recurrence/more_charges"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/recurrence/more_information"(platform: "/mobile", type: TrackType.Event) {
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
            segment()
        }


        // Charge List
        "/single_player/paygo/charge_list"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/charge_list/selected_charge"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/charge_list/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Charge Detail
        "/single_player/paygo/charge_detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/charge_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/charge_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
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
            step_information()
        }

        "/single_player/paygo/debt_detail/back"(platform: "/mobile", type: TrackType.Event) {
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


        // Debt Detail With Others
        "/single_player/paygo/debt_detail_with_others"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/debt_detail_with_others/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/debt_detail_with_others/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/debt_detail_with_others/cancel"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Multiple devices
        "/single_player/paygo/multiple_devices"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
            quantity = 3
            available_items()
        }

        "/single_player/paygo/multiple_devices/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/multiple_devices/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
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


        // Requested Device Detail
        "/single_player/paygo/requested_device_detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/requested_device_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/requested_device_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/requested_device_detail/activate_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/requested_device_detail/shipping_detail"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/requested_device_detail/cancel_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/requested_device_detail/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Active Device Detail
        "/single_player/paygo/active_device_detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/active_device_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/active_device_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/active_device_detail/delete_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/active_device_detail/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Pending Device Detail
        "/single_player/paygo/pending_device_detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/pending_device_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/pending_device_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/pending_device_detail/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Blocked Device Detail
        "/single_player/paygo/blocked_device_detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/blocked_device_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/blocked_device_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/blocked_device_detail/delete_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/blocked_device_detail/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Shipping Detail
        "/single_player/paygo/shipping_detail"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/shipping_detail/more_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/shipping_detail/understood_information"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/shipping_detail/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Cancel Device
        "/single_player/paygo/cancel_device"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/cancel_device/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/cancel_device/cancel"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/cancel_device/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Congrats Cancel Device
        "/single_player/paygo/congrats_cancel_device"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/congrats_cancel_device/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/paygo/congrats_cancel_device/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Delete Device
        "/single_player/paygo/delete_device"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/delete_device/confirm"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/delete_device/cancel"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/delete_device/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Congrats Delete Device
        "/single_player/paygo/congrats_delete_device"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/congrats_delete_device/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/paygo/congrats_delete_device/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Internal error
        "/single_player/paygo/error/internal"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/error/internal/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/error/internal/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Server error
        "/single_player/paygo/error/server"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
            error_code = "3"
        }

        "/single_player/paygo/error/server/add_money"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/error/server/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/error/server/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/error/server/select_device"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
            view_time()
        }



        // Connection error
        "/single_player/paygo/error/connection"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/error/connection/retry"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/error/connection/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/error/connection/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        // Timeout error
        "/single_player/paygo/error/timeout"(platform: "/mobile", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/error/timeout/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/error/timeout/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Meli
        //------------------------------------------------------------------------------------------------------------------------------------------------------


        // Base
        "/single_player/paygo/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/change_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/view_reciept"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // FTU
        "/single_player/paygo/first_time_use"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/first_time_use/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/first_time_use/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Break New Plate
        "/single_player/paygo/break_new_plate"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/break_new_plate/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/break_new_plate/new_activation_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/break_new_plate/activate_activation_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Challenge KYC
        "/single_player/paygo/challenge_kyc"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }


        // Break Freeways Available
        "/single_player/paygo/break_freeways_available"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
        }

        "/single_player/paygo/freeways_available/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/freeways_available/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // New activation number
        "/single_player/paygo/new_activation_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }


        // New activation number not allowed
        "/single_player/paygo/new_activation_number_not_allowed"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }
        "/single_player/paygo/new_activation_number_not_allowed/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Add activation number
        "/single_player/paygo/add_activation_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/add_activation_number/add_activation_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_activation_number/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_activation_number/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_activation_number/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_activation_number/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/add_activation_number/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Add device number
        "/single_player/paygo/add_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
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
        "/single_player/paygo/add_device_number/invalid_input"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
            device_number = "12345678"
        }


        // Category List
        "/single_player/paygo/category_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
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
            step_information()
        }

        "/single_player/paygo/new_address/save"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/new_address/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Review New Device
        "/single_player/paygo/review_new_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/review_new_device/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_new_device/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_new_device/edit_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_new_device/edit_activation_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_new_device/edit_address"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/review_new_device/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_new_device/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Review Payment Method Change
        "/single_player/paygo/review_payment_method_change"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/review_payment_method_change/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_payment_method_change/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_payment_method_change/edit_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_payment_method_change/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/review_payment_method_change/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Congrats success
        "/single_player/paygo/congrats_success"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }
        "/single_player/paygo/congrats_success/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/congrats_success/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/prepaid/congrats_success/automatic_recharge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Congrats pending
        "/single_player/paygo/congrats_pending"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }
        "/single_player/paygo/congrats_pending/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/congrats_pending/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Congrats rejected
        "/single_player/paygo/congrats_rejected"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
            error_code = "3"
        }
        "/single_player/paygo/congrats_rejected/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/congrats_rejected/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Recurrence
        "/single_player/paygo/recurrence"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
            segment()
            notification_panel()
        }
        "/single_player/paygo/recurrence/selected_charge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/recurrence/more_charges"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/recurrence/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
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
            segment()
        }


        // Charge List
        "/single_player/paygo/charge_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/charge_list/selected_charge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/charge_list/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Charge Detail
        "/single_player/paygo/charge_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/charge_detail/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/charge_detail/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
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
            step_information()
        }

        "/single_player/paygo/debt_detail/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/debt_detail/cancel"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/debt_detail/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Debt Detail With Others
        "/single_player/paygo/debt_detail_with_others"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/debt_detail_with_others/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/debt_detail_with_others/cancel"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/debt_detail_with_others/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }



        // Multiple devices
        "/single_player/paygo/multiple_devices"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
            quantity = 3
            available_items()
        }

        "/single_player/paygo/multiple_devices/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/multiple_devices/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
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


        // Requested Device Detail
        "/single_player/paygo/requested_device_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/requested_device_detail/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/requested_device_detail/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/requested_device_detail/activate_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/requested_device_detail/shipping_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/requested_device_detail/cancel_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/requested_device_detail/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Active Device Detail
        "/single_player/paygo/active_device_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/active_device_detail/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/active_device_detail/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/active_device_detail/delete_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/active_device_detail/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Pending Device Detail
        "/single_player/paygo/pending_device_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/pending_device_detail/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/pending_device_detail/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/pending_device_detail/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Blocked Device Detail
        "/single_player/paygo/blocked_device_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/blocked_device_detail/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/blocked_device_detail/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/blocked_device_detail/delete_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            item_structure()
            view_time()
        }
        "/single_player/paygo/blocked_device_detail/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Shipping Detail
        "/single_player/paygo/shipping_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/shipping_detail/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/shipping_detail/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/shipping_detail/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Cancel Device
        "/single_player/paygo/cancel_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/cancel_device/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/cancel_device/cancel"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/cancel_device/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Congrats Cancel Device
        "/single_player/paygo/congrats_cancel_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/congrats_cancel_device/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/paygo/congrats_cancel_device/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Delete Device
        "/single_player/paygo/delete_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/delete_device/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/delete_device/cancel"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/delete_device/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Congrats Delete Device
        "/single_player/paygo/congrats_delete_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/congrats_delete_device/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        "/single_player/paygo/congrats_delete_device/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Internal error
        "/single_player/paygo/error/internal"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/error/internal/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/error/internal/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Server error
        "/single_player/paygo/error/server"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
            error_code = "3"
        }

        "/single_player/paygo/error/server/add_money"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/error/server/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/error/server/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/error/server/select_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }


        // Connection error
        "/single_player/paygo/error/connection"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/error/connection/retry"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/error/connection/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/error/connection/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }


        // Timeout error
        "/single_player/paygo/error/timeout"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/error/timeout/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
        "/single_player/paygo/error/timeout/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }

        // Update device number
        "/single_player/paygo/update_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/update_device_number/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/update_device_number/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/update_device_number/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/update_device_number/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Success update device number
        "/single_player/paygo/update_device_number/success"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/update_device_number/success/device_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/update_device_number/success/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/update_device_number/success/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Timeout update device number
        "/single_player/paygo/update_device_number/timeout"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/update_device_number/timeout/device_detail"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/update_device_number/timeout/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/update_device_number/timeout/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Tag obtaining methods
        "/single_player/paygo/tag_obtaining_methods"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/tag_obtaining_methods/marketplace"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/tag_obtaining_methods/free_pick_up"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/tag_obtaining_methods/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Interest point list
        "/single_player/paygo/interest_point_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/interest_point_list/selected_interest_point"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/interest_point_list/confirm_pick_up"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/interest_point_list/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Create tag pick up success
        "/single_player/paygo/tag_pick_up/create/success"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/tag_pick_up/create/success/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/tag_pick_up/create/success/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/tag_pick_up/create/success/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Create tag pick up error
        "/single_player/paygo/tag_pick_up/create/error"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/tag_pick_up/create/error/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/tag_pick_up/create/error/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/tag_pick_up/create/error/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }

        // Tag pick up already exists
        "/single_player/paygo/tag_pick_up/already_exists"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
            step_information()
        }

        "/single_player/paygo/tag_pick_up/already_exists/new_pick_up"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/tag_pick_up/already_exists/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/tag_pick_up/already_exists/close"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
        "/single_player/paygo/tag_pick_up/already_exists/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
            view_time()
        }
    }
}
