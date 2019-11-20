import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    propertyDefinitions {
        latitude(required:false, type: PropertyType.String, description:"The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description:"The longitude of driver at that point")
    }

    propertyGroups {
        location(latitude, longitude)
    }

    "/logistics"(platform: "/", isAbstract: true) {
        location
    }

    "/logistics/error"(platform: "/mobile", type: TrackType.View) {
        error_type(required: true, type: PropertyType.String, values: ["generic", "connection"],
                description: "Specifies what kind of error happened.", inheritable: false)
        error_step_id(required: false, type: PropertyType.String,
                description: "Specifies the stepId where the error happened.", inheritable: false)
    }
    "/logistics/error/snackbar"(platform: "/mobile", type: TrackType.Event) {
        error_type(required: true, type: PropertyType.String, values: ["generic", "delivery_failed",
                                                                       "not_delivered_failed", "connection"],
                description: "Specifies what kind of error happened.")
        error_step_id(required: false, type: PropertyType.String,
                description: "Specifies the stepId where the error happened.", inheritable: false)
    }

    "/logistics/login/"(platform: "/mobile", isAbstract: true) {}

    "/logistics/login/select_country"(platform: "/mobile", type: TrackType.View) {
        device_id(required: true, type: PropertyType.String, description: "Specifies the device's id", inheritable: false)
    }
    "/logistics/login/vehicle/start"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/login/vehicle/scanner"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/login/vehicle/scanner/vehicle_detected"(platform: "/mobile", type: TrackType.Event) {
        vehicle_id(required: true, type: PropertyType.String, description:"The id of the vehicle", inheritable: false)
        status(required: true, type: PropertyType.String, values: ["ok", "error"], description: "Specifies if the detected vehicle qr has the correct format or not", inheritable: false)
    }
    "/logistics/login/document"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/login/account_disabled"(platform: "/mobile", type: TrackType.View) {
        error_type(required: true, type: PropertyType.String, values: ["vehicle", "driver", "vehicle_driver"],
                description: "Specifies what kind of error happened.", inheritable: false)
    }
    "/logistics/login/error"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/login/vehicle_on_route"(platform: "/mobile", type: TrackType.View) {
        vehicle_id(required: true, type: PropertyType.String, description:"The id of the vehicle", inheritable: false)
    }
    "/logistics/login/driver_on_route"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: true, type: PropertyType.String, description: "Specifies the driver id", inheritable: false)
    }
    "/logistics/login/profile"(platform: "/mobile", type: TrackType.View) {}

    "/logistics/flow_decision/start"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/flow_decision/start/ask_camera"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/flow_decision/start/ask_geolocation"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/flow_decision/scanner"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/flow_decision/add_package/invalid"(platform: "/mobile", type: TrackType.View) {
        pack_id(required: true, type: PropertyType.String, description: "Specifies the pack id that had an error", inheritable: false)
    }
    "/logistics/flow_decision/add_container/invalid"(platform: "/mobile", type: TrackType.View) {
        container_id(required: true, type: PropertyType.String, description: "Specifies the container id that had an error", inheritable: false)
    }

    "/logistics/conciliation/fail"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/conciliation/ok"(platform: "/mobile", type: TrackType.View) {}

    // Last Mile
    "/logistics/last_mile/login/recover_trip"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
    }
    "/logistics/last_mile/profile"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/add_package/invalid"(platform: "/mobile", type: TrackType.View) {
        pack_id(required: true, type: PropertyType.String, description: "Specifies the pack id that had an error", inheritable: false)
    }


    // First Mile
    "/logistics/first_mile/scanner/modal_back"(platform: "/mobile", type: TrackType.View) {
        packs_amount(required: false, type: PropertyType.Numeric, description: "Specifies the amount of packages that " +
                "were scanned at the moment that the view was shown")
    }
    "/logistics/first_mile/scanner/modal_back/back"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/first_mile/scanner/modal_back/cancel"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/first_mile/profile"(platform: "/mobile", type: TrackType.View) {}
}