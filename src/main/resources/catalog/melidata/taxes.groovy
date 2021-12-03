package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1014"

    // Taxes
    "/taxes/collected_at_source"(platform: "/") {}
    "/taxes/user_tax_file"(platform: "/") {}
}
