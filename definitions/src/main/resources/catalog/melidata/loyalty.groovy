import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Loyalty

    "/loyalty"(platform: "/", isAbstract: true) {
        level(type: PropertyType.Numeric, required: false)
        points(type: PropertyType.Numeric, required: false)
        percentage(type: PropertyType.Numeric, required: false)
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
        notification_ids(required: true, description: "List of notification ids" )
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

    "/loyalty/buylevel"(platform: "/", isAbstract: true,type: TrackType.View){
    }

    "/loyalty/buylevel/landing"(platform: "/",type: TrackType.View){
        origin(required: false, values: ["marketplace","loyalty_frontend","push","aerolineas"],description: "Where the user came from.")
    }

    "/loyalty/buylevel/checkout"(platform: "/",type: TrackType.Event){
        action(required: true, values: ["started","success","success_orange","rejected","error"], description: "'started' when the CHO starts, success/success_orange/error is when the CHO finish")
        origin(required: false, values: ["mail","vip","marketplace","loyalty_frontend","new_vip","landing","aerolineas"],description: "Where was the checkout was initiated from.")
        item_id(required: false, description: "If flow starts from vip || new_vip")     
    }

    "/loyalty/buylevel/payment"(platform: "/",type: TrackType.Event){
        payment(required: false, type: PropertyType.Numeric, description: "Payment ID Number")
        payment_status(required: false, description: "Payment status, like rejected/success/pending/etc...")
        payment_status_detail(required: false, description: "Payment status detail")
        item_id(required: false, description: "If flow starts from vip")
        our_payment_error(required: false, description: "An error from our (with our endpoint) payment post, is not an error creating the payment")
    }

    "/loyalty/buylevel/cancellation"(platform: "/", isAbstract: true, type: TrackType.View){
    }

    "/loyalty/buylevel/cancellation/not-applicable"(platform: "/",type: TrackType.View){
        reason(required: true, values: ["already_cancelled","not_bought","past_time"], description: "Reason to reject the cancellation")
    }

    "/loyalty/buylevel/cancellation/retention_landing"(platform: "/",type: TrackType.View){
    }

    "/loyalty/buylevel/cancellation/reason_form"(platform: "/",type: TrackType.View){
    }

    "/loyalty/buylevel/cancellation/congrats"(platform: "/",type: TrackType.View){
        status(required: true, values: ["success","needs_validation"], description: "Congrats status. Can be either success or 'needs-validation'")
    }

    /**
     * Loyalty Redesign Tracks
     */

    // Main Page

    "/loyalty/main"(platform: "/", type: TrackType.View) {}
    "/loyalty/main/activity"(platform: "/", type: TrackType.View) {}

    // Modals

    "/loyalty/main/modal"(platform: "/", type: TrackType.View) {
        type(required: true, description: "Indicates what kind of modal was opened", values: ["benefit", "milestone", "benefits_per_level"])
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

    // Rewards

    "/loyalty/rewards"(platform: "/", type: TrackType.View) {}

    "/loyalty/rewards/activity"(platform: "/", type: TrackType.View) {}

    // Milestones Page

    "/loyalty/milestones"(platform: "/", type: TrackType.View) {}

    //Partners
    "/loyalty/subscribe"(platform: "/", type: TrackType.Event) {
        partner_id(required: true, description: "id of partner",type: PropertyType.String)
    }

    //Campaigns
    "/loyalty/campaign"(platform: "/", isAbstract: true,type: TrackType.Event){
    }

    "/loyalty/campaign/email"(platform: "/", type: TrackType.Event) {
        action(required: true, description: "Action that we are tracking", type: PropertyType.String)
        mail_origin(required: false, description: "Level group that received the email", type: PropertyType.String)
        campaign_id(required: true, description: "Campaign id (number/string)", type: PropertyType.String)
    }

    "/loyalty/sellers"(platform: "/", isAbstract: true, type: TrackType.View){}
    "/loyalty/sellers/discounts"(platform: "/", type: TrackType.View){}
}
