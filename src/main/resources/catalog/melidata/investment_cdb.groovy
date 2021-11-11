package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks
{
    initiative = "1047"

    "/investment-cdb"(platform: "/", isAbstract: true) {}

    //CDB tracks

    "/investment-cdb/onboarding" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/home" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/offers" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/ryc" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/congrats" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/blocker" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/detail" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/feedback" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/list" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/not_found" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/error" (platform: "/mobile", type: TrackType.View) {}
    "/investment-cdb/pre_suitability" (platform: "/mobile", type: TrackType.View) {}

}
