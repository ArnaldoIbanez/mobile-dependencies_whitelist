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

        "/pppi/notice/summary"(platform: "/") {}

        "/pppi/notice/form"(platform: "/") {}
        "/pppi/notice/form/success"(platform: "/") {}
        "/pppi/notice/form/error"(platform: "/") {}

        "/pppi/notice/error"(platform: "/") {}

    }

}
