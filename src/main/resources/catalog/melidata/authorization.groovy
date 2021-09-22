
package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

     initiative = "1046"

    "/open_banking"(platform: "/", isAbstract: true) {}
    
    "/appstore"(platform: "/", isAbstract: true) {}

    "/open_banking/authorization"(platform: "/", type: TrackType.View) {
        base_path (type: PropertyType.String, required: true, description: "Page root de open banking'")
        name_page (type: PropertyType.String, required: true, description: "event result'")
    }

     "/open_banking/error"(platform: "/", type: TrackType.View) {
        base_path (type: PropertyType.String, required: true, description: "Page root de open banking'")
        name_page (type: PropertyType.String, required: true, description: "event result'")
    }

    "/open_banking/access"(platform: "/", type: TrackType.View) {
        base_path (type: PropertyType.String, required: true, description: "Page root de open banking'")
        name_page (type: PropertyType.String, required: true, description: "event result'")
    }

     "/appstore/authorization"(platform: "/", type: TrackType.View) {
        base_path (type: PropertyType.String, required: true, description: "Page OAuth Appstore'")
        name_page (type: PropertyType.String, required: true, description: "event result'")
        integrator_app (type: PropertyType.String, required: true, description: "App request permission'")
        request_app (type: PropertyType.String, required: true, description: "App (MP/ML) grants permission'")
    }
    
    "/appstore/error"(platform: "/", type: TrackType.View) {
        base_path (type: PropertyType.String, required: true, description: "Page error appstore'")
        name_page (type: PropertyType.String, required: true, description: "event result'")
    }

    "/appstore/access"(platform: "/", type: TrackType.View) {
        base_path (type: PropertyType.String, required: true, description: "Page accept or reject grant'")
        name_page (type: PropertyType.String, required: true, description: "event result'")
    }
 
}