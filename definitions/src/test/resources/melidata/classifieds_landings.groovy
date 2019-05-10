package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Classifieds landing_services tracks test") {
        def defaultTrackInformation = {
            category_id = "MLA123"
            vertical = "services"
        }

        "/classifieds/hirable/sellers"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            category_path = ["MLA123", "MLA123"]
        }
        "/classifieds/hirable/buyers"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            category_path = ["MLA123", "MLA123"]
        }

        "/classifieds/contract/sellers"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            category_path = ["MLA123", "MLA123"]
        }
        "/classifieds/contract/buyers"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            category_path = ["MLA123", "MLA123"]
        }

        "/classifieds/quotes/sellers"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            category_path = ["MLA123", "MLA123"]
        }
        "/classifieds/quotes/buyers"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            category_path = ["MLA123", "MLA123"]
        }
    }
}
