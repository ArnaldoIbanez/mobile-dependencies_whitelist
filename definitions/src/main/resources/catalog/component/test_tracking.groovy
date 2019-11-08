package src.main.resources.catalog.component

import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/"(platform: "/") {}

    "/component"(platform: "/", type: TrackType.Event) {}

    "/wallet_home"(platform: "/" , isAbstract: true) {}

    "/wallet_home/print"(platform: "/", type: TrackType.Event) {}

}
