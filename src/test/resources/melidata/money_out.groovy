package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

      defaultBusiness = "mercadopago"

      /**
         Money Out Tracks
      **/

      test("Money Out - views") { 

      "/money_out"(platform: "/", type: TrackType.View) {}
      "/money_out/cashout"(platform: "/", type: TrackType.View) {}
      "/money_out/cashout/onboarding"(platform: "/", type: TrackType.View) {}

      // Cashout ticket tracks
      "/money_out/cashout/ticket"(platform: "/", type: TrackType.View) {}

      "/money_out/cashout/cancel_ticket"(platform: "/", type: TrackType.Event) {}

      // Cashout calculator tracks

      "/money_out/calculator"(platform: "/", type: TrackType.View) {
         money_out_method = "cashout"
      }

      "/money_out/calculator/preset_selected"(platform: "/", type: TrackType.Event) {
         money_out_method = "cashout"
         preset = "500"
      }

      "/money_out/calculator/preset_selected"(platform: "/", type: TrackType.Event) {
         money_out_method = "cashout"
         preset = "5000"
      }

      "/money_out/calculator/continue"(platform: "/", type: TrackType.Event) {
         money_out_method = "cashout"
         amount = "500"
      }

      "/money_out/kyc"(platform: "/", type: TrackType.View) {}
      "/money_out/kyc/onboarding"(platform: "/", type: TrackType.View) {}

      "/money_out/cashout/map"(platform: "/", type: TrackType.View) {}

      // New Cashout Onobaording
      "/money_out/cashout/onboarding"(platform: "/", type: TrackType.View) {}
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
         transfer_method = "bank_transfer"
      }

      // Tecban
      "/money_detail/tecban"(platform: "/", type: TrackType.Event) {}
      "/money_out/tecban/network_error"(platform: "/", type: TrackType.View) {}
      "/money_out/tecban/onboarding"(platform: "/", type: TrackType.View) {}
      "/money_out/tecban"(platform: "/", type: TrackType.View) {}
      "/money_out/tecban/onboarding/continue"(platform: "/", type: TrackType.Event) {}
      "/money_out/tecban/onboarding"(platform: "/", type: TrackType.View) {}
      "/money_out/tecban/insufficient_amount"(platform: "/", type: TrackType.View) {}
      "/money_out/tecban/insufficient_amount/exit"(platform: "/", type: TrackType.Event) {}
      "/money_out/tecban/select_amount"(platform: "/", type: TrackType.View) {}
      "/money_out/tecban/select_amount/help"(platform: "/", type: TrackType.Event) {}
      "/money_out/tecban/select_amount/other"(platform: "/", type: TrackType.Event) {}

      "/money_out/tecban/select_amount/amount"(platform: "/", type: TrackType.Event) {
         amount = "200" 
      }


      "/money_out/tecban/select_amount/show_map"(platform: "/mobile", type: TrackType.Event) {}

      "/money_out/tecban/scanner"(platform: "/", type: TrackType.View) {}

      "/money_out/tecban/scanner/invalid_qr"(platform: "/", type: TrackType.Event) {
         qr = "ahjsdkaghjd1897ashdgajsgd" 
      }

      "/money_out/tecban/scanner/valid_qr"(platform: "/", type: TrackType.Event) {
         qr = "ahjsdkaghjd1897ashdgajsgd" 
      }

      "/money_out/tecban/authorize"(platform: "/", type: TrackType.View) {}
      "/money_out/tecban/success"(platform: "/", type: TrackType.View) {}
      "/money_out/tecban/success/exit"(platform: "/", type: TrackType.Event) {}
      "/money_out/tecban/success/help"(platform: "/", type: TrackType.Event) {}

      "/money_out/tecban/error"(platform: "/", type: TrackType.View) {
         error = "rejected" 
      }

      "/money_out/tecban/error/exit"(platform: "/", type: TrackType.Event) {
         error = "rejected" 
      }

      "/money_out"(platform: "/", type: TrackType.Event) {}
      "/money_out/tecban/select_amount"(platform: "/", type: TrackType.View) {}

      //Transfer Hub - Dashboard
      "/money_out/transfers"(platform: "/", type: TrackType.View) {}
      "/money_out/transfers/home/transfer_mp"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/home/transfer_bank"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/home/transfer_pix"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/home"(platform: "/", type: TrackType.View) {}
      "/money_out/transfers/home/send_money"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/home/transfer_ted"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/home/account_selected"(platform: "/", type: TrackType.Event) {
         type = "ted"
      }
      "/money_out/transfers/home/account_mark_favorite"(platform: "/", type: TrackType.Event) {
         type = "ted"
      }
      "/money_out/transfers/home/account_unmark_favorite"(platform: "/", type: TrackType.Event) {
         type = "ted"
      }
      "/money_out/transfers/home/account_deleted"(platform: "/", type: TrackType.Event) {
         type = "ted"
      }
      "/money_out/transfers/home/recents_tab_selected"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/home/favs_tab_selected"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/home/faq_button_clicked"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/home/profile_button_clicked"(platform: "/", type: TrackType.Event) {}
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
      "/money_out/transfers/new_account_form/recipient_account"(platform: "/", type: TrackType.View) {}
      "/money_out/transfers/new_account_form/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/new_account_form/recipient_account/continue_button_clicked"(platform: "/", type: TrackType.Event) {}

      //Transfer Hub - Transfer Amount
      "/money_out/transfers/amount"(platform: "/", type: TrackType.View) {}
      "/money_out/transfers/amount/continue_button_clicked"(platform: "/", type: TrackType.Event) {
         amount = "120.05"
      }
      "/money_out/transfers/amount/money_advance_clicked"(platform: "/", type: TrackType.Event) {
         advance = "yes"
      }

      //Transfer Hub - Review And Confirm
      "/money_out/transfers/review_and_confirm"(platform: "/", type: TrackType.View) {}
      "/money_out/transfers/review_and_confirm/edit_amount_clicked"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/review_and_confirm/edit_account_clicked"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/review_and_confirm/confirm_button_clicked"(platform: "/", type: TrackType.Event) {}

      //Transfer Hub - Congrats
      "/money_out/transfers/result"(platform: "/", type: TrackType.View) {}
      "/money_out/transfers/result/success_online"(platform: "/", type: TrackType.View) {
         transfer_id = 1231242
      }
      "/money_out/transfers/result/success_scheduled"(platform: "/", type: TrackType.View) {
         transfer_id = "123123"
      }
         
      "/money_out/transfers/result/processing_money_advance"(platform: "/", type: TrackType.View) {}
      "/money_out/transfers/result/money_advance_expired"(platform: "/", type: TrackType.View) {}
      "/money_out/transfers/result/error"(platform: "/", type: TrackType.View) {
         reason = "maybe"
      }
      "/money_out/transfers/result/view_receipt_button_clicked"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/result/go_to_home_button_clicked"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/result/complete_bacen_information_button_clicked"(platform: "/", type: TrackType.Event) {}
      
      //Transfer Hub - Receipt
      "/money_out/transfers/receipt"(platform: "/", type: TrackType.View) {
            transfer_id ="1231242"
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

      //Transfer Hub - TED Campaign Modal
      "/money_out/transfers/home/ted_campaign_modal"(platform:"/", type: TrackType.View){}
      "/money_out/transfers/home/ted_campaign_modal/ted_button_clicked"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/home/ted_campaign_modal/withdraw_legacy_button_clicked"(platform: "/", type: TrackType.Event) {}
      
      //Transfer Hub - Coelsa Error
      "/money_out/transfers/home/coelsa_error"(platform: "/", type: TrackType.View) {}
      "/money_out/transfers/home/coelsa_error/continue_button_clicked"(platform: "/", type: TrackType.Event) {}

      //Transfer Hub - Pix
      "/money_out/transfers/pix_dashboard"(platform: "/", type: TrackType.View) {}
      "/money_out/transfers/pix_dashboard/type_selected"(platform: "/", type: TrackType.Event){
        type = "cpf"
      }
      "/money_out/transfers/pix_dashboard/type_selected"(platform: "/", type: TrackType.Event){
        type = "cnpj"
      }
      "/money_out/transfers/pix_dashboard/type_selected"(platform: "/", type: TrackType.Event){
        type = "email"
      }
      "/money_out/transfers/pix_dashboard/type_selected"(platform: "/", type: TrackType.Event){
        type = "telefone"
      }
      "/money_out/transfers/pix_dashboard/type_selected"(platform: "/", type: TrackType.Event){
        type = "chave_aleatoria"
      }
      "/money_out/transfers/pix_dashboard/type_selected"(platform: "/", type: TrackType.Event){
        type = "datos_conta"
      }

      //Cashout - Modals
      "/money_out/cashout/insufficient_amount_modal"(platform:"/", type: TrackType.View){}
      "/money_out/cashout/insufficient_balance_modal"(platform:"/", type: TrackType.View){}

      //New TED scheduling modal
      "/money_out/transfers/review_and_confirm/new_scheduled_modal"(platform:"/", type: TrackType.View){}
      "/money_out/transfers/home/coelsa_error/continue_button_clicked"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/review_and_confirm/new_scheduled_modal/continue_transfer_with_ted"(platform: "/", type: TrackType.Event) {}
      "/money_out/transfers/review_and_confirm/new_scheduled_modal/cancel_button_clicked"(platform: "/", type: TrackType.Event) {}

    }
}