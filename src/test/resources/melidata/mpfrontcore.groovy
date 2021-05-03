package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    /******************************************
    *     Payments - All - Front End Core     *
    ******************************************/

    /**
     * Tracks Tests - Loggued Context
     */

    test("Mercadopago Home") {
        "/mp_home" (platform: "/", type: TrackType.View) {}
    }

    test("Mercadopago Home regret HUB") {
        "/mp_home/regret" (platform: "/", type: TrackType.View) {}
    }

    test("Mercadopago 404") {
        "/not-found" (platform: "/", type: TrackType.View) {}
    }

    test("Mercadopago Home Merch Engine Events") {
        "/mp_home/sections/crossselling/print" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/crossselling/view" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/crossselling/tap" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/discountbenefits/print" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/discountbenefits/view" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/discountbenefits/tap" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/prioritymessages/print" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/prioritymessages/view" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/prioritymessages/tap" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/promobanner/print" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/promobanner/view" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/promobanner/tap" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/oneshotmodal/print" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/oneshotmodal/view" (platform: "/", type: TrackType.Event) {}
        "/mp_home/sections/oneshotmodal/tap" (platform: "/", type: TrackType.Event) {}
    }

    test("Mercadopago Home Shortcuts") {
        "/mp_home/sections/shortcuts"(platform: "/", type: TrackType.Event) {
            shortcut_id = "money_send"
            section_id = "shortcut"
            bu_team = "mpfc"
            action = "click"
            destination = "www.test.com"
        }
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

    test("Mercadopago Landing Home") {
        "/landing/home" (platform: "/web") {}
        "/landing/home/click"(platform: "/", type: TrackType.Event) {
            id = "digital-account"
        }
    }

    test("Mercadopago Landing Cuenta / Conta") {
        "/landing/digital_account" (platform: "/") {}
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
