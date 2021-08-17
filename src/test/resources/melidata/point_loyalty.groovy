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
        "/point/loyalty/register"(platform: "/web", type: TrackType.View) {}
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
}
