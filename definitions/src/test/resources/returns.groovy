import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Returns tracks") {

      "/return/typification"(platform:"/")  {
      }

      "/return/money_refund"(platform:"/") {
        typification = "Producto defectuoso"
      }

      "/return/pick_up_option"(platform:"/") {
        money_refund = "2863383085"
      }

      "/return/collection"(platform:"/") {
        pickup_option = "pickup"
      }

      "/return/carrier"(platform:"/") {
        pickup_option = "carrier"
      }

      "/return/congrats"(platform:"/") {
          pickup_option = "carrier"
          carrier_id = "12331123"
      }

      "/return/congrats/print_label"(platform:"/") {
          print_url = "https://www.mercadolibre.com"
      }

      "/return/congrats/remedy_label"(platform:"/") {
      }
    }
}
