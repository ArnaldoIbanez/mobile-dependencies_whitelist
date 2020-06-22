package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative="1218"
    
    "/unified_onboarding" (platform: "/mobile", isAbstract: true)

    "/unified_onboarding/challenge" (platform: "/mobile", isAbstract: true)

    "/unified_onboarding/challenge/open" (platform: "/mobile", type: TrackType.Event) {
        
    }
}
