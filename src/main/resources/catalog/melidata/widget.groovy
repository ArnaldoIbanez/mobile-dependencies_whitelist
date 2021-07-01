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
        collect_methods_count(
                required: true,
                type: PropertyType.Numeric,
                description: "Indicates the amount of collect methods that the user has enabled"
        )
        collect_method(
                required: true,
                type: PropertyType.String,
                description: "Indicates which collect method is being used from the widget"
        )
    }

    propertyGroups {
        id_group(widget_id)
        config_group(widget_id,collect_methods_count)
        collect_method_group(widget_id,collect_method)
    }

    // Abstract paths

    "/widget" (platform: "/mobile/android", isAbstract: true) { }
    "/widget/seller_collect" (platform: "/mobile/android", isAbstract: true) { }


    "/widget/seller_collect/config" (platform: "/mobile/android", type: TrackType.View) {
        config_group
    }
    "/widget/seller_collect/config/error" (platform: "/mobile/android", type: TrackType.View, parentPropertiesInherited:false) {
        id_group
    }
    "/widget/seller_collect/config/back" (platform: "/mobile/android", type: TrackType.Event, parentPropertiesInherited:false) {
        id_group
    }
    "/widget/seller_collect/config/save" (platform: "/mobile/android", type: TrackType.Event, parentPropertiesInherited:false) {
        collect_method_group
    }
    "/widget/seller_collect/config/not_logged" (platform: "/mobile/android", type: TrackType.View, parentPropertiesInherited:false) {
        id_group
    }
    "/widget/seller_collect/tap" (platform: "/mobile/android", type: TrackType.Event) {
        collect_method_group
    }
    "/widget/seller_collect/remove" (platform: "/mobile/android", type: TrackType.Event) {
        collect_method_group
    }
    "/widget/seller_collect/not_logged" (platform: "/mobile/android", type: TrackType.Event) {
        collect_method_group
    }
}