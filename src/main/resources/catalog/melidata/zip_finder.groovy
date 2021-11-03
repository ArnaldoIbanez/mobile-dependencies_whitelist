package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative = "1171"

    "/zip_finder"(platform: "/", isAbstract: true) {}
    "/zip_finder/search"(platform: "/", type: TrackType.View) {}
    "/zip_finder/finish"(platform: "/", type: TrackType.View) {}
    "/zip_finder/list"(platform: "/", type: TrackType.View) {}
    "/zip_finder/list/select_zip_code"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, values: ['use', 'copy'], description: "Action name")
    }
}
