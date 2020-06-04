import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType



tracks {

    initiative = '1125'

    // Traceability

    "/flow"(platform: "/mobile", isAbstract: true) {
        flow_name(required:true, type: PropertyType.String, description: "Flow name generated by Traceability library")
        from(required: false, type:PropertyType.String, description: "Describes the name of the module that originated this flow in Traceability library")
    }
    "/flow/end"(platform: "/mobile", type: TrackType.Event) { }
    "/flow/init"(platform: "/mobile", type: TrackType.Event) { }
        
    "/free_navigation"(platform: "/mobile", type: TrackType.Event) {
        carrier_name(required:false, type: PropertyType.String, description: "Nombre del operador de chip")
        sd_state(required:true, type: PropertyType.String, description: "Describe el tipo de conexión")
        sd_reason(required:true, type: PropertyType.String, description: "Describe el motivo del error de patrocinio")
        fg_wifi_session_time(required:true, type: PropertyType.Numeric, description: "Tiempo de sesión wifi")
        fg_cellular_session_time(required:true, type: PropertyType.Numeric, description: "tiempo de sesión 3g/4g")
        sd_data_usage(required:true, type: PropertyType.Numeric, description: "cantidad de datos utilizados")
    }
    "/free_navigation_notification"(platform: "/mobile", type: TrackType.Event) {}
    "/free_navigation_dialog"(platform: "/mobile", type: TrackType.Event) {}

    "/memory_warning"(platform: "/mobile", type: TrackType.Event) {
        view_controller(required:true, type: PropertyType.String, description: "Nombre de la View que recibió una alerta de memoria")
        application_state(required:true, type: PropertyType.String, description: "Estado de la app al momento de la alerta")
    }

    "/associate_phone"(platform: "/mobile", isAbstract: true) {
        flow(required: true, type: PropertyType.String, description: "Use case that has been executed")
        from(required: false, type: PropertyType.String, description: "Where the flow start")
    }

    "/associate_phone/sync_phone"(platform: "/mobile") {}
    "/associate_phone/verify_pin"(platform: "/mobile") {}
    "/associate_phone/synced_phone"(platform: "/mobile") {}

    "/camera"(platform: "/mobile/android", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "Where the Camera start in picture profile or person validataion in android")
    }

    "/progressive_registration"(platform: "/mobile", type: TrackType.View) {}

    "/qr_read"(platform: "/mobile", isAbstract: true) {}
    "/qr_read/store"(platform: "/mobile") {
        _label (required:true, type: PropertyType.String, description: "Operation status")
        deep_link (required:false, type: PropertyType.String, description: "Navigation info")
        qr_info (required:false, type: PropertyType.String, description: "Data read")
        additional_info (required:false, description: "Extra info")
    }

    "/shopping"(platform: "/mobile") {
        from (required:false, type: PropertyType.String, description: "Where the flow start") }

    "/sign_in"(platform: "/mobile", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/sign_in/sso"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_in/smart_lock"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }
    "/sign_in/recovery_account_button"(platform: "/mobile", type: TrackType.Event) {
        label (required:false, type: PropertyType.String, description: "Status")
    }
    "/sign_in/facebook"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }
    "/sign_in/google"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }
    "/sign_in/mail"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }

    "/sign_up"(platform: "/mobile", isAbstract: true) {
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/sign_up/facebook"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_up/google"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_up/mail"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }


}
