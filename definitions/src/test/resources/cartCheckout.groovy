package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"



//------------------------------------------------------------------------------------------------------------------------------------------------------
// TRACKS CART CHECKOUT
//------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Cart Checkout") {

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

        "/cart/checkout/geolocation"(platform:"/", type: TrackType.Event) {
            dataSet()
            geolocation_error = "TIMEOUT"
        }
        "/cart/checkout/items_not_available"(platform:"/", dataSet)
        "/cart/checkout/error"(platform:"/", dataSet)
        "/cart/checkout/payment/billing_information"(platform:"/mobile") {
            dataSet()
            user_identification_fields: ["doc_type", "doc_number", "name", "las_name"]
        }
        "/cart/checkout/payment/select_method"(platform:"/", dataSet)
        "/cart/checkout/payment/select_method/edit_payment"(platform:"/", dataSet)
        "/cart/checkout/payment/select_method/show_distances"(platform:"/", dataSet)
        "/cart/checkout/payment/select_store"(platform:"/", dataSet)
        "/cart/checkout/payment/select_bank"(platform:"/", dataSet)
        "/cart/checkout/payment/view_location"(platform:"/", dataSet)
        "/cart/checkout/payment/view_location/location"(platform:"/", dataSet)
        "/cart/checkout/payment/view_location/preloaded"(platform:"/", dataSet)
        "/cart/checkout/payment/input_card"(platform:"/", dataSet)
        "/cart/checkout/payment/input_card#card_config"(platform:"/") {
            dataSet()
            bin = "1234"
            success = true
        }
        "/cart/checkout/payment/input_card/edit_payment"(platform:"/", dataSet)
        "/cart/checkout/payment/input_card/security_code_tooltip"(platform:"/", dataSet)
        "/cart/checkout/payment/select_installments"(platform:"/", dataSet)
        "/cart/checkout/payment/select_installments/close_splitter_message"(platform:"/", dataSet)
        "/cart/checkout/payment/select_installments/click_payment_detail"(platform:"/", dataSet)
        "/cart/checkout/payment/select_installments/click_box_installments"(platform:"/", dataSet)
        "/cart/checkout/payment/create_second_password"(platform:"/", dataSet)
        "/cart/checkout/payment/input_second_password"(platform:"/", dataSet)
        "/cart/checkout/payment/input_second_password/edit_payment"(platform:"/", dataSet)
        "/cart/checkout/payment/promotions"(platform:"/", dataSet)
        "/cart/checkout/review/edit_payment"(platform:"/", dataSet)
        "/cart/checkout/review/edit_first_payment"(platform:"/", dataSet)
        "/cart/checkout/review/edit_second_payment"(platform:"/", dataSet)
        "/cart/checkout/review/edit_shipping"(platform:"/", dataSet)
        "/cart/checkout/review/change_installments"(platform:"/", dataSet)
        "/cart/checkout/review/change_shipping"(platform:"/", dataSet)
        "/cart/checkout/review/change_address"(platform:"/", dataSet)
        "/cart/checkout/review/edit_shipping"(platform:"/", dataSet)
        "/cart/checkout/review/edit_payment_method"(platform:"/", dataSet)
        "/cart/checkout/congrats"(platform:"/"){
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats"(platform:"/mobile") {
            dataSet()
            dataSetCongrats()
            geolocated = true
        }
        "/cart/checkout/congrats/keep_buying"(platform:"/"){
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/go_to_myml"(platform:"/"){
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/go_to_page_bank"(platform:"/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/view_ticket"(platform:"/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/download_ticket"(platform:"/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/show_map"(platform:"/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/save_data"(platform:"/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/contact_us"(platform:"/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/go_to_mercado_puntos"(platform:"/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/congrats/added_points"(platform:"/") {
            dataSet()
            dataSetCongrats()
        }
        "/cart/checkout/show_ticket"(platform:"/", dataSet)
        "/cart/checkout/finish/invalid_sec_code/input_code"(platform:"/", dataSet)
        "/cart/checkout/finish/call_for_auth/instructions"(platform:"/", dataSet)
        "/cart/checkout/finish/call_for_auth/later"(platform:"/", dataSet)
        "/cart/checkout/finish/call_for_auth/input_code"(platform:"/", dataSet)
        "/cart/checkout/shipping"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/edit_address"(platform:"/mobile", dataSet)
        "/cart/checkout/loading"(platform: "/mobile", dataSet)
        "/cart/checkout/shipping/geolocation_permissions"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/geolocation_permissions/allow_geolocation/Yes"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/geolocation_permissions/allow_geolocation/No"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/geolocation_error"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/select_method_geolocated"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/select_method_geolocated/send_to_cp_located"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/select_method_geolocated/send_to_another_location"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/select_option"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/select_method_ask_geolocation"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/input_zipcode"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/input_zipcode/i_dont_know_my_cp"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/input_address"(platform:"/mobile") {
            dataSet()
            edit_flow = false
        }
        "/cart/checkout/shipping/input_address#zip_code"(platform:"/mobile") {
            dataSet()
            zip_code = "1430"
        }
        "/cart/checkout/shipping/input_address#street_name"(platform:"/mobile") {
            dataSet()
            street_name = "Arias"
        }
        "/cart/checkout/shipping/input_address#street_number"(platform:"/mobile") {
            dataSet()
            street_number = "3751"
        }
        "/cart/checkout/shipping/input_address#internal_number"(platform:"/mobile") {
            dataSet()
            internal_number = ""
        }
        "/cart/checkout/shipping/input_address#between_streets"(platform:"/mobile") {
            dataSet()
            between_streets = "Posta y Av. Melian"
        }
        "/cart/checkout/shipping/input_address#references"(platform:"/mobile") {
            dataSet()
            references = "Edificio Intecons"
        }
        "/cart/checkout/shipping/input_address#neighborhood"(platform:"/mobile") {
            dataSet()
            neighborhood = "CABA"
        }
        "/cart/checkout/shipping/input_address#additional_info"(platform:"/mobile") {
            dataSet()
            additional_info = "7mo piso"
        }
        "/cart/checkout/shipping/input_address#submit"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/input_address_number"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/input_address_number/whithout_number"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/select_address"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/select_option_detail"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/input_address_apartment"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/select_contact_info"(platform:"/mobile"){
            dataSet()
            available_options = 1
        }
        "/cart/checkout/shipping/select_contact_info#submit"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/add_contact_info"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping/input_contact_info"(platform:"/mobile", dataSet)
        "/cart/checkout/payment/select_unique_installment"(platform:"/mobile", dataSet)
        "/cart/checkout/payment/select_split_installments"(platform:"/mobile", dataSet)
        "/cart/checkout/payment/select_split_installments/split_detail"(platform:"/mobile", dataSet)
        "/cart/checkout/payment/select_first_installment"(platform:"/mobile", dataSet)
        "/cart/checkout/payment/select_second_installment"(platform:"/mobile", dataSet)
        "/cart/checkout/payment/transfer/select_bank"(platform:"/mobile", dataSet)
        "/cart/checkout/review/edit_unique_installment"(platform:"/mobile", dataSet)
        "/cart/checkout/review/edit_first_installment"(platform:"/mobile", dataSet)
        "/cart/checkout/review/edit_second_installment"(platform:"/mobile", dataSet)
        "/cart/checkout/show_geolocation_map"(platform:"/mobile", dataSet)
        "/cart/checkout/shipping"(platform:"/web", dataSet)
        "/cart/checkout/shipping/confirm_geolocation"(platform:"/web", dataSet)
        "/cart/checkout/shipping/confirm_geolocation/send_to_cp_located"(platform:"/web", dataSet)
        "/cart/checkout/shipping/confirm_geolocation/send_to_another_location"(platform:"/web", dataSet)
        "/cart/checkout/shipping/input_new_address"(platform:"/web", dataSet)
        "/cart/checkout/payment/security_code"(platform:"/mobile") {
            dataSet()
            user_identification_fields: ["doc_type", "doc_number"]
        }
        "/cart/checkout/payment/security_code"(platform:"/web", dataSet)

        //2MP
        //Switch
        "/cart/checkout/payment/2mp#use"(platform: "/mobile", dataSet)
        "/cart/checkout/payment/2mp#not_use"(platform: "/mobile",dataSet)
        "/cart/checkout/payment/2mp/split"(platform: "/mobile",dataSet)

        // Disclaimer combination modal view.
        "/cart/checkout/payment/payment_combination/payment_method_not_supported"(platform:"/mobile", dataSet)

        // Discount Coupons
        "/cart/checkout/payment/add_coupon"(platform:"/mobile", type:TrackType.View) {
            dataSet()
        }
        "/cart/checkout/payment/coupon_ok"(platform:"/mobile", type:TrackType.View) {
            dataSet()
            coupon = "coupon1,coupon2"
        }
        "/cart/checkout/payment/add_another_coupon"(platform:"/mobile", type:TrackType.View) {
            dataSet()
        }
        "/cart/checkout/payment/coupon_error"(platform:"/mobile", type:TrackType.View) {
            dataSet()
        }
        "/cart/checkout/payment/invalid_coupon"(platform:"/mobile", type:TrackType.Event) {
            dataSet()
        }
        "/cart/checkout/payment/expired_coupon"(platform:"/mobile", type:TrackType.Event) {
            dataSet()
        }
        "/cart/checkout/payment/add_another_coupon/delete_coupon"(platform:"/mobile", type:TrackType.Event) {
            dataSet()
        }

        // Cancelarion
        "/cart/checkout/payments_cancelation"(platform:"/mobile", dataSet)

        "/cart/checkout/billing/physical_person"(platform: "/mobile") {
            dataSet()
        }
        "/cart/checkout/billing/legal_person"(platform: "/mobile") {
            dataSet()
        }
        "/cart/checkout/review/edit_billing_info"(platform: "/mobile", type: TrackType.Event) {
        }

        //Inconsistencias
        "/cart/checkout/review/discard_payment_combination"(platform:"/mobile", dataSet)
        "/cart/checkout/review/inconsistency/payment_combination"(platform:"/mobile", dataSet)
        "/cart/checkout/review/inconsistency/payment_combination/payment"(platform:"/mobile", dataSet)
        "/cart/checkout/review/inconsistency/payment_combination/installments"(platform: "/mobile", dataSet)
        "/cart/checkout/review/inconsistency/payment_combination/shipping"(platform: "/mobile", dataSet)
        "/cart/checkout/review/inconsistency/payment_combination/new_split"(platform: "/mobile", dataSet)
    }


}
