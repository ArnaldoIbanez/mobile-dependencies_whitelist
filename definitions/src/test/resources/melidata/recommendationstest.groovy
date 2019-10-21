package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Recommendations Track Combo") {
        "/recommendations/view"(platform: "/") {
            recommendations = [
                hidden_by_client : false,
                client : "vip_combo",
                has_errors : false,
                recommendation_id : "a8c57607-5664-4a70-9f76-eda5094b46a7",
                backend_id : "mp2v-combos-multiseller-v5-without-promise",
                track_info : [
                    "has_recommendations"        : true,
                    "backend_id"                 : "prod-mla.recommendations-combo-api",
                    "model_id"                   : "mp2v-combos-multiseller-v5-without-promise",
                    "model_version"              : "v5",
                    "multiget"                   : false,
                    "recommendation_source"      : "cache",
                    "combo_type"                 : "not_certified",
                    "trigger"                    : [
                        "trigger_type": "item",
                        "item_info"   : [
                            "id"                       : "MLA697071766",
                            "site_id"                  : "MLA",
                            "price"                    : 483.99,
                            "free_shipping"            : false,
                            "category_id"              : "MLA5337",
                            "currency_id"              : "ARS",
                            "seller"                   : 154361388,
                            "logistic_type"            : "cross_docking",
                            "title"                    : "Funda Samsung 360 Protege El 100%  + Vidrio Templado O Nano",
                            "status"                   : "active",
                            "tags"                     : [
                                "brand_verified",
                                "good_quality_picture",
                                "good_quality_thumbnail",
                                "loyalty_discount_eligible",
                                "immediate_payment",
                                "cart_eligible"
                            ],
                            "category_path"            : "MLA1051/MLA3502/MLA432437/MLA5337",
                            "price_usd"                : 12,
                            "with_forbidden_variations": true,
                            "has_only_one_variation"   : false,
                            "domain_id"                : "MLA-CELLPHONE_COVERS"
                        ]
                    ],
                    "combo_free_shipping"        : true,
                    "combo_total_shipping_cost"  : 0,
                    "combo_shipping_save"        : 174.99,
                    "combo_shipping_promise_type": "free",
                    "combo_direct_checkout"      : false,
                    "combo_shipping_save_enabled": false,
                    "recommended_items"          : [
                        [
                            "id": "MLA697071766"
                        ],
                        [
                            "id": "MLA697100672"
                        ]
                    ]
                ]
            ]
        }
    }

    test("Recommendations Track carrousel") {
        "/recommendations/view"(platform: "/") {
            recommendations = [
                recommendation_id : "fa9c9ae3-609e-4d75-8db2-1f335ca7cb47",
                backend_id : "machinalis-seller-items",
                client : "vip-seller_items-above",
                track_info : [
                    "model_id": "machinalis-sellers-baseline",
                    "model_version": "0.0.2+120be36",
                    "train_date": "2019-07-03T03:26:47.919492",
                    "backend_id": "api.mercadolibre.com",
                    "has_recommendations": true,
                    "recommended_items": [
                        [
                            "id": "MLB983708212"
                        ],
                        [
                            "id": "MLB983714368"
                        ]
                    ],
                    "trigger": [
                        "trigger_type": "item",
                        "item_info": [
                            "id": "MLB983714335",
                            "category_id": "MLB235597"
                        ]
                    ]
                ]
            ]
        }
    }

    test("Recommendations click see more tracks") {
        "/recommendations/see_more"(platform: "/", type: TrackType.Event) {
            recommendations = [
                backend_id : "prod.recommendations-algorithm-product",
                client : "pdp_similar",
                track_info : [
                        has_recommendations: true,
                        model_id : "p2p-p2i-dmm-mp2v-no-live-request",
                        model_version : "v8",
                        backend_id : "prod.recommendations-algorithm-product",
                ]
            ]
        }
    }

    test("Recommendations view") {
        "/recommendations/view"(platform: "/") {
            recommendations = [
                backend_id : "prod.recommendations-algorithm-product",
                client : "pdp_similar",
                track_info : [
                        has_recommendations: true,
                        model_id : "p2p-p2i-dmm-mp2v-no-live-request",
                        model_version : "v8",
                        backend_id : "prod.recommendations-algorithm-product",
                ]
            ]
        }
    }

    test ("Recommendations carousel react full track") {
        "/recommendations/view"(platform: "/") {
            recommendations = [
                "recommendation_id": "0ed06a83-6e89-4938-9dc1-655214a452d0",
                "backend_id": "machinalis-pads",
                "client": "vip-pads",
                "track_info": [
                        "model_id": "machinalis-gauss",
                        "model_version": "0.0.2+120be36",
                        "train_date": "2019-07-03T06:39:34.579349",
                        "backend_id": "RECOMMENDATIONS_BASE",
                        "has_recommendations": true,
                        "recommended_items": [
                                [
                                        "id": "MLB983708212"
                                ],
                                [
                                        "id": "MLB983714368"
                                ],
                                [
                                        "id": "MLB1051426363"
                                ],
                                [
                                        "id": "MLB983708226"
                                ],
                                [
                                        "id": "MLB983704729"
                                ],
                                [
                                        "id": "MLB1051419460"
                                ],
                                [
                                        "id": "MLB1051426635"
                                ],
                                [
                                        "id": "MLB1209249079"
                                ],
                                [
                                        "id": "MLB1237673780"
                                ],
                                [
                                        "id": "MLB1051422830"
                                ],
                                [
                                        "id": "MLB1051426364"
                                ],
                                [
                                        "id": "MLB1153265529"
                                ],
                                [
                                        "id": "MLB1209245846"
                                ],
                                [
                                        "id": "MLB1051419229"
                                ],
                                [
                                        "id": "MLB1209248999"
                                ],
                                [
                                        "id": "MLB1209249140"
                                ],
                                [
                                        "id": "MLB1241662886"
                                ],
                                [
                                        "id": "MLB1051419239"
                                ],
                                [
                                        "id": "MLB1209249002"
                                ],
                                [
                                        "id": "MLB805906195"
                                ],
                                [
                                        "id": "MLB983710423"
                                ],
                                [
                                        "id": "MLB1051423061"
                                ],
                                [
                                        "id": "MLB1144130161"
                                ],
                                [
                                        "id": "MLB1220708324"
                                ],
                                [
                                        "id": "MLB1257890805"
                                ]
                        ],
                        "trigger": [
                                "trigger_type": "item",
                                "item_info": [
                                        "id": "MLB983714335",
                                        "category_id": "MLB235597"
                                ]
                        ]
                ],
                "has_errors": false,
                "hidden_by_client": false
            ]
        }
    }

    test ("Recommendations carousel react full track view") {
        "/recommendations/view"(platform: "/") {
            recommendations = [
                    "recommendation_id": "4675a3bf-446d-438d-86e7-85e7068a31f8",
                    "backend_id": "machinalis-pads",
                    "client": "vip-pads",
                    "track_info": [
                            "model_id": "machinalis-gauss",
                            "model_version": "0.0.2+120be36",
                            "train_date": "2019-07-04T10:25:34.710269",
                            "backend_id": "RECOMMENDATIONS_BASE",
                            "has_recommendations": true,
                            "recommended_items": [
                                    [
                                            "id": "MLB983708212"
                                    ],
                                    [
                                            "id": "MLB983714368"
                                    ],
                                    [
                                            "id": "MLB1051426363"
                                    ],
                                    [
                                            "id": "MLB983708226"
                                    ],
                                    [
                                            "id": "MLB983704729"
                                    ],
                                    [
                                            "id": "MLB1051419460"
                                    ],
                                    [
                                            "id": "MLB1051426635"
                                    ],
                                    [
                                            "id": "MLB1209249079"
                                    ],
                                    [
                                            "id": "MLB1237673780"
                                    ],
                                    [
                                            "id": "MLB1051422830"
                                    ],
                                    [
                                            "id": "MLB1051426364"
                                    ],
                                    [
                                            "id": "MLB1153265529"
                                    ],
                                    [
                                            "id": "MLB1209245846"
                                    ],
                                    [
                                            "id": "MLB1051419229"
                                    ],
                                    [
                                            "id": "MLB1209248999"
                                    ],
                                    [
                                            "id": "MLB1209249140"
                                    ],
                                    [
                                            "id": "MLB1051419239"
                                    ],
                                    [
                                            "id": "MLB1209249002"
                                    ],
                                    [
                                            "id": "MLB983710423"
                                    ],
                                    [
                                            "id": "MLB1051423061"
                                    ],
                                    [
                                            "id": "MLB1144130161"
                                    ],
                                    [
                                            "id": "MLB1220708324"
                                    ],
                                    [
                                            "id": "MLB1261889003"
                                    ],
                                    [
                                            "id": "MLB1090535424"
                                    ],
                                    [
                                            "id": "MLB904420271"
                                    ]
                            ],
                            "trigger": [
                                    "trigger_type": "item",
                                    "item_info": [
                                            "id": "MLB983714335",
                                            "category_id": "MLB235597"
                                    ]
                            ]
                    ],
                    "has_errors": false,
                    "hidden_by_client": false
            ]
        }
    }

    test ("Recommendations carousel react motors") {
        "/recommendations/print"(platform: "/") {
            recommendations = [
                    "recommendation_id": "5a7e084f-2e68-466a-b1c0-d55c6bb4ed1f",
                    "backend_id": "triggered_motors_recommendations",
                    "client": "classi-motors-vip",
                    "track_info": [
                            "has_recommendations": true,
                            "has_errors": false,
                            "trigger": [
                                    "trigger_type": "items",
                                    "items_info": [
                                            "mla793413013": [
                                                    "id": "MLA793413013"
                                            ]
                                    ]
                            ],
                            "backend_id": "fury_recommendations-functions-api",
                            "model_id": "reco-autos-item-item",
                            "version_id": "1",
                            "recommendation_backend_name": "triggered_motors_recommendations",
                            "function": "triggered_motors_recommendations",
                            "user_id": 443337530,
                            "recommendation_client_id": "classi-motors-vip",
                            "config_type": "MAPPED",
                            "recommended_items": [
                                    [
                                            "id": "MLA785585689"
                                    ],
                                    [
                                            "id": "MLA786319497"
                                    ],
                                    [
                                            "id": "MLA796689600"
                                    ],
                                    [
                                            "id": "MLA787388076"
                                    ],
                                    [
                                            "id": "MLA795578380"
                                    ],
                                    [
                                            "id": "MLA786454779"
                                    ],
                                    [
                                            "id": "MLA765411667"
                                    ],
                                    [
                                            "id": "MLA794981387"
                                    ],
                                    [
                                            "id": "MLA791441094"
                                    ],
                                    [
                                            "id": "MLA788409691"
                                    ]
                            ]
                    ],
                    "has_errors": false,
                    "hidden_by_client": false
            ]
        }
        "/recommendations/view"(platform: "/") {
            recommendations = [
                    "recommendation_id": "5a7e084f-2e68-466a-b1c0-d55c6bb4ed1f",
                    "backend_id": "triggered_motors_recommendations",
                    "client": "classi-motors-vip",
                    "track_info": [
                            "has_recommendations": true,
                            "has_errors": false,
                            "trigger": [
                                    "trigger_type": "items",
                                    "items_info": [
                                            "mla793413013": [
                                                    "id": "MLA793413013"
                                            ]
                                    ]
                            ],
                            "backend_id": "fury_recommendations-functions-api",
                            "model_id": "reco-autos-item-item",
                            "version_id": "1",
                            "recommendation_backend_name": "triggered_motors_recommendations",
                            "function": "triggered_motors_recommendations",
                            "user_id": 443337530,
                            "recommendation_client_id": "classi-motors-vip",
                            "config_type": "MAPPED",
                            "recommended_items": [
                                    [
                                            "id": "MLA785585689"
                                    ],
                                    [
                                            "id": "MLA786319497"
                                    ],
                                    [
                                            "id": "MLA796689600"
                                    ],
                                    [
                                            "id": "MLA787388076"
                                    ],
                                    [
                                            "id": "MLA795578380"
                                    ],
                                    [
                                            "id": "MLA786454779"
                                    ],
                                    [
                                            "id": "MLA765411667"
                                    ],
                                    [
                                            "id": "MLA794981387"
                                    ],
                                    [
                                            "id": "MLA791441094"
                                    ],
                                    [
                                            "id": "MLA788409691"
                                    ]
                            ]
                    ],
                    "has_errors": false,
                    "hidden_by_client": false
            ]
        }
    }

    test("Recommendations add to cart tracks") {
        "/recommendations/add_to_cart"(platform: "/web/desktop", type: TrackType.Event) {
            backend_id = "l3_l7-ngrams"
            client = "vip_combo"
            direct = true
            items = ["MLB754486062" , "MLB512313"]
            recommendation_id = "4ifmk4-moprk-mfov0-mroas"
            shipping_benefit = "free"

        }
        "/recommendations/add_to_cart"(platform: "/web/mobile", type: TrackType.Event) {
            backend_id = "l3_l7-ngrams"
            client = "vip_combo"
            direct = false
            items = ["MLB754486062" , "MLB512313"]
            recommendation_id = "4ifmk4-moprk-mfov0-mroas"
            shipping_benefit = "none"
        }
        "/recommendations/add_to_cart"(platform: "/mobile/ios", type: TrackType.Event) {
            backend_id = "l3_l7-ngrams"
            client = "vip_combo"
            direct = true
            items = ["MLB754486062" , "MLB512313"]
            recommendation_id = "4ifmk4-moprk-mfov0-mroas"
            shipping_benefit = "free"
        }

        "/recommendations/add_to_cart"(platform: "/mobile/android", type: TrackType.Event) {
            backend_id = "l3_l7-ngrams"
            client = "vip_combo"
            direct = false
            items = ["MLB754486062" , "MLB512313"]
            recommendation_id = "4ifmk4-moprk-mfov0-mroas"
            shipping_benefit = "none"
        }
    }
}


