
package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

     initiative = "1046"

    "/open_banking"(platform: "/", isAbstract: true) {}

    "/open_banking/authorization"(platform: "/", type: TrackType.View) {
        basepath (type: PropertyType.String, required: true, description: "Page root de open banking'")
        namepage (type: PropertyType.String, required: true, description: "event result'")
    }

     "/open_banking/error"(platform: "/", type: TrackType.View) {
        basepath (type: PropertyType.String, required: true, description: "Page root de open banking'")
        namepage (type: PropertyType.String, required: true, description: "event result'")
    }

    "/open_banking/access"(platform: "/", type: TrackType.View) {
        basepath (type: PropertyType.String, required: true, description: "Page root de open banking'")
        namepage (type: PropertyType.String, required: true, description: "event result'")
    }
 
}