package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1104"

    "/cart/social"(platform: "/", type: TrackType.Event) {
        social_network(type: PropertyType.String, required: true, description: "Social network")
    }
}
