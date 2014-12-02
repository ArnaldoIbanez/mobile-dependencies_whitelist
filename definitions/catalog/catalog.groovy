import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog

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
    "/mobile/web",  
  ]

   tracks {
      "/search"(platform: "/") {
            
      }

      "/search"(platform: "/mobile") {
            
      }

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

    "/search/refine" (platform: "/mobile/android"){ }
    "/search/refine/apply" (platform: "/mobile/android"){ } //event
    "/search/refine/cancel" (platform: "/mobile/android"){ } //event
    "/search/refine/select_filter" (platform: "/mobile/android"){
      filter_name()
    } 
    "/search/refine/select_filter/choose"(platform: "/mobile/android"){
      filter_value()
    }

    "/search/change_view" (platform: "/mobile/android"){ } 
    "/search/change_view/choose" (platform: "/mobile/android"){ //event
      list_mode()
    } 
    "/search/bookmark" (platform: "/mobile/android"){ //event
        item_id()
    }
  }
}
