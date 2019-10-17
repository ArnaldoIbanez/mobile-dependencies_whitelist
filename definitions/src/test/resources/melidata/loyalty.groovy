package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"
    
    test("Loyalty parent track") {
        "/loyalty"(platform:"/", type: TrackType.View) {
        }
        
        "/loyalty"(platform:"/", type: TrackType.View) {
            origin = "vip"
        }
    }

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

    test("Loyalty landing aerolineas") {
        "/loyalty/landing/aerolineas"(platform: "/", type: TrackType.Event) {
            landing_id = "aerolineas"
            destination_id = "123ABC"
        }
    }

    test("Loyalty welcome modal") {
        "/loyalty/modal"(platform: "/mobile", type: TrackType.View) {
            event_type = "SHOW"
        }
    }

    test("Loyalty discounts landing") {
        "/loyalty/discounts"(platform: "/", type: TrackType.View) {
            free_shipping = {
                id = "MLA123123123"
            }
            categories = {
                id = "MLA1574"
                name = "HOGAR"
            }
            official_stores = {
                id = 234
                title = "Caliber"
            }
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
        
        "/loyalty/vip/modal"(platform: "/", type: TrackType.View, {
            type = "buy_level"
        })
        
        "/loyalty/vip/modal"(platform: "/", type: TrackType.View, {
            type = "free_trial"
        })

        "/loyalty/vip/modal/action"(platform: "/", type: TrackType.View, {
            type = "buy_level"
        })
        
        "/loyalty/vip/modal/action"(platform: "/", type: TrackType.View, {
            type = "free_trial"
        })
        
        "/loyalty/vip/modal/action"(platform: "/", type: TrackType.View, {
            type = "item"
        })
        
        "/loyalty/vip/modal/action"(platform: "/", type: TrackType.View, {
            type = "close"
        })

        "/loyalty/milestones"(platform: "/", type: TrackType.View, loyaltyInfo)
    }
    test("Loyalty Buy Level"){
        "/loyalty/buylevel"(platform: "/",type: TrackType.View){
        }
    }

    test("Loyalty Buy Level Landing"){
        "/loyalty/buylevel/landing"(platform: "/",type: TrackType.View){
                        origin= "loyalty_frontend"
        }
        "/loyalty/buylevel/landing"(platform: "/",type: TrackType.View){
                        origin= "push"
        }
        "/loyalty/buylevel/landing"(platform: "/",type: TrackType.View){
                        origin= "marketplace"
        }
        "/loyalty/buylevel/landing"(platform: "/",type: TrackType.View){
                        origin= "aerolineas"
        }
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

       "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "started"
            origin= "marketplace"
        }

       "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "started"
            origin= "new_vip"
        }
       "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "started"
            origin= "loyalty_frontend"
        }
       "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "started"
            origin= "vip"
        }
       "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "started"
            origin= "mail"
        }
       "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "started"
            origin= "landing"
        }
        "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "started"
            origin= "aerolineas"
        }
        "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.View){
            action= "success"
            origin= "aerolineas"
        }
    }

    test("Loyalty Buy Level Payment"){
        "/loyalty/buylevel/payment"(platform: "/",type: TrackType.Event){
            payment = 454353
            payment_status= "approved"
            payment_status_detail= "cc_approved_plugin_pm"
            item_id = "MLA000000"
        }

        "/loyalty/buylevel/payment"(platform: "/",type: TrackType.Event){
            item_id = "MLA000000"
            our_payment_error="Error msg"
        }
    }

    test("Loyalty Buy Level Cancellation"){
        "/loyalty/buylevel/cancellation/retention_landing"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/buylevel/cancellation/not-applicable"(platform: "/",type: TrackType.Event){
            reason = "already_cancelled"
        }
        "/loyalty/buylevel/cancellation/not-applicable"(platform: "/",type: TrackType.Event){
            reason = "not_bought"
        }
        "/loyalty/buylevel/cancellation/not-applicable"(platform: "/",type: TrackType.Event){
            reason = "past_time"
        }

        "/loyalty/buylevel/cancellation/reason_form"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/buylevel/cancellation/congrats"(platform: "/",type: TrackType.Event){
            status = "success"
        }

        "/loyalty/buylevel/cancellation/congrats"(platform: "/",type: TrackType.Event){
            status = "needs_validation"
        }

    }

    test("Loyalty Free Trial Cancellation"){
        "/loyalty/freetrial/cancellation/retention_landing"(platform: "/",type: TrackType.Event){
        }
        "/loyalty/freetrial/cancellation/not-applicable"(platform: "/",type: TrackType.Event){
            reason = "already_cancelled"
        }
        "/loyalty/freetrial/cancellation/not-applicable"(platform: "/",type: TrackType.Event){
            reason = "not_in_freetrial"
        }
        "/loyalty/freetrial/cancellation/reason_form"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/freetrial/cancellation/congrats"(platform: "/",type: TrackType.Event){
        }
    }

    test("partners"){
        "/loyalty/subscribe"(platform: "/", type: TrackType.Event){
            partner_id = "megatlon"
        }

        "/loyalty/subscribe"(platform: "/", type: TrackType.Event){
            partner_id = "fiter"
        }
    }

    test("rewards test"){
        "/loyalty/rewards"(platform: "/", type: TrackType.View) {}

        "/loyalty/rewards/activity"(platform: "/", type: TrackType.View) {}
    }

    test("campaign"){
        "/loyalty/campaign/email"(platform: "/", type: TrackType.Event) {
            action = "open"
            mail_origin = "level_1_2"
            campaign_id = "mlb_campaign_buyers_test"
        }

        "/loyalty/campaign/email"(platform: "/", type: TrackType.Event) {
            action = "open"
            mail_origin = "level_3_4_5_6"
            campaign_id = "mlb_campaign_buyers_test"
        }
    }

    test("Loyalty Offer Discounts"){
        "/loyalty/sellers/discounts"(platform: "/",type: TrackType.View){}
    }

    //  --------------------------------------------- Free-Trials ---------------------------------------------

    test("Loyalty Free Trial Landing"){

        "/loyalty/freetrial/landing"(platform: "/", type: TrackType.View) {
        }
    }

    test("Loyalty Free Trials Contention Screen"){

        "/loyalty/freetrial"(platform: "/",type: TrackType.View){
            item_id = "MLA10101010"
        }

        "/loyalty/freetrial/contention"(platform: "/",type: TrackType.View){
        }

        "/loyalty/freetrial/contention"(platform: "/",type: TrackType.View){
            from = "primaryButton"
        }

        "/loyalty/freetrial/contention/continue"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/freetrial/contention/cancel"(platform: "/",type: TrackType.Event){
            type = "close"
        }

        "/loyalty/freetrial/contention/cancel"(platform: "/",type: TrackType.Event){
            type = "dismiss"
        }
    }

    test("Loyalty Free Trials Card Selection Screen"){
        "/loyalty/freetrial/cardselection"(platform: "/",type: TrackType.View){
            item_id = "MLA10101010"
        }

        "/loyalty/freetrial/cardselection"(platform: "/",type: TrackType.View){
            origin = "vip"
            item_id = "MLA1234"
        }

        "/loyalty/freetrial/cardselection/selected"(platform: "/",type: TrackType.Event){
            cardName = "mastercard"
            cardPosition = 1
        }

        "/loyalty/freetrial/cardselection/continue"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/freetrial/cardselection/cancel"(platform: "/",type: TrackType.Event){
            type = "close"
        }
    }

    test("Loyalty Free Trials Set Only CVV"){
        "/loyalty/freetrial/cardselection/cvv"(platform: "/",type: TrackType.View){
            origin = "marketplace"
        }

        "/loyalty/freetrial/cardselection/cvv/continue"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/freetrial/cardselection/cvv/cancel"(platform: "/",type: TrackType.Event){
            type = "dismiss"
        }
    }

    test("Loyalty Free Trials New Card Screen"){
        "/loyalty/freetrial/newcard"(platform: "/",type: TrackType.View){
            item_id = "MLA10101010"
        }

        "/loyalty/freetrial/newcard/continue"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/freetrial/newcard/cancel"(platform: "/",type: TrackType.Event){
            type = "button"
        }

        "/loyalty/freetrial/newcard/cardnumber"(platform: "/",type: TrackType.View){
        }

        "/loyalty/freetrial/newcard/cardnumber/continue"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/freetrial/newcard/cardnumber/cancel"(platform: "/",type: TrackType.Event){
            type = "close"
        }

        "/loyalty/freetrial/newcard/securitycode"(platform: "/",type: TrackType.View){
        }

        "/loyalty/freetrial/newcard/securitycode/continue"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/freetrial/newcard/securitycode/cancel"(platform: "/",type: TrackType.Event){
            type = "back"
        }

        "/loyalty/freetrial/newcard/name"(platform: "/",type: TrackType.View){
        }

        "/loyalty/freetrial/newcard/name/continue"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/freetrial/newcard/name/cancel"(platform: "/",type: TrackType.Event){
            type  = "back"
        }

        "/loyalty/freetrial/newcard/identification"(platform: "/",type: TrackType.View){
        }

        "/loyalty/freetrial/newcard/identification/continue"(platform: "/",type: TrackType.Event){
        }

        "/loyalty/freetrial/newcard/identification/cancel"(platform: "/",type: TrackType.Event){
            type = "button"
        }
    }

    test("Loyalty Free Trials Congrats Screen"){
        "/loyalty/freetrial/congrats"(platform: "/",type: TrackType.View){
            item_id = "MLA10101010"
            congratstype = "warning"
        }

        "/loyalty/freetrial/congrats/continue"(platform: "/",type: TrackType.Event){
            item_id = "MLA10101010"
            congratstype = "success"
        }

        "/loyalty/freetrial/congrats/cancel"(platform: "/",type: TrackType.Event){
            item_id = "MLA10101010"
            congratstype = "error"
        }
    }

    test("Loyalty Free Trials Confirm Screen"){
        "/loyalty/freetrial/confirm"(platform: "/mobile/android",type: TrackType.View){
            item_id = "MLA10101010"
        }

        "/loyalty/freetrial/confirm/continue"(platform: "/mobile/android",type: TrackType.Event){
        }

        "/loyalty/freetrial/confirm/cancel"(platform: "/mobile/android",type: TrackType.Event){
            type = "back"
        }

        "/loyalty/freetrial/confirm/cancel"(platform: "/mobile/android",type: TrackType.Event){
            type = "button"
        }
    }

    test("Loyalty Free Trials Payment Track"){
        "/loyalty/freetrial/payment"(platform: "/",type: TrackType.Event){
            payment = 454353
            payment_status= "approved"
            payment_status_detail= "cc_approved_plugin_pm"
            item_id = "MLA10101010"
        }

        "/loyalty/freetrial/payment"(platform: "/",type: TrackType.Event){
            payment = 454353
            payment_status= "approved"
            payment_status_detail= "cc_approved_plugin_pm"
            origin = "vip"
            item_id = "MLA1234"
        }

        "/loyalty/freetrial/payment/error"(platform: "/",type: TrackType.Event){
            our_payment_error="Error msg"
            item_id = "MLA10101010"
        }
    }

    test("Loyalty partners carousel location A/B test"){
        "/loyalty/main/partners_landing"(platform: "/", type: TrackType.Event){
            original_place = "keep"
        }

        "/loyalty/main/partners_landing"(platform: "/", type: TrackType.Event){
            original_place = "move"
        }
    }

    test("Loyalty v2 pageviews"){
        "/loyalty/hub"(platform: "/", type: TrackType.View){}
        "/loyalty/hub/skeleton"(platform: "/", type: TrackType.View){}
        "/loyalty/status"(platform: "/", type: TrackType.View){}
        "/loyalty/status/skeleton"(platform: "/", type: TrackType.View){}
        "/loyalty/milestones_v2"(platform: "/", type: TrackType.View){}
        "/loyalty/milestone_v2"(platform: "/", type: TrackType.View){
            milestone_id = "qr_payment"
        }
    }
}
