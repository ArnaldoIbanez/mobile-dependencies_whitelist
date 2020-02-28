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

    "/logistics/login"(platform: "/mobile", isAbstract: true) {}

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
    "/logistics/last_mile/package/scanner"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
    }
    "/logistics/last_mile/package/scanner/manual"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/package/scanner/view_list"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/package/scanner/close_list"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/package/scanner/qr_detected"(platform: "/mobile", type: TrackType.Event) {
        status(required: true, type: PropertyType.String,  values: ["ok", "already_registered", "invalid_format"], description: "The feedback of the scan for an specific QR.")
        qr_data(required: false , type: PropertyType.String, description: "The data of qr when it is invalid.")
    }
    "/logistics/last_mile/package/scanner/confirm_amount"(platform: "/mobile", type: TrackType.View) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the packages in the route", inheritable: false)
    }
    "/logistics/last_mile/list"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        route_status(required: true, type: PropertyType.String,
                values: ["old", "pending", "finished", "ready_to_end", "empty", "return_to_station"],
                description: "Specifies the status of the route", inheritable: false)
        packs_info(required: true, type: PropertyType.String, description: "Specifies the packages in the route", inheritable: false)
    }
    "/logistics/last_mile/list/pull_to_refresh"(platform: "/mobile", type: TrackType.Event) {}
    "/logistics/last_mile/list/suggest_trip"(platform: "/mobile", type: TrackType.View) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the pack that will be delivered", inheritable: false)
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the driver id", inheritable: false)
    }
    "/logistics/last_mile/list/suggest_trip/start_trip"(platform: "/mobile", type: TrackType.Event) {
        packs_info(required: true, type: PropertyType.String, description: "Specifies the pack that will be delivered", inheritable: false)
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
    }
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
    "/logistics/last_mile/congrats/final"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/congrats/ok"(platform: "/mobile", type: TrackType.View) {
        context(required: true, type: PropertyType.String, description: "Specifies if the view has been show when the driver delivers the package or when he couldn't")
        driver_id(required: true, type: PropertyType.String, description: "Specifies the ID of the driver that made the deliver")
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the ID of the shipment that was delivered")
        receiver_latitude(required: true, type: PropertyType.String, description: "Specifies the latitude of the receiver when the delivery was made")
        receiver_longitude(required: true, type: PropertyType.String, description: "Specifies the longitude of the receiver when the delivery was made")
    }
    "/logistics/last_mile/congrats/fail"(platform: "/mobile", type: TrackType.View) {
        context(required: true, type: PropertyType.String, description: "Specifies if the view has been show when the driver delivers the package or when he couldn't")
        driver_id(required: true, type: PropertyType.String, description: "Specifies the ID of the driver that made the deliver")
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the ID of the shipment that was delivered")
        receiver_latitude(required: true, type: PropertyType.String, description: "Specifies the latitude of the receiver when the delivery was made")
        receiver_longitude(required: true, type: PropertyType.String, description: "Specifies the longitude of the receiver when the delivery was made")
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
        current_distance(required: false, type: PropertyType.String, description: "Specifies the distance between the driver and the destination in meters")
        context(required: true, type: PropertyType.String, description: "Specifies if the view has been show when the driver delivers the package or when he couldn't",
                values: ["deliver", "could_not_deliver"])
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
    "/logistics/last_mile/return_to_station/packages_to_return"(platform: "/mobile", type: TrackType.View) {}
    "/logistics/last_mile/return_to_station/open_route"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        packages_to_return(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Specifies the list of pending shipment to return to the facility", inheritable: false)
    }
    "/logistics/last_mile/list/transloaded_shipments_modal"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id from where the packages will be transloaded", inheritable: false)
        packs_amount(required: true, type: PropertyType.Numeric, description: "Specifies the transloaded packages amout", inheritable: false)
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
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        target_route(required: true, type: PropertyType.String, description: "Specifies the route id from where the packages will be transloaded.")
    }
    "/logistics/last_mile/transloading_congrats/fail"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        target_route(required: true, type: PropertyType.String, description: "Specifies the route id from where the packages will be transloaded.")
    }
    "/logistics/last_mile/package/scanner/transloading_selection_modal/transload_all"(platform: "/mobile", type: TrackType.Event) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        target_route(required: true, type: PropertyType.String, description: "Specifies the route id from where the packages will be transloaded.")
    }
    "/logistics/last_mile/package/scanner/transloading_selection_modal/transload_some"(platform: "/mobile", type: TrackType.Event) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id", inheritable: false)
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        target_route(required: true, type: PropertyType.String, description: "Specifies the route id from where the packages will be transloaded.")
    }
    "/logistics/last_mile/deliver/buyer_document_form"(platform: "/mobile", type: TrackType.View) {
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
    }
    "logistics/last_mile/document_input/error"(platform: "/mobile", type: TrackType.Event) {
        driver_id(required: true, type: PropertyType.String, description: "Specifies the current driver id", inheritable: false)
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id", inheritable: false)
        error_type(required: true, type: PropertyType.String, description: "Specifies the current error type", inheritable: false, values: ["document_form", "regex"])
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
