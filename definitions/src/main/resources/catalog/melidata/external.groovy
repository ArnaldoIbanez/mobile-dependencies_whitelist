import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
  	// External tracks
    "/external"(platform: "/", isAbstract: true){}

    "/external/home"(platform: "/", type: TrackType.View){
        domain(required: true, description: "current path")
    }

    "/external/checkout"(platform: "/", type: TrackType.View){
        domain(required: true, description: "current path")
    }

}