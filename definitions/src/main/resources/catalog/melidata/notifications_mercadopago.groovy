import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    /**
     * NOTIFICATIONS CENTER
     */
    "/notification_center"(platform: "/", type: TrackType.Event) {
        newsgroup_id(required: false, type: PropertyType.String)
        status(required: false, type: PropertyType.String, values:["unread", "read"])
        event_type(required: false, values: ["open", "pull_to_refresh", "swipe", "action_open", "create", "update", "shown"])
        deeplink(required: false, type: PropertyType.String)
        action_type(required: false, type: PropertyType.String,  values: ["messages", "message", "vop", "picture", "shipping_print_label", "claims", "tracking", "feedback", "changepayment", "reply", "ask", "questions-buy", "cart", "twitter_bar", "leftcta", "rightcta", "create"])
        type_layout(required: false, type: PropertyType.String, values: ["bullet_list", "order", "picture", "standard"])
    }
    "/notification_center/account_balance_approved_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/account_fund_approved_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/account_fund_salary"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/asset_management_warm_up"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/billing_mpoff"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/chargeback_payer_intensify_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/chargeback_payer_notify_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/chargeback_payer_start_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/chargeback_payer_ultimatum_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/chargeback_payer_update_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/compliance_support-validations"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credits_merchants_expired_near_to_daily_charges"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_expired_near_to_fixed_charges"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_expired_no_charges"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits-merchants"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_to_expire_not_standard"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_educational"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        loan_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/fraud-cash_release_iv"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/instore_buyer_qr"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/invite_gift"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/merchants_growth_mgm"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        gift_reason_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money-transfer_request"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mpcampaigns_campaigns"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
    }
    "/notification_center/prepaid_card"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/recurring_recharge_error"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/recurring_recharge_insufficient_balance_error"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/recurring_recharge_second_auth_error"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/wallet_integrator_insufficient_amount"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/wallet_integrator_ticket_acredited"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    /**
     * NOTIFICATIONS
     * disclaimer: when the action_type is set, the event_type should be always 'open'
     **/
    "/notification"(platform: "/mobile") {
        event_type(required: true,
            values: ["sent", "arrived", "received", "dismiss", "discarded", "open", "auto_dismiss", "shown", "purged_token"],
            description: "Type of notification event")

        notification_type(required: false,
            values: ["deep_linking", "directions", "favorite", "reply", "ask", "postpone", "twitter_bar", "picture", "answer", "messages", "vop", "claims", "received", "tracking", "shipping_print_label", "feedback", "buy"])

        news_id(required: false, description: "Identifier of the notification generated")

        notification_created_error(required: false, description: "The notification created error", type: PropertyType.String)

        device_id(required: false, description: "The real device_id, may differ from device field")

        //For event_type:autodismiss, indicates why the notification was dismissed
        source(required: false, values: ["notification_center","logout","overwrite","dismiss_notification"])

        context(required: false, type: PropertyType.String)

        notification_style(required: false, description: "The notification style used when displaying the notification to the user.")

        discard_reason(required: false, description: "The discarded reason of the notification", values: ["invalid_payload","invalid_user", "settings_disabled"], type: PropertyType.String)
    }

    //Asset Management
    "/notification/asset_management_warm_up"(platform: "/mobile") {}
    "/notification/asset_management_investing"(platform: "/mobile") {}
    "/notification/asset_management_pending"(platform: "/mobile") {}
    "/notification/asset_management_disabled"(platform: "/mobile") {}

    //Account
    "/notification/account_fund_approved_ml"(platform: "/mobile") {}
    "/notification/account_fund_approved_mp"(platform: "/mobile") {}
    "/notification/account_fund_salary"(platform: "/mobile") {}
    "/notification/account_balance_approved_mp"(platform: "/mobile") {}
    "/notification/account_balance_approved_ml"(platform: "/mobile") {}

    //Campañas
    "/notification/mpcampaigns_campaigns"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
    }
    "/notification/mpcampaigns_control_group"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
    }
    "/notification/mpcampaigns_mpcampaignspromo"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
    }
    "/notification/mpcampaigns_mpcampaignsinfo"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
    }

    //Credits Merchants
    "/notification/credits_merchants_expired_first_notice"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_expired_second_notice"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_expired_third_notice"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_about_to_expire_first_notice"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_expired_no_charges"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_to_expire"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_expired_near_to_fixed_charges"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_expired_near_to_daily_charges"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_to_expire_standard"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_to_expire_not_standard"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_educational"(platform: "/mobile") {
        loan_id(required: true, type: PropertyType.Numeric)
    }

    //Compliance Support
    "/notification/compliance_support_validations"(platform: "/mobile") {}

    //Fraud
    "/notification/fraud_cash_release_iv"(platform: "/mobile") {}

    //Health Check
    "/notification/health_check"(platform: "/mobile") {
        original_news_id( required: false, type: PropertyType.String, description: "Original identifier of the notification generated" )
    }

    //Inivite Gift
    "/notification/invite_gift"(platform: "/mobile") {}

    //Messages New
    "/notification/messages_new"(platform: "/mobile") {}

    //Money
    "/notification/money_transfer_received"(platform: "/mobile") {}
    "/notification/money_transfer_request"(platform: "/mobile") {}

    //Loyalty
    "/notification/loyalty_milestone"(platform: "/mobile") {}

    //Prepaid
    "/notification/prepaid_card_shipped"(platform: "/mobile") {}
    "/notification/prepaid_card_waiting_for_withdrawal"(platform: "/mobile") {}
    "/notification/prepaid_card_delivered"(platform: "/mobile") {}
    "/notification/prepaid_card_delayed_p1"(platform: "/mobile") {}
    "/notification/prepaid_card_not_delivered"(platform: "/mobile") {}
    "/notification/prepaid_card_third_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_second_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_invalid_pin"(platform: "/mobile") {}

    //Point
    "/notification/point_shipping_ready_to_ship"(platform: "/mobile") {}
    "/notification/point_shipping_shipped"(platform: "/mobile") {}
    "/notification/point_shipping_not_delivered"(platform: "/mobile") {}
    "/notification/point_shipping_waiting_for_withdrawal"(platform: "/mobile") {}
    "/notification/point_shipping_delayed_p1"(platform: "/mobile") {}
    "/notification/point_shipping_delayed_p4_p8"(platform: "/mobile") {}
    "/notification/point_shipping_ready_to_ship_delayed"(platform: "/mobile") {}

    //Recurring Recharge
    "/notification/recurring_recharge_insufficient_balance_error"(platform: "/mobile") {}

    //Security
    "/notification/security_event_feedback"(platform: "/mobile") {}

    //Questions
    "/notification/questions_new"(platform: "/mobile") {
        question_id(required: true, type: PropertyType.Numeric)
    }

    //Seller QR
    "/notification/seller_qr_payment_received"(platform: "/mobile") {}
    "/notification/seller_integrations_new_payment"(platform: "/mobile") {}
    "/notification/seller_integrations_erase_name"(platform: "/mobile") {}

    //Orders New
    "/notification/orders_new"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.Numeric)
    }

    //Wallet
    "/notification/wallet_integrator_insufficient_amount"(platform: "/mobile") {}

    //Withdraw
    "/notification/withdraw_approved_contingency"(platform: "/mobile") {}
}