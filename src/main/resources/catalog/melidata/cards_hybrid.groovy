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
    "/cards/acquisition"(platform: "/", isAbstract: true) { }

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

    // Generic Webview
    // ------

    "/cards/acquisition/webview"(platform: "/", type: TrackType.View) {
        url (
            required: true,
            type: PropertyType.String,
            description: "Url to should loaded",
            inheritable:false
        )
        flow (
            required: true,
            type: PropertyType.String,
            description: "flow from where its started"
        )
    }
    "/cards/acquisition/webview/external_url"(platform:"/", type: TrackType.Event) { }
    "/cards/acquisition/webview/navigate"(platform:"/", type: TrackType.Event) {
        url (
            required: true,
            type: PropertyType.String,
            description: "Url to should loaded"
        )
     }
    "/cards/acquisition/webview/close"(platform:"/", type: TrackType.Event) { }

    // Congrats
    // ------

    "/cards/acquisition/congrats" (platform: "/", type: TrackType.View) {
        type (
            required: true,
            type: PropertyType.String,
            description: "Type of Congrats"
        )
    }
    "/cards/acquisition/congrats/tap" (platform: "/", type: TrackType.Event) {
        url (
            required: true,
            type: PropertyType.String,
            description: "Url button tapped",
            inheritable:false
        )
    }
    "/cards/acquisition/congrats/error" (platform: "/", type: TrackType.Event) {
        status (
            required: true,
            type: PropertyType.String,
            description: "Error Code",
            inheritable:false
        )
    }
    
    // DASHBOARD
    // --------
     "/cards/hybrid/dashboard"(platform: "/", type: TrackType.View) {
         dashboard_status (required:true, type: PropertyType.String, description: "Current sections", inheritable:false)
         minicard_status (required:false, type: PropertyType.String, description: "Mini card status", inheritable:false)
         flap_status (required:false, type: PropertyType.String, description: "Flap status", inheritable:false)
         message_status (required:false, type: PropertyType.String, description: "Message status", inheritable:false)
         activities_status (required:false, type: PropertyType.String, description: "Activities status", inheritable:false)
     }
    
    //MiniCard: Tracking
    "/cards/hybrid/dashboard/mini_card"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["virtual_only", "user_need_challenge", "tracking_init", "tracking_on_the_way", "tracking_next_to_arrive", "physical_ready_for_unlocking", "debit_active", "physical_inactive", "hybrid_active", "tracking_not_delivered"],
            description: "Mini card tapped"
          )
    }
    
    //Flap: Tracking
    "/cards/hybrid/dashboard/flap"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["more_than_one_virtual_active", "virtual_active", "virtual_inactive", "never_had_virtual_card"],
            description: "Flap tapped"
          )
    }
    
    //Account Options: Tracking
    "/cards/hybrid/dashboard/account_options"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/account_options/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in", "account_info_modal"],
            description: "Account info tapped"
          )
    }
    
    //Linear buttons: Tracking
    "/cards/hybrid/dashboard/linear_buttons"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["help", "call", "block"],
            description: "Linear button tapped"
          )
    }
    
    //Linear buttons: Tracking
    "/cards/hybrid/dashboard/message"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/message/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["blocked_pin"],
            description: "Message button tapped"
          )
    }
    
    //Account info: Tracking
    "/cards/hybrid/dashboard/account_info"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/dashboard/account_info/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in"],
            description: "Footer button tapped"
          )
    }

    // SETUP VIRTUAL
    // --------

    //Card
    "/cards/hybrid/setup"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/setup/virtual"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable:false
        )
        initial_status (
            required: true,
            type: PropertyType.String,
            values: ["deprecated", "new", "on_creation", "on_delivery", "delivered", "active", "freeze", "blocked", "inactive"],
            description: "Card initial status",
            inheritable:false
        )
        has_money (
            required: true,
            type: PropertyType.Boolean,
            description: "Indicate whether the user has money",
            inheritable:false
        )
    }
    "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["reissue", "freeze", "unfreeze", "card-unfreeze", "copy"],
            description: "The action type tapped"
        )
    }

    //Redirect when the user don't have a virtual card
    "/cards/hybrid/setup/virtual/redirect"(platform:"/", type: TrackType.Event) {}

    //Account options
    "/cards/hybrid/setup/virtual/account_options"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/setup/virtual/account_options/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["account_info_modal", "money_in"],
            description: "The action type tapped"
        )
    }

    //Account Info
    "/cards/hybrid/setup/virtual/account_info"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/setup/virtual/account_info/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in"],
            description: "The action type tapped"
        )
    }

    // REISSUE VIRTUAL
    // --------

    "/cards/hybrid/block-card"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/block-card/virtual"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id"
        )
    }
    "/cards/hybrid/block-card/virtual/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["primary-button", "secondary-button"],
            description: "The action type tapped"
        )
    }

    // SETUP FÍSICA
    // --------
    "/cards/hybrid/setup/physical"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable:false
        )
        initial_status (
            required: true,
            type: PropertyType.String,
            values: ["active", "freeze", "pin_blocked"],
            description: "Card initial status",
            inheritable:false
        )
    }
    "/cards/hybrid/setup/physical/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["reissue", "freeze", "unfreeze", "card-change_pin", "change_limits"],
            description: "The action type tapped"
        )
    }
}
