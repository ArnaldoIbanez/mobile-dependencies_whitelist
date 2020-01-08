package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    /*************************
    *     ACTIVITY WEB    *
    *************************/

    test("Mercadopago Home") {
        "/mp_home" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities List") {
        "/listing/activities" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Gateway List") {
        "/listing/gateway" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities Detail") {
        "/activity/detail" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities Detail Shipping") {
        "/activity/detail/shipping" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities Balance") {
        "/activities/balance" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities PNF Adelantos") {
        "/activities/balance/advances" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities PNF Adelantos Congrats") {
        "/activities/balance/advances/congrats" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Activities Export") {
        "/activities/export" (platform: "/web", type: TrackType.View) {}
    }

    test("Mercadopago Shields") {
        "/shield" (platform: "/web", type: TrackType.View) {}
    }

    test("Panel Layout") {
        "/panel_layout" (platform: "/web", type: TrackType.View) {
           navigationSections = [[
                section_id: "section1",
                items: [
                  item_id: "item1",
                  sub_items: [
                      sub_item_id: "sub_item_1"
                  ]
                ]
            ],
            [
                section_id: "section2",
                items: [
                    item_id: "item21",
                    sub_items: [

                    ]
                ],
            ],
           ]
        }
    }
}