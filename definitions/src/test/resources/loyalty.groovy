import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Loyalty frontend") {
        "/loyalty/score"(platform: "/", type: TrackType.View) {
        }
    }

    test("Loyalty benefits tab") {
        "/loyalty/score/benefits"(platform: "/", type: TrackType.View) {
        }
    }

    test("Loyalty milestones tab") {
        "/loyalty/score/milestones"(platform: "/", type: TrackType.View) {
        }
    }

    test("Loyalty achievements tab") {
        "/loyalty/score/achievements"(platform: "/", type: TrackType.View) {
        }
    }

    test("Loyalty benefit detail") {
        "/loyalty/score/benefit"(platform: "/", type: TrackType.View) {
            benefit = "FREE_SHIPPING"
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

        }
    }

    test("Loyalty float notification") {
        "/loyalty/user/float_notification"(platform: "/", type: TrackType.Event) {
            event_type = "sent"
            in_loyalty_program = true


        }
    }


}
