
package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1171"

    def pageStructure = objectSchemaDefinitions {
        limit(required: true, type: PropertyType.Numeric, description: "max number of items per page")
        offset(required: true, type: PropertyType.Numeric, description: "item list offset")
        total(required: true, type: PropertyType.String, description: "total number of list items")
    }

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
        benefit(required: false, type: PropertyType.Numeric)
        boosted(required: false, type: PropertyType.Boolean,
                description: "Indicates whether the item was manually positioned")
        model_version(required: false, type: PropertyType.String)
        position(required: false, type: PropertyType.Numeric)
        created_date(required: false, type: PropertyType.String)
        one_p(required: false, type: PropertyType.Numeric,
                description: "Attribute that the publication has or has not. If present, credibility is replaced with 1")
        private_label(required: false, type: PropertyType.Numeric,
                description: "Attribute that the publication has or has not. If present, credibility is replaced with 1")
        promotion_type(required: false, type: PropertyType.String,
                values:["TODAY_PROMOTION", "DEAL_OF_THE_DAY", "LIGHTNING_DEAL", "BUY_BOX_WINNER", "others"], description: "Type of promotion")
        prime_discount(required: false, type: PropertyType.Boolean,
                description: "Indicates whether the item has discounts by mercado puntos")
        score(required: false, type: PropertyType.Numeric,
                description: "Item's score calculated by highlights backend based on several variables")
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
        interest(required: false, type: PropertyType.Numeric)
        item_clicks(required: false, type: PropertyType.Numeric)
        conversion_rate(required: false, type: PropertyType.Numeric)
        expected_clicks(required: false, type: PropertyType.Numeric)
        rebate(required: false, type: PropertyType.Numeric,
                description: "Attribute that the publication has or has not")
        tendency_print_id(required: false, type: PropertyType.String, description: "Unique id per render")
        installments(required: false, type: PropertyType.Map(installmentsDefinition), description: "Installments info for the item")
        lightning_deal_configuration(required: false, type: PropertyType.Map(lightningDealConfigurationDefinition), description: "Configuration for the item if is lighting deal")
        deal_of_the_day_configuration(required: false, type: PropertyType.Map(dealOfTheDayConfigurationDefinition), description: "Configuration for the item if is deal of the day")
        dispatching_normally(required: false, type: PropertyType.Boolean, description: "Indicate whether the item support dispatching normally")
    }

    def shortcutsStructure = objectSchemaDefinitions {
        filter(required: true, type: PropertyType.Map, description: "filter described")
        position(required: true, type: PropertyType.Numeric, description: "position in array")
    }

    def itemsExtraStructure = objectSchemaDefinitions {
        component_name(required: true, type: PropertyType.String, description: "The component name used to display the items extra")
        type_content(required: false, type: PropertyType.Boolean, description: "The items content type to display")
        row(required: false, type: PropertyType.Numeric, description: "Indicate where the items extra should be displayed")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(itemExtraStructure)), description: "Items extra to display")
    }

    propertyDefinitions {
        tendency_print_id(required: true, type: PropertyType.String, description: "Unique id per render")
        items(required: false, type: PropertyType.ArrayList(PropertyType.Map(itemStructure)),
                description: "List of page's items")
        page(required: false, type: PropertyType.Map(pageStructure),
                description: "Indicates pagination information like limit, offset and total")
        origin(required: false, type: PropertyType.String, description: "The page section where the user interact")
        filter_applied(required: false, type: PropertyType.String, description: "The current applied filter name")
        selected_filters(required: false, type: PropertyType.Map, description: "The data of all applied filters")
        displayed_shortcuts(required: false, type: PropertyType.ArrayList(PropertyType.Map(shortcutsStructure)), description: "The filters shortcuts shown to the user in each request")
        items_extra(required: false, type: PropertyType.Map(itemsExtraStructure), description: "Items extra to display")
    }

    propertyGroups {
        general_tendencies_info(tendency_print_id, items, page, origin, filter_applied, selected_filters, displayed_shortcuts, items_extra)
    }

    //Tendencies Landing
    "/tendencies"(platform: "/", type: TrackType.View) {
        general_tendencies_info
    }
}
