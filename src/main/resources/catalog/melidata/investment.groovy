package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks
{
    initiative = "1047"

    "/asset_management/investment"(platform: "/", isAbstract: true) {}

    //CDB tracks

    "/asset_management/investment/cdb"(platform: "/", isAbstract: true) {} 

    "/asset_management/investment/cdb/onboarding" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/home" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/offers" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/ryc" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/congrats" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/blocker" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/detail" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/feedback" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/list" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/not_found" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/error" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/cdb/pre_suitability" (platform: "/mobile", type: TrackType.View) {}

    //Suitability tracks

    "/asset_management/investment/suitability"(platform: "/", isAbstract: true) {}

    "/asset_management/investment/suitability/questions" (platform: "/mobile", type: TrackType.View) {}
    "/asset_management/investment/suitability/investor_profile" (platform: "/mobile", type: TrackType.View) {}  

}
