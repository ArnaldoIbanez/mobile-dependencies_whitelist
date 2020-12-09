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

    /*************************
     * MGM PAYER TRACKS v2  *
     *************************/

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

    /*************************
     * MGM SELLER TRACKS *
     *************************/

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

    /*************************
     * MGM PAYER TRACKS v3  *
     *************************/

    propertyDefinitions {
        program_id(required: true, type: PropertyType.String, description: "Indicates the id of the member get member program.")
        is_recurrent(required: true, type: PropertyType.Boolean, description: "Indicates if the promoter invited more than one user.")
        from(required: false, type: PropertyType.String, description: "Text to identify multiple sources to access the same program.")
    }

    propertyGroups {
        mgmPromoterMinimumFields(
            program_id, is_recurrent, from
        )
        mgmGuestMinimumFields(
            program_id, from
        )
    }

    def item_section_definition = objectSchemaDefinitions {
        order(type: PropertyType.Numeric, required: true, description: "Indicates the order to display the section.")
        section_id(type: PropertyType.String, required: true, description: "Indicates the id of the section.")
    }

    // General Path
    "/mgm/v3"(platform: "/", isAbstract: true) {}

    "/mgm/v3/promoter"(platform: "/mobile", type: TrackType.View) {
        mgmPromoterMinimumFields
        floating_banner_id(required: false, type: PropertyType.String, description: "Indicates the id of the floating banner.")
        sections(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_section_definition)), description: "Indicates the sections of the view.")
    }

    "/mgm/v3/promoter/share"(platform: "/mobile", parentPropertiesInherited: false, isAbstract: true) {}

    "/mgm/v3/promoter/share/tap"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mgmPromoterMinimumFields
        action_id(required: true, type: PropertyType.String, description: "Indicates the id of the action (ex: whatsapp).")
        shared_app_id(required: false, type: PropertyType.String, description: "Indicates in which channel did the user shared the coupon (ex: Slack).")
    }

    "/mgm/v3/promoter/share/terms"(platform: "/mobile", parentPropertiesInherited: false, isAbstract: true) {}

    "/mgm/v3/promoter/share/terms/tap"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mgmPromoterMinimumFields
    }

    "/mgm/v3/promoter/banner"(platform: "/mobile", parentPropertiesInherited: false, isAbstract: true) {}

    "/mgm/v3/promoter/banner/tap"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mgmPromoterMinimumFields
        target_program(required: true, type: PropertyType.String, description: "Indicates the target of the program (ex: MGM Point).")
    }

    "/mgm/v3/promoter/floating_banner"(platform: "/mobile", parentPropertiesInherited: false, isAbstract: true) {}

    "/mgm/v3/promoter/floating_banner/dismiss"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mgmPromoterMinimumFields
        banner_id(required: true, type: PropertyType.String, description: "Indicates the id of the banner.")
    }

    "/mgm/v3/guest"(platform: "/mobile", type: TrackType.View) {
        mgmGuestMinimumFields
        sections(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_section_definition)), description: "Indicates the sections of the view.")
    }

    "/mgm/v3/guest/cross_selling"(platform: "/mobile", parentPropertiesInherited: false, isAbstract: true) {}

    "/mgm/v3/guest/cross_selling/tap"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mgmGuestMinimumFields
        action_id(required: true, type: PropertyType.String, description: "Indicates the id of the action.")
    }

    "/mgm/v3/guest/main_action"(platform: "/mobile", parentPropertiesInherited: false, isAbstract: true) {}

    "/mgm/v3/guest/main_action/tap"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mgmGuestMinimumFields
        action_id(required: true, type: PropertyType.String, description: "Indicates the id of the action (ex: cellphone_recharge).")
    }

    "/mgm/v3/guest/floating_banner"(platform: "/mobile", parentPropertiesInherited: false, isAbstract: true) {}

    "/mgm/v3/guest/floating_banner/terms"(platform: "/mobile", parentPropertiesInherited: false, isAbstract: true) {}

    "/mgm/v3/guest/floating_banner/terms/tap"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        mgmGuestMinimumFields
    }

    "/mgm/v3/error"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        program_id(required: true, type: PropertyType.String, description: "Indicates the id of the member get member program.")
        reason(required:true, type: PropertyType.String, description: "Indicates the reason of the error", values: ["kyc_guest", "kyc_booster", "kyc_fraud", "discount_used", "scarcity_overcome", "wrong_site"])
    }

    "/mgm/v3/error/dismiss"(platform: "/mobile", type: TrackType.Event) {}

    "/mgm/v3/error/tap"(platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Link to where the app was navigating to.")
    }

}
