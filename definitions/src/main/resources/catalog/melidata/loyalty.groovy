import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Loyalty

    "/loyalty"(platform: "/", isAbstract: true) {
        level(type: PropertyType.Numeric, required: false)
        points(type: PropertyType.Numeric, required: false)
        percentage(type: PropertyType.Numeric, required: false)
        origin(required: false, values: ["mail", "push", "vip", "marketplace", "loyalty_frontend", "new_vip", "landing", "aerolineas"], description: "Where was the path flow initiated from.")
    }

    "/loyalty/score"(type: TrackType.View) {}

    "/loyalty/score/milestones"(type: TrackType.View) {} //Milestones tab
    "/loyalty/score/benefits"(type: TrackType.View) {} //Benefits tab
    "/loyalty/score/achievements"(type: TrackType.View) {} //Achievements tab

    "/loyalty/score/benefit"(platform: "/", type: TrackType.View) {
        benefit(required: true, description: "Indicates which benefit was viewed")
    }

    "/loyalty/score/back"(platform: "/mobile", type: TrackType.Event) {
    }

    //Loyalty Program User Tracking
    "/loyalty/user"(platform: "/", type: TrackType.Event) {
        in_loyalty_program(
                required: true,
                type: PropertyType.Boolean,
                description: "Indicates if the user is in or out of the loyalty program"
        )
    }

    "/loyalty/user/change_level"(platform: "/", type: TrackType.Event) {
        old_level(type: PropertyType.Numeric, required: true, description: "Indicates previews user level"
        )
    }


    "/loyalty/user/benefit"(platform: "/", type: TrackType.Event) {
        benefit(required: true, description: "Indicates which benefit was used")
        consumable(required: true,
                type: PropertyType.Boolean,
                description: "Indicates if the benefit is consumable"
        )
        reference(required: true, description: "Reference to the order")
    }

    "/loyalty/user/expire_points"(platform: "/", type: TrackType.Event) {
        expired_points(required: true, description: "Points expired")
        due_date(required: true, description: "Due date for expiration")
    }

    "/loyalty/user/float_notification"(platform: "/", type: TrackType.Event) {
        event_type(required: true, description: "Description of loyalty notification event")
        notification_ids(required: true, description: "List of notification ids")
    }

    "/loyalty/landing"(platform: "/", type: TrackType.Event) {
        landing_id(required: true, description: "id of landing")
    }

    "/loyalty/landing/aerolineas"(platform: "/", type: TrackType.Event) {
        destination_id(required: false, description: "id of the promoted destination")
    }

    "/loyalty/modal"(platform: "/mobile", type: TrackType.View) {
        event_type(required: true, values: ["SHOW", "delawed", "shown", "close", "dismiss", "received", "open"])
    }

    "/loyalty/discounts"(platform: "/", type: TrackType.View) {
        free_shipping(required: true, description: "Info about items at free shipping section")
        categories(required: true, description: "Info about the categories shown")
        official_stores(required: true, description: "What official stores are being shown")
    }

    "/loyalty/notification"(type: TrackType.Event) {
        event_type(required: true,
                values: ["received", "dismiss", "open", "shown", "delayed"],
                description: "Type of loyalty notification event")
    }

    "/loyalty/buylevel"(platform: "/", isAbstract: true, type: TrackType.View) {
    }

    "/loyalty/buylevel/landing"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/buylevel/checkout"(platform: "/", type: TrackType.Event) {
        action(required: true, values: ["started", "success", "success_orange", "rejected", "error"], description: "'started' when the CHO starts, success/success_orange/error is when the CHO finish")
        item_id(required: false, description: "If flow starts from vip || new_vip")
    }

    "/loyalty/buylevel/payment"(platform: "/", type: TrackType.Event) {
        payment(required: false, type: PropertyType.Numeric, description: "Payment ID Number")
        payment_status(required: false, description: "Payment status, like rejected/success/pending/etc...")
        payment_status_detail(required: false, description: "Payment status detail")
        item_id(required: false, description: "If flow starts from vip")
        our_payment_error(required: false, description: "An error from our (with our endpoint) payment post, is not an error creating the payment")
    }

    "/loyalty/buylevel/cancellation"(platform: "/", isAbstract: true, type: TrackType.View) {
    }

    "/loyalty/buylevel/cancellation/not-applicable"(platform: "/", type: TrackType.View) {
        reason(required: true, values: ["already_cancelled", "not_bought", "past_time"], description: "Reason to reject the cancellation")
    }

    "/loyalty/buylevel/cancellation/retention_landing"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/buylevel/cancellation/reason_form"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/buylevel/cancellation/congrats"(platform: "/", type: TrackType.View) {
        status(required: true, values: ["success", "needs_validation"], description: "Congrats status. Can be either success or 'needs-validation'")
    }

    "/loyalty/freetrial/cancellation"(platform: "/", isAbstract: true, type: TrackType.View){
    }

    "/loyalty/freetrial/cancellation/not-applicable"(platform: "/",type: TrackType.View){
        reason(required: true, values: ["already_cancelled","not_in_freetrial"], description: "Reason to reject the cancellation")
    }

    "/loyalty/freetrial/cancellation/retention_landing"(platform: "/",type: TrackType.View){
    }

    "/loyalty/freetrial/cancellation/reason_form"(platform: "/",type: TrackType.View){
    }

    "/loyalty/freetrial/cancellation/congrats"(platform: "/",type: TrackType.View){
    }

    /**
     * Loyalty Redesign Tracks
     */

    // Main Page

    "/loyalty/main"(platform: "/", type: TrackType.View) {}
    "/loyalty/main/activity"(platform: "/", type: TrackType.View) {}

    // Modals

    "/loyalty/main/modal"(platform: "/", type: TrackType.View) {
        type(required: true, description: "Indicates what kind of modal was opened", values: ["benefit", "milestone", "family_milestone", "benefits_per_level"])
        benefit_id(required: false, description: "Indicates the id of the benefit that corresponds to the modal")
        milestone_id(required: false, description: "Indicates the id of the milestone that corresponds to the modal")
        family_id(required: false, description: "Indicates the id of the milestone family that corresponds to the modal")
        from(required: false, description: "Indicates whether the modal was opened from the main page or the milestones page. Only sent for milestone modal", values: ["main", "milestones"])
    }

    "/loyalty/main/modal/action"(platform: "/", type: TrackType.Event) {
        type(required: true, description: "Indicates the kind of modal whose action was triggered", values: ["benefit", "milestone"])
        benefit_id(required: false, description: "Indicates the id of the benefit that corresponds to the modal")
        milestone_id(required: false, description: "Indicates the id of the milestone that corresponds to the modal")
    }
    
    // VIP Modal
    "/loyalty/vip"(platform: "/", isAbstract: true, type: TrackType.View) {}
    
    "/loyalty/vip/modal"(platform: "/", type: TrackType.View) {
        type(required: true, description: "Indicates what kind of modal was opened in VIP", values: ["buy_level", "free_trial"])
    }

    "/loyalty/vip/modal/action"(platform: "/", type: TrackType.Event) {
        type(required: true, description: "Indicates the kind of action that was triggered within the modal", values: ["buy_level", "free_trial", "item", "close"])
    }

    // Rewards

    "/loyalty/rewards"(platform: "/", type: TrackType.View) {}

    "/loyalty/rewards/activity"(platform: "/", type: TrackType.View) {}

    // Milestones Page

    "/loyalty/milestones"(platform: "/", type: TrackType.View) {}

    //Partners
    "/loyalty/subscribe"(platform: "/", type: TrackType.Event) {
        partner_id(required: true, description: "id of partner", type: PropertyType.String)
    }

    //Campaigns
    "/loyalty/campaign"(platform: "/", isAbstract: true, type: TrackType.Event) {
    }

    "/loyalty/campaign/email"(platform: "/", type: TrackType.Event) {
        action(required: true, description: "Action that we are tracking", type: PropertyType.String)
        mail_origin(required: false, description: "Level group that received the email", type: PropertyType.String)
        campaign_id(required: true, description: "Campaign id (number/string)", type: PropertyType.String)
    }

    "/loyalty/sellers"(platform: "/", isAbstract: true, type: TrackType.View) {}
    "/loyalty/sellers/discounts"(platform: "/", type: TrackType.View) {}

    //  --------------------------------------------- Free-Trials ---------------------------------------------

    "/loyalty/freetrial/"(platform: "/", isAbstract: true) {
        item_id(required: false, description: "If flow starts from vip || new_vip", type: PropertyType.String)
    }

    //  -----------------> Free Trial Landing
    "/loyalty/freetrial/landing"(platform: "/", type: TrackType.View) {
    }

    //  -----------------> Contention Screen

    "/loyalty/freetrial/contention"(platform: "/", type: TrackType.View) {
        from(required: false, values: ["primaryButton", "secondaryButton"])
    }

    "/loyalty/freetrial/contention/continue"(platform: "/", type: TrackType.Event) {
    }

    "/loyalty/freetrial/contention/cancel"(platform: "/", type: TrackType.Event) {
        type(required: true, values: ["button", "back", "close", "dismiss"], description: "Finish flow from button or X or back arrow or dismiss modal", type: PropertyType.String)
    }

    //  -----------------> Card Selection
    "/loyalty/freetrial/cardselection"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/freetrial/cardselection/selected"(platform: "/", type: TrackType.Event) {
        cardName(required: false, description: "Card selected", type: PropertyType.String)
        cardPosition(required: false, description: "Card selected", type: PropertyType.Numeric)
    }

    "/loyalty/freetrial/cardselection/continue"(platform: "/", type: TrackType.Event) {
    }

    "/loyalty/freetrial/cardselection/cancel"(platform: "/", type: TrackType.Event) {
        type(required: true, values: ["button", "back", "close", "dismiss"], description: "Finish flow from button or X or back arrow or dismiss modal", type: PropertyType.String)
    }

    // -----------------> Choose CVV
    "/loyalty/freetrial/cardselection/cvv"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/freetrial/cardselection/cvv/continue"(platform: "/", type: TrackType.Event) {
    }

    "/loyalty/freetrial/cardselection/cvv/cancel"(platform: "/", type: TrackType.Event) {
      type(required: true, values: ["button", "back", "close", "dismiss"], description: "Finish flow from button or X or back arrow or dismiss modal", type: PropertyType.String)
    }

    //  -----------------> New Card Screen/Modal
    "/loyalty/freetrial/newcard"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/freetrial/newcard/continue"(platform: "/", type: TrackType.Event) {
    }

    "/loyalty/freetrial/newcard/cancel"(platform: "/", type: TrackType.Event) {
        type(required: true, values: ["button", "back", "close", "dismiss"], description: "Finish flow from button or X or back arrow or dismiss modal", type: PropertyType.String)
    }

    "/loyalty/freetrial/newcard/cardnumber"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/freetrial/newcard/cardnumber/continue"(platform: "/", type: TrackType.Event) {
    }

    "/loyalty/freetrial/newcard/cardnumber/cancel"(platform: "/", type: TrackType.Event) {
        type(required: true, values: ["button", "back", "close", "dismiss"], description: "Finish flow from button or X or back arrow or dismiss modal", type: PropertyType.String)
    }

    "/loyalty/freetrial/newcard/securitycode"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/freetrial/newcard/securitycode/continue"(platform: "/", type: TrackType.Event) {
    }

    "/loyalty/freetrial/newcard/securitycode/cancel"(platform: "/", type: TrackType.Event) {
        type(required: true, values: ["button", "back", "close", "dismiss"], description: "Finish flow from button or X or back arrow or dismiss modal", type: PropertyType.String)
    }

    "/loyalty/freetrial/newcard/name"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/freetrial/newcard/name/continue"(platform: "/", type: TrackType.Event) {
    }

    "/loyalty/freetrial/newcard/name/cancel"(platform: "/", type: TrackType.Event) {
        type(required: true, values: ["button", "back", "close", "dismiss"], description: "Finish flow from button or X or back arrow or dismiss modal", type: PropertyType.String)
    }

    "/loyalty/freetrial/newcard/identification"(platform: "/", type: TrackType.View) {
    }

    "/loyalty/freetrial/newcard/identification/continue"(platform: "/", type: TrackType.Event) {
    }

    "/loyalty/freetrial/newcard/identification/cancel"(platform: "/", type: TrackType.Event) {
        type(required: true, values: ["button", "back", "close", "dismiss"], description: "Finish flow from button or X or back arrow or dismiss modal", type: PropertyType.String)
    }

    //  -----------------> Congrats Screen
    "/loyalty/freetrial/congrats"(platform: "/", type: TrackType.View) {
        congratstype(required: true, values: ["success", "error", "warning"], description: "Congrats type", type: PropertyType.String)
    }

    "/loyalty/freetrial/congrats/continue"(platform: "/", type: TrackType.Event) {
        congratstype(required: true, values: ["success", "error", "warning"], description: "Congrats type", type: PropertyType.String)
    }

    "/loyalty/freetrial/congrats/cancel"(platform: "/", type: TrackType.Event) {
        congratstype(required: true, values: ["success", "error", "warning"], description: "Congrats type", type: PropertyType.String)
    }

    //  -----------------> Confirm Screen
    "/loyalty/freetrial/confirm"(platform: "/mobile", type: TrackType.View) {
    }

    "/loyalty/freetrial/confirm/continue"(platform: "/mobile", type: TrackType.Event) {
    }

    "/loyalty/freetrial/confirm/cancel"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, values: ["button", "back", "close", "dismiss"], description: "Finish flow from button or X or back arrow or dismiss modal", type: PropertyType.String)
    }

    //  -----------------> Payment Track
    "/loyalty/freetrial/payment"(platform: "/", type: TrackType.Event) {
        payment(required: true, type: PropertyType.Numeric, description: "Payment ID Number")
        payment_status(required: true, description: "Payment status, like rejected/success/pending/etc...")
        payment_status_detail(required: true, description: "Payment status detail")
    }

    "/loyalty/freetrial/payment/error"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        our_payment_error(required: true, description: "An error from our (with our endpoint) payment post, is not an error creating the payment")
        item_id(required: false, description: "If flow starts from vip || new_vip", type: PropertyType.String)
    }

    "/loyalty/main/partners_landing"(platform: "/", type: TrackType.Event) {
        original_place(required: true, values: ["keep","move"], description: "From where the partners landing was accesed", type: PropertyType.String)
    }

    // Loyalty v2 pageviews
    "/loyalty/hub"(platform: "/", type: TrackType.View) {}
    "/loyalty/hub/skeleton"(platform: "/", type: TrackType.View) {}
    "/loyalty/status"(platform: "/", type: TrackType.View) {}
    "/loyalty/status/skeleton"(platform: "/", type: TrackType.View) {}
    "/loyalty/milestones_v2"(platform: "/", type: TrackType.View) {}
    "/loyalty/milestone_v2"(platform: "/", type: TrackType.View) {
        milestone_id(required: true, description: "id of the milestone", type: PropertyType.String)
        is_accomplished(required: true, descripcion: "wheter the milestone is already accomplish or not", type: PropertyType.Boolean)
    }

    // Loyalty v2 events
    "/loyalty/message_close"(platform: "/", type: TrackType.Event) {
        id(required: true, description: "id the message closed by the user", type: PropertyType.String, values: ["points-expiration-tooltip", "push-level-up-tooltip", "info-tooltip", "info-tooltip-blue", "status-info-tooltip", "onboarding"])
    }

    "/loyalty/onboarding"(platform: "/", isAbstract: true) {
        step(required: true, description: "type of the element that the onboarding is showing", type: PropertyType.String)
    }

    "/loyalty/onboarding/open"(platform: "/", type: TrackType.Event) {}
    "/loyalty/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/loyalty/onboarding/previous"(platform: "/", type: TrackType.Event) {}
    "/loyalty/onboarding/close"(platform: "/", type: TrackType.Event) {}


    "/loyalty/card"(platform: "/", isAbstract: true) {
        page(required: true, description: "On which page does the event takes place", type: PropertyType.String, values: ["hub", "status"])
        type(required: true, description: "type of the card where the event is taking place", type: PropertyType.String)
        position(required: true, descripcion: "Position of the card in the page where the event is taking place", type: PropertyType.Numeric)
    }

    "/loyalty/card/item_action"(platform: "/", type: TrackType.Event) {
        id(required: true, description: "id of the sub component where the event is taking place", type: PropertyType.String)
        item_position(required: true, description: "position of the action where the event is taking place", type: PropertyType.Numeric)
    }

    "/loyalty/card/action"(platform: "/", type: TrackType.Event) {}

    "/loyalty/card/download"(platform: "/", type: TrackType.Event) {}
    "/loyalty/card/update"(platform: "/", type: TrackType.Event) {}

    "/loyalty/card/benefits_swipe"(platform: "/", type: TrackType.Event) {
        card_level(required: true, description: "position of the action where the event is taking place", type: PropertyType.Numeric)
    }

    "/loyalty/milestone_v2/action"(platform: "/", type: TrackType.Event) {}

}
