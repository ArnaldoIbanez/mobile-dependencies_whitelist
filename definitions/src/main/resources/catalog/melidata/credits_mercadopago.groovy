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

    //Dashboard
    "/credits/merchant/administrator"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: true, values: ['on_time', 'overdue'], inheritable: false)
    }

    //Detail
    "/credits/merchant/administrator/detail"(platform: "/", type: TrackType.View) {
        status(
                type: PropertyType.String,
                required: true,
                values: ['on_time', 'overdue', 'finished'],
                inheritable: false
        )
    }
    "/credits/merchant/administrator/detail/conditions"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/", type: TrackType.Event) {}

    //Voluntary Payment
    "/credits/merchant/administrator/voluntary_payment"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/administrator/voluntary_payment/congrats"(platform: "/", type: TrackType.View) {
        flow(type: PropertyType.String, required: false, values: ['voluntary_payment'])
    }
    "/credits/merchant/administrator/voluntary_payment/error"(platform: "/", type: TrackType.View) {
        reason(type: PropertyType.String, required: false, values: ['insufficient_account_money',
                                                                    'lender_cannot_collect_installments',
                                                                    'default'])
    }

    //These should be deprecated...
    "/credits/merchant/administrator"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/offer"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/no_offer"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/admin_on_time"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/admin_late_pay"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/administrator/detail"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/hero_cta"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/second_offer_cta"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/help"(platform: "/", type: TrackType.Event) {}

    /******************************************
     *       End: Merchants Administrator
     ******************************************/

    /******************************************
     *       Start: Merchants Enrollment
     ******************************************/

    //Enrollment
    //Page Views
    "/credits/merchant/enrollment"(platform: "/", type: TrackType.View) {
        status(
            type: PropertyType.String,
            required: true,
            values: ['pending', 'rejected', 'approved'],
            inheritable: false
        )
        sub_status(
            type: PropertyType.String,
            required: false,
            values: ['missing_documentation','review_pending', 'loan_granted'],
            inheritable: false
        )
        product_type(
            type: PropertyType.String,
            required: true,
            values: ['default', 'point', 'early_offer'],
            inheritable: false
        )
    }

    //Confirmation modal
    "/credits/merchant/enrollment/confirmation"(platform: "/", type: TrackType.View) {
        amount(type: PropertyType.Numeric, required: true)
        installments(type: PropertyType.Numeric, required: false)
    }

    //Congrats merchant
    "/credits/merchant/enrollment/congrats"(platform: "/", type: TrackType.View) {}

    //Error
    "/credits/merchant/enrollment/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true,
            values: [
                'loan_creation_failed',
                'feedback_creation_failed',
                'files_upload_failed',
                'default'
            ],
            inheritable: false
        )
    }

    //Documentation
    "/credits/merchant/enrollment/documentation"(platform: "/", type: TrackType.View) {
        user_type(type: PropertyType.String, required: true, values: ['physical', 'moral'], inheritable: false)
    }
    "/credits/merchant/enrollment/documentation/congrats"(platform: "/", type: TrackType.View) {
        user_type(type: PropertyType.String, required: true, values: ['physical', 'moral'], inheritable: false)
    }
    "/credits/merchant/enrollment/documentation/error"(platform: "/", type: TrackType.View) {
        reason(type: PropertyType.String, required: false)
    }

    //Testimonials
    "/credits/merchant/enrollment/testimonials"(platform: "/", type: TrackType.View) {
        brand(type: PropertyType.String, required: true)
    }

    //Feedback
    "/credits/merchant/enrollment/feedback"(platform: "/", type: TrackType.View) {
         reason(type: PropertyType.String, required: true, values: ['interested', 'not_interested'], inheritable: false)
    }
    "/credits/merchant/enrollment/feedback/congrats"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/feedback/error"(platform: "/", type: TrackType.View) {
        reason(type: PropertyType.String, required: false)
    }


    //These should be deprecated...
    "/credits/merchant/enrollment"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/credits_conditions"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/preconfirm"(platform: "/", type: TrackType.View) {
        amount(type: PropertyType.Numeric, required: false)
        installments(type: PropertyType.Numeric, required: false)
    }
    "/credits/merchant/enrollment/cancel"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/enrollment/feedback"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/feedback/interested"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/feedback/not_interested"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/feedback/success"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/feedback/error"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/choose_amount"(platform: "/", type: TrackType.Event) {
        amount(type: PropertyType.Numeric, required: true)
    }
    "/credits/merchant/enrollment/choose_installment"(platform: "/", type: TrackType.Event) {
        installment(type: PropertyType.Numeric, required: true)
    }
    "/credits/merchant/enrollment/load_documents"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/load_documents/user_type"(platform: "/", type: TrackType.Event) {
        type(type: PropertyType.String, required: true, values: ['physical', 'moral'])
    }
    "/credits/merchant/enrollment/load_documents/cancel"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/enrollment/review"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/enrollment/withdrawal"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/enrollment/error/accept"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/error"(platform: "/", type: TrackType.View) {}
    "/credits/merchant/enrollment/error/try_it_again"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/enrollment/error/contact_us"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/enrollment/ask_us"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/collection"(platform: "/mobile", type: TrackType.Event) {}

    /******************************************
     *       End: Merchants Enrollment
     ******************************************/

    /******************************************
     *       Start: Money Advance
     ******************************************/

    //Money advance
    "/credits/merchant/money_advance"(platform: "/", type: TrackType.View) {}

    //Congrats money advance
    "/credits/merchant/money_advance/congrats"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: false, values: ['delayed'])
        user_status(type: PropertyType.String, required: false, values: ['in_default'])
    }

    //Hub money advance
    "/credits/merchant/money_advance/hub"(platform: "/", type: TrackType.View) {
        user_status(type: PropertyType.String, required: false, values: ['in_default'])
    }

    //Summary money advance
    "/credits/merchant/money_advance/summary"(platform: "/", type: TrackType.View) {}

    //No options money advance
    "/credits/merchant/money_advance/no_options"(platform: "/", type: TrackType.View) {}

    // Error money advance
    "/credits/merchant/money_advance/error"(platform: "/", type: TrackType.View) {
        reason(type: PropertyType.String, required: false)
    }

    /******************************************
     *       End: Money Advance
     ******************************************/

}
