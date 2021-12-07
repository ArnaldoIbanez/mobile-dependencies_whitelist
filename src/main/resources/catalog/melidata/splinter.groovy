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

    def main_slider_item_definition = objectSchemaDefinitions {
        audience(type: PropertyType.String, required: false, description: "Type of audience")
        bu(type: PropertyType.String, required: false, description: "Bussiness unit id")
        bu_line(type: PropertyType.String, required: false, description: "Bussiness unit position")
        component(type: PropertyType.String, required: false, description: "Component name")
        content_id(type: PropertyType.String, required: false, description: "Unique content id")
        flow(type: PropertyType.String, required: false, description: "Type of flow")
        logic(type: PropertyType.String, required: false, description: "Type of logic")
        position(type: PropertyType.Numeric, required: false, description: "Position number")
    }

    def real_estates_definition = objectSchemaDefinitions {
        main_slider(type: PropertyType.Map(main_slider_item_definition), required: false, description: "Main slider info")
    }

    propertyDefinitions {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
        items_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "List of carousel items id")
        filters(required: false, type: PropertyType.Map(filters_definition), description: "Filters applied")
        real_estates(required: false, type: PropertyType.Map(real_estates_definition), description: "Real states info")
        category(required: true, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: true, type: PropertyType.String, description: "Name of the campaign")
        label(required: true, type: PropertyType.String, description: "Component related info")
        context(required: true, type: PropertyType.String, description: "Landing context takeover/normal")
        module(required: true, type: PropertyType.String, description: "Bussiness unit")
        group(required: true, type: PropertyType.String, description: "Vertical")
        content(required: true, type: PropertyType.String, description: "Tipo de landing")
    }

    propertyGroups {
        splinter_views(deal_print_id, items_ids, filters, real_estates, context, module, group, content)
        splinter_events(filters, category, action, label, module, group, content)
    }


     /*
     * Splinter pageViews new definition
     */
    "/splinter/landing"(platform: "/") {
        splinter_views
    }

    /*
     * Splinter events new definition
     */
    "/splinter/landing/event"(platform: "/", type: TrackType.Event) {
        splinter_events
    }
}