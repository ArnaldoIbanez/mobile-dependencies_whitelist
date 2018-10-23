import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"
    test("supermaket") {
        "/supermarket/header"(platform: "/", type: TrackType.Event) {}
        "/supermarket/discovery"(platform: "/", type: TrackType.Event) {}
    }
}