package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.catalog.PropertyType

trackTests {
    defaultBusiness = "mercadopago"

    test("Point loyalty congrats view") {
        "/point/loyalty/register/congrats"(platform: "/web", type: TrackType.View) {
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

    test("Point loyalty generic error") {
        "/point/loyalty/register/failure"(platform: "/web", type: TrackType.View) {
            error_message= "Timeout request"
        }
    }

    test("Point loyalty form field invalid") {
        "/point/loyalty/register/form_field/invalid"(platform: "/web", type: TrackType.Event) {
             field_name= "email"
             error_message= "is required"
        }
    }

    test("Point loyalty FAQ") {
        "/point/loyalty/register/faq"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty tyc") {
        "/point/loyalty/register/tyc"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty phone register view") {   
        "/point/loyalty/phone_register"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty cashback exchange view") {   
        "/point/loyalty/cashback/exchange"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty feedback sms") {   
        "/point/loyalty/feedback_sms"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty modal component in cashback exchange view") {   
        "/point/loyalty/modal"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty tooltip component in cashback exchange view") {   
        "/point/loyalty/cashback/tooltip"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty continue with payment whitout cashback in cashback exchange view") {   
        "/point/loyalty/cashback/continue"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty continue with payment with cashback in cashback exchange view") {   
        "/point/loyalty/cashback/apply"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty quit cashback in cashback exchange view") {   
        "/point/loyalty/cashback/quit"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty change customer") {   
        "/point/loyalty/customer/change"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty quit customer") {   
        "/point/loyalty/customer/quit"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty offer cashback in middle flow screen") {   
        "/point/loyalty/cashback/middle"(platform: "/web", type: TrackType.View) {
        }
    }

     test("Point loyalty continue with payment with cashback in middle flow screen") {   
        "/point/loyalty/cashback/middle/continue"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-middle"
        }
    }

    test("Point loyalty continue with payment without cashback in middle flow screen") {   
        "/point/loyalty/cashback/middle/reject"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-middle"
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

    test("Point loyalty config congrats") {   
        "/point/loyalty/config/congrats"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty config metrics") {   
        "/point/loyalty/config/metrics"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty seller restart program") {   
        "/point/loyalty/config/program/restart"(platform: "/web", type: TrackType.Event) {
            context = "/config/program"
        }
    }

    test("Point loyalty event click in faq into seller config") {   
        "/point/loyalty/config/faq"(platform: "/web", type: TrackType.Event) {
            context = "/config/program"
        }
    }
}
