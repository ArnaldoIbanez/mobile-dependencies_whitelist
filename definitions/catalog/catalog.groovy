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

   tracks {
      "/search"(platform: "/") { }

      "/search"(platform: "/mobile") { }

      "/search"(platform: "/mobile/android") {
        query()
        limit()
        offset()
        total(description:"amount of search items returned", required:false)
        category_id(regex:/[a-zA-Z]{1,3}[0-9]+/, required:false)
        category_path(description:"path from root category", required:false)
        sort_id(required:false)
        filter_user_applied(required:false)
      }

      "/search/cancel"(platform: "/mobile/android"){}
      "/search/abort"(platform: "/mobile/android"){}

    "/search/refine" (platform: "/mobile/android"){ }
    "/search/refine/apply" (platform: "/mobile/android"){ } //event
    "/search/refine/cancel" (platform: "/mobile/android"){ } //event
    "/search/refine/select_filter" (platform: "/mobile/android"){
      filter_name()
    } 
    "/search/refine/select_filter/apply"(platform: "/mobile/android"){
      filter_value()
    }

    "/search/change_view" (platform: "/mobile/android"){ } 
    "/search/change_view/apply" (platform: "/mobile/android"){ //event
      list_mode()
    } 
    "/search/bookmark" (platform: "/mobile/android"){ //event
        item_id()
    }

    "/vip"(platform:"/") {
          item_id()
          buying_mode()
          vertical()
          category_id(regex:"[A-Z]{3}\\d+")
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
    
    //Vip events
    "/vip/bookmark/add"(platform:"/mobile", type: TrackType.Event) {
      item_id();
    }
    "/vip/bookmark/remove"(platform:"/mobile", type: TrackType.Event) {
      item_id();
    }
  }
}
