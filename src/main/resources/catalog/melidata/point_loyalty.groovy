import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = "1349"

    "/point/loyalty/phone_register"(platform: "/web", type: TrackType.View) { 
    }

    "/point/loyalty/phone_register/continue"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/retry_phone_register"(platform: "/web", type: TrackType.View) {
    }

    "/point/loyalty/retry_phone_register/continue"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/register/link"(platform: "/web", type: TrackType.View) {
        status(required: true, description: "Status of token user", values: ["active", "expired"])
    }

    "/point/loyalty/register/tyc"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/register/faq"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/register/privacy"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/register/submit"(platform: "/web", type: TrackType.Event) {
    }
    
    "/point/loyalty/register/congrats"(platform:"/web", type: TrackType.View) {
    }

    "/point/loyalty/register/invalid"(platform: "/web", type: TrackType.Event) {     
        field_name(required: true, type: PropertyType.String, description: "Field name")
        error_message(required: true, type: PropertyType.String, description: "error message")
    }

    "/point/loyalty/register/accept_terms"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/register/congrats/optout"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/register/congrats/optout/cancel"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/register/congrats/optout/confirm"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/cashback/exchange"(platform: "/web", type: TrackType.View) {
    }

    "/point/loyalty/cashback/exchange/reward/information"(platform: "/web", type: TrackType.Event) {
        register_complete(required: true, type: PropertyType.Boolean, description: 'status of register customer')
    }

    "/point/loyalty/cashback/exchange/reward/information/faq"(platform: "/web", type: TrackType.Event) { 
    }

    "/point/loyalty/cashback/exchange/reward/information/close"(platform: "/web", type: TrackType.Event) { 
    }

    "/point/loyalty/cashback/exchange/customer/quit"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/cashback/exchange/continue"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/cashback/exchange/continue_without_cashback"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/cashback/exchange/feedback"(platform: "/web", type: TrackType.View) {
    }

    "/point/loyalty/cashback/exchange/feedback/continue"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/cashback/exchange/feedback/customer_quit"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/config/welcome"(platform: "/web", type: TrackType.View) {
    }

    "/point/loyalty/config/program"(platform: "/web", type: TrackType.View) {
    }

    "/point/loyalty/config/submit"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/config/program/tyc"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/config/program/more_information"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/config/congrats"(platform: "/web", type: TrackType.View) {
    }

    "/point/loyalty/config/congrats/go_metrics"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/config/metrics"(platform: "/web", type: TrackType.View) {
    }

    "/point/loyalty/config/metrics/faq"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/config/program/restart"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/config/metrics/edit"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/config/program/update"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/config/program/cancel"(platform: "/web", type: TrackType.Event) {
    }
    
    "/point/loyalty/config/program/optout/cancel"(platform: "/web", type: TrackType.Event) {
    }

    "/point/loyalty/config/program/optout/continue"(platform: "/web", type: TrackType.Event) {
    }
}
