package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1144"

    "/trends"(platform: "/", isAbstract: true) {}

    "/trends/index"(platform: "/", type: TrackType.View) {}

    "/trends/categ"(platform: "/", type: TrackType.View) {}
}