import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks


tracks {

    /**
     * Singe player Transport Screen Tracks
     */
    "/transport"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
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
}