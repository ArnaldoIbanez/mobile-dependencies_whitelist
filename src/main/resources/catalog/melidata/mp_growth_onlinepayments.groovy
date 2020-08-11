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

    // Share Link de Pago
    "/share_social"(platform: "/", isAbstract: true) {}

    "/share_social/share"(platform: "/", isAbstract: true) {}

    "/share_social/share/button"(platform: "/mobile", type: TrackType.Event){
        action (required: true, values: ["share_link", "copy_link", "copy_to_clipboard"], description: "Type of share button clicked")
        label (required: false, values: ["whatsapp", "facebook", "twitter", "email", "instagram", "other"], description: "Type of share_link event")
        flow_id (type: PropertyType.String, required: false, description: "Flow identifier where click is happening")
        pref_id (type: PropertyType.String, required: false, description: "Preference id")
    }    

}