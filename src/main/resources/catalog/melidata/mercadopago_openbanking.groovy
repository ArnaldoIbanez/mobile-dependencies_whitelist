package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative='1266'

    "/open_banking"(platform:"/", isAbstract: true) {}
    "/open_banking/data_in"(platform:"/", isAbstract: true) {}
    "/open_banking/data_in/opt_in"(platform:"/", type:TrackType.View) {}
    "/open_banking/data_in/opt_in/set_consent_date_limit"(platform:"/", type:TrackType.Event) {
        date_limit(type: PropertyType.String, required: true, description: "value for consent date limit")
    }
    "/open_banking/data_in/opt_in/edit_selected_bank"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/opt_in/edit_consent_date"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/opt_in/cancel_consent_date_bottom_sheet"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/opt_in/show_bank_detail"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/opt_in/select_bank"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/opt_in/send_consent_data"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/opt_in/set_cancel_modal_close"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/opt_in/set_cancel_modal_open"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/opt_in/navigate_to_page"(platform:"/", type:TrackType.Event) {
        page_number(type: PropertyType.String, required: true, description: "value for page number")
    }
    "/open_banking/data_in/opt_in/open_search_bottom_sheet"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/opt_in/click_see_all"(platform:"/", type:TrackType.Event) {
        card_label(type: PropertyType.String, required: true, description: "card main label on accordion components")
    }
    "/open_banking/data_in/consent_management"(platform:"/", type:TrackType.View) {}
    "/open_banking/data_in/consent_management/set_tab_sent"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/consent_management/set_tab_received"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/consent_management/open_modal"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/consent_management/edit_consent"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/consent_management/revoke_consent"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/consent_management/renew_consent"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/consent_management/create_new_consent"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/consent_management/click_consent"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/error"(platform:"/", type:TrackType.View) {}
    "/open_banking/data_in/error/navigate_to_my_home"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/error/navigate_to_my_money"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/feedback"(platform:"/", type:TrackType.View) {}
    "/open_banking/data_in/feedback/navigate_to_my_home"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/feedback/navigate_to_my_money"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/landing_page"(platform:"/", type:TrackType.View) {}
    "/open_banking/data_in/landing_page/click_primary_button"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/landing_page/click_secondary_button"(platform:"/", type:TrackType.Event) {}
    "/open_banking/data_in/landing_page/loaded_from"(platform:"/", type:TrackType.Event) {
        page_name(type: PropertyType.String, required: true, description: "valeu for page where user came from")
    }
    }