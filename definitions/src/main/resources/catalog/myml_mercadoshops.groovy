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
        sidebarName(required: false, type: PropertyType.String)
    }

    "/myml/mercadoshops/admin/sidebar/afip"(platform: "/", type: TrackType.Event){}

    "/myml/mercadoshops/admin/sidebar/banner"(platform: "/", type: TrackType.Event){
        imageId(required: false, type: PropertyType.String)
        alignment(required: false, type: PropertyType.String, values:['top', 'center', 'bottom'])
    }

    "/myml/mercadoshops/admin/sidebar/colors"(platform: "/", type: TrackType.Event){
        presetName(required: false, type: PropertyType.String)
        colors(required: false, type: PropertyType.ArrayList)
    }

    "/myml/mercadoshops/admin/sidebar/shop_name"(platform: "/", type: TrackType.Event){
        shopName(required: false, type: PropertyType.String)
    }

    "/myml/mercadoshops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event){
        subdomain(required: false, type: PropertyType.String)
    }

    "/myml/mercadoshops/admin/sidebar/logo"(platform: "/", type: TrackType.Event){
        imageId(required: false, type: PropertyType.String)
    }
}