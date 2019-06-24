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
    }

}