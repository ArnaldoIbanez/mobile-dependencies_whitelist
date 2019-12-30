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
        "/sp_prepaid/first_time_use"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0B2D62F4-AC8A-4FEE-A70E-FDE5DCAF4519"
        }
        "/sp_prepaid/first_time_use/confirm"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Add device number
        "/sp_prepaid/add_device_number"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/add_device_number/confirm"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/add_device_number/invalid_input"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            device_number = "548786547821356478"
        }
        "/sp_prepaid/add_device_number/more_information"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/add_device_number/understood_information"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Products
        "/sp_prepaid/product_list"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/product_list/selected_product"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "14"
        }


        // Recommended products
        "/sp_prepaid/recommended_product"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/recommended_product/selected_product"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "7"
        }
        "/sp_prepaid/recommended_product/more_products"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Add alias
        "/sp_prepaid/add_alias"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/add_alias/confirm"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/add_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            alias = "^_)(&/843sakdj*-%*L"
        }


        // Edit alias
        "/sp_prepaid/edit_alias"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/edit_alias/confirm_edit"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/edit_alias/invalid_alias"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            alias = "^_)(&/843sakdj*-%*L"
        }
        "/sp_prepaid/edit_alias/delete"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/edit_alias/confirm_delete"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/edit_alias/cancel_delete"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // One device
        "/sp_prepaid/one_device"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/one_device/edit_alias"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/one_device/selected_product"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "4"
        }
        "/sp_prepaid/one_device/more_products"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/one_device/another_device"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Multiple devices
        "/sp_prepaid/multiple_devices"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/multiple_devices/selected_device"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "9"
        }
        "/sp_prepaid/multiple_devices/another_device"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Congrats
        "/sp_prepaid/congrats/show_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/sp_prepaid/congrats/add_alias"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/sp_prepaid/congrats/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/sp_prepaid/congrats/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Congrats alias
        "/sp_prepaid/congrats_alias"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/congrats_alias/another_recharge"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/congrats_alias/back_to_home"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Errors
        "/sp_prepaid/error"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            error_type = "internal"
        }
        "/sp_prepaid/error"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            error_type = "server"
        }
        "/sp_prepaid/error"(platform: "/mobile", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            error_type = "connection"
        }

        "/sp_prepaid/error/action"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            type = "retry"
        }
        "/sp_prepaid/error/action"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            type = "back_to_home"
        }
        "/sp_prepaid/error/action"(platform: "/mobile", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            type = "back"
        }



        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Meli
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //FTU
        "/sp_prepaid/first_time_use"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0B2D62F4-AC8A-4FEE-A70E-FDE5DCAF4519"
        }
        "/sp_prepaid/first_time_use/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Add device number
        "/sp_prepaid/add_device_number"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/add_device_number/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/add_device_number/invalid_input"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            device_number = "548786547821356478"
        }
        "/sp_prepaid/add_device_number/more_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/add_device_number/understood_information"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Products
        "/sp_prepaid/product_list"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/product_list/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "14"
        }


        // Recommended products
        "/sp_prepaid/recommended_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/recommended_product/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "7"
        }
        "/sp_prepaid/recommended_product/more_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Add alias
        "/sp_prepaid/add_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/add_alias/confirm"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/add_alias/invalid_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            alias = "^_)(&/843sakdj*-%*L"
        }


        // Edit alias
        "/sp_prepaid/edit_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/edit_alias/confirm_edit"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/edit_alias/invalid_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            alias = "^_)(&/843sakdj*-%*L"
        }
        "/sp_prepaid/edit_alias/delete"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/edit_alias/confirm_delete"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/edit_alias/cancel_delete"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // One device
        "/sp_prepaid/one_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/one_device/edit_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/one_device/selected_product"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "4"
        }
        "/sp_prepaid/one_device/more_products"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/one_device/another_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Multiple devices
        "/sp_prepaid/multiple_devices"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/multiple_devices/selected_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            item_id = "9"
        }
        "/sp_prepaid/multiple_devices/another_device"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Congrats
        "/sp_prepaid/congrats/show_receipt"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/sp_prepaid/congrats/add_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/sp_prepaid/congrats/another_recharge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }
        "/sp_prepaid/congrats/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }


        // Congrats alias
        "/sp_prepaid/congrats_alias"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/congrats_alias/another_recharge"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }
        "/sp_prepaid/congrats_alias/back_to_home"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
        }


        // Errors
        "/sp_prepaid/error"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            error_type = "internal"
        }
        "/sp_prepaid/error"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            error_type = "server"
        }
        "/sp_prepaid/error"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            error_type = "connection"
        }
        "/sp_prepaid/error"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
        }

        "/sp_prepaid/error/action"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            type = "retry"
        }
        "/sp_prepaid/error/action"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            type = "back_to_home"
        }
        "/sp_prepaid/error/action"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            flow = "antenna"
            session_id = "0b2d62f4-ac8a-4fee-a70e-fde5dcaf4519"
            view_time = 38927
            type = "back"
        }

    }
}