import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadopago"

    test("Crypto Dashboard") {
            "/crypto" (platform: "/mobile", type: TrackType.View) {
                user_profile = "newbie"
                kyc_challenge_shown = 'yes'
                crypto = [
                    melicoin : [
                        price : 9,
                        variation :  20.84,
                        holdings : 0.000214 ],
                    bitcoin : [
                        price : 9,
                        variation :  20.84,
                        holdings : 0.000214 ],
                    ethereum : [
                        price : 9,
                        variation :  20.84,
                        holdings : 0.000214 ],
                    usdp : [
                        price : 9.86,
                        variation :  20.84,
                        holdings : 0.000214 ]
                ]
            }
            "/crypto/tap_educational" (platform: "/mobile", type: TrackType.Event) {
                user_profile = "newbie"
                kyc_challenge_shown = 'yes'
                crypto = [
                    melicoin : [
                        price : 9,
                        variation :  20.84,
                        holdings : 0.000214 ],
                    bitcoin : [
                        price : 9,
                        variation :  20.84,
                        holdings : 0.000214 ],
                    ethereum : [
                        price : 9,
                        variation :  20.84,
                        holdings : 0.000214 ],
                    usdp : [
                        price : 9.86,
                        variation :  20.84,
                        holdings : 0.000214 ]
                ]
                event_category = "crypto"
                event_action = "tap"
                event_label = "slider_educational"
            }
            "/crypto/buy_intention" (platform: "/mobile", type: TrackType.Event) {
                user_profile = "newbie"
                kyc_challenge_shown = 'yes'
                crypto = [
                    melicoin : [
                        price : 9,
                        variation :  -20.84,
                        holdings : 0.000214 ],
                    bitcoin : [
                        price : 9,
                        variation :  20.84,
                        holdings : 0.000214 ],
                    ethereum : [
                        price : 9,
                        variation :  20.84,
                        holdings : 0.000214 ],
                    usdp : [
                        price : 9.86,
                        variation :  20.84,
                        holdings : 0.000214 ]
                ]
                event_category = "crypto"
                event_action = "buy_intention"
                event_label = "crypto_home"
            }
            "/crypto/sell_intention" (platform: "/mobile", type: TrackType.Event) {
                user_profile = "newbie"
                kyc_challenge_shown = 'yes'
                crypto = [
                    melicoin : [
                        price : 9,
                        variation :  20.84,
                        holdings : 0.000214 ],
                    bitcoin : [
                        price : 9576765,
                        variation :  20.84,
                        holdings : 0.000214 ],
                    ethereum : [
                        price : 9345,
                        variation :  -20.84,
                        holdings : 0.000214 ],
                    usdp : [
                        price : 9.86,
                        variation :  -20.84,
                        holdings : 0.000214 ]
                ]
                event_category = "crypto"
                event_action = "sell_intention"
                event_label = "crypto_home"
            }
    }

    test("Crypto Blocking screens") {
            // Blocking screens
            "/crypto/juridical_person" (platform: "/mobile", type: TrackType.View) {
                user_profile = "newbie"
            }
            "/crypto/kyc" (platform: "/mobile", type: TrackType.View) {
                user_profile = "newbie"
                context = "crypto_home_row"
            }
            "/crypto/kyc" (platform: "/mobile", type: TrackType.View) {
                user_profile = "newbie"
                context = "buy_attempt"
            }
            "/crypto/kyc/pending" (platform: "/mobile", type: TrackType.View) {
                user_profile = "newbie"
                context = "crypto_home_row"
            }
            "/crypto/kyc/pending" (platform: "/mobile", type: TrackType.View) {
                user_profile = "newbie"
                context = "buy_attempt"
            }
            "/crypto/identity/pending_validation" (platform: "/mobile", type: TrackType.View) {
                user_profile = "newbie"
                context = "buy_attempt"
                operationType = "sell_crypto"
            }
            "/crypto/identity/rejected_validation" (platform: "/mobile", type: TrackType.View) {
                user_profile = "newbie"
                context = "buy_attempt"
                operationType = "sell_crypto"
            }
            "/crypto/money_in_required" (platform: "/mobile", type: TrackType.View) {
                user_profile = "newbie"
                context = "buy_attempt"
                operationType = "sell_crypto"
            }
    }

    test("Crypto Balance Page") {
         "/crypto/balance" (platform: "/mobile", type: TrackType.View) {
            user_profile = "newbie"
            kyc_challenge_shown = "yes"
            crypto = [
                melicoin : [
                    price : 9,
                    variation :  20.84,
                    holdings : 0.000214 ],
                bitcoin : [
                    price : -9,
                    variation :  20.84,
                    holdings : 0.000214 ],
                ethereum : [
                    price : 9,
                    variation :  20.84,
                    holdings : 0.000214 ],
                usdp : [
                    price : -9.86,
                    variation :  20.84,
                    holdings : 0.000214 ]
            ]
        }
         "/crypto/balance/buy_intention" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            crypto = [
                melicoin : [
                    price : 9,
                    variation :  20.84,
                    holdings : 0.000214 ],
                bitcoin : [
                    price : -9,
                    variation :  20.84,
                    holdings : 0.000214 ],
                ethereum : [
                    price : 9,
                    variation :  20.84,
                    holdings : 0.000214 ],
                usdp : [
                    price : -9.86,
                    variation :  20.84,
                    holdings : 0.000214 ]
            ]
            event_category = "crypto"
            event_action = "buy_intention"
            event_label = "crypto_balance"
        }
        "/crypto/balance/sell_intention" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            crypto = [
                melicoin : [
                    price : 9,
                    variation :  20.84,
                    holdings : 0.000214 ],
                bitcoin : [
                    price : -9,
                    variation :  20.84,
                    holdings : 0.000214 ],
                ethereum : [
                    price : 9,
                    variation :  20.84,
                    holdings : 0.000214 ],
                usdp : [
                    price : -9.86,
                    variation :  20.84,
                    holdings : 0.000214 ]
            ]
            event_category = "crypto"
            event_action = "sell_intention"
            event_label = "crypto_balance"
        }
    }

    test("Buy Crypto Calculate Page") {
        //Calculate view
        "/crypto/buy" (platform: "/mobile", type: TrackType.View) {
            user_profile = "newbie"
            crypto = "ethereum"
            available_amount = 6876574.76
        }
        "/crypto/buy/insert_invalid_amount" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            crypto = "bitcoin"
            available_amount = 6876574.76
            event_category = "crypto"
            event_action = "insert_invalid_amount"
            event_label = "exceeds_weekly_cap"
        }
    }

    test("Comfirm buy Crypto Calculate Page") {
        "/crypto/buy/confirm_buy_amount" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            amount = 78987.554
            crypto = "bitcoin"
            event_category = "crypto"
            event_action = "confirm_buy_amount"
        }
    }

    test("Sell Crypto Calculate Page") {
        "/crypto/sell" (platform: "/mobile", type: TrackType.View) {
            user_profile = "newbie"
            crypto = "bitcoin"
        }
        "/crypto/sell/insert_invalid_amount" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            crypto = "bitcoin"
            event_category = "crypto"
            event_action = "insert_invalid_amount"
            event_label = "exceeds_holdings"
        }
    }

    test("Comfirm Sell Crypto Calculate Page") {
        "/crypto/sell/confirm_sell_amount" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            crypto = "bitcoin"
            amount = 78987.554
            event_category = "crypto"
            event_action = "confirm_sell_amount"
        }
    }

    test("Review Sell Page") {
        "/crypto/sell/review" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            amount = 78987.554
            crypto = "ethereum"
            fee = 7.554
            quote = [
                quote_id : "123123234",
                value : 4878984.78
            ]
        }
        "/crypto/sell/review/confirm_sell" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            amount = 78987.554
            crypto = "ethereum"
            fee = 7.554
            quote = [
                quote_id : "123123234",
                value : 4878984.78
            ]
            event_category = "crypto"
            event_action = "confirm_sell"
        }
    }

    test("Review Buy Page") {
        "/crypto/buy/review" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            amount = 78987.554
            crypto = "ethereum"
            fee = 7.554
            quote = [
                quote_id : "123123234",
                value : 4878984.78
            ]
        }
        "/crypto/buy/review/confirm_buy" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            amount = 78987.554
            crypto = "ethereum"
            fee = 7.554
            quote = [
                quote_id : "123123234",
                value : 4878984.78
            ]
            event_category = "crypto"
            event_action = "confirm_buy"
        }
    }

    test("Congrats Page") {
        "/crypto/buy/congrats" (platform: "/mobile", type: TrackType.View) {
            user_profile = "newbie"
            amount = 78987.554
            crypto = "ethereum"
            payment = [
                id: "1233112123",
                status: "ok",
                paid_amount: 123123.23,
                payment_method : "account_money"
            ]
            quote = [
                quote_id : "123123234",
                value : 4878984.78
            ]
            congrats_status = "ok"
        }
        "/crypto/sell/congrats" (platform: "/mobile", type: TrackType.View) {
            user_profile = "newbie"
            amount = 78987.554
            crypto = "ethereum"
            payment = [
                id: "1233112123",
                status: "ok",
                paid_amount: 123123.23,
                payment_method : "account_money"
            ]
            quote = [
                quote_id : "123123234",
                value : 4878984.78
            ]
            congrats_status = "ok"
        }
    }
    test("Movement Detail Page") {
        "/crypto/movements/detail" (platform: "/mobile", type: TrackType.View) {
            user_profile = "newbie"
            context = "movements_detail"
            crypto = "ethereum"
            operation_type = "sell_crypto"
            operation_date = "2019-10-12T07:20:50.52Z"
            fee = 789878.456
            payment = [
                id: "1233112123",
                status: "ok",
                paid_amount: 123123.23,
                payment_method : "account_money"
            ]
            quote = [
                quote_id : "123123234",
                value : 4878984.78
            ]
        }
        "/crypto/movements/detail/need_help" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            context = "movements_detail"
            crypto = "ethereum"
            operation_type = "sell_crypto"
            operation_date = "2019-10-12T07:20:50.52Z"
            fee = 789878.456
            payment = [
                id: "1233112123",
                status: "ok",
                paid_amount: 123123.23,
                payment_method : "account_money"
            ]
            quote = [
                quote_id : "123123234",
                value : 4878984.78
            ]
        event_category = "crypto"
        event_action = "need_help"
        }
    }
    test("Movements Page") {
        "/crypto/movements" (platform: "/mobile", type: TrackType.View) {
            user_profile = "newbie"
            operation = [
                {operation_type : "sell_crypto"
                crypto: "bitcoin"
                amount: 10
                operation_date: "2019-10-12T07:20:50.52Z"}
                {operation_type : "buy_crypto"
                crypto: "bitcoin"
                amount: 15
                operation_date: "2019-10-12T07:20:50.52Z"}
            ]
        }
    }
    test("Onboarding Page") {
        "/crypto/onboarding" (platform: "/mobile", type: TrackType.View) {
            user_profile = "newbie"
        }
        "/crypto/onboarding/opt_in" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            event_category = "crypto"
            event_action = "opt_in"
        }
    }
    test("Onboarding Page") {
        "/crypto/load_error" (platform: "/mobile", type: TrackType.View) {
            user_profile = "newbie"
            errors = "no_internet_connection"
        }
        "/crypto/load_error" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            errors = "not_available_on_country"
        }
        "/crypto/load_error" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            errors = "no_site_connection"
        }
        "/crypto/load_error" (platform: "/mobile", type: TrackType.Event) {
            user_profile = "newbie"
            errors = "cant_show_data"
        }
    }
}
