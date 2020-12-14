package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
tracks
{
    initiative = "1179"

    propertyDefinitions {
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
        vehicle_id(required: true, type: PropertyType.String, description: "Specifies the current vehicle id")

        container_scanned(required: true, type: PropertyType.String,
                description: "Specifies the container scanned by a driver")
        container_assigned(required: false, type: PropertyType.String,
                description: "Specifies the container assigned to a driver when routing was made")
        container_packages(required: true, type: PropertyType.Numeric,
                description: "Specifies the amount of packages in the scanned container")

        stop_order(type: PropertyType.Numeric, required: false)
    }

    propertyGroups {
        driver_info(vehicle_id, latitude, longitude)
        sorting_info(container_scanned, container_assigned, container_packages)
        delivery_info(latitude, longitude, stop_order)
    }

    def receiver_definition = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "Specifies the shipment's receiver id")
        geo_type(required: false, type: PropertyType.String,
                values: ["ROOFTOP", "RANGE_INTERPOLATED", "APPROXIMATE", "GEOMETRIC_CENTER"],
                description: "Specifies the precision of the receiver location")
        delivery_preference(required: false, type: PropertyType.String,
                values: ["residential", "business"],
                description: "Specifies the current preference for the delivery")
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
    }

    def pack_info_definition = objectSchemaDefinitions {
        sender_id(required: false, type: PropertyType.String, description: "Specifies the shipment's sender id")
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the current shipment id")
        shipment_substatus(required: false, type: PropertyType.String, description: "Specifies the shipment substatus")
        receiver_info(required: true, type: PropertyType.Map(receiver_definition), description: "Specifies the receiver info")
    }

    def route_info_definition = objectSchemaDefinitions {
        route_id(required: true, type: PropertyType.String,
                description: "Specifies the driver route's id")
        route_status(required: true, type: PropertyType.String,
                values: ["old", "pending", "finished", "ready_to_end", "empty", "return_to_station", "active", "close"],
                description: "Specifies the status of the route")
        route_type(required: true, type: PropertyType.String,
                values: ["FM", "LM"],
                description: "Specifies the type of route. Posibles values are FM for first mile routes or LM for last mile ones")
        facility_id(required: true, type: PropertyType.String, description: "Specifies the current facility id")
        vehicle_id(required: true, type: PropertyType.String, description: "Specifies the current vehicle id")
    }

//Tracks for Sorting Flow in every driver App

    "/sorting"(platform: "/mobile", isAbstract: true) {
        driver_info
    }

    "/sorting/qr_checkin"(platform: "/mobile", type: TrackType.View) {
    }

    "/sorting/disclaimer"(platform: "/mobile", type: TrackType.View) {
        container_assigned(required: false, type: PropertyType.String,
                description: "Specifies the container assigned to a driver when routing was made")
    }

    "/sorting/scanner"(platform: "/mobile", type: TrackType.View) {
        
    }

    "/sorting/scanner/fail"(platform: "/mobile", type: TrackType.View) {
        container_scanned(required: true, type: PropertyType.String,
                description: "Specifies the container scanned by a driver")
        container_status(required: true, type: PropertyType.String,
                description: "Specifies the status of container scanned by a driver")
    }

    "/sorting/scanner/assignation_modal"(platform: "/mobile", type: TrackType.View) {
        container_scanned(required: true, type: PropertyType.String,
                description: "Specifies the container scanned by a driver")
    }

    "/sorting/count_packages"(platform: "/mobile", type: TrackType.View) {
        sorting_info
    }

    "/sorting/packages_loaded"(platform: "/mobile", type: TrackType.View) {
        sorting_info
    }

    "/sorting/packages_loaded/send"(platform: "/mobile", type: TrackType.Event) {
        sorting_info
        loaded_packages(required: true, type: PropertyType.Numeric,
            description: "Specifies the loaded amount of packages the driver said")            
    }

    "/sorting/packages_loaded/attempt_fail"(platform: "/mobile", type: TrackType.View) {
        sorting_info
        loaded_packages(required: true, type: PropertyType.Numeric,
            description: "Specifies the loaded amount of packages the driver said")   
    }

    "/sorting/packages_loaded/attempt_final_fail"(platform: "/mobile", type: TrackType.View) {
        sorting_info
        loaded_packages(required: true, type: PropertyType.Numeric,
            description: "Specifies the loaded amount of packages the driver said")   
    }

    "/sorting/success"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
    }

    "/sorting/qr_checkout"(platform: "/mobile", type: TrackType.View) {
        route_id(required: true, type: PropertyType.String, description: "Specifies the current route id")
    }

//Tracks for List & Detail Flow in every driver App

    "/driver/stops"(platform: "/mobile", isAbstract: true) {
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
        packs_info(type: PropertyType.ArrayList(PropertyType.Map(pack_info_definition)), required: true)
        route_info(type: PropertyType.Map(route_info_definition), required: true)
    }

    "/driver/stops/list_view"(platform: "/mobile", type: TrackType.View) {
    }

    "/driver/stops/list_view/next_stop"(platform: "/mobile", type: TrackType.Event) {
        stop_order(required: false, type: PropertyType.Numeric, description: "Specifies the shipment delivery order", inheritable: false)
    }

    "/driver/stops/map_view"(platform: "/mobile", type: TrackType.View) {
    }

    "/driver/stops/map_view/next_stop"(platform: "/mobile", type: TrackType.Event) {
        stop_order(required: false, type: PropertyType.Numeric, description: "Specifies the shipment delivery order", inheritable: false)
    }

    "/driver/stops/next_modal"(platform: "/mobile", type: TrackType.View) {
        suggested_stop(required: true, type: PropertyType.Numeric, description: "Specifies the suggested stop number")
    }

    "/driver/stops/next_modal/going"(platform: "/mobile", type: TrackType.Event) {
        suggested_stop(required: true, type: PropertyType.Numeric, description: "Specifies the suggested stop number")
    }

    "/driver/stops/end_trip"(platform: "/mobile", type: TrackType.Event) {
    }

    "/driver/stops/add_package"(platform: "/mobile", parentPropertiesInherited:false, type: TrackType.View) {
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
        route_info(type: PropertyType.Map(route_info_definition), required: true)
    }

    "/driver/stops/add_package/qr_detected"(platform: "/mobile", parentPropertiesInherited:false, type: TrackType.Event) {
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
        route_info(type: PropertyType.Map(route_info_definition), required: true)
        qr_data(required: true, type: PropertyType.String, description: "Specifies the qr data scanned by driver")
    }

    "/driver/stops/add_package/error"(platform: "/mobile", parentPropertiesInherited:false, type: TrackType.View) {
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
        route_info(type: PropertyType.Map(route_info_definition), required: true)
        shipment_id(required: true, type: PropertyType.String, description: "Specifies the invalid shipment id")
    }

    "/driver/stops/add_package/manual_modal"(platform: "/mobile", parentPropertiesInherited:false, type: TrackType.View) {
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
        route_info(type: PropertyType.Map(route_info_definition), required: true)
    }

    "/driver/stops/add_package/manual_modal/qr_detected"(platform: "/mobile", parentPropertiesInherited:false, type: TrackType.Event) {
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
        route_info(type: PropertyType.Map(route_info_definition), required: true)
        qr_data(required: true, type: PropertyType.String, description: "Specifies the qr data scanned by driver")
    }

    "/driver/stops/toc"(platform: "/mobile", parentPropertiesInherited:false, type: TrackType.View) {
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
        route_info(type: PropertyType.Map(route_info_definition), required: true)
    }

    "/driver/stops/toc/save"(platform: "/mobile", parentPropertiesInherited:false, type: TrackType.Event) {
        latitude(required:false, type: PropertyType.String, description: "The latitude of driver at that point")
        longitude(required:false, type: PropertyType.String, description: "The longitude of driver at that point")
        route_info(type: PropertyType.Map(route_info_definition), required: true)
        problem_description(required: true, type: PropertyType.String, description: "Specifies the problem in route")
    }

    //DETAIL TRACKS

    "/driver/stops/detail"(platform: "/mobile", type: TrackType.View) {
        stop_order(required: false, type: PropertyType.Numeric, description: "Specifies the shipment delivery order", inheritable: false)
    }

    "/driver/stops/detail/call"(platform: "/mobile", type: TrackType.Event) {
        stop_order(required: false, type: PropertyType.Numeric, description: "Specifies the shipment delivery order", inheritable: false)
    }

    "/driver/stops/detail/next_stop"(platform: "/mobile", type: TrackType.Event) {
        stop_order(required: false, type: PropertyType.Numeric, description: "Specifies the shipment delivery order", inheritable: false)
    }

    "/driver/stops/detail/message"(platform: "/mobile", type: TrackType.Event) {
        stop_order(required: false, type: PropertyType.Numeric, description: "Specifies the shipment delivery order", inheritable: false)
    }

    "/driver/stops/detail/map"(platform: "/mobile", type: TrackType.Event) {
        stop_order(required: false, type: PropertyType.Numeric, description: "Specifies the shipment delivery order", inheritable: false)
    }

    "/driver/stops/detail/out_of_distance"(platform: "/mobile", type: TrackType.View) {
        stop_order(required: false, type: PropertyType.Numeric, description: "Specifies the shipment delivery order", inheritable: false)
    }

    "/driver/stops/detail/out_of_distance/error"(platform: "/mobile", type: TrackType.Event) {
        stop_order(required: false, type: PropertyType.Numeric, description: "Specifies the shipment delivery order", inheritable: false)
        error_type(required: true, type: PropertyType.String, values: ["PERMISSION_DENIED", "LOCATION_RESULT_EXCEPTION", "GOOGLE_PLAY_SERVICES_DISABLE", "MOCK_LOCATION_ENABLE"], description: "Specifies the qr data scanned by driver")

    }
/// DELIVERY FLOW TRACKS

    "/driver/delivery"(platform: "/mobile", isAbstract: true) {
        delivery_info
        packs_info(type: PropertyType.ArrayList(PropertyType.Map(pack_info_definition)), required: true)
        route_info(type: PropertyType.Map(route_info_definition), required: true)
    }

    "/driver/delivery/receipt"(platform: "/mobile", type: TrackType.View) {
    }

    "/driver/delivery/receipt/selection"(platform: "/mobile", type: TrackType.Event) {
        receiver_type(required: true, type: PropertyType.String,
                values: ["holder", "reception", "family", "neighbour"],
                description: "Describes the relationship between receiver and buyer")
    }

    "/driver/delivery/receiver_info"(platform: "/mobile", type: TrackType.View) {
        receiver_type(required: true, type: PropertyType.String,
                values: ["holder", "reception", "family", "neighbour"],
                description: "Describes the relationship between receiver and buyer")
    }

    "/driver/delivery/delivery_ok"(platform: "/mobile", type: TrackType.View) {
        receiver_type(required: true, type: PropertyType.String,
                values: ["holder", "reception", "family", "neighbour"],
                description: "Describes the relationship between receiver and buyer")
        doc_type(required: true, type: PropertyType.String,
                description: "Describes the doc type filled by receiver (but not the doc number)")
    }

    "/driver/delivery/undeliver_reason"(platform: "/mobile", type: TrackType.View) {
    }

    "/driver/delivery/undelivery_ok"(platform: "/mobile", type: TrackType.View) {
        selected_reason(required: true, type: PropertyType.String,
                description: "Describes why the driver couldn't deliver the packages")
    }
}

