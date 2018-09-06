import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Cellphone recharge") {
        "/cellphone_recharge"(platform: "/mobile") {
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

        "/cellphone_recharge/carrier_disabled"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/terms_and_conditions"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
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

    defaultBusiness = "mercadolibre"

    test("Cellphone recharge") {
        "/cellphone_recharge"(platform: "/mobile") {
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

        "/cellphone_recharge/carrier_disabled"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
        }

        "/cellphone_recharge/terms_and_conditions"(platform: "/mobile") {
            flow = "/cellphone_recharge"
            from = "/deep_link"
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
}