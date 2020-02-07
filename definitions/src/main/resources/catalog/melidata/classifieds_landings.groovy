import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1075"

    "/classifieds"(platform: "/", isAbstract: true) {}
    "/classifieds/hirable"(platform: "/", isAbstract: true) {}

    "/classifieds/hirable/sellers"(platform: "/", type: TrackType.View) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical of the item")
        category_path(required: true, type: PropertyType.ArrayList, description: "Item's category tree")
    }
    "/classifieds/hirable/buyers"(platform: "/", type: TrackType.View) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical of the item")
        category_path(required: true, type: PropertyType.ArrayList, description: "Item's category tree")
    }

    "/classifieds/contract"(platform: "/", isAbstract: true) {}
    "/classifieds/contract/sellers"(platform: "/", type: TrackType.View) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical of the item")
        category_path(required: true, type: PropertyType.ArrayList, description: "Item's category tree")
    }
    "/classifieds/contract/buyers"(platform: "/", type: TrackType.View) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical of the item")
        category_path(required: true, type: PropertyType.ArrayList, description: "Item's category tree")
    }

    "/classifieds/quotes"(platform: "/", isAbstract: true) {}
    "/classifieds/quotes/sellers"(platform: "/", type: TrackType.View) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical of the item")
        category_path(required: true, type: PropertyType.ArrayList, description: "Item's category tree")
    }
    "/classifieds/quotes/buyers"(platform: "/", type: TrackType.View) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical of the item")
        category_path(required: true, type: PropertyType.ArrayList, description: "Item's category tree")
    }

}