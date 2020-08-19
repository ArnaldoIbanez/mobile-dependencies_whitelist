package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1205"

    propertyDefinitions {
        product_type(
            type: PropertyType.String,
            required: false,
            values: [
                'fixed_term',
                'fixed_term_loan',
                'express_money',
                'sales_percentage',
                'sales_percentage_loan'
            ]
        )
        product_types(
            description: "Available product types in the user's credit line",
            type: PropertyType.ArrayList(product_type),
            required: true,
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
                'full_offer',
                'special_full_offer'
            ]
        )
        is_first_offer(
            required: false,
            type: PropertyType.Boolean
        )
        variant(
            description: "Option types from the user's credit line",
            type: PropertyType.String,
            values: [
                "normal",
                "fixed_amount",
                "fixed_option",
                "fixed"
            ],
            required: true,
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

    def offer_definition = objectSchemaDefinitions {
        offer_group
    }

    def offer_map = objectSchemaDefinitions {
        offer_type(
            type: PropertyType.String,
            required: false,
            values: [
                'early_offer',
                'full_offer',
                'special_full_offer'
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
        is_capped_offer(
            type: PropertyType.Boolean,
            required: false,
            inheritable: false
        )
    }

    def product_type_map = objectSchemaDefinitions {
        product_type(
            description: "Product type from the user's credit line",
            type: PropertyType.String,
            required: true,
            values: [
                'fixed_term_loan',
                'express_money',
                'sales_percentage_loan'
            ]
        )
        variant(
            description: "Option types from the user's credit line",
            type: PropertyType.String,
            values: [
                "normal",
                "fixed_amount",
                "fixed_option",
                "fixed"
            ],
            required: true,
        )
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

    "/credits/merchant/declarative_form"(platform:"/", type: TrackType.View) {}
    "/credits/merchant/declarative_form/congrats"(platform:"/", type: TrackType.View) {}

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
                PropertyType.Map(offer_definition)
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

    "/credits/merchant/administrator/spc_click"(platform: "/", type: TrackType.Event) {
        products_with_status
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

    "/credits/merchant/administrator/history"(platform:"/", type: TrackType.View) {}

    "/credits/merchant/administrator/payment_history"(platform:"/", type: TrackType.View) {
        products_with_status
    }

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
                'installment_paid',
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
     *       Start: Merchants Open Market
     *******************************************/

    "/credits/merchant/open-market/statements_upload"(platform: "/", type: TrackType.Event) {}

    "/credits/merchant/open-market/no-upsell_click"(platform: "/", type: TrackType.Event) {}

    "/credits/merchant/open-market/how-to-download_click"(platform: "/", type: TrackType.Event) {}

    "/credits/merchant/open-market/bank_click"(platform: "/", type: TrackType.Event) {
        bank(
            type: PropertyType.String,
            required: true,
            inheritable: false,
            description: "bank identifier clicked",
            values: [
                'caixa', 
                'santander', 
                'banco_do_brasil', 
                'bradesco',
                'itau',
            ]
        )
    }

    "/credits/merchant/open-market"(platform: "/", type: TrackType.View) {}

    "/credits/merchant/open-market/congrats"(platform: "/", type: TrackType.View) {}

    "/credits/merchant/open-market/form"(platform: "/", type: TrackType.View) {
        bank(
            type: PropertyType.String,
            required: true,
            inheritable: false,
            description: "bank identifier clicked",
            values: [
                'caixa', 
                'santander', 
                'banco_do_brasil', 
                'bradesco',
                'itau',
            ]
        )
    }

    "/credits/merchant/open-market/form/sent"(platform: "/", type: TrackType.Event) {}

    /******************************************
     *       End: Merchants Open Market
     ******************************************/

    /******************************************
     *       Start: Merchants Enrollment
     ******************************************/

    //Enrollment
    //Page Views
    "/credits/merchant/enrollment"(platform: "/", type: TrackType.View) {
        status(
            type: PropertyType.String,
            required: false,
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
            required: false,
            values: [
                'default',
                'point',
                'early_offer',
            ],
            inheritable: false
        )
        is_capped_offer(
            type: PropertyType.Boolean,
            required: false,
            inheritable: false
        )
        offer(
            type: PropertyType.Map(offer_map),
            required: false,
        )
        product_types(
            description: "Available product types in the user's credit line",
            type: PropertyType.ArrayList(
                PropertyType.Map(product_type_map)
            ),
            required: false,
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

    //Congrats
    "/credits/merchant/enrollment/congrats"(platform: "/", type: TrackType.View) {
        product_type(
            description: "Product type from the user's credit line",
            type: PropertyType.String,
            required: false,
        )
        has_prepaid(
            description: "Metric to track users who has accepted a loan and has prepaid card enabled",
            type: PropertyType.Boolean,
            required: false,
        )
        requested_amount(
            description: "User requested amount",
            type: PropertyType.Numeric,
            required: false,
        )
        max_amount(
            description: "Credit line maximum allowed amount",
            type: PropertyType.Numeric,
            required: false,
        )
        min_amount(
            description: "Credit line minimum allowed amount",
            type: PropertyType.Numeric,
            required: false,
        )
        option(
            description: "User requested option",
            type: PropertyType.Numeric,
            required: false,
        )
        max_option(
            description: "Credit line maximum allowed option",
            type: PropertyType.Numeric,
            required: false,
        )
        loan_status(
            description: "The status of the created loan",
            type: PropertyType.String,
            required: false,
        )
        loan_created_with_retry(
                description: "Metric to track user who accept the credit in a second attempt",
                type: PropertyType.Boolean,
                required: false,
        )
    }

    //Error
    "/credits/merchant/enrollment/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true,
            values: [
                'loan_creation',
                'feedback_creation',
                'files_upload',
                'rejected_loan_by_regulation',
                'unknown-error',
                'admin-is-restricted',
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

    //Mobile
    //Onboarding
    "/credits/merchant/enrollment/onboarding"(platform: "/", type: TrackType.View) {
        offer(
            type: PropertyType.Map(offer_map),
            required: false,
        )
        product_types(
            description: "Available product types in the user's credit line",
            type: PropertyType.ArrayList,
            required: true,
        )
        is_kyc_compliant(
                type: PropertyType.Boolean,
                required: false,
        )
    }

    //Kyc Onboarding
    "/credits/merchant/enrollment/kyc_onboarding"(platform: "/", type: TrackType.View) {
        offer(
                type: PropertyType.Map(offer_map),
                required: false,
        )
        product_types(
                description: "Available product types in the user's credit line",
                type: PropertyType.ArrayList,
                required: true,
        )
    }

    //Hub
    "/credits/merchant/enrollment/hub"(platform: "/", type: TrackType.View) {
        offer(
            type: PropertyType.Map(offer_map),
            required: false,
        )
        product_types(
            description: "Available product types in the user's credit line",
            type: PropertyType.ArrayList,
            required: true,
        )
        is_kyc_compliant(
                type: PropertyType.Boolean,
                required: false,
        )
    }

    //Simulator
    "/credits/merchant/enrollment/simulator"(platform: "/", type: TrackType.View) {
        offer(
            type: PropertyType.Map(offer_map),
            required: false,
        )
        product_type(
            description: "Product type from the user's credit line",
            type: PropertyType.String,
            required: true,
            values: [
                'fixed_term_loan',
                'express_money',
                'sales_percentage_loan'
            ]
        )
        variant(
            description: "Option types from the user's credit line",
            type: PropertyType.String,
            values: [
                "normal",
                "fixed_amount",
                "fixed_option",
                "fixed"
            ],
            required: true,
        )
        is_kyc_compliant(
                type: PropertyType.Boolean,
                required: false,
        )
    }

    //Summary
    "/credits/merchant/enrollment/summary"(platform: "/", type: TrackType.View) {
        product_type(
            description: "Product type from the user's credit line",
            type: PropertyType.String,
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
        min_amount(
            description: "Credit line minimum allowed amount",
            type: PropertyType.Numeric,
            required: true,
        )
        option(
            description: "User requested option",
            type: PropertyType.Numeric,
            required: true,
        )
        max_option(
            description: "Credit line maximum allowed option",
            type: PropertyType.Numeric,
            required: true,
        )
    }

    //Documents
    "/credits/merchant/documents"(platform: "/", isAbstract: true) {}

    //Simulation
    "/credits/merchant/documents/simulation"(platform: "/", isAbstract: true) {}

    //Conditions
    "/credits/merchant/documents/simulation/conditions"(platform: "/", type: TrackType.View) {
        products_group
    }

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
                'congrats_pending',
                'em_congrats_credited_loan',
                'em_congrats_debit_installment',
                'em_insufficient_funds',
                'em_expired_daily_charges'
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
        min_amount(
            description: "Credit line minimum allowed amount",
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
        min_amount(
            description: "Credit line minimum allowed amount",
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

    /******************************************
     *   Start: Personal Loans Adoption
     ******************************************/
    "/credits/consumer/personal"(platform: "/mobile", type: TrackType.View) {}

    "/credits/consumer/personal/adoption"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: true)
    }

    "/credits/consumer/personal/adoption/onboarding"(platform: "/mobile", type: TrackType.View) {
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: true)
    }

    "/credits/consumer/personal/adoption/onboarding/go_simulation"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/onboarding/close"(platform: "/mobile", type: TrackType.Event) {
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: false)
    }

    "/credits/consumer/personal/adoption/simulator"(platform: "/mobile", type: TrackType.View) {}

    "/credits/consumer/personal/adoption/simulator/go_review"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review"(platform: "/mobile", type: TrackType.View) {}

    "/credits/consumer/personal/adoption/review/general_terms"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review/particular_terms"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review/above_confirm"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review/below_confirm"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/congrats"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: false)
        status(description: "Status of the user prepaid", type: PropertyType.String, required: true, values: ["no_prepaid", "prepaid_enabled", "prepaid_disabled"])
    }

    "/credits/consumer/personal/adoption/congrats/go_wallet"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/congrats/go_prepaid"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/congrats/go_withdrawals"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/generic_message"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: false)
        status(description: "Status of the user prepaid", type: PropertyType.String, required: true, values: ["no_prepaid", "prepaid_enabled", "prepaid_disabled"])
    }

    "/credits/consumer/personal/adoption/generic_message/go_prepaid"(platform: "/mobile", type: TrackType.Event) {}


    /******************************************
     *   End: Personal Loans Adoption
     ******************************************/
}
