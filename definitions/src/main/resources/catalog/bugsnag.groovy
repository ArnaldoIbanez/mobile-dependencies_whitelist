import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType

tracks {

    "/mobile" (platform: "/mobile", isAbstract: true){}
    "/mobile/bugsnag"(platform: "/mobile", type: TrackType.Event) {
        error_type               (required:false, type: PropertyType.String, description: "Track of Bugsnag error: error type")
        error_context            (required:true,  type: PropertyType.String, description: "Bugsnag context, the best important field on Canejo")
        error_severity           (required:false, type: PropertyType.String, description: "error or warning or info")
        url_error                (required:false, type: PropertyType.String, description: "url error")
        error_mach_exception_name(required:false, type: PropertyType.String, description: "error mach exception name")
        error_address            (required:false, type: PropertyType.String, description: "error address")
        error_message            (required:false, type: PropertyType.String, description: "error message")
        error_Id                 (required:false, type: PropertyType.String, description: "error id")
        error_timestamp          (required:false, type: PropertyType.String, description: "error timestamp")
        error_exception_class    (required:false, type: PropertyType.String, description: "error exception class")
        release_stage            (required:false, type: PropertyType.String, description: "error stage, eg. production")
        error_signal_name        (required:false, type: PropertyType.String, description: "error signal name")
        error_nsexception        (required:false, type: PropertyType.String, description: "error nsException")
    }
}
