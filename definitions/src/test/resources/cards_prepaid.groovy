import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("cards prepaid landing") {

        // View
        "/prepaid/"(platform: "/", type: TrackType.View) {}
        "/prepaid/"(platform: "/", type: TrackType.View) { user_profile = "buyers" }
        "/prepaid/"(platform: "/", type: TrackType.View) {  hotjar_id = 1196462402 }
        "/prepaid/acquisition"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/card_request"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/card_request"(platform: "/", type: TrackType.View) { user_profile = "sellers" }
        "/prepaid/acquisition/landing/card_request"(platform: "/", type: TrackType.View) { hotjar_id = 1196462401 }
        "/prepaid/acquisition/landing/on_delivery_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/delivered_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/inactive/user_request"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/inactive/not_delivered_stolen_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/inactive/not_delivered_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/active_card"(platform: "/web/desktop") {}
    }


    test("cards prepaid acquisition flow") {

        // View
        "/prepaid/acquisition/confirmation_account"(platform: "/web/desktop") {}
        "/prepaid/acquisition/congrats/registration"(platform: "/web/desktop") {}
        "/prepaid/acquisition/juridical_info"(platform: "/web/desktop") {}
        "/prepaid/acquisition/personal_info"(platform: "/web/desktop") {}
        "/prepaid/acquisition/personal_info/identity"(platform: "/web/mobile") {}
        "/prepaid/acquisition/personal_info/gender"(platform: "/web/mobile") {}
        "/prepaid/acquisition/personal_info/activity"(platform: "/web/mobile") {}
        "/prepaid/acquisition/review"(platform: "/web/desktop") {}
        "/prepaid/acquisition/review/welcome"(platform: "/web/mobile") {}
        "/prepaid/acquisition/need_fund"(platform: "/web/desktop") {}
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) {}
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) { congrats_type = "bapropagos" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) { congrats_type = "redlink" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View) { congrats_type = "maestro" }
        "/prepaid/acquisition/congrats"(platform: "/web/mobile", type: TrackType.View) { congrats_type = "bolbradesco" }
        "/prepaid/acquisition/congrats"(platform: "/web/mobile", type: TrackType.View) { congrats_type = "rapipago" }
        "/prepaid/acquisition/error"(platform: "/web/desktop", type: TrackType.View) {}
        "/prepaid/acquisition/error"(platform: "/web/desktop", type: TrackType.View) { error_type = "main_error" }
        "/prepaid/acquisition/error"(platform: "/web/desktop", type: TrackType.View) { error_type = "have_a_card" }
        "/prepaid/acquisition/error"(platform: "/web/mobile", type: TrackType.View) { error_type = "juridical_error" }
        "/prepaid/acquisition/error"(platform: "/web/mobile", type: TrackType.View) { error_type = "denied_error" }
    } 


    test("cards prepaid activation flow") {

        // View  
        "/prepaid/activation"(platform: "/web/desktop") {}  
        "/prepaid/activation/last_digits"(platform: "/web/desktop") {}
        "/prepaid/activation/marital_status"(platform: "/web/desktop") {}
        "/prepaid/activation/congrats"(platform: "/web/desktop") {}
        "/prepaid/activation/error"(platform: "/", type: TrackType.View) {}
        "/prepaid/activation/error"(platform: "/", type: TrackType.View) { error_type = "main_error" }
        "/prepaid/activation/error"(platform: "/", type: TrackType.View) { error_type = "not_found" }
    }


    test("cards prepaid shipment tracking") {

        // View
        "/prepaid/tracking"(platform: "/", type: TrackType.View) {}
        "/prepaid/tracking"(platform: "/", type: TrackType.View) { status = "on_track" }
        "/prepaid/tracking"(platform: "/", type: TrackType.View) { status = "delayed" }
        "/prepaid/tracking"(platform: "/", type: TrackType.View) { status = "to_collect" }
        "/prepaid/tracking"(platform: "/", type: TrackType.View) { status = "not_delivered" }
    }


    test("cards prepaid block") {

        // View
        "/prepaid/block"(platform: "/web/desktop") {}
    }

    test("Landing Cobranded card") {
        "/cobranded/acquisition/landing" (platform: "/web") {}
    }
}
