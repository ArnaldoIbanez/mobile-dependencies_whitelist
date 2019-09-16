
package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

	defaultBusiness = "mercadopago"
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
        "/recharge_sube/redirect_sube_app"(platform: "/mobile", type: TrackType.Event) {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/show_terminals_information"(platform: "/mobile", type: TrackType.Event) {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/show_terminals_congrats"(platform: "/mobile", type: TrackType.Event) {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
    }

    defaultBusiness = "mercadolibre"

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
        "/recharge_sube/redirect_sube_app"(platform: "/mobile", type: TrackType.Event) {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/show_terminals_information"(platform: "/mobile", type: TrackType.Event) {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
        "/recharge_sube/show_terminals_congrats"(platform: "/mobile", type: TrackType.Event) {
            flow = "/recharge_sube"
            from = "/deep_link"
        }
    }
}