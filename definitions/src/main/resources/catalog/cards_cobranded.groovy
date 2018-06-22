import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    defaultBusiness = "mercadopago"

    // General Path
    "/cobranded"(platform: "/", isAbstract: true) {}
    "/cobranded/acquisition"(platform: "/", isAbstract: true) {}

    // Acquisition
    // MLA => https://www.mercadopago.com.ar/tarjeta-mercadopago
    "/cobranded/acquisition/landing"(platform: "/", type: TrackType.View){}

    // Acquisition Flow
    "/cobranded/acquisition/maininfo"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/scoreinfo"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/additionalinfo"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/deliverymodeselectio"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/deliveryinfo"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/deliverybranchinfo"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/approvedpremium"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/premiumdetails"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/confirmedpremium"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/approved"(platform: "/", type: TrackType.View){}
    
    // Acquisition Error
    "/cobranded/acquisition/error"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/errornojs"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/notallowedaction"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/premiumtimeout"(platform: "/", type: TrackType.View){}

    // Old Pages
    "/cobranded/acquisition/masterinfo"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/masterrejected"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/readyapplicant"(platform: "/", type: TrackType.View){}
}
