import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    propertyDefinitions {
        shop_id(required: true, type: PropertyType.Numeric)
        shop_domain(required: true, type: PropertyType.String)
        shop_name(required: true, type: PropertyType.String)
        delegation_status(
            required: true,
            type: PropertyType.String,
            values: [
                'NOT_DELEGATED', 'REGISTERED', 'CHECK_FOR_TOTAL_DELEGATION', 'CHECK_FOR_PARTIAL_DELEGATION',
                'DELEGATION_OK', 'CERTIFICATE_OK', 'CERTIFICATE_ERROR', 'NAVIGATION_OK', 'NAVIGATION_ERROR',
                'ERROR', 'DELEGATION_ERROR', 'ACTIVE'
            ]
        )
        success(required: true, type: PropertyType.Boolean, description: "The request was fulfilled successfully")
        error_code(required: false, type: PropertyType.String)

        ref(
            required: false,
            type: PropertyType.String,
            description: "Additional information from where the user is coming"
        )
    }

    propertyGroups {
        mshopsGroup(shop_id, shop_domain, shop_name, ref)
        mshopsDomainsGroup(delegation_status)
        mshopsEventGroup(success, error_code)
    }

    "/mercado_shops"(platform: "/", isAbstract: true) {
        mshopsGroup
    }

    "/mercado_shops/optin"(platform: "/", type: TrackType.View){}

    "/mercado_shops/admin"(platform: "/", type: TrackType.View){}

    "/mercado_shops/admin/welcome"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains"(platform: "/", isAbstract: true) {
        mshopsDomainsGroup
    }

    "/mercado_shops/admin/sidebar"(platform: "/", type: TrackType.Event){
        sidebar_name(
                required: false,
                type: PropertyType.String,
                values: ['AFIP', 'BANNER', 'COLORS', 'LOGO', 'SHOP_NAME', 'SLIDER', 'SUBDOMAIN']
        )
    }

    "/mercado_shops/admin/sidebar/afip"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/banner"(platform: "/", type: TrackType.Event){
        image_id(required: false, type: PropertyType.String)
        alignment(required: false, type: PropertyType.String, values:['top', 'center', 'bottom'])
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/colors"(platform: "/", type: TrackType.Event){
        preset_name(required: false, type: PropertyType.String, description: "Selected preset name")
        colors(required: false, type: PropertyType.ArrayList, description: "Array of colors in hex notation")
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/logo"(platform: "/", type: TrackType.Event){
        image_id(required: false, type: PropertyType.String)
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/shop_name"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/slider"(platform: "/", type: TrackType.Event){
        image_list(required: false, type: PropertyType.ArrayList, description: "Array of image ids")
        slider_size(required: false, type: PropertyType.String, values: ['small', 'medium', 'large'])
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event){
        subdomain(required: true, type: PropertyType.String)
    }

    "/mercado_shops/admin/deactivate_form"(platform: "/", type: TrackType.View){}

    "/mercado_shops/admin/deactivate"(platform: "/", type: TrackType.Event){
        reason_id(required: true, type: PropertyType.String, description: "The reason id that identifies the main reason why the user decided to opt out.")
        additional_comments(required: false, type: PropertyType.String, description: "Additional comments on why the user decided to opt out.")
    }

    "/mercado_shops/admin/onboarding"(platform: "/", type: TrackType.Event){
        trigger(
            required: true,
            type: PropertyType.String,
            values: ['MODAL', 'ICON']
        )
    }

    "/mercado_shops/admin/onboarding/steps"(platform: "/", type: TrackType.Event){
        scope(
            required: true,
            type: PropertyType.String,
            description: "Name of step"
        )
    }

    "/mercado_shops/domains/summary"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/subdomain"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/delegation_form"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/emails"(platform: "/", type: TrackType.View){
        mx_registers(required: true, type: PropertyType.ArrayList, description: "Array of copied registers")
    }

    "/mercado_shops/domains/delegation_instructions"(platform: "/", type: TrackType.View){
        dns_list(required: true, type: PropertyType.ArrayList, description: "Array of dns registers to copy")
    }

    "/mercado_shops/domains/congrats"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/error_details"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/delegation_init"(platform: "/", type: TrackType.Event){
        domain(required: true, type: PropertyType.String, description: "New domain to delegate")
        mshopsEventGroup
    }

    "/mercado_shops/domains/subdomain_change"(platform: "/", type: TrackType.Event){
        subdomain(required: true, type: PropertyType.String)
        mshopsEventGroup
    }

    "/mercado_shops/domains/delegation_cancel"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }
}
