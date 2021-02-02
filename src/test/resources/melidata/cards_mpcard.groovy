package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    //-----------------
    // mpcard MP
    //-----------------

    defaultBusiness = "mercadopago"

    // SHIPPING
    // --------

    //Shipping: Tracking
    test("cards mpcard shipping tracking") {
        "/cards/mpcard/shipping/tracking"(platform: "/", type: TrackType.View) {
            unlock_banner_is_present = false
            contact_is_present = true
            setup_virtual_banner_is_present = true
        }
        "/cards/mpcard/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
            action = "contact"
        }
        "/cards/mpcard/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
            component_id = "banner_unlock"
        }

    }

    //Shipping: Delayed
    test("cards mpcard shipping delayed") {
        "/cards/mpcard/shipping/delayed"(platform: "/", type: TrackType.View) {
            context = "stolen"
        }
        "/cards/mpcard/shipping/delayed/tap"(platform:"/", type: TrackType.Event) {
            action = "reissue"
        }
    }

    // UNLOCK
    // ------

     // Unlock: Init point
    test("cards mpcard unlock init point") {
        "/cards/mpcard/unlock/init-point"(platform: "/", type: TrackType.View) {}
    }

    // Unlock: Scanner
    test("cards mpcard unlock scanner") {
        "/cards/mpcard/unlock/scanner"(platform: "/", type: TrackType.View) {}
        "/cards/mpcard/unlock/scanner/link"(platform:"/", type: TrackType.Event) {
            action = "qr"
        }
        "/cards/mpcard/unlock/scanner/link"(platform:"/", type: TrackType.Event) {
            action = "manual"
        }
        "/cards/mpcard/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "initializing"
        }
        "/cards/mpcard/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "scanning"
        }
        "/cards/mpcard/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "resolving"
        }
        "/cards/mpcard/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "failed"
        }
    }

    test("cards mpcard unlock scanner help") {
        "/cards/mpcard/unlock/scanner/help"(platform: "/", type: TrackType.Event) {}
    }

    // Unlock: Manual Link
    test("cards mpcard unlock manual link") {
        "/cards/mpcard/unlock/manual-link"(platform: "/", type: TrackType.View) {}
        "/cards/mpcard/unlock/manual-link/tap"(platform:"/", type: TrackType.Event) {
            action = "link"
        }
        "/cards/mpcard/unlock/manual-link/invalid_code"(platform: "/", type: TrackType.Event) {}
    }

    // Unlock: Confirm Link
    test("cards mpcard unlock confirm link") {
        "/cards/mpcard/unlock/confirm-link"(platform: "/", type: TrackType.View) {}
        "/cards/mpcard/unlock/confirm-link/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/mpcard/unlock/confirm-link/tap"(platform:"/", type: TrackType.Event) {
            action = "logout"
        }
    }

    // Unlock: Camera Permissions
    test("cards mpcard unlock camera permissions") {
        "/cards/mpcard/unlock/camera-permissions"(platform: "/", type: TrackType.View) {}
        "/cards/mpcard/unlock/camera-permissions/tap"(platform:"/", type: TrackType.Event) {
            action = "qr"
        }
        "/cards/mpcard/unlock/camera-permissions/tap"(platform:"/", type: TrackType.Event) {
            action = "manual"
        }
    }

    // Unlock: Confirm Replacement
    test("cards mpcard unlock confirm replacement") {
        "/cards/mpcard/unlock/confirm-replacement"(platform: "/", type: TrackType.View) {}
        "/cards/mpcard/unlock/confirm-replacement/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/mpcard/unlock/confirm-replacement/tap"(platform:"/", type: TrackType.Event) {
            action = "exit"
        }
    }

    // Unlock: Set Pin
    test("cards mpcard unlock set pin") {
        "/cards/mpcard/unlock/set-pin"(platform: "/", type: TrackType.View) {}
        "/cards/mpcard/unlock/set-pin/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/mpcard/unlock/set-pin/invalide_pin"(platform: "/", type: TrackType.Event) {}
    }

    // Unlock: Update App
    test("cards mpcard unlock update app") {
        "/cards/mpcard/unlock/update-app"(platform: "/", type: TrackType.View) {}
        "/cards/mpcard/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "update"
        }
        "/cards/mpcard/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "exit"
        }
    }

    // Unlock: Success
    test("cards mpcard unlock success event"){
        "/cards/mpcard/unlock/success"(platform:"/", type: TrackType.Event) {}
    }

    // DASHBOARD
    // --------
    test("cards mpcard dashboard") {
        "/cards/mpcard/dashboard"(platform: "/", type: TrackType.View) {
            dashboard_status = "[minicard, flap, activities, message, account_options, carousel, linear_buttons, account_info]"
            dashboard_banner_status = "virtual_only"
            minicard_status = "virtual_only"
            flap_status = "virtual_only"
            message_status = "warning"
            activities_status = "activities_with_error"
        }
        "/cards/mpcard/dashboard"(platform: "/", type: TrackType.View) {
            dashboard_status = "[minicard, flap, activities, account_options, carousel, linear_buttons, account_info]"
            minicard_status = "virtual_only"
            flap_status = "virtual_only"
            activities_status = "activities"
        }
        "/cards/mpcard/dashboard/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "header_help"
        }
        "/cards/mpcard/dashboard/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "header_help"
        }
    }
    
    //Mini card: Tracking
    test("cards mpcard dashboard mini card tracking") {
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "options"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "card_data"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_delivered"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "mpcard_active"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "debit_active"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_inactive"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "user_need_challenge"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_only"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_pending"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_ready_to_ship"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_not_delivered"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_soon_deliver"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_delayed"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_waiting_for_withdrawal"
        }
        "/cards/mpcard/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_shipped"
        }
    }

     //Physical acquisition stop: Tracking
    test("cards mpcard dashboard physical acquistion stop tracking") {
        "/cards/mpcard/dashboard/physical_acquisition_stop/tap"(platform:"/", type: TrackType.Event) {
            action = "button"
        }
    }

    //Banner: Tracking
    test("cards mpcard dashboard banner tracking") {
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "render"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_inactive"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_only"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "user_need_challenge"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_pending"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_ready_to_ship"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_soon_deliver"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_delayed"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_waiting_for_withdrawal"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_delivered"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_not_delivered"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "kyc_pending_manual_review"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "kyc_not_compliance"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "kyc_compliance"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "debit_active"
        }
        "/cards/mpcard/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "hybrid_active"
        }
    }
    
    //Flap card: Tracking
    test("cards mpcard dashboard flap card tracking") {
        "/cards/mpcard/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
            action = "more_than_one_virtual_active"
        }
        "/cards/mpcard/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_active"
        }
        "/cards/mpcard/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_inactive"
        }
        "/cards/mpcard/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
            action = "never_had_virtual_card"
        }
    }
     
    //Account options: Tracking
    test("cards mpcard dashboard account options") {
        "/cards/mpcard/dashboard/account_options/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
        "/cards/mpcard/dashboard/account_options/tap"(platform:"/", type: TrackType.Event) {
            action = "account_info_modal"
        }
    }
    
    //Linear buttons: Tracking
    test("cards mpcard dashboard linear buttons") {
        "/cards/mpcard/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
            action = "help"
        }
        "/cards/mpcard/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
            action = "call"
        }
        "/cards/mpcard/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
            action = "block"
        }
    }
    
    //Message: Tracking
    test("cards mpcard dashboard message") {
        "/cards/mpcard/dashboard/message/tap"(platform:"/", type: TrackType.Event) {
            action = "blocked_pin"
        }
    }
    
    //Account info: Tracking
    test("cards mpcard dashboard account info") {
        "/cards/mpcard/dashboard/account_info"(platform: "/", type: TrackType.View) {}
        "/cards/mpcard/dashboard/account_info/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }
    
    //Carousel: Tracking
    test("cards mpcard dashboard carousel tapped") {
        "/cards/mpcard/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
            action = "page_0"
        }
        "/cards/mpcard/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
            action = "page_1"
        }
        "/cards/mpcard/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
            action = "page_2"
        }
        "/cards/mpcard/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
            action = "page_3"
        }
        "/cards/mpcard/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
            action = "page_4"
        }
    }
    
    test("cards mpcard dashboard carousel swiped") {
        "/cards/mpcard/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
            action = "page_0"
        }
        "/cards/mpcard/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
            action = "page_1"
        }
        "/cards/mpcard/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
            action = "page_2"
        }
        "/cards/mpcard/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
            action = "page_3"
        }
        "/cards/mpcard/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
            action = "page_4"
        }
    }
    
    //Feedback: Tracking
    test("cards mpcard dasboard feedback") {
        "/cards/mpcard/dashboard/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }

    //Coachmark Banner
    test("cards mpcard dashboard coachmark banner"){
        "/cards/mpcard/dashboard/coachmark_banner"(platform: "/", type: TrackType.Event) {
            action = "close"
            id = "dashboard_virtual"
        }
        "/cards/mpcard/dashboard/coachmark_banner"(platform: "/", type: TrackType.Event) {
            action = "tap"
            id = "dashboard_virtual"
        }
    }

    
    //Map Info: Tracking
    test("cards mpcard dasboard map info") {
        "/cards/mpcard/dashboard/map_info/tap"(platform:"/", type: TrackType.Event) {
            action = "map_info"
        }
    }

    // SETUP VIRTUAL
    // --------

    //Card
    test("cards mpcard setup virtual card tracking") {
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "deprecated"
            has_money = false
        }
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "new"
            has_money = false
        }
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "on_creation"
            has_money = false
        }
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "on_delivery"
            has_money = false
        }
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "delivered"
            has_money = false
        }
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "active"
            has_money = true
        }
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "freeze"
            has_money = false
        }
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "blocked"
            has_money = false
        }
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            has_money = false
        }
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            has_money = false
            experimental_version = "experimental_a"
        }
        "/cards/mpcard/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            has_money = false
            experimental_version = "experimental_b"
        }
    }
    test("cards mpcard setup virtual card taps tracking") {
        "/cards/mpcard/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "card_name_copy"
        }
        "/cards/mpcard/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "card_number_copy"
        }
        "/cards/mpcard/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "card_sec_code_copy"
        }
        "/cards/mpcard/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "additional_message"
        }
         "/cards/mpcard/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "close_modal"
        }
    }

    //Highlighted Row
    test("cards mpcard setup virtual Highlighted Row") {
        "/cards/mpcard/setup/virtual/highlighted_row/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }
    
    //Account options
    test("cards mpcard setup virtual card message") {
        "/cards/mpcard/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
        "/cards/mpcard/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in_experimental_a"
        }
        "/cards/mpcard/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in_experimental_b"
        }
        "/cards/mpcard/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "account_info_modal"
        }
        "/cards/mpcard/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "account_info_modal_experimental_a"
        }
        "/cards/mpcard/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "account_info_modal_experimental_b"
        }
    }

    /// SETUP OPTIONS
    test("cards mpcard setup options") {
        "/cards/mpcard/setup/options"(platform: "/", type: TrackType.View) {
            virtual_status = "active"
            debit_status = "active"
        }
    }
    test("cards mpcard setup options taps") {
        "/cards/mpcard/setup/options"(platform: "/", type: TrackType.View) {}
        "/cards/mpcard/setup/options/tap"(platform:"/", type: TrackType.Event) {
            action = "freeze"
        }
        "/cards/mpcard/setup/options/tap"(platform:"/", type: TrackType.Event) {
            action = "unfreeze"
        }
        "/cards/mpcard/setup/options/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_freeze"
        }
        "/cards/mpcard/setup/options/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_unfreeze"
        }
        "/cards/mpcard/setup/options/tap"(platform:"/", type: TrackType.Event) {
            action = "change_limits"
        }
        "/cards/mpcard/setup/options/tap"(platform:"/", type: TrackType.Event) {
            action = "see_nip"
        }
        "/cards/mpcard/setup/options/tap"(platform:"/", type: TrackType.Event) {
            action = "block_card"
        }
    }
    test("cards mpcard setup options physical locked message") {
        "/cards/mpcard/setup/options/message/lock/tap"(platform:"/", type: TrackType.Event) {
            action = "unlock"
        }
        "/cards/mpcard/setup/options/message/lock/tap"(platform:"/", type: TrackType.Event) {
            action = "reissue"
        }
    }
    test("cards mpcard setup options physical card unlock status") {
        "/cards/mpcard/setup/options/physical/unlock"(platform:"/", type: TrackType.Event) {
            action = "success"
        }
        "/cards/mpcard/setup/options/physical/unlock"(platform:"/", type: TrackType.Event) {
            action = "error"
        }
    }

    
    //Redirect when the user don't have a virtual card
    test("cards mpcard setup virtual card need to redirect in order to create a new virtual card") {
        "/cards/mpcard/setup/virtual/redirect"(platform:"/", type: TrackType.Event) {}
    }

    //Account options
    test("cards mpcard setup virtual card account options") {
        "/cards/mpcard/setup/virtual/account_options/tap"(platform:"/", type: TrackType.Event) {
            action = "account_info_modal"
        }
        "/cards/mpcard/setup/virtual/account_options/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }

    //Account Info
    test("cards mpcard setup virtual card account info") {
        "/cards/mpcard/setup/virtual/account_info"(platform:"/", type: TrackType.View) {}
        "/cards/mpcard/setup/virtual/account_info/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }
    
    //Feedback: Tracking
    test("cards mpcard setup virtual feedback") {
        "/cards/mpcard/setup/virtual/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }

    //Static Banner: Tracking
    test("cards mpcard setup virtual static banner") {
        "/cards/mpcard/setup/virtual/static_banner/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }

    // REISSUE VIRTUAL
    // --------

    test("cards mpcard reissue virtual card ") {
        "/cards/mpcard/block_card/virtual"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
        }
        "/cards/mpcard/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "primary_button"
        }
        "/cards/mpcard/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "secondary_button"
        }

        "/cards/mpcard/block_card/virtual/success"(platform:"/", type: TrackType.Event) { }
    }

    // REISSUE PHYSICAL
    // --------

    test("cards mpcard reissue physical card ") {
        "/cards/mpcard/block_card/physical"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
        }
        "/cards/mpcard/block_card/physical/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "primary_button"
        }
        "/cards/mpcard/block_card/physical/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "secondary_button"
        }
        "/cards/mpcard/block_card/physical/success"(platform:"/", type: TrackType.Event) { }
    }

    // SETUP FÍSICA
    // --------

    //Card
    test("cards mpcard setup physical card tracking") {
        "/cards/mpcard/setup/physical"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "active"
        }
        "/cards/mpcard/setup/physical"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "freeze"
        }
        "/cards/mpcard/setup/physical"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "pin_blocked"
        }
    }

    test("cards mpcard setup physical card taps tracking") {
        "/cards/mpcard/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "reissue"
        }
        "/cards/mpcard/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "freeze"
        }
        "/cards/mpcard/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "unfreeze"
        }
        "/cards/mpcard/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "change_pin"
        }
        "/cards/mpcard/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "change_limits"
        }
        "/cards/mpcard/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "header_help"
        }
    }
    
    test("cards mpcard setup physical feedback") {
        "/cards/mpcard/setup/physical/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }
    // Physical Unlock
    test("cards hybrid physical unlock View") {
        "/cards/mpcard/physical/unlock"(platform:"/", type: TrackType.View) {
            card_id = "Axs12345"
        }
    }

    test("cards hybrid physical unlock Events") {
        "/cards/mpcard/physical/unlock/tap"(platform:"/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/mpcard/physical/unlock/tap"(platform:"/", type: TrackType.Event) {
            action = "unlock_card"
        }
        "/cards/mpcard/physical/unlock/tap"(platform:"/", type: TrackType.Event) {
            action = "block_card"
        }
    }
    
     // CHANGE-PIN
    // --------
    test("cards mpcard change pin") {
        "/cards/mpcard/change_pin"(platform: "/", type: TrackType.View) {}
    }
    
    test("cards mpcard change pin tap") {
        "/cards/mpcard/change_pin/tap"(platform:"/", type: TrackType.Event) {
            action = "change_pin"
        }
    }
    
    test("cards mpcard change pin congrats") {
        "/cards/mpcard/change_pin/congrats"(platform: "/", type: TrackType.View) {}
    }

    // NIP
    // --------
    test("cards mpcard nip screen") {
        "/cards/mpcard/nip/physical"(platform: "/", type: TrackType.View) {
            card_id = "Axs12345"
        }
    }
    test("cards mpcard nip screen") {
        "/cards/mpcard/nip/physical/tap"(platform: "/", type: TrackType.Event) {
            action = "header_help"
        }
    }
    test("cards mpcard nip, It_was_not_me link message tap") {
        "/cards/mpcard/nip/message/tap"(platform:"/", type: TrackType.Event) {
            action = "blocked_pin"
        }
    }
    
    // LIMITS
    // --------
    test("cards mpcard limits") {
        "/cards/mpcard/limits_setup"(platform: "/", type: TrackType.View) {
            limits_status = "[number_selector_atm, message]"
        }
    }
    
    test("cards mpcard limits header action tap") {
        "/cards/mpcard/limits_setup/tap"(platform:"/", type: TrackType.Event) {
            action = "header_help"
        }
    }
    
    //Number selector
    test("cards mpcard number selector tap") {
        "/cards/mpcard/limits_setup/number_selector/tap"(platform:"/", type: TrackType.Event) {
            action = "modal"
        }
    }
    
    //Number selector modal
    test("cards mpcard number selector modal") {
        "/cards/mpcard/limits_setup/number_selector_modal"(platform:"/", type: TrackType.View) {}
    }
    
    test("cards mpcard number selector modal tap") {
        "/cards/mpcard/limits_setup/number_selector_modal/tap"(platform:"/", type: TrackType.Event) {
            action = "cancel"
        }
        "/cards/mpcard/limits_setup/number_selector_modal/tap"(platform:"/", type: TrackType.Event) {
            action = "save"
        }
    }

    //Map Info: Tracking
    test("cards mpcard limits map info") {
        "/cards/mpcard/limits_setup/map_info/tap"(platform:"/", type: TrackType.Event) {
            action = "map_info"
        }
    }

    // Request

    // Request: Onboarding
    test("cards mpcard request physical onboarding") {
        "/cards/mpcard/request/physical/onboarding"(platform: "/", type: TrackType.View) {
            context = "no_kyc_no_challenge"
        }
        "/cards/mpcard/request/physical/onboarding"(platform: "/", type: TrackType.View) {
            context = "kyc_challenge"
        }
        "/cards/mpcard/request/physical/onboarding"(platform: "/", type: TrackType.View) {
            context = "no_kyc_challenge"
        }
        "/cards/mpcard/request/physical/onboarding"(platform: "/", type: TrackType.View) {
            context = "kyc_no_challenge"
        }
    }
    test("cards mpcard request physical onboarding tap") {
        "/cards/mpcard/request/physical/onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/mpcard/request/physical/onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "continue"
        }
    }

    // Request: Challenge

    test("cards mpcard request physical challenge success") {
        "/cards/mpcard/request/physical/challenge/success"(platform: "/", type: TrackType.Event) {
            reasons = ["debit_available_push_strategy_none", "reissue"]
        }
    }

    test("cards mpcard request physical challenge") {
        "/cards/mpcard/request/physical/challenge"(platform: "/", type: TrackType.View) {}
    }
    test("cards mpcard request physical challenge tap") {
        "/cards/mpcard/request/physical/challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/mpcard/request/physical/challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "add_money"
        }
    }

    // Request: Pending Challenge
    test("cards mpcard request physical pending challenge") {
        "/cards/mpcard/request/physical/pending_challenge"(platform: "/", type: TrackType.View) {}
    }
    test("cards mpcard request physical pending challenge tap") {
        "/cards/mpcard/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "back"
        }
        "/cards/mpcard/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "add_money"
        }
        "/cards/mpcard/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "info_payment"
        }
    }

    // Request: Expired Challenge
    test("cards mpcard request physical expired challenge") {
        "/cards/mpcard/request/physical/expired_challenge"(platform: "/", type: TrackType.View) {}
    }
    test("cards mpcard request physical pending challenge tap") {
        "/cards/mpcard/request/physical/expired_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "back"
        }
        "/cards/mpcard/request/physical/expired_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "continue"
        }
    }

    // Request: review
    test("cards mpcard request physical review") {
        "/cards/mpcard/request/physical/review"(platform: "/", type: TrackType.View) {}
    }
    test("cards mpcard request physical review tap") {
        "/cards/mpcard/request/physical/review/tap"(platform: "/", type: TrackType.Event) {
            action = "back"
        }
        "/cards/mpcard/request/physical/review/tap"(platform: "/", type: TrackType.Event) {
            action = "changes_address"
        }
        "/cards/mpcard/request/physical/review/tap"(platform: "/", type: TrackType.Event) {
            action = "tyc"
        }
        "/cards/mpcard/request/physical/review/tap"(platform: "/", type: TrackType.Event) {
            action = "card_request"
        }
    }

    // Request: Review TyC
    test("cards mpcard request physical review tyc") {
        "/cards/mpcard/request/physical/review/tyc"(platform: "/", type: TrackType.View) {}
    }
    test("cards mpcard request physical review tyc close") {
        "/cards/mpcard/request/physical/review/tyc/close"(platform: "/", type: TrackType.Event) {}
    }

    // Request: Review address
    test("cards mpcard request physical review address") {
        "/cards/mpcard/request/physical/review/address_modal"(platform: "/", type: TrackType.View) {}
    }
    test("cards mpcard request physical review address tap") {
        "/cards/mpcard/request/physical/review/address_modal/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/mpcard/request/physical/review/address_modal/tap"(platform: "/", type: TrackType.Event) {
            action = "add"
        }
        "/cards/mpcard/request/physical/review/address_modal/tap"(platform: "/", type: TrackType.Event) {
            action = "select_row"
        }
    }

    // Request: Success Physical
    test("cards mpcard physical success event"){
        "/cards/mpcard/request/physical/success"(platform:"/", type: TrackType.Event) {
            reasons = ["debit_available_push_strategy_none", "reissue"]
        }
    }

    // CARD IDENTIFICATION
    // --------
    test("cards mpcard identification") {
        "/cards/mpcard/card_identification"(platform: "/", type: TrackType.View) {}
    }

    // CARD REQUEST init point
    // --------
    test("cards mpcard request init point") {
        "/cards/mpcard/request/init_point"(platform: "/", type: TrackType.View) {
            from = "home"
        }
    }
    // CARD REQUEST virtual on boarding
    // --------
    test("cards mpcard virtual onboarding"){
        "/cards/mpcard/request/virtual/onboarding"(platform:"/", type: TrackType.Event) {}
    }
     test("cards mpcard virtual onboarding tap") {
        "/cards/mpcard/request/virtual/onboarding/tap"(platform:"/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/mpcard/request/virtual/onboarding/tap"(platform:"/", type: TrackType.Event) {
            action = "continue"
        }
    }

    // Request: Success Virtual
    test("cards mpcard virtual success event"){
        "/cards/mpcard/request/virtual/success"(platform:"/", type: TrackType.Event) {
            reasons = ["debit_available_physical_first_whitelist"]
        }
    }

    test ("mpcard Setup") {
        "/cards/mp-card/mpcard/detail" (platform: "/web/desktop", type: TrackType.View) {}
        "/cards/mp-card/mpcard/detail/download-app" (platform: "/web/desktop", type: TrackType.Event) {}
        "/cards/mp-card/mpcard/detail/send-sms" (platform: "/web/desktop", type: TrackType.Event) {
            status = "OK"
        }
        "/cards/mp-card/mpcard/detail/send-sms" (platform: "/web/desktop", type: TrackType.Event) {
            status = "ERROR"
        }
        "/cards/mp-card/mpcard/detail/click-send-message" (platform: "/web/desktop", type: TrackType.Event) {
             deviceType = "desktop"
        }
    }

    //COACHMARK
    // --------
    test("cards mpcard coachmark tap"){
        "/cards/mpcard/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
            step = 1
            id = "dashboard_virtual"
        }
        "/cards/mpcard/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "next"
            step = 2
            id = "dashboard_virtual"
        }
        "/cards/mpcard/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "previous"
            step = 2
            id = "dashboard_physical"
        }
    }

    //Contingency
    test("Cards contingency tests"){
        "/cards/mpcard/contingency/nip/physical"(platform: "/mobile", type: TrackType.View) {}

        "/cards/mpcard/contingency/nip/physical/tap"(platform: "/mobile", type: TrackType.Event) {
            action = "back_button"
        }
    }

    test("Feedback Tap event"){
        "/cards/mpcard/tracking/feedback/tap"(platform:"/mobile", type: TrackType.Event) {
            action = "research_form"
        }
    }
}
