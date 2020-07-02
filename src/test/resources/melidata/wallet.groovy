package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    //Card Listing Flow
    test("Cards Wallet tracking MP") {

        "/wallet/cards/listing"(platform:"/mobile", {
            version = "2.0"
        })

        "/wallet/cards/detail"(platform:"/mobile", {
            version = "2.0"
        })

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

        "/wallet/cards/banner_print"(platform: "/mobile", {
            id = "cards_list_prepaid_banner_acquisition"
            type = "primary"
            title = "Pedí tu tarjeta"
            description = "Podés usarla donde quieras"
            image = "cards_list_prepaid_banner"
            secondary_image = "cards_list_prepaid_banner_2"
            background = "#FFFFFF"
            chevron_color = "#000000" 
            action = [link: "mercadopago://meli-cards/prepaid/acquisition/init-point"]
        })
        "/wallet/cards/banner_tap"(platform: "/mobile", {
            id = "cards_list_prepaid_banner_acquisition"
            type = "primary"
            title = "Pedí tu tarjeta"
            description = "Podés usarla donde quieras"
            image = "cards_list_prepaid_banner"
            secondary_image = "cards_list_prepaid_banner_2"
            background = "#FFFFFF"
            chevron_color = "#000000"            
            action = [link: "mercadopago://meli-cards/prepaid/acquisition/init-point"]
        })
    }

    //Card Listing Error
    test("Card listing show error MP") {
        "/wallet/cards/listing/error"(platform: "/mobile") {
            screen = "cards_listing"
        }
    }
}
