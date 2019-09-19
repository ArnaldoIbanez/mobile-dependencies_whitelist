import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    def pageStructure = objectSchemaDefinitions {
      limit(required: true, type: PropertyType.Numeric, description: "max number of items per page")
      offset(required: true, type: PropertyType.Numeric, description: "item list offset")
      total(required: true, type: PropertyType.String, description: "total number of list items")
    }

    // def algorithmsStructure = objectSchemaDefinitions {
    //   scoring(required: true, type: PropertyType.String, description: "scoring algorithm")
    //   selection(required: true, type: PropertyType.String, description: "selection algorithm")
    //   sorting(required: true, type: PropertyType.String, description: "sorting algorithm")
    // }

    def priceStructure = objectSchemaDefinitions {
      currency(required: true, type: PropertyType.String)
      price(required: true, type: PropertyType.String)
      decimals(required: true, type: PropertyType.String)
      original_price(required: true, type: PropertyType.String)
      discount(required: true, type: PropertyType.Numeric)
      has_loyalty_discount(required: true, type: PropertyType.Boolean)
    }

    def itemStructure = objectSchemaDefinitions {
      id(required: true, type: PropertyType.String, description: "Item's id")
      title(required: true, type: PropertyType.String, description: "Item's title")
      price(required: true, type: PropertyType.Map(priceStructure), description: "Item's price")
      free_shipping(required: true, type: PropertyType.Boolean, description: "Item's free_shipping condition")
      fulfillment(required: true, type: PropertyType.Boolean)
      listing_type_id(required: true, type: PropertyType.String)
      logistic_type(required: true, type: PropertyType.String)
      sold_quantity(required: true, type: PropertyType.Numeric)
      available_quantity(required: true, type: PropertyType.Numeric)
      tags(required: true, type: PropertyType.ArrayList(PropertyType.String))
      warranty(required: true, type: PropertyType.String)
      accepts_mercadopago(required: true, type: PropertyType.Boolean)
      health(required: true, type: PropertyType.Numeric, 
              description: "Variable used to calculate item score in promotions backend")
      score(required: true, type: PropertyType.Numeric, 
              description: "Item's score calculated by promotions backend based on several variables")
      credibility(required: true, type: PropertyType.Numeric, 
              description: "Variable used to calculate item score in promotions backend")
      benefit(required: true, type: PropertyType.Numeric)
      interest(required: true, type: PropertyType.Numeric)
      alpha(required: false, type: PropertyType.Numeric)
      item_clicks(required: false, type: PropertyType.Numeric)
      conversion_rate(required: false, type: PropertyType.Numeric)
      expected_clicks(required: false, type: PropertyType.Numeric)
    }

    propertyDefinitions {
        deal_print_id(required: true, type: PropertyType.String, description: "Unique id per render")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(itemStructure)), 
                    description: "List of page's items")
        // algorithms(required: true, type: PropertyType.Map(algorithmsStructure), 
        //             description: "Indicates the implemented scoring, order and selection algorithms")
        page(required: true, type: PropertyType.Map(pageStructure), 
                    description: "Indicates pagination information like limit, offset and total")
    }
    
    propertyGroups {
        general_promotions_info(deal_print_id, items, page)
    }

    //Promotions Landing
    "/promotions"(platform: "/", type: TrackType.View) {
        general_promotions_info
    }
}
