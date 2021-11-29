package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1202"
    defaultBusiness = "mercadolibre"

    def filters_definition = objectSchemaDefinitions {
        deal_id(type: PropertyType.String, required: false, description: "Unique deal id")
    }

    propertyDefinitions {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash", inheritable:false)
        items_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "List of carousel items id")
        filters(required: false, type: PropertyType.Map(filters_definition), description: "Filters applied")
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
        context(required: true, type: PropertyType.String, description: "Landing context takeover/normal")
        module(required: true, type: PropertyType.String, description: "Bussiness unit")
        group(required: true, type: PropertyType.String, description: "Vertical")
        content(required: true, type: PropertyType.String, description: "Tipo de landing")
    }

    propertyGroups {
        all_landings(deal_print_id, items_ids, filters, category, action, label, context, module, group, content)
    }


     /*
     * Splinter pageViews new definition
     */
    "/splinter/landing"(platform: "/") {
        all_landings
    }
}