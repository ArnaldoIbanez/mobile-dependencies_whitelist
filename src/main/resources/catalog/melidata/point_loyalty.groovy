import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = "1299"

    "/point/loyalty/register/congrats"(platform:"/web", type: TrackType.View) { }

    "/point/loyalty/register"(platform: "/web", type: TrackType.View) {}

    "/point/loyalty/register/failure"(platform: "/web", type: TrackType.Event) {
        error_message(required: true, type: PropertyType.String, description: "Generic error message")
    }

    "/point/loyalty/register/form_field/invalid"(platform: "/web", type: TrackType.Event) { 
        field_name(required: true, type: PropertyType.String, description: "Field name")
        error_message(required: true, type: PropertyType.String, description: "error message")
    }

    "/point/loyalty/register/faq"(platform: "/web", type: TrackType.Event) { 
    }

    "/point/loyalty/register/tyc"(platform: "/web", type: TrackType.Event) {     
    }
}
