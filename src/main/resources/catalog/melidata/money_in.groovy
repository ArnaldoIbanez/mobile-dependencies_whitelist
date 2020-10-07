package catalog.melidata

import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1149'

    /**
        Money In V2 Tracks
    **/

    "/money_in"(platform: "/", isAbstract: true) {}
    "/money_in/kyc"(platform: "/", isAbstract: true) {}

    //Payment methods tracks
    "/money_in/payment_methods"(platform: "/", type: TrackType.View) {}

    "/money_in/payment_methods/select"(platform: "/", type: TrackType.Event) {
        payment_method (required:true, description: "Selected payment method")
    }

    //Payment method help pressed
    "/money_in/payment_methods/help"(platform: "/", type: TrackType.Event) {}

    //Calculator tracks
    "/money_in/calculator"(platform: "/", type: TrackType.View) {
        payment_method (required:true, description: "Payment method selected on calculator")
    }

    //Calculator montos preseteados
    "/money_in/calculator/preset_selected"(platform: "/", type: TrackType.Event) {
        preset (required:true, description: "Preset amount selected")
    }

    "/money_in/calculator/continue"(platform: "/", type: TrackType.Event) {
        payment_method (required:true, description: "Continue payment method selected")
        amount (required:true, description: "Continue amount entered")
    }

    //Checkout PX
    "/money_in/px"(platform: "/", isAbstract: true) {}

    "/money_in/px/error"(platform: "/", type: TrackType.View) {}

    "/money_in/px/success"(platform: "/", type: TrackType.View) {}

    "/money_in/onboarding"(platform: "/", isAbstract: true) {}

    //Onboarding
     "/money_in/kyc/onboarding"(platform: "/", type: TrackType.View) {}
     "/money_in/kyc/onboarding/continue"(platform: "/", type: TrackType.Event) {}
     "/money_in/kyc/onboarding/close"(platform: "/", type: TrackType.Event) {}
     "/money_in/onboarding/add_money"(platform: "/", type: TrackType.View) {}
     "/money_in/onboarding/simplify_payments"(platform: "/", type: TrackType.View) {}
     "/money_in/onboarding/invest_money"(platform: "/", type: TrackType.View) {}
     "/money_in/onboarding/use_mp_card"(platform: "/", type: TrackType.View) {}

    "/money_in/onboarding/enter"(platform: "/", type: TrackType.Event) {}
    "/money_in/onboarding/close"(platform: "/", type: TrackType.Event) {}

    //TED

    //FTU IV
    "/money_in/ted/ftu_iv"(platform: "/", type: TrackType.View) {}

    "/money_in/ted/ftu_iv/start"(platform: "/", type: TrackType.Event) {}
    "/money_in/ted/ftu_iv/exit"(platform: "/", type: TrackType.Event) {}

    "/money_in/ted"(platform: "/", isAbstract: true) {}

    //FTU NORMAL
    "/money_in/ted/ftu"(platform: "/", type: TrackType.View) {}

    "/money_in/ted/ftu/start"(platform: "/", type: TrackType.Event) {}
    "/money_in/ted/ftu/exit"(platform: "/", type: TrackType.Event) {}

    //Error en la creacíon de la cuenta
    "/money_in/ted/error"(platform: "/", type: TrackType.View) {
        reason (required:true, description: "Account creation error reason", values: ["under_age", "generic_error"])
    }

    //Pantalla de datos de TED
    "/money_in/ted/account"(platform: "/", type: TrackType.View) {}

    "/money_in/ted/account/copy"(platform: "/", type: TrackType.Event) {
        text (required:true, description: "Ted account coppied text", values: ["account", "name", "id_number"])
    }

    "/money_in/ted/account/share"(platform: "/", type: TrackType.Event) {}

    "/money_in/ted/account/need_help"(platform: "/", type: TrackType.Event) {}

    // CLABE
    "/money_in/clabe"(platform:"/", isAbstract:true){}

    // CLABE - Onboarding
    "/money_in/clabe/onboarding"(platform: "/", type: TrackType.View) {}
    "/money_in/clabe/onboarding/continue"(platform: "/", type: TrackType.Event) {}

    // CLABE - KYC
    "/money_in/clabe/need_validation"(platform: "/", type: TrackType.View) {}
    "/money_in/clabe/need_validation/continue"(platform: "/", type: TrackType.Event) {}

    // CLABE - Pending
    "/money_in/clabe/pending"(platform: "/", type: TrackType.View) {}
    "/money_in/clabe/pending/continue"(platform: "/", type: TrackType.Event) {}

    // CLABE - Datos
    "/money_in/clabe/copy"(platform: "/", type: TrackType.Event) {}
    "/money_in/clabe/share"(platform: "/", type: TrackType.Event) {}
    "/money_in/clabe/help"(platform: "/", type: TrackType.Event) {}

    // CLABE - Congrats Error
    "/money_in/clabe/error"(platform: "/", type: TrackType.View) {}
    "/money_in/clabe/error/continue"(platform: "/", type: TrackType.Event) {}

    // Money In CAIXA (Covid)
    "/money_in/caixa"(platform:"/", isAbstract:true){}

    // Caixa - Onboarding
    "/money_in/caixa/onboarding"(platform: "/", type: TrackType.View) {}
    "/money_in/caixa/onboarding/continue_button_clicked"(platform: "/", type: TrackType.Event) {}

    // Caixa - Amount
    "/money_in/caixa/amount"(platform: "/", type: TrackType.View) {}
    "/money_in/caixa/amount/continue_button_clicked"(platform: "/", type: TrackType.Event) {
        amount (required:true, description: "Continue amount entered")
    }

    // Caixa - Congrats
    "/money_in/caixa/success"(platform: "/", type: TrackType.View) {}
    "/money_in/caixa/success/go_home_button_clicked"(platform: "/", type: TrackType.Event) {}

    // Caixa - Disclaimer 
    "/money_in/caixa/disclaimer"(platform: "/", type: TrackType.View) {}
    "/money_in/caixa/disclaimer/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_in/caixa/disclaimer/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}

    // Cash Tickets - Locations 
    "/money_in/cash"(platform:"/", isAbstract:true){}
    "/money_in/cash/location_list"(platform: "/", type: TrackType.View) {}
    "/money_in/cash/location/location_selected"(platform: "/", type: TrackType.Event) {
        id (required:true, description: "Selected location")
    }

    // Cash Tickets - Amount 
    "/money_in/cash/amount"(platform: "/", type: TrackType.View) {
        type (required:true, description: "Ticket type source", values: ["paycash", "oxxo"])
    }
    "/money_in/cash/amount/continue_button_clicked"(platform: "/", type: TrackType.Event) {
        type (required:true, description: "Continue type ticket selected", values: ["paycash", "oxxo"])
        amount (required:true, description: "Continue amount entered")
    }

    // Cash Tickets - Info 
    "/money_in/cash/ticket"(platform: "/", type: TrackType.View) {
        type (required:true, description: "Ticket type source", values: ["paycash", "oxxo"])
    }
    "/money_in/cash/ticket/cancel_button_clicked"(platform: "/", type: TrackType.Event) {
        type (required:true, description: "Cancel ticket selected", values: ["paycash", "oxxo"])
    }

    // Cash Tickets - Camcel Modal 
    "/money_in/cash/cancel_ticket_modal"(platform: "/", type: TrackType.View) {
        type (required:true, description: "Ticket type source", values: ["paycash", "oxxo"])
    }
    "/money_in/cash/cancel_ticket_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {
        type (required:true, description: "Cancel ticket selected", values: ["paycash", "oxxo"])
    }
    "/money_in/cash/cancel_ticket_modal/back_ticket_button_clicked"(platform: "/", type: TrackType.Event) {
        type (required:true, description: "Back ticket selected", values: ["paycash", "oxxo"])
    }

    // Oxxo Tickets - Disuassive Modal 
    "/money_in/cash/location"(platform:"/", isAbstract:true){}
    "/money_in/cash/location/warning_ticket_modal"(platform: "/", type: TrackType.View) {}
    "/money_in/cash/location/warning_ticket_modal/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
    "/money_in/cash/location/warning_ticket_modal/back_button_clicked"(platform: "/", type: TrackType.Event) {}

    // Cash IFPE CAP Modal
    "/money_in/cash/ifpe_cap_exceeded"(platform: "/", type: TrackType.View) {}
    "/money_in/cash/ifpe_cap_exceeded/insert_other_amount"(platform: "/", type: TrackType.Event) {}
    "/money_in/cash/ifpe_cap_exceeded/help"(platform: "/", type: TrackType.Event) {}

    //PIX keys - Congrats
    "/money_in/pix_keys"(platform:"/", isAbstract:true){}
    "/money_in/pix_keys/enroll_congrats"(platform: "/", type: TrackType.View) {}
    //PIX keys - Admin
    "/money_in/pix_keys/onboarding"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/create"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/admin"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/admin/resolve_request"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/admin/detail_key"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/admin/add_key"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/key_detail"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/key_detail/remove_key"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/key_claim_detail"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/congrats/continue"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/notification"(platform: "/", type: TrackType.Event) {}
}
