import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    def utmProperties = objectSchemaDefinitions {
        utm_campaign(required: false, type: PropertyType.String, description: "UTM campaign given")
        utm_medium(required: false, type: PropertyType.String, description: "UTM medium given")
        utm_source(required: false, type: PropertyType.String, description: "UTM source given")
    }

    propertyDefinitions {
        flow_id (type: PropertyType.String, required: true, description: "Flow ID")
        product_id (type: PropertyType.String, required: true, description: "Product identifier")
        product (type: PropertyType.String, required: false, description: "Product Name")
        coupon_type (type: PropertyType.String, required: false, description: "Coupon type - Ex: mgm, organic", values: ["organic", "mgm", "resellers", "partners", "campaign"])
        currency (type: PropertyType.String, required: true, description: "ISO Currency")
        price (type: PropertyType.Numeric, required: true, description: "Price of device")
        discount_code (type: PropertyType.String, required: true, description: "Discount code")
        is_guest (type: PropertyType.Boolean, required: true, description: "User logged as guest")
        e2e_test (type: PropertyType.Boolean, required: true, description: "e2e Test")
        bunit (type: PropertyType.String, required: false, description: "business unit")
        ch (type: PropertyType.String, required: false, description: "sales channel")
        camp (type: PropertyType.String, required: false, description: "campaign")
        strategy (type: PropertyType.String, required: false, description: "strategy")
        utm (type: PropertyType.Map(utmProperties), required: false, description: "UTM info")
    }

    propertyGroups {
        groupCheckoutProperties(flow_id, product_id, product, coupon_type, currency, price, discount_code, is_guest, e2e_test, bunit, ch, camp, strategy, utm)
    }

    "/point/buyingflow"(platform: "/", isAbstract: true, initiative : "1262") {}
    "/point/buyingflow/shipping"(platform: "/", isAbstract: true) {}
    "/point/buyingflow/payment"(platform: "/", isAbstract: true) {}

    "/point/buyingflow/start"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
        has_coupon (type: PropertyType.Boolean, required: false, description: "Flag to detect if a sell has coupon")
    }

    "/point/buyingflow/shipping/options"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/shipping/new_address"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/shipping/new_address/goto_zipcode_finder"(platform: "/", type: TrackType.Event) {}
    
    "/point/buyingflow/shipping/zipcode_finder"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment/methods"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
        has_account_money (type: PropertyType.Boolean, required: false, description: "Flag that shows if the user has enough money in account")
        has_consumer_credits (type: PropertyType.Boolean, required: false, description: "Flag that shows if the user has credit balance")
    }

    "/point/buyingflow/payment/ticket_info"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment/installments"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment/bank_selector"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment/new_card"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment/card_security_code"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/review"(platform: "/", type: TrackType.View) {
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

    "/point/buyingflow/review/confirm_purchase"(platform: "/", type: TrackType.Event) {
        groupCheckoutProperties
        has_account_money (type: PropertyType.Boolean, required: false, description: "Flag that shows if the user has enough money in account")
        has_consumer_credits (type: PropertyType.Boolean, required: false, description: "Flag that shows if the user has credit balance")
        payment_status_detail (type: PropertyType.String, required: false, description: "Flag that shows payment status detail")
        payment_status (type: PropertyType.String, required: false, description: "Flag that shows payment status detail")
        payment_method_id (type: PropertyType.String, required: false, description: "Flag that shows the selected payment method")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Flag that shows the quantity of installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Flag that shows the type of selected payment")
        payment_id (type: PropertyType.Numeric, required: false, description: "ID that identifies the payment")
        error_code (type: PropertyType.Numeric, required: false, description: "Error code")
    }

    "/point/buyingflow/shipping/invalid_address"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/shipping/complete_phone"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment/complete_card_data"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/shipping/sim_card"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/shipping/xsell"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment/credit_authorization"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
    }

    "/point/buyingflow/payment/credit_authorization/confirm"(platform: "/", type: TrackType.Event) {
        groupCheckoutProperties
    }

    "/point/buyingflow/regret"(platform: "/", type: TrackType.View) {}

    "/point/buyingflow/congrats"(platform: "/", isAbstract: true) {}
    
    "/point/buyingflow/congrats"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }

    "/point/buyingflow/congrats/refresh"(platform: "/", type: TrackType.View) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }

    "/point/buyingflow/congrats/instructions"(platform:"/", type: TrackType.View) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }

    "/point/buyingflow/congrats/print"(platform:"/", type: TrackType.Event) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }
    "/point/buyingflow/congrats/copy"(platform:"/", type: TrackType.Event) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }
    "/point/buyingflow/congrats/map"(platform:"/", type: TrackType.Event) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }
    "/point/buyingflow/congrats/continue"(platform:"/", type: TrackType.Event) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }

    "/point/buyingflow/congrats/instructions/continue"(platform:"/", type: TrackType.Event) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }
    "/point/buyingflow/congrats/instructions/print"(platform:"/", type: TrackType.Event) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }
    "/point/buyingflow/congrats/instructions/copy"(platform:"/", type: TrackType.Event) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }
    "/point/buyingflow/congrats/instructions/map"(platform:"/", type: TrackType.Event) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }
    "/point/buyingflow/congrats/instructions/goto_bank"(platform:"/", type: TrackType.Event) {
        groupCheckoutProperties
        payment_method_id (type: PropertyType.String, required: true, description: "Selected Payment method ID")
        payment_id (type: PropertyType.Numeric, required: true, description: "Payment ID")
        payment_status (type: PropertyType.String, required: false, description: "Payment Status - Ex: approved, rejected")
        payment_status_detail (type: PropertyType.String, required: false, description: "Payment Status Detail")
        payment_installments (type: PropertyType.Numeric, required: false, description: "Payment Installments")
        payment_type_id (type: PropertyType.String, required: false, description: "Payment Type Id - Ex: ticket")
    }

}
