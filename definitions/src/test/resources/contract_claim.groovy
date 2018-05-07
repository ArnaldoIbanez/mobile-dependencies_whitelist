import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadolibre"

    test("melidata contract-claim track") {

        "/contract-claim"(platform: "/", type: TrackType.View) {}

        "/contract-claim/add-claim"(platform: "/", type: TrackType.Event) {
            order_id = 1703206862
            item_id = 'MLA722247557'
            seller_id = 282439040
            buyer_id = 318501512
            reason_id = 'undelivered'
            reason_detail = 'undelivered_repentant_buyer'
        }
    }
}