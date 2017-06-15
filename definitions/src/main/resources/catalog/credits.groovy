import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    defaultBusiness = "mercadopago"

    "/"(platform: "/web", isAbstract: true) {
    }

    //Definitions
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/merchant"(platform: "/", isAbstract: true) {}
    "/credits/merchant/enrollment"(platform: "/", isAbstract: true) {}

    //Landing merchant
    "/credits/merchant/enrollment"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/not_interested"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/choose_amount"(platform: "/", type: TrackType.Event) {
        amount(type: PropertyType.Numeric, required: true)
    }
    "/credits/merchant/enrollment/choose_installment"(platform: "/", type: TrackType.Event) {
        installment(type: PropertyType.Numeric, required: true)
    }

    //Modal merchant
    "/credits/merchant/enrollment/continue"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/preconfirm"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/enrollment/cancel"(platform: "/", type: TrackType.Event) {}

    //Congrats merchant
    "/credits/merchant/enrollment/congrats"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/withdrawal"(platform: "/", type: TrackType.Event) {}

    //Dashboard merchant
    "/credits/merchant/administrator"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/offer"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/no_offer"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/hero_cta"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/help"(platform: "/", type: TrackType.Event) {}

    //emails para merchant credits
    "/email"(platform: "/email", isAbstract: true) {
    }

    "/email/congrats"(platform: "/email"){
        days(type: PropertyType.Numeric, required: true)
    }

    "/email/next_to_overdue"(platform: "/email"){
        days(type: PropertyType.Numeric, required: true)
    }

    "/email/late_fee"(platform: "/email"){
        days(type: PropertyType.Numeric, required: true)
    }
}