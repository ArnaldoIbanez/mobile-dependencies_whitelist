package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1237"

    /**
     * NOTIFICATIONS CENTER
     */
    "/notification_center/screen"(platform: "/", type: TrackType.View) {
    }
    "/notification_center/config"(platform: "/mobile", type: TrackType.View) {
    }
    "/notification_center"(platform: "/", type: TrackType.Event) {
        newsgroup_id(required: false, type: PropertyType.String, description:"Id of newsgroup.")
        status(required: false, type: PropertyType.String, values:["unread", "read"], description:"status of notification.")
        event_type(required: false, values: ["open", "pull_to_refresh", "swipe", "action_open", "create", "update", "shown"], description:"event type of notification")
        deeplink(required: false, type: PropertyType.String, description: "The link were the notification should navigate to, if applies")
        action_type(required: false, type: PropertyType.String,  values: ["messages", "message", "vop", "picture", "shipping_print_label", "claims", "tracking", "feedback", "changepayment", "reply", "ask", "questions-buy", "cart", "twitter_bar", "leftcta", "rightcta", "create"], description: "Type of the notification action")
        type_layout(required: false, type: PropertyType.String, values: ["bullet_list", "order", "picture", "standard"], description: "type of layout of notification.")
    }
    "/notification_center/abort"(platform: "/", type: TrackType.Event) {}
    "/notification_center/addresses-update"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/addresses_update"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/abandoned_cart_buyer"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/abandoned_cart_link_payer"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }


    //Always On
    "/notification_center/alwayson_bsas_a"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: false, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_bsas_h"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: true, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_caba_a"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: true, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_caba_b"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: true, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_caba_c"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: true, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_caba_h"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: true, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_iva_a"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: true, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_iva_b"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: true, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_iva_h"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: false, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_sirtac_a"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: true, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_sirtac_b"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: true, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_sirtac_c"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: true, type: PropertyType.String, description: "Sent Date.")
    }
    "/notification_center/alwayson_sirtac_h"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        sent_date(required: false, type: PropertyType.String, description: "Sent Date.")
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
        campaign_id(required: false, type: PropertyType.String, description:"Corresponds to the campaign_id of the newsgroup that is showing.")
        end_date(required: false, type: PropertyType.String, description:"Corresponds to the end_date the newsgroup that is showing.")
    }
    "/notification_center/mp_sponsor_campaign_budget_trigger"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        campaign_id(required: false, type: PropertyType.String, description:"Corresponds to the campaign_id of the newsgroup that is showing.")
        end_date(required: false, type: PropertyType.String, description:"Corresponds to the end_date the newsgroup that is showing.")
    }
    "/notification_center/mp_sponsor_campaign_day_trigger"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        campaign_id(required: false, type: PropertyType.String, description:"Corresponds to the campaign_id of the newsgroup that is showing.")
        end_date(required: false, type: PropertyType.String, description:"Corresponds to the end_date the newsgroup that is showing.")
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
        installment_id(required: false, type: PropertyType.Numeric, description: "Id of installment.")
        loan_id(required: false, type: PropertyType.Numeric, description: "Id of loan.")
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
    "/notification_center/fraud_kyc_validation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/invoices"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/ingate_tokenization_verification_code"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/dangerous_substances"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/disbursement_wu_successful"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud-identity_validation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fbm_withdrawals_delayed"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fiscal_data_mp_business_registration"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/package-buyer"(platform: "/", type: TrackType.Event) {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/me_flex_rehunting_reputation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/mediations_v2"(platform: "/", type: TrackType.Event) {
        pack_id(required: false, type: PropertyType.Numeric, description: "Id of batch.")
        claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
    }
    "/notification_center/orders-buyer"(platform: "/", type: TrackType.Event) {
        order_id(required: true, type: PropertyType.Numeric)
        experiment_id(required: false, type: PropertyType.String, description: "Experiment id.")
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
    "/notification_center/account_balance-cvu"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/account_fund_approved_mlc_tc"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/asset_management_investing"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/asset_management_failed"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/asset_management_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/asset_management_underage_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/asset_management_underage_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/asset_management_underage_request"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/chargeback_payer_high_n_chargebacks_agree_repayment_mp"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/billing_iva_isr_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/billing_newusertaxfile"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_adhoc_communication"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_transaction_chout_purchase"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/gating_accreditation_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/gating_accreditation_rejected"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/kyc_continue_from_desktop_person_notification_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_legal_entity_notification_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/kyc_user_notification_ml_web"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/killers-loser_item_new"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/killers-winner_item_recover"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/killers-losing_item_buybox"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/killers_winner_item_recover"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/killers-winner_item_lost"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/killers_winner_item_new"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/killers-winner_item_new"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/merchants_growth_resellers"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/merchants_growth_reverse_screening"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/merchants_growth_pricing_point"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money-transfer_request"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/money_request_paid"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/moneyin_cashin_accredited"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/moneyin_cashin_exceeded_cap"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/moneyin_debin_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/moneyin_debin_in_process"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/moneyin_debin_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/money_transfer_sender"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_transactions"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/hub_transfer_new_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/hub_transfer_new_scheduled"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/mp_dx_credentials"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_dx_credentials_seller_received_request"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_seller_campaign_resume_campaign"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_shipping_label"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_shipping_not_delivered"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_shipping_on_way"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mp_sponsor_campaign_create_campaign"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        campaign_id(required: false, type: PropertyType.String, description: "Id of the campaign related to the notification sent.")
        end_date(required: false, type: PropertyType.String, description: "End date.")
    }
    "/notification_center/mp_sponsor_campaign_web_eligible_campaign"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        campaign_id(required: false, type: PropertyType.String, description: "Id of the campaign related to the notification sent.")
        end_date(required: false, type: PropertyType.String, description: "End date.")
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
    "/notification_center/not_shippable_by_dimensions_items_sellers"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/point_fill_in"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/point_qr_login_new"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/subscription_free_content_level_drop"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification_center/subscription_free_content_previous"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification_center/subscription_free_content_grace_period"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Failure for the first payment attempt on the subscription.")
    }

    "/notification_center/subscription_free_content_payment_pending"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Failure due to secund payment attempt on subscription.")
    }

    "/notification_center/subscription_free_content_last_day_to_pay"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Failure for the last payment attempt on the subscription.")
    }

    "/notification_center/subscription_payment_congrats"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        payment_type(required: false, type: PropertyType.String, description: "Payment pending type.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification_center/subscription_payment_error"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender")
        error_type(required: true, type: PropertyType.String, description: "Error type")
    }
    "/notification_center/subscription_payment_instructions"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
        payment_option(required: true, type: PropertyType.String, description: "Payment option.")
    }
    "/notification_center/subscription_payment_pending"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        payment_type(required: true, type: PropertyType.String, description: "Payment pending type.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification_center/subscription_disney_activation_on"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification_center/subscription_disney_activation_off"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification_center/subscription_disney_activation_free_trial"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification_center/card_first_use_incentive"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card_transaction_rejected_regulations_bacen_data_incomplete"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/promotions_msg"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/promotions_volume"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/protected_purchase_order_reminder_purchase_protection"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card_transaction_rejected_invalid_pin"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_rejected_withdraw_by_invalid_amount_for_fee"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card_transaction_rejected_activation_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/prepaid_card_delivery"(platform: "/", type: TrackType.Event) {
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
        branch_time_elapsed(required: false, type: PropertyType.Boolean, description: "Branch Time Elapsed")
    }
    "/notification_center/card_prepaid_tracking"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        branch_case(required: false, type: PropertyType.Boolean, description: "Has been in a branch office before")
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
    "/notification_center/card_flow_incentive_prepaid_acquisition_first"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_flow_incentive_prepaid_acquisition_second"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_kyc_data_completed_nfc_acquisition"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_kyc_data_completed_prepaid_acquisition_first"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_kyc_data_completed_prepaid_acquisition_second"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_kyc_data_completed_prepaid_acquisition_third"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_nip"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_reminders_virtual_digital_services"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_subscription"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive_fifteenth_day"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive_fifth_day"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive_twentyfifth_day"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive_zero_day"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive_zero_day_known_person"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive_zero_day_owner"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive_zero_day_point"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/card_unlock_incentive_zero_day_somewhere"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/cashoutmlb_rejected_manualreview"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/chargeback_payer_high_agree_repayment_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        case_id(required: true, type: PropertyType.String, description: "Id of chargeback.")
    }

    // Credit Card
    "/notification_center/credit_card_collection"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_overlimit"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_reject_blocked"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_reject_cvv_incorrect"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_reject_insufficient_amount"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_reject_invalid_pin"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_transaction_acquisition"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_transaction_choff_purchase"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_transaction_purchase"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_transaction_statement_payment"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_transaction_withdrawal"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credit_card_waitlist"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/credit_card_transaction_kyc_onboarding"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/credit_card_transaction_acquisition_micro"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/credits_merchants_spl_congrats"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credits_merchants_spl_expired_0_ws"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credits_merchants_spl_expired_30_ws"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credits_merchants_std_expired_daily_charges_75"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/card_wallet"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_rejected_authorization_by_invalid_amount"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transaction_rejected_authorization_contactless_freeze_decorator"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transfer_online_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transfer_online_in_process"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transfer_online_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transfer_online_review_manual"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/transfer_online_scheduled"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/whatsapp-enrollment"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/wallet_connect_binding_error"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/wallet_connect_binding_with_card_and_cash"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/wallet_connect_binding_with_cash"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/wallet_connect_rejected_payment"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/under_age_responsible_info"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_responsible_authorization_legacy"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_minor_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_minor_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_responsible_info_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_responsible_authorization_legacy_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_minor_rejected_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_minor_approved_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_responsible_relationship_bond_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_responsible_relationship_bond_approved_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_responsible_relationship_bond_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/under_age_responsible_relationship_bond_rejected_ml"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/wrong_address_driver_action"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
        shipment_id(required: true, type: PropertyType.Numeric, description: "Shipment Id.")
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
    "/notification_center/single_player_utility_refused_am"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_utility_refused_cc"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/single_player_balance_expiration_transport_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_balance_expiration_prepaid_toll_mp"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/single_player_payg_create_device_fail_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_payg_blocked_device_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_payg_cashback_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_payg_change_device_number_success_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_payg_change_device_number_fail_mp"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/single_player_scheduled_payment_pixtransfer_grouped_insufficient_amount"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_scheduled_payment_pixtransfer_solo_insufficient_amount"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_scheduled_payment_pixtransfer_grouped_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_scheduled_payment_pixtransfer_solo_reminder"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_subscription_recharge_cancelled_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_subscription_recharge_cancelled_product_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_subscription_recharge_cancelled_unrecoverable_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_subscription_recharge_fail_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/single_player_subscription_recharge_fail_payments_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/single_player_subscription_recharge_reminder_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/single_player_subscription_recharge_success_mp"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: false, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: false, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    //Single player - Self-Service
    "/notification_center/single_player_self_service_schedule_new_debt"(platform: "/", type: TrackType.Event) {
        debt_id(required: true, type: PropertyType.Numeric, description: "Corresponds to the id of the debt payer that is showing")
        seller_name(required: true, type: PropertyType.String, description: "Corresponds to the name of the seller that is showing")
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
    "/notification_center/shipping_proximity"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/shipping_scoring_keyword_created"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification_center/shipping_shipped_out_for_delivery"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification_center/shipping_shipped_soon_deliver"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification_center/shipping_special_milkrun"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/insurtech_kyc_roda_pre_activacion"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mpinstitutional_generic"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: true, type: PropertyType.String, description: "Hermes communication id")
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

    "/notification_center/insurtech_purchase"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_imei_cancellation_advice"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_imei_activation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_pending_payment"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_purchase"(platform: "/", type: TrackType.Event) {}

    "/notification_center/insurtech_new_claim"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_payment_recovery"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_money_in"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_imei_cancellation_advice"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_cancellation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/claim"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/insurtech_payment_recovery_cards"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, values: ["insurtech_payment_recovery_cards"], type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    
    "/notification_center/insurtech_post_service_poll"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, values: ["insurtech_post_service_poll"], type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    // Disbursement Kwai
    "/notification_center/disbursement_kwai_received"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/disbursement_kwai_pending_kyc"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    // Fraud Remedies
    "/notification_center/fraud_remedies_card_reminder_second_score"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud_remedies_card_start_second_score"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud_remedies_identity_reminder_second_score"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud_remedies_identity_start_second_score"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
}