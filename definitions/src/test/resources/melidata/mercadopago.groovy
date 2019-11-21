package src.test.resources.melidata

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

        "/register/user_delete"(platform: "/"){
            application_source = "registration"
            reason = "register_not_validated"
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
            app = "registration"
            source = "email"
            captcha_showed = true
            prog_reg_version = 0
        }

        "/register/form"(platform:"/mobile") {
            app = "normal"
            register_type = "company"
        }

        "/register/form/challenge/require" (platform: "/mobile") {
            app = "normal"
        }

        "/register/form/challenge/require" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
        }

        "/register/form/challenge/require" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            register_type = "person"
        }

        "/register/form/challenge/show" (platform: "/mobile") {
            app = "normal"
        }

        "/register/form/challenge/show" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
        }

        "/register/form/challenge/show" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            register_type = "person"
        }

        "/register/form/challenge/cancel" (platform: "/mobile") {
            app = "normal"
        }

        "/register/form/challenge/cancel" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
        }

        "/register/form/challenge/cancel" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            register_type = "person"
        }

        "/register/form/challenge/solve" (platform: "/mobile") {
            app = "normal"
        }

        "/register/form/challenge/solve" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
        }

        "/register/form/challenge/solve" (platform: "/mobile") {
            app = "normal"
            origin = "drawer"
            register_type = "person"
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

    test("Landing mercadopago sellers mss") {
        "/landing/sellers/mss" (platform: "/web") {
            page_name = "dzero"
        }
    }

    test("Landing mercadopago sellers mss click event") {
        "/landing/sellers/mss/click" (platform: "/web") {
            id = "dzero"
            label = "test label"
            page_name = "dzero"
        }
    }

    test("Landing mercadopago buyers") {
        "/landing/buyers" (platform: "/web") {}
    }

    test("Landing mercadopago promotions") {
        "/landing/promotions" (platform: "/web") {}
    }

    test("Landing form comercial") {
        "/landing/formcomercial"(platform: "/", type: TrackType.View) {}
    }

    test("Landing form comercial send email") {
        "/landing/formcomercial/send_email"(platform: "/", type: TrackType.Event) {
          email = "teste@teste.com.br"
        }
    }

    test("Landing alliance bancocolombia") {
        "/alliance/landing"(platform: "/", type: TrackType.View) {
            company_name = "bancocolombia"
        }
    }

    test("Growth Frontend Login") {
        "/growth/login"(platform: "/", type: TrackType.View) {
          view = "split"
        }

        "/growth/login"(platform: "/", type: TrackType.View) {
          view = "guest"
        }
    }

    test("Point Buying Flow") {
        "/point/buyingflow/start"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          has_coupon = true
          coupon_code = "GHZM"
        }

        "/point/buyingflow/shippingOptions"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
        }

        "/point/buyingflow/newAddress"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
        }

        "/point/buyingflow/paymentMethods"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
        }
        
        "/point/buyingflow/payment_ticket_info"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
        }

        "/point/buyingflow/paymentInstallments"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
        }

        "/point/buyingflow/paymentInstallments/installments"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
        }

        "/point/buyingflow/paymentNewCard"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
        }

        "/point/buyingflow/paymentCardSecurityCode"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
        }

        "/point/buyingflow/payment_bank_selector"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
        }

        "/point/buyingflow/paymentReview"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          selected_payment_method_id = "tarshop"
          selected_payment_method_type = "credit_card"
          installments = 6
        }

        "/point/buyingflow/paymentRejected"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          selected_payment_method_id = "tarshop"
          selected_payment_method_type = "credit_card"
          installments = 6
        }
        
        "/point/buyingflow/error"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          type = "error: Session ended"
        }

        "/point/buyingflow/paymentReview/confirmPurchase"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
        }
    }

    test("MP-MA Landing QR") {
        "/merchant_acquisition/qr/landing" (platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/qr/landing/promotions"(platform: "/", type: TrackType.Event) {}
        "/merchant_acquisition/qr/landing/video" (platform: "/", type: TrackType.Event) {
            value = "hero"
            trigger = "click_qr_video"
        }
        "/merchant_acquisition/qr/landing/landing-get-qr-code"(platform: "/", type: TrackType.Event) {}
    }

    test("MP-MA Flow QR Assignment") {
        "/merchant_acquisition/flows/qr-assignment"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-assignment/success"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-assignment/error"(platform:"/", type: TrackType.View) {
            status = 'invalidAccess'
        }
        "/merchant_acquisition/flows/qr-assignment/error"(platform:"/", type: TrackType.View) {
            status = 'error'
        }
        "/merchant_acquisition/flows/qr-assignment/validate_email"(platform:"/", type: TrackType.Event) {
          valid = true
        }
        "/merchant_acquisition/flows/qr-assignment/validate_email"(platform:"/", type: TrackType.Event) {
          valid = false
        }
        "/merchant_acquisition/flows/qr-assignment/qr_scan"(platform:"/", type: TrackType.Event) {
          qr_content = 'http://qr-content'
        }
    }

    test("Share MGM Web") {
        "/merchant_acquisition/flows/share_mgm"(platform:"/", type: TrackType.View) {}

        "/merchant_acquisition/flows/share_mgm/about_share"(platform:"/", type: TrackType.Event) {}

        "/merchant_acquisition/flows/share_mgm/share_device_button"(platform:"/", type: TrackType.Event) {
          product = "point-h"
        }

        "/merchant_acquisition/flows/share_mgm/more_info_device"(platform:"/", type: TrackType.Event) {
          product = "point-h"
        }

        "/merchant_acquisition/flows/share_mgm/device/invite"(platform:"/", type: TrackType.Event) {
          media = "whastapp"
          product = "point-h"
        }

        "/merchant_acquisition/flows/share_mgm/device/invite/send_email"(platform: "/", type: TrackType.Event) {}

        "/merchant_acquisition/flows/share_mgm/banner"(platform:"/", type: TrackType.Event) {
          banner_name = "Kit promotional"
        }
    }

    test("Paper Rolls (Bobinas)") {
        "/merchant_acquisition/flows/paper_rolls"(platform:"/", type: TrackType.View) {
          view = "order"
        }

        "/merchant_acquisition/flows/paper_rolls/complete_form"(platform:"/", type: TrackType.Event) {
          view = "order"
        }
        "/merchant_acquisition/flows/paper_rolls/modal/update_address"(platform: "/", type: TrackType.Event) {
          view = "order"
        }
        "/merchant_acquisition/flows/paper_rolls/modal/add_address"(platform: "/", type: TrackType.Event) {
          view = "order"
        }
    }

    test("MP-MA Flow QR Queue Web") {
        "/merchant_acquisition/flows/qr-queue"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-queue/amount"(platform:"/", type: TrackType.View) {
            onboarding = true
        }
        "/merchant_acquisition/flows/qr-queue/amount"(platform:"/", type: TrackType.View) {
            onboarding = false
        }

        "/merchant_acquisition/flows/qr-queue/amount/download"(platform:"/", type: TrackType.Event) { onboarding = true }
        "/merchant_acquisition/flows/qr-queue/amount/print"(platform:"/", type: TrackType.Event) { onboarding = true }
        "/merchant_acquisition/flows/qr-queue/amount/replace-amount"(platform:"/", type: TrackType.Event) { onboarding = true }
        "/merchant_acquisition/flows/qr-queue/amount/pos-changed"(platform:"/", type: TrackType.Event) { onboarding = true}
        "/merchant_acquisition/flows/qr-queue/amount/store-changed"(platform:"/", type: TrackType.Event) { onboarding = true}

        "/merchant_acquisition/flows/qr-queue/waiting-payment"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-queue/congrats"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-queue/error"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-queue/waiting-payment/retry"(platform:"/", type: TrackType.Event) {}
        "/merchant_acquisition/flows/qr-queue/waiting-payment/extend-time"(platform:"/", type: TrackType.Event) {}
    }

    test("MP Point Transfer") {
        "/merchant_acquisition/flows/transfer-device"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/transfer-device/success"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/transfer-device/empty"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/transfer-device/error"(platform: "/", type: TrackType.View) {}
    }

    test("MP Point Register") {
        "/merchant_acquisition/flows/register-device"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/register-device/success"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/register-device/error"(platform: "/", type: TrackType.View) {}
    }

    test("MP Point Release Options") {
        "/merchant_acquisition/flows/release-options"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/release-options/success"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/release-options/error"(platform: "/", type: TrackType.View) {}
    }

    test("MP Micrositio Reseller") {
    "/merchant_acquisition/flows/resellers"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/bundles"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/bundles/share"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/bundles/click"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/bundles/open"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/bundles/close"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/mgm"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/mgm/click"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/mgm/share"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/mgm/open"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/mgm/close"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/dashboard"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/dashboard/click"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/dashboard/share"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/dashboard/open"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/dashboard/close"(platform:"/", type: TrackType.View) {
      page_resource = 'device-item'
    }
    "/merchant_acquisition/flows/resellers/benefits"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/metrics"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/associate_device"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/register_device"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/register_device/individual"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/register_device/bundle"(platform:"/", type: TrackType.View) {}
    }

    test("// Associar Point - Micrositio - reseller") {
        "/merchant_acquisition/flows/resellers/point_register"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/resellers/point_register/associate"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/resellers/point_register/success"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/resellers/point_register/no_account"(platform: "/", type: TrackType.View) {}
    }


    test("Envio proactivo QR - Associar QR + Point - qr-point-assignment") {
        "/merchant_acquisition/flows/qr-point-assignment"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-point-assignment/qr"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-point-assignment/store"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-point-assignment/congrats"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-point-assignment/error"(platform: "/", type: TrackType.View) {}
        "/merchant_acquisition/flows/qr-point-assignment/unauthorized"(platform: "/", type: TrackType.View) {}
    }

    test("MP-MA Flow QR") {
        "/merchant_acquisition/qr/onboarding"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/qr-code"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/pending"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/error"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/settings"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/permission-denied"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/web-mobile"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/qr/qr-code/download"(platform:"/", type: TrackType.Event) {}
        "/merchant_acquisition/qr/qr-code/print"(platform:"/", type: TrackType.Event) {}
        "/merchant_acquisition/qr/qr-code/faqs"(platform:"/", type: TrackType.Event) {}
        "/merchant_acquisition/qr/qr-code/help"(platform:"/", type: TrackType.Event) {}
        "/merchant_acquisition/qr/qr-code/rates"(platform:"/", type: TrackType.Event) {}
    }

    test("MP-MA Flow MCC") {
        "/merchant_acquisition/mydata/edit"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/mydata/success"(platform:"/", type: TrackType.View) {}
    }

    test("Point Flow Congrats Instructions") {
        "/point/flows/congrats/instructions"(platform:"/") {
          payment_id = 4334902696
          payment_method = "bolbradesco"
          device_id = "9"
          amount = 118.11
          is_guest = false
        }
    }

    test("Point Flow Congrats") {
        "/point/flows/congrats"(platform:"/") {
          payment_id = 4334902696
          payment_method = "bolbradesco"
          device_id = "9"
          amount = 118.11
          is_guest = false
        }
    }

    test("Point Flow Congrats Instructions click events") {

        "/point/flows/congrats/instructions/print"(platform:"/", type: TrackType.Event) {
          payment_id = 4334902696
          payment_method = "bolbradesco"
          device_id = "9"
          amount = 118.11
          is_guest = false
        }
        "/point/flows/congrats/instructions/copy"(platform:"/", type: TrackType.Event) {
          payment_id = 4334902696
          payment_method = "bolbradesco"
          device_id = "9"
          amount = 118.11
          is_guest = false
        }
        "/point/flows/congrats/instructions/map"(platform:"/", type: TrackType.Event) {
          payment_id = 4334902696
          payment_method = "bolbradesco"
          device_id = "9"
          amount = 118.11
          is_guest = false
        }
        "/point/flows/congrats/instructions/prepaid_offer_refuse"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
        "/point/flows/congrats/instructions/prepaid_offer_register"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
        "/point/flows/congrats/instructions/prepaid_offer_accept"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
        "/point/flows/congrats/instructions/continue"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
        "/point/flows/congrats/instructions/unlockprepaid"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
        "/point/flows/congrats/instructions/followprepaid"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
    }

    test("Point Flow Congrats click events") {

        "/point/flows/congrats/print"(platform:"/", type: TrackType.Event) {
          payment_id = 4334902696
          payment_method = "bolbradesco"
          device_id = "9"
          amount = 118.11
          is_guest = false
        }
        "/point/flows/congrats/copy"(platform:"/", type: TrackType.Event) {
          payment_id = 4334902696
          payment_method = "bolbradesco"
          device_id = "9"
          amount = 118.11
          is_guest = false
        }
        "/point/flows/congrats/map"(platform:"/", type: TrackType.Event) {
          payment_id = 4334902696
          payment_method = "bolbradesco"
          device_id = "9"
          amount = 118.11
          is_guest = false
        }
        "/point/flows/congrats/prepaid_offer_refuse"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
        "/point/flows/congrats/prepaid_offer_register"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
        "/point/flows/congrats/prepaid_offer_accept"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
        "/point/flows/congrats/continue"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
        "/point/flows/congrats/unlockprepaid"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
        "/point/flows/congrats/followprepaid"(platform:"/", type: TrackType.Event) {
            payment_id = 4334902696
            payment_method = "bolbradesco"
            device_id = "9"
            amount = 118.11
            is_guest = false
        }
    }
    
    test("Point Friction test") {
        "/pos_mobile"(platform: "/mobile", type: TrackType.Event) {}
        "/pos_mobile/friction"(platform: "/mobile", type: TrackType.Event) {
            id = "error_generic"
            context = "point/card_reader"
            style = "snackbar"
            message = "No se pudo realizar el pago, intentelo nuevamente."
            attributable_to = "device"
        }
        "/pos_mobile/friction"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "12345-asdf-hash"
            id = "error_generic"
            context = "point/card_reader"
            style = "snackbar"
            message = "No se pudo realizar el pago, intentelo nuevamente."
            attributable_to = "device"
            extra_info = "missing_track_2"
        }
        "/pos_mobile/friction"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "12345-asdf-hash"
            id = "error_generic"
            context = "point/card_reader"
            style = "snackbar"
            message = "No se pudo realizar el pago, intentelo nuevamente."
            attributable_to = "device"
        }
        "/pos_mobile/friction"(platform: "/mobile", type: TrackType.Event) {
            id = "error_generic"
            context = "point/card_reader"
            style = "snackbar"
            message = "No se pudo realizar el pago, intentelo nuevamente."
            attributable_to = "device"
            extra_info = "missing_track_2"
        }
    }

    test("Point Seller Friction tests") {
        "/pos_seller/friction/device_comm_error"(platform: "/mobile", type: TrackType.Event) {
            context = "settings/reader_update"
            message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
            attributable_to = "reader"
            extra_info = [ poi: "CHB123456789012-LE", progress: 25.5 ]
        }
        "/pos_seller/friction/server_comm_error"(platform: "/mobile", type: TrackType.Event) {
            context = "settings/reader_update"
            message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
            attributable_to = "reader"
            extra_info = [ poi: "CHB123456789012-LE", progress: 25.5 ]
        }
        "/pos_seller/friction/battery_low_error"(platform: "/mobile", type: TrackType.Event) {
            context = "settings/reader_update"
            message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
            attributable_to = "reader"
            extra_info = [ poi: "CHB123456789012-LE"]
        }
        "/pos_seller/friction/reader_update_failed"(platform: "/mobile", type: TrackType.Event) {
            context = "settings/reader_update"
            message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
            attributable_to = "device"
            extra_info = [ poi: "CHB123456789012-LE", progress: 25.5 ]
        }
    }

    test("MP-MA Point Landings App Chinese") {
        "/merchant_acquisition/point-landings/app-chinese"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/point-landings/app-chinese/error"(platform:"/", type: TrackType.View) {}
        "/merchant_acquisition/point-landings/app-chinese/success"(platform:"/", type: TrackType.View) {}
    }

    test("Merchant Acquisition Widgets") {
        //reverse label
        "/merchant_acquisition/widget" (platform: "/") {
            type = "reverse-label"
        }

        // Widget de envíos
        "/merchant_acquisition/widget" (platform: "/") {
            type = "reset-chip"
        }
    }

    test("Landing mercadopago point") {
        "/point/landings" (platform: "/") {
            product = "point-h"
            currency = "R\$"
            price = 401
            discount = 0.16
            price_with_discount = 334.8
            has_coupon = true
            coupon_code = "Y96XA"
            coupon_type = "default"
        }
        "/point/landings/buy"(platform:"/", type: TrackType.Event) {
            product = "bbpos"
        }
        // Landing MGM
        "/point/landings" (platform: "/") {
            product = "mgm"
        }

        // Landing Bundles - bundle_point_* Depends on site.
        "/point/landings" (platform: "/") {
            product = "bundle_point_mini"
        }
    }

    test("Landing mercadopago payers growth") {
        "/payers_growth/landings" (platform: "/") {
            product = "mkt-combustibles"
        }
        "/payers_growth/landings" (platform: "/") {
            product = "shell-box"
        }
        "/payers_growth/landings" (platform: "/") {
            product = "mkt-mostaza"
        }
    }

    test("MP MLA/MLB/MLM Landing Bundles Point") {
        "/point/landings/landing_bundles_buy"(platform: "/", type: TrackType.Event) {
            quantity = 5
            product = "bundle_point_mini"
        }
    }

    test("Landing MercadoPago Point MGM > Events") {
      "/point/landings/mgm/share"(platform:"/", type: TrackType.Event) {
           product = "mgm"
       }
      "/point/landings/mgm/ios"(platform:"/", type: TrackType.Event) {
          product = "mgm"
      }
      "/point/landings/mgm/android"(platform:"/", type: TrackType.Event) {
          product = "mgm"
      }
      "/point/landings/mgm/prepago"(platform:"/", type: TrackType.Event) {
          product = "mgm"
      }
      "/point/landings/mgm/tyc"(platform:"/", type: TrackType.Event) {
          product = "mgm"
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
        "/shopping"(platform: "/mobile") {
            from = "/deep_link"
        }
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

    test("Camera") {
        "/camera"(platform: "/mobile/android") {
        }

    }

    test("Login Success") {
        "/login_success"(platform: "/mobile/ios") {
        }

    }


    test("Sign In") {
        "/sign_in"(platform: "/mobile") {
            from = "/deep_link"
        }
        "/sign_in/facebook"(platform: "/mobile") {
            label = "success"
            from = "/deep_link"
        }
        "/sign_in/facebook"(platform: "/mobile") {
            label = "canceled"
        }
        "/sign_in/facebook"(platform: "/mobile") {
            label = "failure"
            description = "invalid password"
        }
        "/sign_in/google"(platform: "/mobile") {
            label = "success"
        }
        "/sign_in/google"(platform: "/mobile") {
            label = "failure"
            description = "invalid password"
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
            description = "invalid password"
        }
        "/sign_in/mail"(platform: "/mobile") {
            label = "success"
        }
        "/sign_in/mail"(platform: "/mobile") {
            label = "failure"
            description = "already_exists"
        }
        "/sign_in/recovery_account_button"(platform: "/mobile") {
            label = "failure"
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

        "/send_money/bacen/ok"(platform: "/mobile", type: TrackType.Event) {
            flow = "/send_money"
        }
        "/send_money/bacen/cancel"(platform: "/mobile", type: TrackType.Event) {
            flow = "/send_money"
        }
        "/send_money/bacen/error"(platform: "/mobile", type: TrackType.Event) {
            flow = "/send_money"
        }
        "/send_money/bacen/open"(platform: "/mobile", type: TrackType.Event) {
            flow = "/send_money"
        }
        "/send_money/bacen/close"(platform: "/mobile", type: TrackType.Event) {
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
        "/point_payment/main"(platform: "/mobile", type: TrackType.View) {
            flow_origin = 'point'
        }
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
            amount = "10"
            installments = "1"
            payment_status = "approved"
            payment_detail = "accredited"
            poi = "BBPOS-01099923701497"
            poi_type = "BBPOS"
            payment_method_id = "debvisa"
            operator_id = "12345678"
            flow = "/point_payment"
            error_msg = "an error"
        }
        "/point_payment/result/sms"(platform: "/mobile", type: TrackType.View) {
            flow_id = "1231313123213"
            method = "swipe"
            currency = "ARS"
            amount = "10"
            installments = "1"
            payment_status = "approved"
            payment_detail = "accredited"
            poi = "BBPOS-01099923701497"
            poi_type = "BBPOS"
            payment_method_id = "debvisa"
            operator_id = "12345678"
            flow = "/point_payment"
            error_msg = "an error"
        }
        "/point_payment/error"(platform: "/mobile", type: TrackType.View) {
            from = "/point_catalog"
            error_msg = "No podemos procesar esta tarjeta. Prueba con otra"
        }
        "/point_payment/new_payment_entry_point"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/send_bill_congrats"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/send_sms"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/error_i_have_an_issue"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/error/generic"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/error/rejected"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/request_bluetooth"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/ftu_preorder_pax"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/ftu_qr"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing_chooser"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/selector"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/send_bill"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/point_ftu_newland"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/idempotency"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/point"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/qr_ftu"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/bank_selection"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/select_connected_device"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/link_share"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/link"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/qr"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/device_selection"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/qr_show_code"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/request_location"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/user_identification"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/ftu_preorder_bbpos"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/ftu_preorder_newland"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing_pax_turn_on"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing_bbposbt_device_selection"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing_bbposbt_turn_on"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/cart"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/permission_screen"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/deals"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing_newland_device_selection"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing_newland_turn_on"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/error/ownership"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/error/low_battery"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/web_view"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing/problem"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing/problem/help"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/bbpos_connectivity_help_web_view"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/qr_congrats"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/qr_congrats_nofee"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/bank_detail"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/pairing_ftu"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/new_payment"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/new_payment/deals"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/new_payment/deals/finantial_costs"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/buyer_email"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/discount"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/onboarding_brandname"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/onboarding_chooser"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/onboarding_how_to_charge"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/push_mcc"(platform: "/mobile", type: TrackType.View) {}

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
        "/point_payment/flow_tracker/card_tokens_result"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/card_tokens_request"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_error"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/start"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/payment_methods_request"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/payment_methods_response"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/end"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_next_step_after_payment"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_payment_card_tokens_request_put"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_payment_card_tokens_response_put"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_payment_request"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_payment_response"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_pos_sending_online_process"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_notification_request"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_notification_response"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_notification_sms_request"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_notification_sms_response"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/flow_pos_error_message"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/select_qr"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/select_point"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/select_link"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/waiting_card"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
        "/point_payment/flow_tracker/select_connected_device"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
            devices = "{m_device:{m_address:B0:F1:EC:72:37:2E},name:PAX-77770610}"
        }
        "/point_payment/flow_tracker/cancel_qr_charge"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            data ="{ctr: 2313}"
        }
         "/point_payment/flow_tracker/auto_reverse_off"(platform: "/mobile", type: TrackType.Event) {
            flow_id = "UUID"
            user_id = "123241234413"
            level ="info"
            trx_id = "as-123241234413"

        }

        "/point_payment/write_concept"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/customer_care"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/start_refund"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/customer_care_success"(platform: "/mobile", type: TrackType.View) {}


        "/point_payment/cash/ftu"(platform: "/mobile", type: TrackType.View) {}
        "/point_payment/cash/congrats"(platform: "/mobile", type: TrackType.View) {}

        "/settings/point/costs_calculator"(platform: "/mobile", type: TrackType.View) {
            flow = "point"
        }
        "/settings/point/settings/pricing"(platform: "/mobile", type: TrackType.View) {
            flow = "point"
        }
        "/settings/point/installment_cost"(platform: "/mobile", type: TrackType.View) {
            flow = "point"
        }
        "/settings/point/device_mlb"(platform: "/mobile", type: TrackType.View) {
            flow = "point"
        }
        "/settings/pairing"(platform: "/mobile", type: TrackType.View) {
            flow = "point"
        }

        "/settings/cost_calculator/detail"(platform: "/mobile", type: TrackType.View) {}
        "/settings/cost_calculator/chooser"(platform: "/mobile", type: TrackType.View) {}
        "/settings/cost_calculator/input"(platform: "/mobile", type: TrackType.View) {}

        "/settings/pricing"(platform: "/mobile", type: TrackType.Event) {
            flow = "settings"
            channel = "point"
            payment_method = "credit"
            old_release_days = 0
            new_release_days = 14
        }
        "/settings/pricing"(platform: "/mobile", type: TrackType.Event) {
            flow = "settings"
            channel = "qr"
            payment_method = "credit"
            old_release_days = 0
            new_release_days = 14
        }

        "/shortcuts/point"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/scan_qr"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/cellphone_recharge"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/sube_recharge"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/pay_services"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/send_money"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/member_get_member"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/sell_qr"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/open_request"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/credit_enrollment"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/credit_admin"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/techo"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/antenna_tv"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/money_request_with_qr"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/gas_station"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/transport"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/buy_credit"(platform: "/mobile", type: TrackType.Event) {}
        "/shortcuts/coupon"(platform: "/mobile", type: TrackType.Event) {}

        "/get_member/point"(platform: "/mobile", type: TrackType.View) {
            flow = "point"
        }

        "/ftu_release/point_app"(platform: "/mobile", type: TrackType.View) {}
        "/ftu_release/point_&_mp_app"(platform: "/mobile", type: TrackType.View) {}

        "/company_info/on_boarding"(platform: "/mobile", type: TrackType.View) {}
        "/company_info/main"(platform: "/mobile", type: TrackType.View) {}
        "/company_info/brand_name"(platform: "/mobile", type: TrackType.View) {}
        "/company_info/mcc"(platform: "/mobile", type: TrackType.View) {}
        "/company_info/push_soft_descriptor"(platform: "/mobile", type: TrackType.View) {}

        "/point_payment/dashboard"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Point Payment Test") {
        "/point_payment_test/test_payment"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Settings Point Reader Update") {
        "/settings/reader_update"(platform: "/mobile", type: TrackType.View) {
            flow = "/settings"
            poi = "CHB123456789012-LE"
        }
        "/settings/reader_update/onboarding"(platform: "/mobile", type: TrackType.View) {
            flow = "/settings"
            poi = "CHB123456789012-LE"
        }
        "/settings/reader_update/result"(platform: "/mobile", type: TrackType.View) {
            flow = "/settings"
            poi = "CHB123456789012-LE"
        }
        "/settings/reader_update/process_completed"(platform: "/mobile", type: TrackType.Event) {
            flow = "/settings"
            poi = "CHB123456789012-LE"
            duration = 120.7
            previous_version = "1.00.02.21"
            previous_config = "MEZZ_Generic_v6"
            new_version = "1.00.03.32"
            new_config = "MEZZ_Generic_v8"
        }
        "/settings/reader_update/cancel"(platform: "/mobile", type: TrackType.Event) {
            flow = "/settings"
            poi = "CHB123456789012-LE"
            duration = 120.7
            time_remaining = 20.7
            progress = 78.8
        }
    }

    test("MP Point Standalone") { //BORRAR CUANDO LA APP ESTÉ INHABILITADA

        "/card"(platform: "/mobile", type: TrackType.View) {}
        "/card_number"(platform: "/mobile", type: TrackType.View) {}
        "/card_type"(platform: "/mobile", type: TrackType.View) {}
        "/card_name"(platform: "/mobile", type: TrackType.View) {}
        "/help_web_view"(platform: "/mobile", type: TrackType.View) {}
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

        "/get_member/invite/invite"(platform: "/mobile", type:TrackType.Event) {
            flow = "/get_member"
            scope = "wallet"
        }

        "/get_member/redeem"(platform: "/mobile") {
            flow = "/get_member"
        }

        "/get_member/redeem"(platform: "/mobile") {
            flow = "/get_member"
            from = "/deep_link"
        }

        "/get_member/px_result"(platform: "/mobile") {
            flow = "/get_member"
            result_status = "rejected"
        }
    }

    test("MGM Navigation") {
        "/mgm/navigation" (platform: "/mobile", type: TrackType.Event) {
            realestates = [
                    [
                            "content_id": "drawer_mgm_seller_mp",
                            "origin": "user_journey",
                            "realestate_id": "drawer_mgm"
                    ]
            ]
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
        "/digital_goods/recommended_click"(platform: "/mobile", type: TrackType.Event) {
            flow = "/digital_goods"
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
        "/bill_payments/generic_paybills_screen"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/categories"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/barcode_scanner"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/products"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
            type = "option"
        }
        "/bill_payments/shopping"(platform: "/mobile") {
            flow = "/bill_payments"
            from = "/deep_link"
        }
        "/bill_payments/input_validation_error"(platform: "/mobile", type: TrackType.Event) {
            flow = "/bill_payments"
            from = "/deep_link"
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

    test("tfs_dashboard") {
        "/tfs_dashboard/home"(platform: "/", type: TrackType.View){}
        "/tfs_dashboard/home/general"(platform: "/", type: TrackType.View){}
        "/tfs_dashboard/home/online"(platform: "/", type: TrackType.View){}
        "/tfs_dashboard/home/offline"(platform: "/", type: TrackType.View){}
        "/tfs_dashboard/home/meli"(platform: "/", type: TrackType.View){}
        "/tfs_dashboard/detail"(platform: "/", type: TrackType.View){
            chart_id="tpv"
            section="online"
        }
        "/tfs_dashboard/compare"(platform: "/", type: TrackType.View){}
        "/tfs_dashboard/filters"(platform: "/", type: TrackType.View){}

        "/tfs_dashboard/tab_selection"(platform: "/", type: TrackType.Event){
            section="online"
        }
        "/tfs_dashboard/hint"(platform: "/", type: TrackType.Event){
            chart_id="tpv"
            section="online"
        }
        "/tfs_dashboard/home/delta"(platform: "/", type: TrackType.Event){
            chart_id="tpv"
            section="online"
        }
        "/tfs_dashboard/detail/delta"(platform: "/", type: TrackType.Event){
            chart_id="tpv"
            section="online"
        }
        "/tfs_dashboard/home/filters_apply"(platform: "/", type: TrackType.Event){
            section="online"
            filters=[
                    [
                        filter_id: "time_filter",
                        filter_value: "today"
                    ],
                    [
                        filter_id: "operator_filter",
                        filter_value: "1342"
                    ]
            ]
        }
        "/tfs_dashboard/detail/filters_apply"(platform: "/", type: TrackType.Event){
            section="online"
            chart_id="tpv"
            filters=[
                    [
                        filter_id: "time_filter",
                        filter_value: "today"
                    ],
                    [
                        filter_id: "operator_filter",
                        filter_value: "1342"
                    ]
            ]
        }
        "/tfs_dashboard/compare"(platform: "/", type: TrackType.Event){
            section="online"
            chart_id="tpv"
        }

        "/tfs_dashboard/home/error"(platform: "/", type: TrackType.Event){
            status_code=404
        }
        "/tfs_dashboard/detail/error"(platform: "/", type: TrackType.Event){
            status_code=404
            section="online"
            chart_id="tpv"
        }
        "/tfs_dashboard/home/card/error"(platform: "/", type: TrackType.Event){
            status_code=404
            section="online"
            chart_id="tpv"
        }
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
        "/withdraw/bacen/ok"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw/bacen/cancel"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw/bacen/error"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw/bacen/open"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw/bacen/close"(platform: "/mobile") {
            flow = "/withdraw"
            from = "/deep_link"
        }
        "/withdraw/main"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/confirmation"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/make_withdraw"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/add_account"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/congrats"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/error/generic_error"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/error/withdraw_failed"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/error/high_risk"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/error/uif"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/delay/manual_review"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/delay/offline"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/uif_change_account"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/restriction"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}
        "/withdraw/delay"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}            
         "/withdraw/error"(platform: "/mobile") { flow = "/withdraw"
            from = "/deep_link"}          
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

    test("Withdraw_delete_account") {
        "/withdraw/select_bank"(platform:"/mobile"){ flow = "/withdraw" }
        "/withdraw/select_bank/delete_account_modal"(platform:"/mobile", type: TrackType.View){ flow = "/withdraw" }    
        "/withdraw/select_bank/delete_account_modal/confirm"(platform:"/mobile", type: TrackType.Event){
            bank_account_id = "1234523"
            flow = "/withdraw"
        } 
        "/withdraw/select_bank/delete_account_modal/cancel"(platform:"/mobile", type: TrackType.Event){flow = "/withdraw"} 
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

    test("Money Detail") {
        "/money_detail/balance"(platform: "/mobile") {
            flow = "/money_detail"
            from = "/deep_link"
        }
        "/money_detail/help_modal"(platform: "/mobile") {
            flow = "/money_detail"
        }

        "/money_detail/withdraw"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/withdraw/main"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/withdraw/confirmation"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/withdraw/congrats"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/withdraw/add_account"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/withdraw/select_bank"(platform: "/mobile") {flow = "/money_detail"}   
        "/money_detail/withdraw/error"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/withdraw/error/high_risk"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/withdraw/error/generic_error"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/withdraw/uif_change_account"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/withdraw/delay/offline"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/withdraw/delay/manual_review"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/shopping"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/credits"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/activities"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/daily_detail"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/money_advance"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/restrictions"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/point_home"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/manual_code"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail/confirmation"(platform: "/mobile") {flow = "/money_detail"}
        "/money_detail"(platform: "/mobile") {flow = "/money_detail"}
    }

// END -- MPMOBILE TEST

    test("Login conversion tracks") {
        "/login"(platform: "/") {
            source = "LFE"
        }
        "/login/form"(platform: "/", type: TrackType.View) {
            challenge = "password"
            source = "QUESTION"
            tx = "tx"
            operator_id = null
        }
        "/login/form"(platform: "/", type: TrackType.View) {
            challenge = "user"
            source = "EXPLICIT"
            tx = "tx"
            operator_id = "123"
            has_error = false
            recaptcha = false
            old_user_id = "123456"
            old_user_nick = "nick"
        }
        "/login/recovery"(platform: "/web", type: TrackType.Event) {
            source = "LFE"
        }
        "/login/recovery"(platform: "/mobile", type: TrackType.View) {
            source = "LFE"
        }
        "/login/registration"(platform: "/", type: TrackType.Event) {
            source = "LFE"
        }
        "/login/auth/success"(platform: "/web", type: TrackType.Event) {
            source = "DEFAULT"
            tracking_id = "123"
            is_otp = true
            is_admin_otp = false
        }
        "/login/auth/success"(platform: "/web", type: TrackType.Event) {
            source = "DEFAULT"
            tracking_id = "123"
            is_otp = true
            is_admin_otp = false
            operator_id = null
            rememberme_enabled = true
        }
        "/login/auth/success"(platform: "/mobile", type: TrackType.Event) {
            challenge = "password"
            tracking_id = "123"
        }
        "/login/auth/failure"(platform: "/web", type: TrackType.Event) {
            challenge = "user"
            source = "FAVORITE"
            tx = "tx"
            reason = [error: "invalid user"]
            operator_id = null
        }
        "/login/auth/failure"(platform: "/mobile", type: TrackType.Event) {
            challenge = "user"
            is_otp = false
            is_admin_otp = true
            reason = [error: "invalid user"]
        }
        "/login/auth/challenge_success"(platform: "/web", type: TrackType.Event) {
            challenge = "pass"
            source = "QUESTION"
            tx = "tx"
            operator_id = "123"
        }
        "/login/auth/challenge_success"(platform: "/mobile", type: TrackType.Event) {
            challenge = "pass"
            is_otp = false
            is_admin_otp = false
        }
       "/login/auth/challenge_decline"(platform: "/", type: TrackType.View) {
            challenge = "pass"
            source = "QUESTION"
            tx = "tx"
            operator_id = null
        }
        "/logout"(platform: "/", type: TrackType.Event) {
            source = "MSL"
        }
        "/login/auth/error"(platform: "/mobile", type: TrackType.View) {
            error = "network"
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
        "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {
            attempt_type = "auto_sign_in"
        }
        "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {
            attempt_type = "retrieve_credentials"
        }
        "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {
            attempt_type = "multiple_credentials"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "RESOLUTION_REQUIRED"
            attempt_type = "retrieve_credentials"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "RESOLUTION_REQUIRED"
            attempt_type = "multiple_credentials"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "CANCELED"
            attempt_type = "auto_sign_in"
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

    test("Multiple credentials to Smart Lock for Passwords") {
        "/login/smartlock/multiple_credentials/credential_selected"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/multiple_credentials/cancel"(platform: "/mobile", type: TrackType.Event) {}
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

    test("Security feedback flow") {
        "/login/auth/feedback"(platform: "/web", type: TrackType.Event) {
            view = "answer"
            event_type = "click_go_change_pwd_button"
            view_type = "recognized"
        }
        "/login/auth/feedback"(platform: "/web", type: TrackType.Event) {
            view = "unrecognized"
            event_type = "click_go_home_button"
        }
        "/login/auth/feedback"(platform: "/web", type: TrackType.Event) {
            view = "review_login"
            event_type = "click_recongnized_button"
            notification_id = "a6bcc09b-ccef-4277-ad94"
        }
        "/login/auth/feedback"(platform: "/web", type: TrackType.Event) {
            view = "recognized"
            event_type = "render"
            phone_status = "hasPhone"
        }
    }

    test("Account recovery flow") {
        "/auth/account_recovery/recovery_confirmation"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/congrats"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/landing"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/phone_number_verification"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/on_hold"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/recovery_confirmation/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "confirm_button"
            is_webview = true
        }
        "/auth/account_recovery/recovery_confirmation/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "cancel_button"
            is_webview = true
        }
        "/auth/account_recovery/congrats/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "go_home_button"
            is_webview = true
        }
        "/auth/account_recovery/landing/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "validate_identity_button"
            is_webview = true
        }
        "/auth/account_recovery/landing/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "go_home_button"
            is_webview = true
        }
        "/auth/account_recovery/phone_number_verification/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "continue_button"
            is_webview = true
        }
        "/auth/account_recovery/on_hold/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "go_home_button"
            status_code = "429"
            is_webview = true
        }
        "/auth/account_recovery/on_hold/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "go_home_button"
            status_code = "403"
            is_webview = true
        }
    }

    test("Phone Enrollment flow") {
        "/auth/recovery/phone/registration"(platform: "/web", type: TrackType.Event) {
            redirect_url = 'www.mercadopago.com'
            flow_type = 'sms_enrollment'
            flow_sub_type = 'ULTIMATUM'
        }
        "/auth/recovery/phone/save"(platform: "/web", type: TrackType.Event) {
            redirect_url = "www.mercadopago.com"
            selected_phone_source = "manual"
            verified = false
            flow_type = "sms_enrollment"
            flow_sub_type = "LOGIN"
            visual_validation_allowed = true
        }
        "/auth/recovery/phone/verified"(platform: "/web", type: TrackType.Event) {
            redirect_url = "www.mercadopago.com"
            selected_phone_source = "manual"
            flow_type = "sms_enrollment"
            flow_sub_type = "LOGIN_NOTIF"
        }
        "/auth/phone_confirmation"(platform: "/", type: TrackType.Event) {
            event = "confirm"
        }
    }

    test("Authenticators") {
        "/auth/authentication_factors/sms"(platform: "/web", type: TrackType.Event) {
            event = "method_selector"
            flow_type = 'sms_enrollment'
            reauthentication = true
            risk_context = false
            sms_option = true
            call_option = true
            push_option = false
            option_selected = "sms"
        }
        "/auth/authentication_factors/primary_email"(platform: "/web", type: TrackType.Event) {
            event = "start_validation"
            flow_type = 'sms_enrollment'
            reauthentication = false
            risk_context = true
            option_selected = "primary_email"
            primary_email_option = true
            domain = "gmail"
        }
        "/auth/authentication_factors/social_connect"(platform: "/web", type: TrackType.Event) {
            event = "close_validation"
            flow_type = 'sms_enrollment'
            reauthentication = true
            risk_context = true
            option_selected = "microsoft_connect"
            google_connect_option = true
            domain = "gmail"
            is_google_account_of_different_user = "false"
            authenticator = "emailValidation"
        }
    }

    test("Device Attestation"){
        "/auth/attestation/start"(platform: "/mobile", type: TrackType.Event) {
            mode = "prefetch_only"
        }

        "/auth/attestation/start"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/signature/request"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/signature/created"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/signature/reuse"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/signature/expired"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/signature/fail"(platform: "/mobile", type: TrackType.Event) {
            reason = "quota exceeded"
        }

        "/auth/attestation/nonce/request"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/nonce/created"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/nonce/fail"(platform: "/mobile", type: TrackType.Event) {
            reason = "missing vendor"
        }
    }

    test("Device Authorization - Authentication") {
        "/authenticators/device_authorization/access_request"(platform: "/", type: TrackType.View) {}

        "/authenticators/device_authorization/access_request/fallback"(platform: "/", type: TrackType.View) {}

        "/authenticators/device_authorization/access_answer"(platform: "/", type: TrackType.View) {}

        "/authenticators/device_authorization/access_answer/send"(platform: "/", type: TrackType.Event) {
            status = "approve"
        }
    }

    test("Device Authorization - Enrollment") {
        "/authenticators/device_authorization/enrollment/greeting"(platform: "/", type: TrackType.View) {
            section = "security_settings"
        }

        "/authenticators/device_authorization/enrollment/access_request"(platform: "/", type: TrackType.View) {
            section = "security_settings"
        }

        "/authenticators/device_authorization/enrollment/access_request/fallback"(platform: "/", type: TrackType.View) {
            section = "security_settings"
        }

        "/authenticators/device_authorization/enrollment/access_answer"(platform: "/", type: TrackType.View) {
            section = "security_settings"
        }

        "/authenticators/device_authorization/enrollment/access_answer/send"(platform: "/", type: TrackType.Event) {
            section = "security_settings"
            status = "approve"
        }

        "/authenticators/device_authorization/enrollment/congrats"(platform: "/", type: TrackType.View) {
            section = "security_settings"
        }
    }

    test("Phone Validation - Authentication") {
        "/authenticators/phone_validation/channel_selector"(platform: "/", type: TrackType.View) {
            status = "pending_validation"
            available_channels = ["push", "sms", "call"]
        }

        "/authenticators/phone_validation/channel_selector/submit"(platform: "/", type: TrackType.Event) {
            status = "pending_validation"
            available_channels = ["push", "sms", "call"]
            selected_channel = "push"
        }

        "/authenticators/phone_validation/enter_code"(platform: "/", type: TrackType.View) {
            status = "pending_validation"
            available_channels = ["sms", "call"]
            selected_channel = "sms"
        }

        "/authenticators/phone_validation/enter_code/submit"(platform: "/", type: TrackType.Event) {
            status = "success"
            available_channels = ["sms", "call"]
            selected_channel = "call"
        }
    }

    test("Change Password") {
        "/auth/authentication_methods/password/change_form"(platform: "/", type: TrackType.Event) {
            redirect_url = "https://accountrecovery.mercadolibre.com.ar/collect/userInfo"
        }

        "/auth/authentication_methods/password/change"(platform: "/", type: TrackType.Event) {
            redirect_url = "https://accountrecovery.mercadolibre.com.ar/collect/userInfo"
            device_profile_id = "abc-123-def-456"
        }
    }

    test("Biometrics / Screenlock") {
        "/screenlock/validation_start"(platform: "/mobile/android", type: TrackType.Event) {
            flow_id = "flow"
            enrollment_status = "enabled"
            os_status = "biometrics"
        }

        "/screenlock/validation_start"(platform: "/mobile/ios", type: TrackType.Event) {
            flow_id = "flow"
            enrollment_status = "disabled"
            os_status = "biometrics"
        }

        "/screenlock/validation_end"(platform: "/mobile/android", type: TrackType.Event) {
            flow_id = "flow"
            enrollment_status = "enabled"
            os_status = "biometrics"
            elapsed_time = 50
            result = "success"
        }

        "/screenlock/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
            flow_id = "flow"
            enrollment_status = "enabled"
            os_status = "basic_screenlock"
            elapsed_time = 50
            result = "error"
            errors = ["user_cancelled"]
        }

        "/screenlock/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
            flow_id = "flow"
            enrollment_status = "enabled"
            os_status = "basic_screenlock"
            elapsed_time = 50
            result = "success"
        }
    }

    test("Screenlock") {
        "/security_settings/screenlock"(platform: "/mobile/android", type: TrackType.View) {
            os_status = "biometrics"
            enrollment_status = "enabled"
        }

        "/security_settings/screenlock"(platform: "/mobile/ios", type: TrackType.View) {
            os_status = "basic_screenlock"
            enrollment_status = "enabled"
        }

        "/security_settings/screenlock/toggle"(platform: "/mobile/android", type: TrackType.Event) {
            enrollment_status = "enabled"
            os_status = "biometrics"
        }

        "/security_settings/screenlock/toggle"(platform: "/mobile/ios", type: TrackType.Event) {
            enrollment_status = "enabled"
            os_status = "biometrics"
        }

        "/security_settings/screenlock/toggle"(platform: "/mobile/android", type: TrackType.Event) {
            enrollment_status = "disabled"
            os_status = "biometrics"
        }

        "/security_settings/screenlock/toggle"(platform: "/mobile/ios", type: TrackType.Event) {
            enrollment_status = "disabled"
            os_status = "biometrics"
        }
    }

    test("Push Notification") {
        "/auth/push_notification"(platform: "/mobile", type: TrackType.Event) {}
        "/auth/push_notification"(platform: "/mobile", type: TrackType.Event) {
            notified_user = "123"
        }
    }

    test("Multi Step Login Android") {
        "/login/auth/challenge"(platform: "/mobile", type: TrackType.View) {
            challenge = "nickname_or_email"
            tracking_id = "123"
        }
        "/login/auth/challenge"(platform: "/mobile", type: TrackType.View) {
            challenge = "enter_password"
            tracking_id = "123"
        }
        "/login/auth/challenge"(platform: "/mobile", type: TrackType.View) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
        }
        "/login/auth/challenge/submit"(platform: "/mobile", type: TrackType.Event) {
            challenge = "nickname_or_email"
            tracking_id = "123"
        }
        "/login/auth/challenge/submit"(platform: "/mobile", type: TrackType.Event) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
        }
        "/login/auth/challenge/cancel"(platform: "/mobile", type: TrackType.Event) {
            challenge = "nickname_or_email"
            tracking_id = "123"
        }
        "/login/auth/challenge/cancel"(platform: "/mobile", type: TrackType.Event) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
        }
        "/login/auth/challenge/error"(platform: "/mobile", type: TrackType.View) {
            challenge = "nickname_or_email"
            tracking_id = "123"
            errors = ["user_not_found"]
        }
        "/login/auth/challenge/error"(platform: "/mobile", type: TrackType.View) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
            errors = ["user_not_found"]
        }
        "/login/auth/challenge/decline"(platform: "/mobile", type: TrackType.Event) {
            challenge = "enter_password"
        }
        "/login/auth/challenge/restart"(platform: "/mobile", type: TrackType.Event) {
            challenge = "enter_password"
            tracking_id = "123"
        }
    }

    test("Security Settings") {
        "/security_settings"(platform: "/", type: TrackType.View) {}

        "/security_settings/2fa"(platform: "/", type: TrackType.View) {}

        "/security_settings/2fa/switch"(platform: "/", type: TrackType.Event) {
            status = "opted_in"
        }
    }

    test("Devices Admin") {
        "/security_settings/devices"(platform: "/", type: TrackType.View) {}

        "/security_settings/devices/action"(platform: "/", type: TrackType.Event) {
            event_type = "click"
            target = "unlink_button"
        }

        "/security_settings/devices/action"(platform: "/", type: TrackType.Event) {
            event_type = "click"
            target = "confirm_unlink_button"
        }
    }

    test("Change Password") {
        "/security_settings/password"(platform: "/", type: TrackType.View) {
            context = "feedback"
        }

        "/security_settings/password"(platform: "/", type: TrackType.View) {
            context = "security_settings"
        }

        "/security_settings/password/maxlength"(platform: "/", type: TrackType.Event) {
            context = "feedback"
        }

        "/security_settings/password/maxlength"(platform: "/", type: TrackType.Event) {
            context = "security_settings"
        }

        "/security_settings/password/success"(platform: "/", type: TrackType.Event) {
            context = "forgot"
            delete_sessions = false
        }

        "/security_settings/password/success"(platform: "/", type: TrackType.Event) {
            context = "feedback"
            delete_sessions = true
            lowend = true
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

        "/identity-validation/image_error"(platform: "/mobile/ios") {
            source = "TAKE_PHOTO"
        }

        "/identity-validation/image_error"(platform: "/mobile/android") {
            source = "TAKE_PHOTO"
        }

        "/identity-validation/image_error"(platform: "/web/mobile") {
            source = "TAKE_PHOTO"
        }

        "/identity-validation/image_error"(platform: "/web/desktop") {
            source = "TAKE_PHOTO"
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
        "/my_business"(platform: "/", type: TrackType.View){}
        "/my_business/how_it_works_ME"(platform: "/", type: TrackType.Event){
            how_it_works_me="click"
        }
        "/my_business/enable_ME"(platform: "/", type: TrackType.Event){
            mercado_envios="enable"
        }
        "/my_business/disable_ME"(platform: "/", type: TrackType.Event){
            mercado_envios="disable"
        }

        "/my_business/split_payment"(platform: "/", type: TrackType.Event){
            split_payment="enabled"
        }
        "/my_business/recovery_mails"(platform: "/", type: TrackType.Event){
            recovery_mails="disabled"
        }
        "/my_business/cost_absorption"(platform: "/", type: TrackType.Event){
            cost_absorption="deactivate"
        }
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
    
    test("Encuesta satisfaccion contenidos devsite"){
        "/devsite/feedback"(platform: "/web/mobile", type: TrackType.Event) {
            user_id = "1321312"
            lang = "es"
            site = "mla"
            like = "yes"
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

    test("Device settings") {
        "/device_settings"(platform: "/", type:TrackType.Event) {}

        "/device_settings/notifications"(platform: "/mobile/android", type:TrackType.Event) {
            device_id = "ee6f7bd224c2d6"
            enable = false
            registration_id = "dH2soSpvhwM:APA91bFwZmJy-wXP7DRLm_458FqPF9n8zbm7uVjixKUOHOS8FQ7QN-qSbWS_DrKYDiXyLzGE2giqzVf90fwyjNy4dkgi6hR_W_fv6JvnQo6B5AQ4BOX21g8wx0cLSrcJswrof5U3f"
        }
    }

    test("Single Player Frontend") {
        "/single_player/entertainment"(platform: "/web", type: TrackType.View) {}
        "/single_player/services"(platform: "/web", type: TrackType.View) {}
        "/single_player/sube"(platform: "/web", type: TrackType.View) {}
        "/single_player/transport"(platform: "/web", type: TrackType.View) {}
        "/single_player/send_sms"(platform: "/web", type: TrackType.Event) {
            activity = "entertainment"
            status = 'OK'
        }
        "/single_player/send_sms"(platform: "/web", type: TrackType.Event) {
            activity = "services"
            status = 'ERROR'
        }
        "/single_player/send_sms"(platform: "/web", type: TrackType.Event) {
            activity = "sube"
            status = 'OK'
        }
        "/single_player/send_sms"(platform: "/web", type: TrackType.Event) {
            activity = "transport"
            status = 'OK'
        }
        "/single_player/open_deep_link"(platform: "/web/mobile", type: TrackType.Event) {
            activity = "entertainment"
        }
        "/single_player/open_deep_link"(platform: "/web/mobile", type: TrackType.Event) {
            activity = "services"
        }
        "/single_player/open_deep_link"(platform: "/web/mobile", type: TrackType.Event) {
            activity = "sube"
        }
        "/single_player/open_deep_link"(platform: "/web/mobile", type: TrackType.Event) {
            activity = "transport"
        }
    }

    test("Stores frontend admin") {
        "/stores/create"(platform: "/web", type: TrackType.View) {}
        "/stores/link_operators"(platform: "/web", type: TrackType.View) {}
        "/stores/list"(platform: "/web", type: TrackType.View) {}
        "/stores/update"(platform: "/web", type: TrackType.View) {}
        "/stores/details"(platform: "/web", type: TrackType.View) {}
        "/stores/pos/create"(platform: "/web", type: TrackType.View) {}
        "/stores/pos/update"(platform: "/web", type: TrackType.View) {}
        "/stores/standalone_pos"(platform: "/web", type: TrackType.View) {}
        "/stores/move_pos"(platform: "/web", type: TrackType.View) {}

        "/stores/create"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/link_operators"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/list"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/update"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/details"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/pos/create"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/pos/update"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/standalone_pos"(platform: "/web/mobile", type: TrackType.View) {}
        "/stores/move_pos"(platform: "/web/mobile", type: TrackType.View) {}
    }

    test("Account mydata") {
        "/account"(platform: "/web", type: TrackType.View) {}
        "/account/mydata"(platform: "/web", type: TrackType.View) {}
        "/account/mydata/email"(platform: "/web", type: TrackType.View) {}
        "/account/mydata/email/congrats"(platform: "/web", type: TrackType.View) {}

        "/account"(platform: "/web/mobile", type: TrackType.View) {}
        "/account/mydata"(platform: "/web/mobile", type: TrackType.View) {}
        "/account/mydata/email"(platform: "/web/mobile", type: TrackType.View) {}
        "/account/mydata/email/congrats"(platform: "/web/mobile", type: TrackType.View) {}

        "/account/mydata/email"(platform: "/mobile/android", type: TrackType.View) {}
    }
}
