import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1171"

    // Supermarket
    "/supermarket"(platform: "/", isAbstract: true) {}
    "/supermarket/header"(platform: "/", type: TrackType.View) {
        client_id(type: PropertyType.String)
        selected_department(required: false, type: PropertyType.String)
        departments(type: PropertyType.ArrayList)
    }
    "/supermarket/discovery"(platform: "/", type: TrackType.View) {
        client_id(type: PropertyType.String)
        selected_department(required: false, type: PropertyType.String)
        departments(type: PropertyType.ArrayList)
    }
}