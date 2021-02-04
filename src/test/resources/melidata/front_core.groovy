package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

/**************************************************************
 * CONTACT: In case of changes over this file, please send us
 *  a message to our e-mail: front_native_devs@mercadolibre.com
 **************************************************************/

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

    // New Banking

    test("Mercadopago MPcard") {
        "/wallet_home/section/tap/banking_v2" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago"
            section_id = "banking_v2"
        }

        "/wallet_home/section/tap/banking_v2/mpcards" (platform: "/mobile", type: TrackType.Event) {
            pill = "NOVO"
            has_card = true
            component_id = "card"
            link = "mercadopago"
            section_id = "banking_v2"
        }


        "/wallet_home/section/tap/banking_v2/mpcards" (platform: "/mobile", type: TrackType.Event) {
            has_nfc_card = true
            component_id = "nfc"
            link = "mercadopago"
            section_id = "banking_v2"
        }
        
        "/wallet_home/section/tap/banking_v2/mpcards" (platform: "/mobile", type: TrackType.Event) {
            card_status = "active"
            component_id = "pay_online"
            link = "mercadopago"
            section_id = "banking_v2"
        }
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
            metadata_user:[
                type: "payer"
            ]
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
            metadata_user:[
                type: "payer"
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
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Show") {
        "/wallet_home/home" (platform: "/mobile", type: TrackType.View) {
            header = [
                    link: "mercadopago://link",
                    button_link: "mercadopago://link",
                    loyalty: [
                            level: 5
                    ],
                    metadata_user:[
                            type: "payer"
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
                            quantity: 9,
                            debit: false
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
            shortcuts = [
                    content_type : 'complete',
                    ordinal: 3,
                    favorite_ids: [
                        "scan_qr", "send_money", "recharge_sube", "money_out", "money_in"
                    ],
                    shortcut_ids: [
                        "gran_dia_mcdonals"
                    ],
                    has_view_more: false
            ]
            prepaid_banner = [
                    content_type : 'partial',
                    ordinal: 4,
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
                    ordinal: 5,
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
                    ordinal: 6,
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
                    ordinal: 7,
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
                    ordinal: 8,
                    level: 3,
                    percentage: 17
            ]
            activities= [
                    content_type : 'partial',
                    ordinal: 9,
                    quantity: 3,
                    is_ftu: false,
                    has_footer: true
            ]
            qr_map= [
                    content_type : 'partial',
                    ordinal: 10,
                    header_title: "¡Pagá con QR en tus locales favoritos!",
                    items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                    link: "mercadopago://discovery/map?from=home_instore_map_section"
            ]
            activities_link= [
                    ordinal: 11,
                    content_type : 'partial'
            ]
            discount_center= [
                    ordinal: 12,
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
            credits=[]
            banking_v2=[
                hidden : true
            ]
            survey= [
                    ordinal: 13,
                    content_type : 'complete'
            ]
            bcra_regulation= [
                    ordinal: 14,
                    content_type : 'complete'
            ]
            ifpe_regulation= [
                    ordinal: 15,
                    content_type : 'complete'
            ]
            repentance_button= [
                    ordinal: 16,
                    content_type : 'complete'
            ]
            metadata = [
                accessibility_voice: false
            ]
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Update") {
        "/wallet_home/update" (platform: "/mobile", type: TrackType.View) {
            header = [
                    loyalty: [
                            level: 5
                    ],
                    metadata_user:[
                            type: "payer"
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
                            quantity: 9,
                            debit: true
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
            shortcuts = [
                    content_type : 'complete',
                    ordinal: 3,
                    favorite_ids: [
                        "scan_qr", "send_money", "recharge_sube", "money_out", "money_in"
                    ],
                    shortcut_ids: [
                        "gran_dia_mcdonals"
                    ],
                    has_view_more: true,
                    has_view_more_ripple: true,
            ]
            prepaid_banner = [
                    content_type : 'partial',
                    ordinal: 4,
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
                    ordinal: 5,
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
                    ordinal: 6,
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
                    ordinal: 7,
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
                    ordinal: 8,
                    level: 3,
                    percentage: 17
            ]
            activities= [
                    content_type : 'partial',
                    ordinal: 9,
                    quantity: 3,
                    is_ftu: false,
                    has_footer: true
            ]
            qr_map= [
                    content_type : 'partial',
                    ordinal: 10,
                    header_title: "¡Pagá con QR en tus locales favoritos!",
                    items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                    link: "mercadopago://discovery/map?from=home_instore_map_section"
            ]
            activities_link= [
                    ordinal: 11,
                    content_type : 'partial'
            ]
            discount_center= [
                    ordinal: 12,
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
                    ordinal: 13,
                    content_type : 'complete'
            ]
            bcra_regulation= [
                    ordinal: 14,
                    content_type : 'complete'
            ]
            ifpe_regulation= [
                    ordinal: 15,
                    content_type : 'complete'
            ]
            repentance_button= [
                    ordinal: 16,
                    content_type : 'complete'
            ]
            metadata = [
                accessibility_voice: true
            ]
            metadata_user:[
                type: "payer"
            ]
        }
    }

    //Notification Center
    test("Mercadopago Home Notification center Show") {
        "/wallet_home/notification/show" (platform: "/mobile", type: TrackType.View) {
            badge_count = 3
            metadata_user:[
                type: "payer"
            ]
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
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Modal Tap") {
        "/wallet_home/modal/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "modalid"
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Modal close") {
        "/wallet_home/modal/close" (platform: "/mobile", type: TrackType.Event) {
            id = "modalid"
            metadata_user:[
                type: "payer"
            ]
        }
    }

    //Loyalty
    test("Loyalty header tap") {
        "/wallet_home/loyalty/tap" (platform: "/mobile", type: TrackType.Event) {
            loyalty = [
                    level: 9
            ]
            metadata_user = [
                type: "newbie"
            ]
        }
    }

    // New Header
    test("Profile header tap") {
        "/wallet_home/header_profile/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://link"
            button_link = "mercadopago://link"
       	    metadata_user = [
                type: "seller"
            ]
        }
    }

    test("Button header tap") {
        "/wallet_home/header_data_button/tap" (platform: "/mobile", type: TrackType.Event) {}
    }

    /*****************************
     * WALLET HOME TEST TRACKS V3 *
     *****************************/

    test("Mercadopago Home Tap v3") {
        "/wallet_home/section/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="banking"
            component_id="user_banking"
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Tap v3 - Banking") {
        "/wallet_home/section/tap/banking" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="banking"
            component_id="user_banking"
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Tap v3 - Banking V2") {
        "/wallet_home/section/tap/banking_v2/cards" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="banking_v2/cards"
            component_id="cards"
            prepaid = false
            debit = false
            quantity = 1 
        }
    }

    test("Mercadopago Home Tap v3 - BANKING v2 Assets") {
        "/wallet_home/section/tap/banking_v2/assets" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="assets"
            component_id="assets"
            content_id="assets"
            investment_counter=5
            optin_process="kyc"
        }
    }

    test("Mercadopago Home Tap v3 - BANKING v2 Actions") {
        "/wallet_home/section/tap/banking_v2/actions" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="Actions"
            component_id="Actions"
            content_id="Actions"
            position=3
            enabled=true
        }
    }

    test("Mercadopago Home Tap v3 - BANKING v2 balance") {
        "/wallet_home/section/tap/banking_v2/balance" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://balance"
            section_id="Balance"
            component_id="Balance"
            hidden=true
            pending_balance=true
            balance_histogram=3
        }
    }

    //hidden state
    test("Mercadopago Home Show - Hidden state") {
        "/wallet_home/banking_v2/hidden_state" (platform: "/mobile", type: TrackType.View) {
            hidden=true
        }
    }

    test("Mercadopago Home Tap v3 - Hidden state") {
        "/wallet_home/banking_v2/tap/hidden_state" (platform: "/mobile", type: TrackType.Event) {
            hidden=true
        }
    }

    test("Mercadopago Home Tap v3 - QR FAB") {
        "/wallet_home/section/tap/qr_fab" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="qr_fab"
            component_id="qr"
        }
    }

    test("Mercadopago Home Tap v3 - CREDITS") {
        "/wallet_home/section/tap/credits" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="credits"
            component_id="credits"
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
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Tap v3 - QR Map") {
        "/wallet_home/section/tap/qr_map" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="qr_map"
            component_id="user_qr_map"
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Tap v3 - Discount Center") {
        "/wallet_home/section/tap/discount_center" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="discount_center"
            component_id="user_discount_center"
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Tap v3 - Loyalty") {
        "/wallet_home/section/tap/loyalty" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="loyalty"
            component_id="user_loyalty"
            level=4
            percentage=0.32
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Tap v3 - Subscription") {
        "/wallet_home/section/tap/subscription" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://loyalty"
            section_id="subscription"
            component_id="cta"
            level=4
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Tap v3 - Survey") {
        "/wallet_home/section/tap/survey" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="survey"
            component_id="user_survey"
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Tap v3 - Repentance button") {
        "/wallet_home/section/tap/repentance_button" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="repentance_button"
            component_id="repentance_button"
        }
    }

    test("Mercadopago Home Tap v3 - shortcuts") {
        "/wallet_home/section/tap/shortcuts" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="payer"
            component_id="scan_qr"
            from = "section"
            content_id = "business"
            position = 3
            enabled = true
            is_favorite = false
            has_aware = false
            has_label = true
            group_id = "seller"
            group_position = 6
            audience="all"
            bu="1"
            bu_line="10"
            flow="1"
            logic="default"
            user_profile="newbie"
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago Home Tap v3 - shortcuts (without optionals)") {
        "/wallet_home/section/tap/shortcuts" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="payer"
            component_id="scan_qr"
            from = "sheet"
            content_id = "business"
            position = 3
            enabled = true
            is_favorite = false
            has_aware = false
            has_label = true
            metadata_user:[
                type: "payer"
            ]
        }

        "/wallet_home/section/tap/shortcuts" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="payer"
            component_id="scan_qr"
            from = "sheet"
            content_id = "business"
            position = 3
            enabled = true
            is_favorite = false
            has_aware = false
            has_label = true
            has_ripple = false
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago cross sell experiments") {
        "/wallet_home/cross_sell" (platform: "/mobile", type: TrackType.Event) {}
    }


    test("Mercadopago shortcut sheet page view") {
        "/wallet_home/shortcuts_sheet/view" (platform: "/mobile", type: TrackType.View) {
            group_ids = ["payer", "business", "seller", "favorites"]
            shortcut_ids = ["scan_qr", "send_money", "recharge_sube", "money_out", "money_in"]
            metadata_user:[
                type: "payer"
            ]
        }

        "/wallet_home/shortcuts_sheet/view" (platform: "/mobile", type: TrackType.View) {
            group_ids = ["payer", "business", "seller", "favorites"]
            shortcut_ids = ["scan_qr", "send_money", "recharge_sube", "money_out", "money_in"]
            favorite_ids = ["scan_qr", "send_money", "recharge_sube", "money_out", "money_in"]
            has_ftu = false
            metadata_user:[
                type: "payer"
            ]
        }

        "/wallet_home/shortcuts_sheet/dismiss" (platform: "/mobile", type: TrackType.Event) {
            from = "drag"
            time_spent = 122
            metadata_user:[
                type: "payer"
            ]
        }
    }

    test("Mercadopago shortcut favorite edition") { 
        "/wallet_home/shortcuts_sheet/edit" (platform: "/mobile", type: TrackType.Event) {
            metadata_user:[
                type: "payer"
            ]
        }

        "/wallet_home/shortcuts_sheet/edit/drop" (platform: "/mobile", type: TrackType.Event) {
            initial_position = 1
            end_position = 2
            shortcut_id = "scan_qr"
            metadata_user:[
                type: "payer"
            ]
        }

        "/wallet_home/shortcuts_sheet/cancel" (platform: "/mobile", type: TrackType.Event) {
            metadata_user:[
                type: "payer"
            ]
        }

        "/wallet_home/shortcuts_sheet/save" (platform: "/mobile", type: TrackType.View) {
            favorite_ids = ["scan_qr", "send_money", "recharge_sube", "money_out", "money_in"]
            metadata_user:[
                type: "payer"
            ]
        }
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

    // New Banking

    test("Mercadopago MPcard") {

        "/wallet_home/section/tap/banking_v2" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago"
            section_id = "banking_v2"
        }

        "/wallet_home/section/tap/banking_v2/mpcards" (platform: "/mobile", type: TrackType.Event) {
            pill = "NOVO"
            has_card = true
            component_id = "card"
            link = "mercadopago"
            section_id = "banking_v2"
        }


        "/wallet_home/section/tap/banking_v2/mpcards" (platform: "/mobile", type: TrackType.Event) {
            has_nfc_card = true
            component_id = "nfc"
            link = "mercadopago"
            section_id = "banking_v2"
        }
        
        "/wallet_home/section/tap/banking_v2/mpcards" (platform: "/mobile", type: TrackType.Event) {
            card_status = "active"
            component_id = "pay_online"
            link = "mercadopago"
            section_id = "banking_v2"
        }
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
                    link: "mercadopago://link",
                    button_link: "mercadopago://link",
                    loyalty: [
                            level: 5
                    ],
                    metadata_user:[
                            type: "payer"
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
                            quantity: 9,
                            debit: true
                    ],
                    assets: [],
                    credits: [],
                    money_in: [
                            pending_balance: false,
                            balance_histogram: 6
                    ]
            ]
            credits=[]
            banking_v2=[
                hidden : true
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
            shortcuts = [
                    content_type : 'complete',
                    ordinal: 3,
                    favorite_ids: [
                        "scan_qr", "send_money", "recharge_sube", "money_out", "money_in"
                    ],
                    shortcut_ids: [
                        "gran_dia_mcdonals"
                    ],
                    has_view_more: true,
                    has_view_more_ripple: true,
            ]
            prepaid_banner = [
                    content_type : 'partial',
                    ordinal: 4,
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
                    ordinal: 5,
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
                    ordinal: 6,
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
                    ordinal: 7,
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
                    ordinal: 8,
                    level: 3,
                    percentage: 17
            ]
            activities= [
                    content_type : 'partial',
                    ordinal: 9,
                    quantity: 3,
                    is_ftu: false,
                    has_footer: true
            ]
            qr_map= [
                    content_type : 'partial',
                    ordinal: 10,
                    header_title: "¡Pagá con QR en tus locales favoritos!",
                    items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                    link: "mercadopago://discovery/map?from=home_instore_map_section"
            ]
            activities_link= [
                    ordinal: 11,
                    content_type : 'partial'
            ]
            discount_center= [
                    ordinal: 12,
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
                    ordinal: 13,
                    content_type : 'complete'
            ]
            subscription= [
                    content_type : 'partial',
                    ordinal: 14,
                    level: 3,
                    partner: "HBO"
            ]
            repentance_button= [
                    ordinal: 15,
                    content_type : 'complete'
            ]
            metadata = [
                accessibility_voice: false
            ]
        }
    }

    test("Mercadopago Home Update") {
        "/wallet_home/update" (platform: "/mobile", type: TrackType.View) {
            header = [
                    loyalty: [
                            level: 5
                    ],
                    metadata_user:[
                            type: "payer"
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
                            quantity: 9,
                            debit: false
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
            shortcuts = [
                    content_type : 'partial',
                    ordinal: 3,
                    favorite_ids: [
                        "scan_qr", "send_money", "recharge_sube", "money_out", "money_in"
                    ],
                    shortcut_ids: [
                        "gran_dia_mcdonals"
                    ],
                    has_view_more: false
            ]
            prepaid_banner = [
                    content_type : 'partial',
                    ordinal: 4,
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
                    ordinal: 5,
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
                    ordinal: 6,
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
                    ordinal: 7,
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
                    ordinal: 8,
                    level: 3,
                    percentage: 17
            ]
            activities= [
                    content_type : 'partial',
                    ordinal: 9,
                    quantity: 3,
                    is_ftu: false,
                    has_footer: true
            ]
            qr_map= [
                    content_type : 'partial',
                    ordinal: 10,
                    header_title: "¡Pagá con QR en tus locales favoritos!",
                    items: ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"],
                    link: "mercadopago://discovery/map?from=home_instore_map_section"
            ]
            activities_link= [
                    ordinal: 11,
                    content_type : 'partial'
            ]
            discount_center= [
                    ordinal: 12,
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
                    ordinal: 13,
                    content_type : 'complete'
            ]
            subscription= [
                    content_type : 'partial',
                    ordinal: 14,
                    level: 3,
                    partner: "HBO"
            ]
            repentance_button= [
                    ordinal: 15,
                    content_type : 'complete'
            ]
            metadata = [
                accessibility_voice: true
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
            metadata_user = [
                type: "seller"
            ]
        }
    }

    // New Header
    test("Profile header tap") {
        "/wallet_home/header_profile/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://link"
            button_link = "mercadopago://link"
       	    metadata_user = [
                type: "seller"
            ]
        }
    }

    test("Button header tap") {
        "/wallet_home/header_data_button/tap" (platform: "/mobile", type: TrackType.Event) {}
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

    test("Mercadopago Home Tap v3 - Banking V2") {
        "/wallet_home/section/tap/banking_v2/cards" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="banking_v2/cards"
            component_id="cards"
            prepaid = false
            debit = false
            quantity = 1 
        }
    }

    test("Mercadopago Home Tap v3 - BANKING v2 Assets") {
        "/wallet_home/section/tap/banking_v2/assets" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="assets"
            component_id="assets"
            content_id="assets"
            investment_counter=5
            optin_process="kyc"
        }
    }

    test("Mercadopago Home Tap v3 - BANKING v2 Actions") {
        "/wallet_home/section/tap/banking_v2/actions" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="Actions"
            component_id="Actions"
            content_id="Actions"
            position=3
            enabled=true
        }
    }

    test("Mercadopago Home Tap v3 - BANKING v2 balance") {
        "/wallet_home/section/tap/banking_v2/balance" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://balance"
            section_id="Balance"
            component_id="Balance"
            hidden=true
            pending_balance=true
            balance_histogram=3
        }
    }

    //hidden state
    test("Mercadopago Home Show - Hidden state") {
        "/wallet_home/banking_v2/hidden_state" (platform: "/mobile", type: TrackType.View) {
            hidden=true
        }
    }

    test("Mercadopago Home Tap v3 - Hidden state") {
        "/wallet_home/banking_v2/tap/hidden_state" (platform: "/mobile", type: TrackType.Event) {
            hidden=true
        }
    }

    test("Mercadopago Home Tap v3 - QR FAB") {
        "/wallet_home/section/tap/qr_fab" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="qr_fab"
            component_id="qr"
        }
    }

    test("Mercadopago Home Tap v3 - CREDITS") {
        "/wallet_home/section/tap/credits" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="credits"
            component_id="credits"
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

    test("Mercadopago Home Tap v3 - Subscription") {
        "/wallet_home/section/tap/subscription" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://loyalty"
            section_id="subscription"
            component_id="cta"
        }
    }

    test("Mercadopago Home Tap v3 - Survey") {
        "/wallet_home/section/tap/survey" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="survey"
            component_id="user_survey"
        }
    }

    test("Mercadopago Home Tap v3 - Survey") {
        "/wallet_home/section/tap/repentance_button" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="repentance_button"
            component_id="repentance_button"
        }
    }

    test("Mercadopago Home Tap v3 - shortcuts") {
        "/wallet_home/section/tap/shortcuts" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="payer"
            component_id="scan_qr"
            from = "section"
            content_id = "business"
            position = 3
            enabled = true
            is_favorite = false
            has_aware = false
            has_label = true
            group_id = "seller"
            component_id="user_survey"
            group_position = 6
        }

        "/wallet_home/section/tap/shortcuts" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
            section_id="payer"
            component_id="scan_qr"
            from = "sheet"
            content_id = "business"
            position = 3
            enabled = true
            is_favorite = false
            has_aware = false
            has_label = true
            has_ripple = false
        }
    }

    test("Mercadopago cross sell experiments") {
        "/wallet_home/cross_sell" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago shortcut sheet page view") {
        "/wallet_home/shortcuts_sheet/view" (platform: "/mobile", type: TrackType.View) {
            group_ids = ["payer", "business", "seller", "favorites"]
            shortcut_ids = ["scan_qr", "send_money", "recharge_sube", "money_out", "money_in"]
        }

        "/wallet_home/shortcuts_sheet/view" (platform: "/mobile", type: TrackType.View) {
            group_ids = ["payer", "business", "seller", "favorites"]
            shortcut_ids = ["scan_qr", "send_money", "recharge_sube", "money_out", "money_in"]
            favorite_ids = ["scan_qr", "send_money", "recharge_sube", "money_out", "money_in"]
            has_ftu = false
        }

        "/wallet_home/shortcuts_sheet/dismiss" (platform: "/mobile", type: TrackType.Event) {
            from = "drag"
            time_spent = 122
        }
    }

    test("Mercadopago shortcut favorite edition") {
        "/wallet_home/shortcuts_sheet/edit" (platform: "/mobile", type: TrackType.Event) {}

        "/wallet_home/shortcuts_sheet/edit/drop" (platform: "/mobile", type: TrackType.Event) {
            initial_position = 1
            end_position = 2
            shortcut_id = "scan_qr"
        }

        "/wallet_home/shortcuts_sheet/cancel" (platform: "/mobile", type: TrackType.Event) {}

        "/wallet_home/shortcuts_sheet/save" (platform: "/mobile", type: TrackType.View) {
            favorite_ids = ["scan_qr", "send_money", "recharge_sube", "money_out", "money_in"]
        }
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

    ["mercadolibre", "mercadopago"].each { business ->
        defaultBusiness = business

        test("Home Tap v3 - Secondary Actions [${business}]") {
            "/wallet_home/section/tap/secondary_actions"(platform: "/mobile", type: TrackType.Event) {
                audience = "all"
                component_id = "secondary_actions_payers_recharge_sube_mp"
                section_id = "secondary_actions"
                action_id = "default"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                link = "mercadopago://entity/sube"
                position = 1
                logic = "user_journey"
                flow = "default"
            }
            "/wallet_home/section/tap/secondary_actions"(platform: "/mobile", type: TrackType.Event) {
                audience = "all"
                component_id = "secondary_actions_payers_recharge_sube_mp"
                section_id = "secondary_actions"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                logic = "user_journey"
                flow = "default"
            }
        }
        test("Mercadopago Home Tap v3 - Cross Selling [${business}]") {
            "/wallet_home/section/tap/cross_selling" (platform: "/mobile", type: TrackType.Event) {
                audience = "all"
                component_id = "cross_selling_item1"
                section_id = "cross_selling"
                action_id = "default"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                link = "mercadopago://entity/sube"
                logic = "user_journey"
                flow = "default"
                position = 1
            }
            "/wallet_home/section/tap/cross_selling" (platform: "/mobile", type: TrackType.Event) {
                audience = "all"
                component_id = "secondary_actions_payers_recharge_sube_mp"
                section_id = "secondary_actions"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                logic = "user_journey"
                flow = "default"
            }
        }

        test("Mercadopago Home Tap v3 - Prepaid Banner [${business}]") {
            "/wallet_home/section/tap/prepaid_banner" (platform: "/mobile", type: TrackType.Event) {
                audience = "all"
                component_id = "cross_selling_item1"
                section_id = "cross_selling"
                action_id = "default"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                link = "mercadopago://entity/sube"
                logic = "user_journey"
                flow = "default"
                position = 1
            }
            "/wallet_home/section/tap/prepaid_banner" (platform: "/mobile", type: TrackType.Event) {
                audience = "all"
                component_id = "secondary_actions_payers_recharge_sube_mp"
                section_id = "secondary_actions"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                logic = "user_journey"
                flow = "default"
            }
        }
        test("Mercadopago Home Tap v3 - Benefits [${business}]") {
            "/wallet_home/section/tap/benefits" (platform: "/mobile", type: TrackType.Event) {
                audience = "all"
                component_id = "cross_selling_item1"
                section_id = "cross_selling"
                action_id = "default"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                link = "mercadopago://entity/sube"
                logic = "user_journey"
                flow = "default"
                position = 1
            }
            "/wallet_home/section/tap/benefits" (platform: "/mobile", type: TrackType.Event) {
                audience = "all"
                component_id = "secondary_actions_payers_recharge_sube_mp"
                section_id = "secondary_actions"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                logic = "user_journey"
                flow = "default"
            }
        }

    }

    ["mercadolibre", "mercadopago"].each { business ->
        defaultBusiness = business

        test("Merch Control Group [${business}]") {
            "/wallet_home/merch/control_group"(platform: "/mobile", type: TrackType.Event) {
                component_id =  "modal_home_mp_v2"
                content_id = "modal_test_proof_2"
                audience = "all"
                position = 0
                logic = "campaigns"
                bu = "4"
                bu_line = "10"
                flow = "-1"
            }
        }
    }
}
