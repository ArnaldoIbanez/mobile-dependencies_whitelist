import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = "1375"

    "/reauthentication"(platform: "/", type: TrackType.Event) {
        operation_id(required: true, type: PropertyType.String, description: "operation flow identifier")
        reauth_id(required: true, type: PropertyType.String, description: "reauthentication identifier")
        reauth_type(required: true, type: PropertyType.String, description: "reauthentication type")
        flow_type(required: true, type: PropertyType.String, description: "type of operating flow")
        reauth_status(required: true, type: PropertyType.String, description: "reauthentication status")
        reauth_risk(required: true, type: PropertyType.String, description: "reauthentication risk")
        elapsed_time(required: false, type: PropertyType.String, description: "elapsed time in the operation")
        user_ato_risk(required: false, type: PropertyType.String, description: "user ATO risk")
        amount(required: false, type: PropertyType.String, description: "amount of the operation")
        recently_logged_in(required: true, type: PropertyType.Boolean, description: "Indicates if the user recently logged in")
        requested_factors(required: true, type: PropertyType.String, description: "factors requested for reauthentication") // TODO - ver si separar por factores
    }
}