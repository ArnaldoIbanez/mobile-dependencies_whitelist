import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Root tracking") {
        "/"(platform: "/mobile") {
            sent_again=true
        }

        "/"(platform: "/web/desktop") {}
    }

    test("Home core tracking") {
        "/home"(platform: "/mobile") {}

        "/home/abort"(platform: "/mobile") {}

        "/home/back"(platform: "/mobile") {}

        "/home/failure"(platform: "/mobile", {
            error_message = "error loading home"
        })

        "/home/long_press"(platform: "/mobile") {}

        "/home/contextual_menu"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLB681933310"
        }

        "/home/share"(platform: "/mobile") {}

        "/home/contextual_menu/share"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLB681933310"
        }

        "/home/pulltorefresh"(platform:"/mobile") {}

        "/home/pulltorefresh/failure"(platform:"/mobile") {}

        "/home/pulltorefresh/abort"(platform:"/mobile") {}

        "/home/scroll"(platform: "/mobile") {}

        "/home/scroll/failure"(platform: "/mobile") {}

        "/home/scroll/abort"(platform: "/mobile") {}

        "/home/tap"(platform: "/mobile", {
            position = 1
            section = "history"
            tag_id = "MLB681933310"
        })

        "/home/carousel/firstTO"(platform: "/mobile") {}

        "/home/carousel/lastcard"(platform: "/mobile") {}
    }

    test("Onboarding tracking") {
        "/onboarding/step/chooser"(platform: "/mobile", type: TrackType.View) {}

        "/onboarding/login"(platform: "/mobile", type: TrackType.Event) {}

        "/onboarding/registration"(platform: "/mobile", type: TrackType.Event) {
            type = "email"
        }

        "/onboarding/cancel"(platform: "/mobile", type: TrackType.Event) {}

        "/onboarding/skip"(platform: "/mobile", type: TrackType.Event) {}

        "/onboarding/flow"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Search core tracking"){

        def defaultSearchInformation = {
            total=5876
            limit=20
            query="iphone"
            category_path=["MLA1051", "MLA1055", "MLA32089"]
            category_id="MLA32089"
            filter_user_applied=[]
            offset=0
            sort_id="relevance"
            view_mode="MOSAIC"
            filter_tags=["locationFromHistory"]
            results=["232232000", "232232001", "232232002"]
            backend_data={
                sm="sm"
                ab="1"
                aa=["a1","a2"]
                ac=["ac1","ac2"]
                ap=["ap1","ap2"]
                fsm="fsm"
                ab_bucket="AB1"
                layout="stack"
                qas=["232232000", "232232001", "232232002"]
                cli_rel_qty_configured="12"
                canonical="http://home.mercadolibre.com.ar/telefonia/"
                cli_rel_qty_link_to_category="MLA123"
            }
            catalog_product_id="MLA123"
        }

        def defaultEmptySearchInformation = {
            limit=20
            query="ipod"
            offset=0
        }
        "/search"(platform: "/web",{
            visual_id="STD"
            config_version= "111"
            filters = { seller_id = "47316577" }
            only_in_type="Seller"
            limit=20
            offset=0
            click_banner={
                exhibitors_id='12'
            }
            banner={
                deal_id='12'
                exhibitors_id='12'
            }
            click_banner={
                exhibitors_id='12'
            }
            related_searches={
                query= 'ipod'
                position=1
                quantity=2
                related_by_category=false
            }
            related_searches_info={
                quantity=2
                related_queries=['ipod', 'ipod nano']
            }
            canonical={
                url = "https://listado.mercadolibre.com.ar/zapatillas"
                no_follow_tag = true
                mirror_category_canonical = true
            }

            autosuggest={
                suggest_position=3
            }
            autosuggest={
                last_search_position=1
            }
            autosuggest={
                block_store_position=19
            }
            results=["232232000", "232232001", "232232002"]
            billboards = ["232232000"]
            geolocation="AR:CABA"
            landing="base"
            layout_forced=true
            promise_items=["232232000"]
            has_logos:true
        })

        "/search"(platform: "/mobile", defaultSearchInformation)

        "/search"(platform: "/mobile", {
            total = 258
            limit = 0
            context = "deeplinking"
            category_path = []
            offset = 50.0
            sort_id = "relevance"
            filters = {official_store="140"}
            autoselected_filters = ["official_store"]
        })


        "/search/input"(platform: "/mobile") {}

        "/search/input/back"(platform: "/mobile") {}

        "/search/failure"(platform: "/mobile") {
            defaultSearchInformation()
            error_message = "No connection error"
        }

        "/search/filters"(platform: "/mobile", defaultSearchInformation)
        "/search/back"(platform: "/mobile", defaultSearchInformation)
        "/search/long_press"(platform: "/mobile"){
            defaultEmptySearchInformation()
            item_id = "MLA170232"
        }
        "/search/share"(platform: "/mobile"){
            defaultEmptySearchInformation()
            item_id = "MLA170232"
        }
        "/search/abort"(platform: "/mobile", defaultEmptySearchInformation)
        "/search/refine"(platform: "/mobile", defaultSearchInformation)
        "/search/refine/apply"(platform: "/mobile", defaultSearchInformation)
        "/search/refine/back" (platform: "/mobile", defaultSearchInformation)
        "/search/refine/select_filter" (platform: "/mobile"){
            defaultSearchInformation()
            filter_id = "9997262-AMLA_7262_2"
        }
        "/search/refine/select_filter/apply"(platform: "/mobile"){
            defaultSearchInformation()
            filter_id = "9997262-AMLA_7262_2"
            filter_value_id = "9997262-AMLA_7262_1-MMLA6838"
            filter_value_name = "IPod touch"
        }
        "/search/change_view" (platform: "/mobile", defaultSearchInformation)
        "/search/change_view/apply" (platform: "/mobile", type: TrackType.Event){
            defaultSearchInformation()
            list_mode = "mosaic"
        }
        "/search/promoted_items"(platform: "/web", defaultSearchInformation)
        "/search/promoted_items/show"(platform: "/web") {
            defaultSearchInformation()
            item_type = "projects"
        }
        "/search/billboard"(platform: "/") {
            defaultSearchInformation()
            position_shown = 1
            move = "forward"
        }
        "/search/billboard/resize"(platform: "/web") {
            defaultSearchInformation()
            action = "expand"
        }
        "/search/save"(platform: "/") {
            defaultSearchInformation()
        }
    }

    test("Search gallery with 10 items, first page" ) {
        "/search"(platform: "/mobile") {
            limit = 10
            offset = 0
            category_id="MLA32089"
            query="iphone"
        }
    }

    test("Search category_id ROOT" ) {
        "/search"(platform: "/mobile") {
            limit = 10
            offset = 0
            category_id="ROOT"
            query="iphone"
        }
    }

    test("Search carousel next"){
        "/search/carousel"(platform: "/web") {
            carousel_used="next"
        }
    }

    //Reviews
    test("Reviews tracks") {
        def dataSetForm = {
            item_id="MLA533657947"
            step="description"
        }

        def dataSet = {
            item_id="MLA533657947"
        }

        def dataSetCongrats = {
            item_id="MLA533657947"
            review_length=321
        }

        def vipTrack = {
            item_id = "MLA631609359"
            reviews_all_count = 3
            reviews_negative_count = 0
            vote_up = {
                reviews_id = [1,2]
                count = 2
            }
            vote_down = {
                reviews_id = [3,4]
                count = 2
            }
            reviews_positive_count = 0
            reviews_shown = [
                    {
                        filter = "all"
                        length = 300
                        position = 2
                        reviewId = "3581337"
                        time = 27364
                        words = 52
                    }
            ]
            time_ellapsed = 75211
            type = "detail"
        }

        "/reviews/form"(platform:"/", dataSetForm)

        "/reviews/edit"(platform:"/", dataSet)

        "/reviews/congrats/delete"(platform:"/", dataSet)

        "/reviews/congrats/edit"(platform:"/", dataSetCongrats)

        "/reviews/error"(platform:"/", dataSet)

        "/reviews/congrats"(platform:"/", dataSetCongrats)

        "/reviews/email"(platform:"/email", dataSet)

        "/reviews"(platform:"/email", dataSet)

        "/reviews/show"(platform:"/", vipTrack)
    }




    test("Checkout Basic Flow test. Legacy test for previous mobile versions") {

        def defaultCheckoutInformation = {
            item_id = "MCO412584037"
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
            payment_method = "oxxo"
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
            item_id="MLA538444567"
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

    test("credit cards"){

        "/credit_cards"(platform:"/mobile", type: TrackType.View) {
            available_cards=["visa", "amex", "master", "diners"]
            context = "/checkout"
        }

        "/credit_cards/abort"(platform:"/mobile", type: TrackType.View) {
            available_cards=["visa", "amex", "master", "diners"]
            context = "/checkout"
        }

        "/credit_cards/back"(platform:"/mobile", type: TrackType.View) {
            available_cards=["visa", "amex", "master", "diners"]
            context = "/checkout"
        }

        "/credit_cards/new_card"(platform:"/mobile", type: TrackType.View) {
            payment_method_id = "diners"
            context = "/checkout"
        }

        "/credit_cards/new_card/back"(platform:"/mobile", type: TrackType.View) {
            payment_method_id = "diners"
            context = "/checkout"
        }

        "/credit_cards/new_card/apply"(platform:"/mobile", type: TrackType.Event) {
            payment_method_id = "diners"
            card_number = 123123123123
            context = "/checkout"
        }

        "/credit_cards/new_card/installments" (platform:"/mobile", type: TrackType.View) {
            //payment_method_id = "diners"
            available_installments = [1, 2, 3, 5, 6]
            context = "/checkout"
        }

        "/credit_cards/new_card/installments/apply"(platform:"/mobile", type: TrackType.Event) {
            payment_method_id = "diners"
            available_installments = [1, 2, 3, 5, 6]
            installment=6
            context = "/checkout"
        }
    }

    test("Devices Notification Settings") {
        "/devices_settings/notifications"(platform:"/mobile") {
            enable = true
            registration_id = "1234567890ASDVH7766527892"
            device_id = "12345678"
        }
    }

    test("Shipping Mercadoenvios calculate cost") {
        "/shipping/mercadoenvios/shipping_cost"(platform: "/mobile") {
            item_id = "MLA12345"
            context = "/vip"
        }
        "/shipping/mercadoenvios/shipping_cost/get"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA12345"
            context = "/vip"
            zip_code="1414"
            destination = "1234"
        }
        "/shipping/mercadoenvios/shipping_cost/apply"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA12345"
            context = "/vip"
            shipping_id = "509341521"
            zip_code="1414"
            destination = "1234"
        }
        "/shipping/mercadoenvios/shipping_cost/fail"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA12345"
            context = "/vip"
        }
        "/shipping/shipping_cost"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA12345"
            context = "/vip"
        }
        "/shipping/shipping_cost/back"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA12345"
            context = "/vip"
        }
    }

    test("address"){
        "/address/add_address"(platform:"/mobile", type: TrackType.View){
            context = "/checkout"
        }
        "/address/add_address/back"(platform:"/mobile", type: TrackType.Event){
            context = "/checkout"
        }
        "/address/add_address/apply"(platform:"/mobile", type: TrackType.Event){
            context = "/checkout"
        }
    }

    test("payments"){
        "/payments"(platform:"/mobile", type:TrackType.View){
            context = "vip"
            item_id="MLA539399952"
        }
        "/payments/back"(platform:"/mobile", type:TrackType.Event){
            context = "vip"
            item_id="MLA539399952"
        }
    }

    test("seller reputation"){
        "/seller_reputation"(platform:"/mobile"){
            context = "/vip"
            item_id = "MLA539399952"
        }
        "/seller_reputation/back"(platform:"/mobile"){
            context = "/vip"
            item_id = "MLA539399952"
        }
        "/seller_reputation/ratings"(platform:"/mobile"){
            context = "/vip"
            item_id = "MLA539399952"
        }

        "/seller_reputation/ratings/back"(platform:"/mobile"){
            context = "/vip"
            item_id = "MLA539399952"
        }
    }

    test("Register") {
        "/register/success"(platform: "/mobile") {
            source = "facebook"
        }

        "/register/failure"(platform: "/mobile") {
            source = "facebook"
        }

        "/register/facebook_permissions"(platform: "/mobile"){
            login_status = "success"
            email = true
            user_birthday = true
            user_likes = true
        }
    }

    test("Progressive registration") {
        "/progressive_registration"(platform: "/mobile/android") {}
    }

    test("Register Web") {
        "/register/form"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/form"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            prog_reg_version = 1
        }

        "/register/form/error"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/form/error"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            errors = [
                    [
                            code:0,
                            field: 'firstName',
                            message: 'Tu nombre es incorrecto'
                    ],
                    [
                            code:2,
                            field: 'lastName'
                    ]
            ]
            errors_validation = 'back'
            prog_reg_version = 1
        }

        "/register/form/error"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            errors = [
                    [
                            code:2,
                            field: 'lastName'
                    ]
            ]
            errors_validation = 'front'
            prog_reg_version = 0
        }

        "/register/form/another-email"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            errors = [
                    [
                            code:8,
                            field: 'email'
                    ]
            ]
            errors_validation = 'back'
            prog_reg_version = 0
        }

        "/register/form/another-email"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/form/geolocation"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            geo_location_code = 1
        }

        "/register/form/facebook-connect"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/facebook-connect/facebook-register-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "facebook"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/facebook-connect/email-register-selected"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/facebook-connect/login-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/site-identification"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            ip_site_id = "MCO"
        }

        "/register/form/site-identification/url-site-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            ip_site_id = "MCO"
        }

        "/register/form/site-identification/ip-site-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            ip_site_id = "MCO"
        }

        "/register/success"(platform: "/web/desktop") {
            app = "registration-favorite"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/success"(platform: "/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 1
        }

        "/register/form/skip-update"(platform: "/web/desktop") {
            app = "registration-update-opt"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/optin"(platform: "/web/desktop") {
            app = "registration"
            prog_reg_version = 0
        }

        "/register/optin/push"(platform: "/web/mobile") {
            app = "registration-optin"
            prog_reg_version = 0
        }

        "/register/optin/skip"(platform: "/web/mobile") {
            app = "registration-optin"
            prog_reg_version = 0
        }

        "/register/form/email-suggest"(platform: "/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

    }

    test("Registration App"){
        // app module
        "/register/hub"(platform: "/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }
        "/register/hub/register-with-email"(platform: "/mobile"){
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"

        }
        "/register/hub/register-with-facebook"(platform: "/mobile"){
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }
        "/register/form"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }
        "/register/form/error"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
            errors_validation = "back"
            errors = [
                    [
                            code:8,
                            field: 'email'
                    ]
            ]
        }
        "/register/form/another-email"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }
        "/register/account-recovery-hub"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }
        "/register/account-recovery-hub/account-recovery"(platform: "/mobile"){
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"

        }
        "/register/account-recovery-hub/use-another-email"(platform: "/mobile"){
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }

        "/register/congrats"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }

        "/register/form/update"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
        }

        "/register/form/update/error"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
            errors_validation = "back"
            errors = [
                    [
                            code:14,
                            field: 'first_name'
                    ]
            ]
        }

        "/register/form/update/save"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
        }

        "/register/form/update/not-now"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
        }

        "/register/successful-update"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
        }
    }

    test("Traffic") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            word = "campaignName"
        }
    }

    test("Traffic") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            word = "campaignName"
            go = "http://ofertas.mercadolibre.com.mx/hot-sale"
        }
    }

    test("external tracking"){

        def defaultSearchInformation = {
            total=5876
            limit=20
            query="iphone"
            category_path=["MLA1051", "MLA1055", "MLA32089"]
            category_id="MLA32089"
            filter_user_applied=[]
            offset=0
            sort_id="relevance"
        }

        "/external"(platform:"/mobile", type:TrackType.View) { defaultSearchInformation }

        "/external/abort"(platform:"/mobile", type:TrackType.View) { defaultSearchInformation }

        "/external/back"(platform:"/mobile", type:TrackType.View) { defaultSearchInformation }

        "/external/failure"(platform:"/mobile", type:TrackType.View) {
            defaultSearchInformation
            error_message = "error loading search"
        }

        "/external/search"(platform:"/mobile", type:TrackType.View) { defaultSearchInformation }

        "/external/vip"(platform:"/mobile", type:TrackType.View) {
            item_id = "MLA123"
        }
    }


    test("melidata"){
        "/melidata/delete_old_tracks" (platform:"/mobile", type:TrackType.Event) {
            count = 10
        }

        "/melidata/null_track" (platform:"/mobile", type:TrackType.Event) {
            context = "DescriptionFragment"
        }

        "/melidata/statistics"(platform:"/mobile", type:TrackType.Event){
            errors_counter = ["java.io.EOFException":2, "nullpointer":3]
            last_send_timestamp="2015-01-21T13:14:09.415-0300"
            total_pending_tracks=2
            send_counter=6
            database_size=16384
            tracks_counter=12
            average_ok_time=10
            average_error_time=11
        }

        "/melidata/shrink_database"(platform:"/mobile/android", type:TrackType.Control){
            delete_records=40
            current_size=69632
            previous_size=110592
        }

        "/melidata/shrink_database"(platform:"/mobile/ios", type:TrackType.Event){
            delete_records=50
            current_size=82322
            previous_size=122592
        }
    }

    test("Mobile Landings") {
        "/landing/generic"(platform: "/mobile"){
            url = "https://www.mercadolibre.com"
            is_main_url = true
        }
    }


    test("Mall Tracking") {
        "/official_stores/home"(platform: "/web") {
            from="breadcrumb"
        }
    }
    test("Mall Tracking without hash") {
        "/official_stores/home"(platform: "/web") {}
    }

    test("Home Tracking") {
        "/home"(platform: "/web") {
            from="breadcrumb"
        }
    }
    test("Tracking landing without tooltip") {
        "/official_stores/landing"(platform: "/web") {
            is_tool_tip_present = false
        }
    }
    test("Tracking landing with tooltip") {
        "/official_stores/landing"(platform: "/web") {
            is_tool_tip_present = true
        }
    }
    test("Tracking landing without tooltip info") {
        "/official_stores/landing"(platform: "/web") {}
    }
    test("Tracking checkon with tooltip") {
        "/official_stores/checkon"(platform: "/web") {
            is_tool_tip_present = true
        }
    }
    test("Tracking checkon without tooltip") {
        "/official_stores/checkon"(platform: "/web") {
            is_tool_tip_present = false
        }
    }
    test("Tracking checkon without tooltip info") {
        "/official_stores/checkon"(platform: "/web") {}
    }
    test("Tracking Few Items Page") {
        "/official_stores/fewItemsPage"(platform: "/web") {
            query="mochila"
            store="Topper"
        }
    }
    test("Tracking official stores zrp") {
        "/official_stores/zrp"(platform: "/web") {
            in_store=true
            use_link=false
        }
    }

    test("Home Category Tracking") {
        "/home/category"(platform: "/web") {
            from="breadcrumb"
            category_id="MLA1051"
        }
    }

    test("Permission location dialog") {
        "/permissions/location"(platform: "/mobile") {
            context="HOME"
        }
    }

    test("Custom Permission location dialog accepted") {
        "/permissions/location/custom/accept"(platform: "/mobile") {
            context="HOME"
        }
    }

    test("Custom Permission location dialog denied") {
        "/permissions/location/custom/deny"(platform: "/mobile") {
            context="HOME"
        }
    }

    test("Native Permission location dialog accepted") {
        "/permissions/location/native/accept"(platform: "/mobile") {
            context="HOME"
        }
    }


    test("Native Permission location dialog denied") {
        "/permissions/location/native/deny"(platform: "/mobile") {
            context="HOME"
        }
    }

    test("Real estate home tracking") {
        def dataSetViewEmpty = {
            filters = ''
            carousels = ''
            category_id = 'MLA1459'
        }

        def dataSetView = {
            category_id = "MLA1459"
            filters = {
                cityId: 1
                cityName: 'Santiago'
                stateId: 1
                stateName: 'Santiago'
                neighborhoodId: 1
                neighborhoodName: 'La rioja'
                categories: 11
                operations: 11
            }
            carousels = {
                premium: [1,2,3]
                gold: [11,12,13]
                used: [111,122,133]
            }
        }

        "/home/category/real-estate"(platform: "/", dataSetViewEmpty)
        "/home/category/real-estate"(platform: "/web", dataSetViewEmpty)

        "/home/category/real-estate"(platform: "/", dataSetView)
        "/home/category/real-estate"(platform: "/web", dataSetView)
        "/home/category/real-estate"(platform: "/mobile", dataSetView)
    }

    test("Item events"){
        def dataListItem = {
            item_id = "MLA123456"
            listing_type_id = "gold_special"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
            category_id = "MLA3530"
        }

        def dataListItemWithCategorySuggestion = {
            item_id = "MLA123456"
            listing_type_id = "gold_special"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
            category_id = "MLA3530"
            suggested_category_id = "MLA1915"
            suggested_category_is_leaf = false
        }

        def dataChangeListingTypeItemFullInfo = {
            item_id = "MLA123456"
            from = "gold_special"
            to = "gold_pro"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
            source = "upgrade_on"
        }

        def dataChangeListingTypeItemMinimumInfo = {
            item_id = "MLA123456"
            from = "gold_special"
            to = "gold_pro"
        }

        def dataRelistItem = {
            item_id = "MLA123456"
            listing_type_id = "gold_special"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
        }

        def dataRelistItemWithParentInformation = {
            item_id = "MLA123456"
            listing_type_id = "gold_special"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
            parent_id = "MLA345"
            parent_listing_type_id = "free"
            source = "/sell/quick_relist/single"
        }

        "/item/create"(platform: "/web", dataListItem)
        "/item/create"(platform: "/web", dataListItemWithCategorySuggestion)
        "/item/change_listing_type"(platform: "/web", dataChangeListingTypeItemFullInfo)
        "/item/change_listing_type"(platform: "/web", dataChangeListingTypeItemMinimumInfo)
        "/item/relist"(platform: "/web", dataRelistItem)
        "/item/relist"(platform: "/web", dataRelistItemWithParentInformation)
    }

    test("Myml listing active view"){
        "/myml/listings"(platform: "/web"){
            label = "active"
        }
        "/myml/bookmarks"(platform: "/web"){}
        "/myml/questions"(platform: "/web"){}
        "/myml/summary"(platform: "/web"){}
    }

    test("Myml My Data"){
        "/myml/profile"(platform: "/mobile"){}
        "/myml/profile/review_data"(platform: "/mobile"){}
        "/myml/profile/complete_data"(platform: "/mobile"){}
        "/myml/profile/update_form"(platform: "/mobile"){
            has_inferred_data = true
        }
        "/myml/profile/update_success"(platform: "/mobile"){}
        "/myml/profile/review_data/confirm"(platform: "/mobile"){}
        "/myml/company_profile"(platform: "/mobile"){}
        "/myml/fiscal_data_edit"(platform: "/mobile"){}
    }

    test("Myml Suggested Discounts"){
        "/myml/suggested_discounts/landing"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/landing/about"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/landing/start"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/landing/back"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/landing/abandon"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/about"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/about/skip"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/about/start"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/about/abandon"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/about/back"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/select_discount"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/select_discount/apply"(platform: "/mobile"){
            item_id = "MLA123456"
            selected_discount = "1"
        }
        "/myml/suggested_discounts/review_discount"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/review_discount/confirm"(platform: "/mobile"){
            item_id = "MLA123456"
            selected_discount = "1"
        }
        "/myml/suggested_discounts/select_discount/back"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/review_discount/back"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/info"(platform: "/mobile"){
            item_id = "MLA123456"
            discount_status = "on_deal"
        }
        "/myml/suggested_discounts/info/exit"(platform: "/mobile"){
            item_id = "MLA123456"
            discount_status = "on_deal"
            action = "vip"
        }
        "/myml/suggested_discounts/info/back"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/error"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/error/back"(platform: "/mobile"){item_id = "MLA123456"}
    }

    test("Myml account balance") {
        "/myml/account_balance"(platform: "/mobile", type: TrackType.View) {}
        "/myml/account_balance/withdraw"(platform: "/mobile", type: TrackType.Event) {
            mp_installed = true
        }
        "/myml/account_balance/send_money"(platform: "/mobile", type: TrackType.Event) {
            mp_installed = true
        }
        "/myml/account_balance/cellphone_recharge"(platform: "/mobile", type: TrackType.Event) {
            mp_installed = true
        }
        "/myml/account_balance/bill_payments"(platform: "/mobile", type: TrackType.Event) {
            mp_installed = true
        }
        "/myml/account_balance/generic_error"(platform: "/mobile", type: TrackType.View) {
            additional_info = {message="Escanear código QR"
                icon="error"
                description="Solo puedes pagar usando códigos de Mercado Pago"
                message="¿Estas seguro que ese código es para pagar?"
                actions=[{
                             id="try_again"
                             link="meli://mp/scan_qr"
                             label="Intentar nuevamente"
                             type="link"
                         }]}
        }
        "/myml/account_balance/scan_qr"(platform: "/mobile", type: TrackType.View) {}
    }

    test("MyMl new reputation flow seller") {
        "/myml/sales/detail/flow_selector"(platform: "/mobile", type: TrackType.View) {
            flow_selected = "MPA and not ME"
        }
        "/myml/sales/detail/deliver_product"(platform: "/mobile", type: TrackType.View) {}
        "/myml/sales/detail/deliver_product#submit"(platform: "/mobile", type: TrackType.Event) {
            action_label = "send_feedback"
        }
        "/myml/sales/detail/date_will_receive_product"(platform: "/mobile", type: TrackType.View) {}
        "/myml/sales/detail/deliver_product/action"(platform: "/mobile", type: TrackType.Event) {
            action_label = "send_feedback"
            order_id = "12344"
            shipping_id = "1234"
            success = false
        }
        "/myml/sales/detail/send_feedback"(platform: "/mobile", type: TrackType.Event) {
            order_id = "1234"
            success = true
        }
    }

    test("MyMl new reputation flow buyer") {
        "/myml/purchases/feedback/rating"(platform: "/mobile", type: TrackType.View) {}

        "/myml/purchases/feedback/message"(platform: "/mobile", type: TrackType.View) {}

        "/myml/purchases/feedback/congrats"(platform: "/mobile", type: TrackType.View) {}

        "/myml/purchases/feedback/congrats#action"(platform: "/mobile", type: TrackType.Event) {
            target = "meli://home"
        }

        "/myml/purchases/feedback/error"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Myml installation") {
        "/myml/account_balance/install"(platform: "/mobile", type: TrackType.View) {}
        "/myml/account_balance/install/go_to_store"(platform: "/mobile", type: TrackType.Event) {}
    }

    test("Download app landing tracking") {

        "/download-app"(platform: "/web"){}
        "/download-app/send"(platform: "/web", type: TrackType.Event){
            user_phone_number = "000123456789"
            final_phone_number = "123456789"
        }
        "/download-app/send/success"(platform: "/web", type: TrackType.Event){
            user_phone_number = "000123456789"
            final_phone_number = "123456789"
        }
        "/download-app/send/error"(platform: "/web", type: TrackType.Event){
            user_phone_number = "000123456789"
            final_phone_number = "123456789"
            error_type = "error type"
        }
    }

    test("Account Recovery tracking event") {

        "/register/accountRecovery"(platform: "/mobile", type: TrackType.Event) {
            error_type = "connectionError/invalidOneTimePassword/operatorNotSupported"
        }
    }

    test("Recommendations tracking on checkout") {

        "/checkout/congrats"(platform: "/web", type: TrackType.View) {
            //recommendations data
            recommendations = [
                    success_print : true,
                    algorithm : "MarketingIntelligence",
                    context : "CHO",
                    item_category_l3 : "MLA1537",
                    recommended_l3_categories : ["MLA1051", "MLA1055", "MLA32089"]
            ]
            //checkout data
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
        "/checkout/congrats"(platform: "/web", type: TrackType.View) {
            //recommendations data
            recommendations = [
                    success_print : true,
                    algorithm : "MarketingIntelligence",
                    context : "CHO",
                    item_category_l3 : "MLA1537",
                    recommended_l3_categories : ["MLA1051", "MLA1055", "MLA32089"]
            ]
            //checkout data
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
    }

    test("Entering to official stores listing") {

        "/official_stores/search"(platform:"/mobile", type: TrackType.View, {})
    }


    test("Tap an official store row") {
        def officialStoreEvent = {
            query = "abe"
            official_store_id="174"
            official_store_name="Aberturas L'Hermetique"
        }
        "/official_stores/search/open"(platform:"/mobile", type: TrackType.Event, officialStoreEvent)
    }

    test("Abort official store search") {
        def officialStoreEvent = {
            query = "abe"
        }
        "/official_stores/search/abort"(platform:"/mobile", type: TrackType.Event, officialStoreEvent)
    }

    test("Back pressed in official store listing") {
        def officialStoreEvent = {
            query = "abe"
        }
        "/official_stores/search/back"(platform:"/mobile", type: TrackType.Event, officialStoreEvent)
    }

    test("Loyalty tracks") {
        def loyaltyInfo = {
            level = 1
            points = 100
            percentage = 0.5f
        }
        "/loyalty/score"(platform: "/", type: TrackType.View, loyaltyInfo)
        "/loyalty/score/milestones"(platform: "/", type: TrackType.View, loyaltyInfo)
        "/loyalty/score/achievements"(platform: "/", type: TrackType.View, loyaltyInfo)
        "/loyalty/score/benefits"(platform: "/", type: TrackType.View, loyaltyInfo)
        "/loyalty/notification"(platform: "/", type: TrackType.Event, { event_type = 'shown' })
    }

    test("Referral Program tracks") {
        "/referral/promoter/main"(platform: "/", type: TrackType.View) {}

        "/referral/promoter/main/social"(platform: "/", type: TrackType.Event) {
            action = "share_link"
            label = "email"
        }

        "/referral/promoter/main/social"(platform: "/", type: TrackType.Event) {
            action = "share_link"
            label = "facebook"
        }

        "/referral/promoter/main/social"(platform: "/", type: TrackType.Event) {
            action = "share_link"
            label = "twitter"
        }

        "/referral/promoter/main/social"(platform: "/", type: TrackType.Event) {
            action = "share_link"
            label = "whatsapp"
        }

        "/referral/promoter/main/social"(platform: "/", type: TrackType.Event) {
            action = "copy_link"
        }

        "/referral/promoter/error/self_invite"(platform: "/", type: TrackType.View) {}

        "/referral/promoter/error/activated_user"(platform: "/", type: TrackType.View) {}

        "/referral/referred/main"(platform: "/", type: TrackType.View) {}

        "/referral/referred/error/has_benefit"(platform: "/", type: TrackType.View) {}

        "/referral/referred/congrats/login"(platform: "/mobile", type: TrackType.View) {}

        "/referral/referred/congrats/register"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Mobile Navigation Menu"){
        "/navigation"(platform: "/mobile/android"){
            origin = "/HOME"
        }
    }

    test("Mobile Navigation Drawer"){
        "/navigation/drawer"(platform: "/mobile/android", type: TrackType.Event) {
            section = "my_account"
        }
    }

    test("Mobile Navigation Tabs"){
        "/navigation/tabs"(platform: "/mobile/ios", type: TrackType.Event) {
            action = "TAB_SELECTED"
            tab = "BOOKMARKS"
        }
    }

    test("Mobile Navigation to Cart"){
        "/navigation/cart"(platform: "/mobile/ios", type: TrackType.Event) {
            action = "CART_SELECTED"
            origin = "SEARCH"
        }
    }

    test("Logout action confirmed") {
        "/logout/modal"(platform: "/mobile") {
            action = "confirmed"
        }
    }

    test("Logout action canceled") {
        "/logout/modal"(platform: "/mobile") {
            action = "canceled"
        }
    }

    test("Login conversion tracks") {
        "/login"(platform: "/") {
            source = "LFE"
        }
        "/login/form"(platform: "/", type: TrackType.View) {
            source = "QUESTION"
            has_error = true
            flow = "internal"
            old_user_id = "123456"
            old_user_nick = "nick"
        }
        "/login/form"(platform: "/", type: TrackType.View) {
            source = "FAVORITE"
            has_error = false
            flow = "internal"
            recaptcha = true
        }
        "/login/recovery"(platform: "/web", type: TrackType.Event) {
            source = "LFE"
        }
        "/login/recovery"(platform: "/mobile", type: TrackType.View) {
            source = "LFE"
        }
        "/login/auth"(platform: "/mobile", type: TrackType.View) {
            source = "LFE"
            is_otp = false
            is_admin_otp = false
        }
        "/login/auth"(platform: "/web", type: TrackType.Event) {
            source = "LFE"
            is_otp = false
            is_admin_otp = false
        }
        "/login/registration"(platform: "/", type: TrackType.Event) {
            source = "LFE"
        }
        "/login/auth/success"(platform: "/", type: TrackType.Event) {
            source = "LFE"
            flow = "internal"
            is_otp = false
            is_admin_otp = false
            user_reg_date = "2002-09-26T00:00:00.000-04:00"
            user_points = 100
        }
        "/login/auth/failure"(platform: "/", type: TrackType.Event) {
            source = "LFE"
            reason = [errorId: 'invalid_password']
            flow = "internal"
            is_otp = false
            is_admin_otp = false
            old_user_id = "123456"
            old_user_nick = "nick"
        }
        "/login/auth/challenge_success"(platform: "/", type: TrackType.Event) {
            challenge = "pass"
            source = "MSL_DEFAULT"
            is_otp = false
            is_admin_otp = false
        }
        "/login/auth/push"(platform: "/", type: TrackType.Event) {
            view = "waiting_view"
            event_type = "click_go_to_password_button"
            challenge = "push_authentication"
            tx = "adHgjskcD01lM6EeLs7zUGgBaA1GiWqF6w_XQUgLJk0QAmdhE"
            is_otp = false
            is_admin_otp = false
        }
        "/logout"(platform: "/", type: TrackType.Event) {
            flow = "internal"
        }
    }

    test("App authorization tracks") {
        "/oauth/authorization/form"(platform: "/", type: TrackType.Event) {
            source = "LFE"
        }
        "/oauth/authorization/form/access"(platform: "/", type: TrackType.Event) {
            source = "LFE"
            authorize = true
        }
    }

    test("Login Status with Smart Lock for Passwords") {
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = true
            smartlock_status = "SUCCESS"
            section = "application_startup"
        }
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = false
            smartlock_status = "SUCCESS"
            section = "application_startup"
        }
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = true
            smartlock_status = "RESOLUTION_REQUIRED"
            section = "application_startup"
        }
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = false
            smartlock_status = "RESOLUTION_REQUIRED"
            section = "application_startup"
        }
    }

    test("Requesting credentials to Smart Lock for Passwords") {
        "/login/smartlock"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "RESOLUTION_REQUIRED"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "CANCELED"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "VALIDATION_REQUIRED"
        }
    }

    test("Saving credentials to Smart Lock for Passwords") {
        "/login/smartlock/save_credentials"(platform: "/mobile") {}
        "/login/smartlock/save_credentials/already_saved"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/save_credentials/resolution_required"(platform: "/mobile", type: TrackType.Event) {
            success = true
        }
        "/login/smartlock/save_credentials/resolution_required"(platform: "/mobile", type: TrackType.Event) {
            success = false
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "CANCELED"
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "TIMEOUT"
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "NETWORK_ERROR"
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "API_NOT_CONNECTED"
        }
    }

    test("Abuse Prevention in Identification and Authentication") {
      "/auth/abuse_prevention"(platform: "/mobile", type: TrackType.Event) {
        result = "low"
      }
      "/auth/abuse_prevention/ban"(platform: "/web", type: TrackType.Event) {
          result = "low"
      }
      "/auth/abuse_prevention/login"(platform: "/web", type: TrackType.Event) {
        device_id = "1"
        platform = "web"
      }
      "/auth/abuse_prevention/login"(platform: "/mobile", type: TrackType.Event) {
        device_id = "1"
        platform = "mobile"
      }
    }

    test("Loyalty user tracking") {
        "/loyalty/user"(platform: "/") {
            in_loyalty_program = true
        }
    }

    test("Identity Validation ") {

        "/identity-validation/validation_landing"(platform: "/web/mobile") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/web/mobile") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/web/mobile") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/web/mobile") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/web/mobile") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/validation_landing"(platform: "/web/desktop") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/web/desktop") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/web/desktop") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/web/desktop") {
            type = "phone"
            success = false
        }

        "/identity-validation/finish_challenge"(platform: "/web/desktop") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/web/desktop") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/validation_landing"(platform: "/mobile/android") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/mobile/android") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/android") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/android") {
            type = "phone"
            success = false
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/android") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/mobile/android") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/validation_landing"(platform: "/mobile/ios") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/mobile/ios") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/ios") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/ios") {
            type = "phone"
            success = false
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/ios") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/mobile/ios") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/upload_compress"(platform: "/mobile/ios") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/upload_compress"(platform: "/mobile/android") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/upload_compress"(platform: "/web/mobile") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/upload_compress"(platform: "/web/desktop") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/phone_code"(platform: "/mobile") {}
        "/identity-validation/phone"(platform: "/mobile") {}
        "/identity-validation/upload_doc"(platform: "/mobile") {}
        "/identity-validation/landing"(platform: "/mobile") {}
        "/identity-validation/congrats"(platform: "/mobile") {}
        "/identity-validation/landing_doc"(platform: "/mobile") {}
        "/identity-validation/doc_number"(platform: "/mobile") {}

        "/identity-validation/phone_code"(platform: "/web/desktop") {}
        "/identity-validation/phone"(platform: "/web/desktop") {}
        "/identity-validation/upload_doc"(platform: "/web/desktop") {}
        "/identity-validation/landing"(platform: "/web/desktop") {}
        "/identity-validation/congrats"(platform: "/web/desktop") {}
        "/identity-validation/landing_doc"(platform: "/web/desktop") {}
        "/identity-validation/doc_number"(platform: "/web/desktop") {}

        "/identity-validation/phone_code"(platform: "/web/mobile") {}
        "/identity-validation/phone"(platform: "/web/mobile") {}
        "/identity-validation/upload_doc"(platform: "/web/mobile") {}
        "/identity-validation/landing"(platform: "/web/mobile") {}
        "/identity-validation/congrats"(platform: "/web/mobile") {}
        "/identity-validation/landing_doc"(platform: "/web/mobile") {}
        "/identity-validation/doc_number"(platform: "/web/mobile") {}
    }

    test("recommendations tracking in feedbacks congrats") {
        "/feedback/congrats"(platform: "/web") {
            recommendations = [
                    has_errors: false,
                    hidden_by_client: false,
                    client: "feedback_congrats",
                    backend_id: "marketing_intelligence",
                    track_info: [
                            has_recommendations: true,
                            item_category: "MLA3519",
                            recommended_items: [
                                    "MLA627123724",
                                    "MLA617149341"

                            ],
                            recommended_categories: [
                                    "MLA5337"
                            ]
                    ]
            ]
        }

    }

    test("Quotation :: Show details tracking") {

        "/quotation/details"(platform: "/") {
            item_id = "MLM2222222"
        }

        "/quotation/details"(platform: "/web") {
            item_id = "MLM2222222"
            category_id = "MLM170531"
            seller_id = 123456789
            listing_type_id = "silver"
            item_status = "closed"
            vertical = "REAL_ESTATE"
            error_type = ""
        }

        "/quotation/details"(platform: "/mobile") {
            item_id = "MLM2222222"
        }

        "/quotation/details"(platform: "/mobile") {
            item_id = "MLM2222222"
            model_id = "MLM170531"
        }
    }

    test("Quotation :: Show select models tracking") {

        "/quotation/models"(platform: "/mobile") {
            item_id = "MLM2222222"
        }

        "/quotation/models"(platform: "/mobile") {
            item_id = "MLM2222222"
            model_id = "MLM170531"
        }
    }

    test("Quotation :: Show select units tracking") {

        "/quotation/units"(platform: "/mobile") {
            item_id = "MLM2222222"
        }

        "/quotation/units"(platform: "/mobile") {
            item_id = "MLM2222222"
            unit_id = "MLM170531"
        }
    }

    test("Quotation :: Show gallery tracking") {

        "/quotation/gallery"(platform: "/mobile") { }

    }

    test("Quotation :: Show disclaimer tracking") {

        "/quotation/disclaimer"(platform: "/mobile") {
            item_id = "MLM2222222"
        }
    }

    test("Quotation :: Quote intention tracking") {

        "/quotation/quote_intention"(platform: "/mobile") {
            item_id = "MLM2222222"
            model_id = "MLM170531"
            unit_id = "54321"
        }
    }

    test("Quotation :: Quotation success tracking") {

        "/quotation/success"(platform: "/") {
            item_id = "MLM2222222"
            unit_id = "54321"
        }
    }

    test("Quotation :: Show congrats tracking") {
        "/quotation/congrats"(platform: "/") {
            item_id = "MLM2222222"
            unit_id = "54321"
        }

        "/quotation/congrats"(platform: "/web") {
            item_id = "MLM2222222"
            category_id = "MLM170531"
            seller_id = 123456789
            listing_type_id = "silver"
            item_status = "closed"
            vertical = "REAL_ESTATE"
            model_id = 12345
            unit_id = "54321"
            error_type = ""
        }
    }


    test("Buy intention event tests"){

        def buyIntentionDataSet = {
            buy_equal_pay = true
            total_amount=2000

            seller = [
                    [id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                    [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]
            ]

            items = [
                    [
                            currency_id: "ARS",
                            unit_price: 100,
                            quantity: 1,
                            item: [
                                    category_id: "MLA63385",
                                    buying_mode: "buy_it_now",
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

        "/buy_intention"(platform:"/mobile/android") {
            buyIntentionDataSet()
            from = "vip"
        }

        "/buy_intention"(platform:"/mobile/ios") {
            buyIntentionDataSet()
            from = "cart"
        }

        "/buy_intention"(platform:"/web/mobile") {
            buyIntentionDataSet()
            from = "cart_item"
        }

        "/buy_intention"(platform:"/web/desktop") {
            buyIntentionDataSet()
            from = "saved_for_later"
        }

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

//------------------------------------------------------------------------------------------------------------------------------------------------------
// TRACKS CART LIST
//------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Cart List") {

        def dataSet = {

            seller = [
                    [id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                    [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]
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

        "/cart/my_cart"(platform: "/web", dataSet)

        "/cart/my_cart/save_for_later"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]
            seller = [[id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                      [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]]


            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/my_cart/delete_item"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]
            seller = [[id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                      [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]]


            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/my_cart/change_quantity"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]
            seller = [[id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                      [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]]


            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            quantity_change = -1
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/my_cart/select_address"(platform: "/web", dataSet)

        "/cart/my_cart/dont_know_cp"(platform: "/web", dataSet)

        "/cart/my_cart/view_similar"(platform: "/web", dataSet)

        "/cart/my_cart/open_change_notification"(platform: "/web", dataSet)

        "/cart/my_cart/close_change_notification"(platform: "/web", dataSet)

        "/cart/saved_for_later"(platform: "/web", dataSet)

        "/cart/saved_for_later/add_to_cart"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]
            seller = [[id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                      [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]]


            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/saved_for_later/delete_item"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]
            seller = [[id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                      [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]]


            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/change_address"(platform: "/web", dataSet)

        "/cart/add_cp"(platform: "/web", dataSet)

    }

//------------------------------------------------------------------------------------------------------------------------------------------------------
// TRACKS MYML CART
//------------------------------------------------------------------------------------------------------------------------------------------------------

    test("MyML Cart") {

        def dataSet = {

            seller = [
                    [id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                    [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]
            ]

            buyer = [
                    [id: "208642594", nickname: "TESTEO_1", loyalty_level: "4"]
            ]

            cartContent = true

        }

        "/myml/sales/list"(platform: "/web", type: TrackType.Event) {}

        "/myml/sales/vop"(platform: "/web", type: TrackType.Event) {}

        "/myml/sales/status"(platform: "/web") {}

        "/myml/sales/status/call_to_carrier"(platform: "/web") {}

        "/myml/sales/status/pack_tutorial"(platform: "/web") {}

        "/myml/sales/detail/pack_tutorial"(platform: "/web") {}

        "/myml/sales/detail"(platform: "/web") {}

        "/myml/sales/detail/refund_money"(platform: "/web") {}

        "/myml/sales/detail/print_label"(platform: "/web") {}

        "/myml/sales/order"(platform: "/web") {}

        "/myml/sales/shipping_detail"(platform: "/web") {}

        "/myml/sales/messages"(platform: "/web") {}

        "/myml/sales/questions"(platform: "/web") {}

        "/myml/purchases/list"(platform: "/web") {}

        "/myml/purchases/detail"(platform: "/web") {}

        "/myml/purchases/detail/delete_purchase"(platform: "/web") {}

        "/myml/purchases/detail/what_do_if_i_pay"(platform: "/web") {}

        "/myml/purchases/detail/call_to_carrier"(platform: "/web") {}

        "/myml/purchases/print_label"(platform: "/web") {}

        "/myml/purchases/print_label/show_stores_map"(platform: "/web") {}

        "/myml/purchases/shipping_detail"(platform: "/web") {}

        "/myml/purchases/shipping_detail/refund_details"(platform: "/web") {}

        "/myml/purchases/messages"(platform: "/web") {}

        "/myml/purchases/questions"(platform: "/web") {}

        "/myml/purchases/canceled"(platform:"/") {}

        "/myml/purchases/order"(platform:"/") {}

        "/myml/purchases/detail/history"(platform:"/") {}

        "/myml/loyal_discounts" (platform: "/", type: TrackType.View) {}
        "/myml/loyal_discounts/add" (platform: "/web", type: TrackType.Event) {
            item = {
                id = 'MLA713079054'
                price = '300'
                original_price = '1000'
                sale_terms = [
                        {
                            id = "LOYALTY_LEVEL_6"
                            name = "Precio por nivel 6 de loyalty"
                            value_id = null
                            value_name = "25 ARS"
                            value_struct = {
                                number = 25
                                unit = "ARS"
                            }
                        },
                        {
                            id = "LOYALTY_LEVEL_5"
                            name = "Precio por nivel 5 de loyalty"
                            value_id = null
                            value_name = "25 ARS"
                            value_struct = {
                                number = 25
                                unit = "ARS"
                            }
                        },
                        {
                            id = "LOYALTY_LEVEL_4"
                            name = "Precio por nivel 4 de loyalty"
                            value_id = null
                            value_name = "25 ARS"
                            value_struct = {
                                number = 25
                                unit = "ARS"
                            }
                        },
                        {
                            id = "LOYALTY_LEVEL_3"
                            name = "Precio por nivel 3 de loyalty"
                            value_id = null
                            value_name = "25 ARS"
                            value_struct = {
                                number = 25
                                unit = "ARS"
                            }
                        }
                ]
            }
            percentage = 70
            type = "LOW_LOYAL"
        }
        "/myml/loyal_discounts/delete" (platform: "/", type: TrackType.Event) {
            item_id = 'MLA713079054'
            type = "HIGH_LOYAL"
        }


    }

    test("Recommendations") {
        "/recommendations" (platform:"/web/desktop", type: TrackType.View) {
            recommendations = {
                backend_id = "empty"
                client = "vip_middle"
                has_errors = false
                hidden_by_client = false
                track_info = {
                    has_recommendations = false
                    item_category = "MLA383490"
                    recommended_categories = []
                    recommended_items = []
                }
            }
        }

        "/recommendations/print" {}
    }

    test("Application-iOS"){
        "/application/open" (platform:"/mobile/ios", type: TrackType.Event) {}
    }

    test("Application-Android"){
        "/application/open" (platform:"/mobile/android", type: TrackType.Event) {}
    }

    test("Application-Android"){
        "/application/workaround/nohistory" (platform:"/mobile/android", type: TrackType.Event) {}
    }

    test("deals landings") {
        "/deals/landing" (platform:"/web/desktop", type: TrackType.View) {
            deal_id = "mla_1234"
        }
    }

    test("subscriptions") {
        "/subscriptions/frequency" (platform:"/", type: TrackType.View) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/change_frequency" (platform:"/", type: TrackType.View) {
            frequency = "WEEKS_2"
            frequency_before = "WEEKS_1"
            context = "frequency/buyingflow"
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/review"(platform: "/", type: TrackType.View) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/review/confirm"(platform: "/", type: TrackType.Event) {
            context = "bottom"
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }

        "/subscriptions/congrats"(platform: "/", type: TrackType.View) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/congrats/view_subscription"(platform: "/", type: TrackType.Event) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/congrats/subscribe"(platform: "/", type: TrackType.Event) {}
        "/subscriptions/summary"(platform: "/", type: TrackType.View) {}
        "/subscriptions/detail"(platform: "/", type: TrackType.View) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/detail/modify_frequency"(platform: "/" ,type: TrackType.View) {}
        "/subscriptions/change_frequency" (platform:"/", type: TrackType.View) {
            frequency = "WEEKS_2"
            frequency_before = "WEEKS_1"
            context = "details/myml"
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/address" (platform:"/", type: TrackType.View) {}
        "/subscriptions/change_address" (platform:"/", type: TrackType.Event) {
            context = "details/myml"
        }
        "/subscriptions/delivery/cancel"(platform: "/", type: TrackType.View) {
            context = "now"
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/delivery/cancel"(platform: "/", type: TrackType.Event) {
            context = "now"
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/detail/cancel"(platform: "/", type: TrackType.View) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/detail/cancel/subscription"(platform: "/", type: TrackType.Event) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }

        "/subscriptions_landing"(platform: "/", type: TrackType.View) {}

        "/subscriptions_landing/select_item_slide"(platform: "/", type: TrackType.Event) {
            category_id="CAT123"
        }

        "/subscriptions_landing/terms_condition"(platform: "/", type: TrackType.Event) {}
    }

    test("install_event"){
        "/application/install_event" (platform: "/mobile", type: TrackType.Event){
        }
    }
    test("sso"){
        "/sso/login_successful" (platform: "/mobile", type: TrackType.Event){}
        "/sso/logout_successful" (platform: "/mobile", type: TrackType.Event){}
        "/sso/attempt_successful" (platform: "/mobile", type: TrackType.Event){}
        "/sso/attempt_error" (platform: "/mobile", type: TrackType.Event){}
    }

    test("cx"){
        "/cx/click_on_article" (platform: "/mobile", type: TrackType.Event){
            article_id = "MLA754486062"
        }
        "/cx/click_on_help" (platform: "/mobile", type: TrackType.Event){}
        "/cx/click_on_error" (platform: "/mobile", type: TrackType.Event){}
        "/cx/click_on_suggestion" (platform: "/mobile", type: TrackType.Event){}
        "/cx/contact_types/click_on_contact_form" (platform: "/mobile", type: TrackType.Event) {}
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

    test("free data") {

        "/free_navigation"(platform:"/mobile", type:TrackType.Event) {
            status = "sponsored"
        }

        "/free_navigation/dialog"(platform:"/mobile", type:TrackType.View) {
        }

        "/free_navigation/snackbar"(platform:"/mobile", type:TrackType.View) {
        }

        "/free_navigation/dialog_dismissed"(platform:"/mobile", type:TrackType.Event) {
            is_checkbox_checked = true
        }

        "/free_navigation/purchase"(platform:"/mobile", type:TrackType.Event) {
            status = "sponsored"
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

    test("Bugsnag tracks to use on Canejo ML") {
        "/mobile/bugsnag"(platform:"/mobile/ios", type:TrackType.Event) {
            error_type = "signal"
            error_context = "withdraw"
            error_severity = "error"
            url_error = "<none>"
            error_mach_exception_name = "<none>"
            error_address = "4402117060"
            error_message = ""
            error_Id = "5aa6bcd0c098f300193384fb"
            error_timestamp = "2018-04-18T14:18:09.301Z"
            error_exception_class = "SIGTRAP"
            release_stage = "production"
            error_signal_name = "SIGTRAP"
            error_nsexception = "<none>"
        }
    }

}
