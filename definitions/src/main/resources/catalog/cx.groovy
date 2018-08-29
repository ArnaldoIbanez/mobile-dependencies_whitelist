import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    "/cx" (platform: "/mobile", isAbstract: true){}
    "/cx/click_on_article" (platform: "/mobile", type: TrackType.Event){
        article_id(required: true, type: PropertyType.String)
    }
    "/cx/click_on_help" (platform: "/mobile", type: TrackType.Event){}
    "/cx/click_on_error" (platform: "/mobile", type: TrackType.Event){}
    "/cx/click_on_suggestion" (platform: "/mobile", type: TrackType.Event){}
    "/cx/contact_types" (platform: "/mobile", isAbstract: true){}
    "/cx/contact_types/click_on_contact_form" (platform: "/mobile", type: TrackType.Event){}

}
