package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

     test("CHO API webpay onelick") {
        "/open_banking/opt-in"(platform:"/", type:TrackType.View) {}
        "/open_banking/opt-in/set_date_limit_12"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/set_date_limit_6"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/set_date_limit_3"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/set_date_limit_1"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/edit_selected_bank"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/edit_selected_date"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/cancel_consent_date_bottom_sheet"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/show_bank_detail"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/select_bank"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/send_consent_data"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/set_cancel_modal_close"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/set_cancel_modal_open"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/navigate_to_page_2"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/navigate_to_page_3"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/navigate_to_page_4"(platform:"/", type:TrackType.Event) {}
        "/open_banking/opt-in/open_search_bottom_sheet"(platform:"/", type:TrackType.Event) {}

        "/open_banking/consent-management"(platform:"/", type:TrackType.View) {}
        "/open_banking/consent-management/set_tab_sent"(platform:"/", type:TrackType.Event) {}
        "/open_banking/consent-management/set_tab_received"(platform:"/", type:TrackType.Event) {}
        "/open_banking/consent-management/open_modal"(platform:"/", type:TrackType.Event) {}
        "/open_banking/consent-management/edit_consent"(platform:"/", type:TrackType.Event) {}
        "/open_banking/consent-management/revoke_consent"(platform:"/", type:TrackType.Event) {}
        "/open_banking/consent-management/renew_consent"(platform:"/", type:TrackType.Event) {}
        "/open_banking/consent-management/create_new_consent"(platform:"/", type:TrackType.Event) {}

        "/open_banking/error"(platform:"/", type:TrackType.View) {}
        "/open_banking/error/navigate_to_my_home"(platform:"/", type:TrackType.Event) {}
        "/open_banking/error/navigate_to_my_money"(platform:"/", type:TrackType.Event) {}

        "/open_banking/feedback"(platform:"/", type:TrackType.View) {}
        "/open_banking/feedback/navigate_to_my_home"(platform:"/", type:TrackType.Event) {}
        "/open_banking/feedback/navigate_to_my_money"(platform:"/", type:TrackType.Event) {}

         "/open_banking/landing-page"(platform:"/", type:TrackType.View) {}
        "/open_banking/landing-page/click_primary_button"(platform:"/", type:TrackType.Event) {}
        "/open_banking/landing-page/click_secondary_button"(platform:"/", type:TrackType.Event) {}
    }

}
