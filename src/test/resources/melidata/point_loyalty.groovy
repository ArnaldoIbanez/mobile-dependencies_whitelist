package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.catalog.PropertyType

trackTests {
    defaultBusiness = "mercadopago"

    test("Point loyalty phone register view") {   
        "/point/loyalty/phone_register"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty phone register continue button") {
        "/point/loyalty/phone_register/continue"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty retry phone register view") {
        "/point/loyalty/retry_phone_register"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty retry phone register continue button") {
        "/point/loyalty/retry_phone_register/continue"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty register view") {
        "/point/loyalty/register/status"(platform: "/web", type: TrackType.View) {
            status = "active"
        }
    }

    test("Point loyalty register view token expired") {   
        "/point/loyalty/register/status"(platform: "/web", type: TrackType.View) {
            status = "expired"
        }
    }

    test("Point loyalty tyc") {
        "/point/loyalty/register/tyc"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty FAQ") {
        "/point/loyalty/register/faq"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty Privacy") {
        "/point/loyalty/register/privacy"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty register submit button") {
        "/point/loyalty/register/submit"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty congrats view") {
        "/point/loyalty/register/congrats"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty form field invalid") {
        "/point/loyalty/register/invalid"(platform: "/web", type: TrackType.Event) {
             field_name= "email"
             error_message= "is required"
        }
    }

    test("Point loyalty register accept terms form") {
        "/point/loyalty/register/accept_terms"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty register congrats opt-out link") {
        "/point/loyalty/register/congrats/optout"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty register congrats opt-out cancel button") {
        "/point/loyalty/register/congrats/optout/cancel"(platform: "/web", type: TrackType.Event) {
        }
    }
    
    test("Point loyalty register congrats opt-out confirm button") {
        "/point/loyalty/register/congrats/optout/confirm"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty cashback exchange view") {   
        "/point/loyalty/cashback/exchange"(platform: "/web", type: TrackType.View) {
        }
    }
    
    test("Point loyalty tooltip component with information about reward in cashback exchange view") {   
        "/point/loyalty/cashback/exchange/reward_information"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty modal component with details about reward in cashback exchange view") {   
        "/point/loyalty/cashback/exchange/reward_detail"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty faq link in modal component into cashback exchange view") {   
        "/point/loyalty/cashback/exchange/reward_detail/faq"(platform: "/web", type: TrackType.Event) {
        }
    }


    test("Point loyalty close button in modal component into cashback exchange view") {   
        "/point/loyalty/cashback/exchange/reward_detail/close"(platform: "/web", type: TrackType.Event) {
        }
    }


    test("Point loyalty quit customer in cashback exchange view") {   
        "/point/loyalty/cashback/exchange/customer/quit"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty continue with payment with cashback in cashback exchange view") {   
        "/point/loyalty/cashback/exchange/continue"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty continue with payment whitout cashback in cashback exchange view") {   
        "/point/loyalty/cashback/exchange/continue_without_cashback"(platform: "/web", type: TrackType.Event) {
        }
    }


    test("Point loyalty feedback in cashback exchange view") {   
        "/point/loyalty/cashback/exchange/feedback"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty continue button in feedback exchange view") {      
        "/point/loyalty/cashback/exchange/feedback/continue"(platform: "/web", type: TrackType.View) {
        }
    }
    
    test("Point loyalty quit client button in feedback exchange view") {      
        "/point/loyalty/cashback/exchange/feedback/customer_quit"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty config welcome seller") {   
        "/point/loyalty/config/welcome"(platform: "/web", type: TrackType.View) {
        }
    }
    
    test("Point loyalty config program") {   
        "/point/loyalty/config/program"(platform: "/web", type: TrackType.View) {
        }
    }


    test("Point loyalty config program submit button") {   
        "/point/loyalty/config/submit"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty event click in terms into seller config program") {   
        "/point/loyalty/config/program/tyc"(platform: "/web", type: TrackType.Event) {
        }
    }
    
    test("Point loyalty config program click open modal") {   
        "/point/loyalty/config/program/modal"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty config congrats") {   
        "/point/loyalty/config/congrats"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty config congrats go metrics button") {   
        "/point/loyalty/config/congrats/go_metrics"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty config metrics") {   
        "/point/loyalty/config/metrics"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty event click in faq into seller config") {   
        "/point/loyalty/config/metrics/faq"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty restart program in config view") {   
        "/point/loyalty/config/program/restart"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty event click in edit button") {   
        "/point/loyalty/config/metrics/edit"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty config program update") {   
        "/point/loyalty/config/program/update"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty config desactivate program") {   
        "/point/loyalty/config/program/cancel"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty config program optout cancel remove program") {   
        "/point/loyalty/config/program/optout/cancel"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty config program optout modal confirm") {   
        "/point/loyalty/config/program/optout/continue"(platform: "/web", type: TrackType.Event) {
        }
    }
}
