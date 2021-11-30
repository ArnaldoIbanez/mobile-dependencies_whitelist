package src.test.resources.component_prints
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

    test("Mercadopago Home print banking balance") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            banking_v2_balance = [
                    [
                            component_id: "balance",
                            balance_histogram: 6.0,
                            hidden: false,
                            pending_balance: false
                    ]
            ]
        }
    }

    test("Mercadopago Home print banking balance") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            banking_v2_actions = [
                    [
                            component_id: "actions",
                            content_id: "action1",
                            position: 1,
                            enabled: true
                    ]
            ]
        }
    }

    test("Mercadopago Home print banking balance") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            banking_v2_cards = [
                    [
                            quantity: 2,
                            prepaid: true,
                            component_id: "cards",
                            debit: true
                    ]
            ]
        }
    }

    test("Mercadopago Home print shortcuts") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            shortcuts = [
                    [
                            component_id: "business_stores_pos",
                            group_position: 6.0,
                            is_favorite: false,
                            content_id: "general",
                            group_id: "business",
                            hasLabel: false,
                            from: "section",
                            user_profile: "newbie",
                            enabled: true,
                            logic: "business",
                            has_aware: false,
                            has_ripple: false
                    ]
            ]
        }
    }

    test("Mercadopago Home print discount_center") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            discount_center = [
                    [
                            component_id: "discount_center_container"
                    ]
            ]
        }
    }

    test("Mercadopago Home print pendings") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            pendings = [
                    [
                            logic: "logic",
                            criticality: 2,
                            position: 1,
                            from: "section",
                            content_id: "security",
                            flow: "flow",
                            bu_line: "bu",
                            component_id: "pending",
                            bu: "mp",
                            audience: "audience1"
                    ]
            ]
        }
    }

    test("Mercadopago Home print loyalty") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            loyalty = [
                    [
                            component_id: "discount_center_container"
                            level: 2
                            percentage: 10
                    ]
            ]
        }
    }

    test("Mercadopago Home print cross selling") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            cross_selling = [
                    [
                            component_id: "ad1",
                            audience: "audience1",
                            bu: "mp",
                            content_id: "security",
                            action_id: "action1",
                            bu_line: "bu",
                            logic: "logic",
                            position: 1,
                            flow: "flow"
                    ]
            ]
        }
    }

    test("Mercadopago Home print benefits") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            benefits = [
                    [
                            component_id: "benefit1",
                            audience: "audience1",
                            bu: "mp",
                            content_id: "security",
                            action_id: "action1",
                            bu_line: "bu",
                            logic: "logic",
                            position: 1,
                            flow: "flow"
                    ]
            ]
        }
    }

    test("Mercadopago Home print prepaid banner") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            prepaid_banner1 = [
                    [
                            component_id: "banner1",
                            audience: "audience1",
                            bu: "mp",
                            content_id: "promo1",
                            action_id: "action1",
                            bu_line: "bu",
                            logic: "logic",
                            position: 1,
                            flow: "flow"
                    ]
            ]
        }
    }
}
