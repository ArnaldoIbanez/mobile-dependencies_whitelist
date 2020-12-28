package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative='1065'

    // MP Devsite
    "/devsite"(platform: "/", isAbstract: true){
        user_id(required: true, description: "current user in the devsite")
        site(require: true, description: "selected country for devsite")
        lang(require: true, description: "selected language for devsite")
    }

    "/devsite/navigation"(platform: "/", type: TrackType.View){
        uri(required: true, description: "current path")
    }

    "/devsite/feedback"(platform: "/", type: TrackType.Event){
        uri(required: true, description: "current path")
        like(required: true, values: ["yes", "no"], description:"user feedback")
    }

}