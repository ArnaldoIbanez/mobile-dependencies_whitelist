import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("melidata vip track") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            category_id = "MLA123"
        }

        def trackModals = {
            show = "fae_details"
            item_id = "MLA213512313"
            category_id = "MLA123"
        }

        "/vip/variations"(platform: "/web") {
            defaultTrackInformation()
        }

        "/vip/reviews"(platform: "/", type: TrackType.View) {
            trackModals()
        }

    }

}
