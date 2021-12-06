package catalog.melidata

import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1014"

    // Taxes
    "/taxes/collected_at_source"(platform: "/", type: TrackType.View) {}
    "/taxes/user_tax_file"(platform: "/", type: TrackType.View) {}
}
