import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    defaultBusiness = "mercadolibre"

    // Acquisition
    // MLM => https://www.mercadolibre.com.mx/tarjeta-credito
    // General Path
    "/tarjeta_credito"(platform: "/", isAbstract: true) {}
    "/tarjeta_credito/error"(platform: "/", type: TrackType.View){}
    
    // Landing
    "/tarjeta_credito/landing/"(platform: "/", isAbstract: true) {}
    "/tarjeta_credito/landing/card_request"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/landing/pending_card"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/landing/approved_card"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/landing/rejected_card"(platform: "/", type: TrackType.View){}

    // Acquisition
    "/tarjeta_credito/acquisition/"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/welcome"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/personal_info"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/cards"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/last_digits"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/welcome_address"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/address"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/additional_info"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/welcome_phone"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/phone"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/review"(platform: "/", type: TrackType.View){}
    
    "/tarjeta_credito/acquisition/congrats"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/congrats/approved"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/congrats/pending"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/congrats/rejected"(platform: "/", type: TrackType.View){}
    
    "/tarjeta_credito/acquisition/error"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/error/has_card"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/error/corporation"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/error/operator"(platform: "/", type: TrackType.View){}
    "/tarjeta_credito/acquisition/error/without_credit_card"(platform: "/", type: TrackType.View){}
    
}
