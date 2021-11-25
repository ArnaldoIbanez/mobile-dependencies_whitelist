import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1159"

    // MP Online Payments
    "/landing/onlinepayments"(platform: "/web"){
        browser_id (type: PropertyType.String, required: false, description: "Specifies the browser id")
    }

    // MP Landing Online Payments Websites
    "/landing/onlinepayments/websites"(platform: "/web"){
        browser_id (type: PropertyType.String, required: false, description: "Specifies the browser id")
    }

    // MP Landing Online Payments Social
    "/landing/onlinepayments/social"(platform: "/web"){
        browser_id (type: PropertyType.String, required: false, description: "Specifies the browser id")
    }

    // MP Landing Online Payments Shopify
    "/landing/shopify"(platform: "/web"){}

    //==============================================
    // External Landing Cliento
    //==============================================
    "/landing/online-payments/checkout-cliento"(platform: "/web"){}

}
