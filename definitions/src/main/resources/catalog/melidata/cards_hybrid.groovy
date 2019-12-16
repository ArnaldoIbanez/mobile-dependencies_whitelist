import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //-----------------
    // HYBRID
    //-----------------

    //Abstract Path
    "/cards"(platform: "/", isAbstract: true) { }
    "/cards/hybrid"(platform: "/", isAbstract: true) { }

    // SHIPPING
    // --------
    "/cards/hybrid/shipping"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/shipping/tracking"(platform: "/", isAbstract: true) { }

    //Shipping: Tracking
    "/cards/hybrid/shipping/tracking"(platform: "/", type: TrackType.View) {
        banner_is_present (required:true, type: PropertyType.Boolean, description: "Banner is present in Screen", inheritable:false)
        contact_is_present (required:true, type: PropertyType.Boolean, description: "Contact is present in Screen", inheritable:false)
    }
    "/cards/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true, 
            type: PropertyType.String, 
            values: ["back", "contact", "help", "banner_unlock"],
            description: "Action tapped"
        )
    }
    "/cards/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
        component_id (required:true, type: PropertyType.String, description: "Component shown")
    }

    //Shipping: Delayed
    "/cards/hybrid/shipping/delayed"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/shipping/delayed"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/shipping/delayed/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true, 
            type: PropertyType.String, 
            values: ["back", "exit", "reissue"],
            description: "Action tapped"
        )
    }
  

    // UNLOCK
    // --------
    "/cards/hybrid/unlock"(platform: "/", isAbstract: true) { }

    // Unlock: Update App
    "/cards/hybrid/unlock/update-app"(platform: "/", isAbstract: true) { }
    "/cards/hybrid/unlock/update-app"(platform: "/", type: TrackType.View) {}
    "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
        action (
            required: true, 
            type: PropertyType.String, 
            values: ["exit", "update"],
            description: "Action tapped"
        )
    }
}