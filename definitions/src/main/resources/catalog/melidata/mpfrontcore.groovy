import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /*************************
    *      ACTIVITY WEB      *
    *************************/

    // MP Home
    "/mp_home"(platform: "/web", type: TrackType.View) {}

    // MP Activities
    "/listing"(platform: "/", isAbstract: true) {}
    "/listing/activities"(platform: "/web", type: TrackType.View) {}
    "/listing/gateway"(platform: "/web", type: TrackType.View) {}

    // MP details
    "/activity"(platform: "/web", isAbstract: true) {}
    "/activity/detail"(platform: "/web", type: TrackType.View) {}
    "/activity/detail/shipping"(platform: "/web", type: TrackType.View) {}

    // MP Balance/Advances
    "/activities"(platform: "/web", isAbstract: true) {}
    "/activities/balance"(platform: "/web", type: TrackType.View) {}
    "/activities/balance/advances"(platform: "/web", type: TrackType.View) {}
    "/activities/balance/advances/congrats"(platform: "/web", type: TrackType.View) {}

    // MP Activities Export
    "/activities/export"(platform: "/web", type: TrackType.View) {}

    // MP Shields
    "/shield"(platform: "/web", type: TrackType.View) {}

    //MP Panel Layout
    "/panel-layout"(platform: "/") {
        def sub_item_definition = objectSchemaDefinitions {
            sub_item_id(type: PropertyType.String, required: true)
        }
        def item_definition = objectSchemaDefinitions {
            item_id(type: PropertyType.String, required: true)
            sub_items(type: PropertyType.Map(sub_item_definition))
        }
        def section_definition = objectSchemaDefinitions {
            section_id(type: PropertyType.String, required: true)
            items(type: PropertyType.Map(item_definition))
        }
        navigationSections(
                description:"The sections that the user is receiving from the api.",
                type: PropertyType.ArrayList(PropertyType.Map(section_definition))
        )
    }
}
