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
    }
    
    "/chargebacks/payer/viewdetail_buy"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
    }

    "/chargebacks/payer/select-remedy"(platform: "/", type: TrackType.View) {
        category_id: (required: false, type: PropertyType.String, description: "Category id")
        item_id: (required: false, type: PropertyType.String, description: "Item id")
        case_id: (required: false, type: PropertyType.String, description: "CBK case id")
        payment_id: (required: false, type: PropertyType.String, description: "Payment id")
        used_disable: (required: false, type: PropertyType.Boolean, description: "Category id")
    }

    "/chargebacks/payer/attach"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        start_conversation(required: false, type: PropertyType.Boolean)
        select_reason(required: true, type: PropertyType.String)
        flow(required: false, type: PropertyType.String)
    }

    "/chargebacks/payer/send_msj"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        payer_id(required: true, type: PropertyType.Numeric)
        start_conversation(required: false, type: PropertyType.Boolean)
        select_reason(required: false, type: PropertyType.Boolean)
        attached_doc(required: false, type: PropertyType.Boolean)
        flow(required: false, type: PropertyType.String)
    }

    "/chargebacks/payer/remedy"(platform: "/", type: TrackType.View) {
        category_id: (required: false, type: PropertyType.String, description: "Category id")
        item_id: (required: false, type: PropertyType.String, description: "Item id")
        case_id: (required: true, type: PropertyType.String, description: "CBK case id")
        payment_id: (required: true, type: PropertyType.String, description: "Payment id")
        used_disable: (required: true, type: PropertyType.Boolean, description: "Category id")
        problem_id: (required: true, type: PropertyType.String, description: "Problem selected by payer")
    }

    "/chargebacks/payer/change_reason"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
        payment_id(required: true, type: PropertyType.String)
        problem_id(required: true, type: PropertyType.String)
    }

    "/chargebacks/payer/attach_main"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String)
        item_id(required: false, type: PropertyType.String)
        case_id(required: true, type: PropertyType.String)
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
    }

    "/chargebacks/payer/pay"(platform: "/", type: TrackType.Event) {
            category_id(required: false, type: PropertyType.String)
            item_id(required: false, type: PropertyType.String)
            case_id(required: true, type: PropertyType.String)
            payment_id(required: true, type: PropertyType.String)
            payer_id(required: true, type: PropertyType.Numeric)
            problem_id(required: true, type: PropertyType.String)
    }

    "/chargebacks/payer/confirm"(platform: "/", type: TrackType.Event) {
            category_id(required: false, type: PropertyType.String)
            item_id(required: false, type: PropertyType.String)
            case_id(required: true, type: PropertyType.String)
            payment_id(required: true, type: PropertyType.String)
            payer_id(required: true, type: PropertyType.Numeric)
            problem_id(required: true, type: PropertyType.String)
    }

    "/chargebacks/payer/resolve"(platform: "/", type: TrackType.View) {
        category_id: (required: false, type: PropertyType.String, description: "Category id")
        item_id: (required: false, type: PropertyType.String, description: "Item id")
        case_id: (required: true, type: PropertyType.String, description: "CBK case id")
        payment_id: (required: true, type: PropertyType.String, description: "Payment id")
        payment_status: (required: false, type: PropertyType.String, description: "Payment status")
        used_disable: (required: true, type: PropertyType.Boolean, description: "Category id")
        problem_id: (required: true, type: PropertyType.String, description: "Problem selected by payer")
    }

    "/chargebacks/payer/pay-again"(platform: "/", type: TrackType.Event) {
            category_id(required: true, type: PropertyType.String)
            item_id(required: true, type: PropertyType.String)
            case_id(required: true, type: PropertyType.String)
            payment_id(required: true, type: PropertyType.String)
            payer_id(required: true, type: PropertyType.Numeric)
            problem_id(required: true, type: PropertyType.String)
            status_repayment(required: true, type: PropertyType.String)
    }
}