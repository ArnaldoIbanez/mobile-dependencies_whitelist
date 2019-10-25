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

    "/mercado_shops/landing"(platform: "/", type: TrackType.View){
        shop_id(required: false, type: PropertyType.Numeric)
        shop_domain(required: false, type: PropertyType.String)
        shop_name(required: false, type: PropertyType.String)
        delegation_status(
                required: false,
                type: PropertyType.String,
                values: [
                        'NOT_DELEGATED', 'REGISTERED', 'CHECK_FOR_TOTAL_DELEGATION', 'CHECK_FOR_PARTIAL_DELEGATION',
                        'DELEGATION_OK', 'CERTIFICATE_OK', 'CERTIFICATE_ERROR', 'NAVIGATION_OK', 'NAVIGATION_ERROR',
                        'ERROR', 'DELEGATION_ERROR', 'ACTIVE'
                ]
        )
        success(required: false, type: PropertyType.Boolean, description: "The request was fulfilled successfully")
    }

    "/mercado_shops/migration"(platform: "/", type: TrackType.Event){
        is_migration_banner(required: true, type: PropertyType.Boolean, description: "Banner Migration is being shown")
        is_confirmation_banner(required: true, type: PropertyType.Boolean, description: "Banner Confirmation is being shown")
        is_show_dday_banner(required: true, type: PropertyType.Boolean, description: "Banner DDay is being shown")
    }

    "/mercado_shops/admin"(platform: "/", type: TrackType.View){}

    "/mercado_shops/admin/welcome"(platform: "/", type: TrackType.View){}

    "/mercado_shops/admin/welcome/accept"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/admin/welcome/cancel"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/domains"(platform: "/", isAbstract: true) {
        mshopsDomainsGroup
    }

    "/mercado_shops/admin/sidebar"(platform: "/", type: TrackType.Event){
        sidebar_name(
                required: false,
                type: PropertyType.String,
                values: ['AFIP', 'BANNER', 'BRANDS', 'CAROUSEL', 'COLORS', 'FLASH', 'GRID', 'HEADER_MESSAGE',
                         'LOGO', 'MOSAIC', 'SHOP_NAME', 'SLIDER', 'SOCIAL_NETWORKS', 'SUBDOMAIN', 'TEXT_BANNER']
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

    "/mercado_shops/admin/sidebar/brands"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/collection"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/colors"(platform: "/", type: TrackType.Event){
        preset_name(required: false, type: PropertyType.String, description: "Selected preset name")
        colors(required: false, type: PropertyType.ArrayList, description: "Array of colors in hex notation")
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/flash_info"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/grid"(platform: "/", type: TrackType.Event){
        items_per_row(required: true, type: PropertyType.Numeric)
        max_items(required: true, type: PropertyType.Numeric)
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/header_info"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/logo"(platform: "/", type: TrackType.Event){
        image_id(required: false, type: PropertyType.String)
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/mosaic"(platform: "/", type: TrackType.Event){
        max_items(required: true, type: PropertyType.Numeric)
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

    "/mercado_shops/admin/sidebar/social_networks"(platform: "/", type: TrackType.Event){
        facebook(required: false, type: PropertyType.String)
        twitter(required: false, type: PropertyType.String)
        instagram(required: false, type: PropertyType.String)
        youtube(required: false, type: PropertyType.String)
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event){
        subdomain(required: true, type: PropertyType.String)
    }

    "/mercado_shops/admin/sidebar/text_banner"(platform: "/", type: TrackType.Event){
        desktop_image(required: true, type: PropertyType.String)
        mobile_image(required: true, type: PropertyType.String)
        link_url(required: false, type: PropertyType.String)
        mshopsEventGroup
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

    "/mercado_shops/admin/confirm_migration"(platform: "/", type: TrackType.Event){
        scope(required: true, type: PropertyType.String, values: ['editor', 'domains'])
    }

    "/mercado_shops/optin/step"(platform: "/", type: TrackType.Event){
        step(required: true, type: PropertyType.String)
        index(required: true, type: PropertyType.Numeric)
    }

    "/mercado_shops/marketing"(platform: "/", isAbstract: true) {}

    "/mercado_shops/marketing/summary"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/google_analytics"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/google_analytics/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_analytics/open_faqs"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_analytics/cancel"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_analytics/context_help"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_analytics/delete"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_ads"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/google_ads/confirmation"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/google_ads/confirmation/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }
    "/mercado_shops/marketing/google_ads/confirmation/cancel"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_ads/confirmation/context_help"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_ads/confirmation/delete"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_ads/intention"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/google_ads/intention/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_ads/intention/cancel"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_ads/intention/context_help"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_ads/intention/delete"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_ads/remarketing"(platform: "/", type: TrackType.View){}


    "/mercado_shops/marketing/google_ads/remarketing/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }
    "/mercado_shops/marketing/google_ads/remarketing/cancel"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_ads/remarketing/context_help"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_ads/remarketing/delete"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/facebook_pixel"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/facebook_pixel/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

  "/mercado_shops/marketing/facebook_pixel/cancel"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/facebook_pixel/context_help"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/facebook_pixel/delete"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }
}
