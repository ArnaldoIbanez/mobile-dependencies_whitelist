import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1172"

    "/user_blocker"(platform: "/", isAbstract: true) {}

    //User Blocker views
    "/user_blocker/shield"(platform: "/", type: TrackType.View, isAbstract: true) {
        label(required: false, type: PropertyType.String, description: "the initiative flow id")
    }
    "/user_blocker/webview"(platform: "/", type: TrackType.View) {}
    "/user_blocker/redirect"(platform: "/", type: TrackType.View, isAbstract: true) {}

    //Redirect events
    "/user_blocker/redirect/load"(platform: "/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "if the load is from service or cache")
        deeplink(required: false, type: PropertyType.String, description: "in case of load from cache, the deeplink to be loaded")
    }
    "/user_blocker/redirect/skip"(platform: "/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "the cause of the skip")
        verbose(required: false, type: PropertyType.String, description: "in case of service error, the error description")
    }
    "/user_blocker/redirect/block"(platform: "/", type: TrackType.Event) {
        deeplink(required: true, type: PropertyType.String, description: "the blocker initiative deeplink")
    }
    "/user_blocker/redirect/continue"(platform: "/", type: TrackType.Event) {
        label(required: false, type: PropertyType.String, description: "if the continue is from service or cache")
        duration(required: true, type: PropertyType.String, description: "the time to continue in ms")
    }

    //Shield events
    "/user_blocker/shield/close"(platform: "/", type: TrackType.Event) {
        deeplink(required: true, type: PropertyType.String, description: "the deeplink to be launched on close action")
    }
    "/user_blocker/shield/link_action"(platform: "/", type: TrackType.Event) {
        deeplink(required: true, type: PropertyType.String, description: "the deeplink to be launched on click link action")
    }
    "/user_blocker/shield/main_action"(platform: "/", type: TrackType.Event) {
        deeplink(required: true, type: PropertyType.String, description: "the deeplink to be launched on click the main button action")
    }
    "/user_blocker/shield/secondary_action"(platform: "/", type: TrackType.Event) {
        deeplink(required: true, type: PropertyType.String, description: "the deeplink to be launched on click the main button action")
    }
    "/user_blocker/shield/skip"(platform: "/", type: TrackType.Event) {
        deeplink(required: true, type: PropertyType.String, description: "the deeplink to be launched on skip")
    }

    //Finish events
    "/user_blocker/finish"(platform: "/", type: TrackType.Event) {
        deeplink(required: true, type: PropertyType.String, description: "the redirect deeplink")
        dismiss_shield(required: false, type: PropertyType.String, description: "if an optional shield was dismissed")
        duration(required: false, type: PropertyType.String, description: "the duration in which the shield will not be shown in seconds")
    }

    //async mode events
    "/user_blocker/async_mode_load"(platform: "/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "the result of the load")
        deeplink(required: false, type: PropertyType.String, description: "the redirect deeplink")
    }
}