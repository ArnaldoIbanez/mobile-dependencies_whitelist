package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

     /**
        Money In V2 Tracks
    **/

    test("Money In V2 - views") {

        // Payment methods
        "/money_in/payment_methods"(platform: "/", type: TrackType.View) {}

         "/money_in/payment_methods/select"(platform: "/", type: TrackType.Event) {
             payment_method = "ted"
         }

        "/money_in/payment_methods/help"(platform: "/", type: TrackType.Event) {}

        //Calculator
        "/money_in/calculator"(platform: "/", type: TrackType.View) {
            payment_method = "pec"
        }

        "/money_in/calculator"(platform: "/", type: TrackType.View) {
            payment_method = "bolbradesco"
        }

        //Calculator montos preseteados
        "/money_in/calculator/preset_selected"(platform: "/", type: TrackType.Event) {
            payment_method = "pec"
            preset = "30"
        }

        "/money_in/calculator/preset_selected"(platform: "/", type: TrackType.Event) {
            payment_method = "bolbradesco"
            preset = "500"
        }


        "/money_in/calculator/continue"(platform: "/", type: TrackType.Event) {
            payment_method = "pec"
            amount = "30.0"
        }

        //Checkout PX
        "/money_in/px/error"(platform: "/", type: TrackType.View) {}
        "/money_in/px/success"(platform: "/", type: TrackType.View) {}

        //Onboarding
        "/money_in/onboarding/add_money"(platform: "/", type: TrackType.View) {}
        "/money_in/onboarding/simplify_payments"(platform: "/", type: TrackType.View) {}
        "/money_in/onboarding/invest_money"(platform: "/", type: TrackType.View) {}
        "/money_in/onboarding/use_mp_card"(platform: "/", type: TrackType.View) {}

        "/money_in/onboarding/enter"(platform: "/", type: TrackType.Event) {}
        "/money_in/onboarding/close"(platform: "/", type: TrackType.Event) {}
        "/money_in/kyc/onboarding"(platform: "/", type: TrackType.View) {}
        "/money_in/kyc/onboarding/continue"(platform: "/", type: TrackType.Event) {}
        "/money_in/kyc/onboarding/close"(platform: "/", type: TrackType.Event) {}

        //TED

        //FTU IV
        "/money_in/ted/ftu_iv"(platform: "/", type: TrackType.View) {}

        "/money_in/ted/ftu_iv/start"(platform: "/", type: TrackType.Event) {}
        "/money_in/ted/ftu_iv/exit"(platform: "/", type: TrackType.Event) {}

        //FTU NORMAL
        "/money_in/ted/ftu"(platform: "/", type: TrackType.View) {}

        "/money_in/ted/ftu/start"(platform: "/", type: TrackType.Event) {}
        "/money_in/ted/ftu/exit"(platform: "/", type: TrackType.Event) {}

        //Error en la creacíon de la cuenta
        "/money_in/ted/error"(platform: "/", type: TrackType.View) {
            reason = "under_age"
        }

        "/money_in/ted/error"(platform: "/", type: TrackType.View) {
            reason = "generic_error"
        }

        //Pantalla de datos de TED
        "/money_in/ted/account"(platform: "/", type: TrackType.View) {}

        "/money_in/ted/account/copy"(platform: "/", type: TrackType.Event) {
            text = "account"
        }

        "/money_in/ted/account/copy"(platform: "/", type: TrackType.Event) {
            text = "name"
        }

        "/money_in/ted/account/copy"(platform: "/", type: TrackType.Event) {
            text = "id_number"
        }

        "/money_in/ted/account/share"(platform: "/", type: TrackType.Event) {}

        "/money_in/ted/account/need_help"(platform: "/", type: TrackType.Event) {}

        // CLABE
        "/money_in/clabe"(platform:"/", type: TrackType.View){}

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

        // Caixa - Onboarding
        "/money_in/caixa/onboarding"(platform: "/", type: TrackType.View) {}
        "/money_in/caixa/onboarding/continue_button_clicked"(platform: "/", type: TrackType.Event) {}

        // Caixa - Amount
        "/money_in/caixa/amount"(platform: "/", type: TrackType.View) {}
        "/money_in/caixa/amount/continue_button_clicked"(platform: "/", type: TrackType.Event) {
            amount = "30.0"
        }

        // Caixa - Congrats
        "/money_in/caixa/success"(platform: "/", type: TrackType.View) {}
        "/money_in/caixa/success/go_home_button_clicked"(platform: "/", type: TrackType.Event) {}

        // Caixa - Disclaimer 
        "/money_in/caixa/disclaimer"(platform: "/", type: TrackType.View) {}
        "/money_in/caixa/disclaimer/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
        "/money_in/caixa/disclaimer/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}

         // Cash Tickets - Locations 
        "/money_in/cash/location_list"(platform: "/", type: TrackType.View) {}
        "/money_in/cash/location/location_selected"(platform: "/", type: TrackType.Event) {
            id = "paycash_7-eleven"
        }

        // Cash Tickets - Amount 
        "/money_in/cash/amount"(platform: "/", type: TrackType.View) {
            type = "oxxo"
        }
        "/money_in/cash/amount/continue_button_clicked"(platform: "/", type: TrackType.Event) {
            type = "oxxo"
            amount = "23"
        }

        // Cash Tickets - Info 
        "/money_in/cash/ticket"(platform: "/", type: TrackType.View) {
            type = "paycash"
        }
        "/money_in/cash/ticket/cancel_button_clicked"(platform: "/", type: TrackType.Event) {
            type = "paycash"
        }

        // Cash Tickets - Camcel Modal 
        "/money_in/cash/cancel_ticket_modal"(platform: "/", type: TrackType.View) {
            type = "paycash"
        }
        "/money_in/cash/cancel_ticket_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {
            type = "paycash"
        }
        "/money_in/cash/cancel_ticket_modal/back_ticket_button_clicked"(platform: "/", type: TrackType.Event) {
            type = "paycash"
        }

        // Oxxo Tickets - Disuassive Modal 
        "/money_in/cash/location/warning_ticket_modal"(platform: "/", type: TrackType.View) {}
        "/money_in/cash/location/warning_ticket_modal/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
        "/money_in/cash/location/warning_ticket_modal/back_button_clicked"(platform: "/", type: TrackType.Event) {}

        // Cash IFPE CAP Modal
        "/money_in/cash/ifpe_cap_exceeded"(platform: "/", type: TrackType.View) {}
        "/money_in/cash/ifpe_cap_exceeded/insert_other_amount"(platform: "/", type: TrackType.Event) {}
        "/money_in/cash/ifpe_cap_exceeded/help"(platform: "/", type: TrackType.Event) {}

        //PIX keys - Congrats
        "/money_in/pix_keys/enroll_congrats"(platform: "/", type: TrackType.View) {}
        //PIX keys - Admin
        "/money_in/pix_keys/onboarding"(platform: "/", type: TrackType.View) {}
        "/money_in/pix_keys/onboarding"(platform: "/", type: TrackType.View) {
            is_evp_checked : "true"
        }
        "/money_in/pix_keys/onboarding"(platform: "/", type: TrackType.View) {
            is_evp_checked : "false"
        }
        "/money_in/pix_keys/onboarding/continue"(platform: "/", type: TrackType.Event) {}
        "/money_in/pix_keys/create"(platform: "/", type: TrackType.View) {}
        "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {}
        "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {
            key_type = "cpf"
        }
        "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {
            key_type = "cnpj"
        }
        "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {
            key_type = "telephone"
        }
         "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {
            key_type = "email"
        }
        "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {
            key_type = "evp"
        }
        "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {
            key_type = "evp"
        }
        "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {
            key_value_from_profile = "true"
        }
        "/money_in/pix_keys/create/type_selected"(platform: "/", type: TrackType.Event) {
            key_type = "cpf"
            key_value_from_profile = "false"
        }
        "/money_in/pix_keys/admin"(platform: "/", type: TrackType.View) {}
        "/money_in/pix_keys/admin/resolve_request"(platform: "/", type: TrackType.Event) {}
        "/money_in/pix_keys/admin/resolve_request"(platform: "/", type: TrackType.Event) {
            claim_type = "ownership"
        }
        "/money_in/pix_keys/admin/resolve_request"(platform: "/", type: TrackType.Event) {
            claim_type = "portability"
        }
        "/money_in/pix_keys/admin/detail_key"(platform: "/", type: TrackType.Event) {}
        "/money_in/pix_keys/admin/detail_key"(platform: "/", type: TrackType.Event) {
            key_type = "cnpj"
        }
        "/money_in/pix_keys/admin/detail_key"(platform: "/", type: TrackType.Event) {
            key_type = "cpf"
        }
        "/money_in/pix_keys/admin/detail_key"(platform: "/", type: TrackType.Event) {
            key_type = "telephone"
        }
        "/money_in/pix_keys/admin/detail_key"(platform: "/", type: TrackType.Event) {
            key_type = "email"
        }
        "/money_in/pix_keys/admin/detail_key"(platform: "/", type: TrackType.Event) {
            key_type = "evp"
        }
        "/money_in/pix_keys/admin/add_key"(platform: "/", type: TrackType.Event) {}
        "/money_in/pix_keys/key_detail"(platform: "/", type: TrackType.View) {}
        "/money_in/pix_keys/key_detail/remove_key"(platform: "/", type: TrackType.Event) {}
        "/money_in/pix_keys/key_detail/remove_key"(platform: "/", type: TrackType.Event) {
            key_type = "cnpj"
        }
        "/money_in/pix_keys/key_detail/remove_key"(platform: "/", type: TrackType.Event) {
            key_type = "cpf"
        }
        "/money_in/pix_keys/key_detail/remove_key"(platform: "/", type: TrackType.Event) {
            key_type = "telephone"
        }
        "/money_in/pix_keys/key_detail/remove_key"(platform: "/", type: TrackType.Event) {
            key_type = "email"
        }
        "/money_in/pix_keys/key_detail/remove_key"(platform: "/", type: TrackType.Event) {
            key_type = "evp"
        }
        "/money_in/pix_keys/key_claim_detail"(platform: "/", type: TrackType.View) {}
        "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {}
        "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {
            key_type = "cnpj"
        }
        "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {
            key_type = "cpf"
        }
        "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {
            key_type = "telephone"
        }
        "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {
            key_type = "email"
        }
        "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {
            key_type = "evp"
        }
         "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {
            claim_type = "ownership"
        }
        "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {
            claim_type = "portability"
        }
        "/money_in/pix_keys/key_claim_detail/approve"(platform: "/", type: TrackType.Event) {
             key_type = "evp"
            claim_type = "portability"
        }
        "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {}
        "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {
            key_type = "cnpj"
        }
        "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {
            key_type = "cpf"
        }
        "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {
            key_type = "telephone"
        }
        "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {
            key_type = "email"
        }
        "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {
            key_type = "evp"
        }
         "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {
            claim_type = "ownership"
        }
        "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {
            claim_type = "portability"
        }
        "/money_in/pix_keys/key_claim_detail/reject"(platform: "/", type: TrackType.Event) {
             key_type = "evp"
            claim_type = "portability"
        }
        "/money_in/pix_keys/key_claim_detail/delete"(platform: "/", type: TrackType.View) {}
        "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.View) {}
        "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.Event) {
            key_type = "cnpj"
        }
        "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.Event) {
            key_type = "cpf"
        }
        "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.Event) {
            key_type = "telephone"
        }
        "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.Event) {
            key_type = "email"
        }
        "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.Event) {
            key_type = "evp"
        }
         "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.Event) {
            request_type = "registration"
        }
        "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.Event) {
            request_type = "delete"
        }
        "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.Event) {
            request_type = "ownership"
        }
        "/money_in/pix_keys/congrats"(platform: "/", type: TrackType.Event) {
            request_type = "portability"
        }
        "/money_in/pix_keys/congrats/continue"(platform: "/", type: TrackType.Event) {}
        "/money_in/pix_keys/notification"(platform: "/", type: TrackType.Event) {}
        "/money_in/pix_keys/notification"(platform: "/", type: TrackType.Event) {
            action_type = "update"
            claim_role = "claimer"
            claim_type = "ownership"
            claim_status = "Completed"
        }
        "/money_in/pix_keys/notification"(platform: "/", type: TrackType.Event) {
            action_type = "create"
            claim_role = "donor"
            claim_type = "portability"
            claim_status = "Canceled"
        }
        "/money_in/pix_keys/notification"(platform: "/", type: TrackType.Event) {
            action_type = "delete"
            claim_status = "waiting_resolution"
        }
    }
}
