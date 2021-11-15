import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks


tracks {

    initiative = "1048"

    //-----------------
    // MPCARD
    //-----------------

    //Abstract Path
    "/cards"(platform: "/", isAbstract: true) {
        from (required: false, type: PropertyType.String, description: "Context from where its started")
        flow_version (
            required: false,
            type: PropertyType.Numeric,
            description: "This value represents the version iteration for the given flow",
        )
     }
    "/cards/mpcard"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/physical"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/nip"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/coachmark"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/request"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/request/virtual"(platform: "/", isAbstract: true) { }
    "/cards/acquisition"(platform: "/", isAbstract: true) { }
    "/cards/engagement"(platform: "/", isAbstract: true) { }
    "/cards/mp-card"(platform: "/", isAbstract: true) { }
    "/cards/mp-card/mpcard"(platform: "/", isAbstract: true) { }

    // SHIPPING
    // --------
    "/cards/mpcard/shipping"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/shipping/tracking"(platform: "/", isAbstract: true) { }

    //Shipping: Tracking
    "/cards/mpcard/shipping/tracking"(platform: "/", type: TrackType.View) {
        unlock_banner_is_present (required:true, type: PropertyType.Boolean, description: "Unlock Banner is present in Screen", inheritable:false)
        setup_virtual_banner_is_present (required:true, type: PropertyType.Boolean, description: "Setup Virtual Banner is present in Screen", inheritable:false)
        contact_is_present (required:true, type: PropertyType.Boolean, description: "Contact is present in Screen", inheritable:false)
    }
    "/cards/mpcard/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["back", "contact", "help", "banner_unlock", "banner_setup_virtual", "copy_shipping_code"],
            description: "Action tapped"
        )
    }
    "/cards/mpcard/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
        component_id (required:true, type: PropertyType.String, description: "Component shown")
    }

    //Shipping: Delayed
    "/cards/mpcard/shipping/delayed"(platform: "/", type: TrackType.View) {
        context (
            required: true,
            type: PropertyType.String,
            values: ["delayed", "stolen", "not_delivered_not_withdrawn_by_user", "not_delivery"],
            description: "Action tapped",
            inheritable:false
        )
    }
    "/cards/mpcard/shipping/delayed/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["exit", "reissue"],
            description: "Action tapped"
        )
    }

    // UNLOCK
    // --------
    "/cards/mpcard/unlock"(platform: "/", isAbstract: true) { }

    // Unlock: Init Point
    "/cards/mpcard/unlock/init-point"(platform: "/", type: TrackType.View) {}

    // Unlock: Scanner
    "/cards/mpcard/unlock/scanner"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/unlock/scanner/link"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["qr", "manual"],
            description: "Link method used"
        )
    }
    "/cards/mpcard/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["initializing", "scanning", "resolving", "failed"],
            description: "Scanner state"
        )
    }

    "/cards/mpcard/unlock/scanner/help"(platform: "/", type: TrackType.Event) {}

    // Unlock: Manual Link
    "/cards/mpcard/unlock/manual-link"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/unlock/manual-link/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["link"],
            description: "Manual link method selected"
        )
    }

    "/cards/mpcard/unlock/manual-link/invalid_code"(platform: "/", type: TrackType.Event) {}

    // Unlock: Confirm Link
    "/cards/mpcard/unlock/confirm-link"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/unlock/confirm-link/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["confirm", "logout"],
            description: "Action tapped"
        )
    }

    // Unlock: Camera Permissions
    "/cards/mpcard/unlock/camera-permissions"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/unlock/camera-permissions/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["qr", "manual"],
            description: "Link method selected"
        )
    }

    // Unlock: Confirm Replacement
    "/cards/mpcard/unlock/confirm-replacement"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/unlock/confirm-replacement/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["confirm", "exit"],
            description: "Action tapped"
        )
    }

    // Unlock: Set Pin
    "/cards/mpcard/unlock/set-pin"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/unlock/set-pin/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["confirm"],
            description: "Pin confirmed"
        )
    }

    "/cards/mpcard/unlock/set-pin/invalide_pin"(platform: "/", type: TrackType.Event) {}

    // Unlock: Update App
    "/cards/mpcard/unlock/update-app"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["exit", "update"],
            description: "Action tapped"
          )
    }

    // Unlock: Success
    "/cards/mpcard/unlock/success"(platform: "/", type: TrackType.Event) {}




    // DASHBOARD
    // --------
     "/cards/mpcard/dashboard"(platform: "/", type: TrackType.View) {
         dashboard_status (required:true, type: PropertyType.String, description: "Current sections", inheritable:false)
         dashboard_banner_status (required: false, type: PropertyType.String, description: "Banner for card tracking status", inheritable: false)
         minicard_status (required:false, type: PropertyType.String, description: "Mini card status", inheritable:false)
         flap_status (required:false, type: PropertyType.String, description: "Flap status", inheritable:false)
         message_status (required:false, type: PropertyType.String, description: "Message status", inheritable:false)
         activities_status (required:false, type: PropertyType.String, description: "Activities status", inheritable:false)
         dynamic_carousel (required: false, type: PropertyType.ArrayList, description: "Carousel Cards description", inheritable:false)
     }

    "/cards/mpcard/dashboard/header_help"(platform:"/mobile", type: TrackType.Event) {}
    
    "/cards/mpcard/dashboard/virtual"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/virtual/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["header_help"],
            description: "Header help tapped"
          )
    }
    "/cards/mpcard/dashboard/physical"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/physical/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["header_help"],
            description: "Header help tapped"
          )
    }
    // DASHBOARD Physical Unlock
    "/cards/mpcard/dashboard/physical/unlock"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["success", "error"],
            description: "when user try to unlock its card"
          )
    }
    "/cards/mpcard/dashboard/message/lock"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/message/lock/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["unlock", "reissue"],
            description: "Locked nip message tap"
          )
    }
    // DASHBOARD IFPE
    "/cards/mpcard/dashboard/ifpe_message"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/ifpe_message/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["account_conversion"],
            description: "Header help tapped"
          )
    }
    "/cards/mpcard/dashboard/ifpe_modal"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/ifpe_modal/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["confirm", "dismiss"],
            description: "Header help tapped"
          )
    }
    
    //MiniCard: Tracking
    "/cards/mpcard/dashboard/mini_card"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["options","card_data","physical_delivered", "mpcard_active", "debit_active", "physical_inactive", "user_need_challenge", "virtual_only", "tracking_pending", "tracking_ready_to_ship", "tracking_not_delivered", "tracking_soon_deliver", "tracking_delayed", "tracking_waiting_for_withdrawal", "tracking_shipped"],
            description: "Mini card tapped"
          )
    }
    
    //Flap: Tracking
    "/cards/mpcard/dashboard/flap"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["more_than_one_virtual_active", "virtual_active", "virtual_inactive", "never_had_virtual_card"],
            description: "Flap tapped"
          )
    }

    //Banner: Tracking
    "/cards/mpcard/dashboard/banner"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["render", "physical_inactive", "virtual_only", "user_need_challenge", "tracking_pending", "tracking_ready_to_ship", "tracking_shipped", "tracking_soon_deliver", "tracking_delayed", "tracking_waiting_for_withdrawal", "physical_delivered", "tracking_not_delivered", "kyc_pending_manual_review", "kyc_not_compliance", "kyc_compliance", "debit_active", "hybrid_active", "without_cards_and_card_request"],
            description: "Banner tapped"
          )
    }

    //Banner: Tracking
    "/cards/mpcard/dashboard/physical_acquisition_stop"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/physical_acquisition_stop/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["button"],
            description: "Physical acquisition stop tapped"
          )
    }
    
    //Account Options: Tracking
    "/cards/mpcard/dashboard/account_options"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/account_options/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in", "account_info_modal"],
            description: "Account info tapped"
          )
    }
    
    //Linear buttons: Tracking
    "/cards/mpcard/dashboard/linear_buttons"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["help", "call", "block"],
            description: "Linear button tapped"
          )
    }
    
    //Linear buttons: Tracking
    "/cards/mpcard/dashboard/message"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/message/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["blocked_pin", "unlock_card", "unlock_physical_card"],
            description: "Message button tapped"
          )
    }
    
    //Account info: Tracking
    "/cards/mpcard/dashboard/account_info"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/dashboard/account_info/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in"],
            description: "Footer button tapped"
          )
    }

    //Carousel: Tracking
    "/cards/mpcard/dashboard/carousel"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["page_0", "page_1", "page_2", "page_3", "page_4"],
            description: "Carousel item tapped"
          )
    }
    "/cards/mpcard/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["page_0", "page_1", "page_2", "page_3", "page_4"],
            description: "Carousel item swiped"
          )
    }
        //Dynamic Carousel Tracking
    def dynamic_carousel_description = objectSchemaDefinitions {
        audience(required: false, type: PropertyType.String, name: "audience", description: "Field required by merch engine")
        bu(required: false, type: PropertyType.String, name: "bu", description: "Field required by merch engine")
        bu_line(required: false, type: PropertyType.String, name: "bu_line", description: "Field required by merch engine")
        component_id(required: false, type: PropertyType.String, name: "component_id", description: "Field required by merch engine")
        content_id(required: false, type: PropertyType.String, name: "content_id", description: "Field required by merch engine")
        flow(required: false, type: PropertyType.String, name: "flow", description: "Field required by merch engine")
        logic(required: false, type: PropertyType.String, name: "logic", description: "Field required by merch engine")
        position(required: true, type: PropertyType.Numeric, name: "position", description: "Field required by merch engine")
    }
    "/cards/mpcard/dashboard/dynamic_carousel"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/dynamic_carousel/tap"(platform:"/", type: TrackType.Event) {
        description (
            required: true,
            type: PropertyType.Map(dynamic_carousel_description),
            description: "Carousel item tapped",
            name: "description"
          )
    }
    "/cards/mpcard/dashboard/dynamic_carousel/swipe"(platform:"/", type: TrackType.Event) {
        description (
            required: true,
            type: PropertyType.Map(dynamic_carousel_description),
            description: "Carousel item swiped",
            name: "description"
          )
    }
    "/cards/mpcard/dashboard/dynamic_carousel/show_item"(platform:"/", type: TrackType.Event) {
        description (
            required: true,
            type: PropertyType.Map(dynamic_carousel_description),
            description: "Carousel item displayed",
            name: "description"
          )
    }
    "/cards/mpcard/dashboard/dynamic_carousel/close"(platform:"/", type: TrackType.Event) {
        description (
            required: true,
            type: PropertyType.Map(dynamic_carousel_description),
            description: "Carousel item closed",
            name: "description"
          )
    }
    
    //Feedback: Tracking
    "/cards/mpcard/dashboard/feedback"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/feedback/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["research_form"],
            description: "Feedback action tapped"
          )
    }

    //Coachmark banner
    "/cards/mpcard/dashboard/coachmark_banner"(platform: "/", type: TrackType.Event) {
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
    "/cards/mpcard/dashboard/map_info"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/dashboard/map_info/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["map_info"],
            description: "Map info tapped"
          )
    }

    //FTU Single Onboarding: Tracking
    "/cards/mpcard/dashboard/ftu_single_onboarding"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/dashboard/ftu_single_onboarding/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "continue"],
            description: "action tap by the user in the ftu single onboarding view"
        )
    }
    
    //FTU Carousel Onboarding: Tracking
    "/cards/mpcard/dashboard/ftu_carousel_onboarding"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/dashboard/ftu_carousel_onboarding/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "continue"],
            description: "action tap by the user in the ftu single onboarding view"
        )
    }
    "/cards/mpcard/dashboard/ftu_carousel_onboarding/swipe"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["swipe_virtual_slide", "swipe_physical_slide", "swipe_credit_slide", "swipe_nfc_slide"],
            description: "ftu carousel onboarding item swiped"
          )
    }

    // SETUP VIRTUAL
    // --------

    //Card
    "/cards/mpcard/setup"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/setup/virtual"(platform: "/", type: TrackType.View) {
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
        experimental_version (
            required: false,
            type: PropertyType.String,
            values: ["experimental_a", "experimental_b"],
            description: "Indicates experimental version",
            inheritable:false
        )
    }
    "/cards/mpcard/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["card_name_copy", "card_number_copy", "card_sec_code_copy", "additional_message", "close_modal", "header_help", "additional_message_freeze"],
            description: "Virtual card buttons tapped"
        )
    }

    // Setup virtual reauth
    "/cards/mpcard/setup/virtual/reauth"(platform:"/", type: TrackType.Event) { }
    "/cards/mpcard/setup/virtual/reauth/success"(platform:"/", type: TrackType.Event) { }
    "/cards/mpcard/setup/virtual/reauth/error"(platform:"/", type: TrackType.Event) { }

    // Cards hub
    "/cards/mpcard/card_hub"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/card_hub/block_card"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/card_hub/block_card/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["physical_card", "virtual_debit_card"],
            description: "Card tapped"
        )
    }

    //Highlighted row
    "/cards/mpcard/setup/virtual/highlighted_row"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/setup/virtual/highlighted_row/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in"],
            description: "Highlighted Row button tapped"
        )
    }

    //Message
    "/cards/mpcard/setup/virtual/message"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in", "money_in_experimental_a", "money_in_experimental_b", "account_info_modal", "account_info_modal_experimental_a", "account_info_modal_experimental_b"],
            description: "The action type tapped"
        )
    }
    
    //Redirect when the user don't have a virtual card
    "/cards/mpcard/setup/virtual/redirect"(platform:"/", type: TrackType.Event) {}

    //Account options
    "/cards/mpcard/setup/virtual/account_options"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/setup/virtual/account_options/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["account_info_modal", "money_in"],
            description: "The action type tapped"
        )
    }

    //Account Info
    "/cards/mpcard/setup/virtual/account_info"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/setup/virtual/account_info/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in"],
            description: "The action type tapped"
        )
    }

    //Feedback: Tracking
    "/cards/mpcard/setup/virtual/feedback"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/setup/virtual/feedback/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["research_form"],
            description: "Feedback action tapped"
          )
    }

    //Static Banner: Tracking
    "/cards/mpcard/setup/virtual/static_banner"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/setup/virtual/static_banner/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in"],
            description: "Static banner tapped"
          )
    }

    // SETUP OPTIONS
    // --------
    //TODO View attributes
    "/cards/mpcard/setup/options"(platform: "/", type: TrackType.View) {
        virtual_status (
            required: false,
            type: PropertyType.String,
            description: "Virtual card status"
          )
        debit_status (
            required: false,
            type: PropertyType.String,
            description: "Debit_physical card status"
          )
        empty_state (
            required: false,
            type: PropertyType.String,
            description: "User has no cards"
          )
    }
    "/cards/mpcard/setup/options/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["freeze","unfreeze","physical_freeze","physical_unfreeze","change_limits","see_nip","reissue"],
            description: "Cards options tapped"
        )
        product_type (
            required: false,
            type: PropertyType.String,
            description: "Card type"
        )
    }
    "/cards/mpcard/setup/options/tap/success"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["freeze","unfreeze","physical_freeze","physical_unfreeze","change_limits","see_nip","block_card"],
            description: "Setup options operation status"
        )
        product_type (
            required: false,
            type: PropertyType.String,
            description: "Card type"
        )
    }
    "/cards/mpcard/setup/options/tap/failure"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["freeze","unfreeze","physical_freeze","physical_unfreeze","change_limits","see_nip","block_card"],
            description: "Setup options operation status"
        )
        product_type (
            required: false,
            type: PropertyType.String,
            description: "Card type"
        )
    }

    "/cards/mpcard/setup/options/empty_state"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/setup/options/empty_state/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["primary_button", "secondary_button"],
            inheritable: false
        )
    }

    "/cards/mpcard/setup/options/message"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/setup/options/message/lock"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/setup/options/message/lock/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["unlock","reissue"],
            description: "Cards blocked Message tapped"
          )
    }
    "/cards/mpcard/setup/options/physical"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/setup/options/physical/unlock"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["success","error"],
            description: "Physical card unlock status"
          )
    }
    

    
    // REISSUE VIRTUAL
    // --------

    "/cards/mpcard/block_card"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/block_card/virtual"(platform: "/", type: TrackType.View) {
        card_id (
            required: false,
            type: PropertyType.String,
            description: "Card id"
        )
        context (
            required: false,
            type: PropertyType.String,
            values: ["cancellation", "creation"],
            description: "Type of operation: cancel or reissue",
            inheritable: true
        )
    }
    "/cards/mpcard/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["primary_button", "secondary_button"],
            description: "The action type tapped"
        )
        card_id (
            required: false,
            type: PropertyType.String,
            description: "Card id"
        )
    }

    "/cards/mpcard/block_card/virtual/success"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    // REISSUE PHYSICAL
    // --------

    "/cards/mpcard/block_card/physical"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable: false
        )
    }
    "/cards/mpcard/block_card/physical/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["primary_button", "secondary_button"],
            description: "The action type tapped"
        )
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable: false
        )
    }

    "/cards/mpcard/block_card/physical/success"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        is_warning_address (
            required: false,
            type: PropertyType.Boolean,
            description: "If reissue was request by warning address"
        )
    }
    
    // REASONS REISSUE
    // --------
    "/cards/mpcard/block_card/physical/reasons"(platform: "/", type: TrackType.View) {
        type (
            required: true,
            type: PropertyType.String,
            description: "Type of onboarding",
            inheritable: false
        )
    }

    "/cards/mpcard/block_card/physical/reasons/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["selected", "continue"],
            description: "The action type tapped"
        )
        option_id (
            required: true,
            type: PropertyType.String,
            description: "The selected option"
        )
    }

    // CUSTOM FEEDBACK
    // --------
    "/cards/mpcard/feedback_custom"(platform: "/", type: TrackType.View) {
        type (
            required: true,
            type: PropertyType.String,
            description: "Type of custom feedback",
            inheritable: false
        )
    }

    "/cards/mpcard/feedback_custom/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["confirm", "exit"],
            description: "The action tapped"
        )
    }

    // INTERMEDIATE ONBOARDING
    // --------
    "/cards/mpcard/block_card/physical/intermediate_onboarding"(platform: "/", type: TrackType.View) {
        type (
            required: true,
            type: PropertyType.String,
            description: "Type of onboarding",
            inheritable: false
        )
        card_id (
            required: false,
            type: PropertyType.String,
            description: "Optional Card id",
            inheritable: false
        )
    }

    "/cards/mpcard/block_card/physical/intermediate_onboarding/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["reissue_pause_card", "reissue", "reissue_change_pin", "reissue_show_nip", "reissue_activate_contactless", "reissue_continue", "reissue_exit"],
            description: "The action tapped"
        )
    }

    // SETUP FÍSICA
    // --------
    "/cards/mpcard/setup/physical"(platform: "/", type: TrackType.View) {
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
    "/cards/mpcard/setup/physical/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["reissue", "freeze", "unfreeze", "change_pin", "change_limits", "header_help"],
            description: "The action type tapped"
        )
    }
    
    //Feedback: Tracking
    "/cards/mpcard/setup/physical/feedback"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/setup/physical/feedback/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["research_form"],
            description: "Feedback action tapped"
          )
    }

    // Unlock FÍSICA
    "/cards/mpcard/physical/unlock"(platform: "/", isAbstract: true) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable:false
        )
    }
    "/cards/mpcard/physical/unlock/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "unlock_card", "block_card"],
            description: "Unlock Physical Button Tapped"
          )
    }
    "/cards/mpcard/physical/unlock/status"(platform:"/", type: TrackType.Event) {
        status (
            required: true,
            type: PropertyType.String,
            values: ["success", "error"],
            description: "Unlock Physical transaction status"
          )
    }

    
    // CHANGE-PIN
    // --------
    "/cards/mpcard/change_pin"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/change_pin/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["change_pin"],
            description: "Change pin button tapped"
          )
    }
    "/cards/mpcard/change_pin/congrats"(platform: "/", type: TrackType.View) {}
    
    // LIMITS
    // --------
    "/cards/mpcard/limits_setup"(platform: "/", type: TrackType.View) {
        limits_status (required:true, type: PropertyType.String, description: "Current sections", inheritable:false)
    }
    "/cards/mpcard/limits_setup/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["header_help"],
            description: "Header action tapped"
          )
    }

    // NIP
    // -------
    "/cards/mpcard/nip/physical"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable:false
        )
    }
    "/cards/mpcard/nip/physical/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["header_help", "header_back_button", "change_nip"],
            description: "Help, Back and change nip button tapped"
        )
    }
    "/cards/mpcard/nip/message"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/nip/message/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["blocked_pin"],
            description: "It_was_not_me Link button message tapped"
        )
    }
    //NIP - ONBOARDING
    "/cards/mpcard/nip/onboarding"(platform: "/", type: TrackType.View) { }
    "/cards/mpcard/nip/onboarding/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["change_nip", "keep_actual", "close"],
            description: "Button tapped"
        )
    }
    //NIP - Change NIP
    "/cards/mpcard/change_nip"(platform: "/", type: TrackType.View) { }
    "/cards/mpcard/change_nip/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["change_nip"],
            description: "Button tapped"
        )
    }
    //NIP - Change NIP Congrats
    "/cards/mpcard/change_nip/congrats"(platform: "/", type: TrackType.View) { }
    "/cards/mpcard/change_nip/congrats/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["understands", "atm_away"],
            description: "Button tapped",
        )
    }
    
    //Number Selector
    "/cards/mpcard/limits_setup/number_selector"(platform: "/", isAbstract: true) { }
    "/cards/mpcard/limits_setup/number_selector/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["modal"],
            description: "Button tapped"
        )
    }
    
    //Number selector modal
    "/cards/mpcard/limits_setup/number_selector_modal"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/limits_setup/number_selector_modal/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["cancel", "save"],
            description: "Button tapped"
        )
    }

    //Map Info: Tracking
    "/cards/mpcard/limits_setup/map_info"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/limits_setup/map_info/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["map_info"],
            description: "Map info tapped"
          )
    }

    // Request

    // Request: Onboarding
    "/cards/mpcard/request/physical"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/request/physical/onboarding"(platform: "/", type: TrackType.View) {
        context (
            required: true,
            type: PropertyType.String,
            values: ["no_kyc_no_challenge", "kyc_challenge", "no_kyc_challenge", "kyc_no_challenge", 
                    "prepaid_reparking_challenge", "prepaid_reparking_no_challenge",
                    "seller_kyc_challenge", "seller_kyc_no_challenge", "seller_no_kyc_challenge", "seller_no_kyc_no_challenge"],
            description: "type of onboarding",
            inheritable:false
        )
    }
    "/cards/mpcard/request/physical/onboarding/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "continue"],
            description: "action tap by the user in the onboarding"
        )
    }

    // Request: Challenge
    "/cards/mpcard/request/physical/challenge"(platform: "/", type: TrackType.View) { }

    "/cards/mpcard/request/physical/challenge/success"(platform: "/", type: TrackType.Event) {
        reasons (
            required: true,
            type: PropertyType.ArrayList(PropertyType.String),
            description: "list of reasons that allow to do the request flow"
        )
        is_warning_address (
            required: false,
            type: PropertyType.Boolean,
            description: "If reissue was request by warning address"
        )
    }

    "/cards/mpcard/request/physical/challenge/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["back", "add_money"],
            description: "action tap by the user in the challenge"
        )
    }

    // Cards Helper
    //--------------
    "/cards/mpcard/card_helper"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/card_helper/extraction"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable:false
        )
    }
    "/cards/mpcard/card_helper/extraction/contingency"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable:false
        )
    }
    "/cards/mpcard/card_helper/extraction/contingency/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["back_button"],
            description: "Action Tapped"
        )
    }

    // Tap4Auth Flow
    propertyDefinitions {
            tap4auth_congrats_type (
                description: "Tap4auth Congrats Type",
                type: PropertyType.String,
                required: true,
                values: [
                        "user_accepted_congrats_physical",
                        "user_rejected_congrats_physical",
                        "user_accepted_congrats_virtual",
                        "user_rejected_congrats_virtual",
                        "user_rejected_congrats_virtual_second_try",
                        "user_rejected_congrats_virtual_third_try",
                        "user_accepted_ttl_expired_physical",
                        "user_accepted_ttl_expired_virtual",
                        "user_already_responded",
                        "user_rejected_congrats_virtual_third_contingency_cancel_try",
                        "user_rejected_congrats_virtual_third_contingency_create_try"
                ]
            )
    }
    propertyGroups {
        tap4auth_congrats(tap4auth_congrats_type)
    }

    "/cards/mpcard/payment_authorization"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/payment_authorization/main_screen"(platform:"/mobile", type: TrackType.View) {
        amount (
            required: true, 
            type: PropertyType.Numeric, 
            description: "Amount of money through tap4Auth"
        )
     }
     "/cards/mpcard/payment_authorization/main_screen/cta"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
         action (
            required: true,
            type: PropertyType.String,
            values: ["authorize", "no_authorize"],
            description: "Option chosen by Tap4Auth user"
         )
     }
     "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) {
         amount (
            required: true, 
            type: PropertyType.Numeric, 
            description: "Amount of money through tap4Auth"
        )
        tap4auth_congrats
     }
     "/cards/mpcard/payment_authorization/congrats/cta"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        tap4auth_congrats
        action (
            required: true,
            type: PropertyType.String,
            values: [
                "understands",
                "setup_virtual",
                "home",
                "pause_card",
                "report_card",
                "dismiss"
                ],
            description: "Button tapped by user"
        )
     }

    // Request: Pending Challenge
    "/cards/mpcard/request/physical/pending_challenge"(platform: "/", type: TrackType.View) {
        context (
            required: true,
            type: PropertyType.String,
            values: ["D1", "D1_ticket", "D4"],
            description: "type of screen"
        )
    }
    "/cards/mpcard/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["back", "add_money"],
            description: "action tap by the user in the pending challenge view"
        )
        context (
            required: true,
            type: PropertyType.String,
            values: ["D1", "D1_ticket", "D4"],
            description: "type of screen"
        )
    }

    // Request: Expired Challenge
    "/cards/mpcard/request/physical/expired_challenge"(platform: "/", type: TrackType.View) { }
    "/cards/mpcard/request/physical/expired_challenge/tap"(platform: "/", type: TrackType.Event) {
        action(
            required: true,
            type: PropertyType.String,
            values: ["back", "continue"],
            description: "action tap by the user in the expired challenge view"
        )
    }

    // Request: Review
    "/cards/mpcard/request/physical/review"(platform: "/", isAbstract: true) {}

    "/cards/mpcard/request/physical/review"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/request/physical/review/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
             type: PropertyType.String,
             values: ["back", "changes_address", "tyc", "card_request"],
             description: "action tap by the user in the review"
        )
    }

    // Request: Review TyC
    "/cards/mpcard/request/physical/review/tyc"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/request/physical/review/tyc/close"(platform: "/", type: TrackType.Event) {}

    // Request: Review address
    "/cards/mpcard/request/physical/review/address_modal"(platform: "/", type: TrackType.View) {}
    "/cards/mpcard/request/physical/review/address_modal/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "add", "select_row"],
            description: "action tap by the user in the address modal"
        )
    }
    // Request: Success Physical
    "/cards/mpcard/request/physical/success"(platform: "/", type: TrackType.Event) {
        reasons (
            required: true,
            type: PropertyType.ArrayList(PropertyType.String),
            description: "list of reasons that allow to do the request flow"
        )
    }
    
    // CARD IDENTIFICATION
    // --------
    "/cards/mpcard/card_identification"(platform: "/", type: TrackType.View) {}

    // CARD REQUEST init point
    // --------
    "/cards/mpcard/request/init_point"(platform: "/", type: TrackType.View) {}

    // CARD REQUEST physical init point
    // --------
    "/cards/mpcard/request/physical/init_point"(platform: "/", type: TrackType.View) {}

    // CARD REQUEST virtual init point
    // --------
    "/cards/mpcard/request/virtual/init_point"(platform: "/", type: TrackType.View) {}

    // CARD REQUEST PJ virtual lock
    // --------
    "/cards/mpcard/request/virtual/onboarding/lock"(platform: "/", type: TrackType.View) {}
    
    // CARD REQUEST PJ virtual lock
    // --------
    "/cards/mpcard/request/physical/onboarding/lock"(platform: "/", type: TrackType.View) {}
    
    // CARD REQUEST virtual on boarding
    // --------
    "/cards/mpcard/request/virtual/onboarding"(platform: "/", type: TrackType.View) {
        context (
            required: true,
            type: PropertyType.String,
            values: ["no_kyc", "kyc", "onboarding_shown"],
            description: "type of onboarding",
            inheritable:false
        )
    }
    "/cards/mpcard/request/virtual/onboarding/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "continue"],
            description: "Button tapped"
        )
    }

    // mpcard Detail
    "/cards/mp-card/mpcard/detail" (platform: "/web/desktop", type: TrackType.View) {} 
    // mpcard downloadApp Event
    "/cards/mp-card/mpcard/detail/download-app" (platform:"/web/desktop", type: TrackType.Event) {} 
    // mpcard sendSMS Event
    "/cards/mp-card/mpcard/detail/send-sms" (platform: "/web/desktop", type: TrackType.Event) {
        status (
            required: true,
            type: PropertyType.String,
            values: ["OK", "ERROR"],
            description: "Status send sms"
        )
    } 
    // mpcard clickSendMessage Event
    "/cards/mp-card/mpcard/detail/click-send-message" (platform: "/web/desktop", type: TrackType.Event) {
        deviceType (
            required: true,
            type: PropertyType.String,
            values: ["desktop"],
            description: "Device type click send message"
        )
    } 

    // Request: Success Virtual
    "/cards/mpcard/request/virtual/success"(platform: "/", type: TrackType.Event) {
        reasons (
            required: true,
            type: PropertyType.ArrayList(PropertyType.String),
            description: "list of reasons that allow to do the request flow"
        )
    }

    //COACHMARK
    // --------
    "/cards/mpcard/coachmark/tap"(platform:"/", type: TrackType.Event) {
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
    
    "/cards/mpcard/contingency"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/contingency/nip"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/contingency/nip/physical"(platform:"/mobile", type: TrackType.View) {}
    "/cards/mpcard/contingency/nip/physical/tap"(platform:"/mobile", type: TrackType.Event) { 
        action (
            required: true,
            type: PropertyType.String,
            values: ["back_button"],
            description: "Cards contingency nip tap"
            )
    }

    "/cards/mpcard/tracking"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/tracking/feedback"(platform: "/", isAbstract: true) {}
    "/cards/mpcard/tracking/feedback/tap" (platform:"/mobile", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["research_form"],
            description: "Taps feedback in App"
            )
    }

}
