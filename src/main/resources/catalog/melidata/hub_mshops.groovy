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
        "instagram",
        "google_shopping",
        "google_ads",
        "google_search_console",
    ]

    def confData = objectSchemaDefinitions {
        whatsapp(required: false, type: PropertyType.String, values: toolStatus)
        facebook_shop(required: false, type: PropertyType.String, values: toolStatus)
        facebook_pixel(required: false, type: PropertyType.String, values: toolStatus)
        google_analytics(required: false, type: PropertyType.String, values: toolStatus)
        google_shopping(required: false, type: PropertyType.String, values: toolStatus)
        google_ads(required: false, type: PropertyType.String, values: toolStatus)
        google_search(required: false, type: PropertyType.String, values: toolStatus)
        instagram(required: false, type: PropertyType.String, values: toolStatus)
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
        business(required: false, type: PropertyType.String, values: ["shops"])
    }

    propertyGroups {
        mshopsGroup(shop_id, shop_name, shop_domain, domain_status, business)
    }

    "/shops"(platform: "/", isAbstract: true) {
        mshopsGroup
    }

    "/shops/hub"(platform: "/", type: TrackType.View) {
        shop_status(required: true, type: PropertyType.String, inheritable:false)
        product_quantity(required: true, type: PropertyType.Numeric, inheritable:false)
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
    "/shops/hub/configure"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools.plus(["domain", "contact"]), description: "Media tools plus domain and contact information")
    }

    "/shops/hub/modify"(platform: "/", type: TrackType.Event) {
        tool(required: true, type: PropertyType.String, values: tools)
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
}
