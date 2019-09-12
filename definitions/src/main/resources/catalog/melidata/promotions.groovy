import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    def pageStructure = objectSchemaDefinitions {
      limit(required: true, type: PropertyType.Numeric, description: "max number of items per page")
      offset(required: true, type: PropertyType.Numeric, description: "item list offset")
      total(required: true, type: PropertyType.Numeric, description: "total number of list items")
    }

    def algorithmsStructure = objectSchemaDefinitions {
      scoring(required: false, type: PropertyType.String, description: "scoring algorithm")
      selection(required: false, type: PropertyType.String, description: "selection algorithm")
      sorting(required: false, type: PropertyType.String, description: "sorting algorithm")
    }

    def itemStructure = objectSchemaDefinitions {
      id(required: true, type: PropertyType.String, description: "Item's id")
      title(required: false, type: PropertyType.String, description: "Item's title")
      free_shipping(required: false, type: PropertyType.Boolean, description: "Item's free_shipping condition")
    }

    propertyDefinitions {
        origin(required: true, type: PropertyType.String, description: "Indicates track's origin")
        deal_print_id(required: true, type: PropertyType.String, description: "Unique id per render")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(itemStructure)), 
                    description: "List of page's items")
        algorithms(required: true, type: PropertyType.Map(algorithmsStructure), 
                    description: "Indicates the implemented scoring, order and selection algorithms")
        page(required: true, type: PropertyType.Map(pageStructure), 
                    description: "Indicates pagination information like limit, offset and total")
    }
    
    propertyGroups {
        general_promotions_info(origin, algorithms, deal_print_id, items, page)
    }

    //Promotions Landing
    "/promotions"(platform: "/", type: TrackType.View) {
        general_promotions_info
    }
}
