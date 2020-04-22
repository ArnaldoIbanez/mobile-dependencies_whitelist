package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1212"

    "/garex"(platform: "/", isAbstract: true) {}

    def garex_track_structure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String)
        period(required: true, type: PropertyType.Numeric)
        cost(required: true, type: PropertyType.Numeric)
        revenue_share_fee(required: true, type: PropertyType.Numeric)
        revenue(required: true, type: PropertyType.Numeric)
        currency_id(required: true, type: PropertyType.String)
    }

    def financing_type_track_structure = objectSchemaDefinitions {
        no_interest_allowed(required: true, type: PropertyType.Boolean, description: "True when the item allows no interest payments on financing")
        installments(required: false, type: PropertyType.Numeric, description: "Number of available installments to finance payment")
    }

    def item_track_structure = objectSchemaDefinitions {
        domain_id(required: true, type: PropertyType.String, description: "Item domain. For ex: MLA-TELEVISIONS")
        financing_type(required: false, type: PropertyType.Map(financing_type_track_structure), description: "Financing data of item if it has")
        category_path(required: true, type: PropertyType.ArrayList, description: "Category path of the item. For ex: ['MLA1051', 'MLA1055']")
    }

    "/garex/checkout"(platform:"/web", type: TrackType.View) {}
    "/garex/checkout/more_info"(platform:"/web", type: TrackType.Event) {}
    "/garex/checkout/selected_garex"(platform:"/web", type: TrackType.Event) {
        garex(required: true, type: PropertyType.Map(garex_track_structure))
        item(required: true, type: PropertyType.Map(item_track_structure))
    }
    "/garex/checkout/not_selected_garex"(platform:"/web", type: TrackType.Event) {}

    //Mobile
    "/garex/checkout"(platform:"/mobile", type: TrackType.View) {}
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
}
