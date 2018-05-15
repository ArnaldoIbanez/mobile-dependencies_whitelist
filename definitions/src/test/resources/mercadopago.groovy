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

    test("Mercado Pago blog") {
        "/blog/home"(platform: "/web/desktop", type: TrackType.View) {}
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

        "/register/form/email-suggest"(platform: "/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }
    }

    test("Progressive registration") {
        "/progressive_registration"(platform: "/mobile/android") {}
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
            register_type = "person"
        }

        "/register/form"(platform:"/mobile") {
            app = "normal"
            register_type = "company"
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
            register_type = "person"
        }

        "/register/form/error"(platform:"/mobile") {
            app = "normal"
            errors = [
                    [
                            code:50,
                            field: 'doc_number'
                    ]
            ]
            register_type = "company"
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
            register_type = "person"
        }

        "/register/congrats"(platform:"/mobile") {
            app = "normal"
            origin = "email"
            register_type = "company"
        }

        "/register/form/update"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
        }

        "/register/form/update/error"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
            errors_validation = "back"
            errors = [
                    [
                            code:14,
                            field: 'first_name'
                    ]
            ]
        }

        "/register/form/update/save"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
        }

        "/register/form/update/not-now"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
        }

        "/register/successful-update"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
        }

        "/register/form/company-link"(platform: "/mobile"){
            app = "normal"
        }

        "/register/form/person-link"(platform: "/mobile"){
            app = "normal"
        }

        "/register/congrats/complete-fiscal-data"(platform: "/mobile"){
            app = "normal"
            register_type = "company"
        }

        "/register/congrats/complete-fiscal-data-later"(platform: "/mobile"){
            app = "normal"
            register_type = "company"
        }

    }

    test("Account Recovery tracking event") {

        "/register/accountRecovery"(platform: "/mobile", type: TrackType.Event) {
            error_type = "connectionError/invalidOneTimePassword/operatorNotSupported"
        }
    }

    test("Landing mercadopago home") {
        "/landing/home" (platform: "/web") {}
    }

    test("Landing mercadopago sellers") {
        "/landing/sellers" (platform: "/web") {}
    }

    test("Landing mercadopago sellers websites") {
        "/landing/sellers/websites" (platform: "/web") {}
    }

    test("Landing mercadopago sellers social") {
        "/landing/sellers/social" (platform: "/web") {}
    }

    test("Landing mercadopago buyers") {
        "/landing/buyers" (platform: "/web") {}
    }

    test("Landing mercadopago promotions") {
        "/landing/promotions" (platform: "/web") {}
    }

    test("Mercadopago Activities List") {
        "/listing/activities" (platform: "/web") {}
    }

    test("Mercadopago Gateway List") {
        "/listing/gateway" (platform: "/web") {}
    }

    test("MP-MA Landing QR") {
        "/merchant_acquisition/qr/landing" (platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/qr/landing/promotions"(platform: "/", type: TrackType.Event) {}
    }

    test("MP-MA Flow QR") {
        "/merchant_acquisition/qr/onboarding"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/qr-code"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/pending"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/error"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/settings"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/qr-code/download"(platform:"/", type: TrackType.Event) {}
        "/merchant_acquisition/qr/qr-code/print"(platform:"/", type: TrackType.Event) {}
        "/merchant_acquisition/qr/qr-code/faqs"(platform:"/", type: TrackType.Event) {}
        "/merchant_acquisition/qr/qr-code/help"(platform:"/", type: TrackType.Event) {}
    }

    test("Point Flow Congrats") {
        "/point/flows/congrats"(platform:"/", type: TrackType.View) {}
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
        "/point/home/buy"(platform:"/", type: TrackType.Event) {
          product = "point"
        }
    }

    // MPMOBILE TEST
    test("account summary flow") {
        "/account_summary"(platform: "/mobile") {
            from = "/deep_link"
        }
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

    test("Sign In") {
        "/sign_in/facebook"(platform: "/mobile") {
            label = "success"
        }
        "/sign_in/facebook"(platform: "/mobile") {
            label = "cenceled"
        }
        "/sign_in/facebook"(platform: "/mobile") {
            label = "failure"
        }
        "/sign_in/google"(platform: "/mobile") {
            label = "success"
        }
        "/sign_in/google"(platform: "/mobile") {
            label = "failure"
        }
        "/sign_in/sso"(platform: "/mobile") {
            label = "success"
        }
        "/sign_in/sso"(platform: "/mobile") {
            label = "failure"
        }
        "/sign_in/smart_lock"(platform: "/mobile") {
            label = "success"
        }
        "/sign_in/smart_lock"(platform: "/mobile") {
            label = "failure"
        }
        "/sign_in/mail"(platform: "/mobile") {
            label = "success"
        }
        "/sign_in/mail"(platform: "/mobile") {
            label = "failure"
            description = "already_exists"
        }
    }

    test("Sign Up") {
        "/sign_up/facebook"(platform: "/mobile") {
            label = "success"
        }
        "/sign_up/facebook"(platform: "/mobile") {
            label = "cenceled"
        }
        "/sign_up/facebook"(platform: "/mobile") {
            label = "failure"
        }
        "/sign_up/google"(platform: "/mobile") {
            label = "success"
        }
        "/sign_up/google"(platform: "/mobile") {
            label = "failure"
        }
        "/sign_up/mail"(platform: "/mobile") {
            label = "success"
        }
        "/sign_up/mail"(platform: "/mobile") {
            label = "failure"
            description = "already_exists"
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

        "/send_money/confirm"(platform: "/web"){
            flow = "/send_money"
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

    test("Point Payment") {

        "/point_payment"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/main"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/card"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/installments"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/card_type"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/signature"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/security_code"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/identification_number"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/result"(platform: "/mobile", type: TrackType.View) {
            flow_id = "1231313123213"
            method = "swipe"
            currency = "ARS"
            amount = 10
            installments = 1
            payment_status = "approved"
            payment_detail = "accredited"
            poi = "BBPOS-01099923701497"
            poi_type = "BBPOS"
            payment_method_id = "debvisa"
            operator_id = "12345678"
        }
        "/point_payment/error"(platform: "/mobile", type: TrackType.View) {
            from = "/point_catalog"
            error_msg = "No podemos procesar esta tarjeta. Prueba con otra"
        }
        "/point_payment/flow_tracker/pairing"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            level ="error"
            message ="Can't pair"
        }
        "/point_payment/flow_tracker/payment_methods_get"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{data: log}"
        }
        "/point_payment/flow_tracker/configuration"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{configured: 2313}"
        }
        "/point_payment/flow_tracker/payment_methods_response"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{response: 2313}"
        }
        "/point_payment/flow_tracker/card_token_results"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
    }

    test("Point Catalog") {

        "/catalog"(platform: "/mobile", type: TrackType.View) {}
        "/catalog/create_product"(platform: "/mobile", type: TrackType.View) {}
        "/catalog/create_product/picture"(platform: "/mobile", type: TrackType.View) {}
        "/catalog/discount"(platform: "/mobile", type: TrackType.View) {}
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
        "/digital_goods/terms_and_conditions"(platform: "/mobile") {
            flow = "digital_goods"
        }
    }

    test("Cellphone recharge") {
        "/cellphone_recharge/push_handler"(platform: "/mobile") {
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

        "/cellphone_recharge/confirm"(platform: "/web"){
            flow = "/cellphone_recharge"
        }

        "/cellphone_recharge/suggested_phones"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            from = "/sidebar_taladro"
        }
        "/cellphone_recharge/second_password"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/phone_income"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            status = "approved"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            status = "pending"
        }
        "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
            status = "rejected"
        }
        "/cellphone_recharge/companies"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/checkout"(platform: "/web/desktop", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/amounts"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/amount_recommended"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/alias_income"(platform: "/web/mobile", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/account_money"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/error"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
        }
        "/cellphone_recharge/not-found"(platform: "/web", type: TrackType.View) {
            flow = "/cellphone_recharge"
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

        "/money_request/confirm"(platform: "/web"){
            flow = "/money_request"
        }
        "/money_request/congrats"(platform: "/web"){
            flow = "/money_request"
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

        "/fund_account/confirm"(platform: "/web"){
            flow = "/fund_account"
        }
    }

    test("new-withdraw") {
        "/new-withdraw"(platform: "/", type: TrackType.View){}
        "/new-withdraw/confirm"(platform: "/", type: TrackType.View){
            type="cap_prediction"
            type_detail="by_cap_uif"
        }
        "/new-withdraw/account-select"(platform: "/", type: TrackType.View){}
        "/new-withdraw/second-password"(platform: "/", type: TrackType.View){}
        "/new-withdraw/congrats"(platform: "/", type: TrackType.View){}
        "/new-withdraw/congrats-advance"(platform: "/", type: TrackType.View){}
    }

    test("new-account"){
        "/new-account"(platform: "/"){}
    }

    test("Withdraw") {
        "/withdraw/withdrawable_money"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw/take_money_out"(platform: "/") {
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
    test("App authorization tracks") {
        "/oauth/authorization/form"(platform: "/", type: TrackType.Event) {
            source = "LFE"
        }
        "/oauth/authorization/form/access"(platform: "/", type: TrackType.Event) {
            source = "LFE"
            authorize = true
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

    test("Saving credentials to Smart Lock for Passwords") {
        "/login/smartlock/save_credentials"(platform: "/mobile") {}
        "/login/smartlock/save_credentials/already_saved"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/save_credentials/resolution_required"(platform: "/mobile", type: TrackType.Event) {
            success = true
        }
        "/login/smartlock/save_credentials/resolution_required"(platform: "/mobile", type: TrackType.Event) {
            success = false
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "CANCELED"
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "TIMEOUT"
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "NETWORK_ERROR"
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "API_NOT_CONNECTED"
        }
    }

    test("Abuse Prevention in Identification and Authentication") {
      "/auth/abuse_prevention"(platform: "/mobile", type: TrackType.Event) {
        result = "low"
      }
      "/auth/abuse_prevention/ban"(platform: "/web", type: TrackType.Event) {
          result = "low"
      }
      "/auth/abuse_prevention/login"(platform: "/web", type: TrackType.Event) {
        device_id = "1"
        platform = "web"
      }
      "/auth/abuse_prevention/login"(platform: "/mobile", type: TrackType.Event) {
        device_id = "1"
        platform = "mobile"
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

        "/identity-validation/upload_compress"(platform: "/mobile/ios") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/upload_compress"(platform: "/mobile/android") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/upload_compress"(platform: "/web/mobile") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/upload_compress"(platform: "/web/desktop") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/phone_code"(platform: "/mobile") {}
        "/identity-validation/phone"(platform: "/mobile") {}
        "/identity-validation/upload_doc"(platform: "/mobile") {}
        "/identity-validation/landing"(platform: "/mobile") {}
        "/identity-validation/congrats"(platform: "/mobile") {}
        "/identity-validation/landing_doc"(platform: "/mobile") {}
        "/identity-validation/doc_number"(platform: "/mobile") {}

        "/identity-validation/phone_code"(platform: "/web/desktop") {}
        "/identity-validation/phone"(platform: "/web/desktop") {}
        "/identity-validation/upload_doc"(platform: "/web/desktop") {}
        "/identity-validation/landing"(platform: "/web/desktop") {}
        "/identity-validation/congrats"(platform: "/web/desktop") {}
        "/identity-validation/landing_doc"(platform: "/web/desktop") {}
        "/identity-validation/doc_number"(platform: "/web/desktop") {}

        "/identity-validation/phone_code"(platform: "/web/mobile") {}
        "/identity-validation/phone"(platform: "/web/mobile") {}
        "/identity-validation/upload_doc"(platform: "/web/mobile") {}
        "/identity-validation/landing"(platform: "/web/mobile") {}
        "/identity-validation/congrats"(platform: "/web/mobile") {}
        "/identity-validation/landing_doc"(platform: "/web/mobile") {}
        "/identity-validation/doc_number"(platform: "/web/mobile") {}

    }

    test("Checkout Off"){

        def defaultOptions = {
            options = [
                    [
                            has_esc       : false,
                            card_id       : "",
                            payment_method: "visa",
                            payment_type  : "credit_card"
                    ],
                    [
                            has_esc       : true,
                            card_id       : "1234",
                            payment_method: "visa",
                            payment_type  : "credit_card"
                    ]
            ]
        }

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

        //Unified tracking tests

        //Actions
        "/checkout_off/v1/init"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
            purchase_amount = "500"
        }

        "/checkout_off/v1/payment_method_selected"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
            payment_method = "visa"
            payment_type = "credit_card"
            purchase_amount = "500"
            automatic_selection = true
        }

        "/checkout_off/v1/checkout_confirmed"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
            purchase_amount = "500"
            card_id = "1234"
            installments = 3
        }

        "/checkout_off/v1/payment_created"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
            payment_id = "3212321"
            payment_amount = "500"
            payment_method = "visa"
            payment_type = "credit_card"
            payment_status = "approved"
            payment_status_detail = "accredited"
        }

        //Views
        "/checkout_off/v1/login"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/login/guest"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/login/discount"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/express"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/payment_option"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
            defaultOptions()
        }

        "/checkout_off/v1/payment_option/ticket"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/payment_option/bank_transfer"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/payment_option/cards"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
            defaultOptions()
        }

        "/checkout_off/v1/additional_info/bolbradesco"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/additional_info/pse"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/additional_info/khipu"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/additional_info/redpagos"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/additional_info/abitab"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/card/credit_card"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/card/debit_card"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/card/issuer"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/card/installments"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/identification"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/shipping"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/shipping/address"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/shipping/method"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/review"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/congrats/approved"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/congrats/pending"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/congrats/instructions"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/congrats/rejected"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/congrats/in_process"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }

        "/checkout_off/v1/payment_canceled"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
            payment_id = "3212321"
            payment_amount = "500"
            payment_method = "visa"
            payment_type = "credit_card"
        }

        "/checkout_off/v1/consumer_credit/installments"(platform: "/web/mobile") {
            checkout_flow_id = "cca9bcd2-421a-11e7-a919-92ebcb67fe33"
            collector_id = "d17ab7e8-421a-11e7-a919-92ebcb67fe33"
            collector_nickname = "collector nickname test"
            client_id = "1321312"
            environment = "production"
        }
    }

    //MP frontend
    test("Configuracion de campanias de descuento"){
        "/campaigns/create"(platform: "/web", type: TrackType.View){}
        "/campaigns/confirm_create"(platform: "/web"){}
    }

    test("Suscripciones"){
        "/subscription_plan/create"(platform: "/web", type: TrackType.View){}
        "/subscription_plan/confirm_create"(platform: "/web"){}
    }

    //MP personalFrontend
    test("Listado de Herramientas Creadas"){
        "/tools/list"(platform: "/web", type: TrackType.View){}
        "/tools/list/button_create"(platform: "/web"){}
    }

    test("Crear Herramienta de cobro"){
        "/tools/create"(platform: "/web", type: TrackType.View){}
        "/tools/confirm_create_edit"(platform: "/web"){}
    }

    test("Configuraciones de Negocio"){
        "/my_business"(platform: "/web", type: TrackType.View){}
        "/my_business/how_it_works_ME"(platform: "/web"){}
        "/my_business/enable_ME"(platform: "/web"){}
        "/my_business/disable_ME"(platform: "/web"){}

        "/my_business/split_payment"(platform: "/web"){}
        "/my_business/recovery_mails"(platform: "/web"){}
        "/my_business/cost_absorption"(platform: "/web"){}
    }

    //MP listings
    test("Informes"){
        "/listings/movements"(platform: "/web", type: TrackType.View){}
        "/listings/with_holdings"(platform: "/web", type: TrackType.View){}
        "/charts/show"(platform: "/web", type: TrackType.View){}
        "/balance/reports"(platform: "/web", type: TrackType.View){}
    }

    // MP Devsite
    test("MercadoPago Devsite"){
        "/devsite/navigation"(platform: "/web/mobile", type: TrackType.View) {
            user_id = "1321312"
            lang = "es"
            site = "mla"
            uri = "/guides"
        }
    }

    test("free data") {

        "/free_navigation/not_available"(platform:"/mobile", type:TrackType.Event) {}

        "/free_navigation/wifi"(platform:"/mobile", type:TrackType.Event) {}
    }


    test("Bugsnag tracks to use on Canejo MP") {
        "/mobile/bugsnag"(platform:"/mobile/android", type:TrackType.Event) {
            error_type = "signal"
            error_context = "withdraw"
            error_severity = "error"
            url_error = "<none>"
            error_mach_exception_name = "<none>"
            error_address = "4402117060"
            error_message = ""
            error_Id = "5aa6bcd0c098f300193384fb"
            error_timestamp = "2018-04-18T14:18:09.301Z"
            error_exception_class = "SIGTRAP"
            release_stage = "production"
            error_signal_name = "SIGTRAP"
            error_nsexception = "<none>"
        }
    }

}
