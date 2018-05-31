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
        action_type(required: false, type: PropertyType.String,  values: ["messages", "message", "vop", "picture", "shipping_print_label", "claims", "tracking", "feedback", "changepayment", "reply", "ask", "questions-buy", "cart"])
        type_layout(required: false, type: PropertyType.String, values: ["bullet_list", "order", "picture", "standard"])
    }

    "/notification_center/abort"(platform: "/", type: TrackType.Event) {}
    "/notification_center/back"(platform: "/", type: TrackType.Event) {}
    "/notification_center/failure"(platform: "/", type: TrackType.Event) {}
    "/notification_center/questions-buyer"(platform: "/", type: TrackType.Event) {}
    "/notification_center/questions-seller"(platform: "/", type: TrackType.Event) {}
    "/notification_center/orders-buyer"(platform: "/", type: TrackType.Event) {}
    "/notification_center/reputation"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/orders-seller"(platform: "/", type: TrackType.Event) {}
    "/notification_center/security-enrollment"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/security-enrollment-legacy"(platform: "/", type: TrackType.Event) {}
    "/notification_center/mediations-complainant"(platform: "/", type: TrackType.Event) {
        claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/mediations-complainant-legacy"(platform: "/", type: TrackType.Event) {}
    "/notification_center/purchase-pending-legacy"(platform: "/", type: TrackType.Event) {}
    "/notification_center/purchases-payments"(platform: "/", type: TrackType.Event) {
        purchase_id(required: false, type: PropertyType.Numeric, description:"Id of purchase.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/loyalty"(platform: "/", type: TrackType.Event) {}
    "/notification_center/loyalty-freeshipping"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/listings"(platform: "/", type: TrackType.Event) {}
    "/notification_center/campaigns-deals"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, type: PropertyType.String, description: "Id of the campaign related to the mkt notification sent.")
        deal_id(required: true, description: "Id of the deal related to the mkt notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
    }
    "/notification_center/campaigns-campaigns"(platform: "/", type: TrackType.Event) {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
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
    }
    "/notification_center/campaigns-cart_recovery"(platform: "/") {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-checkout_recovery"(platform: "/") {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test.")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        item_id(required: false, type: PropertyType.String, description: "Id of item.")
        experiment(required: false, type: PropertyType.Boolean, description: "experiment.")
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/campaigns-deal_alert"(platform: "/") {
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
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
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
    }
    "/notification_center/credits-consumer"(platform: "/", type: TrackType.Event) {
          installment_id(required: true, description: "Id of installment.")
          loan_id(required: true, description: "Id of loan.")
          latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
          latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
      }
      "/notification_center/fraud-identity_validation"(platform: "/", type: TrackType.Event) {
          latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
          latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
      }
      "/notification_center/packages-buyer"(platform: "/", type: TrackType.Event) {}
      "/notification_center/packages-seller"(platform: "/", type: TrackType.Event) {}
      "/notification_center/returns"(platform: "/", type: TrackType.Event) {
          order_id(required: true, type: PropertyType.Numeric)
          latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
          latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
      }

      /**
       * NOTIFICATIONS TRAY
       **/
      "/notification"(platform: "/") {
          event_type(required: true,
                  values: ["sent", "arrived", "received", "dismiss", "discarded", "open", "auto_dismiss", "shown", "action_open", "control", "carousel","purged_token", "swipe"],
          description: "Type of notification event")
          action_type(required: false,
                  values: ["deeplinking", "directions", "favorite", "reply", "ask", "postpone", "twitter_bar", "picture", "answer", "messages", "vop", "claims", "received", "tracking", "shipping_print_label", "feedback", "buy"])
          deeplink(required: false, description: "The link were the notification should navigate to, if applies")

          //For event_type:autodismiss, indicates why the notification was dismissed
          source(required: false,
                 values: ["notification_center","logout","overwrite"])

          discard_reason(required: false, description: "The discarded reason of the notification", values: ["invalid_payload","invalid_user", "settings_disabled"], type: PropertyType.String)

          notification_created_error(required: false, description: "The notification created error", type: PropertyType.String)

          news_id(required: false, description: "Identifier of the notification generated")
          notification_style(required: false, description: "The notification style used when displaying the notification to the user.")

          status(required: false, values: ["read", "unread"], deprecated: true, description: "*Deprecated*: Just for old NotifCenter.")

          device_id(required: false, description: "The real device_id, may differ from device field")
          context(required: false, type: PropertyType.String)
      }

      "/notification/credits_consumer_about_to_expire_n_loans_first_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_n_loans_first_notice"(platform: "/") {}
      "/notification/credits_consumer_about_to_expire_second_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_first_notice"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }

      "/notification/instore_discover_activities"(platform: "/") {}

      "/notification/messages_new"(platform: "/") {}

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
          shipment_id(required: true, type: PropertyType.String)
      }

      //Hubo un problema con el envío (para el comprador)
      "/notification/shipping_not_delivered_receiver"(platform: "/") {
          shipment_id(required: true, type: PropertyType.String, description: "Id of shipment.")
      }

      //Paquete entregado
      "/notification/shipping_delivered"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }
      "/notification/shipping_reminder_agency_withdrawal"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
          agency_to_agency(required:true, type:PropertyType.Boolean, description: "Indicates if package was sent to an agency in the first place or was shipped there because the user wasnt found in his address")
      }
      //Paquete proximo a entregarse
      "/notification/shipping-soon_deliver"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      "/notification/shipping_self_service_shipped"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      "/notification/shipping_self_service_failed"(platform: "/") {
          shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
      }

      "/notification/shipping_legacy_delivered"(platform: "/") {}
      "/notification/shipping_legacy_shipped"(platform: "/") {}
      "/notification/shipping_legacy_delayed_receiver"(platform: "/") {}
      "/notification/shipping_legacy_agency_withdrawal"(platform: "/") {}

      //Seller questions
      "/notification/questions_new"(platform: "/") {
          question_id(required: true, type: PropertyType.Numeric)
      }

      //Buyer questions
      "/notification/questions_answered"(platform: "/") {
          question_id(required: true, type: PropertyType.Numeric)
      }

      "/notification/questions-buyer"(platform: "/") {}
      "/notification/questions-seller"(platform: "/") {}

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

      //Delivered Order
      "/notification/orders_timeout_confirmed"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric)
      }

      //Deprecated - typo @TODO Revisar este path para eliminarlo en el mediano plazo cuando las apps no lo envien mas
      "/notification/orders-buyer"(platform: "/") {
          newsgroup_id(required: false, type: PropertyType.String)
          type_layout(required: false, type: PropertyType.String)
          type(required: false, type: PropertyType.String, deprecated: true, description: "type of order notification.")
      }

      "/notification/orders-seller"(platform: "/") {
          newsgroup_id(required: false, type: PropertyType.String)
          type_layout(required: false, type: PropertyType.String)
          type(required: false, type: PropertyType.String, description: "type of order notificaction.")
      }

      //Generic Campaigns
      "/notification/campaigns_campaigns"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
      }

      //MKT Deals
      "/notification/campaigns_deals"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the mkt notification sent.")
          deal_id(required: true, description: "Id of the deal related to the mkt notification sent.")
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
      "/notification/campaigns_checkout_recovery"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the campaigns notification sent.")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
          item_id(required: true, type: PropertyType.String)
          experiment(required: false, type: PropertyType.Boolean)
      }
      //
      "/notification/campaigns_deal_alert"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: true, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
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

      //Payment aproved
      "/notification/purchases_payments_approved"(platform: "/") {
          purchase_id(required: true, type: PropertyType.Numeric)
      }

      //Payment rejected
      "/notification/purchases_payments_rejected"(platform: "/") {
          purchase_id(required: true, type: PropertyType.Numeric)
      }

      //Qrviral
      "/notification/qrviral_onboard"(platform: "/") {}
      "/notification/qrviral_reminder"(platform: "/") {}


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

      //Mediations
      "/notification/mediations_complainant"(platform: "/") {
          claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
      }
      "/notification/mediations_respondent"(platform: "/") {
          claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
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
          order_id(required: true, type: PropertyType.String)
      }

      "/notification/payments_rejected"(platform: "/") {
          item_id(required: true, type: PropertyType.String)
          order_id(required: true, type: PropertyType.String)
      }

      //Deprecated - typo
      "/notification/payments_pending_remainder"(platform: "/") {
          item_id(required: true, type: PropertyType.String)
          order_id(required: true, type: PropertyType.String)
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

      //Notification suggested discounts
      "/notification/campaigns_suggested_discounts_seller"(platform: "/") {
          item_id(required: true, type: PropertyType.String, description: "Id of item.")
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
      }
      "/notification/campaigns_suggested_discounts_buyer"(platform: "/") {}

      "/notification/campaigns_remarketing"(platform: "/") {
          campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
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

      //Loyalty
      "/notification/loyalty"(platform: "/") {}
      "/notification/loyalty_welcome"(platform: "/") {}
      "/notification/loyalty_milestone"(platform: "/") {}
      "/notification/loyalty_change_level"(platform: "/") {}
      "/notification/loyalty_freeshipping"(platform: "/") {}

      //Prepaid
      "/notification/prepaid_card_shipped"(platform: "/") {}
      "/notification/prepaid_card_waiting_for_withdrawal"(platform: "/") {}
      "/notification/prepaid_card_delivered"(platform: "/") {}

      //Point
      "/notification/point_shipping_ready_to_ship"(platform: "/") {}
      "/notification/point_shipping_shipped"(platform: "/") {}
      "/notification/point_shipping_not_delivered"(platform: "/") {}
      "/notification/point_shipping_waiting_for_withdrawal"(platform: "/") {}

      //Mshops
      "/notification/mshops_questions"(platform: "/") {}
      //Returns
      "/notification/returns_return_cancelled"(platform: "/") {
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

    //Reviews
    "/notification/reviews_reminder"(platform: "/") {}

    //Security
    "/notification/security_enrollment"(platform: "/") {}
    "/notification/security_phone_confirmation"(platform: "/") {}
    "/notification/security_event_feedback"(platform: "/") {}
    "/notification/security_account_validation"(platform: "/") {}
    "/notification/security_login_auth"(platform: "/") {}

    //Health Check
    "/notification/health_check"(platform: "/") {
        original_news_id( required: false, type: PropertyType.String, description: "Original identifier of the notification generated" )
    }

}
