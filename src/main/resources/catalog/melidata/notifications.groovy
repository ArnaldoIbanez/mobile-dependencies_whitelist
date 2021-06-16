package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1171"

    /**
    * NOTIFICATIONS CENTER
    */
    "/notification_center/screen"(platform: "/", type: TrackType.View) {
    }

    "/notification_center/config"(platform: "/mobile", type: TrackType.View) {
    }
    "/notification_center"(platform: "/", type: TrackType.Event) {
        newsgroup_id(required: false, type: PropertyType.String)
        status(required: false, type: PropertyType.String, values:["unread", "read"])
        event_type(required: false, values: ["open", "pull_to_refresh", "swipe", "action_open", "create", "update", "shown"])
        deeplink(required: false, type: PropertyType.String)
        action_type(required: false, type: PropertyType.String,  values: ["messages", "message", "vop", "picture", "shipping_print_label", "claims", "tracking", "feedback", "changepayment", "reply", "ask", "questions-buy", "cart", "twitter_bar", "leftcta", "rightcta", "create"])
        type_layout(required: false, type: PropertyType.String, values: ["bullet_list", "order", "picture", "standard"])
    }
    "/notification_center/abort"(platform: "/", type: TrackType.Event) {}
    "/notification_center/addresses-update"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/back"(platform: "/", type: TrackType.Event) {}
    "/notification_center/failure"(platform: "/", type: TrackType.Event) {}
    "/notification_center/reputation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/reputation-medal_lost_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/security-enrollment"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/security-enrollment-legacy"(platform: "/", type: TrackType.Event) {}
    "/notification_center/loyalty"(platform: "/", type: TrackType.Event) {
        milestone_id(required: false, type: PropertyType.String, description:"Id of milestone.")
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/loyalty-freeshipping"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_sponsor_campaign_start_campaign"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_sponsor_campaign_budget_trigger"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_sponsor_campaign_day_trigger"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_seller_campaign_start_campaign"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_seller_campaign_end_campaign"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_seller_moderation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mediations-complainant"(platform: "/", type: TrackType.Event) {
        claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mediations-complainant-legacy"(platform: "/", type: TrackType.Event) {}
    "/notification_center/purchase-pending-legacy"(platform: "/", type: TrackType.Event) {}
    "/notification_center/listings"(platform: "/", type: TrackType.Event) {}
    "/notification_center/reviews-reminder"(platform: "/", type: TrackType.Event) {
        vertical(required: true, type: PropertyType.String, description: "vertical.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credits_consumer"(platform: "/", type: TrackType.Event) {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credits-merchants"(platform: "/", type: TrackType.Event) {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fiscal_data-business_registration"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud-postpayment"(platform: "/", type: TrackType.Event) {}
    "/notification_center/instore-activities"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/invoices"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-deals"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, type: PropertyType.String, description: "Id of the campaign related to the mkt notification sent.")
        deal_id(required: true, description: "Id of the deal related to the mkt notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
    }
    "/notification_center/campaigns-campaigns"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
    }
    "/notification_center/campaigns-generic"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        campaign_type(required: false, type: PropertyType.String, description: "Type of the campaign related to the notification sent.")
        campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
        test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id.")
    }
    "/notification_center/campaigns-suggested_discounts_buyer"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        item_id(required: true, type: PropertyType.String, description: "Id of item.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-suggested_discounts_seller"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-buyequalspay"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        order_id(required: false, type: PropertyType.Numeric)
    }
    "/notification_center/campaigns-cart_recovery"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        item_id(required: false, type: PropertyType.String, description: "Id of item.")
        experiment(required: false, type: PropertyType.Boolean, description: "experiment.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-checkout_recovery"(platform: "/") {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        item_id(required: false, type: PropertyType.String, description: "Id of item.")
        variation_id(required: false, type: PropertyType.String, description: "Id of variaton of the item.")
        experiment(required: false, type: PropertyType.Boolean, description: "experiment.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-acho_reminder"(platform: "/") {
        campaign_id(required: true, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        item_id(required: false, type: PropertyType.String, description: "Id of item.")
        variation_id(required: false, type: PropertyType.String, description: "Id of variation.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-recharge_recovery"(platform: "/") {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        experiment(required: false, type: PropertyType.Boolean, description: "experiment.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-ticket_recovery"(platform: "/") {
        campaign_id(required: true, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-cho_cart_recovery"(platform: "/") {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        items(required: false, type: PropertyType.String, description: "Id of item.")
        experiment(required: false, type: PropertyType.Boolean, description: "experiment.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-deal_alert"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, description: "Id of the campaign related to the notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        item_id(required: false, type: PropertyType.String, description: "Id of item.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-download_app"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-prepaid_point"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-remarketing"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        hash(required: false, type: PropertyType.String, description: "Hash of the message in claim check.")
        mantika_id(required: false, type: PropertyType.String, description: "Id of Mantika XP.")
        items_recommendations(required: false, type: PropertyType.String, description: "Items sent from recommendations.")
        items_history(required: false, type: PropertyType.String, description: "Items sent from history.")
    }
    "/notification_center/campaigns-remarketing_motors"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        item_id(required: true, type: PropertyType.String, description:"Item Id.")
    }
    "/notification_center/campaigns_marketplace_discounts"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/compliance_support-validations"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/cx-generic"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/cancellations"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/coverages"(platform: "/", type: TrackType.Event) {
        activity_id(required: true , type: PropertyType.String)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/cx_question"(platform: "/", type: TrackType.Event) {
        case_id(required: true, type: PropertyType.Numeric, description: "Id of cx case.")
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/da_kyc_manual_review"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/data_privacy_export"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud-identity_validation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud_delivery_cancellation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud_delivery_cancellation_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud_delivery_cancellation_stop_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud-cash_release_iv"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud-identity_validation_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud_score_post_approval"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud_iv_credentials"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud_remedies_trust_vote_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/flows_default"(platform: "/", type: TrackType.Event) {
        initiative_code(required: true, type: PropertyType.String)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud_poc_trust_vote_second_score"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    //Openplatform
    "/notification_center/openplatform_sellers_inhouse"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/openplatform_recommendations_wannabe"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/openplatform_recommendations_p4"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/openplatform_recommendations_p3"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/openplatform_recommendations_p2"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/openplatform_recommendations_p1"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/packages-buyer"(platform: "/", type: TrackType.Event) {}
    "/notification_center/packages-seller"(platform: "/", type: TrackType.Event) {}
    "/notification_center/package-seller"(platform: "/", type: TrackType.Event) {
        purchase_id(required: false, type: PropertyType.Numeric)
        pack_id(required: false, type: PropertyType.Numeric)
        shipment_id(required: false, description: "Id of shipment.")
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/me_flex-optin"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/me_flex_rehunting_generic"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/me_flex_rehunting_address"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/me_flex_hunting_generic"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/returns"(platform: "/", type: TrackType.Event) {
        order_id(required: true, type: PropertyType.Numeric)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mediations"(platform: "/", type: TrackType.Event) {
        claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        pack_id(required: false, type: PropertyType.Numeric, description: "Id of batch.")
        claim_id(required: false, type: PropertyType.Numeric, description:"Id of claim.")
    }
    "/notification_center/orders-buyer"(platform: "/", type: TrackType.Event) {
        order_id(required: true, type: PropertyType.Numeric)
        experiment_id(required: false, description: "Id of the experiment related to the order notification sent.")
    }
    "/notification_center/orders-seller"(platform: "/", type: TrackType.Event) {
        order_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/package_seller"(platform: "/", type: TrackType.Event) {
        order_id(required: true, type: PropertyType.Numeric)
    }

    "/notification_center/payments_release"(platform: "/", type: TrackType.Event) {
        notification_id(required: true, type: PropertyType.String)
    }

    "/notification_center/purchases-payments"(platform: "/", type: TrackType.Event) {
        purchase_id(required: true, type: PropertyType.Numeric)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/purchase_invoice"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/partners_pin_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        partner(required: true, type: PropertyType.String)
    }
    "/notification_center/partners_pin_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        partner(required: true, type: PropertyType.String)
    }

    "/notification_center/qrviral"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/quotes_new"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/quotes_reject"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/quotes_cancel"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/quotes_answer_send"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/quotes_answer_pending"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/questions-buyer"(platform: "/", type: TrackType.Event) {
        question_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/questions-seller"(platform: "/", type: TrackType.Event) {
        question_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/registration-info"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/registration-generated_pwd"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/reservations"(platform: "/", type: TrackType.Event) {
        order_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/reservations-pending_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/sc_editor_off"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/security-account_validation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/security-device_authorization"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/security-device_authorization_congrats"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/security_recovery_canceled"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/security_phone_enrollment"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/security_login_code"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/security_enroll_screenlock_app"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/chargeback-payer"(platform: "/", type: TrackType.Event) {
        case_id(required: true, type: PropertyType.String, description: "Id of chargeback.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/messages_quotes"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/messages_flex"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/messages_driver_logistics"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/account_fund-cvu"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/account_fund_approved_ted"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/account_fund_active_disabled_clabe"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/account_fund_iv_cvu_spb"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/account_fund_ticket"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/buybox_forced_item"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/buybox_forewarning"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/buybox_losing_item"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/buybox_losing_many"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/chargeback_payer_high_agree_repayment_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        case_id(required: true, type: PropertyType.String, description: "Id of chargeback.")
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
    //Billing
    "/notification_center/billing_iva_ganancias_reactive"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/billing_newtax"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/billing_newtaxhabituality"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/billing_responsable_inscripto_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/billing_iva_isr_meli"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credits_merchants_expired_near_to_daily_charges"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/credits_merchants_to_expire_not_standard"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_em_to_expire_01"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_em_expired_no_charges_today"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_em_expired_daily_charges_01"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_em_expired_daily_charges_04"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_em_expired_daily_charges_07"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_em_expired_daily_charges_10"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification_center/credits_merchants_educational"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        loan_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/credits_merchants_std_expired_daily_charges_110"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        loan_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/instore_buyer_qr"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/invite_gift"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/flammables_notification"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/growth_tooling_mgm_kyc_booster"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/growth_tooling_mgm_kyc_guest"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_handoff_user_notification_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_handoff_user_notification_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_user_notification_mp_web"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_user_notification_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_user_notification_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_legal_entity_notification_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_afip_user_notification_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_afip_user_notification_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_bo_success"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/killers_winner_item_recover"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/killers_winner_item_new"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/killers_losing_item_buybox"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/killers_loser_item_new"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/merchants_growth_mgm"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        gift_reason_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/merchants_growth_fdv"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/merchants_growth_paper_roll"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/merchants_growth_resellers_smart_launch"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/merchants_growth_sameday"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }    
    "/notification_center/money-transfer_request"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_advance"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_split_started"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_split_rejected_push"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_split_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_split_paid_push"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_split_paid"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_split_finished"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_request_paid_push"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_out_cashoutmlb_rejected_manualreview"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_out_cashoutmlb_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_out_cashoutmlb_pending"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_out_cashoutmlb_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_out_cashout_withdrawn"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_out_cashout_reversed"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_in_cashin_exceeded_cap"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_request_started"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_request_rejected_push"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_request_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_request_finished"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_out_cashout"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_transfer_received"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_transactions"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/hub_transfer_new_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/hub_transfer_manualreview"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/hub_transfer_new_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/hub_transfer_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/hub_transfer_screening_one"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/hub_transfer_screening_two"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mpcampaigns_campaigns"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
        campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
        sent_date(required: false, type: PropertyType.String, description: "Campaign sent date.")
    }
    "/notification_center/mpcampaigns_mpcampaignsinfo"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
    }
    "/notification_center/multiplayer_money_request"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/multiplayer_ml_money_request"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/multiplayer_regulation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/multiplayer_regulation_validated"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_seller_campaign_moderation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mss_gplay"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/no_maquinables_items_sellers"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card_challenge_bolbradesco_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/point_pos_closed"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/point_pos_close_soon"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/point_voucher_sodexo"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/point_pix"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/pix_transfer_mo_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/pix_transfer_mo_manual_review"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/pix_transfer_mi_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/pix_transfer_mo_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/subscription_expiring_notice"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        payment_option(required: false, type: PropertyType.String, description: "Payment option specified in the notification.")
    }
    "/notification_center/subscription_payment_congrats"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Type of congrats.")
    }
    "/notification_center/subscription_payment_error"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        error_type(required: false, type: PropertyType.String, description: "Payment error type.")
    }
    "/notification_center/subscription_payment_instructions"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        payment_option(required: false, type: PropertyType.String, description: "Payment option specified in the notification.")
    }
    "/notification_center/subscription_payment_pending"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Payment pending type.")
    }
    "/notification_center/subscription_disney_activation_on"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Payment pending type.")
    }
    "/notification_center/subscription_disney_activation_off"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Payment pending type.")
    }
    "/notification_center/subscription_disney_activation_free_trial"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Payment pending type.")
    }
    "/notification_center/card_first_use_incentive"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card_delivery"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card_transaction_rejected_regulations_bacen_data_incomplete"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card_transaction_rejected_invalid_pin"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card_transaction_rejected_activation_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card_reprogrammed"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_request_challenge"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_kyc_data_completed"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_delivery_tracking"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive_second_day"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_correios_strike"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_flow_incentive"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_freeze"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_limit"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_offering_physical_card"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_offering_transaction_generic_opt_in_ppd_to_hybrid"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_offering_transaction_opt_in_ppd_to_hybrid"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_pin"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_reminders"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_request_challenge"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive_second_day"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_wallet"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_rejected_authorization_by_invalid_amount"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_rejected_withdraw_by_invalid_amount"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/discount_central_missing_data"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/wallet_integrator_payment_success"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/wallet_integrator_insufficient_funds"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/wallet_integrator_ticket_acredited"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/wallet_integrator_personal_loan"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_rejected_international_authorization_by_invalid_amount"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_rejected_red_link_bug"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_canceled_withdraw"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_canceled_authorization"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_approved_withdraw"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_approved_authorization"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_invalid_amount_option_credit"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/withdraw_approved_contingency"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/withdraw_rejected_contingency"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/withdraw_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/withdraw_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    //Payroll
    "/notification_center/payroll_portability"(platform: "/", type: TrackType.Event){
        portability_id(required: true , type: PropertyType.String, description: "Corresponds to the portability id")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/payroll_portability_request"(platform: "/", type: TrackType.Event){
        portability_request_id(required: true , type: PropertyType.String, description: "Corresponds to the step id of the seller in the journey to associate the step.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/payroll_kyc_approved"(platform: "/", type: TrackType.Event){
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    //Single player
    "/notification_center/single_player_directv_smartcard_expiration"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_payment_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/single_player_recharge_fail_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_recharge_fail_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_recharge_success_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_recharge_success_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_utility_success_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_utility_fail_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_transport_success_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_transport_fail_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_prepaid_toll_success_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_prepaid_toll_fail_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_antenna_fail_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_new_debt_utility_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/single_player_expired_debt_utility_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/single_player_antenna_success_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_generic_balance_expiration"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_payment_reminder_new_grouped_debt"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/single_player_payment_reminder_expiring_grouped_debt"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification_center/single_player_payment_reminder_new_solo_debt"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        debt_id(required: true, type: PropertyType.Numeric)
    }

    "/notification_center/single_player_payg_unlock_device_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_payg_new_debt_without_block_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_payg_create_device_success_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_payg_blocked_device_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_payg_cashback_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_scheduled_payment_utility"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_scheduled_payment_utility_grouped_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_scheduled_payment_utility_grouped_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_scheduled_payment_utility_grouped_success"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_scheduled_payment_utility_solo_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_scheduled_payment_utility_solo_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_scheduled_payment_utility_solo_success"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/seller_journey_congrats"(platform: "/", type: TrackType.Event){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/seller_journey_keep_it_up"(platform: "/", type: TrackType.Event){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/seller_journey_work_harder"(platform: "/", type: TrackType.Event){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/seller_journey_do_something"(platform: "/", type: TrackType.Event){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/shipping_moderation_cross_docking_release_below"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/shipping_moderation_cross_docking_recovery"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/shipping_moderation_cross_docking_downgrade"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/buyer_absent_driver_action"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }

    "/notification_center/institutional_generic"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
        campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
        sent_date(required: false, type: PropertyType.String, description:"")
    }

    //Sll Advertising Notifications
    "/notification_center/sll_items_activate_items"(platform: "/") {
        site_id(required: true, type: PropertyType.String, description: "Site Id.")
        seller_id(required: true, type: PropertyType.String, description: "Customer Id.")
        items_count(required: true , type: PropertyType.Numeric, description: "Number of Items has to sell.")
    }

    "/notification_center/insurtech_imei_activation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_pending_payment"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_cancellation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

      /**
       * NOTIFICATIONS TRAY
       **/
      "/notification"(platform: "/") {
          event_type(required: true,
                  values: ["sent", "resent", "arrived", "received", "dismiss", "discarded", "open", "auto_dismiss", "shown", "action_open", "control", "carousel","purged_token", "swipe"],
          description: "Type of notification event")
          action_type(required: false,
                  values: ["deeplinking", "directions", "favorite", "reply", "ask", "postpone", "twitter_bar", "picture", "answer", "messages", "vop", "claims", "received", "tracking", "shipping_print_label", "feedback", "buy"])
          notification_type(required: false,
              values: ["deep_linking", "directions", "favorite", "reply", "ask", "postpone", "twitter_bar", "picture", "answer", "messages", "vop", "claims", "received", "tracking", "shipping_print_label", "feedback", "buy"])
          deeplink(required: false, description: "The link were the notification should navigate to, if applies")

          //For event_type:autodismiss, indicates why the notification was dismissed
          source(required: false,
                 values: ["notification_center","logout","overwrite","dismiss_notification"])

          discard_reason(required: false, description: "The discarded reason of the notification", values: ["invalid_payload","invalid_user", "settings_disabled"], type: PropertyType.String)

          notification_created_error(required: false, description: "The notification created error", type: PropertyType.String)

          news_id(required: false, description: "Identifier of the notification generated")
          notification_style(required: false, description: "The notification style used when displaying the notification to the user.")

          status(required: false, values: ["read", "unread"], deprecated: true, description: "*Deprecated*: Just for old NotifCenter.")

          device_id(required: false, description: "The real device_id, may differ from device field")
          device_status(required: false, values: ["active", "not_engaged"], description: "Device status at the moment")

          context(required: false, type: PropertyType.String)

          send_health_check(required: false, type: PropertyType.Boolean, description: "Indicates if notification has associated a health check's sent")
      }

    //Anses
    "/notification/anses_payment_date"(platform: "/") {}
    "/notification/anses_paid_benefit"(platform: "/") {}

    //Address
    "/notification/addresses_update_bad_address"(platform: "/") {}
    "/notification/addresses_update_bad_address_delivered"(platform: "/") {}

      //Account
      "/notification/account_fund_approved_mp"(platform: "/") {}
      "/notification/account_fund_approved_ml"(platform: "/") {}
      "/notification/account_fund_salary"(platform: "/") {}
      "/notification/account_fund_cvu"(platform: "/") {}
      "/notification/account_fund_approved_ted"(platform: "/") {}
      "/notification/account_fund_active_disabled_clabe"(platform: "/") {}
      "/notification/account_fund_bank_transfer"(platform: "/") {}
      "/notification/account_fund_iv_cvu_spb"(platform: "/") {}
      "/notification/account_fund_pending_clabe"(platform: "/") {}
      "/notification/account_fund_ticket"(platform: "/") {}
      "/notification/account_balance_approved_mp"(platform: "/") {}
      "/notification/account_balance_approved_ml"(platform: "/") {}
      "/notification/account_balance_create_ted_account"(platform: "/") {}

    // Credits - Credit Card
    // Collection
    "/notification/credit_card_collection_due_in_10"(platform: "/") {}
    "/notification/credit_card_collection_due_in_05"(platform: "/") {}
    "/notification/credit_card_collection_due_in_01"(platform: "/") {}
    "/notification/credit_card_collection_due_in_00"(platform: "/") {}
    "/notification/credit_card_collection_expired_01"(platform: "/") {}
    "/notification/credit_card_collection_expired_04"(platform: "/") {}
    "/notification/credit_card_collection_expired_05"(platform: "/") {}
    "/notification/credit_card_collection_expired_10"(platform: "/") {}
    "/notification/credit_card_collection_expired_15"(platform: "/") {}
    "/notification/credit_card_collection_expired_19"(platform: "/") {}
    "/notification/credit_card_collection_expired_20"(platform: "/") {}
    "/notification/credit_card_collection_expired_29"(platform: "/") {}
    "/notification/credit_card_collection_expired_30"(platform: "/") {}
    "/notification/credit_card_collection_expired_50"(platform: "/") {}
    "/notification/credit_card_collection_expired_53"(platform: "/") {}
    "/notification/credit_card_collection_expired_58"(platform: "/") {}
    // Transaction
    "/notification/credit_card_transaction_acquisition"(platform: "/") {}
    "/notification/credit_card_transaction_choff_purchase"(platform: "/") {}
    "/notification/credit_card_transaction_statement_payment"(platform: "/") {}
    "/notification/credit_card_transaction_purchase"(platform: "/") {}
    "/notification/credit_card_transaction_withdrawal"(platform: "/") {}

      "/notification/credits_consumer_about_to_expire_second_notice"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }
      "/notification/credits_consumer_expired_first_notice"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }
      "/notification/credits_consumer_expired_fourth_notice"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }
      "/notification/credits_consumer_expired_second_notice"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }
      "/notification/credits_consumer_expired_third_notice"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }
      "/notification/credits_consumer_first_time_use_notice"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }
      "/notification/credits_consumer"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }
      "/notification/credits_consumer_closing_date_notice"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }
    "/notification/credits_consumer_expired_sixty_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_expired_fortyfive_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_about_to_expire_first_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_congrats_personal_loans"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_expired_last_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_expired_n_loans_last_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_on_due_day_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }

    "/notification/credits_consumer_congrats_microlines"(platform: "/") {}

      "/notification/credits_consumer_expired_n_loans_first_notice"(platform: "/") {}
      "/notification/credits_consumer_about_to_expire_n_loans_first_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_n_loans_fourth_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_n_loans_second_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_n_loans_third_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_fortyfive_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_sixty_notice"(platform: "/") {}

      //Billing
      "/notification/billing_iva_ganancias_reactive"(platform: "/") {}
      "/notification/billing_newtax"(platform: "/") {}
      "/notification/billing_newtaxhabituality"(platform: "/") {}
      "/notification/billing_responsable_inscripto_reminder"(platform: "/") {}
      "/notification/billing_iva_isr_meli"(platform: "/") {}

    //Buybox
    "/notification/buybox_forced_item"(platform: "/") {}
    "/notification/buybox_forewarning"(platform: "/") {}
    "/notification/buybox_losing_item"(platform: "/") {}
    "/notification/buybox_losing_many"(platform: "/") {}

      //CX Question
      "/notification/cx_question_mp"(platform: "/") {
          case_id(required: true, type: PropertyType.Numeric, description: "Id of cx case.")
      }
      "/notification/cx_question_ml"(platform: "/") {
          case_id(required: true, type: PropertyType.Numeric, description: "Id of cx case.")
      }

      //Compliance Support
      "/notification/compliance_support_validations"(platform: "/") {}

      //Chargeback
      "/notification/chargeback_payer_start_ml"(platform: "/") {
          case_id(required: true, type: PropertyType.String, description: "Id of chargeback.")
      }
      "/notification/chargeback_payer_notify_ml"(platform: "/") {
          case_id(required: true, type: PropertyType.String, description: "Id of chargeback.")
      }
      "/notification/chargeback_payer_update_ml"(platform: "/") {
          case_id(required: true, type: PropertyType.String, description: "Id of chargeback.")
      }
      "/notification/chargeback_payer_ultimatum_ml"(platform: "/") {
          case_id(required: true, type: PropertyType.String, description: "Id of chargeback.")
      }
      "/notification/chargeback_payer_intensify_ml"(platform: "/") {
          case_id(required: true, type: PropertyType.String, description: "Id of chargeback.")
      }
      "/notification/chargeback_payer_high_agree_repayment_ml"(platform: "/") {
          case_id(required: true, type: PropertyType.String, description: "Id of chargeback.")
      }

    //Data
    "/notification/da_kyc_manual_review"(platform: "/") {}
    "/notification/data_privacy_about_to_expire"(platform: "/") {}
    "/notification/data_privacy_extend_expiration"(platform: "/") {}
    "/notification/data_privacy_ready"(platform: "/") {}

    //Drive Logistics
    "/notification/driver_logistics_changed_address"(platform: "/") {}
    "/notification/driver_logistics_retry_collect"(platform: "/") {}
    "/notification/driver_logistics_retry_delivery"(platform: "/") {}

      "/notification/instore_discover_activities"(platform: "/") {}
    "/notification/instore_buyer_qr"(platform: "/") {}

      "/notification/moderations_item_to_patch"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
      }

      "/notification/moderations_item_forbidden"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
      }

      "/notification/moderations_item_warning"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
      }

    //Multiplayer
    "/notification/multiplayer_money_request"(platform: "/") {}
    "/notification/multiplayer_ml_money_request"(platform: "/") {}
    "/notification/multiplayer_regulation"(platform: "/") {}
    "/notification/multiplayer_regulation_validated"(platform: "/") {}

    //Tu producto está en camino
    "/notification/shipping_shipped"(platform: "/") {
          shipment_id(required: true, description: "Id of shipment.")
    }
    "/notification/shipping_shipped_out_for_delivery"(platform: "/") {
        shipment_id(required: true, description: "Id of shipment.")
    }
    "/notification/shipping_shipped_retained_sender"(platform: "/") {
        shipment_id(required: true, description: "Id of shipment.")
    }
    "/notification/shipping_shipped_soon_deliver"(platform: "/") {
        shipment_id(required: true, description: "Id of shipment.")
    }

      //Retiro en sucursal
      "/notification/shipping_agency_withdrawal"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
          agency_to_agency(required:true, type:PropertyType.Boolean, description: "Indicates if package was sent to an agency in the first place or was shipped there because the user wasnt found in his address")
      }

      //Devolución de costo de envío por demora
      "/notification/shipping_delayed_bonus"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric)
      }

      //Tienes que despachar (para el vendedor)
      "/notification/shipping_pending"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      //Devolución por no entrega, a su dirección de despacho (para el vendedor)
      "/notification/shipping_returning_to_sender"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      //Te demoraste en el handling time (para el vendedor)
      "/notification/shipping_delayed_sender"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      //Tu paquete está demorado (para el comprador)
      "/notification/shipping_delayed_receiver"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
          delay_reason(required: true, type: PropertyType.String, description: "shipping_time or handling_time")
      }

      //Hubo un problema con tu paquete y te vamos a pagar (para el vendedor)
      "/notification/shipping_not_delivered_sender"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric)
      }

      //Hubo un problema con el envío (para el comprador)
      "/notification/shipping_not_delivered_receiver"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      //Paquete entregado
      "/notification/shipping_delivered"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      "/notification/shipping_delivered_express_return"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      "/notification/shipping_delivered_without_express_return"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      "/notification/shipping_delivered_express_return"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      "/notification/shipping_reminder_agency_withdrawal"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      //Paquete proximo a entregarse
      "/notification/shipping_soon_deliver"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      "/notification/shipping_self_service_shipped"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      "/notification/shipping_self_service_failed"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      "/notification/shipping_legacy_delivered"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/shipping_legacy_shipped"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/shipping_legacy_delayed_receiver"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
          order_id(required: true, type: PropertyType.Numeric)
          delay_reason(required: true, type: PropertyType.String, description: "shipping_time or handling_time")
      }
      "/notification/shipping_legacy_agency_withdrawal"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
          order_id(required: true, type: PropertyType.Numeric)
          agency_to_agency(required:true, type:PropertyType.Boolean, description: "Indicates if package was sent to an agency in the first place or was shipped there because the user wasnt found in his address")
      }
      "/notification/shipping_legacy_delayed_sender"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
          order_id(required: true, type: PropertyType.Numeric)
      }

      "/notification/shipping_legacy_not_delivered_receiver"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
          order_id(required: true, type: PropertyType.Numeric)
      }

      "/notification/shipping_legacy_reminder_agency_withdrawal"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
          order_id(required: true, type: PropertyType.Numeric)
      }

      "/notification/shipping_not_delivered_retained_sender"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

    "/notification/shipping_wrong_address_driver_action"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_shipped_withdrawal_to_agency_places"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_shipped_to_agency_places"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_reminder_places_withdrawal"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_not_delivered_waiting_for_withdrawal"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_not_delivered_soon_to_be_returned"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_delivered_cart_without_express_return"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_delivered_cart_express_return"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_buyer_absent_driver_action"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_handling_agency_unavailable"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_wrong_address_driver_action"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_agency_receiver_for_failed_delivery"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }

      //Seller questions
      "/notification/questions_new"(platform: "/") {
          question_id(required: true, type: PropertyType.Numeric)
      }

      //Buyer questions
      "/notification/questions_answered"(platform: "/") {
          question_id(required: true, type: PropertyType.Numeric)
      }

      "/notification/questions_buyer"(platform: "/") {}
      "/notification/questions_seller"(platform: "/") {}

      //New Sale
      "/notification/orders_new"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Cancel Order
      "/notification/orders_cancelled"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Deliver Defined  Order
      "/notification/orders_deliver_defined"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Deliver Updated Order
      "/notification/orders_deliver_updated"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Delivered Order
      "/notification/orders_delivered"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Timeout Confirmed Order
      "/notification/orders_timeout_confirmed"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Orders Deliver Confirmation
      "/notification/orders_deliver_confirmation"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Deprecated - typo @TODO Revisar este path para eliminarlo en el mediano plazo cuando las apps no lo envien mas
      "/notification/orders_buyer"(platform: "/") {
          newsgroup_id(required: false, type: PropertyType.String)
          type_layout(required: false, type: PropertyType.String)
          type(required: false, type: PropertyType.String, deprecated: true, description: "type of order notification.")
      }

      "/notification/orders_seller"(platform: "/") {
          newsgroup_id(required: false, type: PropertyType.String)
          type_layout(required: false, type: PropertyType.String)
          type(required: false, type: PropertyType.String, description: "type of order notificaction.")
      }


    //Orders Ticket Payment
    "/notification/orders_ticket_payment_pending_extend_expiration_general_notice"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric)
        experiment_id(required: false, description: "Id of the experiment related to the order notification sent.")
    }
    "/notification/orders_ticket_payment_pending_close_expiration_general_notice"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric)
        experiment_id(required: false, description: "Id of the experiment related to the order notification sent.")
    }
    "/notification/orders_ticket_boleto_payment_pending"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric)
        experiment_id(required: false, description: "Id of the experiment related to the order notification sent.")
    }
    "/notification/orders_ticket_payment_pending"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric)
        experiment_id(required: false, description: "Id of the experiment related to the order notification sent.")
    }
    "/notification/orders_ticket_payment_pending_day_expiration_general_notice"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric)
        experiment_id(required: false, description: "Id of the experiment related to the order notification sent.")
    }
    "/notification/orders_ticket_payment_pending_reminder_general_notice"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric)
        experiment_id(required: false, description: "Id of the experiment related to the order notification sent.")
    }


      //Reviews
      "/notification/reviews_reminder"(platform: "/") {}

      //Generic Campaigns
      "/notification/campaigns_campaigns"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
      }

      "/notification/campaigns_generic"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          campaign_type(required: true,type: PropertyType.String, description: "Type of the campaign related to the notification sent.")
          campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
          communication_id(required: false, type: PropertyType.String, description: "Hermes communication id.")
      }

      "/notification/campaigns_sms"(platform: "/", type: TrackType.Event) {
          segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
          experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
          communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
          communication_data(required: false, type: PropertyType.String, description: "Extra data")
          campaign_type(required: false, type: PropertyType.Boolean, description: "Communication type")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          event_type(required: true, type: PropertyType.String, description: "event type of send notification.")
      }

      "/notification/mpcampaigns_sms"(platform: "/", type: TrackType.Event) {
          segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
          experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
          communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
          communication_data(required: false, type: PropertyType.String, description: "Extra data")
          campaign_type(required: false, type: PropertyType.Boolean, description: "Communication type")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          event_type(required: true, type: PropertyType.String, description: "event type of send notification.")
      }

    "/notification/institutional_sms"(platform: "/", type: TrackType.Event) {
        segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
        experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
        communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
        communication_data(required: false, type: PropertyType.String, description: "Extra data")
        campaign_type(required: false, type: PropertyType.Boolean, description: "Communication type")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
        event_type(required: true, type: PropertyType.String, description: "event type of send notification.")
    }

    "/notification/mpinstitutional_sms"(platform: "/", type: TrackType.Event) {
        segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
        experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
        communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
        communication_data(required: false, type: PropertyType.String, description: "Extra data")
        campaign_type(required: false, type: PropertyType.Boolean, description: "Communication type")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
        event_type(required: true, type: PropertyType.String, description: "event type of send notification.")
    }

      //MKT Deals
      "/notification/campaigns_deals"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the mkt notification sent.")
          deal_id(required: true, type: PropertyType.String, description: "Id of the deal related to the mkt notification sent.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
      }

      //Cart Campaigns
      "/notification/campaigns_cart_recovery"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
      }

       //Marketplace Discounts
      "/notification/campaigns_marketplace_discounts"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
      }

      "/notification/campaigns_checkout_recovery"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the campaigns notification sent.")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
          item_id(required: true, type: PropertyType.String)
          variation_id(required: false, type: PropertyType.String, description: "Id of variaton of the item.")
          experiment(required: false, type: PropertyType.Boolean)
      }
      "/notification/campaigns_acho_reminder"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the campaigns notification sent.")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
          variation_id(required: false, type: PropertyType.String, description: "Id of variation.")
          item_id(required: true, type: PropertyType.String)
      }
      "/notification/campaigns_ticket_recovery"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the campaigns notification sent.")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
      }
      "/notification/campaigns_cho_cart_recovery"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the campaigns notification sent.")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
          items(required: false, type: PropertyType.String)
          experiment(required: false, type: PropertyType.Boolean)
      }
      //
      "/notification/campaigns_deal_alert"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
          item_id(required: true, type: PropertyType.String)
      }
      // Recharge recovery campaigns
      "/notification/campaigns_recharge_recovery"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the campaigns notification sent.")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
          experiment(required: false, type: PropertyType.Boolean)
      }
      "/notification/campaigns_download_app"(platform: "/", type: TrackType.Event) {}
      //Freemium SYI
      "/notification/campaigns_syi_freemium"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the SYI Freemium notification sent.")
      }
      //Tu cobro fué acreditado
      "/notification/collections_approved"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Dropout de CHO
      "/notification/purchase_pending"(platform: "/") {
          item_id(required: true, type: PropertyType.String)
      }

      "/notification/orders_pending"(platform: "/") {
          item_id(required: true, type: PropertyType.String)
      }

      //Payment approved
      "/notification/purchases_payments_approved"(platform: "/") {
          purchase_id(required: true, type: PropertyType.Numeric)
      }

      //Payment rejected
      "/notification/purchases_payments_rejected"(platform: "/") {
          purchase_id(required: true, type: PropertyType.Numeric)
      }

    //Payment Ticket
    "/notification/payments_ticket_boleto_pending_reminder"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric)
        item_id(required: true, type: PropertyType.String)
    }

      "/notification/purchase_invoice"(platform: "/") {}

      //Qrviral
      "/notification/qrviral_onboard"(platform: "/") {}
      "/notification/qrviral_onboard_recharge"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
      }
      "/notification/qrviral_reminder"(platform: "/") {}
      "/notification/qrviral_extension"(platform: "/") {}
      "/notification/qrviral_reminder_mp"(platform: "/") {}


      //Quotes
      "/notification/quotes_reject"(platform: "/") {}
      "/notification/quotes_new"(platform: "/") {}
      "/notification/quotes_cancel"(platform: "/") {}
      "/notification/quotes_answer_send"(platform: "/") {}
      "/notification/quotes_answer_pending"(platform: "/") {}

      //Listings
      "/notification/listings"(platform: "/") {}
      "/notification/listings_upgrade"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
          vertical(required: true, type: PropertyType.String, description: "vertical.")
      }
      "/notification/listings_relist"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
          vertical(required: true, type: PropertyType.String, description: "vertical.")
      }

      //Me Flex
      "/notification/me_flex_optin_activation"(platform: "/") {}
      "/notification/me_flex_optin_reminder"(platform: "/") {}
      "/notification/me_flex_rehunting_generic"(platform: "/") {}
      "/notification/me_flex_rehunting_address"(platform: "/") {}
      "/notification/me_flex_hunting_generic"(platform: "/") {}

      //Mediations
      "/notification/mediations_complainant"(platform: "/") {
          claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
      }
      "/notification/mediations_respondent"(platform: "/") {
          claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
      }
      "/notification/mediations_legacy_complainant"(platform: "/") {
          claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Moderation
      "/notification/moderations_item_to_patch"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
      }

      "/notification/moderations_item_forbidden"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
      }

      "/notification/moderations_item_warning"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
      }

      "/notification/moderations_message_banned"(platform: "/") {}

      //Carousel
      "/notification/carousel"(platform: "/") {
          action_carousel(required: true, values: ["next", "prev"])
      }

      //Payments
      "/notification/payments_pending_reminder"(platform: "/") {
          item_id(required: true, type: PropertyType.String)
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/payments_approved"(platform: "/") {
          item_id(required: true, type: PropertyType.String)
          order_id(required: true, type: PropertyType.Numeric)
      }

      "/notification/payments_rejected"(platform: "/") {
          item_id(required: true, type: PropertyType.String)
          order_id(required: true, type: PropertyType.Numeric)
      }

      /* ============================================================ */
      /* Team: IT Payments - Payroll | Initiative: Salary Portability */
      /*                       contact: payroll-devs@mercadolibre.com */
      "/notification/payroll_portability_request_accepted"(platform: "/") {
          portability_request_id(required: true, type: PropertyType.String)
      }

      "/notification/payroll_portability_request_denied"(platform: "/") {
          portability_request_id(required: true, type: PropertyType.String)
      }

      "/notification/payroll_portability_request_failed"(platform: "/") {
          portability_request_id(required: true, type: PropertyType.String)
      }

      "/notification/payroll_portability_request_integrated"(platform: "/") {
          portability_request_id(required: true, type: PropertyType.String)
      }

      "/notification/payroll_portability_first_salary"(platform: "/") {
          portability_id(required: true, type: PropertyType.String)
      }

      "/notification/payroll_portability_ted_rejected"(platform: "/") {
          portability_id(required: true, type: PropertyType.String)
      }

      "/notification/payroll_kyc_accepted"(platform: "/") {}

    "/notification/payroll_kyc_approved"(platform: "/") {}
      /* ------------------------------------------------------------ */

      //Puis
      "/notification/puis_agency_withdrawal"(platform: "/") {
          pickup_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/puis_confirmation"(platform: "/") {
          pickup_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/puis_picked_up"(platform: "/") {
          pickup_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/puis_reschedule"(platform: "/") {
          pickup_id(required: true, type: PropertyType.Numeric)
      }

      //Deprecated - typo
      "/notification/payments_pending_remainder"(platform: "/") {
          item_id(required: true, type: PropertyType.String)
          order_id(required: true, type: PropertyType.Numeric)
      }

    //Messages
    "/notification/messages_new"(platform: "/") {}
    "/notification/messages_read"(platform: "/") {}
    "/notification/messages_driver_logistics"(platform: "/") {}
    "/notification/messages_driver_flex"(platform: "/") {}
    "/notification/messages_flex"(platform: "/") {}
    "/notification/messages_quotes"(platform: "/") {}

    // Crowdsourcing driver
    "/notification/me_crowd_multiple_offers_available"(platform: "/") {}
    "/notification/me_crowd_upcoming_trip_forewarn"(platform: "/") {}
    "/notification/me_crowd_canceled_order_warning"(platform: "/") {}

    //Money
    "/notification/money_advance_congrats"(platform: "/") {}
    "/notification/money_advance_fail"(platform: "/") {}
    "/notification/money_split_started"(platform: "/") {}
    "/notification/money_split_rejected_push"(platform: "/") {}
    "/notification/money_split_rejected"(platform: "/") {}
    "/notification/money_split_paid_push"(platform: "/") {}
    "/notification/money_split_paid"(platform: "/") {}
    "/notification/money_request_started"(platform: "/") {}
    "/notification/money_request_rejected_push"(platform: "/") {}
    "/notification/money_request_rejected"(platform: "/") {}
    "/notification/money_request_finished"(platform: "/") {}
    "/notification/money_out_cashout"(platform: "/") {}
    "/notification/money_split_finished"(platform: "/") {}
    "/notification/money_request_paid_push"(platform: "/") {}
    "/notification/money_out_cashoutmlb_rejected_manualreview"(platform: "/") {}
    "/notification/money_out_cashoutmlb_rejected"(platform: "/") {}
    "/notification/money_out_cashoutmlb_pending"(platform: "/") {}
    "/notification/money_out_cashoutmlb_approved"(platform: "/") {}
    "/notification/money_out_cashout_withdrawn"(platform: "/") {}
    "/notification/money_out_cashout_reversed"(platform: "/") {}
    "/notification/money_in_cashin_exceeded_cap"(platform: "/") {}

      //Reputation
      "/notification/reputation"(platform: "/") {
          newsgroup_id(required: false, type: PropertyType.String)
          type_layout(required: false, type: PropertyType.String)
          type(required: false, type: PropertyType.String)
          latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
          latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
      }
      "/notification/reputation_free_shipping_activation"(platform: "/") {}
      "/notification/reputation_free_shipping_deactivation"(platform: "/") {}
      "/notification/reputation_medal_lost_reminder"(platform: "/") {}

      //Reservations
      "/notification/reservations_new"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/reservations_reminder"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/reservations_confirmed"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/reservations_buyer_confirm_delivery"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/reservations_seller_confirm_delivery"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/reservations_timeout_buyer_cancel"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/reservations_seller_cancel"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/reservations_timeout_seller_cancel"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/reservations_buyer_confirm_delivery_reminder"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }
      "/notification/reservations_buyer_cancel"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Notification suggested discounts
      "/notification/campaigns_suggested_discounts_seller"(platform: "/") {
          item_id(required: false, type: PropertyType.String, description: "Id of item.")
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
      }
      "/notification/campaigns_suggested_discounts_buyer"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
      }

      "/notification/campaigns_remarketing"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
          hash(required: false, type: PropertyType.String, description: "Hash of the message in claim check.")
          mantika_id(required: false, type: PropertyType.String, description: "Id of Mantika XP.")
          items_recommendations(required: true, type: PropertyType.String, description: "Items sent from recommendations.")
          items_history(required: true, type: PropertyType.String, description: "Items sent from history.")
      }

      "/notification/campaigns_remarketing_motors"(platform: "/") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        item_id(required: true, type: PropertyType.String, description: "Item Id.")
      }

      "/notification/campaigns_control_group"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
          campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
          deal_id(required: false, type: PropertyType.String, description: "Id of deal.")
      }

      //Packages
      "/notification/packages_new"(platform: "/") {
          purchase_id(required: true, type: PropertyType.Numeric, description: "date of send notification.")
          pack_id(required: true, type: PropertyType.Numeric, description: "Id of batch.")
      }

      //Fraud
      "/notification/fraud_identity_validation"(platform: "/") {}
      "/notification/fraud_delivery_cancellation_stop_ml"(platform: "/") {}
      "/notification/fraud_cash_release_iv"(platform: "/") {}
      "/notification/fraud_iv_credentials"(platform: "/") {}
      "/notification/fraud_score_post_approval_last_chance_mp"(platform: "/") {}
      "/notification/fraud_score_post_approval_last_chance_ml"(platform: "/") {}
      "/notification/fraud_remedies_trust_vote_ml"(platform: "/") {}
      "/notification/fraud_delivery_cancellation_stop_mp"(platform: "/") {}
      "/notification/fraud_poc_trust_vote_second_score"(platform: "/") {}

      //Loyalty
      "/notification/loyalty"(platform: "/") {}
      "/notification/loyalty_welcome"(platform: "/") {}
      "/notification/loyalty_milestone"(platform: "/") {}
      "/notification/loyalty_change_level"(platform: "/") {}
      "/notification/loyalty_freeshipping"(platform: "/") {}

      //Returns
      "/notification/returns_return_cancelled"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_return_expired"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_shipped_seller"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_init_return"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_init_return_buyer"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_refund_payment"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_reminder_printed"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_no_refund_payment"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_pickup_expired"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_reminder_not_printed"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_refund_account_money"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_no_shipping_option"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
      "/notification/returns_label_unavailable"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
      }
    "/notification/returns_refund_bank_transfer"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
    }

    //Security
    "/notification/security_enrollment"(platform: "/") {}
    "/notification/security_phone_confirmation"(platform: "/") {}
    "/notification/security_event_feedback"(platform: "/") {}
    "/notification/security_account_validation"(platform: "/") {}
    "/notification/security_login_auth"(platform: "/") {}
    "/notification/security_device_authorization"(platform: "/") {}
    "/notification/security_recovery_canceled"(platform: "/") {}
    "/notification/security_login_code"(platform: "/") {}
    "/notification/security_enroll_screenlock_app"(platform: "/") {}

      //Health Check
      "/notification/health_check"(platform: "/") {
          original_news_id( required: false, type: PropertyType.String, description: "Original identifier of the notification generated" )
      }

    //Asset Management
    "/notification/asset_management_warm_up"(platform: "/mobile") {}
    "/notification/asset_management_investing"(platform: "/mobile") {}
    "/notification/asset_management_pending"(platform: "/mobile") {}
    "/notification/asset_management_disabled"(platform: "/mobile") {}

    //Campañas
    "/notification/mpcampaigns_campaigns"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
        campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
        sent_date(required: false, type: PropertyType.String, description: "Campaign sent date.")
    }
    "/notification/mpcampaigns_control_group"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
        sent_date(required: false, type: PropertyType.String, description: "Campaign sent date.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        deal_id(required: false, type: PropertyType.String, description: "Id of deal.")
    }
    "/notification/mpcampaigns_mpcampaignspromo"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
    }
    "/notification/mpcampaigns_mpcampaignsinfo"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
    }
    "/notification/subscription_expiring_notice"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        payment_option(required: false, type: PropertyType.String, description: "Payment option specified in the notification.")
    }
    "/notification/subscription_payment_congrats"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Type of congrats.")
    }
    "/notification/subscription_payment_error"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        error_type(required: false, type: PropertyType.String, description: "Payment error type.")
    }
    "/notification/subscription_payment_instructions"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        payment_option(required: false, type: PropertyType.String, description: "Payment option specified in the notification.")
    }
    "/notification/subscription_payment_pending"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Payment pending type.")
    }
    "/notification/subscription_disney_activation_on"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Payment pending type.")
    }
    "/notification/subscription_disney_activation_off"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Payment pending type.")
    }
    "/notification/subscription_disney_activation_free_trial"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Payment pending type.")
    }

    "/notification/mp_sponsor_campaign_start_campaign"(platform: "/mobile") {}
    "/notification/mp_sponsor_campaign_budget_trigger"(platform: "/mobile") {}
    "/notification/mp_sponsor_campaign_day_trigger"(platform: "/mobile") {}
    "/notification/mp_seller_campaign_start_campaign"(platform: "/mobile") {}
    "/notification/mp_seller_campaign_end_campaign"(platform: "/mobile") {}
    "/notification/mp_seller_marketplace_must"(platform: "/mobile") {}
    "/notification/mp_seller_generic_wish"(platform: "/mobile") {}
    "/notification/mp_seller_discount_center_must"(platform: "/mobile") {}

    //Credits Merchants
    "/notification/credits_merchants_educational"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric)
    }
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
    "/notification/credits_merchants_expired_near_to_fixed_charges"(platform: "/mobile") {}
    "/notification/credits_merchants_expired_near_to_daily_charges"(platform: "/mobile") {}
    "/notification/credits_merchants_to_expire_standard"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_to_expire_not_standard"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }

    "/notification/credits_merchants_em_to_expire_01"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_em_expired_no_charges_today"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_em_expired_daily_charges_01"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_em_expired_daily_charges_04"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_em_expired_daily_charges_07"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_em_expired_daily_charges_10"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_std_expired_daily_charges_30"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_std_expired_daily_charges_60"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_std_expired_daily_charges_75"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_std_expired_daily_charges_90"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_std_expired_daily_charges_110"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_em_congrats"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_em_collected"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_spl_congrats"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_std_finished_loan_payment"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }

    "/notification/coverages_compensation_complainant"(platform: "/mobile") {
        activity_id(required: true , type: PropertyType.String)
    }

    "/notification/cancellations_warning_seller_suspended"(platform: "/") {}
    "/notification/cancellations_warning_seller_too_many"(platform: "/") {}
    "/notification/cancellations_notice_delayed_reimbursement"(platform: "/") {}
    "/notification/cancellations_notice_cancelled_purchase"(platform: "/") {}
    "/notification/cancellations_notice_cancelled_purchase_proximity"(platform: "/mobile") {}

    "/notification/seller_journey_congrats"(platform: "/mobile"){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
    }
    "/notification/seller_journey_keep_it_up"(platform: "/mobile"){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
    }
    "/notification/seller_journey_work_harder"(platform: "/mobile"){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
    }
    "/notification/seller_journey_do_something"(platform: "/mobile"){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
    }

    //Inivite Gift
    "/notification/invite_gift"(platform: "/mobile") {}

    //Profile missing data notification
    "/notification/discount_central_missing_data"(platform: "/mobile") {}

    //Merchants
    "/notification/merchants_growth_mgm"(platform: "/mobile") {
        gift_reason_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification/merchants_growth_fdv_failure"(platform: "/mobile") {}
    "/notification/merchants_growth_fdv_recovery"(platform: "/mobile") {}
    "/notification/merchants_growth_fdv_success"(platform: "/mobile") {}
    "/notification/merchants_growth_fdv_warning"(platform: "/mobile") {}
    "/notification/merchants_growth_paper_roll_first_request"(platform: "/mobile") {}
    "/notification/merchants_growth_paper_roll_recurrent_request"(platform: "/mobile") {}
    "/notification/merchants_growth_paper_roll_reminder"(platform: "/mobile") {}
    "/notification/merchants_growth_resellers_caps"(platform: "/mobile") {}
    "/notification/merchants_growth_resellers_newland_nfc_launch"(platform: "/mobile") {}
    "/notification/merchants_growth_resellers_prizes"(platform: "/mobile") {}
    "/notification/merchants_growth_resellers_pro2_launch"(platform: "/mobile") {}
    "/notification/merchants_growth_resellers_smart_launch"(platform: "/mobile") {}
    "/notification/merchants_growth_sameday"(platform: "/mobile") {}

    //Flows
    "/notification/flows_default"(platform: "/mobile") {
        initiative_code(required: true, type: PropertyType.String)
    }

    //Growth
    "/notification/growth_tooling_mgm_kyc_booster"(platform: "/mobile") {}
    "/notification/growth_tooling_mgm_kyc_guest"(platform: "/mobile") {}

    //killers
    "/notification/killers_winner_item_recover"(platform: "/mobile") {}
    "/notification/killers_winner_item_new"(platform: "/mobile") {}
    "/notification/killers_losing_item_buybox"(platform: "/mobile") {}
    "/notification/killers_loser_item_new"(platform: "/mobile") {}

    //kyc
    "/notification/kyc_handoff_user_notification_ml"(platform: "/mobile") {}
    "/notification/kyc_handoff_user_notification_mp"(platform: "/mobile") {}
    "/notification/kyc_user_notification_mp"(platform: "/mobile") {}
    "/notification/kyc_user_notification_ml"(platform: "/mobile") {}
    "/notification/kyc_bo_success"(platform: "/mobile") {}
    "/notification/kyc_afip_user_notification_mp"(platform: "/mobile") {}

    //Money
    "/notification/money_transfer_received"(platform: "/mobile") {}
    "/notification/money_transfer_request"(platform: "/mobile") {}

    //Openplatform
    "/notification/openplatform_sellers_inhouse"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
    }
    "/notification/openplatform_recommendations_wannabe"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
    }
    "/notification/openplatform_recommendations_p4"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
    }
    "/notification/openplatform_recommendations_p3"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
    }
    "/notification/openplatform_recommendations_p2"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
    }
    "/notification/openplatform_recommendations_p1"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
    }

    //Payments
    "/notification/payments_release"(platform: "/mobile") {
        notification_id(required: true, type: PropertyType.String)
    }

    //Hybrid
    "/notification/card_request_challenge_pending"(platform: "/mobile") {}
    "/notification/card_correios_strike_delayed"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_first_day"(platform: "/") {}
    "/notification/card_first_use_incentive_fourteenth_day"(platform: "/") {}
    "/notification/card_first_use_incentive_seventh_day"(platform: "/") {}
    "/notification/card_first_use_incentive_twentyoneth_day"(platform: "/") {}
    "/notification/card_flow_incentive_prepaid_acquisition_first"(platform: "/") {}
    "/notification/card_flow_incentive_prepaid_acquisition_second"(platform: "/") {}
    "/notification/card_freeze_rejected_authorization"(platform: "/") {}
    "/notification/card_freeze_rejected_withdraw"(platform: "/") {}
    "/notification/card_limit_rejected_withdraw_by_limit"(platform: "/") {}
    "/notification/card_limit_rejected_withdraw_by_maximum_limit"(platform: "/") {}
    "/notification/card_offering_physical_card"(platform: "/") {}
    "/notification/card_offering_transaction_generic_opt_in_ppd_to_hybrid"(platform: "/") {}
    "/notification/card_offering_transaction_opt_in_ppd_to_hybrid"(platform: "/") {}
    "/notification/card_pin_invalid_pin_first_tries"(platform: "/") {}
    "/notification/card_pin_invalid_pin_fourth_try"(platform: "/") {}
    "/notification/card_pin_pin_blocked"(platform: "/") {}
    "/notification/card_reminders_pin_reminder"(platform: "/") {}
    "/notification/card_reminders_virtual_digital_services"(platform: "/") {}
    "/notification/card_request_challenge_expired"(platform: "/") {}
    "/notification/card_request_challenge_pending"(platform: "/") {}
    "/notification/card_kyc_data_completed_nfc_acquisition"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_physical_acquisition"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_unlock"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_virtual"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_prepaid_acquisition_first"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_prepaid_acquisition_second"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_prepaid_acquisition_third"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_virtual_acquisition"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_zero_day"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_second_day"(platform: "/mobile") {
        has_money(required: true, type: PropertyType.Boolean)
    }
    "/notification/card_unlock_incentive_fifth_day"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_tenth_day"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_fifteenth_day"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_twentyfifth_day"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_fourtyfifth_day"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_ready_to_ship"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_shipped"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_soon_deliver"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_delayed"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_branch"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_not_delivered"(platform: "/mobile") {}
    "/notification/cards_send_card"(platform: "/mobile") {}
    "/notification/card_nip_first_try"(platform: "/mobile") {}
    "/notification/card_nip_second_try"(platform: "/mobile") {}
    "/notification/card_nip_nip_block"(platform: "/mobile") {}
    "/notification/card_limit_rejected_withdraw_by_maximum_limit"(platform: "/mobile") {}
    "/notification/card_nip_set_nip"(platform: "/mobile") {}
    "/notification/card_wallet_resume_token"(platform: "/mobile") {}

    //Prepaid
    "/notification/card_transactions_balance_atm"(platform: "/mobile") {}
    "/notification/card_transactions_payment_reject_whit_contactless"(platform: "/mobile") {}
    "/notification/card_transactions_approved_authorization"(platform: "/mobile") {}
    "/notification/card_transactions_approved_withdraw"(platform: "/mobile") {}
    "/notification/card_transactions_cancelled_authorization"(platform: "/mobile") {}
    "/notification/card_transactions_capture_exceed_amount"(platform: "/mobile") {}
    "/notification/card_transactions_first_transaction_chip_pin"(platform: "/mobile") {}
    "/notification/card_transactions_rejected_authorization_by_invalid_amount"(platform: "/mobile") {}
    "/notification/card_transactions_rejected_authorization_by_invalid_amount_with_unavailable_balance"(platform: "/mobile") {}
    "/notification/card_transactions_rejected_authorization_international_by_invalid_amount"(platform: "/mobile") {}
    "/notification/card_transactions_rejected_withdraw_by_invalid_amount"(platform: "/mobile") {}
    "/notification/card_transactions_rejected_withdraw_by_invalid_amount_with_unavailable_balance"(platform: "/mobile") {}
    "/notification/card_transactions-approved_authorization_whatsapp"(platform: "/mobile") {}
    "/notification/card_transactions-approved_withdraw_mute"(platform: "/mobile") {}
    "/notification/card_transactions-fund_money_in_whatsapp"(platform: "/mobile") {}
    "/notification/card_transactions-fund_money_in_whatsapp_mute"(platform: "/mobile") {}

    "/notification/card_transactions_cancelled_withdraw"(platform: "/mobile") {}
    "/notification/card_transactions_capture_after_ttl"(platform: "/mobile") {}
    "/notification/card_transactions_capture_expired_ttl"(platform: "/mobile") {}
    "/notification/card_transactions_capture_less_than_amount"(platform: "/mobile") {}
    "/notification/card_transactions_chargeback_reimbursed"(platform: "/mobile") {}
    "/notification/card_transactions_rejected_authorization_virtual_wrong_cvv"(platform: "/mobile") {}
    "/notification/card_transactions_transaction_invalid_amount_option_credit"(platform: "/mobile") {}

    "/notification/card_wallet_insufficient_account_balance"(platform: "/mobile") {}

    //Prepaidbuild.gradle
    "/notification/prepaid_card_shipped"(platform: "/mobile") {}
    "/notification/prepaid_card_waiting_for_withdrawal"(platform: "/mobile") {}
    "/notification/prepaid_card_delivered"(platform: "/mobile") {}
    "/notification/prepaid_card_delayed_p1"(platform: "/mobile") {}
    "/notification/prepaid_card_not_delivered"(platform: "/mobile") {}
    "/notification/prepaid_card_third_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_second_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_invalid_pin"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_approved_authorization"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_approved_withdraw"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_canceled_authorization"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_canceled_withdraw"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_withdraw_freeze"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_regulations_bacen_data_incomplete"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_authorization_freeze"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_by_kyc"(platform: "/mobile") {}
    "/notification/prepaid_card_compliant_kyc"(platform: "/mobile") {}
    "/notification/prepaid_card_reissue_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_delivery"(platform: "/mobile") {}
    "/notification/prepaid_card_challenge_bolbradesco_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_red_link_bug"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_international_authorization_by_invalid_amount"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_international_authorization_by_fraud_prevention"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount"(platform: "/mobile") {}
    "/notification/prepaid_card_soon_deliver"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_for_not_transaction"(platform: "/mobile") {}
    "/notification/prepaid_card_reprogrammed"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_invalid_amount_option_credit"(platform: "/mobile") {}

    //Protected Purchase
    "/notification/protected_purchase_order_reminder_purchase_protection"(platform: "/mobile") {}

    //Pix
    "/notification/pix_transfer_mo_rejected"(platform: "/mobile") {}
    "/notification/pix_transfer_mo_manual_review"(platform: "/mobile") {}
    "/notification/pix_transfer_mi_approved"(platform: "/mobile") {}
    "/notification/pix_transfer_mo_approved"(platform: "/mobile") {}
    "/notification/pix_key_portability_request"(platform: "/mobile") {}
    "/notification/pix_key_portability_rejected"(platform: "/mobile") {}
    "/notification/pix_key_portability_approved"(platform: "/mobile") {}
    "/notification/pix_key_claim_request"(platform: "/mobile") {}
    "/notification/pix_key_claim_rejected"(platform: "/mobile") {}
    "/notification/pix_key_claim_key_expired"(platform: "/mobile") {}
    "/notification/pix_key_claim_key_deleted"(platform: "/mobile") {}
    "/notification/pix_key_claim_approved"(platform: "/mobile") {}

    //Point
    "/notification/point_shipping_ready_to_ship"(platform: "/mobile") {}
    "/notification/point_shipping_shipped"(platform: "/mobile") {}
    "/notification/point_shipping_not_delivered"(platform: "/mobile") {}
    "/notification/point_shipping_waiting_for_withdrawal"(platform: "/mobile") {}
    "/notification/point_shipping_delayed_p1"(platform: "/mobile") {}
    "/notification/point_shipping_delayed_p4_p8"(platform: "/mobile") {}
    "/notification/point_shipping_ready_to_ship_delayed"(platform: "/mobile") {}
    "/notification/point_audit_cash"(platform: "/mobile") {}
    "/notification/point_pos_closed"(platform: "/mobile") {}
    "/notification/point_pos_close_soon"(platform: "/mobile") {}
    "/notification/point_improvement"(platform: "/mobile") {}
    "/notification/point_voucher_sodexo"(platform: "/mobile") {}
    "/notification/point_pix"(platform: "/mobile") {}

    //Partners
    "/notification/partners_pin_ml"(platform: "/mobile") {
        partner(required: true, type: PropertyType.String)
    }
    "/notification/partners_pin_mp"(platform: "/mobile") {
        partner(required: true, type: PropertyType.String)
    }

    //Recurring Recharge
    "/notification/recurring_recharge_insufficient_balance_error"(platform: "/mobile") {}

    //Seller QR
    "/notification/seller_qr_payment_received"(platform: "/mobile") {}
    "/notification/seller_integrations_new_payment"(platform: "/mobile") {}
    "/notification/seller_integrations_erase_name"(platform: "/mobile") {}

    //Single player
    "/notification/single_player_directv_smartcard_expiration"(platform: "/mobile") {}
    "/notification/single_player_payment_reminder"(platform: "/mobile") {
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/single_player_recharge_fail_ml"(platform: "/mobile") {}
    "/notification/single_player_recharge_fail_mp"(platform: "/mobile") {}
    "/notification/single_player_recharge_success_ml"(platform: "/mobile") {}
    "/notification/single_player_recharge_success_mp"(platform: "/mobile") {}
    "/notification/single_player_utility_success_mp"(platform: "/mobile") {}
    "/notification/single_player_utility_fail_mp"(platform: "/mobile") {}
    "/notification/single_player_transport_success_mp"(platform: "/mobile") {}
    "/notification/single_player_utility_success_mp"(platform: "/mobile") {}
    "/notification/single_player_utility_fail_mp"(platform: "/mobile") {}
    "/notification/single_player_transport_success_mp"(platform: "/mobile") {}
    "/notification/single_player_transport_fail_mp"(platform: "/mobile") {}
    "/notification/single_player_prepaid_toll_success_mp"(platform: "/mobile") {}
    "/notification/single_player_prepaid_toll_fail_mp"(platform: "/mobile") {}
    "/notification/single_player_antenna_fail_mp"(platform: "/mobile") {}
    "/notification/single_player_antenna_success_mp"(platform: "/mobile") {}
    "/notification/single_player_generic_balance_expiration"(platform: "/mobile") {}
    "/notification/single_player_payment_reminder_new_grouped_debt"(platform: "/mobile") {
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/single_player_payment_reminder_expiring_grouped_debt"(platform: "/mobile") {
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/single_player_payment_reminder_new_solo_debt"(platform: "/mobile") {
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/single_player_new_debt_utility_mp"(platform: "/mobile") {
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/single_player_expired_debt_utility_mp"(platform: "/mobile") {
        debt_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/single_player_payg_unlock_device_mp"(platform: "/mobile") {}
    "/notification/single_player_payg_new_debt_without_block_mp"(platform: "/mobile") {}
    "/notification/single_player_payg_create_device_success_mp"(platform: "/mobile") {}
    "/notification/single_player_payg_blocked_device_mp"(platform: "/mobile") {}
    "/notification/single_player_payg_cashback_mp"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_grouped_rejected"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_grouped_reminder"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_grouped_success"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_solo_rejected"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_solo_reminder"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_solo_success"(platform: "/mobile") {}

    //Shipping
    "/notification/shipping_moderation_cross_docking_release_below"(platform: "/") {}
    "/notification/shipping_moderation_cross_docking_recovery"(platform: "/") {}
    "/notification/shipping_moderation_cross_docking_downgrade"(platform: "/") {}
    //Shipping-Scoring
    "/notification/shipping_wrong_address_driver_action"(platform: "/mobile") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    "/notification/shipping_buyer_absent_driver_action"(platform: "/mobile") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    "/notification/shipping_scoring_keyword_created"(platform: "/mobile") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    //Wallet
    "/notification/wallet_integrator_insufficient_amount"(platform: "/mobile") {}
    "/notification/wallet_integrator_payment_success"(platform: "/mobile") {}
    "/notification/wallet_integrator_insufficient_funds"(platform: "/mobile") {}
    "/notification/wallet_integrator_insufficient_funds"(platform: "/mobile") {}
    "/notification/wallet_integrator_personal_loan"(platform: "/mobile") {}

    //Withdraw
    "/notification/withdraw_approved_contingency"(platform: "/", type: TrackType.Event) {} //At web, only mp business
    "/notification/withdraw_rejected_contingency"(platform: "/", type: TrackType.Event) {}
    "/notification/withdraw_approved"(platform: "/", type: TrackType.Event) {} //At web, only mp business
    "/notification/withdraw_rejected"(platform: "/", type: TrackType.Event) {}

    //Phone Enrollment
    "/notification/security_phone_enrollment"(platform: "/web", type: TrackType.Event) {}

    //Merchant Services
    "/notification/mss_alliance"(platform: "/web", type: TrackType.Event) {}
    "/notification/mss_gplay"(platform: "/web", type: TrackType.Event) {}

    //Fiscal Data
    "/notification/fiscal_data_mp_business_registration"(platform: "/web", type: TrackType.Event) {}

    "/notification/installs_checker"(platform: "/mobile") {
        date_created(required: true, type: PropertyType.String, description:"Corresponds to the date created device.")
        advertising_id(required: true, type: PropertyType.String)
    }

    "/notification/uninstalls_checker"(platform: "/mobile") {
        execution_id(required: true, type: PropertyType.String)
        advertising_id(required: true, type: PropertyType.String)
    }

    "/notification/institutional_generic"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
        campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
        sent_date(required: false, type: PropertyType.String, description:"")
    }

    "/notification/hub_transfer_new_approved"(platform: "/mobile") {}
    "/notification/hub_transfer_manualreview"(platform: "/mobile") {}
    "/notification/hub_transfer_new_rejected"(platform: "/mobile") {}
    "/notification/hub_transfer_rejected"(platform: "/mobile") {}
    "/notification/hub_transfer_screening_one"(platform: "/mobile") {}
    "/notification/hub_transfer_screening_two"(platform: "/mobile") {}

    //Contactless card
    "/notification/card_contactless_transaction_rejected_authorization_contactless_freeze"(platform: "/mobile") {}

    //Insurtech
    "/notification/insurtech_imei_activation"(platform: "/mobile") {}
    "/notification/insurtech_pending_payment"(platform: "/mobile") {}
    "/notification/insurtech_cancellation"(platform: "/mobile") {}
    
    // Abandoned Cart
    "/notification/abandoned_cart_buyer"(platform: "/mobile") {}
}
