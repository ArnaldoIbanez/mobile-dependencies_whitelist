import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/post_purchase"(platform: "/", isAbstract: true) {
        ref(required: false, type: PropertyType.String, description: 'reference of the beginning of the flow')
    }

    "/post_purchase/reasons"(platform: "/", type: TrackType.View){ }
    "/post_purchase/reasons/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        reason(required: true, type: PropertyType.String, description: 'selected reason')
    }

    "/post_purchase/potential_resolutions"(platform: "/", type: TrackType.View) { }
    "/post_purchase/potential_resolutions/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        request_type(required: true, type: PropertyType.String, description: 'selection of potential resolution')
    }

}