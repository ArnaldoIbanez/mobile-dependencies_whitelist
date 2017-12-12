
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

    "/"(platform: "/mobile", isAbstract: true) {
        sent_again(required: false)
    }

    "/"(platform: "/web", isAbstract: true) {
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

    "/point"(platform: "/", isAbstract: true) {}

    // MP Point Landings
    "/point/home"(platform: "/") {
        product (type: PropertyType.String, description: "Name of device, example: 'point-h'")
        currency (type: PropertyType.String, required: false, description: "Currency")
        price (type: PropertyType.Numeric, required: false, description: "Price of device")
        in_installments (type: PropertyType.Boolean, required: false, description: "If product is selling in installments")
        discount (type: PropertyType.Numeric, required: false, description: "Discount in price")
        price_with_discount (type: PropertyType.Numeric, required: false, description: "Total price")
    }

    // MP Mobile Point
    "/point_payment"(platform: "/mobile", type: TrackType.View) {
        from (required: false, type: PropertyType.String, description: "Where the flow start")
        method (required: false, type: PropertyType.String, description: "Card reading method swipe/dip/tap", values: ["swipe", "dip", "tap"])
        currency (required: false, type: PropertyType.String, description: "Transaction currency")
        amount (required: false, type: PropertyType.Numeric, description: "Transaction amount")
        installments (required: false, type: PropertyType.Numeric, description: "Installments amount")
        payment_status (required: false, type: PropertyType.String, description: "Payment result status")
        payment_detail (required: false, type: PropertyType.String, description: "Payment result detail")
        reason (required: false, type: PropertyType.String, description: "Payment reason")
        poi (required: false, type: PropertyType.String, description: "Device serial number")
        poi_type (required: false, type: PropertyType.String, description: "Type of device")
        payment_method_id (required: false, type: PropertyType.String, description: "Payment Method used")
        operator_id (required: false, type: PropertyType.String, description: "Operator identification")
    }

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
    
    // MPMOBILE
    "/account_summary"(platform: "/mobile") {}
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
    "/login/splitter"(platform: "/mobile") {}
    "/login/sign_in"(platform: "/mobile") {}
    "/login/sign_up"(platform: "/mobile") {}
    "/login/identification"(platform: "/mobile") {}


    "/send_money"(platform: "/mobile", isAbstract: true) {
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

    "/cellphone_recharge"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/cellphone_recharge/push_handler"(platform: "/mobile") {}
    "/cellphone_recharge/recents"(platform: "/mobile") {}
    "/cellphone_recharge/set_telephone_number"(platform: "/mobile") {}
    "/cellphone_recharge/contacts"(platform: "/mobile") {}
    "/cellphone_recharge/carriers"(platform: "/mobile") {}
    "/cellphone_recharge/recommended"(platform: "/mobile") {}
    "/cellphone_recharge/packages"(platform: "/mobile") {}
    "/cellphone_recharge/manual_amount"(platform: "/mobile") {}
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
    "/cellphone_recharge/px_payment_method_search"(platform: "/mobile") {}
    "/cellphone_recharge/px_discount_summary"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_vault"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_number"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_holder_name"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_expiry_date"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_security_code"(platform: "/mobile") {}
    "/cellphone_recharge/px_identification_number"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_issuers"(platform: "/mobile") {}
    "/cellphone_recharge/px_card_installments"(platform: "/mobile") {}
    "/cellphone_recharge/px_review_and_confirm"(platform: "/mobile") {}
    "/cellphone_recharge/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

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


    "/money_request"(platform: "/mobile", isAbstract: true) {
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
    "/new-withdraw/confirm"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/account-select"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/second-password"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/congrats"(platform: "/", type: TrackType.View) {}
    "/new-account"(platform: "/", type: TrackType.View) {}

    "/withdraw"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/withdraw/withdrawable_money"(platform: "/mobile") {}
    "/withdraw/take_money_out"(platform: "/mobile") {}
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

    "/fund_account"(platform: "/mobile", isAbstract: true) {
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

    "/prepaid_card"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/prepaid_card/action_picker"(platform: "/mobile") {}
    "/prepaid_card/web_view"(platform: "/mobile") {}

    "/prepaid_recharge"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/prepaid_recharge/fill_recharge_data"(platform: "/mobile") {}
    "/prepaid_recharge/recipients"(platform: "/mobile") {}
    "/prepaid_recharge/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    
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
}
