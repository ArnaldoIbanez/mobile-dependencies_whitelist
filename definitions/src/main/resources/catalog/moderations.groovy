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

    "/pppi/notice/error"(platform: "/", type: TrackType.View) {}

    // Rights

    "/pppi/rights"(platform: "/", isAbstract: true) {}

    "/pppi/rights/enroll"(platform: "/", type: TrackType.View) {}
    "/pppi/rights/enroll/properties"(platform: "/", type: TrackType.View) {}
    "/pppi/rights/enroll/success"(platform: "/", type: TrackType.View) {}
    "/pppi/rights/enroll/error"(platform: "/", type: TrackType.View) {}

    "/pppi/rights/member"(platform: "/", isAbstract: true) {}

    "/pppi/rights/member/properties"(platform: "/", type: TrackType.View) {}
    "/pppi/rights/member/success"(platform: "/", type: TrackType.View) {}
    "/pppi/rights/member/error"(platform: "/", type: TrackType.View) {}

    "/pppi/rights/error"(platform: "/", type: TrackType.View) {}

}
