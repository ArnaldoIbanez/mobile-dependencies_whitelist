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
			"/mobile/ios"
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

		"/" (platform:"/mobile"){
			mode(required:false)
			deferred_time(required:false)
			sent_again(required:false)
			from_background(required:false)
		}

		"/" (platform:"/web"){
			headers(required:false)
			cookies(required:false)
			http_url(required:false)
			http_referer(required:false)
		}

		"/melidata/statistics"(platform:"/mobile", type:TrackType.Event){
			errors_counter(type:PropertyType.Map)
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

		"/external/" (platform: "/mobile") {
			query(required: false)
			limit(type: PropertyType.Numeric, required: false)
			offset(type: PropertyType.Numeric, required: false)
			total(description:"amount of search items returned", type: PropertyType.Numeric, required:false)
			category_id(regex:categoryRegex, required:false)
			category_path(description:"path from root category", regex:categoryPathRegex, type: PropertyType.ArrayList, required:false)
			sort_id(required:false)
			filters(required:false)
			filter_user_applied(deprecated: true, required: false)

			news_id(required: false)
			notification_type(required: false)
			deal_id(required: false)
			url(required: false)
		}

		"/external/search" (platform: "/mobile") {
		}

		"/external/failure" (platform: "/mobile") {
			error_message()
		}

		"/external/abort" (platform: "/mobile") {}

		"/external/back" (platform: "/mobile") {}

		"/external/vip" (platform: "/mobile") {
			item_id()
		}

		//HOME FLOW

		"/home"(platform:"/mobile") {
			retry_after_error(required: false)
		}

		"/home/failure"(platform:"/mobile") {
			error_message(required: false)
		}

		"/home/back"(platform:"/mobile") {
		}

		"/home/abort"(platform:"/mobile") {
		}

		"/home/tap"(platform:"/mobile") {
			position(type:PropertyType.Numeric)
			section()
			tag_id()
		}

		//SEARCH FLOW

		"/search" (platform: "/") {
			query(required: false)
			limit(type: PropertyType.Numeric)
			offset(type: PropertyType.Numeric)
			total(description:"amount of search items returned", type: PropertyType.Numeric, required:false)
			category_id(regex:categoryRegex, required:false)
			category_path(description:"path from root category", regex:categoryPathRegex, type: PropertyType.ArrayList, required:false)
			sort_id(required:false)
			filters(required:false)
			filter_user_applied(deprecated: true, required:false)
			tienda_oficial(deprecated: true, required: false)
			official_store_id(deprecated: true, required: false)
			deal(deprecated: true, required: false)
		}

		"/search"(platform: "/web") {
			visual_id(required:false)
			config_version(required:false)
			filters(required:false)
		}

		"/search"(platform: "/mobile") {
			filter_user_applied(deprecated:true, required: false)
		}


		"/search/failure" (platform: "/mobile", type: TrackType.Event){
			error_message()
			limit(required: false, description: "override required property")
			offset(required: false, description: "override required property")
		}

		"/search/back" (platform: "/mobile", type: TrackType.Event){ }

		"/search/abort" (platform: "/mobile", type: TrackType.Event){
			limit(required: false, description: "override required property")
			offset(required: false, description: "override required property")
		}

		"/search/refine" (platform: "/mobile"){ }

		"/search/refine/apply" (platform: "/mobile", type: TrackType.Event){ }

		"/search/refine/back" (platform: "/mobile", type: TrackType.Event){ }

		"/search/refine/select_filter" (platform: "/mobile"){
			filter_id()
		}

		"/search/refine/select_filter/apply"(platform: "/mobile"){
			filter_value_id()
			filter_value_name()
		}

		"/search/change_view" (platform: "/mobile"){ }

		"/search/change_view/apply" (platform: "/mobile", type: TrackType.Event){
			list_mode()
		}

		"/search/input" (platform: "/mobile", parentPropertiesInherited: false) {
			//TODO. remove this when inhereted from / is solved
			mode(required:false)
			sent_again(required:false)
			from_background(required:false)
		}

		"/search/input/back" (platform: "/mobile"){ }

		//VIP FLOW

		"/vip"(platform:"/") {
			item_id()
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

		"/vip/abort"(platform:"/mobile", type: TrackType.Event) { }

		"/vip/back"(platform:"/mobile", type: TrackType.Event) { }

		"/vip/seller_reputation"(platform:"/mobile") { }

		"/vip/seller_reputation/ratings"(platform:"/mobile") { }

		"/vip/color_and_size"(platform:"/mobile") { }

		"/vip/description"(platform:"/mobile") {
			empty_description(type:PropertyType.Boolean, required: false, inheritable: false)
		}

		"/vip/description/failure"(platform:"/mobile") { }

		"/vip/description/abort"(platform:"/mobile") { }

		"/vip/description/back"(platform:"/mobile") { }

		"/vip/item_gallery"(platform:"/mobile", parentPropertiesInherited: false) {
			//TODO. remove this when inhereted from / is solved
			mode(required:false)
			sent_again(required:false)
			from_background(required:false)
		}

		"/vip/item_gallery/back"(platform:"/mobile") { }

		"/vip/contact_seller"(platform:"/mobile") { }
		
		"/vip/map/"(platform:"/mobile") { }

		//BOOKMARKS

		"/bookmarks"(platform:"/mobile", type: TrackType.Event) {
			context(required:false)
		}

		//deprecated: true
		"/bookmarks/post"(platform:"/mobile", type: TrackType.Event) {
			item_id()
		}

		//deprecated: true
		"/bookmarks/delete"(platform:"/mobile", type: TrackType.Event) {
			item_id()
		}

		"/bookmarks/action/post"(platform:"/mobile", type: TrackType.Event) {
			item_id()
		}

		"/bookmarks/action/delete"(platform:"/mobile", type: TrackType.Event) {
			item_id()
		}

		// Questions
		"/questions"(platform: "/mobile") {
			item_id()
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

		//CHECKOUT FLOW

		"/checkout/orderCreated"(platform:"/web", type: TrackType.Event) {
			order_id()
			status()
			total_amount()
			order_items()
			buyer()
			seller()
			errors()
			mobile(type: PropertyType.Boolean)

			congrats_seq(serverSide: true)
			first_for_order(serverSide: true)
			total_amount_local(serverSide: true)
			total_amount_usd(serverSide: true)
			order_api(serverSide: true)
		}

		"/checkout"(platform:"/mobile") {
			order_id(required: false)
			order_items(required: false, description: "New: optional for old versions of mobile")
			reloaded(required:false)
			quantity_pre_selected(required:false)
			order_payment_required(required:false)
			shipping_pre_selected(required:false)
			payment_pre_selected(required:false)
			selected_card(required:false)
			shipping_type(required:false)
			shipping_option(required:false)
			financed_order_cost_for_card(required: false)
			payment_must_call_for_authorize(required: false)
			payment_method(required:false)
			payment_type(required:false)
			installments(required:false)
			buyer(required:false)
			seller(required:false)
			total_amount(required: false, type: PropertyType.Numeric)
			status(required:false)
			status_detail(required:false)

			item_id(deprecated: true, required: false)
			quantity(deprecated: true, required: false)
			order_cost(deprecated: true, required: false)
		}

		"/checkout/abort"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/back"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/congrats"(platform:"/mobile") {
			duplicated_error(required: false)
			congrats_seq(serverSide: true)
			total_amount_local(serverSide: true)
			total_amount_usd(serverSide: true)
			first_for_order(serverSide: true)
			order_api(serverSide: true)
		}

		"/checkout/congrats/back"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/failure"(platform: "/mobile", type: TrackType.Event) {
			error()
			message()
		}

		"/checkout/quantity_changed"(platform:"/mobile", type: TrackType.Event) {
			quantity()
		}

		//--> SHIPPING flow

		"/checkout/shipping_selection"(platform:"/mobile") {  //TODO flow
			available_types()
			current_type(required:false)
			current_option(required:false)
			available_other_methods(required:false)
		}

		"/checkout/shipping_selection/apply"(platform:"/mobile", type: TrackType.Event) {
			type()
			option(required:false)
		}

		"/checkout/shipping_selection/back"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/shipping_selection/address_selection"(platform:"/mobile", type: TrackType.View) {
			invalid_address()
			valid_address()
			available_other_methods(required:false)
		}

		"/checkout/shipping_selection/address_selection/back" (platform:"/mobile", type: TrackType.Event) {
			invalid_address()
			valid_address()
		}

		"/checkout/shipping_cost"(platform:"/mobile") {}

		"/checkout/shipping_cost/back"(platform:"/mobile") {}

		"/checkout/shipping_cost/apply"(platform:"/mobile", type: TrackType.Event) {
			//TODO
		}

		"/checkout/payment_selection"(platform:"/mobile") {
			available_types(type: PropertyType.ArrayList)
			available_other_methods(type: PropertyType.Boolean)
			current_type(required:false)
			current_method(required:false)
			method(required:false)
		}

		"/checkout/payment_selection/apply"(platform:"/mobile", type: TrackType.Event) {
			type()
		}

		"/checkout/payment_selection/back"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/payment_selection/othertype"(platform:"/mobile") {
			available_methods()
		}

		"/checkout/payment_selection/othertype/back"(platform:"/mobile") {}

		"/checkout/order_total"(platform:"/mobile") {}

		"/checkout/order_total/back"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/contact_seller_call"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/contact_seller_email"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/contact_add"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/screenshot"(platform:"/mobile", type: TrackType.Event) {}

		// ADDRESS

		"/address/add_address"(platform:"/mobile", type: TrackType.View){
			context()
		}

		"/address/add_address/back"(platform:"/mobile", type: TrackType.Event){}

		"/address/add_address/apply"(platform:"/mobile", type: TrackType.Event){}

		// CREDIT CARDS

		"/credit_cards"(platform:"/mobile", type: TrackType.View) {
			available_cards()
			context()
		}

		"/credit_cards/abort"(platform:"/mobile", type: TrackType.Event) {
			available_cards(required:false)
		}

		"/credit_cards/back"(platform:"/mobile", type: TrackType.Event) {
			available_cards(required:false)
		}

		"/credit_cards/new_card"(platform:"/mobile", type: TrackType.View) {
			available_cards(required:false)
			payment_method_id()
		}

		"/credit_cards/new_card/apply"(platform:"/mobile", type: TrackType.Event) {
			available_cards(required:false)
			card_number()
		}

		"/credit_cards/new_card/back"(platform:"/mobile", type:TrackType.Event){}

		"/credit_cards/new_card/installments" (platform:"/mobile", type: TrackType.View) {
			available_cards(required:false)
			available_installments()
			payment_method_id(required:false)
		}

		"/credit_cards/new_card/installments/apply"(platform:"/mobile", type: TrackType.Event) {
			available_cards(required:false)
			installment()
		}

		// SHIPPING FLOW

		"/shipping/shipping_cost"(platform:"/mobile"){
			context()
			item_id()
		}

		"/shipping/shipping_cost/back"(platform:"/mobile", type:TrackType.Event){}

		"/shipping/mercadoenvios/shipping_cost"(platform:"/mobile") {
			item_id()
			context()
			zip_code(required:false)
		}

		"/shipping/mercadoenvios/shipping_cost/get"(platform:"/mobile", type: TrackType.Event) {
			destination()
		}

		"/shipping/mercadoenvios/shipping_cost/apply"(platform:"/mobile", type: TrackType.Event) {
			shipping_id()
			destination()
		}

		"/shipping/mercadoenvios/shipping_cost/fail"(platform:"/mobile", type: TrackType.Event) {
		}


		// PAYMENTS FLOW

		"/payments"(platform:"/mobile", type:TrackType.View){
			context()
			item_id()
		}

		"/payments/back"(platform:"/mobile", type:TrackType.Event){}

		// SELLER

		"/seller_reputation"(platform:"/mobile"){
			context()
			item_id(required:false)
		}

		"/seller_reputation/back"(platform:"/mobile"){}

		"/seller_reputation/ratings"(platform:"/mobile"){}

		"/seller_reputation/ratings/back"(platform:"/mobile"){}

		// REGISTER

		"/register/success"(platform:"/mobile") {
			source()
		}
		
		"/register/failure"(platform:"/mobile") {
			source()
		}

		 "/notification_center"(platform: "/mobile", type: TrackType.Event){}

		 "/notification_center/apply" (platform: "/mobile", type: TrackType.Event){ }

		 "/notification_center/abort" (platform: "/mobile", type: TrackType.Event){ }

		 "/notification_center/back" (platform: "/mobile", type: TrackType.Event){ }

		 "/notification_center/failure" (platform: "/mobile", type: TrackType.Event){ }


		 /**
		  * NOTIFICATIONS
		  * disclaimer: when the action_type is set, the event_type should be always 'open'
		  **/
		 "/notification"(platform:"/mobile") {
			  news_id(required: true, description: "Identifier of the notification generated")
			  event_type(required: true, values: ["sent", "arrived", "received", "dismiss", "discarded", "open"], description: "Type of notification event")
			  action_type(required: false, values: ["deeplinking", "directions", "favorite", "reply", "ask", "postpone"])
			  deeplink(required: false, description: "The link were the notification should navigate to, if applies")
			  status(required: false, values: ["read", "unread"], description: "The current notification status, used only when tracking from notification center.")
			  context(required: false, values: ["notification", "notification_center"], description: "Current context of the notification")
		 }
		 //Tu producto está en camino
		 "/notification/shipping_shipped"(platform:"/mobile") {
			  order_id(required: false, type : PropertyType.Numeric, description: "The order of the bought item which has been shipped")
		 }
		 //Retiro en sucursal
		 "/notification/shipping_agency_withdrawal"(platform: "/mobile"){
			  order_id(required: false, type: PropertyType.Numeric, description: "The order related to the product that is available to withdrawal")
		 }
		 //Seller questions
		 "/notification/questions_new"(platform: "/mobile") {
			  question_id(required: false)
		 }
		 //Buyer questions
		 "/notification/questions_answered"(platform: "/mobile") {
			  question_id(required: false)
		 }
		 //New Sale
		 "/notification/orders_new"(platform: "/mobile") {
			  order_id(required: false)
		 }
		 //MKT Deals
		 "/notification/campaigns_deals"(platform: "/mobile"){
			  deal_id(required: true, description: "Id of the deal related to the mkt notification sent.")
		 }
		 //Tu cobro fué acreditado
		 "/notification/collections_approved"(platform: "/mobile"){ }

		 //Dropout de CHO
		 "/notification/purchases_pending"(platform: "/mobile") {
			  item_id(required: true)
		 }
		 //Loyalty
		 "/notification/reputation_buyer_in"(platform: "/mobile") { }
	}
}
