package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    // my data
    "/my-data"(platform: "/", type: TrackType.View) {
        entity_type(type: PropertyType.String, required: true, description: "indicates the type of person (person, company)")
        is_compliant(type: PropertyType.Boolean, required: false, description: "is compliant", inheritable:false)
        account_type(type: PropertyType.String, required: true, description: "customer type (BU, CO)")
    }

    "/my-data/action"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, description: "indicates the type of person (person, company)")
        account_type(type: PropertyType.String, required: true, description: "customer type (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: false, description: "is compliant", inheritable:false)
        event_type(type: PropertyType.String, required: true, values: ["click"], description: "User clicked a cell or card")
        target(type: PropertyType.String, required: true, values: ["nickname", "email", "identity", "user", "phone", "preferred-name"], description: "Name of cell that was clicked")
    }

    // User
    "/my-data/user-identity-me"(platform: "/", type: TrackType.View) {}

    "/my-data/user-identity-me/action"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, description: "indicates the type of person (person, company)")
        account_type(type: PropertyType.String, required: true, description: "customer type (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: false, description: "is compliant", inheritable:false)
        target(type: PropertyType.String, required: true, values: ["modified"], description: "Button clicked by the user in the Devices Admin page")
    }

}
