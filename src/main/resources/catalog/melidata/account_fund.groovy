package catalog.melidata

import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1149"

    /**
     * ACCOUNT FUND Screen Tracks
     */

    "/account_fund"(platform: "/", isAbstract: true) {}

    "/account_fund/select_method"(platform: "/", type: TrackType.View) {}
    "/account_fund/select_method/selected"(platform: "/", type: TrackType.Event) {
        method (required:true, description: "Selected money in method", values: ["debit_card", "cvu", "cash", "atm", "qr", "ticket", "spb"])
    }

    "/account_fund/amount"(platform: "/", type: TrackType.View) {}
    // Amount presets buttons
    "/account_fund/amount/preset"(platform: "/", type: TrackType.Event) {
        preset (required:true, description: "Amount preset button value", values: ["30", "60", "120", "240", "500", "1000", "2000", "5000"])
    }

    // Amount warning modal
    "/account_fund/amount/warning"(platform: "/", type: TrackType.View) {}
    "/account_fund/amount/warning/continue"(platform: "/", type: TrackType.Event) {}
    "/account_fund/amount/warning/transfer"(platform: "/", type: TrackType.Event) {}
    "/account_fund/amount/warning/dismiss"(platform: "/", type: TrackType.Event) {}

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
    "/account_fund/mi_cvu/transfer_help"(platform: "/", type: TrackType.Event) {}
    "/account_fund/mi_cvu/share"(platform: "/", type: TrackType.Event) {}
    "/account_fund/mi_cvu/menu_help"(platform: "/", type: TrackType.Event) {}
    "/account_fund/mi_cvu/edit_alias/menu_help"(platform: "/", type: TrackType.Event) {}
    
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
    "/account_fund/cvu/pending"(platform: "/", type: TrackType.View) {}
    
    "/account_fund/cvu/main/instructions"(platform: "/", type: TrackType.Event) {}
    "/account_fund/cvu/main/bank_selection"(platform: "/", type: TrackType.View) {}
    "/account_fund/cvu/main/bank_selection/select"(platform: "/", type: TrackType.Event) {
        bank (required:true, description: "Bank to display instructions for")
    }
    "/account_fund/cvu/main/help"(platform: "/", type: TrackType.Event) {}
}
