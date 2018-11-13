import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    propertyDefinitions {
        shop_id(required: false, type: PropertyType.Numeric)
        shop_domain(required: false, type: PropertyType.String)
        shop_name(required: false, type: PropertyType.String)
    }

    propertyGroups {
        mshopsGroup(shop_domain, shop_name)
    }

    "/myml/mercadoshops"(platform: "/", isAbstract: true) {
        mshopsGroup
    }

    "/myml/mercadoshops/admin"(platform: "/", type: TrackType.View){}

    "/myml/mercadoshops/admin/sidebar"(platform: "/", type: TrackType.Event){
        sidebar_name(
                required: false,
                type: PropertyType.String,
                values: ['AFIP', 'BANNER', 'COLORS', 'LOGO', 'SHOP_NAME', 'SLIDER', 'SUBDOMAIN']
        )
    }

    "/myml/mercadoshops/admin/sidebar/afip"(platform: "/", type: TrackType.Event){}

    "/myml/mercadoshops/admin/sidebar/banner"(platform: "/", type: TrackType.Event){
        image_id(required: false, type: PropertyType.String)
        alignment(required: false, type: PropertyType.String, values:['top', 'center', 'bottom'])
    }

    "/myml/mercadoshops/admin/sidebar/colors"(platform: "/", type: TrackType.Event){
        preset_name(required: false, type: PropertyType.String, description: "Selected preset name")
        colors(required: false, type: PropertyType.ArrayList, description: "Array of colors in hex notation")
    }

    "/myml/mercadoshops/admin/sidebar/logo"(platform: "/", type: TrackType.Event){
        image_id(required: false, type: PropertyType.String)
    }

    "/myml/mercadoshops/admin/sidebar/shop_name"(platform: "/", type: TrackType.Event){}

    "/myml/mercadoshops/admin/sidebar/slider"(platform: "/", type: TrackType.Event){
        image_list(required: false, type: PropertyType.ArrayList, description: "Array of image ids")
        slider_size(required: false, type: PropertyType.String, values: ['small', 'medium', 'large'])
    }

    "/myml/mercadoshops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event){
        subdomain(required: false, type: PropertyType.String)
    }
}
