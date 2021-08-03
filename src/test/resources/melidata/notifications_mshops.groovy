import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadoshops"
    test("MercadoShops Notifications") {
        "/notification/mshops_orders"(platform: "/", type: TrackType.Event) {
            event_type = "shown"
        }
        "/notification/mshops_questions"(platform: "/", type: TrackType.Event) {
            event_type = "shown"
        }
    }
}