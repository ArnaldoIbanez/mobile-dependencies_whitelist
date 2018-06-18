import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/hirable/sellers"(platform: "/", type: TrackType.View) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String,
                values: ["services"],
                description: "Vertical of the item")
    }
    "/hirable/buyers"(platform: "/", type: TrackType.View) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String,
                values: ["services"],
                description: "Vertical of the item")
    }

    "/contract/sellers"(platform: "/", type: TrackType.View) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String,
                values: ["services"],
                description: "Vertical of the item")
    }
    "/contract/buyers"(platform: "/", type: TrackType.View) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String,
                values: ["services"],
                description: "Vertical of the item")
    }
}