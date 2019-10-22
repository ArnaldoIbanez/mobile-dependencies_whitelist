package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Bugsnag tracks to use on Canejo ML") {
        "/mobile/bugsnag"(platform:"/mobile/ios", type:TrackType.Event) {
            error_type = "signal"
            error_context = "withdraw"
            error_severity = "error"
            url_error = "<none>"
            error_mach_exception_name = "<none>"
            error_address = "4402117060"
            error_message = ""
            error_Id = "5aa6bcd0c098f300193384fb"
            error_timestamp = "2018-04-18T14:18:09.301Z"
            error_exception_class = "SIGTRAP"
            release_stage = "production"
            error_signal_name = "SIGTRAP"
            error_nsexception = "<none>"
        }
    }

    test("Bugsnag tracks to use on Canejo MP") {
        "/mobile/bugsnag"(platform:"/mobile/android", type:TrackType.Event, business: "mercadopago") {
            error_type = "signal"
            error_context = "withdraw"
            error_severity = "error"
            url_error = "<none>"
            error_mach_exception_name = "<none>"
            error_address = "4402117060"
            error_message = ""
            error_Id = "5aa6bcd0c098f300193384fb"
            error_timestamp = "2018-04-18T14:18:09.301Z"
            error_exception_class = "SIGTRAP"
            release_stage = "production"
            error_signal_name = "SIGTRAP"
            error_nsexception = "<none>"
        }
    }
}
