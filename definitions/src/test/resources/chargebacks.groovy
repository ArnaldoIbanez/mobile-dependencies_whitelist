import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Chargebacks payer frontend tracks") {

        "/chargebacks/payer/list"(platform: "/", ptype: TrackType.View) {}

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
            payer_id = 306162056
            payment_id = "3536747103"
            used_disable = false
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
        }

        "/chargebacks/payer/remedy"(platform: "/", type: TrackType.View) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            used_disable = false
            problem_id = "DUPLICATED_PAYMENT"
        }

        "/chargebacks/payer/change_reason"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
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
        }

        "/chargebacks/payer/resolve"(platform: "/", type: TrackType.View) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            used_disable = false
            payment_status = "CANCELLED"
        }

        "/chargebacks/payer/pay-again"(platform: "/", type: TrackType.Event) {
            case_id = "987987987004"
            category_id = "MLA407408"
            item_id = "MLA673024191"
            payment_id = "3536747103"
            problem_id = "DUPLICATED_PAYMENT"
            payer_id = 306162056
            payment_status = "CANCELLED"
        }
    }
}

