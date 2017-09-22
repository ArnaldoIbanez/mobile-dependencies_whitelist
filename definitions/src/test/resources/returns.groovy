import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Returns tracks") {

      // STEP 01
      "/return/typifications"(platform:"/")  {
      }

      // STEP 02
      "/return/payments"(platform:"/") {
        typification = "Producto defectuoso"
      }

      // STEP 03
      "/return/shipping"(platform:"/") {
        money_refund = "2863383085"
      }

      // STEP 04.a
      "/return/pickup"(platform:"/") {
        pickup_option = "pickup"
      }

      // STEP 04.b
      "/return/delivery"(platform:"/") {
        pickup_option = "carrier"
      }

      // STEP 05
      "/return/congrats"(platform:"/") {
          pickup_option = "carrier"
          carrier_id = "12331123"
      }

      // STEP 05.cta.a
      "/return/congrats/print_label"(platform:"/") {
          print_url = "https://www.mercadolibre.com"
      }

      // STEP 05.cta.b
      "/return/congrats/remedy_label"(platform:"/") {
      }
    }
}
