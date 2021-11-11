package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Investment CDB") {

    
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

    }

    test("Investment Suitability") {
        "/investment_suitability/questions" (platform: "/mobile", type: TrackType.View) {}
        "/investment_suitability/investor_profile" (platform: "/mobile", type: TrackType.View) {}

    }

}
