package melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("MeliLive stream broadcast live") {

        "/melilive/stream/live"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "title": "Melilive",
                    "started_at"  : "2021-01-23T17:00:48Z",
                    "template_id" : "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "channel_id"  : 546789702,
                    "time_elapsed": 17291928
            ]
            products = [
                    [
                            "seller_id"      : 46772732,
                            "item_id"        : "MLA750284572",
                            "category_id"    : "MLA413229",
                            "domain_id"      : "MLA-LATEX_ENAMEL_AND_ACRYLIC_PAINTS",
                            "is_catalog_listing": false
                    ]
            ]
            viewer_info = [
                    "loyalty_level": 1,
                    "zipcode"    : "1416",
                    "muted"      : false,
                    "overlay_on" : true,
                    "orientation": "landscape"

            ]
            tracking_id = "5441d655-f5a6-420a-868b-3700c356164a"
        }
    }

    test("MeliLive stream broadcast ended") {
        "/melilive/stream/end"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "title"       : "Melilive",
                    "started_at"  : "2021-01-23T17:00:48Z",
                    "template_id" : "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "channel_id"  : 546789702
            ]
            products = [
                    [
                            "seller_id"         : 46772732,
                            "item_id"           : "MLA750284572",
                            "category_id"       : "MLA413229",
                            "domain_id"         : "MLA-LATEX_ENAMEL_AND_ACRYLIC_PAINTS",
                            "is_catalog_listing": false
                    ]
            ]
            viewer_info = [
                    "loyalty_level": 1,
                    "zipcode"      : "1416",
                    "muted"        : false,
                    "overlay_on"   : true,
                    "orientation"  : "landscape"

            ]
            tracking_id = "5441d655-f5a6-420a-868b-3700c356164a"
        }
    }

    test("MeliLive stream broadcast recorded") {
        "/melilive/stream/recorded"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "title"       : "Melilive",
                    "started_at"  : "2021-01-23T17:00:48Z",
                    "template_id" : "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "channel_id"  : 546789702
            ]
            products = [
                    [
                            "seller_id"         : 46772732,
                            "item_id"           : "MLA750284572",
                            "category_id"       : "MLA413229",
                            "domain_id"         : "MLA-LATEX_ENAMEL_AND_ACRYLIC_PAINTS",
                            "is_catalog_listing": false
                    ]
            ]
            viewer_info = [
                    "loyalty_level": 1,
                    "zipcode"      : "1416",
                    "muted"        : false,
                    "overlay_on"   : true,
                    "orientation"  : "landscape"

            ]
            tracking_id = "5441d655-f5a6-420a-868b-3700c356164a"
        }
    }

    test("MeliLive WebView") {

        "/melilive/webview"(platform: "/mobile") {
            uri = "meli://live/ede1ad69-c277-4f60-90c8-b845ca804fbe"
        }
    }

    test("Melilive Exit from stream") {

        "/melilive/stream/exit"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "title": "Melilive",
                    "status": "SCHEDULED"
            ]

            viewer_info = [
                    "loyalty_level": 1,
                    "zipcode"    : "1416",
                    "orientation": "landscape"
            ]
        }
    }

    test("Melilive PreLive") {

        "/melilive/prelive"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "title": "Melilive Stream",
                    "starts_at": "2021-01-23T17:00:48Z",
            ]
            viewer_info = [
                    "loyalty_level": 1,
                    "zipcode"    : "1416",
                    "orientation": "landscape"
            ]
        }
    }

    test("Melive Tap Group") {

        "/melilive/stream/group"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "title": "Melilive",
                    "status": "LIVE"
            ]
            group_id = "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            products = [
                [
                   "item_id" : "MLA750284572",
                   "highlighted": false
                ]
            ]
        }
    }

    test("Melilive Share Stream Link") {

        "/melilive/stream/share"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "title": "Melilive",
                    "status": "LIVE",
                    "url": "http://2ecee02e-49fc-48d7-94b0-1a19adb2a1fb"
            ]
        }
    }

    test("Melilive Bookmark Added") {

        "/melilive/stream/bookmark/add"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
            ]
            item_id = "MLA5646513"
            context = "/melilive"
        }
    }

    test("Melilive Bookmark Removed") {

        "/melilive/stream/bookmark/remove"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
            ]
            item_id = "MLA5646513"
            context = "/melilive"
        }
    }

    // ***************** CREATOR ******************

    test("Melilive Start Live From Creator") {

        "/melilive/creator/start_live"(platform: "/") {
            broadcast_id = "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            groups = [
                [
                    "group_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe",
                    "products": [
                        [
                            "item_id" : "MLA750284572",
                            "visible": true,
                            "highlighted": false,
                            "position": 0
                        ]
                    ]
                ]
            ]
        }
    }

    test("Melilive End Live From Creator") {

        "/melilive/creator/end_live"(platform: "/") {
            broadcast_id = "ede1ad69-c277-4f60-90c8-b845ca804fbe"
        }
    }

    test("Melilive Share Broadcast Link From Creator") {

        "/melilive/creator/share"(platform: "/") {
            broadcast_id = "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            url = "http://2ecee02e-49fc-48d7-94b0-1a19adb2a1fb"
        }
    }

    test("Melilive Item Event") {

        "/melilive/creator/item/event"(platform: "/") {
            event_type = "HIGHLIGHT"
            item_id = "MLA231546"
            group_id = "ede1ad69-c277-4f60-90c8-b845ca804fbe"
        }
    }

    // ***************** CHAT ******************

    test("Chat messages") {
        "/melilive/stream/chat/first_message"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            room_id = "room-v3-03"
        }

        "/melilive/stream/chat/message_error"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            room_id = "room-v3-03"
        }

        "/melilive/stream/chat/chat_scroll"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            room_id = "room-v3-03"
        }
    }

    test("Creator / Moderator chat") {
        "/melilive/creator/chat/ban"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            room_id = "room-v3-03"
        }

        "/melilive/creator/chat/moderation"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            room_id = "room-v3-03"
        }
    }
}