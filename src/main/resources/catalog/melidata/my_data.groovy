package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    // My data
    "/my_data"(platform: "/", type: TrackType.View) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "indicates the type of person (person, company, unknown)")
        is_compliant(type: PropertyType.Boolean, required: false, description: "is compliant", inheritable:false)
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "customer type (BU, CO)")
    }

    "/my_data/action"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "indicates the type of person (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "customer type (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: false, description: "is compliant", inheritable:false)
        event_type(type: PropertyType.String, required: true, values: ["click"], description: "User clicked a cell or card")
        target(type: PropertyType.String, required: true, values: ["nickname", "email", "identity", "user", "phone", "preferred-name"], description: "Name of cell that was clicked")
    }

    // identity
    "/my_data/identity"(platform: "/", type: TrackType.View) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "indicates the type of person (person, company, unknown)")
        is_compliant(type: PropertyType.Boolean, required: false, description: "is compliant", inheritable:false)
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "customer type (BU, CO)")
    }

    "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "indicates the type of person (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "customer type (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: false, description: "is compliant", inheritable:false)
        target(type: PropertyType.String, required: true, values: ["modified"], description: "Button clicked by the user in the Devices Admin page")
    }

}
