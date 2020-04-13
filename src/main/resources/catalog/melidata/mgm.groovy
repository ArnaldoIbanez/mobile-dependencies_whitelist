package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    //MGM Navigation (Android Drawer or iOS Settings)
    def realestate = objectSchemaDefinitions {
        realestate_id(type: PropertyType.String, required: true, description: "The container where we show contents")
        content_id(type: PropertyType.String, required: true, description: "The identification of shown content")
        origin(type: PropertyType.String, required: false, description: "The application that returns the content")
    }

    initiative = '1176'

    /**
     * MGM Screen Tracks
     */

    // General Path
    "/mgm"(platform: "/", isAbstract: true) {}


    "/mgm/navigation"(platform: "/mobile", type: TrackType.Event,  initiative: "1059") {
        realestates(required: false, type: PropertyType.ArrayList(PropertyType.Map(realestate)), description: "The realestate information")
    }

    "/mgm/payers"(platform: "/", isAbstract: true) {}

    // MOBILE
    // Access MGM flow
    "/mgm/payers/init"(platform: "/mobile", type: TrackType.Event) {
        origin (required:true, type: PropertyType.String, description: "What is the origin of the flow (ex: row / shortcut / drawer)", values: ["row", "shortcut", "drawer"])
    }

    // Invite Screen
    "/mgm/payers/invite"(platform: "/mobile", type: TrackType.View) {
        promoter (required:true, type: PropertyType.String, description: "Indicates the id of the inviter/promoter")
    }

    // Invite Screen Events
    "/mgm/payers/invite/invite"(platform: "/mobile", type: TrackType.Event) {
        media (required:false, type: PropertyType.String, description: "In which channel did the user shared the coupon (ex: Whatsapp)")
    }
    "/mgm/payers/invite/back"(platform: "/mobile", type: TrackType.Event) {}
    "/mgm/payers/invite/terms"(platform: "/mobile", type: TrackType.Event) {}

    // Redeem Screen
    "/mgm/payers/redeem"(platform: "/mobile", type: TrackType.View) {
        promoter (required:true, type: PropertyType.String, description: "Indicates the id of the inviter/promoter")
    }
    "/mgm/payers/redeem/option"(platform: "/mobile", type: TrackType.Event) {
        option (required:true, type: PropertyType.String, description: "Which option did the user selected (ex: cellphone_recharge)")
        type (required:true, type: PropertyType.String, description: "Which action are we tracking (ex: install / use_coupon)", values: ["install", "use_coupon"])
    }
    "/mgm/payers/redeem/terms"(platform: "/mobile", type: TrackType.Event) {}

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
        promoter (required:false, type: PropertyType.String, description: "Indicates the id of the inviter/promoter")
    }
    "/mgm/payers/stop_landing/redirect"(platform: "/web", type: TrackType.Event) {}

    // MGM Seller Mobile
    "/mgm_seller" (platform: "/mobile", isAbstract: true) {}

    // Views
    "/mgm_seller/referal" (platform: "/mobile", type: TrackType.View) {}
    "/mgm_seller/dashboard" (platform: "/mobile", type: TrackType.View) {}
    
    // Events
    "/mgm_seller/referal/tap" (platform: "/mobile", type: TrackType.Event) {
        media(required: false, type: PropertyType.String, description: "media to share the content")
        device(required: false, type: PropertyType.String, description: "Device to share")
        link(required: false, type: PropertyType.String, description: "link to screen")
    }
    "/mgm_seller/referal/swipe" (platform: "/mobile", type: TrackType.Event) {}

}
