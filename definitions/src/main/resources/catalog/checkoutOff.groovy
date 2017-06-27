import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    // Chekout Flow
    "/checkout_off"(platform: "/", isAbstract: true){
        checkout_flow_id(required: true, description: "checkout flow id")
        collector_id(required: true)
        collector_nickname(required: true)
        preference_id(required: true)
        scope(required: false, description: "pool that generates the tracks: mla, mlb, mlm, rola, revamp")
    }

    "/checkout_off/init"(platform: "/", type: TrackType.View) {}
    "/checkout_off/congrats"(platform: "/", type: TrackType.View) {
        payment_status(required: true)
        payment_id(required: false)
        payment_status_detail(required: true)
        payment_method_id(required: true)
        payment_type_id(required: true)
        is_express(required: true, type: PropertyType.Boolean)
    }
}