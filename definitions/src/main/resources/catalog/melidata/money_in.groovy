import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    /**
        Money In V2 Tracks
    **/

    "/money_in"(platform: "/", isAbstract: true) {}

    //Payment methods tracks
    "/money_in/payment_methods"(platform: "/", type: TrackType.View) {}

    //Calculator tracks
    "/money_in/calculator"(platform: "/", type: TrackType.View) {
        payment_method (required:true, description: "Payment method selected on calculator", values: ["pec", "bolbradesco"])
    }

    //Calculator montos preseteados
    "/money_in/calculator/preset_selected"(platform: "/", type: TrackType.Event) {
        preset (required:true, description: "Preset amount selected", values: ["30", "60", "120", "240", "500", "1000", "2000", "5000"])
    }

    "/money_in/calculator/continue"(platform: "/", type: TrackType.Event) {
        payment_method (required:true, description: "Continue payment method selected", values: ["pec", "bolbradesco"])
        amount (required:true, description: "Continue amount entered")
    }

    //Checkout PX
    "/money_in/px"(platform: "/", isAbstract: true) {}

    "/money_in/px/error"(platform: "/", type: TrackType.View) {}

    "/money_in/px/success"(platform: "/", type: TrackType.View) {}

    "/money_in/onboarding"(platform: "/", isAbstract: true) {}

    //Onboarding
    "/money_in/onboarding/adicione_dinero"(platform: "/", type: TrackType.View) {}
    "/money_in/onboarding/simplifique_pagos"(platform: "/", type: TrackType.View) {}
    "/money_in/onboarding/reciba_rendimientos"(platform: "/", type: TrackType.View) {}
    "/money_in/onboarding/use_tarjeta_mp"(platform: "/", type: TrackType.View) {}

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


}
