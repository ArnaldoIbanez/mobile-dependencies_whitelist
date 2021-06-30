package catalog.melidata

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

    def installmentsDefinition = objectSchemaDefinitions {
      quantity(required: true, type: PropertyType.Numeric)
      amount(required: true, type: PropertyType.Numeric)
      no_interest(required: true, type: PropertyType.Boolean)
      currency_id(required: true, type: PropertyType.String)
      decimals(required: false, type: PropertyType.String)
      price(required: false, type: PropertyType.String)
    }

    def lightningDealConfigurationDefinition = objectSchemaDefinitions {
        end_date(required: true, type: PropertyType.String)
        initial_stock(required: true, type: PropertyType.Numeric)
        start_date(required: true, type: PropertyType.String)
        remaining_stock(required: false, type: PropertyType.Numeric)
    }

    def dealOfTheDayConfigurationDefinition = objectSchemaDefinitions {
        end_date(required: true, type: PropertyType.String)
        start_date(required: true, type: PropertyType.String)
    }

    def itemStructure = objectSchemaDefinitions {
      id(required: true, type: PropertyType.String, description: "Item's id")
      title(required: true, type: PropertyType.String, description: "Item's title")
      price(required: true, type: PropertyType.Map(priceStructure), description: "Item's price")
      free_shipping(required: true, type: PropertyType.Boolean, description: "Item's free_shipping condition")
      fulfillment(required: true, type: PropertyType.Boolean)
      score_prior(required: false, type: PropertyType.Numeric, 
              description: "Item's score calculated by ML model")
      position_prior(required: false, type: PropertyType.Numeric, 
              description: "Item's position calculated by prior_score")
      position_posterior(required: false, type: PropertyType.Numeric, 
              description: "Item's position calculated by posterior_score")
      benefit(required: true, type: PropertyType.Numeric)
      boosted(required: false, type: PropertyType.Boolean, 
              description: "Indicates whether the item was manually positioned")
      model_version(required: false, type: PropertyType.String)
      position(required: false, type: PropertyType.Numeric)
      created_date(required: false, type: PropertyType.String)
      one_p(required: false, type: PropertyType.Numeric, 
              description: "Attribute that the publication has or has not. If present, credibility is replaced with 1")
      private_label(required: false, type: PropertyType.Numeric,
              description: "Attribute that the publication has or has not. If present, credibility is replaced with 1")    
      promotion_type(required: true, type: PropertyType.String,
              values:["TODAY_PROMOTION", "DEAL_OF_THE_DAY", "LIGHTNING_DEAL", "BUY_BOX_WINNER", "others"], description: "Type of promotion")
      prime_discount(required: false, type: PropertyType.Boolean, 
              description: "Indicates whether the item has discounts by mercado puntos")
      score(required: true, type: PropertyType.Numeric, 
              description: "Item's score calculated by promotions backend based on several variables")
      posterior_score(required: false, type: PropertyType.Numeric, 
              description: "Item's score calculated with prior_score and learning data")
      listing_type_id(required: false, type: PropertyType.String)
      logistic_type(required: false, type: PropertyType.String)
      sold_quantity(required: false, type: PropertyType.Numeric)
      available_quantity(required: false, type: PropertyType.Numeric)
      tags(required: false, type: PropertyType.ArrayList(PropertyType.String))
      deal_ids(required: true, type: PropertyType.ArrayList(PropertyType.String))
      warranty(required: false, type: PropertyType.String)
      accepts_mercadopago(required: false, type: PropertyType.Boolean)
      health(required: false, type: PropertyType.Numeric, 
              description: "Variable used to calculate item score in promotions backend")
      
      credibility(required: false, type: PropertyType.Numeric, 
              description: "Variable used to calculate item score in promotions backend")
      interest(required: false, type: PropertyType.Numeric)
      item_clicks(required: false, type: PropertyType.Numeric)
      conversion_rate(required: false, type: PropertyType.Numeric)
      expected_clicks(required: false, type: PropertyType.Numeric)
      rebate(required: false, type: PropertyType.Numeric, 
              description: "Attribute that the publication has or has not")
      deal_print_id(required: false, type: PropertyType.String, description: "Unique id per render")
      installments(required: false, type: PropertyType.Map(installmentsDefinition), description: "Installments info for the item")
      lightning_deal_configuration(required: false, type: PropertyType.Map(lightningDealConfigurationDefinition), description: "Configuration for the item if is lighting deal")
      deal_of_the_day_configuration(required: false, type: PropertyType.Map(dealOfTheDayConfigurationDefinition), description: "Configuration for the item if is deal of the day")
      dispatching_normally(required: false, type: PropertyType.Boolean, description: "Indicate whether the item support dispatching normally")
      pos(required: false, type: PropertyType.Numeric, description: "Position of the item in the response")
    }

    def shortcutsStructure = objectSchemaDefinitions {
      filter(required: true, type: PropertyType.Map, description: "filter described")
      is_recommended_domain(required: true, type: PropertyType.Boolean, description: "whether the filter is recommended or not")
      position(required: true, type: PropertyType.Numeric, description: "position in array")
    }

    def itemsExtraStructure = objectSchemaDefinitions {
      component_name(required: true, type: PropertyType.String, description: "The component name used to display the items extra")
      type_content(required: false, type: PropertyType.Boolean, description: "The items content type to display")
      row(required: false, type: PropertyType.Numeric, description: "Indicate where the items extra should be displayed")
      items(required: true, type: PropertyType.ArrayList(PropertyType.Map(itemExtraStructure)), description: "Items extra to display")
    }

    def itemExtraStructure = objectSchemaDefinitions {
      id(required: false, type: PropertyType.String, description: "Item's id")
      title(required: true, type: PropertyType.String, description: "Item's title")
      image_id(required: true, type: PropertyType.String, description: "Item's image id")
      image_src(required: true, type: PropertyType.String, description: "Item's image src")
      free_shipping(required: true, type: PropertyType.Boolean, description: "Inidcate whether the item has free shipping")
      fulfillment(required: true, type: PropertyType.Boolean, description: "Inidcate whether the item has fulfillment")
      link(required: true, type: PropertyType.Map(linkStructure), description: "Item's link")
      price(required: true, type: PropertyType.Map(priceStructure), description: "Item's price")
      installments(required: true, type: PropertyType.Map(installmentsDefinition), description: "Item's installments")
    }

    def linkStructure = objectSchemaDefinitions {
      url(required: true, type: PropertyType.String, description: "Link url")
    }

    propertyDefinitions {
        deal_print_id(required: true, type: PropertyType.String, description: "Unique id per render")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(itemStructure)), 
                    description: "List of page's items")
        // algorithms(required: true, type: PropertyType.Map(algorithmsStructure), 
        //             description: "Indicates the implemented scoring, order and selection algorithms")
        page(required: true, type: PropertyType.Map(pageStructure), 
                    description: "Indicates pagination information like limit, offset and total")
        origin(required: false, type: PropertyType.String, description: "The page section where the user interact")
        filter_applied(required: false, type: PropertyType.String, description: "The current applied filter name")
        filter_position(required: false, type: PropertyType.Numeric, description: "The current applied filter position")
        selected_filters(required: false, type: PropertyType.Map, description: "The data of all applied filters")
        displayed_shortcuts(required: false, type: PropertyType.ArrayList(PropertyType.Map(shortcutsStructure)), description: "The filters shortcuts shown to the user in each request")
        is_recommended_domain(required: false, type: PropertyType.Boolean, description: "Indicate whether filters domains are recommended")
        items_extra(required: false, type: PropertyType.Map(itemsExtraStructure), description: "Items extra to display")
    }
    
    propertyGroups {
        general_promotions_info(deal_print_id, items, page, origin, filter_applied, filter_position, selected_filters, displayed_shortcuts, is_recommended_domain, items_extra)
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
