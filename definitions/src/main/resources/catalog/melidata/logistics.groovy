import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    propertyDefinitions {
        latitude(required:false, type: PropertyType.String, description:"The latitude of driver at that point", inheritable:false)
        longitude(required:false, type: PropertyType.String, description:"The longitude of driver at that point", inheritable:false)

        vehicle_id(required: true, type: PropertyType.String, description:"The id of the vehicle", inheritable: false)
        license_plate(required: false, type: PropertyType.String, description:"The license plate of the vehicle", inheritable: false)
        carrier_id(required: false, type: PropertyType.String, description: "The id of the carrier", inheritable: false)

        driver_id(required: true, type: PropertyType.String, description: "Specifies the driver id", inheritable: false)
        document_number(required: false, type: PropertyType.String, description: "The driver's document number", inheritable: false)
    }

    propertyGroups {
        location(latitude, longitude)
        vehicle_info(vehicle_id, license_plate, carrier_id)
        driver_info(driver_id, document_number)
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

    "/logistics/login/select_country"(platform: "/mobile", type: TrackType.View) {
        device_id(required: true, type: PropertyType.String, description: "Specifies the device's id", inheritable: false)
        location
    }

    "/logistics/login/vehicle/start"(platform: "/mobile", type: TrackType.View) {}

    "/logistics/login/vehicle/scan"(platform: "/mobile", type: TrackType.View) {}

    "/logistics/login/vehicle/scan/vehicle_detected"(platform: "/mobile", type: TrackType.Event) {
        vehicle_info
        qr_format(required: true, type: PropertyType.String, values: ["ok", "error"], description: "Specifies if the detected " +
                "vehicle qr has the correct format or not", inheritable: false)
    }

    "/logistics/login/document"(platform: "/mobile", type: TrackType.View) {}

    "/logistics/conciliation/fail"(platform: "/mobile", type: TrackType.View) {}

    "/logistics/conciliation/ok"(platform: "/mobile", type: TrackType.View) {}

    "/logistics/login/account_disabled"(platform: "/mobile", type: TrackType.View) {
        error_type(required: true, type: PropertyType.String, values: ["vehicle", "driver", "vehicle_driver"],
                description: "Specifies what kind of error happened.", inheritable: false)
    }

    "/logistics/login/error"(platform: "/mobile", type: TrackType.View) {}

    "/logistics/login/vehicle_on_route"(platform: "/mobile", type: TrackType.View) {
        vehicle_info
    }

    "/logistics/login/driver_on_route"(platform: "/mobile", type: TrackType.View) {
        driver_info
    }

    // Last Mile
    "/logistics/last_mile/login/recover_trip"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
    }

    // First Mile
    "/logistics/first_mile/scanner/modal_back"(platform: "/mobile", type: TrackType.View) {
        packs_amount(required: false, type: PropertyType.Numeric, description: "Specifies the amount of packages that " +
                "were scanned at the moment that the view was shown")
    }

    "/logistics/first_mile/scanner/modal_back/back"(platform: "/mobile", type: TrackType.Event) {}

    "/logistics/first_mile/scanner/modal_back/cancel"(platform: "/mobile", type: TrackType.Event) {}
}