import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
     * ACCOUNT FUND Screen Tracks
     */

    "/account_fund"(platform: "/", isAbstract: true) {}

    "/account_fund/select_method"(platform: "/", type: TrackType.View) {}
    "/account_fund/amount"(platform: "/", type: TrackType.View) {}
    "/account_fund/amount/preset"(platform: "/", isAbstract: true) {}

    // Amount presets MLB
    "/account_fund/amount/preset/mlb"(platform: "/", isAbstract: true) {}
    "/account_fund/amount/preset/mlb/30"(platform: "/", type: TrackType.Event) {}
    "/account_fund/amount/preset/mlb/60"(platform: "/", type: TrackType.Event) {}
    "/account_fund/amount/preset/mlb/120"(platform: "/", type: TrackType.Event) {}
    "/account_fund/amount/preset/mlb/240"(platform: "/", type: TrackType.Event) {}

    // Amount presets MLA
    "/account_fund/amount/preset/mla"(platform: "/", isAbstract: true) {}
    "/account_fund/amount/preset/mla/500"(platform: "/", type: TrackType.Event) {}
    "/account_fund/amount/preset/mla/1000"(platform: "/", type: TrackType.Event) {}
    "/account_fund/amount/preset/mla/2000"(platform: "/", type: TrackType.Event) {}
    "/account_fund/amount/preset/mla/5000"(platform: "/", type: TrackType.Event) {}

    "/account_fund/agencies_map"(platform: "/", type: TrackType.View) {}
    "/account_fund/ftu"(platform: "/", type: TrackType.View) {}
    "/account_fund/unique_code"(platform: "/", type: TrackType.View) {}
    "/account_fund/unique_code/help"(platform: "/", type: TrackType.View) {}
    "/account_fund/result"(platform: "/", type: TrackType.View) {}

    "/account_fund/px"(platform: "/", isAbstract: true) {}
    "/account_fund/px/card_vault"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/card_number"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/card_holder_name"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/card_expiry_date"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/card_security_code"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/identification_number"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/review_and_confirm"(platform: "/", type: TrackType.View) {}
    "/account_fund/px/result"(platform: "/", type: TrackType.View) {
        result_status (required:false, description: "Operation result status") // Change in the future with required true
        result_type (required:false, description: "Operation result type")
    }

    "/account_fund/cvu"(platform: "/", isAbstract: true) {}
    
    "/account_fund/mi_cvu"(platform: "/", type: TrackType.View) {}
    "/account_fund/mi_cvu/copy_alias"(platform: "/", type: TrackType.Event) {}
    "/account_fund/mi_cvu/copy_cvu"(platform: "/", type: TrackType.Event) {}
    "/account_fund/mi_cvu/edit_alias"(platform: "/", type: TrackType.View) {}
    "/account_fund/mi_cvu/edit_alias/save"(platform: "/", type: TrackType.Event) {}
    "/account_fund/mi_cvu/edit_alias/save/success"(platform: "/", type: TrackType.View) {}
    "/account_fund/mi_cvu/edit_alias/save/fail"(platform: "/", type: TrackType.View) {}
    
    "/account_fund/cvu/copy_alias"(platform: "/", type: TrackType.Event) {}
    "/account_fund/cvu/copy_cvu"(platform: "/", type: TrackType.Event) {}
    "/account_fund/cvu/edit_alias"(platform: "/", type: TrackType.View) {}
    "/account_fund/cvu/edit_alias/save"(platform: "/", type: TrackType.Event) {}
    "/account_fund/cvu/edit_alias/save/success"(platform: "/", type: TrackType.View) {}
    "/account_fund/cvu/edit_alias/save/fail"(platform: "/", type: TrackType.View) {}
    "/account_fund/cvu/ftu"(platform: "/", type: TrackType.View) {}
    "/account_fund/cvu/main"(platform: "/", type: TrackType.View) {}
    "/account_fund/cvu/result"(platform: "/", type: TrackType.View) {
        result_status (required:false, description: "Operation result status") // Change in the future with required true
        result_type (required:false, description: "Operation result type")
    }
}
