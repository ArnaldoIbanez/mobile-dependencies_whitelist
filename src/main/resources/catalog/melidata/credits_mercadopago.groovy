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
     *       Start: Consumer Public Landings
     ******************************************/
    "/credits/consumer/public_landing"(platform: "/", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, inheritable: false, values: ["guest", "no_offer"])
        sk(description: "Source key", type: PropertyType.String, required: false)
    }
    /******************************************
     *       End: Consumer Public Landings
     ******************************************/

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
        promise(
            type: PropertyType.String,
            required: true,
            values: [
                'create_promise',
                'view_promise',
                'create_debt_relief',
                'view_debt_relief',
                'none',
            ],
            inheritable: false
        )
        show_cx_widget(
            type: PropertyType.Boolean,
            required: false,
            inheritable: false
        )
        accesses(
            description: "List of accesses shown to the user",
            type: PropertyType.ArrayList(accesses),
            required: false
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

    "/credits/merchant/administrator/history"(platform:"/", type: TrackType.View) {}

    "/credits/merchant/administrator/payment_history"(platform:"/", type: TrackType.View) {
        products_with_status
    }

    "/credits/merchant/administrator/inconsistency"(platform:"/mobile", type: TrackType.View) {
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
            inheritable: false
        )

        source_tracking
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
    }

    "/credits/merchant/open_market/financial_scraping_click"(platform: "/", type: TrackType.Event) {}

    "/credits/merchant/open_market/financial_scraping/error"(platform: "/", type: TrackType.Event) {
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

    "/credits/merchant/open_market/financial_scraping/message"(platform: "/", type: TrackType.Event) {
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
                'external_api_error'
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

    "/credits/express_money/onboarding"(platform: "/mobile", type: TrackType.View) { }

    /******************************************
     *   End: Express money
     ******************************************/

    /******************************************
     *   Start: Personal Loans Adoption
     ******************************************/
    "/credits/consumer/personal"(platform: "/mobile", type: TrackType.View) {}

    "/credits/consumer/personal/adoption"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: true)
        virtual_card(description: "Identifies if the user has virtual card", type: PropertyType.Boolean, required: false)
        physical_card(description: "Identifies if the user has physical card", type: PropertyType.Boolean, required: false)
    }

    "/credits/consumer/personal/adoption/onboarding"(platform: "/mobile", type: TrackType.View) {
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: true)
        sk(description: "Source key", type: PropertyType.String, required: false)
    }

    "/credits/consumer/personal/adoption/onboarding/go_simulation"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/onboarding/close"(platform: "/mobile", type: TrackType.Event) {
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: false)
    }

    "/credits/consumer/personal/adoption/simulator"(platform: "/mobile", type: TrackType.View) {
        sk(description: "Source key", type: PropertyType.String, required: false)
    }

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
    "/credits/consumer/administrator/detail"(platform: "/", type: TrackType.View) {
        loan_id(
                type: PropertyType.Numeric,
                description: "The id of the current loan",
                required: true,
                inheritable: false
        )
        next_installment_status(
                type: PropertyType.String,
                description: "Status of the closest to expire installment",
                required: true,
                inheritable: false,
                values: [
                        'on_time',
                        'to_expire_soft',
                        'to_expire_hard',
                        'expired_today',
                        'no_charge_period',
                        'fixed_charge_period_1',
                        'fixed_charge_period_2',
                        'daily_charge_period',
                        'paid'
                ])
    }
    "/credits/consumer/administrator/dashboard"(platform: "/", type: TrackType.View) {
        dashboard_status(type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
    }
    "/credits/consumer/administrator/summary"(platform: "/", type: TrackType.View) {
        summary_status(description: "Current status of the loan summary", type: PropertyType.String, required: true, values: ["empty_state", "on_time", "overdue"])
    }

    //Events
    "/credits/consumer/administrator/detail/see_loan_conditions"(platform: "/", type: TrackType.Event) {}

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
            type: PropertyType.ArrayList(PropertyType.String)
        )
        opt_in_separator(
                required: false,
                description: "It is only shown when user needs to allow notifications",
                type: PropertyType.String,
                values: [
                        "visible",
                        "not visible"
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
    "/credits/consumer/administrator_v2/dashboard/opt_in_wsp"(platform: "/", type: TrackType.Event) {
        status(
                required: true,
                description: "Define if user allows or not whatsapp notifications",
                type: PropertyType.Boolean,
        )
    }
    "/credits/consumer/administrator_v2/dashboard/payment_intention_all"(platform: "/mobile", type: TrackType.Event) {
        installments_group
        installments_qty(
                type: PropertyType.Numeric,
                description: "Tne number of the installments to pay",
                required: true,
                inheritable: false
        )
        advance_installment(
            required: false,
            description: "User wanted to pay in advance and was redirected to CX widget",
            type: PropertyType.Boolean,
        )
    }
    "/credits/consumer/administrator_v2/details_button"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/choose_installments"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_help"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_help/how_to_pay_installments"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_personal_loan"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_uses_modal"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_how_to_use_modal"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/cx_contact"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_shopping"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/get_educative"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_mp"(platform: "/mobile", type: TrackType.Event) {
        has_mp(type: PropertyType.Boolean, required: true)
    }
    "/credits/consumer/administrator_v2/dashboard/close_mp_modal"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_store_mp"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/dashboard/go_installments_detail"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/error_message/button_pressed"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/administrator_v2/promises"(platform: "/mobile", isAbstract: true) {}
    "/credits/consumer/administrator_v2/promises/create"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/promises/view"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/debt_relief"(platform: "/mobile", isAbstract: true) {}
    "/credits/consumer/administrator_v2/debt_relief/create"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/administrator_v2/payment_not_credited"(platform: "/mobile", type: TrackType.Event) {}

    //Event PX Congrats Extra Component
    "/credits/consumer/administrator_v2/dashboard/opt_in_wsp_px_access"(platform: "/mobile", type: TrackType.Event) {}

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
     *    Start: Consumers Early Repayments FLow
     ******************************************/
    "/credits/consumer/early_repayments"(platform: "/", type: TrackType.View) {
        total_amount(
            required: false,
            description: "total installments amount",
            type: PropertyType.Numeric
        )
        total_amount_with_discount(
            required: false,
            description: "total amount offerted to user",
            type: PropertyType.Numeric
        )
        total_discount(
            required: false,
            description: "Total discount",
            type: PropertyType.Numeric
        )
        installments_ids(
            required: false,
            description: "Array of Installments",
            type: PropertyType.ArrayList
        )
    }

    "/credits/consumer/early_repayments/success"(platform: "/", type: TrackType.View) {}

    "/credits/consumer/early_repayments/error"(platform: "/", type: TrackType.View) {}

    "/credits/consumer/early_repayments/warning"(platform: "/", type: TrackType.View) {}

    "/credits/consumer/early_repayments/accept"(platform: "/", type: TrackType.Event) {
        total_amount(
            required: false,
            description: "total installments amount",
            type: PropertyType.Numeric
        )
        total_amount_with_discount(
            required: false,
            description: "total amount offerted to user",
            type: PropertyType.Numeric
        )
        total_discount(
            required: false,
            description: "Total discount",
            type: PropertyType.Numeric
        )
        installments_ids(
            required: false,
            description: "Array of Installments",
            type: PropertyType.ArrayList
        )
    }

     /******************************************
     *    End: Consumers Early Repayments FLow
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
