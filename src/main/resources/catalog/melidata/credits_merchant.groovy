package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1204"

    

     /******************************************
     *       Start: Merchants Public Landings
     ******************************************/
    //Public landing
    "/credits/merchant/public_landing"(platform: "/", type: TrackType.View) {
        offers(
            type: PropertyType.ArrayList(PropertyType.String),
            required: false,
            inheritable: false
        )
    }
    
    "/credits/merchant/public_landing/ftl_offer"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/public_landing/spl_offer"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/public_landing/em_offer"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/public_landing/new_account"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/public_landing/credits_access"(platform: "/", type: TrackType.Event) {}

    // Credits Marketing Performance landing 
    "/credits/mkt_landing"(platform: "/web", type: TrackType.View, initiative: "1176") {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/credits/mkt_landing/sms"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/credits/mkt_landing/copy-clipboard"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["coupon", "steps"], description: "Indicates position of copy button")
    }
    "/credits/mkt_landing/button"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["hero", "fixed", "footer"], description: "Indicates position of button in landing")
    }

    /******************************************
     *       End: Merchants Public Landings
     ******************************************/


}
