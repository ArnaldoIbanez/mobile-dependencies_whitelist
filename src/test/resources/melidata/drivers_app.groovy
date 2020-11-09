package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    def defaultLocation =
            {
                latitude = "-36.34443"
                longitude = "-35.34332"
            }

    test("Testing Sorting") {

        def defaultDriverData =
                {
                    defaultLocation()
                    vehicle_id = "23232424"
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
    }
}