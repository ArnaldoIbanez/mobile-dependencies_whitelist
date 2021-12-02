package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    initiative = "1204"

    propertyDefinitions {
        product_type(
            type: PropertyType.String,
            required: false,
            description: "Names of the products",
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
            description: "Loan status",
            values: [
                'on_time',
                'overdue',
                'finished'
            ]
        )
        segment(
            type: PropertyType.String,
            required: false,
            description: "Segment",
            values: [
                'online',
                'in_store'
            ]
        )
        category(
            type: PropertyType.String,
            required: false,
            description: "Category",
            values: [
                'regular',
                'refinance'
            ]
        )
        offer_type(
            type: PropertyType.String,
            required: false,
            description: "Offer type",
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
        from(
            description: "States previous navigation step (could be from same flow or not)",
            type: PropertyType.String,
            required: false,
            inheritable: true
        )
        additional_info(
            description: "Additional information regarding flow navigation",
            type: PropertyType.String,
            required: false,
            inheritable: true
        )
        accesses(
                description: "Type of accesses shown to users",
                type: PropertyType.String,
                required: false,
                values: [
                    'open_market'
                ],
                inheritable: false
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

    propertyGroups {
        source_tracking(from, additional_info)
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
    "/credits/express_money"(platform: "/web", isAbstract: true) {}
    "/credits/merchant"(platform: "/web", isAbstract: true) {}
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/credits/self_service"(platform: "/", isAbstract: true) {}
    "/credits/self_service/promises"(platform: "/", isAbstract: true) {}
    "/credits/self_service/debt-relief"(platform: "/", isAbstract: true) {}
    "/credits/merchant/open_market"(platform: "/", isAbstract: true) {
        flow(
            type: PropertyType.String,
            required: true,
            description: "From which flow was landing accessed",
            values: [
                'upsell_offer',
                'request_offer',
            ]
        )
    }
    "/credits/merchant/open_market/financial_scraping"(platform: "/", isAbstract: true) {}

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
            inheritable: false,
            description: "offers"
        )
        campaign_id(
            description: "Custom landing campaign",
            type: PropertyType.String,
            required: false,
            values: [
                'amount_and_fee_improvement',
                'amount_and_term_improvement',
                'amount_improvement',
                'fee_improvement',
                'term_improvement'
            ]
        )
        products(
            type: PropertyType.ArrayList(
                PropertyType.Map(with_status)
            ),
            required: false,
            inheritable: false,
            description: "products"
        )
        promise(
            type: PropertyType.String,
            required: false,
            values: [
                'create_promise',
                'view_promise',
                'create_debt_relief',
                'view_debt_relief',
                'none',
            ],
            inheritable: false,
            description: "promise"
        )
        show_cx_widget(
            type: PropertyType.Boolean,
            required: false,
            inheritable: false,
            description: "cx widget is open"
        )
        accesses(
            description: "List of accesses shown to the user",
            type: PropertyType.ArrayList(accesses),
            required: false,
        )
        from_optins(
            type: PropertyType.Boolean,
            required: false,
            inheritable: false,
            description: "optin validation"
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
            inheritable: false,
            description: "status"
        )
        source_tracking
    }

    "/credits/merchant/administrator/spc_click"(platform: "/", type: TrackType.Event) {
        products_with_status
    }

    "/credits/merchant/administrator/spl_proactive_payment_click"(platform: "/", type: TrackType.Event) {
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
                inheritable: false,
                description: "offers"
        )
        products(
                type: PropertyType.ArrayList(
                        PropertyType.Map(with_status)
                ),
                required: false,
                inheritable: false,
                description: "products"
        )
        from_optins(
            type: PropertyType.Boolean,
            required: false,
            inheritable: false,
            description: "optin validation"
        )
        source_tracking
    }

    "/credits/merchant/administrator/contextual_help_click"(platform: "/", type: TrackType.Event) {

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

    "/credits/merchant/administrator/detail/conditions/ccc_click"(platform: "/", type: TrackType.Event) {
        products_with_status
    }

    "/credits/merchant/administrator/detail/conditions/dde_click"(platform: "/", type: TrackType.Event) {
        products_with_status
    }

    "/credits/merchant/administrator/detail/conditions/hrc_click"(platform: "/", type: TrackType.Event) {
        products_with_status
    }

    "/credits/merchant/administrator/history"(platform:"/", type: TrackType.View) {}

    "/credits/merchant/administrator/payment_history"(platform:"/", type: TrackType.View) {
        products_with_status
    }

    "/credits/merchant/administrator/inconsistency"(platform:"/mobile", type: TrackType.View) {
        offers(
            type: PropertyType.ArrayList(
                PropertyType.Map(offer_definition)
            ),
            description: "inconsistency",
            required: false,
            inheritable: false
        )
        products(
            type: PropertyType.ArrayList(
                PropertyType.Map(with_status)
            ),
            description: "products",
            required: false,
            inheritable: false
        )
        promise(
            type: PropertyType.String,
            required: false,
            description: "Promise state",
            values: [
                'create_promise',
                'view_promise',
                'create_debt_relief',
                'view_debt_relief',
                'none',
            ],
            inheritable: false
        )

        accesses(
            description: "List of accesses shown to the user",
            type: PropertyType.ArrayList(accesses),
            required: false
        )

        reason(
            type: PropertyType.String,
            required: true,
            values: [
                'communications_library'
            ],
            inheritable: false,
            description: "reason"
        )

        source_tracking
    }

    //Checkout
    "/credits/merchant/checkout"(platform: "/web", type: TrackType.Event) {
        amount_to_pay(
           type: PropertyType.String,
           required: true,
           description: "Redirect to checkout with amount to pay",
           inheritable: false
        )
        products(
            type: PropertyType.ArrayList(
                PropertyType.Map(with_status)
            ),
            required: false,
            inheritable: false,
            description: "products"
        )
    }

    "/credits/merchant/checkout"(platform: "/mobile", type: TrackType.View) {
        amount_to_pay(
           type: PropertyType.String,
           required: true,
           description: "Redirect to checkout with amount to pay",
           inheritable: false
        )
        products(
            type: PropertyType.ArrayList(
                PropertyType.Map(with_status)
            ),
            required: true,
            inheritable: false,
            description: "products"
        )
    }

    "/credits/merchant/checkout/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: false,
            inheritable: false,
            description: "error"
        )
    }

    //Voluntary Payment
    "/credits/merchant/proactive_payment"(platform: "/", type: TrackType.View) {
        products_group
    }
    "/credits/merchant/proactive_payment/summary"(platform: "/", type: TrackType.View) {
        account_money(
            type: PropertyType.String,
            required: false,
            values: [
                'sufficient',
                'insufficient'
            ],
            inheritable: false
        )
        total_amount_owed(
           type: PropertyType.String,
           required: false,
           inheritable: false
        )
        available_balance(
            type: PropertyType.String,
            required: false,
            inheritable: false
        )
        amount_to_pay(
            type: PropertyType.String,
            required: false,
            inheritable: false
        )
        products_group
    }
    "/credits/merchant/proactive_payment/congrats"(platform: "/", type: TrackType.View) {
        products_group
    }
    "/credits/merchant/proactive_payment/amount_input"(platform: "/", type: TrackType.View) {
        available_balance(
            type: PropertyType.String,
            required: false,
            inheritable: false
        )
        max_value_to_pay(
            type: PropertyType.String,
            required: false,
            inheritable: false
        )
        products_with_status
    }
    "/credits/merchant/proactive_payment/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true,
            values: [
                'insufficient_account_money',
                'lender_cannot_collect_installments',
                "rejected:rejected_by_regulations",
                'rejected:rejected_high_risk',
                'rejected:payer_unavailable',
                "in_process:pending_review_manual",
                "internal_error",
                'conflict_error',
                'bad_request',
                'unauthorized',
                'default'
            ],
            inheritable: false
        )
        products_group
    }
    "/credits/merchant/proactive_payment/info"(platform: "/", type: TrackType.View) {
        reason(
                type: PropertyType.String,
                required: true,
                values: [
                        "installment_paid",
                        "payment_pending",
                        "payment_already_processed"
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
        payment_type(
            type: PropertyType.String,
            required: false,
            values: [
                'total',
                'partial'
            ],
            inheritable: false
        )
        products_group
    }
    "/credits/merchant/early_repayment/congrats"(platform: "/", type: TrackType.View) {
        products_group
        payment_type(
            type: PropertyType.String,
            required: false,
            values: [
                'total',
                'partial'
            ],
            inheritable: false
        )
    }
    "/credits/merchant/early_repayment/active_early_repayment"(platform: "/", type: TrackType.View) {
        products_group
        payment_type(
            type: PropertyType.String,
            required: false,
            values: [
                'total',
                'partial'
            ],
            inheritable: false
        )
    }
    "/credits/merchant/early_repayment/error"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: false,
            inheritable: false
        )
        products_group
        payment_type(
            type: PropertyType.String,
            required: false,
            values: [
                'total',
                'partial'
            ],
            inheritable: false
        )
    }

    /******************************************
     *       End: Merchants Administrator
     ******************************************/

    /******************************************
     *       Start: Credits Hub
     *******************************************/

    "/credits/mp-hub"(platform: "/", type: TrackType.View) {
        user_type(
            type: PropertyType.String,
            required: true,
            description: "User status when entering hub",
            values: [
                'mixed',
                'no_credit_line'
            ],
            inheritable: false,
        )
    }

    "/credits/mp-hub/redirect"(platform: "/", type: TrackType.View) {
        user_status(
            type: PropertyType.String,
            required: true,
            description: "User status at the moment it was redirected",
            values: [
                'fixed_term_loan_collect',
                'sales_percentage_loan_collect',
                'express_money_collect',
                'personal_loan_collect',
                'consumer_loan_collect',
                'fixed_term_loan_prior_to_collect',
                'sales_percentage_loan_prior_to_collect',
                'express_money_prior_to_collect',
                'personal_loan_prior_to_collect',
                'consumer_loan_prior_to_collect',
                'fixed_term_loan_adoption',
                'sales_percentage_loan_adoption',
                'express_money_adoption',
                'personal_loan_adoption',
                'express_money_on_time',
                'fixed_term_loan_on_time',
                'sales_percentage_loan_on_time',
                'personal_loan_on_time',
                'consumer_loan_on_time',
                'sales_percentage_loan_finished',
                'fixed_term_loan_finished',
                'express_money_finished',
                'personal_loan_finished',
                'consumer_loan_finished',
                'consumer_loan_adoption',
                'unknown',
            ]
        )
    }

    "/credits/mp-hub/access_click"(platform: "/", type: TrackType.Event) {
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

    "/credits/mp-hub/stop"(platform: "/", type: TrackType.View) {
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

    "/credits/mp-hub/stop/faqs_click"(platform: "/", type: TrackType.Event) {
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

    "/credits/merchant/open_market/statements_upload"(platform: "/", type: TrackType.Event) {}

    "/credits/merchant/open_market/statements_upload_click"(platform: "/", type: TrackType.Event) {}

    "/credits/merchant/open_market/statements_upload/error"(platform: "/", type: TrackType.Event) {
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

    "/credits/merchant/open_market/no_upsell_click"(platform: "/", type: TrackType.Event) {}

    "/credits/merchant/open_market/how_to_download_click"(platform: "/", type: TrackType.Event) {}

    "/credits/merchant/open_market/congrats"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true,
            description: "From which sub-flow was congrats accessed",
            values: [
                'financial_files',
                'financial_scraping',
            ]
        )
        provider(
            type: PropertyType.String,
            required: false,
            description: "Which provider was choosen to share information",
            values: [
                'quanto',
                'open_finance',
                'unknown',
            ]
        )
    }

    "/credits/merchant/open_market/financial_scraping_click"(platform: "/", type: TrackType.Event) {
        provider(
            type: PropertyType.String,
            required: true,
            description: "Which provider was choosen to share information",
            values: [
                'quanto',
                'open_finance',
            ]
        )
    }

    "/credits/merchant/open_market/financial_scraping_started"(platform: "/", type: TrackType.Event) {
        provider(
            type: PropertyType.String,
            required: true,
            description: "Which provider was choosen to share information",
            values: [
                'quanto',
                'open_finance',
            ]
        )
    }

    "/credits/merchant/open_market/financial_scraping_error"(platform: "/", type: TrackType.Event) {
        reason(
            type: PropertyType.String,
            required: true,
            description: "Quanto integration error",
            values: [
                'integration_error',
                'generic',
            ]
        )
    }

    "/credits/merchant/open_market/financial_scraping_message_shown"(platform: "/", type: TrackType.Event) {
        reason(
            type: PropertyType.String,
            required: true,
            description: "Quanto integration message",
            values: [
                'finished_flow',
                'finished_session',
                'not_available',
            ]
        )
    }

    "/credits/merchant/open_market/stop"(platform: "/", type: TrackType.View) {
        reason(
            type: PropertyType.String,
            required: true,
            description: "From which sub-flow was stop page accessed",
            values: [
                'financial_files',
                'financial_scraping',
                'finished_flow',
            ]
        )
    }

    "/credits/merchant/open_market/loans_faqs_click"(platform: "/", type: TrackType.Event) {}

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
        source_tracking
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
        loan_status_detail(
            description: "The detail of status of the created loan",
            type: PropertyType.String,
            required: false,
        )
        loan_request_status(
            description: "The status of the created loan request",
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
        require_optin(
            description: "User required opt ins flow",
            type: PropertyType.Boolean,
            required: false,
        )
    }

    //Error
    "/credits/merchant/enrollment/error"(platform: "/", type: TrackType.View) {
        reason(
            description: "Error reason",
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
                'loan_request_is_null',
                'default'
            ],
            inheritable: false
        )
    }

    "/credits/merchant/enrollment/info"(platform: "/mobile", type: TrackType.View) {
        reason(
                description: "State reason",
                type: PropertyType.String,
                required: true,
                values: [
                        'already_taken_credit_line',
                        "no_credit_lines_present"
                ]
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
        campaign_id(
            description: "Custom landing campaign",
            type: PropertyType.String,
            required: false,
            values: [
                'amount_and_fee_improvement',
                'amount_and_term_improvement',
                'amount_improvement',
                'fee_improvement',
                'term_improvement'
            ]
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
        require_optin(
            description: "User required opt ins flow",
            type: PropertyType.Boolean,
            required: false,
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

    //Access
    "/credits/merchant/enrollment/capped_access"(platform: "/", type: TrackType.Event) {
        context(
            description: "Section from which the user accesses the capped form",
            type: PropertyType.String,
            required: true,
            values: [
                'hero_card',
                'upsell_offer',
            ],
            inheritable: false
        )
    }

    "/credits/merchant/enrollment/open_market_access"(platform: "/", type: TrackType.Event) {
        context(
            description: "Section from which the user accesses the open market landing",
            type: PropertyType.String,
            required: true,
            values: [
                'simulator',
                'upsell_offer',
            ],
            inheritable: false
        )
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
        release_attemps_number(
                description: "Number of attemps to release the advance",
                type: PropertyType.Numeric,
                required: false,
        )
    }

    //Congrats money advance mobile
    "/credits/merchant/money_advance/congrats"(platform: "/mobile", type: TrackType.View) {
        offer(
                description: "User has express money offer",
                type: PropertyType.String,
                required: false,
                values: [
                        'none',
                        'express_money'
                ]
        )
    }

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
    "/credits/merchant/money_advance/summary"(platform: "/", type: TrackType.View) {
        from(
            description: "Request Origin (could be from same flow or not)",
            type: PropertyType.String,
            required: false,
            values: [
                'default',
                'withdraw',
            ]
        )
    }

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

    "/credits/express_money"(platform: "/mobile", type: TrackType.View) {
        source_tracking
    }

    "/credits/express_money/amount_input"(platform: "/", type: TrackType.View) {
        show_onboarding(
            description: "Metric to track onboarding modal conversion",
            type: PropertyType.Boolean,
            required: false,
            inheritable: false
        )
        default_amount(
                description: "Default requested amount",
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
        default_payment_term(
                description: "Default payment term selected",
                type: PropertyType.String,
                required: false,
        )
        payment_terms(
                description: "Available payment terms",
                type: PropertyType.ArrayList,
                required: false,
        )
    }

    "/credits/express_money/amount_input/simulation"(platform: "/mobile", type: TrackType.View) {
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
        default_payment_term(
                description: "Default payment term selected",
                type: PropertyType.String,
                required: true,
        )
    }

    "/credits/express_money/amount_input/simulation"(platform: "/", type: TrackType.Event) {
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
        default_payment_term(
                description: "Default payment term selected",
                type: PropertyType.String,
                required: true,
        )
    }

    "/credits/express_money/amount_input/term_option"(platform: "/web", type: TrackType.Event) {
        selected_payment_term(
                description: "Payment term selected",
                type: PropertyType.String,
                required: true,
        )
    }

    "/credits/express_money/summary"(platform: "/web", type: TrackType.View) {
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
        default_payment_term(
                description: "Default payment term selected",
                type: PropertyType.String,
                required: false,
        )
        selected_payment_term(
                description: "Payment term selected",
                type: PropertyType.String,
                required: false,
        )
        payment_terms(
                description: "Available payment terms",
                type: PropertyType.ArrayList,
                required: false,
        )
    }

    "/credits/express_money/summary"(platform: "/mobile", type: TrackType.View) {
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
        default_payment_term(
                description: "Default payment term selected",
                type: PropertyType.String,
                required: false,
        )
        selected_payment_term(
                description: "Payment term selected",
                type: PropertyType.String,
                required: false,
        )
        payment_terms(
                description: "Available payment terms",
                type: PropertyType.ArrayList,
                required: false,
        )
        default_amount(
                description: "Default requested amount",
                type: PropertyType.Numeric,
                required: true,
        )
        require_optin(
                description: "User required opt ins flow",
                type: PropertyType.Boolean,
                required: false,
        )
    }

    "/credits/express_money/congrats"(platform: "/web", type: TrackType.View) {
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
        default_payment_term(
                description: "Default payment term selected",
                type: PropertyType.String,
                required: false,
        )
        selected_payment_term(
                description: "Payment term selected",
                type: PropertyType.String,
                required: false,
        )
        payment_terms(
                description: "Available payment terms",
                type: PropertyType.ArrayList,
                required: false,
        )
    }

    "/credits/express_money/congrats"(platform: "/mobile", type: TrackType.View) {
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
        default_payment_term(
                description: "Default payment term selected",
                type: PropertyType.String,
                required: false,
        )
        selected_payment_term(
                description: "Payment term selected",
                type: PropertyType.String,
                required: false,
        )
        payment_terms(
                description: "Available payment terms",
                type: PropertyType.ArrayList,
                required: false,
        )
        default_amount(
                description: "Default requested amount",
                type: PropertyType.Numeric,
                required: true,
        )
        require_optin(
                description: "User required opt ins flow",
                type: PropertyType.Boolean,
                required: false,
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
                'create_express_money_validation',
                'ext_bank_rejected',
                'origination_error',
                'bad_request',
                'credit_option_not_found',
                'repeated_request',
                'gateway_timeout',
                'date_validation',
                'internal_error',
                'concurrency_error',
                'update_credit_line_error',
                'invalid_first_due_date',
                'insufficient_credit_balance',
                'conflict',
                'external_api_error',
                'payment_rejected'
            ]
        )
    }

    "/credits/express_money/info"(platform: "/", type: TrackType.View) {
        reason(
            description: "State reason",
            type: PropertyType.String,
            required: true,
            values: [
                'no_credit_lines_present',
                'already_taken_credit_line'
            ]
        )
    }

    "/credits/express_money/kyc_onboarding"(platform: "/web", type: TrackType.View) { }

    "/credits/express_money/kyc_onboarding"(platform: "/mobile", type: TrackType.View) {
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

    "/credits/express_money/onboarding"(platform: "/mobile", type: TrackType.View) { }

    /******************************************
     *   End: Express money
     ******************************************/

     /******************************************
     *    Start: Self service
     ******************************************/
    "/credits/self_service/promises/create_form"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer, mix or no credit)",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix",
                "no_credit"
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
            description: "User type (merchant, consumer, mix or no credit)",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix",
                "no_credit"
            ]
        )
    }

    "/credits/self_service/promises/error"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer, mix or no credit)",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix",
                "no_credit"
            ]
        )
    }

    "/credits/self_service/promises/view"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer, mix or no credit)",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix",
                "no_credit"
            ]
        )
    }

    "/credits/self_service/debt_relief"(platform: "/", type: TrackType.View) {
        user_type(
            required: true,
            description: "User type (merchant, consumer or mix)",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix"
            ]
        )
    }

    "/credits/self_service/debt_relief/summary"(platform: "/", type: TrackType.View) {
            bulk_amount(
                required: true,
                description: "Bulk amount of the debt relief proposed by the user",
                type: PropertyType.Numeric
            )
            total_amount(
                required: true,
                description: "Total debt amount",
                type: PropertyType.Numeric
            )
            min_amount(
                required: false,
                description: "Total debt amount",
                type: PropertyType.Boolean
            )
        }

    "/credits/self_service/debt_relief/accept_summary"(platform: "/", type: TrackType.Event) {
            bulk_amount(
                required: true,
                description: "Bulk amount of the debt relief proposed by the user",
                type: PropertyType.Numeric
            )
            total_amount(
                required: true,
                description: "Total debt amount",
                type: PropertyType.Numeric
            )
            installments_id(
                required: true,
                description: "Array of Installments reached by the punitive condonation",
                type: PropertyType.ArrayList
            )
            debt_relief_amount(
                required: true,
                description: "final Debt relief amount",
                type: PropertyType.Numeric
            )
        }

    "/credits/self_service/debt_relief/error"(platform: "/", type: TrackType.View) {
        error_type(
                required: true,
                description: "Error type message",
                type: PropertyType.String,
                values: [
                    "no_offer",
                    "not_found",
                    "unknown",
                    "invalid_offer_first_attempt",
                    "invalid_offer_second_attempt",
                    "invalid_offer_three_or_more_attempts",
                ]
            )
        user_type(
            required: true,
            description: "User type (merchant, consumer, mix or no credit)",
            type: PropertyType.String,
            values: [
                "merchant",
                "consumer",
                "mix",
                "no_credit"
            ]
        )
    }
     /******************************************
     *    End: Self service
     ******************************************/

}
