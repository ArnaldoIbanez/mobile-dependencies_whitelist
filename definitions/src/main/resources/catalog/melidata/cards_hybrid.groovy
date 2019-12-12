import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //-----------------
    // HYBRID
    //-----------------

    //Abstract Path
    "/hybrid"(platform: "/", isAbstract: true) { }

    // SHIPPING
    // --------
    "/hybrid/shipping"(platform: "/", isAbstract: true) { }

    //Shipping: Tracking
    "/hybrid/shipping/tracking"(platform: "/", type: TrackType.View) {
        banner_is_present (required:true, type: PropertyType.Boolean, description: "Banner is present in Screen")
        contact_is_present (required:true, type: PropertyType.Boolean, description: "Contact is present in Screen")
    }
    "/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true, 
            type: PropertyType.String, 
            values: ["back", "contact", "help", "banner_unlock"],
            description: "Action tapped"
        )
    }
    "/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
        component_id (required:true, type: PropertyType.String, description: "Component shown")
    }

    //Shipping: Delayed
    "/hybrid/shipping/delayed"(platform: "/", type: TrackType.View) {}
    "/hybrid/shipping/delayed/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true, 
            type: PropertyType.String, 
            values: ["back", "exit", "reissue"],
            description: "Action tapped"
        )
    }
}