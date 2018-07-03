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


    test("Loyalty Redesign Tracks") {
        def loyaltyInfo = {
            level = 1
            points = 100
            percentage = 0.5f
        }
        "/loyalty/main"(platform: "/", type: TrackType.View, loyaltyInfo)
        "/loyalty/main/activity"(platform: "/", type: TrackType.View, loyaltyInfo)

        "/loyalty/main/modal"(platform: "/", type: TrackType.View, {
            type = "benefit"
            benefit_id = 'FREE_SHIPPING'
        })

        "/loyalty/main/modal"(platform: "/", type: TrackType.View, {
            type = "milestone"
            milestone_id = 'WELCOME_TO_PROGRAM'
            from = 'main'
        })

        "/loyalty/main/modal"(platform: "/", type: TrackType.View, {
            type = "milestone"
            milestone_id = 'COBRANDED_REQUEST'
            family_id = 'cobranded'
            from = 'main'
        })

        "/loyalty/main/modal"(platform: "/", type: TrackType.View, {
            type = "milestone"
            milestone_id = 'COBRANDED_REQUEST'
            family_id = 'cobranded'
            from = 'milestones'
        })

        "/loyalty/main/modal"(platform: "/", type: TrackType.View, {
            type = "benefits_per_level"
        })

        "/loyalty/main/modal/action"(platform: "/", type: TrackType.View, {
            type = "benefit"
            benefit_id = 'FREE_SHIPPING'
        })

        "/loyalty/main/modal/action"(platform: "/", type: TrackType.View, {
            type = "milestone"
            milestone_id = 'VALIDATE_PHONE'
        })

        "/loyalty/main/modal/action"(platform: "/", type: TrackType.View, {
            type = "milestone"
            milestone_id = 'COBRANDED_REQUEST'
            family_id = 'cobranded'
        })

        "/loyalty/main/modal/action"(platform: "/", type: TrackType.View, {
            type = "milestone"
            milestone_id = 'COBRANDED_REQUEST'
            family_id = 'cobranded'
        })

        "/loyalty/milestones"(platform: "/", type: TrackType.View, loyaltyInfo)
    }

    test("Loyalty Buy Level"){
        "/loyalty/buylevel"(platform: "/",type: TrackType.View){
        }
    }

    test("Loyalty Buy Level Landing"){
        "/loyalty/buylevel/landing"(platform: "/",type: TrackType.View){
        }
    }

    test("Loyalty Buy Level Checkout"){
        "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "success"
            origin= "vip"
            item_id = "MLA000000"
        }

        "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "success_orange"
            origin= "vip"
        }

        "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "error"
            origin= "mail"
        }
    }

    test("Loyalty Buy Level Payment"){
        "/loyalty/buylevel/payment"(platform: "/",type: TrackType.Event){
            payment_status= "approved"
            payment_status_detail= "cc_approved_plugin_pm"
        }

        "/loyalty/buylevel/payment"(platform: "/",type: TrackType.Event){
            our_payment_error="Error msg"
        }
    }
}
