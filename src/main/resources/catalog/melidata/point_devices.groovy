import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1300"

    /**
    * Point devices section tracks
    */
    "/point_devices"(platform: "/", isAbstract: true) {}
 
    /**
    * Main list view
    */
    "/point_devices/list"(platform: "/", type: TrackType.View) {}

    /**
    * Actions with redirect
    */
    "/point_devices/out_of_paper"(platform: "/", type: TrackType.Event) {}
    "/point_devices/issues"(platform: "/", type: TrackType.Event) {}
    "/point_devices/change_owner"(platform: "/", type: TrackType.Event) {}
    "/point_devices/cards_promos"(platform: "/", type: TrackType.Event) {}
    "/point_devices/connect"(platform: "/", type: TrackType.Event) {}

    /**
    * Modal associate action
    */
    "/point_devices/associate"(platform: "/", isAbstract: true) {}
    "/point_devices/associate/start"(platform: "/", type: TrackType.Event) {}
    "/point_devices/associate/end"(platform: "/", type: TrackType.Event) {}

    /**
    * Modal delete action
    */
    "/point_devices/delete"(platform: "/", isAbstract: true) {}
    "/point_devices/delete/start"(platform: "/", type: TrackType.Event) {}
    "/point_devices/delete/end"(platform: "/", type: TrackType.Event) {}

    /**
    * Modal reset pin action
    */
    "/point_devices/reset_pin"(platform: "/", isAbstract: true) {}
    "/point_devices/reset_pin/start"(platform: "/", type: TrackType.Event) {}
    "/point_devices/reset_pin/end"(platform: "/", type: TrackType.Event) {}

    /**
    * Reactivate chips button action
    */
    "/point_devices/reactivate_chips"(platform: "/", isAbstract: true) {}
    "/point_devices/reactivate_chips/start"(platform: "/", type: TrackType.Event) {}
    "/point_devices/reactivate_chips/show_button"(platform: "/", type: TrackType.Event) {}
}
