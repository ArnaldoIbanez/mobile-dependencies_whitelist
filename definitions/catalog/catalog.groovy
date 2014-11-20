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
            limit(description:"amount of search items returned")
            offset(type: PropertyType.Numeric, regex:".*")
        }
        "/search"(platform: "/mobile") {
            position(values: ["horizonal","landscape"])
        }
        "/checkout"(platform: "/") {
          category(regex:/[a-zA-Z]{1,3}[0-9]+/)
        }
    }
}