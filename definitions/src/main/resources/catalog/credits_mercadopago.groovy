import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    defaultBusiness = "mercadopago"

    "/"(platform: "/web", isAbstract: true) {
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/merchant"(platform: "/", isAbstract: true) {}
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/credits/consumer/administrator"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Merchants Public Landings
     ******************************************/
    //Public landing
    "/credits/merchant/public_landing"(platform: "/", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true)
    }

    /******************************************
     *       End: Merchants Public Landings
     ******************************************/

    /******************************************
     *       Start: Merchants Administrator
     ******************************************/

    //Transactional
    "/credits/merchant/administrator/congrats"(platform: "/", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, values: ['voluntary_payment'])
    }
    "/credits/merchant/administrator/error"(platform: "/", type: TrackType.View) {
        reason(type: PropertyType.String, required: true, values: ['insufficient_account_money',
                                                                   'lender_cannot_collect_installments',
                                                                   'default'])
    }

    //Dashboard merchants
    //Page Views
    "/credits/merchant/administrator/dashboard"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: true, values: ['offer', 'no_offer', 'on_time', 'overdue',
                                                                   'on_time_with_offer', 'overdue_with_offer'])
    }
    "/credits/merchant/administrator"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/offer"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/no_offer"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/admin_on_time"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/admin_late_pay"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/administrator/detail"(platform: "/", type: TrackType.View) {}

    //Events
    "/credits/merchant/hero_cta"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/second_offer_cta"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/help"(platform: "/", type: TrackType.Event) {}

    //Voluntary Payment
    "/credits/merchant/administrator/next_installment_payment"(platform: "/", type: TrackType.View) {}

    /******************************************
     *       End: Merchants Administrator
     ******************************************/

    /******************************************
     *       Start: Merchants Enrollment
     ******************************************/

    //Enrollment
    //Page Views
    "/credits/merchant/enrollment"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/credits_conditions"(platform: "/", type: TrackType.View) {}


    //Feedback new
    "/credits/merchant/enrollment/feedback"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/feedback/interested"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/feedback/not_interested"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/feedback/success"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/feedback/error"(platform: "/", type: TrackType.View) {}

    //Feedback old => to be removed
    "/credits/merchant/enrollment/not_interested"(platform: "/", type: TrackType.View) {}


    //Events
    "/credits/merchant/enrollment/choose_amount"(platform: "/", type: TrackType.Event) {
        amount(type: PropertyType.Numeric, required: true)
    }
    "/credits/merchant/enrollment/choose_installment"(platform: "/", type: TrackType.Event) {
        installment(type: PropertyType.Numeric, required: true)
    }

    //Modal merchant
    "/credits/merchant/enrollment/preconfirm"(platform: "/", type: TrackType.View) {
        amount(type: PropertyType.Numeric, required: false)
        installment(type: PropertyType.Numeric, required: false)
    }
    "/credits/merchant/enrollment/cancel"(platform: "/", type: TrackType.Event) {}

    //Upload Files merchant
    "/credits/merchant/enrollment/load_documents"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/load_documents/user_type"(platform: "/", type: TrackType.Event) {
        type(type: PropertyType.String, required: true, values: ['physical', 'moral'])
    }
    "/credits/merchant/enrollment/load_documents/cancel"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/enrollment/documentation"(platform: "/", type: TrackType.View) {
        userType(type: PropertyType.String, required: true, values: ['physical', 'moral'])
    }

    //Review merchant
    "/credits/merchant/enrollment/review"(platform: "/", type: TrackType.Event) {}

    //Congrats merchant
    "/credits/merchant/enrollment/congrats"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/withdrawal"(platform: "/", type: TrackType.Event) {}

    //Error merchant
    "/credits/merchant/enrollment/error/accept"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/error"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/error/try_it_again"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/enrollment/error/contact_us"(platform: "/", type: TrackType.Event) {}

    //Help merchant
    "/credits/merchant/enrollment/ask_us"(platform: "/", type: TrackType.Event) {}
    /******************************************
     *       End: Merchants Enrollment
     ******************************************/

}
