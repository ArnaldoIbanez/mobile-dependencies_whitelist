import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Loyalty benefit detail") {
        "/loyalty/score/benefit"(platform: "/", type: TrackType.View) {
            benefit = "FREE_SHIPPING"
        }
    }

    test("Loyalty score back") {
        "/loyalty/score/back"(platform: "/mobile/android", type: TrackType.Event) {
        }
    }

    test("Loyalty notification") {
        "/loyalty/notification"(platform: "/", type: TrackType.Event) {
            event_type = "received"
        }
    }


    test("Loyalty user") {
        "/loyalty/user"(platform: "/", type: TrackType.Event) {
            in_loyalty_program = true
        }
    }

    test("Loyalty user change level") {
        "/loyalty/user/change_level"(platform: "/", type: TrackType.Event) {
            old_level = 4
            in_loyalty_program = true

        }
    }

    test("Loyalty user uses benefit") {
        "/loyalty/user/benefit"(platform: "/", type: TrackType.Event) {
            benefit = "FREE_SHIPPING"
            consumable = false
            in_loyalty_program = true
            reference = "123"
        }
    }

    test("Loyalty points expiration") {
        "/loyalty/user/expire_points"(platform: "/", type: TrackType.Event) {
            expired_points = "123"
            due_date = "24/11/89"
            in_loyalty_program = true
        }
    }


    test("Loyalty float notification") {
        "/loyalty/user/float_notification"(platform: "/", type: TrackType.Event) {
            event_type = "sent"
            in_loyalty_program = true
            notification_ids = "[123]"

        }
    }

    test("Loyalty landing") {
        "/loyalty/landing"(platform: "/", type: TrackType.Event) {
            landing_id = "FREE_SHIPPING"
        }
    }

    test("Loyalty welcome modal") {
        "/loyalty/modal"(platform: "/mobile", type: TrackType.View) {
            event_type = "SHOW"
        }
    }

    test("Loyalty discounts landing") {
        "/loyalty/discounts"(platform: "/", type: TrackType.View) {
        }
    }

    test("Loyalty user tracking") {
        "/loyalty/user"(platform: "/") {
            in_loyalty_program = true
        }
    }

    test("Loyalty tracks") {
        def loyaltyInfo = {
            level = 1
            points = 100
            percentage = 0.5f
        }
        "/loyalty/score"(platform: "/", type: TrackType.View, loyaltyInfo)
        "/loyalty/score/milestones"(platform: "/", type: TrackType.View, loyaltyInfo)
        "/loyalty/score/achievements"(platform: "/", type: TrackType.View, loyaltyInfo)
        "/loyalty/score/benefits"(platform: "/", type: TrackType.View, loyaltyInfo)
        "/loyalty/notification"(platform: "/", type: TrackType.Event, { event_type = 'shown' })
    }
}
