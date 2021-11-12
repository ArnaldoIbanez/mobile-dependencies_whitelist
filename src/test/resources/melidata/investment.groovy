package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("CDB") {
    
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

    }

    test("Suitability") {
        "/asset_management/investment/suitability/questions" (platform: "/mobile", type: TrackType.View) {}
        "/asset_management/investment/suitability/investor_profile" (platform: "/mobile", type: TrackType.View) {}  

    }

}
