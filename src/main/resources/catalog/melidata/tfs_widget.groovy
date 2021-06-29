package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1148"

    propertyDefinitions {
        widget_id(
                required: true,
                type: PropertyType.Numeric,
                description: "Indicates an ID of the widget"
        )
        is_collaborator(
                required: true,
                type: PropertyType.Boolean,
                description: "Indicates if the user is a collaborator"
        )
        collect_count(
                required: true,
                type: PropertyType.Numeric,
                description: "Indicates how many collect permissions the user has"
        )
        collect_method(
                required: true,
                type: PropertyType.String,
                description: "Indicates which collect method is being used from the widget"
        )
    }

    propertyGroups {
        widget_id_group(widget_id)
        config_group(widget_id, is_collaborator)
        config_successful_group(widget_id, is_collaborator, collect_count)
        use_widget_group(widget_id, collect_method, is_collaborator)
        use_widget_not_logged_group(widget_id, collect_method)
    }

    // Abstract paths

    "/widget" (platform: "/mobile", isAbstract: true) { }
    "/widget/collect" (platform: "/mobile", isAbstract: true) { }
    "/widget/collect/config" (platform: "/mobile", isAbstract: true) { }


    "/widget/collect/config/open" (platform: "/mobile", type: TrackType.View) {
        config_group
    }
    "/widget/collect/config/success" (platform: "/mobile", type: TrackType.Event) {
        config_successful_group
    }
    "/widget/collect/config/error" (platform: "/mobile", type: TrackType.Event) {
        config_group
    }
    "/widget/collect/config/back" (platform: "/mobile", type: TrackType.Event) {
        config_group
    }
    "/widget/collect/config/save" (platform: "/mobile", type: TrackType.Event) {
        use_widget_group
    }
    "/widget/collect/config/not_logged" (platform: "/mobile", type: TrackType.Event) {
        widget_id_group
    }
    "/widget/collect/tap" (platform: "/mobile", type: TrackType.Event) {
        use_widget_group
    }
    "/widget/collect/remove" (platform: "/mobile", type: TrackType.Event) {
        use_widget_group
    }
    "/widget/collect/not_logged" (platform: "/mobile", type: TrackType.Event) {
        use_widget_not_logged_group
    }


}