package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1129"

    propertyDefinitions {
        shop_id(required: true, type: PropertyType.Numeric)
        shop_domain(required: true, type: PropertyType.String)
        shop_name(required: true, type: PropertyType.String)
        operator_id(required: false, type: PropertyType.Numeric)
        delegation_status(
            required: true,
            type: PropertyType.String,
            values: [
                'NOT_DELEGATED', 'REGISTERED', 'CHECK_FOR_TOTAL_DELEGATION', 'CHECK_FOR_PARTIAL_DELEGATION',
                'DELEGATION_OK', 'CERTIFICATE_OK', 'CERTIFICATE_ERROR', 'NAVIGATION_OK', 'NAVIGATION_ERROR',
                'ERROR', 'DELEGATION_ERROR', 'ACTIVE', 'DELEGATION_CEASED'
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
        mshopsGroup(shop_id, shop_domain, shop_name, operator_id, ref)
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
                        'ERROR', 'DELEGATION_ERROR', 'ACTIVE', 'DELEGATION_CEASED'
                ]
        )
        success(required: false, type: PropertyType.Boolean, description: "The request was fulfilled successfully")
    }

    "/mercado_shops/migration"(platform: "/", type: TrackType.Event){
        is_migration_banner(required: true, type: PropertyType.Boolean, description: "Banner Migration is being shown")
        is_confirmation_banner(required: true, type: PropertyType.Boolean, description: "Banner Confirmation is being shown")
        is_show_dday_banner(required: true, type: PropertyType.Boolean, description: "Banner DDay is being shown")
    }

    "/mercado_shops/access_denied"(platform: "/", type: TrackType.View){}

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
                values: ['AFIP', 'BANNER', 'BRANDS', 'CATEGORIES', 'CAROUSEL', 'COLORS', 'CONTACT',
                         'CONTACT_FROM_SHOP_NAME', 'DISCOVERY', 'DISCOVERY_ADVANCED', 'FLASH', 'FOOTER', 'GENERAL', 'GRID',
                         'HEADER', 'HEADER_ADVANCED', 'HEADER_MESSAGE', 'LOGO', 'MENU', 'MOSAIC', 'PRICE_AND_IMAGE',
                         'PRICE_AND_IMAGE_ADVANCED', 'SHOP_NAME', 'SLIDER', 'SOCIAL_NETWORKS',
                         'SOCIAL_NETWORKS_FROM_SHOP_NAME', 'SUBDOMAIN', 'TABBED_CAROUSEL', 'TEXT_BANNER', 'FISCAL_DATA',
                         'FOOTER_MESSAGE', 'WHATSAPP']
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

    "/mercado_shops/admin/sidebar/categories"(platform: "/", type: TrackType.Event){
        categories(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Selected categories to show")
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

    "/mercado_shops/admin/sidebar/discovery"(platform: "/", type: TrackType.Event){
        max_items(required: true, type: PropertyType.Numeric, description: "Number of categories to show")
        categories(required: true, type: PropertyType.ArrayList, description: "Selected categories to show")
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/discovery_advanced"(platform: "/", type: TrackType.Event){
        theme(required: true, type: PropertyType.String, description: "Id of the selected theme for the discovery")
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/flash_info"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/footer_message"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/grid"(platform: "/", type: TrackType.Event){
        items_per_row(required: true, type: PropertyType.Numeric)
        max_items(required: true, type: PropertyType.Numeric)
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/header_advanced"(platform: "/", type: TrackType.Event){
        transparency(required: false, type: PropertyType.Numeric, description: "Selected transparency for header")
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/header_info"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/logo"(platform: "/", type: TrackType.Event){
        image_id(required: false, type: PropertyType.String)
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/menu"(platform: "/", type: TrackType.Event){
        categories(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "Selected categories to show in header menu")
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/mosaic"(platform: "/", type: TrackType.Event){
        max_items(required: true, type: PropertyType.Numeric)
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/price_and_image"(platform: "/", type: TrackType.Event){
        categories(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Selected categories to show")
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
        facebook(required: false, type: PropertyType.String, description: "Facebook was configured")
        twitter(required: false, type: PropertyType.String, description: "Twitter was configured")
        instagram(required: false, type: PropertyType.String, description: "Instagram was configured")
        youtube(required: false, type: PropertyType.String, description: "Youtube was configured")
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/tabbed_carousel"(platform: "/", type: TrackType.Event){
        filters(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Array of filters ids to use in carousel")
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/contact"(platform: "/", type: TrackType.Event){
        street(required: true, type: PropertyType.String, description: "New street")
        number(required: true, type: PropertyType.String, description: "New street number")
        city(required: true, type: PropertyType.String, description: "New city name")
        state(required: true, type: PropertyType.String, description: "New state name")
        email(required: true, type: PropertyType.String, description: "New email address")
        phone(required: true, type: PropertyType.String, description: "New phone number")
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event){
        subdomain(required: true, type: PropertyType.String)
    }

    "/mercado_shops/admin/sidebar/fiscal_data"(platform: "/", type: TrackType.Event){
        fiscal_data_visible(required: true, type: PropertyType.Boolean)
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/whatsapp"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/sidebar/text_banner"(platform: "/", type: TrackType.Event){
        desktop_image(required: true, type: PropertyType.String)
        mobile_image(required: true, type: PropertyType.String)
        link_url(required: false, type: PropertyType.String)
        mshopsEventGroup
    }

    "/mercado_shops/admin/quick_setup"(platform: "/", isAbstract: true) {}

    "/mercado_shops/admin/quick_setup/name_and_logo"(platform: "/", type: TrackType.View){}

    "/mercado_shops/admin/quick_setup/name_and_logo/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/quick_setup/contact_data"(platform: "/", type: TrackType.View){}

    "/mercado_shops/admin/quick_setup/contact_data/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/quick_setup/theme"(platform: "/", type: TrackType.View){}

    "/mercado_shops/admin/quick_setup/theme/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/admin/quick_setup/theme/details"(platform: "/", type: TrackType.View){}

    "/mercado_shops/admin/quick_setup/theme/details/save"(platform: "/", type: TrackType.Event){
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

    "/mercado_shops/admin/unavailable"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/summary"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/subdomain"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/delegation_form"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/emails"(platform: "/", type: TrackType.View){
        mx_registers(required: true, type: PropertyType.ArrayList, description: "Array of copied registers")
    }

    "/mercado_shops/domains/delegation_instructions"(platform: "/", type: TrackType.View){
        dns_list(required: true, type: PropertyType.ArrayList, description: "Array of dns registers to copy")
    }

    "/mercado_shops/domains/migration_delegation_instructions"(platform: "/", type: TrackType.View){
        dns_list(required: true, type: PropertyType.ArrayList, description: "Array of dns registers to copy")
    }

    "/mercado_shops/domains/congrats"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/error_details"(platform: "/", type: TrackType.View){}

    "/mercado_shops/domains/delegation_init"(platform: "/", type: TrackType.Event){
        domain(required: true, type: PropertyType.String, description: "New domain to delegate")
        mshopsEventGroup
    }

    "/mercado_shops/domains/partial_migration_start"(platform: "/", type: TrackType.Event){
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

    "/mercado_shops/marketing/google_tag_manager"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/google_tag_manager/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_tag_manager/open_faqs"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_tag_manager/cancel"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_tag_manager/context_help"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_tag_manager/delete"(platform: "/", type: TrackType.Event){
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

    "/mercado_shops/marketing/google_search_console"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/google_search_console/upload"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_search_console/delete"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/template-selection"(platform: "/", type: TrackType.Event, isAbstract: true){}

    "/mercado_shops/template-selection/save"(platform: "/", type: TrackType.Event){
        theme(
            required: true,
            type: PropertyType.String,
            description: "Name of theme"
        )
        mshopsEventGroup
    }

    "/mercado_shops/template-selection/preview"(platform: "/", type: TrackType.View){}

    "/mercado_shops/template-selection/summary"(platform: "/", type: TrackType.View){}

    "/mercado_shops/themes"(platform: "/", type: TrackType.View, isAbstract: true){}

    "/mercado_shops/themes/customize"(platform: "/", type: TrackType.View){}

    "/mercado_shops/themes/customize/upload"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/custom-categories"(platform: "/", type: TrackType.Event, isAbstract: true){}

    "/mercado_shops/custom-categories/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/custom-categories/summary"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/facebook"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/facebook/store"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/facebook/store/link_with_facebook"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/facebook/store/fan_pages"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/facebook/store/business_manager"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/facebook/store/user_procedure"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/facebook/store/pixel_activation"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/facebook/store/pixel_activation/active"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/facebook/store/context_help"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/facebook/store/meta_tag_configuration"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/facebook/store/domain_verification"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/facebook/store/domain_verification/save"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google/shopping"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google/shopping/introduction"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google/shopping/introduction/context_help"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google/shopping/configuration"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google/shopping/product_feed"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google/shopping/procedure"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google/shopping/resume"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_shopping_smart"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/google_shopping_smart/context_help"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/google_shopping_smart/campaign"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/google_shopping_smart/campaign/set"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_shopping_smart/campaign/context_help"(platform: "/", type: TrackType.Event){}

    // GOOGLE SHOPPING DASHBOARD

    "/mercado_shops/marketing/google_shopping_smart/dashboard"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/google_shopping_smart/dashboard/delete"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_shopping_smart/dashboard/pause"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_shopping_smart/dashboard/activate"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_shopping_smart/dashboard/set_budget"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_shopping_smart/campaign/set_budget"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
    }

    "/mercado_shops/marketing/google_shopping_smart/dashboard/context_help"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/marketing/instagram"(platform: "/", type: TrackType.View){}

    "/mercado_shops/marketing/instagram/context_help"(platform: "/", type: TrackType.View){}

    "/mercado_shops/hub"(platform: "/", isAbstract: true){}

    "/mercado_shops/hub/view"(platform: "/", type: TrackType.View){}

    "/mercado_shops/hub/onboarding"(platform: "/", type: TrackType.View){}

    "/mercado_shops/hub/quick_access"(platform: "/", type: TrackType.Event){
        quick_access(required: true, type: PropertyType.String)
    }

    "/mercado_shops/hub/boost"(platform: "/", type: TrackType.Event){
        option(required: true, type: PropertyType.String)
    }

    "/mercado_shops/hub/google"(platform: "/", type: TrackType.View){}

    "/mercado_shops/hub/google/shopping"(platform: "/", type: TrackType.View){}

    "/mercado_shops/hub/google/shopping/activate"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/hub/google/shopping/deactivate"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/hub/google/shopping/reactivate"(platform: "/", type: TrackType.Event){}

    "/mercado_shops/discounts/"(platform: "/", type: TrackType.View){}

    "/mercado_shops/discounts/set"(platform: "/", type: TrackType.Event){
        mshopsEventGroup
        percentage(required: true, type: PropertyType.Numeric, description: "Discount Percentage")
        status(required: true, type: PropertyType.String, description: "Discount State", values: ['ACTIVE', 'INACTIVE'])
    }

    "/mercado_shops/discounts/create"(platform: "/", type: TrackType.View){}
    "/mercado_shops/discounts/create/coupon"(platform: "/", type: TrackType.View){}
}
