package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"
    test("Transport") {
        "/transport/recents"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/packages"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/recommended_amount"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/card_number"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/card_name"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/amount"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/products"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/days_quantity"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/carrousel"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/topup_helper"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/combined_packages"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/combined_amount"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/validation_points"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/no_money"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/first_use"(platform: "/mobile") {
            flow = "/transport"
        }
        "/transport/error"(platform: "/mobile") {
            flow = "/transport"
        }
    }
}