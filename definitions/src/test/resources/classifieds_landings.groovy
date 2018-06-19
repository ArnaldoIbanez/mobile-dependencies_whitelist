import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    def defaultTrackInformation = {
        category_id = "MLA123"
        vertical = "services"
    }

    "/classifieds/hirable/sellers"(platform: "/", type: TrackType.View) {
        defaultTrackInformation()
    }
    "/classifieds/hirable/buyers"(platform: "/", type: TrackType.View) {
        defaultTrackInformation()
    }
    "/classifieds/contract/sellers"(platform: "/", type: TrackType.View) {
        defaultTrackInformation()
    }
    "/classifieds/contract/buyers"(platform: "/", type: TrackType.View) {
        defaultTrackInformation()
    }
}