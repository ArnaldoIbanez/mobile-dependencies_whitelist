import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1159"

    // MP Landing Plugins Woocommerce
    "/landing/woocommerce"(platform: "/web"){
        browser_id (type: PropertyType.String, required: false, description: "Specifies the browser id")
    }
}