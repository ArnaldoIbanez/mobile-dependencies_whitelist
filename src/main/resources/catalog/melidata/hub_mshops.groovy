package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks


tracks {

    initiative = "1129"

    def toolStatus = [
        "not_configured",
        "configuring",
        "configured",
        "error",
        "warning",
        "blocked",
        "unavailable",
    ]

    def tools = [
        "mercado_ads",
        "whatsapp",
        "facebook_shop",
        "facebook_pixel",
        "google_analytics",
        "instagram_shop",
        "google_shopping",
        "google_ads",
        "google_search_console",
        "pads",
    ]

    def shopCards = [
        "marketing",
        "listings",
        "sales",
        "promotions",
    ]

    def sidebars = [
        "whatsapp",
        "shop_name",
        "contact",
        "social_networks",
        "afip",
        "logo",
        "fiscal_data",
    ]

    def socialNetworks = [
        "youtube",
        "facebook",
        "twitter",
        "instagram",
    ]

    def confData = objectSchemaDefinitions {
        mercado_ads(required: true, type: PropertyType.String, values: toolStatus, description: "Mercado Ads configuration tool", name: "mercado_ads")
        whatsapp(required: true, type: PropertyType.String, values: toolStatus, description: "WhatsApp configuration tool", name: "whatsapp")
        facebook_shop(required: true, type: PropertyType.String, values: toolStatus, description: "Facebook Shop configuration tool", name: "facebook_shop")
        facebook_pixel(required: true, type: PropertyType.String, values: toolStatus, description: "Facebook Pixel configuration tool", name: "facebook_pixel")
        google_analytics(required: true, type: PropertyType.String, values: toolStatus, description: "Google Analytics configuration tool", name: "google_analytics")
        google_shopping(required: true, type: PropertyType.String, values: toolStatus, description: "Google Shopping configuration tool", name: "google_shopping")
        google_ads(required: true, type: PropertyType.String, values: toolStatus, description: "Google Ads configuration tool", name: "google_ads")
        google_search_console(required: true, type: PropertyType.String, values: toolStatus, description: "Google Search Console configuration tool", name: "google_search_console")
        instagram_shop(required: false, type: PropertyType.String, values: toolStatus, description: "Instagram Shop configuration tool", name: "instagram_shop")
        contact_data(required: true, type: PropertyType.String, values: toolStatus, description: "Contact Data configuration tool", name: "contact_data")
        domain(required: true, type: PropertyType.String, values: toolStatus, description: "Domain configuration tool", name: "domain")
    }

    def cardsData = objectSchemaDefinitions {
        publications(required: true, type: PropertyType.Numeric, description: "Number of publications", name: "publications")
        sales(required: true, type: PropertyType.Numeric, description: "Number of sales", name: "sales")
        promotions(required: true, type: PropertyType.Numeric, description: "Number of promotions", name: "promotions")
        marketing(required: true, type: PropertyType.Numeric, description: "Number of campaigns", name: "marketing")
    }

    def videoData = objectSchemaDefinitions {
        id(name: "id", description: "Unique video identifier", required: true, type: PropertyType.String)
    }

    propertyDefinitions {
        shop_id(
            description: "Unique Shop identifier",
            name: "shop_id",
            required: true,
            type: PropertyType.Numeric,
        )
        shop_name(
            description: "Name of the shop",
            name: "shop_name",
            required: true,
            type: PropertyType.String,
        )
        shop_domain(
            description: "Domain registered by the seller",
            name: "shop_domain",
            required: true,
            type: PropertyType.String,
        )
        domain_status(
            description: "Status of the shop domain",
            name: "domain_status",
            required: false,
            type: PropertyType.String,
            values: [
                "own_domain", "shops_domain"
            ]
        )
        tool(
            description: "Tool being tracked",
            name: "tool",
            required: true,
            type: PropertyType.String,
            values: tools,
            inheritable: false,
        )
    }

    propertyGroups {
        commonDataGroup(shop_id, shop_name, shop_domain, domain_status)
        configurationGroup(tool)
    }

    "/shops"(platform: "/", isAbstract: true) {
        commonDataGroup
    }

    "/shops/hub"(platform: "/", type: TrackType.View) {
        shop_status(required: true, type: PropertyType.String, description: "Current shop status", name: "shop_status", inheritable: false)
        configuration(required: true, type: PropertyType.Map(confData), description: "Current configuration status", name: "configuration", inheritable: false)
        cards(required: true, type: PropertyType.Map(cardsData), description: "Cards being rendered", name: "cards", inheritable: false)
    }

    "/shops/hub/onboarding"(platform: "/", type: TrackType.Event) {}

    // SHOP CONFIGURATION    
    "/shops/hub/edit"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, values: [
            "logo",
            "username",
            "design",
            "contact",
            "domain"
        ], inheritable: false)
    }

    // TOOLS CONFIGURATION
    "/shops/hub/configuration"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools.plus(["domain", "contact"]), description: "Media tools plus domain and contact information", inheritable: false)
    }

    "/shops/hub/modify"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    "/shops/hub/link"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    "/shops/hub/know_more"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    "/shops/hub/review"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    "/shops/hub/verify"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    "/shops/hub/solve"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    "/shops/hub/activate"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    "/shops/hub/engage"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    "/shops/hub/reactivate"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    "/shops/hub/configuration/show_more"(platform: "/", type: TrackType.Event) {}

    // SHOP CARDS

    "/shops/hub/manage"(platform: "/", isAbstract: true) {}

    "/shops/hub/manage/listings"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['listings'])
    }

    "/shops/hub/view"(platform: "/", isAbstract: true) {}

    "/shops/hub/view/listings"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['listings'])
    }

    "/shops/hub/modify/listings"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['listings'])
    }
    
    "/shops/hub/modify/sales_listings"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['sales'])
    }

    "/shops/hub/add"(platform: "/", isAbstract: true) {}

    "/shops/hub/add/codes"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['listings'])
    }

    "/shops/hub/add/listings"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['listings'])
    }

    "/shops/hub/edit/prices_combos"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['listings'])
    }

    "/shops/hub/manage_sales"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['sales'])
    }

    "/shops/hub/promotions_configuration"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, values: shopCards)
    }

    "/shops/hub/promotions_central"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['promotions'])
    }

    "/shops/hub/view_report"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['promotions'])
    }

    "/shops/hub/marketing_configuration"(platform: "/", type: TrackType.Event) {
        card(required: false, type: PropertyType.String, values: ['marketing'])
    }

    "/shops/hub/show_more"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, values: shopCards)
    }

    "/shops/hub/review_sales"(platform: "/", type: TrackType.Event) {
        sale_status(required: true, type: PropertyType.String, values: ['ready_to_deliver', 'in_transit', 'to_review', 'to_prepare'])
    }

    // SHOP METRICS

    "/shops/hub/metrics"(platform: "/", isAbstract: true) {}

    "/shops/hub/metrics/show_more"(platform: "/", type: TrackType.Event) {}

    // SELLER COACH

    "/shops/hub/social"(platform: "/", type: TrackType.Event) {
        location(name: "location", description: "Card identifier", required: true, type: PropertyType.String, values: ["tutorial", "footer"])
        social_network(name: "social_network", description: "Name of the social network", required: true, type: PropertyType.String, values: socialNetworks)
    }

    "/shops/hub/play"(platform: "/", type: TrackType.Event) {
        tool(name: "tool", description: "Tool identifier", required: true, type: PropertyType.String)
        video(name: "video", description: "Video tutorial being tracked", required: true, type: PropertyType.Map(videoData))
    }

    "/shops/hub/inspiration_store"(platform: "/", type: TrackType.Event) {
        example_store(name: "example_store", description: "Name of the example store", required: true, type: PropertyType.String)
    }

    "/shops/hub/seller_central"(platform: "/", type: TrackType.Event) {}

    "/shops/hub/content_center"(platform: "/", type: TrackType.Event) {}

    // TIPS AND NEWS

    "/shops/hub/more_about"(platform: "/", isAbstract: true) {}

    "/shops/hub/more_about/show_more"(platform: "/", type: TrackType.Event) {}

    "/shops/hub/tips_news"(platform: "/", isAbstract: true) {}

    "/shops/hub/tips_news/show_more"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    "/shops/hub/tips_news/configuration"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }
    
    "/shops/hub/tips_news/link"(platform: "/", type: TrackType.Event) {
        configurationGroup
    }

    // SIDEBARS

    "/shops/hub/sidebar"(platform: "/") {
        sidebar_name(required: true, type: PropertyType.String, values: sidebars, description: "Sidebar that is being tracking")
    }

    "/shops/hub/sidebar/save_changes"(platform: "/", type: TrackType.Event) {
        success(required: true, type: PropertyType.Boolean, description: "If the request to update the info succeeded or not")
        configured_fields(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "Names of the fields that where configured in certain sidebar(sidebar_name), ex: ['twitter', 'facebook']")
    }
}
