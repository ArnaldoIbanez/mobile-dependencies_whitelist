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
    "/credits/mp-hub"(platform: "/", isAbstract: true) {}
    "/credits/self_service"(platform: "/", isAbstract: true) {}
    "/credits/self_service/promises"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Merchants Public Landings
     ******************************************/

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

    "/credits/merchant/administrator/late_debt"(platform: "/", type: TrackType.Event) {
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
    "/credits/merchant/proactive_payment"(platform: "/", type: TrackType.View) {
        account_money(
            type: PropertyType.String,
            required: false,
            values: [
                'sufficient',
                'insufficient'
            ],
            inheritable: false
        )
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
    "/credits/merchant/early_repayment"(platform: "/", type: TrackType.View) {
        account_money(
            type: PropertyType.String,
            required: true,
            values: [
                'sufficient',
                'insufficient'
            ],
            inheritable: false
        )
        products_group
    }
    "/credits/merchant/early_repayment/congrats"(platform: "/", type: TrackType.View) {
        products_group
    }
    "/credits/merchant/early_repayment/active_early_repayment"(platform: "/", type: TrackType.View) {
        products_group
    }
    "/credits/merchant/early_repayment/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: false,
            inheritable: false
        )
        products_group
    }

    /******************************************
     *       End: Merchants Administrator
     ******************************************/

    /******************************************
     *       Start: Credits Hub
     *******************************************/

    "/credits/mp-hub/redirect"(platform: "/", type: TrackType.View) {
        flow(
            type: PropertyType.String,
            required: true,
            description: "Flow which the user is being redirected",
            values: [
                'merchant_administrator',
                'expres_money_enrollment',
                'personal_loan_adoption_ml',
                'personal_loan_adoption_mp',
                'personal_loan_collection',
                'merchant_enrollment',
                'consumer_loan_adoption',
                'consumer_loan_collection',
                'consumer_native_admin_mp',
                'open_sea_mp',
                'app_store_mp',
                'app_store_ml',
            ]
        )
    }

    "/credits/mp-hub/no-credit-line"(platform: "/", type: TrackType.View) {}

    "/credits/mp-hub/no-credit-line/access_click"(platform: "/", type: TrackType.Event) {
        flow(
            type: PropertyType.String,
            required: true,
            description: "Flow which user is being redirected",
            values: [
                'consumer',
                'merchant',
            ]
        )
    }

    "/credits/mp-hub/no-credit-line/stop"(platform: "/", type: TrackType.View) {
        flow(
            type: PropertyType.String,
            required: true,
            description: "Stop flow",
            values: [
                'generic',
                'merchant',
            ]
        )
    }

    "/credits/mp-hub/no-credit-line/stop/faqs_click"(platform: "/", type: TrackType.Event) {
        flow(
            type: PropertyType.String,
            required: true,
            description: "FAQs flow which user choose to enter",
            values: [
                'merchant',
            ]
        )
    }
    
    "/credits/mp-hub/error"(platform: "/", type: TrackType.View) {}

    "/credits/mp-hub/error/access_click"(platform: "/", type: TrackType.Event) {
        flow(
            type: PropertyType.String,
            required: true,
            description: "Flow which user is being redirected",
            values: [
                'consumer',
                'merchant',
            ]
        )
    }

    /******************************************
     *       End: Credits Hub
     ******************************************/

    /******************************************
     *       Start: Merchants Open Market
     *******************************************/

    "/credits/merchant/open-market/statements_upload"(platform: "/", type: TrackType.Event) {}

    "/credits/merchant/open-market/statements-upload_click"(platform: "/", type: TrackType.Event) {}

    "/credits/merchant/open-market/statements_upload/error"(platform: "/", type: TrackType.Event) {
        reason(
            type: PropertyType.String,
            required: true,
            description: "Statements upload error",
            values: [
                'wrong_extension',
                'generic',
            ]
        )
    }

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

    "/credits/merchant/open-market/congrats"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true,
            description: "From which flow was congrats accessed",
            values: [
                'financial_files',
                'financial_scraping',
            ]
        )
    }

    "/credits/merchant/open-market/stop"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true,
            description: "From which flow was stop page accessed",
            values: [
                'financial_files_uploaded',
                'financial_scraping_done',
            ]
        )
    }

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
        is_operator_user(
            type: PropertyType.Boolean,
            required: false,
        )
        is_kyc_compliance(
            type: PropertyType.Boolean,
            required: false,
        )
    }

    //Without Proposal
    "/credits/merchant/enrollment/without_proposal"(platform: "/", type: TrackType.View) {
        is_operator_user(
            type: PropertyType.Boolean,
            required: false,
        )
    }

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
        through_kyc(
            description: "Metric to track user who has been redirected from KYC",
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
                'rejected_by_regulation',
                'unknown-error',
                'admin-is-restricted',
                'kyc_error',
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

    //Kyc Onboarding for User Challenges
    "/credits/merchant/enrollment/kyc_user_challenges_onboarding"(platform: "/", type: TrackType.View) {}

    //Kyc Congrats Backoffice Challenges
    "/credits/merchant/enrollment/kyc_back_office_congrats"(platform: "/", type: TrackType.View) {}

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

    //Summary event
    "/credits/merchant/enrollment/summary/accept_loan_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        action(
                description: "Event action that we need to track",
                type: PropertyType.String,
                required: true,
        )
        label(
                description: "Tag that identify the button",
                type: PropertyType.String,
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
        offer(
            type: PropertyType.String,
            required: false,
            values: [
                'none',
                'express_money'
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
                'em_expired_daily_charges',
                'congrats_upsell',
                'cm_expired_early_repayment',
                'cm_congrats_debit_lastinstallment',
                'spl_congrats_credited_loan'
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
        status(
            description: "Status of the user prepaid",
            type: PropertyType.String,
            required: true,
            values: [
                "no_prepaid",
                "prepaid_enabled",
                "prepaid_disabled",
                "physical_card",
                "virtual_card"
            ]
        )
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

     /******************************************
     *   Start: Consumer Admin Detail
     ******************************************/

    "/credits/consumer/administrator"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/administrator/dashboard"(platform: "/", type: TrackType.View) {
        dashboard_status(type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
    }
    "/credits/consumer/administrator/summary"(platform: "/", type: TrackType.View) {
        summary_status(description: "Current status of the loan summary", type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
    }

    //Events
    "/credits/consumer/administrator/payment_intention"(platform: "/", type: TrackType.Event) {
        installment_status(
                type: PropertyType.String,
                required: true,
                description: "Current status of clicked pay button",
                values: [
                        'on_time',
                        'to_expire_soft',
                        'to_expire_hard',
                        'expired_today',
                        'no_charge_period',
                        'fixed_charge_period_1',
                        'fixed_charge_period_2',
                        'daily_charge_period'
                ]
        )
        payment_intention(type: PropertyType.String, required: true, values: ['cho', 'ticket'])
    }

    "/credits/consumer/administrator/summary/payment_intention"(platform: "/", type: TrackType.Event) {
    }
    "/credits/consumer/administrator/summary/cx_contact"(platform: "/", type: TrackType.Event) {
    }
    "/credits/consumer/administrator/summary/go_shopping"(platform: "/", type: TrackType.Event) {
    }
    "/credits/consumer/administrator/summary/get_help"(platform: "/", type: TrackType.Event) {
        summary_status(description: "Current status of the loan summary", type: PropertyType.String, required: false, values: ["empty_state", "on_time", "overdue"])
    }
    "/credits/consumer/administrator/summary/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {
        summary_status(description: "Current status of the loan summary", type: PropertyType.String, required: false, values: ["empty_state", "on_time", "overdue"])
    }
    "/credits/consumer/administrator/summary/get_educative"(platform: "/", type: TrackType.Event) {
    }

    //Admin Dashboard v2

    //Page Views
    "/credits/consumer/administrator_v2"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/administrator_v2/dashboard"(platform: "/", type: TrackType.View) {
        dashboard_status(
                            required: true,
                            description: "Current status of the Dashboard",
                            type: PropertyType.String,
                            values: [
                                        "empty_state",
                                        "on_time",
                                        "overdue"
                                    ]
                        )
        personalLoanAccessShown(
                required: false,
                description: "Personal loan access type",
                type: PropertyType.String,
                values: [
                        "row",
                        "banner"
                ]
        )
        offer(
            required: false,
            description: "Self service option shown to the user",
            type: PropertyType.String,
            values: [
                "already_paid",
                "create_promise",
                "view_promise"
            ]
        )
    }
    "/credits/consumer/administrator_v2/error_message"(platform: "/mobile", type: TrackType.View) {
        user_status(
                            required: true,
                            description: "Credit line's current status",
                            type: PropertyType.String,
                            values: [
                                        "manually_paused"
                                    ]
                    )
    }

    //Events

    //Mobile Events
    "/credits/consumer/administrator_v2/dashboard/payment_intention_all"(platform: "/mobile", type: TrackType.Event) {
        installments_group
        installments_qty(
                type: PropertyType.Numeric,
                description: "Tne number of the installments to pay",
                required: true,
                inheritable: false
        )
    }
    "/credits/consumer/administrator_v2/dashboard/choose_installments"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_help"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/cx_contact"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_shopping"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_educative"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_mp"(platform: "/mobile", type: TrackType.Event) {
        has_mp(type: PropertyType.Boolean, required: true)
    }
    "/credits/consumer/administrator_v2/dashboard/close_mp_modal"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_store_mp"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/error_message/button_pressed"(platform: "/mobile", type: TrackType.Event) {}
    
    "/credits/consumer/administrator_v2/dashboard/promises"(platform: "/", isAbstract: true) {}
    "/credits/consumer/administrator_v2/dashboard/promises/create"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/promises/view"(platform: "/mobile", type: TrackType.Event) {}

    /******************************************
     *       End: Consumers Administrator
     ******************************************/


    /****************************************************
     *       Start: Consumers Installment Selection Page
     ****************************************************/

    //Views
    "/credits/consumer/administrator_v2/installment_selection"(platform: "/mobile", type: TrackType.View) {
        page_status(type: PropertyType.String, required: true, values: ["empty_state","on_time", "overdue"])
    }

    //Events
    "/credits/consumer/administrator_v2/installment_selection/payment_intention"(platform: "/", type: TrackType.Event) {
        total_installments(
                type: PropertyType.Numeric,
                required: true,
                description: "The total number of payable installments"
        )
        paid_installments(
                type: PropertyType.Numeric,
                required: true,
                description: "The selected number of installments to pay"
        )
    }
    "/credits/consumer/administrator_v2/installment_selection/secondary_payment_intention"(platform: "/", type: TrackType.Event) {
        total_installments(
                type: PropertyType.Numeric,
                required: true,
                description: "The total number of payable installments"
        )
    }
    "/credits/consumer/administrator_v2/installment_selection/back_to_dashboard"(platform: "/", type: TrackType.Event) {
    }

    /****************************************************
     *       End: Consumers Installment Selection Page
     ****************************************************/
    /******************************************
     *    Start: Consumers Change Due Date FLow
     ******************************************/
    "/credits/consumer/duedate_selection"(platform: "/", type: TrackType.View) {
        available_products(description: "products that user was used", type: PropertyType.ArrayList, required: true)
        due_date (description: "Positive number for actuall due date",type: PropertyType.Numeric,required: true)
    }

    "/credits/consumer/duedate_selection/success"(platform: "/", type: TrackType.View) {
        new_due_date(description: "Positive number for actuall due date",type: PropertyType.Numeric,required: true)
    }

    "/credits/consumer/duedate_selection/not_allowed"(platform: "/", type: TrackType.View) {}

    "/credits/consumer/duedate_selection/error"(platform: "/", type: TrackType.View) {}

    "/credits/consumer/duedate_selection/cancel"(platform: "/", type: TrackType.Event) {}

     /******************************************
     *    End: Consumers Change Due Date FLow
     ******************************************/

     /******************************************
     *    Start: Self service
     ******************************************/
    "/credits/self_service/promises/create_form"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer or mix",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix"
            ]
        )
    }
        
    "/credits/self_service/promises/create_form/submit"(platform: "/", type: TrackType.Event) {
        is_partial_amount(
            required: true,
            description: "Whether promise amount is less than bulk amount",
            type: PropertyType.Boolean
        )
        bulk_amount(
            required: true,
            description: "Bulk amount or total debt amount for user",
            type: PropertyType.Numeric
        )
        promise_amount(
            required: true,
            description: "Promise amount filled in by user",
            type: PropertyType.Numeric
        )
        payment_method(
            required: true,
            description: "Payment method selected for promise",
            type: PropertyType.String
        )
        promise_due_days(
            required: true,
            description: "How many days until the promise is due from the day it was created",
            type: PropertyType.Numeric
        )
    }

    "/credits/self_service/promises/create_form/cancel"(platform: "/", type: TrackType.Event) {}
    
    "/credits/self_service/promises/congrats"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer or mix",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix"
            ]
        )
    }

    "/credits/self_service/promises/error"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer or mix",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix"
            ]
        )
    }

    "/credits/self_service/promises/view"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer or mix",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix"
            ]
        )
    }
     /******************************************
     *    End: Self service
     ******************************************/
}
