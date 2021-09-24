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

    test("VIP Merch SHOW ") {
        def component = {
            merch_data = {
                content_id = "a"
                component_id = "a"
                audience = "all"
                bu = "3"
                bu_line = "26"
                flow = "-1"
                logic = "campaign"
                campaign_id = "2345"
                position = 2
                print_id = "a"
            }
        }

        "/vip/merch/show"(platform: "/", component)
    }

    test("PDP Merch SHOW ") {
        def component = {
            merch_data = {
                content_id = "a"
                component_id = "a"
                audience = "all"
                bu = "3"
                bu_line = "26"
                flow = "-1"
                logic = "campaign"
                campaign_id = "2345"
                position = 2
            }
        }

        "/pdp/merch/show"(platform: "/", component)
    }
}
