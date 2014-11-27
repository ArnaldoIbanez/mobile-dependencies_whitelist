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
    "/mobile/web"
  ]

   tracks {
        "/search"(platform: "/") {
            limit(description:"amount of search items returned")
            offset(type: PropertyType.Numeric, regex:".*")

        }
        "/search"(platform: "/mobile") {
            position(values: ["horizontal","landscape"])
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
    }
}
