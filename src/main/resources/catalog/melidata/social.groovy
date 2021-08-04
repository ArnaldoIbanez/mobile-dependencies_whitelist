package catalog.melidata


import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1129"

    "/shops/social"(platform: "/", isAbstract: true) {}

    "/shops/social"(platform: "/", type: TrackType.Event){
        social_network(required: true, type: PropertyType.String, description: "Name social network")
        from(required: true, type: PropertyType.String, description: "Project where the track is sent")
        )
    }
}
