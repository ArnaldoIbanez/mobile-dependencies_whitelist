package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadolibre"

    test("Mobile Notifications"){

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
            experiment= false
        }
        "/notification_center/campaigns-acho_reminder"(platform: "/mobile"){
            campaign_id= "campaign1"
            newsgroup_id= "campaigns-acho_reminder-320010629"
            event_type= "open"
            deeplink= "meli://item?id=MLA645507294"
            type_layout= "standard"
            test_notification= false
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
            latest_news_type= "campaigns-acho_reminder"
            latest_news_id= "campaigns-acho_reminder-143816022-MLB1013046714"
            item_id= "MLV515515631"
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
        "/notification_center/packages-buyer"(platform: "/mobile"){}
        "/notification_center/packages-seller"(platform: "/mobile"){}
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

        "/notification/account_balance_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_approved_ml"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_ml-12345678"
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

        "/notification/campaigns_cart_recovery"(platform: "/mobile") {
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

        "/notification/instore_discover_activities"(platform: "/mobile"){
            news_id = "instore-discover_activities-321953606"
            event_type = "sent"
        }

        "/notification/messages_new"(platform: "/mobile"){
            news_id = "instore-discover_activities-321953606"
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

        "/notification/health_check"(platform: "/mobile/android") {
            news_id = "COXwPxDrigQYBw==-1eb9ff37e01d45b0"
            original_news_id = "messages-new-1688986927-60f251a8ee0a4b748b6c1b59bc1e267a"
            event_type = "arrived"
        }


    }

}
