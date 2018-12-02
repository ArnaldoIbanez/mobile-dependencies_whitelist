package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    /**
     * ACCOUNT FUND Screen Tracks
     */

    test("Account Fund - views") {
        "/account_fund/select_method"(platform: "/", type: TrackType.View) {}
        "/account_fund/amount"(platform: "/", type: TrackType.View) {}
        "/account_fund/agencies_map"(platform: "/", type: TrackType.View) {}
        "/account_fund/ftu"(platform: "/", type: TrackType.View) {}
        "/account_fund/unique_code"(platform: "/", type: TrackType.View) {}
        "/account_fund/unique_code/help"(platform: "/", type: TrackType.View) {}

        "/account_fund/px/card_vault"(platform: "/", type: TrackType.View) {}
        "/account_fund/px/card_number"(platform: "/", type: TrackType.View) {}
        "/account_fund/px/card_holder_name"(platform: "/", type: TrackType.View) {}
        "/account_fund/px/card_expiry_date"(platform: "/", type: TrackType.View) {}
        "/account_fund/px/card_security_code"(platform: "/", type: TrackType.View) {}
        "/account_fund/px/identification_number"(platform: "/", type: TrackType.View) {}
        "/account_fund/px/review_and_confirm"(platform: "/", type: TrackType.View) {}
        "/account_fund/px/result"(platform: "/", type: TrackType.View) {
            result_status = "rejected"
        }
    }
}
