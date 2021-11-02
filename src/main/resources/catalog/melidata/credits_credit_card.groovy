package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1205"

    def proposal_data = objectSchemaDefinitions {
        rating(
            description: "User reputation level",
            type: PropertyType.String,
            required: true
        )
    }

    propertyDefinitions {
        is_card_active(
            description: "Status of the user's card",
            type: PropertyType.Boolean,
            required: false
        )
        proposal(
                type: PropertyType.Map(proposal_data),
                required: true
        )

        bucket(
            description: "Payment due date chosen",
            type: PropertyType.Numeric,
            required: true
        )
    }

    propertyGroups {
        upgrade_info(proposal, is_card_active)
        bucket_group(bucket)
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits/credit_card/upgrade"(platform: "/", isAbstract: true) {}


    /***********************************************
     *       Start: Credit Card Upgrade
     ***********************************************/
    // Onboarding
    "/credits/credit_card/upgrade/onboarding"(platform: "/", type: TrackType.View) {
        upgrade_info
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: false)
        from(
                description: "Indicates where the onboarding flow was accessed from",
                type: PropertyType.String,
                required: true
        )
    }

    "/credits/credit_card/upgrade/onboarding/change_page"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        upgrade_info
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: true)
    }

    // Payment due date selection
    "/credits/credit_card/upgrade/payment_due_date_selection"(platform: "/", type: TrackType.View) {
        upgrade_info
        buckets(
            description: "Payment due date options",
            type: PropertyType.ArrayList(PropertyType.Numeric),
            required: true
        )
    }

    // Summary
    "/credits/credit_card/upgrade/summary"(platform: "/", type: TrackType.View) {
        upgrade_info
        bucket_group
        limit(
            description: "User's card limit",
            type: PropertyType.Numeric,
            required: true
        )
        annuity_cost(
            description: "User's card annuity cost",
            type: PropertyType.Numeric,
            required: true
        )
    }

    "/credits/credit_card/upgrade/summary/payment_due_date_selection_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        bucket_group
    }

    // Congrats
    "/credits/credit_card/upgrade/congrats"(platform: "/", type: TrackType.View) {
        upgrade_info
        status(
            description: "Status from the user's upgrade request",
            type: PropertyType.String,
            required: true,
            values: [
                "approved",
                "pending",
                "rejected"
            ]
        )
        congrats_status(
                description: "Status for the congrats's view",
                type: PropertyType.String,
                required: true,
                values: [
                        "linked_card",
                        "not_linked_card",
                        "physical_not_requested",
                        "kyc_user_in_review"
                ]
        )
        from(
                description: "Indicates where the upgrade congrats flow was accessed from",
                type: PropertyType.String,
                required: true
        )
    }

    "/credits/credit_card/upgrade/congrats/promotion_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/credits/credit_card/upgrade/congrats/go_dashboard_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/credits/credit_card/upgrade/congrats/kyc_go_home"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/credits/credit_card/upgrade/congrats/physical_card_request"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        status(
                description: "Status from the physical card request",
                type: PropertyType.String,
                required: true,
                values: [
                        "approved",
                        "pending"
                ]
        )
    }

    "/credits/credit_card/upgrade/congrats/physical_card_unlock"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        status(
                description: "Status from the physical card unlock",
                type: PropertyType.String,
                required: true,
                values: [
                        "approved",
                        "pending"
                ]
        )
    }

    // Error
    "/credits/credit_card/upgrade/error"(platform: "/", type: TrackType.View) {
        reason(type: PropertyType.String, required: false)
    }

    // Stop page
    "/credits/credit_card/upgrade/stop_page"(platform: "/", type: TrackType.View) {
        reason(
                description: "Reason why the Card can't be upgraded",
                type: PropertyType.String,
                required: true,
                values: [
                        "no_proposal_match",
                        "invalid_proposal_status",
                        "kyc_not_compliant",
                        "physical_card_request",
                        "kyc_api_failed"
                ]
        )
    }

    "/credits/credit_card/upgrade/stop_page/redirect_to_dashboard"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        status(
                description: "Indicates the status and then redirect to the dashboard",
                type: PropertyType.String,
                required: true,
                values: [
                        "user_has_active_account"
                ]
        )
    }

    "/credits/credit_card/upgrade/stop_page/kyc_start_validations"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        status(
                description: "A KYC not compliant user starts validation flow",
                type: PropertyType.String,
                required: true,
                values: [
                        "kyc_not_compliant"
                ]
        )
    }

    "/credits/credit_card/upgrade/stop_page/physical_card_request_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        status(
                description: "Indicates the status and that the user requests a physical card",
                type: PropertyType.String,
                required: true,
                values: [
                        "physical_card_request"
                ]
        )
    }

    /*********************************************
     *       End: Credit Card Upgrade
     *********************************************/
}