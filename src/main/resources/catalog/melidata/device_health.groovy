package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1375"
    /**
     * Device Health Tracks
     */

    "/devices/health/location_risk"(platform: "/mobile", type: TrackType.App) {}

    def bodySchemaDefinitions = objectSchemaDefinitions {
        installation_id(type: PropertyType.String, required: true, description: "Installation ID")
        account_id(type: PropertyType.String, required: false, description: "Account ID")
    }

    "/devices/health/location_risk/request"(platform: "/mobile", type: TrackType.App) {
        provider(type: PropertyType.String, required: true, values: ["incognia"], description: "Provider in charge of the assessments")
        identifier(type: PropertyType.String, required: true, description: "Identifier for a particular request")
        event_type(type: PropertyType.String, required: true, values: ["sign-up", "log-in", "payment"], description: "Type of assessment the user is trying to test")
        body(type: PropertyType.Map(bodySchemaDefinitions), required:true, description: "Payload representation for request")
        latitude(type: PropertyType.String, required: false, description: "current device position")
        longitude(type: PropertyType.String, required: false, description: "current device position")
    }

    def resultSchemaDefinitions = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "id")
        risk_assessment(type: PropertyType.String, required: true, description: "risk score")
        device_model(type: PropertyType.String, required: true, description: "Model of the device used to perform the given action.")
        location_permission_enabled(type: PropertyType.Boolean, required: true, description: "Are location permissions enabled?")
        location_sensors_enabled(type: PropertyType.Boolean, required: true, description: "Are location sen")
        probable_root(type: PropertyType.Boolean, required: true, description: "Indicates if the device is probably rooted")
        emulator(type: PropertyType.Boolean, required: true, description: "if an emulator has been used")
        gps_spoofing(type: PropertyType.Boolean, required: true, description: "GPS data is being faked")
        from_official_store(type: PropertyType.Boolean, required: true, description: "if your app was downloaded from official stores")
        geocode_quality(type: PropertyType.String, required: true, description: "Indicates if a declared address was able to be successfully geocoded by Incognia.")
        address_quality(type: PropertyType.String, required: true, description: "Indicates if a declared address matches an existing address.")
        address_match(type: PropertyType.String, required: true, description: "Indicates the level of match that the declared address has with the users previous locations.")
        location_events_near_address(type: PropertyType.Numeric, required: true, description: "Amount of location events near the declared address.")
        location_events_quantity(type: PropertyType.Numeric, required: true, description: "Amount of recent location events associated with the device.")
        device_fraud_reputation(type: PropertyType.String, required: false, description: "Amount of location events near the declared address.")
        known_account(type: PropertyType.Boolean, required: false, description: "Whether we have information about this Account ID provided via Feedback API")
        request_id(type: PropertyType.String, required: false, description: "Id of the request")
        distance_to_trusted_location(type: PropertyType.Numeric, required: false, description: "Distance between the device's current location to it's past frequent locations.")
        last_location_ts(type: PropertyType.String, required: false, description: "Date and time of the last location event associated with the device.")
        sensor_match_type(type: PropertyType.String, required: false, description: "Indicates which type of matching strategy was utilized to produce a result.")
    }

    "/devices/health/location_risk/result"(platform: "/mobile", type: TrackType.App) {
        identifier(type: PropertyType.String, required: true, description: "Identifier for a particular request")
        result(type: PropertyType.Map(resultSchemaDefinitions), required:true, description: "Payload representation for answer")
    }

    "/devices/health/location_risk/permissions"(platform: "/mobile", type: TrackType.App) {
        permission_type(type: PropertyType.String, required: true, values: ["location", "location_background"], description: "Type of the permission")
        granted(type: PropertyType.Boolean, required: true, description: "Permissions were granted or not")
    }

    "/devices/health/location_risk/property_set"(platform: "/mobile", type: TrackType.App) {
        provider(type: PropertyType.String, required: true, values: ["incognia"], description: "Provider in charge of the assessments")
        property_name(type: PropertyType.String, required: true, description: "Name of the property being set")
        property_value(type: PropertyType.String, required: true, description: "Value of the property being set")
    }
}
