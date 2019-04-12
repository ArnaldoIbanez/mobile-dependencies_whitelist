import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    /*
     * Denounces
     */

    "/denounce"(platform: "/", isAbstract: true) {}

    "/denounce/form"(platform: "/", type: TrackType.View) {}
    "/denounce/form/success"(platform: "/", type: TrackType.View) {}
    "/denounce/form/error"(platform: "/", type: TrackType.View) {}
    "/denounce/form/go_to_tool"(platform: "/", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, values: ["modal", "announcement", "message"], description: "context in which the event was triggered")
    }
    "/denounce/form/go_to_tool_landing"(platform: "/", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, values: ["modal", "announcement", "message"], description: "context in which the event was triggered")
    }

    "/denounce/error"(platform: "/", type: TrackType.View) {}

    /*
     * PPPI
     */

    "/pppi"(platform: "/", isAbstract: true) {}

    // Notice

    "/pppi/notice"(platform: "/", isAbstract: true) {}

    "/pppi/notice/summary"(platform: "/", type: TrackType.View) {}

    "/pppi/notice/form"(platform: "/", type: TrackType.View) {}
    "/pppi/notice/form/success"(platform: "/", type: TrackType.View) {}
    "/pppi/notice/form/error"(platform: "/", type: TrackType.View) {}

    // Rights

    "/pppi/rights"(platform: "/", isAbstract: true) {}

    "/pppi/rights/enroll"(platform: "/", type: TrackType.View) {}
    "/pppi/rights/enroll/success"(platform: "/", type: TrackType.View) {}
    "/pppi/rights/enroll/error"(platform: "/", type: TrackType.View) {}

    "/pppi/rights/member"(platform: "/", type: TrackType.View) {}
    "/pppi/rights/member/success"(platform: "/", type: TrackType.View) {}
    "/pppi/rights/member/error"(platform: "/", type: TrackType.View) {}

    // Landing

    "/pppi/landings"(platform: "/", isAbstract: true) {}

    "/pppi/landings/revamp"(platform: "/", type: TrackType.View) {}
    "/pppi/landings/revamp/go_to_tool"(platform: "/", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, values: ["headline", "tool"], description: "context in which the event was triggered")
    }
    "/pppi/landings/revamp/go_to_contact"(platform: "/", type: TrackType.Event) {
        context(required: true, type: PropertyType.String, values: ["tool"], description: "context in which the event was triggered")
    }

    // Support

    "/pppi/support"(platform: "/", isAbstract: true) {}

    "/pppi/support/form"(platform: "/", type: TrackType.View) {}
    "/pppi/support/form/success"(platform: "/", type: TrackType.View) {}
    "/pppi/support/form/forbidden"(platform: "/", type: TrackType.View) {}

    // Error

    "/pppi/error"(platform: "/", type: TrackType.View) {}
}
