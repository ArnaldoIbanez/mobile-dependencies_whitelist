package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Home loads successfully") {
        "/meliplaces/home/success"(platform: "/", type: TrackType.View) {
            service_id = ['cashin', 'cashout']
        }
    }

    test("Home shield view is shown") {
        "/meliplaces/home/shield"(platform: "/", type: TrackType.View) {
            shield_id = "shield_1"
            error = 404
            message = "error message"
        }
    }

    test("Home is closed") {
        "/meliplaces/home/close"(platform: "/mobile", type: TrackType.Event) {}
    }

    test("A row from other options is tapped") {
        "/meliplaces/home/other_options/tap"(platform: "/", type: TrackType.Event) {
            row_id = "row_1"
        }
    }

    test("A new transaction is created") {
        "/meliplaces/transaction/start"(platform: "/", type: TrackType.Event) {
            service_id = "cashin"
        }
    }

    test("Performance view loads successfully") {
        "/meliplaces/performance/success"(platform: "/", type: TrackType.View) {}
    }

    test("Performance empty state view loads successfully") {
        "/meliplaces/performance/empty_state"(platform: "/", type: TrackType.View) {}
    }

    test("Performance shield view is shown") {
        "/meliplaces/performance/shield"(platform: "/", type: TrackType.View) {
            shield_id = "shield_1"
            error = 404
            message = "error message"
        }
    }

    test("Performance tooltip is shown") {
        "/meliplaces/performance/tooltip/show"(platform: "/", type: TrackType.Event) {
            tooltip_id = "tooltip_1"
        }
    }

    test("Performance tooltip is hidden") {
        "/meliplaces/performance/tooltip/hide"(platform: "/", type: TrackType.Event) {
            tooltip_id = "tooltip_1"
        }
    }

    test("Performance card's footer is tapped") {
        "/meliplaces/performance/card/footer"(platform: "/", type: TrackType.Event) {
            card_id = "card_1"
            footer_id = "footer_1"
        }
    }

    test("Activity detail view loads successfully") {
        "/meliplaces/activities/detail/success"(platform: "/", type: TrackType.View) {}
    }  
    
    test("Activity detail shield view is shown") {
        "/meliplaces/activities/detail/shield"(platform: "/", type: TrackType.View) {
            shield_id = "shield_1"
            error = 404
            message = "error message"
        }
    }

    test("User taps on view receipt") {
        "/meliplaces/activities/detail/receipt"(platform: "/", type: TrackType.Event) {}
    }

    test("Result view loads successfully") {
        "/meliplaces/result/success"(platform: "/mobile", type: TrackType.View) {
            service_id = "cashin"
            status = "approved"
        }
    }
    
    test("Result shield view is shown") {
        "/meliplaces/result/shield"(platform: "/mobile", type: TrackType.View) {
            shield_id = "shield_1"
            error = 404
            message = "error message"
        }
    }

    test("User taps on share button") {
        "/meliplaces/result/share"(platform: "/mobile", type: TrackType.Event) {}
    }

    test("User taps on action button") {
        "/meliplaces/result/action"(platform: "/mobile", type: TrackType.Event) {
            action_id = "primary"
            type = "navigate"
        }
    }

    test("Result is closed") {
        "/meliplaces/result/close"(platform: "/mobile", type: TrackType.Event) {}
    }
}