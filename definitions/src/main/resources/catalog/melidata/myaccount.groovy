import com.ml.melidata.catalog.PropertyType

import com.ml.melidata.TrackType


tracks {

    //My Account
    "/myaccount"(type: TrackType.View, isAbstract: true) {}
    "/myaccount/search_alerts"(type: TrackType.View, isAbstract: true) {}
    "/myaccount/search_alerts/list"(platform: "/", type: TrackType.View) {
        platform(required: true, type: PropertyType.String, values: ["ML", "PI", "MT", "TC", "TM"], description: "Platforms of classi mercadolibre")
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of search alerts")
    }

}
