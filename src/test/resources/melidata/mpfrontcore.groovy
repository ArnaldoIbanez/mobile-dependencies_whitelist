package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    /******************************************
    *              MP FRONT CORE              *
    ******************************************/

    /**
     * Tracks Tests - Loggued Context
     */

    test("Mercadopago Home") {
        "/mp_home" (platform: "/", type: TrackType.View) {}
    }

    test("Mercadopago Profile") {
        "/profile" (platform: "/", type: TrackType.View) {}
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
        "/panel_layout" (platform: "/", type: TrackType.View) {
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

    test("Banking Balannce MP") {
        "/banking/balance"(platform: "/", type: TrackType.View) {}
    }

    test("Banking Calendar MP") {
        "/banking/calendar"(platform: "/", type: TrackType.View) {}
    }

    test("Banking PNF") {
        "/banking/pnf"(platform: "/", type: TrackType.View) {}
    }


    /**
     * Tracks Tests - Public Context
     */

    test("Digital Wallet") {
        "/digital_wallet"(platform: "/", type: TrackType.View) {}
        "/digital_wallet/click_show_video"(platform: "/", type: TrackType.Event) {
            section = "facilities_recharge"
        }
        "/digital_wallet/click_download_app"(platform: "/", type: TrackType.Event) {
            section_store = "hero_playstore"
        }
    }

    test("Business Site") {
        "/business_site"(platform: "/", type: TrackType.View) {}
        "/business_site/click"(platform: "/", type: TrackType.Event) {
          action = "shortcut"
          section = "digital"
        }
        "/business_site/click"(platform: "/", type: TrackType.Event) {
          action = "know_more"
          section = "digital"
          item = "checkout"
        }
        "/business_site/click"(platform: "/", type: TrackType.Event) {
          action = "new_account"
          section = "last"
        }
    }
    
    test("Splinter MP Landings") {
      "/landing/marketing"(platform: "/", type: TrackType.View) {
        key = 'landing-de-prueba'
        startTime = "2020-05-17T00:00:00Z"
        endTime = "2020-06-30T00:00:00Z"
      }
    }
}
