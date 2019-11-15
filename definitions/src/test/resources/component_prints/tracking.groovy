package src.test.resources.component_prints

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("test mercadolibre") {

        "/"(platform: "/") {}

        "/component"(platform: "/mobile/android", type: TrackType.Event) {}
        "/component"(platform: "/mobile/ios", type: TrackType.Event) {}
        "/component"(platform: "/web/desktop", type: TrackType.Event) {}
        "/component"(platform: "/web/mobile", type: TrackType.Event) {}

        "/wallet_home/print"(platform: "/mobile/android", type: TrackType.Event) {}

    }

    defaultBusiness = "mercadopago"

    test("test mercadopago") {

        "/"(platform: "/") {}

        "/component"(platform: "/mobile/android", type: TrackType.Event) {}
        "/component"(platform: "/mobile/ios", type: TrackType.Event) {}
        "/component"(platform: "/web/desktop", type: TrackType.Event) {}
        "/component"(platform: "/web/mobile", type: TrackType.Event) {}

        "/wallet_home/print"(platform: "/mobile/android", type: TrackType.Event) {}

    }

    defaultBusiness = "portalinmobiliario"

    test("test portalinmobiliario") {

        "/"(platform: "/") {}

        "/component"(platform: "/mobile/android", type: TrackType.Event) {}
        "/component"(platform: "/mobile/ios", type: TrackType.Event) {}
        "/component"(platform: "/web/desktop", type: TrackType.Event) {}
        "/component"(platform: "/web/mobile", type: TrackType.Event) {}

        "/wallet_home/print"(platform: "/mobile/android", type: TrackType.Event) {}

    }
}
