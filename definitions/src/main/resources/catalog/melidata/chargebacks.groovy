import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    "/chargebacks"(platform: "/", isAbstract: true) {}
    "/chargebacks/payer"(platform: "/", isAbstract: true) {}

    "/chargebacks/payer/list"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {}

    "/chargebacks/payer/viewdetail"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
    }
    
    "/chargebacks/payer/viewdetail_buy"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        category_path(required: false, type: PropertyType.ArrayList)
    }

    "/chargebacks/payer/select-remedy"(platform: "/", type: TrackType.View) {
        category_id(required: false, type: PropertyType.String, description: "Category id")
        item_id(required: false, type: PropertyType.String, description: "Item id")
        case_id(required: true, type: PropertyType.String, description: "CBK case id")
        payment_id(required: true, type: PropertyType.String, description: "Payment id")
        user_disabled(required: true, type: PropertyType.Boolean, description: "is user disabled")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
    }

    "/chargebacks/payer/attach"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        start_conversation(required: false, type: PropertyType.Boolean)
        select_reason(required: true, type: PropertyType.Boolean)
        flow(required: false, type: PropertyType.String)
        problem_id(required: true, type: PropertyType.String)
        user_disabled(required: true, type: PropertyType.Boolean, description: "is user disabled")
        repayment_status(required: false, type: PropertyType.String, description: "Repayment status")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
    }

    "/chargebacks/payer/send_msj"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        problem_id(required: false, type: PropertyType.String)
        repayment_status(required: false, type: PropertyType.String, description: "Repayment status")
        start_conversation(required: false, type: PropertyType.Boolean)
        select_reason(required: true, type: PropertyType.Boolean)
        attached_doc(required: false, type: PropertyType.Boolean)
        flow(required: false, type: PropertyType.String)
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
        user_disabled(required: true, type: PropertyType.Boolean)
    }

    "/chargebacks/payer/remedy"(platform: "/", type: TrackType.View) {
        category_id(required: false, type: PropertyType.String, description: "Category id")
        item_id(required: false, type: PropertyType.String, description: "Item id")
        case_id(required: true, type: PropertyType.String, description: "CBK case id")
        payment_id(required: true, type: PropertyType.String, description: "Payment id")
        user_disabled(required: true, type: PropertyType.Boolean, description: "is user disabled")
        problem_id(required: true, type: PropertyType.String, description: "Problem selected by payer")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
    }

    "/chargebacks/payer/change_reason"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        problem_id(required: true, type: PropertyType.String)
        user_disabled(required: true, type: PropertyType.Boolean, description: "is user disabled")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
    }

    "/chargebacks/payer/attach_main"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        payment_id(required: true, type: PropertyType.String)
        problem_id(required: true, type: PropertyType.String)
    }

    "/chargebacks/payer/send"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        problem_id(required: true, type: PropertyType.String)
        repayment_status(required: false, type: PropertyType.String, description: "Repayment status")
        user_disabled(required: true, type: PropertyType.Boolean, description: "is user disabled")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
    }

    "/chargebacks/payer/pay"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        problem_id(required: true, type: PropertyType.String)
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
    }

    "/chargebacks/payer/confirm"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        problem_id(required: true, type: PropertyType.String)
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
        user_disabled(required: true, type: PropertyType.Boolean, description: "is user disabled")
    }

    "/chargebacks/payer/resolve"(platform: "/", type: TrackType.View) {
        category_id(required: false, type: PropertyType.String, description: "Category id")
        item_id(required: false, type: PropertyType.String, description: "Item id")
        case_id(required: true, type: PropertyType.String, description: "CBK case id")
        payment_id(required: true, type: PropertyType.String, description: "Payment id")
        repayment_status(required: false, type: PropertyType.String, description: "Repayment status")
        user_disabled(required: true, type: PropertyType.Boolean, description: "is user disabled")
        problem_id(required: true, type: PropertyType.String, description: "Problem selected by payer")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
    }

    "/chargebacks/payer/pay-again"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        problem_id(required: true, type: PropertyType.String)
        user_disabled(required: true, type: PropertyType.Boolean, description: "is user disabled")
        repayment_status(required: false, type: PropertyType.String, description: "Repayment status")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
    }

    "/chargebacks/payer/click-form-link"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        problem_id(required: true, type: PropertyType.String)
        user_disabled(required: true, type: PropertyType.Boolean, description: "is user disabled")
        repayment_status(required: false, type: PropertyType.String, description: "Repayment status")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
    }
}