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


    // Acquisition
    // MLM => https://www.mercadopago.com.mx/tarjeta-credito
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
