import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    propertyDefinitions {
        packs_info(required: true, type: PropertyType.ArrayList, description: "Array of packages to deliver", inheritable:false)
        latitude(required:false, type: PropertyType.String, description:"The latitude of driver at that point", inheritable:false)
        longitude(required:false, type: PropertyType.String, description:"The longitude of driver at that point", inheritable:false)
    }

    propertyGroups {
        location(latitude, longitude)
        packsAndLocation(latitude, longitude, packs_info)
    }

    "/flex"(platform: "/mobile", isAbstract: true) {}

    "/flex/landing"(platform: "/", type: TrackType.View) {}

    "/flex/optin"(platform: "/", type: TrackType.View) {}

    "/flex/optin/congrats"(platform: "/", type: TrackType.Event) {
        view(required: true, type: PropertyType.String, description: "specific view the app returned")
    }

    "/flex/optout"(platform: "/", type: TrackType.View) {}

    "/flex/optout/congrats"(platform: "/", type: TrackType.Event) {
        view(required: true, type: PropertyType.String, description: "specific view the app returned")
        message(required: false, type: PropertyType.String, description: "user feedback")
    }

    "/flex/login/name"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/package/start"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/package/add"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/package/add/qr_detected"(platform: "/mobile", type: TrackType.Event) {
        status(required: true, type: PropertyType.String,  values: ["ok", "already_registered", "invalid_format"],
            description: "The feedback of the scan for an specific QR.")
        location
        json_data(required: false , type: PropertyType.String, description: "The data of qr when it is invalid.")
    }

    "/flex/package/add/start_delivery"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/add/view_list"(platform: "/mobile", type: TrackType.Event) {
        location
    }

    "/flex/package/add/delete_package"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
    }

    "/flex/package/add/close_list"(platform: "/mobile", type: TrackType.Event) {
        location
    }

    "/flex/package/list/loading"(platform: "/mobile", type: TrackType.View) {
        packsAndLocation
    }

    "/flex/package/list/map_too_many_packages"(platform: "/mobile", type: TrackType.View) {
        packsAndLocation
    }

    "/flex/package/list"(platform: "/mobile", type: TrackType.View) {
        delivered_packages(required: true, type: PropertyType.String,
            description: "The number of packages with delivered status",inheritable:false)
        packsAndLocation
        delivery_status(required: false, type: PropertyType.String,  values: ["ready_to_end"],
            description: "This field declares the status of the delivery, depending on each pack status", inheritable:false)
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/start_trip"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        context(required: true, type: PropertyType.String,  values: ["list", "detail"],
            description: "Indicates whether start trip action was executed in the list or detail of packages")
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/see_on_google_maps"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        context(required: true, type: PropertyType.String,  values: ["list", "map_missing_addresses","detail_map","detail_menu"],
            description: "Indicates whether start trip action was executed in the list or detail of packages")
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/add_more_packages"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/package/add_more_packages/qr_detected"(platform: "/mobile", type: TrackType.Event) {
        location
        status(required: true, type: PropertyType.String,  values: ["ok", "already_registered", "invalid_format"],
            description: "The feedback of the scan for an specific QR.")
    }

    "/flex/package/add_more_packages/add_packages"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/add_more_packages/view_list"(platform: "/mobile", type: TrackType.Event) {
        location
    }

    "/flex/package/add_more_packages/delete_package"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
    }

    "/flex/package/add_more_packages/close_list"(platform: "/mobile", type: TrackType.Event) {
        location
    }

    "/flex/package/list/map_missing_addresses"(platform: "/mobile", type: TrackType.View) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/detail"(platform: "/mobile", type: TrackType.View) {
        location
        pack_status(required: true, type: PropertyType.String,  values: ["delivered", "pending", "not_delivered"],
            description: "The current status of the package", inheritable:false)
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/retry_pack"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        context(required: true, type: PropertyType.String,  values: ["list", "detail"],
            description: "Indicates whether retry action was executed in the list or detail of packages")
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/list/end_trip"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/detail/call_buyer"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        buyer_info(required: false, description: "The receiver data")
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/detail/call_seller"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        seller_info(required: true, description: "The seller data")
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/detail/receipt"(platform: "/mobile", type: TrackType.View) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
        //Name
        //Surname
        //Doc number
    }

    "/flex/package/detail/receipt_other_person"(platform: "/mobile", type: TrackType.View) {
        location
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/finish_delivery"(platform: "/mobile", type: TrackType.View) {
        location
        pack_status(required: true, type: PropertyType.String,  values: ["delivered", "not_delivered"],
            description: "The status of the congrats page.")
        delivery_status(required: false, type: PropertyType.String,  values: ["pending","finished","finished_incomplete"],
                description: "This field declares the status of the delivery, depending on each pack status", inheritable:false)
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/start/ask_geolocation"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/package/start/ask_camera"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/package/list/cant_delete"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/package/scan/cant_add"(platform: "/mobile", type: TrackType.View) {
        location
        invalid_labels(required: true, type: PropertyType.String, description: "The labels that could not be added")
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/error/session_expired"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/error/update_app"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/error"(platform: "/mobile", type: TrackType.View) {
        location
        error_type(required: true, type: PropertyType.String,  values: ["generic", "connection"],
            description: "Specifies what kind of error happened.",inheritable:false)
    }

    "/flex/error/snackbar"(platform: "/mobile", type: TrackType.Event) {
        location
        error_type(required: true, type: PropertyType.String,  values: ["generic", "delivery_failed",
                                                                        "not_delivered_failed", "connection"],
            description: "Specifies what kind of error happened.")
    }

    "/flex/error/update_app/update_app"(platform: "/mobile", type: TrackType.Event) {
        location
    }

    "/flex/onboarding/package/add"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/onboarding/got_it"(platform: "/mobile", type: TrackType.Event) {
        location
        context(required: true, type: PropertyType.String,  values: ["add", "start_trip", "confirm_delivery"],
            description: "Indicates in which onboarding the action was executed.")
    }

    "/flex/onboarding/package/start_trip"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/onboarding/package/confirm_delivery"(platform: "/mobile", type: TrackType.View) {
        location
    }

    "/flex/package/detail/receipt/save"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/notification/open_near_pack_destination"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/notification/view_near_pack_destination"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/not_delivered_reason/selection"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
        reason_type(required: true, type: PropertyType.String, description: "The reason why the pack wasn't delivered", inheritable:false)
    }

    "/flex/package/not_delivered_reason"(platform: "/mobile", type: TrackType.View) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/not_delivered_reason/form/other_reason"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
        reason(required: false, type: PropertyType.String, description: "The driver's reason why the pack wasn't delivered", inheritable:false)
    }

    "/flex/package/not_delivered_reason/form"(platform: "/mobile", type: TrackType.View) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/detail/receipt/go_back"(platform: "/mobile", type: TrackType.View) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/package/detail/receipt/back"(platform: "/mobile", type: TrackType.Event) {
        packsAndLocation
        delivery_id(required: true, type: PropertyType.Numeric, description: "The delivery id for session created", inheritable:false)
    }

    "/flex/login/select_country"(platform: "/mobile", type: TrackType.View) {
    }
}