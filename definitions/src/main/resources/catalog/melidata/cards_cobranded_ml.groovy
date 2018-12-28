import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    defaultBusiness = "mercadolibre"

    // Acquisition
    // MLM => https://www.mercadolibre.com.mx/tarjeta-credito
    // General Path
    "/cobranded"(platform: "/", isAbstract: true) {}
    "/cobranded/error"(platform: "/", type: TrackType.View){}
    
    // Landing
    "/cobranded/landing"(platform: "/", isAbstract: true) {}
    "/cobranded/landing/card_request"(platform: "/", type: TrackType.View){}
    "/cobranded/landing/pending_card"(platform: "/", type: TrackType.View){}
    "/cobranded/landing/approved_card"(platform: "/", type: TrackType.View){}
    "/cobranded/landing/rejected_card"(platform: "/", type: TrackType.View){}

    // Acquisition
    "/cobranded/acquisition"(platform: "/", isAbstract: true) {}
    "/cobranded/acquisition/welcome"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/personal_info"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/cards"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/last_digits"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/welcome_address"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/address"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/additional_info"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/welcome_phone"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/phone"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/review"(platform: "/", type: TrackType.View){}
    
    "/cobranded/acquisition/congrats"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/congrats/approved"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/congrats/pending"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/congrats/rejected"(platform: "/", type: TrackType.View){}
    
    "/cobranded/acquisition/error"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/error/has_card"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/error/corporation"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/error/operator"(platform: "/", type: TrackType.View){}
    "/cobranded/acquisition/error/without_credit_card"(platform: "/", type: TrackType.View){}
    
}
