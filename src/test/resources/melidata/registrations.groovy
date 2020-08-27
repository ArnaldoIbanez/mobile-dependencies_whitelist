import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

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

        "/register/user_delete"(platform: "/"){
            application_source = "registration"
            reason = "register_not_validated"
        }
    }

    test("Progressive registration") {
        "/progressive_registration"(platform: "/mobile/android") {}
    }

    test("Register Web") {
        "/register/form"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            prog_reg_version = 1
            registration_version = "regi_v0_web"
        }

        "/register/form"(platform: "/web/desktop") {
            app = "shield"
            source = "email"
            origin = "bacen"
            captcha_showed = false
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form/error"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form/error"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            errors = [
                    [
                            code:0,
                            field: 'firstName',
                            message: 'Tu nombre es incorrecto'
                    ],
                    [
                            code:2,
                            field: 'lastName'
                    ]
            ]
            errors_validation = 'back'
            prog_reg_version = 1
            registration_version = "regi_v0_web"
        }

        "/register/form/error"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            errors = [
                    [
                            code:2,
                            field: 'lastName'
                    ]
            ]
            errors_validation = 'front'
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form/another-email"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            errors = [
                    [
                            code:8,
                            field: 'email'
                    ]
            ]
            errors_validation = 'back'
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form/error"(platform: "/web/desktop") {
            app = "shield"
            origin = "bacen"
            source = "email"
            captcha_showed = false
            errors = [
                    [
                            code:0,
                            field: 'firstName',
                            message: 'Tu nombre es incorrecto'
                    ],
                    [
                            code:2,
                            field: 'lastName'
                    ]
            ]
            errors_validation = 'back'
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form/another-email"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form/geolocation"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            geo_location_code = 1
            registration_version = "regi_v0_web"
        }

        "/register/form/facebook-connect"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form/facebook-connect/facebook-register-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "facebook"
            captcha_showed = false
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form/facebook-connect/email-register-selected"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form/facebook-connect/login-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }

        "/register/form/site-identification"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            ip_site_id = "MCO"
            registration_version = "regi_v0_web"
        }

        "/register/form/site-identification/url-site-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            ip_site_id = "MCO"
            registration_version = "regi_v0_web"
        }

        "/register/form/site-identification/ip-site-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            ip_site_id = "MCO"
            registration_version = "regi_v0_web"
        }

        "/register/success"(platform: "/web/desktop") {
            app = "registration-favorite"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/success"(platform: "/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 1
        }

        "/register/form/skip-update"(platform: "/web/desktop") {
            app = "registration-update-opt"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/successful-update"(platform: "/web/desktop") {
            app = "registration-syi"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }
        "/register/successful-update"(platform: "/web/mobile") {
            app = "registration-syi"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/optin"(platform: "/web/desktop") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/optin/push"(platform: "/web/mobile") {
            app = "registration-optin"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/optin/skip"(platform: "/web/mobile") {
            app = "registration-optin"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/form/email-suggest"(platform: "/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/congrats"(platform:"/web/desktop") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
            register_type = "person"
            registration_version = "regi_v0_web"
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
            register_type = "person"
            registration_version = "regi_v0_web"
        }
        "/register/form"(platform:"/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
            registration_version = "regi_v0_web"
        }
        "/register/form/email-suggest"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            register_type = "person"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/require" (platform: "/mobile") {
            app = "normal"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/require" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/require" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            register_type = "person"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/show" (platform: "/mobile") {
            app = "normal"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/show" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/show" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            register_type = "person"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/cancel" (platform: "/mobile") {
            app = "normal"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/cancel" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/cancel" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            register_type = "person"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/solve" (platform: "/mobile") {
            app = "normal"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/solve" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            registration_version = "regi_v0_web"
        }

        "/register/form/challenge/solve" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            register_type = "person"
            registration_version = "regi_v0_web"
        }

        "/register/form"(platform:"/mobile") {
            app = "normal"
            register_type = "company"
            registration_version = "regi_v0_web"
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
            registration_version = "regi_v0_web"
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
            registration_version = "regi_v0_web"
        }

        "/register/form/another-email"(platform:"/mobile") {
            app = "favorite"
            origin = "email"
            item_id = "MLA21233"
            registration_version = "regi_v0_web"
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
            registration_version = "regi_v0_web"
        }

        "/register/congrats"(platform:"/mobile") {
            app = "normal"
            origin = "email"
            register_type = "company"
            registration_version = "regi_v0_web"
        }

        "/register/success"(platform:"/mobile") {
            app = "normal"
            origin = "email"
            register_type = "person"
        }

        "/register/success"(platform:"/mobile") {
            source = "email"
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
            registration_version = "regi_v0_web"
        }

        "/register/form/update/save"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
            registration_version = "regi_v0_web"
        }

        "/register/form/update/not-now"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
            registration_version = "regi_v0_web"
        }

        "/register/successful-update"(platform:"/mobile") {
            app = "question"
            origin = "drawer"
            item_id = "MLM23143"
        }

        "/register/form/company-link"(platform: "/mobile"){
            app = "normal"
            registration_version = "regi_v0_web"
        }

        "/register/form/person-link"(platform: "/mobile"){
            app = "normal"
            registration_version = "regi_v0_web"
        }

        "/register/congrats/complete-fiscal-data"(platform: "/mobile"){
            app = "normal"
            register_type = "company"
            registration_version = "regi_v0_web"
        }

        "/register/congrats/complete-fiscal-data-later"(platform: "/mobile"){
            app = "normal"
            register_type = "company"
            registration_version = "regi_v0_web"
        }

        "/register/form/google_hint/show"(platform: "/mobile") {
            app = "mp"
            step = "phoneRegistration"
            field = "phone"
            registration_version = "regi_v0_web"
        }

        "/register/form/google_hint/select"(platform: "/mobile") {
            app = "mp"
            step = "phoneRegistration"
            field = "phone"
            registration_version = "regi_v0_web"
        }
    }

    test("Company Registration Desktop") {
        "/register/company/form"(platform: "/web", type: TrackType.View) {
        }
        "/register/company/congrats"(platform: "/web", type: TrackType.View) {
        }
        "/register/company/form/error"(platform: "/web", type: TrackType.Event) {
            errors = [
                    ["field": "cuit", "code": 1],
                    ["field": "socialReason", "code": 1],
                    ["field": "email", "code": 1],
                    ["field": "pass", "code": 1]
            ]
        }
    }

    test("Account Recovery tracking event") {

        "/register/accountRecovery"(platform: "/mobile", type: TrackType.Event) {
            error_type = "connectionError/invalidOneTimePassword/operatorNotSupported"
        }
    }

    test("Phone registration") {
        "/register/phone_registration/get_phone"(platform: "/mobile") {
            app = "mp"
        }

        "/register/phone_registration/get_phone/error"(platform: "/mobile") {
            app = "mp"
            errors_validation = "back"
            errors = [
                    [
                            code:00,
                            field: 'identification_phone'
                    ]
            ]
        }

        "/register/phone_registration/additional_data"(platform: "/mobile") {
            app = "mp"
        }

        "/register/phone_registration/additional_data/error"(platform: "/mobile") {
            app = "mp"
            errors_validation = "back"
            errors = [
                    [
                            code:00,
                            field: 'first_name'
                    ]
            ]
        }

        "/register/phone_registration/get_email"(platform: "/mobile") {
            app = "mp"
        }

        "/register/phone_registration/get_email/error"(platform: "/mobile") {
            app = "mp"
            errors_validation = "back"
            errors = [
                    [
                            code:00,
                            field: 'email'
                    ]
            ]
        }

        "/register/phone_registration/verification"(platform: "/mobile") {
            app = "mp"
            channel = "sms"
        }

        "/register/phone_registration/verification/error"(platform: "/mobile") {
            app = "mp"
            channel = "sms"
            errors_validation = "back"
            errors = [
                    [
                            code:00,
                            field: 'verification_code'
                    ]
            ]
        }

        "/register/phone_registration/phone_already_registered"(platform: "/mobile") {
            app = "mp"
        }

        "/register/phone_registration/send_code"(platform: "/mobile") {
            app = "mp"
        }

        "/register/phone_registration/resend_code"(platform: "/mobile") {
            app = "mp"
        }

        "/register/phone_registration/email_link"(platform: "/mobile") {
            app = "mp"
        }

        "/register/phone_registration/verification/autodetect_code"(platform: "/mobile") {
            app = "mp"
            channel = "sms"
        }

        "/register/phone_registration/sign_in"(platform: "/mobile") {
            app = "mp"
        }

        "/register/phone_registration/create_account"(platform: "/mobile") {
            app = "mp"
        }

        "/register/success"(platform:"/mobile") {
            app = "mp"
            source = "phone"
        }
    }

}
