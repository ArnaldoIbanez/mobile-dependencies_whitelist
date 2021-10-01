package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests


trackTests {
    defaultBusiness = "mercadopago"

    test("Point Buying Flow") {
        "/point/buyingflow/start"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          has_coupon = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          utm = {
            utm_medium = "utm_medium"
            utm_campaign = "utm_campaign"
            utm_source = "utm_source"
          }
        }

        "/point/buyingflow/shipping/options"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/shipping/new_address"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/payment/methods"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          has_account_money = true
          has_consumer_credits = true
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }
        
        "/point/buyingflow/payment/ticket_info"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/payment/installments"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/payment/new_card"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/payment/card_security_code"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/payment/bank_selector"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/review"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          selected_payment_method_id = "tarshop"
          selected_payment_method_type = "credit_card"
          discount_code = "GHZM"
          installments = 6
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/payment_rejected"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          selected_payment_method_id = "tarshop"
          selected_payment_method_type = "credit_card"
          discount_code = "GHZM"
          installments = 6
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }
        
        "/point/buyingflow/error"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          error_code = 6
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/review/confirm_purchase"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/shipping/invalid_address"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/shipping/complete_phone"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          discount_code = "GHZM"
          is_guest = true
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/payment/complete_card_data"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/shipping/sim_card"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/shipping/xsell"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/payment/credit_authorization"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }

        "/point/buyingflow/payment/credit_authorization/confirm"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
        }
        
        "/point/buyingflow/regret"(platform: "/", type: TrackType.View) {}

        "/point/buyingflow/congrats"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }

        "/point/buyingflow/congrats/refresh"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }

        "/point/buyingflow/congrats/instructions"(platform: "/", type: TrackType.View) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }

        "/point/buyingflow/congrats/continue"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }

        "/point/buyingflow/congrats/copy"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }

        "/point/buyingflow/congrats/map"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }

        "/point/buyingflow/congrats/print"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }
        
        "/point/buyingflow/congrats/instructions/print"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }

        "/point/buyingflow/congrats/instructions/map"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }

        "/point/buyingflow/congrats/instructions/copy"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }

        "/point/buyingflow/congrats/instructions/continue"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }
        "/point/buyingflow/congrats/instructions/goto_bank"(platform: "/", type: TrackType.Event) {
          flow_id = "83ee2407-1a73-4eca-922d-b07c7904552c"
          product_id = "11"
          currency = "ARS"
          price = 299
          is_guest = true
          discount_code = "GHZM"
          e2e_test = false
          bunit = "Point"
          ch = "channel"
          camp = "TELE_2021"
          strategy = "strategy"
          product = "Merdaco Pago Point Bluetooth"
          coupon_type = "mgm"
          payment_method_id = "pagofacil"
          payment_id = 15511951431
          payment_status = "rejected"
          payment_status_detail = "cc_rejected_call_for_authorize"
          payment_installments = 1
          payment_type_id = "ticket"
        }
    }
}
