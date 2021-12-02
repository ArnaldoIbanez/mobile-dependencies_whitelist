package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1339"

    // Taxes
    "/taxes/collected-at-source"(platform: "/") {}
    "/taxes/user-tax-file"(platform: "/") {}
}
