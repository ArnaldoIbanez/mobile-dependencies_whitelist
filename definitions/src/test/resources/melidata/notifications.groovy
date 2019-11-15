package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadolibre"
    test("Mobile Notifications mercadolibre"){

        "/device_settings"(platform: "/", type:TrackType.Event) {}

        "/device_settings/notifications"(platform: "/mobile/android", type:TrackType.Event) {
            device_id = "ee6f7bd224c2d6"
            enable = false
            registration_id = "dH2soSpvhwM:APA91bFwZmJy-wXP7DRLm_458FqPF9n8zbm7uVjixKUOHOS8FQ7QN-qSbWS_DrKYDiXyLzGE2giqzVf90fwyjNy4dkgi6hR_W_fv6JvnQo6B5AQ4BOX21g8wx0cLSrcJswrof5U3f"
        }

        "/notification_center/screen"(platform: "/", type: TrackType.View){}
        "/notification_center"(platform: "/mobile"){}
        "/notification_center/abort"(platform: "/mobile"){}
        "/notification_center/addresses-update"(platform: "/mobile") {
            latest_news_type= "addresses-update"
            latest_news_id= "addresses-update-126635313"
        }
        "/notification_center/back"(platform: "/mobile"){}
        "/notification_center/failure"(platform: "/mobile"){}
        "/notification_center"(platform: "/mobile") {
            newsgroup_id = "12332323"
            event_type = "open"
        }
        "/notification_center/reputation"(platform: "/mobile"){
            newsgroup_id= "reputation-126635313"
            status= "read"
            event_type= "open"
            deeplink= "https://reputacao.mercadolivre.com.br/myReputation"
            type_layout= "standard"
            latest_news_type= "reputation"
            latest_news_id= "reputation-126635313-grace_time_126635313-13804002905"
        }
        "/notification_center/reputation-medal_lost_reminder"(platform: "/mobile"){
            newsgroup_id= "reputation-medal_lost_reminder-126635313"
            status= "read"
            event_type= "open"
            deeplink= "https://reputacao.mercadolivre.com.br/myReputation"
            type_layout= "standard"
            latest_news_type= "reputation-medal_lost_reminder"
            latest_news_id= "reputation-medal_lost_reminder-126635313-grace_time_126635313-13804002905"
        }
        "/notification_center/discount_central_missing_data"(platform: "/mobile"){
            newsgroup_id= "discount_central-missing_data-126635313"
            status= "read"
            event_type= "open"
            deeplink= "mercadopago://profile-engine/landing?flow_name=discount_central"
            type_layout= "standard"
            latest_news_type= "discount_central_missing_data"
            latest_news_id= "discount_central-missing_data-126635313"
        }
        "/notification_center/security-enrollment"(platform: "/mobile"){
            newsgroup_id= "security-enrollment-142242996"
            status= "unread"
            event_type= "open"
            deeplink= "meli://generic_landing?url=https%3A%2F%2Faccountrecovery.mercadolivre.com.br%2Fenrollment%3Fsection%3DMDP_UPDATED_NOTIF%26nativeMobile%3DANDROID"
            type_layout= "standard"
            latest_news_type= "security-enrollment"
            latest_news_id= "security-enrollment-305337286"
        }
        "/notification_center/security-enrollment-legacy"(platform: "/mobile"){
            newsgroup_id= "security-enrollment-142242996"
            status= "unread"
            event_type= "open"
            deeplink= "meli://generic_landing?url=https%3A%2F%2Faccountrecovery.mercadolivre.com.br%2Fenrollment%3Fsection%3DMDP_UPDATED_NOTIF%26nativeMobile%3DANDROID"
            type_layout= "standard"
        }
        "/notification_center/loyalty"(platform: "/mobile"){
            newsgroup_id= "LOYALTY-48422892"
            status= "unread"
            event_type= "open"
            deeplink= "https://www.mercadolivre.com.br/mercadopontos/fretegratis"
            type_layout= "standard"
        }
        "/notification_center/loyalty-freeshipping"(platform: "/mobile"){
            newsgroup_id= "loyalty-freeshipping-321438470"
            status= "unread"
            event_type= "open"
            deeplink= "meli://loyalty/?selectedTab=benefits"
            type_layout= "standard"
            latest_news_type= "loyalty-freeshipping"
            latest_news_id= "loyalty-freeshipping-321438470"
        }
        "/notification_center/mediations-complainant"(platform: "/mobile"){
            newsgroup_id= "mediations-995364894"
            status= "read"
            event_type= "open"
            deeplink= "meli://generic_landing?url=https%3A%2F%2Fmediations.mercadolibre.com.ar%2Fclaims%2F995364894&authenticate=true"
            type_layout= "standard"
            claim_id= 995364894
            latest_news_type= "mediations-complainant"
            latest_news_id= "mediations-complainant-995364894-5afa30fa7eb37e6b7470573b"
        }
        "/notification_center/mediations-complainant-legacy"(platform: "/mobile"){
            newsgroup_id= "MEDIATIONS-1287016973"
            status= "read"
            event_type= "open"
            deeplink= "meli://purchases/1287016973/claims/900736064"
            type_layout= "standard"
        }
        "/notification_center/purchase-pending-legacy"(platform: "/mobile"){
            newsgroup_id= "purchase-pending-210167262-MLA646946595"
            status= "read"
            event_type= "open"
            deeplink= "meli://item?id=MLA646946595"
            type_layout= "standard"
        }
        "/notification_center/reviews-reminder"(platform: "/mobile"){
            vertical= "services"
            latest_news_type= "reviews-reminder"
            latest_news_id= "reviews-reminder-143816022-MLB1013046714"
        }
        "/notification_center/fiscal_data-business_registration"(platform: "/mobile"){
            latest_news_type= "fiscal_data-business_registration"
            latest_news_id= "fiscal_data-business_registration-143816022-MLB1013046714"
        }
        "/notification_center/instore-activities"(platform: "/mobile"){
            latest_news_type= "instore-activities"
            latest_news_id= "instore-activities-143816022-MLB1013046714"
        }
        "/notification_center/invoices"(platform: "/mobile"){
            latest_news_type= "invoices"
            latest_news_id= "invoices-143816022-MLB1013046714"
        }
        "/notification_center/listings"(platform: "/mobile"){}
        "/notification_center/campaigns-deals"(platform: "/mobile"){
            campaign_id= "campaign1"
            deal_id= "deal1_123"
            newsgroup_id= "deals-MLU102_07_02_2017-56626993"
            status= "unread"
            event_type= "swipe"
            type_layout= "picture"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
        }
        "/notification_center/campaigns-campaigns"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "deals-MLU102_07_02_2017-56626993"
            status= "unread"
            event_type= "swipe"
            type_layout= "picture"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
        }
        "/notification_center/campaigns-generic"(platform: "/"){
            campaign_id= "campaign1"
            campaign_type="xp_cupones"
            campaign_data = "MLV515515631,MLV515515632,MLV515515633"
            newsgroup_id= "campaigns-generic-MLU102_07_02_2017-56626993"
            status= "unread"
            event_type= "swipe"
            type_layout= "picture"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-generic"
            latest_news_id= "campaigns-generic-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-suggested_discounts_buyer"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-suggested_discounts_buyer-142593788-MLA645507294"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            item_id= "MLV515515631"
            latest_news_type= "campaigns-suggested_discounts_buyer"
            latest_news_id= "campaigns-suggested_discounts_buyer-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-suggested_discounts_seller"(platform: "/mobile"){
            newsgroup_id= "campaigns-suggested_discounts_seller-142593788-MLA645507294"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-suggested_discounts_seller"
            latest_news_id= "campaigns-suggested_discounts_seller-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-buyequalspay"(platform: "/mobile"){
            newsgroup_id= "campaigns-buyequalspay-4939870"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            latest_news_type= "campaigns-buyequalspay"
            latest_news_id= "campaigns-buyequalspay-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-cart_recovery"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-cart_recovery-192495923"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-cart_recovery"
            latest_news_id= "campaigns-cart_recovery-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-checkout_recovery"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-checkout_recovery-320010629"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-checkout_recovery"
            latest_news_id= "campaigns-checkout_recovery-143816022-MLB1013046714"
            item_id= "MLV515515631"
            variation_id="BLUE"
            experiment= false
        }
        "/notification_center/campaigns-acho_reminder"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-acho_reminder-320010629"
            event_type= "open"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-acho_reminder"
            latest_news_id= "campaigns-acho_reminder-143816022-MLB1013046714"
            item_id= "MLV515515631"
            variation_id= "1234"
        }
        "/notification_center/campaigns-ticket_recovery"(platform: "/") {
            campaign_id = "mkt_campaign_ticket_recovery"
            newsgroup_id = "campaigns_ticket_recovery-320010629"
            event_type = "open"
            deeplink = "meli://purchases"
            type_layout = "standard"
            test_notification = false
            sent_date = "20190129"
            latest_news_type = "campaigns_ticket_recovery"
            latest_news_id = "campaigns_ticket_recovery-143816022"
        }
        "/notification_center/campaigns-cho_cart_recovery"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-checkout_recovery-320010629"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-checkout_recovery"
            latest_news_id= "campaigns-checkout_recovery-143816022-MLB1013046714"
            items= "MLV515515631,MLV515515632,MLV515515633"
            experiment= false
        }
        "/notification_center/campaigns-deal_alert"(platform: "/mobile"){
            campaign_id= "DEAL_ALERT_MLB_20180508"
            newsgroup_id= "campaigns-deal_alert-152329972"
            event_type= "open"
            deeplink= "meli://item?id=MLB799297448&tool=69156792&word=COREPN_MLB_PUSH_DEALALERT_20180508&referrer=utm_source%3Dpromotional_notifications%26utm_medium%3Dnotifications%26utm_campaign%3DDEAL_ALERT_MLB_20180508%26utm_term%3Dpms-word%3ACOREPN_MLB_PUSH_DEALALERT_20180508%26utm_id%3Dpms-tool%3A69156792"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-deal_alert"
            latest_news_id= "campaigns-deal_alert-152329972-MLB799297448"
            item_id= "MLB799297448"
        }
        "/notification_center/campaigns-download_app"(platform: "/mobile"){
            newsgroup_id= "campaigns-download_app-96757367"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            latest_news_type= "campaigns-download_app"
            latest_news_id= "campaigns-download_app-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-prepaid_point"(platform: "/mobile"){
            newsgroup_id= "campaigns-prepaid_point-251663897"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            latest_news_type= "campaigns-prepaid_point"
            latest_news_id= "campaigns-prepaid_point-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-remarketing"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-remarketing-241951421"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-remarketing"
            latest_news_id= "campaigns-remarketing-143816022-MLB1013046714"
            hash="hash1"
            items_recommendations="MLB557314949,MLB613999012,MLB677993650,MLB695215973"
            items_history="MLB595398238,MLB649162181,MLB656729144"
        }
        "/notification_center/campaigns-remarketing_motors"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-remarketing_motors-241951421"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-remarketing_motors"
            latest_news_id= "campaigns-remarketing_motors-143816022-MLB1013046714"
            item_id= "MLU457119874"
        }
        "/notification_center/campaigns_marketplace_discounts"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-marketplace_discounts-241951421"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-marketplace_discounts"
            latest_news_id= "campaigns-marketplace_discounts-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-recharge_recovery"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-recharge_recovery-320010629"
            event_type= "open"
            deeplink= "meli://cellphone-recharge/"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-recharge_recovery"
            latest_news_id= "campaigns-recharge_recovery-143816022-MLB1013046714"
            experiment= false
        }
        "/notification_center/compliance_support-validations"(platform: "/mobile"){
            latest_news_type= "compliance_support-validations"
            latest_news_id= "compliance_support-validations-143816022-MLB1013046714"
        }
        "/notification_center/credits_consumer"(platform: "/mobile"){
            newsgroup_id= "credits-consumer-213882865-255720"
            event_type= "open"
            deeplink= "meli://generic_landing?authenticate=true&url=https%3A%2F%2Fwww.mercadolibre.com.ar%2Fcredits%2Fconsumer%2Fnews%3FloanId%3D255720%26installmentId%3D1592866"
            type_layout= "standard"
            installment_id= 717743
            loan_id= 107849
            latest_news_type= "1592866"
            latest_news_id= "credits-consumer_expired_second_notice-1592866"
        }
        "/notification_center/credits-merchants"(platform: "/mobile"){
            newsgroup_id= "credits-merchants-213882865-255720"
            event_type= "open"
            deeplink= "meli://generic_landing?authenticate=true&url=https%3A%2F%2Fwww.mercadolibre.com.ar%2Fcredits%2Fconsumer%2Fnews%3FloanId%3D255720%26installmentId%3D1592866"
            type_layout= "standard"
            installment_id= 717743
            latest_news_type= "1592866"
            latest_news_id= "credits-merchants-1592866"
        }
        "/notification_center/cancellations"(platform: "/mobile") {
            latest_news_type= "cancellations"
            latest_news_id= "cancellations-143816022-MLB1013046714"
        }
        "/notification_center/coverages"(platform: "/mobile") {
            activity_id = "12345"
            latest_news_type= "coverages"
            latest_news_id= "coverages-143816022-MLB1013046714"
        }
        "/notification_center/cx-generic"(platform: "/mobile"){
            latest_news_type= "cx-generic"
            latest_news_id= "cx-generic-143816022-MLB1013046714"
        }
        "/notification_center/cx_question"(platform: "/mobile"){
            case_id= 12345678
            latest_news_type= "cx-cx_question"
            latest_news_id= "cx_question-143816022-MLB1013046714"
        }
        "/notification_center/fraud-identity_validation"(platform: "/mobile"){
            newsgroup_id= "fraud-identity_validation-142593788"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            latest_news_type= "fraud-identity_validation"
            latest_news_id= "campaigns-remarketing-143816022-MLB1013046714"
        }
        "/notification_center/fraud-postpayment"(platform: "/mobile"){}
        "/notification_center/fraud-delivery_cancellation"(platform: "/mobile"){
            latest_news_type= "fraud-delivery_cancellation"
            latest_news_id= "fraud-delivery_cancellation-143816022-MLB1013046714"
        }
        "/notification_center/fraud-cash_release_iv"(platform: "/mobile"){
            latest_news_type= "fraud-cash_release_iv"
            latest_news_id= "fraud-cash_release_iv-143816022-MLB1013046714"
        }
        "/notification_center/fraud-identity_validation_reminder"(platform: "/mobile"){
            latest_news_type= "fraud-identity_validation_reminder"
            latest_news_id= "fraud-identity_validation_reminder-143816022-MLB1013046714"
        }

        "/notification_center/messages_quotes"(platform: "/mobile"){
            latest_news_type= "messages_quotes"
            latest_news_id= "messages_quotes-143816022-MLB1013046714"
        }
        "/notification_center/messages_flex"(platform: "/mobile") {
            latest_news_type= "messages_flex"
            latest_news_id= "messages_flex-123-123"
        }

        "/notification_center/openplatform_sellers_inhouse"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_sellers_inhouse"
            latest_news_id= "openplatform_sellers_inhouse-12345"
        }
        "/notification_center/openplatform_recommendations_wannabe"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_wannaber"
            latest_news_id= "openplatform_recommendations_wannabe-12345"
        }
        "/notification_center/openplatform_recommendations_p4"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p4"
            latest_news_id= "openplatform_recommendations_p4-12345"
        }
        "/notification_center/openplatform_recommendations_p3"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p3"
            latest_news_id= "openplatform_recommendations_p3-12345"
        }
        "/notification_center/openplatform_recommendations_p2"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p2"
            latest_news_id= "openplatform_recommendations_p2-12345"
        }
        "/notification_center/openplatform_recommendations_p1"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p1"
            latest_news_id= "openplatform_recommendations_p1-12345"
        }

        "/notification_center/packages-buyer"(platform: "/mobile"){}
        "/notification_center/packages-seller"(platform: "/mobile"){}
        "/notification_center/package-seller"(platform: "/mobile") {
            purchase_id= 1000000016589794
            pack_id= 2000000032080846
            shipment_id= 1234
            latest_news_type= "package-seller"
            latest_news_id= "package-seller-1000000016305386"
        }
        "/notification_center/messages_quotes"(platform: "/mobile") {
            latest_news_type= "messages_quotes"
            latest_news_id= "messages-quotes-123-123"
        }
        "/notification_center/messages_flex"(platform: "/mobile") {
            latest_news_type= "messages_flex"
            latest_news_id= "messages_flex-123-123"
        }
        "/notification_center/messages_driver_logistics"(platform: "/mobile") {
            latest_news_type= "messages_driver_logistics"
            latest_news_id= "messages_driver_logistics-123-123"
        }
        "/notification_center/me_flex-optin"(platform: "/mobile"){
            latest_news_type= "me_flex-optin"
            latest_news_id= "me_flex-optin-143816022-MLB1013046714"
        }
        "/notification_center/returns"(platform: "/mobile"){
            newsgroup_id= "packages-seller-2000000031949978"
            event_type= "open"
            deeplink= "meli://messages/orders/1709786702"
            type_layout= "bullet_list"
            order_id= 1692352012
            latest_news_type= "returns-init_return"
            latest_news_id= "returns-init_return-1692352012-88594841"
        }
        "/notification_center/mediations"(platform: "/", type: TrackType.Event) {
            claim_id= 443103451
        }
        "/notification_center/orders-buyer"(platform: "/mobile"){
            newsgroup_id= "orders-buyer-1285223441"
            status= "read"
            event_type= "open"
            deeplink= "meli://purchases/1285223441#payment"
            type_layout= "standard"
            order_id = 1234
        }
        "/notification_center/orders-seller"(platform: "/mobile"){
            newsgroup_id= "orders-seller-1288279054"
            action_type= "messages"
            status= "unread"
            event_type= "action_open"
            deeplink= "meli://sales/1288279054/messages/send"
            type_layout= "bullet_list"
            order_id = 1234
        }
        "/notification_center/package_seller"(platform: "/mobile"){
            newsgroup_id= "packages-seller-2000000031949978"
            event_type= "open"
            deeplink= "meli://messages/orders/1709786702"
            type_layout= "bullet_list"
            order_id= 1692352012
        }
        "/notification_center/purchases-payments"(platform: "/mobile"){
            newsgroup_id= "purchases-payments-1000000016305386"
            status= "read"
            event_type= "open"
            deeplink= "https://myaccount.mercadolibre.com.mx/purchases/1000000016305386/detail"
            type_layout= "standard"
            purchase_id= 1000000016305386
            latest_news_type= "purchases-payments_approved"
            latest_news_id= "purchases-payments_approved-1000000016305386"
        }

        "/notification_center/qrviral"(platform: "/mobile") {}
        "/notification_center/questions-buyer"(platform: "/mobile"){
            newsgroup_id= "question-123412"
            status= "read"
            event_type= "open"
            deeplink= "meli://buyer_questions/MLA1234/ask"
            type_layout= "bullet_list"
            question_id= 3730000436
        }
        "/notification_center/questions-seller"(platform: "/mobile"){
            newsgroup_id= "answer-123412"
            status= "unread"
            event_type= "swipe"
            deeplink= "meli://seller_questions/1234"
            type_layout= "bullet_list"
            question_id= 3730000436
        }
        "/notification_center/registration-info"(platform: "/mobile") {
            latest_news_type= "registration-info"
            latest_news_id= "registration-info-1000000016305386"
        }
        "/notification_center/registration-generated_pwd"(platform: "/mobile") {
            latest_news_type= "registration-generated_pwd"
            latest_news_id= "registration-generated_pwd-1000000016305386"
        }
        "/notification_center/reservations"(platform: "/mobile") {
            order_id = 12132
        }
        "/notification_center/reservations-pending_reminder"(platform: "/mobile") {
            latest_news_type= "reservations-pending_reminder"
            latest_news_id= "reservations-pending_reminder-1000000016305386"
        }
        "/notification_center/sc_editor_off"(platform: "/mobile") {
            latest_news_type= "sc_editor_off"
            latest_news_id= "sc_editor_off-1000000016305386"
        }
        "/notification_center/security-account_validation"(platform: "/mobile") {
            latest_news_type= "security-account_validation"
            latest_news_id= "security-account_validation-1000000016305386"
        }
        "/notification_center/security-device_authorization"(platform: "/mobile") {
            latest_news_type= "security-device_authorization"
            latest_news_id= "security-device_authorization-1000000016305386"
        }
        "/notification_center/security-device_authorization_congrats"(platform: "/mobile") {
            latest_news_type= "security-device_authorization_congrats"
            latest_news_id= "security-device_authorization_congrats-1000000016305386"
        }

        "/notification_center/security_recovery_canceled"(platform: "/mobile") {
            latest_news_type= "security_recovery_canceled"
            latest_news_id= "security_recovery_canceled-1000000016305386"
        }

        "/notification_center/security_phone_enrollment"(platform: "/mobile") {
            latest_news_type= "security_phone_enrollment"
            latest_news_id= "security_phone_enrollment-1000000016305386"
        }

        "/notification_center/security_login_code"(platform: "/mobile") {
            latest_news_type= "security_login_code"
            latest_news_id= "security_login_code-1000000016305386"
        }

        "/notification_center/chargeback-payer"(platform: "/mobile") {
            case_id = "158213000000"
            latest_news_id = "chargeback-buyer-158213000000-init13545"
            latest_news_type = "chargeback-buyer"
            type_layout = "standard"
            newsgroup_id = "chargeback-buyer-158213000000"
            status = "unread"
            event_type = "open"
            deeplink = "https=//www.mercadolibre.com.ar/chargebacks/payer/select-remedy/158213000000#entry=notification"
        }
        "/notification_center/quotes_new"(platform: "/mobile") {
            latest_news_type= "quotes_new"
            latest_news_id= "quotes_new-123-123"
        }

        "/notification_center/quotes_reject"(platform: "/mobile") {
            latest_news_type= "quotes_reject"
            latest_news_id= "quotes_reject-123-123"
        }

        "/notification_center/quotes_cancel"(platform: "/mobile") {
            latest_news_type= "quotes_cancel"
            latest_news_id= "quotes_cancel-123-123"
        }

        "/notification_center/account_balance_approved_mp"(platform: "/mobile"){
            newsgroup_id= "account_balance-account_balance-approved_mp-12345678"
            latest_news_type= "account_balance_approved_mp"
            latest_news_id= "account_balance-account_balance-approved_mp-12345678"
            status= "unread"
        }
        "/notification_center/account_fund_approved_mp"(platform: "/mobile"){
            newsgroup_id= "account_fund-approved_mp-12345678"
            latest_news_id= "account_fund-approved_mp-12345678"
            latest_news_type= "account_fund_approved_mp"
            status= "unread"
        }
        "/notification_center/account_fund_salary"(platform: "/mobile"){
            newsgroup_id= "account_fund-salary-12345678"
            latest_news_id= "account_fund-salary-12345678"
            latest_news_type= "account_fund_salary"
            status= "unread"
        }
        "/notification_center/account_fund_cvu"(platform: "/mobile"){
            newsgroup_id= "account_fund_cvu-12345678"
            latest_news_id= "account_fund_cvu-12345678"
            latest_news_type= "account_fund_cvu"
            status= "unread"
        }
        "/notification_center/account_fund_approved_ted"(platform: "/mobile"){
            newsgroup_id= "account_fund_approved_ted-12345678"
            latest_news_id= "account_fund_approved_ted-12345678"
            latest_news_type= "account_fund_approved_ted"
            status= "unread"
        }
        "/notification_center/asset_management_warm_up"(platform: "/mobile"){
            newsgroup_id= "asset_management-warm_up-186785675-76283123"
            latest_news_id= "asset_management-warm_up-186785675-76283123"
            latest_news_type= "asset_management_warm_up"
            status= "read"
        }
        "/notification_center/billing_mpoff"(platform: "/mobile"){
            newsgroup_id= "billing-mpoff-186785675-76283123"
            latest_news_id= "billing-mpoff-186785675-76283123"
            latest_news_type= "billing_mpoff"
            status= "read"
        }
        "/notification_center/chargeback_payer_intensify_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_intensify_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_intensify_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_intensify_mp"
            status= "read"
        }
        "/notification_center/chargeback_payer_notify_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_notify_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_notify_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_notify_mp"
            status= "read"
        }
        "/notification_center/chargeback_payer_start_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_start_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_start_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_start_mp"
            status= "read"
        }
        "/notification_center/chargeback_payer_ultimatum_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_ultimatum_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_ultimatum_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_ultimatum_mp"
            status= "read"
        }
        "/notification_center/chargeback_payer_update_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_update_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_update_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_update_mp"
            status= "read"
        }
        "/notification_center/compliance_support-validations"(platform: "/mobile"){
            newsgroup_id= "compliance_support-validations-186785675-76283123"
            latest_news_id= "compliance_support-validations-186785675-76283123"
            latest_news_type= "compliance_support-validations"
            status= "read"
        }
        "/notification_center/credits_merchants_expired_near_to_daily_charges"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-expired_near_to_daily_charges-186785675-76283123"
            latest_news_id= "credits_merchants-expired_near_to_daily_charges-186785675-76283123"
            latest_news_type= "credits_merchants_expired_near_to_daily_charges"
            status= "read"
        }
        "/notification_center/credits_merchants_expired_near_to_fixed_charges"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-expired_near_to_fixed_charges-186785675-76283123"
            latest_news_id= "credits_merchants-expired_near_to_fixed_charges-186785675-76283123"
            latest_news_type= "credits_merchants_expired_near_to_fixed_charges"
            status= "read"
        }
        "/notification_center/credits_merchants_expired_no_charges"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-expired_no_charges-186785675-76283123"
            latest_news_id= "credits_merchants-expired_no_charges-186785675-76283123"
            latest_news_type= "credits_merchants_expired_no_charges"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits-merchants"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-to_expire-186785675-76283123"
            latest_news_id= "credits_merchants-to_expire-186785675-76283123"
            latest_news_type= "credits_merchants_to_expire"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_to_expire_not_standard"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-to_expire_not_standard-186785675-76283123"
            latest_news_id= "credits_merchants-to_expire_not_standard-186785675-76283123"
            latest_news_type= "credits_merchants_to_expire_not_standard"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_educational"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-educational-186785675-76283123"
            latest_news_id= "credits_merchants-educational-186785675-76283123"
            latest_news_type= "credits_merchants_educational"
            status= "read"
            loan_id = 123
        }
        "/notification_center/fraud-cash_release_iv"(platform: "/mobile"){
            newsgroup_id= "fraud-cash_release_iv-186785675-76283123"
            latest_news_id= "fraud-cash_release_iv-186785675-76283123"
            latest_news_type= "fraud_cash_release_iv"
            status= "read"
        }
        "/notification_center/fraud_score_post_approval"(platform: "/mobile"){
            newsgroup_id= "fraud_score_post_approval-186785675-76283123"
            latest_news_id= "fraud_score_post_approval-186785675-76283123"
            latest_news_type= "fraud_score_post_approval"
            status= "read"
        }
        "/notification_center/fraud_iv_credentials"(platform: "/mobile"){
            newsgroup_id= "fraud_iv_credentials-186785675-76283123"
            latest_news_id= "fraud_iv_credentials-186785675-76283123"
            latest_news_type= "fraud_iv_credentials"
            status= "read"
        }
        "/notification_center/instore_buyer_qr"(platform: "/mobile"){
            newsgroup_id= "instore-buyer_qr-186785675-76283123"
            latest_news_id= "instore-buyer_qr-186785675-76283123"
            latest_news_type= "instore_buyer_qr"
            status= "read"
        }
        "/notification_center/invite_gift"(platform: "/mobile"){
            newsgroup_id= "invite-gift-186785675-76283123"
            latest_news_id= "invite-gift-186785675-76283123"
            latest_news_type= "invite_gift"
            status= "read"
        }
        "/notification_center/merchants_growth_mgm"(platform: "/mobile"){
            newsgroup_id= "merchants_growth-mgm-186785675-76283123"
            latest_news_id= "merchants_growth-mgm-186785675-76283123"
            latest_news_type= "merchants_growth_mgm"
            status= "read"
            gift_reason_id= "MLB_14456"
        }
        "/notification_center/money-transfer_request"(platform: "/mobile"){
            newsgroup_id= "money-transfer_request-186785675-76283123"
            latest_news_id= "money-transfer_request-186785675-76283123"
            latest_news_type= "money-transfer_request"
            status= "read"
        }
        "/notification_center/mpcampaigns_campaigns"(platform: "/mobile"){
            newsgroup_id= "mpcampaigns-campaigns-186785675-76283123"
            latest_news_id= "mpcampaigns-campaigns-186785675-76283123"
            latest_news_type= "mpcampaigns_campaigns"
            status= "read"
            campaign_id = "mkt_campaign_co"
            batch_id = "MLB_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }
        "/notification_center/mpcampaigns_mpcampaignsinfo"(platform: "/mobile"){
            newsgroup_id= "mpcampaigns_mpcampaignsinfo-186785675-76283123"
            latest_news_id= "mpcampaigns_mpcampaignsinfo-186785675-76283123"
            latest_news_type= "mpcampaigns_mpcampaignsinfo"
            status= "read"
            campaign_id = "mkt_campaign_co"
            batch_id = "MLB_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }
        "/notification_center/mp_sponsor_campaign_start_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_-ampaign_start_campaign-143816022-MLB1013046714"
        }
        "/notification_center/mp_sponsor_campaign_budget_trigger"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor-campaign_budget_trigger-143816022-MLB1013046714"
        }
        "/notification_center/mp_sponsor_campaign_day_trigger"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor-campaign_day_trigger-143816022-MLB1013046714"
        }
        "/notification_center/mp_seller_campaign_start_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_seller-campaign_start_campaign-143816022-MLB1013046714"
        }
        "/notification_center/mp_seller_campaign_end_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_seller-campaign_end_campaign-143816022-MLB1013046714"
        }
        "/notification_center/prepaid_card"(platform: "/mobile"){
            newsgroup_id= "prepaid_card-delayed_p1-186785675-76283123"
            latest_news_id= "prepaid_card-delayed_p1-186785675-76283123"
            latest_news_type= "prepaid_card_delayed_p1"
            status= "read"
        }
        "/notification_center/prepaid_card_delivery"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_delivery-186785675-76283123"
            latest_news_id= "prepaid_card_delivery-186785675-76283123"
            latest_news_type= "prepaid_card_delivery"
            status= "read"
        }
        "/notification_center/prepaid_card_transaction_rejected_regulations_bacen_data_incomplete"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_transaction_rejected_regulations_bacen_data_incomplete-186785675-76283123"
            latest_news_id= "prepaid_card_transaction_rejected_regulations_bacen_data_incomplete-186785675-76283123"
            latest_news_type= "prepaid_card_transaction_rejected_regulations_bacen_data_incomplete"
            status= "read"
        }
        "/notification_center/prepaid_card_transaction_rejected_invalid_pin"(platform: "/mobile"){
            newsgroup_id= "pprepaid_card_transaction_rejected_invalid_pin-186785675-76283123"
            latest_news_id= "prepaid_card_transaction_rejected_invalid_pin-186785675-76283123"
            latest_news_type= "prepaid_card_transaction_rejected_invalid_pin"
            status= "read"
        }
        "/notification_center/prepaid_card_transaction_rejected_activation_reminder"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_transaction_rejected_activation_reminder-186785675-76283123"
            latest_news_id= "prepaid_card_transaction_rejected_activation_reminder-186785675-76283123"
            latest_news_type= "prepaid_card_transaction_rejected_activation_reminder"
            status= "read"
        }
        "/notification_center/transaction_approved_authorization"(platform: "/mobile"){
            newsgroup_id= "transaction_approved_authorization-186785675-76283123"
            latest_news_id= "transaction_approved_authorization-186785675-76283123"
            latest_news_type= "transaction_approved_authorization"
            status= "read"
        }
        "/notification_center/transaction_approved_withdraw"(platform: "/mobile") {
            newsgroup_id = "transaction_approved_withdraw-186785675-76283123"
            latest_news_id = "transaction_approved_withdraw-186785675-76283123"
            latest_news_type = "transaction_approved_withdraw"
            status = "read"
        }
        "/notification_center/transaction_canceled_authorization"(platform: "/mobile"){
            newsgroup_id= "transaction_canceled_authorization-186785675-76283123"
            latest_news_id= "transaction_canceled_authorization-186785675-76283123"
            latest_news_type= "transaction_canceled_authorization"
            status= "read"
        }
        "/notification_center/transaction_canceled_withdraw"(platform: "/mobile"){
            newsgroup_id= "transaction_canceled_withdraw-186785675-76283123"
            latest_news_id= "transaction_canceled_withdraw-186785675-76283123"
            latest_news_type= "transaction_canceled_withdraw"
            status= "read"
        }
        "/notification_center/transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_authorization_by_invalid_amount_with_avaible_balance-186785675-76283123"
            latest_news_id= "transaction_rejected_authorization_by_invalid_amount_with_avaible_balance-186785675-76283123"
            latest_news_type= "transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"
            status= "read"
        }
        "/notification_center/transaction_rejected_red_link_bug"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_red_link_bug-186785675-76283123"
            latest_news_id= "transaction_rejected_red_link_bug-186785675-76283123"
            latest_news_type= "transaction_rejected_red_link_bug"
            status= "read"
        }
        "/notification_center/transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance-186785675-76283123"
            latest_news_id= "transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance-186785675-76283123"
            latest_news_type= "transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"
            status= "read"
        }
        "/notification_center/recurring_recharge_error"(platform: "/mobile"){
            newsgroup_id= "recurring_recharge-error-186785675-76283123"
            latest_news_id= "recurring_recharge-error-186785675-76283123"
            latest_news_type= "recurring_recharge_error"
            status= "read"
        }
        "/notification_center/recurring_recharge_insufficient_balance_error"(platform: "/mobile"){
            newsgroup_id= "recurring_recharge-insufficient_balance_error-186785675-76283123"
            latest_news_id= "recurring_recharge-insufficient_balance_error-186785675-76283123"
            latest_news_type= "recurring_recharge_insufficient_balance_error"
            status= "read"
        }
        "/notification_center/recurring_recharge_second_auth_error"(platform: "/mobile"){
            newsgroup_id= "recurring_recharge-second_auth_error-186785675-76283123"
            latest_news_id= "recurring_recharge-second_auth_error-186785675-76283123"
            latest_news_type= "recurring_recharge_second_auth_error"
            status= "read"
        }
        "/notification_center/wallet_integrator_insufficient_amount"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator-insufficient_amount-186785675-76283123"
            latest_news_id= "wallet_integrator-insufficient_amount-186785675-76283123"
            latest_news_type= "wallet_integrator_insufficient_amount"
            status= "read"
        }
        "/notification_center/wallet_integrator_ticket_acredited"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator-ticket_acredited-186785675-76283123"
            latest_news_id= "wallet_integrator-ticket_acredited-186785675-76283123"
            latest_news_type= "wallet_integrator_ticket_acredited"
            status= "read"
        }
        "/notification_center/withdraw_approved_contingency"(platform: "/mobile") {
            latest_news_type= "withdraw_approved_contingency"
            latest_news_id= "withdraw_approved_contingency-143816022-MLB1013046714"
        }
        "/notification_center/withdraw_rejected_contingency"(platform: "/mobile") {
            latest_news_type= "coverages"
            latest_news_id= "withdraw_rejected_contingency-143816022-MLB1013046714"
        }

        "/notification_center/seller_journey_congrats"(platform: "/mobile"){
            step_id= 123
            event_type= "create"
        }
        "/notification_center/seller_journey_keep_it_up"(platform: "/mobile"){
            step_id= 123
            event_type= "create"
        }
        "/notification_center/seller_journey_work_harder"(platform: "/mobile"){
            step_id= 123
            event_type= "create"
        }
        "/notification_center/seller_journey_do_something"(platform: "/mobile"){
            step_id= 123
            event_type= "create"
        }

        "/notification/seller_journey_congrats"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
        }
        "/notification/seller_journey_keep_it_up"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
        }
        "/notification/seller_journey_work_harder"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
        }
        "/notification/seller_journey_do_something"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
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

        "/notification/account_fund_approved_ml"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_ml-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_salary"(platform: "/mobile") {
            news_id = "account_fund-account_fund_salary-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_cvu"(platform: "/mobile") {
            news_id = "account_fund-cvu-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_approved_ted"(platform: "/mobile") {
            news_id = "account_fund-approved_ted-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_approved_ml"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_ml-12345678"
            event_type = "shown"
        }

        "/notification/anses_payment_date"(platform: "/mobile") {
            news_id = "anses_payment_date-12345678-123"
            event_type = "shown"
        }

        "/notification/anses_paid_benefit"(platform: "/mobile") {
            news_id = "anses_paid_benefit-12345678-123"
            event_type = "shown"
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

        "/notification/campaigns_generic"(platform: "/") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            campaign_type="xp_cupones"
            campaign_data = "MLB1234"
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

        "/notification/campaigns_marketplace_discounts"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
        }

        "/notification/campaigns_checkout_recovery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLV515515631"
            variation_id="BLUE"
            experiment = false
        }

        "/notification/campaigns_acho_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLV515515631"
        }

        "/notification/campaigns_ticket_recovery"(platform: "/") {
            news_id = "12332323"
            event_type = "sent"
            deeplink ="meli://purchases"
            campaign_id = "mkt_campaign_ticket_recovery"
            test_notification = false
            sent_date = "20190129"
        }

        "/notification/campaigns_cho_cart_recovery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            items = "MLV515515631,MLV515515632,MLV515515633"
        }

        "/notification/campaigns_deal_alert"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLB1234"
        }

        "/notification/campaigns_recharge_recovery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://cellphone-recharge/"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            experiment = false
        }

        "/notification/cancellations_warning_seller_suspended"(platform: "/mobile") {
            event_type = "shown"
        }

        "/notification/coverages_compensation_complainant"(platform: "/mobile") {
            event_type = "shown"
            activity_id = "12345"
        }

        "/notification/compliance_support_validations"(platform: "/mobile") {
            event_type = "shown"
        }

        "/notification/chargeback_payer_start_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_start_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }
        "/notification/chargeback_payer_notify_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_notify_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }
        "/notification/chargeback_payer_update_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_update_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }
        "/notification/chargeback_payer_ultimatum_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_ultimatum_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }
        "/notification/chargeback_payer_intensify_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_intensify_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }

        "/notification/credits_consumer_expired_n_loans_fourth_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_fourth_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_n_loans_second_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_second_noticee-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_n_loans_third_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_third_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_fortyfive_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_third_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_sixty_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_third_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_about_to_expire_n_loans_first_notice"(platform: "/mobile") {
            news_id = "credits-consumer_about_to_expire_n_loans_first_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_n_loans_first_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_first_notice-122359638-20180516"
            event_type = "dismiss"
        }

        "/notification/credits_consumer_about_to_expire_second_notice"(platform: "/mobile") {
            news_id = "credits-consumer_about_to_expire_second_notice-186785675-20180409"
            event_type = "shown"
            installment_id = 9876
            loan_id = 12345433
        }

        "/notification/credits_consumer_expired_fourth_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_fourth_notice-186785675-20180409"
            event_type = "shown"
            installment_id = 9876
            loan_id = 12345433
        }

        "/notification/credits_consumer_expired_second_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_second_notice-186785675-20180409"
            event_type = "shown"
            installment_id = 9876
            loan_id = 12345433
        }

        "/notification/credits_consumer_expired_third_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_third_notice-186785675-20180409"
            event_type = "shown"
            installment_id = 9876
            loan_id = 12345433
        }

        "/notification/credits_consumer_first_time_use_notice"(platform: "/mobile") {
            news_id = "credits-consumer_first_time_use_notice-186785675-20180409"
            event_type = "shown"
            installment_id = 9876
            loan_id = 12345433
        }

        "/notification/credits_consumer"(platform: "/mobile") {
            news_id = "credits-consumer_186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_closing_date_notice"(platform: "/mobile") {
            news_id = "credits-consumer_closing_date_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_expired_first_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_first_notice-1329452"
            event_type = "dismiss"
            installment_id= 717743
            loan_id= 107849
        }

        "/notification/credits_merchants_educational"(platform: "/mobile") {
            news_id = "credits-merchants_educational-9876"
            event_type = "shown"
            loan_id = 123
        }

        "/notification/cx_question_ml"(platform: "/mobile"){
            case_id= 12345678
            event_type = "sent"
        }

        "/notification/instore_discover_activities"(platform: "/mobile"){
            news_id = "instore-discover_activities-321953606"
            event_type = "sent"
        }

        "/notification/messages_new"(platform: "/mobile"){
            news_id = "messages-new-321953606"
            event_type = "sent"
        }

        "/notification/messages_quotes"(platform: "/mobile"){
            news_id = "messages-quotes-321953606"
            event_type = "sent"
        }

        "/notification/messages_flex"(platform: "/mobile"){
            news_id = "messages-flex-321953606"
            event_type = "sent"
        }

        "/notification/messages_driver_logistics"(platform: "/mobile"){
            news_id = "messages-driver_logistics-321953606"
            event_type = "sent"
        }

        "/notification/me_flex_optin_activation"(platform: "/mobile"){
            news_id = "me_flex-optin_activation-315571651"
            event_type = "sent"
        }

        "/notification/me_flex_optin_reminder"(platform: "/mobile"){
            news_id = "me_flex-optin_reminder-315571651"
            event_type = "sent"
        }

        "/notification/moderations_item_to_patch"(platform: "/mobile"){
            news_id = "moderations-item_to_patch-MLB1029865869-104215143"
            event_type = "discarded"
            item_id = "MLB1029865869"
        }

        "/notification/moderations_item_forbidden"(platform: "/mobile"){
            news_id = "moderations-item_forbidden-MLU452272153-104009955"
            event_type = "discarded"
            item_id = "MLU452272153"
        }

        "/notification/moderations_item_warning"(platform: "/mobile"){
            news_id = "moderations-item_warning-MLA711938299-104104695"
            event_type = "discarded"
            item_id = "MLA711938299"
        }

        "/notification/moderations_message_banned"(platform: "/mobile"){
            news_id = "moderations-message_banned-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "discarded"
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

        "/notification/listings"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
        }

        "/notification/campaigns_syi_freemium"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "registered_between_1_and_2_weeks_ago_and_have_not_listed_in_core"
        }

        "/notification/campaigns_control_group"(platform: "/mobile") {
            news_id = "CIbDQhDb3hMYCQ==-5e22992d1b3518a"
            event_type = "discarded"
            campaign_id = "RECOVERY_CHECKOUT_MLB_60m-65m_20180516_CG"
            sent_date = "20180516"
            batch_id = "RECOVERY_CHECKOUT_MLB_60m-65m"
            deal_id = "RMK_MCO"
        }

        "/notification/questions_new"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "dismiss"
            deeplink = "meli://seller_question/12221"
            question_id = 1234
        }

        "/notification/questions_answered"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            deeplink ="meli://buyer_questions"
            question_id = 1234
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

        "/notification/openplatform_sellers_inhouse"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_wannabe"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p4"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p3"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p2"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p1"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        //Quotes
        "/notification/quotes_reject"(platform: "/mobile") {
            news_id = "quotes-reject-123"
            event_type = "open"
        }

        "/notification/quotes_new"(platform: "/mobile") {
            news_id = "quotes-reject-123"
            event_type = "open"
        }

        "/notification/quotes_cancel"(platform: "/mobile") {
            news_id = "quotes-reject-123"
            event_type = "open"
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
        "/notification/orders_deliver_confirmation"(platform: "/mobile") {
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
        "/notification/orders_buyer"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            type= "orders-buyer"
        }
        "/notification/orders_seller"(platform: "/mobile") {
            news_id = "orders-seller-1712072317"
            event_type = "action_open"
            type= "orders-seller"
        }
        "/notification/orders_ticket_payment_pending_extend_expiration_general_notice"(platform: "/mobile") {
            news_id = "orders-ticket_payment_pending_extend_expiration_general_notice-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            order_id = 1957429460
        }
        "/notification/orders_ticket_payment_pending_close_expiration_general_notice"(platform: "/mobile") {
            news_id = "orders-ticket_payment_pending_close_expiration_general_notice-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            order_id = 1957429460
        }
        "/notification/orders_ticket_payment_pending_reminder_general_notice"(platform: "/mobile") {
            news_id = "orders-ticket_payment_pending_reminder_general_notice-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            order_id = 1957429460
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
        "/notification/qrviral_onboard"(platform: "/mobile") {
            news_id = "qrviral-onboard-1234-186785675"
            event_type = "open"
        }
        "/notification/qrviral_onboard_recharge"(platform: "/mobile") {
            news_id = "qrviral-onboard_recharge-1234-186785675"
            event_type = "open"
            campaign_id = "qrviral-onboard_recharge"
        }
        "/notification/qrviral_reminder"(platform: "/mobile") {
            news_id = "qrviral-reminder-1234-186785675"
            event_type = "open"
        }
        "/notification/qrviral_extension"(platform: "/mobile") {
            news_id = "qrviral-extension-1234-186785675"
            event_type = "open"
        }
        "/notification/qrviral_reminder_mp"(platform: "/mobile") {
            news_id = "qrviral_reminder_mp-1234-186785675"
            event_type = "open"
        }
        "/notification/reputation"(platform: "/mobile") {
            newsgroup_id= "packages-seller-2000000031949978"
            event_type= "open"
            deeplink= "meli://messages/orders/1709786702"
            type_layout= "bullet_list"
            latest_news_type= "reputation"
            latest_news_id= "reputation-1692352012-88594841"
        }
        "/notification/reputation_free_shipping_activation"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }
        "/notification/reputation_medal_lost_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }
        "/notification/reservations_new"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_confirmed"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_buyer_confirm_delivery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_seller_confirm_delivery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_timeout_buyer_cancel"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_timeout_seller_cancel"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_seller_cancel"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_buyer_confirm_delivery_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
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
        }

        "/notification/shipping_not_delivered_receiver"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }

        "/notification/shipping_soon_deliver"(platform: "/mobile"){
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

        "/notification/shipping_legacy_agency_withdrawal"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
            agency_to_agency = true
        }
        "/notification/shipping_legacy_not_delivered_receiver"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
        }

        "/notification/shipping_legacy_delayed_receiver"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
            delay_reason = "shipping_time"
        }
        "/notification/shipping_legacy_delivered"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
        }
        "/notification/shipping_legacy_shipped"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
        }
        "/notification/shipping_legacy_delayed_sender"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
        }
        "/notification/shipping_legacy_reminder_agency_withdrawal"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
        }
        "/notification/shipping_not_delivered_retained_sender"(platform: "/mobile"){
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
        }

        "/notification/mediations_complainant"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
        }

        "/notification/mediations_legacy_complainant"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
            order_id = 1234321
        }

        "/notification/mediations_respondent"(platform: "/mobile") {
            news_id = "mediations-respondent-1013715421-5b0d7ee426e063333fe0c582"
            event_type = "shown"
            notification_style = "c"
            claim_id = 1013715459
        }

        "/notification/questions_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            question_id = 1234
        }

        "/notification/questions_buyer"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            notification_style = "BigTextStyle"
        }

        "/notification/questions_seller"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            notification_style = "BigTextStyle"
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

        "/notification/payments_pending_remainder"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/payments_pending_reminder"(platform: "/mobile") {
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

        "/notification/messages_driver_logistics"(platform: "/mobile/android") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/messages_flex"(platform: "/mobile/android") {
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
            item_id = "123"
            campaign_id = 1234
        }

        "/notification/campaigns_suggested_discounts_buyer"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
            item_id = "123"
            campaign_id = 1234
        }

        "/notification/campaigns_suggested_discounts_buyer"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            item_id = "123"
            campaign_id = 1234
        }

        "/notification/campaigns_download_app"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/campaigns_remarketing"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            campaign_id= "MLV515515631"
            test_notification= false
            sent_date= "20180508"
            batch_id = "MLB_PACK_20180508_2"
            hash="hash1"
            items_recommendations="MLB557314949,MLB613999012,MLB677993650,MLB695215973"
            items_history="MLB595398238,MLB649162181,MLB656729144"
        }

        "/notification/campaigns_remarketing_motors"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            campaign_id= "MLV515515631"
            test_notification= false
            sent_date= "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLU457119874"
        }

        "/notification/packages_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            purchase_id= 1000000016589794
            pack_id= 2000000032080846
        }

        "/notification/loyalty"(platform: "/mobile") {
            news_id = "loyalty-137855615"
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

        "/notification/mshops_questions"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/mshops_orders"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/puis_agency_withdrawal"(platform: "/mobile") {
            news_id = "puis-agency_withdrawal-21409256437"
            event_type = "sent"
            pickup_id = 1234
        }

        "/notification/puis_confirmation"(platform: "/mobile") {
            news_id = "puis-confirmation-21409256437"
            event_type = "sent"
            pickup_id = 1234
        }

        "/notification/puis_picked_up"(platform: "/mobile") {
            news_id = "puis-picked_up-21409256437"
            event_type = "sent"
            pickup_id = 1234
        }

        "/notification/puis_reschedule"(platform: "/mobile") {
            news_id = "puis-reschedule-21409256437"
            event_type = "sent"
            pickup_id = 1234
        }

        "/notification/reservations_buyer_cancel"(platform: "/mobile") {
            news_id = "reservations-buyer_cancel-1004906131"
            event_type = "open"
            order_id = 1004906131
        }

        "/notification/returns_return_cancelled"(platform: "/mobile") {
            news_id = "returns-return_cancelled-1674717959-216070768"
            event_type = "arrived"
            order_id = 1703754979
        }

        "/notification/returns_return_expired"(platform: "/mobile") {
            news_id = "returns-return_expired-1674717959-216070768"
            event_type = "arrived"
            order_id = 1703754979
        }

        "/notification/returns_shipped_seller"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_init_return"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_init_return_buyer"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_refund_payment"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_reminder_printed"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_no_refund_payment"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_pickup_expired"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_reminder_not_printed"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/security_enrollment"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/security_phone_confirmation"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_event_feedback"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_account_validation"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_login_auth"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_device_authorization"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_recovery_canceled"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_login_code"(platform: "/mobile") {
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

        "/notification/fraud_delivery_cancellation_stop_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_cash_release_iv"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_iv_credentials"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_score_post_approval_last_chance_mp"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_score_post_approval_last_chance_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/health_check"(platform: "/mobile/android") {
            news_id = "COXwPxDrigQYBw==-1eb9ff37e01d45b0"
            original_news_id = "messages-new-1688986927-60f251a8ee0a4b748b6c1b59bc1e267a"
            event_type = "arrived"
        }

        "/notification"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "sent"
        }

        "/notification/account_fund_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_approved_ml"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_ml-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_salary"(platform: "/mobile") {
            news_id = "account_fund-account_fund_salary-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_cvu"(platform: "/mobile") {
            news_id = "account_fund-account_fund_cvu-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_approved_ted"(platform: "/mobile") {
            news_id = "account_fund-account_fund_approved_ted-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_approved_ml"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_ml-12345678"
            event_type = "shown"
        }

        "/notification/anses_payment_date"(platform: "/mobile") {
            news_id = "anses_payment_date-12345678-123"
            event_type = "shown"
        }

        "/notification/anses_paid_benefit"(platform: "/mobile") {
            news_id = "anses_paid_benefit-12345678-123"
            event_type = "shown"
        }

        "/notification/asset_management_warm_up"(platform: "/mobile") {
            news_id = "asset-management_warm_up-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_pending"(platform: "/mobile") {
            news_id = "asset-management_pending-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_investing"(platform: "/mobile") {
            news_id = "asset-management_investing-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_disabled"(platform: "/mobile") {
            news_id = "asset-management_disabled-12345678-123123"
            event_type = "shown"
        }

        "/notification/mpcampaigns_campaigns"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            campaign_id = "mkt_campaign_co"
            batch_id = "MLB_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }

        "/notification/mpcampaigns_control_group"(platform: "/mobile") {
            news_id = "123"
            event_type = "discarded"
            campaign_id = "MLA_MP_PRUEBA_G_20181211_CG"
            deal_id = "MLA_MP_PRUEBA_G_20181211"
            sent_date = "20181211"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }

        "/notification/mpcampaigns_mpcampaignspromo"(platform: "/mobile") {
            news_id = "123"
            event_type = "discarded"
            campaign_id = "MLA_MP_PRUEBA_G_20181211_CG"
            deal_id = "MLA_MP_PRUEBA_G_20181211"
            sent_date = "20181211"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }

        "/notification/mpcampaigns_mpcampaignsinfo"(platform: "/mobile") {
            news_id = "123"
            event_type = "discarded"
            campaign_id = "MLA_MP_PRUEBA_G_20181211_CG"
            deal_id = "MLA_MP_PRUEBA_G_20181211"
            sent_date = "20181211"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }

        "/notification/mp_sponsor_campaign_start_campaign"(platform: "/mobile") {
            news_id = "mp_sponsor-campaign_start_campaign-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_sponsor_campaign_budget_trigger"(platform: "/mobile") {
            news_id = "mp_sponsor-campaign_budget_trigger-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_sponsor_campaign_day_trigger"(platform: "/mobile") {
            news_id = "mp_sponsor-campaign_day_trigger-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_seller_campaign_start_campaign"(platform: "/mobile") {
            news_id = "mp_seller-campaign_start_campaign-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_seller_campaign_end_campaign"(platform: "/mobile") {
            news_id = "mp_seller-campaign_end_campaignn-12345678-123123"
            event_type = "shown"
        }

        "/notification/credits_merchants_expired_first_notice"(platform: "/mobile") {
            news_id = "credits-merchants_expired_first_notice-9876"
            event_type = "shown"
            installment_id = 9876
        }

        "/notification/credits_merchants_expired_second_notice"(platform: "/mobile") {
            news_id = "credits-merchants_expired_second_notice-9876"
            event_type = "shown"
            installment_id = 9876
        }

        "/notification/credits_merchants_expired_third_notice"(platform: "/mobile") {
            news_id = "credits-merchants_expired_third_notice-9876"
            event_type = "shown"
            installment_id = 9876
        }

        "/notification/credits_merchants_about_to_expire_first_notice"(platform: "/mobile") {
            news_id = "credits-merchants_about_to_expire_first_notice-9876"
            event_type = "shown"
            installment_id = 9876
        }

        "/notification/credits_merchants_expired_no_charges"(platform: "/mobile") {
            news_id = "credits-merchants_expired_no_charges-9876"
            event_type = "shown"
            installment_id = 9876
        }
        "/notification/credits_merchants_to_expire"(platform: "/mobile") {
            news_id = "credits-merchants_to_expire-9876"
            event_type = "shown"
            installment_id = 9876
        }
        "/notification/credits_merchants_expired_near_to_fixed_charges"(platform: "/mobile") {
            news_id = "credits-merchants_expired_near_to_fixed_charges-9876"
            event_type = "shown"
        }
        "/notification/credits_merchants_expired_near_to_daily_charges"(platform: "/mobile") {
            news_id = "credits-merchants_expired_near_to_daily_charges-9876"
            event_type = "shown"
        }

        "/notification/credits_merchants_to_expire_standard"(platform: "/mobile") {
            news_id = "credits-merchants_to_expire_standard-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_to_expire_not_standard"(platform: "/mobile") {
            news_id = "credits-merchants_to_expire_not_standard-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_educational"(platform: "/mobile") {
            news_id = "credits-merchants_educational-9876"
            event_type = "shown"
            loan_id = 123
        }

        "/notification/compliance_support_validations"(platform: "/mobile") {
            event_type = "shown"
        }

        "/notification/fraud_cash_release_iv"(platform: "/mobile") {
            news_id = "fraud_cash_release_iv-12345678"
            event_type = "shown"
        }

        "/notification/health_check"(platform: "/mobile/android") {
            news_id = "COXwPxDrigQYBw==-1eb9ff37e01d45b0"
            original_news_id = "messages-new-1688986927-60f251a8ee0a4b748b6c1b59bc1e267a"
            event_type = "arrived"
        }

        "/notification/invite_gift"(platform: "/mobile"){
            news_id = "invite-gift-12345"
            event_type = "sent"
        }

        "/notification/messages_new"(platform: "/mobile") {
            news_id = "messages_new_123"
            event_type = "open"
        }

        //Merchant
        "/notification/merchants_growth_mgm"(platform: "/mobile") {
            latest_news_type= "merchants_growth_mgm"
            latest_news_id= "merchants_growth_mgm-126635313"
            gift_reason_id = "test"
            event_type = "open"
        }

        "/notification/money_transfer_received"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/money_transfer_request"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/loyalty_milestone"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/prepaid_card_shipped"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_waiting_for_withdrawal"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_delivered"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_delayed_p1"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_not_delivered"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_third_activation_reminder"(platform: "/mobile") {
            news_id = "prepaid_card-third_activation_reminder-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_second_activation_reminder"(platform: "/mobile") {
            news_id = "prepaid_card-second_activation_reminder-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_activation_reminder"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_activation_reminder-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_invalid_pin"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_invalid_pin-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_approved_authorization"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_approved_authorization-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_approved_withdraw"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_approved_withdraw-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_canceled_authorization"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_canceled_authorization-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_canceled_withdraw"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_canceled_withdraw-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_authorization_by_invalid_amount_with_avaible_balance-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_challenge_bolbradesco_reminder"(platform: "/mobile") {
            news_id = "prepaid_card-challenge_bolbradesco_reminder-43545334234"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_red_link_bug"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_red_link_bug-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_delivery"(platform: "/mobile") {
            news_id = "prepaid_card-delivery-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_approved_authorization"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_approved_authorization-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_approved_withdraw"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_approved_withdraw-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_canceled_authorization"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_canceled_authorization-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_canceled_withdraw"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_canceled_withdraw-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_authorization_by_invalid_amount_with_avaible_balance-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_authorization_by_invalid_amount-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_challenge_bolbradesco_reminder"(platform: "/mobile") {
            news_id = "prepaid_card-challenge_bolbradesco_reminder-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_delivery"(platform: "/mobile") {
            news_id = "prepaid_card-delivery-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_transaction_rejected_withdraw_freeze"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_freeze-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_transaction_rejected_regulations_bacen_data_incomplete"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_regulations_bacen_data_incomplete-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_transaction_rejected_authorization_freeze"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_authorization_freeze-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_reissue_reminder"(platform: "/mobile") {
            news_id = "prepaid_card_reissue_reminder-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_soon_deliver"(platform: "/mobile") {
            news_id = "prepaid_card_soon_deliver-186785675"
            event_type = "auto_dismiss"
        }

        "/notification/point_shipping_ready_to_ship"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_shipped"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_not_delivered"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_waiting_for_withdrawal"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_delayed_p1"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }


        "/notification/point_shipping_delayed_p4_p8"(platform: "/mobile") {
            news_id = "point_shipping-delayed_p4_p8-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_ready_to_ship_delayed"(platform: "/mobile") {
            news_id = "point_shipping-ready_to_ship_delayed-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/recurring_recharge_insufficient_balance_error"(platform: "/mobile") {
            news_id = "recurring_recharge_insufficient_balance_error-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/security_event_feedback"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/questions_new"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "dismiss"
            question_id = 1234
        }

        "/notification/seller_qr_payment_received"(platform: "/mobile") {
            news_id = "seller_qr_payment_received-186785675"
            event_type = "open"
        }

        "/notification/seller_integrations_new_payment"(platform: "/mobile") {
            news_id = "seller_integrations_new_payment-186785675"
            event_type = "open"
        }

        "/notification/seller_integrations_erase_name"(platform: "/mobile") {
            news_id = "seller_integrations_erase_name-186785675"
            event_type = "open"
        }

        "/notification/orders_new"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }

        "/notification/wallet_integrator_insufficient_amount"(platform: "/mobile") {
            news_id = "wallet_integrator-insufficient_amount-186785675"
            event_type = "open"
        }

        //Withdrawal
        "/notification/withdraw_approved_contingency"(platform: "/mobile") {
            news_id = "withdraw-approved_contingency-186785675"
            event_type = "open"
        }

        "/notification/discount_central_missing_data"(platform: "/mobile") {
            news_id = "discount_central-missing_data-12332323"
            event_type = "shown"
        }

    }

    defaultBusiness = "mercadopago"
    test("Mobile Notifications mercadopago"){

        "/device_settings"(platform: "/", type:TrackType.Event) {}

        "/device_settings/notifications"(platform: "/mobile/android", type:TrackType.Event) {
            device_id = "ee6f7bd224c2d6"
            enable = false
            registration_id = "dH2soSpvhwM:APA91bFwZmJy-wXP7DRLm_458FqPF9n8zbm7uVjixKUOHOS8FQ7QN-qSbWS_DrKYDiXyLzGE2giqzVf90fwyjNy4dkgi6hR_W_fv6JvnQo6B5AQ4BOX21g8wx0cLSrcJswrof5U3f"
        }

        "/notification_center/screen"(platform: "/", type: TrackType.View){}
        "/notification_center"(platform: "/mobile"){}
        "/notification_center/abort"(platform: "/mobile"){}
        "/notification_center/addresses-update"(platform: "/mobile") {
            latest_news_type= "addresses-update"
            latest_news_id= "addresses-update-126635313"
        }
        "/notification_center/back"(platform: "/mobile"){}
        "/notification_center/failure"(platform: "/mobile"){}
        "/notification_center"(platform: "/mobile") {
            newsgroup_id = "12332323"
            event_type = "open"
        }
        "/notification_center/reputation"(platform: "/mobile"){
            newsgroup_id= "reputation-126635313"
            status= "read"
            event_type= "open"
            deeplink= "https://reputacao.mercadolivre.com.br/myReputation"
            type_layout= "standard"
            latest_news_type= "reputation"
            latest_news_id= "reputation-126635313-grace_time_126635313-13804002905"
        }
        "/notification_center/reputation-medal_lost_reminder"(platform: "/mobile"){
            newsgroup_id= "reputation-medal_lost_reminder-126635313"
            status= "read"
            event_type= "open"
            deeplink= "https://reputacao.mercadolivre.com.br/myReputation"
            type_layout= "standard"
            latest_news_type= "reputation-medal_lost_reminder"
            latest_news_id= "reputation-medal_lost_reminder-126635313-grace_time_126635313-13804002905"
        }
        "/notification_center/security-enrollment"(platform: "/mobile"){
            newsgroup_id= "security-enrollment-142242996"
            status= "unread"
            event_type= "open"
            deeplink= "meli://generic_landing?url=https%3A%2F%2Faccountrecovery.mercadolivre.com.br%2Fenrollment%3Fsection%3DMDP_UPDATED_NOTIF%26nativeMobile%3DANDROID"
            type_layout= "standard"
            latest_news_type= "security-enrollment"
            latest_news_id= "security-enrollment-305337286"
        }
        "/notification_center/security-enrollment-legacy"(platform: "/mobile"){
            newsgroup_id= "security-enrollment-142242996"
            status= "unread"
            event_type= "open"
            deeplink= "meli://generic_landing?url=https%3A%2F%2Faccountrecovery.mercadolivre.com.br%2Fenrollment%3Fsection%3DMDP_UPDATED_NOTIF%26nativeMobile%3DANDROID"
            type_layout= "standard"
        }
        "/notification_center/loyalty"(platform: "/mobile"){
            newsgroup_id= "LOYALTY-48422892"
            status= "unread"
            event_type= "open"
            deeplink= "https://www.mercadolivre.com.br/mercadopontos/fretegratis"
            type_layout= "standard"
        }
        "/notification_center/loyalty-freeshipping"(platform: "/mobile"){
            newsgroup_id= "loyalty-freeshipping-321438470"
            status= "unread"
            event_type= "open"
            deeplink= "meli://loyalty/?selectedTab=benefits"
            type_layout= "standard"
            latest_news_type= "loyalty-freeshipping"
            latest_news_id= "loyalty-freeshipping-321438470"
        }
        "/notification_center/mediations-complainant"(platform: "/mobile"){
            newsgroup_id= "mediations-995364894"
            status= "read"
            event_type= "open"
            deeplink= "meli://generic_landing?url=https%3A%2F%2Fmediations.mercadolibre.com.ar%2Fclaims%2F995364894&authenticate=true"
            type_layout= "standard"
            claim_id= 995364894
            latest_news_type= "mediations-complainant"
            latest_news_id= "mediations-complainant-995364894-5afa30fa7eb37e6b7470573b"
        }
        "/notification_center/mediations-complainant-legacy"(platform: "/mobile"){
            newsgroup_id= "MEDIATIONS-1287016973"
            status= "read"
            event_type= "open"
            deeplink= "meli://purchases/1287016973/claims/900736064"
            type_layout= "standard"
        }
        "/notification_center/purchase-pending-legacy"(platform: "/mobile"){
            newsgroup_id= "purchase-pending-210167262-MLA646946595"
            status= "read"
            event_type= "open"
            deeplink= "meli://item?id=MLA646946595"
            type_layout= "standard"
        }
        "/notification_center/reviews-reminder"(platform: "/mobile"){
            vertical= "services"
            latest_news_type= "reviews-reminder"
            latest_news_id= "reviews-reminder-143816022-MLB1013046714"
        }
        "/notification_center/fiscal_data-business_registration"(platform: "/mobile"){
            latest_news_type= "fiscal_data-business_registration"
            latest_news_id= "fiscal_data-business_registration-143816022-MLB1013046714"
        }
        "/notification_center/instore-activities"(platform: "/mobile"){
            latest_news_type= "instore-activities"
            latest_news_id= "instore-activities-143816022-MLB1013046714"
        }
        "/notification_center/invoices"(platform: "/mobile"){
            latest_news_type= "invoices"
            latest_news_id= "invoices-143816022-MLB1013046714"
        }
        "/notification_center/listings"(platform: "/mobile"){}
        "/notification_center/campaigns-deals"(platform: "/mobile"){
            campaign_id= "campaign1"
            deal_id= "deal1_123"
            newsgroup_id= "deals-MLU102_07_02_2017-56626993"
            status= "unread"
            event_type= "swipe"
            type_layout= "picture"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
        }
        "/notification_center/campaigns-campaigns"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "deals-MLU102_07_02_2017-56626993"
            status= "unread"
            event_type= "swipe"
            type_layout= "picture"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
        }
        "/notification_center/campaigns-generic"(platform: "/"){
            campaign_id= "campaign1"
            campaign_type="xp_cupones"
            campaign_data = "MLV515515631,MLV515515632,MLV515515633"
            newsgroup_id= "campaigns-generic-MLU102_07_02_2017-56626993"
            status= "unread"
            event_type= "swipe"
            type_layout= "picture"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-generic"
            latest_news_id= "campaigns-generic-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-suggested_discounts_buyer"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-suggested_discounts_buyer-142593788-MLA645507294"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            item_id= "MLV515515631"
            latest_news_type= "campaigns-suggested_discounts_buyer"
            latest_news_id= "campaigns-suggested_discounts_buyer-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-suggested_discounts_seller"(platform: "/mobile"){
            newsgroup_id= "campaigns-suggested_discounts_seller-142593788-MLA645507294"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-suggested_discounts_seller"
            latest_news_id= "campaigns-suggested_discounts_seller-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-buyequalspay"(platform: "/mobile"){
            newsgroup_id= "campaigns-buyequalspay-4939870"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            latest_news_type= "campaigns-buyequalspay"
            latest_news_id= "campaigns-buyequalspay-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-cart_recovery"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-cart_recovery-192495923"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-cart_recovery"
            latest_news_id= "campaigns-cart_recovery-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-checkout_recovery"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-checkout_recovery-320010629"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-checkout_recovery"
            latest_news_id= "campaigns-checkout_recovery-143816022-MLB1013046714"
            item_id= "MLV515515631"
            variation_id="BLUE"
            experiment= false
        }
        "/notification_center/campaigns-acho_reminder"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-acho_reminder-320010629"
            event_type= "open"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-acho_reminder"
            latest_news_id= "campaigns-acho_reminder-143816022-MLB1013046714"
            item_id= "MLV515515631"
            variation_id= "1234"
        }
        "/notification_center/campaigns-ticket_recovery"(platform: "/") {
            campaign_id = "mkt_campaign_ticket_recovery"
            newsgroup_id = "campaigns_ticket_recovery-320010629"
            event_type = "open"
            deeplink = "meli://purchases"
            type_layout = "standard"
            test_notification = false
            sent_date = "20190129"
            latest_news_type = "campaigns_ticket_recovery"
            latest_news_id = "campaigns_ticket_recovery-143816022"
        }
        "/notification_center/campaigns-cho_cart_recovery"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-checkout_recovery-320010629"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-checkout_recovery"
            latest_news_id= "campaigns-checkout_recovery-143816022-MLB1013046714"
            items= "MLV515515631,MLV515515632,MLV515515633"
            experiment= false
        }
        "/notification_center/campaigns-deal_alert"(platform: "/mobile"){
            campaign_id= "DEAL_ALERT_MLB_20180508"
            newsgroup_id= "campaigns-deal_alert-152329972"
            event_type= "open"
            deeplink= "meli://item?id=MLB799297448&tool=69156792&word=COREPN_MLB_PUSH_DEALALERT_20180508&referrer=utm_source%3Dpromotional_notifications%26utm_medium%3Dnotifications%26utm_campaign%3DDEAL_ALERT_MLB_20180508%26utm_term%3Dpms-word%3ACOREPN_MLB_PUSH_DEALALERT_20180508%26utm_id%3Dpms-tool%3A69156792"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-deal_alert"
            latest_news_id= "campaigns-deal_alert-152329972-MLB799297448"
            item_id= "MLB799297448"
        }
        "/notification_center/campaigns-download_app"(platform: "/mobile"){
            newsgroup_id= "campaigns-download_app-96757367"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            latest_news_type= "campaigns-download_app"
            latest_news_id= "campaigns-download_app-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-prepaid_point"(platform: "/mobile"){
            newsgroup_id= "campaigns-prepaid_point-251663897"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            latest_news_type= "campaigns-prepaid_point"
            latest_news_id= "campaigns-prepaid_point-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-remarketing"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-remarketing-241951421"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-remarketing"
            latest_news_id= "campaigns-remarketing-143816022-MLB1013046714"
            hash="hash1"
            items_recommendations="MLB557314949,MLB613999012,MLB677993650,MLB695215973"
            items_history="MLB595398238,MLB649162181,MLB656729144"
        }
        "/notification_center/campaigns-remarketing_motors"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-remarketing_motors-241951421"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-remarketing_motors"
            latest_news_id= "campaigns-remarketing_motors-143816022-MLB1013046714"
            item_id= "MLU457119874"
        }
        "/notification_center/campaigns_marketplace_discounts"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-marketplace_discounts-241951421"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-marketplace_discounts"
            latest_news_id= "campaigns-marketplace_discounts-143816022-MLB1013046714"
        }
        "/notification_center/campaigns-recharge_recovery"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-recharge_recovery-320010629"
            event_type= "open"
            deeplink= "meli://cellphone-recharge/"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-recharge_recovery"
            latest_news_id= "campaigns-recharge_recovery-143816022-MLB1013046714"
            experiment= false
        }
        "/notification_center/compliance_support-validations"(platform: "/mobile"){
            latest_news_type= "compliance_support-validations"
            latest_news_id= "compliance_support-validations-143816022-MLB1013046714"
        }
        "/notification_center/credits_consumer"(platform: "/mobile"){
            newsgroup_id= "credits-consumer-213882865-255720"
            event_type= "open"
            deeplink= "meli://generic_landing?authenticate=true&url=https%3A%2F%2Fwww.mercadolibre.com.ar%2Fcredits%2Fconsumer%2Fnews%3FloanId%3D255720%26installmentId%3D1592866"
            type_layout= "standard"
            installment_id= 717743
            loan_id= 107849
            latest_news_type= "1592866"
            latest_news_id= "credits-consumer_expired_second_notice-1592866"
        }
        "/notification_center/credits-merchants"(platform: "/mobile"){
            newsgroup_id= "credits-merchants-213882865-255720"
            event_type= "open"
            deeplink= "meli://generic_landing?authenticate=true&url=https%3A%2F%2Fwww.mercadolibre.com.ar%2Fcredits%2Fconsumer%2Fnews%3FloanId%3D255720%26installmentId%3D1592866"
            type_layout= "standard"
            installment_id= 717743
            latest_news_type= "1592866"
            latest_news_id= "credits-merchants-1592866"
        }
        "/notification_center/cancellations"(platform: "/mobile") {
            latest_news_type= "cancellations"
            latest_news_id= "cancellations-143816022-MLB1013046714"
        }
        "/notification_center/coverages"(platform: "/mobile") {
            activity_id = "12345"
            latest_news_type= "coverages"
            latest_news_id= "coverages-143816022-MLB1013046714"
        }
        "/notification_center/cx-generic"(platform: "/mobile"){
            latest_news_type= "cx-generic"
            latest_news_id= "cx-generic-143816022-MLB1013046714"
        }
        "/notification_center/cx_question"(platform: "/mobile"){
            case_id= 12345678
            latest_news_type= "cx-cx_question"
            latest_news_id= "cx_question-143816022-MLB1013046714"
        }
        "/notification_center/fraud-identity_validation"(platform: "/mobile"){
            newsgroup_id= "fraud-identity_validation-142593788"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            latest_news_type= "fraud-identity_validation"
            latest_news_id= "campaigns-remarketing-143816022-MLB1013046714"
        }
        "/notification_center/fraud-postpayment"(platform: "/mobile"){}
        "/notification_center/fraud-delivery_cancellation"(platform: "/mobile"){
            latest_news_type= "fraud-delivery_cancellation"
            latest_news_id= "fraud-delivery_cancellation-143816022-MLB1013046714"
        }
        "/notification_center/fraud-cash_release_iv"(platform: "/mobile"){
            latest_news_type= "fraud-cash_release_iv"
            latest_news_id= "fraud-cash_release_iv-143816022-MLB1013046714"
        }
        "/notification_center/fraud-identity_validation_reminder"(platform: "/mobile"){
            latest_news_type= "fraud-identity_validation_reminder"
            latest_news_id= "fraud-identity_validation_reminder-143816022-MLB1013046714"
        }

        "/notification_center/messages_quotes"(platform: "/mobile"){
            latest_news_type= "messages_quotes"
            latest_news_id= "messages_quotes-143816022-MLB1013046714"
        }
        "/notification_center/messages_flex"(platform: "/mobile"){
            latest_news_type= "messages_flex"
            latest_news_id= "messages_flex-143816022-MLB1013046714"
        }
        "/notification_center/messages_driver_logistics"(platform: "/mobile"){
            latest_news_type= "messages_driver_logistics"
            latest_news_id= "messages_driver_logistics-143816022-MLB1013046714"
        }

        "/notification_center/openplatform_sellers_inhouse"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_sellers_inhouse"
            latest_news_id= "openplatform_sellers_inhouse-12345"
        }
        "/notification_center/openplatform_recommendations_wannabe"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_wannaber"
            latest_news_id= "openplatform_recommendations_wannabe-12345"
        }
        "/notification_center/openplatform_recommendations_p4"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p4"
            latest_news_id= "openplatform_recommendations_p4-12345"
        }
        "/notification_center/openplatform_recommendations_p3"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p3"
            latest_news_id= "openplatform_recommendations_p3-12345"
        }
        "/notification_center/openplatform_recommendations_p2"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p2"
            latest_news_id= "openplatform_recommendations_p2-12345"
        }
        "/notification_center/openplatform_recommendations_p1"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p1"
            latest_news_id= "openplatform_recommendations_p1-12345"
        }

        "/notification_center/packages-buyer"(platform: "/mobile"){}
        "/notification_center/packages-seller"(platform: "/mobile"){}
        "/notification_center/package-seller"(platform: "/mobile") {
            purchase_id= 1000000016589794
            pack_id= 2000000032080846
            shipment_id= 1234
            latest_news_type= "package-seller"
            latest_news_id= "package-seller-1000000016305386"
        }
        "/notification_center/messages_quotes"(platform: "/mobile") {
            latest_news_type= "messages_quotes"
            latest_news_id= "messages-quotes-123-123"
        }
        "/notification_center/messages_flex"(platform: "/mobile"){
            latest_news_type= "messages_flex"
            latest_news_id= "messages_flex-143816022-MLB1013046714"
        }
        "/notification_center/messages_driver_logistics"(platform: "/mobile"){
            latest_news_type= "messages_driver_logistics"
            latest_news_id= "messages_driver_logistics-143816022-MLB1013046714"
        }

        "/notification_center/me_flex-optin"(platform: "/mobile"){
            latest_news_type= "me_flex-optin"
            latest_news_id= "me_flex-optin-143816022-MLB1013046714"
        }
        "/notification_center/returns"(platform: "/mobile"){
            newsgroup_id= "packages-seller-2000000031949978"
            event_type= "open"
            deeplink= "meli://messages/orders/1709786702"
            type_layout= "bullet_list"
            order_id= 1692352012
            latest_news_type= "returns-init_return"
            latest_news_id= "returns-init_return-1692352012-88594841"
        }
        "/notification_center/mediations"(platform: "/", type: TrackType.Event) {
            claim_id= 443103451
        }
        "/notification_center/orders-buyer"(platform: "/mobile"){
            newsgroup_id= "orders-buyer-1285223441"
            status= "read"
            event_type= "open"
            deeplink= "meli://purchases/1285223441#payment"
            type_layout= "standard"
            order_id = 1234
        }
        "/notification_center/orders-seller"(platform: "/mobile"){
            newsgroup_id= "orders-seller-1288279054"
            action_type= "messages"
            status= "unread"
            event_type= "action_open"
            deeplink= "meli://sales/1288279054/messages/send"
            type_layout= "bullet_list"
            order_id = 1234
        }
        "/notification_center/package_seller"(platform: "/mobile"){
            newsgroup_id= "packages-seller-2000000031949978"
            event_type= "open"
            deeplink= "meli://messages/orders/1709786702"
            type_layout= "bullet_list"
            order_id= 1692352012
        }
        "/notification_center/purchases-payments"(platform: "/mobile"){
            newsgroup_id= "purchases-payments-1000000016305386"
            status= "read"
            event_type= "open"
            deeplink= "https://myaccount.mercadolibre.com.mx/purchases/1000000016305386/detail"
            type_layout= "standard"
            purchase_id= 1000000016305386
            latest_news_type= "purchases-payments_approved"
            latest_news_id= "purchases-payments_approved-1000000016305386"
        }

        "/notification_center/qrviral"(platform: "/mobile") {}
        "/notification_center/questions-buyer"(platform: "/mobile"){
            newsgroup_id= "question-123412"
            status= "read"
            event_type= "open"
            deeplink= "meli://buyer_questions/MLA1234/ask"
            type_layout= "bullet_list"
            question_id= 3730000436
        }
        "/notification_center/questions-seller"(platform: "/mobile"){
            newsgroup_id= "answer-123412"
            status= "unread"
            event_type= "swipe"
            deeplink= "meli://seller_questions/1234"
            type_layout= "bullet_list"
            question_id= 3730000436
        }
        "/notification_center/registration-info"(platform: "/mobile") {
            latest_news_type= "registration-info"
            latest_news_id= "registration-info-1000000016305386"
        }
        "/notification_center/registration-generated_pwd"(platform: "/mobile") {
            latest_news_type= "registration-generated_pwd"
            latest_news_id= "registration-generated_pwd-1000000016305386"
        }
        "/notification_center/reservations"(platform: "/mobile") {
            order_id = 12132
        }
        "/notification_center/reservations-pending_reminder"(platform: "/mobile") {
            latest_news_type= "reservations-pending_reminder"
            latest_news_id= "reservations-pending_reminder-1000000016305386"
        }
        "/notification_center/sc_editor_off"(platform: "/mobile") {
            latest_news_type= "sc_editor_off"
            latest_news_id= "sc_editor_off-1000000016305386"
        }
        "/notification_center/security-account_validation"(platform: "/mobile") {
            latest_news_type= "security-account_validation"
            latest_news_id= "security-account_validation-1000000016305386"
        }
        "/notification_center/security-device_authorization"(platform: "/mobile") {
            latest_news_type= "security-device_authorization"
            latest_news_id= "security-device_authorization-1000000016305386"
        }
        "/notification_center/security-device_authorization_congrats"(platform: "/mobile") {
            latest_news_type= "security-device_authorization_congrats"
            latest_news_id= "security-device_authorization_congrats-1000000016305386"
        }

        "/notification_center/security_recovery_canceled"(platform: "/mobile") {
            latest_news_type= "security_recovery_canceled"
            latest_news_id= "security_recovery_canceled-1000000016305386"
        }

        "/notification_center/security_phone_enrollment"(platform: "/mobile") {
            latest_news_type= "security_phone_enrollment"
            latest_news_id= "security_phone_enrollment-1000000016305386"
        }

        "/notification_center/security_login_code"(platform: "/mobile") {
            latest_news_type= "security_login_code"
            latest_news_id= "security_login_code-1000000016305386"
        }

        "/notification_center/chargeback-payer"(platform: "/mobile") {
            case_id = "158213000000"
            latest_news_id = "chargeback-buyer-158213000000-init13545"
            latest_news_type = "chargeback-buyer"
            type_layout = "standard"
            newsgroup_id = "chargeback-buyer-158213000000"
            status = "unread"
            event_type = "open"
            deeplink = "https=//www.mercadolibre.com.ar/chargebacks/payer/select-remedy/158213000000#entry=notification"
        }
        "/notification_center/quotes_new"(platform: "/mobile") {
            latest_news_type= "quotes_new"
            latest_news_id= "quotes_new-123-123"
        }

        "/notification_center/quotes_reject"(platform: "/mobile") {
            latest_news_type= "quotes_reject"
            latest_news_id= "quotes_reject-123-123"
        }

        "/notification_center/quotes_cancel"(platform: "/mobile") {
            latest_news_type= "quotes_cancel"
            latest_news_id= "quotes_cancel-123-123"
        }

        "/notification_center/account_balance_approved_mp"(platform: "/mobile"){
            newsgroup_id= "account_balance-account_balance-approved_mp-12345678"
            latest_news_type= "account_balance_approved_mp"
            latest_news_id= "account_balance-account_balance-approved_mp-12345678"
            status= "unread"
        }
        "/notification_center/account_fund_approved_mp"(platform: "/mobile"){
            newsgroup_id= "account_fund-approved_mp-12345678"
            latest_news_id= "account_fund-approved_mp-12345678"
            latest_news_type= "account_fund_approved_mp"
            status= "unread"
        }
        "/notification_center/account_fund_salary"(platform: "/mobile"){
            newsgroup_id= "account_fund-salary-12345678"
            latest_news_id= "account_fund-salary-12345678"
            latest_news_type= "account_fund_salary"
            status= "unread"
        }
        "/notification_center/account_fund_cvu"(platform: "/mobile"){
            newsgroup_id= "account_fund-cvu-12345678"
            latest_news_id= "account_fund-cvu-12345678"
            latest_news_type= "account_fund_cvu"
            status= "unread"
        }
        "/notification_center/account_fund_approved_ted"(platform: "/mobile"){
            newsgroup_id= "account_fund_approved_ted-12345678"
            latest_news_id= "account_fund_approved_ted-12345678"
            latest_news_type= "account_fund_approved_ted"
            status= "unread"
        }
        "/notification_center/asset_management_warm_up"(platform: "/mobile"){
            newsgroup_id= "asset_management-warm_up-186785675-76283123"
            latest_news_id= "asset_management-warm_up-186785675-76283123"
            latest_news_type= "asset_management_warm_up"
            status= "read"
        }
        "/notification_center/billing_mpoff"(platform: "/mobile"){
            newsgroup_id= "billing-mpoff-186785675-76283123"
            latest_news_id= "billing-mpoff-186785675-76283123"
            latest_news_type= "billing_mpoff"
            status= "read"
        }
        "/notification_center/chargeback_payer_intensify_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_intensify_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_intensify_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_intensify_mp"
            status= "read"
        }
        "/notification_center/chargeback_payer_notify_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_notify_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_notify_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_notify_mp"
            status= "read"
        }
        "/notification_center/chargeback_payer_start_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_start_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_start_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_start_mp"
            status= "read"
        }
        "/notification_center/chargeback_payer_ultimatum_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_ultimatum_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_ultimatum_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_ultimatum_mp"
            status= "read"
        }
        "/notification_center/chargeback_payer_update_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_update_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_update_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_update_mp"
            status= "read"
        }
        "/notification_center/compliance_support-validations"(platform: "/mobile"){
            newsgroup_id= "compliance_support-validations-186785675-76283123"
            latest_news_id= "compliance_support-validations-186785675-76283123"
            latest_news_type= "compliance_support-validations"
            status= "read"
        }
        "/notification_center/credits_merchants_expired_near_to_daily_charges"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-expired_near_to_daily_charges-186785675-76283123"
            latest_news_id= "credits_merchants-expired_near_to_daily_charges-186785675-76283123"
            latest_news_type= "credits_merchants_expired_near_to_daily_charges"
            status= "read"
        }
        "/notification_center/credits_merchants_expired_near_to_fixed_charges"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-expired_near_to_fixed_charges-186785675-76283123"
            latest_news_id= "credits_merchants-expired_near_to_fixed_charges-186785675-76283123"
            latest_news_type= "credits_merchants_expired_near_to_fixed_charges"
            status= "read"
        }
        "/notification_center/credits_merchants_expired_no_charges"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-expired_no_charges-186785675-76283123"
            latest_news_id= "credits_merchants-expired_no_charges-186785675-76283123"
            latest_news_type= "credits_merchants_expired_no_charges"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits-merchants"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-to_expire-186785675-76283123"
            latest_news_id= "credits_merchants-to_expire-186785675-76283123"
            latest_news_type= "credits_merchants_to_expire"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_to_expire_not_standard"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-to_expire_not_standard-186785675-76283123"
            latest_news_id= "credits_merchants-to_expire_not_standard-186785675-76283123"
            latest_news_type= "credits_merchants_to_expire_not_standard"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_educational"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-educational-186785675-76283123"
            latest_news_id= "credits_merchants-educational-186785675-76283123"
            latest_news_type= "credits_merchants_educational"
            status= "read"
            loan_id = 123
        }
        "/notification_center/fraud-cash_release_iv"(platform: "/mobile"){
            newsgroup_id= "fraud-cash_release_iv-186785675-76283123"
            latest_news_id= "fraud-cash_release_iv-186785675-76283123"
            latest_news_type= "fraud_cash_release_iv"
            status= "read"
        }
        "/notification_center/fraud_score_post_approval"(platform: "/mobile"){
            newsgroup_id= "fraud_score_post_approval-186785675-76283123"
            latest_news_id= "fraud_score_post_approval-186785675-76283123"
            latest_news_type= "fraud_score_post_approval"
            status= "read"
        }
        "/notification_center/fraud_iv_credentials"(platform: "/mobile"){
            newsgroup_id= "fraud_iv_credentials-186785675-76283123"
            latest_news_id= "fraud_iv_credentials-186785675-76283123"
            latest_news_type= "fraud_iv_credentials"
            status= "read"
        }
        "/notification_center/instore_buyer_qr"(platform: "/mobile"){
            newsgroup_id= "instore-buyer_qr-186785675-76283123"
            latest_news_id= "instore-buyer_qr-186785675-76283123"
            latest_news_type= "instore_buyer_qr"
            status= "read"
        }
        "/notification_center/invite_gift"(platform: "/mobile"){
            newsgroup_id= "invite-gift-186785675-76283123"
            latest_news_id= "invite-gift-186785675-76283123"
            latest_news_type= "invite_gift"
            status= "read"
        }
        "/notification_center/merchants_growth_mgm"(platform: "/mobile"){
            newsgroup_id= "merchants_growth-mgm-186785675-76283123"
            latest_news_id= "merchants_growth-mgm-186785675-76283123"
            latest_news_type= "merchants_growth_mgm"
            status= "read"
            gift_reason_id= "MLB_14456"
        }
        "/notification_center/money-transfer_request"(platform: "/mobile"){
            newsgroup_id= "money-transfer_request-186785675-76283123"
            latest_news_id= "money-transfer_request-186785675-76283123"
            latest_news_type= "money-transfer_request"
            status= "read"
        }
        "/notification_center/mpcampaigns_campaigns"(platform: "/mobile"){
            newsgroup_id= "mpcampaigns-campaigns-186785675-76283123"
            latest_news_id= "mpcampaigns-campaigns-186785675-76283123"
            latest_news_type= "mpcampaigns_campaigns"
            status= "read"
            campaign_id = "mkt_campaign_co"
            batch_id = "MLB_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }
        "/notification_center/mpcampaigns_mpcampaignsinfo"(platform: "/mobile"){
            newsgroup_id= "mpcampaigns-mpcampaignsinfo-186785675-76283123"
            latest_news_id= "mpcampaigns-mpcampaignsinfo-186785675-76283123"
            latest_news_type= "mpcampaigns_mpcampaignsinfo"
            status= "read"
            campaign_id = "mkt_campaign_co"
            batch_id = "MLB_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }
        "/notification_center/mp_sponsor_campaign_start_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_-ampaign_start_campaign-143816022-MLB1013046714"
        }
        "/notification_center/mp_sponsor_campaign_budget_trigger"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor-campaign_budget_trigger-143816022-MLB1013046714"
        }
        "/notification_center/mp_sponsor_campaign_day_trigger"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor-campaign_day_trigger-143816022-MLB1013046714"
        }
        "/notification_center/mp_seller_campaign_start_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_seller-campaign_start_campaign-143816022-MLB1013046714"
        }
        "/notification_center/mp_seller_campaign_end_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_seller-campaign_end_campaign-143816022-MLB1013046714"
        }

        "/notification_center/prepaid_card"(platform: "/mobile"){
            newsgroup_id= "prepaid_card-delayed_p1-186785675-76283123"
            latest_news_id= "prepaid_card-delayed_p1-186785675-76283123"
            latest_news_type= "prepaid_card_delayed_p1"
            status= "read"
        }
        "/notification_center/prepaid_card_delivery"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_delivery-186785675-76283123"
            latest_news_id= "prepaid_card_delivery-186785675-76283123"
            latest_news_type= "prepaid_card_delivery"
            status= "read"
        }
        "/notification_center/prepaid_card_transaction_rejected_regulations_bacen_data_incomplete"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_transaction_rejected_regulations_bacen_data_incomplete-186785675-76283123"
            latest_news_id= "prepaid_card_transaction_rejected_regulations_bacen_data_incomplete-186785675-76283123"
            latest_news_type= "prepaid_card_transaction_rejected_regulations_bacen_data_incomplete"
            status= "read"
        }
        "/notification_center/prepaid_card_transaction_rejected_invalid_pin"(platform: "/mobile"){
            newsgroup_id= "pprepaid_card_transaction_rejected_invalid_pin-186785675-76283123"
            latest_news_id= "prepaid_card_transaction_rejected_invalid_pin-186785675-76283123"
            latest_news_type= "prepaid_card_transaction_rejected_invalid_pin"
            status= "read"
        }
        "/notification_center/prepaid_card_transaction_rejected_activation_reminder"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_transaction_rejected_activation_reminder-186785675-76283123"
            latest_news_id= "prepaid_card_transaction_rejected_activation_reminder-186785675-76283123"
            latest_news_type= "prepaid_card_transaction_rejected_activation_reminder"
            status= "read"
        }
        "/notification_center/transaction_approved_authorization"(platform: "/mobile"){
            newsgroup_id= "transaction_approved_authorization-186785675-76283123"
            latest_news_id= "transaction_approved_authorization-186785675-76283123"
            latest_news_type= "transaction_approved_authorization"
            status= "read"
        }
        "/notification_center/transaction_approved_withdraw"(platform: "/mobile") {
            newsgroup_id = "transaction_approved_withdraw-186785675-76283123"
            latest_news_id = "transaction_approved_withdraw-186785675-76283123"
            latest_news_type = "transaction_approved_withdraw"
            status = "read"
        }
        "/notification_center/transaction_canceled_authorization"(platform: "/mobile"){
            newsgroup_id= "transaction_canceled_authorization-186785675-76283123"
            latest_news_id= "transaction_canceled_authorization-186785675-76283123"
            latest_news_type= "transaction_canceled_authorization"
            status= "read"
        }
        "/notification_center/transaction_canceled_withdraw"(platform: "/mobile"){
            newsgroup_id= "transaction_canceled_withdraw-186785675-76283123"
            latest_news_id= "transaction_canceled_withdraw-186785675-76283123"
            latest_news_type= "transaction_canceled_withdraw"
            status= "read"
        }
        "/notification_center/transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_authorization_by_invalid_amount_with_avaible_balance-186785675-76283123"
            latest_news_id= "transaction_rejected_authorization_by_invalid_amount_with_avaible_balance-186785675-76283123"
            latest_news_type= "transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"
            status= "read"
        }
        "/notification_center/transaction_rejected_red_link_bug"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_red_link_bug-186785675-76283123"
            latest_news_id= "transaction_rejected_red_link_bug-186785675-76283123"
            latest_news_type= "transaction_rejected_red_link_bug"
            status= "read"
        }
        "/notification_center/transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance-186785675-76283123"
            latest_news_id= "transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance-186785675-76283123"
            latest_news_type= "transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"
            status= "read"
        }
        "/notification_center/recurring_recharge_error"(platform: "/mobile"){
            newsgroup_id= "recurring_recharge-error-186785675-76283123"
            latest_news_id= "recurring_recharge-error-186785675-76283123"
            latest_news_type= "recurring_recharge_error"
            status= "read"
        }
        "/notification_center/recurring_recharge_insufficient_balance_error"(platform: "/mobile"){
            newsgroup_id= "recurring_recharge-insufficient_balance_error-186785675-76283123"
            latest_news_id= "recurring_recharge-insufficient_balance_error-186785675-76283123"
            latest_news_type= "recurring_recharge_insufficient_balance_error"
            status= "read"
        }
        "/notification_center/recurring_recharge_second_auth_error"(platform: "/mobile"){
            newsgroup_id= "recurring_recharge-second_auth_error-186785675-76283123"
            latest_news_id= "recurring_recharge-second_auth_error-186785675-76283123"
            latest_news_type= "recurring_recharge_second_auth_error"
            status= "read"
        }
        "/notification_center/withdraw_approved_contingency"(platform: "/mobile") {
            latest_news_type= "withdraw_approved_contingency"
            latest_news_id= "withdraw_approved_contingency-143816022-MLB1013046714"
        }
        "/notification_center/withdraw_rejected_contingency"(platform: "/mobile") {
            latest_news_type= "coverages"
            latest_news_id= "withdraw_rejected_contingency-143816022-MLB1013046714"
        }
        "/notification_center/wallet_integrator_insufficient_amount"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator-insufficient_amount-186785675-76283123"
            latest_news_id= "wallet_integrator-insufficient_amount-186785675-76283123"
            latest_news_type= "wallet_integrator_insufficient_amount"
            status= "read"
        }
        "/notification_center/wallet_integrator_ticket_acredited"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator-ticket_acredited-186785675-76283123"
            latest_news_id= "wallet_integrator-ticket_acredited-186785675-76283123"
            latest_news_type= "wallet_integrator_ticket_acredited"
            status= "read"
        }

        "/notification_center/seller_journey_congrats"(platform: "/mobile"){
            step_id= 123
            event_type= "create"
        }
        "/notification_center/seller_journey_keep_it_up"(platform: "/mobile"){
            step_id= 123
            event_type= "create"
        }
        "/notification_center/seller_journey_work_harder"(platform: "/mobile"){
            step_id= 123
            event_type= "create"
        }
        "/notification_center/seller_journey_do_something"(platform: "/mobile"){
            step_id= 123
            event_type= "create"
        }

        "/notification/seller_journey_congrats"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
        }
        "/notification/seller_journey_keep_it_up"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
        }
        "/notification/seller_journey_work_harder"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
        }
        "/notification/seller_journey_do_something"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
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

        "/notification/account_fund_approved_ml"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_ml-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_salary"(platform: "/mobile") {
            news_id = "account_fund-account_fund_salary-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_cvu"(platform: "/mobile") {
            news_id = "account_fund-account_fund_cvu-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_approved_ted"(platform: "/mobile") {
            news_id = "account_fund-account_fund_approved_ted-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_approved_ml"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_ml-12345678"
            event_type = "shown"
        }

        "/notification/anses_payment_date"(platform: "/mobile") {
            news_id = "anses_payment_date-12345678-123"
            event_type = "shown"
        }

        "/notification/anses_paid_benefit"(platform: "/mobile") {
            news_id = "anses_paid_benefit-12345678-123"
            event_type = "shown"
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

        "/notification/campaigns_generic"(platform: "/") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            campaign_type="xp_cupones"
            campaign_data = "MLB1234"
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

        "/notification/campaigns_marketplace_discounts"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
        }

        "/notification/campaigns_checkout_recovery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLV515515631"
            variation_id="BLUE"
            experiment = false
        }

        "/notification/campaigns_acho_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLV515515631"
        }

        "/notification/campaigns_ticket_recovery"(platform: "/") {
            news_id = "12332323"
            event_type = "sent"
            deeplink ="meli://purchases"
            campaign_id = "mkt_campaign_ticket_recovery"
            test_notification = false
            sent_date = "20190129"
        }

        "/notification/campaigns_cho_cart_recovery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            items = "MLV515515631,MLV515515632,MLV515515633"
        }

        "/notification/campaigns_deal_alert"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLB1234"
        }

        "/notification/campaigns_recharge_recovery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://cellphone-recharge/"
            campaign_id = "mkt_campaign_co"
            test_notification = false
            sent_date = "20180508"
            batch_id = "MLB_PACK_20180508_2"
            experiment = false
        }

        "/notification/compliance_support_validations"(platform: "/mobile") {
            event_type = "shown"
        }

        "/notification/chargeback_payer_start_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_start_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }
        "/notification/chargeback_payer_notify_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_notify_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }
        "/notification/chargeback_payer_update_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_update_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }
        "/notification/chargeback_payer_ultimatum_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_ultimatum_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }
        "/notification/chargeback_payer_intensify_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_intensify_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }

        "/notification/credits_consumer_expired_n_loans_fourth_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_fourth_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_n_loans_second_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_second_noticee-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_n_loans_third_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_third_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_fortyfive_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_third_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_sixty_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_third_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_about_to_expire_n_loans_first_notice"(platform: "/mobile") {
            news_id = "credits-consumer_about_to_expire_n_loans_first_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_n_loans_first_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_first_notice-122359638-20180516"
            event_type = "dismiss"
        }

        "/notification/credits_consumer_about_to_expire_second_notice"(platform: "/mobile") {
            news_id = "credits-consumer_about_to_expire_second_notice-186785675-20180409"
            event_type = "shown"
            installment_id = 9876
            loan_id = 12345433
        }

        "/notification/credits_consumer_expired_fourth_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_fourth_notice-186785675-20180409"
            event_type = "shown"
            installment_id = 9876
            loan_id = 12345433
        }

        "/notification/credits_consumer_expired_second_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_second_notice-186785675-20180409"
            event_type = "shown"
            installment_id = 9876
            loan_id = 12345433
        }

        "/notification/credits_consumer_expired_third_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_third_notice-186785675-20180409"
            event_type = "shown"
            installment_id = 9876
            loan_id = 12345433
        }

        "/notification/credits_consumer_first_time_use_notice"(platform: "/mobile") {
            news_id = "credits-consumer_first_time_use_notice-186785675-20180409"
            event_type = "shown"
            installment_id = 9876
            loan_id = 12345433
        }

        "/notification/credits_consumer"(platform: "/mobile") {
            news_id = "credits-consumer_186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_closing_date_notice"(platform: "/mobile") {
            news_id = "credits-consumer_closing_date_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_expired_first_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_first_notice-1329452"
            event_type = "dismiss"
            installment_id= 717743
            loan_id= 107849
        }

        "/notification/credits_merchants_educational"(platform: "/mobile") {
            news_id = "credits-merchants_educational-9876"
            event_type = "shown"
            loan_id = 123
        }

        "/notification/cx_question_mp"(platform: "/mobile"){
            case_id= 12345678
            event_type = "sent"
        }

        "/notification/instore_discover_activities"(platform: "/mobile"){
            news_id = "instore-discover_activities-321953606"
            event_type = "sent"
        }

        "/notification/messages_new"(platform: "/mobile"){
            news_id = "instore-discover_activities-321953606"
            event_type = "sent"
        }

        "/notification/messages_quotes"(platform: "/mobile"){
            news_id = "instore-discover_activities-321953606"
            event_type = "sent"
        }

        "/notification/messages_flex"(platform: "/mobile"){
            news_id = "messages-flex-321953606"
            event_type = "sent"
        }

        "/notification/messages_driver_logistics"(platform: "/mobile"){
            news_id = "messages-driver_logistics-321953606"
            event_type = "sent"
        }

        "/notification/me_flex_optin_activation"(platform: "/mobile"){
            news_id = "me_flex-optin_activation-315571651"
            event_type = "sent"
        }

        "/notification/me_flex_optin_reminder"(platform: "/mobile"){
            news_id = "me_flex-optin_reminder-315571651"
            event_type = "sent"
        }

        "/notification/moderations_item_to_patch"(platform: "/mobile"){
            news_id = "moderations-item_to_patch-MLB1029865869-104215143"
            event_type = "discarded"
            item_id = "MLB1029865869"
        }

        "/notification/moderations_item_forbidden"(platform: "/mobile"){
            news_id = "moderations-item_forbidden-MLU452272153-104009955"
            event_type = "discarded"
            item_id = "MLU452272153"
        }

        "/notification/moderations_item_warning"(platform: "/mobile"){
            news_id = "moderations-item_warning-MLA711938299-104104695"
            event_type = "discarded"
            item_id = "MLA711938299"
        }

        "/notification/moderations_message_banned"(platform: "/mobile"){
            news_id = "moderations-message_banned-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "discarded"
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

        "/notification/listings"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
        }

        "/notification/campaigns_syi_freemium"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "received"
            deeplink ="meli://search?q=sony"
            campaign_id = "registered_between_1_and_2_weeks_ago_and_have_not_listed_in_core"
        }

        "/notification/campaigns_control_group"(platform: "/mobile") {
            news_id = "CIbDQhDb3hMYCQ==-5e22992d1b3518a"
            event_type = "discarded"
            campaign_id = "RECOVERY_CHECKOUT_MLB_60m-65m_20180516_CG"
            sent_date = "20180516"
            batch_id = "RECOVERY_CHECKOUT_MLB_60m-65m"
            deal_id = "RMK_MCO"
        }

        "/notification/questions_new"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "dismiss"
            deeplink = "meli://seller_question/12221"
            question_id = 1234
        }

        "/notification/questions_answered"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            deeplink ="meli://buyer_questions"
            question_id = 1234
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

        //Quotes
        "/notification/quotes_reject"(platform: "/mobile") {
            news_id = "quotes-reject-123"
            event_type = "open"
        }

        "/notification/quotes_new"(platform: "/mobile") {
            news_id = "quotes-reject-123"
            event_type = "open"
        }

        "/notification/quotes_cancel"(platform: "/mobile") {
            news_id = "quotes-reject-123"
            event_type = "open"
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
        "/notification/orders_deliver_confirmation"(platform: "/mobile") {
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
        "/notification/orders_buyer"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            type= "orders-buyer"
        }
        "/notification/orders_seller"(platform: "/mobile") {
            news_id = "orders-seller-1712072317"
            event_type = "action_open"
            type= "orders-seller"
        }
        "/notification/orders_ticket_payment_pending_extend_expiration_general_notice"(platform: "/mobile") {
            news_id = "orders-ticket_payment_pending_extend_expiration_general_notice-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            order_id = 1957429460
        }
        "/notification/orders_ticket_payment_pending_close_expiration_general_notice"(platform: "/mobile") {
            news_id = "orders-ticket_payment_pending_close_expiration_general_notice-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            order_id = 1957429460
        }
        "/notification/orders_ticket_payment_pending_reminder_general_notice"(platform: "/mobile") {
            news_id = "orders-ticket_payment_pending_reminder_general_notice-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            order_id = 1957429460
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
        "/notification/qrviral_onboard"(platform: "/mobile") {
            news_id = "qrviral-onboard-1234-186785675"
            event_type = "open"
        }
        "/notification/qrviral_onboard_recharge"(platform: "/mobile") {
            news_id = "qrviral-onboard_recharge-1234-186785675"
            event_type = "open"
            campaign_id = "qrviral-onboard_recharge"
        }
        "/notification/qrviral_reminder"(platform: "/mobile") {
            news_id = "qrviral-reminder-1234-186785675"
            event_type = "open"
        }
        "/notification/qrviral_extension"(platform: "/mobile") {
            news_id = "qrviral-extension-1234-186785675"
            event_type = "open"
        }
        "/notification/qrviral_reminder_mp"(platform: "/mobile") {
            news_id = "qrviral_reminder_mp-1234-186785675"
            event_type = "open"
        }
        "/notification/reputation"(platform: "/mobile") {
            newsgroup_id= "packages-seller-2000000031949978"
            event_type= "open"
            deeplink= "meli://messages/orders/1709786702"
            type_layout= "bullet_list"
            latest_news_type= "reputation"
            latest_news_id= "reputation-1692352012-88594841"
        }
        "/notification/reputation_free_shipping_activation"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }
        "/notification/reputation_medal_lost_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }
        "/notification/reservations_new"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_confirmed"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_buyer_confirm_delivery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_seller_confirm_delivery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_timeout_buyer_cancel"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_timeout_seller_cancel"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_seller_cancel"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }
        "/notification/reservations_buyer_confirm_delivery_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
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
        }

        "/notification/shipping_not_delivered_receiver"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }

        "/notification/shipping_soon_deliver"(platform: "/mobile"){
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

        "/notification/shipping_legacy_agency_withdrawal"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
            agency_to_agency = true
        }
        "/notification/shipping_legacy_not_delivered_receiver"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
        }

        "/notification/shipping_legacy_delayed_receiver"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
            delay_reason = "shipping_time"
        }
        "/notification/shipping_legacy_delivered"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
        }
        "/notification/shipping_legacy_shipped"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
        }
        "/notification/shipping_legacy_delayed_sender"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
        }
        "/notification/shipping_legacy_reminder_agency_withdrawal"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
            order_id = 123
        }
        "/notification/shipping_not_delivered_retained_sender"(platform: "/mobile"){
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
        }

        "/notification/mediations_complainant"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
        }

        "/notification/mediations_legacy_complainant"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
            order_id = 1234321
        }

        "/notification/mediations_respondent"(platform: "/mobile") {
            news_id = "mediations-respondent-1013715421-5b0d7ee426e063333fe0c582"
            event_type = "shown"
            notification_style = "c"
            claim_id = 1013715459
        }

        "/notification/questions_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            question_id = 1234
        }

        "/notification/questions_buyer"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            notification_style = "BigTextStyle"
        }

        "/notification/questions_seller"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            notification_style = "BigTextStyle"
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

        "/notification/payments_pending_remainder"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            item_id = "MLA1234"
            order_id = 1234321
        }

        "/notification/payments_pending_reminder"(platform: "/mobile") {
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
            item_id = "123"
            campaign_id = 1234
        }

        "/notification/campaigns_suggested_discounts_buyer"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
            item_id = "123"
            campaign_id = 1234
        }

        "/notification/campaigns_suggested_discounts_buyer"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            item_id = "123"
            campaign_id = 1234
        }

        "/notification/campaigns_download_app"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/campaigns_remarketing"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            campaign_id= "MLV515515631"
            test_notification= false
            sent_date= "20180508"
            batch_id = "MLB_PACK_20180508_2"
            hash="hash1"
            items_recommendations="MLB557314949,MLB613999012,MLB677993650,MLB695215973"
            items_history="MLB595398238,MLB649162181,MLB656729144"
        }

        "/notification/campaigns_remarketing_motors"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            campaign_id= "MLV515515631"
            test_notification= false
            sent_date= "20180508"
            batch_id = "MLB_PACK_20180508_2"
            item_id = "MLU457119874"
        }

        "/notification/packages_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            purchase_id= 1000000016589794
            pack_id= 2000000032080846
        }

        "/notification/loyalty"(platform: "/mobile") {
            news_id = "loyalty-137855615"
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

        "/notification/mshops_questions"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/mshops_orders"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/puis_agency_withdrawal"(platform: "/mobile") {
            news_id = "puis-agency_withdrawal-21409256437"
            event_type = "sent"
            pickup_id = 1234
        }

        "/notification/puis_confirmation"(platform: "/mobile") {
            news_id = "puis-confirmation-21409256437"
            event_type = "sent"
            pickup_id = 1234
        }

        "/notification/puis_picked_up"(platform: "/mobile") {
            news_id = "puis-picked_up-21409256437"
            event_type = "sent"
            pickup_id = 1234
        }

        "/notification/puis_reschedule"(platform: "/mobile") {
            news_id = "puis-reschedule-21409256437"
            event_type = "sent"
            pickup_id = 1234
        }

        "/notification/reservations_buyer_cancel"(platform: "/mobile") {
            news_id = "reservations-buyer_cancel-1004906131"
            event_type = "open"
            order_id = 1004906131
        }

        "/notification/returns_return_cancelled"(platform: "/mobile") {
            news_id = "returns-return_cancelled-1674717959-216070768"
            event_type = "arrived"
            order_id = 1703754979
        }

        "/notification/returns_return_expired"(platform: "/mobile") {
            news_id = "returns-return_expired-1674717959-216070768"
            event_type = "arrived"
            order_id = 1703754979
        }

        "/notification/returns_shipped_seller"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_init_return"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_init_return_buyer"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_refund_payment"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_reminder_printed"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_no_refund_payment"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_pickup_expired"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_reminder_not_printed"(platform: "/mobile") {
            news_id = "returns-shipped_seller-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/security_enrollment"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/security_phone_confirmation"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_event_feedback"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_account_validation"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_login_auth"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_device_authorization"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_recovery_canceled"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/security_login_code"(platform: "/mobile") {
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

        "/notification/fraud_delivery_cancellation_stop_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_cash_release_iv"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_iv_credentials"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_score_post_approval_last_chance_mp"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_score_post_approval_last_chance_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/health_check"(platform: "/mobile/android") {
            news_id = "COXwPxDrigQYBw==-1eb9ff37e01d45b0"
            original_news_id = "messages-new-1688986927-60f251a8ee0a4b748b6c1b59bc1e267a"
            event_type = "arrived"
        }

        "/notification"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "sent"
        }

        "/notification/account_fund_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_approved_ml"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_ml-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_salary"(platform: "/mobile") {
            news_id = "account_fund-account_fund_salary-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_cvu"(platform: "/mobile") {
            news_id = "account_fund-account_fund_cvu-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_approved_ted"(platform: "/mobile") {
            news_id = "account_fund-account_fund_approved_ted-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_approved_ml"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_ml-12345678"
            event_type = "shown"
        }

        "/notification/anses_payment_date"(platform: "/mobile") {
            news_id = "anses_payment_date-12345678-123"
            event_type = "shown"
        }

        "/notification/anses_paid_benefit"(platform: "/mobile") {
            news_id = "anses_paid_benefit-12345678-123"
            event_type = "shown"
        }

        "/notification/asset_management_warm_up"(platform: "/mobile") {
            news_id = "asset-management_warm_up-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_pending"(platform: "/mobile") {
            news_id = "asset-management_pending-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_investing"(platform: "/mobile") {
            news_id = "asset-management_investing-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_disabled"(platform: "/mobile") {
            news_id = "asset-management_disabled-12345678-123123"
            event_type = "shown"
        }

        "/notification/mpcampaigns_campaigns"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            campaign_id = "mkt_campaign_co"
            batch_id = "MLB_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }

        "/notification/mpcampaigns_mpcampaignsinfo"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            campaign_id = "mkt_campaign_co"
            deal_id = "MLA_MP_PRUEBA_G_20181211"
            sent_date = "20181211"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }

        "/notification/mpcampaigns_control_group"(platform: "/mobile") {
            news_id = "123"
            event_type = "discarded"
            campaign_id = "MLA_MP_PRUEBA_G_20181211_CG"
            deal_id = "MLA_MP_PRUEBA_G_20181211"
            sent_date = "20181211"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }

        "/notification/mpcampaigns_mpcampaignspromo"(platform: "/mobile") {
            news_id = "123"
            event_type = "discarded"
            campaign_id = "MLA_MP_PRUEBA_G_20181211_CG"
            deal_id = "MLA_MP_PRUEBA_G_20181211"
            sent_date = "20181211"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }

        "/notification/mpcampaigns_mpcampaignsinfo"(platform: "/mobile") {
            news_id = "123"
            event_type = "discarded"
            campaign_id = "MLA_MP_PRUEBA_G_20181211_CG"
            deal_id = "MLA_MP_PRUEBA_G_20181211"
            sent_date = "20181211"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
        }

        "/notification/mp_sponsor_campaign_start_campaign"(platform: "/mobile") {
            news_id = "mp_sponsor-campaign_start_campaign-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_sponsor_campaign_budget_trigger"(platform: "/mobile") {
            news_id = "mp_sponsor-campaign_budget_trigger-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_sponsor_campaign_day_trigger"(platform: "/mobile") {
            news_id = "mp_sponsor-campaign_day_trigger-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_seller_campaign_start_campaign"(platform: "/mobile") {
            news_id = "mp_seller-campaign_start_campaign-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_seller_campaign_end_campaign"(platform: "/mobile") {
            news_id = "mp_seller-campaign_end_campaignn-12345678-123123"
            event_type = "shown"
        }

        "/notification/credits_merchants_expired_first_notice"(platform: "/mobile") {
            news_id = "credits-merchants_expired_first_notice-9876"
            event_type = "shown"
            installment_id = 9876
        }

        "/notification/credits_merchants_expired_second_notice"(platform: "/mobile") {
            news_id = "credits-merchants_expired_second_notice-9876"
            event_type = "shown"
            installment_id = 9876
        }

        "/notification/credits_merchants_expired_third_notice"(platform: "/mobile") {
            news_id = "credits-merchants_expired_third_notice-9876"
            event_type = "shown"
            installment_id = 9876
        }

        "/notification/credits_merchants_about_to_expire_first_notice"(platform: "/mobile") {
            news_id = "credits-merchants_about_to_expire_first_notice-9876"
            event_type = "shown"
            installment_id = 9876
        }

        "/notification/credits_merchants_expired_no_charges"(platform: "/mobile") {
            news_id = "credits-merchants_expired_no_charges-9876"
            event_type = "shown"
            installment_id = 9876
        }
        "/notification/credits_merchants_to_expire"(platform: "/mobile") {
            news_id = "credits-merchants_to_expire-9876"
            event_type = "shown"
            installment_id = 9876
        }
        "/notification/credits_merchants_expired_near_to_fixed_charges"(platform: "/mobile") {
            news_id = "credits-merchants_expired_near_to_fixed_charges-9876"
            event_type = "shown"
        }
        "/notification/credits_merchants_expired_near_to_daily_charges"(platform: "/mobile") {
            news_id = "credits-merchants_expired_near_to_daily_charges-9876"
            event_type = "shown"
        }

        "/notification/credits_merchants_to_expire_standard"(platform: "/mobile") {
            news_id = "credits-merchants_to_expire_standard-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_to_expire_not_standard"(platform: "/mobile") {
            news_id = "credits-merchants_to_expire_not_standard-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_educational"(platform: "/mobile") {
            news_id = "credits-merchants_educational-9876"
            event_type = "shown"
            loan_id = 123
        }

        "/notification/compliance_support_validations"(platform: "/mobile") {
            event_type = "shown"
        }

        "/notification/fraud_cash_release_iv"(platform: "/mobile") {
            news_id = "fraud_cash_release_iv-12345678"
            event_type = "shown"
        }

        "/notification/health_check"(platform: "/mobile/android") {
            news_id = "COXwPxDrigQYBw==-1eb9ff37e01d45b0"
            original_news_id = "messages-new-1688986927-60f251a8ee0a4b748b6c1b59bc1e267a"
            event_type = "arrived"
        }

        "/notification/invite_gift"(platform: "/mobile"){
            news_id = "invite-gift-12345"
            event_type = "sent"
        }

        "/notification/messages_new"(platform: "/mobile") {
            news_id = "messages_new_123"
            event_type = "open"
        }

        "/notification/merchants_growth_mgm"(platform: "/mobile") {
            latest_news_type= "merchants_growth_mgm"
            latest_news_id= "merchants_growth_mgm-126635313"
            gift_reason_id = "test"
            event_type = "open"
        }

        "/notification/money_transfer_received"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/money_transfer_request"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/loyalty_milestone"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
        }

        "/notification/prepaid_card_shipped"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_waiting_for_withdrawal"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_delivered"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_delayed_p1"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_not_delivered"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_third_activation_reminder"(platform: "/mobile") {
            news_id = "prepaid_card-third_activation_reminder-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_second_activation_reminder"(platform: "/mobile") {
            news_id = "prepaid_card-second_activation_reminder-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_activation_reminder"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_activation_reminder-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_challenge_bolbradesco_reminder"(platform: "/mobile") {
            news_id = "prepaid_card-challenge_bolbradesco_reminder-43545334234"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_delivery"(platform: "/mobile") {
            news_id = "prepaid_card-delivery-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_invalid_pin"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_invalid_pin-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_approved_authorization"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_approved_authorization-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_red_link_bug"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_red_link_bug-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_approved_withdraw"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_approved_withdraw-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_canceled_authorization"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_canceled_authorization-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_canceled_withdraw"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_canceled_withdraw-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_authorization_by_invalid_amount_with_avaible_balance-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_authorization_by_invalid_amount-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_transaction_approved_authorization"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_approved_authorization-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_approved_withdraw"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_approved_withdraw-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_canceled_authorization"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_canceled_authorization-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_canceled_withdraw"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_canceled_withdraw-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_authorization_by_invalid_amount_with_avaible_balance-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_freeze"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_freeze-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_regulations_bacen_data_incomplete"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_regulations_bacen_data_incomplete-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_authorization_freeze"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_authorization_freeze-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_reissue_reminder"(platform: "/mobile") {
            news_id = "prepaid_card_reissue_reminder-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_soon_deliver"(platform: "/mobile") {
            news_id = "prepaid_card_soon_deliver-186785675"
            event_type = "auto_dismiss"
        }

        "/notification/point_shipping_ready_to_ship"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_shipped"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_not_delivered"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_waiting_for_withdrawal"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_delayed_p1"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_delayed_p4_p8"(platform: "/mobile") {
            news_id = "point_shipping-delayed_p4_p8-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/point_shipping_ready_to_ship_delayed"(platform: "/mobile") {
            news_id = "point_shipping-ready_to_ship_delayed-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/recurring_recharge_insufficient_balance_error"(platform: "/mobile") {
            news_id = "recurring_recharge_insufficient_balance_error-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/security_event_feedback"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/questions_new"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "dismiss"
            question_id = 1234
        }

        "/notification/seller_qr_payment_received"(platform: "/mobile") {
            news_id = "seller_qr_payment_received-186785675"
            event_type = "open"
        }

        "/notification/seller_integrations_new_payment"(platform: "/mobile") {
            news_id = "seller_integrations_new_payment-186785675"
            event_type = "open"
        }

        "/notification/seller_integrations_erase_name"(platform: "/mobile") {
            news_id = "seller_integrations_erase_name-186785675"
            event_type = "open"
        }

        "/notification/orders_new"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
        }

        "/notification/wallet_integrator_insufficient_amount"(platform: "/mobile") {
            news_id = "wallet_integrator-insufficient_amount-186785675"
            event_type = "open"
        }

        //Withdrawal
        "/notification/withdraw_approved_contingency"(platform: "/mobile") {
            news_id = "withdraw_approved_contingency-186785675"
            event_type = "open"
        }

        "/notification/uninstalls_checker"(platform: "/mobile"){
            execution_id= "160295629"
            advertising_id= "4066c329-d684-4196-8db4-3633148fc1a5"
            event_type = "sent"
        }

    }

    defaultBusiness = "mercadolibre"
    test("Web Notifications mercadolibre"){
        //Withdrawal
        "/notification/withdraw_approved_contingency"(platform: "/web") {
            news_id = "withdraw_approved_contingency-186785675"
            event_type = "open"
        }
        "/notification/withdraw_rejected_contingency"(platform: "/web") {
            news_id = "withdraw_rejected_contingency-186785675"
            event_type = "open"
        }

        //Phone Enrollment
        "/notification/security_phone_enrollment"(platform: "/web") {
            news_id = "security_phone_enrollment-186785675"
            event_type = "open"
        }

        //Merchant Services
        "/notification/mss_alliance"(platform: "/web") {
            news_id = "mss_alliance-186785675"
            event_type = "open"
        }
        "/notification/mss_gplay"(platform: "/web") {
            news_id = "mss_gplay-186785675"
            event_type = "open"
        }

        //Fiscal Data
        "/notification/fiscal_data_mp_business_registration"(platform: "/web") {
            news_id = "fiscal_data_mp_business_registration-186785675"
            event_type = "open"
        }

        //CX Question
        "/notification/cx_question_ml"(platform: "/web"){
            case_id= 12345678
            event_type = "sent"
        }

        "/notification/cx_question_mp"(platform: "/web"){
            case_id= 12345678
            event_type = "sent"
        }

        "/notification/openplatform_sellers_inhouse"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_wannabe"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p4"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p3"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p2"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p1"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/uninstalls_checker"(platform: "/mobile"){
            execution_id= "160295629"
            advertising_id= "4066c329-d684-4196-8db4-3633148fc1a5"
            event_type = "sent"
        }

        "/notification_center/openplatform_sellers_inhouse"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_sellers_inhouse"
            latest_news_id= "openplatform_sellers_inhouse-12345"
        }
        "/notification_center/openplatform_recommendations_wannabe"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_wannaber"
            latest_news_id= "openplatform_recommendations_wannabe-12345"
        }
        "/notification_center/openplatform_recommendations_p4"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p4"
            latest_news_id= "openplatform_recommendations_p4-12345"
        }
        "/notification_center/openplatform_recommendations_p3"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p3"
            latest_news_id= "openplatform_recommendations_p3-12345"
        }
        "/notification_center/openplatform_recommendations_p2"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p2"
            latest_news_id= "openplatform_recommendations_p2-12345"
        }
        "/notification_center/openplatform_recommendations_p1"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p1"
            latest_news_id= "openplatform_recommendations_p1-12345"
        }
    }

    defaultBusiness = "mercadopago"
    test("Web Notifications mercadopago"){
        //Withdrawal
        "/notification/withdraw_approved_contingency"(platform: "/web") {
            news_id = "withdraw_approved_contingency-186785675"
            event_type = "open"
        }
        "/notification/withdraw_rejected_contingency"(platform: "/web") {
            news_id = "withdraw_rejected_contingency-186785675"
            event_type = "open"
        }

        //Phone Enrollment
        "/notification/security_phone_enrollment"(platform: "/web") {
            news_id = "security_phone_enrollment-186785675"
            event_type = "open"
        }

        //Merchant Services
        "/notification/mss_alliance"(platform: "/web") {
            news_id = "mss_alliance-186785675"
            event_type = "open"
        }
        "/notification/mss_gplay"(platform: "/web") {
            news_id = "mss_gplay-186785675"
            event_type = "open"
        }

        //Fiscal Data
        "/notification/fiscal_data_mp_business_registration"(platform: "/web") {
            news_id = "fiscal_data_mp_business_registration-186785675"
            event_type = "open"
        }

        //CX Question
        "/notification/cx_question_mp"(platform: "/web"){
            case_id= 12345678
            event_type = "open"
        }

        "/notification/cx_question_ml"(platform: "/web"){
            case_id= 12345678
            event_type = "open"
        }

        "/notification/discount_central_missing_data"(platform: "/mobile") {
            news_id = "discount_central-missing_data-186785675"
            event_type = "open"
        }

        "/notification/cancellations_warning_seller_suspended"(platform: "/mobile") {
            event_type = "open"
        }

         "/notification/coverages_compensation_complainant"(platform: "/mobile") {
             event_type = "open"
             activity_id = "12345"
         }

        "/notification/openplatform_sellers_inhouse"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_wannabe"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p4"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p3"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p2"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/openplatform_recommendations_p1"(platform: "/mobile"){
            notification_id= "12345"
            event_type = "open"
        }

        "/notification/uninstalls_checker"(platform: "/mobile"){
            execution_id= "160295629"
            advertising_id= "4066c329-d684-4196-8db4-3633148fc1a5"
            event_type = "sent"
        }

        "/notification_center/openplatform_sellers_inhouse"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_sellers_inhouse"
            latest_news_id= "openplatform_sellers_inhouse-12345"
        }
        "/notification_center/openplatform_recommendations_wannabe"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_wannaber"
            latest_news_id= "openplatform_recommendations_wannabe-12345"
        }
        "/notification_center/openplatform_recommendations_p4"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p4"
            latest_news_id= "openplatform_recommendations_p4-12345"
        }
        "/notification_center/openplatform_recommendations_p3"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p3"
            latest_news_id= "openplatform_recommendations_p3-12345"
        }
        "/notification_center/openplatform_recommendations_p2"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p2"
            latest_news_id= "openplatform_recommendations_p2-12345"
        }
        "/notification_center/openplatform_recommendations_p1"(platform: "/mobile"){
            notification_id= "12345"
            latest_news_type= "openplatform_recommendations_p1"
            latest_news_id= "openplatform_recommendations_p1-12345"
        }
        "/notification_center/discount_central_missing_data"(platform: "/mobile"){
            latest_news_type= "discount_central_missing_data"
            latest_news_id= "discount_central_missing_data-12345"
        }
    }

}
