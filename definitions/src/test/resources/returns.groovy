import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Returns tracks") {

      "/returns/typification"(platform:"/")  {
      }

      "/returns/money_refund"(platform:"/") {
      }

      "/returns/pick_up_option"(platform:"/") {
      }

      "/returns/collection_step"(platform:"/") {
      }

      "/returns/carrier_step"(platform:"/") {
      }

      "/returns/congrats"(platform:"/") {
      }

      "/returns/congrats/print_label"(platform:"/") {
          print_url = "https://www.mercadolibre.com"
      }
    }
}
