package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = '1100'
    
    "/auth/card"(platform: "/", isAbstract: true) {}
    "/auth/card/validation"(platform: "/", type: TrackType.Event) {}
    "/auth/card/validation"(platform: "/", type: TrackType.View) {}
}