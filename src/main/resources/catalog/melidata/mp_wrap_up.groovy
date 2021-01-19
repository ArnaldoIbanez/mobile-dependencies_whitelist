package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1238"

    /******************************************
    *  Mercado Pago Wrap Up  *
    ******************************************/

    //Definitions
    propertyDefinitions {
        productSellName(required: true, type: PropertyType.String, description: "The product sell name")
        link(required: true, type: PropertyType.String, description: "Link to execute")
    }

    propertyGroups {
        actionEventDataTrack (
                productSellName, link
        )
    }

    // MP Wrap Up
    "/wrap-up"(platform: "/", isAbstract: true) {}

    // Home
    "/wrap-up/home"(platform: "/", type: TrackType.View) {}
    "/wrap-up/home/x-sell/click-see-more"(platform: "/", type: TrackType.Event) { actionEventDataTrack }
}
