package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1212"

    "/garex"(platform: "/", isAbstract: true) {}

    def garex_track_structure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "Selected warranty option id. For ex: MLA-HAIR_CLIPPERS_GAR110203")
        period(required: true, type: PropertyType.Numeric, description: "Period of de selected warranty (months). For ex: 12")
        cost(required: true, type: PropertyType.Numeric, description: "Cost of selected warranty.")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Revenue share fee of selected warranty.")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue of selected warranty.")
        currency_id(required: true, type: PropertyType.String, description: "Currency of selected warranty. For ex: ARS")
        discount_rate(required: false, type: PropertyType.Numeric, description: "Rate of the discount on the original cost.")
    }

    def financing_type_track_structure = objectSchemaDefinitions {
        no_interest_allowed(required: true, type: PropertyType.Boolean, description: "True when the item allows no interest payments on financing")
        installments(required: false, type: PropertyType.Numeric, description: "Number of available installments to finance payment")
    }

    def item_track_structure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "Item ID. For ex: MLA824281356")
        domain_id(required: true, type: PropertyType.String, description: "Item domain. For ex: MLA-TELEVISIONS")
        financing_type(required: false, type: PropertyType.Map(financing_type_track_structure), description: "Financing data of item if it has")
        category_path(required: true, type: PropertyType.ArrayList, description: "Category path of the item. For ex: ['MLA1051', 'MLA1055']")
    }

     def gdr_option_price = objectSchemaDefinitions {
        final_amount(required: false, type: PropertyType.Numeric, description: "final amount")
        original_amount(required: false, type: PropertyType.Numeric, description: "amount original")
        discount_rate(required: false, type: PropertyType.Numeric, description: "discount rate")
        currency_id(required: false, type: PropertyType.String, description: "currency id")
        monthly(required: false, type: PropertyType.Numeric, description: "Monthly amount")
    }

    def grd_option = objectSchemaDefinitions {
        brand(required: false, type: PropertyType.String, description: "model")
        coverage(required: false, type: PropertyType.String, description: "coverage")
        check(required: false, type: PropertyType.String, description: "check")
        deductible_rate(required: false, type: PropertyType.Numeric, description: "deductible rate")
        deductible_amount(required: false, type: PropertyType.Numeric, description: "deductible amount")
        model(required: false, type: PropertyType.String, description: "model")
        size(required: false, type: PropertyType.String, description: "size")
        manufacturer_warranty(required: false, type: PropertyType.Numeric, description: "factory warranty time")
    }

    def grd_protection_option = objectSchemaDefinitions {
        product_id(required: true, type: PropertyType.String, description: "id of the warranty option")
        price(required: true, type: PropertyType.Map(gdr_option_price), description: "price of the warranty option")
        period(required: true, type: PropertyType.Numeric, description: "period of the warranty option")
        option_data(required: false, type: PropertyType.Map(grd_option), description: "extra information of the warranty option")
    }

    def grd_protection_item = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "id of the item that is offered a protection")
        domain_id(required: true, type: PropertyType.String, description: "domain of the item that is offered a protection")
        price(required: true, type: PropertyType.Numeric, description: "price of the item that is offered a protection")
    }

    // Web
    "/garex/checkout"(platform:"/web", type: TrackType.View) {
        item(required: true, type: PropertyType.Map(item_track_structure))
        options_has_discount(required: true, type: PropertyType.Boolean, description: "When pricing-elasticity experiment is on, this will determine if items has discounts to offer")
    }
    "/garex/checkout/more_info"(platform:"/web", type: TrackType.Event) {
        item(required: true, type: PropertyType.Map(item_track_structure))
        options_has_discount(required: true, type: PropertyType.Boolean, description: "When pricing-elasticity experiment is on, this will determine if items has discounts to offer")
    }
    "/garex/checkout/selected_garex"(platform:"/web", type: TrackType.Event) {
        garex(required: true, type: PropertyType.Map(garex_track_structure))
        item(required: true, type: PropertyType.Map(item_track_structure))
        options_has_discount(required: true, type: PropertyType.Boolean, description: "When pricing-elasticity experiment is on, this will determine if items has discounts to offer")
    }
    "/garex/checkout/not_selected_garex"(platform:"/web", type: TrackType.Event) {
        item(required: true, type: PropertyType.Map(item_track_structure))
        options_has_discount(required: true, type: PropertyType.Boolean, description: "When pricing-elasticity experiment is on, this will determine if items has discounts to offer")
    }
    "/garex/checkout/delete"(platform:"/web", parentPropertiesInherited: false, type: TrackType.Event) {
        garex(required: true, type: PropertyType.Map(garex_track_structure))
    }

    //Mobile
    "/garex/checkout"(platform:"/mobile", type: TrackType.View) {
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
    }
    "/garex/checkout/more_info"(platform:"/mobile", type: TrackType.Event) {}
    "/garex/checkout/selected_garex"(platform:"/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Selected warranty id")
        period(required: true, type: PropertyType.Numeric, description: "Contracted warranty period")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for mercado libre")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for mercado libre")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }
    "/garex/checkout/not_selected_garex"(platform:"/mobile", type: TrackType.Event) {}
    "/garex/checkout/delete"(platform:"/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Warranty id removed")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    "/garex/checkout/back"(platform: "/mobile", type: TrackType.Event) {}
    "/garex/checkout/tap_selector"(platform: "/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Selected warranty id")
        period(required: true, type: PropertyType.Numeric, description: "Contracted warranty period")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for mercado libre")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for mercado libre")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }
    "/garex/checkout/selected_warranty_option"(platform: "/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Selected warranty id")
        period(required: true, type: PropertyType.Numeric, description: "Contracted warranty period")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for mercado libre")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for mercado libre")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }
    "/garex/checkout/conditions_disclaimer"(platform: "/mobile", type: TrackType.Event) {}
    "/garex/checkout/terms_disclaimer"(platform: "/mobile", type: TrackType.Event) {}
    
    "/garex/skeleton"(platform:"/mobile", type: TrackType.View) {
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
    }
    "/garex/skeleton/back"(platform:"/mobile", type: TrackType.Event) {}

    "/garex/checkout/quote_creation_success"(platform: "/mobile", type: TrackType.Event) {
        quote_id(required: true, type: PropertyType.String, description: "Quotation id for the garex")
    }

    "/garex/checkout/quote_creation_error"(platform: "/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Selected warranty id")
        period(required: true, type: PropertyType.Numeric, description: "Contracted warranty period")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for mercado libre")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for mercado libre")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }


    // QPAGE_ON - MOBILE

    "/insurtech/qpage_on/skeleton"(platform:"/mobile", type: TrackType.View) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
    }

    "/insurtech/qpage_on/skeleton/back"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
    }

    "/insurtech/qpage_on"(platform:"/mobile", type: TrackType.View) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: false, type: PropertyType.String, description: "Product_id of insurtech")
    }

    "/insurtech/qpage_on/slide"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: false, type: PropertyType.String, description: "Product id of insurtech")
        option_id(required: true, type: PropertyType.String, description: "Selected option id")
        period(required: true, type: PropertyType.Numeric, description: "Product period")
        cost(required: true, type: PropertyType.Numeric, description: "Product cost")
        original_cost(required: false, type: PropertyType.Numeric, description: "Product original cost")
        discount_rate(required: false, type: PropertyType.Numeric, description: "Product discount rate")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for Meli")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for Meli")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    "/insurtech/qpage_on/faq"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: false, type: PropertyType.String, description: "Product id of insurtech")
    }

    "/insurtech/qpage_on/selected"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: false, type: PropertyType.String, description: "Product id of insurtech")
        option_id(required: true, type: PropertyType.String, description: "Selected option id")
        period(required: true, type: PropertyType.Numeric, description: "Product period")
        cost(required: true, type: PropertyType.Numeric, description: "Product cost")
        original_cost(required: false, type: PropertyType.Numeric, description: "Product original cost")
        discount_rate(required: false, type: PropertyType.Numeric, description: "Product discount rate")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for Meli")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for Meli")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    "/insurtech/qpage_on/not_selected"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: false, type: PropertyType.String, description: "Product id of insurtech")
    }

    "/insurtech/qpage_on/quote_creation_error"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: false, type: PropertyType.String, description: "Product id of insurtech")
        option_id(required: true, type: PropertyType.String, description: "Selected option id")
        period(required: true, type: PropertyType.Numeric, description: "Product period")
        cost(required: true, type: PropertyType.Numeric, description: "Product cost")
        original_cost(required: false, type: PropertyType.Numeric, description: "Product original cost")
        discount_rate(required: false, type: PropertyType.Numeric, description: "Product discount rate")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for Meli")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for Meli")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    "/insurtech/qpage_on/quote_creation_success"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: false, type: PropertyType.String, description: "Product id of insurtech")
        quote_id(required: false, type: PropertyType.String, description: "Quote id")
    }

    "/insurtech/qpage_on/back"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: false, type: PropertyType.String, description: "Product id of insurtech")
    }

    "/insurtech/qpage_on/error"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: false, type: PropertyType.String, description: "Product id of insurtech")
        error_type(required: true, type: PropertyType.String, description: "Error type obtained")
    }

    "/insurtech/qpage_on/delete"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: false, type: PropertyType.String, description: "Product id of insurtech")
        quote_id(required: false, type: PropertyType.String, description: "Quote id")
        option_id(required: true, type: PropertyType.String, description: "Selected option id")
        cost(required: true, type: PropertyType.Numeric, description: "Product cost")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    //INSURTECH Hub-ON
    "/insurtech/protections/marketplace"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        item_info(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options_info(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
    }
    
    "/insurtech/protections/marketplace/help"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
         item_info(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
         option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
    }

    "/insurtech/protections/marketplace/selectProtection"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
         item_info(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
         option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
    }

    "/insurtech/protections/marketplace/cancelProtection"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        item_info(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options_info(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
    }

    "/insurtech/protections/marketplace/confirmProtection"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        item_info(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options_info(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
        option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
    }

    "/insurtech/protections/marketplace/faq"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_id(required: true, type: PropertyType.String, description: "product type id")
        coverage(required: false, type: PropertyType.String, description: "protection coverage")
        manufacturer_warranty(required: false, type: PropertyType.Numeric, description: "factory warranty time")
        period(required: false, type: PropertyType.Numeric, description: "duration of warranty")
    }
}
