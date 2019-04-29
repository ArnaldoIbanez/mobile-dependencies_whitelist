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
        type(required: true, type: PropertyType.String, description: "Which action type are we tracking (ex: primary / secondary / tyc)", values: ["primary", "secondary", "tyc"])
        action(required: true, type: PropertyType.String, description: "Which action are we tracking (ex: reload / back_to_root / use_coupon / tyc)", values: ["retry", "back_to_root", "use_coupon", "tyc"])
    }

    // Coupon Error Screen
    "/coupon/error"(platform: "/mobile", type: TrackType.View) {
        code(required: true, type: PropertyType.String, description: "Indicates the coupon code")
        type(required: true, type: PropertyType.String, description: "Which error type are we tracking (ex: invalid_code / pending_code)", values: ["invalid_code", "pending_code"])
    }

    // Coupon Error Events
    "/coupon/error/button"(platform: "/mobile", type: TrackType.Event) {
        code(required: true, type: PropertyType.String, description: "Indicates the coupon code")
        type(required: true, type: PropertyType.String, description: "Which action type are we tracking (ex: primary / secondary / tyc)", values: ["primary", "secondary", "tyc"])
        action(required: true, type: PropertyType.String, description: "Which action are we tracking (ex: reload / back_to_root / use_coupon / tyc)", values: ["retry", "back_to_root", "use_coupon", "tyc"])
    }


}
