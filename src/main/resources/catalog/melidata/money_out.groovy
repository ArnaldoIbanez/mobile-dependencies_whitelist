package catalog.melidata

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
}
