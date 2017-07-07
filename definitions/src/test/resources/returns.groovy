import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Returns tracks") {

      "/return/typification"(platform:"/")  {
      }

      "/return/money_refund"(platform:"/") {
      }

      "/return/pick_up_option"(platform:"/") {
      }

      "/return/collection_step"(platform:"/") {
      }

      "/return/carrier_step"(platform:"/") {
      }

      "/return/congrats"(platform:"/") {
      }

      "/return/congrats/print_label"(platform:"/") {
          print_url = "https://www.mercadolibre.com"
      }
    }
}
