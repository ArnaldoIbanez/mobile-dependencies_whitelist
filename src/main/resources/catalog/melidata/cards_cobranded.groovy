package catalog.melidata

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
    "/cobranded/acquisition/main_info"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/score_info"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/additional_info"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/delivery_mode_selection"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/delivery_info"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/delivery_branch_info"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/approved_premium"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/premium_details"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/confirmed_premium"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/approved"(platform: "/", type: TrackType.View){}
    
    // Acquisition Error
    "/cobranded/acquisition/error"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/error_no_js"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/not_allowed_action"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/premium_timeout"(platform: "/", type: TrackType.View){}

    // Old Pages
    "/cobranded/acquisition/master_info"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/master_rejected"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/ready_applicant"(platform: "/", type: TrackType.View){}
}
