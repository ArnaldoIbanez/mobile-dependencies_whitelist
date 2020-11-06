package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
tracks
{
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
    }

    propertyGroups {
        driver_info(vehicle_id, latitude, longitude)
        sorting_info(container_scanned, container_assigned, container_packages)
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
}

