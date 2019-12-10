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
    }    
}