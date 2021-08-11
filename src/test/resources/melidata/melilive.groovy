package melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("MeliLive stream broadcast") {

        "/melilive/stream"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "started_at"  : "2021-01-23T17:00:48Z",
                    "status"      : "LIVE",
                    "template_id" : "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "channel_id"  : 546789702,
                    "time_elapsed": 17291928
            ]
            products = [
                    [
                            "seller_id"      : 46772732,
                            "free_shipping"  : true,
                            "price"          : 4998.87,
                            "original_price" : 5554.3,
                            "discount"       : 10,
                            "currency_id"    : "ARS",
                            "item_id"        : "MLA750284572",
                            "category_id"    : "MLA413229",
                            "domain_id"      : "MLA-LATEX_ENAMEL_AND_ACRYLIC_PAINTS",
                            "catalog_listing": false
                    ]
            ]
            viewer_info = [
                    "zipcode"    : "1416",
                    "muted"      : false,
                    "overlay_on" : true,
                    "orientation": "landscape"

            ]
            tracking_id = "5441d655-f5a6-420a-868b-3700c356164a"
        }
    }
}