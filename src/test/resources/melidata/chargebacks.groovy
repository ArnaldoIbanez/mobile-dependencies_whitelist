package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Chargebacks payer frontend tracks") {

        "/chargebacks"(platform: "/", type: TrackType.View) {}
        "/chargebacks/payer"(platform: "/", type: TrackType.View) {
            case_id = "987987987004"
            payment_id = "3536747103"
            payer_id = 306162056
        }
        "/chargebacks/payer/list"(platform: "/", type: TrackType.View) {}

        "/chargebacks/payer/viewdetail"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payer_id = 306162056
            payment_id = "3536747103"
        }

        "/chargebacks/payer/viewdetail_buy"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payer_id = 306162056
            payment_id = "3536747103"
        }

        "/chargebacks/payer/select-remedy"(platform: "/", type: TrackType.View) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/attach"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payer_id = 306162056
            payment_id = "3536747103"
            select_reason = false
            start_conversation = false
            flow = "CBK"
            problem_id = "DUPLICATED_PAYMENT"
            user_disabled = false
        }

        "/chargebacks/payer/send_msj"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payer_id = 306162056
            payment_id = "3536747103"
            select_reason = false
            start_conversation = false
            attached_doc = true
            flow = "CBK"
            problem_id = ""
            repayment_status = "CANCELLED"
            user_disabled = false
        }

        "/chargebacks/payer/remedy"(platform: "/", type: TrackType.View) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            user_disabled = false
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
        }

        "/chargebacks/payer/change_reason"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/attach_main"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
        }

        "/chargebacks/payer/send"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
            user_disabled = false
        }

        "/chargebacks/payer/pay"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
        }

        "/chargebacks/payer/confirm"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
            user_disabled = true
        }

        "/chargebacks/payer/resolve"(platform: "/", type: TrackType.View) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            user_disabled = false
            repayment_status = "CANCELLED"
            category_path = ["MLM1000", "MLM189492", "MLM190998"]
            payer_id = 306162056
        }

        "/chargebacks/payer/pay-again"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
            user_disabled = true
        }

        "/chargebacks/payer/click-form-link"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "TKO_UNRECOGNIZED_MLB"
            payer_id = 306162056
            user_disabled = false
        }

        "/chargebacks/payer/close_operation_detail"(platform: "/", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/back_action_operation_detail"(platform: "/", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/select_remedy/chargeback_detail"(platform: "/", type: TrackType.View) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/select_remedy/chargeback_management"(platform: "/", type: TrackType.View) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/action_chargeback_detail"(platform: "/", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/close_action_onboarding"(platform: "/", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/close_onboarding"(platform: "/", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/show_onboarding"(platform: "/", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/show_detail_modal"(platform: "/", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/explain_chargeback_management"(platform: "/", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/recognize_chargeback_management"(platform: "/", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        /* MercadoLibre*/

        "/chargebacks/payer/list"(platform: "/", business:"mercadolibre", type: TrackType.View) {}

        "/chargebacks/payer/viewdetail"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payer_id = 306162056
            payment_id = "3536747103"
        }

        "/chargebacks/payer/viewdetail_buy"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            item_id = "MLA673024191"
            case_id = "987987987004"
            payer_id = 306162056
            payment_id = "3536747103"
        }

        "/chargebacks/payer/viewdetail_buy"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payer_id = 306162056
            payment_id = "3536747103"
        }

        "/chargebacks/payer/select-remedy"(platform: "/", business:"mercadolibre", type: TrackType.View) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/attach"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payer_id = 306162056
            payment_id = "3536747103"
            select_reason = false
            start_conversation = false
            flow = "CBK"
            problem_id = "DUPLICATED_PAYMENT"
            user_disabled = true
        }

        "/chargebacks/payer/send_msj"(platform: "/",business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payer_id = 306162056
            payment_id = "3536747103"
            select_reason = false
            start_conversation = false
            attached_doc = true
            flow = "CBK"
            problem_id = "DUPLICATED_PAYMENT"
            user_disabled = true
        }

        "/chargebacks/payer/remedy"(platform: "/", business:"mercadolibre", type: TrackType.View) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            user_disabled = false
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
        }

        "/chargebacks/payer/change_reason"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            user_disabled = false
            payer_id = 306162056
        }

        "/chargebacks/payer/attach_main"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
        }

        "/chargebacks/payer/send"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
            user_disabled = false
        }

        "/chargebacks/payer/pay"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
        }

        "/chargebacks/payer/confirm"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
            user_disabled = false
        }

        "/chargebacks/payer/resolve"(platform: "/", business:"mercadolibre", type: TrackType.View) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            user_disabled = false
            repayment_status = "CANCELLED"
            category_path = ["MLM1000", "MLM189492", "MLM190998"]
            payer_id = 306162056
        }

        "/chargebacks/payer/pay-again"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
            user_disabled = false
        }

        "/chargebacks/payer/click-form-link"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "TKO_UNRECOGNIZED_MLB"
            payer_id = 306162056
            user_disabled = true
        }

        "/chargebacks/payer/close_operation_detail"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

        "/chargebacks/payer/back_action_operation_detail"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

        "/chargebacks/payer/select_remedy/chargeback_detail"(platform: "/", business:"mercadolibre", type: TrackType.View) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

        "/chargebacks/payer/select_remedy/chargeback_management"(platform: "/", business:"mercadolibre", type: TrackType.View) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

        "/chargebacks/payer/action_chargeback_detail"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

        "/chargebacks/payer/close_action_onboarding"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

        "/chargebacks/payer/close_onboarding"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

        "/chargebacks/payer/show_onboarding"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

        "/chargebacks/payer/show_detail_modal"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

        "/chargebacks/payer/explain_chargeback_management"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

        "/chargebacks/payer/recognize_chargeback_management"(platform: "/", business:"mercadolibre", type: TrackType.Event) {
            category_id = "MLA407408"
            item_id = "MLA673024191"
            case_id = "987987987004"
            payment_id = "3536747103"
            user_disabled = false
            payer_id = 306162056
            category_path = ["MLA1000", "MLA189492", "MLA190998"]
        }

    }
}

