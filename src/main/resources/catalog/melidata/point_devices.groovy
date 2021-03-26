import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1046"

    /**
    * Point devices section tracks
    */
    "/point/devices"(platform: "/", isAbstract: true) {}
 
    /**
    * Main list view
    */
    "/point/devices/list"(platform: "/", type: TrackType.View) {}

    /**
    * Actions with redirect
    */
    "/point/devices/out_of_paper"(platform: "/", type: TrackType.Event) {}
    "/point/devices/issues"(platform: "/", type: TrackType.Event) {}
    "/point/devices/change_owner"(platform: "/", type: TrackType.Event) {}
    "/point/devices/cards_promos"(platform: "/", type: TrackType.Event) {}
    "/point/devices/connect"(platform: "/", type: TrackType.Event) {}

    /**
    * Modal associate action
    */
    "/point/devices/associate"(platform: "/", isAbstract: true) {}
    "/point/devices/associate/start"(platform: "/", type: TrackType.Event) {}
    "/point/devices/associate/end"(platform: "/", type: TrackType.Event) {}

    /**
    * Modal delete action
    */
    "/point/devices/delete"(platform: "/", isAbstract: true) {}
    "/point/devices/delete/start"(platform: "/", type: TrackType.Event) {}
    "/point/devices/delete/end"(platform: "/", type: TrackType.Event) {}

    /**
    * Modal reset pin action
    */
    "/point/devices/reset_pin"(platform: "/", isAbstract: true) {}
    "/point/devices/reset_pin/start"(platform: "/", type: TrackType.Event) {}
    "/point/devices/reset_pin/end"(platform: "/", type: TrackType.Event) {}
}
