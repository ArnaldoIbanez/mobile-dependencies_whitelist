package src.test.resources.melidata

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

    test("Mobile Landings") {
        "/landing/generic"(platform: "/mobile"){
            url = "https://www.mercadolibre.com"
            is_main_url = true
            version = "2"
        }
        "/landing/generic"(platform: "/mobile", business: "mercadopago"){
            url = "https://www.mercadolibre.com"
            is_main_url = true
            version = "2"
        }

        "/webkit/deeplink_open/error"(platform: "/mobile") {
            url = "https://www.mercadolibre.com"
            deeplink = "meli://host/path/to/landing"
        }
    }

    test("Mobile Landing loading time") {
        "/landing/load"(platform: "/mobile") {
            url = "https://www.mercadolibre.com"
            status = "success"
            loading_time = 500
        }

        "/landing/load"(platform: "/mobile", business: "mercadopago") {
            url = "https://www.mercadopago.com"
            status = "error"
            loading_time = 200
        }
    }

    test("Oficial stores landings") {

        "/landing/brands/abort"(platform: "/mobile") {
            query = "adidas"
        }

        "/landing/brands/open"(platform: "/mobile") {
            query = "adidas"
            official_store_id = "adidas_12345"
            official_store_name = "Adidas oficial store"
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

    test("Item events"){
        def dataListItem = {
            item_id = "MLA123456"
            listing_type_id = "gold_special"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
            category_id = "MLA3530"
            category_path = ["MLA1459", "MLA3530"]
        }

        def dataListItemWithCategorySuggestion = {
            item_id = "MLA123456"
            listing_type_id = "gold_special"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
            category_id = "MLA3530"
            category_path = ["MLA1459", "MLA3530"]
            suggested_category_id = "MLA1915"
            suggested_category_is_leaf = false
            suggested_category_path = ["MLA1459", "MLA3530"]
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
            quantity = 1
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
        "/item/update"(platform: "/web"){
            item_id = "MLA12345"
            variations_changed = true
            title_changed = true
            stock_changed = true
            price_changed = true
        }
        "/item/create"(platform: "/web", dataListItemWithCategorySuggestion)
        "/item/change_listing_type"(platform: "/web", dataChangeListingTypeItemFullInfo)
        "/item/change_listing_type"(platform: "/web", dataChangeListingTypeItemMinimumInfo)
        "/item/relist"(platform: "/web", dataRelistItem)
        "/item/relist"(platform: "/web", dataRelistItemWithParentInformation)
    }

    test("Download app landing tracking") {

        "/download-app"(platform: "/web"){}
        "/download-app/send"(platform: "/web", type: TrackType.Event){
            user_phone_number = "000123456789"
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
            payment_status_detail = "ACCREDITED"
            congrats_status = "APPROVED"
            token_generated_with_esc = "NO"
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
            payment_status_detail = "ACCREDITED"
            congrats_status = "APPROVED"
            token_generated_with_esc = "NO"
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

    test("MP-MA Landing QR") {
        "/merchant_acquisition/" (platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/qr" (platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/qr/landing" (platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/qr/landing/buyers"(platform: "/", type: TrackType.View){}
        "/merchant_acquisition/qr/landing/buyers"(platform: "/web/desktop", type: TrackType.View){}
        "/merchant_acquisition/qr/landing/buyers"(platform: "/web/mobile", type: TrackType.View){}
    }

    test("Landing mercadolibre payers growth") {
        "/payers_growth/landings" (platform: "/") {
            product = "rola-buyers"
        }
        "/payers_growth/landings" (platform: "/") {
            product = "rola-mkt"
        }
        "/payers_growth/landings" (platform: "/") {
            product = "mgm"
        }
    }

    test("apparel") {
        "/home/category/apparel" (platform:"/", type: TrackType.View) {
            gender="male"
            category_id="MLM1430"
            category_path="/home/category/apparel"
        }

        "/home/category/apparel/stores" (platform:"/", type: TrackType.View) {
            gender="male"
            category_id="MLM1430"
            category_path="/home/category/apparel"
        }

        "/home/category/apparel/tabs" (platform:"/", type: TrackType.Event) {
            gender="male"
            category_id="MLM1430"
            category_path="/home/category/apparel"
        }

        "/home/category/apparel/slider" (platform:"/", type: TrackType.Event) {
            gender="male"
            link="https://www.mercadolibre.com.mx/exhibitor-link"
            title="Campaña"
            category_id="MLM1430"
            category_path="/home/category/apparel"
        }

        "/home/category/apparel/category" (platform:"/", type: TrackType.Event) {
            gender="male"
            category_id="MLA123567"
            link="https://www.mercadolibre.com.ar/link-de-categoría"
            category_path="/home/category/apparel"
            name="Category"
        }

        "/home/category/apparel/items" (platform:"/", type: TrackType.Event) {
            gender="male"
            item_id="MLA123567"
            section="Publicaciones destacadas"
            category_id="MLM1430"
            category_path="/home/category/apparel"
        }

        "/home/category/apparel/more_categories" (platform:"/", type: TrackType.Event) {
            gender="male"
            category_id="MLM1430"
            category_path="/home/category/apparel"
        }

        "/home/category/apparel/official_store" (platform:"/", type: TrackType.Event) {
            gender="male"
            link="https://www.mercadolibre.com.ar/link-de-tienda-oficial"
            context="home"
            category_id="MLM1430"
            category_path="/home/category/apparel"
            name="Tienda oficial"
        }

        "/home/category/apparel/images" (platform:"/", type: TrackType.Event) {
            gender="male"
            link="https://www.mercadolibre.com.ar/link-de-tienda-oficial"
            image="Tienda Oficial"
            category_id="MLM1430"
            category_path="/home/category/apparel"
        }

    }

    test("sso"){
        "/sso/login_successful" (platform: "/mobile", type: TrackType.Event){}
        "/sso/login_successful" (platform: "/mobile", type: TrackType.Event, business: "mercadopago"){}
        "/sso/logout_successful" (platform: "/mobile", type: TrackType.Event){}
        "/sso/logout_successful" (platform: "/mobile", type: TrackType.Event, business: "mercadopago"){}
        "/sso/attempt_successful" (platform: "/mobile", type: TrackType.Event){}
        "/sso/attempt_successful" (platform: "/mobile", type: TrackType.Event, business: "mercadopago"){}
        "/sso/attempt_error" (platform: "/mobile", type: TrackType.Event){}
        "/sso/attempt_error" (platform: "/mobile", type: TrackType.Event, business: "mercadopago"){}
    }

}
