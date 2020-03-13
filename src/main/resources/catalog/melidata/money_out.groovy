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

    // Cashout ticket tracks
    "/money_out/cashout/ticket"(platform: "/", type: TrackType.View) {}

    "/money_out/cashout/cancel_ticket"(platform: "/", type: TrackType.Event) {}

    // Cashout calculator tracks

    "/money_out/calculator"(platform: "/", type: TrackType.View) {
        money_out_method (required:true, description: "Money out method on calculator", values: ["cashout"])
    }

    "/money_out/calculator/preset_selected"(platform: "/", type: TrackType.Event) {
        money_out_method (required:true, description: "Money out method on calculator", values: ["cashout"])
        preset (required:true, description: "Preset amount selected", values: ["500", "1000", "3000", "5000"])
    }

    "/money_out/calculator/continue"(platform: "/", type: TrackType.Event) {
        money_out_method (required:true, description: "Continue Money out method selected", values: ["cashout"])
        amount (required:true, description: "Continue amount entered")
    }

    // Cashout onboarding

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

    //Transfer Hub 
    "/money_out/transfers"(platform: "/", isAbstract: true) {}

    //Transfer Hub - Dashboard
    "/money_out/transfers/home"(platform: "/", type: TrackType.View) {}
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
    "/money_out/transfers/home/scheduled_transfers_selected"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Scheduled Transfers
    "/money_out/transfers/scheduled_transfers_list"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/scheduled_transfers_list/transfer_selected"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Scheduled Transfers Detail
    "/money_out/transfers/scheduled_transfer_detail"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/scheduled_transfer_detail/cancel"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfer_detail/cancel_dismissed"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/scheduled_transfer_detail/cancel_confirmed"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Add Bank Account Form
    "/money_out/transfers/new_account_form"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/new_account_form/continue_button_clicked"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Transfer Amount
    "/money_out/transfers/amount"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/amount/continue_button_clicked"(platform: "/", type: TrackType.Event) {
        amount (required:false, description: "Indicate amount of transaction")
    }
    "/money_out/transfers/amount/money_advance_clicked"(platform: "/", type: TrackType.Event) {
        advance (required:false, description: "Indicate if user click advance money")
    }

    //Transfer Hub - Review And Confirm
    "/money_out/transfers/review_and_confirm"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/review_and_confirm/edit_amount_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/edit_account_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/confirm_button_clicked"(platform: "/", type: TrackType.Event) {}
    
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

    //Transfer Hub - Bacen Closed Modal (RyC)
    "/money_out/transfers/review_and_confirm/scheduled_warning_modal"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/review_and_confirm/scheduled_warning_modal/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/review_and_confirm/scheduled_warning_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}

    //Transfer Hub - Bacen Closed Modal (Home)
    "/money_out/transfers/home/scheduled_warning_modal"(platform: "/", type: TrackType.View) {}
    "/money_out/transfers/home/scheduled_warning_modal/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_out/transfers/home/scheduled_warning_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}
      
    
}
