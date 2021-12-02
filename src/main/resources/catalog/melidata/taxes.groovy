package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1014"

    // Taxes
    "/taxes/collected-at-source"(platform: "/") {}
    "/taxes/user-tax-file"(platform: "/") {}
}
