package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1129"

    propertyDefinitions {
        shop_id(required: true, type: PropertyType.Numeric)
        shop_name(required: true, type: PropertyType.String)
        shop_domain(required: false, type: PropertyType.String)
        location(required: true, type: PropertyType.String)
    }

    propertyGroups {
        mshopsEventGroup(shop_id, shop_name, shop_domain)
        mshopslClickGroup(location)
    }

    "/mercado_shops/home"(platform: "/", type: TrackType.View){}

    "/mercado_shops/home/landing"(platform: "/", type: TrackType.View){}

    "/mercado_shops/home/landing/click"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/home/landing/activate_store"(platform: "/", type: TrackType.Event){
        mshopslClickGroup
    }

}