import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * PayersGrowth Screen Tracks
    */

    "/payers_growth"(platform: "/mobile", isAbstract: true) {}

    // Shake It Screens
    "/payers_growth/shake_it"(platform: "/mobile", isAbstract: true) {}
    "/payers_growth/shake_it/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/payers_growth/shake_it/begin_game"(platform: "/mobile", type: TrackType.View) {}
    "/payers_growth/shake_it/game_result"(platform: "/mobile", type: TrackType.View) {
        status(required: true, type: PropertyType.String, description: "status of game")
    }
    "/payers_growth/shake_it/how_to"(platform: "/mobile", type: TrackType.View) {}
    "/payers_growth/shake_it/pending"(platform: "/mobile", type: TrackType.View) {
        status(required: true, type: PropertyType.String, description: "status of pending")
    }
    "/payers_growth/shake_it/rejected"(platform: "/mobile", type: TrackType.View) {
        status(required: true, type: PropertyType.String, description: "status of rejected")
    }
    "/payers_growth/shake_it/router"(platform: "/mobile", type: TrackType.View) {}
    "/payers_growth/shake_it/couchmark"(platform: "/mobile", type: TrackType.View) {}

    // Shake It Events
    "/payers_growth/shake_it/terms"(platform: "/mobile", type: TrackType.Event) {}
    "/payers_growth/shake_it/route"(platform: "/mobile", type: TrackType.Event) {
        status(required: true, type: PropertyType.String, description: "status of router")
    }
    "/payers_growth/shake_it/shake"(platform: "/mobile", type: TrackType.Event) {}

    //Modal Events
    "/payers_growth/modal"(platform: "/mobile", isAbstract: true) {}
    "/payers_growth/modal/cta"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Modal ID")
    }
    "/payers_growth/modal/show"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Modal ID")
    }
    "/payers_growth/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Modal ID")
    }
}
