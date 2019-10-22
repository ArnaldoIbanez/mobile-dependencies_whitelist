package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
     * Coupons Screen Tracks
     */

    // General Path
    "/coupon"(platform: "/", isAbstract: true) {
        code(required: true, type: PropertyType.String, description: "Indicates the coupon code")
        campaign_brand(required: false, type: PropertyType.String, description: "Indicates the campaing brand")
        is_auto_sendable(required: false, type: PropertyType.Boolean, description: "Indicates if the automatic coupon entry mode was activated")
    }

    // MOBILE


    // Coupon Input  Screen
    "/coupon/input"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {
        code(required: false, type: PropertyType.String, description: "Indicates the coupon code")
        campaign_brand(required: false, type: PropertyType.String, description: "Indicates the campaing brand")
        is_auto_sendable(required: false, type: PropertyType.Boolean, description: "Indicates if the automatic coupon entry mode was activated")
    }

    // Coupon Input  Events
    "/coupon/input/continue"(platform: "/mobile", type: TrackType.Event) {
        code(required: true, type: PropertyType.String, description: "Indicates the coupon code")
    }

    // Coupon Success Screen
    "/coupon/success"(platform: "/mobile", type: TrackType.View) {
        flow(required: false, type: PropertyType.String, description: "Indicates the flow of screen")
        entity_id(required: false, type: PropertyType.String, description: "Indicates the entity id")
        entity_type(required: true, type: PropertyType.String, description: "Which success type are we tracking")
    }

    // Coupon Success Events
    "/coupon/success/button"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Which action type are we tracking (ex: primary / secondary / tyc)", values: ["primary", "secondary", "tyc"])
        action(required: true, type: PropertyType.String, description: "Which action are we tracking (ex: retry / back_to_root / use_coupon / tyc)", values: ["retry", "back_to_root", "use_coupon", "tyc"])
    }

    // Coupon Error Screen
    "/coupon/error"(platform: "/mobile", type: TrackType.View) {
        entity_type(required: true, type: PropertyType.String, description: "Which error type are we tracking")
    }

    // Coupon Error Events
    "/coupon/error/button"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Which action type are we tracking (ex: primary / secondary / tyc)", values: ["primary", "secondary", "tyc"])
        action(required: true, type: PropertyType.String, description: "Which action are we tracking (ex: retry / back_to_root / use_coupon / tyc)", values: ["retry", "back_to_root", "use_coupon", "tyc"])
    }


}
