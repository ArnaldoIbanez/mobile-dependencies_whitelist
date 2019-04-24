import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks


tracks {

    /**
     * Singe player Transport Screen Tracks
     */
    "/transport"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }
    "/transport/recents"(platform: "/mobile", type: TrackType.View) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }
    "/transport/packages"(platform: "/mobile", type: TrackType.View) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }
    "/transport/recommended_amount"(platform: "/mobile", type: TrackType.View) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }
    "/transport/card_number"(platform: "/mobile", type: TrackType.View) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }
    "/transport/card_name"(platform: "/mobile", type: TrackType.View) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }
    "/transport/amount"(platform: "/mobile", type: TrackType.View) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }
    "/transport/products"(platform: "/mobile", type: TrackType.View) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }
    "/transport/days_quantity"(platform: "/mobile", type: TrackType.View) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }
    "/transport/carrousel"(platform: "/mobile", type: TrackType.View) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }
    "/transport/topup_helper"(platform: "/mobile", type: TrackType.View) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
    }

}