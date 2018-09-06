package src.test.resources

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
        }

        "/register/form"(platform: "/web/mobile") {
            app = "registration-question"
            source = "email"
            item_id = "MCO123321"
            captcha_showed = true
            prog_reg_version = 1
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

        "/register/form/facebook-connect"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/facebook-connect/facebook-register-selected"(platform:"/web/desktop") {
            app = "registration"
            source = "facebook"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/facebook-connect/email-register-selected"(platform:"/web/mobile") {
            app = "registration"
            source = "email"
            captcha_showed = false
            prog_reg_version = 0
        }

        "/register/form/facebook-connect/login-selected"(platform:"/web/desktop") {
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

}
