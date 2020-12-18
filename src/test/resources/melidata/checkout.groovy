package src.test.resources.melidata

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

        "/checkout/user_contact_information"(platform:"/", type:TrackType.Event) {}

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
            loyalty_level = 1
            context = "vip"
        }

        "/checkout/wrapper"(platform:"/mobile", type:TrackType.View) {}
        "/checkout/init"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            success = true
            location = "34.677755,56.444433"
            geolocation_method = "platform"
        }
        "/checkout/init/back"(platform:"/mobile", type:TrackType.Event) {
            checkoutStatus()
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
        "/checkout/shipping/accord"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            inconsistency = "only_to_agree"
            selections = ["to_agree"]
        }
        "/checkout/shipping/accord/back"(platform:"/mobile", type:TrackType.Event) {
            checkoutStatus()
            inconsistency = "only_to_agree"
            selections = ["to_agree"]
        }
        "/checkout/shipping/accord_shipping_and_payment"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            inconsistency = "agree_agree"
            selections = ["to_agree"]
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
            edit_flow = true
            checkoutStatus()
        }
        "/checkout/shipping/custom_address/zip_code/back"(platform:"/mobile", type:TrackType.Event) {
            edit_flow = true
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
        "/checkout/shipping/custom_address/zip_code#submit"(platform:"/mobile", type: TrackType.Event) {
            success = true
        }
        "/checkout/shipping/custom_address/zip_code/query"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/shipping/custom_address/zip_code/query#submit"(platform:"/mobile", type: TrackType.Event) {
            query_parameters = "Mexico D.F."
        }
        "/checkout/shipping/custom_address/zip_code/query/back"(platform:"/mobile", type:TrackType.Event) {
            checkoutStatus()
        }
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
            view_type = "grouped"
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
            view_type = "grouped"
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
            view_type = "grouped"
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
        "/checkout/shipping/location/address/back"(platform:"/mobile", type:TrackType.Event) {
            checkoutStatus()
            edit_flow = true
        }
        "/checkout/shipping/location/select_contact#submit"(platform:"/mobile", type: TrackType.Event) {
            success = true
            error_codes = ["street_name_error"]
        }
        "/checkout/shipping/location/select_contact"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
            available_options = 2
        }
        "/checkout/shipping/location/select_contact/back"(platform:"/mobile", type:TrackType.Event) {
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
        "/checkout/shipping/location/new_contact/back"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
       "/checkout/shipping/location/new_contact#submit"(platform:"/mobile", type:TrackType.Event) {
            success = true
            session_id = "1241n1kj2nk14141nl12nl"
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
        "/checkout/shipping/select_store_map/back"(platform:"/mobile", type:TrackType.Event) {}
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

        // Map v2
        "/checkout/shipping/puis/select_store"(platform: "/mobile") {
            checkoutStatus()
        }
        "/checkout/shipping/select_store"(platform: "/mobile") {
            checkoutStatus()
        }

        "/checkout/shipping/puis/select_store/back"(platform: "/mobile", type: TrackType.Event) {
            checkoutStatus()
        }
        "/checkout/shipping/select_store/back"(platform: "/mobile", type: TrackType.Event) {
            checkoutStatus()
        }
        "/checkout/shipping/puis/select_store/store_not_found"(platform: "/mobile",type: TrackType.Event) {
            latitude = -33.312313
            longitude = -58.929484
        }
        "/checkout/shipping/select_store/store_not_found"(platform: "/mobile",type: TrackType.Event) {
            latitude = -33.312313
            longitude = -58.929484
        }
        "/checkout/shipping/puis/select_store/selected_store"(platform: "/mobile", type: TrackType.Event) {
            default_location_info = {
                type: "address_id"
                suggested : true
            }
            latitude = -33.312313
            longitude = -58.929484
            last_action = "geolocation"
            distance = 345
            selected_filters = [
                                    {
                                        filter_id : "free"
                                        type : "quick / category"
                                    }
                                ]
        }
        "/checkout/shipping/select_store/selected_store"(platform: "/mobile", type: TrackType.Event) {
            default_location_info = {
                type: "address_id"
                suggested : true
            }
            latitude = -33.312313
            longitude = -58.929484
            last_action = "geolocation"
            distance = 345
            selected_filters = [
                    {
                        filter_id : "free"
                        type : "quick / category"
                    }
            ]
        }
        //

        "/checkout/shipping/address_profile"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }

        "/checkout/shipping/address_profile/delivered_time"(platform: "/web", type: TrackType.Event) {
            label = "laboral"
            session_id = "some_session_id"
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
        "/checkout/payment/add_debit_card/back"(platform:"/mobile", type:TrackType.Event) {
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
        "/checkout/payment/add_card/back"(platform:"/mobile", type:TrackType.Event) {}
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
        "/checkout/payment/add_card/installments/back"(platform: "/mobile", type: TrackType.Event) {
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

        "/checkout/payment/stored_card/installments/back" (platform:"/mobile", type:TrackType.Event){
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
        "/checkout/payment/cash/select_store/back"(platform:"/mobile", type:TrackType.Event) {
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
        "/checkout/payment/consumer_credits/installments/back"(platform:"/mobile", type:TrackType.Event) {
            checkoutStatus()
            available_installments = [
                    [
                            installment: 1,
                            amount: 20.6,
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
            available_methods = ["visa", "master", "amex", "cash"]
            coupon = true
            coupon_discount = 20
        }
        "/checkout/payment/select_type/back"(platform:"/mobile", type:TrackType.Event) {
            checkoutStatus()
            available_methods = ["visa", "master", "amex", "cash"]
            coupon = true
            coupon_discount = 20
        }

        // ESC: Enter the Sec Code to generate an Encrypted Security Code
        "/checkout/payment/encrypted_security_code_add"(platform:"/mobile") {
            checkoutStatus()
        }

        "/checkout/payment/encrypted_security_code_add#submit"(platform:"/mobile") {
            status = "success"
            checkout_flow = "checkout"
            session_id = "asodas98a9sd8a"
        }

         //Payment form input tack events:
         "/checkout/payment/input_card/card_number"(platform:"/mobile", type: TrackType.Event){
             session_id = "1241n1kj2nk14141nl12nl"
         }
         "/checkout/payment/input_card/holder_name"(platform:"/mobile", type: TrackType.Event){
             session_id = "1241n1kj2nk14141nl12nl"
         }
         "/checkout/payment/input_card/expiry_date"(platform:"/mobile", type: TrackType.Event){
             session_id = "1241n1kj2nk14141nl12nl"
         }
         "/checkout/payment/input_card/security_code"(platform:"/mobile", type: TrackType.Event){
             session_id = "1241n1kj2nk14141nl12nl"
         }
         "/checkout/payment/input_card/identification_number"(platform:"/mobile", type: TrackType.Event){
             session_id = "1241n1kj2nk14141nl12nl"
         }
         "/checkout/payment/input_card/error_card_number"(platform:"/mobile", type: TrackType.Event){
             session_id = "1241n1kj2nk14141nl12nl"
             error = "Completa este dato"
         }
         "/checkout/payment/input_card/error_holder_name"(platform:"/mobile", type: TrackType.Event){
             session_id = "1241n1kj2nk14141nl12nl"
             error = "Completa este dato"
         }
         "/checkout/payment/input_card/error_expiry_date"(platform:"/mobile", type: TrackType.Event){
             session_id = "1241n1kj2nk14141nl12nl"
             error = "Completa este dato"
         }
         "/checkout/payment/input_card/error_security_code"(platform:"/mobile", type: TrackType.Event){
             session_id = "1241n1kj2nk14141nl12nl"
             error = "Completa este dato"
         }
         "/checkout/payment/input_card/error_identification_number"(platform:"/mobile", type: TrackType.Event){
             session_id = "1241n1kj2nk14141nl12nl"
             error = "Completa este dato"
         }

        // Billing Info
        "/checkout/billing/physical_person"(platform: "/mobile") {
            checkoutStatus()
        }
        "/checkout/billing/physical_person/back"(platform: "/mobile", type: TrackType.Event) {
            checkoutStatus()
        }
        "/checkout/billing/legal_person"(platform: "/mobile") {
            checkoutStatus()
        }
        "/checkout/billing/legal_person/back"(platform: "/mobile", type: TrackType.Event) {
            checkoutStatus()
        }
        "/checkout/review/edit_billing_info"(platform: "/mobile", type: TrackType.Event) {
        }

        "/checkout/review#submit"(platform:"/mobile", type:TrackType.Event) {
            status = "success"
            checkout_flow = "checkout"
        }

        "/checkout/review#submit/abort"(platform:"/mobile", type:TrackType.Event) {
            checkout_flow = "checkout"
            session_id = "some_session_id"
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
        "/checkout/finish/call_for_auth/instructions#submit"(platform:"/mobile", type:TrackType.Event) {
            status = "success"
            checkout_flow = "checkout"
        }
        "/checkout/finish/call_for_auth/instructions#submit/abort"(platform:"/mobile", type:TrackType.Event) {
            checkout_flow = "checkout"
        }
        "/checkout/finish/call_for_auth/later"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }
        "/checkout/finish/invalid_sec_code/input"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }

        "/checkout/finish/invalid_sec_code/input#submit"(platform:"/mobile", type:TrackType.Event) { }

        "/checkout/features/bridge"(platform:"/mobile", type:TrackType.Event) {
            is_experiment_on = true
            can_navigate_to = false
            screen = "MapScreen"
        }

        "/checkout/finish/choose_action"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }

        "/checkout/finish/second_step/error_details"(platform:"/mobile", type:TrackType.View) {
            checkoutStatus()
        }

        "/checkout/finish/click"(platform: "/mobile", type: TrackType.Event) {
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
        "/checkout/show_geolocation_map/back"(platform:"/mobile", type:TrackType.Event) {
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
         // Step Curp Credits MLM
        "/checkout/payment/curp/not_my_curp"(platform: "/", type: TrackType.Event) {}
        "/checkout/payment/curp/view_authorization"(platform: "/", type: TrackType.Event) {}
        //Credits Review
        "/checkout/review/credits_cover"(platform:"/", type: TrackType.Event) {}
        "/checkout/review/credits_terms_and_conditions"(platform:"/", type: TrackType.Event) {}
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

        /**
         * Garex
         * */
        "/checkout/"(platform: "/web") {
            item_with_garex: true
            total_amount_including_garex: 1869.89
        }

        "/checkout/"(platform: "/web") {
            item_with_garex: false
            total_amount_including_garex: 1699.89
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
            payment_status_detail = "ACCREDITED"
            congrats_status = "APPROVED"
            token_generated_with_esc = "NO"
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
            payment_status_detail = "ACCREDITED"
            congrats_status = "APPROVED"
            token_generated_with_esc = "NO"
        }
        "/checkout/congrats/pay_with_another"(platform: "/", type:  TrackType.Event){
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
            recovery_flow=true
        }

        "/checkout/congrats/pay_now"(platform: "/", type:  TrackType.Event){
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
            recovery_flow=true
        }

        "/checkout/congrats/use_now"(platform: "/", type:  TrackType.Event){
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
            recovery_flow=true
        }
    }

    /*
    Garex tracks tests
    * */
    test('checkout garex') {

        "/checkout/garex"(platform:"/mobile", type: TrackType.View) {}
        "/checkout/garex/delete"(platform:"/mobile", type: TrackType.Event) {
            garex_id = "MLA390289_GAR16001"
            period = 24
            cost = 1234
            revenue_share_fee = 70
            revenue = 863.80
            currency_id = "ARS"
        }
        "/checkout/garex/selected_garex"(platform:"/mobile", type: TrackType.Event) {
            garex_id = "MLA390289_GAR16001"
            period = 24
            cost = 1234
            revenue_share_fee = 70
            revenue = 863.80
            currency_id = "ARS"
        }
        "/checkout/garex/not_selected_garex"(platform:"/mobile", type: TrackType.Event) {}
        "/checkout/garex/more_info"(platform:"/mobile", type: TrackType.Event) {}
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

            operation_status = "ok"
            user_identification = ["doc_type", "doc_number"]
            available_methods = ["visa", "master", "amex"]
            nearest_store_distance = 250000
            checkout_flow = "direct"
            flow_type = "buy_it_now"
            stored_cards_quantity = 3
            checkout_flow_reason = "default_case"
        }

        "/checkout/geolocation"(platform:"/web", type: TrackType.Event) {
            dataSet()
            geolocation_error = "TIMEOUT"
        }
        "/checkout/items_not_available"(platform:"/web", dataSet)
        "/checkout/error"(platform:"/web", dataSet)
        "/checkout/payment/select_type"(platform:"/web", type: TrackType.View){
            dataSet()
        }
        "/checkout/payment/select_method"(platform:"/web", dataSet)
        "/checkout/payment/input_sec_code"(platform:"/web", dataSet)
        "/checkout/payment/esc_input_sec_code"(platform:"/web", dataSet)
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
        "/checkout/payment/billing_information"(platform:"/web", dataSet)
        "/checkout/billing/physical_person"(platform:"/web", dataSet)
        "/checkout/billing/legal_person"(platform:"/web", dataSet)
        "/checkout/review/edit_payment"(platform:"/web", dataSet)
        "/checkout/review/edit_first_payment"(platform:"/web", dataSet)
        "/checkout/review/edit_second_payment"(platform:"/web", dataSet)
        "/checkout/review/edit_shipping"(platform:"/web", dataSet)
        "/checkout/review/change_installments"(platform:"/web", dataSet)
        "/checkout/review/change_shipping"(platform:"/web", dataSet)
        "/checkout/review/change_address"(platform:"/web", dataSet)
        "/checkout/review/edit_shipping"(platform:"/web", dataSet)
        "/checkout/review/edit_payment_method"(platform:"/web", dataSet)
        "/checkout/review/confirm_purchase"(platform: "/", dataSet)
        "/checkout/congrats"(platform:"/web"){
            dataSet()
            dataSetCongrats()
            purchase_status = "paid"
            purchase_id = 11111
            payment_status_detail = "ACCREDITED"
            congrats_status = "APPROVED"
            token_generated_with_esc = "NO"
        }
        "/checkout/congrats"(platform:"/web") {
            dataSet()
            dataSetCongrats()
            geolocated = true
            purchase_status = "paid"
            purchase_id = 11111
            payment_status_detail = "ACCREDITED"
            congrats_status = "APPROVED"
            token_generated_with_esc = "NO"
        }
        "/checkout/congrats/recommendations"(platform: "/"){
            dataSet()
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
        "/checkout/session_expire"(platform:"/", dataSet)
        "/checkout/loading"(platform: "/web", dataSet)
        "/checkout/loading/error"(platform: "/web", dataSet)
        "/checkout/shipping/select_option"(platform:"/web", dataSet)
        "/checkout/shipping/input_zipcode"(platform:"/web", dataSet)
        "/checkout/shipping/input_zipcode/i_dont_know_my_cp"(platform:"/web", dataSet)
        //Address Hub
        "/checkout/shipping/delivery_instructions"(platform:"/",dataSet)
        "/checkout/shipping/address_hub"(platform:"/", dataSet)
        // Addresses
        // Page
        "/checkout/shipping/input_address"(platform:"/mobile", dataSet)
        "/checkout/shipping/input_address"(platform:"/web", dataSet)
        "/checkout/shipping/input_address/map"(platform:"/mobile", dataSet)
        "/checkout/shipping/input_address/map"(platform:"/web", dataSet)
        "/checkout/shipping/input_address/back"(platform:"/", type: TrackType.Event, dataSet)

        // Event
        "/checkout/shipping/input_address/name"(platform:"/", type: TrackType.Event){
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/street_name"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/zip_code"(platform:"/", type: TrackType.Event){
            label = "La cantidad de caracteres ingresados es inválida"
            value = "00"
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/city"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/colony"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/street_number"(platform:"/",  type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            value = "aaa"
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/references"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/delivery"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/delivery_instructions"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/phone"(platform:"/", type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            value = ""
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/telephone_input"(platform:"/", type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/additional_info"(platform:"/", type: TrackType.Event){
            label = "Revisa este dato"
            value = "!*"
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/additional_info"(platform:"/", type: TrackType.Event){
            label = "Revisa este dato"
            value = ""
            session_id="some_session_id"
        }
        "/checkout/shipping/input_address/internal_number"(platform:"/", type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=false
        }
        "/checkout/shipping/input_address/caixa_postal_number"(platform: "/", type: TrackType.Event) {
            label = "Ingresar solo valores numéricos"
            value = "aa"
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=true
        }
        "/checkout/shipping/input_address/error_map"(platform: "/", type: TrackType.Event) {
            label = "Mové el mapa y ubicá el pin en tu ubicación exacta"
            value = ""
            items = [
                    [
                            quantity: 1,
                            item    : [
                                    id          : "MLM590711277",
                                    variation_id: ""
                            ]
                    ]
            ]
            recovery_flow=true
        }

        "/checkout/shipping/input_address/select_street_name"(platform: "/", type: TrackType.Event) {
            written = "sug"
            finalText = "suggested street"
        }

        "/checkout/shipping/input_address/select_phone"(platform: "/", type: TrackType.Event) {
            written = "123"
            finalText = "12345678"
        }
        
        "/checkout/shipping/input_address/search_replaced_zip_code"(platform: "/", type: TrackType.Event) {
            count = 10.0
        }
        
        "/checkout/shipping/input_address/select_replaced_zip_code"(platform: "/", type: TrackType.Event) {
            count = 2.0
            session_id = "1234567"
        }

        "/checkout/shipping/input_address/select_map_position"(platform: "/", type: TrackType.Event) {
            suggested = [
                "latitude": 12.12,
                "longitude": 42.42
            ]
            finalCoordinates = [
                "latitude": 12.13,
                "longitude": 42.40
            ]
            session_id = "1234567"
        }

        "/checkout/shipping/input_address_number"(platform:"/web", dataSet)
        "/checkout/shipping/input_address_number/whithout_number"(platform:"/web", dataSet)
        "/checkout/shipping/select_address"(platform:"/web", dataSet)
        "/checkout/shipping/select_option_detail"(platform:"/web", dataSet)
        "/checkout/shipping/input_address_apartment"(platform:"/web", dataSet)
        "/checkout/shipping/select_contact_info"(platform:"/web", dataSet)
        "/checkout/shipping/add_contact_info"(platform:"/web", dataSet)
        "/checkout/shipping/input_contact_info"(platform:"/web", dataSet)
        "/checkout/payment/select_unique_installment"(platform:"/", dataSet)
        "/checkout/payment/select_unique_installment/select_installment"(platform: "/", dataSet)
        "/checkout/payment/select_unique_installment/edit_installment_options"(platform: "/", dataSet)
        "/checkout/payment/select_first_installment"(platform:"/web", dataSet)
        "/checkout/payment/select_second_installment"(platform:"/web", dataSet)
        "/checkout/review/edit_unique_installment"(platform:"/web", dataSet)
        "/checkout/review/edit_first_installment"(platform:"/web", dataSet)
        "/checkout/review/edit_second_installment"(platform:"/web", dataSet)
        "/checkout/shipping"(platform:"/web", dataSet)
        "/checkout/shipping/confirm_geolocation"(platform:"/web", dataSet)
        "/checkout/shipping/select_method_ask_geolocation"(platform:"/web", dataSet)
        "/checkout/shipping/confirm_geolocation/send_to_cp_located"(platform:"/web", dataSet)
        "/checkout/shipping/confirm_geolocation/send_to_another_location"(platform:"/web", dataSet)
        "/checkout/shipping/input_new_address"(platform:"/web", dataSet)
        "/checkout/shipping/accord"(platform:"/web", dataSet)
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

        "/checkout/shipping/address_profile"(platform:"/web", dataSet)
        "/checkout/shipping/address_profile/delivered_time"(platform: "/web", type: TrackType.Event) {
            label = "laboral"
        }

        //Switch track
        "/checkout/payment/select_type/account_money/use"(platform: "/web", type: TrackType.Event) {}
        "/checkout/payment/select_type/account_money/not_use"(platform: "/web", type: TrackType.Event) {}

        // Map v2
        "/checkout/shipping/puis/select_store"(platform: "/web", dataSet)
        "/checkout/shipping/select_store"(platform: "/web", dataSet)
        "/checkout/shipping/puis/select_store/store_not_found"(platform: "/web", type: TrackType.Event) {
            latitude = -33.312313
            longitude = -58.929484
        }
        "/checkout/shipping/select_store/store_not_found"(platform: "/web", type: TrackType.Event) {
            latitude = -33.312313
            longitude = -58.929484
        }
        "/checkout/shipping/puis/select_store/selected_store"(platform: "/web", type: TrackType.Event) {
            default_location_info = {
                type: "address_id"
                suggested : true
            }
            latitude = -33.312313
            longitude = -58.929484
            last_action = "geolocation"
            distance = 345
            selected_filters = [
                    {
                        filter_id : "free"
                        type : "quick / category"
                    }
            ]
            filters_present = true
            agency_latitude = 31.638802
            agency_longitude = -106.436181
        }
        "/checkout/shipping/select_store/selected_store"(platform: "/web", type: TrackType.Event) {
            default_location_info = {
                type: "address_id"
                suggested : true
            }
            latitude = -33.312313
            longitude = -58.929484
            last_action = "geolocation"
            distance = 345
            selected_filters = [
                    {
                        filter_id : "free"
                        type : "quick / category"
                    }
            ]
            filters_present = true
            agency_latitude = 31.638802
            agency_longitude = -106.436181
        }

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

         // Step Curp Credits MLM
        "/checkout/payment/curp"(platform:"/", dataSet)
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

        "/checkout_recovery" (platform:"/mobile/android", type: TrackType.View) {
            item_id = "MLU451705243"
            item_status = "inactive"
        }
        "/checkout_recovery/error" (platform:"/mobile/android", type: TrackType.View) {
            item_id = "MLU451705243"
            item_status = "inactive"
        }
        "/checkout_recovery/notfound" (platform:"/mobile/android", type: TrackType.View) {
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
