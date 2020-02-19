package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //Card Listing Flow
    test("Cards Wallet tracking ML") {

        "/wallet/cards/listing"(platform:"/mobile", {})

        "/wallet/cards/detail"(platform:"/mobile", {})

        "/wallet/cards/add_card"(platform:"/mobile", {})
        "/wallet/cards/add_card/success"(platform:"/mobile", {})
        "/wallet/cards/add_card/failed"(platform:"/mobile", {})

        "/wallet/cards/detail/delete_card"(platform:"/mobile", {})
        "/wallet/cards/detail/delete_card/success"(platform:"/mobile", {})
        "/wallet/cards/detail/delete_card/failed"(platform:"/mobile", {})

        "/wallet/cards/back"(platform:"/mobile", {})

        "/wallet/cards/add_card_header"(platform: "/mobile", {})
    }

    test("New Digital Wallet - Ukraine Lab") {
        /**
         * Digital Wallet Tracks
         */

        "/new_digital_wallet"(platform: "/", type: TrackType.View) {
            landing_id = 'ukraine lab'
        }
        "/new_digital_wallet/click_download_app"(platform: "/", type: TrackType.Event) {
            landing_id = 'ukraine lab'
            section_store = "hero_googleplay"
        }
        "/new_digital_wallet/click_download_app"(platform: "/", type: TrackType.Event) {
            landing_id = 'ukraine lab'
            section_store = "fixed_appstore"
        }
        "/new_digital_wallet/click_download_app"(platform: "/", type: TrackType.Event) {
            landing_id = 'ukraine lab'
            section_store = "footer_appstore"
        }
    }

    defaultBusiness = "mercadopago"

    //Card Listing Flow
    test("Cards Wallet tracking ML") {

        "/wallet/cards/listing"(platform:"/mobile", {})

        "/wallet/cards/detail"(platform:"/mobile", {})

        "/wallet/cards/add_card"(platform:"/mobile", {})
        "/wallet/cards/add_card/success"(platform:"/mobile", {})
        "/wallet/cards/add_card/failed"(platform:"/mobile", {})

        "/wallet/cards/detail/delete_card"(platform:"/mobile", {})
        "/wallet/cards/detail/delete_card/success"(platform:"/mobile", {})
        "/wallet/cards/detail/delete_card/failed"(platform:"/mobile", {})

        "/wallet/cards/back"(platform:"/mobile", {})

        "/wallet/cards/add_card_header"(platform: "/mobile", {})
    }

}
