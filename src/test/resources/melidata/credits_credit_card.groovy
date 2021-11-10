package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    def account_rating_a = [
        rating: "A"
    ]

    def account_rating_b = [
            rating: "B"
    ]

    test("Credits Credit Card - Upgrade tests") {
        /***********************************************
         *       Start: Credit Card Upgrade
         ***********************************************/

        def congrats_approved_status = "approved"
        def congrats_pending_status = "pending"
        def congrats_rejected_status = "rejected"
        def congrats_status_linked = "linked_card"
        def congrats_status_not_linked = "not_linked_card"
        def congrats_status_not_requested = "physical_not_requested"
        def congrats_status_kyc_user_in_review = "kyc_user_in_review"
        def congrats_status_physical_card_shipped = "physical_card_shipped"
        def stop_page_no_proposal = "no_proposal_match"
        def stop_page_invalid_proposal = "invalid_proposal_status"
        def stop_page_kyc_not_compliant = "kyc_not_compliant"
        def stop_page_physical_card_request = "physical_card_request"
        def stop_page_kyc_api_failed = "kyc_api_failed"
        def stop_page_already_active = "user_has_active_account"
        def hybrid_dashboard_source = "hybrid-dashboard"
        def facebook_source = "facebook"

        // Onboarding MP
        "/credits/credit_card/upgrade/onboarding"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_b
            is_card_active = true
            page = 1
            from = hybrid_dashboard_source
        }

        "/credits/credit_card/upgrade/onboarding/change_page"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            proposal = account_rating_b
            is_card_active = true
            page = 2
        }

        // Onboarding ML
        "/credits/credit_card/upgrade/onboarding"(platform: "/", type: TrackType.View) {
            proposal = account_rating_b
            is_card_active = true
            page = 1
            from = hybrid_dashboard_source
        }

        "/credits/credit_card/upgrade/onboarding/change_page"(platform: "/", type: TrackType.Event) {
            proposal = account_rating_b
            is_card_active = true
            page = 2
        }

        // Payment due date selection ML
        "/credits/credit_card/upgrade/payment_due_date_selection"(platform: "/", type: TrackType.View) {
            proposal = account_rating_b
            is_card_active = true
            buckets = [1, 15, 25]
        }

        // Payment due date selection MP
        "/credits/credit_card/upgrade/payment_due_date_selection"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_b
            is_card_active = true
            buckets = [1, 15, 25]
        }

        // Summary ML
        "/credits/credit_card/upgrade/summary"(platform: "/", type: TrackType.View) {
            proposal = account_rating_b
            is_card_active = true
            bucket = 15
            limit = 2000
            annuity_cost = 150
        }

        "/credits/credit_card/upgrade/summary/payment_due_date_selection_action"(platform: "/", type: TrackType.Event) {
            bucket = 15
        }

        // Summary MP
        "/credits/credit_card/upgrade/summary"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_b
            is_card_active = true
            bucket = 15
            limit = 2000
            annuity_cost = 150
        }

        "/credits/credit_card/upgrade/summary/payment_due_date_selection_action"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            bucket = 15
        }

        // Congrats ML
        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            proposal = account_rating_b
            is_card_active = true
            status = congrats_approved_status
            congrats_status = congrats_status_linked
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            proposal = account_rating_b
            is_card_active = true
            status = congrats_approved_status
            congrats_status = congrats_status_not_linked
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            proposal = account_rating_b
            is_card_active = true
            status = congrats_approved_status
            congrats_status = congrats_status_not_requested
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_pending_status
            congrats_status = congrats_status_linked
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_pending_status
            congrats_status = congrats_status_not_linked
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_pending_status
            congrats_status = congrats_status_not_requested
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_rejected_status
            congrats_status = congrats_status_not_requested
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_pending_status
            congrats_status = congrats_status_kyc_user_in_review
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_approved_status
            congrats_status = congrats_status_physical_card_shipped
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_pending_status
            congrats_status = congrats_status_physical_card_shipped
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats/promotion_action"(platform: "/", type: TrackType.Event) {}

        "/credits/credit_card/upgrade/congrats/go_dashboard_action"(platform: "/", type: TrackType.Event) {}

        "/credits/credit_card/upgrade/congrats/kyc_go_home"(platform: "/", type: TrackType.Event) {}

        "/credits/credit_card/upgrade/congrats/physical_card_request"(platform: "/", type: TrackType.Event) {
            status = congrats_approved_status
        }

        "/credits/credit_card/upgrade/congrats/physical_card_request"(platform: "/", type: TrackType.Event) {
            status = congrats_pending_status
        }

        "/credits/credit_card/upgrade/congrats/physical_card_unlock"(platform: "/", type: TrackType.Event) {
            status = congrats_approved_status
        }

        "/credits/credit_card/upgrade/congrats/physical_card_unlock"(platform: "/", type: TrackType.Event) {
            status = congrats_pending_status
        }

        // Congrats MP
        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_b
            is_card_active = true
            status = congrats_approved_status
            congrats_status = congrats_status_linked
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_b
            is_card_active = true
            status = congrats_approved_status
            congrats_status = congrats_status_not_linked
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_b
            is_card_active = true
            status = congrats_approved_status
            congrats_status = congrats_status_not_requested
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_pending_status
            congrats_status = congrats_status_linked
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_pending_status
            congrats_status = congrats_status_not_linked
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_pending_status
            congrats_status = congrats_status_not_requested
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_rejected_status
            congrats_status = congrats_status_not_requested
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            proposal = account_rating_a
            is_card_active = true
            status = congrats_pending_status
            congrats_status = congrats_status_kyc_user_in_review
            from = facebook_source
        }

        "/credits/credit_card/upgrade/congrats/promotion_action"(platform: "/", type: TrackType.Event, business: 'mercadopago') {}

        "/credits/credit_card/upgrade/congrats/go_dashboard_action"(platform: "/", type: TrackType.Event, business: 'mercadopago') {}

        "/credits/credit_card/upgrade/congrats/kyc_go_home"(platform: "/", type: TrackType.Event, business: 'mercadopago') {}

        "/credits/credit_card/upgrade/congrats/physical_card_request"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = congrats_approved_status
        }

        "/credits/credit_card/upgrade/congrats/physical_card_request"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = congrats_pending_status
        }

        "/credits/credit_card/upgrade/congrats/physical_card_unlock"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = congrats_approved_status
        }

        "/credits/credit_card/upgrade/congrats/physical_card_unlock"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = congrats_pending_status
        }

        "/credits/credit_card/upgrade/congrats/go_virtual_credit_card"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = congrats_approved_status
        }

        "/credits/credit_card/upgrade/congrats/go_virtual_credit_card"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = congrats_pending_status
        }

        "/credits/credit_card/upgrade/congrats/go_physical_card_shipment_tracking"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = congrats_approved_status
        }

        "/credits/credit_card/upgrade/congrats/go_physical_card_shipment_tracking"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = congrats_pending_status
        }

        "/credits/credit_card/upgrade/congrats/physical_card_request_in_unlock"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = congrats_approved_status
        }

        "/credits/credit_card/upgrade/congrats/physical_card_request_in_unlock"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = congrats_pending_status
        }

        // Error ML
        "/credits/credit_card/upgrade/error"(platform: "/", type: TrackType.View) {
            reason = "Network error"
        }

        // Error MP
        "/credits/credit_card/upgrade/error"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            reason = "Network error"
        }

        // Stop page ML
        "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View) {
            reason = stop_page_no_proposal
        }

        "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View) {
            reason = stop_page_invalid_proposal
        }

        "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View) {
            reason = stop_page_kyc_not_compliant
        }
        "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View) {
            reason = stop_page_physical_card_request
        }
        "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View) {
            reason = stop_page_kyc_api_failed
        }

        "/credits/credit_card/upgrade/stop_page/redirect_to_dashboard"(platform: "/", type: TrackType.Event) {
            status = stop_page_already_active
        }

        "/credits/credit_card/upgrade/stop_page/kyc_start_validations"(platform: "/", type: TrackType.Event) {
            status = stop_page_kyc_not_compliant
        }

        "/credits/credit_card/upgrade/stop_page/physical_card_request_action"(platform: "/", type: TrackType.Event) {
            status = stop_page_physical_card_request
        }

        // Stop page MP
        "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            reason = stop_page_no_proposal
        }

        "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            reason = stop_page_invalid_proposal
        }

        "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            reason = stop_page_kyc_not_compliant
        }
        "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            reason = stop_page_physical_card_request
        }
        "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View, business: 'mercadopago') {
            reason = stop_page_kyc_api_failed
        }

        "/credits/credit_card/upgrade/stop_page/redirect_to_dashboard"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = stop_page_already_active
        }

        "/credits/credit_card/upgrade/stop_page/kyc_start_validations"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = stop_page_kyc_not_compliant
        }

        "/credits/credit_card/upgrade/stop_page/physical_card_request_action"(platform: "/", type: TrackType.Event, business: 'mercadopago') {
            status = stop_page_physical_card_request
        }

        /*********************************************
         *       End: Credit Card Upgrade
         *********************************************/
    }
}