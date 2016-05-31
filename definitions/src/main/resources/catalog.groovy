import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
import com.ml.melidata.TrackType

/**
 * Main catalog definitions
 */
catalog {
	/**
	 * All available business units
	 */

	business = [
			"mercadolibre"
	]

	/*
	   * Business to be used as default
	   */
	defaultBusiness = "mercadolibre"

	/**
	 * All available platfrom
	 */
	platforms = [
			"/",
			"/web",
			"/web/desktop",
			"/web/desktop/forced",
			"/web/mobile",
			"/web/mobile/forced",
			"/web/mobile/static",
			"/mobile",
			"/mobile/android",
			"/mobile/ios",
			"/email"
	]

/**
 *
 * The events means actions that happens without launch a View,
 * as example of that we can consider Bookmark an item in a VIP page
 * Every event is an action, so the verbs available are:
 *
 * - back:  the event of back from a page, specially in mobile
 * - abort: the user abort the action (e.g: back pressed before api response)
 * - delete: when something is deleted
 * - apply: when a criteria is applied
 * - post: create a new entity
 */

	tracks {
        def categoryRegex = /(ROOT|[a-zA-Z]{1,3}[0-9]+)/
        def categoryPathRegex = /\[([a-zA-Z]{1,3}[0-9]+(, )?)*\]/

        "/"(platform: "/mobile", isAbstract: true) {
            mode(required: false)
            deferred_time(required: false)
            sent_again(required: false)
            from_background(required: false)
        }

        "/"(platform: "/web", isAbstract: true) {
            headers(required: false)
            cookies(required: false)
            http_url(required: false)
            http_referer(required: false)
        }

        "/melidata"(platform: "/mobile", isAbstract: true) {}

        "/melidata/statistics"(platform: "/mobile", type: TrackType.Event) {
            errors_counter(type: PropertyType.Map)
            last_send_timestamp()
            total_pending_tracks()
            send_counter()
            database_size()
            tracks_counter()
            average_ok_time()
            average_error_time()
            last_statistics_timestamp(required: false)
        }

        "/melidata/null_track"(platform: "/mobile") {
            context()
        }

        "/melidata/delete_old_tracks"(platform: "/mobile") {
            count()
        }

        //EXTERNAL
        //TODO revisar /external/XXX

        "/external/"(platform: "/mobile") {
            query(required: false)
            limit(type: PropertyType.Numeric, required: false)
            offset(type: PropertyType.Numeric, required: false)
            total(description: "amount of search items returned", type: PropertyType.Numeric, required: false)
            category_id(regex: categoryRegex, required: false)
            category_path(description: "path from root category", regex: categoryPathRegex, type: PropertyType.ArrayList, required: false)
            sort_id(required: false)
            filters(required: false)
            filter_user_applied(deprecated: true, required: false)

            news_id(required: false)
            notification_type(required: false)
            deal_id(required: false)
            url(required: false)
        }

        "/external/search"(platform: "/mobile") {
        }

        "/external/failure"(platform: "/mobile") {
            error_message()
        }

        "/external/abort"(platform: "/mobile") {}

        "/external/back"(platform: "/mobile") {}

        "/external/vip"(platform: "/mobile") {
            item_id()
        }

        //HOME FLOW

        "/home"(platform: "/mobile") {
            retry_after_error(required: false)
        }

        "/home/failure"(platform: "/mobile") {
            error_message(required: false)
        }

        "/home/back"(platform: "/mobile") {
        }

        "/home/pulltorefresh"(platform: "/mobile", type: TrackType.Event) {
        }

        "/home/pulltorefresh/abort"(platform: "/mobile", type: TrackType.Event) {
        }

        "/home/scroll"(platform: "/mobile", type: TrackType.Event) {
        }

        "/home/scroll/abort"(platform: "/mobile", type: TrackType.Event) {
        }

        "/home/abort"(platform: "/mobile") {
        }

        "/home/tap"(platform: "/mobile") {
            position(type: PropertyType.Numeric)
            section()
            tag_id()
        }

        //REVIEWS FRONTEND
        "/reviews/form"(platform: "/") {
            item_id()
        }

        "/reviews/edit"(platform: "/") {
            item_id()
        }

        "/reviews/congrats/delete"(platform: "/") {
            item_id()
        }

        "/reviews/congrats/edit"(platform: "/") {
            item_id()
            review_length()
        }

        "/reviews/congrats"(platform: "/") {
            item_id()
            review_length(inheritable: false)
        }

        "/reviews/error"(platform: "/") {
            item_id()
        }

        "/reviews/email"(platform: "/email") {
            item_id()
        }

        "/reviews"(platform: "/") {
            item_id()
        }

        //SEARCH FLOW

        "/search"(platform: "/") {
            query(required: false)
            limit(type: PropertyType.Numeric)
            offset(type: PropertyType.Numeric)
            total(description: "amount of search items returned", type: PropertyType.Numeric, required: false)
            category_id(regex: categoryRegex, required: false)
            category_path(description: "path from root category", regex: categoryPathRegex, type: PropertyType.ArrayList, required: false)
            sort_id(required: false)
            filters(required: false)
            view_mode(required: false, description: "MOSAIC, LIST or GALLERY")
            filter_user_applied(deprecated: true, required: false)
            tienda_oficial(deprecated: true, required: false)
            official_store_id(deprecated: true, required: false)
            deal(deprecated: true, required: false)
            filter_tags(required: false, PropertyType.ArrayList)
        }

        "/search"(platform: "/web") {
            visual_id(required: false)
            config_version(required: false)
            filters(required: false)
            only_in_type(required: false)
        }

        "/search"(platform: "/mobile") {
            filter_user_applied(deprecated: true, required: false)
            context(required: false)
        }

        "/search/failure"(platform: "/mobile", type: TrackType.Event) {
            error_message()
            limit(required: false, description: "override required property")
            offset(required: false, description: "override required property")
        }

        "/search/long_press" (platform: "/mobile", type: TrackType.Event){
			item_id()
		}

        "/search/share" (platform: "/mobile", type: TrackType.Event){
			item_id()
		}

        "/search/back" (platform: "/mobile", type: TrackType.Event) {}

        "/search/abort"(platform: "/mobile", type: TrackType.Event) {
            limit(required: false, description: "override required property")
            offset(required: false, description: "override required property")
        }

        "/search/filters"(platform: "/mobile") {}

        "/search/refine"(platform: "/mobile") {}

        "/search/refine/apply"(platform: "/mobile", type: TrackType.Event) {}

        "/search/refine/back"(platform: "/mobile", type: TrackType.Event) {}

        "/search/refine/select_filter"(platform: "/mobile") {
            filter_id()
        }

        "/search/refine/select_filter/apply"(platform: "/mobile") {
            filter_value_id()
            filter_value_name()
        }

        "/search/change_view"(platform: "/mobile") {}

        "/search/change_view/apply"(platform: "/mobile", type: TrackType.Event) {
            list_mode()
        }

        "/search/input"(platform: "/mobile", parentPropertiesInherited: false) {
            //TODO. remove this when inhereted from / is solved
            mode(required: false)
            sent_again(required: false)
            from_background(required: false)
        }

        "/search/input/back"(platform: "/mobile") {}

        //VIP FLOW

        "/vip"(platform: "/") {
            item_id()
            category_id()
            buying_mode(deprecated: true, required: false)
            vertical(deprecated: true, required: false)
            category_id(deprecated: true, required: false)
            quantity(deprecated: true, required: false)
            item_condition(deprecated: true, required: false)
            currency_id(deprecated: true, required: false)
            price(deprecated: true, required: false)
            item_status(deprecated: true, required: false)
            official_store_id(deprecated: true, required: false)
            seller_id(deprecated: true, required: false)
            power_seller_status(deprecated: true, required: false)
            listing_type_id(deprecated: true, required: false)
            start_time(deprecated: true, required: false)
            stop_time(deprecated: true, required: false)
            shipping_mode(deprecated: true, required: false)
            free_shipping(deprecated: true, required: false)
            local_pick_up(deprecated: true, required: false)
            category_path(deprecated: true, required: false)
        }

        "/vip"(platform: "/web") {
            review_rate(inheritable: false)
        }

        "/vip"(platform: "/mobile") {
            context(required: false)
        }

        "/vip/abort"(platform: "/mobile", type: TrackType.Event) {}

        "/vip/failure"(platform: "/mobile", type: TrackType.Event) {
            error_message()
        }

        "/vip/back"(platform: "/mobile", type: TrackType.Event) {}

        "/vip/seller_reputation"(platform: "/mobile") {}

        "/vip/seller_reputation/ratings"(platform: "/mobile") {}

        "/vip/color_and_size"(platform: "/mobile") {}

        "/vip/description"(platform: "/mobile") {
            empty_description(type: PropertyType.Boolean, required: false, inheritable: false)
        }

        "/vip/description/failure"(platform: "/mobile") {}

        "/vip/description/abort"(platform: "/mobile") {}

        "/vip/description/back"(platform: "/mobile") {}

        "/vip/item_gallery"(platform: "/mobile", parentPropertiesInherited: false) {
            //TODO. remove this when inhereted from / is solved
            mode(required: false)
            sent_again(required: false)
            from_background(required: false)
            context(required: false)
        }

        "/vip/item_gallery/back"(platform: "/mobile") {}

        "/vip/contact_seller"(platform: "/mobile") {}

        "/vip/map/"(platform: "/mobile") {}

        "/vip/buy_intention"(platform: "/mobile") {}

        "/vip/payment_method"(platform: "/mobile") {}

        "/vip/payment_method/back"(platform: "/mobile") {}

        "/vip/variations"(platform: "/mobile") {}

        "/vip/variations/back"(platform: "/mobile") {}

        //BOOKMARKS

        "/bookmarks/action"(platform: "/mobile", isAbstract: true) {}

        "/bookmarks"(platform: "/mobile", type: TrackType.Event, isAbstract: true) {
            context(required: false)
        }

        //deprecated: true
        "/bookmarks/post"(platform: "/mobile", type: TrackType.Event) {
            item_id()
        }

        //deprecated: true
        "/bookmarks/delete"(platform: "/mobile", type: TrackType.Event) {
            item_id()
        }

        "/bookmarks/action/post"(platform: "/mobile", type: TrackType.Event) {
            item_id()
        }

        "/bookmarks/action/delete"(platform: "/mobile", type: TrackType.Event) {
            item_id()
        }

        // Questions
        "/questions"(platform: "/mobile", isAbstract: true) {
            item_id(required: false)
            context()
        }

        "/questions/list"(platform: "/mobile") {}

        "/questions/ask"(platform: "/mobile") {}

        "/questions/ask/post"(platform: "/mobile", type: TrackType.Event) {
            //TODO revisar si no conviene pasar failed() a otro path "/questions/ask/post/failed"
            failed()
            question_id(required: false, description: "it has no value if failed is true")
        }

        "/questions/ask/back"(platform: "/mobile", type: TrackType.Event) {
        }

        "/questions/answer"(platform: "/mobile") {}

        "/questions/answer/post"(platform: "/mobile", type: TrackType.Event) {
            failed()
            question_id(required: false, description: "it has no value if failed is true")
        }

        "/questions/answer/back"(platform: "/mobile", type: TrackType.Event) {
        }

        "/questions/back"(platform: "/mobile") {}

        //CHECKOUT FLOW

        "/checkout"(platform: "/web", isAbstract: true) {
        }

        "/checkout/ordercreated"(platform: "/web", type: TrackType.Event) {
            order_id()
            status()
            total_amount()
            order_items()
            //item
            //id
            //variation_id
            //buying_mode
            //category_id
            //deal_ids
            //quantity
            //unit_price
            //currency_id
            platform()

            buyer()
            	//id
            	//nickname
            seller()
            	//id
            	//nickname
			errors()

			congrats_seq(serverSide: true)
			first_for_order(serverSide: true)
			total_amount_local(serverSide: true)
			total_amount_usd(serverSide: true)
		}

        "/checkout/login"(platform:"/web", isAbstract: true) {
            vip_parameters(required: true, description: "Parameters that came from the VIP")
               //cht
               //pm
               //inst
               //bp
               //zip_code
               //shipping_method_id
               //ship_method_id
               //ship_option_id
               //cc_issuer
               //is_logged
               //prefs_on
        }    
        "/checkout/login/confirm_authenticated"(platform: "/web") {}
        "/checkout/login/first_purchase_not_authenticated"(platform: "/web") {}
        "/checkout/login/confirm_not_authenticated"(platform: "/web") {}

		"/checkout/payments"(platform:"/web", isAbstract: true) {
			order_id(required: true, description: "OrderId")
			status(required: true, description: "status")
			total_amount(required: true, description: "totalAmount")
			total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
			total_paid_amount(required: true, description: "total pais Amount is total_amount_with_shipping plus installments fee")

			buy_equal_pay(required: true, description: "BP flag")
			recovery_flow(required: true, description: "Is recovery CHO flow")
			register_int(required: false, description: "Integrated registration") 			
			platform()

            payments(required: false, description: "Array of payments information")
                // id
                // payment_method,
                // payment_type,
                // installments,
                // paid_amount,
                // installment_amount
                // without_fee

            shipping(required: false)
                // shipping_type
                // cost
                // shipping_option,
                	// id,
                	// name,
                	// shipping_method_id

            order_items( description: "Array of items in the order" )
                //item
                    //id
                    //variation_id
                    //buying_mode
                    //shipping_mode
                    //category_id
                    //deal_ids
                //quantity
                //unit_price
                //currency_id    	

			tracking_referer_page(required: false, description: "tracking referer page from where the request came")               
		}
        "/checkout/payments/select_payment_method"(platform: "/web") {}
        "/checkout/payments/select_payment_type"(platform: "/web") {}
        "/checkout/payments/select_split_payment"(platform: "/web") {}
        "/checkout/payments/input_proactive_payment_amount"(platform: "/web") {}

        "/checkout/payments/installments"(platform:"/web", parentPropertiesInherited: false) {
            payPrefId(required: true, description: "payment preference Id")
            totalPrice(required: true, description: "Total price")
            preferredInstallment(required: true, description: "preferred Installment")
            maxInstallmentsWithoutFee(required: true, description: "max Installments Without Fee")
            selectedInstallment(required: true, description: "selected Installment")
        }

        "/checkout/review"(platform:"/web") {
            order_id(required: true, description: "OrderId")
            status(required: true, description: "status")
            total_amount(required: true, description: "totalAmount")
            total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
            total_paid_amount(required: true, description: "total pais Amount is total_amount_with_shipping plus installments fee")

            buy_equal_pay(required: true, description: "BP flag")
            recovery_flow(required: true, description: "Is recovery CHO flow")
            register_int(required: false, description: "Integrated registration")           
            platform()

            payments(required: false, description: "Array of payments information")
                // id
                // payment_method,
                // payment_type,
                // installments,
                // paid_amount,
                // installment_amount
                // without_fee

            shipping(required: false)
                // shipping_type
                // cost
                // shipping_option,
                    // id,
                    // name,
                    // shipping_method_id

            order_items( description: "Array of items in the order" )
                //item
                    //id
                    //variation_id
                    //buying_mode
                    //shipping_mode
                    //category_id
                    //deal_ids
                //quantity
                //unit_price
                //currency_id       
        }

        "/checkout/congrats"(platform:"/web") {
            order_id(required: true, description: "OrderId")
            status(required: true, description: "status")
            total_amount(required: true, description: "totalAmount")
            total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
            total_paid_amount(required: true, description: "total pais Amount is total_amount_with_shipping plus installments fee")

            buy_equal_pay(required: true, description: "BP flag")
            recovery_flow(required: true, description: "Is recovery CHO flow")
            register_int(required: false, description: "Integrated registration")           
            platform()

            payments(required: false, description: "Array of payments information")
                // id
                // payment_method,
                // payment_type,
                // installments,
                // paid_amount,
                // installment_amount
                // without_fee
                // status
                // status_detail    

            shipping(required: false)
                // shipping_type
                // cost
                // shipping_option,
                    // id,
                    // name,
                    // shipping_method_id
                // id
                // shipping_mode

            order_items( description: "Array of items in the order" )
                //item
                    //id
                    //variation_id
                    //buying_mode
                    //shipping_mode
                    //category_id
                    //deal_ids
                //quantity
                //unit_price
                //currency_id    

            buyer(required: true)
                //id
                //nickname

            seller(required: true)
                //id
                //nickname

            proactive_two_payment(required: false, description: "tracking proactive two payment selection")                                 
            total_amount_local(serverSide: true)
            total_amount_usd(serverSide: true)        
        }

		"/checkout"(platform:"/mobile") {
			order_id(required: false)
            status(required:false)
            total_amount(required: false, type: PropertyType.Numeric)
            order_items(required: false, description: "Array of items in the order. New: optional for old versions of mobile")
            //item
            //id
            //variation_id
            //buying_mode
            //category_id
            //deal_ids
            //quantity
            //unit_price
            //currency_id

            shipping(required: false)
            //shipping_type
            //shipping_option

            payments(required: false, description: "Array of payment information") //
            // id
            // payment_method,
            // payment_type,
            // installments,
            // selected_card
            // financed_order_cost_for_card
            // payment_must_call_for_authorize

            status_detail(required: false)
            reloaded(required: false)
            quantity_pre_selected(required: false)
            order_payment_required(required: false)
            shipping_pre_selected(required: false)

            item_id(deprecated: true, required: false)
            quantity(deprecated: true, required: false)
            order_cost(deprecated: true, required: false)
        }

        "/checkout/abort"(platform: "/mobile", type: TrackType.Event) {}

        "/checkout/back"(platform: "/mobile", type: TrackType.Event) {}

        "/checkout/congrats"(platform: "/mobile") {
            buyer(required: false)
            seller(required: false)

            duplicated_error(required: false)
            congrats_seq(serverSide: true)
            total_amount_local(serverSide: true)
            total_amount_usd(serverSide: true)
            first_for_order(serverSide: true)
            order_api(serverSide: true)
        }

        "/checkout/congrats/back"(platform: "/mobile", type: TrackType.Event) {}

        "/checkout/failure"(platform: "/mobile", type: TrackType.Event) {
            error()
            message()
        }

        "/checkout/quantity_changed"(platform: "/mobile", type: TrackType.Event) {
            quantity()
        }

        //--> SHIPPING flow

        "/checkout/shipping_selection"(platform: "/mobile") {  //TODO flow
            available_types()
            current_type(required: false)
            current_option(required: false)
            available_other_methods(required: false)
        }

        "/checkout/shipping_selection/apply"(platform: "/mobile", type: TrackType.Event) {
            type()
            option(required: false)
        }

        "/checkout/shipping_selection/back"(platform: "/mobile", type: TrackType.Event) {}

        "/checkout/shipping_selection/address_selection"(platform: "/mobile", type: TrackType.View) {
            invalid_address()
            valid_address()
            available_other_methods(required: false)
        }

        "/checkout/shipping_selection/address_selection/back"(platform: "/mobile", type: TrackType.Event) {
            invalid_address()
            valid_address()
        }

        "/checkout/shipping_cost"(platform: "/mobile") {}

        "/checkout/shipping_cost/back"(platform: "/mobile") {}

        "/checkout/shipping_cost/apply"(platform: "/mobile", type: TrackType.Event) {
            //TODO
        }

        "/checkout/payment_selection"(platform: "/mobile") {
            available_types(type: PropertyType.ArrayList)
            available_other_methods(type: PropertyType.Boolean)
            current_type(required: false)
            current_method(required: false)
            method(required: false)
        }

        "/checkout/payment_selection/apply"(platform: "/mobile", type: TrackType.Event) {
            type()
        }

        "/checkout/payment_selection/back"(platform: "/mobile", type: TrackType.Event) {}

        "/checkout/payment_selection/othertype"(platform: "/mobile") {
            available_methods()
        }

        "/checkout/payment_selection/othertype/back"(platform: "/mobile") {}

        "/checkout/order_total"(platform: "/mobile") {}

        "/checkout/order_total/back"(platform: "/mobile", type: TrackType.Event) {}

        "/checkout/contact_seller_call"(platform: "/mobile", type: TrackType.Event) {}

        "/checkout/contact_seller_email"(platform: "/mobile", type: TrackType.Event) {}

        "/checkout/contact_add"(platform: "/mobile", type: TrackType.Event) {}

        "/checkout/screenshot"(platform: "/mobile", type: TrackType.Event) {}

        // ADDRESS

        "/address"(platform: "/mobile", isAbstract: true) {}

        "/address/add_address"(platform: "/mobile", type: TrackType.View) {
            context()
        }

        "/address/add_address/back"(platform: "/mobile", type: TrackType.Event) {}

        "/address/add_address/apply"(platform: "/mobile", type: TrackType.Event) {}

        // CREDIT CARDS

        "/credit_cards"(platform: "/mobile", type: TrackType.View) {
            available_cards()
            context()
        }

        "/credit_cards/abort"(platform: "/mobile", type: TrackType.Event) {
            available_cards(required: false)
        }

        "/credit_cards/back"(platform: "/mobile", type: TrackType.Event) {
            available_cards(required: false)
        }

        "/credit_cards/new_card"(platform: "/mobile", type: TrackType.View) {
            available_cards(required: false)
            payment_method_id()
        }

        "/credit_cards/new_card/apply"(platform: "/mobile", type: TrackType.Event) {
            available_cards(required: false)
            card_number()
        }

        "/credit_cards/new_card/back"(platform: "/mobile", type: TrackType.Event) {}

        "/credit_cards/new_card/installments"(platform: "/mobile", type: TrackType.View) {
            available_cards(required: false)
            available_installments()
            payment_method_id(required: false)
        }

        "/credit_cards/new_card/installments/apply"(platform: "/mobile", type: TrackType.Event) {
            available_cards(required: false)
            installment()
        }

        // SHIPPING FLOW

        "/shipping"(platform: '/mobile', isAbstract: true) {}

        "/shipping/mercadoenvios"(platform: '/mobile', isAbstract: true) {}

        "/shipping/shipping_cost"(platform: "/mobile") {
            context()
            item_id()
        }

        "/shipping/shipping_cost/back"(platform: "/mobile", type: TrackType.Event) {}

        "/shipping/mercadoenvios/shipping_cost"(platform: "/mobile") {
            item_id()
            context()
            zip_code(required: false)
        }

        "/shipping/mercadoenvios/shipping_cost/get"(platform: "/mobile", type: TrackType.Event) {
            destination()
        }

        "/shipping/mercadoenvios/shipping_cost/apply"(platform: "/mobile", type: TrackType.Event) {
            shipping_id()
            destination()
        }

        "/shipping/mercadoenvios/shipping_cost/fail"(platform: "/mobile", type: TrackType.Event) {
        }

        // PAYMENTS FLOW

        "/payments"(platform: "/mobile", type: TrackType.View) {
            context()
            item_id()
        }

        "/payments/back"(platform: "/mobile", type: TrackType.Event) {}

        // SELLER

        "/seller_reputation"(platform: "/mobile") {
            context()
            item_id(required: false)
        }

        "/seller_reputation/back"(platform: "/mobile") {}

        "/seller_reputation/ratings"(platform: "/mobile") {}

        "/seller_reputation/ratings/back"(platform: "/mobile") {}

        // REGISTER

        "/register"(platform: "/mobile", isAbstract: true) {}

        "/register/success"(platform: "/mobile") {
            source()
        }

        "/register/failure"(platform: "/mobile") {
            source()
        }

        "/traffic"(platform: "/", isAbstract: true) {}

        "/traffic/inbound"(platform: "/", isAbstract: true) {}

        "/traffic/inbound/matt"(platform: "/") {
            tool(type: PropertyType.Numeric, description: "Referrer's ID, this could identify Google, Facebook or any other channel")
            word(type: PropertyType.String, description: "This is the name of the marketing campaign.")
        }

        "/notification_center"(platform: "/mobile", type: TrackType.Event) {}

        "/notification_center/abort"(platform: "/mobile", type: TrackType.Event) {}

        "/notification_center/back"(platform: "/mobile", type: TrackType.Event) {}

        "/notification_center/failure"(platform: "/mobile", type: TrackType.Event) {}

        /**
         * NOTIFICATIONS
         * disclaimer: when the action_type is set, the event_type should be always 'open'
         **/
        "/notification"(platform: "/mobile") {
            news_id(required: false, description: "Identifier of the notification generated")
            event_type(required: true, values: ["sent", "arrived", "received", "dismiss", "discarded", "open", "auto_dismiss", "shown"], description: "Type of notification event")
            action_type(required: false, values: ["deeplinking", "directions", "favorite", "reply", "ask", "postpone"])
            deeplink(required: false, description: "The link were the notification should navigate to, if applies")
            status(required: false, values: ["read", "unread"], description: "The current notification status, used only when tracking from notification center.")
            notification_style(required: false, description: "The notification style used when displaying the notification to the user.")
            context(required: false, values: ["notification", "notification_center"], description: "Current context of the notification")
        }
        //Tu producto está en camino
        "/notification/shipping_shipped"(platform: "/mobile") {
            order_id(required: true, type: PropertyType.String, description: "The order of the bought item which has been shipped")
            shipment_id(required: true, type: PropertyType.Numeric)
        }
        //Retiro en sucursal
        "/notification/shipping_agency_withdrawal"(platform: "/mobile") {
            order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
            shipment_id(required: true, type: PropertyType.Numeric)
        }
        //Devolución de costo de envío por demora
        "/notification/shipping_delayed_bonus"(platform: "/mobile") {
            order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
            shipment_id(required: true, type: PropertyType.Numeric)
        }
        //Tienes que despachar (para el vendedor)
        "/notification/pending"(platform: "/mobile") {
            order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
            shipment_id(required: true, type: PropertyType.Numeric)
        }
        //Devolución por no entrega, a su dirección de despacho (para el vendedor)
        "/notification/returning_to_sender"(platform: "/mobile") {
            order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
            shipment_id(required: true, type: PropertyType.Numeric)
        }      
        //Te demoraste en el handling time (para el vendedor)
        "/notification/delayed_sender"(platform: "/mobile") {
            order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
            shipment_id(required: true, type: PropertyType.Numeric)
        }   
         
        //Seller questions
        "/notification/questions_new"(platform: "/mobile") {
            question_id(required: true)
        }
        //Buyer questions
        "/notification/questions_answered"(platform: "/mobile") {
            question_id(required: true, type: PropertyType.Numeric)
        }
        //New Sale
        "/notification/orders_new"(platform: "/mobile") {
            order_id(required: true, type: PropertyType.String)
        }
        //MKT Deals DEPRECADO
        "/notification/deals_campaigns"(platform: "/mobile") {
            deal_id(required: true, description: "Id of the deal related to the mkt notification sent.")
        }

        //MKT Deals
        "/notification/campaigns_deals"(platform: "/mobile") {
            campaign_id(required: true, description: "Id of the campaign related to the mkt notification sent.")
        }

        //Freemium SYI
        "/notification/campaigns_syi_freemium"(platform: "/mobile") {
            campaign_id(required: true, description: "Id of the campaign related to the SYI Freemium notification sent.")
        }
        //Tu cobro fué acreditado
        "/notification/collections_approved"(platform: "/mobile") {
            order_id(required: true, type: PropertyType.String)
        }

        //Dropout de CHO
        "/notification/purchase_pending"(platform: "/mobile") {
            item_id(required: true, type: PropertyType.String)
        }
        //Loyalty
        "/notification/reputation_buyer_in"(platform: "/mobile") {}

        //Mediations
        "/notification/mediations_complainant"(platform: "/mobile") {
            order_id(required: true, type: PropertyType.String, description: "The order related to the claim")
            claim_id(required: true, type: PropertyType.String)
        }

        //Moderation
        "/notification/moderation_item_to_patch"(platform: "/mobile") {
            item_id(required: true, type: PropertyType.String)
        }

        "/notification/moderation_item_forbidden"(platform: "/mobile") {
            item_id(required: true, type: PropertyType.String)
        }


        "/notification/moderation_item_warning"(platform: "/mobile") {
            item_id(required: true, type: PropertyType.String)
        }


        "/notification/moderation_message_banned"(platform: "/mobile") {
        }

        //Payments
        "/notification/payments_pending_remainder"(platform: "/mobile") {
            item_id(required: true, type: PropertyType.String)
            order_id(required: true, type: PropertyType.Numeric)
        }

        "/notification/payments_approved"(platform: "/mobile") {
            item_id(required: true, type: PropertyType.String)
            order_id(required: true, type: PropertyType.Numeric)
        }

        "/notification/payments_rejected"(platform: "/mobile") {
            item_id(required: true, type: PropertyType.String)
            order_id(required: true, type: PropertyType.Numeric)
        }

        "/notification/orders_cancelled"(platform: "/mobile") {
            item_id(required: true, type: PropertyType.String)
        }

        //Messages
        "/notification/messages_new"(platform: "/mobile") {
        }

        "/orders"(platform: "/", isAbstract: true) {}

        "/orders/ordercreated"(platform: "/") {
            order_id(required: true, description: "order identifier")
            status(required: true, description: "status of this order at creation")
            status_detail(required: false, description: "status description")
            total_amount(required: true, description: "order amount, does not include shipping or interests")
            total_amount_with_shipping(required: false, description: "order amount including shipping cost")
            order_items(description: "Array of items in the order")
            //item
                //id
                //title
                //selle_custom_fields
                //variation_attributes
                //category_id
                //variation_id
            //quantity
            //unit_price
            //currency_id
            //sale_fee

            shipping(required: false)
                //id
                //cost
                //shipping_mode
                //shipping_option
                    //id
                    //name
                    //shipping_method_id

            payments(required: false, description: "Array of payments information")
                // id
                // payment_method
                // payment_type
                // paid_amount
                // installments
                // without_fee
                // status
                // status_detail

            buyer(required: true, description: "buyer information") // id, nickname
            seller(required: true, description: "seller information") // id, nickname
        }
    }
}
