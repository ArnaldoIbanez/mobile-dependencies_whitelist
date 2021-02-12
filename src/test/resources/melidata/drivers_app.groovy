package melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    test("MercadoEnvios - Driver Apps - Testing Sorting") {

        def defaultLocation =
                {
                    latitude = "-36.34443"
                    longitude = "-35.34332"
                }

        def defaultDriverData =
                {
                    defaultLocation()
                    vehicle_id = "23232424"
                }

        def defaultRouteData = {
            route_info = [
                    route_id    : "323232",
                    route_status: "active",
                    facility_id : "SMX1",
                    route_type  : "LM",
                    vehicle_id  : "dyuwduw"
            ]
        }

        //Full error view page success
        "/sorting/qr_checkin"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
        }

        "/sorting/disclaimer"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
        }

        "/sorting/disclaimer"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_assigned = "A7_1"
        }

        "/sorting/scanner"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
        }

        "/sorting/scanner/fail"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_status = "open"
        }

        "/sorting/scanner/assignation_modal"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_scanned = "A8_1"
        }

        "/sorting/count_packages"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_packages = 15
        }

        "/sorting/count_packages"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_packages = 15
            container_assigned = "A7_2"
        }

        "/sorting/packages_loaded"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_packages = 15
        }

        "/sorting/packages_loaded"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_packages = 15
            container_assigned = "A7_2"
        }

        "/sorting/packages_loaded/send"(platform: "/mobile", type: TrackType.Event) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_packages = 15
            loaded_packages = 16
        }

        "/sorting/packages_loaded/send"(platform: "/mobile", type: TrackType.Event) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_packages = 15
            loaded_packages = 16
            container_assigned = "A7_2"
        }

        "/sorting/packages_loaded/attempt_fail"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_packages = 15
            loaded_packages = 16
        }

        "/sorting/packages_loaded/attempt_fail"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_packages = 15
            loaded_packages = 16
            container_assigned = "A7_2"
        }

        "/sorting/packages_loaded/attempt_final_fail"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_packages = 15
            loaded_packages = 16
        }

        "/sorting/packages_loaded/attempt_final_fail"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            container_scanned = "A8_1"
            container_packages = 15
            loaded_packages = 16
            container_assigned = "A7_2"
        }

        "/sorting/success"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            route_id = "1333"
        }

        "/sorting/qr_checkout"(platform: "/mobile", type: TrackType.View) {
            defaultDriverData()
            route_id = "1333"
        }

        "/sorting/add_package"(platform: "/mobile", type: TrackType.View) {
            defaultRouteData()
        }

        "/sorting/add_package/qr_detected"(platform: "/mobile", type: TrackType.Event) {
            defaultRouteData()
            qr_data = "un qr de paquete"
        }

        "/sorting/stops/add_package/manual_modal"(platform: "/mobile", type: TrackType.View) {
            defaultRouteData()
        }

        "/sorting/add_package/manual_modal/qr_detected"(platform: "/mobile", type: TrackType.Event) {
            defaultRouteData()
            qr_data = "un qr de paquete"
        }

        "/sorting/scanner/package_fail"(platform: "/mobile", type: TrackType.Event) {
            defaultRouteData()
            shipment_id = "123456"
        }
    }

    test("MercadoEnvíos - Driver Apps - Testing List & Detail") {

        def defaultDeliveryData = {
            route_info = [
                    route_id    : "323232",
                    route_status: "active",
                    facility_id : "SMX1",
                    route_type  : "LM",
                    vehicle_id  : "dyuwduw"
            ]
        }

        def defaultPackInfo = {
            packs_info = [
                    [
                            sender_id         : "12345",
                            shipment_id       : "1234456",
                            shipment_substatus: "test",
                            receiver_info     : [
                                    id                 : "123",
                                    geo_type           : "ROOFTOP",
                                    delivery_preference: "residential",
                                    latitude           : "-36.34443",
                                    longitude          : "-35.34332"
                            ]
                    ]
            ]
        }

        def defaultLocation =
                {
                    latitude = "-36.34443"
                    longitude = "-35.34332"
                }

        "/driver/stops/list_view"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            defaultDeliveryData()
            defaultPackInfo()
        }

        "/driver/stops/list_view/next_stop"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            stop_order = 4
            defaultLocation()
        }

        "/driver/stops/map_view"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
        }

        "/driver/stops/map_view/next_stop"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            stop_order = 4
            defaultLocation()
        }

        "/driver/stops/toc"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultLocation()
        }

        "/driver/stops/toc/save"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultLocation()
            problem_description = "vehicle_problem"
        }

        "/driver/stops/next_modal/going"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            suggested_stop = 4
            defaultLocation()
        }

        "/driver/stops/end_trip"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
        }

        "/driver/stops/add_package"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultLocation()
        }

        "/driver/stops/add_package/qr_detected"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            qr_data = "Un qr de test"
            defaultLocation()
        }

        "/driver/stops/add_package/manual_modal"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultLocation()
        }

        "/driver/stops/add_package/manual_modal/qr_detected"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            qr_data = "Un qr de test"
            defaultLocation()
        }

        "/driver/stops/add_package/error"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            shipment_id = "34433434343"
            defaultLocation()
        }

        "/driver/stops/detail"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            stop_order = 4
            defaultLocation()
        }

        "/driver/stops/detail/call"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            stop_order = 4
            defaultLocation()
        }

        "/driver/stops/detail/message"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            stop_order = 4
            defaultLocation()
        }

        "/driver/stops/detail/next_stop"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            stop_order = 4
            defaultLocation()
        }

        "/driver/stops/detail/map"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            stop_order = 4
            defaultLocation()
        }

        "/driver/stops/detail/out_of_distance"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            stop_order = 4
            defaultLocation()
        }

        "/driver/stops/detail/out_of_distance/error"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            stop_order = 4
            defaultLocation()
            error_type = "PERMISSION_DENIED"
        }
    }

    test("MercadoEnvíos - Driver Apps - Testing Delivery Flow") {
        def defaultDeliveryData = {
            route_info = [
                    route_id    : "323232",
                    route_status: "active",
                    facility_id : "SMX1",
                    route_type  : "LM",
                    vehicle_id  : "dyuwduw"
            ]
        }

        def defaultPackInfo = {
            packs_info = [
                    [
                            sender_id         : "12345",
                            shipment_id       : "1234456",
                            shipment_substatus: "test",
                            receiver_info     : [
                                    id                 : "123",
                                    geo_type           : "ROOFTOP",
                                    delivery_preference: "residential",
                                    latitude           : "-36.34443",
                                    longitude          : "-35.34332"
                            ]
                    ]
            ]
        }

        def defaultLocation = {
            latitude = "-36.34443"
            longitude = "-35.34332"
        }
        def defaultStopOrder = 3

        "/driver/delivery/receipt"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
            defaultStopOrder
        }

        "/driver/delivery/receipt/selection"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
            defaultStopOrder
            receiver_type = "reception"
        }

        "/driver/delivery/receiver_info"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
            defaultStopOrder
            receiver_type = "reception"
        }

        "/driver/delivery/delivery_ok"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
            defaultStopOrder
            receiver_type = "reception"
            doc_type = "CURP"
        }

        "/driver/delivery/undeliver_reason"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
            defaultStopOrder
        }

        "/driver/delivery/undelivery_ok"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
            defaultStopOrder
            selected_reason = "nobody_address"
        }

        "/driver/delivery/security_keyword"(platform: "/mobile", type: TrackType.View) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
            defaultStopOrder
        }

        "/driver/delivery/security_keyword/save"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
            defaultStopOrder
        }

        "/driver/delivery/security_keyword/helper"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
            defaultStopOrder
        }

        "/driver/delivery/security_keyword/not_delivery"(platform: "/mobile", type: TrackType.Event) {
            defaultDeliveryData()
            defaultPackInfo()
            defaultLocation()
            defaultStopOrder
        }
    }

    test("MercadoEnvíos - Driver Apps - Testing My account Flow") {

        def defaultLocation = {
            latitude = "-36.34443"
            longitude = "-35.34332"
        }

        "/driver/my_account/menu"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/driver/my_account/profile"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/driver/my_account/qr"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            vehicle_id = "23232424"
        }

        "/driver/my_account/logout"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/driver/my_account/logout/confirm"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
        }

    }

    test("MercadoEnvíos - Driver Apps - Testing Return to Station Flow") {

        def defaultDriverAndRouteIds = {
            driver_id = "12345678"
            route_id = "87654321"
        }

        def defaultPackagesToReturn = {
            packages_to_return = ["87263362", "21716253", "92837621"]
        }

        "/driver/return_to_station/return_to_station_disclaimer"(platform: "/mobile", type: TrackType.View) {
            defaultDriverAndRouteIds()
        }

        "/driver/return_to_station/facility_map"(platform: "/mobile", type: TrackType.Event) {
            defaultDriverAndRouteIds()
        }

        "/driver/return_to_station/enter_facility_qr"(platform: "/mobile", type: TrackType.View) {
            defaultDriverAndRouteIds()
        }

        "/driver/return_to_station/remaining_packages_disclaimer"(platform: "/mobile", type: TrackType.Event) {
            defaultDriverAndRouteIds()
            defaultPackagesToReturn()
        }

        "/driver/return_to_station/remaining_packages_modal"(platform: "/mobile", type: TrackType.View) {
            defaultDriverAndRouteIds()
            defaultPackagesToReturn()
        }

        "/driver/return_to_station/route_still_open"(platform: "/mobile", type: TrackType.Event) {
            defaultDriverAndRouteIds()
            defaultPackagesToReturn()
        }

        "/driver/return_to_station/exit_facility_qr"(platform: "/mobile", type: TrackType.View) {
            defaultDriverAndRouteIds()
        }

        "/driver/return_to_station/success"(platform: "/mobile", type: TrackType.Event) {
            defaultDriverAndRouteIds()
        }
    }
}