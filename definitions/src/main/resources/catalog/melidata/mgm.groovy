import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
     * MGM Screen Tracks
     */

    // General Path
    "/mgm"(platform: "/", isAbstract: true) {}
    "/mgm/payers"(platform: "/", isAbstract: true) {}

    // MOBILE
    // Invite Screen
    "/mgm/payers/invite"(platform: "/mobile", type: TrackType.View) {}

    // Invite Screen Events
    "/mgm/payers/invite/invite"(platform: "/mobile", type: TrackType.Event) {
        media (required:false, type: PropertyType.String, description: "In which channel did the user shared the coupon (ex: Whatsapp)")
    }
    "/mgm/payers/invite/back"(platform: "/mobile", type: TrackType.Event) {}
    "/mgm/payers/invite/terms"(platform: "/mobile", type: TrackType.Event) {}

    // Redeem Screen
    "/mgm/payers/redeem"(platform: "/mobile", type: TrackType.View) {}
    "/mgm/payers/invite/option"(platform: "/mobile", type: TrackType.Event) {
        option (required:true, type: PropertyType.String, description: "Which option did the user selected (ex: cellphone_recharge)")
    }
    "/mgm/payers/invite/terms"(platform: "/mobile", type: TrackType.Event) {}

    // No Redeem Screen
    "/mgm/payers/no_redeem"(platform: "/mobile", type: TrackType.View) {}

    // No Redeem Screen Events
    "/mgm/payers/no_redeem/invite"(platform: "/mobile", type: TrackType.Event) {
        media (required:false, type: PropertyType.String, description: "In which channel did the user shared the coupon (ex: Whatsapp)")
    }
    "/mgm/payers/no_redeem/back"(platform: "/mobile", type: TrackType.Event) {}
    "/mgm/payers/no_redeem/terms"(platform: "/mobile", type: TrackType.Event) {}

    // WEB
    "/mgm/payers/stop_landing"(platform: "/web", type: TrackType.View) {
        type (required:true, type: PropertyType.String, description: "Which landing are we tracking (ex: invite / use_coupon)")
    }
    "/mgm/payers/redirect"(platform: "/web", type: TrackType.Event) {
        platform (required:true, type: PropertyType.String, description: "The platform where we are redirecting the user (ex: Mercadolibre / Mercadopago)")
    }
}
