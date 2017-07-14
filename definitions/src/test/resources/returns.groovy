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
        money_refund = "Tarjeta Credito"
      }

      "/return/collection"(platform:"/") {
      }

      "/return/carrier"(platform:"/") {
      }

      "/return/congrats"(platform:"/") {
          pickup_option = "collection"
          carrier_id = "12331123"
      }

      "/return/congrats/print_label"(platform:"/") {
          print_url = "https://www.mercadolibre.com"
      }

      "/return/congrats/remedy_label"(platform:"/") {
      }
    }
}
