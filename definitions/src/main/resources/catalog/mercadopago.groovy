
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

/**
*
* The events means actions that happens without launch a View,
* as example of that we can consider Bookmark an item in a VIP page
* Every event is an action, so the verbs available are:
*
* - back:  the event of back from a page, specially in mobile
* - abort: the user abort the action (e.g: back pressed before api response)
* - delete: when something is deleted
* - apply: when a criteria is applied
* - post: create a new entity
*/

tracks {
    
    "/"(platform: "/", isAbstract: true) {
    }

    "/"(platform: "/mobile", isAbstract: true) {
        sent_again(required: false)
    }

    "/blog"(platform: "/web", isAbstract: true) {
    }

    "/blog/home"(platform: "/web") {
    }

    // MP Landings Scope
    "/landing"(platform: "/web", isAbstract: true) {}

    // MP Home
    "/landing/home"(platform: "/web"){}

    // MP Sellers
    "/landing/sellers"(platform: "/web"){}

    // MP Sellers Websites
    "/landing/sellers/websites"(platform: "/web"){}

    // MP Sellers Social
    "/landing/sellers/social"(platform: "/web"){}

    // MP Buyers
    "/landing/buyers"(platform: "/web"){}

    // MP Promotions
    "/landing/promotions"(platform: "/web"){}

    // MP Activities
    "/listing"(platform: "/web", isAbstract: true){}

    "/listing/activities"(platform: "/web"){}

    "/listing/gateway"(platform: "/web"){}

    // MP details
    "/activity"(platform: "/web", isAbstract: true){}
    "/activity/detail"(platform: "/web"){}
    "/activity/detail/shipping"(platform: "/web"){}

    "/point"(platform: "/", isAbstract: true) {}

    // Merchant Acquisition
    "/merchant_acquisition"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/qr"(platform: "/", isAbstract: true) {}

    // QR Landing > Pageviews
    "/merchant_acquisition/qr/landing"(platform:"/", type: TrackType.View) {}

    // QR Landing > Buyers
    "/merchant_acquisition/qr/landing/buyers"(platform:"/", type: TrackType.View) {}

    // QR Landing > Events
    "/merchant_acquisition/qr/landing/promotions"(platform:"/", type: TrackType.Event) {}

    // QR Flow > Pageviews
    "/merchant_acquisition/qr/onboarding"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/qr-code"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/pending"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/error"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/settings"(platform:"/", type: TrackType.View) {}

    // QR Flow > Events
    "/merchant_acquisition/qr/qr-code/download"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/print"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/faqs"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/help"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/rates"(platform:"/", type: TrackType.Event) {}

    // Merchant Acquisition Point Landings
    "/point/landings"(platform: "/") {
        product (type: PropertyType.String, required: false, description: "Name of device, example: 'point-h'")
        currency (type: PropertyType.String, required: false, description: "Currency")
        price (type: PropertyType.Numeric, required: false, description: "Price of device")
        has_coupon (type: PropertyType.Boolean, required: false, description: "Flag to detect if a sell has coupon")
        coupon_code (type: PropertyType.String, required: false, description: "MGM CuponCode")
        coupon_type (type: PropertyType.String, required: false, values: ["default", "mgm", "campaign"], description: "Kind of MGM Coupon: default | mgm | campaign")
        discount (type: PropertyType.Numeric, required: false, description: "Discount in price")
        price_with_discount (type: PropertyType.Numeric, required: false, description: "Total price")
    }
    "/point/landings/buy"(platform:"/", type: TrackType.Event) {}

    // Merchant Acquisition Point Landings: MGM
    "/point/landings/mgm"(platform:"/", type: TrackType.Event) {
      type (type: PropertyType.String, description: "Click event type, possible values: share || ios || android")
    }

    // Point Flows
    "/point/flows"(platform: "/", isAbstract: true) {}

    // Point Flows Congrats > Pageviews
    "/point/flows/congrats"(platform:"/", type: TrackType.View) {}

    // MP Mobile Point
    "/point_payment"(platform: "/mobile", type: TrackType.View) {
        flow_id (required: false, type: PropertyType.String, description: "Flow id.")
        from (required: false, type: PropertyType.String, description: "Where the flow start")
        method (required: false, type: PropertyType.String, description: "Card reading method swipe/dip/tap", values: ["swipe", "dip", "tap", "chip"])
        currency (required: false, type: PropertyType.String, description: "Transaction currency")
        amount (required: false, type: PropertyType.String, description: "Transaction amount")
        installments (required: false, type: PropertyType.String, description: "Installments amount")
        payment_status (required: false, type: PropertyType.String, description: "Payment result status")
        payment_detail (required: false, type: PropertyType.String, description: "Payment result detail")
        reason (required: false, type: PropertyType.String, description: "Payment reason")
        poi (required: false, type: PropertyType.String, description: "Device serial number")
        poi_type (required: false, type: PropertyType.String, description: "Type of device")
        payment_method_id (required: false, type: PropertyType.String, description: "Payment Method used")
        operator_id (required: false, type: PropertyType.String, description: "Operator identification")
        flow (required: false, type: PropertyType.String, description: "Flow")
        error_msg (required:false, type: PropertyType.String, description: "Error shown to seller")
    }

    "/point_payment/main"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/card"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/installments"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/card_type"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/signature"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/security_code"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/identification_number"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/result"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error"(platform: "/mobile", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "Where the flow start")
        error_msg (required:false, type: PropertyType.String, description: "Error shown to seller")
    }
    "/point_payment/new_payment_entry_point"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/send_bill_congrats"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/send_sms"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error_i_have_an_issue"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error/generic"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error/rejected"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/request_bluetooth"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/ftu_preorder_pax"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_chooser"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/selector"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/send_bill"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/point_ftu_newland"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/idempotency"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/point"(platform: "/mobile", type: TrackType.View) {}

    "/point_payment/flow_tracker"(platform: "/mobile", type: TrackType.Event, isAbstract: true) {
        flow_id (required: true, type: PropertyType.String, description: "Flow id.")
        user_id (required: false, type: PropertyType.String, description: "User id.")
        level (required: true, type: PropertyType.String, description: "Log level (error|info)", values: ["error", "info"])
        message(required: false, type:  PropertyType.String, description: "message to log")
        data (required: false, type:  PropertyType.String, description: "data to log")
    }

    "/point_payment/flow_tracker/pairing"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/configuration"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_get"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/card_token_results"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/start"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/card_tokens_result"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/end"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_next_step_after_payment"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_card_tokens_request_put"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_card_tokens_response_put"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_pos_sending_online_process"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_notification_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_notification_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_pos_error_message"(platform: "/mobile", type: TrackType.Event) {}

    "/settings/point"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/settings/point/settings"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/settings/point/costs_calculator"(platform: "/mobile", type: TrackType.View) {}
    "/settings/point/settings/pricing"(platform: "/mobile", type: TrackType.View) {}
    "/settings/point/installment_cost"(platform: "/mobile", type: TrackType.View) {}
    "/settings/point/device_mlb"(platform: "/mobile", type: TrackType.View) {}
    "/settings/pairing"(platform: "/mobile", type: TrackType.View) {}

    "/shortcuts"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/shortcuts/point"(platform: "/mobile", type: TrackType.Event) {}

    "/get_member/point"(platform: "/mobile", type: TrackType.View) {}

    "/ftu_release"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/ftu_release/point_app"(platform: "/mobile", type: TrackType.View) {}
    "/ftu_release/point_&_mp_app"(platform: "/mobile", type: TrackType.View) {}

    "/company_info"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/company_info/on_boarding"(platform: "/mobile", type: TrackType.View) {}

    // MP Mobile Point Catalog

    "/catalog"(platform: "/mobile", type: TrackType.View) {}
    "/catalog/create_product"(platform: "/mobile", type: TrackType.View) {}
    "/catalog/create_product/picture"(platform: "/mobile", type: TrackType.View) {}
    "/catalog/discount"(platform: "/mobile", type: TrackType.View) {}

    // MPMOBILE
    "/account_summary"(platform: "/mobile") {
        from (required:false, type: PropertyType.String, description: "Where the flow start", values:["/deep_link_ml","/deep_link","push"])
    }
    "/account_summary/filters"(platform: "/mobile") {}
    "/account_summary/filtered_list"(platform: "/mobile") {}

    "/activity_detail"(platform: "/mobile") { }
    "/transaction_detail"(platform: "/mobile") { }
    "/social_detail"(platform: "/mobile") { }
    "/event_detail"(platform: "/mobile") { }

    "/shopping"(platform: "/mobile") { }
    "/crop_image"(platform: "/mobile") { }

    "/login"(platform: "/mobile", isAbstract: true) {
        flow (required:false, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/login/splitter"(platform: "/mobile", type: TrackType.View) {}
    "/login/sign_in"(platform: "/mobile", type: TrackType.View) {}
    "/login/sign_up"(platform: "/mobile", type: TrackType.View) {}
    "/login/identification"(platform: "/mobile") {}

    "/sign_in"(platform: "/mobile", isAbstract: true) {}
    "/sign_in/sso"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_in/smart_lock"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_in/facebook"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_in/google"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_in/mail"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }
    "/sign_up"(platform: "/mobile", isAbstract: true) {}
    "/sign_up/facebook"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_up/google"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_up/mail"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }

    "/send_money"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/send_money/fill_transaction_data"(platform: "/mobile") {}
    "/send_money/pay"(platform: "/mobile") {}
    "/send_money/deals"(platform: "/mobile") {}
    "/send_money/deals/terms"(platform: "/mobile") {}
    "/send_money/payment_methods"(platform: "/mobile") {}
    "/send_money/other_payment_methods"(platform: "/mobile") {}
    "/send_money/cards"(platform: "/mobile") {}
    "/send_money/add_card"(platform: "/mobile") {}
    "/send_money/issuers"(platform: "/mobile") {}
    "/send_money/my_cards"(platform: "/mobile") {}
    "/send_money/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }


    "/checkout"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/checkout/pay"(platform: "/mobile") {}
    "/checkout/deals"(platform: "/mobile") {}
    "/checkout/deals/terms"(platform: "/mobile") {}
    "/checkout/payment_methods"(platform: "/mobile") {}
    "/checkout/other_payment_methods"(platform: "/mobile") {}
    "/checkout/cards"(platform: "/mobile") {}
    "/checkout/add_card"(platform: "/mobile") {}
    "/checkout/issuers"(platform: "/mobile") {}
    "/checkout/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/qr_code"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/qr_code/qr_reader"(platform: "/mobile") {}
    "/qr_code/fill_transaction_data"(platform: "/mobile") {}
    "/qr_code/pay"(platform: "/mobile") {}
    "/qr_code/deals"(platform: "/mobile") {}
    "/qr_code/deals/terms"(platform: "/mobile") {}
    "/qr_code/payment_methods"(platform: "/mobile") {}
    "/qr_code/other_payment_methods"(platform: "/mobile") {}
    "/qr_code/cards"(platform: "/mobile") {}
    "/qr_code/add_card"(platform: "/mobile") {}
    "/qr_code/issuers"(platform: "/mobile") {}
    "/qr_code/my_cards"(platform: "/mobile") {}
    "/qr_code/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/qr_code/px_payment_method_search"(platform: "/mobile") {}
    "/qr_code/px_discount_summary"(platform: "/mobile") {}
    "/qr_code/px_card_vault"(platform: "/mobile") {}
    "/qr_code/px_card_number"(platform: "/mobile") {}
    "/qr_code/px_card_holder_name"(platform: "/mobile") {}
    "/qr_code/px_card_expiry_date"(platform: "/mobile") {}
    "/qr_code/px_card_security_code"(platform: "/mobile") {}
    "/qr_code/px_identification_number"(platform: "/mobile") {}
    "/qr_code/px_card_issuers"(platform: "/mobile") {}
    "/qr_code/px_card_installments"(platform: "/mobile") {}
    "/qr_code/px_review_and_confirm"(platform: "/mobile") {}
    "/qr_code/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/qr_read"(platform: "/mobile", isAbstract: true) {}
    "/qr_read/store"(platform: "/mobile") {
        _label (required:true, type: PropertyType.String, description: "Operation status")
        deep_link (required:false, type: PropertyType.String, description: "Navigation info")
        qr_info (required:false, type: PropertyType.String, description: "Data read")
        additional_info (required:false, description: "Extra info")
    }

    "/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/pay_preference"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/pay_preference/fetch_preference_info"(platform: "/mobile") {}
    "/pay_preference/px_payment_method_search"(platform: "/mobile") {}
    "/pay_preference/px_payer_cost"(platform: "/mobile") {}
    "/pay_preference/px_card_number"(platform: "/mobile") {}
    "/pay_preference/px_card_vault"(platform: "/mobile") {}
    "/pay_preference/px_card_holder"(platform: "/mobile") {}
    "/pay_preference/px_card_holder_name"(platform: "/mobile") {}
    "/pay_preference/px_card_issuers"(platform: "/mobile") {}
    "/pay_preference/px_card_installments"(platform: "/mobile") {}
    "/pay_preference/px_card_expiry_date"(platform: "/mobile") {}
    "/pay_preference/px_card_security_code"(platform: "/mobile") {}
    "/pay_preference/px_identification_number"(platform: "/mobile") {}
    "/pay_preference/px_review_and_confirm"(platform: "/mobile") {}
    "/pay_preference/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/cellphone_recharge"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/cellphone_recharge/push_handler"(platform: "/mobile") {}
    "/cellphone_recharge/pay"(platform: "/mobile") {}
    "/cellphone_recharge/deals"(platform: "/mobile") {}
    "/cellphone_recharge/deals/terms"(platform: "/mobile") {}
    "/cellphone_recharge/payment_methods"(platform: "/mobile") {}
    "/cellphone_recharge/other_payment_methods"(platform: "/mobile") {}
    "/cellphone_recharge/cards"(platform: "/mobile") {}
    "/cellphone_recharge/add_card"(platform: "/mobile") {}
    "/cellphone_recharge/issuers"(platform: "/mobile") {}
    "/cellphone_recharge/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    // Cellphone Recharge Frontend
    "/cellphone_recharge/suggested_phones"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/second_password"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/phone_income"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/congrats"(platform: "/web", type: TrackType.View) {
        status (required:true, type: PropertyType.String, description: "Payment status (approved, pending, rejected)")
    }
    "/cellphone_recharge/companies"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/checkout"(platform: "/web/desktop", type: TrackType.View) {}
    "/cellphone_recharge/amounts"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/amount_recommended"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/alias_income"(platform: "/web/mobile", type: TrackType.View) {}
    "/cellphone_recharge/account_money"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/error"(platform: "/web", type: TrackType.View) {}
    "/cellphone_recharge/not-found"(platform: "/web", type: TrackType.View) {}

    "/scheduled_recharge"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/scheduled_recharge/detail"(platform: "/mobile") {}
    "/scheduled_recharge/empty_recharges"(platform: "/mobile") {}
    "/scheduled_recharge/all_scheduled"(platform: "/mobile") {}
    "/scheduled_recharge/frequency"(platform: "/mobile") {}
    "/scheduled_recharge/weekly_option"(platform: "/mobile") {}
    "/scheduled_recharge/monthly_option"(platform: "/mobile") {}
    "/scheduled_recharge/suggested_recent_recharges"(platform: "/mobile") {}
    "/scheduled_recharge/carries"(platform: "/mobile") {}
    "/scheduled_recharge/recommended"(platform: "/mobile") {}
    "/scheduled_recharge/packages"(platform: "/mobile") {}
    "/scheduled_recharge/manual_amount"(platform: "/mobile") {}
    "/scheduled_recharge/px_payment_method_search"(platform: "/mobile") {}
    "/scheduled_recharge/px_discount_summary"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_vault"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_number"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_holder_name"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_expiry_date"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_security_code"(platform: "/mobile") {}
    "/scheduled_recharge/px_identification_number"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_issuers"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_installments"(platform: "/mobile") {}
    "/scheduled_recharge/px_review_and_confirm"(platform: "/mobile") {}
    "/scheduled_recharge/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/get_member"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/get_member/invite"(platform: "/mobile") {
        scope(required: true, type: PropertyType.String, description: "The scope from where it has been executed")
    }
    "/get_member/redeem"(platform: "/mobile") {}

    "/bill_payments"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/bill_payments/help"(platform: "/mobile") {}
    "/bill_payments/associated_entities"(platform: "/mobile") {}
    "/bill_payments/no_money"(platform: "/mobile") {}
    "/bill_payments/permissions_rationale"(platform: "/mobile") {}
    "/bill_payments/scan"(platform: "/mobile") {}
    "/bill_payments/manual_code"(platform: "/mobile") {}
    "/bill_payments/confirmation"(platform: "/mobile") {}
    "/bill_payments/add_info"(platform: "/mobile") {
        type (required: true, type: PropertyType.String, description: "Additional info type")
    }
    "/bill_payments/second_password"(platform: "/mobile") {}
    "/bill_payments/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/bill_payments/px_payment_method_search"(platform: "/mobile") {}
    "/bill_payments/px_discount_summary"(platform: "/mobile") {}
    "/bill_payments/px_card_vault"(platform: "/mobile") {}
    "/bill_payments/px_card_number"(platform: "/mobile") {}
    "/bill_payments/px_card_holder_name"(platform: "/mobile") {}
    "/bill_payments/px_card_expiry_date"(platform: "/mobile") {}
    "/bill_payments/px_card_security_code"(platform: "/mobile") {}
    "/bill_payments/px_identification_number"(platform: "/mobile") {}
    "/bill_payments/px_card_issuers"(platform: "/mobile") {}
    "/bill_payments/px_card_installments"(platform: "/mobile") {}
    "/bill_payments/px_review_and_confirm"(platform: "/mobile") {}
    "/bill_payments/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/bill_payments/fixed_amount"(platform: "/mobile") {}
    "/bill_payments/ticket_data"(platform: "/mobile") {}
    "/bill_payments/fee"(platform: "/mobile"){}


    "/recharge_sube"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/recharge_sube/first_time_use"(platform: "/mobile") {}
    "/recharge_sube/no_money"(platform: "/mobile") {}
    "/recharge_sube/choose_amount_information"(platform: "/mobile") {}
    "/recharge_sube/localization"(platform: "/mobile") {}
    "/recharge_sube/localization_permission"(platform: "/mobile") {}
    "/recharge_sube/select_recharge_card"(platform: "/mobile") {}
    "/recharge_sube/information"(platform: "/mobile") {}
    "/recharge_sube/add_bus_card"(platform: "/mobile") {}
    "/recharge_sube/add_card_name"(platform: "/mobile") {}
    "/recharge_sube/choose_amount"(platform: "/mobile") {}
    "/recharge_sube/second_password"(platform: "/mobile") {}
    "/recharge_sube/px_payment_method_search"(platform: "/mobile") {}
    "/recharge_sube/px_discount_summary"(platform: "/mobile") {}
    "/recharge_sube/px_card_vault"(platform: "/mobile") {}
    "/recharge_sube/px_card_number"(platform: "/mobile") {}
    "/recharge_sube/px_card_holder_name"(platform: "/mobile") {}
    "/recharge_sube/px_card_expiry_date"(platform: "/mobile") {}
    "/recharge_sube/px_card_security_code"(platform: "/mobile") {}
    "/recharge_sube/px_identification_number"(platform: "/mobile") {}
    "/recharge_sube/px_card_issuers"(platform: "/mobile") {}
    "/recharge_sube/px_card_installments"(platform: "/mobile") {}
    "/recharge_sube/px_review_and_confirm"(platform: "/mobile") {}
    "/recharge_sube/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }


    "/money_request"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/money_request/picker"(platform: "/mobile") {}
    "/money_request/fill_transaction_data"(platform: "/mobile") {}
    "/money_request/social_share"(platform: "/mobile") {}
    "/money_request/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    //tracks for new flow (withdraw and new account)
    "/new-withdraw"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/confirm"(platform: "/", type: TrackType.View) {
        type (required: true, type: PropertyType.String, description: "tipo de confirm")
        type_detail (required: true, type: PropertyType.String, description: "detalle de confirm")
    }
    "/new-withdraw/account-select"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/second-password"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/congrats"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/congrats-advance"(platform: "/", type: TrackType.View) {}
    "/new-account"(platform: "/", type: TrackType.View) {}

    "/withdraw"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/withdraw/take_money_out"(platform: "/") {}
    "/withdraw/withdrawable_money"(platform: "/mobile") {}
    "/withdraw/select_bank"(platform: "/mobile") {}
    "/withdraw/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/withdraw_advance"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/withdraw_advance/take_money_out"(platform: "/mobile") {}
    "/withdraw_advance/select_bank"(platform: "/mobile") {}
    "/withdraw_advance/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/fund_account"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/fund_account/fund_amount"(platform: "/mobile") {}
    "/fund_account/other_payment_methods"(platform: "/mobile") {}
    "/fund_account/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/settings"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/settings/my_profile"(platform: "/mobile") {}
    "/settings/balance"(platform: "/mobile") {}
    "/settings/my_cards"(platform: "/mobile") {}
    "/settings/my_cards_detail"(platform: "/mobile") {}
    "/settings/pin_status"(platform: "/mobile") {}
    "/settings/verify_pin"(platform: "/mobile") {}
    "/settings/set_pin_code"(platform: "/mobile") {}
    "/settings/about"(platform: "/mobile") {}

    "/associate_phone"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/associate_phone/sync_phone"(platform: "/mobile") {}
    "/associate_phone/verify_pin"(platform: "/mobile") {}
    "/associate_phone/synced_phone"(platform: "/mobile") {}

    /**
     * NOTIFICATIONS
     * disclaimer: when the action_type is set, the event_type should be always 'open'
     **/
    "/notification"(platform: "/mobile") {
        event_type(required: true,
                values: ["sent", "arrived", "received", "dismiss", "discarded", "open", "auto_dismiss", "shown"],
        description: "Type of notification event")
        news_id(required: false, description: "Identifier of the notification generated")
    }

    //Campañas
    "/notification/mpcampaigns_campaigns"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
    }

    //Money
    "/notification/money_transfer_received"(platform: "/mobile") {}
    "/notification/money_transfer_request"(platform: "/mobile") {}

    //Prepaid
    "/notification/prepaid_card_shipped"(platform: "/mobile") {
        notification_type(required: false, type: PropertyType.String, description: "Optional notification type because event type.")
    }
    "/notification/prepaid_card_waiting_for_withdrawal"(platform: "/mobile") {
        notification_type(required: false, type: PropertyType.String, description: "Optional notification type because event type.")
    }
    "/notification/prepaid_card_delivered"(platform: "/mobile") {
        notification_type(required: false, type: PropertyType.String, description: "Optional notification type because event type.")
    }
    "/notification/prepaid_card_delayed_p1"(platform: "/mobile") {
        notification_type(required: false, type: PropertyType.String, description: "Optional notification type because event type.")
    }
    "/notification/prepaid_card_not_delivered"(platform: "/mobile") {
        notification_type(required: false, type: PropertyType.String, description: "Optional notification type because event type.")
    }

    //Point
    "/notification/point_shipping_ready_to_ship"(platform: "/mobile") {
        notification_type(required: false, type: PropertyType.String, description: "Optional notification type because event type.")
    }
    "/notification/point_shipping_shipped"(platform: "/mobile") {
        notification_type(required: false, type: PropertyType.String, description: "Optional notification type because event type.")
    }
    "/notification/point_shipping_not_delivered"(platform: "/mobile") {
        notification_type(required: false, type: PropertyType.String, description: "Optional notification type because event type.")
    }
    "/notification/point_shipping_waiting_for_withdrawal"(platform: "/mobile") {
        notification_type(required: false, type: PropertyType.String, description: "Optional notification type because event type.")
    }
    "/notification/point_shipping_delayed_p1"(platform: "/mobile") {
        notification_type(required: false, type: PropertyType.String, description: "Optional notification type because event type.")
    }
    //Digital Goods
     "/digital_goods"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/digital_goods/list"(platform: "/mobile") {}
    "/digital_goods/no_money"(platform: "/mobile") {}
    "/digital_goods/search_entities"(platform: "/mobile") {}
    "/digital_goods/products"(platform: "/mobile") {
        type (required:true, type: PropertyType.String, description: "Option")
    }
    "/digital_goods/px_payment_method_search"(platform: "/mobile") {}
    "/digital_goods/px_discount_summary"(platform: "/mobile") {}
    "/digital_goods/px_card_vault"(platform: "/mobile") {}
    "/digital_goods/px_card_number"(platform: "/mobile") {}
    "/digital_goods/px_card_holder_name"(platform: "/mobile") {}
    "/digital_goods/px_card_expiry_date"(platform: "/mobile") {}
    "/digital_goods/px_card_security_code"(platform: "/mobile") {}
    "/digital_goods/px_identification_number"(platform: "/mobile") {}
    "/digital_goods/px_card_issuers"(platform: "/mobile") {}
    "/digital_goods/px_card_installments"(platform: "/mobile") {}
    "/digital_goods/px_review_and_confirm"(platform: "/mobile") {}
    "/digital_goods/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/digital_goods/terms_and_conditions"(platform: "/mobile") {}


    "/money_detail"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/money_detail/balance"(platform: "/mobile") {}
    "/money_detail/help_modal"(platform: "/mobile") {}

    /**
     * END NOTIFICATIONS
     **/

    // END -- MPMOBILE

    //MP listings
    "/listings"(platform: "/web", isAbstract: true){}
    "/listings/movements"(platform: "/web", type: TrackType.View){}
    "/listings/with_holdings"(platform: "/web", type: TrackType.View){}

    //MP personalFrontend
    "/tools"(platform: "/web", isAbstract: true){}

    "/tools/list"(platform: "/web", type: TrackType.View){}
    "/tools/list/button_create"(platform: "/web"){}

    "/tools/create"(platform: "/web", type: TrackType.View){}
    "/tools/confirm_create_edit"(platform: "/web"){}

    "/charts"(platform: "/web", isAbstract: true){}
    "/charts/show"(platform: "/web", type: TrackType.View){}

    "/balance"(platform: "/web", isAbstract: true){}
    "/balance/reports"(platform: "/web", type: TrackType.View){}

    "/my_business"(platform: "/web", type: TrackType.View){}
    "/my_business/how_it_works_ME"(platform: "/web"){}
    "/my_business/enable_ME"(platform: "/web"){}
    "/my_business/disable_ME"(platform: "/web"){}

    "/my_business/split_payment"(platform: "/web"){}
    "/my_business/recovery_mails"(platform: "/web"){}
    "/my_business/cost_absorption"(platform: "/web"){}

    //END -- MP personalFrontend

    //MP frontend
    "/cellphone_recharge/confirm"(platform: "/web"){}
    "/fund_account/confirm"(platform: "/web"){}
    "/send_money/confirm"(platform: "/web"){}
    "/money_request/confirm"(platform: "/web"){}
    "/money_request/congrats"(platform: "/web"){}

    "/campaigns"(platform: "/web", isAbstract: true){}
    "/campaigns/create"(platform: "/web", type: TrackType.View){}
    "/campaigns/confirm_create"(platform: "/web"){}

    "/subscription_plan"(platform: "/web", isAbstract: true){}
    "/subscription_plan/create"(platform: "/web", type: TrackType.View){}
    "/subscription_plan/confirm_create"(platform: "/web"){}
    //END -- MP frontend

    "/free_navigation"(platform:"/mobile", isAbstract: true) {}

    "/free_navigation/not_available"(platform:"/mobile", type:TrackType.Event) {}

    "/free_navigation/wifi"(platform:"/mobile", type:TrackType.Event) {}



}
