package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1176'

    /**
    * PayersGrowth Screen Tracks
    */


    // Payers Growth Landings
    "/payers_growth"(platform: "/", isAbstract: true) {}
    "/payers_growth/landings"(platform: "/") {
        product (type: PropertyType.String, required: true, description: "Product name, example: 'mkt-combustibles'")
    }

    // Covid19 Marketing Performance landing 
    "/payers_growth/mkt_landing"(platform: "/web", isAbstract: true){}
    "/payers_growth/mkt_landing/codoacodo"(platform: "/web", type: TrackType.View) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/payers_growth/mkt_landing/codoacodo/sms"(platform: "/web", type: TrackType.Event) { 
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/payers_growth/mkt_landing/codoacodo/copy-clipboard"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["coupon", "steps"], description: "Indicates position of copy button")
    }
    "/payers_growth/mkt_landing/codoacodo/button"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["hero", "fixed", "footer"], description: "Indicates position of button in landing")
    }

    // Experiment landing - Ukraine Lab
    "/payers_growth/xp_landing"(platform: "/", type: TrackType.View) {
        landing_id (required: true, type: PropertyType.String, description: "Indicate landing id")
    }
    "/payers_growth/xp_landing/button"(platform: "/", type: TrackType.Event) {
        landing_id (required: true, type: PropertyType.String, description: "Indicate landing id")
        action (required: true, type: PropertyType.String, values: ["recharge_mp", "recharge_ml"], description: "Indicates button action: recharge on mp or recharge on ml")
    }

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
