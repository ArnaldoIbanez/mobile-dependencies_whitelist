package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    /******************************************
    *  Payments - Digital Accounts - Banking  *
    ******************************************/

    test("Banking Balannce MP") {
        "/banking/balance"(platform: "/", type: TrackType.View) {}
    }

    test("Banking Calendar MP") {
        "/banking/calendar"(platform: "/", type: TrackType.View) {}
    }

    test("Banking PNF") {
        "/banking/pnf"(platform: "/", type: TrackType.View) {}
    }
}
