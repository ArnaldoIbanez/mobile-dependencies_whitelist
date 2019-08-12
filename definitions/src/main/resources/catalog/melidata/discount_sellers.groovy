import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
	
    "/discount_sellers" (platform: "/mobile", isAbstract: true) {}

    // Views
    "/discount_sellers/form" (platform: "/mobile", type: TrackType.View) {}
    "/discount_sellers/history" (platform: "/mobile", type: TrackType.View) {}
    "/discount_sellers/detail" (platform: "/mobile", type: TrackType.View) {}

    // Events
    


}