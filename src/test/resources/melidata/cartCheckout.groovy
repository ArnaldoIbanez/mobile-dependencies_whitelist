package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"



//------------------------------------------------------------------------------------------------------------------------------------------------------
// TRACKS CART CHECKOUT
//------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Cart Checkout") {

        def dataSetCongratsWeb = {
            status = "payment_required"
            purchase_id = "MLA98792837983"
            payment_status_detail = "ACCREDITED"
            congrats_status = "APPROVED"
            token_generated_with_esc = "NO"
        }

        def dataSetCongrats = {
            status = "payment_required"
            purchase_id = "MLA98792837983"
        }

        def dataSet = {

            buy_equal_pay = true
            recovery_flow = false
            register_int = false
            resolution = "high"

            precharged_cards = true

            total_amount = 2000
            total_amount_with_shipping = 2087.99
            total_paid_amount = 3373.98

            seller = [
                    [id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                    [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]
            ]

            shipping = [
                    [
                            cost            : 25.98,
                            shipping_mode   : "me2",
                            shipping_type   : "mercadoenvios",
                            shipping_options: [
                                    [
                                            method_name          : "Normal",
                                            price                : 0.0,
                                            currency_id          : "ARS",
                                            free_shipping        : true,
                                            free_shipping_benefit: true
                                    ],
                                    [
                                            method_name  : "Expreso",
                                            price        : 50.46,
                                            currency_id  : "ARS",
                                            free_shipping: false
                                    ]
                            ]
                    ]
            ]

            payments = [
                    [
                            id                : "23cfddb085c577f0584ab78e17861c63be386608",
                            payment_type      : "credit_card",
                            payment_method    : "amex",
                            bank              : "Santander Rio",
                            installments      : 12,
                            paid_amount       : 3373.98,
                            installment_amount: 281.17,
                            without_fee       : false,
                            payment_splitted  : false,
                            status            : "approved",
                            status_detail     : "accredited"
                    ]
            ]

            items = [
                    [
                            currency_id: "ARS",
                            unit_price : 100,
                            quantity   : 1,
                            item       : [
                                    category_id   : "MLA63385",
                                    buying_mode   : "buy_it_now",
                                    category_path : ["MLA1499", "MLA2467", "MLA754486062"],
                                    id            : "MLA754486062",
                                    official_store: "Adidas",
                                    condition     : "new",
                                    listing_type  : "gold_special",
                                    title         : "Conector 12 Vias",
                                    shipping_mode : "me2"
                            ]
                    ],
                    [
                            currency_id: "ARS",
                            unit_price : 1000,
                            quantity   : 3,
                            item       : [
                                    category_id   : "MLA63385",
                                    buying_mode   : "buy_it_now",
                                    category_path : ["MLA1499", "MLA2467", "MLA754486062"],
                                    id            : "MLA754486062",
                                    official_store: "SportCenter",
                                    condition     : "new",
                                    listing_type  : "gold_pro",
                                    title         : "Conector 12 Vias",
                                    shipping_mode : "me2"
                            ]
                    ]
            ]
            context = "vip_combo"
            checkout_flow = "cart"

            operation_status = "ok"
            user_identification = ["doc_type", "doc_number"]
            available_methods = ["visa", "master", "amex"]
            nearest_store_distance = 250000
            stored_cards_quantity = 3
            checkout_flow_reason = "default_case"
        }

        "/cart/checkout/review/edit_installments"(platform: "/", type: TrackType.Event) {
            dataSet()
        }

        "/cart/checkout/geolocation"(platform: "/web", type: TrackType.Event) {
            dataSet()
            geolocation_error = "TIMEOUT"
        }
        "/cart/checkout/items_not_available"(platform: "/", dataSet)
        "/cart/checkout/error"(platform: "/", dataSet)
        "/cart/checkout/error"(platform: "/") {
            dataSet()
            error='paused_item'
            error_code='404'
        }
        "/cart/checkout/payment/billing_information"(platform: "/mobile") {
            dataSet()
            user_identification_fields:
            ["doc_type", "doc_number", "name", "las_name"]
        }
        "/cart/checkout/payment/select_type"(platform: "/", type: TrackType.View) {
            dataSet()
        }
        "/cart/checkout/payment/select_method"(platform: "/", dataSet)
        "/cart/checkout/payment/select_method/edit_payment"(platform: "/", dataSet)
        "/cart/checkout/payment/select_method/show_distances"(platform: "/", dataSet)
        "/cart/checkout/payment/select_store"(platform: "/", dataSet)
        "/cart/checkout/payment/select_bank"(platform: "/", dataSet)
        "/cart/checkout/payment/select_bank"(platform: "/") {
            dataSet()
            available_issuers = ["santander", "banamex"]
        }
        "/cart/checkout/payment/view_location"(platform: "/", dataSet)
        "/cart/checkout/payment/view_location/location"(platform: "/", dataSet)
        "/cart/checkout/payment/view_location/preloaded"(platform: "/", dataSet)
        "/cart/checkout/payment/input_card"(platform: "/", dataSet)
        "/cart/checkout/payment/input_card#card_config"(platform: "/web") {
            dataSet()
            bin = "1234"
            success = true
        }
        "/cart/checkout/payment/input_card/edit_payment"(platform: "/", dataSet)
        "/cart/checkout/payment/input_card/security_code_tooltip"(platform: "/", dataSet)
        "/cart/checkout/payment/select_installments"(platform: "/", dataSet)
        "/cart/checkout/payment/select_installments/close_splitter_message"(platform: "/", dataSet)
        "/cart/checkout/payment/select_installments/click_payment_detail"(platform: "/", dataSet)
        "/cart/checkout/payment/select_installments/click_box_installments"(platform: "/", dataSet)
        "/cart/checkout/payment/create_second_password"(platform: "/", dataSet)
        "/cart/checkout/payment/input_second_password"(platform: "/", dataSet)
        "/cart/checkout/payment/input_second_password/edit_payment"(platform: "/", dataSet)
        "/cart/checkout/payment/promotions"(platform: "/", dataSet)
        "/cart/checkout/payment/input_sec_code"(platform: "/", dataSet)
        "/cart/checkout/payment/esc_input_sec_code"(platform: "/", dataSet)
        "/cart/checkout/review/edit_payment"(platform: "/", dataSet)
        "/cart/checkout/review/edit_first_payment"(platform: "/", dataSet)
        "/cart/checkout/review/edit_second_payment"(platform: "/", dataSet)
        "/cart/checkout/review/edit_shipping"(platform: "/", dataSet)
        "/cart/checkout/review/change_installments"(platform: "/", dataSet)
        "/cart/checkout/review/change_shipping"(platform: "/", dataSet)
        "/cart/checkout/review/change_address"(platform: "/", dataSet)
        "/cart/checkout/review/edit_shipping"(platform: "/", dataSet)
        "/cart/checkout/review/edit_payment_method"(platform: "/", dataSet)
        "/cart/checkout/review/edit_payment_method"(platform: "/mobile") {
            dataSet()
            coupon=true
        }
        "/cart/checkout/review/confirm_purchase"(platform: "/web", dataSet)
        "/cart/checkout/review/confirm_purchase"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
            status = "success"
        }
        "/cart/checkout/review/confirm_purchase/abort"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
            status = "success"
        }
        "/cart/checkout/congrats"(platform: "/web") {
            dataSet()
            dataSetCongratsWeb()
        }
        "/cart/checkout/congrats/input_sec_code"(platform: "/web") {
            dataSet()
            dataSetCongratsWeb()
        }
        "/cart/checkout/congrats"(platform: "/mobile") {
            dataSet()
            dataSetCongrats()
            geolocated = true
        }
        "/cart/checkout/congrats/keep_buying"(platform: "/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/go_to_myml"(platform: "/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/go_to_page_bank"(platform: "/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/view_ticket"(platform: "/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/download_ticket"(platform: "/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/show_map"(platform: "/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/save_data"(platform: "/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/contact_us"(platform: "/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/go_to_mercado_puntos"(platform: "/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/added_points"(platform: "/") {
            dataSet()
            dataSetCongrats()
        }

        "/cart/checkout/congrats/pay_with_another"(platform: "/", type: TrackType.Event){
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
        "/cart/checkout/congrats/pay_now"(platform: "/", type: TrackType.Event){
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
        "/cart/checkout/congrats/use_now"(platform: "/", type: TrackType.Event){
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

        "/cart/checkout/show_ticket"(platform: "/", dataSet)
        "/cart/checkout/finish/invalid_sec_code/input_code"(platform: "/", dataSet)
        "/cart/checkout/finish/invalid_sec_code/input_code/confirm_purchase"(platform: "/mobile", type: TrackType.Event) {
            session_id="some_session_id"
            status="success"
        }
        "/cart/checkout/finish/call_for_auth/instructions"(platform: "/", dataSet)
        "/cart/checkout/finish/call_for_auth/later"(platform: "/", dataSet)
        "/cart/checkout/finish/call_for_auth/input_code"(platform: "/", dataSet)
        "/cart/checkout/loading"(platform: "/", dataSet)
        "/cart/checkout/loading/back"(platform: "/mobile", type: TrackType.Event, dataSet)
        "/cart/checkout/shipping"(platform: "/mobile", dataSet)

        //Address Hub
        "/cart/checkout/shipping/delivery_instructions"(platform:"/", dataSet)
        "/cart/checkout/shipping/address_hub"(platform:"/", dataSet)

        // Addresses
        // Page
        "/cart/checkout/shipping/input_address"(platform:"/mobile") {
            dataSet()
            edit_flow = false
        }
        "/cart/checkout/shipping/input_address"(platform:"/web") {
            dataSet()
            edit_flow = false
        }
        "/cart/checkout/shipping/input_address/map"(platform:"/mobile") {
            dataSet()
            edit_flow = false
        }
        "/cart/checkout/shipping/input_address/map"(platform:"/web") {
            dataSet()
            edit_flow = false
        }
        // Event
        "/cart/checkout/shipping/input_address/name"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = "na"
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
        "/cart/checkout/shipping/input_address/street_name"(platform: "/", type: TrackType.Event) {
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
            recovery_flow=true
        }
        "/cart/checkout/shipping/input_address/zip_code"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = "0"
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
        "/cart/checkout/shipping/input_address/colony"(platform: "/", type: TrackType.Event) {
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
            recovery_flow=true
        }
        "/cart/checkout/shipping/input_address/street_number"(platform: "/", type: TrackType.Event) {
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
        "/cart/checkout/shipping/input_address/references"(platform: "/", type: TrackType.Event) {
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
            recovery_flow=true
        }
        "/cart/checkout/shipping/input_address/delivery"(platform: "/", type: TrackType.Event) {
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
            recovery_flow=true
        }
        "/cart/checkout/shipping/input_address/delivery_instructions"(platform: "/", type: TrackType.Event) {
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
            recovery_flow=true
        }
        "/cart/checkout/shipping/input_address/phone"(platform: "/", type: TrackType.Event) {
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
            recovery_flow=true
        }
        "/cart/checkout/shipping/input_address/telephone_input"(platform: "/", type: TrackType.Event) {
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
            recovery_flow=true
        }
        "/cart/checkout/shipping/input_address/additional_info"(platform: "/", type: TrackType.Event) {
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
            recovery_flow=true
            session_id="some_session_id"
        }
        "/cart/checkout/shipping/input_address/internal_number"(platform: "/", type: TrackType.Event) {
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
            recovery_flow=true
        }
        "/cart/checkout/shipping/input_address/caixa_postal_number"(platform: "/", type: TrackType.Event) {
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
            recovery_flow=true
        }
        "/cart/checkout/shipping/input_address/error_map"(platform: "/", type: TrackType.Event) {
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

        // address form mobile
        "/cart/checkout/shipping/input_address/name"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = "na"
            session_id="some_session_id"
        }
        "/cart/checkout/shipping/input_address/street_name"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = "123456"
            session_id="some_session_id"
        }
        "/cart/checkout/shipping/input_address/zip_code"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = "123"
            session_id="some_session_id"
        }
        "/cart/checkout/shipping/input_address/city"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            session_id="some_session_id"
        }
        "/cart/checkout/shipping/input_address/colony"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            session_id="some_session_id"
        }
        "/cart/checkout/shipping/input_address/street_number"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            session_id="some_session_id"
            recovery_flow=true
        }
        "/cart/checkout/shipping/input_address/references"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            session_id="some_session_id"
        }
        "/cart/checkout/shipping/input_address/delivery"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            session_id="some_session_id"
        }
        "/cart/checkout/shipping/input_address/delivery_instructions"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            session_id="some_session_id"
        }
        "/cart/checkout/shipping/input_address/phone"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            session_id="some_session_id"
        }
        "/cart/checkout/shipping/input_address/telephone_input"(platform: "/", type: TrackType.Event) {
            label = "La cantidad de caracteres ingresados es inválida"
            session_id="some_session_id"
        }

        "/cart/checkout/shipping/input_address/select_street_name"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
            written = "sug"
            finalText = "suggested street"
        }

        "/cart/checkout/shipping/input_address/select_phone"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
            written = "123"
            finalText = "12345678"
        }
        
        "/cart/checkout/shipping/input_address/search_replaced_zip_code"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
            count = 10.0
        }
        
        "/cart/checkout/shipping/input_address/select_replaced_zip_code"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
            count = 2.0
        }

        "/cart/checkout/shipping/input_address/select_map_position"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
            suggested = "{\"latitude\":\"12.12\",\"longitude\":\"42.42\"}"
            finalCoordinates = "{\"latitude\":\"12.13\",\"longitude\":\"42.40\"}"
        }

        // First Visit
        // Page
        "/cart/checkout/shipping/address_profile"(platform: "/mobile", dataSet)

        // Event
        "/cart/checkout/shipping/address_profile/delivered_time"(platform: "/mobile", type: TrackType.Event) {
            label = "laboral"
            session_id = "some_session_id"
        }

        "/cart/checkout/shipping/edit_address"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/shipping/edit_address"(platform: "/web", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/shipping/geolocation_permissions"(platform: "/mobile", dataSet)
        "/cart/checkout/shipping/geolocation_permissions/allow_geolocation/Yes"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/shipping/geolocation_permissions/allow_geolocation/No"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/geolocation"(platform: "/mobile", type: TrackType.Event) {
            geolocation_error = "NO_LOCATION_PERMISSION"
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/shipping/geolocation_error"(platform: "/mobile", dataSet)
        "/cart/checkout/shipping/select_method_geolocated"(platform: "/mobile", dataSet)
        "/cart/checkout/shipping/select_method_geolocated/send_to_cp_located"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/shipping/select_method_geolocated/send_to_another_location"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/shipping/select_option"(platform: "/mobile", dataSet)
        "/cart/checkout/shipping/select_method_ask_geolocation"(platform: "/mobile") {
            dataSet()
            selections = ["free_shipping", "me2"]
        }
        "/cart/checkout/shipping/input_zipcode"(platform: "/mobile", dataSet)
        "/cart/checkout/shipping/input_zipcode/i_dont_know_my_cp"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/shipping/input_address/back"(platform:"/mobile", type:TrackType.Event) {
            dataSet()
            edit_flow=false
        }
        "/cart/checkout/shipping/input_address#submit"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
            success = true
        }
        "/cart/checkout/shipping/select_address"(platform: "/mobile", dataSet)
        "/cart/checkout/shipping/select_option_detail"(platform: "/mobile", dataSet)
        "/cart/checkout/shipping/input_address_apartment"(platform: "/mobile", dataSet)
        "/cart/checkout/shipping/select_contact_info"(platform: "/mobile") {
            dataSet()
            available_options = 1
        }
        "/cart/checkout/shipping/select_contact_info#submit"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/shipping/add_contact_info"(platform: "/mobile", dataSet)
        "/cart/checkout/shipping/input_contact_info"(platform: "/mobile", dataSet)
        "/cart/checkout/payment/select_unique_installment"(platform: "/", dataSet)
        "/cart/checkout/payment/select_unique_installment/back"(platform: "/", dataSet)
        "/cart/checkout/payment/select_unique_installment/edit_installment_options"(platform: "/", dataSet)
        "/cart/checkout/payment/select_unique_installment/select_installment"(platform: "/", dataSet)
        "/cart/checkout/payment/select_split_installments"(platform: "/", dataSet)
        "/cart/checkout/payment/select_split_installments/close_split_message"(platform: "/", dataSet)
        "/cart/checkout/payment/select_split_installments/edit_installment_options"(platform: "/", dataSet)
        "/cart/checkout/payment/select_split_installments/select_installment"(platform: "/", dataSet)
        "/cart/checkout/payment/select_split_installments"(platform: "/", dataSet)
        "/cart/checkout/payment/select_split_installments/split_detail"(platform: "/mobile", dataSet)
        "/cart/checkout/payment/select_first_installment"(platform: "/mobile", dataSet)
        "/cart/checkout/payment/select_second_installment"(platform: "/mobile", dataSet)
        "/cart/checkout/payment/transfer/select_bank"(platform: "/mobile", dataSet)
        "/cart/checkout/review/edit_unique_installment"(platform: "/mobile", dataSet)
        "/cart/checkout/review/edit_first_installment"(platform: "/mobile", dataSet)
        "/cart/checkout/review/edit_second_installment"(platform: "/mobile", dataSet)
        "/cart/checkout/show_geolocation_map"(platform: "/mobile", dataSet)

        "/cart/checkout/shipping"(platform: "/web", type: TrackType.View) {
            dataSet()
        }

        // First Visit
        // Page
        "/cart/checkout/shipping/address_profile"(platform: "/web", dataSet)

        // Event
        "/cart/checkout/shipping/address_profile/delivered_time"(platform:"/web", type:TrackType.Event) {
            label = "laboral"
        }

        "/cart/checkout/shipping/confirm_geolocation"(platform: "/web", dataSet)
        "/cart/checkout/shipping/confirm_geolocation/send_to_cp_located"(platform: "/web", dataSet)
        "/cart/checkout/shipping/confirm_geolocation/send_to_another_location"(platform: "/web", dataSet)
        "/cart/checkout/shipping/input_new_address"(platform: "/web", dataSet)
        "/cart/checkout/payment/security_code"(platform: "/mobile") {
            dataSet()
            user_identification_fields:
            ["doc_type", "doc_number"]
        }
        "/cart/checkout/payment/security_code"(platform: "/web", dataSet)

        // Step Curp Credits MLM
        "/cart/checkout/payment/curp"(platform: "/", dataSet)

        //2MP
        //Switch
        "/cart/checkout/payment/2mp#use"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/payment/2mp#not_use"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/payment/2mp/split"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }

        // Disclaimer combination modal view.
        "/cart/checkout/payment/payment_combination/payment_method_not_supported"(platform: "/mobile", dataSet)

        // Discount Coupons
        "/cart/checkout/payment/add_coupon"(platform: "/mobile", type: TrackType.View) {
            dataSet()
        }
        "/cart/checkout/payment/coupon_ok"(platform: "/mobile", type: TrackType.View) {
            dataSet()
            coupon = "coupon1,coupon2"
        }
        "/cart/checkout/payment/add_another_coupon"(platform: "/mobile", type: TrackType.View) {
            dataSet()
        }
        "/cart/checkout/payment/coupon_error"(platform: "/mobile", type: TrackType.View) {
            dataSet()
        }
        "/cart/checkout/payment/invalid_coupon"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/payment/expired_coupon"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }
        "/cart/checkout/payment/add_another_coupon/delete_coupon"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }

        //Payment form input tack events:
        "/cart/checkout/payment/input_card#card_config"(platform: "/mobile", type: TrackType.Event) {
            bin = "123456"
            success = true
            session_id = "1241n1kj2nk14141nl12nl"
        }

        "/cart/checkout/payment/input_card/card_number"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
        }
        "/cart/checkout/payment/input_card/holder_name"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
        }
        "/cart/checkout/payment/input_card/expiry_date"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
        }
        "/cart/checkout/payment/input_card/security_code"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
        }
        "/cart/checkout/payment/input_card/identification_number"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
        }
        "/cart/checkout/payment/input_card/error_card_number"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
            error = "Completa este dato"
        }
        "/cart/checkout/payment/input_card/error_holder_name"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
            error = "Completa este dato"
        }
        "/cart/checkout/payment/input_card/error_expiry_date"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
            error = "Completa este dato"
        }
        "/cart/checkout/payment/input_card/error_security_code"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
            error = "Completa este dato"
        }
        "/cart/checkout/payment/input_card/error_identification_number"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
            error = "Completa este dato"
        }
        "/cart/checkout/payment/input_card/back"(platform: "/mobile", type: TrackType.Event, dataSet)

        // Cancelarion
        "/cart/checkout/payments_cancelation"(platform: "/mobile", dataSet)

        // ESC: Enter the Sec Code to generate an Encrypted Security Code
        "/cart/checkout/payment/encrypted_security_code_add"(platform: "/mobile") {
            dataSet()
        }
        "/cart/checkout/payment/encrypted_security_code_add/confirm_purchase"(platform: "/mobile", type: TrackType.Event) {
            session_id = "1241n1kj2nk14141nl12nl"
            status="success"
        }

        // Billing info
        "/cart/checkout/billing/physical_person"(platform: "/") {
            dataSet()
        }
        "/cart/checkout/billing/physical_person/back"(platform: "/mobile", type: TrackType.Event, dataSet)
        "/cart/checkout/billing/legal_person"(platform: "/") {
            dataSet()
        }
        "/cart/checkout/billing/legal_person/back"(platform: "/mobile", type: TrackType.Event, dataSet)
        "/cart/checkout/review/edit_billing_info"(platform: "/mobile", type: TrackType.Event) {
            session_id = "98f8v98au0af9af0af"
        }

        // Inconsistencias
        "/cart/checkout/review/discard_payment_combination"(platform: "/mobile", dataSet)
        "/cart/checkout/review/inconsistency/payment_combination"(platform: "/mobile", dataSet)
        "/cart/checkout/review/inconsistency/payment_combination/payment"(platform: "/mobile", dataSet)
        "/cart/checkout/review/inconsistency/payment_combination/installments"(platform: "/mobile", dataSet)
        "/cart/checkout/review/inconsistency/payment_combination/shipping"(platform: "/mobile", dataSet)
        "/cart/checkout/review/inconsistency/payment_combination/new_split"(platform: "/mobile", dataSet)

        "/cart/checkout/finish/click"(platform: "/mobile", type: TrackType.Event) {
            action = 'call_seller'
            session_id = "asda98sad98ad89ad8"
        }

        "/cart/checkout/finish/choose_action"(platform: "/", dataSet)
        // Step Curp Credits MLM
        "/cart/checkout/payment/curp/not_my_curp"(platform: "/", type: TrackType.Event) {}
        "/cart/checkout/payment/curp/view_authorization"(platform: "/", type: TrackType.Event) {}

        //Credits Review
        "/cart/checkout/review/credits_cover"(platform: "/", type: TrackType.Event) {}
        "/cart/checkout/review/credits_terms_and_conditions"(platform: "/", type: TrackType.Event) {}

        //Switch track
        "/cart/checkout/payment/select_type/account_money/use"(platform: "/web", type: TrackType.Event) {
            dataSet()
        }
        "/cart/checkout/payment/select_type/account_money/not_use"(platform: "/web", type: TrackType.Event) {
            dataSet()
        }
    }

}
