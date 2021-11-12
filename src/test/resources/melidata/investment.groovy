package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("CDB") {
    
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

    }

    test("Suitability") {
        "/questions" (platform: "/mobile", type: TrackType.View) {}
        "/investor_profile" (platform: "/mobile", type: TrackType.View) {}

    }

}
