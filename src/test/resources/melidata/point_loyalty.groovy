package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.catalog.PropertyType

trackTests {
    defaultBusiness = "mercadopago"

    test("Point loyalty congrats view") {
        "/point/loyalty/register/congrats"(platform: "/web", type: TrackType.View) {}
    }

    test("Point loyalty register view") {
        "/point/loyalty/register/status"(platform: "/web", type: TrackType.View) {
            status = 1
        }
    }

    test("Point loyalty register view token expired") {   
        "/point/loyalty/register/status"(platform: "/web", type: TrackType.View) {
            status = 2
        }
    }

    test("Point loyalty generic error") {
        "/point/loyalty/register/failure"(platform: "/web", type: TrackType.Event) {
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
        "/point/loyalty/cashback_exchange"(platform: "/web", type: TrackType.View) {
        }
    }

    test("Point loyalty feedback sms") {   
        "/point/loyalty/feedback_sms"(platform: "/web", type: TrackType.Event) {
        }
    }

    test("Point loyalty modal component in cashback exchange view") {   
        "/point/loyalty/cashback_modal"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty tooltip component in cashback exchange view") {   
        "/point/loyalty/cashback_tooltip"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty continue with payment whitout cashback in cashback exchange view") {   
        "/point/loyalty/cashback_continue"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty continue with payment with cashback in cashback exchange view") {   
        "/point/loyalty/cashback_apply"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty quit cashback in cashback exchange view") {   
        "/point/loyalty/cashback_quit"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty change customer") {   
        "/point/loyalty/customer_change"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }

    test("Point loyalty quit customer") {   
        "/point/loyalty/quit_customer"(platform: "/web", type: TrackType.Event) {
            context = "/cashback-exchange"
        }
    }
}
