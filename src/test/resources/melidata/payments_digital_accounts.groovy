package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadopago"

    /******************************************
    *  Payments - Digital Accounts - Banking  *
    ******************************************/

    test("Balance") {
        "/banking/balance"(platform: "/", type: TrackType.View) {}
    }

    test("Balance Calendar") {
        "/banking/calendar"(platform: "/", type: TrackType.View) {}
    }

    test("Balance Activities") {
        "/banking/activities"(platform: "/", type: TrackType.View) {}
    }

    test("Balance Cerc") {
        "/banking/cerc"(platform: "/", type: TrackType.View) {}
    }

    test("Movements") {
        "/banking/movements"(platform: "/", type: TrackType.View) {}
    }

    test("PNF") {
        "/banking/pnf"(platform: "/", type: TrackType.View) {}
    }

    test("Banking Balance Merch Engine Events") {
        "/banking/balance/credits" (platform: "/", type: TrackType.Event) {}
        "/banking/balance/credits/print" (platform: "/", type: TrackType.Event) {}
        "/banking/balance/credits/tap" (platform: "/", type: TrackType.Event) {}
    }
}
