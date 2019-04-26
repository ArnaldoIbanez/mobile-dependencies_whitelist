package src.main.resources.catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
     * Coupons Screen Tracks
     */

    // General Path
    "/coupon"(platform: "/", isAbstract: true) {}

    // MOBILE


    // Coupon Input  Screen
    "/coupon/input"(platform: "/mobile", type: TrackType.View) {
        code(required: false, type: PropertyType.String, description: "Indicates the coupon code")
    }

    // Coupon Input  Events
    "/coupon/input/continue"(platform: "/mobile", type: TrackType.Event) {
        code(required: true, type: PropertyType.String, description: "Indicates the coupon code")
    }

    // Coupon Success Screen
    "/coupon/success"(platform: "/mobile", type: TrackType.View) {
        code(required: true, type: PropertyType.String, description: "Indicates the coupon code")
    }

    // Coupon Success Events
    "/coupon/success/button"(platform: "/mobile", type: TrackType.Event) {
        code(required: true, type: PropertyType.String, description: "Indicates the coupon code")
        type(required: true, type: PropertyType.String, description: "Indicates the button type")
        action(required: true, type: PropertyType.String, description: "Which action are we tracking (ex: reintentar / volver_al_inicio)")
    }

    // Coupon Error Screen
    "/coupon/error"(platform: "/mobile", type: TrackType.View) {
        code(required: true, type: PropertyType.String, description: "Indicates the coupon code")
        type(required: true, type: PropertyType.String, description: "Indicates the error type")
    }

    // Coupon Error Events
    "/coupon/error/button"(platform: "/mobile", type: TrackType.Event) {
        code(required: true, type: PropertyType.String, description: "Indicates the coupon code")
        type(required: true, type: PropertyType.String, description: "Indicates the button type")
        action(required: true, type: PropertyType.String, description: "Which action are we tracking (ex: reintentar / volver_al_inicio)")
    }


}
