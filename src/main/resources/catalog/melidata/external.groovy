package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType

tracks {

    initiative= "1036"

    def domainRegex = /(?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\.)+[a-z0-9][a-z0-9-]{0,61}[a-z0-9]/

    // External merchants tracks
    "/external"(platform: "/", isAbstract: true){}

    "/external/merchants"(platform: "/"){
        domain(required: true, description: "domain of current view", type: PropertyType.String, regex: domainRegex)
        view(required: false, description: "current section of the external merchant website", type: PropertyType.String)
    }

    "/external/merchants/home"(platform: "/", type: TrackType.View){}

    "/external/merchants/checkout"(platform: "/", type: TrackType.View){}

    "/external/merchants/item"(platform: "/", type: TrackType.View){}

    "/external/merchants/search"(platform: "/", type: TrackType.View){}
}
