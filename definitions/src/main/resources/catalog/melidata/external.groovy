import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType


tracks {
  	// External tracks
    "/external"(platform: "/", isAbstract: true){
    	domain(required: true, description: "domain of current view", type: PropertyType.String)
    }

    "/external/home"(platform: "/", type: TrackType.View){}

    "/external/checkout"(platform: "/", type: TrackType.View){}

}