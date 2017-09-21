import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Returns tracks") {

      "/return/typifications"(platform:"/")  {
      }

      "/return/payments"(platform:"/") {
        typification = "Producto defectuoso"
      }

      "/return/shipping"(platform:"/") {
        payment = "2863383085"
      }

      "/return/pickup"(platform:"/") {
        shipping = "pickup"
      }

      "/return/delivery"(platform:"/") {
        shipping = "carrier"
      }

      "/return/congrats"(platform:"/") {
          shipping = "carrier"
          carrier_id = "12331123"
      }

      "/return/congrats/print_label"(platform:"/") {
          print_url = "https://www.mercadolibre.com"
      }

      "/return/congrats/remedy_label"(platform:"/") {
      }
    }
}
