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
        flow_version (
            required: false,
            type: PropertyType.Numeric,
            description: "This value represents the version iteration for the given flow",
        )
     }
    "/cards/hybrid"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/physical"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/coachmark"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/request"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/request/virtual"(platform: "/", isAbstract: true) { }
    "/cards/acquisition"(platform: "/", isAbstract: true) { }
    "/cards/engagement"(platform: "/", isAbstract: true) { }
    "/cards/mp-card"(platform: "/", isAbstract: true) { }
    "/cards/mp-card/hybrid"(platform: "/", isAbstract: true) { }
    "/cards/nfc"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment/hub/step"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment/tokenization"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment/tokenization/wipe_data"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment/tokenization/new_card_push"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment/fetch_card_data"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment/check_card_eligibility"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment/partial_enrollment"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment/digitize_card"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment/replenish_payment_keys"(platform: "/", isAbstract: true) { }
    "/cards/nfc/enrollment/device_enrollment"(platform: "/", isAbstract: true) { }
    "/cards/nfc/configuration"(platform: "/", isAbstract: true) { }
    "/cards/nfc/configuration/hub/step"(platform: "/", isAbstract: true) { }
    "/cards/nfc/core"(platform: "/", isAbstract: true) { }
    "/cards/nfc/core/service"(platform: "/", isAbstract: true) { }
    "/cards/nfc/core/service/initializer"(platform: "/", isAbstract: true) { }
    "/cards/nfc/core/service/start_secure_enrollment"(platform: "/", isAbstract: true) { }
    "/cards/nfc/feature"(platform: "/", isAbstract: true) { }
    "/cards/nfc/block_page"(platform: "/", isAbstract: true) { }
    "/cards/nfc/congrats"(platform: "/", isAbstract: true) { }
    "/cards/nfc/semaphore"(platform: "/", isAbstract: true) { }
    "/cards/nfc/constraint"(platform: "/", isAbstract: true) { }
    "/cards/nfc/acquisition"(platform: "/", isAbstract: true) { }
    "/cards/nfc/payments"(platform: "/", isAbstract: true) { }
    "/cards/nfc/payments/congrats"(platform: "/", isAbstract: true) { }

    // SHIPPING
    // --------
    "/cards/hybrid/shipping"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/shipping/tracking"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/shipping/delivered"(platform: "/", isAbstract: true) { }

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
            values: ["back", "contact", "help", "banner_unlock", "banner_setup_virtual", "copy_shipping_code"],
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

    //Shipping: Delivered
    "/cards/hybrid/shipping/delivered"(platform: "/", type: TrackType.View) {
        context (
            required: false,
            type: PropertyType.String,
            values: ["receiver-2-mãe", "receiver-3-pai", "receiver-4-port", "receiver-5-secretario", "receiver-6-segurança",
            "receiver-7-funcionário", "receiver-8-empregada", "receiver-9-filho", "receiver-10-tio", "receiver-11-sobrinho",
            "receiver-12-avo", "receiver-13-procurador", "receiver-14-esposa", "receiver-15-esposo", "receiver-16-recepção",
            "receiver-17-primo", "receiver-18-sogro", "receiver-19-inquilino", "receiver-20-sindico", "receiver-21-irmao",
            "receiver-22-noivo", "receiver-23-cunhado", "receiver-24-genro", "receiver-25-neto", "receiver-26-res_autorizado",
            "receiver-50-deixado_na_varanda", "receiver-51-caixa_de_correspondencia", "receiver-52-entregue_sob_a_porta",
            "receiver-53-garagem", "receiver-54-outros", "receiver-0-agência"],
            description: "Type of relationship with receiver",
            inheritable:false
        )
    }
    "/cards/hybrid/shipping/delivered/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["back", "unlock", "reissue"],
            description: "Action tapped"
        )
    }

    //Feedback: Tracking
    "/cards/hybrid/shipping/tracking/feedback"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/shipping/tracking/feedback/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["research_form"],
            description: "Feedback action tapped"
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

    "/cards/hybrid/unlock/set-pin/invalid_pin"(platform: "/", type: TrackType.Event) {}

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

    // Engagement Error
    // --------
    "/cards/engagement/error"(platform: "/", type: TrackType.View) {
        screen (required: true, type: PropertyType.String, description: "The screen that showed error")
    }
    "/cards/engagement/decrypting"(platform: "/", isAbstract: true) {}
    "/cards/engagement/decrypting/error"(platform: "/", type: TrackType.Event) {
        error(
            required: true,
            type: PropertyType.String,
            description: "User sensitive data decryption errors"
            )
        from(
            required: true,
            type: PropertyType.String,
            description: "Component where the error occurred"
            )
    }

    // DASHBOARD
    // --------

    // Start // Credit Card definitions
    def account_data = objectSchemaDefinitions {
        rating(
                description: "User reputation level",
                type: PropertyType.String,
                required: false
        )
        status(
                description: "Status user's account",
                type: PropertyType.String,
                required: false,
                values: [
                        "pending",
                        "active",
                        "blocked",
                        "cancelled"
                ]
        )
        status_detail(
                description: "Status detail of user's account",
                type: PropertyType.String,
                required: false
        )
        overdue_days(
                description: "Overdue days of user's account",
                type: PropertyType.Numeric,
                required: false
        )
    }

    def credits_data = objectSchemaDefinitions {
         account(
                type: PropertyType.Map(account_data),
                required: false
        )
        statement_status(   
            description: "Status from the user's statement",
            type: PropertyType.String,
            required: false,
            values: [
                "closed",
                "open"
            ]
        )
        pending_payments(
                description: "The pending payments",
                type: PropertyType.Boolean,
                required: false
        )
    }

    // End // Credit Card definitions

     "/cards/hybrid/dashboard"(platform: "/", type: TrackType.View) {
         dashboard_status (required:true, type: PropertyType.String, description: "Current sections", inheritable:false)
         dashboard_banner_status (required: false, type: PropertyType.String, description: "Banner for card tracking status", inheritable: false)
         minicard_status (required:false, type: PropertyType.String, description: "Mini card status", inheritable:false)
         flap_status (required:false, type: PropertyType.String, description: "Flap status", inheritable:false)
         message_status (required:false, type: PropertyType.String, description: "Message status", inheritable:false)
         activities_status (required:false, type: PropertyType.String, description: "Activities status", inheritable:false)
         credits (required:false, type: PropertyType.Map(credits_data), description: "Credit Card", inheritable: false)
         dynamic_carousel (required: false, type: PropertyType.ArrayList, description: "Carousel Cards description", inheritable:false)
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
            values: ["options", "card_data", "kyc_compliance", "kyc_not_compliance", "tracking_pending", "tracking_ready_to_ship", "tracking_not_delivered", "tracking_soon_deliver", "tracking_delayed", "tracking_waiting_for_withdrawal", "tracking_shipped", "debit_active", "virtual_only", "physical_delivered", "physical_inactive", "user_need_challenge"],
            description: "Mini card tapped"
          )
    }
    
    //Banner: Tracking
    "/cards/hybrid/dashboard/banner"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["render", "physical_inactive", "virtual_only", "user_need_challenge", "tracking_pending", "tracking_ready_to_ship", "tracking_shipped", "tracking_soon_deliver", "tracking_delayed", "tracking_waiting_for_withdrawal", "physical_delivered", "tracking_not_delivered", "kyc_pending_manual_review", "kyc_not_compliance", "kyc_compliance", "debit_active", "hybrid_active","debit_active_and_credit_pending","virtual_debit_and_credit_pending","virtual_debit_and_credit_active", "without_cards_and_card_request"],
            description: "Banner tapped"
          )
    }
    
    //Banner: Tracking
    "/cards/hybrid/dashboard/physical_acquisition_stop"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/physical_acquisition_stop/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["primary_button", "secondary_button"],
            description: "Physical acquisition stop tapped"
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
            values: ["money_in"],
            description: "Account info tapped"
          )
    }
    
    //Linear buttons: Tracking
    "/cards/hybrid/dashboard/linear_buttons"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["help", "block"],
            description: "Linear button tapped"
          )
    }
    
    //Dashboard Andes Messages
    "/cards/hybrid/dashboard/pin"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/pin/message"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/pin/message/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["blocked_pin"],
            description: "Message action tapped"
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
    //Dynamic Carousel Tracking
    def dynamic_carousel_description = objectSchemaDefinitions {
        audience(required: false, type: PropertyType.String)
        bu(required: false, type: PropertyType.String)
        bu_line(required: false, type: PropertyType.String)
        component_id(required: false, type: PropertyType.String)
        content_id(required: false, type: PropertyType.String)
        flow(required: false, type: PropertyType.String)
        logic(required: false, type: PropertyType.String)
        position(required: true, type: PropertyType.Numeric)
    }
    "/cards/hybrid/dashboard/dynamic_carousel"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/dynamic_carousel/tap"(platform:"/", type: TrackType.Event) {
        description (
            required: true,
            type: PropertyType.Map(dynamic_carousel_description),
            description: "Carousel item tapped"
          )
    }
    "/cards/hybrid/dashboard/dynamic_carousel/swipe"(platform:"/", type: TrackType.Event) {
        description (
            required: true,
            type: PropertyType.Map(dynamic_carousel_description),
            description: "Carousel item swiped"
          )
    }
    "/cards/hybrid/dashboard/dynamic_carousel/close"(platform:"/", type: TrackType.Event) {
        description (
            required: true,
            type: PropertyType.Map(dynamic_carousel_description),
            description: "Carousel item closed"
          )
    }

    //Feedback: Tracking
    "/cards/hybrid/dashboard/feedback"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/feedback/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["research_form"],
            description: "Dasboard feedback in app action tapped"
          )
    }

    //Feedback for virtual credit card
    "/cards/hybrid/dashboard/feedback/credit"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/feedback/credit/tap"(platform:"/", type: TrackType.Event) {
        action (
                required: true,
                type: PropertyType.String,
                values: ["research_form"],
                description: "Feedback action tapped from dashboard for virtual credit card"
        )
    }

    //Dashboard Coachmark banner
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
            values: ["dashboard_virtual_coachmark", "dashboard_physical_coachmark"],
            description: "coachmark id"
        )
     }

    //Map Info: Tracking
    "/cards/hybrid/dashboard/map_info"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/dashboard/map_info/tap"(platform:"/", type: TrackType.Event) {}

    //FTU Single Onboarding: Tracking
    "/cards/hybrid/dashboard/ftu_single_onboarding"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/dashboard/ftu_single_onboarding/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "continue"],
            description: "action tap by the user in the ftu single onboarding view"
        )
    }
    
    //FTU Carousel Onboarding: Tracking
    "/cards/hybrid/dashboard/ftu_carousel_onboarding"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/dashboard/ftu_carousel_onboarding/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "continue"],
            description: "action tap by the user in the ftu single onboarding view"
        )
    }
    "/cards/hybrid/dashboard/ftu_carousel_onboarding/swipe"(platform:"/", type: TrackType.Event) {
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
        product_type (
			required: false,
            type: PropertyType.String,
            values: ["prepaid","hybrid","credit"],
            description: "Indicate card type",
            inheritable:false
        )
        has_money (
            required: false,
            type: PropertyType.Boolean,
            description: "Indicate whether the user has money",
            inheritable:false
        )
    }
    "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["header_help", "card_name_copy", "card_number_copy", "card_sec_code_copy", "credit_card_message_no_limit", "credit_card_message_blocked_account", "credit_message_card_paused", "additional_message_freeze"],
            description: "The action type tapped"
        )
    }
    "/cards/hybrid/setup/virtual/whatsapp"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/setup/virtual/whatsapp/banner"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/setup/virtual/whatsapp/banner/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: false,
            type: PropertyType.String,
            description: "The wsp banner tapped"
        )
    }
    "/cards/hybrid/setup/virtual/card"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/setup/virtual/card/modal"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/setup/virtual/card/modal/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["primary_button"],
            description: "The action tapped"
        )
    }

    //Highlighted row
    "/cards/hybrid/setup/virtual/highlighted_row"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/setup/virtual/highlighted_row/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in"],
            description: "Highlighted Row button tapped"
        )
    }

    //Message
    "/cards/hybrid/setup/virtual/message"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in", "money_in_experimental_a", "money_in_experimental_b", "account_info_modal", "account_info_modal_experimental_a", "account_info_modal_experimental_b"],
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

    // WHATSAPP Banner
    "/cards/hybrid/setup/virtual/whatsapp"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/setup/virtual/whatsapp/banner"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/setup/virtual/whatsapp/banner/tap"(platform:"/", type: TrackType.Event) {}


    // CARDS HUBS
    "/cards/hybrid/card_hub"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/card_hub/setup_virtual"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/card_hub/setup_virtual/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["credit_card", "debit_card"],
            description: "Card tapped"
        )
    }

    "/cards/hybrid/card_hub/block_card"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/card_hub/block_card/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["physical_card", "virtual_credit_card", "virtual_debit_card"],
            description: "Card tapped"
        )
    }
    
    // REISSUE VIRTUAL
    // --------

    "/cards/hybrid/block_card"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/block_card/virtual"(platform: "/", type: TrackType.View) {
        card_id (
            required: false,
            type: PropertyType.String,
            description: "Card id",
            inheritable: false
        )
        context (
            required: false,
            type: PropertyType.String,
            values: ["cancellation", "creation"],
            description: "Type of operation: cancel or reissue",
            inheritable: false
        )
    }
    "/cards/hybrid/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["primary_button", "secondary_button"],
            description: "The action type tapped"
        )
        card_id (
            required: false,
            type: PropertyType.String,
            description: "Card id",
            inheritable: false
        )
        context (
            required: false,
            type: PropertyType.String,
            values: ["cancellation", "creation"],
            description: "Type of operation: cancel or reissue",
            inheritable: false
        )
    }
    "/cards/hybrid/block_card/virtual/success"(platform: "/", type: TrackType.Event) {
        reasons (
            required: true,
            type: PropertyType.ArrayList(PropertyType.String),
            description: "list of reasons that allow to do the request flow"
        )
    }

    // REISSUE VIRTUAL CREDIT
    // --------

    "/cards/hybrid/block_card/virtual/credit"(platform: "/", type: TrackType.View) {
        card_id (
                required: true,
                type: PropertyType.String,
                description: "Card id",
                inheritable: false
        )
    }
    "/cards/hybrid/block_card/virtual/credit/tap"(platform:"/", type: TrackType.Event) {
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

    // REISSUE PHYSICAL
    // --------

    "/cards/hybrid/block_card/physical"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable: false
        )
    }
    "/cards/hybrid/block_card/physical/tap"(platform:"/", type: TrackType.Event) {
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

    "/cards/hybrid/block_card/physical/success"(platform: "/", type: TrackType.Event) {
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

    
    // REASONS REISSUE
    // --------
    "/cards/hybrid/block_card/physical/reasons"(platform: "/", type: TrackType.View) {
        type (
            required: true,
            type: PropertyType.String,
            description: "Type of onboarding",
            inheritable: false
        )
    }

    "/cards/hybrid/block_card/physical/reasons/tap"(platform: "/", type: TrackType.Event) {
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
    "/cards/hybrid/feedback_custom"(platform: "/", type: TrackType.View) {
        type (
            required: true,
            type: PropertyType.String,
            description: "Type of custom feedback",
            inheritable: false
        )
    }

    "/cards/hybrid/feedback_custom/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["confirm", "exit"],
            description: "The action tapped"
        )
    }

    // INTERMEDIATE ONBOARDING
    // --------
    "/cards/hybrid/block_card/physical/intermediate_onboarding"(platform: "/", type: TrackType.View) {
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

    "/cards/hybrid/block_card/physical/intermediate_onboarding/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["reissue_pause_card", "reissue", "reissue_change_pin", "reissue_activate_contactless", "reissue_continue", "reissue_exit"],
            description: "The action tapped"
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
            values: ["reissue", "freeze", "unfreeze", "change_pin", "change_limits", "header_help"],
            description: "The action type tapped"
        )
    }
    // Unlock FÍSICA
    "/cards/hybrid/physical/unlock"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/physical/unlock/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close"],
            description: "Unlock Physical Button Tapped"
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
        limits_status (
            required:true,
            type: PropertyType.String,
            description: "Current sections",
            inheritable:false
        )
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
    "/cards/hybrid/limits_setup/map_info/tap"(platform:"/", type: TrackType.Event) {}

    // Request

    // Request: Onboarding
    "/cards/hybrid/request/physical"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/request/physical/onboarding"(platform: "/", type: TrackType.View) {
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
    "/cards/hybrid/request/physical/onboarding/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "continue", "unlock"],
            description: "action tap by the user in the onboarding"
        )
    }

    // Request: Challenge
    "/cards/hybrid/request/physical/challenge/success"(platform: "/", type: TrackType.Event) {
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
    "/cards/hybrid/request/physical/success"(platform: "/", type: TrackType.Event) {
        reasons (
            required: true,
            type: PropertyType.ArrayList(PropertyType.String),
            description: "list of reasons that allow to do the request flow"
        )
    }
    
    // CARD IDENTIFICATION
    // --------
    "/cards/hybrid/card_identification"(platform: "/", type: TrackType.View) {}

    // CARD REQUEST init point
    // --------
    "/cards/hybrid/request/init_point"(platform: "/", type: TrackType.View) {}

     // CARD REQUEST physical init point
    // --------
    "/cards/hybrid/request/physical/init_point"(platform: "/", type: TrackType.View) {}

     // CARD REQUEST virtual init point
    // --------
    "/cards/hybrid/request/virtual/init_point"(platform: "/", type: TrackType.View) {}

    // CARD REQUEST virtual on boarding
    // --------
    "/cards/hybrid/request/virtual/onboarding"(platform: "/", type: TrackType.View) {
        context (
            required: false,
            type: PropertyType.String,
            values: ["no_kyc", "kyc", "onboarding_shown"],
            description: "type of onboarding",
            inheritable:false
        )
    }
    "/cards/hybrid/request/virtual/onboarding/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "continue"],
            description: "Button tapped"
        )
    }

    // Hybrid Detail
    "/cards/mp-card/hybrid/detail" (platform: "/web", type: TrackType.View) {} 
    // Hybrid downloadApp Event
    "/cards/mp-card/hybrid/detail/download-app" (platform:"/web", type: TrackType.Event) {
    	osName (
    		required: false,
            type: PropertyType.String,
            description: "Device OS"
    		)
    }
    // Hybrid sendSMS Event
    "/cards/mp-card/hybrid/detail/send-sms" (platform: "/web", type: TrackType.Event) {
        status (
            required: true,
            type: PropertyType.String,
            values: ["OK", "ERROR"],
            description: "Status send sms"
        )
    } 
    // Hybrid clickSendMessage Event
    "/cards/mp-card/hybrid/detail/click-send-message" (platform: "/web/desktop", type: TrackType.Event) { } 

    // Request: Success Virtual
    "/cards/hybrid/request/virtual/success"(platform: "/", type: TrackType.Event) {
        reasons (
            required: true,
            type: PropertyType.ArrayList(PropertyType.String),
            description: "list of reasons that allow to do the request flow"
        )
    }

    //COACHMARK
    // --------
    "/cards/hybrid/coachmark/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close", "next", "previous"],
            description: "Coachmark action tapped"
        )
        step (
            required: true,
            type: PropertyType.Numeric,
            description: "The coachmark is a guide. This may have multiple steps. It states the number of it"
        )
        id (
            required: true,
            type: PropertyType.String,
            values: ["dashboard_virtual_coachmark", "dashboard_physical_coachmark", "setup_virtual_debit_coachmark", "setup_virtual_credit_coachmark"],
            description: "Coachmark id"
        )
    }
    
    // OPTIONS
    // --------


    propertyDefinitions {
        product_type(
            type: PropertyType.String,
            required: false,
            values: [
                'virtual_debit',
                'virtual_prepaid',
                'virtual_credit',
                'virtual_hybrid',
                'virtual_debit_nfc',
                'chip_debit',
                'chip_prepaid',
                'chip_credit',
                'chip_hybrid',
                'chip_debit_nfc',
                'contactless_debit',
                'contactless_debit_contactless',
                'contactless_prepaid',
                'contactless_credit',
                'contactless_credit_contactless',
                'contactless_hybrid',
                'contactless_hybrid_contactless',
                'contactless_debit_nfc',
                'wallet_debit',
                'wallet_prepaid',
                'wallet_credit',
                'wallet_hybrid',
                'wallet_debit_nfc',
            ]
        )
        status(
            type: PropertyType.String,
            required: true,
            values: [
                'active',
                'blocked',
                'delivered',
                'deprecated',
                'depurated',
                'freeze',
                'inactive',
                'pin_blocked'
            ]
        )
        action(
            type: PropertyType.String,
            required: true,
            values: [
                'freeze',
                'unfreeze',
                'reissue',
                'change_limits',
                'change_pin',
                'disable_credit_card'
            ]
        )
    }

    propertyGroups {
        card_group(product_type, status)
    }

    propertyGroups {
        card_action_group(product_type, action)
    }

    def card_map = objectSchemaDefinitions {
        card_group
    }

     "/cards/hybrid/setup/options"(platform: "/", type: TrackType.View) {
         cards(
             required: true,
             type: PropertyType.ArrayList(PropertyType.Map(card_map)),
             inheritable: false
         )
     }

    "/cards/hybrid/setup/options/empty_state"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/setup/options/empty_state/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["primary_button", "secondary_button"],
            inheritable: false
        )
    }


    "/cards/hybrid/setup/options/tap"(platform:"/", type: TrackType.Event) {
        card_action_group
    }

    "/cards/hybrid/setup/options/tap/success"(platform:"/", type: TrackType.Event) {
        card_action_group
    }

    "/cards/hybrid/setup/options/tap/failure"(platform:"/", type: TrackType.Event) {
        card_action_group
    }
    
    // Options message
    "/cards/hybrid/setup/options/message"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/setup/options/message/lock"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/setup/options/message/lock/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["unblock_pin"],
            description: "Message button tapped"
        )
    }

    //Feedback
    "/cards/hybrid/setup/options/feedback"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/setup/options/feedback/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["research_form"],
            description: "Feedback button tapped"
        )
    }

    //Feedback for virtual credit card
    "/cards/hybrid/setup/options/feedback/credit"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/setup/options/feedback/credit/tap"(platform:"/", type: TrackType.Event) {
        action (
                required: true,
                type: PropertyType.String,
                values: ["research_form"],
                description: "Feedback button tapped"
        )
    }

    // Semaphore
    //-------------------
    "/cards/hybrid/setup/options/semaphore"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/setup/options/semaphore/render"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: [
                "configured", 
                "not_configured", 
                "not_tokenized", 
                "tokenized_in_progress", 
                "privder_suspended"
            ],
            description: "Semaphore State"
        )
    }
    "/cards/hybrid/setup/options/semaphore/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: [
                "configured", 
                "not_configured"
            ],
            description: "Semaphore Tap"
        )
    }
    // Cards Helper
    //--------------
    "/cards/hybrid/card_helper"(platform: "/", isAbstract: true) {}
    "/cards/hybrid/card_helper/extraction"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable:false
        )
    }
    "/cards/hybrid/card_helper/extraction/contingency"(platform: "/", type: TrackType.View) {
        card_id (
            required: true,
            type: PropertyType.String,
            description: "Card id",
            inheritable:false
        )
    }
    "/cards/hybrid/card_helper/extraction/contingency/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["back_button"],
            description: "Action Tapped"
        )
    }
    
    // ENROLLMENT-HUB-NFC
    //-------------------
    "/cards/nfc/enrollment/hub"(platform: "/", type: TrackType.View) {
        nfc_card_id (
            required: true,
            type: PropertyType.String,
            description: "The user NFC card id",
            inheritable: false
        )
        need_show_only_error_message_in_configuration_hub (
            required: true,
            type: PropertyType.Boolean,
            description: "User error message status",
            inheritable: false
        )
        tokenization_error (
            required: true,
            type: PropertyType.Boolean,
            description: "Tokenization error status",
            inheritable: false
        )
        nfc_has_pin_setted (
            required: true,
            type: PropertyType.Boolean,
            description: "User nfc card pin status",
            inheritable: false
        )
        nfc_is_freezed (
            required: true,
            type: PropertyType.Boolean,
            description: "User nfc card freeze status",
            inheritable: false
        )
        has_physical_card (
            required: true,
            type: PropertyType.Boolean,
            description: "If user already has a physical card",
            inheritable: false
        )
        is_nfc_enabled (
            required: true,
            type: PropertyType.Boolean,
            description: "Checks if NFC is turned on",
            inheritable: false
        )
        is_tap_and_pay_setted (
            required: true,
            type: PropertyType.Boolean,
            description: "Checks if MP is the default Tap&Pay app",
            inheritable: false
        )
        is_restrictive_mode_occupied (
            required: true,
            type: PropertyType.Boolean,
            description: "Checks if MP can replace the default Tap&Pay app",
            inheritable: false
        )
    }
    "/cards/nfc/enrollment/hub/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            description: "Action Tapped"
        )
    }
    "/cards/nfc/enrollment/hub/step/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["step_tap_and_pay","step_pin","step_nfc"],
            description: "Step Button Tapped"
        )
    }
    "/cards/nfc/enrollment/hub/redirect"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["success_redirect"],
            description: "Redirection Done"
        )
    }
    "/cards/nfc/enrollment/hub/incomplete_steps"(platform: "/", type: TrackType.Event) {
        result (
            required: true,
            type: PropertyType.Numeric,
            description: "Amount of incomplete steps"
        )
        incomplete_steps (
            required: true,
            type: PropertyType.String,
            values: [
                "pin_tnp_nfc",
                "tnp_nfc",
                "pin_nfc",
                "pin_tnp",
                "pin",
                "tnp",
                "nfc",
                "all_complete"
            ]
        )
    }
    
    // CONFFIGURATION-HUB-NFC
    //-------------------
    "/cards/nfc/configuration/hub"(platform: "/", type: TrackType.View) {
        nfc_card_id (
            required: true,
            type: PropertyType.String,
            description: "The user NFC card id",
            inheritable: false
        )
        need_show_only_error_message_in_configuration_hub (
            required: true,
            type: PropertyType.Boolean,
            description: "User error message status",
            inheritable: false
        )
        tokenization_error (
            required: true,
            type: PropertyType.Boolean,
            description: "Tokenization error status",
            inheritable: false
        )
        nfc_has_pin_setted (
            required: true,
            type: PropertyType.Boolean,
            description: "User nfc card pin status",
            inheritable: false
        )
        nfc_is_freezed (
            required: true,
            type: PropertyType.Boolean,
            description: "User nfc card freeze status",
            inheritable: false
        )
        has_physical_card (
            required: true,
            type: PropertyType.Boolean,
            description: "If user already has a physical card",
            inheritable: false
        )
        is_nfc_enabled (
            required: true,
            type: PropertyType.Boolean,
            description: "Checks if NFC is turned on",
            inheritable: false
        )
        is_tap_and_pay_setted (
            required: true,
            type: PropertyType.Boolean,
            description: "Checks if MP is the default Tap&Pay app",
            inheritable: false
        )
        is_restrictive_mode_occupied (
            required: true,
            type: PropertyType.Boolean,
            description: "Checks if MP can replace the default Tap&Pay app",
            inheritable: false
        )
    }
    "/cards/nfc/configuration/hub/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["back","primary_button","secondary_button","contextual_help","feedback"],
            description: "Action Tapped"
        )
    }
    "/cards/nfc/configuration/hub/step/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["step_tap_and_pay","step_pin","step_nfc","step_nfc_freeze"],
            description: "Step Button Tapped"
        )
    }
    "/cards/nfc/configuration/hub/redirect"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["success_redirect"],
            description: "Redirection Done"
        )
    }

    // CREATE-CARD-NFC
    //-------------------
    "/cards/nfc/acquisition/create_nfc_card"(platform: "/", type: TrackType.View) {}
    
    "/cards/nfc/acquisition/create_nfc_card/redirect"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            description: "Redirect deeplink"
        )
    }
    
    // NFC-KYC
    //-------------------
    "/cards/nfc/acquisition/init_nfc_kyc"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            description: "Deeplink"
        )
    }
    
    
    // ONBOARDING-NFC
    //-------------------
    "/cards/nfc/enrollment/hub/onboarding"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/enrollment/hub/onboarding/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            description: "Button tapped"
        )
        kyc_status (
            required: true,
            type: PropertyType.String,
            description: "User kyc status"
        )
    }
    
    // Block-Page-NFC
    "/cards/nfc/block_page/not_nfc_device"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/block_page/acquisition_rollout"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/block_page/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["secondary","primary"],
            description: "Block Page for non NFC Users"
        )
        type (
            required: true,
            type: PropertyType.String,
            values: ["not_nfc_device","acquisition_rollout"],
            description: "Type of Block Page"
        )
    }
    "/cards/nfc/block_page/not_nfc_device/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close"],
            description: "Close Button Tapped"
        )
    }
    "/cards/nfc/block_page/acquisition_rollout/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["close"],
            description: "Close Button Tapped"
        )
    }


    // ENROLLMENT-NFC

    "/cards/nfc/enrollment/success"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["enrollment_worker_success"],
            description: "Enrollment worker success"
        )
    }

    "/cards/nfc/enrollment/attempts"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["enrollment_worker_attempts"],
            inheritable: false,
            description: "Enrollment worker attempts"
        )
        result (
            required: true,
            type: PropertyType.Numeric,
            inheritable: false,
            description: "Count enrollment worker attemps"
        )
    }

    "/cards/nfc/enrollment/attempts/error"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["worker_max_attempts"],
            description: "Max Enrollment worker attempts"
        )
        result (
            required: true,
            type: PropertyType.Numeric,
            description: "Count enrollment worker attemps"
        )
    }

    "/cards/nfc/enrollment/time"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["enrollment_worker_async_success_time"],
            description: "Enrollment worker success time"
        )
        result (
            required: true,
            type: PropertyType.Numeric,
            description: "Time in milliseconds for enrollment worker completed time"
        )
    }

    // ENROLLMENT-NFC-TOKENIZATION
    // -------------------

    "/cards/nfc/enrollment/tokenization/user_token"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["user_has_token",
                     "not_token_ready_for_user"],
            description: "Result if user has token"
        )
        result (
            required: true,
            type: PropertyType.String,
            values: ["EnrollmentWorker: User has not token.. Process checkCardEligibility...",
                     "EnrollmentWorker: User already has a token. Aborting enrollment..."],
            description: "Check if user has token"
        )
    }

    "/cards/nfc/enrollment/tokenization/wipe_data/success"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["wipe_data_success"],
            description: "Wipe data result success"
        )
    }

    "/cards/nfc/enrollment/tokenization/wipe_data/error"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["wipe_data_error"],
            description: "Wipe data result error"
        )
    }

    "/cards/nfc/enrollment/tokenization/waiting_time"(platform:"/", type: TrackType.Event) {
        time_millis (
            required: true,
            type: PropertyType.Numeric,
            inheritable: false,
            description: "Tokenization process in milliseconds"
        )
        action (
            required: true,
            type: PropertyType.String,
            inheritable: false,
            values: ["tokenization_success_total_time",
                     "user_waiting_start_time_payments_available",
                     "user_waiting_finish_time_payments_available"],
            description: "Type of tokenization state time"
        )
    }

    "/cards/nfc/enrollment/tokenization/waiting_time/error"(platform:"/", type: TrackType.Event) {
        time_millis (
            required: true,
            type: PropertyType.Numeric,
            description: "Tokenization error process in milliseconds"
        )
        action (
            required: true,
            type: PropertyType.String,
            values: ["tokenization_error"],
            description: "Tokenization stop error time"
        )
    }

    "/cards/nfc/enrollment/tokenization/new_card_push/success"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["new_card_push_received_success"],
            description: "Enrollment token was provisioned"
        )
        information (
            required: true,
            type: PropertyType.String,
            values:["tokenization completed event"],
            description: "Tokenization completed token provisioned"
        )
    }

    "/cards/nfc/enrollment/tokenization/new_card_push/error"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["missing_new_card_push_notification"],
            description: "Miss enrollment notification"
        )
        result (
            required: true,
            type: PropertyType.String,
            values: ["Missing token provisioning push"],
            description: "Miss push notification for nfc enrollment"
        )
    }

    "/cards/nfc/enrollment/tokenization/new_card_push/waiting_time"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["push_provisioned_delay_time"],
            inheritable: false,
            description: "New card push total received time"
        )
        result (
            required: true,
            type: PropertyType.Numeric,
            inheritable: false,
            description: "Time in milliseconds for total time received new card push"
        )
    }

    "/cards/nfc/enrollment/tokenization/new_card_push/attempts"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["new_card_push_attempts"],
            description: "Type of token provisioned attempts"
        )
        result (
            required: true,
            type: PropertyType.Numeric,
            description: "Numbers of Attempts to token provisioned"
        )
    }

    "/cards/nfc/enrollment/fetch_card_data/success"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["fetch_data_success"],
            description: "Type fetch data result value"
        )
    }

    "/cards/nfc/enrollment/fetch_card_data/error"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["fetch_data_error", "fetch_data_http_error"],
            description: "Type fetch data information value"
        )
        information (
            required: true,
            type: PropertyType.String,
            values: ["fetchTokenizationDataWorker error",
                     "fetchTokenizationDataWorker HTTP_NOT_FOUND or HTTP_UNAVAILABLE error"],
            description: "Fetch data error information"
        )
    }

    "/cards/nfc/enrollment/fetch_card_data/attempts"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["fetch_tokenize_worker_attempts"],
            inheritable: false,
            description: "Type try fetch card data attempts"
        )
        result (
            required: true,
            type: PropertyType.Numeric,
            inheritable: false,
            description: "Fetch card data attempts"
        )
    }

    "/cards/nfc/enrollment/fetch_card_data/attempts/error"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["worker_max_attempts"],
            description: "Type try fetch card data attempts"
        )
        result (
            required: true,
            type: PropertyType.Numeric,
            description: "Fetch card data max attempts"
        )
    }


    // CORE-NFC

    "/cards/nfc/core/service/start"(platform: "/", type: TrackType.Event) {
        context (
            required: true,
            type: PropertyType.String,
            description: "Check if nfc sdk start service!"
        )
    }

    "/cards/nfc/core/service/success"(platform: "/", type: TrackType.Event) {
        action (
            required: false,
            type: PropertyType.String,
            description: "Check is nfc service is success"
        )
    }

    "/cards/nfc/core/service/sdk_is_initialized"(platform: "/", type: TrackType.Event) {
        context (
            required: true,
            type: PropertyType.String,
            description: "Check if nfc sdk is already initialized!"
        )
    }

    "/cards/nfc/core/service/error"(platform: "/", type: TrackType.Event) {
        action (
            required: false,
            type: PropertyType.String,
            description: "Nfc sdk is initialized error"
        )

        error_code (
            required: false,
            type: PropertyType.String,
            description: "Type of sdk init errors"
        )

        error_message(
            required: false,
            type: PropertyType.String,
            description: "Error message sdk init"
        )

        from(
            required: true,
            type: PropertyType.String,
            description: "Context from where its sended"
        )
    }

    "/cards/nfc/core/service/life_cycle_initialize"(platform: "/", type: TrackType.Event) { }

    "/cards/nfc/core/service/sdk_not_initialized"(platform: "/", type: TrackType.Event) {
        from (
            required: true,
            type: PropertyType.String,
            description: "Context from where its sended"
        )
    }

    "/cards/nfc/core/service/initializer/attempts"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values:["sdk_init_attempts"],
            inheritable: false,
            description: "Type sdk init attempts"
        )
        result (
            required: true,
            type: PropertyType.Numeric,
            inheritable: false,
            description: "Init sdk attempts"
        )
    }

    "/cards/nfc/core/service/initializer/attempts/error"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values:["worker_max_attempts"],
            description: "Sdk init max attempts"
        )
        result (
            required: true,
            type: PropertyType.Numeric,
            description: "Max sdk attempts"
        )
    }


    "/cards/nfc/core/service/start_secure_enrollment/success"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values:["start_secure_enrollment_success"],
            description: "Start secure enrollment success"
        )
    }

    "/cards/nfc/core/service/start_secure_enrollment/error"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values:["start_secure_enrollment_error"],
            description: "Start secure enrollment error"
        )
        error_code (
            type: PropertyType.String,
            required: true,
            values: [
                'wse_internal_error',
                'common_no_internet',
                'common_comm_error',
                'common_server_error',
                're_enrollment_required',
                'wse_storage_access_error',
                'json_parsing_error',
                'wse_request_error',
                'wse_download_error',
            ],
            description: "Type of sdk errors code"
        )

        error_message(
            type: PropertyType.String,
            required: false,
            description: "Type of sdk error message"
        )
    }

    "/cards/nfc/enrollment/replenish_payment_keys/success"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values:["replenish_payment_keys_success"],
            description: "Replenish payment keys success"
        )
    }

    "/cards/nfc/enrollment/replenish_payment_keys/error"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values:["replenish_payment_keys_error"],
            description: "Replenish payment keys error"
        )

        error_code (
            type: PropertyType.String,
            required: true,
            values: [
                'common_no_internet',
                'common_comm_error',
                'common_server_error',
                'enrollment_wrong_credentials',
                'enrollment_credential_expired',
                'enrollment_try_limit_exceeded',
                'card_activation_activation_code_entry_canceled',
                'card_activation_mobile_pin_invalid_length',
                'card_activation_mobile_pin_mismatch',
                'change_pin_reentry_mismatch',
                'change_pin_card_not_active',
                'change_pin_card_not_exist',
                're_enrollment_required',
                'card_not_enrolled',
                'card_state_unknown',
                'replenishment_not_allowed',
                'sdk_internal_component_error',
                'enrollment_wrong_activation_code',
                'enrollment_blocked_secure_wallet_enrollment_required',
                'replenishment_blocked_secure_wallet_enrollment_required',
                'invalid_replenish_missing_payment',
                'asm_error',
                'invalid_digitalcardid',
            ],
            description: "Type of sdk errors code"
        )

        error_message(
            type: PropertyType.String,
            required: false,
            description: "Type of sdk error message"
        )
    }

    "/cards/nfc/enrollment/device_enrollment/success"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values:["device_enrollment_success"],
            description: "Device enrollment success"
        )
    }

    "/cards/nfc/enrollment/device_enrollment/error"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["device_enrollment_error"],
            description: "Type of device enrollment values"
        )

        error_code (
            type: PropertyType.String,
            required: true,
            values: [
                'common_no_internet',
                'common_comm_error',
                'common_server_error',
                'enrollment_wrong_credentials',
                'enrollment_credential_expired',
                'enrollment_try_limit_exceeded',
                'card_activation_activation_code_entry_canceled',
                'card_activation_mobile_pin_invalid_length',
                'card_activation_mobile_pin_mismatch',
                'change_pin_reentry_mismatch',
                'change_pin_card_not_active',
                'change_pin_card_not_exist',
                're_enrollment_required',
                'card_not_enrolled',
                'card_state_unknown',
                'replenishment_not_allowed',
                'sdk_internal_component_error',
                'enrollment_wrong_activation_code',
                'enrollment_blocked_secure_wallet_enrollment_required',
                'replenishment_blocked_secure_wallet_enrollment_required',
                'invalid_replenish_missing_payment',
                'asm_error',
                'invalid_digitalcardid',
            ],
            description: "Type of sdk errors code"
        )

        error_message(
            type: PropertyType.String,
            required: false,
            description: "Type of sdk error message"
        )
    }

    "/cards/nfc/enrollment/check_card_eligibility/success"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values:["check_card_eligility_service_success"],
            description: "Check card eligibility success"
        )
    }

    "/cards/nfc/enrollment/check_card_eligibility/result"(platform: "/", type: TrackType.Event) {
        action (
            type: PropertyType.String,
            required: true,
            values: ["check_card_eligibility_result"],
            description: "Type of check card eligibility result values"
        )
        result (
            type: PropertyType.String,
            required: true,
            values: ["SUCCESS",
                     "FAILURE_DEFAULT",
                     "FAILURE_API_ERROR",
                     "PARTIAL_ENROLLMENT",
                     "BLOCKED_WSE_REQUIRED"],
            description: "Type of check card eligibility result values"
        )
    }

    "/cards/nfc/enrollment/check_card_eligibility/error"(platform: "/", type: TrackType.Event) {
        action (
            type: PropertyType.String,
            required: true,
            values: ["check_card_eligibility_service_error", "card_info_failed"],
            description: "Type of check card eligibility error values"
        )

        error_code (
            type: PropertyType.String,
            required: false,
            values: [
                'no_internet',
                'connection_timeout',
                'communication_error',
                'server_error',
                'internal_error',
                'fpan_not_eligible',
                'unknown_bin',
                'unknown_card_product',
                'card_product_not_supported',
                'incorrect_cvv',
                'card_already_provisioned_in_wallet',
                'device_not_eligible',
                'resource_not_found',
                'incorrect_authentication_token',
                'card_provisioning_count_exceeded',
                'unkonown_idv_method',
                'provisioning_not_allowed',
                'incorrect_otp',
                'incorrect_otp_max_try_exceeded',
                'otp_expired',
                'idv_method_not_available',
                'unexpected_internal_error',
                'external_system_unavailable',
                'unknown_wallet_provider_id',
                'unknown_wallet_id',
                'unknown_digital_card_id',
                'unknown_correlation_id',
                'card_state_does_not_allow_requested_operation',
                'operation_already_ongoing',
                'operation_failed',
                'unknown_device_id',
                'missing_required_parameter',
                'unknown_issuer_id',
                'unknown_card_id',
                'no_tnc_resource_id',
                'invalid_tnc_data_type',
                'securestorage_write_config_data_error',
                'securestorage_wipe_all_error',
                'context_missing_error',
                'web_3ds_authentication_failed',
                'web_3ds_data_error',
                'invalid_card_data',
                'no_card_meta_data',
                'card_meta_data_json_error',
                'no_card_data',
                'invalid_asset_type',
                'invalid_asset_version',
                'asset_not_available',
                'blocked_secure_wallet_enrollment_required',
            ],
            description: "Type of sdk errors code"
        )

        error_message(
            type: PropertyType.String,
            required: false,
            description: "Error message description"
        )
    }

    "/cards/nfc/enrollment/digitize_card/success"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values:["digitize_card_service_success"],
            description: "Digitize card success"
        )
    }

    "/cards/nfc/enrollment/digitize_card/result"(platform: "/", type: TrackType.Event) {
        action (
            type: PropertyType.String,
            required: true,
            values: ["digitize_card_result"],
            description: "Digitize card result"
        )
        result (
            type: PropertyType.String,
            required: true,
            values: ["SUCCESS", "FAILURE", "CAN_NOT_PROCEED"],
            description: "Type of digitize card result values"
        )
    }

    "/cards/nfc/enrollment/digitize_card/error"(platform: "/", type: TrackType.Event) {
        action (
            type: PropertyType.String,
            required: true,
            values: ["digitize_card_service_error"],
            description: "Type of digitize card values"
        )

        error_code (
            type: PropertyType.String,
            required: true,
            values: [
                'no_internet',
                'connection_timeout',
                'communication_error',
                'server_error',
                'internal_error',
                'fpan_not_eligible',
                'unknown_bin',
                'unknown_card_product',
                'card_product_not_supported',
                'incorrect_cvv',
                'card_already_provisioned_in_wallet',
                'device_not_eligible',
                'resource_not_found',
                'incorrect_authentication_token',
                'card_provisioning_count_exceeded',
                'unkonown_idv_method',
                'provisioning_not_allowed',
                'incorrect_otp',
                'incorrect_otp_max_try_exceeded',
                'otp_expired',
                'idv_method_not_available',
                'unexpected_internal_error',
                'external_system_unavailable',
                'unknown_wallet_provider_id',
                'unknown_wallet_id',
                'unknown_digital_card_id',
                'unknown_correlation_id',
                'card_state_does_not_allow_requested_operation',
                'operation_already_ongoing',
                'operation_failed',
                'unknown_device_id',
                'missing_required_parameter',
                'unknown_issuer_id',
                'unknown_card_id',
                'no_tnc_resource_id',
                'invalid_tnc_data_type',
                'securestorage_write_config_data_error',
                'securestorage_wipe_all_error',
                'context_missing_error',
                'web_3ds_authentication_failed',
                'web_3ds_data_error',
                'invalid_card_data',
                'no_card_meta_data',
                'card_meta_data_json_error',
                'no_card_data',
                'invalid_asset_type',
                'invalid_asset_version',
                'asset_not_available',
                'blocked_secure_wallet_enrollment_required',
            ],
            description: "Type of sdk errors code"
        )

        error_message(
            type: PropertyType.String,
            required: false,
            description: "Type of sdk error message"
        )
    }

    "/cards/nfc/enrollment/partial_enrollment/success"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values:["delete_card_push_received_success"],
            description: "Delete card push received success process to partial enrollment"
        )
    }

    "/cards/nfc/enrollment/partial_enrollment/delete_card_result"(platform: "/", type: TrackType.Event) {
        action (
            type: PropertyType.String,
            required: true,
            values: ["delete_card_result"],
            description: "Delete card result"
        )
        result (
            type: PropertyType.String,
            required: true,
            values: ["SUCCESS",
                     "UNKNOWN_DIGITAL_CARD_ID",
                     "FAILURE",
                     "CONNECTION_ERROR"],
            description: "Type of delete card result values"
        )
    }

    "/cards/nfc/enrollment/partial_enrollment/error"(platform: "/", type: TrackType.Event) {
        action (
            type: PropertyType.String,
            required: true,
            values: ["delete_card_service_error",
                     "delete_card_failed",
                     "delete_card_push_error"],
            description: "Type of delete card values for partial enrollment"
        )

        error_code (
            type: PropertyType.String,
            required: false,
            values: [ 'no_internet',
                      'connection_timeout',
                      'communication_error',
                      'server_error',
                      'internal_error',
                      'fpan_not_eligible',
                      'unknown_bin',
                      'unknown_card_product',
                      'card_product_not_supported',
                      'incorrect_cvv',
                      'card_already_provisioned_in_wallet',
                      'device_not_eligible',
                      'resource_not_found',
                      'incorrect_authentication_token',
                      'card_provisioning_count_exceeded',
                      'unkonown_idv_method',
                      'provisioning_not_allowed',
                      'incorrect_otp',
                      'incorrect_otp_max_try_exceeded',
                      'otp_expired',
                      'idv_method_not_available',
                      'unexpected_internal_error',
                      'external_system_unavailable',
                      'unknown_wallet_provider_id',
                      'unknown_wallet_id',
                      'unknown_digital_card_id',
                      'unknown_correlation_id',
                      'card_state_does_not_allow_requested_operation',
                      'operation_already_ongoing',
                      'operation_failed',
                      'unknown_device_id',
                      'missing_required_parameter',
                      'unknown_issuer_id',
                      'unknown_card_id',
                      'no_tnc_resource_id',
                      'invalid_tnc_data_type',
                      'securestorage_write_config_data_error',
                      'securestorage_wipe_all_error',
                      'context_missing_error',
                      'web_3ds_authentication_failed',
                      'web_3ds_data_error',
                      'invalid_card_data',
                      'no_card_meta_data',
                      'card_meta_data_json_error',
                      'no_card_data',
                      'invalid_asset_type',
                      'invalid_asset_version',
                      'asset_not_available',
                      'blocked_secure_wallet_enrollment_required'],
            description: "Type of sdk errors code"
        )

        error_message(
            type: PropertyType.String,
            required: false,
            description: "Error message description"
        )
    }

    "/cards/nfc/enrollment/tokenization/messageprocessor"(platform: "/", type: TrackType.Event) {
        information (
                required: true,
                type: PropertyType.String,
                description: "Message processor information",
                inheritable: false
        )
    }

    // PAYMENTS-NFC
    // -------------------
    "/cards/nfc/payment"(platform: "/", type: TrackType.View) {
        from (
            required: true,
            type: PropertyType.String,
            inheritable: false,
            description: "Access location of NFCPayment call"
        )
    }
    "/cards/nfc/payment/tap_pos"(platform:"/", type: TrackType.Event) {
        result (
            required: true,
            type: PropertyType.String,
            description: "Tap payment error transaction"
        )
        reasons (
            required: true,
            type: PropertyType.String,
            description: "Error code of the payment tap pos error"
        )
    }
    "/cards/nfc/payment/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["faq"],
            description: "Help button tapped"
        )
    }
    "/cards/nfc/payment/intention"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/payment/intention/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            description: "Main Button Tapped")
    }
    "/cards/nfc/payment/pos_contact"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/payment/waiting_payment"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/payment/waiting_payment/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["money_in"],
            description: "Add money tapped"
        )
    }

    // Nfc Payments User Without Money

    "/cards/nfc/payment/without_money"(platform: "/", type: TrackType.View) {}

    "/cards/nfc/payment/without_money/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            description: "Button Pressed"
        )
    }

    // NFC Payments Congrats

    "/cards/nfc/payment/congrats"(platform: "/", type: TrackType.View) {
        status (
            required: true,
            type: PropertyType.String,
            values: ["success", "unknown", "generic"],
            description: "Type of congrats",
            inheritable: false
        )
    }

    "/cards/nfc/payment/congrats/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["finish", "primary", "secondary"],
            description: "Deeplink"
        )
    }

    "/cards/nfc/payments/congrats/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["finish", "primary", "secondary"],
            description: "Finish button tapped"
        )
        type (
            required: true,
            type: PropertyType.String,
            description: "Congrats Type"
        )
    }

    "/cards/nfc/acquisition/congrats"(platform: "/", type: TrackType.View) {}

    "/cards/nfc/acquisition/congrats/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["finish", "primary", "secondary"],
            description: "Finish button tapped"
        )
        type (
            required: true,
            type: PropertyType.String,
            description: "Congrats Type"
        )
    }


    "/cards/nfc/congrats/insufficient_money"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/congrats/blocked_pin"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/congrats/connection_error"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/congrats/invalid_pin"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/congrats/generic_tap_pos_error"(platform: "/", type: TrackType.View) {}
    "/cards/nfc/congrats/generic_error"(platform: "/", type: TrackType.View) {}

    // NFC - Congrats

    "/cards/nfc/congrats/create_nfc_card_error"(platform: "/", type: TrackType.View) {}

    // NFC - Feature

    "/cards/nfc/feature/availability"(platform: "/", type: TrackType.Event) {}

    // NFC-INFORMATIVE-SCREEN
    // ----------------------
    
    "/cards/nfc/enrollment/instructions"(platform: "/", type: TrackType.View) {
        has_money (
            required: true,
            type: PropertyType.Boolean,
            description: "If user has money",
            inheritable: false
        )
    }
    
    
    "/cards/nfc/enrollment/instructions/tap"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            description: "Finish button tapped"
        )
    }

    // NFC-DEVICE-CVM
    // -------------------------------

    "/cards/nfc/enrollment/devicecvm"(platform: "/", type: TrackType.Event) {
        status (
            required: true,
            type: PropertyType.String,
            description: "Device cvm status information"
        )
    }


    "/cards/nfc/enrollment/devicecvm/no_security"(platform:"/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            values: ["tokenization_error"],
            description: "Tokenization not initialized"
        )
    }

    // NFC-FEATURE-IGNITE-STATUS
    // ----------------------
    
    "/cards/nfc/core/ignite"(platform: "/", type: TrackType.Event) {
        value (
            required: true,
            type: PropertyType.Boolean,
            description: "Ignite status for this user"
        )
    }

    // NFC-CONSTRAINTS
    // -----------
    
    // NfcConstraintUpdate
    
    "/cards/nfc/constraint/update"(platform: "/", type: TrackType.Event) {
        action (
            required: true,
            type: PropertyType.String,
            description: "Determinates if we are sending o receiving the event"
        )
        event (
            required: true,
            type: PropertyType.String,
            description: "The event that changed"
        )
    }

    // NFC-SEMAPHORE
    // -----------
    
    // NfcSemaphoreStatus
    
    "/cards/nfc/semaphore/constraints"(platform: "/", type: TrackType.Event) {
        has_nfc_card_created (
            required: true,
            type: PropertyType.Boolean,
        )
        has_active_nfc_card (
            required: true,
            type: PropertyType.Boolean,
        )
        has_pin (
            required: true,
            type: PropertyType.Boolean,
        )
        is_nfc_payments_initialized (
            required: true,
            type: PropertyType.Boolean,
        )
        is_token_ready (
            required: true,
            type: PropertyType.Boolean,
        )
        is_token_active (
            required: true,
            type: PropertyType.Boolean,
        )
        is_default_tap_n_pay (
            required: true,
            type: PropertyType.Boolean,
        )
        is_restrictive (
            required: true,
            type: PropertyType.Boolean,
        )
        is_tap_n_pay_admitted_to_pay (
            required: true,
            type: PropertyType.Boolean,
        )
        is_default_card (
            required: true,
            typement: PropertyType.Boolean,
        )
        is_nfc_activated (
            required: true,
            type: PropertyType.Boolean,
        )
        are_payment_keys_avaliable (
            required: true,
            type: PropertyType.Boolean,
        )
    }
    
    // NFC-PRODUCT-METRICS
    // -------------------
    
    // NFC status
    
    "/cards/nfc/status"(platform: "/", type: TrackType.Event) {
        restrictiveness (
            required: true,
            type: PropertyType.String,
            values: [
                'restrictive',
                'not_restrictive'
            ]
        )
        default_app (
            required: true,
            type: PropertyType.String,
            values: [
                "default",
                "not_default"
            ]
        )
    }

    // NFC_ONDEMAND_ENROLLMENT
    // -----------------------
    "/cards/nfc/enrollment/ondemand"(platform: "/", type: TrackType.Event) {}

    "/cards/nfc/enrollment/ondemand/success"(platform: "/", type: TrackType.Event) {}

    "/cards/nfc/enrollment/ondemand/error"(platform: "/", type: TrackType.Event) {
        error_message (
            required: true,
            type: PropertyType.String,
            description: "Cause of on-demand enrollment error"
        )
    }
}
