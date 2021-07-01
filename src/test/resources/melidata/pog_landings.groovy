import com.ml.melidata.catalog.PropertyType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadopago"

    test("Root tracking") {
      "/"(platform: "/mobile") {}

      "/"(platform: "/web/desktop") {}
    }

    test("Landing mercadopago point") {

      "/pog/landings" (platform: "/") {
        product = "point-h"
        bu = "POINT"
        ch = "XSELL"
        currency = "R\$"
        price = 401
        discount = 0.16
        price_with_discount = 334.8
        has_coupon = true
        coupon_code = "Y96XA"
        coupon_type = "default"
        camp = "RAINBOW"
        strategy = "UPS"
      }

      // Landing Multiproduct
      "/pog/landings/compare" (platform: "/", type: TrackType.View) {
        product = "Point Mini"
        bu = "POINT"
        ch = "XSELL"
      }

      // Multiproduct
      "/pog/landings/multiproduct"(platform:"/", type: TrackType.View) {
        product = "multiproduct mla"
        bu = "POINT"
        ch = "XSELL"
      }

    /* ---------------------
    -------- Events --------
    --------------------- */

      "/pog/landings/buy"(platform:"/", type: TrackType.Event) {
        product = "bbpos"
        bu = "POINT"
        ch = "XSELL"
      }

      // Landing navigation
      "/pog/landings/navigation"(platform:"/", type: TrackType.Event) {
        product = "Point Plus"
        coupon_code = "Y96XA"
        coupon_type = "default"
        bu = "POINT"
        ch = "XSELL"
      }

      // Landing go to calculator event
      "/pog/landings/calculator"(platform:"/", type: TrackType.Event) {
        product = "Point Newland"
        bu = "POINT"
        ch = "XSELL"
      }

      // Landing go to security landing event
      "/pog/landings/security"(platform:"/", type: TrackType.Event) {
        product = "Point Newland"
        bu = "POINT"
        ch = "XSELL"
      }

      "/pog/landings/compare/buy"(platform:"/", type: TrackType.Event) {
        product = "Point Plus"
        bu = "POINT"
        ch = "XSELL"
      }

      "/pog/landings/compare/go"(platform:"/", type: TrackType.Event) {
        product = "Point Plus"
        bu = "POINT"
        ch = "XSELL"
      }

      "/pog/landings/multiproduct/buy"(platform:"/", type: TrackType.Event) {
        product = "Point Plus"
        bu = "POINT"
        ch = "XSELL"
      }

      "/pog/landings/multiproduct/compare"(platform:"/", type: TrackType.Event) {
        product = "Point Plus"
        bu = "POINT"
        ch = "XSELL"
      }

      "/pog/landings/multiproduct/go"(platform:"/", type: TrackType.Event) {
        product = "Point Plus"
        bu = "POINT"
        ch = "XSELL"
      }

    }
}