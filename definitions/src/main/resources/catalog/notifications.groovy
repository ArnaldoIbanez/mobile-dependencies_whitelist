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
        event_type(required: false, values: ["open", "pull_to_refresh", "swipe", "action_open"])
        deeplink(required: false, type: PropertyType.String)
        action_type(required: false, type: PropertyType.String,  values: ["messages", "message", "vop", "picture", "shipping_print_label", "claims", "tracking", "feedback", "changepayment", "reply", "ask", "questions-buy"])
        type_layout(required: false, type: PropertyType.String, values: ["bullet_list", "order", "picture", "standard"])
    }

    "/notification_center/abort"(platform: "/", type: TrackType.Event) {}
    "/notification_center/back"(platform: "/", type: TrackType.Event) {}
    "/notification_center/failure"(platform: "/", type: TrackType.Event) {}

    "/notification_center/reputation"(platform: "/", type: TrackType.Event) {}
    "/notification_center/questions-buyer"(platform: "/", type: TrackType.Event) {}
    "/notification_center/questions-seller"(platform: "/", type: TrackType.Event) {}
    "/notification_center/orders-buyer"(platform: "/", type: TrackType.Event) {}
    "/notification_center/orders-seller"(platform: "/", type: TrackType.Event) {}
    "/notification_center/security-enrollment-legacy"(platform: "/", type: TrackType.Event) {}
    "/notification_center/mediations-complainant-legacy"(platform: "/", type: TrackType.Event) {}
    "/notification_center/purchase-pending-legacy"(platform: "/", type: TrackType.Event) {}
    "/notification_center/loyalty"(platform: "/", type: TrackType.Event) {}
    "/notification_center/listings"(platform: "/", type: TrackType.Event) {}
    "/notification_center/campaigns-deals"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, type: PropertyType.String, description: "Id of the campaign related to the mkt notification sent.")
        deal_id(required: false, description: "Id of the deal related to the mkt notification sent.")
    }
    "/notification_center/campaigns-campaigns"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
    }

    "/notification_center/campaigns-suggested_discounts_buyer"(platform: "/", type: TrackType.Event) {}
    "/notification_center/campaigns-suggested_discounts_seller"(platform: "/", type: TrackType.Event) {}
    "/notification_center/fraud-identity_validation"(platform: "/", type: TrackType.Event) {}

    /**
     * NOTIFICATIONS TRAY
     **/
    "/notification"(platform: "/") {
        event_type(required: true,
                values: ["sent", "arrived", "received", "dismiss", "discarded", "open", "auto_dismiss", "shown", "action_open", "control", "carousel","purged_token"],
        description: "Type of notification event")
        action_type(required: false,
                values: ["deeplinking", "directions", "favorite", "reply", "ask", "postpone", "twitter_bar", "picture", "answer"])
        deeplink(required: false, description: "The link were the notification should navigate to, if applies")

        //For event_type:autodismiss, indicates why the notification was dismissed
        source(required: false,
               values: ["notification_center","logout","overwrite"])

        discard_reason(required: false, description: "The discarded reason of the notification", values: ["invalid_payload","invalid_user"], type: PropertyType.String)

        notification_created_error(required: false, description: "The notification created error", type: PropertyType.String)

        news_id(required: false, description: "Identifier of the notification generated")
        notification_style(required: false, description: "The notification style used when displaying the notification to the user.")

        status(required: false, values: ["read", "unread"], deprecated: true, description: "*Deprecated*: Just for old NotifCenter.")

        device_id(required: false, description: "The real device_id, may differ from device field")
        context(required: false, type: PropertyType.String)
    }
    //Tu producto está en camino
    "/notification/shipping_shipped"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order of the bought item which has been shipped")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Retiro en sucursal
    "/notification/shipping_agency_withdrawal"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
        agency_to_agency(required:false, type:PropertyType.Boolean, description: "Indicates if package was sent to an agency in the first place or was shipped there because the user wasnt found in his address")
    }
    //Devolución de costo de envío por demora
    "/notification/shipping_delayed_bonus"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Tienes que despachar (para el vendedor)
    "/notification/shipping_pending"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Devolución por no entrega, a su dirección de despacho (para el vendedor)
    "/notification/shipping_returning_to_sender"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Te demoraste en el handling time (para el vendedor)
    "/notification/shipping_delayed_sender"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Tu paquete está demorado (para el comprador)
    "/notification/shipping_delayed_receiver"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
        delay_reason(required: true, type: PropertyType.String, description: "shipping_time or handling_time")
    }
    //Hubo un problema con tu paquete y te vamos a pagar (para el vendedor)
    "/notification/shipping_not_delivered_sender"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Hubo un problema con el envío (para el comprador)
    "/notification/shipping_not_delivered_receiver"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }

    //Paquete entregado
    "/notification/shipping_delivered"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }

    //Seller questions
    "/notification/questions_new"(platform: "/") {
        question_id(required: true)
    }
    //Buyer questions
    "/notification/questions_answered"(platform: "/") {
        question_id(required: true, type: PropertyType.Numeric)
    }
    //New Sale
    "/notification/orders_new"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric)
    }

    //Generic Campaigns
    "/notification/campaigns_campaigns"(platform: "/") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
    }

    //MKT Deals
    "/notification/campaigns_deals"(platform: "/") {
        campaign_id(required: true, description: "Id of the campaign related to the mkt notification sent.")
        deal_id(required: true, description: "Id of the deal related to the mkt notification sent.")
    }

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

    //Mediations
    "/notification/mediations_complainant"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "The order related to the claim")
        claim_id(required: true, type: PropertyType.Numeric)
    }

    //Moderation
    "/notification/moderations_item_to_patch"(platform: "/") {
        item_id(required: true, type: PropertyType.String)
    }

    "/notification/moderations_item_forbidden"(platform: "/") {
        item_id(required: true, type: PropertyType.String)
    }

    "/notification/moderations_item_warning"(platform: "/") {
        item_id(required: true, type: PropertyType.String)
    }

    "/notification/moderations_message_banned"(platform: "/") {
    }

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

    //Deprecated - typo
    "/notification/payments_pending_remainder"(platform: "/") {
        item_id(required: true, type: PropertyType.String)
        order_id(required: true, type: PropertyType.Numeric)
    }

    //Messages
    "/notification/messages_new"(platform: "/") {}

    //Reputation
    "/notification/reputation-free_shipping_activation"(platform: "/") {}
    "/notification/reputation-free_shipping_deactivation"(platform: "/") {}

    //Notification suggested discounts
    "/notification/campaigns_suggested_discounts_seller"(platform: "/") {}
    "/notification/campaigns_suggested_discounts_buyer"(platform: "/") {}

    //Fraud
    "/notification/fraud_identity_validation"(platform: "/") {}

    //Loyalty
    "/notification/loyalty_welcome"(platform: "/") {}
    "/notification/loyalty_milestone"(platform: "/") {}
    "/notification/loyalty_change_level"(platform: "/") {}

    //Reviews
    "/notification/reviews_reminder"(platform: "/") {}

    //Security
    "/notification/security_enrollment"(platform: "/") {}

}
