package catalog.melidata


import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1129"

    "/social"(platform: "/", isAbstract: true) {}

    "/social"(platform: "/", type: TrackType.Event){
        shop_id(required: true, type: PropertyType.Numeric)
        social_network(required: true, type: PropertyType.String, description: "Name social network")
        from(required: true, type: PropertyType.String, description: "Project where the track is sent")
        shop_name(required: true, type: PropertyType.String)
        shop_domain(required: true, type: PropertyType.String)
        status(
            required: true, 
            type: PropertyType.String,
            values: [
                "active", "inactive"
            ]
        )
    }
}
