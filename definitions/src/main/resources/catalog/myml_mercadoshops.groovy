import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    propertyDefinitions {
        custId(required: false, type: PropertyType.Numeric)
        shopDomain(required: false, type: PropertyType.String)
        shopName(required: false, type: PropertyType.String)
    }

    propertyGroups {
        mshopsGroup(custId, shopDomain, shopName)
    }

    "/myml/mercadoshops"(platform: "/", isAbstract: true) {
        mshopsGroup
    }

    "/myml/mercadoshops/admin"(platform: "/", type: TrackType.View){}

    "/myml/mercadoshops/admin/sidebar"(platform: "/", type: TrackType.Event){
        sidebarName(
                required: false,
                type: PropertyType.String,
                values: ['AFIP', 'BANNER', 'COLORS', 'LOGO', 'SHOP_NAME', 'SLIDER', 'SUBDOMAIN']
        )
    }

    "/myml/mercadoshops/admin/sidebar/afip"(platform: "/", type: TrackType.Event){}

    "/myml/mercadoshops/admin/sidebar/banner"(platform: "/", type: TrackType.Event){
        imageId(required: false, type: PropertyType.String)
        alignment(required: false, type: PropertyType.String, values:['top', 'center', 'bottom'])
    }

    "/myml/mercadoshops/admin/sidebar/colors"(platform: "/", type: TrackType.Event){
        presetName(required: false, type: PropertyType.String, description: "Selected preset name")
        colors(required: false, type: PropertyType.ArrayList, description: "Array of colors in hex notation")
    }

    "/myml/mercadoshops/admin/sidebar/logo"(platform: "/", type: TrackType.Event){
        imageId(required: false, type: PropertyType.String)
    }

    "/myml/mercadoshops/admin/sidebar/shop_name"(platform: "/", type: TrackType.Event){
        shopName(required: false, type: PropertyType.String)
    }

    "/myml/mercadoshops/admin/sidebar/slider"(platform: "/", type: TrackType.Event){
        imageList(required: false, type: PropertyType.ArrayList, description: "Array of image ids")
        sliderSize(required: false, type: PropertyType.String, values: ['small', 'medium', 'large'])
    }

    "/myml/mercadoshops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event){
        subdomain(required: false, type: PropertyType.String)
    }
}
