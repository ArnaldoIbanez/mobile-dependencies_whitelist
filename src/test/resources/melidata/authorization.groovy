
package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

   test("Authorization Open-Banking") {

       "/open_banking"(platform: "/") {}

        "/open_banking/authorization"(platform: "/", type: TrackType.View)  {
            base_path = "/open_banking"
            name_page = "/authorization"
        }

        "/open_banking/error"(platform: "/", type: TrackType.View)  {
            base_path = "/open_banking"
            name_page = "/error"
        }

        "/open_banking/access"(platform: "/", type: TrackType.View)  {
            base_path = "/open_banking"
            name_page = "/access"
        }

    }

   test("Authorization AppStore") {

       "/appstore"(platform: "/") {}

        "/appstore/authorization"(platform: "/", type: TrackType.View)  {
            base_path = "/appstore"
            name_page = "/authorization"
            integrator_app = "App example"
            request_app = "Mercado Libre"
        }

        "/appstore/error"(platform: "/", type: TrackType.View)  {
            base_path = "/appstore"
            name_page = "/error"
        }

        "/appstore/access"(platform: "/", type: TrackType.View)  {
            base_path = "/appstore"
            name_page = "/access"
        }

    }
}