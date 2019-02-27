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
    "/denounce/form/tool_migration_app"(platform: "/", type: TrackType.Event) {
        context(required: false, type: PropertyType.String, description: "context in which the event was triggered")
    }
    "/denounce/form/tool_migration_landing"(platform: "/", type: TrackType.Event) {
        context(required: false, type: PropertyType.String, description: "context in which the event was triggered")
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
    "/pppi/landings/revamp/app"(platform: "/", type: TrackType.Event) {
        context(required: false, type: PropertyType.String, description: "context in which the event was triggered")
    }
    "/pppi/landings/revamp/contact"(platform: "/", type: TrackType.Event) {
        context(required: false, type: PropertyType.String, description: "context in which the event was triggered")
    }

    // Error

    "/pppi/error"(platform: "/", type: TrackType.View) {}
}
