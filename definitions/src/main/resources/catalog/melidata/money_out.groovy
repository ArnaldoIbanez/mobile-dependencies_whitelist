import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
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
    "/money_detail/tecban"(platform: "/", type: TrackType.Event) {}

    "/money_out/tecban/onboarding"(platform: "/", type: TrackType.View) {}
    "/money_out/tecban"(platform: "/", isAbstract: true) {}
    
    "/money_out/tecban/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/money_out/tecban/onboarding"(platform: "/", type: TrackType.View) {}

    "/money_out/tecban/insufficient_amount"(platform: "/", type: TrackType.View) {}
    "/money_out/tecban/insufficient_amount/exit"(platform: "/", type: TrackType.Event) {}

    "/money_out/tecban/select_amount"(platform: "/", type: TrackType.View) {}

    "/money_out/tecban/select_amount/help"(platform: "/", type: TrackType.Event) {}
    
    "/money_out/tecban/select_amount"(platform: "/", isAbstract: true) {}

    "/money_out/tecban/select_amount/other"(platform: "/", type: TrackType.Event) {}
    
    "/money_out/tecban/select_amount/amount"(platform: "/", type: TrackType.Event) {
        amount (required:true, description: "Continue amount entered")
    }

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
}
