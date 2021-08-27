import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = "1299"

    "/point/loyalty/register/congrats"(platform:"/web", type: TrackType.View) { }

    "/point/loyalty/register/status"(platform: "/web", type: TrackType.View) {
        status(required: true, type: PropertyType.Numeric, description: "Status of token user")
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
    
    "/point/loyalty/cashback_exchange"(platform: "/web", type: TrackType.View) { }

    "/point/loyalty/feedback_sms"(platform: "/web", type: TrackType.Event) { }

    "/point/loyalty/cashback_modal"(platform: "/web", type: TrackType.Event) { 
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")

    }

    "/point/loyalty/cashback_tooltip"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
     }

    "/point/loyalty/cashback_continue"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/cashback_apply"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/cashback_quit"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/customer_change"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }

    "/point/loyalty/quit_customer"(platform: "/web", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, description: "Page, section or flow origin")
    }
}
