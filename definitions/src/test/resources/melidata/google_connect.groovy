import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("MPConnect Lib") {
         "/google_connect/init_flow"(platform:"/mobile", type: TrackType.Event) {
             type = "no_params"
         }

         "/google_connect/init_flow"(platform:"/mobile", type: TrackType.Event) {
             type = "normal"
             withToken = false
             withAuthRequest = false
         }

         "/google_connect/init_flow"(platform:"/mobile", type: TrackType.Event) {
             type = "normal"
             withAuthRequest = true
         }

         "/google_connect/init_flow"(platform:"/mobile", type: TrackType.Event) {
             type = "reauthentication"
             withToken = true
             withAuthRequest = false
         }

         "/google_connect/end_flow"(platform:"/mobile", type: TrackType.Event) {
             status = "approved"
         }
         "/google_connect/end_flow"(platform:"/mobile", type: TrackType.Event) {
             status = "canceled"
         }
     }

    
    defaultBusiness = "mercadopago"

    test("MPConnect Lib") {
         "/google_connect/init_flow"(platform:"/mobile", type: TrackType.Event) {
             type = "no_params"
         }

         "/google_connect/init_flow"(platform:"/mobile", type: TrackType.Event) {
             type = "normal"
             withToken = false
             withAuthRequest = false
         }

         "/google_connect/init_flow"(platform:"/mobile", type: TrackType.Event) {
             type = "normal"
             withAuthRequest = true
         }

         "/google_connect/init_flow"(platform:"/mobile", type: TrackType.Event) {
             type = "reauthentication"
             withToken = true
             withAuthRequest = false
         }

         "/google_connect/end_flow"(platform:"/mobile", type: TrackType.Event) {
             status = "approved"
         }
         "/google_connect/end_flow"(platform:"/mobile", type: TrackType.Event) {
             status = "canceled"
         }
     }
}
