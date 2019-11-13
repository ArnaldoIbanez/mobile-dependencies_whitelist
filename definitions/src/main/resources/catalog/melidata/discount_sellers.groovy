import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
	
    "/discount_sellers" (platform: "/mobile", isAbstract: true) {}

    // Views
    "/discount_sellers/form" (platform: "/mobile", type: TrackType.View) {}
    "/discount_sellers/form/redirect" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "The deeplink to redirect to")
    }
    "/discount_sellers/history" (platform: "/mobile", type: TrackType.View) {}
    "/discount_sellers/history/redirect" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "The deeplink to redirect to")
    }
    "/discount_sellers/detail" (platform: "/mobile", type: TrackType.View) {}
    "/discount_sellers/landing" (platform: "/mobile", type: TrackType.View) {
      id(required: true, type: PropertyType.String, description: "Landing identifier")
    }
    "/discount_sellers/congrats" (platform: "/mobile", type: TrackType.View) {}

    // Events
    
     "/discount_sellers/tap" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Deeplink to execute an action")
    }

    "/discount_sellers/form/back" (platform: "/mobile", type: TrackType.Event) { }
    "/discount_sellers/history/back" (platform: "/mobile", type: TrackType.Event) { }
    "/discount_sellers/detail/back" (platform: "/mobile", type: TrackType.Event) { }
}
