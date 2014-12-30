import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
import com.ml.melidata.TrackType;

/**
 * Main catalog definitions
 */
catalog {
  /**
   * All available platfrom
   */
  platforms = [
    "/",
    "/desktop",
    "/mobile",
    "/mobile/android",
    "/mobile/ios",
    "/mobile/web"
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

		def categoryRegex = /[a-zA-Z]{1,3}[0-9]+/
		
		"/application_open" (platform:"/mobile") {}

		"/splash"(platform:"/mobile") {}

		"/application_open"(platform:"/mobile", type:TrackType.Event){}

		"/home"(platform:"/mobile") {}

		//SEARCH FLOW

		"/" (platform:"/mobile"){
			mode(required:false)
			time(required:false)
		}

		"/search" (platform: "/mobile") {
		  query(required: false)
		  limit()
		  offset()
		  total(description:"amount of search items returned", required:false)
		  category_id(regex:categoryRegex, required:false)
		  category_path(description:"path from root category", required:false)
		  sort_id(required:false)
		  filter_user_applied(required:false)
		}

		"/search/failure" (platform: "/mobile", type: TrackType.Event){
			error_message()
		}

		"/search/back" (platform: "/mobile", type: TrackType.Event){ }

		"/search/abort" (platform: "/mobile", type: TrackType.Event){ }

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

		//VIP FLOW

		"/vip"(platform:"/") {
			  item_id()
			  buying_mode()
			  vertical()
			  category_id(regex:categoryRegex)
			  quantity(type: PropertyType.Numeric)
			  item_condition()
			  currency_id()
			  price(type: PropertyType.Numeric)
			  item_status()
			  official_store_id(required: false)
			  seller_id()
			  power_seller_status(required:false)
			  listing_type_id()
			  start_time(required:false)
			  stop_time()
			  shipping_mode()
			  free_shipping()
			  local_pick_up()
			  category_path(type: PropertyType.ArrayList, required:false)
		}
		"/vip/seller_reputation"(platform:"/mobile") { }
		"/vip/seller_reputation/ratings"(platform:"/mobile") { }
		"/vip/color_and_size"(platform:"/mobile") { }
		"/vip/payments"(platform:"/mobile") { }
		"/vip/description"(platform:"/mobile") { }

		"/vip/back"(platform:"/mobile", type: TrackType.Event) { }

		//Bookmarks

		"/bookmarks/post"(platform:"/mobile", type: TrackType.Event) {
			item_id();
		}

		"/bookmarks/delete"(platform:"/mobile", type: TrackType.Event) {
		  item_id();
		}

		// Questions
		"/questions/list"(platform: "/mobile") {
		  item_id();
		  context();
		}

		"/questions/ask"(platform: "/mobile") {
		  item_id();
		  context();
		}

		"/questions/ask/post"(platform: "/mobile", type: TrackType.Event) {
		}

		//Checkout FLOW
		"/checkout"(platform:"/") {
			item_id()
			reloaded(required:false)
			quantity_pre_selected(required:false)
			order_payment_required(required:false)
		}

		"/checkout/abort"(platform:"/mobile", type: TrackType.Event) {}
		"/checkout/back"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/congrats"(platform:"/mobile") {
			shipping_type(required:false)
        	order_cost(required:false)
        	selected_card(required:false)
        	quantity(required:false)
        	variation_id(required:false)
        	financed_order_cost_for_card(required:false)
        	payment_method(required:false)
        	payment_type(required:false)
        	installments(required:false)
		}

		"/checkout/congrats/back"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/failure"(platform: "/mobile", type: TrackType.Event) {
			error_message()
		}

		"/checkout/quantity_changed"(platform:"/mobile", type: TrackType.Event) {
			quantity()
		}

		//--> SHIPPING flow
		"/checkout/shipping_selection"(platform:"/mobile") {  //TODO flow
		   available_types()
		   current_type(required:false)
		   current_option(required:false)
		}

		"/checkout/shipping_selection/apply"(platform:"/mobile", type: TrackType.Event) {
			type()
		}

		"/checkout/shipping_selection/back"(platform:"/mobile", type: TrackType.Event) {}
		"/checkout/shipping_selection/address_selection"(platform:"/mobile", type: TrackType.View) {
			invalid_address()
			valid_address()
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

		"/checkout/shipping_cost/back"(platform:"/mobile") {}

 		// <--- SHIPPING FLOW
 		// ---> PAYMENT FLOW
		"/checkout/payment_selection"(platform:"/mobile") {
		   available_types(type: PropertyType.ArrayList)
		   available_other_methods(type: PropertyType.Boolean)
		   current_type(required:false)
		   current_method(required:false)
		}
		"/checkout/payment_selection/apply"(platform:"/mobile", type: TrackType.Event) {
			type()
		}
		"/checkout/payment_selection/back"(platform:"/mobile", type: TrackType.Event) {}
		"/checkout/payment_selection/othertype"(platform:"/mobile") {
		   available_methods()
		}

		// <--- PAYMENT FLOW
		"/checkout/order_total"(platform:"/mobile") {}

		"/checkout/order_total/back"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/contact_seller_call"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/contact_seller_email"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/contact_add"(platform:"/mobile", type: TrackType.Event) {}


		"/checkout/screenshot"(platform:"/mobile", type: TrackType.Event) {}

		// Address
		"/address/add_address"(platform:"/mobile", type: TrackType.View){
			context()
		}
		"/address/add_address/back"(platform:"/mobile", type: TrackType.Event){}
		"/address/add_address/apply"(platform:"/mobile", type: TrackType.Event){}

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
			payment_method_id();
		}

		"/credit_cards/new_card/apply"(platform:"/mobile", type: TrackType.Event) {
			available_cards(required:false)
			card_number()
		}
		"/credit_cards/new_card/back"(platform:"/mobile", type:TrackType.Event){}
		"/credit_cards/new_card/installments" (platform:"/mobile", type: TrackType.View) {
			available_cards(required:false)
			available_installments()
		}
		"/credit_cards/new_card/installments/apply"(platform:"/mobile", type: TrackType.Event) {
			available_cards(required:false)
			installment()
		}

		// <--- PAYMENT FLOW

		"/checkout/order_total"(platform:"/mobile") {}

		"/checkout/order_total/back"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/contact_seller_call"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/contact_seller_email"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/contact_add"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/screenshot"(platform:"/mobile", type: TrackType.Event) {}

	    "/shipping/mercadoenvios/calculate_cost"(platform:"/mobile") {
	       item_id()
	       context()
	     }

	    "/shipping/mercadoenvios/calculate_cost/get"(platform:"/mobile", type: TrackType.Event) {}
	    "/shipping/mercadoenvios/calculate_cost/apply"(platform:"/mobile", type: TrackType.Event) {}
  }
}
