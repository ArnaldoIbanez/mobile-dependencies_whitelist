package src.main.resources.catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/user"(platform: "/", isAbstract: true) {}

    "/user/delete"(platform: "/backend") {
        application_source(type: PropertyType.String, required:true, description: "Source that made the deletion", values: ["registration"])
        reason(type: PropertyType.String, required:true, description: "Reason for delete User Account", values: ["register_not_validated"])
    }
}

