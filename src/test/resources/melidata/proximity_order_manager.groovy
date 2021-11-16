package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    // Views:

    test("Page View Order Manager Home Page") {
        "/proximity_order_manager/home" (platform: "/", type: TrackType.View) {}
    }

    // Events:

    test("Event Order Manager Action") {
        "/proximity_order_manager/action" (platform: "/", type: TrackType.Event) {
            opening_hours_today = [
                {
                    open: "00:00"
                    close: "23:59"
                }
            ]
            seller_id = 1
            store_id = 2
            action_type = "CLOSE_STORE"
        }
    }

    test("Event Order Manager Session") {
        "/proximity_order_manager/session" (platform: "/", type: TrackType.Event) {
            session_id = "123"
            seller_id = 1
            session_type = "CREATE"
            date = "2021/11/08"
            created_at = "2021/11/08"
        }
    }
}
