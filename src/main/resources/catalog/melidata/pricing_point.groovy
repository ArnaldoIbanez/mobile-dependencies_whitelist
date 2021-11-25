import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1175"

    // Pricing Scale
    "/point/pricing/scale"(platform:"/", type: TrackType.View) {}
    "/point/pricing/scale/success"(platform:"/", type: TrackType.View) {}
    "/point/pricing/scale/error"(platform:"/", type: TrackType.View) {}

}