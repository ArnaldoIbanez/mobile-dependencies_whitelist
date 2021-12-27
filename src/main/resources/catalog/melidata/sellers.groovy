package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1110"

    propertyDefinitions {
        session_id(required: false, type: PropertyType.String, description: "Id for user session")
    }

    propertyGroups {
        sellersBasicGroup(session_id)
    }


    // Central of Sellers - CdV
    "/sellers/home/main"(platform: "/", type: TrackType.View) {
        sellersBasicGroup
    }

    "/sellers/blog/post"(platform: "/", type: TrackType.View) {
        sellersBasicGroup
    }
}
  