package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks
{
    initiative = "1047"

    "/asset_management/investment"(platform: "/", isAbstract: true) {}

    //CDB tracks

    "/cdb"(platform: "/", isAbstract: true) {} 

    "/onboarding" (platform: "/mobile", type: TrackType.View) {}
    "/home" (platform: "/mobile", type: TrackType.View) {}
    "/offers" (platform: "/mobile", type: TrackType.View) {}
    "/ryc" (platform: "/mobile", type: TrackType.View) {}
    "/congrats" (platform: "/mobile", type: TrackType.View) {}
    "/blocker" (platform: "/mobile", type: TrackType.View) {}
    "/detail" (platform: "/mobile", type: TrackType.View) {}
    "/feedback" (platform: "/mobile", type: TrackType.View) {}
    "/list" (platform: "/mobile", type: TrackType.View) {}
    "/not_found" (platform: "/mobile", type: TrackType.View) {}
    "/error" (platform: "/mobile", type: TrackType.View) {}
    "/pre_suitability" (platform: "/mobile", type: TrackType.View) {}

    //Suitability tracks

    "/suitability"(platform: "/", isAbstract: true) {}

    "/questions" (platform: "/mobile", type: TrackType.View) {}
    "/investor_profile" (platform: "/mobile", type: TrackType.View) {}  

}
