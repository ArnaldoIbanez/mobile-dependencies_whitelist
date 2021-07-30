package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    initiative = "1125"
    defaultBusiness = "mercadolibre"

    //Card Listing Flow
    test("Cards Wallet tracking ML") {

        "/wallet/cards/listing"(platform:"/mobile", {
            version = "2.0"
        })

        "/wallet/cards/detail"(platform:"/mobile", {})

        "/wallet/cards/add_card"(platform:"/mobile", {
            id_banner = "cards_list_prepaid_banner_acquisition"
            other_cards = true
        })
        "/wallet/cards/add_card/success"(platform:"/mobile", {})
        "/wallet/cards/add_card/failed"(platform:"/mobile", {})

        "/wallet/cards/detail/delete_card"(platform:"/mobile", {})
        "/wallet/cards/detail/delete_card/success"(platform:"/mobile", {})
        "/wallet/cards/detail/delete_card/failed"(platform:"/mobile", {})

        "/wallet/cards/back"(platform:"/mobile", {})

        "/wallet/cards/add_card_header"(platform: "/mobile", {})
    }

    //Card Listing Error
    test("Card listing show error ML") {
        "/wallet/cards/listing/error"(platform: "/mobile") {
            screen = "cards_listing"
        }
    }
}
