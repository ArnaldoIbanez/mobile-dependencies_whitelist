package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    //VIP FLOW
    test("Vip min core tracking in android") {
        def mandatory= {
            item_id = "MLA533657947"
            category_id = "MLA43718"
            buying_mode = "buy_it_now"
            category_path = ["MLA1234","MLA6789"]
            vertical = "core"
            item_condition = "new"
            listing_type_id = "gold_special"
            item_status = "active"
            deal_ids = []
            seller_id = 131662738

            price = 15.3
            currency_id = "ARS"
            original_price = 18.0
            discount_reasons = ["loyalty","deal"]
        }

        def optionals = {
            cac_item = false
            cac_status = "normal"
            quantity = 3
            best_seller_position = 5
            return_available = false
            cart_content = false
            add_to_cart_availability = "no_high_ratio"
            main_action = "buy"
            power_seller_status = "platinum"
            reputation_level = "5_green"
            official_store_id = 1
            store_type = "brand"
            shipping_mode = "me2"
            free_shipping = true
            local_pick_up = false
            logistic_type = "fulfillment"
            free_shipping_benefit = false
            loyalty_level = 2
            price_comparison_available = true
            has_good_price = true
            price_comparison_position =  0.75
            whatsapp_available = "false"
            video_type = "TOUR360"
            quote_demand_available = false
            new_wording_free = false
            quantity_models = 4
            item_attributes = "promotions,cbt_ddu,discount"
			city = "none"
			neighborhood = "none"
			state = "none"
            vip_version = "new"
        }

        Object items_attributes = {
            map_item_attributes = [
                    [ attribute_id:"BRAND", value_id:"60297", value_name:"Toyota"],
                    [ attribute_id:"MODEL", value_id:"60337", value_name:"Yaris" ],
                    [ attribute_id:"YEAR", value_name:"2012"]
            ]
        }

        "/vip"(platform:"/mobile", {
            mandatory()
            catalog_listing = false
            items_attributes()
        })

        "/vip"(platform: "/web/mobile", {
            mandatory()
            catalog_listing = false
            items_attributes()
        })

        "/vip"(platform: "/web/desktop", {
            mandatory()
            catalog_listing = false
            items_attributes()
        })

        "/vip"(platform:"/mobile", {
            mandatory()
            optionals()
            catalog_listing = false
            attribute_combinations = 1
            attributes_quantities = [11]
        })

        "/vip"(platform:"/mobile", {
            mandatory()
            optionals()
            shipping_preference = "Express a domicilio"
            available_subscriptions = true
            subscription_discount = 10
            default_tab = "subscription"
            whatsapp_installed = true
            catalog_listing = false
            attribute_combinations = null
            attributes_quantities = null
        })

        "/vip/failure"(platform:"/mobile", {
            item_id = "MLA533657947"
            error_message = "any message"
        })

        "/vip/abort"(platform:"/mobile", mandatory)

        "/vip/back"(platform:"/mobile", mandatory)

        "/vip/color_and_size"(platform:"/mobile", mandatory)

        "/vip/description/abort"(platform:"/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/description/back"(platform:"/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/description/failure"(platform:"/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/price_comparison"(platform:"/", type: TrackType.Event, {
            mandatory()
            optionals()
        })

        "/vip/contact_seller"(platform:"/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
            deal_ids = []
            item_condition= "new"
        })

        "/vip/contact_seller"(platform: "/web/desktop", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
            deal_ids = []
            item_condition= "new"
        })

        "/vip/contact_seller"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
            deal_ids = []
            item_condition= "new"
        })

        "/vip/contact_seller"(platform: "/", type: TrackType.Event, {
            mandatory()
            unregistered_contact = false
            captcha_showed = false
            deal_ids = []
            item_condition= "new"
            has_good_price= true
        })

        "/vip/call_seller"(platform:"/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
            from_view="vip"
            event_source="modal"
        })

        "/vip/call_seller"(platform:"/web/desktop", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
            from_view="vip"
            event_source="button"
            catalog_listing=false
            source=""
        })

        "/vip/call_seller"(platform:"/web/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
            from_view="vip"
            event_source="link"
            catalog_listing=false
            source=""
        })

        "/vip/contact_whatsapp"(platform: "/mobile", type: TrackType.Event, {
            mandatory()
        })

        "/vip/contact_whatsapp"(platform: "/mobile", type: TrackType.Event, {
            item_id = "MLB1246990714"
            catalog_listing = false
            buying_mode = "classified"
            vertical = "motors"
            from_view = "vip"
            deal_ids = ["MLB2633"]
            event_source = "button"
            source = ""
            item_status = "active"
            category_id = "MLB1744"
            category_path = ["MLA1234", "MLA6789"]
            item_seller_type = "car_dealer"
            item_condition = "new"
            listing_type_id = "gold_premium"
            has_good_price = false
            seller_id = 210183916
        })

        "/vip/call_seller_intention"(platform: "/mobile", type: TrackType.Event, {
            mandatory()
            item_id = "MLA533657947"
            event_source="link"
        })

        "/vip/contact_whatsapp_intention"(platform: "/mobile", type: TrackType.Event, {
            mandatory()
            event_source="link"
            catalog_listing=false
            source=""
        })

        "/vip/call_seller_intention"(platform: "/web", type: TrackType.Event, {
            mandatory()
            item_id = "MLA533657947"
            event_source="link"
        })

        "/vip/contact_whatsapp_intention"(platform: "/web", type: TrackType.Event, {
            mandatory()
            item_id = "MLA533657947"
            event_source="link"
            catalog_listing=false
            source=""
        })

        "/vip/contact_whatsapp"(platform: "/web", type: TrackType.Event, {
            mandatory()
            item_seller_type="normal"
            event_source="button"
            from_view="vip"
            catalog_listing=false
            source=""
        })

        "/vip/contact_whatsapp"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
            item_seller_type="normal"
            event_source="button"
            from_view="vip"
            event_source = "link"
            catalog_listing=false
            source=""
        })

        "/vip/show_phone"(platform: "/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/desktop", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/desktop", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone_intention"(platform: "/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone_intention"(platform: "/web/desktop", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone_intention"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone_intention"(platform: "/web/desktop", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone_intention"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/description/failure"(platform:"/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/item_gallery"(platform:"/mobile") {
            context = "/vip"
        }

        "/vip/item_gallery/back"(platform:"/mobile") {}

        "/vip/map"(platform:"/mobile", mandatory)

        "/vip/seller_reputation"(platform:"/mobile") {}

        "/vip/seller_reputation/ratings"(platform:"/mobile") {}

        "/vip/payment_method"(platform: "/mobile") {}

        "/vip/payment_method/back"(platform: "/mobile") {}

        "/vip/variations"(platform: "/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/variations/back"(platform: "/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/quantity"(platform: "/mobile") {
            item_id = "MLA533657947"
        }

        "/vip/question_intention"(platform: "/web/desktop", type: TrackType.Event, {
            mandatory()
            optionals()
            unregistered_contact = false
            unregistered_contact_context = false
            event_source = "description"
        })

        "/vip/question_intention"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
            unregistered_contact = true
            unregistered_contact_context = false
            event_source = "technicalSpecs"
            source = "htmlView"
            item_seller_type="car_dealer"
        })

        "/vip/question_intention"(platform: "/mobile", type: TrackType.Event, {
            item_id= "MLB1650303704"
            listing_type_id = "gold_premium"
            item_condition= "used"
            deal_ids= []
            category_id= "MLB1744"
            category_path=  ["MLB1743","MLB1744"]
            vertical= "motors"
            item_status= "active"
            buying_mode= "classified"
            seller_id= 308998259
            item_seller_type= "car_dealer"
            event_source= "vip"
            unregistered_contact= false
            unregistered_contact_context= false
            has_good_price= false
        })

        "/vip/captcha_showed"(platform: "/web/desktop", type: TrackType.Event, {
            mandatory()
            optionals()
        })

        "/vip/captcha_showed"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
        })

        "/vip/quote_demand_intention"(platform: "/web/desktop", type: TrackType.Event) {
            mandatory()
            optionals()
            item_seller_type = "AB001"
        }

        "/vip/quote_demand_messages"(platform: "/web/desktop", type: TrackType.Event) {
            mandatory()
            optionals()
            item_seller_type = "AB001"
        }

	  	"/vip/quote_demand_intention_lower"(platform: "/mobile", type: TrackType.Event) {
	        item_id = "MLA533657947"
	        category_id = "MLA43718"
	        buying_mode = "buy_it_now"
	        category_path = ["MLA1234", "MLA6789"]
	        vertical = "core"
	        item_condition = "new"
	        listing_type_id = "gold_special"
	        item_status = "active"
	        seller_id = 131662738
	        price = 15.3
	        currency_id = "ARS"
	        original_price = 18.0
	        discount_reasons = ["loyalty", "deal"]
	        optionals()
	        item_seller_type = "AB001"
	        from_view="vip"
	        resolution = "high"
	    }

	  	"/vip/quote_demand_intention"(platform: "/mobile", type: TrackType.Event) {
	        item_id = "MLA533657947"
	        category_id = "MLA43718"
	        buying_mode = "buy_it_now"
	        category_path = ["MLA1234", "MLA6789"]
	        vertical = "core"
	        item_condition = "new"
	        listing_type_id = "gold_special"
	        item_status = "active"
	        seller_id = 131662738
	        price = 15.3
	        currency_id = "ARS"
	        original_price = 18.0
	        discount_reasons = ["loyalty", "deal"]
	        optionals()
	        item_seller_type = "AB001"
	        from_view="vip"
	        resolution = "high"
	    }

        "/vip/quote_demand_messages"(platform: "/mobile", type: TrackType.Event) {
	        item_id = "MLA533657947"
	        category_id = "MLA43718"
	        buying_mode = "buy_it_now"
	        category_path = ["MLA1234", "MLA6789"]
	        vertical = "core"
	        item_condition = "new"
	        listing_type_id = "gold_special"
	        item_status = "active"
	        seller_id = 131662738
	        price = 15.3
	        currency_id = "ARS"
	        original_price = 18.0
	        discount_reasons = ["loyalty", "deal"]
	        optionals()
	        item_seller_type = "AB001"
	        from_view="vip"
	        resolution = "high"
    	}

        //with deals_ids
        "/vip/quote_demand_intention"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA533657947"
            category_id = "MLA43718"
            buying_mode = "buy_it_now"
            category_path = ["MLA1234", "MLA6789"]
            vertical = "core"
            item_condition = "new"
            listing_type_id = "gold_special"
            item_status = "active"
            seller_id = 131662738
            price = 15.3
            currency_id = "ARS"
            original_price = 18.0
            discount_reasons = ["loyalty", "deal"]
            deal_ids = ["MLA123"]
            optionals()
            item_seller_type = "AB001"
            from_view = "vip"
            resolution = "high"
        }

        "/vip/quote_demand_messages"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA533657947"
            category_id = "MLA43718"
            buying_mode = "buy_it_now"
            category_path = ["MLA1234", "MLA6789"]
            vertical = "core"
            item_condition = "new"
            listing_type_id = "gold_special"
            item_status = "active"
            seller_id = 131662738
            price = 15.3
            currency_id = "ARS"
            original_price = 18.0
            discount_reasons = ["loyalty", "deal"]
            deal_ids = []
            optionals()
            item_seller_type = "AB001"
            from_view = "vip"
            resolution = "high"
        }
    }
    test("Vip web mobile tracking without reviews") {

        "/vip"(platform:"/web/mobile") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=-1
            buying_mode = "buy_it_now"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
            contract_available = false
            catalog_listing = false
        }
    }

    test("vip - tour 360") {

        def dataSet = {
            item_id = "MLC537771292"
            category_id = "MLC183186"
            buying_mode = "classified"
            category_path = [
                    "MLC1459",
                    "MLC1472",
                    "MLC6407",
                    "MLC183186"]
            vertical = "realEstate"
            item_condition = "used"
            listing_type_id = "gold"
            item_status = "active"
            deal_ids = []
            catalog_listing = false
            city = "Santiago"
            neighborhood = "Santa Isabel"
            state = "RM (Metropolitana)"
            seller_id = 516954617
            contract_available = false
            comparator_available = false
            gallery_pattern = "X"
            price_comparison_available = null
            price_comparison_position = null
            whatsapp_available = "false"
            quote_demand_available = false
            description_type = "plain_text"
            quantity_models = null
            domain_id = "MLC-APARTMENTS_FOR_RENT"
        }

        def tourOption = {
            dataSet()
            video_type = "TOUR360"
        }

        def videoOption = {
            dataSet()
            video_type = "VIDEO"
        }

        def noneOption = {
            dataSet()
            video_type = "NONE"
        }

        "/vip/video_focus"(platform: "/", type: TrackType.Event) {
            tourOption()
        }
        "/vip/video_focus"(platform: "/", type: TrackType.Event) {
            videoOption()
        }

        "/vip/video_focus"(platform: "/", type: TrackType.Event) {
            noneOption()
        }
    }

    test("Vip web mobile with reviews") {
        "/vip"(platform:"/web/mobile") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=3.5
            buying_mode = "buy_it_now"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
            contract_available = false
            catalog_listing = false
        }
    }

    test("Vip show payment methods") {
        "/payment_methods/show"(platform: "/mobile", type: TrackType.View) {
            context = "vip"
            item_id = "MLB533657947"
        }
    }

    test("Vip web desktop without reviews") {
        "/vip"(platform:"/web/desktop") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=-1
            buying_mode = "buy_it_now"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
            catalog_listing = false
        }
    }

    test("Vip web desktop with reviews") {
        "/vip"(platform:"/web/desktop") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=5
            buying_mode = "buy_it_now"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
            catalog_listing = false
        }
    }

    test("Vip tracking in web") {
        def dataSet = {
            item_id = "MLA533657947"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            buying_mode = "buy_it_now"
            official_store_id = 1
            deal_ids = ["MLA24"]
            review_rate=5
            specifications_size = 1
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
            catalog_listing = false
            tracking_id="dd1ec405-0a55-4b55-aaa5-de29cc3ab5fb"
        }

        "/vip"(platform:"/web", dataSet)

        "/vip/sizechart"(platform: "/", type: TrackType.View) {
            item_id = "MLA533657947"
        }

        "/vip/sizechart/tutorial"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA533657947"
        }

        "/vip/show_sizechart_reviews"(platform: "/", type: TrackType.Event) {
            item_id = "MLA533657947"
        }
    }

    test("Vip protected purchase") {
        "/vip/protected_purchase/show" (platform:"/web/mobile", type: TrackType.Event) {
            category_id = "MLA1234"
            item_id="MLA1891239"
            category_path = ["MLA1234","MLA6789"]
            buying_mode = "buy_it_now"
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
        }

        "/vip/protected_purchase/close" (platform:"/web/mobile", type: TrackType.Event) {
            category_id = "MLA1234"
            category_path = ["MLA1234","MLA6789"]
            item_id="MLA1891239"
            buying_mode = "buy_it_now"
            vertical = "motors"
            item_condition = "new"
            item_status = "paused"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
        }
    }


    test("melidata vip track") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            category_id = "MLA123"
            category_path = ["MLA1234","MLA6789"]
            buying_mode = "buy_it_now"
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = []
            billboard_clicked_position = "3"
            tracking_id="dd1ec405-0a55-4b55-aaa5-de29cc3ab5fb"
        }

        def trackModals = {
            show = "fae_details"
            item_id = "MLA213512313"
            category_id = "MLA123"
        }

        "/vip/variations"(platform: "/web") {
            item_id = "MLA213512313"
        }

        "/vip/picker_selection"(platform: "/", type: TrackType.Event) {
            item_id = "MLA213512313"
            picker_id = "SIZE"
            attribute_id = "TQ=="
        }

        "/vip/reviews"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            trackModals()
        }

        "/vip/coordinate_availability"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
            item_seller_type= "normal"
            from_view="howToContract"
            catalog_listing="Item's catalog listing"
            category_path=["MLA1540","MLA122258"]
        }

        "/vip/coordinate_intention"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/vip/contract_intention"(platform: "/mobile", type: TrackType.Event) {
            buying_mode= "classified"
            category_id= "MLA43972"
            category_path= ["MLA1540","MLA122258"]
            from_view="howToContract"
            item_condition="not_specified"
            item_id="MLA812057056"
            item_seller_type = "normal"
            item_status = "active"
            listing_type_id = "gold_premium"
            seller_id= 86995812
            vertical= "services"
        }

        "/vip/contract_intention"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/vip/similar_vehicles"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/vip/similar_vehicles"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
        
        "/vip/free_shipping_cart_available"(platform: "/web", type:TrackType.Event){
        }

        "/vip/description"(platform: "/web", type: TrackType.View){
            item_id = "MLA213512313"
        }

        "/vip/show_all_description"(platform: "/", type: TrackType.Event){
            item_id = "MLA213512313"
            has_good_price = true
        }

        "/vip/technical_specs"(platform: "/web", type: TrackType.View){
            item_id = "MLA213512313"
            vertical = "core"
            vip_version = "new"
            has_good_price = false
        }

        "/vip/technical_specs/see_more"(platform: "/web", type: TrackType.Event){
            item_id = "MLA213512313"
            vertical = "motors"
            category_id = "MLA401803"
            item_status = "active"
            category_path = [
                    "MLA1459",
                    "MLA1493",
                    "MLA1495",
                    "MLA401803"
            ]
            has_good_price = true
        }

        "/vip/denounce_intention"(platform: "/web", type: TrackType.Event){
            item_id = "MLA213512313"
            vertical = "motors"
            category_id = "MLA401803"
            item_status = "active"
            category_path = [
                    "MLA1459",
                    "MLA1493",
                    "MLA1495",
                    "MLA401803"
            ]
            has_good_price = true
        }

        "/vip/question"(platform: "/", type: TrackType.View){
            item_id = "MLA213512313"
            vip_version = "new"
            has_good_price = false
        }

        "/vip/question"(platform: "/", type: TrackType.View){
            item_id = "MLA213512313"
            unregistered_contact = false
            unregistered_contact_context = false
            event_source= "description"
        }

        "/vip/questions/show"(platform: "/", type: TrackType.View) {
            item_id = "MLA213512313"
            catalog_product_id="MLA123456"
            vip_version = "new"
            has_good_price = true
        }

        "/vip/questions/quick_access"(platform: "/",type: TrackType.View) {
            item_id = "MLA112341"
            domain_id = "celulares"
            type = "payment"
            context = "/qadb"
            vip_version = "new"
        }

        "/vip/qadb/call-to-action"(platform: "/", {
            item_id = "MLA112341"
        })
    }

    test("New Shipping calculator"){

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            category_id = "MLA123"
            vertical = "core"
        }

        "/vip/shipping/calculator/calculate"(platform: "/") {
            defaultTrackInformation()
            cp_autocomplete = "yes"
        }

        "/vip/shipping/calculator/i_dont_know_my_code"(platform: "/") {
            defaultTrackInformation()
        }

        "/vip/shipping/calculator/calculate_error"(platform: "/") {
            defaultTrackInformation()
            error_type = "error code"
        }

        "/vip/shipping/calculator/agencies/show_agencies_map_for_pickup"(platform: "/") {
            defaultTrackInformation()
        }

        "/vip/shipping/calculator/choose_state"(platform: "/") {
            defaultTrackInformation()
        }

        "/vip/shipping/calculator/choose_city"(platform: "/") {
            defaultTrackInformation()
        }

        "/vip/shipping/calculator/preloaded"(platform: "/web/mobile"){
            defaultTrackInformation()
        }

        "/vip/shipping/calculator/shipping_options"(platform: "/web/mobile"){
            defaultTrackInformation()
        }

        def defaultShipping = [
        shipping_type : "delivery",
        shipping_method_id : 123,
        shipping_benefit : "loyalty",
        shipping_price : [
            price : 0,
            currency_id  : "ARS",
        ],
        shipping_days : [
            min : 4,
            max : 5
        ],
        recommend : true
        ]

        def otherShipping = [
        shipping_type : "delivery",
        shipping_method_id : 1234,
        shipping_price : [
            price : 100 ,
            currency_id  : "ARS"
        ],
        shipping_days : [
            min : 4,
            max : 5
        ],
        recommend : false
        ]

        "/vip/shipping/calculator/go_to_vip"(platform: "/") {
            item_id = "MLA123"
            item_selected_quantity = 1
            item_shipping_quantity = 1
            shipping_default = defaultShipping
            shipping_selected = defaultShipping
            shipping_available_opcion = [
            defaultShipping,
            otherShipping
        ]
        }
    
    }

    test("VIP Web Classifieds services track click on link to landing_services") {
        "/vip/landing_services"(platform: "/web", type: TrackType.Event) {
            item_id = "MLA213512313"
            category_id = "MLA123"
            vertical = "services"
            buying_mode = "classified"
            category_path = ["MLA1234","MLA6789"]
            item_condition = "new"
            listing_type_id = "gold_special"
            item_status = "active"
            deal_ids = []
            seller_id = 123456789
        }
    }

    // RESERVATION

    test("VIP Web reservation onboard ") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            category_id = "MLA123"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            listing_type_id = "gold_premium"
            item_seller_type = "car_dealer"
            item_condition = "new"

        }

        def onboardInformation = {
            item_status = "active"
            buying_mode = "classified"
            deal_ids = []
            seller_id = 123456789
            contract_available = false
            comparator_available = true
            gallery_pattern = "XXXXXXXX"
            description_type = "plain_text"
            reputation_level = "5_green"
        }

        "/vip/reservation_onboard"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
            onboardInformation()
        }

        "/vip/reservation_onboard/ok"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
            onboardInformation()
        }

        "/vip/reservation_onboard/close"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
            onboardInformation()
        }

        "/vip/reservation_payment_options"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }

        "/vip/reservation_information"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }

    }

    test("VIP Actions") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            quantity = 1
            has_variations = true
        }

        def cartInformation = {
            cart_content = false
            add_to_cart_availability = "yes_default"
            main_action = "buy"
        }

        def shippingInformation = {
            shipping_preference = "Normal a Domicilio"
            shipping_mode = "me1"
            free_shipping = false
            local_pick_up = false
            logistic_type = "default"
            free_shipping_benefit = false
            shipping_promise = {
                afterDispatch = true
                min_days = 2
                max_days = 12
                price = {
                    amount = 10000
                    currency_id = "ARS"
                    is_loyalty_discount = false
                }
                destination = "1429"
            }
        }

        def variationInformation = {
            preselection_type = "parcial"
            enforced_preselection = "stock"
        }

        def pricingTwoPointO = {
            available_promotions=[
                {
                    campaign_id = "1761"
                    type = "DISCOUNT"
                    original_value = 953
                    value = 643.5
                }
            ]
            discount_reasons=["deal"]
        }

        "/vip/buy_action"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            cartInformation()
            shippingInformation()
            credits_opensea = true
            vip_version = "new"
        }

        "/vip/profile_intention"(platform: "/", type: TrackType.Event) {
            context = '/vip'
            seller_id = 131662738
            buying_mode = "classified"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            item_id = "MLA533657947"
            vertical = "services"
            item_condition = "new"
            listing_type_id = "silver"
            item_status = "active"
            deal_ids = []
            item_seller_type = "normal"
            from_view = "unitsAvailable"
            catalog_listing = false
            review_rate=-1
        }

        "/vip/buy_action"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
            cartInformation()
            shippingInformation()
            variationInformation()
            shipping_pay_before = false
        }

         "/vip/add_cart_action"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            cartInformation()
            shippingInformation()
            vip_version = "new"
         }

        "/vip/add_cart_action"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
            cartInformation()
            shippingInformation()
            variationInformation()
            shipping_pay_before = false
        }
        
        def shipping_method = { 
            shipping_method = {
                id = 531332827
                name = "Retiro en Correo Argentino"
                currency_id = "ARS"
                list_cost =  178.49
                cost = 178.49
                base_cost = 169.99
                display = "recommended"
                shipping_method_id = 503045
                shipping_method_type = "standard"
                shipping_option_type = "agency"
                estimated_delivery_time = {
                    type = "unknown_frame"
                    date = "2018-12-06T00:00:00.000-03:00"
                    shipping = 48
                    unit =  "hour"
                    offset = {
                        date =  "2018-12-10T00:00:00.000-03:00"
                        shipping = 48
                    }
                }      
            }
        }

        "/vip/quantity_change"(platform: "/", type: TrackType.Event) {
            item_id = "MLA533657947"
            price = 123
            zip_code = 123
            quantity = 2
            has_shipping = false
            shipping_method()
            vip_version = "new"
        }

        // PRICING 2.0

        "/vip/buy_action"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            cartInformation()
            shippingInformation()
            pricingTwoPointO()
            credits_opensea = true
            vip_version = "new"
        }

         "/vip/add_cart_action"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            cartInformation()
            shippingInformation()
            pricingTwoPointO()
            vip_version = "new"
         }
    }

    test("VIP zipcode") {

        "/vip/input_zip_code"(platform: "/", type: TrackType.View) {}

         "/vip/input_zip_code/dont_know_my_zip_code"(platform: "/", type: TrackType.Event) {}
    }

    test("VIP fulfillment onboardings") {

        "/vip/show_fulfillment_popup"(platform: "/", type: TrackType.Event) {
            item_id = "MLA533657947"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            item_condition = "new"
            seller_id = 131662738
            price = 15.3
            currency_id = "ARS"
            original_price = 18.0
            vip_version = "new"
        }

        "/vip/show_fulfillment_tooltip"(platform: "/") {
            item_id = "MLA533657947"
            buyer_id = "12343718"
            vip_version = "new"
        }

        "/vip/close_fulfillment_tooltip"(platform: "/", type: TrackType.Event) {
            item_id = "MLA533657947"
            buyer_id = "12343718"
            vip_version = "new"
        }

        "/vip/credits_tooltip/show"(platform: "/", {
            item_id = "MLA533657947"
            buyer_id = "12343718"
            vip_version = "new"
        })

        "/vip/credits_tooltip/close"(platform: "/", type: TrackType.Event, {
            item_id = "MLA533657947"
            buyer_id = "12343718"
            vip_version = "new"
        })
    }

    test("VIP fulfillment free shipping onboardings") {

        "/vip/show_fulfillment_fs_popup"(platform: "/", type: TrackType.Event) {
            item_id = "MLA533657947"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            item_condition = "new"
            seller_id = 131662738
            price = 15.3
            currency_id = "ARS"
            original_price = 18.0
            vip_version = "new"
        }

        "/vip/show_fulfillment_fs_tooltip"(platform: "/") {
            item_id = "MLA533657947"
            buyer_id = "12343718"
            vip_version = "new"
        }

        "/vip/close_fulfillment_fs_tooltip"(platform: "/", type: TrackType.Event) {
            item_id = "MLA533657947"
            buyer_id = "12343718"
            vip_version = "new"
        }

        "/vip/credits_tooltip/show"(platform: "/", {
            item_id = "MLA533657947"
            buyer_id = "12343718"
            vip_version = "new"
        })

    }


    test("VIP Shipping Calculator"){

        def model = {
            location = {
                type = "zip_code"
                value = "1234"
            }
            shipping_methods = [{
                cost = 50
                promoted_amount = 12
                delivery_type = "seller_agreement"
                selected = false
                promise = {
                    to = 4
                    from = 5
                    deferred = true
                }}]
        }

        def shipping_method = {
            selected_method = {
                cost = 50
                promoted_amount = 12
                delivery_type = "seller_agreement"
                selected = false
                promise = {
                    to = 4
                    from = 5
                    deferred = true
                }
            }
        }


        "/vip/shipping_calculator"(platform: "/", type: TrackType.View) {
            model()
            item_id = "MLA533657947"
        }

         "/vip/shipping_calculator/select"(platform: "/", type: TrackType.Event) {
            model()
            shipping_method()
        }
        
        "/vip/shipping_calculator/modify"(platform: "/", type: TrackType.Event) {
        }
        
        "/vip/shipping_calculator/show_map"(platform: "/", type: TrackType.Event) {
             model()
        }


        "/vip/shipping_calculator"(platform: "/web/desktop", type: TrackType.View) {
            model()
        }

         "/vip/shipping_calculator/select"(platform: "/web/desktop", type: TrackType.Event) {
            model()
            shipping_method()
        }

        "/vip/shipping_calculator/cancel"(platform: "/web/desktop", type: TrackType.Event) {
            model()
        }
        
        "/vip/shipping_calculator/modify"(platform: "/web/desktop", type: TrackType.Event) {
        }
        
        "/vip/shipping_calculator/show_map"(platform: "/web/desktop", type: TrackType.Event) {
             model()
        }
        
        
        //Apps
        "/vip/shipping_calculator"(platform: "/mobile/ios", type: TrackType.View) {
            model()
        }

         "/vip/shipping_calculator/select"(platform: "/mobile/ios", type: TrackType.Event) {
            model()
            shipping_method()
        }

        "/vip/shipping_calculator/modify"(platform: "/mobile/ios", type: TrackType.Event) {
        }

    
        "/vip/shipping_calculator/cancel"(platform: "/mobile/ios", type: TrackType.Event) {
        }
                
        "/vip/shipping_calculator/show_map"(platform: "/mobile/ios", type: TrackType.Event) {
            model()
        }
    }

    test("VIP public similar intention"){
        def model = {
            category_id = "MLC24350"
            category_path = [
                "MLC1743",
                "MLC1744",
                "MLC6619",
                "MLC24350"
            ]
            item_id = "MLC493108266"
            item_condition = "used"
            vertical = "motors"
            listing_type_id = "gold_premium"
            item_seller_type = "normal"
            vip_version = "new"
        }

        "/vip/public_similar_intention"(platform: "/web", type: TrackType.Event) {
            model()
        }
    }

    test("VIP Units available section for projects RE"){
        def properties = {
            vertical = "realEstate"
            from_view = "unitsAvailable"
            seller_id =  430012134
            item_seller_type = "real_estate_agency"
            listing_type_id = "silver"
            category_id = "MLA401803"
            item_status = "active"
            item_id = "MLA792156560"
            item_condition = "new"
            category_path = [
                "MLA1459",
                "MLA1493",
                "MLA1495",
                "MLA401803"
            ]
            buying_mode = "classified"
        }

        "/vip/units_available"(platform: "/mobile", type: TrackType.View){
            properties()
        }


        "/vip/contact_seller"(platform: "/mobile", type: TrackType.Event){
            properties()
        }
    }

    test("VIP Facilities section for projects RE"){
        def properties = {

            vertical = "realEstate"
            from_view = "technicalSpecs"
            seller_id =  430012134
            item_seller_type = "real_estate_agency"
            listing_type_id = "silver"
            category_id = "MLA401803"
            item_status = "active"
            item_id = "MLA792156560"
            item_condition = "new"
            category_path = [
                "MLA1459",
                "MLA1493",
                "MLA1495",
                "MLA401803"
            ]
            buying_mode = "classified"
        }

        "/vip/technical_specs"(platform: "/mobile", type: TrackType.View){
            properties()
            vip_version = "new"
        }

        "/vip/contact_seller"(platform: "/mobile", type: TrackType.Event){
            properties()
        }
    }

    test("VIP Facilities CTA for see more attributes in technical specifications"){
        def properties = {

            vertical = "motors"
            seller_id =  430012134
            item_seller_type = "car_dealer"
            listing_type_id = "silver"
            category_id = "MLA401803"
            item_status = "active"
            item_id = "MLA792156560"
            item_condition = "new"
            category_path = [
                    "MLA1459",
                    "MLA1493",
                    "MLA1495",
                    "MLA401803"
            ]
            buying_mode = "classified"
        }

        "/vip/technical_specs/see_more"(platform: "/mobile", type: TrackType.Event){
            properties()
        }
    }

    test("VIP link from denounce"){
        def properties = {

            vertical = "motors"
            seller_id =  430012134
            item_seller_type = "car_dealer"
            listing_type_id = "silver"
            category_id = "MLA401803"
            item_status = "active"
            item_id = "MLA792156560"
            item_condition = "new"
            category_path = [
                    "MLA1459",
                    "MLA1493",
                    "MLA1495",
                    "MLA401803"
            ]
            buying_mode = "classified"
        }

        "/vip/denounce_intention"(platform: "/mobile", type: TrackType.Event){
            properties()
        }
    }

    test("VIP preload MainAction Contact from search"){
        def properties = {
            item_id = "MLA792156560"
        }

        "/vip/contact_seller/preload"(platform: "/mobile", type: TrackType.Event){
            properties()
        }
    }

    test("VIP preload MainAction Call from search"){
        def properties = {
            item_id = "MLA792156560"
        }

        "/vip/call_seller/preload"(platform: "/mobile", type: TrackType.Event){
            properties()
        }
    }

    test("VIP preload MainAction Reservation from search"){
        def properties = {
            item_id = "MLA792156560"
        }

        "/vip/reservation_intention/preload"(platform: "/mobile", type: TrackType.Event){
            properties()
        }
    }

    test("VIP prevent stock question for web desktop") {
        "/vip/question/ask/prevent_stock"(platform: "/web/desktop", type: TrackType.Event) {
            item_id = "MLA792156560"
            vip_version = "new"
        }
    }

    test("VIP prevent stock question for web mobile") {
        "/vip/question/ask/prevent_stock"(platform: "/web/mobile", type: TrackType.Event) {
            item_id = "MLA792156560"
            vip_version = "new"
        }
    }
	
    test("VIP prevent stock question for mobile") {
        "/vip/question/ask/prevent_stock"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA792156560"
            vip_version = "new"
        }
    }

    test("VIP back to listing event") {
        "/vip/back_to_listing"(platform:"/web/desktop", type: TrackType.Event) {
            item_id = "MLA792156560"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            domain_id = "MLA7192"
            vertical = "core"
            vip_version = "new"
        }
    }

    // BEGIN - Classifieds Credits

    test("VIP go to credits simulation card event") {
        def properties = {
            item_id = "MLA792156560"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            seller_id = 167086843
            buying_mode = "classified"
            item_condition = "new"
            item_seller_type = "AB001"
            listing_type_id = "gold_special"
            from_view="vip"
            item_status = "active"
            vertical = "motors"
            deal_ids = []
        }

        "/vip/credits_intention/card"(platform:"/web/mobile", type: TrackType.Event) {
            properties()
        }

        "/vip/credits_intention/main_action/up"(platform:"/web/mobile", type: TrackType.Event) {
            properties()
        }

        "/vip/credits_intention/main_action/down"(platform:"/web/mobile", type: TrackType.Event) {
            properties()
        }
    }

    test("VIP onboarding classifieds credits") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            category_id = "MLA123"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            listing_type_id = "gold_premium"
            item_condition = "new"
            item_seller_type = "car_dealer"
            catalog_listing = false
            item_status = "active"
            buying_mode = "classified"
            deal_ids = []
            seller_id = 123456789
        }

        "/vip/classi_credits_onboard"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }

        "/vip/classi_credits_onboard/ok"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/vip/classi_credits_onboard/close"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/vip/classi_credits_onboard"(platform: "/mobile", type: TrackType.Event) {
            vip_version = "new"
        }

        "/vip/classi_credits_onboard/ok"(platform: "/mobile", type: TrackType.Event) {
            vip_version = "new"
        }

        "/vip/classi_credits_onboard/close"(platform: "/mobile", type: TrackType.Event) {
            vip_version = "new"
        }
    }

   //END - Classifieds Credits

    test("VIP denounce") {
        "/vip/denounce"(platform: "/", type: TrackType.Event) {}
    }

    test("VIP cbt") {
        "/vip/show_cbt_popup"(platform: "/", type: TrackType.Event) {
            item_id = "MLA792156560"
            category_id = "MLA43718"
            category_path = ["MLA1234", "MLA6789"]
            seller_id = 167086843
            item_condition = "new"
            price = 100
            original_price = 110
            currency_id = "ARS"
            vip_version = "new"
        }
    }

    test("Free Listing Advertising event") {
        "/vip/free_list_adv"(platform:"/web/desktop", type: TrackType.Event) {
            item_id = "MLA792156560"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            listing_type_id = "gold_premium"
            item_seller_type = "car_dealer"
            item_condition = "new"
        }
        "/vip/free_list_adv"(platform:"/web/mobile", type: TrackType.Event) {
            item_id = "MLA792156560"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            listing_type_id = "gold_premium"
            item_seller_type = "car_dealer"
            item_condition = "new"
        }
        "/vip/free_list_adv"(platform:"/mobile", type: TrackType.Event) {
            item_id = "MLA792156560"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            listing_type_id = "gold_premium"
            item_seller_type = "car_dealer"
            item_condition = "new"
        }
    }

    test("VIP Copy Seller info") {
        "/vip/copy_seller_info"(platform: "/web/", type: TrackType.Event) {
            item_id = "MLA792156560"
            seller_id = 167086843
            price = 100
            buyer_id = "12343718"
            loyalty_level = 2
            shipping_cost = 30
            shipping_method="standard"
            shipping_mode = "me2"
            free_shipping = true
            free_shipping_benefit = false
            free_shipping_benefit_lyl = false
            discount_shipping_benefit_lyl = false
            shipping_preference = "Normal a Domicilio"
            shipping_promise = {
                afterDispatch = true
                min_days = 2
                max_days = 12
                price = {
                    amount = 10000
                    currency_id = "ARS"
                    is_loyalty_discount = false
                }
                destination = "1429"
            }
        }
    }


    // Price Comparator - RealEstate

    test("VIP Price Comparator section for used properties RE"){
        def properties = {
            vertical = "realEstate"
            seller_id =  430012134
            listing_type_id = "silver"
            category_id = "MLA401803"
            item_status = "active"
            item_id = "MLA792156560"
            item_condition = "new"
            category_path = [
                    "MLA1459",
                    "MLA1493",
                    "MLA1495",
                    "MLA401803"
            ]
            buying_mode = "classified"
            deal_ids = []
            price_comparison_available = true
        }

        "/vip/comparator_price/similar_properties"(platform: "/web/desktop", type: TrackType.Event) {
            properties()
        }
        "/vip/comparator_price/info_tooltip"(platform: "/web/desktop", type: TrackType.Event) {
            properties()
        }
        "/vip/comparator_price/similar_properties"(platform: "/web/mobile", type: TrackType.Event) {
            properties()
        }
        "/vip/comparator_price/info_tooltip"(platform: "/web/mobile", type: TrackType.Event) {
            properties()
        }

        "/vip/comparator_price/interactive_bin"(platform: "/web/desktop", type: TrackType.Event) {
            properties()
        }

        "/vip/comparator_price/interactive_bin"(platform: "/web/mobile", type: TrackType.Event) {
            properties()
        }

    }

    test("VIP item free return"){
        def properties = {
            item_id = "MLA792156560"
        }

        "/vip/item/free_return"(platform: "/", type: TrackType.View) {
            properties()
        }
    }

    // Server side

    test("VIP Server side tracking"){
        def optional = {
            item_id = "MLA792156560"
        }

        "/vip/backend"(platform: "/web/desktop", type: TrackType.Event) {
            optional()
        }

        "/vip/backend"(platform: "/web/mobile", type: TrackType.Event) {
            optional()
        }

    }

    // Pricing 2.0 - Payments Modal Track
    test("VIP Pricing 2.0 - Payments Modal track") {
        "/vip/pricing_rebates/modal_payments_action"(platform: "/", type: TrackType.Event) {
            item_id = "MLB1640051252"
            is_cash_price = true
            original_price = 100
            price = 85
            currency_id = "BRL"
            installments_value_total = 104.4
            installments_value_each = 8.7
            installments_amount = 12
            is_free_installments = false
        }
    }

    // Pricing 2.0 - View track
    test("Vip tracking in web for pricing 2.0") {
        def dataSet = {
            item_id = "MLB533657947"
            category_id = "MLA43718"
            category_path = ["MLB1234","MLB6789"]
            buying_mode = "buy_it_now"
            official_store_id = 1
            deal_ids = ["MLB24"]
            review_rate=5
            specifications_size = 1
            vertical = "core"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
            catalog_listing = false
            tracking_id="dd1ec405-0a55-4b55-aaa5-de29cc3ab5fb"
            available_promotions = [
                {
                    campaign_id = "1761"
                    type = "DISCOUNT"
                    original_value = 953
                    value = 643.5
                }
            ]
            discount_reasons = ["deal"]
        }

        "/vip"(platform:"/web", dataSet)
    }

    test("Vip Advertising banners") {
        "/vip/advertising"(platform: "/", type: TrackType.Event) {
            advertising_id = "fullscreen-core"
        }
    }
}
