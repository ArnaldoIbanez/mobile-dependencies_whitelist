import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType


tracks {
  	// External merchants tracks
    "/external"(platform: "/", isAbstract: true){}

    "/external/merchants"(platform: "/", isAbstract: true){
    	domain(required: true, description: "domain of current view", type: PropertyType.String)
    }

    "/external/merchants/home"(platform: "/", type: TrackType.View){}

    "/external/merchants/checkout"(platform: "/", type: TrackType.View){}

}