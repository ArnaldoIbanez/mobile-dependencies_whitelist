package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1204"

    propertyDefinitions {
        installments_qty( type: PropertyType.Numeric, required: true, description: "The total number of installments to pay")
    }

     propertyGroups {
        installments_group(installments_qty)
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/credits/pursue"(platform: "/", isAbstract: true) {}
    "/credits/consumer/myml"(platform: "/", isAbstract: true) {}
    "/credits/consumer/myml/summary"(platform: "/", isAbstract: true) {}
    "/credits/consumer/my_account"(platform: "/", isAbstract: true) {}
    "/credits/consumer/opensea"(platform: "/", isAbstract: true) {}
    "/credits/self_service"(platform: "/", isAbstract: true) {}
    "/credits/self_service/promises"(platform: "/", isAbstract: true) {}
    "/credits/self_service/debt-relief"(platform: "/", isAbstract: true) {}
    "/credits/car_loan"(platform: "/", isAbstract: true) {}

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
                           "invalid_offer",
                           "unknown",
                       ]
                   )
               }
     /******************************************
     *    End: Self service
     ******************************************/

    /******************************************
    *    Start: Car Loan
    ******************************************/
    //Views
    "/credits/car_loan/contact"(platform: "/", type: TrackType.View) {
        push_variant(
            required: true,
            description: "Identifier for the flow of the push A, B or C",
            type: PropertyType.String
        )
    }
    //Events
    "/credits/car_loan/contact/confirm"(platform: "/", type: TrackType.Event) {
        push_variant(
            required: true,
            description: "Identifier for the flow of the push A, B or C",
            type: PropertyType.String
        )
    }
    /******************************************
    *    End: Car Loan
    ******************************************/
}
