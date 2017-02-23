
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

    "/point"(platform: "/", isAbstract: true) {}

    "/point/home"(platform: "/") {
        product (type: PropertyType.String, description: "Name of device, example: 'point-h'")
        currency (type: PropertyType.String, required: false, description: "Currency")
        price (type: PropertyType.Numeric, required: false, description: "Price of device")
        in_installments (type: PropertyType.Boolean, required: false, description: "If product is selling in installments")
        discount (type: PropertyType.Numeric, required: false, description: "Discount in price")
        price_with_discount (type: PropertyType.Numeric, required: false, description: "Total price")
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

    "/cellphone_recharge"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
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
    "/bill_payments/add_info"(platform: "/mobile", isAbstract: true) {}
    "/bill_payments/add_info/literal"(platform: "/mobile") {}
    "/bill_payments/add_info/amount"(platform: "/mobile") {}
    "/bill_payments/add_info/option"(platform: "/mobile") {}
    "/bill_payments/second_password"(platform: "/mobile") {}
    "/bill_payments/result"(platform: "/mobile") {
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
    
    /**
     * END NOTIFICATIONS
     **/    

    // END -- MPMOBILE

}
