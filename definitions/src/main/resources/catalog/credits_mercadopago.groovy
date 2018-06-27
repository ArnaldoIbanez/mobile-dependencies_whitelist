import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    defaultBusiness = "mercadopago"

    "/"(platform: "/web", isAbstract: true) {
    }

    //Definitions - Merchant
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/merchant"(platform: "/", isAbstract: true) {}
    "/credits/merchant/enrollment"(platform: "/", isAbstract: true) {}
    "/credits/merchant/enrollment/load_documents"(platform: "/", isAbstract: true) {}
    "/credits/merchant/public_landing"(platform: "/", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true)
    }

    //Landing merchant
    "/credits/merchant/enrollment"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/credits_conditions"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/not_interested"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/choose_amount"(platform: "/", type: TrackType.Event) {
        amount(type: PropertyType.Numeric, required: true)
    }
    "/credits/merchant/enrollment/choose_installment"(platform: "/", type: TrackType.Event) {
        installment(type: PropertyType.Numeric, required: true)
    }

    //Modal merchant
    "/credits/merchant/enrollment/preconfirm"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/cancel"(platform: "/", type: TrackType.Event) {}

    //Upload Files merchant
    "/credits/merchant/enrollment/load_documents"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/user_type"(platform: "/", type: TrackType.Event) {
        type(type: PropertyType.String, required: true)
    }
    "/credits/merchant/enrollment/load_documents/cancel"(platform: "/", type: TrackType.Event) {}

    //Review merchant
    "/credits/merchant/enrollment/review"(platform: "/", type: TrackType.Event) {}

    //Congrats merchant
    "/credits/merchant/enrollment/congrats"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/withdrawal"(platform: "/", type: TrackType.Event) {}

    //Error merchant
    "/credits/merchant/enrollment/error"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/try_it_again"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/enrollment/contact_us"(platform: "/", type: TrackType.Event) {}

    //Dashboard merchant
    "/credits/merchant/administrator"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/administrator/detail"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/offer"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/no_offer"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/admin_on_time"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/admin_late_pay"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/hero_cta"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/second_offer_cta"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/help"(platform: "/", type: TrackType.Event) {}

    //Help merchant
    "/credits/merchant/enrollment/ask_us"(platform: "/", type: TrackType.Event) {}

    //Definitions - Consumer
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/credits/consumer/administrator/detail"(platform: "/", isAbstract: true) {}

    //Administrator consumer
    "/credits/consumer/administrator/detail"(platform: "/", type: TrackType.View) {}

    //Definitions - Money Advance
    "/credits/moneyadvance"(platform: "/", isAbstract: true) {}

    //Money Advance - Automatic Cash Advance
    "/credits/moneyadvance/automatic"(platform: "/", isAbstract: true) {}
    "/credits/moneyadvance/automatic/offer"(platform: "/", type: TrackType.View) {}
    "/credits/moneyadvance/automatic/congrats"(platform: "/", type: TrackType.View) {}
}
