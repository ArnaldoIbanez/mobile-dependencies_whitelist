package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType

tracks {
    initiative = "1101"

    "/pog_comm"(platform: "/email", isAbstract: true) {
        template_id(required: true, type: PropertyType.String, description: "Comm template name")
        variant_id(required: true, type: PropertyType.String, description: "Variant selected")
    }

    "/pog_comm/generic"(platform: "/") {
    }
}