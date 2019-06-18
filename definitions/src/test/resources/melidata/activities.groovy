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

    /************************************
    *    ACTIVITY MOBILE TEST TRACKS    *
    ************************************/
    
    test("Mercadopago Activities List Mobile") {
        "/listing/activities" (platform: "/mobile", type: TrackType.View) {}
    }   

    test("Mercadopago Activities Pull List Mobile") {
        "/listing/activities/pull" (platform: "/mobile", type: TrackType.Event) {
            has_changes = true
        }
    }
       
    test("Mercadopago Activity Apply Filters Mobile") {
        "/listing/activities/filters/apply" (platform: "/mobile", type: TrackType.Event) {
            items = [
                [
                    ordinal: 1,
                    id: "month"
                ],
                [
                    ordinal: 2,
                    id: "facet_type_payment"
                ]
            ]
        }
    }

    test("Mercadopago Activity Filters List Mobile") {
        "/listing/activities/filters" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Activity Filters Options List Mobile") {
        "/listing/activities/filters/options" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail List Mobile") {
        "/listing/activities/detail" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail List Mobile") {
        "/listing/activities/detail/list" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Add Note List Mobile") {
        "/listing/activities/detail/add_note" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Added Note Mobile") {
        "/listing/activities/detail/add_note/added" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Operation Detail Buyer Information Mobile") {
        "/listing/activities/detail/user_info" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Shipping Mobile") {
        "/listing/activities/detail/shipping" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Web View Mobile") {
        "/listing/activities/detail/web_view" (platform: "/mobile", type: TrackType.View) {
            url = "https://mercadolibre.com"
        }
    }

    test("Mercadopago Activities Real Time Total Mobile") {
        "/listing/activities/real_time/total" (platform: "/mobile", type: TrackType.View) {
            total = 9
        }
    }

    test("Mercadopago Activities Real Time Push Mobile") {
        "/listing/activities/real_time/push" (platform: "/mobile", type: TrackType.View) {
            activity_id = "merch-001234"
            date_created = "2019/09/08"
        }
    }
}
