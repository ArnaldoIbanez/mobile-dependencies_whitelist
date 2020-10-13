package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1144"

    "/cdn"(platform: "/", isAbstract: true) {}

    "/cdn/profiler"(platform: "/", type: TrackType.Event) {
        fileName(required: true, type: PropertyType.String, description: "Name of the file sent")
        size(required: true, type: PropertyType.Numeric, description: "Resource size downloaded")
        duration(required: true, type: PropertyType.Numeric, description: "Time used to download the resource ")
        cdnProvider(required: true, type: PropertyType.String, description: "Name of cdn provider")
        cacheStatus(required: true, type: PropertyType.String, description: "Cache type of response")
        connection(required: true, type: PropertyType.String, description: "Type of network connection")
    }
}