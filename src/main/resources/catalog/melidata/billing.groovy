package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1014"

    //Billing
    "/billing"(type: TrackType.View, isAbstract: true) {}
    "/billing/summary"(platform: "/") {
        bills_to_pay(type: PropertyType.Numeric, required: true)
        total_debt(type: PropertyType.Numeric, required: true)
        has_automatic_debit(type: PropertyType.Boolean, required: true)
        is_subscription_user(type: PropertyType.Boolean, required: true)
        type(type: PropertyType.String, required: false, description: "Indicates the type of tracked event")
    }
    "/billing/detail"(platform: "/") {
        bill_exp_date(type: PropertyType.Numeric, required: false, description: "Bill Expiration date in format YYYYMMDD")
        has_cancelled_payments(type: PropertyType.Boolean, required: true, description: "Indicates if bill has cancelled payments")
        has_debt(type: PropertyType.Boolean, required: true, description: "Indicates if the bill has an amount to pay")
        has_taxes(type: PropertyType.Boolean, required: true, description: "Indicates if the bill has taxes charges")
        is_expired_bill(type: PropertyType.Boolean, required: true, description: "Indicates if the expiration date of the bill is earlier than the current date")
        is_open_bill(type: PropertyType.Boolean, required: true, description: "Indicates if is an open bill")
        is_paid_bill(type: PropertyType.Boolean, required: true, description: "Indicates if is a paid bill")
        user_can_pay(type: PropertyType.Boolean, required: true, description: "Indicates if the user can pay the bill")
        type(type: PropertyType.String, required: false, description: "Indicates the type of tracked event")
    }
     "/billing/reports"(platform: "/") {
        type(type: PropertyType.String, required: false, description: "Indicates the type of tracked event")
    }
    "/billing/legal_documents"(platform: "/") {
        type(type: PropertyType.String, required: false, description: "Indicates the type of tracked event")
    }
}
