package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    
    //initiative="12169"

    "/blackfriday" (platform: "/mobile", isAbstract: true) {}

    "/blackfriday/reservation" (platform: "/mobile", type: TrackType.View) {}

    "/blackfriday/reservation/back" (platform: "/mobile", type: TrackType.Event) {}

    "/blackfriday/reservation/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


    "/blackfriday/kyc" (platform: "/mobile", type: TrackType.View) {}

    "/blackfriday/kyc/back" (platform: "/mobile", type: TrackType.Event) {}

    "/blackfriday/kyc/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


    "/blackfriday/congrats" (platform: "/mobile", type: TrackType.View) {
        result(required: true, inheritable: false, type: PropertyType.String, description: "The congrats result: success, error, or sold_out")
    }

    "/blackfriday/congrats/close" (platform: "/mobile", type: TrackType.Event) {
        result(required: true, inheritable: false, type: PropertyType.String, description: "The congrats result: success, error, or sold_out")
    }

    "/blackfriday/congrats/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
        result(required: true, inheritable: false, type: PropertyType.String, description: "The congrats result: success, error, or sold_out")
    }


    "/blackfriday/reserved" (platform: "/mobile", type: TrackType.View) {}

    "/blackfriday/reserved/close" (platform: "/mobile", type: TrackType.Event) {}

    "/blackfriday/reserved/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


    "/blackfriday/soldout" (platform: "/mobile", type: TrackType.View) {}

    "/blackfriday/soldout/close" (platform: "/mobile", type: TrackType.Event) {}

    "/blackfriday/soldout/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


    "/blackfriday/discounts" (platform: "/mobile", type: TrackType.View) {
        discount_mcdonalds_enabled(required: true, inheritable: false, type: PropertyType.Boolean, description: "If the Mc Donalds discount is enabled")
        discount_ragazzo_enabled(required: true, inheritable: false, type: PropertyType.Boolean, description: "If the Ragazzo discount is enabled")
        discount_habibs_enabled(required: true, inheritable: false, type: PropertyType.Boolean, description: "If the Habibs discount is enabled")
    }

    "/blackfriday/discounts/back" (platform: "/mobile", type: TrackType.Event) {}

    "/blackfriday/discounts/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


    "/blackfriday/howto" (platform: "/mobile", type: TrackType.View) {}

    "/blackfriday/howto/back" (platform: "/mobile", type: TrackType.Event) {}

    "/blackfriday/howto/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }

    "/blackfriday/ftu-used" (platform: "/mobile", type: TrackType.View) {}

    "/blackfriday/ftu-used/back" (platform: "/mobile", type: TrackType.Event) {}

    "/blackfriday/ftu-used/cta" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type: PropertyType.String, description: "The call to action type")
    }


}
