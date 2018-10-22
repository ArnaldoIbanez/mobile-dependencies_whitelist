import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Denounce tracking") {

        "/denounce/form"(platform: "/") {}
        "/denounce/form/success"(platform: "/") {}
        "/denounce/form/error"(platform: "/") {}

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

        "/pppi/error"(platform: "/") {}

    }

}
