package src.main.resources.catalog.component

import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    "/component"(platform: "/", type: TrackType.Event) {}
}
