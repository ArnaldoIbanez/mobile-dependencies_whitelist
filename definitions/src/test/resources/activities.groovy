import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Mercadopago Activities List") {
        "/listing/activities" (platform: "/web", type: TrackType.View) {
            shown_modal_id = '45daysMigration'
        }
    }

    test("Mercadopago Gateway List") {
        "/listing/gateway" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities Detail") {
        "/activity/detail" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities Detail Shipping") {
        "/activity/detail/shipping" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities Balance") {
        "/activities/balance" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities PNF Adelantos") {
        "/activities/balance/advances" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities PNF Adelantos Congrats") {
        "/activities/balance/advances/congrats" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities Export") {
        "/activities/export" (platform: "/web", type: TrackType.View) {}
    }
}
