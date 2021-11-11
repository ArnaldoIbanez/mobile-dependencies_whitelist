package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks
{
    initiative = "1047"

    "/investment_cdb"(platform: "/", isAbstract: true) {}

    //CDB tracks

    "/investment_cdb/onboarding" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/home" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/offers" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/ryc" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/congrats" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/blocker" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/detail" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/feedback" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/list" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/not_found" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/error" (platform: "/mobile", type: TrackType.View) {}
    "/investment_cdb/pre_suitability" (platform: "/mobile", type: TrackType.View) {}

    //Suitability tracks

    "/investment_suitability"(platform: "/", isAbstract: true) {}

    "/investment_suitability/questions" (platform: "/mobile", type: TrackType.View) {}
    "/investment_suitability/investor_profile" (platform: "/mobile", type: TrackType.View) {}  

}
