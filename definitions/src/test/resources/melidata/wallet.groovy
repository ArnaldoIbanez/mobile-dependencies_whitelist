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
         * New Digital Wallet Tracks - Ukraine Lab
         */
        "/new_digital_wallet"(platform: "/"){
            landing_id = "ukraine lab"
        }
        "/new_digital_wallet/click_download_app"(platform: "/"){
            landing_id = "ukraine lab"
            section = "hero"
        }
        "/new_digital_wallet/click_download_app"(platform: "/"){
            landing_id = "ukraine lab"
            section = "fixed"
        }
        "/new_digital_wallet/click_download_app"(platform: "/"){
            landing_id = "ukraine lab"
            section = "footer"
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
