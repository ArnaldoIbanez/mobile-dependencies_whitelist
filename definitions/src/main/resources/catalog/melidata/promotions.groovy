import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1026"

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
      original_price(required: false, type: PropertyType.String)
      discount(required: false, type: PropertyType.Numeric)
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
      prior_score(required: false, type: PropertyType.Numeric, 
              description: "Item's score calculated by ML model")
      prior_position(required: false, type: PropertyType.Numeric, 
              description: "Item's position calculated by prior_score")
      posterior_score(required: false, type: PropertyType.Numeric, 
              description: "Item's score calculated with prior_score and learning data")
      posterior_position(required: false, type: PropertyType.Numeric, 
              description: "Item's position calculated by posterior_score")
      credibility(required: true, type: PropertyType.Numeric, 
              description: "Variable used to calculate item score in promotions backend")
      benefit(required: true, type: PropertyType.Numeric)
      interest(required: true, type: PropertyType.Numeric)
      item_clicks(required: false, type: PropertyType.Numeric)
      conversion_rate(required: false, type: PropertyType.Numeric)
      expected_clicks(required: false, type: PropertyType.Numeric)
      boosted(required: false, type: PropertyType.Boolean, 
              description: "Indicates whether the item was manually positioned")
      model_version(required: false, type: PropertyType.String)
      position(required: false, type: PropertyType.Numeric)
      created_date(required: false, type: PropertyType.String)
      alpha(required: false, type: PropertyType.Numeric, 
              description: "Weighting for equation learning. Calculated with total number of item prints within promotions")
      beta(required: false, type: PropertyType.Numeric, 
              description: "Adjustment parameters to weigh how much the ctr and the conversion rate add to learning")
      gamma(required: false, type: PropertyType.Numeric, 
              description: "Adjustment parameters to weigh how much the ctr and the conversion rate add to learning")
      rebate(required: false, type: PropertyType.Numeric, 
              description: "Attribute that the publication has or has not")
      one_p(required: false, type: PropertyType.Numeric, 
              description: "Attribute that the publication has or has not. If present, credibility is replaced with 1")
      private_label(required: false, type: PropertyType.Numeric,
              description: "Attribute that the publication has or has not. If present, credibility is replaced with 1")    
      promotion_type(required: true, type: PropertyType.String,
              values:["TODAY_PROMOTION", "DEAL_OF_THE_DAY", "others"], description: "Type of promotion")
      prime_discount(required: false, type: PropertyType.Boolean, 
              description: "Indicates whether the item has discounts by mercado puntos")
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

    //Promotions Android Landing
    "/promotions/landing"(platform: "/mobile", parentPropertiesInherited: false) {
        url(required:true, descripcion:"The url to be loaded by the promotions landing")
        is_main_url(required:false, type: PropertyType.Boolean,
                descripcion: "True if the url is the first url to be loaded. Next urls will have this flag in false (redirects, taps)")
    }

}
