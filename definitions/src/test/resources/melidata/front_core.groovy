package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


/**************************
* WALLET HOME TEST TRACKS *
**************************/

trackTests {

    defaultBusiness = "mercadopago"

    test("Mercadopago Home") {
        "/wallet/home" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Tap") {
        "/wallet/home/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
        }
    }

    test("Mercadopago Drawer Tap") {
        "/home_wallet/drawer/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://pay_section"
        }
    }


    test("Mercadopago Home Show") {
        "/wallet/home/show" (platform: "/mobile", type: TrackType.Event) {
            header = "name"
            items = [
                [
                    id: "banking",
                    ordinal: 1,
                    type: "BANKING"
                ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Home Show Instore generic") {
        "/wallet/home/show/instore/promotion/generic"(platform: "/mobile", type: TrackType.Event) {
            header_title = "Any title"
            link = "Any deeplink"
            items = ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"]
            items_size = 3
        }
    }
    // TODO: This test will be removed
    test("Mercadopago Home Show Instore qr_map") {
        "/wallet/home/show/instore/promotion/qr_map"(platform: "/mobile", type: TrackType.Event) {
            header_title = "Any title"
            link = "Any deeplink"
            items = ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"]
            items_size = 3
        }
    }
    test("Mercadopago Main Actions Section Show") {
        "/wallet/home/show/main_actions" (platform: "/mobile", type: TrackType.Event) {
            quantity = 1
            items = [
                    [
                            id: "show_qr",
                            ordinal: 1,
                            has_promotion: true,
                            enabled: false
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Secondary Actions Section Show") {
        "/wallet/home/show/secondary_actions" (platform: "/mobile", type: TrackType.Event) {
            realestates_payers = [
                    [
                            realestate_id: "secondary_actions_mp_pay_services",
                            content_id: "pay_services",
                            origin: "secondary_actions"
                    ]
            ]
            realestates_sellers = [
                    [
                            realestate_id: "secondary_actions_mp_charge_with_qr",
                            content_id: "charge_with_qr",
                            origin: "secondary_actions"
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Discount Benefits Section Show") {
        "/wallet/home/show/discount_benefits" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            realestate_id : "discount_benefits_advice",
                            content_id : "mgm_payer",
                            origin : "user_journey"
                    ],
                    [
                            realestate_id : "discount_benefits_coupon",
                            content_id : "coupon",
                            origin : "user_journey"
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Dismissible Row Section Show") {
        "/wallet/home/show/dismissible_row" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            realestate_id : "dismissible_row",
                            content_id : "available_acquisition",
                            origin : "user_journey"
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Cross Selling Section Show") {
        "/wallet/home/show/cross_selling" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            realestate_id: "cross_selling_home_mp_prepaid",
                            content_id   : "cross_selling_prepaid",
                            origin       : "user_journey"
                    ],
                    [
                            realestate_id: "cross_selling_home_mp_point",
                            content_id   : "cross_selling_point",
                            origin       : "user_journey"
                    ]
            ]

        }
    }


    // TODO: This test will be removed
    test("Mercadopago Home Banking Section Show") {
        "/wallet/home/show/banking" (platform: "/mobile", type: TrackType.Event) {
            collapsed = true
            balance : [
                pendingBalance: false,
                balanceHistogram: 6
            ]
            cards : [
                prepaid: false,
                quantity: 9
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Home Activities Show") {
        "/wallet/home/show/activities" (platform: "/mobile", type: TrackType.Event) {
            quantity = 0
            is_ftu = true
            has_footer = false
        }
    }

    test("Mercadopago Home Banking Initial State") {
        "/wallet/home/banking/initial_state" (platform: "/mobile", type: TrackType.Event) {
            collapsed = true
            balance : [
                pendingBalance: false,
                balanceHistogram: 6
            ]
            cards : [
                prepaid: false,
                quantity: 9
            ]
        }
    }

    test("Mercadopago Home Banking Collapse") {
        "/wallet/home/banking/collapse" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Banking Expand") {
        "/wallet/home/banking/expand" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home activity shown") {
        "/home_wallet" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Secondary actions toggle") {
        "/wallet/home/secondary_actions/toggle" (platform: "/mobile", type: TrackType.Event) {
            id= "payer"
            quantity= "6"
            is_showing_aware= true
            actions= [ 
                [
                    id              :   "recharge_phone",
                    ordinal         :   1,
                    has_promotion   :   false
                ],
                [
                    id              :   "pay_services",
                    ordinal         :   2,
                    has_promotion   :   false
                ]
            ]
        }
    }

    /*****************************
    * WALLET HOME TEST TRACKS V2 *
    *****************************/

    test("Mercadopago Home") {
        "/wallet_home" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/wallet_home/pull" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Tap") {
        "/wallet_home/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="main_actions"
            component_id="user_activities"
        }
    }

    test("Mercadopago Home Secondary actions toggle") {
        "/wallet_home/secondary_actions/toggle" (platform: "/mobile", type: TrackType.Event) {
            id= "payer"
            quantity= "6"
            is_showing_aware= true
            actions= [ 
                [
                    id              :   "recharge_phone",
                    ordinal         :   1,
                    has_promotion   :   false
                ],
                [
                    id              :   "pay_services",
                    ordinal         :   2,
                    has_promotion   :   false
                ]
            ]
        }
    }

    test("Mercadopago Home Banking Collapse") {
        "/wallet_home/banking/collapse" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Banking Expand") {
        "/wallet_home/banking/expand" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Drawer Tap") {
        "/wallet_home/drawer/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://pay_section"
        }
    }

    test("Mercadopago Home Show") {
        "/wallet_home/home" (platform: "/mobile", type: TrackType.View) {
            header = "name"
            partial_content = false
            banking = [  
                partial_content : false,
                default_content : false,
                ordinal: 1,
                collapsed: true,
                balance: [
                    pending_balance: false,
                    balance_histogram: 6
                ],
                cards: [
                    prepaid: false,
                    quantity: 9
                ],
                assets: [],
                credits: []
            ]
            main_actions = [
                partial_content : false,
                default_content : false,
                ordinal: 2,
                quantity: 3,
                items: [
                    [
                    id              : "scan_qr",
                    ordinal         : 1,
                    has_promotion   : false,
                    enabled         : true
                    ]
                ]
            ] 
            prepaid_banner = [
                partial_content : false,
                default_content : false,
                ordinal: 3,
                realestates: [
                    [
                        realestate_id: "dismissible_row",
                        content_id: "available_acquisition",
                        origin: "customer_journey"
                    ]
                ]
            ]
            secondary_actions = [
                partial_content : false,
                default_content : false,
                ordinal: 4,
                realestates_payers: [
                    [ 
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_pay_services_MARZO_20",
                        origin: "campaigns"
                    ]
                ],
                realestates_sellers: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_pay_services_MARZO_20",
                        origin: "campaigns"
                    ]
                ]
            ]
            benefits= [
                partial_content : false,
                default_content : false,
                ordinal: 5,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns"
                    ]
                ]
            ]
            cross_selling= [
                partial_content : false,
                default_content : false,
                ordinal: 6,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns"
                    ]
                ]
            ]
            activities= [
                partial_content : false,
                default_content : false,
                ordinal: 7,
                quantity: 3,
                is_ftu: false,
                has_footer: true
            ]
            qr_map= [
                partial_content : false,
                default_content : false,
                ordinal: 8,
                header_title: "¡Pagá con QR en tus locales favoritos!",
                items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                link: "mercadopago://discovery/map?from=home_instore_map_section"              
            ]
        }
    }

    test("Mercadopago Home Update") {
        "/wallet_home/update" (platform: "/mobile", type: TrackType.View) {
            header = "name"
            partial_content = false
            banking = [  
                partial_content : false,
                default_content : false,
                ordinal: 1,
                collapsed: true,
                balance: [
                    pending_balance: false,
                    balance_histogram: 6
                ],
                cards: [
                    prepaid: false,
                    quantity: 9
                ],
                assets: [],
                credits: []
            ]
            main_actions = [
                partial_content : false,
                default_content : false,
                ordinal: 2,
                quantity: 3,
                items: [
                    [
                    id              : "scan_qr",
                    ordinal         : 1,
                    has_promotion   : false,
                    enabled         : true
                    ]
                ]
            ] 
            prepaid_banner = [
                partial_content : false,
                default_content : false,
                ordinal: 3,
                realestates: [
                    [
                        realestate_id: "dismissible_row",
                        content_id: "available_acquisition",
                        origin: "customer_journey"
                    ]
                ]
            ]
            secondary_actions = [
                partial_content : false,
                default_content : false,
                ordinal: 4,
                realestates_payers: [
                    [ 
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_pay_services_MARZO_20",
                        origin: "campaigns"
                    ]
                ],
                realestates_sellers: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_pay_services_MARZO_20",
                        origin: "campaigns"
                    ]
                ]
            ]
            benefits= [
                partial_content : false,
                default_content : false,
                ordinal: 5,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns"
                    ]
                ]
            ]
            cross_selling= [
                partial_content : false,
                default_content : false,
                ordinal: 6,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns"
                    ]
                ]
            ]
            activities= [
                partial_content : false,
                default_content : false,
                ordinal: 7,
                quantity: 3,
                is_ftu: false,
                has_footer: true
            ]
            qr_map= [
                partial_content : false,
                default_content : false,
                ordinal: 8,
                header_title: "¡Pagá con QR en tus locales favoritos!",
                items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                link: "mercadopago://discovery/map?from=home_instore_map_section"              
            ]
        }
    }

    //Notification Center
    test("Mercadopago Home Notification center Show") {
        "/wallet_home/notification/show" (platform: "/mobile", type: TrackType.View) {
            badge_count = 3
        }
    }

    test("Mercadopago Home Notification center Tap") {
        "/wallet_home/notification/tap" (platform: "/mobile", type: TrackType.Event) {
            badge_count = 4
        }
    }

    // Modal Mercadopago-Mercadolibre
    test("Modal Show") {
        "/wallet_home/modal/show" (platform: "/mobile", type: TrackType.Event) {
            id = "modalid"
        }
    }

    test("Modal Tap") {
        "/wallet_home/modal/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "modalid"
        }
    }
    
    test("Modal close") {
        "/wallet_home/modal/close" (platform: "/mobile", type: TrackType.Event) {
            id = "modalid"
        }
    }

    defaultBusiness = "mercadolibre"

        test("Mercadopago Home") {
        "/wallet/home" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Tap") {
        "/wallet/home/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
        }
    }

    test("Mercadopago Drawer Tap") {
        "/home_wallet/drawer/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://pay_section"
        }
    }


    test("Mercadopago Home Show") {
        "/wallet/home/show" (platform: "/mobile", type: TrackType.Event) {
            header = "name"
            items = [
                [
                    id: "banking",
                    ordinal: 1,
                    type: "BANKING"
                ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Home Show Instore generic") {
        "/wallet/home/show/instore/promotion/generic"(platform: "/mobile", type: TrackType.Event) {
            header_title = "Any title"
            link = "Any deeplink"
            items = ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"]
            items_size = 3
        }
    }
    // TODO: This test will be removed
    test("Mercadopago Home Show Instore qr_map") {
        "/wallet/home/show/instore/promotion/qr_map"(platform: "/mobile", type: TrackType.Event) {
            header_title = "Any title"
            link = "Any deeplink"
            items = ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"]
            items_size = 3
        }
    }
    test("Mercadopago Main Actions Section Show") {
        "/wallet/home/show/main_actions" (platform: "/mobile", type: TrackType.Event) {
            quantity = 1
            items = [
                    [
                            id: "show_qr",
                            ordinal: 1,
                            has_promotion: true,
                            enabled: false
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Secondary Actions Section Show") {
        "/wallet/home/show/secondary_actions" (platform: "/mobile", type: TrackType.Event) {
            realestates_payers = [
                    [
                            realestate_id: "secondary_actions_mp_pay_services",
                            content_id: "pay_services",
                            origin: "secondary_actions"
                    ]
            ]
            realestates_sellers = [
                    [
                            realestate_id: "secondary_actions_mp_charge_with_qr",
                            content_id: "charge_with_qr",
                            origin: "secondary_actions"
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Discount Benefits Section Show") {
        "/wallet/home/show/discount_benefits" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            realestate_id : "discount_benefits_advice",
                            content_id : "mgm_payer",
                            origin : "user_journey"
                    ],
                    [
                            realestate_id : "discount_benefits_coupon",
                            content_id : "coupon",
                            origin : "user_journey"
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Dismissible Row Section Show") {
        "/wallet/home/show/dismissible_row" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            realestate_id : "dismissible_row",
                            content_id : "available_acquisition",
                            origin : "user_journey"
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Cross Selling Section Show") {
        "/wallet/home/show/cross_selling" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            realestate_id: "cross_selling_home_mp_prepaid",
                            content_id   : "cross_selling_prepaid",
                            origin       : "user_journey"
                    ],
                    [
                            realestate_id: "cross_selling_home_mp_point",
                            content_id   : "cross_selling_point",
                            origin       : "user_journey"
                    ]
            ]

        }
    }


    // TODO: This test will be removed
    test("Mercadopago Home Banking Section Show") {
        "/wallet/home/show/banking" (platform: "/mobile", type: TrackType.Event) {
            collapsed = true
            balance : [
                pendingBalance: false,
                balanceHistogram: 6
            ]
            cards : [
                prepaid: false,
                quantity: 9
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Home Activities Show") {
        "/wallet/home/show/activities" (platform: "/mobile", type: TrackType.Event) {
            quantity = 0
            is_ftu = true
            has_footer = false
        }
    }

    test("Mercadopago Home Banking Initial State") {
        "/wallet/home/banking/initial_state" (platform: "/mobile", type: TrackType.Event) {
            collapsed = true
            balance : [
                pendingBalance: false,
                balanceHistogram: 6
            ]
            cards : [
                prepaid: false,
                quantity: 9
            ]
        }
    }

    test("Mercadopago Home Banking Collapse") {
        "/wallet/home/banking/collapse" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Banking Expand") {
        "/wallet/home/banking/expand" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home activity shown") {
        "/home_wallet" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Secondary actions toggle") {
        "/wallet/home/secondary_actions/toggle" (platform: "/mobile", type: TrackType.Event) {
            id= "payer"
            quantity= "6"
            is_showing_aware= true
            actions= [ 
                [
                    id              :   "recharge_phone",
                    ordinal         :   1,
                    has_promotion   :   false
                ],
                [
                    id              :   "pay_services",
                    ordinal         :   2,
                    has_promotion   :   false
                ]
            ]
        }
    }

    /*****************************
    * WALLET HOME TEST TRACKS V2 *
    *****************************/

    test("Mercadopago Home") {
        "/wallet_home" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/wallet_home/pull" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Tap") {
        "/wallet_home/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="main_actions"
            component_id="user_activities"
        }
    }

    test("Mercadopago Home Secondary actions toggle") {
        "/wallet_home/secondary_actions/toggle" (platform: "/mobile", type: TrackType.Event) {
            id= "payer"
            quantity= "6"
            is_showing_aware= true
            actions= [ 
                [
                    id              :   "recharge_phone",
                    ordinal         :   1,
                    has_promotion   :   false
                ],
                [
                    id              :   "pay_services",
                    ordinal         :   2,
                    has_promotion   :   false
                ]
            ]
        }
    }

    test("Mercadopago Home Banking Collapse") {
        "/wallet_home/banking/collapse" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Banking Expand") {
        "/wallet_home/banking/expand" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Drawer Tap") {
        "/wallet_home/drawer/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://pay_section"
        }
    }

    test("Mercadopago Home Show") {
        "/wallet_home/home" (platform: "/mobile", type: TrackType.View) {
            header = "name"
            partial_content = false
            banking = [  
                partial_content : false,
                default_content : false,
                ordinal: 1,
                collapsed: true,
                balance: [
                    pending_balance: false,
                    balance_histogram: 6
                ],
                cards: [
                    prepaid: false,
                    quantity: 9
                ],
                assets: [],
                credits: []
            ]
            main_actions = [
                partial_content : false,
                default_content : false,
                ordinal: 2,
                quantity: 3,
                items: [
                    [
                    id              : "scan_qr",
                    ordinal         : 1,
                    has_promotion   : false,
                    enabled         : true
                    ]
                ]
            ] 
            prepaid_banner = [
                partial_content : false,
                default_content : false,
                ordinal: 3,
                realestates: [
                    [
                        realestate_id: "dismissible_row",
                        content_id: "available_acquisition",
                        origin: "customer_journey"
                    ]
                ]
            ]
            secondary_actions = [
                partial_content : false,
                default_content : false,
                ordinal: 4,
                realestates_payers: [
                    [ 
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_pay_services_MARZO_20",
                        origin: "campaigns"
                    ]
                ],
                realestates_sellers: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_pay_services_MARZO_20",
                        origin: "campaigns"
                    ]
                ]
            ]
            benefits= [
                partial_content : false,
                default_content : false,
                ordinal: 5,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns"
                    ]
                ]
            ]
            cross_selling= [
                partial_content : false,
                default_content : false,
                ordinal: 6,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns"
                    ]
                ]
            ]
            activities= [
                partial_content : false,
                default_content : false,
                ordinal: 7,
                quantity: 3,
                is_ftu: false,
                has_footer: true
            ]
            qr_map= [
                partial_content : false,
                default_content : false,
                ordinal: 8,
                header_title: "¡Pagá con QR en tus locales favoritos!",
                items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                link: "mercadopago://discovery/map?from=home_instore_map_section"              
            ]
        }
    }

    test("Mercadopago Home Update") {
        "/wallet_home/update" (platform: "/mobile", type: TrackType.View) {
            header = "name"
            partial_content = false
            banking = [  
                partial_content : false,
                default_content : false,
                ordinal: 1,
                collapsed: true,
                balance: [
                    pending_balance: false,
                    balance_histogram: 6
                ],
                cards: [
                    prepaid: false,
                    quantity: 9
                ],
                assets: [],
                credits: []
            ]
            main_actions = [
                partial_content : false,
                default_content : false,
                ordinal: 2,
                quantity: 3,
                items: [
                    [
                    id              : "scan_qr",
                    ordinal         : 1,
                    has_promotion   : false,
                    enabled         : true
                    ]
                ]
            ] 
            prepaid_banner = [
                partial_content : false,
                default_content : false,
                ordinal: 3,
                realestates: [
                    [
                        realestate_id: "dismissible_row",
                        content_id: "available_acquisition",
                        origin: "customer_journey"
                    ]
                ]
            ]
            secondary_actions = [
                partial_content : false,
                default_content : false,
                ordinal: 4,
                realestates_payers: [
                    [ 
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_pay_services_MARZO_20",
                        origin: "campaigns"
                    ]
                ],
                realestates_sellers: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_pay_services_MARZO_20",
                        origin: "campaigns"
                    ]
                ]
            ]
            benefits= [
                partial_content : false,
                default_content : false,
                ordinal: 5,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns"
                    ]
                ]
            ]
            cross_selling= [
                partial_content : false,
                default_content : false,
                ordinal: 6,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns"
                    ]
                ]
            ]
            activities= [
                partial_content : false,
                default_content : false,
                ordinal: 7,
                quantity: 3,
                is_ftu: false,
                has_footer: true
            ]
            qr_map= [
                partial_content : false,
                default_content : false,
                ordinal: 8,
                header_title: "¡Pagá con QR en tus locales favoritos!",
                items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                link: "mercadopago://discovery/map?from=home_instore_map_section"              
            ]
        }
    }

    //Notification Center
    test("Mercadopago Home Notification center Show") {
        "/wallet_home/notification/show" (platform: "/mobile", type: TrackType.View) {
            badge_count = 3
        }
    }

    test("Mercadopago Home Notification center Tap") {
        "/wallet_home/notification/tap" (platform: "/mobile", type: TrackType.Event) {
            badge_count = 4
        }
    }

    // Modal Mercadopago-Mercadolibre
    test("Modal Show") {
        "/wallet_home/modal/show" (platform: "/mobile", type: TrackType.Event) {
            id = "modalid"
        }
    }

    test("Modal Tap") {
        "/wallet_home/modal/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "modalid"
        }
    }
    
    test("Modal close") {
        "/wallet_home/modal/close" (platform: "/mobile", type: TrackType.Event) {
            id = "modalid"
        }
    }


}