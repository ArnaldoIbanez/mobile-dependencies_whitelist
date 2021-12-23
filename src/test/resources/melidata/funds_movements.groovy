package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"
    /**
        Unification tracks
    **/

    test("MoneyTransfer") {

        // Unification - New Transfer
        "/funds_movements/new_transfer"(platform: "/mobile") {}
        "/funds_movements/new_transfer/search"(platform: "/mobile") {}
        "/funds_movements/new_transfer/search_result"(platform: "/mobile") {
            is_empty = true
        }
        "/funds_movements/new_transfer/contact_selected"(platform: "/mobile") {}
        "/funds_movements/new_transfer/pill/tapped"(platform: "/mobile") {
	        type_id = "CNPJ"
        }
        "/funds_movements/new_transfer/pill/tapped/format_match"(platform: "/mobile") {
            success = true
        }
        "/funds_movements/new_transfer/continue"(platform: "/mobile") {}

        // Unification - Bottom Sheet
        "/funds_movements/bottom_sheet"(platform: "/mobile") {
            total = 2
            accounts = [[type: "MP"], [type: "BANKING", warning: "BLOCKER"]]
        }
        "/funds_movements/bottom_sheet"(platform: "/mobile") {
            total = 1
        }
        "/funds_movements/bottom_sheet/account_selected"(platform: "/mobile") {
            type = "MP"
        }

        // Unification - Manual Amount
        "/funds_movements/manual_amount"(platform: "/mobile") {}
        "/funds_movements/manual_amount/continue"(platform: "/mobile") {
            transaction_amount = 200
            has_reason = true
        }
        "/funds_movements/manual_amount/emoji_selected"(platform: "/mobile") {
            position = 0
        }
    }
}
