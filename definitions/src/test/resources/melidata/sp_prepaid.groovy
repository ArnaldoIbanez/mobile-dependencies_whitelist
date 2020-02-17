package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Single Player Prepaid") {

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Mercado Pago
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        //FTU
        "/single_player/prepaid/first_time_use"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/first_time_use/confirm"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Add device number
        "/single_player/prepaid/add_device_number"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/add_device_number/confirm"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/add_device_number/invalid_input"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            device_number = "548786547821356478"
        }
        "/single_player/prepaid/add_device_number/more_information"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/add_device_number/understood_information"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Products
        "/single_player/prepaid/product_list"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/product_list/selected_product"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "14"
        }


        // Recommended products
        "/single_player/prepaid/recommended_products"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/recommended_products/selected_product"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "7"
        }
        "/single_player/prepaid/recommended_products/more_products"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "7"
        }


        // Add alias
        "/single_player/prepaid/add_alias"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/add_alias/confirm"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/add_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            alias = "^_)(&/843sakdj*-%*L"
        }


        // Edit alias
        "/single_player/prepaid/edit_alias"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/edit_alias/confirm_edit"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/edit_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            alias = "^_)(&/843sakdj*-%*L"
        }
        "/single_player/prepaid/edit_alias/delete"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/edit_alias/confirm_delete"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/edit_alias/cancel_delete"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // One device
        "/single_player/prepaid/one_device"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/one_device/edit_alias"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/one_device/selected_product"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "4"
        }
        "/single_player/prepaid/one_device/more_products"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "7"
        }
        "/single_player/prepaid/one_device/another_device"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Multiple devices
        "/single_player/prepaid/multiple_devices"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/multiple_devices/selected_device"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "9"
        }
        "/single_player/prepaid/multiple_devices/another_device"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Congrats success
        "/single_player/prepaid/congrats_success"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_success/show_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_success/add_alias"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_success/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_success/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_success/open_external_application"(platform: "/mobile", type: TrackType.Event) {
            flow = "transport"
            application_name = "sube"
        }


        // Congrats rejected
        "/single_player/prepaid/congrats_rejected"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_rejected/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_rejected/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Congrats pending
        "/single_player/prepaid/congrats_pending"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_pending/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_pending/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Congrats alias
        "/single_player/prepaid/congrats_alias"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/congrats_alias/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/congrats_alias/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Internal error
        "/single_player/prepaid/error/internal"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/error/internal/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/error/internal/back"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Server error
        "/single_player/prepaid/error/server"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            error_code = "3"
        }

        "/single_player/prepaid/error/server/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/error/server/back"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Connection error
        "/single_player/prepaid/error/connection"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/error/connection/retry"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/error/connection/back"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Shield
        "/single_player/prepaid/shield"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Contingency
        "/single_player/prepaid/contingency"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/contingency/confirm"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/contingency/back"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/contingency/abort"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }



        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Meli
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //FTU
        "/single_player/prepaid/first_time_use"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/first_time_use/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Add device number
        "/single_player/prepaid/add_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/add_device_number/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/add_device_number/invalid_input"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            device_number = "548786547821356478"
        }
        "/single_player/prepaid/add_device_number/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/add_device_number/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Products
        "/single_player/prepaid/product_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/product_list/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "14"
        }


        // Recommended products
        "/single_player/prepaid/recommended_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/recommended_products/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "7"
        }
        "/single_player/prepaid/recommended_products/more_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "7"
        }


        // Add alias
        "/single_player/prepaid/add_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/add_alias/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/add_alias/invalid_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            alias = "^_)(&/843sakdj*-%*L"
        }


        // Edit alias
        "/single_player/prepaid/edit_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/edit_alias/confirm_edit"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/edit_alias/invalid_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            alias = "^_)(&/843sakdj*-%*L"
        }
        "/single_player/prepaid/edit_alias/delete"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/edit_alias/confirm_delete"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/edit_alias/cancel_delete"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // One device
        "/single_player/prepaid/one_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/one_device/edit_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/one_device/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "4"
        }
        "/single_player/prepaid/one_device/more_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "7"
        }
        "/single_player/prepaid/one_device/another_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Multiple devices
        "/single_player/prepaid/multiple_devices"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/multiple_devices/selected_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "9"
        }
        "/single_player/prepaid/multiple_devices/another_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Congrats success
        "/single_player/prepaid/congrats_success"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_success/show_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_success/add_alias"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_success/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_success/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_success/open_external_application"(platform: "/mobile", type: TrackType.Event) {
            flow = "transport"
            application_name = "sube"
        }


        // Congrats rejected
        "/single_player/prepaid/congrats_rejected"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_rejected/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_rejected/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Congrats pending
        "/single_player/prepaid/congrats_pending"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_pending/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/congrats_pending/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Congrats alias
        "/single_player/prepaid/congrats_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/congrats_alias/another_recharge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/congrats_alias/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Internal error
        "/single_player/prepaid/error/internal"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/error/internal/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/error/internal/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Server error
        "/single_player/prepaid/error/server"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            error_code = "3"
        }

        "/single_player/prepaid/error/server/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/error/server/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Connection error
        "/single_player/prepaid/error/connection"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/error/connection/retry"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/single_player/prepaid/error/connection/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Shield
        "/single_player/prepaid/shield"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Contingency
        "/single_player/prepaid/contingency"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/single_player/prepaid/contingency/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/contingency/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/single_player/prepaid/contingency/abort"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
    }
}