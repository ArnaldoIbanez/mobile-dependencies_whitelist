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
            banner_is_present = false
            contact_is_present = true
        }
        "/cards/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
            action = "contact"
        }
        "/cards/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
            component_id = "banner_unlock"
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
        "/cards/hybrid/unlock/set-pin/invalide_pin"(platform: "/", type: TrackType.Event) {}
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

    // DASHBOARD
    // --------
    test("cards hybrid dashboard") {
        "/cards/hybrid/dashboard"(platform: "/", type: TrackType.View) {
            dashboard_status = "[minicard, flap, activities, message, account_options, carousel, linear_buttons, account_info]"
            minicard_status = "virtual_only"
            flap_status = "virtual_only"
            message_status = "warning"
            activities_status = "activities_with_error"
        }
        "/cards/hybrid/dashboard"(platform: "/", type: TrackType.View) {
            dashboard_status = "[minicard, flap, activities, account_options, carousel, linear_buttons, account_info]"
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
            action = "virtual_only"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "user_need_challenge"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_init"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_on_the_way"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_next_to_arrive"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_ready_for_unlocking"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "debit_active"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "physical_inactive"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "hybrid_active"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "tracking_not_delivered"
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

    // Acquisition Error
    // --------

    test("cards acquisition error") {
        "/cards/acquisition/error"(platform: "/", type: TrackType.View) {
            screen = "review"
        }
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

    // REISSUE VIRTUAL
    // --------

    test("cards hybrid reissue virtual card ") {
        "/cards/hybrid/block-card/virtual"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
        }
        "/cards/hybrid/block-card/virtual/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "primary_button"
        }
        "/cards/hybrid/block-card/virtual/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "secondary_button"
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
    }
    
    test("cards hybrid setup physical feedback") {
        "/cards/hybrid/setup/physical/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
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

    // Request

    // Request: Onboarding
    test("cards hybrid request physical onboarding") {
        "/cards/hybrid/request/physical/onboarding"(platform: "/", type: TrackType.View) {
            context = "no_kyc_no_challlenge"
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

    // CARD IDENTIFICATION
    // --------
    test("cards hybrid identification") {
        "/cards/hybrid/card_identification"(platform: "/", type: TrackType.View) {}
    }

    // CARD REQUEST init point
    // --------
    test("cards hybrid request init point") {
        "/cards/hybrid/request/init_point"(platform: "/", type: TrackType.View) {}
    }
    // CARD REQUEST virtual on boarding
    // --------
    test("cards hybrid virtual onboarding"){
        "/cards/hybrid/request/virtual/onboarding"(platform:"/", type: TrackType.Event) {}
    }
     test("cards hybrid virtual onboarding tap") {
        "/cards/hybrid/request/virtual/onboarding/tap"(platform:"/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/hybrid/request/virtual/onboarding/tap"(platform:"/", type: TrackType.Event) {
            action = "continue"
        }
    }
}
