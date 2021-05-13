package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    
    initiative="1217"

    "/instore_hot_sale" (platform: "/mobile", isAbstract: true) {}

    "/instore_hot_sale/reservation" (platform: "/mobile", type: TrackType.View) {}

    "/instore_hot_sale/reservation/back" (platform: "/mobile", type: TrackType.Event) {}

    "/instore_hot_sale/reservation/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


    "/instore_hot_sale/kyc" (platform: "/mobile", type: TrackType.View) {}

    "/instore_hot_sale/kyc/back" (platform: "/mobile", type: TrackType.Event) {}

    "/instore_hot_sale/kyc/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


    "/instore_hot_sale/congrats" (platform: "/mobile", type: TrackType.View) {
        result(required: true, inheritable: false, type: PropertyType.String, description: "The congrats result: success, error, or sold_out")
    }

    "/instore_hot_sale/congrats/close" (platform: "/mobile", type: TrackType.Event) {
        result(required: true, inheritable: false, type: PropertyType.String, description: "The congrats result: success, error, or sold_out")
    }

    "/instore_hot_sale/congrats/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
        result(required: true, inheritable: false, type: PropertyType.String, description: "The congrats result: success, error, or sold_out")
    }


    "/instore_hot_sale/reserved" (platform: "/mobile", type: TrackType.View) {}

    "/instore_hot_sale/reserved/close" (platform: "/mobile", type: TrackType.Event) {}

    "/instore_hot_sale/reserved/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


    "/instore_hot_sale/soldout" (platform: "/mobile", type: TrackType.View) {}

    "/instore_hot_sale/soldout/close" (platform: "/mobile", type: TrackType.Event) {}

    "/instore_hot_sale/soldout/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


    "/instore_hot_sale/discounts" (platform: "/mobile", type: TrackType.View) {
        discount_mcdonalds_enabled(required: true, inheritable: false, type: PropertyType.Boolean, description: "If the Mc Donalds discount is enabled")
        discount_ragazzo_enabled(required: true, inheritable: false, type: PropertyType.Boolean, description: "If the Ragazzo discount is enabled")
        discount_habibs_enabled(required: true, inheritable: false, type: PropertyType.Boolean, description: "If the Habibs discount is enabled")
    }

    "/instore_hot_sale/discounts/back" (platform: "/mobile", type: TrackType.Event) {}

    "/instore_hot_sale/discounts/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


    "/instore_hot_sale/howto" (platform: "/mobile", type: TrackType.View) {}

    "/instore_hot_sale/howto/back" (platform: "/mobile", type: TrackType.Event) {}

    "/instore_hot_sale/howto/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }

    "/instore_hot_sale/ftu-used" (platform: "/mobile", type: TrackType.View) {}

    "/instore_hot_sale/ftu-used/back" (platform: "/mobile", type: TrackType.Event) {}

    "/instore_hot_sale/ftu-used/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


}
