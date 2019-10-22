package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    propertyDefinitions {
        latitude(required:false, type: PropertyType.String, description:"The latitude of driver at that point", inheritable:false)
        longitude(required:false, type: PropertyType.String, description:"The longitude of driver at that point", inheritable:false)
    }

    propertyGroups {
        location(latitude, longitude)
    }

    "/logistics"(platform: "/", isAbstract: true) {}

    "/logistics/error"(platform: "/mobile", type: TrackType.View) {
        location
        error_type(required: true, type: PropertyType.String, values: ["generic", "connection"],
                description: "Specifies what kind of error happened.", inheritable: false)
        error_step_id(required: false, type: PropertyType.String,
                description: "Specifies the stepId where the error happened.", inheritable: false)
    }

    "/logistics/error/snackbar"(platform: "/mobile", type: TrackType.Event) {
        location
        error_type(required: true, type: PropertyType.String, values: ["generic", "delivery_failed",
                                                                       "not_delivered_failed", "connection"],
                description: "Specifies what kind of error happened.")
        error_step_id(required: false, type: PropertyType.String,
                description: "Specifies the stepId where the error happened.", inheritable: false)
    }

    "/logistics/conciliation/fail"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/conciliation/ok"(platform: "/mobile", type: TrackType.View) {}

}