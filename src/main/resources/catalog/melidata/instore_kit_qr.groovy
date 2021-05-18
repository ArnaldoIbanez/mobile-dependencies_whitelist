package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/instore_kit_qr"(platform: "/",isAbstract: true, initiative: "1305") {}

    // Views:

    "/instore_kit_qr/landing"(platform: "/", type: TrackType.View) {
        product (type: PropertyType.String, required: true, description: "Name of device, example: 'kit-standalone'")
        currency (type: PropertyType.String, required: false, description: "Currency")
        price (type: PropertyType.Numeric, required: false, description: "Price of device")
        has_coupon (type: PropertyType.Boolean, required: false, description: "Flag to detect if a sell has coupon")
        coupon_code (type: PropertyType.String, required: false, description: "MGM CuponCode")
        coupon_type (type: PropertyType.String, required: false, values: ["default", "mgm", "campaign"], description: "Kind of MGM Coupon: default | mgm | campaign")
        discount (type: PropertyType.Numeric, required: false, description: "Discount in price")
        price_with_discount (type: PropertyType.Numeric, required: false, description: "Total price")
    }

    // Events:

    "/instore_kit_qr/landing/buy"(platform: "/", type: TrackType.Event) {}

    "/instore_kit_qr/landing/error"(platform: "/", type: TrackType.Event) {
        value(required: true, inheritable: false, type: PropertyType.String, description: "Error description view")
    }

    "/instore_kit_qr/component" (platform: "/", isAbstract: true) {
        component_id(required: true, type: PropertyType.String, description: "Component's id")
        component_type(required: true, type: PropertyType.String, description: "Component's type")
        value(required: true, type: PropertyType.String, description: "Component's value")
    }

    "/instore_kit_qr/component/tap" (platform: "/", type: TrackType.Event) {}

}
