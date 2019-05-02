package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Denounce tracking") {

        "/denounce/form"(platform: "/") {}
        "/denounce/form/success"(platform: "/") {}
        "/denounce/form/error"(platform: "/") {}
        "/denounce/form/go_to_tool"(platform: "/") {
            context = "modal"
        }
        "/denounce/form/go_to_tool_landing"(platform: "/") {
            context = "announcement"
        }

        "/denounce/error"(platform: "/") {}

    }

    test("PPPI tracking") {

        // Notice

        "/pppi/notice/summary"(platform: "/") {}

        "/pppi/notice/form"(platform: "/") {}
        "/pppi/notice/form/success"(platform: "/") {}
        "/pppi/notice/form/error"(platform: "/") {}

        // Rights

        "/pppi/rights/enroll"(platform: "/") {}
        "/pppi/rights/enroll/success"(platform: "/") {}
        "/pppi/rights/enroll/error"(platform: "/") {}

        "/pppi/rights/member"(platform: "/") {}
        "/pppi/rights/member/success"(platform: "/") {}
        "/pppi/rights/member/error"(platform: "/") {}

        // Landing

        "/pppi/landings"(platform: "/") {}

        "/pppi/landings/revamp"(platform: "/") {}
        "/pppi/landings/revamp/go_to_tool"(platform: "/") {
            context = "headline"
        }
        "/pppi/landings/revamp/go_to_contact"(platform: "/") {
            context = "tool"
        }

        // Support

        "/pppi/support"(platform: "/") {}

        "/pppi/support/form"(platform: "/") {}
        "/pppi/support/form/success"(platform: "/") {}
        "/pppi/support/form/forbidden"(platform: "/") {}

        // Error

        "/pppi/error"(platform: "/") {}

    }

}
