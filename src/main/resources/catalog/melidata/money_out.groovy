package catalog.melidata

import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1149'

    /**
        Money Out Tracks
    **/
    "/money_out"(platform: "/", isAbstract: true) {}
    "/money_out/cashout"(platform: "/", isAbstract: true) {}
    "/money_out/cashout/onboarding"(platform: "/", isAbstract: true) {}
    "/money_out/transfers/mlm"(platform: "/", isAbstract: true) {}

    // Cashout ticket tracks
    "/money_out/cashout/ticket"(platform: "/", type: TrackType.View) {}

    "/money_out/cashout/cancel_ticket"(platform: "/", type: TrackType.Event) {}

    // Cashout calculator tracks

    "/money_out/calculator"(platform: "/", type: TrackType.View) {
        money_out_method (required:true, description: "Money out method on calculator")
    }

    "/money_out/calculator/preset_selected"(platform: "/", type: TrackType.Event) {
        money_out_method (required:true, description: "Money out method on calculator")
        preset (required:true, description: "Preset amount selected")
    }

    "/money_out/calculator/continue"(platform: "/", type: TrackType.Event) {
        money_out_method (required:true, description: "Continue Money out method selected")
        amount (required:true, description: "Continue amount entered")
    }

    "/money_out/cashout/map"(platform: "/", type: TrackType.View) {}

    // Cashout onboarding
    "/money_out/kyc"(platform: "/", isAbstract: true) {}
    "/money_out/kyc/onboarding"(platform: "/", type: TrackType.View) {}

    // New Cashout Onobaording
    "/money_out/cashout/onboarding"(platform: "/", type: TrackType.View) {}
    //Legacy onboarding
    "/money_out/cashout/onboarding/withdraw_limit"(platform: "/", type: TrackType.View) {}
    "/money_out/cashout/onboarding/withdraw_agencies"(platform: "/", type: TrackType.View) {}
    "/money_out/cashout/onboarding/withdraw_less"(platform: "/", type: TrackType.View) {}

    "/money_out/cashout/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/cashout/onboarding/done"(platform: "/", type: TrackType.Event) {}
    "/money_out/cashout/onboarding/close"(platform: "/", type: TrackType.Event) {}

    // Dashboard
    "/money_out/dashboard"(platform: "/", type: TrackType.View) {}
    "/money_out/dashboard/select"(platform: "/", type: TrackType.Event) {
        transfer_method (required:true, description: "Transfer method selected")
    }

    // Tecban
    "/money_out/tecban"(platform: "/", isAbstract: true) {}
    "/money_out/tecban/network_error"(platform: "/", type: TrackType.View) {}
    "/money_out/tecban/onboarding"(platform: "/", type: TrackType.View) {}
    "/money_out/tecban/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/tecban/insufficient_amount"(platform: "/", type: TrackType.View) {}
    "/money_out/tecban/insufficient_amount/exit"(platform: "/", type: TrackType.Event) {}
    "/money_out/tecban/select_amount"(platform: "/", type: TrackType.View) {}
    "/money_out/tecban/select_amount/help"(platform: "/", type: TrackType.Event) {}
    "/money_out/tecban/select_amount/other"(platform: "/", type: TrackType.Event) {}
    
    "/money_out/tecban/select_amount/amount"(platform: "/", type: TrackType.Event) {
        amount (required:true, description: "Selected amount")
    }

    "/money_out/tecban/select_amount/show_map"(platform: "/mobile", type: TrackType.Event){}

    "/money_out/tecban/scanner"(platform: "/", type: TrackType.View) {}
    
    "/money_out/tecban/scanner/invalid_qr"(platform: "/", type: TrackType.Event) {
        qr (required:true, description: "Scanned QR code")
    }

    "/money_out/tecban/scanner/valid_qr"(platform: "/", type: TrackType.Event) {
        qr (required:true, description: "Scanned QR code")
    }

    "/money_out/tecban/authorize"(platform: "/", type: TrackType.View) {}
    "/money_out/tecban/success"(platform: "/", type: TrackType.View) {}
    "/money_out/tecban/success/exit"(platform: "/", type: TrackType.Event) {}
    "/money_out/tecban/success/help"(platform: "/", type: TrackType.Event) {}
    
    "/money_out/tecban/error"(platform: "/", type: TrackType.View) {
        error (required:true, description: "Status returned by wrapper")
    }

    "/money_out/tecban/error/exit"(platform: "/", type: TrackType.Event) {
        error (required:true, description: "Status returned by wrapper")
    }
    
    "/money_out/tecban/risk_cap"(platform: "/", type: TrackType.View) {}

    //Transfer Hub 
    "/money_out/transfers"(platform: "/", isAbstract: true) {}

    //Transfer Hub - Dashboard
    "/money_out/transfers/home"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/home/transfer_mp"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/transfer_bank"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/transfer_pix"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/unified_transfers_p2p"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/send_money"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/transfer_ted"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/account_selected"(platform: "/", type: TrackType.Event) {
        type (required_:false, description: "Indicate if account is ted or mp")
    }
    "/money_out/transfers/home/account_mark_favorite"(platform: "/", type: TrackType.Event) {
        type (required_:false, description: "Indicate if account is ted or mp")
    }
    "/money_out/transfers/home/account_unmark_favorite"(platform: "/", type: TrackType.Event) {
        type (required_:false, description: "Indicate if account is ted or mp")
    }
    "/money_out/transfers/home/account_deleted"(platform: "/", type: TrackType.Event) {
        type (required_:false, description: "Indicate if account is ted or mp")
    }
    "/money_out/transfers/home/recents_tab_selected"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/favs_tab_selected"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/faq_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/profile_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/scheduled_transfers_selected"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Scheduled Transfers
    "/money_out/transfers/scheduled_transfers_list"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/scheduled_transfers_list/transfer_selected"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfers_list/faq"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfers_list/transfer_cancel_click"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfers_list/transfer_cancel_succes"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfers_list/transfer_cancel_error"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Scheduled Transfers Detail
    "/money_out/transfers/scheduled_transfer_detail"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/scheduled_transfer_detail/cancel"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfer_detail/cancel_dismissed"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfer_detail/cancel_confirmed"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfer_detail/money_in_click"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfer_detail/show_receipt_click"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfer_detail/cancel_transfer_click"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfer_detail/modal"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/scheduled_transfer_detail/modal/confirm"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfer_detail/modal/dismiss"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfer_detail/modal/close"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Add Bank Account Form
    "/money_out/transfers/new_account_form"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/new_account_form/recipient_account"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/new_account_form/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/new_account_form/recipient_account/continue_button_clicked"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Transfer Amount
    "/money_out/transfers/amount"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/amount/continue_button_clicked"(platform: "/", type: TrackType.Event) {
        amount (required:false, description: "Indicate amount of transaction")
    }
    "/money_out/transfers/amount/money_advance_clicked"(platform: "/", type: TrackType.Event) {
        advance (required:false, description: "Indicate if user click advance money")
    }

    // Transfer Hub - Cap Limit Modal
    "/money_out/transfers/amount/cap_limit_modal"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/amount/cap_limit_modal/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/amount/cap_limit_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Review And Confirm
    "/money_out/transfers/review_and_confirm"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/review_and_confirm/edit_amount_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/edit_account_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/confirm_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/know_more_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/know_more_tooltip_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/edit_reason_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/faq"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/immediate_transfer_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirms/scheduled_transfer_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/edit_date_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/calendar"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/review_and_confirm/calendar/confirm"(platform: "/", type: TrackType.Event) {}
    
    //Transfer Hub - Congrats
    "/money_out/transfers/result"(platform: "/", isAbstract:true) {}
    "/money_out/transfers/result/success_online"(platform: "/", type: TrackType.View) {
        transfer_id (required:false, description: "Indicate transfer_id of operation")
    }
    "/money_out/transfers/result/success_scheduled"(platform: "/", type: TrackType.View) {
        transfer_id (required:false, description:"Indicate transfer_id of operation")
    }
    "/money_out/transfers/result/processing_money_advance"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/result/money_advance_expired"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/result/error"(platform: "/", type: TrackType.View) {
        reason (required:false, description:"Indicate error of operation")
    }
    "/money_out/transfers/result/view_receipt_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/result/go_to_home_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/result/complete_bacen_information_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/result/new_transfer"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/result/share_receipt"(platform: "/", type: TrackType.Event) {}
    
    //Transfer Hub - Receipt
    "/money_out/transfers/receipt"(platform: "/", type: TrackType.View) {
        transfer_id(required:false, description:"Indicate transfer_id of operation")
    }
    "/money_out/transfers/receipt/share_button_clicked"(platform: "/mobile", type: TrackType.Event) {} 
    "/money_out/transfers/receipt/download_button_clicked"(platform: "/web", type: TrackType.Event) {} 
    "/money_out/transfers/receipt/close_button_clicked"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Onboarding
    "/money_out/transfers/onboarding"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/onboarding/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/onboarding/close_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/scheduled_transfers/onboarding"(platform: "/", type: TrackType.View) {}
    "/money_out/scheduled_transfers/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/scheduled_transfers/onboarding/close"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Bacen Closed Modal (RyC)
    "/money_out/transfers/review_and_confirm/scheduled_warning_modal"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/review_and_confirm/scheduled_warning_modal/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/scheduled_warning_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Bacen Closed Modal (Home)
    "/money_out/transfers/home/scheduled_warning_modal"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/home/scheduled_warning_modal/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/scheduled_warning_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}
      
    //Transfer Hub - TED Campaign Modal
    "/money_out/transfers/home/ted_campaign_modal"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/home/ted_campaign_modal/ted_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/ted_campaign_modal/withdraw_legacy_button_clicked"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Withdraw Campaign Modal
    "/money_out/transfers/home/withdraw_bank_campaign_modal"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/home/withdraw_bank_campaign_modal/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/withdraw_bank_campaign_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Coelsa Error
    "/money_out/transfers/home/coelsa_error"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/home/coelsa_error/continue_button_clicked"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Pix
    "/money_out/transfers/pix_dashboard"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/pix_dashboard/type_selected"(platform: "/", type: TrackType.Event){
        type(required_:false, description: "Indicates the type selected ")
    }

    //Bottom Sheet - Unified P2P
    "/money_out/transfers/bottom_sheet"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/bottom_sheet/confirm"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/bottom_sheet/cancel"(platform: "/", type: TrackType.Event) {}

    //Cashout - modals
    "/money_out/cashout/insufficient_amount_modal"(platform:"/", type: TrackType.View){}
    "/money_out/cashout/insufficient_balance_modal"(platform:"/", type: TrackType.View){}

    //New TED scheduling modal from HUB
    "/money_out/transfers/home/new_scheduled_modal"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/home/new_scheduled_modal/continue_transfer_with_pix"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/new_scheduled_modal/continue_transfer_with_ted"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/new_scheduled_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}

    //New TED scheduling modal from recent and favs
    "/money_out/transfers/recents"(platform: "/", isAbstract: true) {}
    "/money_out/transfers/recents/new_scheduled_modal"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/recents/new_scheduled_modal/continue_transfer_with_pix"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/recents/new_scheduled_modal/continue_transfer_with_ted"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/recents/new_scheduled_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Modal Withdraw Pix
    "/money_out/transfers/home/modal_withdraw"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/home/modal_withdraw/continue_button_with_pix"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/modal_withdraw/continue_button_with_legacy"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/modal_withdraw/dismiss"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Modal Avoid Legacy
    "/money_out/transfers/home/modal_avoid_legacy"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/home/modal_avoid_legacy/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/modal_avoid_legacy/more_info"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/modal_avoid_legacy/dismiss"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Modal Xselling
    "/money_out/transfers/home/modal_xselling"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/home/modal_xselling/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/modal_xselling/dismiss"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/recents/modal_xselling"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/recents/modal_xselling/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/recents/modal_xselling/dismiss"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Modal Persuasion Pix
    "/money_out/transfers/home/modal_persuasion_pix"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/home/modal_persuasion_pix/continue_pix"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/modal_persuasion_pix/continue_ted"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/modal_persuasion_pix/dismiss"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/recents/modal_persuasion_pix"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/recents/modal_persuasion_pix/continue_pix"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/recents/modal_persuasion_pix/continue_ted"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/recents/modal_persuasion_pix/dismiss"(platform: "/", type: TrackType.Event) {}


    //Transfer Hub - Modal Restrictions
    "/money_out/transfers/home/restrictions"(platform:"/", type: TrackType.View){
        type(required:true, description:"Indicate type of restriction for example: credits", values=["credits", "chargeback", "p2p", "generic", "manual_review_open_cases"])
    }
    "/money_out/transfers/home/restrictions/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/restrictions/back"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/restrictions/dismiss"(platform: "/", type: TrackType.Event) {}

    "/money_out/transfers/bottom_sheet/restrictions"(platform:"/", type: TrackType.View){
        type(required:true, description:"Indicate type of restriction for example: rate_limit_pix", values=["rate_limit_pix", "rate_limit_p2p", "rate_limit_pix_p2p", "inactive_account", "user_blacklist", "same_sender_collector", "collector"])
    }
    "/money_out/transfers/bottom_sheet/restrictions/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/bottom_sheet/restrictions/back"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/bottom_sheet/restrictions/dismiss"(platform: "/", type: TrackType.Event) {}

    "/money_out/transfers/calculator_p2p/restrictions"(platform:"/", type: TrackType.View){
        type(required:true, description:"Indicate type of restriction for example: same_user", values=["same_user", "blacklist", "account_deactive", "country", "user_without_account", "kyc_collector_restriction", "collector_restriction"])
    }
    "/money_out/transfers/calculator_p2p/restrictions/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/calculator_p2p/restrictions/back"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/calculator_p2p/restrictions/dismiss"(platform: "/", type: TrackType.Event) {}
    
    //Transfer Hub - Modal KYC
    "/money_out/transfers/home/kyc_modal"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/home/kyc_modal/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/kyc_modal/back"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/kyc_modal/dismiss"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - FTU Unified transfers
    "/money_out/transfers/home/unified_transfers_ftu"(platform:"/", type: TrackType.View){}
    "/money_out/transfers/home/unified_transfers_ftu/continue"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - MLM - Account Form
    "/money_out/transfers/mlm/account_form"(platform: "/", type: TrackType.View){}
    "/money_out/transfers/mlm/account_form/faq"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/mlm/account_form/continue"(platform: "/", type: TrackType.Event) {}
    
    //Pix Limits MLB
    "/pix"(platform: "/", isAbstract: true) {}
    "/pix/limits"(platform: "/", isAbstract: true) {}

    //Pix Limits MLB - Dashboard
    "/pix/limits/dashboard"(platform: "/", type: TrackType.View) {}
    "/pix/limits/dashboard/faq"(platform: "/", type: TrackType.Event) {}
    "/pix/limits/dashboard/select_new_limit"(platform: "/", type: TrackType.Event) {}
    "/pix/limits/dashboard/go_back"(platform: "/", type: TrackType.Event) {}

    //Pix Limits MLB - Limit Selection
    "/pix/limits/selection"(platform: "/", type: TrackType.View) {}
    "/pix/limits/selection/faq"(platform: "/", type: TrackType.Event) {}
    "/pix/limits/selection/limit_selected"(platform: "/", type: TrackType.Event) {}
    "/pix/limits/selection/continue"(platform: "/", type: TrackType.Event) {}

    //Pix Limits MLB - Review And Confirm
    "/pix/limits/review_and_confirm"(platform: "/", type: TrackType.View) {}
    "/pix/limits/review_and_confirm/faq"(platform: "/", type: TrackType.Event) {}
    "/pix/limits/review_and_confirm/edit"(platform: "/", type: TrackType.Event) {}
    "/pix/limits/review_and_confirm/continue"(platform: "/", type: TrackType.Event) {}

    //Pix Limits MLB - Congrat
    "/pix/limits/congrat"(platform: "/", type: TrackType.View) {}
    "/pix/limits/congrat/primary_button_click"(platform: "/", type: TrackType.Event) {}
    "/pix/limits/congrat/secondary_button_click"(platform: "/", type: TrackType.Event) {}

    //Money Out Error View - Enchufe
    "/money_out/error_view"(platform: "/", type: TrackType.View) {
        error (required:false, description: "Indicate the error type thats been shown")
        view (required:false, description: "Indicate the view where the error happened")
    }

    //Digital Accounts Components
    "/da_base_activity"(platform: "/", isAbstract: true) {}
    "/da_base_activity/error_view"(platform: "/", type: TrackType.View) {
        error (required:false, description: "Indicate the error type thats been shown")
        view (required:false, description: "Indicate the view where the error happened")
    }

    //Home Pix MLB
    "/pix/home"(platform: "/", type: TrackType.View) {}
    "/pix/home/settings"(platform: "/", type: TrackType.Event) {}
    "/pix/home/faq"(platform: "/", type: TrackType.Event) {}
    "/pix/home/money_in"(platform: "/", type: TrackType.Event) {}
    "/pix/home/money_out"(platform: "/", type: TrackType.Event) {}
    "/pix/home/cash_out"(platform: "/", type: TrackType.Event) {}
    "/pix/home/collect"(platform: "/", type: TrackType.Event) {}
    "/pix/home/pay"(platform: "/", type: TrackType.Event) {}

    //Home Pix MLB - Keys
    "/pix/home/keys"(platform: "/", isAbstract: true) {}
    "/pix/home/keys/copy"(platform: "/", type: TrackType.Event) {}
    "/pix/home/keys/share"(platform: "/", type: TrackType.Event) {}
    "/pix/home/keys/new"(platform: "/", type: TrackType.Event) {}

    //Home Pix MLB - Cadastrar Keys
    "/pix/home/banner"(platform: "/", isAbstract: true) {}
    "/pix/home/banner/new_key"(platform: "/", type: TrackType.Event) {}

    //Home Pix MLB - Help Button
    "/pix/home/additional_list"(platform: "/", isAbstract: true) {}
    "/pix/home/additional_list/faq"(platform: "/", type: TrackType.Event) {}

    //Home Pix MLB - Bottom Sheet
    "/pix/home/bottom_sheet"(platform: "/", type: TrackType.View) {}

    //Home Pix MLB - Help Button Options
    "/pix/home/bottom_sheet/faq"(platform: "/", type: TrackType.Event) {}    
    "/pix/home/bottom_sheet/bacen"(platform: "/", type: TrackType.Event) {}

    //Home Pix MLB - Settings options
    "/pix/home/bottom_sheet/pix_limits"(platform: "/", type: TrackType.Event) {}    
    "/pix/home/bottom_sheet/pix_keys"(platform: "/", type: TrackType.Event) {}

    //Home Pix MLB - Pay options
    "/pix/home/bottom_sheet/qr_scan"(platform: "/", type: TrackType.Event) {}    
    "/pix/home/bottom_sheet/copy_paste"(platform: "/", type: TrackType.Event) {}

    //Home Pix MLB - FTU
    "/pix/home/ftu"(platform: "/", type: TrackType.View) {}
    "/pix/home/ftu/close"(platform: "/", type: TrackType.Event) {}  
    "/pix/home/ftu/confirm"(platform: "/", type: TrackType.Event) {}
    "/pix/home/ftu/cancel"(platform: "/", type: TrackType.Event) {}
}
