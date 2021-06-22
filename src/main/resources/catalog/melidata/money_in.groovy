package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

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

    "/money_in/calculator/tooltip"(platform: "/", type: TrackType.Event) {}
    
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
        text (required:true, description: "Ted account coppied text", values: ["account", "name", "id_number", "bank_name", "agency_number"])
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

    //Ticket Cashin MLB - Congrats
    "/money_in/cash/congrats"(platform: "/", type: TrackType.View) {
        type (required:false, description: "congrats type")
        payment_method (required:true, description: "Payment method selected in congrats")
    }
    "/money_in/cash/copy_code"(platform: "/", type: TrackType.Event) {
        payment_method (required:true, description: "Payment method selected on copy code")
    }
    "/money_in/cash/view_ticket"(platform: "/", type: TrackType.Event) {
        payment_method (required:true, description: "Payment method selected on view ticket")
    }
    "/money_in/cash/go_home"(platform: "/", type: TrackType.Event) {
        payment_method (required:true, description: "Payment method selected on go to tome")
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
    
    // Ticket Cashin MLB - review and confirm
    "/money_in/cash/review_and_confirm"(platform: "/", type: TrackType.View) {
        payment_method (required:true, description: "Payment method selected on ryc")
    }
    "/money_in/cash/review_and_confirm/create"(platform: "/", type: TrackType.Event) {
        payment_method (required:true, description: "Payment method selected on ryc creation")
    }
    "/money_in/cash/review_and_confirm/edit_amount"(platform: "/", type: TrackType.Event) {
        payment_method (required:true, description: "Payment method selected on ryc edition")
    }
    
    //PIX keys - Congrats
    "/money_in/pix_keys"(platform:"/", isAbstract:true){}
    "/money_in/pix_keys/enroll_congrats"(platform: "/", type: TrackType.View) {}
    //PIX keys - Admin
    "/money_in/pix_keys/onboarding"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/onboarding/continue"(platform: "/", type: TrackType.Event) {
        is_evp_checked (required:false, description: "Indicate if the user checked the evp option")
    }
    "/money_in/pix_keys/create"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {
        key_type (required:false, description: "key type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
        key_value_from_profile (required:false, description: "Indicate if the key is loaded from vault")
    }
    "/money_in/pix_keys/admin"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/admin/resolve_request"(platform: "/", type: TrackType.Event) {
        claim_type (required:false, description: "Request type", values: ["ownership", "portability"])
    }
    "/money_in/pix_keys/admin/detail_key"(platform: "/", type: TrackType.Event) {
        key_type (required:false, description: "key_type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
    }
    "/money_in/pix_keys/admin/add_key"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/key_detail"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/key_detail/remove_key"(platform: "/", type: TrackType.Event) {
        key_type (required:false, description: "key type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
    }
    "/money_in/pix_keys/admin/carousel"(platform:"/", isAbstract: true){}
    "/money_in/pix_keys/admin/carousel/add_key"(platform: "/", type: TrackType.Event) {
        key_type (required:false, description: "key type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
    }
    "/money_in/pix_keys/admin/carousel/swipe"(platform: "/", type: TrackType.Event) {
        swipe_direction (required:false, description: "carousel swipe direction", values: ["left", "right"])
    }
    "/money_in/pix_keys/key_detail/share_key"(platform: "/", type: TrackType.Event) {
        key_type (required:false, description: "key type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
    }
    "/money_in/pix_keys/key_claim_detail"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {
        key_type (required:false, description: "key type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
        claim_type (required:false, description: "Request type", values: ["ownership", "portability"])
    }
    "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {
        key_type (required:false, description: "key type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
        claim_type (required:false, description: "Request type", values: ["ownership", "portability"])
    }
    "/money_in/pix_keys/key_claim_detail/delete"(platform: "/", type: TrackType.View) {}
    "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.View) {
        type (required:false, description: "congrats type", values: ["green", "red", "yellow"])
        key_type (required:false, description: "key type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
        request_type (required:false, description: "Request type", values: ["registration", "delete", "ownership", "portability"])
    }
    "/money_in/pix_keys/congrats/continue"(platform: "/", type: TrackType.Event) {}
    "/money_in/pix_keys/notification"(platform: "/", type: TrackType.Event) {
        action_type (required:false, description: "Action type", values: ["update", "create", "delete"])
        claim_role (required:false, description: "claim role", values: ["claimer", "donor"])
        claim_type (required:false, description: "Request type", values: ["ownership", "portability"])
        claim_status (required:false, description: "Claim status", values: ["Completed", "Canceled", "waiting_resolution"])
    }
    "/money_in/pix_keys/delete_confirm/continue"(platform: "/", type: TrackType.Event) {
        key_type (required:false, description: "key type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
    }
    "/money_in/pix_keys/delete_confirm"(platform: "/", type: TrackType.View) {
        key_type (required:false, description: "key type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
    }
    "/money_in/pix_keys/delete_confirm/cancel"(platform: "/", type: TrackType.Event) {
        key_type (required:false, description: "key type", values: ["cpf", "cnpj", "telephone", "email", "evp"])
    }
    "/money_in/pix_keys/cpf_confirm"(platform: "/", type: TrackType.View) {
        key_value_from_profile (required:false, description: "Indicate if the key is loaded from vault")
    }


    "/money_in/pix"(platform:"/", isAbstract: true){}
    "/money_in/pix/key"(platform: "/", isAbstract: true){}

    //PIX onboarding
    "/money_in/pix/onboarding"(platform:"/", type: TrackType.View){}
    "/money_in/pix/onboarding/continue"(platform: "/", type: TrackType.Event){}
    "/money_in/pix/redirect_ted"(platform: "/", type: TrackType.Event){}
    "/money_in/pix/redirect_admin_key"(platform: "/", type: TrackType.Event){}

    //PIX mykeys
    "/money_in/pix/my_keys"(platform:"/", type: TrackType.View){}
    "/money_in/pix/my_keys/swipe"(platform: "/", type: TrackType.Event){}
    "/money_in/pix/my_keys/add_keys"(platform: "/", type: TrackType.Event){}
    "/money_in/pix/my_keys/generate_qr"(platform: "/", type: TrackType.Event){
        key_type(required:false, description: "key type", values: ["cpf", "cnpf", "telephone", "email", "evp"])
    }
    "/money_in/pix/my_keys/copy"(platform: "/", type: TrackType.Event){
        key_type(required:false, description: "key type", values: ["cpf", "cnpf", "telephone", "email", "evp"])
    }
    "/money_in/pix/my_keys/share"(platform: "/", type: TrackType.Event){
        key_type(required:false, description: "key type", values: ["cpf", "cnpf", "telephone", "email", "evp"])
    }

    //PIX QR
    "/money_in/pix/qr"(platform:"/", type: TrackType.View){}
    "/money_in/pix/qr/share"(platform: "/", type: TrackType.Event){}
    "/money_in/pix/qr/setup"(platform: "/", type: TrackType.Event){}

    //PIX Setup QR
    "/money_in/pix/key/setup_qr"(platform:"/", type: TrackType.View){}
    "/money_in/pix/key/setup_qr/continue"(platform: "/", type: TrackType.Event){}

    //Debin
    "/money_in/debin"(platform:"/", isAbstract: true){}
    "/money_in/debin/search"(platform:"/", isAbstract: true){}
    "/money_in/debin/search/generic_error"(platform:"/", isAbstract: true){}
    "/money_in/debin/search/ownership_error"(platform:"/", isAbstract: true){}
    "/money_in/debin/search/success"(platform:"/", isAbstract: true){}
    "/money_in/debin/search/dismiss"(platform:"/", isAbstract: true){}

    //Debin Hub
    "/money_in/debin/hub"(platform:"/", type: TrackType.View){}
    "/money_in/debin/hub/select"(platform:"/",type: TrackType.Event){
        account_id(required:false, description: "indicate the source of the debin")
    }
    "/money_in/debin/hub/new_account"(platform:"/",type: TrackType.Event){}
    "/money_in/debin/hub/help"(platform:"/",type: TrackType.Event){}

    //Debin Onboarding
    "/money_in/debin/onboarding"(platform:"/", type: TrackType.View){}
    "/money_in/debin/onboarding/debin"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/onboarding/know_more"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/onboarding/exit"(platform:"/", type: TrackType.Event){}

    //Debin Calculator
    "/money_in/debin/calculator"(platform:"/", type: TrackType.View){}
    "/money_in/debin/calculator/continue"(platform:"/", type: TrackType.Event){
        amount(required:false, description: "indicate the amount of the debin")
    }
    "/money_in/debin/calculator/preset"(platform:"/", type: TrackType.Event){
        amount(required:false, description: "indicate the amount of the preset")
    }
    "/money_in/debin/calculator/message"(platform:"/", type: TrackType.Event){
        message(required:false, description: "indicate the error message")
    }

    //Debin RyC
    "/money_in/debin/ryc"(platform:"/", type: TrackType.View){}
    "/money_in/debin/ryc/edit_amount"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/ryc/edit_account"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/ryc/reason"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/ryc/create_debin"(platform:"/", type: TrackType.Event){}

    //Debin Processing
    "/money_in/debin/processing"(platform:"/", type: TrackType.View){}

    //Debin Congrats
    "/money_in/debin/congrats"(platform:"/", type: TrackType.View){
        status(required:true, description:"status",values:["success", "pending", "error"])
        error_type(required:false, description:"indicates the error of the debin")
    }
    "/money_in/debin/congrats/go_home"(platform:"/", type: TrackType.Event){
         status(required:false, description:"status",values:["success", "pending", "error"])
    }
    "/money_in/debin/congrats/retry"(platform:"/", type: TrackType.Event){
         status(required:false, description:"status",values:["error"])
    }
    "/money_in/debin/congrats/feedback"(platform:"/", type: TrackType.Event){}

    //Debin Merch Engine
    "/money_in/debin/congrats/merch_engine"(platform:"/", type: TrackType.View){
        status(required:true,type: PropertyType.String, description:"merch engine status", values:["success","error"])
        audience(required:false,type: PropertyType.String, description:"indicates the audience")
        bu(required:false,type: PropertyType.String, description:"Indicates the buisiness unit")
        bu_line(required:false,type: PropertyType.String, description:"buisiness unit line")
        component_id(required:false,type: PropertyType.String, description:"Id of the merch engine real state")
        content_id(required:false,type: PropertyType.String, description:"id of the content")
        flow(required:false,type: PropertyType.String, description:"flow of the merch engine")
        logic(required:false,type: PropertyType.String, description:"logic of the merch engine")
        position(required:false,type: PropertyType.String, description:"Position of the item")
        xp_id(required:false,type: PropertyType.String, description:"id of the experiments")
    }

    //Debin Search account
    "/money_in/debin/search"(platform:"/", type: TrackType.View){}
    "/money_in/debin/search/help"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/search/continue"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/search/result"(platform:"/", type: TrackType.Event){
        result_status(required:true, description:"indicates the result of the search")
    }
    "/money_in/debin/search/success/continue"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/search/generic_error/retry"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/search/generic_error/go_home"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/search/ownership_error/go_home"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/search/ownership_error/edit_account"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/search/dismiss/bottom_sheet"(platform:"/", type: TrackType.Event){
        bs_type(required:false, description:"indicates the tye of the bottom-sheet")
    }

    "/money_in/td_calculator"(platform:"/", isAbstract: true){}
    "/money_in/debin/calculator"(platform:"/", isAbstract: true){}

    //Cap TD Calculator (debit to debin)
    "/money_in/td_calculator/debin_modal"(platform:"/", isAbstract: true){}
    "/money_in/td_calculator/debin_modal"(platform:"/", type: TrackType.View){}
    "/money_in/td_calculator/debin_modal/go_to_debin"(platform:"/", type: TrackType.Event){}
    "/money_in/td_calculator/debin_modal/edit_amount"(platform:"/", type: TrackType.Event){}

    //Cap TD WEB (debit to debin)
    "/account_fund/cvu"(platform:"/", type: TrackType.View){}
    "/account_fund/amount/warning/go_to_cvu"(platform:"/", type: TrackType.Event){}
    "/account_fund/amount/warning/edit_amount"(platform:"/", type: TrackType.Event){}
    "/account_fund/cvu/donwload_app"(platform:"/", type: TrackType.Event){}

    //Cap TD Calculator (debit to cvu)
    "/money_in/td_calculator/cvu_modal"(platform:"/", isAbstract: true){}
    "/money_in/td_calculator/cvu_modal"(platform:"/", type: TrackType.View){}
    "/money_in/td_calculator/cvu_modal/go_to_cvu"(platform:"/", type: TrackType.Event){}
    "/money_in/td_calculator/cvu_modal/edit_amount"(platform:"/", type: TrackType.Event){}

    //Cap TD Calculator (debin to cvu)
    "/money_in/debin/calculator/cvu_modal"(platform:"/", isAbstract: true){}
    "/money_in/debin/calculator/cvu_modal"(platform:"/", type: TrackType.View){}
    "/money_in/debin/calculator/cvu_modal/go_to_cvu"(platform:"/", type: TrackType.Event){}
    "/money_in/debin/calculator/cvu_modal/edit_amount"(platform:"/", type: TrackType.Event){}

    //Money In Error View - Enchufe
    "/money_in/error_view"(platform: "/", type: TrackType.View) {
        error (required:false, description: "Indicate the error type thats been shown")
        view (required:false, description: "Indicate the view where the error happened")
    }
}
