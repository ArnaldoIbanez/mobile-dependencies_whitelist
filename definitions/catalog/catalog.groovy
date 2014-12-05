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
 * - back:  the event of back from a page, speacially in mobile
 * - delete: when something is deleted
 * - apply: when a criteria is applied
 * - post: create a new entity
 */

   tracks {
    
    def categoryRegex = /[a-zA-Z]{1,3}[0-9]+/
  

	  "/splash"(platform:"/mobile") {}

	  "/home"(platform:"/mobile") {}

    "/search"(platform: "/") {
          
    }

    "/search"(platform: "/mobile") {
          
    }

    "/search"(platform: "/mobile/android") {
      query()
      limit()
      offset()
      total(description:"amount of search items returned", required:false)
      category_id(regex:categoryRegex, required:false)
      category_path(description:"path from root category", required:false)
      sort_id(required:false)
      filter_user_applied(required:false)
    }

		"/search/refine" (platform: "/mobile/android"){ }
		
    "/search/refine/apply" (platform: "/mobile/android", type: TrackType.Event){ }
		
    "/search/refine/back" (platform: "/mobile/android", type: TrackType.Event){ }
		
    "/search/refine/select_filter" (platform: "/mobile/android"){
		  filter_name()
		}
		"/search/refine/select_filter/apply"(platform: "/mobile/android"){
		  filter_value()
		}

		"/search/change_view" (platform: "/mobile/android"){ }

		"/search/change_view/apply" (platform: "/mobile/android", type: TrackType.Event){
		  list_mode()
		}
		"/search/bookmark" (platform: "/mobile/android", type: TrackType.Event){
			item_id()
		}

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
			  power_seller_status()
			  listing_type_id()
			  start_time()
			  stop_time()
			  shipping_mode()
			  free_shipping()
			  local_pick_up()
			  category_path(type: PropertyType.ArrayList)
		}
		"/vip/seller_reputation"(platform:"/mobile") { }
		"/vip/seller_reputation/ratings"(platform:"/mobile") { }
		"/vip/mercadoenvios"(platform:"/mobile") { }
		"/vip/color_and_size"(platform:"/mobile") { }
		"/vip/questions"(platform:"/mobile") { }
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

		//Checkout
		"/checkout"(platform:"/") {
			item_id()
		}

		"/checkout/back"(platform:"/mobile", type: TrackType.Event) {}

		"/checkout/congrats"(platform:"/mobile") {

		}

	   "/checkout/congrats/back"(platform:"/mobile", type: TrackType.Event) {}

	   	"/checkout/error"(platform: "/mobile", type: TrackType.Event) {
			error_message()
		}

		"/checkout/quantity_changed"(platform:"/mobile", type: TrackType.Event) {
			quantity()
		}

	   "/checkout/shipping_selection"(platform:"/mobile") {  //TODO flow
		   available_types()
		   current_type()
		   current_option()
	   }

	   "/checkout/shipping_selection/apply"(platform:"/mobile", type: TrackType.Event) {}

	   "/checkout/shipping_selection/back"(platform:"/mobile", type: TrackType.Event) {}

	   "/checkout/shipping_cost"(platform:"/mobile") {}

	   "/checkout/shipping_cost/back"(platform:"/mobile") {}

	   "/checkout/shipping_cost/apply"(platform:"/mobile", type: TrackType.Event) {
		   //TODO
	   }

	   "/checkout/shipping_cost/back"(platform:"/mobile") {}

	   "/checkout/payment_selection"(platform:"/mobile") {
		   available_types(type: PropertyType.ArrayList)
		   available_other_methods(type: PropertyType.Boolean)
		   current_type()
		   current_method()
	   }

	   "/checkout/payment_selection/othertype"(platform:"/mobile") {
		   available_methods()
	   }

	   "/checkout/payment_selection/credit_card"(platform:"/mobile") {
	   	//TODO flow
	   }

	   "/checkout/payment_selection/apply"(platform:"/mobile", type: TrackType.Event) {}

	   "/checkout/payment_selection/back"(platform:"/mobile", type: TrackType.Event) {}

	   "/checkout/order_total"(platform:"/mobile") {}

	   "/checkout/order_total/back"(platform:"/mobile", type: TrackType.Event) {}

	   "/checkout/contact_seller_call"(platform:"/mobile", type: TrackType.Event) {}

	   "/checkout/contact_seller_email"(platform:"/mobile", type: TrackType.Event) {}

	   "/checkout/contact_add"(platform:"/mobile", type: TrackType.Event) {}

	   "/checkout/screenshot"(platform:"/mobile", type: TrackType.Event) {}



   }
}
