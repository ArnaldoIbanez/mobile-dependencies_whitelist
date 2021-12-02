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

    test("Mercadopago Home print Shortcuts") {
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

    test("Mercadopago Home print DiscountCenter") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            discount_center = [
                    [
                            component_id: "discount_center_container"
                    ]
            ]
        }
    }

    test("Mercadopago Home print Pendings") {
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

    test("Mercadopago Home print Loyalty") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            loyalty = [
                    [
                            component_id: "discount_center_container",
                            level: 2,
                            percentage: 10
                    ]
            ]
        }
    }

    test("Mercadopago Home print CrossSelling") {
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

    test("Mercadopago Home print Benefits") {
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

    test("Mercadopago Home print PrepaidBanner") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            prepaid_banner = [
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

    test("Mercadopago Home print Credits") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            credits = [
                    [
                            component_id: "banner1"
                    ]
            ]
        }
    }

    test("Mercadopago Home print Activities") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            activities = [
                    [
                            component_id: "banner1",
                            contains_rta: false
                    ]
            ]
        }
    }

    test("Mercadopago Home print Survey") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            survey = [
                    [
                            component_id: "survey1"
                    ]
            ]
        }
    }

    test("Mercadopago Home print Subscription") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            subscription = [
                    [
                            component_id: "subscription1"
                    ]
            ]
        }
    }

    test("Mercadopago Home print BuyLevelSubscription") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            buy_level_subscription = [
                    [
                            component_id: "buy_level_subscription1"
                    ]
            ]
        }
    }

    test("Mercadopago Home print RepentanceButton") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            repentance_button = [
                    [
                            component_id: "repentance_button1"
                    ]
            ]
        }
    }

    test("Mercadopago Home print BcraRegulation") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            bcra_regulation = [
                    [
                            component_id: "bcra_regulation1"
                    ]
            ]
        }
    }
}
