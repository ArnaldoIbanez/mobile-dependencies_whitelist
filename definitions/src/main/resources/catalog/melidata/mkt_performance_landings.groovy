import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * Marketing performance landings Screen Tracks
    */
    // Web
    "/mkt_performance_landing"(platform: "/", isAbstract: true) {}

    // Recharge Landing
    "/mkt_performance_landing/recharge"(platform: "/web", type: TrackType.View) {}
    "/mkt_performance_landing/recharge/sms"(platform: "/web", type: TrackType.Event) {}
    "/mkt_performance_landing/recharge/copy-clipboard"(platform: "/web", type: TrackType.Event) {
        position (require: true, type: PropertyType.string, values: ["coupon", "steps"], description: "Indicates position of copy button")
    }
    "/mkt_performance_landing/recharge/button"(platform: "/", type: TrackType.Event) {
        position (require: true, type: PropertyType.string, values: ["hero", "fixed", "footer"], description: "Indicates position of button in landing")
    }

    // Transport Landing
    "/mkt_performance_landing/transport"(platform: "/web", type: TrackType.View) {}
    "/mkt_performance_landing/transport/sms"(platform: "/web", type: TrackType.Event) {}
    "/mkt_performance_landing/transport/copy-clipboard"(platform: "/web", type: TrackType.Event) {
        position (require: true, type: PropertyType.string, values: ["coupon", "steps"], description: "Indicates position of copy button")
    }
    "/mkt_performance_landing/transport/button"(platform: "/web", type: TrackType.Event) {
        position (require: true, type: PropertyType.string, values: ["hero", "fixed", "footer"], description: "Indicates position of button in landing")
    }
}
