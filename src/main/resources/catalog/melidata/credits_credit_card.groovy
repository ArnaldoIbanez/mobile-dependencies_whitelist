package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1205"

    def amount_input_data = objectSchemaDefinitions {
        amount(
            description: "The amount that the user want to pay",
            type: PropertyType.Numeric,
            required: true
        )
        statement_min_amount(
            description: "The minimum amount that the user must pay",
            type: PropertyType.Numeric,
            required: true
        )
        statement_max_amount(
            description: "The current statement amount",
            type: PropertyType.Numeric,
            required: true
        )
        account_total_amount(
            description: "The user total debt",
            type: PropertyType.Numeric,
            required: true
        )
    }

    def payment_plan_data = objectSchemaDefinitions {
        payment_plan_number(
            description: "The payment plan option that was selected",
            type: PropertyType.Numeric,
            required: true
        )
        min_payment_plan(
            description: "The minimum option available to select",
            type: PropertyType.Numeric,
            required: true
        )
        max_payment_plan(
            description: "The maximum option available to select",
            type: PropertyType.Numeric,
            required: true
        )
    }

    def offer_data = objectSchemaDefinitions {
        scoring(
            description: "User reputation level",
            type: PropertyType.String,
            required: true,
        )
    }

    propertyDefinitions {
        offer(
            type: PropertyType.Map(offer_data),
            required: true
        )
        amount_input(
            type: PropertyType.Map(amount_input_data),
            required: false
        )
        payment_plan(
            type: PropertyType.Map(payment_plan_data),
            required: false
        )
        statement_status(
            description: "Status from the user's statement",
            type: PropertyType.String,
            required: true,
            values: [
                "closed",
                "open",
                "overdue"
            ]
        )
        payment_option(
            description: "How the user pays",
            type: PropertyType.String,
            required: true,
            values: [
                "more_than_total",
                "partial",
                "payment_plan",
                "total",
                "total_account"
            ]
        )
    }

    propertyGroups {
        payment_group(offer, statement_status)
        full_payment_group(offer, statement_status, payment_option, amount_input, payment_plan)
    }

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/credit_card"(platform: "/", isAbstract: true) {}
    "/credits/credit_card/payment"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start: Credit Card Payment
     ******************************************/
    //Hub
    "/credits/credit_card/payment/hub"(platform: "/", type: TrackType.View) {
        payment_group
    }

    "/credits/credit_card/payment/total_payment_action"(platform: "/", type: TrackType.Event) {
        amount(
            description: "Statement amount",
            type: PropertyType.Numeric,
            required: true
        )
    }

    //Payment plan
    "/credits/credit_card/payment/payment_plan_selection"(platform: "/", type: TrackType.View) {
        payment_group
    }

    //Amount input
    "/credits/credit_card/payment/amount_input"(platform: "/", type: TrackType.View) {
        payment_group
    }

    //Summary
    "/credits/credit_card/payment/summary"(platform: "/", type: TrackType.View) {
        full_payment_group
    }

    "/credits/credit_card/payment/payment_action"(platform: "/", type: TrackType.Event) {
        full_payment_group
    }
    /******************************************
     *       End: Credit Card Payment
     ******************************************/


}