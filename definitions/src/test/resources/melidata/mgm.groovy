package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("MGM track ML") {

        // MOBILE
        // Access MGM flow
        "/mgm/payers/init"(platform: "/mobile", type: TrackType.Event) {
            origin = "row"
        }

        // Invite Screen
        "/mgm/payers/invite"(platform: "/mobile", type: TrackType.View) {}

        // Invite Screen Events
        "/mgm/payers/invite/invite"(platform: "/mobile", type: TrackType.Event) {
            media = "whatsapp"
        }
        "/mgm/payers/invite/back"(platform: "/mobile", type: TrackType.Event) {}
        "/mgm/payers/invite/terms"(platform: "/mobile", type: TrackType.Event) {}

        // Redeem Screen
        "/mgm/payers/redeem"(platform: "/mobile", type: TrackType.View) {}
        "/mgm/payers/redeem/option"(platform: "/mobile", type: TrackType.Event) {
            option = "cellphone_recharge"
        }
        "/mgm/payers/redeem/terms"(platform: "/mobile", type: TrackType.Event) {}

        // No Redeem Screen
        "/mgm/payers/no_redeem"(platform: "/mobile", type: TrackType.View) {}

        // No Redeem Screen Events
        "/mgm/payers/no_redeem/invite"(platform: "/mobile", type: TrackType.Event) {
            media = "whatsapp"
        }
        "/mgm/payers/no_redeem/back"(platform: "/mobile", type: TrackType.Event) {}
        "/mgm/payers/no_redeem/terms"(platform: "/mobile", type: TrackType.Event) {}

        // WEB
        "/mgm/payers/stop_landing"(platform: "/web", type: TrackType.View) {
            type = "use_coupon"
        }
        "/mgm/payers/stop_landing/redirect"(platform: "/web", type: TrackType.Event) {
            type = "use_coupon"
            promoter = "123456"
        }
    }

    defaultBusiness = "mercadopago"

    test("MGM track MP") {

        // MOBILE
        // Access MGM flow
        "/mgm/payers/init"(platform: "/mobile", type: TrackType.Event) {
            origin = "row"
        }

        // Invite Screen
        "/mgm/payers/invite"(platform: "/mobile", type: TrackType.View) {}

        // Invite Screen Events
        "/mgm/payers/invite/invite"(platform: "/mobile", type: TrackType.Event) {
            media = "whatsapp"
        }
        "/mgm/payers/invite/back"(platform: "/mobile", type: TrackType.Event) {}
        "/mgm/payers/invite/terms"(platform: "/mobile", type: TrackType.Event) {}

        // Redeem Screen
        "/mgm/payers/redeem"(platform: "/mobile", type: TrackType.View) {}
        "/mgm/payers/redeem/option"(platform: "/mobile", type: TrackType.Event) {
            option = "cellphone_recharge"
        }
        "/mgm/payers/redeem/terms"(platform: "/mobile", type: TrackType.Event) {}

        // No Redeem Screen
        "/mgm/payers/no_redeem"(platform: "/mobile", type: TrackType.View) {}

        // No Redeem Screen Events
        "/mgm/payers/no_redeem/invite"(platform: "/mobile", type: TrackType.Event) {
            media = "whatsapp"
        }
        "/mgm/payers/no_redeem/back"(platform: "/mobile", type: TrackType.Event) {}
        "/mgm/payers/no_redeem/terms"(platform: "/mobile", type: TrackType.Event) {}

        // WEB
        "/mgm/payers/stop_landing"(platform: "/web", type: TrackType.View) {
            type = "use_coupon"
        }
        "/mgm/payers/stop_landing/redirect"(platform: "/web", type: TrackType.Event) {
            type = "use_coupon"
            promoter = "123456"
        }
    }
}
