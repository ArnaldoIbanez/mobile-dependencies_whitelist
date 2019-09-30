import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    "/device_settings/"(platform: "/", isAbstract: true){}

    "/device_settings/notifications"(platform: "/mobile/android", type:TrackType.Event) {
        device_id(required: true, description: "The real device_id, may differ from device field")
        enable(required:true, type:PropertyType.Boolean, description: "Indicates if settings are enabled")
        registration_id(required: false, description: "The registration id", type: PropertyType.String)
    }

    /**
    * NOTIFICATIONS CENTER
    */
    "/notification_center/screen"(platform: "/", type: TrackType.View) {
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
        campaign_type(required: true,type: PropertyType.String, description: "Type of the campaign related to the notification sent.")
        campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
        test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/fraud-identity_validation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/fraud-delivery_cancellation"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/purchases-payments"(platform: "/", type: TrackType.Event) {
        purchase_id(required: true, type: PropertyType.Numeric)
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/account_fund_cvu"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/account_fund_approved_ted"(platform: "/", type: TrackType.Event) {
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
    "/notification_center/credits_merchants_expired_near_to_daily_charges"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/credits_merchants_expired_near_to_fixed_charges"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    "/notification_center/credits_merchants_educational"(platform: "/", type: TrackType.Event) {
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
        communication_id(required: false, type: PropertyType.String, description: "Communication Id.")
    }
    "/notification_center/prepaid_card"(platform: "/", type: TrackType.Event) {
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

    "/notification_center/withdraw_approved_contingency"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/withdraw_rejected_contingency"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }


    "/notification_center/seller_journey_congrats"(platform: "/", type: TrackType.Event){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
    }
    "/notification_center/seller_journey_keep_it_up"(platform: "/", type: TrackType.Event){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
    }
    "/notification_center/seller_journey_work_harder"(platform: "/", type: TrackType.Event){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
    }
    "/notification_center/seller_journey_do_something"(platform: "/", type: TrackType.Event){
        step_id(required: true , type: PropertyType.Numeric, description: "Corresponds to the step id of the seller in the journey to associate the step.")
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
          context(required: false, type: PropertyType.String)
      }

      //Anses
      "/notification/anses_payment_date"(platform: "/") {}
      "/notification/anses_paid_benefit"(platform: "/") {}

      //Account
      "/notification/account_fund_approved_mp"(platform: "/") {}
      "/notification/account_fund_approved_ml"(platform: "/") {}
      "/notification/account_fund_salary"(platform: "/") {}
      "/notification/account_fund_cvu"(platform: "/") {}
      "/notification/account_fund_approved_ted"(platform: "/") {}
      "/notification/account_balance_approved_mp"(platform: "/") {}
      "/notification/account_balance_approved_ml"(platform: "/") {}

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
      "/notification/credits_consumer_expired_n_loans_first_notice"(platform: "/") {}
      "/notification/credits_consumer_about_to_expire_n_loans_first_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_n_loans_fourth_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_n_loans_second_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_n_loans_third_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_fortyfive_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_sixty_notice"(platform: "/") {}

      "/notification/credits_merchants_educational"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric)
      }

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

      "/notification/instore_discover_activities"(platform: "/") {}

      //Messages
      "/notification/messages_quotes"(platform: "/") {}

      "/notification/moderations_item_to_patch"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
      }

      "/notification/moderations_item_forbidden"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
      }

      "/notification/moderations_item_warning"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
      }

      //Tu producto está en camino
      "/notification/shipping_shipped"(platform: "/") {
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
          order_id(required: true, type: PropertyType.Numeric)
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

      "/notification/orders_ticket_payment_pending_extend_expiration_general_notice"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
          experiment_id(required: false, description: "Id of the experiment related to the order notification sent.")
      }

      "/notification/orders_ticket_payment_pending_close_expiration_general_notice"(platform: "/") {
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

      //Loyalty
      "/notification/loyalty"(platform: "/") {}
      "/notification/loyalty_welcome"(platform: "/") {}
      "/notification/loyalty_milestone"(platform: "/") {}
      "/notification/loyalty_change_level"(platform: "/") {}
      "/notification/loyalty_freeshipping"(platform: "/") {}

      //Mshops
      "/notification/mshops_orders"(platform: "/") {}
      "/notification/mshops_questions"(platform: "/") {}

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

      //Security
      "/notification/security_enrollment"(platform: "/") {}
      "/notification/security_phone_confirmation"(platform: "/") {}
      "/notification/security_event_feedback"(platform: "/") {}
      "/notification/security_account_validation"(platform: "/") {}
      "/notification/security_login_auth"(platform: "/") {}
      "/notification/security_device_authorization"(platform: "/") {}
      "/notification/security_recovery_canceled"(platform: "/") {}

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
        communication_id(required: false, type: PropertyType.String, description: "Communication Id.")
    }
    "/notification/mpcampaigns_control_group"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
        communication_id(required: false, type: PropertyType.String, description: "Communication Id.")
    }
    "/notification/mpcampaigns_mpcampaignspromo"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
        communication_id(required: false, type: PropertyType.String, description: "Communication Id.")
    }
    "/notification/mpcampaigns_mpcampaignsinfo"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
        communication_id(required: false, type: PropertyType.String, description: "Communication Id.")
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
    "/notification/credits_merchants_expired_near_to_fixed_charges"(platform: "/mobile") {}
    "/notification/credits_merchants_expired_near_to_daily_charges"(platform: "/mobile") {}
    "/notification/credits_merchants_to_expire_standard"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_to_expire_not_standard"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }

    "/notification/coverages_compensation_complainant"(platform: "/mobile") {
        activity_id(required: true , type: PropertyType.String)
    }

    "/notification/cancellations_warning_seller_suspended"(platform: "/mobile") {}

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

    //Merchants
    "/notification/merchants_growth_mgm"(platform: "/mobile") {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        gift_reason_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

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
    "/notification/prepaid_card_transaction_approved_authorization"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_approved_withdraw"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_canceled_authorization"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_canceled_withdraw"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_withdraw_freeze"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_regulations_bacen_data_incomplete"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_authorization_freeze"(platform: "/mobile") {}
    "/notification/prepaid_card_reissue_reminder"(platform: "/mobile") {}

    "/notification/prepaid_card_delivery"(platform: "/mobile") {}
    "/notification/prepaid_card_challenge_bolbradesco_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_red_link_bug"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount"(platform: "/mobile") {}

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

    //Seller QR
    "/notification/seller_qr_payment_received"(platform: "/mobile") {}
    "/notification/seller_integrations_new_payment"(platform: "/mobile") {}
    "/notification/seller_integrations_erase_name"(platform: "/mobile") {}

    //Wallet
    "/notification/wallet_integrator_insufficient_amount"(platform: "/mobile") {}

    //Withdraw
    "/notification/withdraw_approved_contingency"(platform: "/", type: TrackType.Event) {} //At web, only mp business
    "/notification/withdraw_rejected_contingency"(platform: "/web", type: TrackType.Event) {}

    //Phone Enrollment
    "/notification/security_phone_enrollment"(platform: "/web", type: TrackType.Event) {}

    //Merchant Services
    "/notification/mss_alliance"(platform: "/web", type: TrackType.Event) {}
    "/notification/mss_gplay"(platform: "/web", type: TrackType.Event) {}

    //Fiscal Data
    "/notification/fiscal_data_mp_business_registration"(platform: "/web", type: TrackType.Event) {}

}
