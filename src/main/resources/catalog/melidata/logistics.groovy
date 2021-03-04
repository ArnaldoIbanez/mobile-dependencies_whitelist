package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1179"

    def receiver_definition = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "Specifies the shipment's receiver id", inheritable: false)
        geolocation_type(required: false, type: PropertyType.String,
            values: ["ROOFTOP", "RANGE_INTERPOLATED", "APPROXIMATE", "GEOMETRIC_CENTER"],
            description: "Specifies the precision of the receiver location",
            inheritable: false)
        delivery_preference(required: false, type: PropertyType.String,
            values: ["residential", "business"],
            description: "Specifies the current preference for the delivery", inheritable: false)
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
    }

    def pack_info_definition = objectSchemaDefinitions {
        sender_id(required: false, type: PropertyType.String, description: "Specifies the shipment's sender id", inheritable: false)
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
        shipment_substatus(required: false, type: PropertyType.String, description: "Specifies the shipment substatus", inheritable: false)
        order(required: false, type: PropertyType.Numeric, description: "Specifies the shipment delivery order", inheritable: false)
        receiver_info(required: true, type: PropertyType.Map(receiver_definition), description: "Specifies the receiver info", inheritable: false)
    }

    propertyDefinitions {
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        route_status(required: true, type: PropertyType.String,
                values: ["old", "pending", "finished", "ready_to_end", "empty", "return_to_station", "active", "close"],
                description: "Specifies the status of the route", inheritable: false)
        packs_info(type: PropertyType.ArrayList(PropertyType.Map(pack_info_definition)), required: true, inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        facility_id(required: false, type: PropertyType.String, description: "Specifies the current facility id", inheritable: false)
    }

    def pickup_status = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "The id of the pickup")
        status(required: true, type: PropertyType.String, description: "The status of the pickup", values: ["pending", "cancelled", "finished"])
    }

    def geo_position_definition = objectSchemaDefinitions {
        latitude(required:true, type: PropertyType.String, description: "The latitude of the geo position")
        longitude(required:true, type: PropertyType.String, description: "The longitude of the geo position")
        geolocation_type(required: true, type: PropertyType.String,
            values: ["ROOFTOP", "RANGE_INTERPOLATED", "APPROXIMATE", "GEOMETRIC_CENTER"],
            description: "Specifies the precision of the geo position location",
            inheritable: false)
        distance(required:false, type: PropertyType.String, description: "The driver's distance in meters to the destination")
        accuracy(required:false, type: PropertyType.String, description: "The accuracy radius in meters for this geo point")
    }

    propertyGroups {
        location(latitude, longitude)
        route_info(route_id, route_status, packs_info, driver_id, facility_id, latitude, longitude)
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

    "/logistics/login"(platform: "/mobile", isAbstract: true) {}

    "/logistics/login/select_country"(platform: "/mobile", type: TrackType.View) {
        device_id(required: true, type: PropertyType.String, description: "Specifies the device's id", inheritable: false)
    }
    "/logistics/login/vehicle/start"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/login/vehicle/scanner"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/login/vehicle/scanner/vehicle_detected"(platform: "/mobile", type: TrackType.Event) {
        vehicle_id(required: false, type: PropertyType.String, description: "The id of the vehicle", inheritable: false)
        status(required: true, type: PropertyType.String, values: ["ok", "invalid_format"], description: "Specifies if the detected vehicle qr has the correct format or not", inheritable: false)
        json_data(required: false, type: PropertyType.String, description: "The data of qr vehicle", inheritable: false)
    }
    "/logistics/login/document"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/login/document/pull_to_refresh"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/login/document/vehicle_detected"(platform: "/mobile", type: TrackType.Event) {
        vehicle_id(required: false, type: PropertyType.String, description: "The id of the vehicle", inheritable: false)
        status(required: true, type: PropertyType.String, values: ["ok", "invalid_format"], description: "Specifies if the detected vehicle qr has the correct format or not", inheritable: false)
    }
    "/logistics/login/account_disabled"(platform: "/mobile", type: TrackType.View) {
        error_type(required: true, type: PropertyType.String, values: ["generic" , "driver_on_route", "vehicle_on_route", "vehicle_driver_inactive", "driver_inactive" , "vehicle_inactive"],
                description: "Specifies what kind of error happened.", inheritable: false)
    }
    "/logistics/login/error"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/login/vehicle_on_route"(platform: "/mobile", type: TrackType.View) {
        vehicle_id(required: true, type: PropertyType.String, description:"The id of the vehicle", inheritable: false)
    }
    "/logistics/login/driver_on_route"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: true, type: PropertyType.String, description: "Specifies the driver id", inheritable: false)
    }
    "/logistics/login/profile"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: false, type: PropertyType.String, description: "Specifies the driver id", inheritable: false)
    }

    "/logistics/flow_decision/start"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/package/start/ask_camera"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/package/start/ask_geolocation"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/package/start/ask_phone"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/flow_decision/scanner"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: false, type: PropertyType.String, description: "Specifies the driver id", inheritable: false)
    }
    "/logistics/flow_decision/scanner/qr_detected"(platform: "/mobile", type: TrackType.Event) {
        status(required: true, type: PropertyType.String,  values: ["ok", "already_registered", "invalid_format"], description: "The feedback of the scan for an specific QR.")
        qr_data(required: false , type: PropertyType.String, description: "The data of qr when it is invalid.")
    }
    "/logistics/flow_decision/scanner/pull_to_refresh"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/flow_decision/add_package/invalid"(platform: "/mobile", type: TrackType.View) {
        pack_id(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "Specifies the pack id that had an error", inheritable: false)
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
    "/logistics/last_mile/profile"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: false, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        route_id(required: false, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
    }
    "/logistics/profile/trainings_list"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        route_id(required: false, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        logistic_type(required: false, type: PropertyType.String, description: "Specifies the current logistic type of the driver", inheritable: false)
    }
    "/logistics/profile/trainings_list/training"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        route_id(required: false, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        training_id(required: true, type: PropertyType.String, description: "Specifies the training id for the view", inheritable: false)
        logistic_type(required: false, type: PropertyType.String, description: "Specifies the current logistic type of the driver", inheritable: false)
    }
    "/logistics/last_mile/add_package/invalid"(platform: "/mobile", type: TrackType.View) {
        pack_id(required: true, type: PropertyType.String, description: "Specifies the pack id that had an error", inheritable: false)
    }
    "/logistics/last_mile/package/scanner"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
    }
    "/logistics/last_mile/package/scanner/manual"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/package/scanner/view_list"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/package/scanner/close_list"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/sorting/bags_conciliation_disclaimer"(platform: "/mobile", type: TrackType.View) {
        bags_amount(required: true, type: PropertyType.Numeric, description: "Specifies the amount of bags loaded", inheritable: false)
        single_packs_amount(required: true, type: PropertyType.Numeric, description: "Specifies the amount of single packages loaded", inheritable: false)
        container_assignment(required: true, type: PropertyType.String, description: "Specifies the loaded container assignment", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the driver id", inheritable: false)
    }
    "/logistics/last_mile/package/scanner/qr_detected"(platform: "/mobile", type: TrackType.Event) {
        status(required: true, type: PropertyType.String,  values: ["ok", "already_registered", "invalid_format"], description: "The feedback of the scan for an specific QR.")
        qr_data(required: false , type: PropertyType.String, description: "The data of qr when it is invalid.")
    }
    "/logistics/last_mile/package/scanner/confirm_amount"(platform: "/mobile", type: TrackType.View) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the packages in the route", inheritable: false)
    }
    "/logistics/last_mile/list"(platform: "/mobile", type: TrackType.View) {
        route_info
    }
    "/logistics/last_mile/list/pull_to_refresh"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/list/suggest_trip"(platform: "/mobile", type: TrackType.View) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the pack that will be delivered", inheritable: true)
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: true)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the driver id", inheritable: true)
        latitude(required: false, description: "the latitude at which we are requesting agencies",  inheritable: true)
        longitude(required: false, description: "the longitude at which we are requesting agencies", inheritable: true)
    }
    "/logistics/last_mile/list/suggest_trip/start_trip"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/list/old_route"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        packs_amount(required: true, type: PropertyType.Numeric, description: "Specifies the amount of packages in the route", inheritable: false)
    }
    "/logistics/last_mile/list/start_trip"(platform: "/mobile", type: TrackType.Event) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the pack that will be delivered")
        route_status(required: true, type: PropertyType.String,
                values: ["old", "pending", "finished", "ready_to_end", "empty", "return_to_station"],
                description: "Specifies the status of the route", inheritable: false)
    }
    "/logistics/last_mile/list/retry_trip"(platform: "/mobile", type: TrackType.Event) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the pack that will be delivered")
        route_status(required: true, type: PropertyType.String,
                values: ["old", "pending", "finished", "ready_to_end", "empty", "return_to_station"],
                description: "Specifies the status of the route", inheritable: false)
    }
    "/logistics/last_mile/list/fraud"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/map"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        route_status(required: true, type: PropertyType.String,
                values: ["old", "pending", "finished", "ready_to_end", "empty", "return_to_station"],
                description: "Specifies the status of the route")
        packs_info(required: true, type: PropertyType.String, description: "Specifies the packages in the route")
    }
    "/logistics/last_mile/map/start_trip"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/map/retry_trip"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/congrats/final"(platform: "/mobile", type: TrackType.View) {
        route_id(required: false, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: false, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/last_mile/congrats/ok"(platform: "/mobile", type: TrackType.View) {
        context(required: false, type: PropertyType.String, description: "Specifies if the view has been show when the driver delivers the package or when he couldn't")
        driver_id(required: true, type: PropertyType.String, description: "Specifies the ID of the driver that made the deliver")
        shipment_id(required: false, type: PropertyType.String, description: "Specifies the ID of the shipment that was delivered")
        latitude(required: false, type: PropertyType.String, description: "Specifies the latitude from driver")
        longitude(required: false, type: PropertyType.String, description: "Specifies the longitude from driver")
        receiver_relationship(required: false, type: PropertyType.String, description: "Specifies the receiver relationship")
    }
    "/logistics/last_mile/congrats/fail"(platform: "/mobile", type: TrackType.View) {
        context(required: false, type: PropertyType.String, description: "Specifies if the view has been show when the driver delivers the package or when he couldn't")
        driver_id(required: true, type: PropertyType.String, description: "Specifies the ID of the driver that made the deliver")
        shipment_id(required: false, type: PropertyType.String, description: "Specifies the ID of the shipment that was delivered")
        latitude(required: false, type: PropertyType.String, description: "Specifies the latitude from driver")
        longitude(required: false, type: PropertyType.String, description: "Specifies the longitude from driver")
    }
    "/logistics/last_mile/detail"(platform: "/mobile", type: TrackType.View) {
        is_next_destination(required: true, type: PropertyType.Boolean, description: "Specifies if the detail is from the next destination shipment", inheritable: false)
    }
    "/logistics/last_mile/detail/start_trip"(platform: "/mobile", type: TrackType.View) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the pack that will be delivered")
    }
    "/logistics/last_mile/detail/retry_trip"(platform: "/mobile", type: TrackType.Event) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the pack that will be delivered")
    }
    "/logistics/last_mile/detail/distance_modal"(platform: "/mobile", type: TrackType.View) {
        distance(required: false, type: PropertyType.String, description: "Specifies the distance between the driver and the destination in meters")
        context(required: true, type: PropertyType.String, description: "Specifies if the view has been show when the driver delivers the package or when he couldn't",
                values: ["deliver", "could_not_deliver"])
        is_blocking(required: false, type: PropertyType.Boolean, description: "Specifies if the view is blocking for the user or not")
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
    }
    "/logistics/last_mile/detail/call_buyer"(platform: "/mobile", type: TrackType.Event) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the pack that will be delivered")
        buyer_id(required: true, PropertyType.String, description: "The id of the buyer")
    }
    "/logistics/last_mile/detail/see_messages"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/detail/view_map"(platform: "/mobile", type: TrackType.Event) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the pack that will be delivered")
    }
    "/logistics/last_mile/deliver/select_receiver"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
    }
    "/logistics/last_mile/deliver/receives_another"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/deliver/signature"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/could_not_deliver/sections"(platform: "/mobile", type:  TrackType.View) {}
    "/logistics/last_mile/could_not_deliver/package_problem"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/could_not_deliver/buyer_problem"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/could_not_deliver/address_problem"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/return_to_station"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        packages_to_return(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Specifies the list of pending shipment to return to the facility", inheritable: false)
    }
    "/logistics/last_mile/return_to_station/packages_to_return"(platform: "/mobile", type: TrackType.View) {
        route_id(required: false, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: false, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/last_mile/return_to_station/open_route"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        packages_to_return(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Specifies the list of pending shipment to return to the facility", inheritable: false)
    }
    "/logistics/last_mile/return_to_station/remaining_packages_disclaimer"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/last_mile/return_to_station/access_facility_qr"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/last_mile/list/transloaded_shipments_modal"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id from where the packages will be transloaded", inheritable: false)
        packs_amount(required: true, type: PropertyType.Numeric, description: "Specifies the transloaded packages amount", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        destination_route(required: true, type: PropertyType.String, description: "Specifies the route to where the packages will be transloaded.")
    }
    "/logistics/last_mile/package/scanner/transloading_selection_modal"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        target_route(required: true, type: PropertyType.String, description: "Specifies the route id from where the packages will be transloaded.")
    }
    "/logistics/last_mile/transloading_congrats/success"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        packs_amount(required: true, type: PropertyType.Numeric, description: "Specifies the transloaded packages amount", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        target_route(required: true, type: PropertyType.String, description: "Specifies the route id from where the packages will be transloaded.")
    }
    "/logistics/last_mile/transloading_congrats/fail"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        packs_amount(required: true, type: PropertyType.Numeric, description: "Specifies the transloaded packages amount", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        target_route(required: true, type: PropertyType.String, description: "Specifies the route id from where the packages will be transloaded.")
    }
    "/logistics/last_mile/transloading_congrats/success/pull_to_refresh"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/transloading_congrats/fail/pull_to_refresh"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/deliver/buyer_document_form"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
    }
    "/logistics/last_mile/deliver/buyer_document_form/save"(platform: "/mobile", type: TrackType.Event) {
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
        receiver_relationship(required: true, type: PropertyType.String, description: "Specifies the receiver relationship", inheritable: false)
    }
    "logistics/last_mile/document_input/error"(platform: "/mobile", type: TrackType.Event) {
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
        error_type(required: true, type: PropertyType.String, description: "Specifies the current error type", inheritable: false, values: ["document_form", "regex"])
    }

    "/logistics/last_mile/notification/view_near_pack_destination"(platform: "/mobile", type: TrackType.Event) {
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
        geo_position(required: true, type: PropertyType.Map(geo_position_definition), description: "Specifies the information about the destination geo point", inheritable: false)
    }
    "/logistics/end_route/authentication_qr"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/profile/authentication_qr"(platform: "/mobile", type: TrackType.View) {
        route_id(required: false, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/profile/authentication_qr/pull_to_refresh"(platform: "/mobile", type: TrackType.Event) {}

    // Scoring LM
    "/logistics/last_mile/package/security_keyword/invalid"(platform: "/mobile", type: TrackType.View) {
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
        receiver_relationship(required: true, type: PropertyType.String, description: "Specifies the receiver relationship", inheritable: false)
    }
    "/logistics/last_mile/package/security_keyword"(platform: "/mobile", type: TrackType.View) {
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
    }
    "/logistics/last_mile/package/security_keyword/save"(platform: "/mobile", type: TrackType.Event) {
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
    }
    "/logistics/last_mile/package/security_keyword/helper"(platform: "/mobile", type: TrackType.Event) {
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
    }
    "/logistics/last_mile/package/security_keyword/not_delivery"(platform: "/mobile", type: TrackType.Event) {
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id", inheritable: false)
    }

    //Control Tower LM
    "/logistics/last_mile/control_tower/incident_view"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/last_mile/control_tower/incident_selection"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        case_type_id(required: true, type: PropertyType.String, description: "Specifies the current incident case type id", inheritable: false)
    }

    //Handshake
    "/logistics/last_mile/handshake_disclaimer"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id")
        vehicle_id(required: true, type: PropertyType.Numeric, description: "Specifies the current vehicle id")
        agency_id(required: true, type: PropertyType.Numeric, description: "Specifies the current agency id")
    }
    "/logistics/last_mile/handshake_disclaimer/confirm"(platform: "/mobile", type: TrackType.Event) {
        shipments(required: true, type: PropertyType.ArrayList(PropertyType.Numeric), description: "Specifies the list of shipments id to scan", inheritable: false)
    }
    "/logistics/last_mile/handshake_disclaimer_modal"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id")
        vehicle_id(required: true, type: PropertyType.Numeric, description: "Specifies the current vehicle id")
        agency_id(required: true, type: PropertyType.Numeric, description: "Specifies the current agency id")
    }
    "/logistics/last_mile/handshake_disclaimer_modal/understand"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/handshake_warning"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id")
        vehicle_id(required: true, type: PropertyType.Numeric, description: "Specifies the current vehicle id")
        agency_id(required: true, type: PropertyType.Numeric, description: "Specifies the current agency id")
        missing_shipments(required: false, type: PropertyType.ArrayList(PropertyType.Numeric), description: "Specifies the list of missing shipments id")
    }
    "/logistics/last_mile/handshake_warning/delivery_done"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/handshake_warning/not_delivery"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/handshake_warning_modal"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id")
        vehicle_id(required: true, type: PropertyType.Numeric, description: "Specifies the current vehicle id")
        agency_id(required: true, type: PropertyType.Numeric, description: "Specifies the current agency id")
    }
    "/logistics/last_mile/handshake_warning_modal/understand"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/deliver/receives_form"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id")
        vehicle_id(required: true, type: PropertyType.Numeric, description: "Specifies the current vehicle id")
        agency_id(required: true, type: PropertyType.Numeric, description: "Specifies the current agency id")
        context(required: true, type: PropertyType.String, values: ["agency", "cart", "direct"] ,  description: "Specifies the type of deliver: agency, cart or direct")
    }
    "/logistics/last_mile/deliver/receives_form/save"(platform: "/mobile", type: TrackType.Event) {
        shipments_delivered(required: false, type: PropertyType.ArrayList(PropertyType.Numeric), description: "Specifies the list of delivered shipments id")
        shipments_not_delivered(required: false, type: PropertyType.ArrayList(PropertyType.Numeric), description: "Specifies the list of not delivered shipments id")
    }
    "/logistics/last_mile/package/not_delivered_reason"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id")
        vehicle_id(required: true, type: PropertyType.Numeric, description: "Specifies the current vehicle id")
        agency_id(required: true, type: PropertyType.Numeric, description: "Specifies the current agency id")
    }
    "/logistics/last_mile/package/not_delivered_reason/save"(platform: "/mobile", type: TrackType.Event) {
        reason(required: true, type: PropertyType.String, description: "Specifies the current agency id")
    }
    "/logistics/last_mile/handshake_missing_packages_modal"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id")
        vehicle_id(required: true, type: PropertyType.Numeric, description: "Specifies the current vehicle id")
        agency_id(required: true, type: PropertyType.Numeric, description: "Specifies the current agency id")
        missing_shipments(required: false, type: PropertyType.ArrayList(PropertyType.Numeric), description: "Specifies the list of missing shipments id", inheritable: false)
    }
    "/logistics/last_mile/handshake_missing_packages_modal/understand"(platform: "/mobile", type: TrackType.Event) {}

    // First Mile
    "/logistics/first_mile/list"(platform: "/mobile", type: TrackType.View) {
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        pickups_status(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Specifies the diferent status in all the pickups", inheritable: false)
    }
    "/logistics/first_mile/list/pull_to_refresh"(platform: "/mobile", type: TrackType.Event) {
    }
    "/logistics/first_mile/scanner"(platform: "/mobile", type: TrackType.View) {
        location
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/first_mile/scanner/pull_to_refresh"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/first_mile/scanner/modal_invalid_packages"(platform: "/mobile", type: TrackType.View) {
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id")
        packages(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Specifies the invalid ids received")
    }

    "/logistics/first_mile/scanner/modal_back"(platform: "/mobile", type: TrackType.View) {
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
        packs_amount(required: false, type: PropertyType.Numeric, description: "Specifies the amount of packages that " +
                "were scanned at the moment that the view was shown")
    }
    "/logistics/first_mile/scanner/modal_back/back"(platform: "/mobile", type: TrackType.Event) {
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
    }
    "/logistics/first_mile/scanner/modal_back/cancel"(platform: "/mobile", type: TrackType.Event) {
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
    }
    "/logistics/first_mile/scanner/modal_keyboard_input/open"(platform: "/mobile", type: TrackType.Event) {
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id")
    }
    "/logistics/first_mile/scanner/modal_invalid_package_quantity"(platform: "/mobile", type: TrackType.View) {
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id")
        pickup_point_id(required: true, type: PropertyType.String, description: "Specifies the current pickup point id")
        picked_count(required: true, type: PropertyType.Numeric, description: "Specifies the package amount that was picked up")
        estimated_count(required: true, type: PropertyType.Numeric, description: "Specifies the package amount that was expected to pick up")
    }
    "/logistics/first_mile/pickup/seller_document_form"(platform: "/mobile", type: TrackType.View) {
        location
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        packages(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Specifies the packages being picked up")
    }
    "/logistics/first_mile/pickup/partial"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: true)
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id", inheritable: true)
        pickup_point_id(required: true, type: PropertyType.String, description: "Specifies the current pickup point id", inheritable: true)
    }
    "/logistics/first_mile/pickup/partial/full_vehicle"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/first_mile/pickup/partial/all_picked"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/first_mile/pickup/seller_document_form/pull_to_refresh"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/first_mile/pickup/seller_document_form/view_list"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/first_mile/pickup/signature"(platform: "/mobile", type: TrackType.View) {
        location
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        packages(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Specifies the packages being picked up")
    }
    "/logistics/first_mile/profile"(platform: "/mobile", type: TrackType.View) {
        first_mile_logistic_type(required:false, type: PropertyType.String, values: ["XD", "FF"], description: "Identifies whether it is a fulfillment or a cross-docking pickup for first mile")
    }
    "/logistics/first_mile/scanner/view_list"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/first_mile/scanner/close_list"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/scanner/driver_affinity_modal/continue"(platform: "/mobile", type: TrackType.Event){
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/last_mile/scanner/driver_affinity_modal/cancel"(platform: "/mobile", type: TrackType.Event){
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/last_mile/scanner/driver_affinity_modal"(platform: "/mobile", type: TrackType.View){
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id", inheritable: false)
    }
    "/logistics/last_mile/poll"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: true, type: PropertyType.Numeric, description: "Specifies the current driver id", inheritable: true)
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: true)
    }
    "/logistics/last_mile/poll/modal"(platform: "/mobile", type: TrackType.View) {}
}
