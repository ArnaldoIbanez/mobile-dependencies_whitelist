import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    propertyDefinitions {
        flow_id (type: PropertyType.String, required: true, description: "Flow ID")
        product (type: PropertyType.String, required: true, description: "Product identifier")
        currency (type: PropertyType.String, required: true, description: "ISO Currency")
        price (type: PropertyType.Numeric, required: true, description: "Price of device")
        discount_code (type: PropertyType.String, required: true, description: "Discount code")
        is_guest (type: PropertyType.Boolean, required: true, description: "User logged as guest")
        e2e_test (type: PropertyType.Boolean, required: true, description: "e2e Test")
    }

    propertyGroups {
        groupCheckoutProperties(flow_id, product, currency, price, discount_code, is_guest, e2e_test)
    }

    "/point/buyingflow"(platform: "/", isAbstract: true, initiative : "1046") {}

    "/point/buyingflow/start"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
        has_coupon (type: PropertyType.Boolean, required: false, description: "Flag to detect if a sell has coupon")
    }

    "/point/buyingflow/shipping_options"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/new_address"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment_methods"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
        has_account_money (type: PropertyType.Boolean, required: false, description: "Flag that shows if the user has enough money in account")
        has_consumer_credits (type: PropertyType.Boolean, required: false, description: "Flag that shows if the user has credit balance")
    }

    "/point/buyingflow/payment_ticket_info"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment_installments"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment_installments/installments"(platform: "/", type: TrackType.Event) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment_bank_selector"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment_new_card"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment_card_security_code"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment_review"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
        selected_payment_method_id (type: PropertyType.String, required: false, description: "Selected payment method ID")
        selected_payment_method_type (type: PropertyType.String, required: false, description: "Selected payment method type, ex: credit card")
        installments (type: PropertyType.Numeric, required: false, description: "Selected installments")
    }

    "/point/buyingflow/error"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
        error_code (type: PropertyType.Numeric, required: true, description: "Error code")
    }

    "/point/buyingflow/payment_rejected"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
        selected_payment_method_id (type: PropertyType.String, required: true, description: "Selected payment method ID")
        selected_payment_method_type (type: PropertyType.String, required: false, description: "Selected payment method type, ex: credit card")
        installments (type: PropertyType.Numeric, required: false, description: "Selected installments")
    }

    "/point/buyingflow/payment_review/confirm_purchase"(platform: "/", type: TrackType.Event) {
        groupCheckoutProperties
    }

    "/point/buyingflow/invalid_address"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/complete_phone"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/complete_card_data"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/sim_card"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/xsell"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/regret"(platform: "/", type: TrackType.View) {}

}
