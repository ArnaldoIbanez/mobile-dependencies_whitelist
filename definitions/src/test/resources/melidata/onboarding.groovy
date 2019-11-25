package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    //VIP FLOW
    test("Onboarding registration step tracking") {
        def mandatory= {
            onboarding_close_status = "DEFAULT"
            onboarding_fb_login_on = false
        }

        "/onboarding/registration_step"(platform:"/mobile", type: TrackType.View) {
            mandatory()
        }
    }

}
