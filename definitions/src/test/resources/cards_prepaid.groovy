import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("cards prepaid landing") {

        // View
        "/prepaid/acquisition"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/card_request"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/on_delivery_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/delivered_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/inactive/user_request"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/inactive/not_delivered_stolen_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/inactive/not_delivered_card"(platform: "/web/desktop") {}
        "/prepaid/acquisition/landing/active_card"(platform: "/web/desktop") {}

        // Event
        "/prepaid/acquisition/landing"(platform: "/", type: TrackType.Event) {
            user_profile = "buyers"
        }
        "/prepaid/acquisition/landing/card_request"(platform: "/", type: TrackType.Event) {
            user_profile = "sellers"
        }
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

        // Event
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.Event) { congrats_type = "bapropagos" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.Event) { congrats_type = "redlink" }
        "/prepaid/acquisition/congrats"(platform: "/web/desktop", type: TrackType.Event) { congrats_type = "maestro" }
        "/prepaid/acquisition/congrats"(platform: "/web/mobile", type: TrackType.Event) { congrats_type = "bolbradesco" }
        "/prepaid/acquisition/congrats"(platform: "/web/mobile", type: TrackType.Event) { congrats_type = "rapipago" }
        
        "/prepaid/acquisition/error"(platform: "/web/desktop", type: TrackType.Event) { error_type = "main_error" }
        "/prepaid/acquisition/error"(platform: "/web/desktop", type: TrackType.Event) { error_type = "have_a_card" }
        "/prepaid/acquisition/error"(platform: "/web/mobile", type: TrackType.Event) { error_type = "juridical_error" }
        "/prepaid/acquisition/error"(platform: "/web/mobile", type: TrackType.Event) { error_type = "denied_error" }
    } 


    test("cards prepaid activation flow") {

        // View  
        "/prepaid/activation"(platform: "/web/desktop") {}  
        "/prepaid/activation/last_digits"(platform: "/web/desktop") {}
        "/prepaid/activation/marital_status"(platform: "/web/desktop") {}
        "/prepaid/activation/congrats"(platform: "/web/desktop") {}

        // Event
        "/prepaid/activation/error"(platform: "/", type: TrackType.Event) { error_type = "main_error" }
        "/prepaid/activation/error"(platform: "/", type: TrackType.Event) { error_type = "not_found" }
    }


    test("cards prepaid shipment tracking") {
        
        // Event
        "/prepaid/tracking"(platform: "/", type: TrackType.Event) { status = "on_track" }
        "/prepaid/tracking"(platform: "/", type: TrackType.Event) { status = "delayed" }
        "/prepaid/tracking"(platform: "/", type: TrackType.Event) { status = "to_collect" }
        "/prepaid/tracking"(platform: "/", type: TrackType.Event) { status = "not_delivered" }
    }


    test("cards prepaid block") {

        // View
        "/prepaid/block"(platform: "/web/desktop") {}
    }
}




























