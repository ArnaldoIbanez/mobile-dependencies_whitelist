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
            prog_reg_version = 0
        }

        "/register/form"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/form/error"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/form/error"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            prog_reg_version = 1
        }

        "/register/form/another-email"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            prog_reg_version = 1
        }

        "/register/form/another-email"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/form/geolocation"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            geo_location_code = 1
        }

        "/register/form/facebook-connect"(platform:"/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/facebook-connect/facebook-register-selected"(platform:"/web/mobile") {
            app = "registration"
            source = "facebook"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/facebook-connect/email-register-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/facebook-connect/login-selected"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/site-identification"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            ip_site_id = "MCO"
        }

        "/register/form/site-identification/url-site-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            ip_site_id = "MCO"
        }

        "/register/form/site-identification/ip-site-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            ip_site_id = "MCO"
        }

        "/register/success"(platform: "/web/desktop") {
            app = "registration-favorite"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = false
            prog_reg_version = 1
        }

        "/register/success"(platform: "/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/skip-update"(platform: "/web/desktop") {
            app = "registration-update-opt"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/optin"(platform: "/web/desktop") {
            app = "registration"
            prog_reg_version = 0
        }

        "/register/optin/push"(platform: "/web/mobile") {
            app = "registration-optin"
            prog_reg_version = 0
        }

        "/register/optin/skip"(platform: "/web/mobile") {
            app = "registration-optin"
            prog_reg_version = 0
        }
    }

    test("Registration App"){
        // app module
        "/register/hub"(platform: "/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }
        "/register/hub/register-with-email"(platform: "/mobile"){
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"

        }
        "/register/hub/register-with-facebook"(platform: "/mobile"){
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }
        "/register/form"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }
        "/register/form/error"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
            errors_validation = "back"
            errors = [
                    [
                            code:8,
                            field: 'email'
                    ]
            ]
        }
        "/register/form/another-email"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }
        "/register/account-recovery-hub"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }
        "/register/account-recovery-hub/account-recovery"(platform: "/mobile"){
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"

        }
        "/register/account-recovery-hub/use-another-email"(platform: "/mobile"){
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
        }

        "/register/congrats"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
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
        "/activity_detail"(platform: "/mobile") {}
        "/transaction_detail"(platform: "/mobile") {}
        "/social_detail"(platform: "/mobile") { }
        "/event_detail"(platform: "/mobile") { }
    }

    test("shopping") {
        "/shopping"(platform: "/mobile") {}
    }

    test("Login") {
        "/login/splitter"(platform: "/mobile") {
            flow = "/login"
        }
        "/login/sign_in"(platform: "/mobile") {
            flow = "/login"
        }
        "/login/sign_up"(platform: "/mobile") {
            flow = "/login"
        }
        "/login/identification"(platform: "/mobile") {
            flow = "/login"
        }
    }

    test("Send Money") {
        "/send_money/fill_transaction_data"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }
        "/send_money/pay"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/send_money/deals"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/send_money/deals/terms"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/send_money/payment_methods"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/send_money/other_payment_methods"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/send_money/cards"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/send_money/add_card"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/send_money/issuers"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }

        "/send_money/my_cards"(platform: "/mobile") {
            flow = "/send_money"
            from = "/deep_link"
        }
        "/send_money/result"(platform: "/mobile") {
            flow = "/checkout"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "call_for_auth"
        }
    }

    test("Checkout") {
        "/checkout/pay"(platform: "/mobile") {
            flow = "/checkout"
            from = "/deep_link"
        }
        "/checkout/deals"(platform: "/mobile") {
            flow = "/checkout"
            from = "/deep_link"
        }
        "/checkout/deals/terms"(platform: "/mobile") {
            flow = "/checkout"
            from = "/deep_link"
        }
        "/checkout/payment_methods"(platform: "/mobile") {
            flow = "/checkout"
            from = "/deep_link"
        }
        "/checkout/other_payment_methods"(platform: "/mobile") {
            flow = "/checkout"
            from = "/deep_link"
        }
        "/checkout/cards"(platform: "/mobile") {
            flow = "/checkout"
            from = "/deep_link"
        }
        "/checkout/add_card"(platform: "/mobile") {
            flow = "/checkout"
            from = "/deep_link"
        }
        "/checkout/issuers"(platform: "/mobile") {
            flow = "/checkout"
            from = "/deep_link"
        }
        "/checkout/result"(platform: "/mobile") {
            flow = "/checkout"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "call_for_auth"
        }
    }

    test("QR") {
        "/qr_code/qr_reader"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/fill_transaction_data"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/pay"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/deals"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/deals/terms"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/payment_methods"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/other_payment_methods"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/cards"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/add_card"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/issuers"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/my_cards"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/result"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "call_for_auth"
        }
        "/qr_code/px_payment_method_search"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_discount_summary"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_card_vault"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_card_number"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_card_holder_name"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_card_expiry_date"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_card_security_code"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_identification_number"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_card_issuers"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_card_installments"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_review_and_confirm"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/qr_code/px_result"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
            result_status = "rejected"
        }
    }

    test("QRRead Stores event") {

        "/qr_read/store"(platform: "/mobile") {
            qr_info = "http://laconoariel.com/mpmobile/axion/?id=invalid"
            _label = "error"
            deep_link = "mercadopago://congrats_store"
            additional_info = {message="Algo no salió bien"
                icon="error"
                status="rejected"
                description="Por favor, intenta nuevamente."
                actions=[{
                             id="try_again"
                             link="mercadopago://stores?qr_code=http%3A%2F%2Flaconoariel.com%2Fmpmobile%2Faxion%2F%3Fid%3Dinvalid"
                             label="Intentar nuevamente"
                             type="button"
                         },{
                    id="back_to_root"
                    link":null"
                    label="Volver al inicio"
                    type="link" }]}
        }
    }

    test("Pay Preference") {
        "/px_result"(platform: "/mobile") {
            result_status = "rejected"
        }

        "/pay_preference/fetch_preference_info"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_payment_method_search"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_payer_cost"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_card_number"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_card_vault"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_card_holder"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_card_holder_name"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_card_issuers"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_card_installments"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_card_expiry_date"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_card_security_code"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_identification_number"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_review_and_confirm"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
        }

        "/pay_preference/px_result"(platform: "/mobile") {
            flow = "/pay_preference"
            from = "/deep_link"
            result_status = "rejected"
        }
    }

    test("Get member") {
        "/get_member/invite"(platform: "/mobile") {
            flow = "/get_member"
            scope = "wallet"
        }

        "/get_member/invite"(platform: "/mobile") {
            flow = "/get_member"
            from = "/deep_link"
            scope = "point"
        }

        "/get_member/redeem"(platform: "/mobile") {
            flow = "/get_member"
        }

        "/get_member/redeem"(platform: "/mobile") {
            flow = "/get_member"
            from = "/deep_link"
        }
    }

    test("Digital Goods") {
        "/digital_goods/list"(platform: "/mobile") {
            flow = "/digital_goods"
        }

        "/digital_goods/list"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }

        "/digital_goods/no_money"(platform: "/mobile") {
            flow = "/digital_goods"
        }

        "/digital_goods/no_money"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }

        "/digital_goods/search_entities"(platform: "/mobile") {
            flow = "/digital_goods"
        }

        "/digital_goods/search_entities"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }

        "/digital_goods/products"(platform: "/mobile") {
            flow = "/digital_goods"
            type = "option"
        }

        "/digital_goods/products"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
            type = "option"
        }

        "/digital_goods/px_card_vault"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_card_number"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_card_holder_name"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_card_expiry_date"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_card_security_code"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_identification_number"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_card_issuers"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_card_installments"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_result"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
            result_status = "rejected"
        }
        "/digital_goods/px_review_and_confirm"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_payment_method_search"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_discount_summary"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
        }
        "/digital_goods/px_result"(platform: "/mobile") {
            flow = "/digital_goods"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "call_for_auth"
        }

        "/digital_goods/px_card_vault"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_card_number"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_card_holder_name"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_card_expiry_date"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_card_security_code"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_review_and_confirm"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_identification_number"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_discount_summary"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_payment_method_search"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_card_issuers"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_card_installments"(platform: "/mobile") {
            flow = "/digital_goods"
        }
        "/digital_goods/px_result"(platform: "/mobile") {
            flow = "/digital_goods"
            result_status = "rejected"
        }
        "/digital_goods/px_result"(platform: "/mobile") {
            flow = "/digital_goods"
            result_status = "rejected"
            status_detail = "call_for_auth"
        }
    }

    test("Cellphone recharge") {
        "/cellphone_recharge/push_handler"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/recents"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/set_telephone_number"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/contacts"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/carriers"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/recommended"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/packages"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/manual_amount"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/pay"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/deals"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/deals/terms"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/payment_methods"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/other_payment_methods"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/cards"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/add_card"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/issuers"(platform: "/mobile") {
            flow = "/qr_code"
            from = "/deep_link"
        }
        "/cellphone_recharge/result"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "call_for_auth"
        }
        "/cellphone_recharge/px_payment_method_search"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_discount_summary"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_vault"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_number"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_holder_name"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_expiry_date"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_security_code"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_identification_number"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_issuers"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_card_installments"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_review_and_confirm"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }
        "/cellphone_recharge/px_result"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
            result_status = "rejected"
        }
    }

    test("Scheduled recharge") {
        "/scheduled_recharge/detail"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/empty_recharges"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/all_scheduled"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/frequency"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/weekly_option"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/monthly_option"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/suggested_recent_recharges"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/carries"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/recommended"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/packages"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/manual_amount"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_payment_method_search"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_discount_summary"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_card_vault"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_card_number"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_card_holder_name"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_card_expiry_date"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_card_security_code"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_identification_number"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_card_issuers"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_card_installments"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_review_and_confirm"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
        }
        "/scheduled_recharge/px_result"(platform: "/mobile") {
            flow = "/scheduled_recharge"
            from = "/deep_link"
            result_status = "rejected"
        }
    }

    test("Money request") {
        "/money_request/fill_transaction_data"(platform: "/mobile") {
            flow = "/money_request"
            from = "/deep_link"
        }
        "/money_request/picker"(platform: "/mobile") {
            flow = "/money_request"
            from = "/deep_link"
        }
        "/money_request/social_share"(platform: "/mobile") {
            flow = "/money_request"
            from = "/deep_link"
        }
        "/crop_image"(platform: "/mobile") {}
        "/money_request/result"(platform: "/mobile") {
            flow = "/money_request"
            from = "/deep_link"
            result_status = "approved"
        }
    }

    test("Bill payments") {

        "/bill_payments/fixed_amount"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/bill_payments/ticket_data"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }

        "/bill_payments/help"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/associated_entities"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/no_money"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/permissions_rationale"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/scan"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/manual_code"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/confirmation"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/add_info"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
            type = "literal"
        }
        "/bill_payments/second_password"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/result"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "call_for_auth"
        }
        "/bill_payments/px_payment_method_search"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_discount_summary"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_card_vault"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_card_number"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_card_holder_name"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_card_expiry_date"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_card_security_code"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_identification_number"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_card_issuers"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_card_installments"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_review_and_confirm"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/px_result"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
            result_status = "rejected"
        }
        "/bill_payments/fee"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
    }

    test("Recharge Sube") {
        "/recharge_sube/first_time_use"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/no_money"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/choose_amount_information"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/localization"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/localization_permission"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/select_recharge_card"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/information"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/add_bus_card"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/add_card_name"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/choose_amount"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/second_password"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_payment_method_search"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_discount_summary"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_card_vault"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_card_number"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_card_holder_name"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_card_expiry_date"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_card_security_code"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_identification_number"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_card_issuers"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_card_installments"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_review_and_confirm"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/px_result"(platform: "/mobile") {
            flow = "/recharge_sube"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "call_for_auth"
        }
    }

    test("Fund account") {
        "/fund_account/fund_amount"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
        }
        "/fund_account/other_payment_methods"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
        }
        "/fund_account/result"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "unavailable"
        }
    }

    test("Withdraw") {
        "/withdraw/withdrawable_money"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw/take_money_out"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw/select_bank"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw/result"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "internal_server_error"
        }
    }

    test("Withdraw_advance") {
        "/withdraw_advance/take_money_out"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw_advance/select_bank"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw_advance/result"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "internal_server_error"
        }
    }

    test("Settings") {
        "/settings/my_profile"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }
        "/settings/balance"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }
        "/settings/my_cards"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }
        "/settings/my_cards_detail"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }
        "/settings/pin_status"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }
        "/settings/set_pin_code"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }
        "/settings/verify_pin"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }
        "/settings/about"(platform: "/mobile") {
            flow = "/settings"
            from = "/deep_link"
        }
    }

    test("Associate phone") {
        "/associate_phone/sync_phone"(platform: "/mobile") {
            flow = "/associate_phone"
            from = "/deep_link"
        }
        "/associate_phone/verify_pin"(platform: "/mobile") {
            flow = "/associate_phone"
            from = "/deep_link"
        }
        "/associate_phone/synced_phone"(platform: "/mobile") {
            flow = "/associate_phone"
            from = "/deep_link"
        }
    }

    test("Prepaid cards") {
        "/prepaid_card/action_picker"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }
        "/prepaid_card/web_view"(platform: "/mobile") {
            flow = "/prepaid_card"
            from = "/deep_link"
        }
        "/prepaid_recharge/fill_recharge_data"(platform: "/mobile") {
            flow = "/prepaid_recharge"
            from = "/deep_link"
        }
        "/prepaid_recharge/recipients"(platform: "/mobile") {
            flow = "/prepaid_recharge"
            from = "/deep_link"
        }
        "/prepaid_recharge/result"(platform: "/mobile") {
            flow = "/fund_account"
            from = "/deep_link"
            result_status = "rejected"
            status_detail = "internal_server_error"
        }
    }

    test("Money Detail") {
        "/money_detail/balance"(platform: "/mobile") {
            flow = "/money_detail"
            from = "/deep_link"
        }
        "/money_detail/help_modal"(platform: "/mobile") {
            flow = "/money_detail"
        }
    }

    
    test("Notifications") {
                
        "/notification"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "sent"
        }
        
        "/notification/mpcampaigns_campaigns"(platform: "/mobile") {
                news_id = "123"
                campaign_id = "prueba_123"
                event_type = "open"
        }  
        
        "/notification/money_transfer_received"(platform: "/mobile") {
                news_id = "123"
                event_type = "open"
        }  
        
        "/notification/money_transfer_request"(platform: "/mobile") {
                news_id = "123"
                event_type = "open"
        }
    }

// END -- MPMOBILE TEST

    test("Login conversion tracks") {
        "/login"(platform: "/") {
            source = "LFE"
        }
        "/login/form"(platform: "/", type: TrackType.View) {
            source = "QUESTION"
            flow = "internal"
            has_error = true
            old_user_id = "123456"
            old_user_nick = "nick"
        }
        "/login/form"(platform: "/", type: TrackType.View) {
            source = "FAVORITE"
            flow = "internal"
            has_error = false
            recaptcha = false
        }
        "/login/recovery"(platform: "/web", type: TrackType.Event) {
            source = "LFE"
        }
        "/login/recovery"(platform: "/mobile", type: TrackType.View) {
            source = "LFE"
        }
        "/login/auth"(platform: "/mobile", type: TrackType.View) {
            source = "LFE"
            is_otp = false
            is_admin_otp = false
        }
        "/login/auth"(platform: "/web", type: TrackType.Event) {
            source = "LFE"
            is_otp = false
            is_admin_otp = false
        }
        "/login/registration"(platform: "/", type: TrackType.Event) {
            source = "LFE"
        }
        "/login/auth/success"(platform: "/", type: TrackType.Event) {
            source = "LFE"
            flow = "internal"
            is_otp = false
            is_admin_otp = false
            user_reg_date = "2002-09-26T00:00:00.000-04:00"
            user_points = 100
        }
        "/login/auth/failure"(platform: "/", type: TrackType.Event) {
            source = "LFE"
            reason = [errorId: 'invalid_password']
            flow = "internal"
            is_otp = false
            is_admin_otp = false
            old_user_id = "123456"
            old_user_nick = "nick"
        }
        "/login/auth/challenge_success"(platform: "/", type: TrackType.Event) {
            source = "MSL_DEFAULT"
            challenge = "pass"
            is_otp = false
            is_admin_otp = false
        }
        "/login/auth/push"(platform: "/", type: TrackType.Event) {
            view = "waiting_view"
            event_type = "click_go_to_password_button"
            challenge = "push_authentication"
            tx = "adHgjskcD01lM6EeLs7zUGgBaA1GiWqF6w_XQUgLJk0QAmdhE"
            is_otp = false
            is_admin_otp = false
        }
        "/logout"(platform: "/", type: TrackType.Event) {
            flow = "internal"
        }
    }

    test("Login Status with Smart Lock for Passwords") {
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = true
            smartlock_status = "SUCCESS"
            section = "application_startup"
        }
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = false
            smartlock_status = "SUCCESS"
            section = "application_startup"
        }
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = true
            smartlock_status = "RESOLUTION_REQUIRED"
            section = "application_startup"
        }
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = false
            smartlock_status = "RESOLUTION_REQUIRED"
            section = "application_startup"
        }
    }

    test("Requesting credentials to Smart Lock for Passwords") {
        "/login/smartlock"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "RESOLUTION_REQUIRED"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "CANCELED"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "VALIDATION_REQUIRED"
        }
    }

    test("Identity Validation ") {

        "/identity-validation/validation_landing"(platform: "/web/mobile") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/web/mobile") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/web/mobile") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/web/mobile") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/web/mobile") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/validation_landing"(platform: "/web/desktop") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/web/desktop") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/web/desktop") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/web/desktop") {
            type = "phone"
            success = false
        }

        "/identity-validation/finish_challenge"(platform: "/web/desktop") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/web/desktop") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/validation_landing"(platform: "/mobile/android") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/mobile/android") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/android") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/android") {
            type = "phone"
            success = false
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/android") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/mobile/android") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/validation_landing"(platform: "/mobile/ios") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/mobile/ios") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/ios") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/ios") {
            type = "phone"
            success = false
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/ios") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/mobile/ios") {
            result = "valid"
            flow = "ms_hard_validation"
        }
    }

    test("Checkout Off"){
        "/checkout_off/init"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/congrats"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "24286689"
            scope = 'mla'

            payment_status = "pending"
            payment_id = "123456789"
            payment_status_detail = "pending_waiting_payment"
            payment_method_id = "rapipago"
            payment_type_id = "ticket"
            is_express = false
            is_split = false
        }
        "/checkout_off/payment_option"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/payment_option/ticket"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/payment_option/bank_transfer"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/payment_option/cards"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/review"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            payment_type = "credit_card"
            payment_method = "visa"
            issuer = "288"
            has_shipping = false
            has_payer_shipping_data = false
        }
        "/checkout_off/review"(platform: "/web/desktop") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            payment_type = "ticket"
            payment_method = "rapipago"
            has_shipping = true
            has_payer_shipping_data = true
            shipping_mode = "me2"
        }
        "/checkout_off/express"(platform: "/web/mobile"){
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            payment_type = "account_money"
            payment_method = "account_money"
            only_account_money = false
            has_shipping = true
            has_payer_shipping_data = false
            shipping_mode = "custom"
        }
        "/checkout_off/congrats/approved"(platform: "/web/mobile"){
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            payment_status = "approved"
            payment_id = "123456789"
            payment_status_detail = "approved"
            payment_method_id = "visa"
            payment_type_id = "credit_card"
            is_express = true
            is_split = false
        }
        "/checkout_off/congrats/pending"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            payment_status = "pending"
            payment_id = "123456789"
            payment_status_detail = "pending_waiting_for_remedy"
            payment_method_id = "visa"
            payment_type_id = "debit_card"
            is_express = false
            is_split = false
        }
        "/checkout_off/congrats/instructions"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            payment_status = "pending"
            payment_id = "123456789"
            payment_status_detail = "pending_waiting_payment"
            payment_method_id = "rapipago"
            payment_type_id = "ticket"
            is_express = false
            is_split = false
        }
        "/checkout_off/congrats/rejected"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            payment_status = "rejected"
            payment_id = "123456789"
            payment_status_detail = "cc_rejected_other_reason"
            payment_method_id = "visa"
            payment_type_id = "credit_card"
            is_express = false
            is_split = false
        }
        "/checkout_off/shipping"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            shipping_mode = "me2"
            local_pickup = false
            payer_addresses = 2
        }
        "/checkout_off/shipping/address"(platform: "/web/desktop") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            shipping_mode = "custom"
            local_pickup = true
            payer_addresses = 0
        }
        "/checkout_off/shipping/method"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            shipping_mode = "me2"
            local_pickup = false
            payer_addresses = 0

            shipping_method_count = 1
        }
        "/checkout_off/login"(platform: "/web/desktop") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/login/guest"(platform: "/web/desktop") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/login/discount"(platform: "/web/desktop") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/card/credit_card"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/card/debit_card"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/card/split"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
        }
        "/checkout_off/error/validation"(platform: "/web/desktop") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            failure_code = "invalid_CVV"
        }
        "/checkout_off/error/expired"(platform: "/web/desktop") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'

            ms_since_expiration = 40000
        }
        "/checkout_off/error/internal"(platform: "/web/desktop") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            preference_id = "96449980"
            scope = 'mla'
            
            response_status = 500
            exception_message = "Some exception message"
        }

    }
}
