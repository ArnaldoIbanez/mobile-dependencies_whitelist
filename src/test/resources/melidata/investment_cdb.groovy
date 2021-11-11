package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Investment CDB") {

    
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

    test("Investment Suitability") {
        "/investment_suitability/questions" (platform: "/mobile", type: TrackType.View) {}
        "/investment_suitability/investor_profile" (platform: "/mobile", type: TrackType.View) {}

    }
    
}
