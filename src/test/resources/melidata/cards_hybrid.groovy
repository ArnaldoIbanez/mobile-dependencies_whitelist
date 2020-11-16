package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    //-----------------
    // HYBRID MP
    //-----------------

    defaultBusiness = "mercadopago"

    // SHIPPING
    // --------

    //Shipping: Tracking
    test("cards hybrid shipping tracking") {
        "/cards/hybrid/shipping/tracking"(platform: "/", type: TrackType.View) {
            unlock_banner_is_present = false
            contact_is_present = true
            setup_virtual_banner_is_present = true
        }
        "/cards/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
            action = "contact"
        }
        "/cards/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
            component_id = "banner_unlock"
        }
        "/cards/hybrid/shipping/tracking/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }

    }

    //Shipping: Delayed
    test("cards hybrid shipping delayed") {
        "/cards/hybrid/shipping/delayed"(platform: "/", type: TrackType.View) {
            context = "stolen"
        }
        "/cards/hybrid/shipping/delayed/tap"(platform:"/", type: TrackType.Event) {
            action = "reissue"
        }
    }

    // UNLOCK
    // ------

     // Unlock: Init point
    test("cards hybrid unlock init point") {
        "/cards/hybrid/unlock/init-point"(platform: "/", type: TrackType.View) {}
    }

    // Unlock: Scanner
    test("cards hybrid unlock scanner") {
        "/cards/hybrid/unlock/scanner"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/scanner/link"(platform:"/", type: TrackType.Event) {
            action = "qr"
        }
        "/cards/hybrid/unlock/scanner/link"(platform:"/", type: TrackType.Event) {
            action = "manual"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "initializing"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "scanning"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "resolving"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "failed"
        }
    }

    test("cards hybrid unlock scanner help") {
        "/cards/hybrid/unlock/scanner/help"(platform: "/", type: TrackType.Event) {}
    }

    // Unlock: Manual Link
    test("cards hybrid unlock manual link") {
        "/cards/hybrid/unlock/manual-link"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/manual-link/tap"(platform:"/", type: TrackType.Event) {
            action = "link"
        }
        "/cards/hybrid/unlock/manual-link/invalid_code"(platform: "/", type: TrackType.Event) {}
    }

    // Unlock: Confirm Link
    test("cards hybrid unlock confirm link") {
        "/cards/hybrid/unlock/confirm-link"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/confirm-link/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/hybrid/unlock/confirm-link/tap"(platform:"/", type: TrackType.Event) {
            action = "logout"
        }
    }

    // Unlock: Camera Permissions
    test("cards hybrid unlock camera permissions") {
        "/cards/hybrid/unlock/camera-permissions"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/camera-permissions/tap"(platform:"/", type: TrackType.Event) {
            action = "qr"
        }
        "/cards/hybrid/unlock/camera-permissions/tap"(platform:"/", type: TrackType.Event) {
            action = "manual"
        }
    }

    // Unlock: Confirm Replacement
    test("cards hybrid unlock confirm replacement") {
        "/cards/hybrid/unlock/confirm-replacement"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/confirm-replacement/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/hybrid/unlock/confirm-replacement/tap"(platform:"/", type: TrackType.Event) {
            action = "exit"
        }
    }

    // Unlock: Set Pin
    test("cards hybrid unlock set pin") {
        "/cards/hybrid/unlock/set-pin"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/set-pin/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/hybrid/unlock/set-pin/invalid_pin"(platform: "/", type: TrackType.Event) {}
    }

    // Unlock: Update App
    test("cards hybrid unlock update app") {
        "/cards/hybrid/unlock/update-app"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "update"
        }
        "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "exit"
        }
    }

    // Unlock: Success
    test("cards hybrid unlock success event"){
        "/cards/hybrid/unlock/success"(platform:"/", type: TrackType.Event) {}
    }

    // DASHBOARD
    // --------
    test("cards hybrid dashboard") {
        "/cards/hybrid/dashboard"(platform: "/", type: TrackType.View) {
            dashboard_status = "[minicard, flap, activities, message, account_options, carousel, linear_buttons, account_info]"
            dashboard_banner_status = "virtual_only"
            minicard_status = "virtual_only"
            flap_status = "virtual_only"
            message_status = "warning"
            activities_status = "activities_with_error"
        }
        "/cards/hybrid/dashboard"(platform: "/", type: TrackType.View) {
            dashboard_status = "[minicard, flap, activities, account_options, carousel, linear_buttons, account_info]"
            dashboard_banner_status = "virtual_only"
            minicard_status = "virtual_only"
            flap_status = "virtual_only"
            activities_status = "activities"
        }
        "/cards/hybrid/dashboard/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "header_help"
        }
        "/cards/hybrid/dashboard/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "header_help"
        }
    }
    
    //Mini card: Tracking
    test("cards hybrid dashboard mini card tracking") {
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_delivered"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "hybrid_active"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "debit_active"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_inactive"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "user_need_challenge"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_only"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_pending"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_ready_to_ship"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_not_delivered"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_soon_deliver"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_delayed"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_waiting_for_withdrawal"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_shipped"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "options"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "card_data"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "kyc_compliance"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "kyc_not_compliance"
        }
    }
    
     //Physical acquisition stop: Tracking
    test("cards hybrid dashboard physical acquistion stop tracking") {
        "/cards/hybrid/dashboard/physical_acquisition_stop/tap"(platform:"/", type: TrackType.Event) {
            action = "primary_button"
        }
        "/cards/hybrid/dashboard/physical_acquisition_stop/tap"(platform:"/", type: TrackType.Event) {
            action = "secondary_button"
        }
    }
    
    //Banner: Tracking
    test("cards hybrid dashboard banner tracking") {
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "render"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_inactive"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_only"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "user_need_challenge"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_pending"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_ready_to_ship"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_soon_deliver"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_delayed"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_waiting_for_withdrawal"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_delivered"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_not_delivered"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "kyc_pending_manual_review"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "kyc_not_compliance"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "kyc_compliance"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "debit_active"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "hybrid_active"
        }
    }
    
    //Flap card: Tracking
    test("cards hybrid dashboard flap card tracking") {
        "/cards/hybrid/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
            action = "more_than_one_virtual_active"
        }
        "/cards/hybrid/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_active"
        }
        "/cards/hybrid/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_inactive"
        }
        "/cards/hybrid/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
            action = "never_had_virtual_card"
        }
    }
     
    //Account options: Tracking
    test("cards hybrid dashboard account options") {
        "/cards/hybrid/dashboard/account_options/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
        "/cards/hybrid/dashboard/account_options/tap"(platform:"/", type: TrackType.Event) {
            action = "account_info_modal"
        }
    }
    
    //Linear buttons: Tracking
    test("cards hybrid dashboard linear buttons") {
        "/cards/hybrid/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
            action = "help"
        }
        "/cards/hybrid/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
            action = "call"
        }
        "/cards/hybrid/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
            action = "block"
        }
        "/cards/hybrid/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
            action = "contact"
        }
    }
    
    //Message: Tracking
    test("cards hybrid dashboard message") {
        "/cards/hybrid/dashboard/message/tap"(platform:"/", type: TrackType.Event) {
            action = "blocked_pin"
        }
    }
    
    //Account info: Tracking
    test("cards hybrid dashboard account info") {
        "/cards/hybrid/dashboard/account_info"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/dashboard/account_info/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }
    
    //Carousel: Tracking
    test("cards hybrid dashboard carousel tapped") {
        "/cards/hybrid/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
            action = "page_0"
        }
        "/cards/hybrid/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
            action = "page_1"
        }
        "/cards/hybrid/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
            action = "page_2"
        }
        "/cards/hybrid/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
            action = "page_3"
        }
        "/cards/hybrid/dashboard/carousel/tap"(platform:"/", type: TrackType.Event) {
            action = "page_4"
        }
    }
    
    test("cards hybrid dashboard carousel swiped") {
        "/cards/hybrid/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
            action = "page_0"
        }
        "/cards/hybrid/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
            action = "page_1"
        }
        "/cards/hybrid/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
            action = "page_2"
        }
        "/cards/hybrid/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
            action = "page_3"
        }
        "/cards/hybrid/dashboard/carousel/swipe"(platform:"/", type: TrackType.Event) {
            action = "page_4"
        }
    }
    
    //Feedback: Tracking
    test("cards hybrid dasboard feedback") {
        "/cards/hybrid/dashboard/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }

    //Coachmark Banner
    test("cards hybrid dashboard coachmark banner"){
        "/cards/hybrid/dashboard/coachmark_banner"(platform: "/", type: TrackType.Event) {
            action = "close"
            id = "dashboard_virtual"
        }
        "/cards/hybrid/dashboard/coachmark_banner"(platform: "/", type: TrackType.Event) {
            action = "tap"
            id = "dashboard_virtual"
        }
    }

    // Acquisition Error
    // --------

    test("cards acquisition error") {
        "/cards/acquisition/error"(platform: "/", type: TrackType.View) {
            screen = "review"
        }
    }
    
    //Map Info: Tracking
    test("cards hybrid dasboard map info") {
        "/cards/hybrid/dashboard/map_info/tap"(platform:"/", type: TrackType.Event) {}
    }

    // Generic Webview
    // ------

    test("cards generic webview") {
        "/cards/acquisition/webview"(platform: "/", type: TrackType.View) {
            url = "http://url.com"
            flow = "generic"
        }
        "/cards/acquisition/webview/external_url"(platform:"/", type: TrackType.Event) {
            flow = "generic"
        }
        "/cards/acquisition/webview/navigate"(platform:"/", type: TrackType.Event) {
            url = "http://newurl.com"
            flow = "generic"
        }
        "/cards/acquisition/webview/close"(platform:"/", type: TrackType.Event) {
            flow = "generic"
        }
    }

    // Generic Congrats 
    // ------

    test("cards generic congrats") {
        "/cards/acquisition/congrats"(platform: "/", type: TrackType.View) {
            type = "congrats_type"
        }
        "/cards/acquisition/congrats/tap"(platform:"/", type: TrackType.Event) {
            type = "congrats_type"
            url = "mercadopago://home"
        }
        "/cards/acquisition/congrats/error"(platform:"/", type: TrackType.Event) {
            type = "congrats_type"
            status = "404"
        }
    }

    // Engagement Error
    // --------

    test("cards engagement error") {
        "/cards/engagement/error"(platform: "/", type: TrackType.View) {
            screen = "dashboard"
        }
    }

    // SETUP VIRTUAL
    // --------

    //Card
    test("cards hybrid setup virtual card tracking") {
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "deprecated"
            has_money = false
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "new"
            has_money = false
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "on_creation"
            has_money = false
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "on_delivery"
            has_money = false
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "delivered"
            has_money = false
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "active"
            has_money = true
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "freeze"
            has_money = false
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "blocked"
            has_money = false
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            has_money = false
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            has_money = false
            experimental_version = "experimental_a"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            has_money = false
            experimental_version = "experimental_b"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            product_type = "credit"
            experimental_version = "experimental_a"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            product_type = "prepaid"
            has_money = true
            experimental_version = "experimental_a"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            product_type = "hybrid"
            has_money = true
            experimental_version = "experimental_a"
        }
    }
    test("cards hybrid setup virtual card taps tracking") {
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "reissue"
        }
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "freeze"
        }
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "unfreeze"
        }
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "card_unfreeze"
        }
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "copy"
        }
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "header_help"
        }
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "card_name_copy"
        }
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "card_number_copy"
        }
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "card_sec_code_copy"
        }
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "additional_message"
        }
        "/cards/hybrid/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "additional_message_freeze"
        }
    }

    //Highlighted Row
    test("cards hybrid setup virtual Highlighted Row") {
        "/cards/hybrid/setup/virtual/highlighted_row/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }
    
    //Account options
    test("cards hybrid setup virtual card message") {
        "/cards/hybrid/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
        "/cards/hybrid/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in_experimental_a"
        }
        "/cards/hybrid/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in_experimental_b"
        }
        "/cards/hybrid/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "account_info_modal"
        }
        "/cards/hybrid/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "account_info_modal_experimental_a"
        }
        "/cards/hybrid/setup/virtual/message/tap"(platform:"/", type: TrackType.Event) {
            action = "account_info_modal_experimental_b"
        }
    }
    
    //Redirect when the user don't have a virtual card
    test("cards hybrid setup virtual card need to redirect in order to create a new virtual card") {
        "/cards/hybrid/setup/virtual/redirect"(platform:"/", type: TrackType.Event) {}
    }

    //Account options
    test("cards hybrid setup virtual card account options") {
        "/cards/hybrid/setup/virtual/account_options/tap"(platform:"/", type: TrackType.Event) {
            action = "account_info_modal"
        }
        "/cards/hybrid/setup/virtual/account_options/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }

    //Account Info
    test("cards hybrid setup virtual card account info") {
        "/cards/hybrid/setup/virtual/account_info"(platform:"/", type: TrackType.View) {}
        "/cards/hybrid/setup/virtual/account_info/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }
    
    //Feedback: Tracking
    test("cards hybrid setup virtual feedback") {
        "/cards/hybrid/setup/virtual/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }

    //Static Banner: Tracking
    test("cards hybrid setup virtual static banner") {
        "/cards/hybrid/setup/virtual/static_banner/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }

    // REISSUE VIRTUAL
    // --------

    test("cards hybrid reissue virtual card ") {
        "/cards/hybrid/block_card/virtual"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
        }
        "/cards/hybrid/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "primary_button"
        }
        "/cards/hybrid/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "secondary_button"
        }
        "/cards/hybrid/block_card/virtual/success"(platform:"/", type: TrackType.Event) {
            reasons = ["debit_available_push_strategy_none", "reissue"]
         }
    }

    // REISSUE PHYSICAL
    // --------

    test("cards hybrid reissue physical card ") {
        "/cards/hybrid/block_card/physical"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
        }
        "/cards/hybrid/block_card/physical/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "primary_button"
        }
        "/cards/hybrid/block_card/physical/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "secondary_button"
        }
        "/cards/hybrid/block_card/physical/success"(platform:"/", type: TrackType.Event) { 
            reasons = ["debit_available_push_strategy_second", "reissue"]
        }
    }

    // SETUP FÍSICA
    // --------

    //Card
    test("cards hybrid setup physical card tracking") {
        "/cards/hybrid/setup/physical"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "active"
        }
        "/cards/hybrid/setup/physical"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "freeze"
        }
        "/cards/hybrid/setup/physical"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "pin_blocked"
        }
    }

    test("cards hybrid setup physical card taps tracking") {
        "/cards/hybrid/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "reissue"
        }
        "/cards/hybrid/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "freeze"
        }
        "/cards/hybrid/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "unfreeze"
        }
        "/cards/hybrid/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "change_pin"
        }
        "/cards/hybrid/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "change_limits"
        }
        "/cards/hybrid/setup/physical/tap"(platform:"/", type: TrackType.Event) {
            action = "header_help"
        }
    }
    
    test("cards hybrid setup physical feedback") {
        "/cards/hybrid/setup/physical/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }

    test("cards hybrid physical unlock") {
        "/cards/hybrid/physical/unlock/tap"(platform:"/", type: TrackType.Event) {
            action = "close"
        }
    }
    
     // CHANGE-PIN
    // --------
    test("cards hybrid change pin") {
        "/cards/hybrid/change_pin"(platform: "/", type: TrackType.View) {}
    }
    
    test("cards hybrid change pin tap") {
        "/cards/hybrid/change_pin/tap"(platform:"/", type: TrackType.Event) {
            action = "change_pin"
        }
    }
    
    test("cards hybrid change pin congrats") {
        "/cards/hybrid/change_pin/congrats"(platform: "/", type: TrackType.View) {}
    }
    
    // LIMITS
    // --------
    test("cards hybrid limits") {
        "/cards/hybrid/limits_setup"(platform: "/", type: TrackType.View) {
            limits_status = "[number_selector_atm, message]"
        }
    }
    
    test("cards hybrid limits header action tap") {
        "/cards/hybrid/limits_setup/tap"(platform:"/", type: TrackType.Event) {
            action = "header_help"
        }
    }
    
    //Number selector
    test("cards hybrid number selector tap") {
        "/cards/hybrid/limits_setup/number_selector/tap"(platform:"/", type: TrackType.Event) {
            action = "modal"
        }
    }
    
    //Number selector modal
    test("cards hybrid number selector modal") {
        "/cards/hybrid/limits_setup/number_selector_modal"(platform:"/", type: TrackType.View) {}
    }
    
    test("cards hybrid number selector modal tap") {
        "/cards/hybrid/limits_setup/number_selector_modal/tap"(platform:"/", type: TrackType.Event) {
            action = "cancel"
        }
        "/cards/hybrid/limits_setup/number_selector_modal/tap"(platform:"/", type: TrackType.Event) {
            action = "save"
        }
    }

    //Map Info: Tracking
    test("cards hybrid limits map info") {
        "/cards/hybrid/limits_setup/map_info/tap"(platform:"/", type: TrackType.Event) {}
    }

    // Request

    // Request: Onboarding
    test("cards hybrid request physical onboarding") {
        "/cards/hybrid/request/physical/onboarding"(platform: "/", type: TrackType.View) {
            context = "no_kyc_no_challenge"
        }
        "/cards/hybrid/request/physical/onboarding"(platform: "/", type: TrackType.View) {
            context = "kyc_challenge"
        }
        "/cards/hybrid/request/physical/onboarding"(platform: "/", type: TrackType.View) {
            context = "no_kyc_challenge"
        }
        "/cards/hybrid/request/physical/onboarding"(platform: "/", type: TrackType.View) {
            context = "kyc_no_challenge"
        }
    }
    test("cards hybrid request physical onboarding tap") {
        "/cards/hybrid/request/physical/onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/hybrid/request/physical/onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "continue"
        }
    }

    // Request: Challenge
    test("cards hybrid request physical challenge success") {
        "/cards/hybrid/request/physical/challenge/success"(platform: "/", type: TrackType.Event) {
            reasons = ["debit_available_push_strategy_none", "reissue"]
        }
    }
    test("cards hybrid request physical challenge") {
        "/cards/hybrid/request/physical/challenge"(platform: "/", type: TrackType.View) {}
    }
    test("cards hybrid request physical challenge tap") {
        "/cards/hybrid/request/physical/challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/hybrid/request/physical/challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "add_money"
        }
    }

    // Request: Pending Challenge
    test("cards hybrid request physical pending challenge") {
        "/cards/hybrid/request/physical/pending_challenge"(platform: "/", type: TrackType.View) {}
    }
    test("cards hybrid request physical pending challenge tap") {
        "/cards/hybrid/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "back"
        }
        "/cards/hybrid/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "add_money"
        }
        "/cards/hybrid/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "info_payment"
        }
    }

    // Request: review
    test("cards hybrid request physical review") {
        "/cards/hybrid/request/physical/review"(platform: "/", type: TrackType.View) {}
    }
    test("cards hybrid request physical review tap") {
        "/cards/hybrid/request/physical/review/tap"(platform: "/", type: TrackType.Event) {
            action = "back"
        }
        "/cards/hybrid/request/physical/review/tap"(platform: "/", type: TrackType.Event) {
            action = "changes_address"
        }
        "/cards/hybrid/request/physical/review/tap"(platform: "/", type: TrackType.Event) {
            action = "tyc"
        }
        "/cards/hybrid/request/physical/review/tap"(platform: "/", type: TrackType.Event) {
            action = "card_request"
        }
    }

    // Request: Review TyC
    test("cards hybrid request physical review tyc") {
        "/cards/hybrid/request/physical/review/tyc"(platform: "/", type: TrackType.View) {}
    }
    test("cards hybrid request physical review tyc close") {
        "/cards/hybrid/request/physical/review/tyc/close"(platform: "/", type: TrackType.Event) {}
    }

    // Request: Review address
    test("cards hybrid request physical review address") {
        "/cards/hybrid/request/physical/review/address_modal"(platform: "/", type: TrackType.View) {}
    }
    test("cards hybrid request physical review address tap") {
        "/cards/hybrid/request/physical/review/address_modal/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/hybrid/request/physical/review/address_modal/tap"(platform: "/", type: TrackType.Event) {
            action = "add"
        }
        "/cards/hybrid/request/physical/review/address_modal/tap"(platform: "/", type: TrackType.Event) {
            action = "select_row"
        }
    }

    // Request: Success Physical
    test("cards hybrid physical success event"){
        "/cards/hybrid/request/physical/success"(platform:"/", type: TrackType.Event) {
            reasons = ["card_whitelist_physical_first", "reissue"]
        }
    }

    // CARD IDENTIFICATION
    // --------
    test("cards hybrid identification") {
        "/cards/hybrid/card_identification"(platform: "/", type: TrackType.View) {}
    }

    // CARD REQUEST init point
    // --------
    test("cards hybrid request init point") {
        "/cards/hybrid/request/init_point"(platform: "/", type: TrackType.View) {
            from = "home"
        }
    }
    // CARD REQUEST virtual on boarding
    // --------
    test("cards hybrid virtual onboarding"){
        "/cards/hybrid/request/virtual/onboarding"(platform:"/", type: TrackType.Event) {}
    }
    test("cards hybrid virtual onboarding"){
        "/cards/hybrid/request/virtual/onboarding"(platform:"/", type: TrackType.Event) {
            context = "kyc"
        }
    }
    test("cards hybrid virtual onboarding tap") {
        "/cards/hybrid/request/virtual/onboarding/tap"(platform:"/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/hybrid/request/virtual/onboarding/tap"(platform:"/", type: TrackType.Event) {
            action = "continue"
        }
    }

    // Request: Success Virtual
    test("cards hybrid virtual success event"){
        "/cards/hybrid/request/virtual/success"(platform:"/", type: TrackType.Event) {
            reasons = ["virtual_debit_available_push_strategy_first", "reissue"]
        }
    }

    test ("Hybrid Setup") {
        "/cards/mp-card/hybrid/detail" (platform: "/web/desktop", type: TrackType.View) {}
        "/cards/mp-card/hybrid/detail" (platform: "/web/mobile", type: TrackType.View) {}
        "/cards/mp-card/hybrid/detail/download-app" (platform: "/web/desktop", type: TrackType.Event) {}
        "/cards/mp-card/hybrid/detail/download-app" (platform: "/web/mobile", type: TrackType.Event) {
            osName = "android"
        }
        "/cards/mp-card/hybrid/detail/send-sms" (platform: "/web/desktop", type: TrackType.Event) {
            status = "OK"
        }
        "/cards/mp-card/hybrid/detail/send-sms" (platform: "/web/desktop", type: TrackType.Event) {
            status = "ERROR"
        }
        "/cards/mp-card/hybrid/detail/click-send-message" (platform: "/web/desktop", type: TrackType.Event) {
             deviceType = "desktop"
        }
    }

    //COACHMARK
    // --------
    test("cards hybrid coachmark tap"){
        "/cards/hybrid/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
            step = 1
            id = "dashboard_virtual"
        }
        "/cards/hybrid/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "next"
            step = 2
            id = "dashboard_virtual"
        }
        "/cards/hybrid/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "previous"
            step = 2
            id = "dashboard_physical"
        }
    }
    
    //OPTIONS
    test("cards hybrid options tracking") {
        "/cards/hybrid/setup/options"(platform:"/", type: TrackType.View) {
            cards = [
                [
                    "product_type": "virtual_debit",
                    "status": "active",
                ],
                [
                    "product_type": "virtual_credit",
                    "status": "active",
                ],
                [
                    "product_type": "chip_prepaid",
                    "status": "active",
                ]
            ]
        }
        "/cards/hybrid/setup/options"(platform:"/", type: TrackType.View) {
            cards = []
        }
        "/cards/hybrid/setup/options/empty_state"(platform:"/", type: TrackType.View) {}
        "/cards/hybrid/setup/options/empty_state/tap"(platform:"/", type: TrackType.Event) {
            action = "button_primary"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "chip_prepaid"
            action = "reissue"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "chip_prepaid"
            action = "change_limits"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "chip_prepaid"
            action = "change_pin"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "virtual_debit"
            action = "freeze"

        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "virtual_debit"
            action = "freeze"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "chip_prepaid"
            action = "unfreeze"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "chip_prepaid"
            action = "freeze"
        }
        "/cards/hybrid/setup/options/tap/success"(platform: "/", type: TrackType.Event) {
            product_type = "chip_prepaid"
            action = "freeze"
        }
        "/cards/hybrid/setup/options/tap/failure"(platform: "/", type: TrackType.Event) {
            product_type = "chip_prepaid"
            action = "freeze"
        }
    }

    //OPTIONS Message
    test("cards hybrid options message tracking") {
        "/cards/hybrid/setup/options/message/lock/tap"(platform:"/", type: TrackType.Event) {
            action = "blocked_pin"
        }
    }

    //OPTIONS Feedback
    test("cards hybrid options feedback button event") {
        "/cards/hybrid/setup/options/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }

    //NFC HUB
    test("cards hybrid nfc enrollment hub") {
        "/cards/nfc/enrollment/hub"(platform:"/", type: TrackType.View) {}
        "/cards/nfc/enrollment/hub/tap"(platform:"/", type: TrackType.Event) {
            action = "continue_later"
        }
        "/cards/nfc/enrollment/hub/tap"(platform:"/", type: TrackType.Event) {
            action = "back"
        }
        "/cards/nfc/enrollment/hub/step/tap"(platform:"/", type: TrackType.Event) {
            action = "step_tap_and_pay"
        }
        "/cards/nfc/enrollment/hub/step/tap"(platform:"/", type: TrackType.Event) {
            action = "step_pin"
        }
        "/cards/nfc/enrollment/hub/step/tap"(platform:"/", type: TrackType.Event) {
            action = "step_nfc"
        }     
        "/cards/nfc/enrollment/hub/redirect"(platform:"/", type: TrackType.Event) {
            action = "success_redirect"
        }
    } 
}
