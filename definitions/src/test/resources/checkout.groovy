package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"






    test("Checkout Basic Flow test. Legacy test for previous mobile versions") {

        def defaultCheckoutInformation = {
            checkout_version = "V2"
        }

        def defaultCheckoutPaymentInformation = {
            current_type="credit_card"
            available_other_methods=true
            available_types=[]
            current_method="visa"
        }

        def defaultCheckoutIItemsInformation = {
            items = [[
                             unit_price: 100,
                             quantity: 1,
                             item: [
                                     category_id: "MLB63385",
                                     buying_mode: "buy_it_now",
                                     id: "MLB754486062",
                                     shipping_mode: "me2"
                             ],
                             currency_id: "BRL"
                     ]]
        }

        //Checkout Apps Legacy
        "/checkout"(platform:"/mobile") {
            defaultCheckoutInformation()
            quantity_pre_selected=1
            order_payment_required=false
        }

        "/checkout/abort"(platform:"/mobile") {}

        "/checkout/back"(platform:"/mobile") {}

        "/checkout/congrats/back"(platform:"/mobile") {
            defaultCheckoutIItemsInformation()
        }

        "/checkout/abort"(platform:"/mobile") {}

        "/checkout/failure"(platform:"/mobile") {
            error = "error loading checkout"
            message = "content"
        }

        "/checkout/payment_selection" (platform:"/mobile"){
            defaultCheckoutInformation()
            defaultCheckoutPaymentInformation()
        }

        "/checkout/payment_selection/apply" (platform:"/mobile", type:TrackType.Event){
            defaultCheckoutInformation()
            defaultCheckoutPaymentInformation()
            type = "cash"
        }

        "/checkout/payment_selection/back" (platform:"/mobile"){
            defaultCheckoutInformation()
            defaultCheckoutPaymentInformation()

        }

        "/checkout/payment_selection/othertype" (platform: "/mobile"){
            defaultCheckoutInformation()
            defaultCheckoutPaymentInformation()
            available_methods=["efecty", "davivienda"]
        }

        "/checkout/payment_selection/othertype/back" (platform: "/mobile"){
            defaultCheckoutInformation()
            defaultCheckoutPaymentInformation()
            available_methods=["efecty", "davivienda"]
        }

        "/checkout/payment_selection/othertype" (platform: "/mobile"){
            defaultCheckoutInformation()
            defaultCheckoutPaymentInformation()
            available_methods=["efecty", "davivienda"]
        }

        def defaultCheckoutShippingInformation = {
            available_types=[]
            current_type="to_agree"
            current_option="to_agree"
        }

        "/checkout/shipping_selection" (platform:"/mobile"){
            defaultCheckoutInformation()
            defaultCheckoutShippingInformation()
        }

        "/checkout/shipping_selection/apply" (platform:"/mobile"){
            defaultCheckoutInformation()
            defaultCheckoutShippingInformation()
            type = "known_cost"
        }

        "/checkout/shipping_selection/back" (platform:"/mobile", type:TrackType.Event){
            defaultCheckoutInformation()
            defaultCheckoutShippingInformation()
        }

        "/checkout/shipping_selection/address_selection" (platform:"/mobile"){
            defaultCheckoutInformation()
            defaultCheckoutShippingInformation()
            invalid_address = 1
            valid_address = 0
        }

        "/checkout/shipping_selection/address_selection/back" (platform:"/mobile"){
            defaultCheckoutInformation()
            defaultCheckoutShippingInformation()
            invalid_address = 1
            valid_address = 0
        }

        "/checkout/shipping_cost" (platform: "/mobile"){
            defaultCheckoutInformation()
        }

        "/checkout/shipping_cost/apply" (platform: "/mobile"){
            defaultCheckoutInformation()
        }

        "/checkout/shipping_cost/back" (platform: "/mobile"){
            defaultCheckoutInformation()
        }

        "/checkout/contact_add" (platform: "/mobile"){}

        "/checkout/contact_seller_call" (platform: "/mobile"){}

        "/checkout/contact_seller_email" (platform: "/mobile"){}

        "/checkout/order_total" (platform: "/mobile"){}

        "/checkout/order_total/back" (platform: "/mobile"){}

        "/checkout/quantity_changed" (platform: "/mobile"){
            quantity = 10
        }

        "/checkout/screenshot" (platform: "/mobile"){}

        "/checkout/" (platform: "/mobile"){}

        "/checkout/" (platform: "/mobile"){}

        "/checkout/" (platform: "/mobile"){}
    }

    //Checkout Apps
    test("checkout wizard flow") {
        //Default track data
        def checkoutStatus = {
            buyer = [
                    nickname: "JUANCHOMLB",
                    id: "208346754"
            ]
            order_id = "null"
            items = [[
                             unit_price: 100,
                             quantity: 1,
                             item: [
                                     category_id: "MLB63385",
                                     buying_mode: "buy_it_now",
                                     id: "MLB754486062",
                                     shipping_mode: "me2"
                             ],
                             currency_id: "BRL"
                     ]]
            payments = [[
                                payment_type: "credit_card",
                                payment_method: "amex",
                                id: "23cfddb085c577f0584ab78e17861c63be386608",
                                paid_amount: 0.0
                        ]]
            platform = "/mobile/android"
            seller = [[
                              id: "208642594"
                      ]]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]

            buy_equal_pay = true
            recovery_flow = true
            total_amount = 100.0
            total_amount_with_shipping = 125.979996
            total_paid_amount = 0.0
            reservation_price = 50
            vertical = "MOTORS"
        }

        "/checkout/wrapper"(platform:"/mobile", type:TrackType.View) {}
        "/checkout/init"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            success = true
            location = "34.677755,56.444433"
            geolocation_method = "platform"
        }
        "/checkout/init/options"(platform:"/mobile", type:TrackType.Event) {
            payment_data = "[credit_card:-, ticket:abitab, ticket:redpagos, cash:cash]"
            shipping_data = ["mercadoenvios", "local_pick_up"]
        }
        "/checkout/geolocation"(platform:"/mobile", type:TrackType.Event) {
            geolocation_error = "TIMEOUT"
        }
        "/checkout/shipping/select_method"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            //List of available shippingMethods
            selections = ["shipping_other", "local_pick_up"]
        }
        "/checkout/shipping/select_method/inconsistency"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            error_code = "cant_buy_quantity"
            inconsistency = "cant_sent_x_units"
            selections = ["shipping_geo", "shipping_other", "local_pick_up"]
        }
        "/checkout/shipping/select_method/ask_enable_geolocation"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            //List of available shippingMethods
            selections = ["shipping_other", "local_pick_up"]
        }
        "/checkout/shipping/select_method/ask_enable_geolocation#geolocation_permission_ask"(platform:"/mobile", type: TrackType.Event) {
            //granted
            granted = "yes"
        }
        "/checkout/shipping/select_method/ask_enable_geolocation#geolocation_enabled"(platform:"/mobile", type: TrackType.Event) {
            //status
            status = "on"
        }
        "/checkout/shipping/select_method/ask_enable_geolocation#unable_to_use_location_services"(platform:"/mobile", type: TrackType.Event) {}
        "/checkout/shipping/select_method/geolocated"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            //List of available shippingMethods
            selections = ["shipping_geo", "shipping_other", "local_pick_up"]
        }
        "/checkout/shipping/custom_address/zip_code"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/shipping/custom_address/zip_code#zip_code"(platform:"/mobile", type: TrackType.Event) {
            zip_code = "1437"
        }
        "/checkout/shipping/custom_address/zip_code#street_name"(platform:"/mobile", type: TrackType.Event) {
            street_name = "Av. Colonia"
        }
        "/checkout/shipping/custom_address/zip_code#street_number"(platform:"/mobile", type: TrackType.Event) {
            street_number = "170"
        }
        "/checkout/shipping/custom_address/zip_code#internal_number"(platform:"/mobile", type: TrackType.Event) {
            internal_number = "34"
        }
        "/checkout/shipping/custom_address/zip_code#between_streets"(platform:"/mobile", type: TrackType.Event) {
            between_streets = "Patagones y Uspallata"
        }
        "/checkout/shipping/custom_address/zip_code#references"(platform:"/mobile", type: TrackType.Event) {
            references = "Edificio CMD"
        }
        "/checkout/shipping/custom_address/zip_code#neighborhood"(platform:"/mobile", type: TrackType.Event) {
            neighborhood = "Parque Patricios"
        }
        "/checkout/shipping/custom_address/zip_code#additional_info"(platform:"/mobile", type: TrackType.Event) {
            additional_info = "1er piso"
        }
        "/checkout/shipping/custom_address/zip_code#submit"(platform:"/mobile", type: TrackType.Event) {}

        "/checkout/shipping/custom_address/zip_code/query"(platform:"/mobile", type:TrackType.View) {}
        "/checkout/shipping/custom_address/zip_code/query#submit"(platform:"/mobile", type: TrackType.Event) {
            query_parameters = "Mexico D.F."
        }
        "/checkout/shipping/custom_address/zip_code/query/back"(platform:"/mobile", type:TrackType.Event) {}
        "/checkout/shipping/select_option/mercado_envios"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            //List of available shippingMethods
            shipping_options = [
                    [
                            method_name: "Normal",
                            price: 0.0,
                            currency_id: "ARS",
                            free_shipping: true
                    ],
                    [
                            method_name: "Expreso",
                            price: 50.46,
                            currency_id: "ARS",
                            free_shipping: false
                    ]
            ]
        }
        "/checkout/shipping/select_option/free_shipping"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            //List of available shippingMethods
            shipping_options = [
                    [
                            method_name: "Gratis a todo el país",
                            price: 0.0,
                            currency_id: "ARS",
                            free_shipping: true
                    ]
            ]
        }
        "/checkout/shipping/select_option/custom"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            //List of available shippingMethods
            shipping_options = [
                    [
                            method_name: "Zona 1",
                            price: 0.0,
                            currency_id: "ARS",
                            free_shipping: false
                    ]
            ]
        }
        "/checkout/shipping/select_contact"(platform:"/mobile", type:TrackType.Event) {
            is_from_preload_address = true
        }
        "/checkout/shipping/location/select_state"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/shipping/location/select_city"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/shipping/location/select_city/invalid_destination"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/shipping/location/address"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            edit_flow = true
        }
        "/checkout/shipping/location/address#street_name"(platform: "/mobile", type: TrackType.Event) {
            street_name = "streetName"
        }
        "/checkout/shipping/location/address#street_number"(platform: "/mobile", type: TrackType.Event) {
            street_number = "streetNumber"
        }
        "/checkout/shipping/location/address#additional_info"(platform: "/mobile", type: TrackType.Event) {
            additional_info = "additionalInfo"
        }
        "/checkout/shipping/location/address#internal_number"(platform: "/mobile", type: TrackType.Event) {
            internal_number = "internalNumber"
        }
        "/checkout/shipping/location/address#between_streets"(platform: "/mobile", type: TrackType.Event) {
            between_streets = "betweenStreets"
        }
        "/checkout/shipping/location/address#references"(platform: "/mobile", type: TrackType.Event) {
            references = "references"
        }
        "/checkout/shipping/location/address#neighborhood"(platform: "/mobile", type: TrackType.Event) {
            neighborhood = "neighborhood"
        }
        "/checkout/shipping/location/select_contact#submit"(platform:"/mobile", type: TrackType.Event) {
            success = true
            error_codes = ["street_name_error"]
        }
        "/checkout/shipping/location/select_contact"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_options = 2
        }
        "/checkout/shipping/location/find_contact"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/shipping/location/new_contact"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            contact_name = "Juan"
            contact_phone = "555-5555"
        }
        "/checkout/shipping/select_address"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            //List of available shippingMethods
            shipping_options = [
                    [
                            method_name: "Zona 1",
                            price: 0.0,
                            currency_id: "ARS",
                            free_shipping: false
                    ]
            ]
        }
        "/checkout/shipping/select_address/list"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/shipping/select_store_map"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/shipping/select_store_map#agencies_request"(platform:"/mobile", type:TrackType.Event) {
            item_id = "MLA12341"
            latitude = "-33,312313"
            longitude = "-58,929484"
            agencies = 10
        }

        "/checkout/shipping/select_store_map#agencies_request"(platform:"/mobile", type:TrackType.Event) {
            item_id = "MLA12341"
            agencies = 10
        }

        "/checkout/payment/preload_credit_card"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/select_method"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_methods = ["visa", "master", "amex", "cash"]
            coupon = true
            coupon_discount = 20
        }
        "/checkout/payment/select_method#new_payment_method_selected"(platform:"/mobile",  type: TrackType.Event) {
            payment_method_id = "payment_method_id"
            payment_type_id = "payment_type_id"
        }
        "/checkout/payment/coupon_detail"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/add_debit_card"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/add_debit_card#card_config"(platform:"/mobile", type: TrackType.Event) {
            bin = "123456"
            success = true
        }
        "/checkout/payment/add_debit_card/select_bank"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_issuers = ["Visa", "Banamex", "Santander"]
        }
        "/checkout/payment/add_prepaid_card"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/add_prepaid_card#card_config"(platform:"/mobile", type: TrackType.Event) {
            bin = "123456"
            success = true
        }
        "/checkout/payment/add_card"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/add_card#card_config"(platform:"/mobile", type: TrackType.Event) {
            bin = "123456"
            success = true
        }
        "/checkout/payment/add_card/select_bank"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_issuers = ["Visa", "Banamex", "Santander"]
        }
        "/checkout/payment/add_card/installments"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_installments = [
                    [
                            installment: 1,
                            amount: 20.6,
                            without_fee: true
                    ],
                    [
                            installment: 3,
                            amount: 7.2,
                            without_fee: true
                    ],
                    [
                            installment: 6,
                            amount: 3.2,
                            without_fee: true
                    ]
            ]
        }
        "/checkout/payment/stored_card/select_bank"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_methods = ["industrial", "bancor", "santander"]
        }
        "/checkout/payment/stored_card/security_code"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            user_identification_fields = ["doc_type", "doc_number"]
        }
        "/checkout/payment/stored_card/installments"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            credit_card_id = "1234"
            available_installments = [
                    [
                            installment: 1,
                            amount: 20.6,
                            without_fee: true
                    ],
                    [
                            installment: 3,
                            amount: 7.2,
                            without_fee: true
                    ],
                    [
                            installment: 6,
                            amount: 3.2,
                            without_fee: true
                    ]
            ]
        }
        "/checkout/payment/stored_card/installments#change_payment_method"(platform:"/mobile", type:TrackType.Event) {
            event_source = "installments_row"
        }
        "/checkout/payment/account_money/create"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/account_money/password"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/account_money/password#submit"(platform:"/mobile", type:TrackType.Event) {}
        "/checkout/payment/select_issuer"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/cash/select_store"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_methods = ["telecomm", "oxxo", "bancomer", "banamex"]
        }
        "/checkout/payment/cash/select_store/select_address"(platform:"/mobile") {}
        "/checkout/payment/cash/select_store#request_permissions"(platform:"/mobile", type: TrackType.Event) {
            permissions = "android.permission.ACCESS_FINE_LOCATION"
            extended = true
        }
        "/checkout/payment/transfer/select_bank"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_methods = ["telecomm", "bancomer", "banamex"]
        }
        "/checkout/payment/billing_info"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            user_identification_fields: ["doc_type", "doc_number", "name", "las_name"]
        }
        "/checkout/payment/billing_info#submit"(platform:"/mobile", type:TrackType.Event) {
            billing_info_state = "same_billing_info"
        }
        "/checkout/payment/promotions"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/consumer_credits/installments"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_installments = [
                    [
                            installment: 1,
                            amount: 20.6,
                            without_fee: true
                    ],
                    [
                            installment: 3,
                            amount: 7.2,
                            without_fee: true
                    ],
                    [
                            installment: 6,
                            amount: 3.2,
                            without_fee: true
                    ]
            ]
        }
        "/checkout/payment/payment_combination/debit_card"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }

        "/checkout/payment/payment_combination/payment_method_not_supported"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }

        // Discount Coupons
        "/checkout/payment/add_coupon"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/coupon_ok"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            coupon = "coupon1,coupon2"
        }
        "/checkout/payment/add_another_coupon"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/coupon_error"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/payment/invalid_coupon"(platform:"/mobile", type:TrackType.Event) {
            checkoutStatus()
        }
        "/checkout/payment/expired_coupon"(platform:"/mobile", type:TrackType.Event) {
            checkoutStatus()
        }
        "/checkout/payment/add_another_coupon/delete_coupon"(platform:"/mobile", type:TrackType.Event) {
            checkoutStatus()
        }

        "/checkout/payment/select_type"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }

        "/checkout/billing/physical_person"(platform: "/mobile") {
            checkoutStatus()
        }
        "/checkout/billing/legal_person"(platform: "/mobile") {
            checkoutStatus()
        }
        "/checkout/review/edit_billing_info"(platform: "/mobile", type: TrackType.Event) {
        }

        "/checkout/review#submit"(platform:"/mobile", type:TrackType.Event) {
            status = "success"
            checkout_flow = "direct"
        }
        "/checkout/review/quantity#submit"(platform:"/mobile", type: TrackType.Event) {
            old_quantity = 4
            selected_quantity = 1
        }
        "/checkout/review/quantity"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/review/quantity/input"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/review/inconsistency/quantity"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            error_code ="invalid_volume_for_quantity"
        }
        "/checkout/review/inconsistency/price_changed"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/review/edit_shipping#submit"(platform:"/mobile", type: TrackType.Event) {
            //old_value, new_value
            old_value = "Zona 1"
            new_value = "Acuerdo"
        }
        "/checkout/review/edit_shipping"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            //List of available shippingMethods
            shipping_options = [
                    [
                            method_name: "Zona 1",
                            price: 0.0,
                            currency_id: "ARS",
                            free_shipping: false
                    ]
            ]
        }
        "/checkout/review/inconsistency/edit_shipping"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            error_code = "invalid_volume_for_quantity"
        }
        "/checkout/review/edit_installments"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_installments = [
                    [
                            installment: 1,
                            amount: 20.6,
                            without_fee: true
                    ]
            ]
        }
        "/checkout/review/edit_installments#submit"(platform: "/mobile", type: TrackType.Event) {
            //old_value, new_value
            old_value = 3
            new_value = 9
        }
        "/checkout/review/terms"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/additional_info"(platform: "/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/finish/call_for_auth/instructions"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/finish/call_for_auth/later"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/finish/invalid_sec_code/input"(platform:"/mobile", type:TrackType.View) {
        }

        "/checkout/finish/choose_action"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }

        "/checkout/finish/second_step/error_details"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }

        "/checkout/finish#click"(platform: "/mobile", type: TrackType.Event) {
            action = 'call_seller'
        }

        "/checkout/error"(platform:"/mobile", type:TrackType.View) {
            error_code = "internal_server_error"
        }
        "/checkout/show_ticket"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/show_ticket#save"(platform:"/mobile", type:TrackType.Event) {}
        "/checkout/show_geolocation_map"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            payment_method = "telecomm"
        }
        "/checkout/show_geolocation_map/search"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            payment_method = "telecomm"
        }
        "/checkout/show_geolocation_map/search#location"(platform:"/mobile", type:TrackType.Event) {}
        "/checkout/show_geolocation_map/search#preloaded"(platform:"/mobile", type:TrackType.Event) {}
        "/checkout/show_geolocation_map/search#select"(platform:"/mobile", type:TrackType.Event) {}
        "/checkout/show_geolocation_map#agencies_request"(platform:"/mobile", type:TrackType.Event) {
            payment_method = "telecomm"
            agencies = 10
        }
    }

    test("checkout congrats"){

        "/checkout/congrats"(platform:"/mobile", type:TrackType.View) {
            payments = [
                    [
                            payment_method:"amex",
                            payment_type:"credit_card",
                            installments:3,
                            selected_card:"146872309",
                            financed_order_cost_for_card:13.00

                    ]
            ]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]

            items = [
                    [
                            currency_id: "BRL",
                            item: [
                                    id: "MLB683236263",
                                    category_path: [ "MLB1499", "MLB2467", "MLB30216" ],
                                    buying_mode: "buy_it_now",
                                    category_id: "MLB30216",
                                    variation_id: null
                            ],
                            quantity: 1,
                            unit_price: 70
                    ]
            ]

            order_id=912391
        }

        //Checkout Desktop
        "/checkout/ordercreated"(platform:"/web/desktop", type:TrackType.Event) {
            congrats_seq = 1
            total_amount = 70
            order_id = 991687837
            status = "payment_required"
            seller = [[ id: 135201044, nickname: "JPS PAULO" ]]
            first_for_order = true
            errors = false
            buyer = [ id: 75961818, nickname: "CIA51" ]
            items = [
                    [
                            currency_id: "BRL",
                            item: [
                                    id: "MLB683236263",
                                    category_path: [ "MLB1499", "MLB2467", "MLB30216" ],
                                    buying_mode: "buy_it_now",
                                    category_id: "MLB30216",
                                    variation_id: null
                            ],
                            quantity: 1,
                            unit_price: 70
                    ]
            ]
            total_amount_local = 70
            total_amount_usd = 19.72
            platform = "/web/desktop"
        }

        "/checkout/login/confirm_authenticated"(platform:"/web/desktop") {
            vip_parameters=[
                    cht:1459801088940,
                    pm:"master",
                    inst:"6",
                    bp:"Y",
                    zip_code:"1416",
                    shipping_method_id:"509341521",
                    ship_method_id:"501045",
                    ship_option_id:"509341521",
                    cc_issuer:"297",
                    is_logged:"true",
                    prefs_on:"COOKIE"
            ]
        }

        "/checkout/login/first_purchase_not_authenticated"(platform:"/web/desktop") {
            vip_parameters=[
                    cht:1459800702645,
                    pm:"master",
                    inst:"6",
                    bp:"Y",
                    zip_code:"1418",
                    shipping_method_id:"391232427",
                    ship_method_id:"73330",
                    ship_option_id:"391232427",
                    cc_issuer:"297",
                    is_logged:"false",
                    prefs_on:"NONE"
            ]
        }

        "/checkout/login/confirm_not_authenticated"(platform:"/web/desktop") {
            vip_parameters=[
                    cht:1459800702645,
                    pm:"master",
                    inst:"6",
                    bp:"Y",
                    zip_code:"1418",
                    shipping_method_id:"391232427",
                    ship_method_id:"73330",
                    ship_option_id:"391232427",
                    cc_issuer:"297",
                    is_logged:"false",
                    prefs_on:"NONE"
            ]
        }

        "/checkout/payments/select_payment_method"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=2000
            total_amount_with_shipping=2087.99
            total_paid_amount=3373.98
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"visa",
                            payment_type:"credit_card",
                            installments:12,
                            paid_amount:3373.98,
                            installment_amount:281.17,
                            without_fee:false
                    ]
            ]


            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]

            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:2000,
                            currency_id:"ARS"
                    ]
            ]
        }

        "/checkout/payments/select_payment_type"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=2000
            total_amount_with_shipping=2087.99
            total_paid_amount=3373.98
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"visa",
                            payment_type:"credit_card",
                            installments:12,
                            paid_amount:3373.98,
                            installment_amount:281.17,
                            without_fee:false
                    ]
            ]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]


            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:2000,
                            currency_id:"ARS"
                    ]
            ]
        }

        "/checkout/payments/select_split_payment"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=2000
            total_amount_with_shipping=2087.99
            total_paid_amount=3373.98
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"visa",
                            payment_type:"credit_card",
                            installments:12,
                            paid_amount:3373.98,
                            installment_amount:281.17,
                            without_fee:false
                    ]
            ]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]


            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:2000,
                            currency_id:"ARS"
                    ]
            ]
        }

        "/checkout/payments/input_proactive_payment_amount"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=2000
            total_amount_with_shipping=2087.99
            total_paid_amount=3373.98
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"visa",
                            payment_type:"credit_card",
                            installments:12,
                            paid_amount:3373.98,
                            installment_amount:281.17,
                            without_fee:false
                    ]
            ]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]

            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:2000,
                            currency_id:"ARS"
                    ]
            ]
        }

        "/checkout/payments/select_payment_method"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=200
            total_amount_with_shipping=200
            total_paid_amount=200
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:200,
                            currency_id:"BRL"
                    ]
            ]

        }

        "/checkout/payments/select_payment_method"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=200
            total_amount_with_shipping=200
            total_paid_amount=200
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"bolbradesco",
                            payment_type:"ticket",
                            installments:1,
                            paid_amount:200,
                            installment_amount:200,
                            without_fee:true
                    ]
            ]
            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:200,
                            currency_id:"BRL"
                    ]
            ]

        }

        "/checkout/payments/select_payment_method"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=2000
            total_amount_with_shipping=2087.99
            total_paid_amount=3373.98
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"visa",
                            payment_type:"credit_card",
                            installments:12,
                            paid_amount:3373.98,
                            installment_amount:281.17,
                            without_fee:false
                    ]
            ]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]


            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:2000,
                            currency_id:"ARS"
                    ]
            ]
        }

        "/checkout/payments/installments#submit"(platform:"/web/desktop", type: TrackType.Event) {
            pay_pref_id="ABCD1234"
            total_price=1000
            preferred_installment=6
            max_installments_without_fee=12
            selected_installment = 3

            order_id=1234
            status="payment_required"
            total_amount=2000
            total_amount_with_shipping=2087.99
            total_paid_amount=3373.98
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"visa",
                            payment_type:"credit_card",
                            installments:12,
                            paid_amount:3373.98,
                            installment_amount:281.17,
                            without_fee:false
                    ]
            ]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]

            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:2000,
                            currency_id:"ARS"
                    ]
            ]
        }

        "/checkout/review"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=2000
            total_amount_with_shipping=2087.99
            total_paid_amount=3373.98
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"visa",
                            payment_type:"credit_card",
                            installments:12,
                            paid_amount:3373.98,
                            installment_amount:281.17,
                            without_fee:false
                    ]
            ]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]

            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:2000,
                            currency_id:"ARS"
                    ]
            ]
        }

        "/checkout/review"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=200
            total_amount_with_shipping=200
            total_paid_amount=200
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:200,
                            currency_id:"BRL"
                    ]
            ]
        }

        "/checkout/review"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=200
            total_amount_with_shipping=200
            total_paid_amount=200
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"bolbradesco",
                            payment_type:"ticket",
                            installments:1,
                            paid_amount:200,
                            installment_amount:200,
                            without_fee:true
                    ]
            ]
            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:200,
                            currency_id:"BRL"
                    ]
            ]
        }

        "/checkout/congrats"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=2000
            total_amount_with_shipping=2087.99
            total_paid_amount=3373.98
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"visa",
                            payment_type:"credit_card",
                            installments:12,
                            paid_amount:3373.98,
                            installment_amount:281.17,
                            without_fee:false,
                            status:"approved",
                            status_detail:"accredited"
                    ]
            ]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]

            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:2000,
                            currency_id:"ARS"
                    ]
            ]
            buyer=[
                    id:111111,
                    nickname:"buyer01"
            ]
            seller =[[
                             id:111222,
                             nickname:"seller02"
                     ]]
        }

        "/checkout/congrats"(platform:"/web/desktop") {
            order_id=1234
            status="payment_required"
            total_amount=2000
            total_amount_with_shipping=2000
            total_paid_amount=2000
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:2000,
                            currency_id:"ARS"
                    ]
            ]
            buyer=[
                    id:111111,
                    nickname:"buyer01"
            ]
            seller =[[
                             id:111222,
                             nickname:"seller02"
                     ]]
        }

    }

    test("checkout payment combination inconsistencies") {
        "/checkout/review/discard_payment_combination"(platform: "/mobile", type:TrackType.View) {}
        "/checkout/review/inconsistency/payment_combination/payment"(platform: "/mobile", type:TrackType.View) {}
        "/checkout/review/inconsistency/payment_combination/installments"(platform: "/mobile", type:TrackType.View) {}
        "/checkout/review/inconsistency/payment_combination/shipping"(platform: "/mobile", type:TrackType.View) {}
    }

    test("checkout payment combination switch events") {
        "/checkout/payment/2mp#use"(platform: "/mobile", type: TrackType.Event) {}
        "/checkout/payment/2mp#not_use"(platform: "/mobile", type: TrackType.Event) {}
    }

    test("checkout payment combination review") {
        "/checkout/review"(platform:"/mobile") {
            order_id=1234
            status="payment_required"
            total_amount=2000
            total_amount_with_shipping=2087.99
            total_paid_amount=3373.98
            buy_equal_pay=true
            recovery_flow=false
            register_int=false
            platform = "/web/desktop"
            payments=[
                    [
                            id:333,
                            payment_method:"visa",
                            payment_type:"credit_card",
                            installments:12,
                            paid_amount:3373.98,
                            installment_amount:281.17,
                            without_fee:false
                    ]
            ]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]

            items=[
                    [
                            item:[
                                    id:"MLA9876",
                                    variation_id:null,
                                    buying_mode:"buy_it_now",
                                    shipping_mode:"me2",
                                    category_id:"MLA1915",
                                    deal_ids:null
                            ],
                            quantity:1,
                            unit_price:2000,
                            currency_id:"ARS"
                    ]
            ]

            // 2MP switch state
            combination_2mp="on"
        }
    }

    test("checkout payments cancelation") {
        "/checkout/payments_cancelation"(platform: "/mobile", type:TrackType.View) {}
    }

    test("checkout onboard") {
        "/checkout/onboard"(platform: "/mobile", type:TrackType.View) {}
    }

    test("checkout summary payment detail expand/collapse") {
        "/checkout/review/display_detail#displayed"(platform: "/mobile", type: TrackType.Event) {}
        "/checkout/review/display_detail#closed"(platform: "/mobile", type: TrackType.Event) {}
    }



//------------------------------------------------------------------------------------------------------------------------------------------------------
// TRACKS CHECKOUT V5
//------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Checkout V5") {

        def dataSetCongrats = {
            status = "payment_required"
        }

        def dataSet = {

            buy_equal_pay = true
            recovery_flow = false
            register_int = false
            resolution = "high"

            precharged_cards = true

            total_amount=2000
            total_amount_with_shipping=2087.99
            total_paid_amount=3373.98

            seller = [
                    [id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                    [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]
            ]

            shipping = [
                    [
                            cost: 25.98,
                            shipping_mode: "me2",
                            shipping_type: "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name: "Normal",
                                            price: 0.0,
                                            currency_id: "ARS",
                                            free_shipping: true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name: "Expreso",
                                            price: 50.46,
                                            currency_id: "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]

            payments = [
                    [
                            id: "23cfddb085c577f0584ab78e17861c63be386608",
                            payment_type: "credit_card",
                            payment_method: "amex",
                            bank: "Santander Rio",
                            installments:12,
                            paid_amount:3373.98,
                            installment_amount:281.17,
                            without_fee:false,
                            payment_splitted:false,
                            status:"approved",
                            status_detail:"accredited"
                    ]
            ]

            items = [
                    [
                            currency_id: "ARS",
                            unit_price: 100,
                            quantity: 1,
                            item: [
                                    category_id: "MLA63385",
                                    buying_mode: "buy_it_now",
                                    category_path: [ "MLA1499", "MLA2467", "MLA754486062" ],
                                    id: "MLA754486062",
                                    official_store: "Adidas",
                                    condition: "new",
                                    listing_type: "gold_special",
                                    title: "Conector 12 Vias",
                                    shipping_mode: "me2"
                            ]
                    ],
                    [
                            currency_id: "ARS",
                            unit_price: 1000,
                            quantity: 3,
                            item: [
                                    category_id: "MLA63385",
                                    buying_mode: "buy_it_now",
                                    category_path: [ "MLA1499", "MLA2467", "MLA754486062" ],
                                    id: "MLA754486062",
                                    official_store: "SportCenter",
                                    condition: "new",
                                    listing_type: "gold_pro",
                                    title: "Conector 12 Vias",
                                    shipping_mode: "me2"
                            ]
                    ]
            ]
        }

        "/checkout/geolocation"(platform:"/web", type: TrackType.Event) {
            dataSet()
            geolocation_error = "TIMEOUT"
        }
        "/checkout/items_not_available"(platform:"/web", dataSet)
        "/checkout/error"(platform:"/web", dataSet)
        "/checkout/payment/select_method"(platform:"/web", dataSet)
        "/checkout/payment/select_method/edit_payment"(platform:"/web", dataSet)
        "/checkout/payment/select_method/show_distances"(platform:"/web", dataSet)
        "/checkout/payment/select_store"(platform:"/web", dataSet)
        "/checkout/payment/select_bank"(platform:"/web", dataSet)
        "/checkout/payment/view_location"(platform:"/web", dataSet)
        "/checkout/payment/view_location/location"(platform:"/web", dataSet)
        "/checkout/payment/view_location/preloaded"(platform:"/web", dataSet)
        "/checkout/payment/input_card"(platform:"/web", dataSet)
        "/checkout/payment/input_card/edit_payment"(platform:"/web", dataSet)
        "/checkout/payment/input_card/security_code_tooltip"(platform:"/web", dataSet)
        "/checkout/payment/select_installments"(platform:"/web", dataSet)
        "/checkout/payment/select_installments/close_splitter_message"(platform:"/web", dataSet)
        "/checkout/payment/select_installments/click_payment_detail"(platform:"/web", dataSet)
        "/checkout/payment/select_installments/click_box_installments"(platform:"/web", dataSet)
        "/checkout/payment/create_second_password"(platform:"/web", dataSet)
        "/checkout/payment/input_second_password"(platform:"/web", dataSet)
        "/checkout/payment/input_second_password/edit_payment"(platform:"/web", dataSet)
        "/checkout/review/edit_payment"(platform:"/web", dataSet)
        "/checkout/review/edit_first_payment"(platform:"/web", dataSet)
        "/checkout/review/edit_second_payment"(platform:"/web", dataSet)
        "/checkout/review/edit_shipping"(platform:"/web", dataSet)
        "/checkout/review/change_installments"(platform:"/web", dataSet)
        "/checkout/review/change_shipping"(platform:"/web", dataSet)
        "/checkout/review/change_address"(platform:"/web", dataSet)
        "/checkout/review/edit_shipping"(platform:"/web", dataSet)
        "/checkout/review/edit_payment_method"(platform:"/web", dataSet)
        "/checkout/congrats"(platform:"/web"){
            dataSet()
            dataSetCongrats()
        }
        "/checkout/congrats"(platform:"/web") {
            dataSet()
            dataSetCongrats()
            geolocated = true
        }
        "/checkout/finish/keep_buying"(platform:"/web"){
            dataSet()
            dataSetCongrats()
        }
        "/checkout/finish/go_to_myml"(platform:"/web"){
            dataSet()
            dataSetCongrats()
        }
        "/checkout/finish/go_to_page_bank"(platform:"/web") {
            dataSet()
            dataSetCongrats()
        }
        "/checkout/finish/view_ticket"(platform:"/web") {
            dataSet()
            dataSetCongrats()
        }
        "/checkout/finish/download_ticket"(platform:"/web") {
            dataSet()
            dataSetCongrats()
        }
        "/checkout/finish/show_map"(platform:"/web") {
            dataSet()
            dataSetCongrats()
        }
        "/checkout/finish/save_data"(platform:"/web") {
            dataSet()
            dataSetCongrats()
        }
        "/checkout/finish/contact_us"(platform:"/web") {
            dataSet()
            dataSetCongrats()
        }
        "/checkout/finish/go_to_mercado_puntos"(platform:"/web") {
            dataSet()
            dataSetCongrats()
        }
        "/checkout/finish/added_points"(platform:"/web") {
            dataSet()
            dataSetCongrats()
        }
        "/checkout/show_ticket"(platform:"/web", dataSet)
        "/checkout/invalid_sec_code"(platform:"/web", dataSet)
        "/checkout/invalid_sec_code/input_code"(platform:"/web", dataSet)
        "/checkout/call_for_auth"(platform:"/web", dataSet)
        "/checkout/call_for_auth/instructions"(platform:"/web", dataSet)
        "/checkout/call_for_auth/call_later"(platform:"/web", dataSet)
        "/checkout/call_for_auth/input_code"(platform:"/web", dataSet)
        "/checkout/shipping"(platform:"/web", dataSet)
        "/checkout/shipping/edit_address"(platform:"/web", dataSet)
        "/checkout/loading"(platform: "/web", dataSet)
        "/checkout/loading/error"(platform: "/web", dataSet)
        "/checkout/shipping/select_option"(platform:"/web", dataSet)
        "/checkout/shipping/input_zipcode"(platform:"/web", dataSet)
        "/checkout/shipping/input_zipcode/i_dont_know_my_cp"(platform:"/web", dataSet)
        "/checkout/shipping/input_address"(platform:"/web", dataSet)
        "/checkout/shipping/input_address_number"(platform:"/web", dataSet)
        "/checkout/shipping/input_address_number/whithout_number"(platform:"/web", dataSet)
        "/checkout/shipping/select_address"(platform:"/web", dataSet)
        "/checkout/shipping/select_option_detail"(platform:"/web", dataSet)
        "/checkout/shipping/input_address_apartment"(platform:"/web", dataSet)
        "/checkout/shipping/select_contact_info"(platform:"/web", dataSet)
        "/checkout/shipping/add_contact_info"(platform:"/web", dataSet)
        "/checkout/shipping/input_contact_info"(platform:"/web", dataSet)
        "/checkout/payment/select_unique_installment"(platform:"/web", dataSet)
        "/checkout/payment/select_first_installment"(platform:"/web", dataSet)
        "/checkout/payment/select_second_installment"(platform:"/web", dataSet)
        "/checkout/review/edit_unique_installment"(platform:"/web", dataSet)
        "/checkout/review/edit_first_installment"(platform:"/web", dataSet)
        "/checkout/review/edit_second_installment"(platform:"/web", dataSet)
        "/checkout/shipping"(platform:"/web", dataSet)
        "/checkout/shipping/confirm_geolocation"(platform:"/web", dataSet)
        "/checkout/shipping/confirm_geolocation/send_to_cp_located"(platform:"/web", dataSet)
        "/checkout/shipping/confirm_geolocation/send_to_another_location"(platform:"/web", dataSet)
        "/checkout/shipping/input_new_address"(platform:"/web", dataSet)
        "/checkout/payment/security_code"(platform:"/web", dataSet)
        "/checkout/finish/call_seller"(platform:"/web", dataSet)
        "/checkout/finish/send_message"(platform:"/web", dataSet)
        "/checkout/review/high_amount_error"(platform:"/web", dataSet)
        "/checkout/review/installments_error"(platform:"/web", dataSet)
        "/checkout/review/insufficient_account_money"(platform:"/web", dataSet)
        "/checkout/review/low_amount_error"(platform:"/web", dataSet)
        "/checkout/shipping/agencies_contact_info"(platform:"/web", dataSet)
        "/checkout/shipping/select_option/agency_pickup"(platform:"/web", dataSet)
        "/checkout/shipping/select_option/send_to_my_address"(platform:"/web", dataSet)
        "/checkout/shipping/store_selection"(platform:"/web", dataSet)

        // Suscripciones
        "/checkout/shipping"(platform:"/web") {
            dataSet()
            checkout_flow = "subscription"
        }

        "/checkout/shipping"(platform:"/web") {
            dataSet()
            checkout_flow = "direct"
        }

        "/checkout/review/edit_frequency"(platform:"/web") {
            frequency = "WEEKS_2"
            frequency_before = "WEEKS_3"
        }

    }

    test("Checkout recovery with recos - push notification flow") {
        "/checkout_recovery" (platform:"/web/mobile", type: TrackType.View) {
            item_id = "MLU451705243"
            item_status = "inactive"
        }
        "/checkout_recovery/error" (platform:"/web/mobile", type: TrackType.View) {
            item_id = "MLU451705243"
            item_status = "inactive"
        }
        "/checkout_recovery/notfound" (platform:"/web/mobile", type: TrackType.View) {
            item_id = "MLU451705243"
            item_status = "inactive"
        }
    }

    test ("checkout Legacy"){
        "/checkout/legacy/entry"(platform: "/mobile", type: TrackType.Event){
            checkout_version = "V1"
            order_payment_required = "false"
            payment_pre_selected = "none"
            shipping_pre_selected = "none"
            quantity_pre_selected = "1"
        }
        "/checkout/legacy/exit"(platform: "/mobile", type: TrackType.Event){
            checkout_version = "V1"
            payment_method = "visa"
            buy_equals_pay = "TRUE"
            shipping_type = "mercadoenvios"
        }

    }

}
