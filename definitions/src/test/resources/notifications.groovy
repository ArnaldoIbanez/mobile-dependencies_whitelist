import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadolibre"

    test("Mobile Notifications"){

        "/notification_center"(platform: "/mobile"){}
        "/notification_center/abort"(platform: "/mobile"){}
        "/notification_center/back"(platform: "/mobile"){}
        "/notification_center/failure"(platform: "/mobile"){}

        "/notification_center"(platform: "/mobile") {
            newsgroup_id = "12332323"
            event_type = "open"
        }

        "/notification_center/questions-buyer"(platform: "/mobile"){
            newsgroup_id: "question-123412"
            status: "read"
            event_type: "open"
            deeplink: "meli://buyer_questions/MLA1234/ask"
            type_layout: "bullet_list"
        }
        "/notification_center/questions-seller"(platform: "/mobile"){
            newsgroup_id: "answer-123412"
            status: "unread"
            event_type: "swipe"
            deeplink: "meli://seller_questions/1234"
            type_layout: "bullet_list"
        }

        "/notification_center/orders-buyer"(platform: "/mobile"){
            newsgroup_id: "orders-buyer-1285223441"
            status: "read"
            event_type: "open"
            deeplink: "meli://purchases/1285223441#payment"
            type_layout: "standard"

        }

        "/notification_center/reputation"(platform: "/mobile"){
            newsgroup_id= "reputation-medal_lost_reminder-126635313"
            status= "read"
            event_type= "open"
            deeplink= "https://reputacao.mercadolivre.com.br/myReputation"
            type_layout= "standard"
            latest_news_type= "reputation-medal_lost_reminder"
            latest_news_id= "reputation-medal_lost_reminder-126635313-grace_time_126635313-13804002905"
        }

        "/notification_center/orders-seller"(platform: "/mobile"){
            newsgroup_id: "orders-seller-1288279054"
            action_type: "messages"
            status: "unread"
            event_type: "action_open"
            deeplink: "meli://sales/1288279054/messages/send"
            type_layout: "bullet_list"
        }

        "/notification_center/security-enrollment-legacy"(platform: "/mobile"){
            newsgroup_id: "security-enrollment-142242996"
            status: "unread"
            event_type: "open"
            deeplink: "meli://generic_landing?url=https%3A%2F%2Faccountrecovery.mercadolivre.com.br%2Fenrollment%3Fsection%3DMDP_UPDATED_NOTIF%26nativeMobile%3DANDROID"
            type_layout: "standard"
        }

        "/notification_center/mediations-complainant-legacy"(platform: "/mobile"){
            newsgroup_id: "MEDIATIONS-1287016973"
            status: "read"
            event_type: "open"
            deeplink: "meli://purchases/1287016973/claims/900736064"
            type_layout: "standard"
        }

        "/notification_center/purchase-pending-legacy"(platform: "/mobile"){
            newsgroup_id: "purchase-pending-210167262-MLA646946595"
            status: "read"
            event_type: "open"
            deeplink: "meli://item?id=MLA646946595"
            type_layout: "standard"
        }

        "/notification_center/purchases-payments"(platform: "/mobile"){
            newsgroup_id: "purchases-payments-1000000016305386"
            status: "read"
            event_type: "open"
            deeplink: "https://myaccount.mercadolibre.com.mx/purchases/1000000016305386/detail"
            type_layout: "standard"
            purchase_id: 1000000016305386
            latest_news_type: "purchases-payments_approved"
            latest_news_id: "purchases-payments_approved-1000000016305386"
        }

        "/notification_center/loyalty"(platform: "/mobile"){
            newsgroup_id: "LOYALTY-48422892"
            status: "unread"
            event_type: "open"
            deeplink: "https://www.mercadolivre.com.br/mercadopontos/fretegratis"
            type_layout: "standard"
            latest_news_type: "loyalty-freeshipping"
            latest_news_id: "loyalty-freeshipping-321438470"
        }

        "/notification_center/loyalty-freeshipping"(platform: "/mobile"){
            newsgroup_id: "loyalty-freeshipping-321438470"
            status: "unread"
            event_type: "open"
            deeplink: "meli://loyalty/?selectedTab=benefits"
            type_layout: "standard"
        }

        "/notification_center/listings"(platform: "/mobile"){
            newsgroup_id: "listings-MLB829990994"
            status: "read"
            event_type: "open"
            deeplink: "meli://listings/MLB829990994"
            type_layout: "standard"
        }

        "/notification_center/campaigns-deals"(platform: "/mobile"){
            campaign_id: "campaign1"
            deal_id: "deal1_123"
            newsgroup_id: "deals-MLU102_07_02_2017-56626993"
            status: "unread"
            event_type: "swipe"
            type_layout: "picture"
            test_notification: false
            sent_date: "20180508"
            batch_id: "MLB_PACK_20180508_2"
        }

        "/notification_center/campaigns-campaigns"(platform: "/mobile"){
            campaign_id: "campaign1"
            newsgroup_id: "deals-MLU102_07_02_2017-56626993"
            status: "unread"
            event_type: "swipe"
            type_layout: "picture"
            test_notification: false
            sent_date: "20180508"
            batch_id: "MLB_PACK_20180508_2"
        }

        "/notification_center/campaigns-suggested_discounts_buyer"(platform: "/mobile"){
            campaign_id: "campaign1"
            newsgroup_id: "campaigns-suggested_discounts_buyer-142593788-MLA645507294"
            event_type: "open"
            deeplink: "meli://item?id=MLA645507294"
            type_layout: "standard"
            test_notification: false
            sent_date: "20180508"
            batch_id: "MLB_PACK_20180508_2"
            latest_news_type: "campaigns-suggested_discounts_buyer"
            latest_news_id: "campaigns-suggested_discounts_buyer-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-suggested_discounts_seller"(platform: "/mobile"){
            newsgroup_id: "campaigns-suggested_discounts_seller-142593788-MLA645507294"
            event_type: "open"
            deeplink: "meli://item?id=MLA645507294"
            type_layout: "standard"
            test_notification: false
            sent_date: "20180508"
            batch_id: "MLB_PACK_20180508_2"
            latest_news_type: "campaigns-suggested_discounts_seller"
            latest_news_id: "campaigns-suggested_discounts_seller-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-buyequalspay"(platform: "/mobile"){
            newsgroup_id: "campaigns-buyequalspay-4939870"
            event_type: "open"
            deeplink: "meli://item?id=MLA645507294"
            type_layout: "standard"
            latest_news_type: "campaigns-buyequalspay"
            latest_news_id: "campaigns-buyequalspay-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-cart_recovery"(platform: "/mobile"){
            campaign_id: "campaign1"
            newsgroup_id: "campaigns-cart_recovery-192495923"
            event_type: "open"
            deeplink: "meli://item?id=MLA645507294"
            type_layout: "standard"
            test_notification: false
            sent_date: "20180508"
            batch_id: "MLB_PACK_20180508_2"
            latest_news_type: "campaigns-cart_recovery"
            latest_news_id: "campaigns-cart_recovery-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-checkout_recovery"(platform: "/mobile"){
            campaign_id: "campaign1"
            newsgroup_id: "campaigns-checkout_recovery-320010629"
            event_type: "open"
            deeplink: "meli://item?id=MLA645507294"
            type_layout: "standard"
            test_notification: false
            sent_date: "20180508"
            batch_id: "MLB_PACK_20180508_2"
            latest_news_type: "campaigns-checkout_recovery"
            latest_news_id: "campaigns-checkout_recovery-143816022-MLB1013046714"
            item_id: "MLV515515631"
            experiment: false
        }
        "/notification_center/campaigns-deal_alert"(platform: "/mobile"){
            campaign_id: "DEAL_ALERT_MLB_20180508"
            newsgroup_id: "campaigns-deal_alert-152329972"
            event_type: "open"
            deeplink: "meli://item?id=MLB799297448&tool=69156792&word=COREPN_MLB_PUSH_DEALALERT_20180508&referrer=utm_source%3Dpromotional_notifications%26utm_medium%3Dnotifications%26utm_campaign%3DDEAL_ALERT_MLB_20180508%26utm_term%3Dpms-word%3ACOREPN_MLB_PUSH_DEALALERT_20180508%26utm_id%3Dpms-tool%3A69156792"
            type_layout: "standard"
            test_notification: false
            sent_date: "20180508"
            batch_id: "MLB_PACK_20180508_2"
            latest_news_type: "campaigns-deal_alert"
            latest_news_id: "campaigns-deal_alert-152329972-MLB799297448"
            item_id: "MLB799297448"
        }
        "/notification_center/campaigns-download_app"(platform: "/mobile"){
            newsgroup_id: "campaigns-download_app-96757367"
            event_type: "open"
            deeplink: "meli://item?id=MLA645507294"
            type_layout: "standard"
            latest_news_type: "campaigns-download_app"
            latest_news_id: "campaigns-download_app-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-prepaid_point"(platform: "/mobile"){
            newsgroup_id: "campaigns-prepaid_point-251663897"
            event_type: "open"
            deeplink: "meli://item?id=MLA645507294"
            type_layout: "standard"
            latest_news_type: "campaigns-prepaid_point"
            latest_news_id: "campaigns-prepaid_point-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-remarketing"(platform: "/mobile"){
            campaign_id: "campaign1"
            newsgroup_id: "campaigns-remarketing-241951421"
            event_type: "open"
            deeplink: "meli://item?id=MLA645507294"
            type_layout: "standard"
            test_notification: false
            sent_date: "20180508"
            batch_id: "MLB_PACK_20180508_2"
            latest_news_type: "campaigns-remarketing"
            latest_news_id: "campaigns-remarketing-143816022-MLB1013046714"
        }
        "/notification_center/fraud-identity_validation"(platform: "/mobile"){
            newsgroup_id: "fraud-identity_validation-142593788"
            event_type: "open"
            deeplink: "meli://item?id=MLA645507294"
            type_layout: "standard"
            latest_news_type: "fraud-identity_validation"
            latest_news_id: "campaigns-remarketing-143816022-MLB1013046714"
        }

        "/notification"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "sent"
        }

        "/notification"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            source = "logout"
        }

        "/notification/campaigns_deals"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            deal_id = "mla_1234"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
        }

        "/notification/campaigns_campaigns"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
        }

        "/notification/campaigns_cart_recovery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
        }

        "/notification/campaigns-checkout_recovery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLV515515631"
            experiment = false
        }

        "/notification/campaigns_deal_alert"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
        }
        "/notification/listings_upgrade"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            item_id = "MLA122211"
            vertical = "services"
        }
        "/notification/listings_relist"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            item_id = "MLA122211"
            vertical = "services"
        }
        "/notification/campaigns_syi_freemium"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "registered_between_1_and_2_weeks_ago_and_have_not_listed_in_core"
        }

        "/notification/questions_new"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "dismiss"
            deeplink ="meli://seller_question/12221"
            question_id = 1234
        }

        "/notification/questions_answered"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            deeplink ="meli://buyer_questions"
            question_id = "1234"
        }

        "/notification/carousel"(platform: "/mobile"){
            event_type = "carousel"
            action_carousel = "next"
        }

        "/notification/orders_new"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }

        "/notification/orders_cancelled"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/orders_deliver_defined"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/orders_deliver_updated"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/orders_delivered"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/orders_timeout_confirmed"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/purchases_payments_approved"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            purchase_id = 12132
        }
        "/notification/purchases_payments_rejected"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            purchase_id = 12132
        }
        "/notification/reputation_free_shipping_activation"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }
        "/notification/reputation_medal_lost_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }

        "/notification"(platform: "/mobile") {
            event_type = "discarded"
            discard_reason = "invalid_payload"
        }

        "/notification"(platform: "/mobile") {
            event_type = "discarded"
            discard_reason = "invalid_user"
        }

        "/notification"(platform: "/mobile") {
            event_type = "discarded"
            notification_created_error = "Some exception message"
        }

        "/notification/reputation_free_shipping_deactivation"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }

        "/notification/shipping_shipped"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_delivered"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_agency_withdrawal"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://purchases/sales"
            shipment_id = 1234
            agency_to_agency = true
        }

        "/notification/shipping_delayed_bonus"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://purchases/sales"
            shipment_id = 1234
        }

        "/notification/shipping_pending"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }

        "/notification/shipping_returning_to_sender"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://purchases/11222/shipments/:shipment_id"
            shipment_id = 1234
        }

        "/notification/shipping_delayed_sender"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }

        "/notification/shipping_delayed_receiver"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            delay_reason = "shipping_time"
        }

        "/notification/shipping_not_delivered_sender"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_reminder_agency_withdrawal"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            agency_to_agency = true
        }

        "/notification/shipping_not_delivered_receiver"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }

        "/notification/shipping-soon_deliver"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_self_service_shipped"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_self_service_failed"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }

        "/notification/collections_approved"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "dismiss"
            order_id = 1234
        }

        "/notification/orders_pending"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            item_id = "MLA122211"
        }

        //Buy action
        "/notification/orders_pending"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            item_id = "MLA122211"
            action_type = "deeplinking"
            notification_style = "BigTextStyle"
        }

        "/notification/orders_pending"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            item_id = "MLA122211"
            action_type = "deeplinking"
        }

        //Favorite action
        "/notification/orders_pending"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            item_id = "MLA122211"
            action_type = "favorite"
            notification_style = "BigTextStyle"
        }

        //Notif center tracking
        "/notification/orders_pending"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            item_id = "MLA122211"
            action_type = "favorite"
            notification_style = "BigPictureStyle"
            status = "unread"
        }


        "/notification/purchase_pending"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            item_id = "MLA122211"
        }

        //Buy action
        "/notification/purchase_pending"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            item_id = "MLA122211"
            action_type = "deeplinking"
            notification_style = "BigTextStyle"
        }

        "/notification/purchase_pending"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            item_id = "MLA122211"
            action_type = "deeplinking"
        }

        //Favorite action
        "/notification/purchase_pending"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            item_id = "MLA122211"
            action_type = "favorite"
            notification_style = "BigTextStyle"
        }

        //Notif center tracking
        "/notification/purchase_pending"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            item_id = "MLA122211"
            action_type = "favorite"
            notification_style = "BigPictureStyle"
            status = "unread"
        }

        "/notification/mediations_complainant"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
            latest_news_type ="mediations_complainant"
            latest_news_id = "mediations_complainant-143816022-MLB1013046714"
        }

        "/notification/mediations_complainant"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
            latest_news_type ="mediations_complainant"
            latest_news_id = "mediations_complainant-143816022-MLB1013046714"
        }

        "/notification/questions_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            question_id = 1234
        }

        "/notification/questions_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            notification_style = "BigTextStyle"
            question_id = 1234
        }

        "/notification/moderations_item_to_patch"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            item_id = "MLA1234"
        }

        "/notification/moderations_item_to_patch"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            item_id = "MLA1234"
        }

        "/notification/moderations_item_to_patch"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
            item_id = "MLA1234"
        }

        "/notification/moderations_item_forbidden"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            item_id = "MLA1234"
        }

        "/notification/moderations_item_forbidden"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
            item_id = "MLA1234"
        }

        "/notification/moderations_item_forbidden"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            item_id = "MLA1234"
        }

        "/notification/payments_pending_reminder"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/payments_pending_reminder"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/payments_pending_reminder"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            item_id = "MLA1234"
            order_id = 1234321
        }
        "/notification/payments_pending_remainder"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/payments_approved"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/payments_approved"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/payments_approved"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/payments_rejected"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/payments_rejected"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/payments_rejected"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/messages_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/messages_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
        }

        "/notification/messages_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/messages_read"(platform: "/mobile/android") {
            news_id = "123"
            event_type = "open"
        }


        "/notification/moderations_item_warning"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            item_id = "MLA1234"
        }

        "/notification/moderations_item_warning"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
            item_id = "MLA1234"
        }

        "/notification/moderations_item_warning"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            item_id = "MLA1234"
        }

        "/notification/moderations_message_banned"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/moderations_message_banned"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
        }

        "/notification/moderations_message_banned"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/campaigns_suggested_discounts_seller"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLV515515631"
        }

        "/notification/campaigns_suggested_discounts_seller"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLV515515631"
        }

        "/notification/campaigns_suggested_discounts_seller"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLV515515631"
        }

        "/notification/campaigns_suggested_discounts_buyer"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/campaigns_suggested_discounts_buyer"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
        }

        "/notification/campaigns_suggested_discounts_buyer"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/campaigns_download_app"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/loyalty_welcome"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/loyalty_milestone"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/loyalty_change_level"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/loyalty_freeshipping"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/security_enrollment"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            latest_news_type = "security_enrollment"
            latest_news_id = "security_enrollment-143816022-MLB1013046714"
        }

        "/notification/security_phone_confirmation"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/reviews_reminder"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_identity_validation"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }


        "/notification/health_check"(platform: "/mobile/android") {
            news_id = "COXwPxDrigQYBw==-1eb9ff37e01d45b0"
            original_news_id = "messages-new-1688986927-60f251a8ee0a4b748b6c1b59bc1e267a"
            event_type = "arrived"
        }
    }

}
