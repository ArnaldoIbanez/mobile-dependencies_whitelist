package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    /*************************
    *     ACTIVITY WEB    *
    *************************/

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

    /*************************
    *     ACTIVITY MOBILE    *
    *************************/

    test("Mercadopago Activities List Mobile") {
        "/activities/list" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Activity Apply Filters Mobile") {
        "/activities/filters/apply" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Activity Filters List Mobile") {
        "/activities/filters" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Activity Filters Options List Mobile") {
        "/activities/filters/options" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Activity Remove Filters Mobile") {
        "/activities/list/remove_filter" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Operation Detail List Mobile") {
        "/activities/detail" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail List Mobile") {
        "/activities/detail/list" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Add Note List Mobile") {
        "/activities/detail/add_note" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Buyer Information Mobile") {
        "/activities/detail/user_info" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Shipping Mobile") {
        "/activities/detail/shipping" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Web View Mobile") {
        "/activities/detail/web_view" (platform: "/mobile", type: TrackType.View) {
            url = "https://mercadolibre.com"
        }
    }

    test("Mercadopago Operation Detail Send Realtimes Activities Mobile") {
        "/activities/real_time" (platform: "/mobile", type: TrackType.Event) {
            activity_id = "merch-123124"
            date_created = "12/11/19"
        }
    }

    test("Mercadopago Operation Detail Number Of Realtimes Activities Mobile") {
        "/activities/real_time/total" (platform: "/mobile", type: TrackType.Event) {
            total = 12
        }
    }
}
