import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
     * ACCOUNT FUND Screen Tracks
     */

    "/account_fund"(platform: "/", isAbstract: true) {}

    "/account_fund/select_method"(platform: "/", type: TrackType.View) {}
    "/account_fund/amount"(platform: "/", type: TrackType.View) {}
    "/account_fund/agencies_map"(platform: "/", type: TrackType.View) {}
    "/account_fund/ftu"(platform: "/", type: TrackType.View) {}
    "/account_fund/unique_code"(platform: "/", type: TrackType.View) {}
    "/account_fund/unique_code/help"(platform: "/", type: TrackType.View) {}

    "/account_fund/px"(platform: "/", isAbstract: true) {}
    "/account_fund/px/card_vault"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/card_number"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/card_holder_name"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/card_expiry_date"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/card_security_code"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/identification_number"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/review_and_confirm"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/result"(platform: "/", type: TrackType.View) {
        result_status (required:true, description: "Operation result status")
        result_type (required:false, description: "Operation result type")
    }
}
