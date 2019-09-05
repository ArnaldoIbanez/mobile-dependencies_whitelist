import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    propertyDefinitions {
        product_type(
            type: PropertyType.String,
            required: false,
            values: [
                'fixed_term', 
                'express_money',
                'sales_percentage'
            ]
        )
        status(
            type: PropertyType.String,
            required: false,
            values: [
                'on_time', 
                'overdue', 
                'finished'
            ]
        )
        segment(
            type: PropertyType.String,
            required: false,
            values: [
                'online', 
                'in_store'
            ]
        )
        category(
            type: PropertyType.String,
            required: false,
            values: [
                'regular', 
                'refinance'
            ]
        )
        offer_type(
            type: PropertyType.String,
            required: false,
            values: [
                'early_offer', 
                'full_offer'
            ]
        )
        is_first_offer(
            required: false, 
            type: PropertyType.Boolean
        )
    }

    propertyGroups {
        offer_group(product_type, segment, is_first_offer, offer_type)
    }

    propertyGroups {
        products_group(product_type, segment, category, offer_type)
    }

    propertyGroups {
        products_with_status(product_type, segment, category, offer_type, status)
    }

    def with_status = objectSchemaDefinitions {
        products_with_status
    }

    def offer = objectSchemaDefinitions {
        offer_group
    }

    defaultBusiness = "mercadopago"

    "/"(platform: "/web", isAbstract: true) {
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/express_money"(platform: "/", isAbstract: true) {}
    "/credits/merchant"(platform: "/", isAbstract: true) {}
    "/credits/consumer"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Merchants Public Landings
     ******************************************/
    //Public landing
    "/credits/merchant/public_landing"(platform: "/", type: TrackType.View) {
        user_profile(
            type: PropertyType.String,
            required: true
        )
    }

    /******************************************
     *       End: Merchants Public Landings
     ******************************************/

    /******************************************
     *       Start: Merchants Administrator
     ******************************************/

    //Dashboard
    "/credits/merchant/administrator"(platform: "/", type: TrackType.View) {
        offers(
            type: PropertyType.ArrayList(
                PropertyType.Map(offer)
            ),
            required: false,
            inheritable: false
        )
        products(
            type: PropertyType.ArrayList(
                PropertyType.Map(with_status)
            ),
            required: false,
            inheritable: false
        )
        show_cx_widget(
            type: PropertyType.Boolean, 
            required: false, 
            inheritable: false            
        )

        // Included in products properties. Deprecate after new web admin, check native first
        status(
            type: PropertyType.String, 
            required: false, 
            values: [
                'on_time', 
                'overdue',
                'empty'
            ], 
            inheritable: false
        )
    }


    "/credits/merchant/administrator/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: false,
            inheritable: false
        )
    }

    //Detail
    "/credits/merchant/administrator/detail"(platform: "/", type: TrackType.View) {
        products_with_status
    }
    
    "/credits/merchant/administrator/detail/conditions"(platform: "/", type: TrackType.View) {
        products_with_status
    }

    "/credits/merchant/administrator/detail/conditions/ccb_click"(platform: "/", type: TrackType.Event) {
        products_with_status
    }

    "/credits/merchant/administrator/history"(platform:"/", type: TrackType.Event) {}

    //Voluntary Payment
    "/credits/merchant/proactive_payment"(platform: "/", type: TrackType.View) {
        products_group
    }
    "/credits/merchant/proactive_payment/congrats"(platform: "/", type: TrackType.View) {
        products_group
    }
    "/credits/merchant/proactive_payment/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: false,
            values: [
                'insufficient_account_money',
                'lender_cannot_collect_installments',
                'default'
            ],
            inheritable: false
        )
        products_group
    }

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
            values: [
                'pending',
                'rejected',
                'approved'
            ],
            inheritable: false
        )
        sub_status(
            type: PropertyType.String,
            required: false,
            values: [
                'missing_documentation',
                'review_pending',
                'loan_granted'
            ],
            inheritable: false
        )
        product_type(
            type: PropertyType.String,
            required: true,
            values: [
                'default',
                'point',
                'early_offer'
            ],
            inheritable: false
        )
        is_capped_offer(
            type: PropertyType.Boolean,
            required: true,
            inheritable: false
        )
    }

    //Without Proposal
    "/credits/merchant/enrollment/without_proposal"(platform: "/", type: TrackType.View) {}

    //Confirmation modal
    "/credits/merchant/enrollment/confirmation"(platform: "/", type: TrackType.View) {
        amount(
            type: PropertyType.Numeric,
            required: true
        )
        installments(
            type: PropertyType.Numeric,
            required: false
        )
    }

    //Congrats merchant
    "/credits/merchant/enrollment/congrats"(platform: "/", type: TrackType.View) {}

    //Error
    "/credits/merchant/enrollment/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true,
            values: [
                'loan_creation',
                'feedback_creation',
                'files_upload',
                'default'
            ],
            inheritable: false
        )
    }

    //Documentation
    "/credits/merchant/enrollment/documentation"(platform: "/", type: TrackType.View) {
        user_type(
            type: PropertyType.String,
            required: true,
            values: [
                'physical',
                'moral'
            ],
            inheritable: false
        )
    }
    "/credits/merchant/enrollment/documentation/congrats"(platform: "/", type: TrackType.View) {
        user_type(
            type: PropertyType.String,
            required: true,
            values: [
                'physical',
                'moral'
            ],
            inheritable: false
        )
    }
    "/credits/merchant/enrollment/documentation/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: false
        )
    }

    //Testimonials
    "/credits/merchant/enrollment/testimonials"(platform: "/", type: TrackType.View) {
        brand(
            type: PropertyType.String,
            required: true
        )
    }

    //Feedback
    "/credits/merchant/enrollment/feedback"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true,
            values: [
                'interested',
                'not_interested',
                'capped'
            ],
            inheritable: false
        )
    }
    "/credits/merchant/enrollment/feedback/congrats"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true,
            values: [
                'interested',
                'not_interested',
                'capped'
            ],
            inheritable: false
        )
    }
    "/credits/merchant/enrollment/feedback/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: false
        )
    }

    "/credits/merchant/collection"(platform: "/mobile", type: TrackType.Event) {}

    /******************************************
     *       End: Merchants Enrollment
     ******************************************/

    /******************************************
     *       Start: Money Advance
     ******************************************/

    //Money Advance
    "/credits/merchant/money_advance"(platform: "/", isAbstract: true) {}

    //Congrats money advance
    "/credits/merchant/money_advance/congrats"(platform: "/web", type: TrackType.View) {
        status(
            type: PropertyType.String,
            required: true,
            values: [
                'on_time',
                'delayed'
            ]
        )
        user_status(
            type: PropertyType.String,
            required: true,
            values: [
                'on_time',
                'overdue'
            ]
        )
    }

    //Congrats money advance mobile
    "/credits/merchant/money_advance/congrats"(platform: "/mobile", type: TrackType.View) {}

    //Hub money advance
    "/credits/merchant/money_advance/hub"(platform: "/web", type: TrackType.View) {
        user_status(
            type: PropertyType.String,
            required: true,
            values: [
                'on_time',
                'overdue'
            ]
        )
    }

    //Hub money advance mobile
    "/credits/merchant/money_advance/hub"(platform: "/mobile", type: TrackType.View) {}


    //Summary money advance
    "/credits/merchant/money_advance/summary"(platform: "/", type: TrackType.View) {}

    //No options money advance
    "/credits/merchant/money_advance/no_options"(platform: "/", type: TrackType.View) {}

    // Error money advance
    "/credits/merchant/money_advance/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true
        )
    }


    /******************************************
     *       End: Money Advance
     ******************************************/

    /******************************************
     *    Start: Merchant Contacts
     *    We can´t declare values as a numeric
     ******************************************/

    "/credits/merchant/contacts"(platform: "/", type: TrackType.Event) {
        campaign(
            description: "Source of the contact",
            type: PropertyType.String,
            required: true,
            values: [
                'collection',
                'updates',
                'engage'
            ]
        )
        medium(
            description: "Medium of the contact",
            type: PropertyType.String,
            required: true,
            values: [
                'email'
            ]
        )
        milestone(
            description: "Number of days overdue of the contact",
            type: PropertyType.Numeric,
            required: false
        )
        stage(
            description: "Credit stage of the contact",
            type: PropertyType.String,
            required: false,
            values: [
                'educational',
                'to_expire',
                'expired_no_charges',
                'expired_fixed_charges',
                'expired_daily_charges',
                'congrats_debit_installment',
                'congrats_credited_loan',
                'congrats_pending'
            ]
        )
    }

    /******************************************
     *   End: Merchant Contacts
     ******************************************/

    /******************************************
     *    Start: Express money
     ******************************************/

    "/credits/express_money/amount_input"(platform: "/", type: TrackType.View) {
        show_onboarding(
            description: "Metric to track onboarding modal conversion",
            type: PropertyType.Boolean,
            required: false,
            inheritable: false
        )
    }

    "/credits/express_money/summary"(platform: "/", type: TrackType.View) {
        requested_amount(
            description: "User requested amount",
            type: PropertyType.Numeric,
            required: true,
        )
        max_amount(
            description: "Credit line maximum allowed amount",
            type: PropertyType.Numeric,
            required: true,
        )
    }

    "/credits/express_money/congrats"(platform: "/", type: TrackType.View) {
        has_prepaid(
            description: "Metric to track users who has accepted a loan and has prepaid card enabled",
            type: PropertyType.Boolean,
            required: true,
        )
        requested_amount(
            description: "User requested amount",
            type: PropertyType.Numeric,
            required: true,
        )
        max_amount(
            description: "Credit line maximum allowed amount",
            type: PropertyType.Numeric,
            required: true,
        )
    }

    "/credits/express_money/error"(platform: "/", type: TrackType.View) {
        reason(
            description: "Error reason",
            type: PropertyType.String,
            required: true,
            values: [
                'server_error',
                'loan_creation',
                'ccb_creation',
                'simulation',
                'default',
            ]
        )
    }

    "/credits/express_money/onboarding"(platform: "/mobile", type: TrackType.View) {}

    /******************************************
     *   End: Express money
     ******************************************/
}
