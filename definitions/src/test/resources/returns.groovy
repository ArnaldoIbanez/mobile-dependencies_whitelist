import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Returns tracks") {

      // STEP 01
      "/return/typifications"(platform: "/")  {
        typification = "broken_item"
      }

      // STEP 02
      "/return/payments"(platform: "/") {
        payment = "paymentId"
      }

      // STEP 03
      "/return/shipping"(platform: "/") {
        shipping = "pickup"
      }

      // STEP 04.a
      "/return/pickup"(platform: "/") {
        pickup_time = "pickupTime"
      }

      // STEP 04.b
      "/return/delivery"(platform: "/") {
        carrier_id = "carrierId"
      }

      // STEP 05
      "/return/congrats"(platform: "/") {
        typification = "broken_item"
        payment = "paymentId"
        shipping = "carrier"
        pickup_time = "pickupTime"
        carrier_id = "carrierId"
      }

      // STEP 05.cta.a
      "/return/congrats/print_label"(platform: "/") {
        print_url = "https://www.mercadolibre.com"
      }

      // STEP 05.cta.b
      "/return/congrats/remedy_label"(platform: "/") { }

      // Modal
      "/return/modal"(platform: "/") {
        action = "modal_action"
        id = "modal_id"
      }
    }
}
