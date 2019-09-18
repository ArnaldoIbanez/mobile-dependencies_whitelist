package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Checkout Off") {

        def defaultProperties = {
            checkout_flow_id = "b24bcffe-4b26-46c9-8646-61891dbd978b"
            collector_nickname = "DUMMY_SELLER"
            product_id = "BC32A4JU643001OI3920"
            site = "MLA"
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
        }

        def finishDefaultProperties = {
            payment_installments = 3
            payment_status_detail = "accredited"
            payment_status = "approved"
        }

        def onlyRequiredProperties = {
            checkout_flow_id = "b24bcffe-4b26-46c9-8646-61891dbd978b"
            product_id = "BC32A4JU643001OI3920"
            site = "MLA"
            productive = true
            is_split = false
            payment_quantity = 1
        }

        def finishOnlyRequiredProperties = {
            payment_status_detail = "accredited"
            payment_status = "approved"
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

        "/checkout_off/agencies"(platform: "/web/mobile") {
            defaultProperties()
        }

        "/checkout_off/error"(platform: "/web/mobile") {
            defaultProperties()
        }

        //Final Views
        "/checkout_off/congrats"(platform: "/web/mobile") {
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

        "/checkout_off/agencies"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        "/checkout_off/error"(platform: "/web/mobile") {
            onlyRequiredProperties()
        }

        //Final Views
        "/checkout_off/congrats"(platform: "/web/mobile") {
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
    }
}