package melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Livecommerce stream broadcast") {

        "/livecommerce/stream"(platform: "/") {
            stream = [
                    "stream_title": "Livecommerce live",
                    "template_id" : "default_template",
                    "start_at"    : "2022-01-23T17:00:00-05:00",
                    "status"      : "LIVE",
                    "channel_id"  : 12345
            ]
            products = [
                    [
                            "item_id": "MLA927887738",
                            "currency_id": "ARS",
                            "price": 1000
                    ]
            ]
        }
    }
}