import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    // Chekout Flow
    "/checkout_off"(platform: "/", isAbstract: true){
        checkout_flow_id(required: true, description: "checkout flow id")
        collector_id(required: true, description: "collector id")
        collector_nickname(required: true, description: "collector nickname")
        scope(required: false, description: "scope")
    }

    "/checkout_off/init"(platform: "/", type: TrackType.View) {}
    "/checkout_off/congrats"(platform: "/", type: TrackType.View) {
        payment_status(required: true, description: "payment status")
        payment_id(required: true, description: "payment id")
        payment_status_detail(required: true, description: "payment status detail")
        payment_method_id(required: true, description: "payment method id")
        payment_type_id(required: true, description: "payment type id")
        is_express(required: true, type: PropertyType.Boolean, description: "is express")
    }
}