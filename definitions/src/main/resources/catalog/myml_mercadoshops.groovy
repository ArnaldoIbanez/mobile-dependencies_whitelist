import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    propertyDefinitions {
        shop_id(required: true, type: PropertyType.Numeric)
        shop_domain(required: true, type: PropertyType.String)
        shop_name(required: true, type: PropertyType.String)
    }

    propertyGroups {
        mshopsGroup(shop_id, shop_domain, shop_name)
    }

    "/mercado_shops"(platform: "/", isAbstract: true) {
        mshopsGroup
    }

    "/mercado_shops/admin"(platform: "/", type: TrackType.View){}

    "/mercado_shops/admin/sidebar"(platform: "/", type: TrackType.Event){
        sidebar_name(
                required: false,
                type: PropertyType.String,
                values: ['AFIP', 'BANNER', 'COLORS', 'LOGO', 'SHOP_NAME', 'SLIDER', 'SUBDOMAIN']
        )
    }

    "/mercado_shops/admin/sidebar/afip"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/admin/sidebar/banner"(platform: "/", type: TrackType.Event){
        image_id(required: false, type: PropertyType.String)
        alignment(required: false, type: PropertyType.String, values:['top', 'center', 'bottom'])
    }

    "/mercado_shops/admin/sidebar/colors"(platform: "/", type: TrackType.Event){
        preset_name(required: false, type: PropertyType.String, description: "Selected preset name")
        colors(required: false, type: PropertyType.ArrayList, description: "Array of colors in hex notation")
    }

    "/mercado_shops/admin/sidebar/logo"(platform: "/", type: TrackType.Event){
        image_id(required: false, type: PropertyType.String)
    }

    "/mercado_shops/admin/sidebar/shop_name"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/admin/sidebar/slider"(platform: "/", type: TrackType.Event){
        image_list(required: false, type: PropertyType.ArrayList, description: "Array of image ids")
        slider_size(required: false, type: PropertyType.String, values: ['small', 'medium', 'large'])
    }

    "/mercado_shops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event){
        subdomain(required: true, type: PropertyType.String)
    }
}
