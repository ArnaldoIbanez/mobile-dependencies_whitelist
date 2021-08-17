import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1159"

    // MP Landing Internal Products Suscripciones
    "/landing/subscriptions"(platform: "/web"){}

    // MP Landing Internal Products Checkouts
    "/landing/checkouts"(platform: "/web"){}
}
