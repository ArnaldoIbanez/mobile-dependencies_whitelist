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
        "blocked",
        "unavailable",
    ]

    def tools = [
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

    def confData = objectSchemaDefinitions {
        whatsapp(required: true, type: PropertyType.String, values: toolStatus)
        facebook_shop(required: true, type: PropertyType.String, values: toolStatus)
        facebook_pixel(required: true, type: PropertyType.String, values: toolStatus)
        google_analytics(required: true, type: PropertyType.String, values: toolStatus)
        google_shopping(required: true, type: PropertyType.String, values: toolStatus)
        google_ads(required: true, type: PropertyType.String, values: toolStatus)
        google_search_console(required: true, type: PropertyType.String, values: toolStatus)
        instagram_shop(required: false, type: PropertyType.String, values: toolStatus)
        contact_data(required: true, type: PropertyType.String, values: toolStatus)
        domain(required: true, type: PropertyType.String, values: toolStatus)
    }

    def cardsData = objectSchemaDefinitions {
        publications(required: true, type: PropertyType.Numeric, description: "Number of publications")
        sales(required: true, type: PropertyType.Numeric, description: "Number of sales")
        promotions(required: true, type: PropertyType.Numeric, description: "Number of promotions")
        marketing(required: true, type: PropertyType.Numeric, description: "Number of campaigns")
    }

    propertyDefinitions {
        shop_id(required: true, type: PropertyType.Numeric)
        shop_name(required: true, type: PropertyType.String)
        shop_domain(required: true, type: PropertyType.String)
        domain_status(
            required: true, 
            type: PropertyType.String,
            values: [
                "own_domain", "shops_domain"
            ]
        )
    }

    propertyGroups {
        mshopsGroup(shop_id, shop_name, shop_domain, domain_status)
    }

    "/shops"(platform: "/", isAbstract: true) {
        mshopsGroup
    }

    "/shops/hub"(platform: "/", type: TrackType.View) {
        shop_status(required: true, type: PropertyType.String, inheritable:false)
        configuration(required: true, type: PropertyType.Map(confData), inheritable: false)
        cards(required: true, type: PropertyType.Map(cardsData), inheritable: false)
    }

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
        tool(required: true, type: PropertyType.String, values: tools, inheritable: false)
    }

    "/shops/hub/link"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools)
    }

    "/shops/hub/know_more"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools)
    }

    "/shops/hub/review"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools)
    }

    "/shops/hub/verify"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools)
    }

    "/shops/hub/solve"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools)
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

    // TIPS AND NEWS

    "/shops/hub/more_about"(platform: "/", isAbstract: true) {}

    "/shops/hub/more_about/show_more"(platform: "/", type: TrackType.Event) {}

    "/shops/hub/tips_news"(platform: "/", isAbstract: true) {}

    "/shops/hub/tips_news/show_more"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools)
    }

    "/shops/hub/tips_news/configuration"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools)
    }
    
    "/shops/hub/tips_news/link"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools)
    }
}
