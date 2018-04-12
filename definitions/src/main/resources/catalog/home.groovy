import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    //HOME FLOW

    "/home"(platform: "/mobile") {
        retry_after_error(required: false)
    }

    "/home"(platform: "/web", type: TrackType.View) {
        from(required: false,  description: "Who is redirecting")
    }

    "/home/failure"(platform: "/mobile", type: TrackType.Event) {
          error_message(required: false)
    }

    // long_press y contextual_menu son la misma acción, se preservan por temas de compatibilidad.
    "/home/long_press"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/contextual_menu"(platform: "/mobile", type: TrackType.Event) {
        item_id()
    }

    // share y contextual_menu/share son la misma acción, se preservan por temas de compatibilidad.
    "/home/share"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/contextual_menu/share"(platform: "/mobile", type: TrackType.Event) {
        item_id()
    }

    "/home/back"(platform: "/mobile") {
    }

    "/home/pulltorefresh"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/pulltorefresh/failure"(platform: "/mobile", type:TrackType.Event) {
    }

    "/home/pulltorefresh/abort"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/scroll"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/scroll/failure"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/scroll/abort"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/abort"(platform: "/mobile") {
    }

    "/home/tap"(platform: "/mobile") {
        position(type: PropertyType.Numeric)
        section()
        tag_id()
    }

    "/home/carousel"(platform: "/mobile", isAbstract: true) {
    }

    "/home/carousel/firstTO"(platform: "/mobile") {
    }

    "/home/carousel/lastcard"(platform: "/mobile") {
    }

}  
