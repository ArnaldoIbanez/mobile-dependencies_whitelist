package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

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
    
    // Credit Card

    def credit_card_data = [
        account: [
            rating: "A",
            status: "pending",
            status_detail: "",
            overdue_days: 0,
        ],
        statement_status: "open",
        pending_payments: false
    ]
    

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
        "/cards/hybrid/dashboard"(platform: "/", type: TrackType.View) {
            dashboard_status = "[minicard, flap, activities, message, account_options, carousel, linear_buttons, account_info]"
            dashboard_banner_status = "virtual_only"
            minicard_status = "virtual_only"
            flap_status = "virtual_only"
            message_status = "warning"
            activities_status = "activities_with_error"
            credits = credit_card_data
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
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "debit_active_and_credit_pending"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_debit_and_credit_pending"
        }
        "/cards/hybrid/dashboard/banner/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_debit_and_credit_active"
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
    }
    
    //Linear buttons: Tracking
    test("cards hybrid dashboard linear buttons") {
        "/cards/hybrid/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
            action = "help"
        }
        "/cards/hybrid/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
            action = "block"
        }
    }
    
    //Message: Tracking
    test("cards hybrid dashboard message") {
        "/cards/hybrid/dashboard/pin/message/tap"(platform:"/", type: TrackType.Event) {
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
    test("cards hybrid dashboard feedback") {
        "/cards/hybrid/dashboard/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }

    //Feedback for virtual credit card
    test("cards hybrid dashboard feedback for virtual credit card") {
        "/cards/hybrid/dashboard/feedback/credit/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }

    //Coachmark Banner
    test("cards hybrid dashboard coachmark banner"){
        "/cards/hybrid/dashboard/coachmark_banner"(platform: "/", type: TrackType.Event) {
            action = "close"
            id = "dashboard_virtual_coachmark"
        }
        "/cards/hybrid/dashboard/coachmark_banner"(platform: "/", type: TrackType.Event) {
            action = "tap"
            id = "dashboard_physical_coachmark"
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

    //FTU Carousel Onboarding: Tracking
    test("cards hybrid dashboard ftu carousel onboarding") {
        "/cards/hybrid/dashboard/ftu_carousel_onboarding"(platform: "/", type: TrackType.View) {}
    }
    test("cards hybrid dashboard ftu carousel onboarding tap") {
        "/cards/hybrid/dashboard/ftu_carousel_onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/hybrid/dashboard/ftu_carousel_onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "continue"
        }
    }
    test("cards hybrid dashboard ftu carousel onboarding swiped") {
        "/cards/hybrid/dashboard/ftu_carousel_onboarding/swipe"(platform:"/", type: TrackType.Event) {
            action = "swipe_virtual_slide"
        }
        "/cards/hybrid/dashboard/ftu_carousel_onboarding/swipe"(platform:"/", type: TrackType.Event) {
            action = "swipe_physical_slide"
        }
        "/cards/hybrid/dashboard/ftu_carousel_onboarding/swipe"(platform:"/", type: TrackType.Event) {
            action = "swipe_credit_slide"
        }
        "/cards/hybrid/dashboard/ftu_carousel_onboarding/swipe"(platform:"/", type: TrackType.Event) {
            action = "swipe_nfc_slide"
        }
    }
    
    //FTU Single Onboarding: Tracking 
    test("cards hybrid dashboard ftu single onboarding") {
        "/cards/hybrid/dashboard/ftu_single_onboarding"(platform: "/", type: TrackType.View) {}
    }
    test("cards hybrid dashboard ftu single onboarding tap") {
        "/cards/hybrid/dashboard/ftu_single_onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/hybrid/dashboard/ftu_single_onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "continue"
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
        "/cards/engagement/decrypting/error" (platform: "/", type: TrackType.Event) {
            error = "keyGenerationError"
            from = "CEEncryptTextBrickPresenter"
        }
    }

    // SETUP VIRTUAL
    // --------

    //Card
    test("cards hybrid setup virtual card tracking") {
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "deprecated"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "new"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "on_creation"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "on_delivery"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "delivered"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "active"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "freeze"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "blocked"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            product_type = "prepaid"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            product_type = "hybrid"
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            product_type = "hybrid"
            has_money = true
        }
        "/cards/hybrid/setup/virtual"(platform:"/", type: TrackType.View) {
            card_id = "12345abcdef"
            initial_status = "inactive"
            product_type = "hybrid"
            has_money = false
        }
    }
    test("cards hybrid setup virtual card taps tracking") {
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
            action = "additional_message_freeze"
        }
    }
    test("cards hybrid setup virtual wsp button tap tracking") {
        "/cards/hybrid/setup/virtual/whatsapp/button/tap"(platform:"/", type: TrackType.Event) {
            action = "action"
        }
    }
    test("cards hybrid setup virtual card taps tracking") {
        "/cards/hybrid/setup/virtual/card/modal/tap"(platform:"/", type: TrackType.Event) {
            action = "primary_button"
        }
    }

    //Highlighted Row
    test("cards hybrid setup virtual Highlighted Row") {
        "/cards/hybrid/setup/virtual/highlighted_row/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }
    

    // Cards hub
    test("cards hybrid card setup virtual hub") {
            "/cards/hybrid/card_hub/setup_virtual"(platform:"/", type: TrackType.View) {}
            "/cards/hybrid/card_hub/setup_virtual/tap"(platform:"/", type: TrackType.Event) {
                action = "credit_card"
            }
            "/cards/hybrid/card_hub/setup_virtual/tap"(platform:"/", type: TrackType.Event) {
                action = "debit_card"
            }
        }


    test("cards hybrid card block hub") {
            "/cards/hybrid/card_hub/block_card"(platform:"/", type: TrackType.View) {}
            "/cards/hybrid/card_hub/block_card/tap"(platform:"/", type: TrackType.Event) {
                action = "virtual_debit_card"
            }
            "/cards/hybrid/card_hub/block_card/tap"(platform:"/", type: TrackType.Event) {
                action = "virtual_credit_card"
            }
             "/cards/hybrid/card_hub/block_card/tap"(platform:"/", type: TrackType.Event) {
                action = "physical_card"
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

    // WHATSAPP BUTTON
    test("cards hybrid card setup virtual whatsapp button") {
            "/cards/hybrid/setup/virtual/whatsapp/button/tap"(platform:"/", type: TrackType.Event){
                
            }
        }

    // REISSUE VIRTUAL
    // --------

    test("cards hybrid reissue virtual card ") {
        "/cards/hybrid/block_card/virtual"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
            context = "cancellation"
        }
        "/cards/hybrid/block_card/virtual"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
            context = "creation"
        }
        "/cards/hybrid/block_card/virtual"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
            context = "creation"
            flow_version = 2
        }
        "/cards/hybrid/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "primary_button"
            context = "creation"
        }
        "/cards/hybrid/block_card/virtual/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "secondary_button"
            context = "cancellation"
        }
        "/cards/hybrid/block_card/virtual/success"(platform:"/", type: TrackType.Event) {
            reasons = ["debit_available_push_strategy_none", "reissue"]
         }
    }

    // REISSUE VIRTUAL CREDIT
    // --------

    test("cards hybrid reissue virtual credit card ") {
        "/cards/hybrid/block_card/virtual/credit"(platform:"/", type: TrackType.View) {
            card_id = "1234abcd"
        }
        "/cards/hybrid/block_card/virtual/credit/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "primary_button"
        }
        "/cards/hybrid/block_card/virtual/credit/tap"(platform:"/", type: TrackType.Event) {
            card_id = "1234abcd"
            action = "secondary_button"
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
            limits_status = "number_selector_atm"
        }
        "/cards/hybrid/limits_setup"(platform: "/", type: TrackType.View) {
            limits_status = "message"
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

        // REASONS REISSUE
    // --------
    test("cards hybrid block card reasons") {
        "/cards/hybrid/block_card/physical/reasons"(platform: "/", type: TrackType.View) {
            type = "reissue_normal_reasons"
        }

        "/cards/hybrid/block_card/physical/reasons/tap"(platform: "/", type: TrackType.Event) {
            action = "selected"
            option_id = "not_working"
        }

         "/cards/hybrid/block_card/physical/reasons/tap"(platform: "/", type: TrackType.Event) {
            action = "continue"
            option_id = "not_working"
        }
    }

    // CUSTOM FEEDBACK
    // --------
    test("cards hybrid custom feedback") {
        "/cards/hybrid/feedback_custom"(platform: "/", type: TrackType.View) {
            type = "reissue_other_reasons"
        }

        "/cards/hybrid/feedback_custom/tap"(platform: "/", type: TrackType.Event) {
            action = "confirm"
        }

        "/cards/hybrid/feedback_custom/tap"(platform: "/", type: TrackType.Event) {
            action = "exit"
        }
    }

    // INTERMEDIATE ONBOARDING
    // --------
    test("cards hybrid custom feedback") {
        "/cards/hybrid/block_card/physical/intermediate_onboarding"(platform: "/", type: TrackType.View) {
            type = "reissue_cancel_damaged_card"
            card_id = "123asd"
        }

        "/cards/hybrid/block_card/physical/intermediate_onboarding/tap"(platform: "/", type: TrackType.Event) {
            action = "reissue_pause_card"
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

    // CARD REQUEST virtual init point
    // --------
    test("cards hybrid request virtual init point") {
        "/cards/hybrid/request/virtual/init_point"(platform: "/", type: TrackType.View) {
            from = "home"
        }
    }

    // CARD REQUEST physical init point
    // --------
    test("cards hybrid request physical init point") {
        "/cards/hybrid/request/physical/init_point"(platform: "/", type: TrackType.View) {
            from = "dashboard"
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
        "/cards/mp-card/hybrid/detail/click-send-message" (platform: "/web/desktop", type: TrackType.Event) { }
    }

    //COACHMARK
    // --------
    test("cards hybrid coachmark tap"){
        "/cards/hybrid/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "close"
            step = 1
            id = "dashboard_virtual_coachmark"
        }
        "/cards/hybrid/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "next"
            step = 2
            id = "dashboard_physical_coachmark"
        }
        "/cards/hybrid/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "previous"
            step = 2
            id = "dashboard_virtual_coachmark"
        }
        "/cards/hybrid/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "next"
            step = 3
            id = "setup_virtual_debit_coachmark"
        }
        "/cards/hybrid/coachmark/tap"(platform: "/", type: TrackType.Event) {
            action = "next"
            step = 3
            id = "setup_virtual_credit_coachmark"
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
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "chip_hybrid"
            action = "disable_credit_card"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "contactless_debit_contactless"
            action = "freeze"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "contactless_credit_contactless"
            action = "freeze"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "contactless_hybrid_contactless"
            action = "freeze"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "contactless_debit_contactless"
            action = "unfreeze"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "contactless_credit_contactless"
            action = "unfreeze"
        }
        "/cards/hybrid/setup/options/tap"(platform: "/", type: TrackType.Event) {
            product_type = "contactless_hybrid_contactless"
            action = "unfreeze"
        }
    }

    //OPTIONS Empty State
    test("cards hybrid options Empty State tracking") {
        "/cards/hybrid/setup/options/empty_state"(platform:"/", type: TrackType.View) {}
        "/cards/hybrid/setup/options/empty_state/tap"(platform:"/", type: TrackType.Event) {
            action = "primary_button"
        }
        "/cards/hybrid/setup/options/empty_state/tap"(platform:"/", type: TrackType.Event) {
            action = "secondary_button"
        }
    }

    //OPTIONS Message
    test("cards hybrid options message tracking") {
        "/cards/hybrid/setup/options/message/lock/tap"(platform:"/", type: TrackType.Event) {
            action = "unblock_pin"
        }
    }

    //OPTIONS Feedback
    test("cards hybrid options feedback button event") {
        "/cards/hybrid/setup/options/feedback/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }

    //OPTIONS Feedback for virtual credit card
    test("cards hybrid options feedback button event for virtual credit card") {
        "/cards/hybrid/setup/options/feedback/credit/tap"(platform:"/", type: TrackType.Event) {
            action = "research_form"
        }
    }
    //Cards Helper Extraction
    test("cards hybrid helper extraction to show user physical card data") {
        "/cards/hybrid/card_helper/extraction"(platform:"/", type: TrackType.View) {
            card_id = "cardId_goes_here"
        }
    }
    test("cards hybrid helper extraction contingency") {
        "/cards/hybrid/card_helper/extraction/contingency"(platform:"/", type: TrackType.View) {
            card_id = "cardId_goes_here"
        }
        "/cards/hybrid/card_helper/extraction/contingency/tap"(platform:"/", type: TrackType.Event) {
            action = "back_button"
        }
    }


    // OPTIONS Semaphore
    test("card options semaphore states for nfc") {
        "/cards/hybrid/setup/options/semaphore"(platform:"/", type: TrackType.View) {}
        "/cards/hybrid/setup/options/semaphore/render"(platform:"/", type: TrackType.Event) {
            action = "configured"
        }
        "/cards/hybrid/setup/options/semaphore/render"(platform:"/", type: TrackType.Event) {
            action = "not_configured"
        }
        "/cards/hybrid/setup/options/semaphore/render"(platform:"/", type: TrackType.Event) {
            action = "not_tokenized"
        }
        "/cards/hybrid/setup/options/semaphore/render"(platform:"/", type: TrackType.Event) {
            action = "tokenized_in_progress"
        }
        "/cards/hybrid/setup/options/semaphore/render"(platform:"/", type: TrackType.Event) {
            action = "privder_suspended"
        }
        "/cards/hybrid/setup/options/semaphore/tap"(platform:"/", type: TrackType.Event) {
            action = "configured"
        }
        "/cards/hybrid/setup/options/semaphore/tap"(platform:"/", type: TrackType.Event) {
            action = "not_configured"
        }
    }

    //NFC ENROLLMENT HUB
    test("cards hybrid nfc enrollment hub") {
        "/cards/nfc/enrollment/hub"(platform:"/", type: TrackType.View) {}
        "/cards/nfc/enrollment/hub/tap"(platform:"/", type: TrackType.Event) {
            action = "primary_button"
        }
        "/cards/nfc/enrollment/hub/tap"(platform:"/", type: TrackType.Event) {
            action = "secondary_button"
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
        "/cards/nfc/enrollment/hub/incomplete_steps"(platform:"/", type: TrackType.Event) {
            result = 1
            incomplete_steps = "pin_tnp_nfc"
        }
        "/cards/nfc/enrollment/hub/incomplete_steps"(platform:"/", type: TrackType.Event) {
            result = 1
            incomplete_steps = "tnp_nfc"
        }
        "/cards/nfc/enrollment/hub/incomplete_steps"(platform:"/", type: TrackType.Event) {
            result = 1
            incomplete_steps = "pin_nfc"
        }
        "/cards/nfc/enrollment/hub/incomplete_steps"(platform:"/", type: TrackType.Event) {
            result = 1
            incomplete_steps = "pin_tnp"
        }
        "/cards/nfc/enrollment/hub/incomplete_steps"(platform:"/", type: TrackType.Event) {
            result = 1
            incomplete_steps = "pin"
        }
        "/cards/nfc/enrollment/hub/incomplete_steps"(platform:"/", type: TrackType.Event) {
            result = 1
            incomplete_steps = "tnp"
        }
        "/cards/nfc/enrollment/hub/incomplete_steps"(platform:"/", type: TrackType.Event) {
            result = 1
            incomplete_steps = "nfc"
        }
        "/cards/nfc/enrollment/hub/incomplete_steps"(platform:"/", type: TrackType.Event) {
            result = 0
            incomplete_steps = "all_complete"
        }
    }
    
    //NFC CONFIGURATION HUB
    test("cards hybrid nfc configuration hub") {
        "/cards/nfc/configuration/hub"(platform:"/", type: TrackType.View) {}
        "/cards/nfc/configuration/hub/tap"(platform:"/", type: TrackType.Event) {
            action = "primary_button"
        }
        "/cards/nfc/configuration/hub/tap"(platform:"/", type: TrackType.Event) {
            action = "secondary_button"
        }
        "/cards/nfc/configuration/hub/tap"(platform:"/", type: TrackType.Event) {
            action = "back"
        }
        "/cards/nfc/configuration/hub/tap"(platform:"/", type: TrackType.Event) {
            action = "contextual_help"
        }
        "/cards/nfc/configuration/hub/tap"(platform:"/", type: TrackType.Event) {
            action = "feedback"
        }
        "/cards/nfc/configuration/hub/step/tap"(platform:"/", type: TrackType.Event) {
            action = "step_tap_and_pay"
        }
        "/cards/nfc/configuration/hub/step/tap"(platform:"/", type: TrackType.Event) {
            action = "step_pin"
        }
        "/cards/nfc/configuration/hub/step/tap"(platform:"/", type: TrackType.Event) {
            action = "step_nfc"
        }     
        "/cards/nfc/configuration/hub/step/tap"(platform:"/", type: TrackType.Event) {
            action = "step_nfc_freeze"
        }     
        "/cards/nfc/configuration/hub/redirect"(platform:"/", type: TrackType.Event) {
            action = "success_redirect"
        }
    }
    
    test("cards hybrid nfc onboarding") {
        "/cards/nfc/enrollment/hub/onboarding"(platform:"/", type: TrackType.View) {}
        "/cards/nfc/enrollment/hub/onboarding/tap"(platform:"/", type: TrackType.Event) {
            kyc_status = "kyc_compilance"
            action = "main"
        }
    }
    
    // Block Page NFC
    test("cards hybrid nfc block page") {
        "/cards/nfc/block_page/not_nfc_device"(platform:"/", type: TrackType.View) {}
        "/cards/nfc/block_page/acquisition_rollout"(platform:"/", type: TrackType.View) {}
        "/cards/nfc/block_page/tap"(platform:"/", type: TrackType.Event) {
            action = "primary"
            type = "not_nfc_device"
        }
        "/cards/nfc/block_page/tap"(platform:"/", type: TrackType.Event) {
            action = "secondary"
            type = "acquisition_rollout"
        }
        "/cards/nfc/block_page/not_nfc_device/tap"(platform:"/", type: TrackType.Event) {
            action = "close"
        }
        "/cards/nfc/block_page/acquisition_rollout/tap"(platform:"/", type: TrackType.Event) {
            action = "close"
        }
    }
    // CREATE-CARD-NFC
    test("cards hybrid nfc card creation") {
        "/cards/nfc/acquisition/create_nfc_card"(platform:"/", type: TrackType.View) {}
        "/cards/nfc/acquisition/create_nfc_card/redirect"(platform:"/", type: TrackType.Event) {
            action = "some deeplink"
        }
        "/cards/nfc/congrats/create_nfc_card_error"(platform: "/", type: TrackType.View) {}
    }
    
    // NFC-KYC
    test("cards hybrid nfc kyc initialization") {
        "/cards/nfc/acquisition/init_nfc_kyc"(platform:"/", type: TrackType.Event) {
            action = "some deeplink"
        }
    }
    
    // NFC Tokenization Status
    test("cards hybrid nfc enrollment tokenization") {
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "success_enrollment"
            result = "tokenization completed event"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "error_enrollment"
            result = "missing enrollment push notification"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "error_enrollment"
            result = "cardInfo error"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "error_enrollment"
            result = "checkCardEligibility error"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "error_enrollment"
            result = "partial enrollment CardDeleteResult UNKNOWN_DIGITAL_CARD_ID"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "error_enrollment"
            result = "partial enrollment CardDeleteResult error"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "error_enrollment"
            result = "partial enrollment deleteCard DELETE_RETRIES exceeded"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "error_enrollment"
            result = "partial enrollment deleteCard error"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "error_enrollment"
            result = "digitize error"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "error_enrollment"
            result = "fetchTokenizationDataWorker HTTP_NOT_FOUND or HTTP_UNAVAILABLE error"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "error_enrollment"
            result = "fetchTokenizationDataWorker error"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "success_callback"
            result = "checkCardEligibility success"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "success_callback"
            result = "checkCardEligibility partial enrollment"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "success_callback"
            result = "partial enrollment CardDeleteResult success"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "success_callback"
            result = "digitize success"
        }
        "/cards/nfc/enrollment/tokenization/callback"(platform:"/", type: TrackType.Event) {
            action = "success_callback"
            result = "fetchTokenizationDataWorker success"
        }
    }

    // NFC Message Processor
    test("message processor information") {
        "/cards/nfc/enrollment/tokenization/messageprocessor"(platform:"/", type: TrackType.Event) {
            information = "The message processor: error_code + error message"
        }
    }

    // NFC Tokenization Time
    test("cards hybrid nfc enrollment tokenization time") {
        "/cards/nfc/enrollment/tokenization/time"(platform:"/", type: TrackType.Event) {
            action = "success_enrollment"
            result = 16511
        }
        "/cards/nfc/enrollment/tokenization/time"(platform:"/", type: TrackType.Event) {
            action = "success_async_callback"
            result = 12151
        }
        "/cards/nfc/enrollment/tokenization/time"(platform:"/", type: TrackType.Event) {
            action = "success_push_received"
            result = 4360
        }
    }

    // NFC Tokenization Time
    test("cards hybrid nfc enrollment tokenization attempts") {
        "/cards/nfc/enrollment/tokenization/attempts"(platform:"/", type: TrackType.Event) {
            result = 1
        }
    }

    // NFC Payment
    test("cards hybrid nfc payment") {
        "/cards/nfc/payment"(platform:"/", type: TrackType.View) {
            from = "home_mp"
        }
        "/cards/nfc/payment"(platform:"/", type: TrackType.View) {
            from = "setup_options"
        }
        "/cards/nfc/payment"(platform:"/", type: TrackType.View) {
            from = "closed_app"
        }
        "/cards/nfc/payment"(platform:"/", type: TrackType.View) {
            from = "tap_in_app"
        }
        "/cards/nfc/payment/tap_pos"(platform:"/", type: TrackType.Event) {
            result = "error_payment"
            reasons = "payment is not allowed as SDK initialization is ongoing"
        }
        "/cards/nfc/payment/tap_pos"(platform:"/", type: TrackType.Event) {
            result = "error_payment"
            reasons = "payment is not allowed as SDK is not initialized"
        }
        "/cards/nfc/payment/tap"(platform:"/", type: TrackType.Event) {
            action = "faq"
        }
        "/cards/nfc/payment/intention"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/payment/pos_contact"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/payment/waiting_payment"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/payment/waiting_payment/tap"(platform: "/", type: TrackType.Event) {
            action = "money_in"
        }
        "/cards/nfc/payment/without_money"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/payment/without_money/tap"(platform: "/", type: TrackType.Event) {
            action = "money_in"
        }
        "/cards/nfc/payment/congrats"(platform: "/", type: TrackType.View) {
            status = "success"
        }
        "/cards/nfc/payment/congrats"(platform: "/", type: TrackType.View) {
            status = "unknown"
        }
        "/cards/nfc/congrats/insufficient_money"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/congrats/blocked_pin"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/congrats/connection_error"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/congrats/invalid_pin"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/congrats/generic_tap_pos_error"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/congrats/generic_error"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/payment/congrats/tap"(platform: "/", type: TrackType.Event) {
            action = "finish"
        }
        "/cards/nfc/acquisition/congrats"(platform: "/", type: TrackType.View) {}
        "/cards/nfc/acquisition/congrats/tap"(platform: "/", type: TrackType.Event) {
            action = "primary"
            type = "blocked_pin"
        }
        "/cards/nfc/acquisition/congrats/tap"(platform: "/", type: TrackType.Event) {
            action = "secondary"
            type = "connection_error"
        }
        "/cards/nfc/acquisition/congrats/tap"(platform: "/", type: TrackType.Event) {
            action = "secondary"
            type = "invalid_pin"
        }
        "/cards/nfc/acquisition/congrats/tap"(platform: "/", type: TrackType.Event) {
            action = "primary"
            type = "generic_tap_pos_error"
        }
        "/cards/nfc/payments/congrats/tap"(platform: "/", type: TrackType.Event) {
            action = "finish"
            type = "generic_error"
        }
        "/cards/nfc/payments/congrats/tap"(platform: "/", type: TrackType.Event) {
            action = "finish"
            type = "generic_tap_pos_error"
        }
        "/cards/nfc/payments/congrats/tap"(platform: "/", type: TrackType.Event) {
            action = "primary"
            type = "generic_error"
        } 
        "/cards/nfc/payments/congrats/tap"(platform: "/", type: TrackType.Event) {
            action = "secondary"
            type = "invalid_pin"
        }
    }
    
    // NFC Feature
    test("nfc feature is available"){
        "/cards/nfc/feature/availability"(platform: "/", type: TrackType.Event) {}
    }
    
    // NFC Core
    test("cards hybrid nfc core"){

        "/cards/nfc/core/error/start_secure_enrollment"(platform: "/", type: TrackType.Event) {
            error_code = "wse_internal_error"
        }
        "/cards/nfc/core/error/start_secure_enrollment"(platform: "/", type: TrackType.Event) {
            error_code = "common_no_internet"
        }
        "/cards/nfc/core/error/start_secure_enrollment"(platform: "/", type: TrackType.Event) {
            error_code = "common_comm_error"
        }
        "/cards/nfc/core/error/start_secure_enrollment"(platform: "/", type: TrackType.Event) {
            error_code = "common_server_error"
        }
        "/cards/nfc/core/error/start_secure_enrollment"(platform: "/", type: TrackType.Event) {
            error_code = "re_enrollment_required"
        }
        "/cards/nfc/core/error/start_secure_enrollment"(platform: "/", type: TrackType.Event) {
            error_code = "wse_storage_access_error"
        }
        "/cards/nfc/core/error/start_secure_enrollment"(platform: "/", type: TrackType.Event) {
            error_code = "json_parsing_error"
        }
        "/cards/nfc/core/error/start_secure_enrollment"(platform: "/", type: TrackType.Event) {
            error_code = "wse_request_error"
        }
        "/cards/nfc/core/error/start_secure_enrollment"(platform: "/", type: TrackType.Event) {
            error_code = "wse_download_error"
        }
        
        "/cards/nfc/core/error/enroll_device"(platform: "/", type: TrackType.Event) {
            error_code = "common_no_internet"
        }
        
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "common_comm_error"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "common_server_error"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "enrollment_wrong_credentials"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "enrollment_credential_expired"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "enrollment_try_limit_exceeded"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "card_activation_mobile_pin_invalid_length"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "card_activation_mobile_pin_mismatch"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "change_pin_reentry_mismatch"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "common_comm_error"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "change_pin_card_not_active"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "change_pin_card_not_exist"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "card_not_enrolled"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "card_state_unknown"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "replenishment_not_allowed"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "sdk_internal_component_error"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "enrollment_wrong_activation_code"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "enrollment_blocked_secure_wallet_enrollment_required"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "replenishment_blocked_secure_wallet_enrollment_required"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "invalid_replenish_missing_payment"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "asm_error"
        }
        "/cards/nfc/core/error/replenish_payment_keys"(platform: "/", type: TrackType.Event) {
            error_code = "invalid_digitalcardid"
        }
        
        "/cards/nfc/core/error/check_card_eligibility"(platform: "/", type: TrackType.Event) {
            error_code = "no_internet"
        }
        
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "connection_timeout"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "communication_error"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "server_error"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "internal_error"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unknown_bin"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unknown_card_product"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "card_product_not_supported"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "incorrect_cvv"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "card_already_provisioned_in_wallet"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "device_not_eligible"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "incorrect_authentication_token"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "card_provisioning_count_exceeded"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unkonown_idv_method"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "provisioning_not_allowed"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "incorrect_otp"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "incorrect_otp_max_try_exceeded"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "otp_expired"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "idv_method_not_available"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unexpected_internal_error"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "external_system_unavailable"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unknown_wallet_provider_id"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unknown_wallet_id"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unknown_digital_card_id"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unknown_correlation_id"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "card_state_does_not_allow_requested_operation"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "operation_already_ongoing"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "operation_failed"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unknown_device_id"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "missing_required_parameter"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unknown_issuer_id"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "unknown_card_id"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "no_tnc_resource_id"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "invalid_tnc_data_type"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "securestorage_write_config_data_error"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "securestorage_wipe_all_error"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "context_missing_error"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "web_3ds_authentication_failed"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "web_3ds_data_error"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "invalid_card_data"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "no_card_meta_data"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "card_meta_data_json_error"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "no_card_data"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "invalid_asset_type"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "invalid_asset_version"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "asset_not_available"
        }
        "/cards/nfc/core/error/digitize_card"(platform: "/", type: TrackType.Event) {
            error_code = "blocked_secure_wallet_enrollment_required"
        }
    }
    
    test("cards hybrid nfc core sdk not initialized error") {
        "/cards/nfc/core/error/sdk_not_initialized"(platform:"/", type: TrackType.View) {
            from = "EnrollmentWorker"
        }
    }
    
    test("cards hybrid nfc core sdk initialization worker error") {
        "/cards/nfc/core/error/sdk_initialization_worker"(platform:"/", type: TrackType.View) {
            error_message = "The error was: error_code + error message"
        }
    }
    
    // NFC-INFORMATIVE-SCREEN
    test("cards hybrid nfc informative screen") {
        "/cards/nfc/enrollment/instructions"(platform:"/", type: TrackType.View) {
            has_money = true
        }
        
        "/cards/nfc/enrollment/instructions"(platform:"/", type: TrackType.View) {
            has_money = false
        }
        
        "/cards/nfc/enrollment/instructions/tap"(platform:"/", type: TrackType.View) {
            action = "close"
        }
    }
    
    // NFC-TOKENIZATION-USER-WAIT-TIME
    test("cards hybrid nfc tokenization user waiting time") {
        "/cards/nfc/enrollment/tokenization/waiting_time"(platform:"/", type: TrackType.View) {
            time_millis = 1
            result= "enrollment_error"
        }
        "/cards/nfc/enrollment/tokenization/waiting_time"(platform:"/", type: TrackType.View) {
            time_millis = 0
            result= "success"
        }
    }

    // NFC-DEVICE-CVM
    test("cards hybrid nfc device cvm information") {
        "/cards/nfc/enrollment/devicecvm"(platform:"/", type: TrackType.Event) {
            status = "device cdcvm initialized"
        }
    }

    test("cards hybrid nfc feature ignite status") {
        "/cards/nfc/core/ignite"(platform:"/", type: TrackType.Event) {
            value = true
        }
        "/cards/nfc/core/ignite"(platform:"/", type: TrackType.Event) {
            value = false
        }
    }
    
    test("cards hybrid nfc initialization service") {
        "/cards/nfc/core/service"(platform:"/", type: TrackType.Event) { }
        "/cards/nfc/core/service/error"(platform:"/", type: TrackType.Event) {
            error_code = "INTERNAL_COMPONENT_ERROR"
        }
        "/cards/nfc/core/service/success"(platform:"/", type: TrackType.Event) { }
    }

        
    // NFC-CONSTRAINT
    
    test("cards nfc constraint update") {
        "/cards/nfc/constraint/update"(platform: "/", type: TrackType.Event) {
           action = "send"
           event = "TokenizationCompletedEvent"
        }
    }
    
    // NFC-SEMAPHORE
    
    test("cards hybrid nfc semaphore constraints status") {
        "/cards/nfc/semaphore/constraints"(platform: "/", type: TrackType.Event) {
            has_nfc_card_created = true
            has_active_nfc_card = true
            has_pin = true
            is_nfc_payments_initialized = true
            is_token_ready = true
            is_token_active = true
            is_default_tap_n_pay = true
            is_restrictive = true
            is_tap_n_pay_admitted_to_pay = true
            is_default_card = true
            is_nfc_activated = true
            are_payment_keys_avaliable = true
        }
        "/cards/nfc/semaphore/constraints"(platform: "/", type: TrackType.Event) {
            has_nfc_card_created = false
            has_active_nfc_card = false
            has_pin = false
            is_nfc_payments_initialized = false
            is_token_ready = false
            is_token_active = false
            is_default_tap_n_pay = false
            is_restrictive = false
            is_tap_n_pay_admitted_to_pay = false
            is_default_card = false
            is_nfc_activated = false
            are_payment_keys_avaliable = false
        }
    }
    
    // NFC status
    test ("cards hybrid nfc feature nfc status") {
        "/cards/nfc/status"(platform: "/", type: TrackType.Event) {
            restrictiveness = 'restrictive'
            default_app = 'default'
        }
        "/cards/nfc/status"(platform: "/", type: TrackType.Event) {
            restrictiveness = 'not_restrictive'
            default_app = 'default'
        }
        "/cards/nfc/status"(platform: "/", type: TrackType.Event) {
            restrictiveness = 'restrictive'
            default_app = 'not_default'
        }
        "/cards/nfc/status"(platform: "/", type: TrackType.Event) {
            restrictiveness = 'not_restrictive'
            default_app = 'not_default'
        }
    }

}
