import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks


tracks {

    initiative = "1048"

    //-----------------
    // HYBRID
    //-----------------

    //Abstract Path
    "/cards"(platform: "/", isAbstract: true) {
        from (required: false, type: PropertyType.String, description: "Context from where its started")
     }
    "/cards/hybrid"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/coachmark"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/request"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/request/virtual"(platform: "/", isAbstract: true) { }
    "/cards/acquisition"(platform: "/", isAbstract: true) { }
    "/cards/engagement"(platform: "/", isAbstract: true) { }
    "/cards/mp-card"(platform: "/", isAbstract: true) { }
    "/cards/mp-card/hybrid"(platform: "/", isAbstract: true) { }



    // SHIPPING
    // --------
    "/cards/hybrid/shipping"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/shipping/tracking"(platform: "/", isAbstract: true) { }

    //Shipping: Tracking
    "/cards/hybrid/shipping/tracking"(platform: "/", type: TrackType.View) {
        unlock_banner_is_present (required:true, type: PropertyType.Boolean, description: "Unlock Banner is present in Screen", inheritable:false)
        setup_virtual_banner_is_present (required:true, type: PropertyType.Boolean, description: "Setup Virtual Banner is present in Screen", inheritable:false)
        contact_is_present (required:true, type: PropertyType.Boolean, description: "Contact is present in Screen", inheritable:false)
    }
    "/cards/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["back", "contact", "help", "banner_unlock", "banner_setup_virtual"],
            description: "Action tapped"
        )
    }
    "/cards/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
        component_id (required:true, type: PropertyType.String, description: "Component shown")
    }

    //Shipping: Delayed
    "/cards/hybrid/shipping/delayed"(platform: "/", type: TrackType.View) {
        context (
            required: true,
            type: PropertyType.String,
            values: ["delayed", "stolen", "not_delivered_not_withdrawn_by_user", "not_delivery"],
            description: "Action tapped",
            inheritable:false
        )
    }
    "/cards/hybrid/shipping/delayed/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["exit", "reissue"],
            description: "Action tapped"
        )
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

    "/cards/hybrid/unlock/scanner/help"(platform: "/", type: TrackType.Event) {}

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

    "/cards/hybrid/unlock/manual-link/invalid_code"(platform: "/", type: TrackType.Event) {}

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

    "/cards/hybrid/unlock/set-pin/invalide_pin"(platform: "/", type: TrackType.Event) {}

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

    // Unlock: Success
    "/cards/hybrid/unlock/success"(platform: "/", type: TrackType.Event) {}

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

    // Acquisition Error
    // --------
    "/cards/acquisition/error"(platform: "/", type: TrackType.View) {
        screen (required: true, type: PropertyType.String, description: "The screen that showed error")
    }

    // Dashboard Error
    // --------
    "/cards/engagement/error"(platform: "/", type: TrackType.View) {
        screen (required: true, type: PropertyType.String, description: "The screen that showed error")
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
    
    "/cards/hybrid/dashboard/virtual"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/virtual/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["header_help"],
            description: "Header help tapped"
          )
    }
    "/cards/hybrid/dashboard/physical"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/physical/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["header_help"],
            description: "Header help tapped"
          )
    }
    
    //MiniCard: Tracking
    "/cards/hybrid/dashboard/mini_card"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["physical_delivered", "hybrid_active", "debit_active", "physical_inactive", "user_need_challenge", "virtual_only", "tracking_pending", "tracking_ready_to_ship", "tracking_not_delivered", "tracking_soon_deliver", "tracking_delayed", "tracking_waiting_for_withdrawal", "tracking_shipped"],
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

    //Carousel: Tracking
    "/cards/hybrid/dashboard/carousel"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["page_0", "page_1", "page_2", "page_3", "page_4"],
            description: "Carousel item tapped"
          )
    }
    "/cards/hybrid/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["page_0", "page_1", "page_2", "page_3", "page_4"],
            description: "Carousel item swiped"
          )
    }
    
    //Feedback: Tracking
    "/cards/hybrid/dashboard/feedback"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/feedback/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["research_form"],
            description: "Feedback action tapped"
          )
    }

    //Coachmark banner
    "/cards/hybrid/dashboard/coachmark_banner"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "tap"],
            description: "Kind of tap on the banner"
        )
        id (
            required: true,
            type: PropertyType.String,
            description: "coachmark identificator"
        )
     }

    //Map Info: Tracking
    "/cards/hybrid/dashboard/map_info"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/map_info/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["map_info"],
            description: "Map info tapped"
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
            values: ["reissue", "freeze", "unfreeze", "card_unfreeze", "copy", "header_help", "card_name_copy", "card_number_copy", "card_sec_code_copy"],
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

    //Feedback: Tracking
    "/cards/hybrid/setup/virtual/feedback"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/setup/virtual/feedback/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["research_form"],
            description: "Feedback action tapped"
          )
    }

    //Static Banner: Tracking
    "/cards/hybrid/setup/virtual/static_banner"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/setup/virtual/static_banner/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in"],
            description: "Static banner tapped"
          )
    }
    
    // REISSUE VIRTUAL
    // --------

    "/cards/hybrid/block_card"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/block_card/virtual"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id"
        )
    }
    "/cards/hybrid/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["primary_button", "secondary_button"],
            description: "The action type tapped"
        )
    }

    "/cards/hybrid/block_card/virtual/success"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    // REISSUE PHYSICAL
    // --------

    "/cards/hybrid/block_card/physical"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id"
        )
    }
    "/cards/hybrid/block_card/physical/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["primary_button", "secondary_button"],
            description: "The action type tapped"
        )
    }

    "/cards/hybrid/block_card/physical/success"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

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
            values: ["reissue", "freeze", "unfreeze", "change_pin", "change_limits", "header_help"],
            description: "The action type tapped"
        )
    }
    
    //Feedback: Tracking
    "/cards/hybrid/setup/physical/feedback"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/setup/physical/feedback/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["research_form"],
            description: "Feedback action tapped"
          )
    }
    
    // CHANGE-PIN
    // --------
    "/cards/hybrid/change_pin"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/change_pin/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["change_pin"],
            description: "Change pin button tapped"
          )
    }
    "/cards/hybrid/change_pin/congrats"(platform: "/", type: TrackType.View) {}
    
    // LIMITS
    // --------
    "/cards/hybrid/limits_setup"(platform: "/", type: TrackType.View) {
        limits_status (required:true, type: PropertyType.String, description: "Current sections", inheritable:false)
    }
    "/cards/hybrid/limits_setup/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["header_help"],
            description: "Header action tapped"
          )
    }
    
    //Number Selector
    "/cards/hybrid/limits_setup/number_selector"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/limits_setup/number_selector/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["modal"],
            description: "Button tapped"
        )
    }
    
    //Number selector modal
    "/cards/hybrid/limits_setup/number_selector_modal"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/limits_setup/number_selector_modal/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["cancel", "save"],
            description: "Button tapped"
        )
    }

    //Map Info: Tracking
    "/cards/hybrid/limits_setup/map_info"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/limits_setup/map_info/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["map_info"],
            description: "Map info tapped"
          )
    }

    // Request

    // Request: Onboarding
    "/cards/hybrid/request/physical"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/request/physical/onboarding"(platform: "/", type: TrackType.View) {
        context (
            required: true,
            type: PropertyType.String,
            values: ["no_kyc_no_challlenge", "kyc_challenge", "no_kyc_challenge", "kyc_no_challenge", 
                    "prepaid_reparking_challenge", "prepaid_reparking_no_challenge",
                    "seller_kyc_challenge", "seller_kyc_no_challenge", "seller_no_kyc_challenge", "seller_no_kyc_no_challlenge"],
            description: "type of onboarding",
            inheritable:false
        )
    }
    "/cards/hybrid/request/physical/onboarding/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "continue"],
            description: "action tap by the user in the onboarding"
        )
    }

    // Request: Challenge
    "/cards/hybrid/request/physical/challenge"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/request/physical/challenge/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "add_money"],
            description: "action tap by the user in the challenge"
        )
    }

    // Request: Pending Challenge
    "/cards/hybrid/request/physical/pending_challenge"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["back", "add_money", "info_payment"],
            description: "action tap by the user in the pending challenge view"
        )
    }

    // Request: Review
    "/cards/hybrid/request/physical/review"(platform: "/", isAbstract: true) {}

    "/cards/hybrid/request/physical/review"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/request/physical/review/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
             type: PropertyType.String,
             values: ["back", "changes_address", "tyc", "card_request"],
             description: "action tap by the user in the review"
        )
    }

    // Request: Review TyC
    "/cards/hybrid/request/physical/review/tyc"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/request/physical/review/tyc/close"(platform: "/", type: TrackType.Event) {}

    // Request: Review address
    "/cards/hybrid/request/physical/review/address_modal"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/request/physical/review/address_modal/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "add", "select_row"],
            description: "action tap by the user in the address modal"
        )
    }
    // Request: Success Physical
    "/cards/hybrid/request/physical/success"(platform: "/", type: TrackType.Event) {}
    
    // CARD IDENTIFICATION
    // --------
    "/cards/hybrid/card_identification"(platform: "/", type: TrackType.View) {}

    // CARD REQUEST init point
    // --------
    "/cards/hybrid/request/init_point"(platform: "/", type: TrackType.View) {}

    // CARD REQUEST virtual on boarding
    // --------
    "/cards/hybrid/request/virtual/onboarding"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/request/virtual/onboarding/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "continue"],
            description: "Button tapped"
        )
    }

    // Hybrid Detail
    "/cards/mp-card/hybrid/detail" (platform: "/web/desktop", type: TrackType.View) {} 
    // Hybrid downloadApp Event
    "/cards/mp-card/hybrid/detail/download-app" (platform:"/web/desktop", type: TrackType.Event) {} 
    // Hybrid sendSMS Event
    "/cards/mp-card/hybrid/detail/send-sms" (platform: "/web/desktop", type: TrackType.Event) {
        status (
            required: true,
            type: PropertyType.String,
            values: ["OK", "ERROR"],
            description: "Status send sms"
        )
    } 
    // Hybrid clickSendMessage Event
    "/cards/mp-card/hybrid/detail/click-send-message" (platform: "/web/desktop", type: TrackType.Event) {
        deviceType (
            required: true,
            type: PropertyType.String,
            values: ["desktop"],
            description: "Device type click send message"
        )
    } 

    // Request: Success Virtual
    "/cards/hybrid/request/virtual/success"(platform: "/", type: TrackType.Event) {}

    //COACHMARK
    // --------
    "/cards/hybrid/coachmark/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "next", "previous"],
            description: "Button tapped"
        )
        step (
            required: true,
            type: PropertyType.Numeric,
            description: "The coachmark is a guide. This may have multiple steps. It states the number of it"
        )
        id (
            required: true,
            type: PropertyType.String,
            description: "Coachmark identificator"
        )
    }

}
