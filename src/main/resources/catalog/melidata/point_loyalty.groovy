import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = "1299"

    "/point/loyalty/register/congrats"(platform:"/web", type: TrackType.View) { }

    "/point/loyalty/register/status"(platform: "/web", type: TrackType.View) {
        status(required: true, description: "Status of token user", values: ["active", "expired"])
    }

    "/point/loyalty/register/failure"(platform: "/web", type: TrackType.Event) {
        error_message(required: true, type: PropertyType.String, description: "Generic error message")
    }

    "/point/loyalty/register/form_field/invalid"(platform: "/web", type: TrackType.Event) { 
        field_name(required: true, type: PropertyType.String, description: "Field name")
        error_message(required: true, type: PropertyType.String, description: "error message")
    }

    "/point/loyalty/register/faq"(platform: "/web", type: TrackType.Event) { }

    "/point/loyalty/register/tyc"(platform: "/web", type: TrackType.Event) { }

    "/point/loyalty/phone_register"(platform: "/web", type: TrackType.View) { }
    
    "/point/loyalty/cashback/exchange"(platform: "/web", type: TrackType.View) { }

    "/point/loyalty/feedback_sms"(platform: "/web", type: TrackType.Event) { }

    "/point/loyalty/modal"(platform: "/web", type: TrackType.View) { 
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/cashback/tooltip"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
     }

    "/point/loyalty/cashback/continue"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/cashback/apply"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/cashback/quit"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/customer/change"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/customer/quit"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/cashback/middle"(platform: "/web", type: TrackType.View) {
    }

    "/point/loyalty/cashback/middle/continue"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/cashback/middle/reject"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }
}
