package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1110"

    // Central of Sellers - CdV
    "/sellers/home/main"(platform: "/", type: TrackType.View) {}

    "/sellers/blog/post"(platform: "/", type: TrackType.View) {}
}
  