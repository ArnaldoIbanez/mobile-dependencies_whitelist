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
            [
                section_id: "section3",
                items: [
                    item_id: "item21",
                 ],
             ],
           ]
        }
    }

    test("Mercadopago Webview COVID Home") {
        "/mp_covid"(platform: "/", type: TrackType.View) {}
    }

    test("Mercadopago Webview COVID Congrats") {
        "/mp_covid/congrats"(platform: "/", type: TrackType.View) {}
    }

    test("Mercadopago Webview COVID Donation") {
        "/mp_covid/donation"(platform: "/", type: TrackType.View) {}
    }

    test("Mercadopago Webview COVID Custom amount") {
        "/mp_covid/custom_amount"(platform: "/", type: TrackType.View) {}
    }



    /*************************
    *        MP PUBLIC       *
    *************************/

    test("Digital Wallet") {
        /**
         * Digital Wallet Screen Tracks
         */

        "/digital_wallet"(platform: "/", type: TrackType.View) {}

        /**
         * Digital Wallet Events Tracks
         */

        "/digital_wallet/click_show_video"(platform: "/", type: TrackType.Event) {
            section = "facilities_recharge"
        }

        "/digital_wallet/click_download_app"(platform: "/", type: TrackType.Event) {
            section_store = "hero_playstore"
        }
    }

    test("Business Site") {
        /**
         * Business Site Screen Tracks
         */

        "/business_site"(platform: "/", type: TrackType.View) {}

        /**
         * Business Site Events Tracks
         */
        
        "/business_site/click"(platform: "/", type: TrackType.Event) {
          action = "shortcut"
          section = "digital"
        }

        "/business_site/click"(platform: "/", type: TrackType.Event) {
          action = "know_more"
          section = "digital",
          item = "checkout"
        }

        "/business_site/click"(platform: "/", type: TrackType.Event) {
          action = "new_account"
          section = "last",
        }
    }
}