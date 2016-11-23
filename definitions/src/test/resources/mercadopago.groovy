import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Root tracking") {
        "/"(platform: "/mobile") {}

        "/"(platform: "/web/desktop") {}
    }

    test("melidata automatic tracks send by sdk") {

        "/melidata/null_track" (platform:"/mobile", type:TrackType.Event) {
            context = "context"
        }

        "/melidata/delete_old_tracks"(platform: "/mobile", type: TrackType.Event) {
            count = 10
        }

        "/melidata/statistics"(platform: "/mobile", type: TrackType.Event) {
            errors_counter = ["java.io.EOFException": 2, "nullpointer": 3]
            last_send_timestamp = "2015-01-21T13:14:09.415-0300"
            total_pending_tracks = 2
            send_counter = 6
            database_size = 16384
            tracks_counter = 12
            average_ok_time = 10
            average_error_time = 11
        }

        "/melidata/shrink_database"(platform: "/mobile/android", type: TrackType.Control) {
            delete_records = 40
            current_size = 69632
            previous_size = 110592
        }

        "/melidata/shrink_database"(platform: "/mobile/ios", type: TrackType.Event) {
            delete_records = 50
            current_size = 82322
            previous_size = 122592
        }
    }

    test("Register") {
        "/register/success"(platform: "/mobile") {
            source = "facebook"
        }

        "/register/failure"(platform: "/mobile") {
            source = "facebook"
        }

        "/register/facebook_permissions"(platform: "/mobile"){
            login_status = "success"
            email = true
            user_birthday = true
            user_likes = true
        }
    }

    test("Register Web") {
        "/register/form"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
        }

        "/register/form"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
        }

        "/register/form/error"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
        }

        "/register/form/error"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
        }

        "/register/form/another-email"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
        }

        "/register/form/another-email"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            captcha_showed = true
        }

        "/register/success"(platform: "/web/desktop") {
            app = "registration-favorite"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = false
        }

        "/register/success"(platform: "/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
        }
    }

    test("Account Recovery tracking event") {

        "/register/accountRecovery"(platform: "/mobile", type: TrackType.Event) {
            error_type = "connectionError/invalidOneTimePassword/operatorNotSupported"
        }
    }

    test("Landing mercadopago point") {
        "/point/home" (platform: "/") {
            product = "point-h"
            currency = "R\$"
            price = 401
            in_installments = true
            discount = 0.16
            price_with_discount = 334.8
        }
    }

    // MPMOBILE TEST
    test("account summary flow") {
        "/account_summary"(platform: "/mobile") {}
        "/account_summary/filters"(platform: "/mobile") {}
        "/account_summary/filtered_list"(platform: "/mobile") {}
    }

    test("shopping") {
        "/shopping"(platform: "/mobile") {}
    }

    test("Login") {
        "/login_splitter"(platform: "/mobile") {}
        "/sign_in"(platform: "/mobile") {}
        "/sign_up"(platform: "/mobile") {}
        "/identification"(platform: "/mobile") {}
    }

    test("Send Money") {
        "/fill_data"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }
    }

    test("Checkout") {
        "/pay"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/deals"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/deals/terms"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/payment_methods"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/other_payment_methods"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/cards"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/add_card"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/issuers"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/my_cards"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }
    }

    test("Money request") {
        "/fill_data"(platform: "/mobile") {
            flow = "/money_request"
            from = "/deep_link"
        }

        "/picker_request_type"(platform: "/mobile") {
            flow = "/money_request"
            from = "/deep_link"
        }


        "/fill_data"(platform: "/mobile") {
            flow = "/money_request"
            from = "/deep_link"
        }


        "/social_share"(platform: "/mobile") {
            flow = "/money_request"
            from = "/deep_link"
        }

        "/crop_image"(platform: "/mobile") {
            flow = "/money_request"
            from = "/deep_link"
        }
    }

    test("Congrats") {
        "/result/approved"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/result/rejected"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/result/in_process"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/result/expired"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }
    }

    test("QR") {
        "/qr_reader"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }
    }

    test("Cellphone recharge") {
        "/recents"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/set_telephone_number"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/contacts"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/carriers"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/recommended"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/package"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/manual_amount"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
    }

    test("Bill payments") {
        "/help"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/associated_entities"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/no_money"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/permissions_rationale"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/scan"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/manual_code"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/confirmation"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/add_info/literal"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/add_info/amount"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/add_info/option"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/second_password"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
    }

    test("Fund account") {
        "/fund_amount"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
        }
    }

    test("Withdraw") {
        "/take_money_out"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }

        "/select_bank"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
    }

    test("Settings") {
        "/my_profile"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }

        "/balance"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }

        "/my_cards"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }

        "/my_cards_detail"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }

        "/pin_status"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }

        "/set_pin_code"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }

        "/verify_pin"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }

        "/about"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }
    }

    test("Associate phone") {
        "/sync_phone"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }

        "/synced_phone"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }
    }

    test("Prepaid cards") {
        "/action_picker"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }

        "/web_view"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }

        "/fill_recharge_data"(platform: "/mobile") {
            flow = "/prepaid_recharge"
            from = "/deep_link"
        }

        "/recipients"(platform: "/mobile") {
            flow = "/prepaid_recharge"
            from = "/deep_link"
        }
    }

// END -- MPMOBILE TEST

    test("Login conversion tracks") {
        "/login"(platform: "/") {
            source = "LFE"
        }
        "/login/form"(platform: "/", type: TrackType.View) {
            source = "QUESTION"
            has_error = true
        }
        "/login/form"(platform: "/", type: TrackType.View) {
            source = "FAVORITE"
            has_error = false
        }
        "/login/recovery"(platform: "/web", type: TrackType.Event) {
            source = "LFE"
        }
        "/login/recovery"(platform: "/mobile", type: TrackType.View) {
            source = "LFE"
        }
        "/login/auth"(platform: "/mobile", type: TrackType.View) {
            source = "LFE"
            dps_id = "123456"
            is_otp = false
            is_admin_otp = false
        }
        "/login/auth"(platform: "/web", type: TrackType.Event) {
            source = "LFE"
            dps_id = "123456"
            is_otp = false
            is_admin_otp = false
        }
        "/login/registration"(platform: "/", type: TrackType.Event) {
            source = "LFE"
        }
        "/login/auth/success"(platform: "/", type: TrackType.Event) {
            source = "LFE"
            dps_id = "123456"
            is_otp = false
            is_admin_otp = false
        }
        "/login/auth/failure"(platform: "/", type: TrackType.Event) {
            source = "LFE"
            reason = [errorId: 'invalid_password']
            dps_id = "123456"
            is_otp = false
            is_admin_otp = false
        }
    }
}
