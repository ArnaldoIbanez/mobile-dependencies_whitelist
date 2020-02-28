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
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ]
            ]
            realestates_sellers = [
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ]
            ]
            realestates_friends = [
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Discount Benefits Section Show") {
        "/wallet/home/show/discount_benefits" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ],
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Dismissible Row Section Show") {
        "/wallet/home/show/dismissible_row" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Cross Selling Section Show") {
        "/wallet/home/show/cross_selling" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ],
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
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
            header = [
                loyalty: [
                    level: 5
                ]
            ]
            content_type = 'partial'
            from = "drawer_ml"
            banking = [  
                content_type : 'default',
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
                credits: [],
                money_in: [
                    pending_balance: false,
                    balance_histogram: 6
                ]

            ]
            main_actions = [
                content_type : 'complete',
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
                content_type : 'partial',
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
                content_type : 'partial',
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
                content_type : 'partial',
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
                content_type : 'partial',
                ordinal: 6,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns"
                    ]
                ]
            ]
            loyalty= [
                content_type : 'partial',
                ordinal: 7,
                level: 3,
                percentage: 17
            ]
            activities= [
                content_type : 'partial',
                ordinal: 8,
                quantity: 3,
                is_ftu: false,
                has_footer: true
            ]
            qr_map= [
                content_type : 'partial',
                ordinal: 9,
                header_title: "¡Pagá con QR en tus locales favoritos!",
                items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                link: "mercadopago://discovery/map?from=home_instore_map_section"              
            ]
            activities_link= [
                ordinal: 10,
                content_type : 'partial'
            ]
            discount_center= [
                ordinal: 11,
                content_type: 'partial',
                items: [
                    [   
                        tracking_id: "1004194",
                        blocked: false,
                        name: "Mc Donalds",
                        category: "Fast Food",
                        mcc: 5611201,
                        position: 0,
                        level: 1,
                        distance: 258,
                        store_id: 30091709,
                        availability: "full",
                        amount_type: "percent",
                        amount: 15,
                        priority: 9,
                        collector_id: 123456,
                        has_logo: true,
                        coupon_used: false
                    ]
                ]
            ]
            survey= [
                ordinal: 12,
                content_type : 'complete'
            ]
            bcra_regulation= [
                ordinal: 13,
                content_type : 'complete'
            ]
        }
    }

    test("Mercadopago Home Update") {
        "/wallet_home/update" (platform: "/mobile", type: TrackType.View) {
            header = [
                loyalty: [
                    level: 5
                ]
            ]
            content_type = 'partial'
            from = "drawer_ml"
            banking = [  
                content_type : 'default',
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
                credits: [],
                money_in: [
                    pending_balance: false,
                    balance_histogram: 6
                ]
            ]
            main_actions = [
                content_type : 'complete',
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
                content_type : 'partial',
                ordinal: 3,
                realestates: [
                    [
                        content_id: "available_acquisition"
                    ]
                ]
            ]
            secondary_actions = [
                content_type : 'partial',
                ordinal: 4,
                realestates_payers: [
                    [
                        content_id: "secondary_actions_mp_pay_services_MARZO_20"
                    ]
                ],
                realestates_sellers: [
                    [
                        content_id: "secondary_actions_mp_pay_services_MARZO_20"
                    ]
                ]
            ]
            benefits= [
                content_type : 'partial',
                ordinal: 5,
                realestates: [
                    [
                        content_id: "secondary_actions_mp_recharge_default"
                    ]
                ]
            ]
            cross_selling= [
                content_type : 'partial',
                ordinal: 6,
                realestates: [
                    [
                        content_id: "secondary_actions_mp_recharge_default"
                    ]
                ]
            ]
            loyalty= [
                content_type : 'partial',
                ordinal: 7,
                level: 3,
                percentage: 17
            ]
            activities= [
                content_type : 'partial',
                ordinal: 8,
                quantity: 3,
                is_ftu: false,
                has_footer: true
            ]
            qr_map= [
                content_type : 'partial',
                ordinal: 9,
                header_title: "¡Pagá con QR en tus locales favoritos!",
                items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                link: "mercadopago://discovery/map?from=home_instore_map_section"              
            ]
            activities_link= [
                ordinal: 10,
                content_type : 'partial'
            ]
            discount_center= [
                ordinal: 11,
                content_type: 'partial',
                items: [
                    [   
                        tracking_id: "1004194",
                        blocked: false,
                        name: "Mc Donalds",
                        category: "Fast Food",
                        mcc: 5611201,
                        position: 0,
                        level: 1,
                        distance: 258,
                        store_id: 30091709,
                        availability: "full",
                        amount_type: "percent",
                        amount: 15,
                        priority: 9,
                        collector_id: 123456,
                        has_logo: true,
                        coupon_used: false
                    ]
                ]
            ]
            survey= [
                ordinal: 12,
                content_type : 'complete'
            ]
            bcra_regulation= [
                ordinal: 13,
                content_type : 'complete'
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

    //Loyalty
    test("Loyalty header tap") {
        "/wallet_home/loyalty/tap" (platform: "/mobile", type: TrackType.Event) {
            loyalty = [
                level: 9
            ]
        }
    }

    /*****************************
     * WALLET HOME TEST TRACKS V3 *
     *****************************/

    test("Mercadopago Home Tap v3") {
        "/wallet_home/section/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="banking"
            component_id="user_banking"
        }
    }

    test("Mercadopago Home Tap v3 - Banking") {
        "/wallet_home/section/tap/banking" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="banking"
            component_id="user_banking"
        }
    }

    test("Mercadopago Home Tap v3 - Main Actions") {
        "/wallet_home/section/tap/main_actions" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="main_actions"
            component_id="user_main_actions"
        }
    }

    test("Mercadopago Home Tap v3 - Activities") {
        "/wallet_home/section/tap/activities" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="activities"
            component_id="user_activities"
        }
    }

    test("Mercadopago Home Tap v3 - Activities Link") {
        "/wallet_home/section/tap/activities_link" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="activities_link"
            component_id="user_activities_link"
        }
    }

    test("Mercadopago Home Tap v3 - QR Map") {
        "/wallet_home/section/tap/qr_map" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="qr_map"
            component_id="user_qr_map"
        }
    }

    test("Mercadopago Home Tap v3 - Discount Center") {
        "/wallet_home/section/tap/discount_center" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="discount_center"
            component_id="user_discount_center"
        }
    }

    test("Mercadopago Home Tap v3 - Loyalty") {
        "/wallet_home/section/tap/loyalty" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="loyalty"
            component_id="user_loyalty"
            level=4
            percentage=0.32
        }
    }

    test("Mercadopago Home Tap v3 - Survey") {
        "/wallet_home/section/tap/survey" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="survey"
            component_id="user_survey"
        }
    }

    test("Mercadopago Home Tap v3 - Secondary Actions") {
        "/wallet_home/section/tap/secondary_actions" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="secondary_actions"
            component_id="user_secondary_actions"
            action_id = "default"
            audience = "all"
            bu_line = "default"
            content_id = "prepaid_mla_2019_10"
            flow = "default"
            logic = "campaigns"
            position = 1.0
        }
    }

    test("Mercadopago Home Tap v3 - Cross Selling") {
        "/wallet_home/section/tap/cross_selling" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="secondary_actions"
            component_id="user_secondary_actions"
            action_id = "default"
            audience = "all"
            bu_line = "default"
            content_id = "prepaid_mla_2019_10"
            flow = "default"
            logic = "campaigns"
            position = 1.0
        }
    }

    test("Mercadopago Home Tap v3 - Prepaid Banner") {
        "/wallet_home/section/tap/prepaid_banner" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="secondary_actions"
            component_id="user_secondary_actions"
            action_id = "default"
            audience = "all"
            bu_line = "default"
            content_id = "prepaid_mla_2019_10"
            flow = "default"
            logic = "campaigns"
            position = 1.0
        }
    }

    test("Mercadopago Home Tap v3 - Benefits") {
        "/wallet_home/section/tap/benefits" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="secondary_actions"
            component_id="user_secondary_actions"
            action_id = "default"
            audience = "all"
            bu_line = "default"
            content_id = "prepaid_mla_2019_10"
            flow = "default"
            logic = "campaigns"
            position = 1.0
        }
    }

    test("Mercadopago cross sell experiments") {
        "/wallet_home/cross_sell" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("New Digital Wallet - Ukraine Lab") {
        /**
         * New Digital Wallet Tracks - Ukraine Lab
         */
        "/new_digital_wallet_landing"(platform: "/"){
            landing_id = "ukraine lab"
        }
        "/new_digital_wallet_landing/click_download_app"(platform: "/"){
            landing_id = "ukraine lab"
            section = "hero"
        }
        "/new_digital_wallet_landing/click_download_app"(platform: "/"){
            landing_id = "ukraine lab"
            section = "fixed"
        }
        "/new_digital_wallet_landing/click_download_app"(platform: "/"){
            landing_id = "ukraine lab"
            section = "footer"
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
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ]
            ]
            realestates_sellers = [
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ]
            ]
            realestates_friends = [
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Discount Benefits Section Show") {
        "/wallet/home/show/discount_benefits" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ],
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Dismissible Row Section Show") {
        "/wallet/home/show/dismissible_row" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ]
            ]
        }
    }

    // TODO: This test will be removed
    test("Mercadopago Cross Selling Section Show") {
        "/wallet/home/show/cross_selling" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
                    ],
                    [
                            content_id: "pay_services",
                            link: "mercadopago://instore/scan_qr",
                            section_id:"benefits",
                            component_id:"user_benefits",
                            action_id: "default",
                            audience: "all",
                            bu_line: "default",
                            flow: "default",
                            logic: "campaigns",
                            position: 1.0
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

    test("Mercadolibre activity Detail") {
        "/activity_detail"(platform: "/mobile") {}
    }

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
            header = [
                loyalty: [
                    level: 5
                ]
            ]
            content_type = 'partial'
            from = "drawer_ml"
            banking = [  
                content_type : 'default',
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
                credits: [],
                money_in: [
                    pending_balance: false,
                    balance_histogram: 6
                ]
            ]
            main_actions = [
                content_type : 'complete',
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
                content_type : 'partial',
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
                content_type : 'partial',
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
                content_type : 'partial',
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
                content_type : 'partial',
                ordinal: 6,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns"
                    ]
                ]
            ]
            loyalty= [
                content_type : 'partial',
                ordinal: 7,
                level: 3,
                percentage: 17
            ]
            activities= [
                content_type : 'partial',
                ordinal: 8,
                quantity: 3,
                is_ftu: false,
                has_footer: true
            ]
            qr_map= [
                content_type : 'partial',
                ordinal: 9,
                header_title: "¡Pagá con QR en tus locales favoritos!",
                items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                link: "mercadopago://discovery/map?from=home_instore_map_section"              
            ]
            activities_link= [
                ordinal: 10,
                content_type : 'partial'
            ]
            discount_center= [
                ordinal: 11,
                content_type: 'partial',
                items: [
                    [   
                        tracking_id: "1004194",
                        blocked: false,
                        name: "Mc Donalds",
                        category: "Fast Food",
                        mcc: 5611201,
                        position: 0,
                        level: 1,
                        distance: 258,
                        store_id: 30091709,
                        availability: "full",
                        amount_type: "percent",
                        amount: 15,
                        priority: 9,
                        collector_id: 123456,
                        has_logo: true,
                        coupon_used: false
                    ]
                ]
            ]
            survey= [
                ordinal: 12,
                content_type : 'complete'
            ]
        }
    }

    test("Mercadopago Home Update") {
        "/wallet_home/update" (platform: "/mobile", type: TrackType.View) {
            header = [
                loyalty: [
                    level: 5
                ]
            ]
            content_type = 'partial'
            from = "my_account_ml"
            banking = [  
                content_type : 'default',
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
                credits: [],
                money_in: [
                    pending_balance: false,
                    balance_histogram: 6
                ]
            ]
            main_actions = [
                content_type : 'complete',
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
                content_type : 'partial',
                ordinal: 3,
                realestates: [
                    [
                        realestate_id: "dismissible_row",
                        content_id: "available_acquisition",
                        origin: "customer_journey",
                        link: "mercadopago://instore/scan_qr",
                        section_id: "benefits",
                        component_id: "user_benefits",
                        action_id: "default",
                        audience: "all",
                        bu_line: "default",
                        content_id: "prepaid_mla_2019_10",
                        flow: "default",
                        logic: "campaigns",
                        position: 1.0
                    ]
                ]
            ]
            secondary_actions = [
                content_type : 'partial',
                ordinal: 4,
                realestates_payers: [
                    [ 
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_pay_services_MARZO_20",
                        origin: "campaigns",
                        link: "mercadopago://instore/scan_qr",
                        section_id: "benefits",
                        component_id: "user_benefits",
                        action_id: "default",
                        audience: "all",
                        bu_line: "default",
                        content_id: "prepaid_mla_2019_10",
                        flow: "default",
                        logic: "campaigns",
                        position: 1.0
                    ]
                ],
                realestates_sellers: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_pay_services_MARZO_20",
                        origin: "campaigns",
                        link: "mercadopago://instore/scan_qr",
                        section_id: "benefits",
                        component_id: "user_benefits",
                        action_id: "default",
                        audience: "all",
                        bu_line: "default",
                        content_id: "prepaid_mla_2019_10",
                        flow: "default",
                        logic: "campaigns",
                        position: 1.0
                    ]
                ]
            ]
            benefits= [
                content_type : 'partial',
                ordinal: 5,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns",
                        link: "mercadopago://instore/scan_qr",
                        section_id: "benefits",
                        component_id: "user_benefits",
                        action_id: "default",
                        audience: "all",
                        bu_line: "default",
                        content_id: "prepaid_mla_2019_10",
                        flow: "default",
                        logic: "campaigns",
                        position: 1.0
                    ]
                ]
            ]
            cross_selling= [
                content_type : 'partial',
                ordinal: 6,
                realestates: [
                    [
                        realestate_id: "secondary_actions_mp_pay_services",
                        content_id: "secondary_actions_mp_recharge_default",
                        origin: "campaigns",
                        link: "mercadopago://instore/scan_qr",
                        section_id: "benefits",
                        component_id: "user_benefits",
                        action_id: "default",
                        audience: "all",
                        bu_line: "default",
                        content_id: "prepaid_mla_2019_10",
                        flow: "default",
                        logic: "campaigns",
                        position: 1.0
                    ]
                ]
            ]
            loyalty= [
                content_type : 'partial',
                ordinal: 7,
                level: 3,
                percentage: 17
            ]
            activities= [
                content_type : 'partial',
                ordinal: 8,
                quantity: 3,
                is_ftu: false,
                has_footer: true
            ]
            qr_map= [
                content_type : 'partial',
                ordinal: 9,
                header_title: "¡Pagá con QR en tus locales favoritos!",
                items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                link: "mercadopago://discovery/map?from=home_instore_map_section"              
            ]
            activities_link= [
                ordinal: 10,
                content_type : 'partial'
            ]
            discount_center= [
                ordinal: 11,
                content_type: 'partial',
                items: [
                    [   
                        tracking_id: "1004194",
                        blocked: false,
                        name: "Mc Donalds",
                        category: "Fast Food",
                        mcc: 5611201,
                        position: 0,
                        level: 1,
                        distance: 258,
                        store_id: 30091709,
                        availability: "full",
                        amount_type: "fixed",
                        amount: 15,
                        priority: 9,
                        collector_id: 123456,
                        has_logo: true,
                        coupon_used: false
                    ]
                ]
            ]
            survey= [
                ordinal: 12,
                content_type : 'complete'
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

    //Loyalty
    test("Loyalty header tap") {
        "/wallet_home/loyalty/tap" (platform: "/mobile", type: TrackType.Event) {
            loyalty = [
                level: 9
            ]
        }
    }

    /*****************************
     * WALLET HOME TEST TRACKS V3 *
     *****************************/

    test("Mercadopago Home Tap v3") {
        "/wallet_home/section/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="banking"
            component_id="user_banking"
        }
    }

    test("Mercadopago Home Tap v3 - Banking") {
        "/wallet_home/section/tap/banking" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="banking"
            component_id="user_banking"
        }
    }

    test("Mercadopago Home Tap v3 - Main Actions") {
        "/wallet_home/section/tap/main_actions" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="main_actions"
            component_id="user_main_actions"
        }
    }

    test("Mercadopago Home Tap v3 - Activities") {
        "/wallet_home/section/tap/activities" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="activities"
            component_id="user_activities"
        }
    }

    test("Mercadopago Home Tap v3 - Activities Link") {
        "/wallet_home/section/tap/activities_link" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="activities_link"
            component_id="user_activities_link"
        }
    }

    test("Mercadopago Home Tap v3 - QR Map") {
        "/wallet_home/section/tap/qr_map" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="qr_map"
            component_id="user_qr_map"
        }
    }

    test("Mercadopago Home Tap v3 - Discount Center") {
        "/wallet_home/section/tap/discount_center" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="discount_center"
            component_id="user_discount_center"
        }
    }

    test("Mercadopago Home Tap v3 - Loyalty") {
        "/wallet_home/section/tap/loyalty" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="loyalty"
            component_id="user_loyalty"
            level=4
            percentage=0.32
        }
    }

    test("Mercadopago Home Tap v3 - Survey") {
        "/wallet_home/section/tap/survey" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="survey"
            component_id="user_survey"
        }
    }

    test("Mercadopago Home Tap v3 - Secondary Actions") {
        "/wallet_home/section/tap/secondary_actions" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="secondary_actions"
            component_id="user_secondary_actions"
            action_id = "default"
            audience = "all"
            bu_line = "default"
            content_id = "prepaid_mla_2019_10"
            flow = "default"
            logic = "campaigns"
            position = 1.0
        }
    }

    test("Mercadopago Home Tap v3 - Cross Selling") {
        "/wallet_home/section/tap/cross_selling" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="cross_selling"
            component_id="user_cross_selling"
            action_id = "default"
            audience = "all"
            bu_line = "default"
            content_id = "prepaid_mla_2019_10"
            flow = "default"
            logic = "campaigns"
            position = 1.0
        }
    }

    test("Mercadopago Home Tap v3 - Prepaid Banner") {
        "/wallet_home/section/tap/prepaid_banner" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="prepaid_banner"
            component_id="user_prepaid_banner"
            action_id = "default"
            audience = "all"
            bu_line = "default"
            content_id = "prepaid_mla_2019_10"
            flow = "default"
            logic = "campaigns"
            position = 1.0
        }
    }

    test("Mercadopago Home Tap v3 - Benefits") {
        "/wallet_home/section/tap/benefits" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="benefits"
            component_id="user_benefits"
            action_id = "default"
            audience = "all"
            bu_line = "default"
            content_id = "prepaid_mla_2019_10"
            flow = "default"
            logic = "campaigns"
            position = 1.0
        }
    }

    test("Mercadopago cross sell experiments") {
        "/wallet_home/cross_sell" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("New Digital Wallet - Ukraine Lab") {
        /**
         * New Digital Wallet Tracks - Ukraine Lab
         */
        "/new_digital_wallet_landing"(platform: "/"){
            landing_id = "ukraine lab"
        }
        "/new_digital_wallet_landing/click_download_app"(platform: "/"){
            landing_id = "ukraine lab"
            section = "hero"
        }
        "/new_digital_wallet_landing/click_download_app"(platform: "/"){
            landing_id = "ukraine lab"
            section = "fixed"
        }
        "/new_digital_wallet_landing/click_download_app"(platform: "/"){
            landing_id = "ukraine lab"
            section = "footer"
        }
    }
}
