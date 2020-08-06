package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1034"

    "/products-review-page"(platform: "/", type: TrackType.View) {
        search_query(type: PropertyType.String, required: true, description: "Referrer's query for reviewpages")
    }

    "/products-review-page/link/product"(platform: "/", type: TrackType.Event) {
        product_url(type: PropertyType.String, required: true, description: "Referrer's url of the product/item")
    }
}