import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    /**
     * ACCOUNT FUND Screen Tracks
     */

    test("Account Fund - views") {
        "/account_fund/select_method"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/amount"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/agencies_map"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/ftu"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/unique_code"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/unique_code/help"(platform: "/mobile", type: TrackType.View) {}

        "/account_fund/px/card_vault"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/px/card_number"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/px/card_holder_name"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/px/card_expiry_date"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/px/card_security_code"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/px/identification_number"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/px/review_and_confirm"(platform: "/mobile", type: TrackType.View) {}
        "/account_fund/px/result"(platform: "/mobile", type: TrackType.View) {}
    }
}
