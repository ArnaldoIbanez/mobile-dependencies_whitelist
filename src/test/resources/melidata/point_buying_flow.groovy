package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests


trackTests {
    defaultBusiness = "mercadopago"

    test("Point Buying Flow") {
        "/point/buyingflow/start"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          has_coupon = true
          discount_code = "GHZM"
          e2e_test = false
        }

        "/point/buyingflow/shipping_options"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/new_address"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/payment_methods"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          has_account_money = true
          has_consumer_credits = true
        }
        
        "/point/buyingflow/payment_ticket_info"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/payment_installments"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/payment_installments/installments"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/payment_new_card"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/payment_card_security_code"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/payment_bank_selector"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/payment_review"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          selected_payment_method_id = "tarshop"
          selected_payment_method_type = "credit_card"
          discount_code = "GHZM"
          installments = 6
          e2e_test = false
        }

        "/point/buyingflow/payment_rejected"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          selected_payment_method_id = "tarshop"
          selected_payment_method_type = "credit_card"
          discount_code = "GHZM"
          installments = 6
          e2e_test = false
        }
        
        "/point/buyingflow/error"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          error_code = 6
          e2e_test = false
        }

        "/point/buyingflow/payment_review/confirm_purchase"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/invalid_address"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/complete_phone"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
        }

        "/point/buyingflow/complete_card_data"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
        }

        "/point/buyingflow/sim_card"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
        }

        "/point/buyingflow/xsell"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
        }
        
        "/point/buyingflow/regret"(platform: "/", type: TrackType.View) {}
    }
}
