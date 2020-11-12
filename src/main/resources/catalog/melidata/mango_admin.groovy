import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    // Mango settings
    "/your_business/merchant-settings"(platform: "/web", isAbstract: true, initiative: "1159") {}
    "/your_business/merchant-settings/merchant-account"(platform: "/web", type: TrackType.View){}
    "/your_business/merchant-settings/merchant-account/congrats"(platform: "/web", type: TrackType.View){}
    
    "/your_business/merchant-settings/aggregator-payment-method"(platform: "/web", type: TrackType.View){}
    "/your_business/merchant-settings/aggregator-payment-method/detail"(platform: "/web", type: TrackType.View){}
    
    "/your_business/merchant-settings/accepted-payment-methods"(platform: "/web", isAbstract: true) {}
    "/your_business/merchant-settings/accepted-payment-methods/gateway"(platform: "/web", isAbstract: true) {}
    "/your_business/merchant-settings/accepted-payment-methods/gateway/create-agreement"(platform: "/web", type: TrackType.View){}
    "/your_business/merchant-settings/accepted-payment-methods/gateway/create-merchant-account"(platform: "/web", type: TrackType.View){}

    "/your_business/merchant-settings/payment-method"(platform: "/web", type: TrackType.View){}
    "/your_business/merchant-settings/payment-method/detail"(platform: "/web", type: TrackType.View){}

}