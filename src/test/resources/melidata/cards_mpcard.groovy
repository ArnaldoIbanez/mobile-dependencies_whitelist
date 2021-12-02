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

    // Dasboard Header Help  
    test("cards mpcard dashboard header help") {
        "/cards/mpcard/dashboard/header_help"(platform:"/mobile", type: TrackType.Event) {}
    }

    // DASHBOARD Physical Unlock
    test("cards mpcard dashboard physical unlock") {
        "/cards/mpcard/dashboard/physical/unlock"(platform:"/", type: TrackType.Event) {
            action = "success"
        }
        "/cards/mpcard/dashboard/physical/unlock"(platform:"/", type: TrackType.Event) {
            action = "error"
        }
        "/cards/mpcard/dashboard/message/lock/tap"(platform:"/", type: TrackType.Event) {
            action = "unlock"
        }
        "/cards/mpcard/dashboard/message/lock/tap"(platform:"/", type: TrackType.Event) {
            action = "reissue"
        }
    }

    // DASHBOARD IFPE
    test("cards mpcard dashboard IFPE") {
        "/cards/mpcard/dashboard/ifpe_message/tap"(platform:"/", type: TrackType.Event) {
            action = "account_conversion"
        }
    }
    test("cards mpcard dashboard IFPE Modal") {
        "/cards/mpcard/dashboard/ifpe_modal/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/mpcard/dashboard/ifpe_modal/tap"(platform:"/", type: TrackType.Event) {
            action = "dismiss"
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
        "/cards/mpcard/dashboard/message/tap"(platform:"/", type: TrackType.Event) {
            action = "unlock_card"
        }
        "/cards/mpcard/dashboard/message/tap"(platform:"/", type: TrackType.Event) {
            action = "unlock_physical_card"
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

    //Dynamic Carousel Tracking
    test("cards hybrid dashboard dynamic carousel tapped") {
        "/cards/mpcard/dashboard/dynamic_carousel/tap"(platform:"/", type: TrackType.Event) {
            description = [
                audience: "audience example",
                bu: "22",
                bu_line: "13",
                component_id: "some id",
                content_id: "some content id",
                flow: "some flow",
                logic: "some logic",
                position: 2
            ]
        }
    }
    test("cards hybrid dashboard dynamic carousel Swiped") {
        "/cards/mpcard/dashboard/dynamic_carousel/swipe"(platform:"/", type: TrackType.Event) {
            description = [
                audience: "audience example",
                bu: "3",
                bu_line: "13",
                component_id: "some id",
                content_id: "some content id",
                flow: "some flow",
                logic: "some logic",
                position: 0
            ]
        }
    }
    test("cards hybrid dashboard dynamic carousel displayed") {
        "/cards/mpcard/dashboard/dynamic_carousel/show_item"(platform:"/", type: TrackType.Event) {
            description = [
                audience: "audience example",
                bu: "3",
                bu_line: "13",
                component_id: "some id",
                content_id: "some content id",
                flow: "some flow",
                logic: "some logic",
                position: 0
            ]
        }
    }
    test("cards hybrid dashboard dynamic carousel Closed") {
        "/cards/mpcard/dashboard/dynamic_carousel/close"(platform:"/", type: TrackType.Event) {
            description = [
                audience: "audience example",
                bu: "42",
                bu_line: "13",
                component_id: "some id",
                content_id: "some content id",
                flow: "some flow",
                logic: "some logic",
                position: 3
            ]
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

    //FTU Carousel Onboarding: Tracking
    test("cards mpcard dashboard ftu carousel onboarding") {
        "/cards/mpcard/dashboard/ftu_carousel_onboarding"(platform: "/", type: TrackType.View) {}
    }
    test("cards mpcard dashboard ftu carousel onboarding tap") {
        "/cards/mpcard/dashboard/ftu_carousel_onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/mpcard/dashboard/ftu_carousel_onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "continue"
        }
    }
    test("cards mpcard dashboard ftu carousel onboarding swiped") {
        "/cards/mpcard/dashboard/ftu_carousel_onboarding/swipe"(platform:"/", type: TrackType.Event) {
            action = "swipe_virtual_slide"
        }
        "/cards/mpcard/dashboard/ftu_carousel_onboarding/swipe"(platform:"/", type: TrackType.Event) {
            action = "swipe_physical_slide"
        }
        "/cards/mpcard/dashboard/ftu_carousel_onboarding/swipe"(platform:"/", type: TrackType.Event) {
            action = "swipe_credit_slide"
        }
        "/cards/mpcard/dashboard/ftu_carousel_onboarding/swipe"(platform:"/", type: TrackType.Event) {
            action = "swipe_nfc_slide"
        }
    }
    
    //FTU Single Onboarding: Tracking 
    test("cards mpcard dashboard ftu single onboarding") {
        "/cards/mpcard/dashboard/ftu_single_onboarding"(platform: "/", type: TrackType.View) {}
    }
    test("cards mpcard dashboard ftu single onboarding tap") {
        "/cards/mpcard/dashboard/ftu_single_onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/mpcard/dashboard/ftu_single_onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "continue"
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
            action = "additional_message_freeze"
        }
        "/cards/mpcard/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "close_modal"
        }
        "/cards/mpcard/setup/virtual/tap"(platform:"/", type: TrackType.Event) {
            action = "header_help"
        }
    }

    test("cards mpcard setup virtual tracking") {
        "/cards/mpcard/setup/virtual/reauth"(platform:"/", type: TrackType.Event) { }
        "/cards/mpcard/setup/virtual/reauth/success"(platform:"/", type: TrackType.Event) { }
        "/cards/mpcard/setup/virtual/reauth/error"(platform:"/", type: TrackType.Event) { }
    }

    //Highlighted Row
    test("cards mpcard setup virtual Highlighted Row") {
        "/cards/mpcard/setup/virtual/highlighted_row/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }
    
    // Cards hub
     test("cards mpcard card block hub") {
            "/cards/mpcard/card_hub/block_card"(platform:"/", type: TrackType.View) {}
            "/cards/mpcard/card_hub/block_card/tap"(platform:"/", type: TrackType.Event) {
                action = "virtual_debit_card"
            }
             "/cards/mpcard/card_hub/block_card/tap"(platform:"/", type: TrackType.Event) {
                action = "physical_card"
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
    // Empty State
    test("cards mpcard options Empty State tracking") {
        "/cards/mpcard/setup/options/empty_state"(platform:"/", type: TrackType.View) {}
        "/cards/mpcard/setup/options/empty_state/tap"(platform:"/", type: TrackType.Event) {
            action = "primary_button"
        }
        "/cards/mpcard/setup/options/empty_state/tap"(platform:"/", type: TrackType.Event) {
            action = "secondary_button"
        }
    }
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
            action = "reissue"
        }
    }
    test("cards mpcard setup options success taps") {
        "/cards/mpcard/setup/options/tap/success"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "unfreeze"
        }
        "/cards/mpcard/setup/options/tap/success"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "freeze"
        }
        "/cards/mpcard/setup/options/tap/success"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "physical_freeze"
        }
        "/cards/mpcard/setup/options/tap/success"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "physical_unfreeze"
        }
        "/cards/mpcard/setup/options/tap/success"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "change_limits"
        }
        "/cards/mpcard/setup/options/tap/success"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "see_nip"
        }
        "/cards/mpcard/setup/options/tap/success"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "block_card"
        }
    }
    test("cards mpcard setup options failure taps") {
        "/cards/mpcard/setup/options/tap/failure"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "freeze"
        }
        "/cards/mpcard/setup/options/tap/failure"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "unfreeze"
        }
        "/cards/mpcard/setup/options/tap/failure"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "physical_freeze"
        }
        "/cards/mpcard/setup/options/tap/failure"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "physical_unfreeze"
        }
        "/cards/mpcard/setup/options/tap/failure"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "change_limits"
        }
        "/cards/mpcard/setup/options/tap/failure"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
                action = "see_nip"
        }
        "/cards/mpcard/setup/options/tap/failure"(platform: "/", type: TrackType.Event) {
                product_type = "chip_prepaid"
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
            context = "cancellation"
        }
        "/cards/mpcard/block_card/virtual"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
            context = "creation"
        }
        "/cards/mpcard/block_card/virtual"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
            flow_version = 2
            context = "creation"
        }
        "/cards/mpcard/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "primary_button"
            context = "cancellation"
        }
        "/cards/mpcard/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "secondary_button"
            context = "creation"
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

    test("cards mpcard physical unlock Events") {
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
    test("cards mpcard physical unlock operation status") {
        "/cards/mpcard/physical/unlock/status"(platform:"/", type: TrackType.Event) {
            status = "success"
        }
        "/cards/mpcard/physical/unlock/status"(platform:"/", type: TrackType.Event) {
            status = "error"
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
        "/cards/mpcard/nip/physical/tap"(platform: "/", type: TrackType.Event) {
            action = "header_back_button"
        }
        "/cards/mpcard/nip/physical/tap"(platform: "/", type: TrackType.Event) {
            action = "change_nip"
        }
    }
    test("cards mpcard nip, It_was_not_me link message tap") {
        "/cards/mpcard/nip/message/tap"(platform:"/", type: TrackType.Event) {
            action = "blocked_pin"
        }
    }
    test("cards mpcard nip onboarding") {
        "/cards/mpcard/nip/onboarding"(platform:"/", type: TrackType.View) { }
        "/cards/mpcard/nip/onboarding/tap"(platform:"/", type: TrackType.Event) {
            action = "change_nip"
        }
        "/cards/mpcard/nip/onboarding/tap"(platform:"/", type: TrackType.Event) {
            action = "keep_actual"
        }
        "/cards/mpcard/nip/onboarding/tap"(platform:"/", type: TrackType.Event) {
            action = "close"
        }
    }
    test("cards mpcard nip change nip") {
        "/cards/mpcard/change_nip"(platform:"/", type: TrackType.View) { }
        "/cards/mpcard/change_nip/tap"(platform:"/", type: TrackType.Event) {
            action = "change_nip"
        }
    }
    test("cards mpcard nip change nip congrats") {
        "/cards/mpcard/change_nip/congrats"(platform:"/", type: TrackType.View) { }
        "/cards/mpcard/change_nip/congrats/tap"(platform:"/", type: TrackType.Event) {
            action = "understands"
        }
        "/cards/mpcard/change_nip/congrats/tap"(platform:"/", type: TrackType.Event) {
            action = "atm_away"
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
            action = "back"
        }
        "/cards/mpcard/request/physical/challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "add_money"
        }
    }

    // Request: Pending Challenge
    test("cards mpcard request physical pending challenge") {
        "/cards/mpcard/request/physical/pending_challenge"(platform: "/", type: TrackType.View) {
            context = "D1"
        }
        "/cards/mpcard/request/physical/pending_challenge"(platform: "/", type: TrackType.View) {
            context = "D1_ticket"
        }
        "/cards/mpcard/request/physical/pending_challenge"(platform: "/", type: TrackType.View) {
            context = "D4"
        }
    }
    test("cards mpcard request physical pending challenge tap") {
        "/cards/mpcard/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "back"
            context = "D1"
        }
        "/cards/mpcard/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "add_money"
            context = "D1_ticket"
        }
        "/cards/mpcard/request/physical/pending_challenge/tap"(platform: "/", type: TrackType.Event) {
            action = "add_money"
            context = "D4"
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

    // REASONS REISSUE
    // --------
    test("cards mpcard block card reasons") {
        "/cards/mpcard/block_card/physical/reasons"(platform: "/", type: TrackType.View) {
            type = "reissue_normal_reasons"
        }

        "/cards/mpcard/block_card/physical/reasons/tap"(platform: "/", type: TrackType.Event) {
            action = "selected"
            option_id = "not_working"
        }

         "/cards/mpcard/block_card/physical/reasons/tap"(platform: "/", type: TrackType.Event) {
            action = "continue"
            option_id = "not_working"
        }
    }

    // CUSTOM FEEDBACK
    // --------
    test("cards mpcard custom feedback") {
        "/cards/mpcard/feedback_custom"(platform: "/", type: TrackType.View) {
            type = "reissue_other_reasons"
        }

        "/cards/mpcard/feedback_custom/tap"(platform: "/", type: TrackType.Event) {
            action = "confirm"
        }

        "/cards/mpcard/feedback_custom/tap"(platform: "/", type: TrackType.Event) {
            action = "exit"
        }
    }

    // INTERMEDIATE ONBOARDING
    // --------
    test("cards mpcard custom feedback") {
        "/cards/mpcard/block_card/physical/intermediate_onboarding"(platform: "/", type: TrackType.View) {
            type = "reissue_cancel_damaged_card"
            card_id = "123asd"
        }

        "/cards/mpcard/block_card/physical/intermediate_onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "reissue_pause_card"
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

    // CARD REQUEST virtual init point
    // --------
    test("cards mpcard request virtual init point") {
        "/cards/mpcard/request/virtual/init_point"(platform: "/", type: TrackType.View) {
            from = "home"
        }
    }

    // CARD REQUEST physical init point
    // --------
    test("cards mpcard request physical init point") {
        "/cards/mpcard/request/physical/init_point"(platform: "/", type: TrackType.View) {
            from = "dashboard"
        }
    }

    // CARD REQUEST virtual pj lock
    // --------
    test("cards mpcard request virtual pj lock") {
        "/cards/mpcard/request/virtual/onboarding/lock"(platform: "/", type: TrackType.View) {
            from = "unknown"
        }
    }

     // CARD REQUEST physical pj lock
    // --------
    test("cards mpcard request physical pj lock") {
        "/cards/mpcard/request/physical/onboarding/lock"(platform: "/", type: TrackType.View) {
            from = "dashboard"
        }
    }

    // CARD REQUEST virtual on boarding
    // --------
    test("cards mpcard virtual onboarding"){
        "/cards/mpcard/request/virtual/onboarding"(platform:"/", type: TrackType.Event) {
            context = "kyc"
        }
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

    //Cards Helper Extraction
    test("cards mpcard helper extraction to show user physical card data") {
        "/cards/mpcard/card_helper/extraction"(platform:"/", type: TrackType.View) {
            card_id = "cardId_goes_here"
        }
    }
    test("cards mlm helper extraction contingency") {
        "/cards/mpcard/card_helper/extraction/contingency"(platform:"/", type: TrackType.View) {
            card_id = "cardId_goes_here"
        }
        "/cards/mpcard/card_helper/extraction/contingency/tap"(platform:"/", type: TrackType.Event) {
            action = "back_button"
        }
    }

    // Tap4Auth
    test("cards mpcard tap4Auth main screen") {
        "/cards/mpcard/payment_authorization/main_screen"(platform:"/mobile", type: TrackType.View) {
            amount = 200.38
        }
        "/cards/mpcard/payment_authorization/main_screen"(platform:"/mobile", type: TrackType.View) {
            amount = 100.46
        }
        "/cards/mpcard/payment_authorization/main_screen/cta"(platform:"/mobile", type: TrackType.Event) {
            action = "authorize"
        }
        "/cards/mpcard/payment_authorization/main_screen/cta"(platform:"/mobile", type: TrackType.Event) {
            action = "no_authorize"
        }
    }
    test("cards hybrid tap4Auth congrats") {
        //View
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_accepted_congrats_physical"
        }
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_rejected_congrats_physical"
        }
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_accepted_congrats_virtual"
        }
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_rejected_congrats_virtual"
        }
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_rejected_congrats_virtual_second_try"
        }
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_rejected_congrats_virtual_third_try"
        }
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_accepted_ttl_expired_physical"
        }
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_accepted_ttl_expired_virtual"
        }
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_already_responded"
        }
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_rejected_congrats_virtual_third_contingency_cancel_try"
        }
        "/cards/mpcard/payment_authorization/congrats"(platform:"/mobile", type: TrackType.View) { 
            amount = 200.38
            tap4auth_congrats_type = "user_rejected_congrats_virtual_third_contingency_create_try"
        }
        // Events
        "/cards/mpcard/payment_authorization/congrats/cta"(platform:"/mobile", type: TrackType.Event) {
            tap4auth_congrats_type = "user_accepted_congrats_physical"
            action = "understands"
        }
        "/cards/mpcard/payment_authorization/congrats/cta"(platform:"/mobile", type: TrackType.Event) {
            tap4auth_congrats_type = "user_accepted_congrats_physical"
            action = "setup_virtual"
        }
        "/cards/mpcard/payment_authorization/congrats/cta"(platform:"/mobile", type: TrackType.Event) {
            tap4auth_congrats_type = "user_accepted_congrats_physical"
            action = "pause_card"
        }
        "/cards/mpcard/payment_authorization/congrats/cta"(platform:"/mobile", type: TrackType.Event) {
            tap4auth_congrats_type = "user_accepted_congrats_physical"
            action = "home"
        }
        "/cards/mpcard/payment_authorization/congrats/cta"(platform:"/mobile", type: TrackType.Event) {
            tap4auth_congrats_type = "user_accepted_congrats_physical"
            action = "report_card"
        }
        "/cards/mpcard/payment_authorization/congrats/cta"(platform:"/mobile", type: TrackType.Event) {
            tap4auth_congrats_type = "user_accepted_congrats_physical"
            action = "dismiss"
        }
    }
}
