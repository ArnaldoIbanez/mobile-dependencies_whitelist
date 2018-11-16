import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //VIP FLOW
    test("Wallet tracking in android") {

        "/wallet/cards"(platform:"/mobile", {
            cards_quantity = 10
            saved_cards = [{
                            card_id="123456"
                            payment_method_name="master"
                            last_four_digits="1234"
                         },{
                            card_id="321412"
                            payment_method_name="visa"
                            last_four_digits="9987"
                            }
                        ]}
        )

        "/wallet/cards/add_card"(platform:"/mobile", {})

        "/wallet/cards/back"(platform:"/mobile", {})

        "/wallet/cards/add_card_header"(platform: "/mobile", {})

    }

    defaultBusiness = "mercadopago"

    //VIP FLOW
    test("Wallet tracking in android") {

        "/wallet/cards"(platform:"/mobile", {
            cards_quantity = 10
            saved_cards = [{
                            card_id="123456"
                            payment_method_name="master"
                            last_four_digits="1234"
                         },{
                            card_id="321412"
                            payment_method_name="visa"
                            last_four_digits="9987"
                            }
                        ]}
        )

        "/wallet/cards/add_card"(platform:"/mobile", {})

        "/wallet/cards/back"(platform:"/mobile", {})

        "/wallet/cards/add_card_header"(platform: "/mobile", {})


    }

}
