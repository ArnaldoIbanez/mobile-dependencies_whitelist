
package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

   test("Authorization Open-Banking") {

       "/open_banking"(platform: "/") {}

        "/open_banking/authorization"(platform: "/", type: TrackType.View)  {
            basepath = "/open_banking"
            namepage = "/authorization"
        }

        "/open_banking/error"(platform: "/", type: TrackType.View)  {
            basepath = "/open_banking"
            namepage = "/error"
        }

        "/open_banking/access"(platform: "/", type: TrackType.View)  {
            basepath = "/open_banking"
            namepage = "/access"
        }

    }
}