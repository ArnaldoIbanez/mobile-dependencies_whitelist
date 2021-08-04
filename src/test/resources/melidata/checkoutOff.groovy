package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Checkout Off - MercadoPago") {
        def defaultProperties = {
            checkout_flow_id = "b24bcffe-4b26-46c9-8646-61891dbd978b"
            product_id = "BC32A4JU643001OI3920"
            productive = true
            preference_id = "123456-ef5abdf8-6c2f-4f3e-a0b9-56a824203e61"
            operation_type = "regular_payment"
            is_express = false
            payer_id = "654321"
            payment_method_id = "visa"
            payment_type_id = "credit_card"
            is_split = true
            payment_quantity = 1
            collector_id = 1010101001
            available_methods = ["credit_card", "account_money"]
            total_amount = 100.00
            currency_id = "ARS"
            flow_context = "init"
            flow_type = "card_express"
            is_free_trial = false
            subscription_partner = "hbogo"
            loyalty_level = 1
            discount_type = "cosmetic"
            discount_percent = 10
            checkout_open_mode = "v2_checkout_redirect"
            items_quantity = 2
            app_candidate = true
            client_id = 470234553122
            errors = ["code: 13253, description: Collector user without key enabled for QR render"]
            visible_components = ["discharge": "qr"]
        }

        def launchingDefaultProperties = {
            productive = true
            collector_id = 1010101001
            preference_id = "123456-ef5abdf8-6c2f-4f3e-a0b9-56a824203e61"
            operation_type = "regular_payment"
            app_candidate = true
            client_id = 470234553122
        }

        def openSeaDefaultProperties = {
            opensea_status = "approved"
            opensea_message_shown = true
        }

        def finishDefaultProperties = {
            payment_installments = 3
            payment_status_detail = "accredited"
            payment_status = "approved"
            payment_id = "5408994392"
            total_amount = 100.00
            currency_id = "ARS"
            total_amount_usd = 1000.00
            items_quantity = 2
            congrats_status = "success"
        }

        def onlyRequiredProperties = {
            checkout_flow_id = "b24bcffe-4b26-46c9-8646-61891dbd978b"
            product_id = "BC32A4JU643001OI3920"
            productive = true
            is_split = false
            payment_quantity = 1
            total_amount = 100.00
            currency_id = "ARS"
            items_quantity = 2
        }

        def launchingOnlyRequiredProperties = {
            productive = true
        }

        def finishOnlyRequiredProperties = {
            payment_status_detail = "accredited"
            payment_status = "approved"
            payment_id = "5408994392"
            total_amount = 100.00
            currency_id = "ARS"
            total_amount_usd = 1000.00
            congrats_status = "success"
        }

        // ALL PROPERTIES TESTS
        // EVENTS
        "/checkout_off/init"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/checkout_confirmed"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/login"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/logout"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/select_type"(platform: "/web/mobile") {
            defaultProperties()
            openSeaDefaultProperties()
        }

        "/checkout_off/payment/select_stores"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/select_transfer"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_card/main"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_card/input_document"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_card/input_card_issuer"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_card/input_security_code"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_card/select_installment"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/card_express"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_credits/select_installment"(platform: "/web/mobile") {
            defaultProperties()
            openSeaDefaultProperties()
        }

        "/checkout_off/payment/input_credits/select_installment/terms_conditions"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/card/split_first"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/card/split_second"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/routing"(platform: "/web/mobile") {
            launchingDefaultProperties()
        }

        // Tokenizer product final screen.
        "/checkout_off/payment/processing"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/billing/input_info"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/review"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/review/shield_kyc"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/review/challenge_kyc"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/review/challenge_second_factor_auth"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/agencies"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/error"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/paypal_ftu"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/paypal_login"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/opensea_credits_ftu"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/opensea_credits_redirect"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/paypal_login/no_display"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/one_click_redirect"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/one_click_processing"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/one_click_return"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/review_express"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/shipping/select_method"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/review"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/input_zip_code"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/input_address"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/select_user_type"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/select_option"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/select_address"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/zipcode_finder"(platform: "/web/mobile") {
            defaultProperties()
        }

        //Final Views
        "/checkout_off/congrats"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/express_recover"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/offline_recover"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/no_display"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/call_for_auth/later"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/call_for_auth/how_to"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/call_for_auth/input_code"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/recovered"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        // ONLY REQUIRED TESTS
        // EVENTS
        "/checkout_off/init"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/checkout_confirmed"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/login"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/logout"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/select_type"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/select_stores"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/select_transfer"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_card/main"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_card/input_document"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_card/input_card_issuer"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_card/input_security_code"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_card/select_installment"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/card_express"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_credits/select_installment"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_credits/select_installment/terms_conditions"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        // Tokenizer product final screen.
        "/checkout_off/payment/processing"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/billing/input_info"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/review"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/review/shield_kyc"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/review/challenge_kyc"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/review/challenge_second_factor_auth"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/agencies"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/error"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/paypal_ftu"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/paypal_login"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/opensea_credits_ftu"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/opensea_credits_redirect"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/paypal_login/no_display"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/one_click_redirect"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/one_click_processing"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/one_click_return"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/review_express"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/shipping/select_method"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/review"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/input_zip_code"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/input_address"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/select_user_type"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/select_option"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/select_address"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/zipcode_finder"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        //Final Views
        "/checkout_off/congrats"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/express_recover"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/offline_recover"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/no_display"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/call_for_auth/later"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/call_for_auth/how_to"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/call_for_auth/input_code"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/recovered"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        // Properties not necessary but minimum
        "/checkout_off/error"(platform: "/web/mobile") {
            product_id = "BC32A4JU643001OI3920"
            productive = true
        }

        // Properties not necessary
        "/checkout_off/error"(platform: "/web/mobile") {
        }

        // Properties not necessary
        "/checkout_off/loading"(platform: "/web/mobile") {
        }

        "/checkout_off/routing"(platform: "/web/mobile") {
            launchingOnlyRequiredProperties()
        }

        // MP personalFrontend
        "/tools/list"(platform: "/"){
        }

        "/tools/list/button_create"(platform: "/"){
        }

        "/tools/create"(platform: "/"){
        }

        "/tools/confirm_create_edit"(platform: "/"){
        }

        "/balance/reports"(platform: "/web"){
        }
        // END -- MP personalFrontend
    }

    defaultBusiness = "mercadolibre"

    test("Checkout Off - MercadoLibre") {
        def defaultProperties = {
            checkout_flow_id = "b24bcffe-4b26-46c9-8646-61891dbd978b"
            product_id = "BC32A4JU643001OI3920"
            productive = true
            preference_id = "123456-ef5abdf8-6c2f-4f3e-a0b9-56a824203e61"
            operation_type = "regular_payment"
            is_express = false
            payer_id = "654321"
            payment_method_id = "visa"
            payment_type_id = "credit_card"
            is_split = true
            payment_quantity = 1
            collector_id = 1010101001
            available_methods = ["credit_card", "account_money"]
            total_amount = 100.00
            currency_id = "ARS"
            flow_context = "init"
            flow_type = "card_express"
            is_free_trial = false
            subscription_partner = "hbogo"
            loyalty_level = 1
            discount_type = "cosmetic"
            discount_percent = 10
            checkout_open_mode = "v2_checkout_redirect"
            items_quantity = 2
            app_candidate = true
            client_id = 470234553122
            errors = ["code: 13253, description: Collector user without key enabled for QR render"]
            visible_components = ["discharge": "qr"]
        }

        def launchingDefaultProperties = {
            productive = true
            collector_id = 1010101001
            preference_id = "123456-ef5abdf8-6c2f-4f3e-a0b9-56a824203e61"
            operation_type = "regular_payment"
            app_candidate = true
            client_id = 470234553122
        }

        def openSeaDefaultProperties = {
            opensea_status = "approved"
            opensea_message_shown = true
        }

        def finishDefaultProperties = {
            payment_installments = 3
            payment_status_detail = "accredited"
            payment_status = "approved"
            payment_id = "5408994392"

            total_amount = 100.00
            currency_id = "ARS"
            total_amount_usd = 1000.00
            congrats_status = "success"
        }

        def onlyRequiredProperties = {
            checkout_flow_id = "b24bcffe-4b26-46c9-8646-61891dbd978b"
            product_id = "BC32A4JU643001OI3920"
            productive = true
            is_split = false
            payment_quantity = 1
            total_amount = 100.00
            currency_id = "ARS"
            items_quantity = 2
        }

        def launchingOnlyRequiredProperties = {
            productive = true
        }

        def finishOnlyRequiredProperties = {
            payment_status_detail = "accredited"
            payment_status = "approved"
            payment_id = "5408994392"
            total_amount = 100.00
            currency_id = "ARS"
            total_amount_usd = 1000.00
            items_quantity = 2
            congrats_status = "success"
        }

        // ALL PROPERTIES TESTS
        // EVENTS
        "/checkout_off/init"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/checkout_confirmed"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/login"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/logout"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/select_type"(platform: "/web/mobile") {
            defaultProperties()
            openSeaDefaultProperties()
        }

        "/checkout_off/payment/select_stores"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/select_transfer"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_card/main"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_card/input_document"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_card/input_card_issuer"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_card/input_security_code"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_card/select_installment"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/card_express"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/input_credits/select_installment"(platform: "/web/mobile") {
            defaultProperties()
            openSeaDefaultProperties()
        }

        "/checkout_off/payment/input_credits/select_installment/terms_conditions"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/card/split_first"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/card/split_second"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/routing"(platform: "/web/mobile") {
            launchingDefaultProperties()
        }

        // Tokenizer product final screen.
        "/checkout_off/payment/processing"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/billing/input_info"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/review"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/review/shield_kyc"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/review/challenge_kyc"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/review/challenge_second_factor_auth"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/agencies"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/error"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/paypal_ftu"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/paypal_login"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/opensea_credits_ftu"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/opensea_credits_redirect"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/paypal_login/no_display"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/one_click_redirect"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/one_click_processing"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/one_click_return"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/review_express"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/shipping/select_method"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/review"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/input_zip_code"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/input_address"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/select_user_type"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/select_option"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/select_address"(platform: "/web/mobile") {
            defaultProperties()
        }
        "/checkout_off/shipping/zipcode_finder"(platform: "/web/mobile") {
            defaultProperties()
        }

        //Final Views
        "/checkout_off/congrats"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/express_recover"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/offline_recover"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/no_display"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/call_for_auth/later"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/call_for_auth/how_to"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/call_for_auth/input_code"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        "/checkout_off/congrats/recovered"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        // ONLY REQUIRED TESTS
        // EVENTS
        "/checkout_off/init"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/checkout_confirmed"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/login"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/logout"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/select_type"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/select_stores"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/select_transfer"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_card/main"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_card/input_document"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_card/input_card_issuer"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_card/input_security_code"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_card/select_installment"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/card_express"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_credits/select_installment"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/input_credits/select_installment/terms_conditions"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        // Tokenizer product final screen.
        "/checkout_off/payment/processing"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/billing/input_info"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/review"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/review/shield_kyc"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/review/challenge_kyc"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/review/challenge_second_factor_auth"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/agencies"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/error"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/paypal_ftu"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/paypal_login"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/opensea_credits_ftu"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/opensea_credits_redirect"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/paypal_login/no_display"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/one_click_redirect"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/payment/one_click_processing"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/one_click_return"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/payment/review_express"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/shipping/select_method"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/review"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/input_zip_code"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/input_address"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/select_user_type"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/select_option"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/select_address"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }
        "/checkout_off/shipping/zipcode_finder"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        //Final Views
        "/checkout_off/congrats"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/express_recover"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/offline_recover"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/no_display"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/call_for_auth/later"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/call_for_auth/how_to"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/call_for_auth/input_code"(platform: "/web/mobile") {
            onlyRequiredProperties()
            finishOnlyRequiredProperties()
        }

        "/checkout_off/congrats/recovered"(platform: "/web/mobile") {
            defaultProperties()
            finishDefaultProperties()
        }

        // Properties not necessary but minimum
        "/checkout_off/error"(platform: "/web/mobile") {
            product_id = "BC32A4JU643001OI3920"
            productive = true
        }

        // Properties not necessary
        "/checkout_off/error"(platform: "/web/mobile") {
        }

        // Properties not necessary
        "/checkout_off/loading"(platform: "/web/mobile") {
        }

        "/checkout_off/routing"(platform: "/web/mobile") {
            launchingOnlyRequiredProperties()
        }

        // MP personalFrontend
        "/tools/list"(platform: "/web"){
        }

        "/tools/list/button_create"(platform: "/web"){
        }

        "/tools/create"(platform: "/web"){
        }

        "/tools/confirm_create_edit"(platform: "/web"){
        }

        "/balance/reports"(platform: "/web"){
        }
        // END -- MP personalFrontend
    }
}
