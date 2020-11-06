package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative= "1171"

    "/navigation"(platform: "/", isAbstract: true) {}
    "/navigation/cookie-disclaimer"(platform: "/", isAbstract: true) {}
    "/navigation/cookie-disclaimer/show"(platform: "/", type: TrackType.View) {}
    "/navigation/cookie-disclaimer/accept"(platform: "/", type: TrackType.Event) {}
}
