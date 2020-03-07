package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks


tracks {

    initiative = "1131"

    /**
     * Singe player Transport Screen Tracks
     */
    "/transport"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
        session_id (required:false, type: PropertyType.String, description: "Session Id of flow")
    }
    "/transport/recents"(platform: "/mobile", type: TrackType.View) {}
    "/transport/packages"(platform: "/mobile", type: TrackType.View) {}
    "/transport/recommended_amount"(platform: "/mobile", type: TrackType.View) {}
    "/transport/card_number"(platform: "/mobile", type: TrackType.View) {}
    "/transport/card_name"(platform: "/mobile", type: TrackType.View) {}
    "/transport/amount"(platform: "/mobile", type: TrackType.View) {}
    "/transport/products"(platform: "/mobile", type: TrackType.View) {}
    "/transport/days_quantity"(platform: "/mobile", type: TrackType.View) {}
    "/transport/carrousel"(platform: "/mobile", type: TrackType.View) {}
    "/transport/topup_helper"(platform: "/mobile", type: TrackType.View) {}
    "/transport/combined_packages"(platform: "/mobile", type: TrackType.View) {}
    "/transport/combined_amount"(platform: "/mobile", type: TrackType.View) {}
    "/transport/validation_points"(platform: "/mobile", type: TrackType.View) {}
    "/transport/no_money"(platform: "/mobile", type: TrackType.View) {}
    "/transport/first_use"(platform: "/mobile", type: TrackType.View) {}
    "/transport/error"(platform: "/mobile", type: TrackType.View) {}

    // Transport Marketing Performance Landing
    "/transport/mkt_landing"(platform: "/web", type: TrackType.View, initiative: "1176") {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/transport/mkt_landing/sms"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/transport/mkt_landing/copy-clipboard"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["coupon", "steps"], description: "Indicates position of copy button")
    }
    "/transport/mkt_landing/button"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["hero", "fixed", "footer"], description: "Indicates position of button in landing")
    }
    "/transport/companies"(platform: "/mobile", type: TrackType.View) {}
    "/transport/selected_company"(platform: "/mobile", type: TrackType.Event) {
        company (required: true, type: PropertyType.String, description: "Company selected")
    }
    "/transport/selected_card"(platform: "/mobile", type: TrackType.Event) {
        company (required: true, type: PropertyType.String, description: "Company of the card")
    }
    "/transport/delete"(platform: "/mobile", type: TrackType.Event) {}
}