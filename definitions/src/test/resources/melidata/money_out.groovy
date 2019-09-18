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
         transfer_method (required:true, description: "Transfer method selected")
     }
    }
}