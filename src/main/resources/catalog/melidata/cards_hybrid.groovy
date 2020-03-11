import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1048"

    //-----------------
    // HYBRID
    //-----------------

    //Abstract Path
    "/cards"(platform: "/", isAbstract: true) { }
    "/cards/hybrid"(platform: "/", isAbstract: true) { }

    // SHIPPING
    // --------
    "/cards/hybrid/shipping"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/shipping/tracking"(platform: "/", isAbstract: true) { }

    //Shipping: Tracking
    "/cards/hybrid/shipping/tracking"(platform: "/", type: TrackType.View) {
        banner_is_present (required:true, type: PropertyType.Boolean, description: "Banner is present in Screen", inheritable:false)
        contact_is_present (required:true, type: PropertyType.Boolean, description: "Contact is present in Screen", inheritable:false)
    }
    "/cards/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["back", "contact", "help", "banner_unlock"],
            description: "Action tapped"
        )
    }
    "/cards/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
        component_id (required:true, type: PropertyType.String, description: "Component shown")
    }

    // UNLOCK
    // --------
    "/cards/hybrid/unlock"(platform: "/", isAbstract: true) { }

    // Unlock: Init Point
    "/cards/hybrid/unlock/init-point"(platform: "/", type: TrackType.View) {}

    // Unlock: Scanner
    "/cards/hybrid/unlock/scanner"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/unlock/scanner/link"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["qr", "manual"],
            description: "Link method used"
        )
    }
    "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["initializing", "scanning", "resolving", "failed"],
            description: "Scanner state"
        )
    }

    // Unlock: Manual Link
    "/cards/hybrid/unlock/manual-link"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/unlock/manual-link/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["link"],
            description: "Manual link method selected"
        )
    }

    // Unlock: Confirm Link
    "/cards/hybrid/unlock/confirm-link"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/unlock/confirm-link/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["confirm", "logout"],
            description: "Action tapped"
        )
    }

    // Unlock: Camera Permissions
    "/cards/hybrid/unlock/camera-permissions"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/unlock/camera-permissions/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["qr", "manual"],
            description: "Link method selected"
        )
    }

    // Unlock: Confirm Replacement
    "/cards/hybrid/unlock/confirm-replacement"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/unlock/confirm-replacement/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["confirm", "exit"],
            description: "Action tapped"
        )
    }

    // Unlock: Set Pin
    "/cards/hybrid/unlock/set-pin"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/unlock/set-pin/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["confirm"],
            description: "Pin confirmed"
        )
    }


    // Unlock: Update App
    "/cards/hybrid/unlock/update-app"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["exit", "update"],
            description: "Action tapped"
          )
    }
    
    
    // DASHBOARD
    // --------
     "/cards/hybrid/dashboard"(platform: "/", type: TrackType.View) {}
    
    //MiniCard: Tracking
    "/cards/hybrid/dashboard/mini_card"(platform: "/", type: TrackType.View) {
        status (required:true, type: PropertyType.String, description: "Status of mini card", inheritable:false)
    }
    "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["virtual_only", "user_need_challenge", "tracking_init", "tracking_on_the_way", "tracking_next_to_arrive", "physical_ready_for_unlocking", "debit_active", "physical_inactive"],
            description: "Mini card tapped"
          )
    }
    
    //Flap: Tracking
    "/cards/hybrid/dashboard/flap"(platform: "/", type: TrackType.View) {
        status (required:true, type: PropertyType.String, description: "Status of flap card", inheritable:false)
    }
    "/cards/hybrid/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["virtual_only", "user_need_challenge", "tracking_init", "tracking_on_the_way", "tracking_next_to_arrive", "physical_ready_for_unlocking", "debit_active", "physical_inactive"],
            description: "Flap tapped"
          )
    }
    
    //Activities: Tracking
    "/cards/hybrid/dashboard/activities"(platform: "/", type: TrackType.View) {}
    
    //Account Options: Tracking
    "/cards/hybrid/dashboard/account_options"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/dashboard/account_options"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in", "account_info_modal"],
            description: "Account info tapped"
          )
    }
    
    //Carousel: Tracking
    "/cards/hybrid/dashboard/carousel"(platform: "/", type: TrackType.View) {}
    
    //Linear buttons: Tracking
    "/cards/hybrid/dashboard/linear_buttons"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/dashboard/linear_buttons"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["help", "call", "block"],
            description: "Linear button tapped"
          )
    }
    
    //Linear buttons: Tracking
    "/cards/hybrid/dashboard/message"(platform: "/", type: TrackType.View) {
        type (required:true, type: PropertyType.String, description: "Type of message", inheritable:false)
    }
    "/cards/hybrid/dashboard/message"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["change_pin"],
            description: "Message button tapped"
          )
    }
    
    //Account info: Tracking
    "/cards/hybrid/dashboard/account_info"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/dashboard/account_info"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in"],
            description: "Footer button tapped"
          )
    }
}
