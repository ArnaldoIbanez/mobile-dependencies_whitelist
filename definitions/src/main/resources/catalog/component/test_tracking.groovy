package src.main.resources.catalog.component

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/"(platform: "/") {}

    "/component"(platform: "/") {}

    "/wallet_home"(platform: "/" , isAbstract: true) {}

    "/wallet_home/print"(platform: "/mobile") {
        id(type: PropertyType.Numeric, required: false)
    }

}
