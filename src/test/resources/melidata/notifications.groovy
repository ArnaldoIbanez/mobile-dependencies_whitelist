package src.test.resources.melidata

import com.ml.melidata.catalog.PropertyType

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
        "/notification_center/config"(platform: "/mobile", type: TrackType.View){}
        "/notification_center"(platform: "/mobile"){}
        "/notification_center/abort"(platform: "/mobile"){}
        "/notification_center/addresses-update"(platform: "/mobile") {
            latest_news_type= "addresses-update"
            latest_news_id= "addresses-update-126635313"
        }
        "/notification_center/abandoned_cart_buyer"(platform: "/mobile"){
            latest_news_type= "abandoned_cart_buyer"
            latest_news_id= "abandoned_cart_buyer-126635313"
        }
        "/notification_center/abandoned_cart_link_payer"(platform: "/mobile"){
            latest_news_type= "abandoned_cart_link_payer"
            latest_news_id= "abandoned_cart_link_payer-126635313"
        }
        "/notification_center/account_balance-cvu"(platform: "/mobile"){
            latest_news_type= "account_balance-cvu"
            latest_news_id= "account_balance-cvu-126635313"
        }
        "/notification_center/account_fund_approved_mlc_tc"(platform: "/mobile"){
            latest_news_type= "account_fund_approved_mlc_tc"
            latest_news_id= "account_fund_approved_mlc_tc-126635313"
        }
        "/notification_center/addresses_update"(platform: "/mobile"){
            latest_news_type= "addresses_update"
            latest_news_id= "addresses_update-126635313"
        }
        "/notification/mp_shipping_label"(platform: "/mobile"){
            news_id="mp_shipping-label-788142312"
            event_type="arrived"
            notification_type="deep_linking"
        }
        "/notification/mp_shipping_on_way"(platform:"/mobile"){
            news_id="mp_shipping-on_way-789827052"
            event_type="arrived"
            notification_type="deep_linking"
        }
        "/notification/mp_shipping_not_delivered"(platform: "/mobile"){
            news_id="mp_shipping-not_delivered-788142312"
            event_type="arrived"
            notification_type="deep_linking"
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
        "/notification_center/under_age_responsible_info"(platform: "/") {
            latest_news_type= "under_age_responsible_info"
            latest_news_id= "under_age-responsible_info-186785675"
        }
        "/notification_center/under_age_responsible_authorization_legacy"(platform: "/") {
            latest_news_type= "under_age_responsible_authorization_legacy"
            latest_news_id= "under_age_responsible_authorization_legacy-186785675"
        }
        "/notification_center/under_age_minor_rejected"(platform: "/") {
            latest_news_type= "under_age_minor_rejected"
            latest_news_id= "under_age_minor_rejected-186785675"
        }
        "/notification_center/under_age_minor_approved"(platform: "/") {
            latest_news_type= "under_age_minor_approved"
            latest_news_id= "under_age_minor_approved-186785675"
        }
        "/notification_center/under_age_responsible_info_ml"(platform: "/") {
            latest_news_type= "under_age_responsible_info"
            latest_news_id= "under_age-responsible_info-186785675"
        }
        "/notification_center/under_age_responsible_authorization_legacy_ml"(platform: "/") {
            latest_news_type= "under_age_responsible_authorization_legacy"
            latest_news_id= "under_age_responsible_authorization_legacy-186785675"
        }
        "/notification_center/under_age_minor_rejected_ml"(platform: "/") {
            latest_news_type= "under_age_minor_rejected"
            latest_news_id= "under_age_minor_rejected-186785675"
        }
        "/notification_center/under_age_minor_approved_ml"(platform: "/") {
            latest_news_type= "under_age_minor_approved"
            latest_news_id= "under_age_minor_approved-186785675"
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

        "/notification_center/institutional_generic"(platform: "/mobile"){
            latest_news_type= "institutional_generic"
            latest_news_id= "institutional_generic-143816022-MLB1013046714"
            campaign_id= "institutional_generic"
            newsgroup_id= "institutional_generic-MLU102_07_02_2017-56626993"
            status= "unread"
            type_layout= "picture"
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
        }
        "/notification_center/ingate_tokenization_verification_code"(platform: "/") {
            latest_news_type= "ingate_tokenization_verification_code"
            latest_news_id= "ingate_tokenization-verification_code-315571651"
        }

        "/notification_center/mpinstitutional_generic"(platform: "/mobile"){
            latest_news_type= "mpinstitutional_generic"
            latest_news_id= "mpinstitutional_generic-143816022-MLB1013046714"
            campaign_id= "mpinstitutional_generic"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            newsgroup_id= "mpinstitutional_generic-MLU102_07_02_2017-56626993"
            status= "unread"
            type_layout= "picture"
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
        }

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
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
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
            mantika_id="26491bbb-b9d2-4dac-8ce7-7f739ea74d7b"
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
        "/notification_center/credit_card_transaction_chout_purchase"(platform: "/") {
            latest_news_type= "credit_card_transaction_chout_purchase"
            latest_news_id= "credit_card-transaction_chout_purchase-12"
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
        "/notification_center/da_kyc_manual_review"(platform: "/mobile"){
            latest_news_type= "da_kyc_manual_review"
            latest_news_id= "da_kyc_manual_review-143816022-MLB1013046714"
        }
        "/notification_center/data_privacy_export"(platform: "/mobile"){
            latest_news_type= "data_privacy_export"
            latest_news_id= "data_privacy_export-143816022-MLB1013046714"
        }
        "/notification_center/dangerous_substances"(platform: "/mobile"){
            latest_news_type= "dangerous_substances"
            latest_news_id= "dangerous_substances-143816022-MLB1013046714"
        }
        "/notification_center/disbursement_wu_successful"(platform: "/mobile"){
            latest_news_type= "disbursement_wu_successful"
            latest_news_id= "disbursement_wu_successful-143816022-MLB1013046714"
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

        "/notification_center/fraud_delivery_cancellation"(platform: "/mobile"){
            latest_news_type= "fraud_delivery_cancellation"
            latest_news_id= "fraud_delivery_cancellation-143816022-MLB1013046714"
        }
        "/notification_center/fraud-cash_release_iv"(platform: "/mobile"){
            latest_news_type= "fraud-cash_release_iv"
            latest_news_id= "fraud-cash_release_iv-143816022-MLB1013046714"
        }
        "/notification_center/fraud-identity_validation_reminder"(platform: "/mobile"){
            latest_news_type= "fraud-identity_validation_reminder"
            latest_news_id= "fraud-identity_validation_reminder-143816022-MLB1013046714"
        }
        "/notification_center/fraud_delivery_cancellation_stop_mp"(platform: "/mobile") {
            latest_news_type= "fraud_delivery_cancellation_stop_mp"
            latest_news_id= "fraud_delivery_cancellation_stop_mp-143816022-MLB1013046714"
        }
        "/notification_center/fraud_poc_trust_vote_second_score"(platform: "/mobile") {
            latest_news_type= "fraud_poc_trust_vote_second_score"
            latest_news_id= "fraud_poc_trust_vote_second_score-143816022-MLB1013046714"
        }
        "/notification_center/fraud_delivery_cancellation_mp"(platform: "/mobile") {
            latest_news_type= "fraud_delivery_cancellation_mp"
            latest_news_id= "fraud_delivery_cancellation_mp-143816022-MLB1013046714"
        }
        "/notification_center/fbm_withdrawals_delayed"(platform: "/mobile") {
            latest_news_type= "fbm_withdrawals_delayed"
            latest_news_id= "fbm_withdrawals_delayed-143816022-MLB1013046714"
        }
        "/notification_center/fiscal_data_mp_business_registration"(platform: "/mobile") {
            latest_news_type= "fiscal_data_mp_business_registration"
            latest_news_id= "fiscal_data_mp_business_registration-143816022-MLB1013046714"
        }
        "/notification_center/gating_accreditation_approved"(platform: "/mobile") {
            latest_news_type= "gating_accreditation_approved"
            latest_news_id= "gating_accreditation_approved-143816022-MLB1013046714"
        }
        "/notification_center/gating_accreditation_rejected"(platform: "/mobile") {
            latest_news_type= "gating_accreditation_rejected"
            latest_news_id= "gating_accreditation_rejected-143816022-MLB1013046714"
        }
        "/notification_center/hub_transfer_new_scheduled"(platform: "/mobile") {
            latest_news_type= "hub_transfer_new_scheduled"
            latest_news_id= "hub_transfer_new_scheduled-143816022-MLB1013046714"
        }
        "/notification_center/kyc_handoff_user_notification_ml"(platform: "/mobile"){
            latest_news_id= "kyc_handoff_user_notification_ml-186785675-76283123"
            latest_news_type= "kyc_handoff_user_notification_ml"
        }
        "/notification_center/kyc_handoff_user_notification_mp"(platform: "/mobile"){
            latest_news_id= "kyc_handoff_user_notification_mp-186785675-76283123"
            latest_news_type= "kyc_handoff_user_notification_mp"
        }
        "/notification_center/kyc_user_notification_mp_web"(platform: "/mobile"){
            latest_news_id= "kyc_user_notification_mp_web-186785675-76283123"
            latest_news_type= "kyc_user_notification_mp_web"
        }
        "/notification_center/kyc_user_notification_mp"(platform: "/mobile"){
            latest_news_id= "kyc_user_notification_mp-186785675-76283123"
            latest_news_type= "kyc_user_notification_mp"
        }
        "/notification_center/kyc_user_notification_ml"(platform: "/mobile"){
            latest_news_id= "kyc_user_notification_ml-186785675-76283123"
            latest_news_type= "kyc_user_notification_ml"
        }
        "/notification_center/kyc_legal_entity_notification_mp"(platform: "/mobile"){
            latest_news_id= "kyc_legal_entity_notification_mp-186785675-76283123"
            latest_news_type= "kyc_legal_entity_notification_mp"
        }
        "/notification_center/kyc_afip_user_notification_mp"(platform: "/mobile"){
            latest_news_id= "kyc_afip_user_notification_mp-186785675-76283123"
            latest_news_type= "kyc_afip_user_notification_mp"
        }
        "/notification_center/kyc_bo_success"(platform: "/mobile"){
            latest_news_id= "kyc_bo_success-186785675-76283123"
            latest_news_type= "kyc_bo_success"
        }
        "/notification_center/killers_winner_item_recover"(platform: "/mobile"){
            latest_news_id= "killers_winner_item_recover-186785675-76283123"
            latest_news_type= "killers_winner_item_recover"
        }
        "/notification_center/killers_winner_item_new"(platform: "/mobile"){
            latest_news_id= "killers_winner_item_new-186785675-76283123"
            latest_news_type= "killers_winner_item_new"
        }
        "/notification_center/killers-winner_item_new"(platform: "/mobile"){
            latest_news_id= "killers-winner_item_new-186785675-76283123"
            latest_news_type= "killers-winner_item_new"
        }
        "/notification_center/killers-winner_item_lost"(platform: "/mobile") {
            latest_news_id= "killers-winner_item_lost-MLA123-19712790"
            latest_news_type= "killers_winner_item_lost"
        }
        "/notification_center/killers_losing_item_buybox"(platform: "/mobile"){
            latest_news_id= "killers_losing_item_buybox-186785675-76283123"
            latest_news_type= "killers_losing_item_buybox"
        }
        "/notification_center/killers_loser_item_new"(platform: "/mobile"){
            latest_news_id= "killers_loser_item_new-186785675-76283123"
            latest_news_type= "killers_loser_item_new"
        }
        "/notification_center/killers-loser_item_new"(platform: "/mobile"){
            latest_news_id= "killers-loser_item_new-186785675-76283123"
            latest_news_type= "killers-loser_item_new"
        }
        "/notification_center/killers-losing_item_buybox"(platform: "/mobile"){
            latest_news_id= "killers-losing_item_buybox-186785675-76283123"
            latest_news_type= "killers-losing_item_buybox"
        }
        "/notification_center/killers-winner_item_recover"(platform: "/mobile"){
            latest_news_id= "killers-winner_item_recover-186785675-76283123"
            latest_news_type= "killers-winner_item_recover"
        }
        "/notification_center/kyc_continue_from_desktop_person_notification_ml"(platform: "/mobile"){
            latest_news_id= "kyc_continue_from_desktop_person_notification_ml-186785675-76283123"
            latest_news_type= "kyc_continue_from_desktop_person_notification_ml"
        }
        "/notification_center/kyc_legal_entity_notification_ml"(platform: "/mobile"){
            latest_news_id= "kyc_legal_entity_notification_ml-186785675-76283123"
            latest_news_type= "kyc_legal_entity_notification_ml"
        }
        "/notification_center/kyc_user_notification_ml_web"(platform: "/mobile"){
            latest_news_id= "kyc_user_notification_ml_web-186785675-76283123"
            latest_news_type= "kyc_user_notification_ml_web"
        }
        "/notification_center/kyc_afip_user_notification_ml"(platform: "/mobile"){
            latest_news_id= "kyc_afip_user_notification_ml-186785675-76283123"
            latest_news_type= "kyc_afip_user_notification_ml"
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

        "/notification_center/payments_release"(platform: "/mobile") {
            notification_id = "12345"
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
        "/notification_center/me_flex_rehunting_generic"(platform: "/mobile"){
            latest_news_type= "me_flex_rehunting_generic"
            latest_news_id= "me_flex_rehunting_generic-143816022-MLB1013046714"
        }
        "/notification_center/me_flex_rehunting_address"(platform: "/mobile"){
            latest_news_type= "me_flex_rehunting_address"
            latest_news_id= "me_flex_rehunting_address-143816022-MLB1013046714"
        }
        "/notification_center/me_flex_rehunting_reputation"(platform: "/mobile"){
            latest_news_type= "me_flex-rehunting_reputation"
            latest_news_id= "me_flex-rehunting_reputation-315571651"
        }
        "/notification_center/me_flex_hunting_generic"(platform: "/mobile"){
            latest_news_type= "me_flex_hunting_generic"
            latest_news_id= "me_flex_hunting_generic-143816022-MLB1013046714"
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
        "/notification_center/mediations_v2"(platform: "/", type: TrackType.Event) {
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
        "/notification_center/purchase_invoice"(platform: "/mobile"){
            newsgroup_id= "purchases-invoice-1000000016305386"
            status= "read"
            event_type= "open"
            deeplink= "https://myaccount.mercadolibre.com.mx/purchases/1000000016305386/detail"
            type_layout= "standard"
            latest_news_type= "purchase_invoice"
            latest_news_id= "purchase_invoice-1000000016305386"
        }
        "/notification_center/point_pos_closed"(platform: "/mobile") {
            latest_news_type= "point_pos_closed"
            latest_news_id= "point_pos_closed-1000000016305386"
        }
        "/notification_center/point_pix"(platform: "/mobile") {
            latest_news_type= "point_pix"
            latest_news_id= "point_pix-1000000016305386"
        }
        "/notification_center/point_pos_close_soon"(platform: "/mobile") {
            latest_news_type= "point_pix"
            latest_news_id= "point_pix-1000000016305386"
        }
        "/notification_center/partners_pin_ml"(platform: "/mobile") {
            latest_news_type= "partners_pin_ml"
            latest_news_id= "partners_pin_ml-1000000016305386"
            partner= "123"
        }
        "/notification_center/partners_pin_mp"(platform: "/mobile") {
            latest_news_type= "partners_pin_mp"
            latest_news_id= "partners_pin_mp-1000000016305386"
            partner= "123"
        }

        "/notification_center/point_voucher_sodexo"(platform: "/mobile") {
            latest_news_type= "point_voucher_sodexo"
            latest_news_id= "point_voucher_sodexo-1000000016305386"
        }
        "/notification_center/point_voucher_sodexo"(platform: "/mobile") {
            latest_news_type= "point_voucher_sodexo"
            latest_news_id= "point_voucher_sodexo-1000000016305386"
        }

        "/notification_center/pix_transfer_mo_rejected"(platform: "/mobile") {
            latest_news_type= "pix_transfer_mo_rejected"
            latest_news_id= "pix_transfer_mo_rejected-1000000016305386"
        }
        "/notification_center/pix_transfer_mo_manual_review"(platform: "/mobile") {
            latest_news_type= "pix_transfer_mo_manual_review"
            latest_news_id= "pix_transfer_mo_manual_review-1000000016305386"
        }
        "/notification_center/pix_transfer_mi_approved"(platform: "/mobile") {
            latest_news_type= "pix_transfer_mi_approved"
            latest_news_id= "pix_transfer_mi_approved-1000000016305386"
        }
        "/notification_center/pix_transfer_mo_approved"(platform: "/mobile") {
            latest_news_type= "pix_transfer_mo_approved"
            latest_news_id= "pix_transfer_mo_approved-1000000016305386"
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
        "/notification_center/security_enroll_screenlock_app"(platform: "/mobile") {
            latest_news_type= "security_enroll_screenlock_app"
            latest_news_id= "security_enroll_screenlock_app-1000000016305386"
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
        "/notification_center/quotes_answer_send"(platform: "/mobile") {
            latest_news_type= "quotes_answer_send"
            latest_news_id= "quotes_answer_send-123-123"
        }
        "/notification_center/quotes_answer_pending"(platform: "/mobile") {
            latest_news_type= "quotes_answer_pending"
            latest_news_id= "quotes_answer_pending-123-123"
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
        "/notification_center/account_fund-cvu"(platform: "/mobile"){
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
        "/notification_center/account_fund_active_disabled_clabe"(platform: "/mobile"){
            newsgroup_id= "account_fund_active_disabled_clabe-12345678"
            latest_news_id= "account_fund_active_disabled_clabe-12345678"
            latest_news_type= "account_fund_active_disabled_clabe"
            status= "unread"
        }
        "/notification_center/account_fund_iv_cvu_spb"(platform: "/mobile"){
            newsgroup_id= "account_fund_iv_cvu_spb-12345678"
            latest_news_id= "account_fund_iv_cvu_spb-12345678"
            latest_news_type= "account_fund_iv_cvu_spb"
            status= "unread"
        }
        "/notification_center/account_fund_ticket"(platform: "/mobile"){
            newsgroup_id= "account_fund_ticket-12345678"
            latest_news_id= "account_fund_ticket-12345678"
            latest_news_type= "account_fund_ticket"
            status= "unread"
        }
        "/notification_center/asset_management_warm_up"(platform: "/mobile"){
            newsgroup_id= "asset_management-warm_up-186785675-76283123"
            latest_news_id= "asset_management-warm_up-186785675-76283123"
            latest_news_type= "asset_management_warm_up"
            status= "read"
        }
        "/notification_center/asset_management_missing_docs"(platform: "/mobile"){
            newsgroup_id= "asset_management-missing_docs-186785675-76283123"
            latest_news_id= "asset_management-missing_docs-186785675-76283123"
            latest_news_type= "missing_docs"
            status= "read"
        }
        "/notification_center/asset_management_investing"(platform: "/mobile"){
            newsgroup_id= "asset_management-investing-186785675-76283123"
            latest_news_id= "asset_management-investing-186785675-76283123"
            latest_news_type= "asset_management_investing"
            status= "read"
        }
        "/notification_center/asset_management_failed"(platform: "/mobile"){
            newsgroup_id= "asset_management-failed-186785675-76283123"
            latest_news_id= "asset_management-failed-186785675-76283123"
            latest_news_type= "asset_management_failed"
            status= "read"
        }
        "/notification_center/asset_management_rejected"(platform: "/mobile"){
            newsgroup_id= "asset_management-rejected-186785675-76283123"
            latest_news_id= "asset_management-rejected-186785675-76283123"
            latest_news_type= "asset_management_rejected"
            status= "read"
        }
        "/notification_center/asset_management_underage_approved"(platform: "/mobile"){
            newsgroup_id= "asset_management-underage_approved-186785675-76283123"
            latest_news_id= "asset_management-underage_approved-186785675-76283123"
            latest_news_type= "asset_management_underage_approved"
            status= "read"
        }
        "/notification_center/asset_management_underage_rejected"(platform: "/mobile"){
            newsgroup_id= "asset_management-underage_rejected-186785675-76283123"
            latest_news_id= "asset_management-underage_rejected186785675-76283123"
            latest_news_type= "asset_management_underage_rejected"
            status= "read"
        }
        "/notification_center/asset_management_underage_request"(platform: "/mobile"){
            newsgroup_id= "asset_management-underage_request-186785675-76283123"
            latest_news_id= "asset_management-underage_request-186785675-76283123"
            latest_news_type= "asset_management_underage_request"
            status= "read"
        }
        "/notification_center/alwayson_bsas_a"(platform: "/") {
            latest_news_type= "alwayson_bsas_a"
            latest_news_id= "alwayson_bsas_a-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_bsas_h"(platform: "/") {
            latest_news_type= "alwayson_bsas_h"
            latest_news_id= "alwayson_bsas_h-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_caba_a"(platform: "/") {
            latest_news_type= "alwayson_caba_a"
            latest_news_id= "alwayson_caba_a-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_caba_b"(platform: "/") {
            latest_news_type= "alwayson_caba_b"
            latest_news_id= "alwayson_caba_b-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_caba_c"(platform: "/") {
            latest_news_type= "alwayson_caba_c"
            latest_news_id= "alwayson_caba_c-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_caba_h"(platform: "/") {
            latest_news_type= "alwayson_caba_h"
            latest_news_id= "alwayson_caba_h-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_iva_a"(platform: "/") {
            latest_news_type= "alwayson_iva_a"
            latest_news_id= "alwayson_iva_a-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_iva_b"(platform: "/") {
            latest_news_type= "alwayson_iva_b"
            latest_news_id= "alwayson_iva_b-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_iva_h"(platform: "/") {
            latest_news_type= "alwayson_iva_h"
            latest_news_id= "alwayson_iva_h-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_sirtac_a"(platform: "/") {
            latest_news_type= "alwayson_sirtac_a"
            latest_news_id= "alwayson_sirtac_a-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_sirtac_b"(platform: "/") {
            latest_news_type= "alwayson_sirtac_b"
            latest_news_id= "alwayson_sirtac_b-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_sirtac_c"(platform: "/") {
            latest_news_type= "alwayson_sirtac_c"
            latest_news_id= "alwayson_sirtac_c-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_sirtac_h"(platform: "/") {
            latest_news_type= "alwayson_sirtac_h"
            latest_news_id= "alwayson_sirtac_h-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }
        "/notification_center/billing_mpoff"(platform: "/mobile"){
            newsgroup_id= "billing-mpoff-186785675-76283123"
            latest_news_id= "billing-mpoff-186785675-76283123"
            latest_news_type= "billing_mpoff"
            status= "read"
        }
        "/notification_center/billing_iva_isr_mp"(platform: "/") {
            latest_news_type= "billing_iva_isr_mp"
            latest_news_id= "billing-iva_isr_mp-186785675-20200522"
        }
        "/notification_center/billing_newusertaxfile"(platform: "/") {
            latest_news_type= "billing_newusertaxfile"
            latest_news_id= "billing-newusertaxfile-186785675-20200522"
        }
        "/notification_center/buybox_forced_item"(platform: "/mobile"){
            newsgroup_id= "buybox_forced_item-186785675-76283123"
            latest_news_id= "buybox_forced_item-186785675-76283123"
            latest_news_type= "buybox_forced_item"
            status= "read"
        }
        "/notification_center/buybox_forewarning"(platform: "/mobile"){
            newsgroup_id= "buybox_forewarning-186785675-76283123"
            latest_news_id= "buybox_forewarning-186785675-76283123"
            latest_news_type= "buybox_forewarning"
            status= "read"
        }
        "/notification_center/buybox_losing_item"(platform: "/mobile"){
            newsgroup_id= "buybox_losing_item-186785675-76283123"
            latest_news_id= "buybox_losing_item-186785675-76283123"
            latest_news_type= "buybox_losing_item"
            status= "read"
        }
        "/notification_center/buybox_losing_many"(platform: "/mobile"){
            newsgroup_id= "buybox_losing_many-186785675-76283123"
            latest_news_id= "buybox_losing_many-186785675-76283123"
            latest_news_type= "buybox_losing_many"
            status= "read"
        }
        "/notification_center/billing_iva_ganancias_reactive"(platform: "/mobile"){
            latest_news_type= "billing_iva_ganancias_reactive"
            latest_news_id= "billing_iva_ganancias_reactive-143816022-MLB1013046714"
        }
        "/notification_center/billing_newtaxhabituality"(platform: "/mobile"){
            latest_news_type= "billing_newtaxhabituality"
            latest_news_id= "billing_newtaxhabituality-143816022-MLB1013046714"
        }
        "/notification_center/billing_newtax"(platform: "/mobile"){
            latest_news_type= "billing_newtax"
            latest_news_id= "billing_newtax-143816022-MLB1013046714"
        }
        "/notification_center/billing_responsable_inscripto_reminder"(platform: "/mobile"){
            latest_news_type= "billing_responsable_inscripto_reminder"
            latest_news_id= "billing_responsable_inscripto_reminder-143816022-MLB1013046714"
        }
        "/notification_center/billing_iva_isr_meli"(platform: "/mobile"){
            latest_news_type= "billing_iva_isr_meli"
            latest_news_id= "billing_iva_isr_meli-143816022-MLB1013046714"
        }
        "/notification_center/chargeback_payer_high_agree_repayment_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_high_agree_repayment_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_high_agree_repayment_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_high_agree_repayment_mp"
            case_id = "158213000000"
            status= "read"
        }
        "/notification_center/chargeback_payer_high_n_chargebacks_agree_repayment_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_high_n_chargebacks_agree_repayment_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_high_n_chargebacks_agree_repayment_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_high_n_chargebacks_agree_repayment_mp"
            case_id = "158213000000"
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
            installment_id = 123
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
        "/notification_center/credits_merchants_em_to_expire_01"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-em_to_expire_01-186785675-76283123"
            latest_news_id= "credits_merchants-em_to_expire_01-186785675-76283123"
            latest_news_type= "credits_merchants_em_to_expire_01"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_em_expired_no_charges_today"(platform: "/mobile"){
            newsgroup_id= "credits_merchants_em_expired_no_charges_today-186785675-76283123"
            latest_news_id= "credits_merchants_em_expired_no_charges_today-186785675-76283123"
            latest_news_type= "credits_merchants_em_expired_no_charges_today"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_em_expired_daily_charges_01"(platform: "/mobile"){
            newsgroup_id= "credits_merchants_em_expired_daily_charges_01-186785675-76283123"
            latest_news_id= "credits_merchants_em_expired_daily_charges_01-186785675-76283123"
            latest_news_type= "credits_merchants_em_expired_daily_charges_01"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_em_expired_daily_charges_04"(platform: "/mobile"){
            newsgroup_id= "credits_merchants_em_expired_daily_charges_04-186785675-76283123"
            latest_news_id= "credits_merchants_em_expired_daily_charges_04-186785675-76283123"
            latest_news_type= "credits_merchants_em_expired_daily_charges_04"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_em_expired_daily_charges_07"(platform: "/mobile"){
            newsgroup_id= "credits_merchants_em_expired_daily_charges_07-186785675-76283123"
            latest_news_id= "credits_merchants_em_expired_daily_charges_07-186785675-76283123"
            latest_news_type= "credits_merchants_em_expired_daily_charges_07"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_em_expired_daily_charges_10"(platform: "/mobile"){
            newsgroup_id= "credits_merchants_em_expired_daily_charges_10-186785675-76283123"
            latest_news_id= "credits_merchants_em_expired_daily_charges_10-186785675-76283123"
            latest_news_type= "credits_merchants_em_expired_daily_charges_10"
            status= "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_std_expired_daily_charges_110"(platform: "/mobile"){
            newsgroup_id= "credits_merchants_std_expired_daily_charges_110-186785675-76283123"
            latest_news_id= "credits_merchants_std_expired_daily_charges_110-186785675-76283123"
            latest_news_type= "credits_merchants_std_expired_daily_charges_110"
            status= "read"
            loan_id = 123
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
        "/notification_center/fraud_remedies_trust_vote_ml"(platform: "/mobile"){
            newsgroup_id= "fraud_remedies_trust_vote_ml-186785675-76283123"
            latest_news_id= "fraud_remedies_trust_vote_ml-186785675-76283123"
            latest_news_type= "fraud_remedies_trust_vote_ml"
            status= "read"
        }
        "/notification_center/flows_default"(platform: "/mobile"){
            initiative_code= "123"
            latest_news_id= "flows_default-186785675-76283123"
            latest_news_type= "flows_default"
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
        "/notification_center/merchants_growth_resellers"(platform: "/mobile"){
            newsgroup_id= "merchants_growth-resellers-186785675-76283123"
            latest_news_id= "merchants_growth-resellers-186785675-76283123"
            latest_news_type= "merchants_growth_resellers"
            status= "read"
        }
        "/notification_center/merchants_growth_fdv"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_fdv-186785675-76283123"
            latest_news_id= "merchants_growth_fdv-186785675-76283123"
            latest_news_type= "merchants_growth_fdv"
            status= "read"
        }
        "/notification_center/merchants_growth_paper_roll"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_paper_roll-186785675-76283123"
            latest_news_id= "merchants_growth_paper_roll-186785675-76283123"
            latest_news_type= "merchants_growth_paper_roll"
            status= "read"
        }
        "/notification_center/merchants_growth_resellers_smart_launch"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_resellers_smart_launch-186785675-76283123"
            latest_news_id= "merchants_growth_resellers_smart_launch-186785675-76283123"
            latest_news_type= "merchants_growth_resellers_smart_launch"
            status= "read"
        }
        "/notification_center/merchants_growth_sameday"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_sameday-186785675-76283123"
            latest_news_id= "merchants_growth_sameday-186785675-76283123"
            latest_news_type= "merchants_growth_sameday"
            status= "read"
        }
        "/notification_center/merchants_growth_reverse_screening"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_reverse_screening-186785675-76283123"
            latest_news_id= "merchants_growth_reverse_screening-186785675-76283123"
            latest_news_type= "merchants_growth_reverse_screening"
            status= "read"
        }
        "/notification_center/merchants_growth_pricing_point"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_pricing_point-186785675-76283123"
            latest_news_id= "merchants_growth_pricing_point-186785675-76283123"
            latest_news_type= "merchants_growth_pricing_point"
            status= "read"
        }
        "/notification_center/money-transfer_request"(platform: "/mobile"){
            newsgroup_id= "money-transfer_request-186785675-76283123"
            latest_news_id= "money-transfer_request-186785675-76283123"
            latest_news_type= "money-transfer_request"
            status= "read"
        }
        "/notification_center/money_advance"(platform: "/mobile"){
            latest_news_id= "money_advance-186785675-76283123"
            latest_news_type= "money_advance"
        }
        "/notification_center/flammables_notification"(platform: "/mobile"){
            latest_news_id= "flammables_notification-186785675-76283123"
            latest_news_type= "flammables_notification"
        }
        "/notification_center/growth_tooling_mgm_kyc_booster"(platform: "/mobile"){
            latest_news_id= "growth_tooling_mgm_kyc_booster-186785675-76283123"
            latest_news_type= "growth_tooling_mgm_kyc_booster"
        }
        "/notification_center/growth_tooling_mgm_kyc_guest"(platform: "/mobile"){
            latest_news_id= "growth_tooling_mgm_kyc_guest-186785675-76283123"
            latest_news_type= "growth_tooling_mgm_kyc_guest"
        }
        "/notification_center/money_split_started"(platform: "/mobile") {
            latest_news_id= "money_split_started-186785675-76283123"
            latest_news_type= "money_split_started"
        }
        "/notification_center/money_split_rejected_push"(platform: "/mobile") {
            latest_news_id= "money_split_rejected_push-186785675-76283123"
            latest_news_type= "money_split_rejected_push"
        }
        "/notification_center/money_split_rejected"(platform: "/mobile") {
            latest_news_id= "money_split_rejected-186785675-76283123"
            latest_news_type= "money_split_rejected"
        }
        "/notification_center/money_split_paid_push"(platform: "/mobile") {
            latest_news_id= "money_split_paid_push-186785675-76283123"
            latest_news_type= "money_split_paid_push"
        }
        "/notification_center/money_split_paid"(platform: "/mobile") {
            latest_news_id= "money_split_paid-186785675-76283123"
            latest_news_type= "money_split_paid"
        }
        "/notification_center/money_request_started"(platform: "/mobile") {
            latest_news_id= "money_request_started-186785675-76283123"
            latest_news_type= "money_request_started"
        }
        "/notification_center/money_request_rejected_push"(platform: "/mobile") {
            latest_news_id= "money_request_rejected_push-186785675-76283123"
            latest_news_type= "money_request_rejected_push"
        }
        "/notification_center/money_request_rejected"(platform: "/mobile") {
            latest_news_id= "money_request_rejected-186785675-76283123"
            latest_news_type= "money_request_rejected"
        }
        "/notification_center/money_request_finished"(platform: "/mobile") {
            latest_news_id= "money_request_finished-186785675-76283123"
            latest_news_type= "money_splmoney_request_finishedit_paid"
        }
        "/notification_center/money_out_cashout"(platform: "/mobile") {
            latest_news_id= "money_out_cashout-186785675-76283123"
            latest_news_type= "money_out_cashout"
        }
        "/notification_center/money_transfer_received"(platform: "/mobile") {
            latest_news_id= "money_transfer_received-186785675-76283123"
            latest_news_type= "money_transfer_received"
        }
        "/notification_center/money_transfer_sender"(platform: "/mobile") {
            latest_news_id= "money-transfer_sender-186785675-1122-993783123"
            latest_news_type= "money_transfer_sender"
        }
        "/notification_center/card_transactions"(platform: "/mobile") {
            latest_news_id= "card_transactions-186785675-76283123"
            latest_news_type= "card_transactions"
        }
        "/notification_center/hub_transfer_new_approved"(platform: "/mobile") {
            latest_news_id= "hub_transfer_new_approved-186785675-76283123"
            latest_news_type= "hub_transfer_new_approved"
        }
        "/notification_center/hub_transfer_manualreview"(platform: "/mobile") {
            latest_news_id= "hub_transfer_manualreview-186785675-76283123"
            latest_news_type= "hub_transfer_manualreview"
        }
        "/notification_center/hub_transfer_new_rejected"(platform: "/mobile") {
            latest_news_id= "hub_transfer_new_rejected-186785675-76283123"
            latest_news_type= "hub_transfer_new_rejected"
        }
        "/notification_center/hub_transfer_rejected"(platform: "/mobile") {
            latest_news_id= "hub_transfer_rejected-186785675-76283123"
            latest_news_type= "hub_transfer_rejected"
        }
        "/notification_center/hub_transfer_screening_one"(platform: "/mobile") {
            latest_news_id= "hub_transfer_screening_one-186785675-76283123"
            latest_news_type= "hub_transfer_screening_one"
        }
        "/notification_center/package-buyer"(platform: "/mobile"){
            latest_news_type= "shipping-rts_in_packing_list"
            latest_news_id= "shipping-rts_in_packing_list-21409256437"
            shipment_id = 21409256437
        }
        "/notification_center/hub_transfer_screening_two"(platform: "/mobile") {
            latest_news_id= "hub_transfer_screening_two-186785675-76283123"
            latest_news_type= "hub_transfer_screening_two"
        }
        "/notification_center/money_split_finished"(platform: "/mobile") {
            latest_news_id= "money_split_finished-186785675-76283123"
            latest_news_type= "money_split_finished"
        }
        "/notification_center/money_request_paid_push"(platform: "/mobile") {
            latest_news_id= "money_request_paid_push-186785675-76283123"
            latest_news_type= "money_request_paid_push"
        }
        "/notification_center/money_request_paid"(platform: "/mobile") {
            latest_news_id= "money_request_paid-186785675-76283123"
            latest_news_type= "money_request_paid"
        }
        "/notification_center/moneyin_cashin_accredited"(platform: "/mobile") {
            latest_news_id= "moneyin_cashin_accredited-186785675-76283123"
            latest_news_type= "moneyin_cashin_accredited"
        }
        "/notification_center/moneyin_cashin_exceeded_cap"(platform: "/mobile") {
            latest_news_id= "moneyin_cashin_exceeded_cap-186785675-76283123"
            latest_news_type= "moneyin_cashin_exceeded_cap"
        }
        "/notification_center/mp_dx_credentials"(platform: "/mobile") {
            latest_news_id= "mp_dx_credentials-186785675-76283123"
            latest_news_type= "mp_dx_credentials"
        }
        "/notification_center/mp_dx_credentials_seller_received_request"(platform: "/mobile") {
            latest_news_id= "mp_dx_credentials_seller_received_request-186785675-76283123"
            latest_news_type= "mp_dx_credentials_seller_received_request"
        }
        "/notification_center/mp_seller_campaign_resume_campaign"(platform: "/mobile") {
            latest_news_id= "mp_seller_campaign_resume_campaign-186785675-76283123"
            latest_news_type= "mp_seller_campaign_resume_campaign"
        }
        "/notification_center/money_out_cashoutmlb_rejected_manualreview"(platform: "/mobile") {
            latest_news_id= "money_out_cashoutmlb_rejected_manualreview-186785675-76283123"
            latest_news_type= "money_out_cashoutmlb_rejected_manualreview"
        }
        "/notification_center/money_out_cashoutmlb_rejected"(platform: "/mobile") {
            latest_news_id= "money_out_cashoutmlb_rejected-186785675-76283123"
            latest_news_type= "money_out_cashoutmlb_rejected"
        }
        "/notification_center/money_out_cashoutmlb_pending"(platform: "/mobile") {
            latest_news_id= "money_out_cashoutmlb_pending-186785675-76283123"
            latest_news_type= "money_out_cashoutmlb_pending"
        }
        "/notification_center/money_out_cashoutmlb_approved"(platform: "/mobile") {
            latest_news_id= "money_out_cashoutmlb_approved-186785675-76283123"
            latest_news_type= "money_out_cashoutmlb_approved"
        }
        "/notification_center/money_out_cashout_withdrawn"(platform: "/mobile") {
            latest_news_id= "money_out_cashout_withdrawn-186785675-76283123"
            latest_news_type= "money_out_cashout_withdrawn"
        }
        "/notification_center/money_out_cashout_reversed"(platform: "/mobile") {
            latest_news_id= "money_out_cashout_reversed-186785675-76283123"
            latest_news_type= "money_out_cashout_reversed"
        }
        "/notification_center/money_in_cashin_exceeded_cap"(platform: "/mobile") {
            latest_news_id= "money_in_cashin_exceeded_cap-186785675-76283123"
            latest_news_type= "money_in_cashin_exceeded_cap"
        }
        "/notification_center/money_request_started"(platform: "/mobile") {
            latest_news_id= "money_request_started-186785675-76283123"
            latest_news_type= "money_request_started"
        }
        "/notification_center/money_request_rejected_push"(platform: "/mobile") {
            latest_news_id= "money_request_rejected_push-186785675-76283123"
            latest_news_type= "money_request_rejected_push"
        }
        "/notification_center/money_request_rejected"(platform: "/mobile") {
            latest_news_id= "money_request_rejected-186785675-76283123"
            latest_news_type= "money_request_rejected"
        }
        "/notification_center/money_request_finished"(platform: "/mobile") {
            latest_news_id= "money_request_finished-186785675-76283123"
            latest_news_type= "money_request_finished"
        }
        "/notification_center/money_out_cashout"(platform: "/mobile") {
            latest_news_id= "money_out_cashout-186785675-76283123"
            latest_news_type= "money_out_cashout"
        }
        "/notification_center/multiplayer_money_request"(platform: "/mobile"){
            newsgroup_id= "multiplayer-money_request-186785675-76283123"
            latest_news_id= "multiplayer-money_request-186785675-76283123"
            latest_news_type= "multiplayer-money_request"
            status= "read"
        }
        "/notification_center/multiplayer_ml_money_request"(platform: "/mobile"){
            newsgroup_id= "multiplayer_ml_money_request-186785675-76283123"
            latest_news_id= "multiplayer_ml_money_request-186785675-76283123"
            latest_news_type= "multiplayer_ml_money_request"
            status= "read"
        }
        "/notification_center/multiplayer_regulation"(platform: "/mobile"){
            newsgroup_id= "multiplayer_regulation-186785675-76283123"
            latest_news_id= "multiplayer_regulation-186785675-76283123"
            latest_news_type= "multiplayer_regulation"
            status= "read"
        }
        "/notification_center/multiplayer_regulation_validated"(platform: "/mobile"){
            newsgroup_id= "multiplayer_regulation_validated-186785675-76283123"
            latest_news_id= "multiplayer_regulation_validated-186785675-76283123"
            latest_news_type= "multiplayer_regulation_validated"
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
            campaign_data = "MLB1234"
        }
        "/notification_center/subscription_expiring_notice"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_expiring_notice"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_option = "Citibanamex"
        }
        "/notification_center/subscription_payment_congrats"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_congrats"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_type = 'successful_payment'
            female_gender = true
        }
        "/notification_center/subscription_payment_error"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_error"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            error_type = "card_code"
            female_gender = true
        }
        "/notification_center/subscription_payment_instructions"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_instructions"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_option = "Citibanamex"
            female_gender = true
        }
        "/notification_center/subscription_payment_pending"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_pending"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            female_gender = true
            payment_type = 'successful_payment'
        }

        "/notification_center/subscription_disney_activation_on"(platform: "/mobile") {
            newsgroup_id = "subscription_disney_activation_on-186785675"
            latest_news_id= "subscription_disney_activation_on-186785675"
            latest_news_type= "subscription_disney_activation_on"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification_center/subscription_disney_activation_off"(platform: "/mobile") {
            newsgroup_id = "subscription_disney_activation_off-186785675"
            latest_news_id= "subscription_disney_activation_off-186785675"
            latest_news_type= "subscription_disney_activation_off"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification_center/subscription_disney_activation_free_trial"(platform: "/mobile") {
            newsgroup_id = "subscription_disney_activation_free_trial-186785675"
            latest_news_id= "subscription_disney_activation_free_trial-186785675"
            latest_news_type= "subscription_disney_activation_free_trial"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification_center/subscription_free_content_level_drop"(platform: "/mobile") {
            newsgroup_id = "subscription_free_content_level_drop-186785675"
            latest_news_id= "subscription_free_content_level_drop-186785675"
            latest_news_type= "subscription_free_content_level_drop"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification_center/subscription_free_content_previous"(platform: "/mobile") {
            newsgroup_id = "subscription_free_content_previous-186785675"
            latest_news_id= "subscription_free_content_previous-186785675"
            latest_news_type= "subscription_free_content_previous"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification/subscription_free_content_grace_period"(platform: "/mobile") {
            news_id = "subscription_free_content_grace_period-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            type = "activate_before"
        }
        "/notification/subscription_free_content_level_drop"(platform: "/mobile") {
            news_id = "subscription_free_content_level_drop-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification/subscription_free_content_previous"(platform: "/mobile") {
            news_id = "subscription_free_content_previous-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification/subscription_free_content_payment_pending"(platform: "/mobile") {
            news_id = "subscription_free_content_payment_pending-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            type = "activate_before"
        }
        "/notification/subscription_free_content_last_day_to_pay"(platform: "/mobile") {
            news_id = "subscription_free_content_last_day_to_pay-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            type = "activate_before"
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
        "/notification_center/card_first_use_incentive"(platform: "/mobile") {
            latest_news_type= "card_first_use_incentive"
            latest_news_id= "card_first_use_incentive-143816022-MLB1013046714"
        }
        "/notification_center/mp_sponsor_campaign_start_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_-ampaign_start_campaign-143816022-MLB1013046714"
            campaign_id= "080677f9877e454f917ca55ea1bbbb24"
            end_date= "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_sponsor_campaign_create_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_campaign_create_campaign-143816022-MLB1013046714"
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_sponsor_campaign_web_eligible_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_campaign_web_eligible_campaign-143816022-MLB1013046714"
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_shipping_label"(platform: "/mobile") {
            latest_news_type= "mp_shipping_label"
            latest_news_id= "mp_shipping_label-143816022-MLB1013046714"
        }
        "/notification_center/mp_shipping_not_delivered"(platform: "/mobile") {
            latest_news_type= "mp_shipping_not_delivered"
            latest_news_id= "mp_shipping_not_delivered-143816022-MLB1013046714"
        }
        "/notification_center/mp_shipping_on_way"(platform: "/mobile") {
            latest_news_type= "mp_shipping_on_way"
            latest_news_id= "mp_shipping_on_way-143816022-MLB1013046714"
        }
        "/notification_center/mp_sponsor_campaign_budget_trigger"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor-campaign_budget_trigger-143816022-MLB1013046714"
            campaign_id= "080677f9877e454f917ca55ea1bbbb24"
            end_date= "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_sponsor_campaign_create_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_campaign_create_campaign-143816022-MLB1013046714"
            campaign_id= "080677f9877e454f917ca55ea1bbbb24"
            end_date= "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_sponsor_campaign_web_eligible_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_campaign_web_eligible_campaign-143816022-MLB1013046714"
            campaign_id= "080677f9877e454f917ca55ea1bbbb24"
            end_date= "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_sponsor_campaign_day_trigger"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor-campaign_day_trigger-143816022-MLB1013046714"
            campaign_id= "080677f9877e454f917ca55ea1bbbb24"
            end_date= "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_seller_campaign_start_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_seller-campaign_start_campaign-143816022-MLB1013046714"
        }
        "/notification_center/mp_seller_campaign_end_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_seller-campaign_end_campaign-143816022-MLB1013046714"
        }
        "/notification_center/mp_seller_moderation"(platform: "/mobile") {
            latest_news_type= "mp_seller_moderation"
            latest_news_id= "mp_seller_moderation-143816022-MLB1013046714"
        }
        "/notification_center/mp_seller_campaign_moderation"(platform: "/mobile") {
            latest_news_type= "mp_seller_campaign_moderation"
            latest_news_id= "mp_seller_campaign_moderation-143816022-MLB1013046714"
        }
        "/notification_center/moneyin_debin_approved"(platform: "/") {
            latest_news_type= "moneyin_debin_approved"
            latest_news_id= "moneyin_debin-approved-12345678"
        }
        "/notification_center/moneyin_debin_in_process"(platform: "/") {
            latest_news_type= "moneyin_debin_process"
            latest_news_id= "moneyin_debin-process-12345678"
        }
        "/notification_center/moneyin_debin_rejected"(platform: "/") {
            latest_news_type= "moneyin_debin_rejected"
            latest_news_id= "moneyin_debin-rejected-12345678"
        }
        "/notification_center/mss_gplay"(platform: "/mobile") {
            latest_news_type= "mss_gplay"
            latest_news_id= "mss_gplay-143816022-MLB1013046714"
        }
        "/notification_center/no_maquinables_items_sellers"(platform: "/mobile") {
            latest_news_type= "no_maquinables_items_sellers"
            latest_news_id= "no_maquinables_items_sellers-143816022-MLB1013046714"
        }
        "/notification_center/not_shippable_by_dimensions_items_sellers"(platform: "/mobile") {
            latest_news_type= "not_shippable_by_dimensions_items_sellers"
            latest_news_id= "not_shippable_by_dimensions_items_sellers-143816022-MLB1013046714"
        }
        "/notification_center/prepaid_card_challenge_bolbradesco_reminder"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_challenge_bolbradesco_reminder-186785675-76283123"
            latest_news_id= "prepaid_card_challenge_bolbradesco_reminder-186785675-76283123"
            latest_news_type= "prepaid_card_challenge_bolbradesco_reminder"
        }
        "/notification_center/card_request_challenge"(platform: "/mobile"){
            newsgroup_id= "card_request_challenge-pending-186785675-76283123"
            latest_news_id= "card_request_challenge-pending-186785675-76283123"
            latest_news_type= "card_request_challenge-pending"
            status= "read"
        }
        "/notification_center/card_correios_strike"(platform: "/mobile"){
            newsgroup_id= "card_correios_strike-delayed-186785675-76283123"
            latest_news_id= "card_correios_strike-delayed-186785675-76283123"
            latest_news_type= "card_correios_strike-delayed"
            status= "read"
        }
        "/notification_center/card_flow_incentive"(platform: "/mobile"){
            newsgroup_id= "card_flow_incentive-186785675-76283123"
            latest_news_id= "card_flow_incentive-186785675-76283123"
            latest_news_type= "card_flow_incentive"
            status= "read"
        }
        "/notification_center/card_flow_incentive_prepaid_acquisition_first"(platform: "/mobile"){
            newsgroup_id= "card_flow_incentive_prepaid_acquisition_first-186785675-76283123"
            latest_news_id= "card_flow_incentive_prepaid_acquisition_first-186785675-76283123"
            latest_news_type= "card_flow_incentive_prepaid_acquisition_first"
            status= "read"
        }
        "/notification_center/card_flow_incentive_prepaid_acquisition_second"(platform: "/mobile"){
            newsgroup_id= "card_flow_incentive_prepaid_acquisition_second-186785675-76283123"
            latest_news_id= "card_flow_incentive_prepaid_acquisition_second-186785675-76283123"
            latest_news_type= "card_flow_incentive_prepaid_acquisition_second"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed_nfc_acquisition"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed_nfc_acquisition-186785675-76283123"
            latest_news_id= "card_kyc_data_completed_nfc_acquisition-186785675-76283123"
            latest_news_type= "card_kyc_data_completed_nfc_acquisition"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed_prepaid_acquisition_first"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed_prepaid_acquisition_first-186785675-76283123"
            latest_news_id= "card_kyc_data_completed_prepaid_acquisition_first-186785675-76283123"
            latest_news_type= "card_kyc_data_completed_prepaid_acquisition_first"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed_prepaid_acquisition_second"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed_prepaid_acquisition_second-186785675-76283123"
            latest_news_id= "card_kyc_data_completed_prepaid_acquisition_second-186785675-76283123"
            latest_news_type= "card_kyc_data_completed_prepaid_acquisition_second"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed_prepaid_acquisition_third"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed_prepaid_acquisition_third-186785675-76283123"
            latest_news_id= "card_kyc_data_completed_prepaid_acquisition_third-186785675-76283123"
            latest_news_type= "card_kyc_data_completed_prepaid_acquisition_third"
            status= "read"
        }
        "/notification_center/card_nip"(platform: "/mobile"){
            newsgroup_id= "card_nip-186785675-76283123"
            latest_news_id= "card_nip-186785675-76283123"
            latest_news_type= "card_nip"
            status= "read"
        }
        "/notification_center/card_reminders_virtual_digital_services"(platform: "/mobile"){
            newsgroup_id= "card_reminders_virtual_digital_services-186785675-76283123"
            latest_news_id= "card_reminders_virtual_digital_services-186785675-76283123"
            latest_news_type= "card_reminders_virtual_digital_services"
            status= "read"
        }
        "/notification_center/card_subscription"(platform: "/mobile"){
            newsgroup_id= "card_subscription-186785675-76283123"
            latest_news_id= "card_subscription-186785675-76283123"
            latest_news_type= "card_subscription"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_fifteenth_day"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_fifteenth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_fifteenth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_fifteenth_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_fifth_day"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_fifth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_fifth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_fifth_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_twentyfifth_day"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_twentyfifth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_twentyfifth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_twentyfifth_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_zero_day"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_zero_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_zero_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_zero_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_zero_day_known_person"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_zero_day_known_person-186785675-76283123"
            latest_news_id= "card_unlock_incentive_zero_day_known_person-186785675-76283123"
            latest_news_type= "card_unlock_incentive_zero_day_known_person"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_zero_day_owner"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_zero_day_owner-186785675-76283123"
            latest_news_id= "card_unlock_incentive_zero_day_owner-186785675-76283123"
            latest_news_type= "card_unlock_incentive_zero_day_owner"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_zero_day_point"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_zero_day_point-186785675-76283123"
            latest_news_id= "card_unlock_incentive_zero_day_point-186785675-76283123"
            latest_news_type= "card_unlock_incentive_zero_day_point"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_zero_day_somewhere"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_zero_day_somewhere-186785675-76283123"
            latest_news_id= "card_unlock_incentive_zero_day_somewhere-186785675-76283123"
            latest_news_type= "card_unlock_incentive_zero_day_somewhere"
            status= "read"
        }
        "/notification_center/card_freeze"(platform: "/mobile"){
            newsgroup_id= "card_freeze-186785675-76283123"
            latest_news_id= "card_freeze-186785675-76283123"
            latest_news_type= "card_freeze"
            status= "read"
        }
        "/notification_center/card_limit"(platform: "/mobile"){
            newsgroup_id= "card_limit-186785675-76283123"
            latest_news_id= "card_limit-186785675-76283123"
            latest_news_type= "card_limit"
            status= "read"
        }
        "/notification_center/card_pin"(platform: "/mobile"){
            newsgroup_id= "card_pin-186785675-76283123"
            latest_news_id= "card_pin-186785675-76283123"
            latest_news_type= "card_pin"
            status= "read"
        }
        "/notification_center/card_reminders"(platform: "/mobile"){
            newsgroup_id= "card_reminders-186785675-76283123"
            latest_news_id= "card_reminders-186785675-76283123"
            latest_news_type= "card_reminders"
            status= "read"
        }
        "/notification_center/card_request_challenge"(platform: "/mobile"){
            newsgroup_id= "card_request_challenge-186785675-76283123"
            latest_news_id= "card_request_challenge-186785675-76283123"
            latest_news_type= "card_request_challenge"
            status= "read"
        }
        "/notification_center/card_wallet"(platform: "/mobile"){
            newsgroup_id= "card_wallet-186785675-76283123"
            latest_news_id= "card_wallet-186785675-76283123"
            latest_news_type= "card_wallet"
            status= "read"
        }
        "/notification_center/card_offering_physical_card"(platform: "/mobile"){
            newsgroup_id= "card_offering_physical_card-186785675-76283123"
            latest_news_id= "card_offering_physical_card-186785675-76283123"
            latest_news_type= "card_offering_physical_card"
            status= "read"
        }
        "/notification_center/card_offering_transaction_generic_opt_in_ppd_to_hybrid"(platform: "/mobile"){
            newsgroup_id= "card_offering_transaction_generic_opt_in_ppd_to_hybrid-186785675-76283123"
            latest_news_id= "card_offering_transaction_generic_opt_in_ppd_to_hybrid-186785675-76283123"
            latest_news_type= "card_offering_transaction_generic_opt_in_ppd_to_hybrid"
            status= "read"
        }
        "/notification_center/card_offering_transaction_opt_in_ppd_to_hybrid"(platform: "/mobile"){
            newsgroup_id= "card_offering_transaction_opt_in_ppd_to_hybrid-186785675-76283123"
            latest_news_id= "card_offering_transaction_opt_in_ppd_to_hybrid-186785675-76283123"
            latest_news_type= "card_offering_transaction_opt_in_ppd_to_hybrid"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-virtual-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-virtual-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-virtual"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-unlock-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-unlock-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-unlock"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-physical_acquisition-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-physical_acquisition-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-physical_acquisition"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-prepaid_acquisition_first-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-prepaid_acquisition_first-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-prepaid_acquisition_first"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-prepaid_acquisition_third-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-prepaid_acquisition_third-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-prepaid_acquisition_third"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-prepaid_acquisition_second-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-prepaid_acquisition_second-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-prepaid_acquisition_second"
            status= "read"
        }
        "/notification_center/card_unlock_incentive"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive-zero_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive-zero_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive-zero_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_second_day"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_second_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_second_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_second_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_fifth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_fifth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_fifth_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_fifteenth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_fifteenth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_fifteenth_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_twentyfifth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_twentyfifth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_twentyfifth_day"
            status= "read"
        }
        "/notification_center/cashoutmlb_rejected_manualreview"(platform: "/mobile"){
            newsgroup_id= "cashoutmlb_rejected_manualreview-186785675-76283123"
            latest_news_id= "cashoutmlb_rejected_manualreview-186785675-76283123"
            latest_news_type= "cashoutmlb_rejected_manualreview"
            status= "read"
        }
        "/notification_center/chargeback_payer_high_agree_repayment_ml"(platform: "/mobile"){
            newsgroup_id= "chargeback_payer_high_agree_repayment_ml-186785675-76283123"
            latest_news_id= "chargeback_payer_high_agree_repayment_ml-186785675-76283123"
            latest_news_type= "chargeback_payer_high_agree_repayment_ml"
            status= "read"
            case_id= "123"
        }
        "/notification_center/claim"(platform: "/mobile"){
            newsgroup_id= "claim_186785675-76283123"
            latest_news_id= "claim_186785675-76283123"
            latest_news_type= "claim_186785675-76283123"
            status= "read"
        }
        "/notification_center/fraud_kyc_validation"(platform: "/mobile") {
            latest_news_type= "fraud_kyc_validation"
            latest_news_id= "fraud-kyc_validation-186785675"
        }
        "/notification_center/prepaid_card"(platform: "/mobile"){
            newsgroup_id= "prepaid_card-delayed_p1-186785675-76283123"
            latest_news_id= "prepaid_card-delayed_p1-186785675-76283123"
            latest_news_type= "prepaid_card_delayed_p1"
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
        "/notification_center/transaction_rejected_withdraw_by_invalid_amount_for_fee"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_withdraw_by_invalid_amount_for_fee-GN92YzFJJQk15V1xg4YfpcCNQMcySlp5LxXAVyS3IPx9sCMYy8Zf5ty4fQNOt3VI"
            latest_news_id= "transaction_rejected_withdraw_by_invalid_amount_for_fee-GN92YzFJJQk15V1xg4YfpcCNQMcySlp5LxXAVyS3IPx9sCMYy8Zf5ty4fQNOt3VI"
            latest_news_type= "transaction_rejected_withdraw_by_invalid_amount_for_fee"
            status= "read"
        }
        "/notification_center/transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee-GN92YzFJJQk15V1xg4YfpcCNQMcySlp5LxXAVyS3IPx9sCMYy8Zf5ty4fQNOt3VI"
            latest_news_id= "transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee-GN92YzFJJQk15V1xg4YfpcCNQMcySlp5LxXAVyS3IPx9sCMYy8Zf5ty4fQNOt3VI"
            latest_news_type= "transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee"
            status= "read"
        }
        "/notification_center/point_qr_login_new"(platform: "/mobile") {
            latest_news_type= "point_qr_login_new"
            latest_news_id= "point-qr_login_new-a34rb3"
        }
        "/notification_center/point_fill_in"(platform: "/mobile") {
            latest_news_type= "point_fill_in"
            latest_news_id= "point-fill_in-a34rb3"
        }
        "/notification_center/promotions_msg"(platform: "/mobile") {
            latest_news_type= "promotions_msg"
            latest_news_id= "promotions-msg-a34rb3"
        }
        "/notification_center/promotions_volume"(platform: "/mobile") {
            latest_news_type= "promotions_volume"
            latest_news_id= "promotions-volume-a34rb3"
        }
        "/notification_center/protected_purchase_order_reminder_purchase_protection"(platform: "/mobile") {
            latest_news_type= "protected_purchase_order_reminder_purchase_protection"
            latest_news_id= "protected_purchase-order_reminder_purchase_protection-a34rb3"
        }
        "/notification_center/transaction_rejected_authorization_by_invalid_amount"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_authorization_by_invalid_amount-186785675-76283123"
            latest_news_id= "transaction_rejected_authorization_by_invalid_amount-186785675-76283123"
            latest_news_type= "transaction_rejected_authorization_by_invalid_amount"
            status= "read"
        }
        "/notification_center/transaction_rejected_authorization_contactless_freeze_decorator"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_authorization_contactless_freeze_decorator-186785675-76283123"
            latest_news_id= "transaction_rejected_authorization_contactless_freeze_decorator-186785675-76283123"
            latest_news_type= "transaction_rejected_authorization_contactless_freeze_decorator"
            status= "read"
        }
        "/notification_center/transfer_online_approved"(platform: "/mobile"){
            newsgroup_id= "transfer_online_approved-186785675-76283123"
            latest_news_id= "transfer_online_approved-186785675-76283123"
            latest_news_type= "transfer_online_approved"
            status= "read"
        }
        "/notification_center/transfer_online_rejected"(platform: "/mobile"){
            newsgroup_id= "transfer_online_rejected-186785675-76283123"
            latest_news_id= "transfer_online_rejected-186785675-76283123"
            latest_news_type= "transfer_online_rejected"
            status= "read"
        }
        "/notification_center/transfer_online_scheduled"(platform: "/mobile"){
            newsgroup_id= "transfer_online_scheduled-186785675-76283123"
            latest_news_id= "transfer_online_scheduled-186785675-76283123"
            latest_news_type= "transfer_online_scheduled"
            status= "read"
        }
        "/notification_center/transaction_rejected_withdraw_by_invalid_amount"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_withdraw_by_invalid_amount-186785675-76283123"
            latest_news_id= "transaction_rejected_withdraw_by_invalid_amount-186785675-76283123"
            latest_news_type= "transaction_rejected_withdraw_by_invalid_amount"
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
        "/notification_center/point_qr_login_new"(platform: "/mobile") {
            latest_news_type= "point_qr_login_new"
            latest_news_id= "point-qr_login_new-a34rb3"
        }
        "/notification_center/point_fill_in"(platform: "/mobile") {
            latest_news_type= "point_fill_in"
            latest_news_id= "point-fill_in-a34rb3"
        }
        "/notification_center/promotions_msg"(platform: "/mobile") {
            latest_news_type= "promotions_msg"
            latest_news_id= "promotions-msg-a34rb3"
        }
        "/notification_center/promotions_volume"(platform: "/mobile") {
            latest_news_type= "promotions_volume"
            latest_news_id= "promotions-volume-a34rb3"
        }
        "/notification_center/protected_purchase_order_reminder_purchase_protection"(platform: "/mobile") {
            latest_news_type= "protected_purchase_order_reminder_purchase_protection"
            latest_news_id= "protected_purchase-order_reminder_purchase_protection-a34rb3"
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
        "/notification_center/wallet_connect_binding_error"(platform: "/") {
            latest_news_type= "wallet_connect_binding_error"
            latest_news_id= "wallet_connect-binding_error-84060496"
        }
        "/notification_center/wallet_connect_binding_with_card_and_cash"(platform: "/") {
            latest_news_type= "wallet_connect_binding_with_card_and_cash"
            latest_news_id= "wallet_connect-binding_with_card_and_cash-84060496"
        }
        "/notification_center/wallet_connect_binding_with_cash"(platform: "/") {
            latest_news_type= "wallet_connect_binding_with_cash"
            latest_news_id= "wallet_connect-binding_with_cash-84060496"
        }
        "/notification_center/wallet_connect_rejected_payment"(platform: "/") {
            latest_news_type= "wallet_connect_rejected_payment"
            latest_news_id= "wallet_connect-rejected_payment-84060496"
        }
        "/notification_center/wallet_integrator_insufficient_amount"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator-insufficient_amount-186785675-76283123"
            latest_news_id= "wallet_integrator-insufficient_amount-186785675-76283123"
            latest_news_type= "wallet_integrator_insufficient_amount"
            status= "read"
        }
        "/notification_center/wallet_integrator_payment_success"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator-payment_success-186785675-76283123"
            latest_news_id= "wallet_integrator-payment_success-186785675-76283123"
            latest_news_type= "wallet_integrator_payment_success"
            status= "read"
        }
        "/notification_center/wallet_integrator_insufficient_funds"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator-insufficient_funds-186785675-76283123"
            latest_news_id= "wallet_integrator-insufficient_funds-186785675-76283123"
            latest_news_type= "wallet_integrator_insufficient_funds"
            status= "read"
        }
        "/notification_center/wallet_integrator_personal_loan"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator_personal_loan-186785675-76283123"
            latest_news_id= "wallet_integrator_personal_loan-186785675-76283123"
            latest_news_type= "wallet_integrator_personal_loan"
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
            latest_news_type= "withdraw_rejected_contingency"
            latest_news_id= "withdraw_rejected_contingency-143816022-MLB1013046714"
        }
        "/notification_center/withdraw_approved"(platform: "/mobile") {
            latest_news_type= "withdraw_approved"
            latest_news_id= "withdraw_approved-143816022-MLB1013046714"
        }
        "/notification_center/withdraw_rejected"(platform: "/mobile") {
            latest_news_type= "withdraw_rejected"
            latest_news_id= "withdraw_rejected-143816022-MLB1013046714"
        }

        "/notification_center/wrong_address_driver_action"(platform: "/mobile") {
            latest_news_type= "shipping-wrong_address_driver_action"
            latest_news_id= "shipping-wrong_address_driver_action-186785675-123123-20191120"
            shipment_id = 21409256437
        }
        "/notification_center/whatsapp-enrollment"(platform: "/mobile") {
            latest_news_type= "whatsapp-enrollment"
            latest_news_id= "whatsapp-enrollment-186785675-123123-20191120"
        }
        "/notification_center/payroll_portability"(platform: "/mobile"){
            latest_news_type = "payroll_portability"
            latest_news_id = "payroll_portability-143816022-MLB1013046714"
            portability_id = "123"
        }
        "/notification_center/payroll_portability_request"(platform: "/mobile"){
            latest_news_type = "payroll_portability_request"
            latest_news_id = "payroll_portability_request-143816022-MLB1013046714"
            portability_request_id = "123"
        }
        "/notification_center/payroll_kyc_approved"(platform: "/mobile"){
            latest_news_type = "payroll_kyc_approved"
            latest_news_id = "payroll_kyc_approved-143816022-MLB1013046714"
        }

        "/notification_center/seller_journey_congrats"(platform: "/mobile"){
            step_id= 123
            latest_news_type= "seller_journey_congrats"
            latest_news_id= "seller_journey_congrats-143816022-MLB1013046714"
        }
        "/notification_center/seller_journey_keep_it_up"(platform: "/mobile"){
            step_id= 123
            latest_news_type= "seller_journey_keep_it_up"
            latest_news_id= "seller_journey_keep_it_up-143816022-MLB1013046714"
        }
        "/notification_center/seller_journey_work_harder"(platform: "/mobile"){
            step_id= 123
            latest_news_type= "seller_journey_work_harder"
            latest_news_id= "seller_journey_work_harder-143816022-MLB1013046714"
        }
        "/notification_center/seller_journey_do_something"(platform: "/mobile"){
            step_id= 123
            latest_news_type= "seller_journey_work_harder"
            latest_news_id= "seller_journey_work_harder-143816022-MLB1013046714"
        }

        "/notification_center/single_player_utility_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_utility_success_mp"
            latest_news_id= "single_player_utility_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_utility_refused_am"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_utility_refused_am"
            latest_news_id= "single_player_utility_refused_am-143816022-MLB1013046714"
        }
        "/notification_center/single_player_utility_refused_cc"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_utility_refused_cc"
            latest_news_id= "single_player_utility_refused_cc-143816022-MLB1013046714"
        }
        "/notification_center/single_player_utility_fail_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_utility_fail_mp"
            latest_news_id= "single_player_utility_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_transport_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_transport_success_mp"
            latest_news_id= "single_player_transport_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_transport_fail_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_transport_fail_mp"
            latest_news_id= "single_player_transport_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_prepaid_toll_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_prepaid_toll_success_mp"
            latest_news_id= "single_player_prepaid_toll_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_prepaid_toll_fail_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_prepaid_toll_fail_mp"
            latest_news_id= "single_player_prepaid_toll_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_antenna_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_antenna_success_mp"
            latest_news_id= "single_player_antenna_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_antenna_fail_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_antenna_fail_mp"
            latest_news_id= "single_player_antenna_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_balance_expiration_transport_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_balance_expiration_transport_mp"
            latest_news_id= "single_player_balance_expiration_transport_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_expired_debt_utility_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_expired_debt_utility_mp"
            latest_news_id= "single_player_expired_debt_utility_mp-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/single_player_generic_balance_expiration"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_generic_balance_expiration"
            latest_news_id= "single_player_generic_balance_expiration-143816022-MLB1013046714"
        }
        "/notification_center/single_player_new_debt_utility_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_new_debt_utility_mp"
            latest_news_id= "single_player_new_debt_utility_mp-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/single_player_payment_reminder_new_grouped_debt"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payment_reminder_new_grouped_debt"
            latest_news_id= "single_player_payment_reminder_new_grouped_debt-143816022-MLB1013046714"
            debt_id=123
        }

        "/notification_center/single_player_payment_reminder_new_solo_debt"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payment_reminder_new_solo_debt"
            latest_news_id= "single_player_payment_reminder_new_solo_debt-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/single_player_payg_unlock_device_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_unlock_device_mp"
            latest_news_id= "single_player_payg_unlock_device_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_new_debt_without_block_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_new_debt_without_block_mp"
            latest_news_id= "single_player_payg_new_debt_without_block_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_create_device_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_create_device_success_mp"
            latest_news_id= "single_player_payg_create_device_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_create_device_fail_mp"(platform: "/mobile") {
            latest_news_type= "single_player_payg_create_device_fail_mp"
            latest_news_id= "single_player-payg_create_device_fail_mp-315571651-5678-1479249799770"
        }
        "/notification_center/single_player_payg_blocked_device_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_blocked_device_mp"
            latest_news_id= "single_player_payg_blocked_device_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_cashback_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_cashback_mp"
            latest_news_id= "single_player_payg_cashback_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_change_device_number_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_change_device_number_success_mp"
            latest_news_id= "single_player_payg_change_device_number_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_change_device_number_fail_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_change_device_number_fail_mp"
            latest_news_id= "single_player_payg_change_device_number_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility"
            latest_news_id= "single_player_scheduled_payment_utility-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_grouped_rejected"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_grouped_rejected"
            latest_news_id= "single_player_scheduled_payment_utility_grouped_rejected-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_grouped_reminder"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_grouped_reminder"
            latest_news_id= "single_player_scheduled_payment_utility_grouped_reminder-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_grouped_success"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_grouped_success"
            latest_news_id= "single_player_scheduled_payment_utility_grouped_success-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_solo_rejected"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_solo_rejected"
            latest_news_id= "single_player_scheduled_payment_utility_solo_rejected-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_solo_reminder"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_solo_reminder"
            latest_news_id= "single_player_scheduled_payment_utility_solo_reminder-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_solo_success"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_solo_success"
            latest_news_id= "single_player_scheduled_payment_utility_solo_success-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_pixtransfer_grouped_insufficient_amount"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_pixtransfer_grouped_insufficient_amount"
            latest_news_id= "single_player_scheduled_payment_pixtransfer_grouped_insufficient_amount-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_pixtransfer_solo_insufficient_amount"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_pixtransfer_solo_insufficient_amount"
            latest_news_id= "single_player_scheduled_payment_pixtransfer_solo_insufficient_amount-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_pixtransfer_grouped_reminder"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_pixtransfer_grouped_reminder"
            latest_news_id= "single_player_scheduled_payment_pixtransfer_grouped_reminder-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_pixtransfer_solo_reminder"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_pixtransfer_solo_reminder"
            latest_news_id= "single_player_scheduled_payment_pixtransfer_solo_reminder-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payment_reminder_expiring_grouped_debt"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payment_reminder_expiring_grouped_debt"
            latest_news_id= "single_player_payment_reminder_expiring_grouped_debt-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/single_player_directv_smartcard_expiration"(platform: "/") {
            latest_news_type= "single_player_directv_smartcard_expiration"
            latest_news_id= "single_player_directv_smartcard_expiration-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payment_reminder"(platform: "/") {
            latest_news_type= "single_player_payment_reminder"
            latest_news_id= "single_player_payment_reminder-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/single_player_recharge_fail_ml"(platform: "/") {
            latest_news_type= "single_player_recharge_fail_ml"
            latest_news_id= "single_player_recharge_fail_ml-143816022-MLB1013046714"
        }
        "/notification_center/single_player_recharge_success_ml"(platform: "/") {
            latest_news_type= "single_player_recharge_success_ml"
            latest_news_id= "single_player_recharge_success_ml-143816022-MLB1013046714"
        }
        "/notification_center/single_player_recharge_fail_mp"(platform: "/") {
            latest_news_type= "single_player_recharge_fail_mp"
            latest_news_id= "single_player_recharge_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_recharge_success_mp"(platform: "/") {
            latest_news_type= "single_player_recharge_success_mp"
            latest_news_id= "single_player_recharge_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_self_service_schedule_new_debt"(platform: "/") {
            latest_news_type= "single_player_self_service_schedule_new_debt"
            latest_news_id= "single_player_self_service_schedule_new_debt-143816022-MLB1013046714"
            debt_id=1234
            seller_name="Hendel"
        }

        "/notification_center/shipping_moderation_cross_docking_release_below"(platform: "/mobile"){
            latest_news_type= "shipping_moderation_cross_docking_release_below"
            latest_news_id= "shipping_moderation_cross_docking_release_below-143816022-MLB1013046714"
        }
        "/notification_center/shipping_proximity"(platform: "/mobile"){
            latest_news_type= "shipping_proximity"
            latest_news_id= "shipping_proximity-143816022-MLB1013046714"
        }
        "/notification_center/shipping_scoring_keyword_created"(platform: "/mobile"){
            latest_news_type= "shipping_scoring_keyword_created"
            latest_news_id= "shipping_scoring_keyword_created-143816022-MLB1013046714"
            shipment_id = 123
        }
        "/notification_center/shipping_shipped_out_for_delivery"(platform: "/mobile"){
            latest_news_type= "shipping_shipped_out_for_delivery"
            latest_news_id= "shipping_shipped_out_for_delivery-143816022-MLB1013046714"
            shipment_id = 123
        }
        "/notification_center/shipping_shipped_soon_deliver"(platform: "/mobile"){
            latest_news_type= "shipping_shipped_soon_deliver"
            latest_news_id= "shipping_shipped_soon_deliver-143816022-MLB1013046714"
            shipment_id = 123
        }
        "/notification_center/shipping_special_milkrun"(platform: "/mobile"){
            latest_news_type= "shipping_special_milkrun"
            latest_news_id= "shipping_special_milkrun-143816022-MLB1013046714"
        }
        "/notification_center/shipping_moderation_cross_docking_recovery"(platform: "/mobile"){
            latest_news_type= "shipping_moderation_cross_docking_recovery"
            latest_news_id= "shipping_moderation_cross_docking_recovery-143816022-MLB1013046714"
        }
        "/notification_center/shipping_moderation_cross_docking_downgrade"(platform: "/mobile"){
            latest_news_type= "shipping_moderation_cross_docking_downgrade"
            latest_news_id= "shipping_moderation_cross_docking_downgrade-143816022-MLB1013046714"
        }
        "/notification_center/buyer_absent_driver_action"(platform: "/mobile"){
            latest_news_type= "buyer_absent_driver_action"
            latest_news_id= "buyer_absent_driver_action-143816022-MLB1013046714"
            shipment_id = 123
        }
        "/notification_center/transaction_rejected_international_authorization_by_invalid_amount"(platform: "/mobile"){
            latest_news_type= "transaction_rejected_international_authorization_by_invalid_amount"
            latest_news_id= "transaction_rejected_international_authorization_by_invalid_amount-143816022-MLB1013046714"
        }
        "/notification_center/transaction_invalid_amount_option_credit"(platform: "/mobile"){
            latest_news_type= "transaction_invalid_amount_option_credit"
            latest_news_id= "transaction_invalid_amount_option_credit-143816022-MLB1013046714"
        }

        // Disbursement Kwai
        "/notification_center/disbursement_kwai_received"(platform: "/") {
            latest_news_type= "disbursement_kwai_received"
            latest_news_id= "disbursement_kwai-received-12345678"
        }

        "/notification/seller_journey_congrats"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
        }

        "/notification/seller_journey_do_something"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
        }
        "/notification/seller_journey_do_something"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
        }
        "/notification/seller_journey_do_something"(platform: "/mobile"){
            step_id= 123
            event_type= "sent"
        }

        "/notification/card_updater_expiry"(platform: "/mobile") {
            news_id = "card_updater_expiry-12345678"
            event_type = "shown"
        }
        "/notification/card_updater_update"(platform: "/mobile") {
            news_id = "card_updater_update-12345678"
            event_type = "shown"
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
        "/notification/account_fund_approved_mlc_tc"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_ml_tc-12345678"
            event_type = "shown"
        }
        "/notification/account_fund_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_active_disabled_clabe"(platform: "/mobile") {
            news_id = "account_fund_active_disabled_clabe-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_bank_transfer"(platform: "/mobile") {
            news_id = "account_fund_bank_transfer-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_iv_cvu_spb"(platform: "/mobile") {
            news_id = "account_fund_iv_cvu_spb-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_pending_clabe"(platform: "/mobile") {
            news_id = "account_fund_pending_clabe-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_ticket"(platform: "/mobile") {
            news_id = "account_fund_ticket-12345678"
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

        "/notification/account_fund_approved_ted"(platform: "/mobile") {
            news_id = "account_fund-approved_ted-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_approved_mp"(platform: "/mobile") {
            news_id = "account_fund-account_balance_approved_mp-12345678"
            event_type = "shown"
        }

        "/notification/account_balance_create_ted_account"(platform: "/mobile") {
            news_id = "account_balance_create_ted_account-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_overlimit_active"(platform: "/") {
            news_id = "credit_card_overlimit_active-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_overlimit_inactive"(platform: "/") {
            news_id = "credit_card_overlimit_inactive-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_transaction_chout_purchase"(platform: "/") {
            news_id = "credit_card-transaction_chout_purchase-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_10"(platform: "/") {
            news_id = "credit_card-waitlist_10-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_40"(platform: "/") {
            news_id = "credit_card-waitlist_40-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_blacklist"(platform: "/") {
            news_id = "credit_card-waitlist_blacklist-12"
            event_type = "dismiss"
        }
        "/notification/card_first_use_incentive_first_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_first_day-12345678"
            event_type = "dismiss"
        }
        "/notification/card_first_use_incentive_thirdth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_thirdth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_thirdth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_thirdth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_fourteenth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_fourteenth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_seventh_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_seventh_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_twentyoneth_day"(platform: "/mobile") {
            news_id = "card_flow_incentive_prepaid_acquisition_first-12345678"
            event_type = "shown"
        }
        "/notification/card_flow_incentive_prepaid_acquisition_first"(platform: "/mobile") {
            news_id = "card_flow_incentive_prepaid_acquisition_first-12345678"
            event_type = "shown"
        }
        "/notification/card_flow_incentive_prepaid_acquisition_second"(platform: "/mobile") {
            news_id = "card_flow_incentive_prepaid_acquisition_second-12345678"
            event_type = "shown"
        }
        "/notification/card_freeze_rejected_authorization"(platform: "/mobile") {
            news_id = "card_freeze_rejected_authorization-12345678"
            event_type = "shown"
        }
        "/notification/ingate_tokenization_verification_code"(platform: "/") {
            news_id = "ingate_tokenization-verification_code-315571651"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_freeze_rejected_withdraw"(platform: "/mobile") {
            news_id = "card_freeze_rejected_withdraw-12345678"
            event_type = "shown"
        }
        "/notification/card_limit_rejected_withdraw_by_limit"(platform: "/mobile") {
            news_id = "card_limit_rejected_withdraw_by_limit-12345678"
            event_type = "shown"
        }
        "/notification/card_limit_rejected_withdraw_by_maximum_limit"(platform: "/mobile") {
            news_id = "card_limit_rejected_withdraw_by_maximum_limit-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_physical_card"(platform: "/mobile") {
            news_id = "card_offering_physical_card-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_transaction_generic_opt_in_ppd_to_hybrid"(platform: "/mobile") {
            news_id = "card_offering_transaction_generic_opt_in_ppd_to_hybrid-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_transaction_opt_in_ppd_to_hybrid"(platform: "/mobile") {
            news_id = "card_offering_transaction_opt_in_ppd_to_hybrid-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_invalid_pin_first_tries"(platform: "/mobile") {
            news_id = "card_pin_invalid_pin_first_tries-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_invalid_pin_fourth_try"(platform: "/mobile") {
            news_id = "card_pin_invalid_pin_fourth_try-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_pin_blocked"(platform: "/mobile") {
            news_id = "card_pin_pin_blocked-12345678"
            event_type = "shown"
        }
        "/notification/card_reminders_pin_reminder"(platform: "/mobile") {
            news_id = "card_reminders_pin_reminder-12345678"
            event_type = "shown"
        }
        "/notification/card_reminders_virtual_digital_services"(platform: "/mobile") {
            news_id = "card_reminders_virtual_digital_services-12345678"
            event_type = "shown"
        }
        "/notification/card_request_challenge_expired"(platform: "/mobile") {
            news_id = "card_request_challenge_expired-12345678"
            event_type = "shown"
        }
        "/notification/card_request_challenge_pending"(platform: "/mobile") {
            news_id = "card_request_challenge_pending-12345678"
            event_type = "shown"
        }
        "/notification/card_request_challenge_pre_expired"(platform: "/mobile") {
            news_id = "card_request_challenge_pre_expired-12345678"
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

        "/notification/addresses_update_bad_address"(platform: "/mobile") {
            news_id = "addresses_update_bad_address-12345678-123"
            event_type = "shown"
        }

        "/notification/addresses_update_bad_address_delivered"(platform: "/mobile") {
            news_id = "addresses_update_bad_address_delivered-12345678-123"
            event_type = "shown"
        }

        "/notification/billing_iva_ganancias_reactive"(platform: "/mobile"){
            news_id = "billing_iva_ganancias_reactive-12345678-123"
            event_type = "shown"
        }
        "/notification/billing_newtaxhabituality"(platform: "/mobile"){
            news_id = "billing_newtaxhabituality-12345678-123"
            event_type = "shown"
        }
        "/notification/billing_newtax"(platform: "/mobile"){
            news_id = "billing_newtax-12345678-123"
            event_type = "shown"
        }
        "/notification/billing_responsable_inscripto_reminder"(platform: "/mobile"){
            news_id = "billing_responsable_inscripto_reminder-12345678-123"
            event_type = "shown"
        }
        "/notification/billing_iva_isr_meli"(platform: "/mobile"){
            news_id = "billing_iva_isr_meli-12345678-123"
            event_type = "shown"
        }
        "/notification/billing_iva_isr"(platform: "/") {
            news_id = "billing-iva_isr_mp-186785675-20200522"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/billing_iva_isr_mp"(platform: "/") {
            news_id = "billing-iva_isr_mp-186785675-20200522"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/buybox_forced_item"(platform: "/mobile"){
            news_id = "buybox_forced_item-12345678-123"
            event_type = "shown"
        }
        "/notification/buybox_forewarning"(platform: "/mobile"){
            news_id = "buybox_forewarning-12345678-123"
            event_type = "shown"
        }
        "/notification/buybox_losing_item"(platform: "/mobile"){
            news_id = "buybox_losing_item-12345678-123"
            event_type = "shown"
        }
        "/notification/buybox_losing_many"(platform: "/mobile"){
            news_id = "buybox_losing_many-12345678-123"
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
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            execution_id = 123456
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
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            send_health_check = true
        }

        "/notification/campaigns_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
        }
        "/notification/mpcampaigns_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
        }

        "/notification/institutional_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
        }
        "/notification/mpinstitutional_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
        }

        "/notification/campaigns_wpp_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
        }
        
        "/notification/mpcampaigns_wpp_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
        }

        "/notification/institutional_wpp_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
        }

        "/notification/mpinstitutional_wpp_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
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

        "/notification/campaigns_schedule"(platform: "/") {
            news_id = "12332323"
            event_type = "open"
            notification_type= "deep_linking"
            campaign_id = "MLB22"
            campaign_type = "xp_cupones"
            campaign_data = "{\"item_id\":\"MLB12345\"}"
            batch_id = "actividad"
            test_notification = false
            send_health_check = false
            schedule_date = "2021-09-30T16:03:00.009-04:00"
            schedule_id = "schedule_id_test"
            sent_date = "20180516"
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
        "/notification/cancellations_warning_seller_too_many"(platform: "/mobile") {
            event_type = "shown"
        }
        "/notification/cancellations_notice_delayed_reimbursement"(platform: "/mobile") {
            event_type = "shown"
        }
        "/notification/cancellations_notice_cancelled_purchase"(platform: "/mobile") {
            event_type = "shown"
        }
        "/notification/cancellations_notice_cancelled_purchase_proximity"(platform: "/mobile") {
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
        "/notification/chargeback_payer_high_agree_repayment_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_high_agree_repayment_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }
        "/notification/chargeback_payer_high_n_chargebacks_agree_repayment_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_high_n_chargebacks_agree_repayment_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }

        "/notification/credits_consumer_expired_n_loans_fourth_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_fourth_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_onboarding_notice"(platform: "/mobile") {
            news_id = "credits-consumer_onboarding_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_onboarding_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_onboarding_mp_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_expired_eighty_notice"(platform: "/") {
            news_id = "credits-consumer_expired_eighty_notice-21680059-20180516"
            event_type = "shown"
        }
            
        "/notification/credits_consumer_expired_two_notice"(platform: "/") {
            news_id = "credits-consumer_expired_two_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_expired_nine_notice"(platform: "/") {
            news_id = "credits-consumer_expired_nine_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_expired_fifteen_notice"(platform: "/") {
            news_id = "credits-consumer_expired_fifteen_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_expired_on_due_date_notice"(platform: "/") {
            news_id = "credits-consumer_expired_on_due_date_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_expired_thirteen_notice"(platform: "/") {
            news_id = "credits-consumer_expired_thirteen_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_expired_twentythree_notice"(platform: "/") {
            news_id = "credits-consumer_expired_twentythree_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_expired_thirtyone_notice"(platform: "/") {
            news_id = "credits-consumer_expired_thirtyone_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_expired_ninety_notice"(platform: "/") {
            news_id = "credits-consumer_expired_ninety_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_how_to_use"(platform: "/") {
            news_id = "credits-consumer_expired_ninety_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_requirements"(platform: "/") {
            news_id = "credits-consumer_chatbot_requirements-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_how_to_pay"(platform: "/") {
            news_id = "credits-consumer_chatbot_how_to_pay-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_credit_limit"(platform: "/") {
            news_id = "credits-consumer_chatbot_credit_limit-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_financing_rate"(platform: "/") {
            news_id = "credits-consumer_chatbot_financing_rate-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_duedate"(platform: "/") {
            news_id = "credits-consumer_chatbot_duedate-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_purchase_trouble"(platform: "/") {
            news_id = "credits-consumer_chatbot_purchase_trouble-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_mc_unavailable"(platform: "/") {
            news_id = "credits-consumer_chatbot_mc_unavailable-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_less_money"(platform: "/") {
            news_id = "credits-consumer_chatbot_less_money-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_early_payment"(platform: "/") {
            news_id = "credits-consumer_chatbot_early_payment-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_cancel_loan"(platform: "/") {
            news_id = "credits-consumer_chatbot_cancel_loan-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_payment_promise_info"(platform: "/") {
            news_id = "credits-consumer_chatbot_payment_promise_info-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_accredited_time"(platform: "/") {
            news_id = "credits-consumer_chatbot_accredited_time-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_initial_greeting"(platform: "/") {
            news_id = "credits-consumer_chatbot_initial_greeting-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_no_match"(platform: "/") {
            news_id = "credits-consumer_chatbot_no_match-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_no_match_v2"(platform: "/") {
            news_id = "credits-consumer_chatbot_no_match_v2-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_ask_feedback"(platform: "/") {
            news_id = "credits-consumer_chatbot_ask_feedback-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_sensitive_info"(platform: "/") {
            news_id = "credits-consumer_chatbot_sensitive_info-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_appreciate"(platform: "/") {
            news_id = "credits-consumer_chatbot_appreciate-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_no_multimedia"(platform: "/") {
            news_id = "credits-consumer_chatbot_no_multimedia-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_feedback_numeric"(platform: "/") {
            news_id = "credits-consumer_chatbot_feedback_numeric-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_feedback_written"(platform: "/") {
            news_id = "credits-consumer_chatbot_feedback_written-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_feedback_omitted"(platform: "/") {
            news_id = "credits-consumer_chatbot_feedback_omitted-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_early_payment"(platform: "/") {
            news_id = "credits-consumer_chatbot_early_payment-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_payment_promise"(platform: "/") {
            news_id = "credits-consumer_chatbot_payment_promise-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_payment_promise_info_v2"(platform: "/") {
            news_id = "credits_consumer_chatbot_payment_promise_info_v2-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_chatbot_general_trouble"(platform: "/") {
            news_id = "credits_consumer_chatbot_general_trouble-21680059-20180516"
            event_type = "shown"
        }

        
        "/notification/chargeback_payer_high_agree_repayment_mp"(platform: "/mobile") {
            news_id = "chargeback-payer_high_agree_repayment_mp-14363307744123"
            event_type = "shown"
            case_id = "158213000000"
            notification_type= "deep_linking"
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
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_about_to_expire_first_notice"(platform: "/mobile") {
            news_id = "credits_consumer_about_to_expire_first_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_about_to_expire_first_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_about_to_expire_first_mp_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_about_to_expire_mp_second_notice"(platform: "/mobile") {
            news_id = "credits-consumer_about_to_expire_mp_second_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_closing_date_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_closing_date_mp_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_congrats_personal_loans"(platform: "/mobile") {
            news_id = "credits_consumer_congrats_personal_loans-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_registration_journey_mp"(platform: "/mobile") {
            news_id = "credits_consumer_registration_journey_mp-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_expired_last_notice"(platform: "/mobile") {
            news_id = "credits_consumer_expired_last_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_on_due_day_notice"(platform: "/mobile") {
            news_id = "credits_consumer_on_due_day_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_expired_sixty_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_third_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_opt_in_telcel_data_privacy"(platform: "/mobile") {
            news_id = "credits_consumer-opt_in_telcel_data_privacy-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_congrats_microlines"(platform: "/mobile") {
            news_id = "credits-credits_consumer_congrats_microlines-21680059-20180516"
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

        "/notification/credits_consumer_expired_sixty_notice"(platform: "/mobile") {
            news_id = "credits_consumer_expired_sixty_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_expired_fortyfive_notice"(platform: "/mobile") {
            news_id = "credits_consumer_expired_fortyfive_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_about_to_expire_first_notice"(platform: "/mobile") {
            news_id = "credits_consumer_about_to_expire_first_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_last_notice"(platform: "/mobile") {
            news_id = "credits_consumer_expired_last_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_mp_first_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_mp_first_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_mp_fortyfive_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_mp_fortyfive_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_mp_fourth_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_mp_fourth_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_mp_second_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_mp_second_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_mp_third_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_mp_third_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_sixty_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_sixty_mp_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_first_time_use_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_first_time_use_mp_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_on_due_day_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_on_due_day_mp_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_n_loans_last_notice"(platform: "/mobile") {
            news_id = "credits_consumer_expired_n_loans_last_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_on_due_day_notice"(platform: "/mobile") {
            news_id = "credits_consumer_on_due_day_notice-21680059-20180516"
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
        "/notification/credit_card_adhoc_communication"(platform: "/") {
            news_id = "credit_card-adhoc_communication-148801678-free-annuity-20211405"
            event_type = "dismiss"
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

        "/notification/melichat_message_ml"(platform: "/mobile"){
            case_id= 12345678
            event_type = "sent"
        }

        "/notification/instore_discover_activities"(platform: "/mobile"){
            news_id = "instore-discover_activities-321953606"
            event_type = "sent"
        }

        "/notification/instore_buyer_qr"(platform: "/mobile"){
            news_id = "instore-buyer_qr-321953606"
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

        "/notification/me_crowd_multiple_offers_available"(platform: "/mobile"){
            news_id = "me_crowd-multiple_offers_available-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_upcoming_trip_forewarn"(platform: "/mobile"){
            news_id = "me_crowd_upcoming_trip_forewarn-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_canceled_order_warning"(platform: "/mobile"){
            news_id = "me_crowd_canceled_order_warning-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/messages_driver_flex"(platform: "/mobile"){
            news_id = "messages-driver_flex-321953606"
            event_type = "sent"
        }

        "/notification/me_flex_optin_activation"(platform: "/mobile"){
            news_id = "me_flex-optin_activation-315571651"
            event_type = "sent"
        }

        "/notification/me_flex_rehunting_generic"(platform: "/mobile"){
            news_id = "me_flex_rehunting_generic-315571651"
            event_type = "sent"
        }

        "/notification/me_flex_rehunting_address"(platform: "/mobile"){
            news_id = "me_flex_rehunting_address-315571651"
            event_type = "sent"
        }

        "/notification/me_flex_rehunting_reputation"(platform: "/mobile"){
            news_id = "me_flex-rehunting_reputation-315571651"
            event_type = "sent"
        }

        "/notification/me_flex_hunting_generic"(platform: "/mobile"){
            news_id = "me_flex_hunting_generic-315571651"
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

        //Money Advance
        "/notification/money_advance_congrats"(platform: "/mobile"){
            news_id = "money_advance_congrats-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_advance_fail"(platform: "/mobile"){
            news_id = "money_advance_fail-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_started"(platform: "/mobile"){
            news_id = "money_split_started-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_rejected_push"(platform: "/mobile"){
            news_id = "money_split_rejected_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_rejected"(platform: "/mobile"){
            news_id = "money_split_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_paid_push"(platform: "/mobile"){
            news_id = "money_split_paid_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_paid"(platform: "/mobile"){
            news_id = "money_split_paid-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_started"(platform: "/mobile"){
            news_id = "money_request_started-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_rejected_push"(platform: "/mobile"){
            news_id = "money_request_rejected_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_rejected"(platform: "/mobile"){
            news_id = "money_request_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_finished"(platform: "/mobile"){
            news_id = "money_request_finished-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashout"(platform: "/mobile"){
            news_id = "money_out_cashout-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }

        "/notification/multiplayer_money_request"(platform: "/mobile"){
            news_id = "multiplayer-money_request-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/multiplayer_ml_money_request"(platform: "/mobile"){
            news_id = "multiplayer_ml_money_request-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/multiplayer_regulation"(platform: "/mobile"){
            news_id = "multiplayer_regulation-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/multiplayer_regulation_validated"(platform: "/mobile"){
            news_id = "multiplayer_regulation_validated-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
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
            communication_id = "test"
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

        "/notification/payments_release"(platform: "/mobile") {
            notification_id = "12345"
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
        "/notification/quotes_answer_send"(platform: "/mobile") {
            news_id = "quotes_answer_send-123"
            event_type = "open"
        }
        "/notification/quotes_answer_pending"(platform: "/mobile") {
            news_id = "quotes_answer_pending-123"
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
        "/notification/orders_deliver_confirmation_newbie_seller"(platform: "/mobile") {
            news_id = "orders-deliver_confirmation_newbie_seller-1004906131"
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
            device_status = "active"
            order_id = 1957429460
        }
        "/notification/orders_ticket_payment_pending_reminder_general_notice"(platform: "/mobile") {
            news_id = "orders-ticket_payment_pending_reminder_general_notice-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            device_status = "not_engaged"
            order_id = 1957429460
        }
        "/notification/orders_ticket_boleto_payment_pending"(platform: "/mobile") {
            news_id = "orders-ticket_boleto_payment_pending-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            device_status = "not_engaged"
            order_id = 1957429460
        }
        "/notification/orders_ticket_payment_pending"(platform: "/mobile") {
            news_id = "orders_ticket_payment_pending-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            device_status = "not_engaged"
            order_id = 1957429460
        }
        "/notification/orders_ticket_payment_pending_day_expiration_general_notice"(platform: "/mobile") {
            news_id = "orders-ticket_payment_pending_day_expiration_general_notice-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            device_status = "not_engaged"
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
        "/notification/payments_ticket_boleto_pending_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
            item_id = "MLA122211"
        }
        "/notification/purchase_invoice"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }
        "/notification/partners_pin_ml"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            partner= "123"
        }
        "/notification/partners_pin_mp"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            partner= "123"
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

        "/notification/shipping_shipped_out_for_delivery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_shipped_outside_me"(platform: "/mobile") {
            news_id = "shipping_shipped_outside_me-12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_shipped_retained_sender"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_shipped_soon_deliver"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_delivered"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_express_return"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_without_express_return"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_express_return"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_places_without_return"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_handling_agency_unavailable"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
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
        "/notification/shipping_wrong_address_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_shipped_withdrawal_to_agency_places"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_shipped_to_agency_places"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_reminder_places_withdrawal"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_not_delivered_waiting_for_withdrawal"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_not_delivered_soon_to_be_returned"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_cart_without_express_return"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_cart_express_return"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_buyer_absent_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_buyer_absent_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_agency_receiver_for_failed_delivery"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_moderation_cross_docking_release_below"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/shipping_moderation_cross_docking_recovery"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/shipping_moderation_cross_docking_downgrade"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/shipping_wrong_address_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            shipment_id = 123
        }
        "/notification/shipping_buyer_absent_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            shipment_id = 123
        }
        "/notification/shipping_scoring_keyword_created"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            shipment_id = 123
        }

        "/notification/shipping_shipped_same_day"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_soon_deliver_same_day"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_delivered_partial_cancellations"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_shipped_partial_cancellations"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_rts_in_packing_list"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_rts_in_packing_list"(platform: "/mobile"){
            news_id = "shipping-rts_in_packing_list-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_shipped_bad_address"(platform: "/mobile"){
            news_id = "shipping-shipped_bad_address-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_shipped_bad_address_on_way"(platform: "/mobile"){
            news_id = "shipping-shipped_bad_address_on_way-21409256333"
            event_type = "arrived"
            shipment_id = 21409256333
        }
        "/notification/shipping_shipped_same_day"(platform: "/mobile"){
            news_id = "shipping-shipped_same_day-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_shipped_waiting_for_confirmation"(platform: "/mobile"){
            news_id = "shipping-shipped_waiting_for_confirmation-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_soon_deliver_same_day"(platform: "/mobile"){
            news_id = "shipping-soon_deliver_same_day-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_shipped_partial_cancellations"(platform: "/mobile"){
            news_id = "shipping-soon_deliver_same_day-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_delivered_partial_cancellations"(platform: "/mobile"){
            news_id = "shipping-soon_deliver_same_day-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
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

        "/notification/protected_purchase_order_reminder_purchase_protection"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
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

        "/notification/mediations_v2_pdd_dispute_with_timeout_buyer"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
        }

        "/notification/mediations_v2_pdd_dispute_elected_action_reminder_buyer"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
        }

        "/notification/mediations_v2_pdd_dispute_without_timeout_buyer"(platform: "/mobile") {
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

        "/notification/mediations_v2_pdd_dispute_with_timeout_seller"(platform: "/mobile") {
            news_id = "mediations_v2-pdd_dispute_with_timeout_seller-1013715421-5b0d7ee426e063333fe0c582"
            event_type = "shown"
            notification_style = "c"
            claim_id = 1013715459
        }

        "/notification/mediations_v2_pdd_dispute_without_timeout_seller"(platform: "/mobile") {
            news_id = "mediations_v2-pdd_dispute_without_timeout_seller-1013715421-5b0d7ee426e063333fe0c582"
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

        "/notification/vouchers_payments_refund"(platform: "/mobile") {
            news_id = "vouchers_payment_refund-123"
            event_type = "open"
        }

        "/notification/payments_rejected"(platform: "/mobile") {
            news_id = "123"
            event_type = "dismiss"
            item_id = "MLA1234"
            order_id = 1234321
        }

        /* ============================================================ */
        /* Team: IT Payments - Payroll | Initiative: Salary Portability */
        /*                       contact: payroll-devs@mercadolibre.com */
        // Portability Request
        "/notification/payroll_portability_request_accepted"(platform: "/mobile") {
            news_id = "payroll-portability_request_accepted-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_accepted"(platform: "/mobile") {
            news_id = "payroll-portability_request_accepted-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_accepted"(platform: "/mobile") {
            news_id = "payroll-portability_request_accepted-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_denied"(platform: "/mobile") {
            news_id = "payroll-portability_request_denied-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_denied"(platform: "/mobile") {
            news_id = "payroll-portability_request_denied-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_denied"(platform: "/mobile") {
            news_id = "payroll-portability_request_denied-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_failed"(platform: "/mobile") {
            news_id = "payroll-portability_request_failed-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_failed"(platform: "/mobile") {
            news_id = "payroll-portability_request_failed-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_failed"(platform: "/mobile") {
            news_id = "payroll-portability_request_failed-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_integrated"(platform: "/mobile") {
            news_id = "payroll-portability_request_integrated-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_integrated"(platform: "/mobile") {
            news_id = "payroll-portability_request_integrated-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_integrated"(platform: "/mobile") {
            news_id = "payroll-portability_request_integrated-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        // Portability
        "/notification/payroll_portability_first_salary"(platform: "/mobile") {
            news_id = "payroll-portability_first_salary-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_first_salary"(platform: "/mobile") {
            news_id = "payroll-portability_first_salary-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_first_salary"(platform: "/mobile") {
            news_id = "payroll-portability_first_salary-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_ted_rejected"(platform: "/mobile") {
            news_id = "payroll-portability_ted_rejected-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_ted_rejected"(platform: "/mobile") {
            news_id = "payroll-portability_ted_rejected-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_ted_rejected"(platform: "/mobile") {
            news_id = "payroll-portability_ted_rejected-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_disabled"(platform: "/mobile") {
            news_id = "payroll-portability_disabled-492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
            event_type = "open"
            portability_id = "492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
        }

        "/notification/payroll_portability_first_notice"(platform: "/mobile") {
            news_id = "payroll-portability_first_notice-492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
            event_type = "open"
            portability_id = "492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
        }

        "/notification/payroll_portability_second_notice"(platform: "/mobile") {
            news_id = "payroll-portability_second_notice-492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
            event_type = "open"
            portability_id = "492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
        }

        // KYC
        "/notification/payroll_kyc_accepted"(platform: "/mobile") {
            news_id = "payroll-kyc_accepted-1234"
            event_type = "open"
        }

        "/notification/payroll_kyc_accepted"(platform: "/mobile") {
            news_id = "payroll-kyc_accepted-1234"
            event_type = "dismiss"
        }

        "/notification/payroll_kyc_accepted"(platform: "/mobile") {
            news_id = "payroll-kyc_accepted-1234"
            event_type = "auto_dismiss"
        }

        "/notification/payroll_kyc_approved"(platform: "/mobile") {
            news_id = "payroll_kyc_approved-1234"
            event_type = "open"
        }

        "/notification/payroll_kyc_approved"(platform: "/mobile") {
            news_id = "payroll_kyc_approved-1234"
            event_type = "dismiss"
        }

        "/notification/payroll_kyc_approved"(platform: "/mobile") {
            news_id = "payroll_kyc_approved-1234"
            event_type = "auto_dismiss"
        }

        /* ------------------------------------------------------------ */

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

        "/notification/messages_flex"(platform: "/mobile/android") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/me_crowd_multiple_offers_available"(platform: "/mobile/android"){
            news_id = "me_crowd-multiple_offers_available-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_upcoming_trip_forewarn"(platform: "/mobile/android"){
            news_id = "me_crowd_upcoming_trip_forewarn-699997492-1611784275"
            event_type = "sent"
        }
        "/notification/me_crowd_canceled_order_warning"(platform: "/mobile/android"){
            news_id = "me_crowd_canceled_order_warning-699997492-1611784275"
            event_type = "sent"
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
            mantika_id="26491bbb-b9d2-4dac-8ce7-7f739ea74d7b"
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
        "/notification/returns_return_to_buyer_shipped"(platform: "/mobile") {
            news_id = "returns-return_to_buyer_shipped-1674717959-216070768"
            event_type = "arrived"
            order_id = 1703754979
        }
        "/notification/returns_return_cancelled_buyer"(platform: "/mobile") {
            news_id = "returns-return_cancelled_buyer-1234-186785675"
            event_type = "arrived"
            order_id = 1234
        }
        "/notification/returns_return_failed_return_to_buyer"(platform: "/mobile") {
            news_id = "returns-return_failed_return_to_buyer-1234-186785675"
            event_type = "arrived"
            order_id = 1234
        }
        "/notification/returns_return_delivered_long_way"(platform: "/mobile") {
            news_id = "returns-return_delivered_long_way-1234-186785675"
            event_type = "arrived"
            order_id = 1234
        }
        "/notification/returns_return_failed_shipment_not_delivered"(platform: "/mobile") {
            news_id = "returns-return_failed_shipment_not_delivered-1234-186785675"
            event_type = "arrived"
            order_id = 1234
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

        "/notification/returns_refund_account_money"(platform: "/mobile") {
            news_id = "returns_refund_account_money-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_no_shipping_option"(platform: "/mobile") {
            news_id = "returns_no_shipping_option-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_label_unavailable"(platform: "/mobile") {
            news_id = "returns_label_unavailable-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_refund_bank_transfer"(platform: "/mobile") {
            news_id = "returns_refund_bank_transfer-1703067817-269729837"
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
        "/notification/security_enroll_screenlock_app"(platform: "/mobile") {
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
        "/notification/fraud_kyc_validation"(platform: "/mobile") {
            news_id = "fraud-kyc_validation-186785675"
            event_type = "open"
        }
        "/notification/fraud_delivery_cancellation_stop_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/fraud_remedies_identity_start_second_score"(platform: "/mobile") {
            news_id= "fraud_remedies_identity_start_second_score-222222222-123456789"
            event_type = "open"
        }
        "/notification/fraud_remedies_identity_reminder_second_score"(platform: "/mobile") {
            news_id= "fraud_remedies_identity_reminder_second_score-222222222-123456789"
            event_type = "open"
        }
        "/notification/fraud_remedies_card_start_second_score"(platform: "/mobile") {
            news_id= "fraud_remedies_card_start_second_score-222222222-123456789"
            event_type = "open"
        }
        "/notification/fraud_remedies_card_reminder_second_score"(platform: "/mobile") {
            news_id= "fraud_remedies_card_reminder_second_score-222222222-123456789"
            event_type = "open"
        }
        "/notification/da_kyc_manual_review"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
        }

        "/notification/data_privacy_about_to_expire"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
        }
        "/notification/data_privacy_extend_expiration"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
        }
        "/notification/data_privacy_ready"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
        }
        "/notification/driver_logistics_allocated_dock"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/driver_logistics_deassigned_dock"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/driver_logistics_modified_dock"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/driver_logistics_resend_allocated_dock"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }

        "/notification/fraud_delivery_cancellation_stop_mp"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_poc_trust_vote_second_score"(platform: "/mobile") {
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

        "/notification/fraud_cash_release_iv"(platform: "/mobile") {
            news_id = "fraud_cash_release_iv-12345678"
            event_type = "shown"
        }

        "/notification/fraud_remedies_trust_vote_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/flows_default"(platform: "/mobile"){
            initiative_code= "123"
            news_id= "123"
            event_type= "open"
        }

        "/notification/growth_tooling_mgm_kyc_booster"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
        }
        "/notification/growth_tooling_mgm_kyc_guest"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
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
        "/notification/account_fund_approved_mlc_tc"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_ml_tc-12345678"
            event_type = "shown"
        }
        "/notification/account_fund_salary"(platform: "/mobile") {
            news_id = "account_fund-account_fund_salary-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_active_disabled_clabe"(platform: "/mobile") {
            news_id = "account_fund_active_disabled_clabe-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_bank_transfer"(platform: "/mobile") {
            news_id = "account_fund_bank_transfer-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_iv_cvu_spb"(platform: "/mobile") {
            news_id = "account_fund_iv_cvu_spb-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_pending_clabe"(platform: "/mobile") {
            news_id = "account_fund_pending_clabe-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_ticket"(platform: "/mobile") {
            news_id = "account_fund_ticket-12345678"
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
        //Always On

        "/notification/alwayson_bsasa"(platform: "/") {
            news_id = "alwayson-bsasa-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_bsash"(platform: "/") {
            news_id = "alwayson-bsash-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_cabaa"(platform: "/") {
            news_id = "alwayson-cabaa-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_cabab"(platform: "/") {
            news_id = "alwayson-cabab-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_cabac"(platform: "/") {
            news_id = "alwayson-cabac-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_cabah"(platform: "/") {
            news_id = "alwayson-cabah-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_ivaa"(platform: "/") {
            news_id = "alwayson-ivaa-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_ivab"(platform: "/") {
            news_id = "alwayson-ivab-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_ivah"(platform: "/") {
            news_id = "alwayson-ivah-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_sirtaca"(platform: "/") {
            news_id = "alwayson-sirtaca-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_sirtacb"(platform: "/") {
            news_id = "alwayson-sirtacb-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_sirtacc"(platform: "/") {
            news_id = "alwayson-sirtacc-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_sirtach"(platform: "/") {
            news_id = "alwayson-sirtach-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/account_balance_create_ted_account"(platform: "/mobile") {
            news_id = "account_balance_create_ted_account-12345678"
            event_type = "shown"
        }

        "/notification/credit_card_overlimit_active"(platform: "/") {
            news_id = "credit_card_overlimit_active-12"
            event_type = "dismiss"
        }

        "/notification/credit_card_overlimit_inactive"(platform: "/") {
            news_id = "credit_card_overlimit_inactive-12"
            event_type = "dismiss"
        }

        "/notification/credit_card_transaction_chout_purchase"(platform: "/") {
            news_id = "credit_card-transaction_chout_purchase-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_10"(platform: "/") {
            news_id = "credit_card-waitlist_10-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_40"(platform: "/") {
            news_id = "credit_card-waitlist_40-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_blacklist"(platform: "/") {
            news_id = "credit_card-waitlist_blacklist-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_collection_due_in_10"(platform: "/mobile") {
            news_id = "credit_card_collection_due_in_10-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_due_in_05"(platform: "/mobile") {
            news_id = "credit_card_collection_due_in_05-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_due_in_01"(platform: "/mobile") {
            news_id = "credit_card_collection_due_in_01-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_due_in_00"(platform: "/mobile") {
            news_id = "credit_card_collection_due_in_00-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_01"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_01-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_04"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_04-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_05"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_05-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_10"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_10-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_15"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_15-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_19"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_19-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_20"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_20-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_29"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_29-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_30"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_30-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_50"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_50-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_53"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_53-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_58"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_58-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_acquisition"(platform: "/mobile") {
            news_id = "credit_card_transaction_acquisition-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_choff_purchase"(platform: "/mobile") {
            news_id = "credit_card_transaction_choff_purchase-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_statement_payment"(platform: "/mobile") {
            news_id = "credit_card_transaction_statement_payment-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_purchase"(platform: "/mobile") {
            news_id = "credit_card_transaction_purchase-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_withdrawal"(platform: "/mobile") {
            news_id = "credit_card_transaction_withdrawal-12345678"
            event_type = "shown"
        }

        "/notification/card_first_use_incentive_first_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_first_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_thirdth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_thirdth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_fourteenth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_fourteenth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_seventh_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_seventh_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_twentyoneth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_twentyoneth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_flow_incentive_prepaid_acquisition_first"(platform: "/mobile") {
            news_id = "card_flow_incentive_prepaid_acquisition_first-12345678"
            event_type = "shown"
        }
        "/notification/card_flow_incentive_prepaid_acquisition_second"(platform: "/mobile") {
            news_id = "card_flow_incentive_prepaid_acquisition_second-12345678"
            event_type = "shown"
        }
        "/notification/card_freeze_rejected_withdraw"(platform: "/mobile") {
            news_id = "card_freeze_rejected_withdraw-12345678"
            event_type = "shown"
        }
        "/notification/card_limit_rejected_withdraw_by_limit"(platform: "/mobile") {
            news_id = "card_limit_rejected_withdraw_by_limit-12345678"
            event_type = "shown"
        }
        "/notification/card_limit_rejected_withdraw_by_maximum_limit"(platform: "/mobile") {
            news_id = "card_limit_rejected_withdraw_by_maximum_limit-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_invalid_pin_first_tries"(platform: "/mobile") {
            news_id = "card_pin_invalid_pin_first_tries-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_invalid_pin_fourth_try"(platform: "/mobile") {
            news_id = "card_pin_invalid_pin_fourth_try-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_pin_blocked"(platform: "/mobile") {
            news_id = "card_pin_pin_blocked-12345678"
            event_type = "shown"
        }
        "/notification/card_reminders_pin_reminder"(platform: "/mobile") {
            news_id = "card_reminders_pin_reminder-12345678"
            event_type = "shown"
        }
        "/notification/card_reminders_virtual_digital_services"(platform: "/mobile") {
            news_id = "card_reminders_virtual_digital_services-12345678"
            event_type = "shown"
        }
        "/notification/card_request_challenge_expired"(platform: "/mobile") {
            news_id = "card_request_challenge_expired-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_physical_card"(platform: "/mobile") {
            news_id = "card_offering_physical_card-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_transaction_generic_opt_in_ppd_to_hybrid"(platform: "/mobile") {
            news_id = "card_offering_transaction_generic_opt_in_ppd_to_hybrid-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_transaction_opt_in_ppd_to_hybrid"(platform: "/mobile") {
            news_id = "card_offering_transaction_opt_in_ppd_to_hybrid-12345678"
            event_type = "shown"
        }
        "/notification/card_transactions_approved_authorization_whatsapp"(platform: "/mobile") {
            news_id = "card_transactions-approved_authorization_whatsapp-debit_authorization_1ba2b28e8a12db8c1c7e27e7c07fd7ns6a28"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_payment_authorization"(platform: "/mobile") {
            news_id = "card_transactions-payment_authorization-2018120931-12345689"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_fund_money_in_whatsapp"(platform: "/mobile") {
            news_id = "card_transactions-fund_money_in_whatsapp-debit_authorization_1ba2b28e8a12db8c1c7e27e7c07fd7ns6a28"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_virtual_already_cancelled"(platform: "/mobile") {
            news_id = "card_transactions-rejected_authorization_virtual_already_cancelled-95AO96H14JInssK6rdZvm1r3Zwv20yFesI1bhlDmv1rj4LrpP0Sn8nQ5pbT35Ti9"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_virtual_inactive"(platform: "/mobile") {
            news_id = "card_transactions-rejected_authorization_virtual_inactive-95AO96H14JInssK6rdZvm1r3Zwv20yFesI1bhlDmv1rj4LrpP0Sn8nQ5pbT35Ti9"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_withdraw_international_by_invalid_amount"(platform: "/mobile") {
            news_id = "card_transactions-rejected_withdraw_international_by_invalid_amount-95AO96H14JInssK6rdZvm1r3Zwv20yFesI1bhlDmv1rj4LrpP0Sn8nQ5pbT35Ti9"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification_center/credit_card_adhoc_communication"(platform: "/") {
            latest_news_type= "credit_card_adhoc_communication"
            latest_news_id= "credit_card-adhoc_communication-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_collection"(platform: "/") {
            latest_news_type= "credit_card_collection"
            latest_news_id= "credit_card-collection-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_overlimit"(platform: "/") {
            latest_news_type= "credit_card_overlimit"
            latest_news_id= "credit_card_overlimit-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_transaction_acquisition"(platform: "/") {
            latest_news_type= "credit_card_transaction_acquisition"
            latest_news_id= "credit_card_transaction_acquisition-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_transaction_choff_purchase"(platform: "/") {
            latest_news_type= "credit_card_transaction_choff_purchase"
            latest_news_id= "credit_card_transaction_choff_purchase-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_transaction_purchase"(platform: "/") {
            latest_news_type= "credit_card_transaction_purchase"
            latest_news_id= "credit_card_transaction_purchase-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_transaction_statement_payment"(platform: "/") {
            latest_news_type= "credit_card_transaction_statement_payment"
            latest_news_id= "credit_card_transaction_statement_payment-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_transaction_withdrawal"(platform: "/") {
            latest_news_type= "credit_card_transaction_withdrawal"
            latest_news_id= "credit_card_transaction_withdrawal-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_waitlist"(platform: "/") {
            latest_news_type= "credit_card_waitlist"
            latest_news_id= "credit_card_waitlist-148801678-free-annuity-20211405"
        }
        "/notification_center/credits_merchants_spl_congrats"(platform: "/") {
            latest_news_type= "credits_merchants_spl_congrats"
            latest_news_id= "credits_merchants_spl_congrats-148801678-free-annuity-20211405"
        }
        "/notification_center/credits_merchants_spl_expired_0_ws"(platform: "/") {
            latest_news_type= "credits_merchants_spl_expired_0_ws"
            latest_news_id= "credits_merchants_spl_expired_0_ws-148801678-free-annuity-20211405"
        }
        "/notification_center/credits_merchants_spl_expired_30_ws"(platform: "/") {
            latest_news_type= "credits_merchants_spl_expired_30_ws"
            latest_news_id= "credits_merchants_spl_expired_30_ws-148801678-free-annuity-20211405"
        }
        "/notification_center/credits_merchants_std_expired_daily_charges_75"(platform: "/") {
            latest_news_type= "credits_merchants_std_expired_daily_charges_75"
            latest_news_id= "credits_merchants_std_expired_daily_charges_75-148801678-free-annuity-20211405"
        }
        "/notification/anses_payment_date"(platform: "/mobile") {
            news_id = "anses_payment_date-12345678-123"
            event_type = "shown"
        }

        "/notification/anses_paid_benefit"(platform: "/mobile") {
            news_id = "anses_paid_benefit-12345678-123"
            event_type = "shown"
        }

        "/notification/addresses_update_bad_address"(platform: "/mobile") {
            news_id = "addresses_update_bad_address-12345678-123"
            event_type = "shown"
        }

        "/notification/addresses_update_bad_address_delivered"(platform: "/mobile") {
            news_id = "addresses_update_bad_address_delivered-12345678-123"
            event_type = "shown"
        }

        "/notification/asset_management_warm_up"(platform: "/mobile") {
            news_id = "asset-management_warm_up-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_missing_docs"(platform: "/mobile") {
            news_id = "asset-management_missing_docs-12345678-123123"
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

        "/notification/asset_management_failed"(platform: "/mobile") {
            news_id = "asset-management_failed-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_rejected"(platform: "/mobile") {
            news_id = "asset-management_rejected-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_underage_approved"(platform: "/mobile") {
            news_id = "asset-management_underage_approved-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_underage_rejected"(platform: "/mobile") {
            news_id = "asset-management_underage_rejected-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_underage_request"(platform: "/mobile") {
            news_id = "asset-management_underage_request-12345678-123123"
            event_type = "shown"
        }

        "/notification/institutional_generic"(platform: "/mobile"){
            event_type = "open"
            campaign_id= "institutional_generic1"
            sent_date= "20180508"
            batch_id = "MLA_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLA1234"
        }

        "/notification/mpinstitutional_generic"(platform: "/mobile"){
            event_type = "open"
            campaign_id= "mpinstitutional_generic1"
            sent_date= "20180508"
            batch_id = "MLA_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLA1234"
        }

        "/notification/institutional_control_group"(platform: "/mobile"){
            event_type="discarded"
            campaign_id= "institutional-control_group1"
            sent_date= "20210624"
            batch_id = "MLA_PACK_20180508_3"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLA1234"
        }

        "/notification/mpinstitutional_control_group"(platform: "/mobile"){
            event_type="discarded"
            campaign_id= "mpinstitutional-control_group1"
            sent_date= "20210624"
            batch_id = "MLA_MPPACK_20180508_4"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLA12345"
        }

        "/notification/mpcampaigns_campaigns"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            campaign_id = "mkt_campaign_co"
            batch_id = "MLB_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLB1234"
            sent_date = "20181211"
        }

        "/notification/subscription_expiring_notice"(platform: "/mobile") {
            news_id = "subscription-expiring_notice-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_option = "Citibanamex"
        }

        "/notification/subscription_payment_congrats"(platform: "/mobile") {
            news_id = "subscription-payment_congrats-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_type = "successful_payment"
            female_gender = true
        }

        "/notification/subscription_payment_error"(platform: "/mobile") {
            news_id = "subscription-payment_error-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            error_type = "card_code"
            female_gender = true
        }

        "/notification/subscription_payment_instructions"(platform: "/mobile") {
            news_id = "subscription-payment_instructions-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_option = "Citibanamex"
            female_gender = true
        }

        "/notification/subscription_payment_pending"(platform: "/mobile") {
            news_id = "subscription-payment_pending-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_type = "successful_payment"
            female_gender = true
        }
        "/notification/subscription_disney_activation_on"(platform: "/mobile") {
            news_id = "subscription_disney_activation_on-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification/subscription_disney_activation_off"(platform: "/mobile") {
            news_id = "subscription_disney_activation_off-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification/subscription_disney_activation_free_trial"(platform: "/mobile") {
            news_id = "subscription_disney_activation_free_trial-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
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
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }

        "/notification/mp_sponsor_campaign_budget_trigger"(platform: "/mobile") {
            news_id = "mp_sponsor-campaign_budget_trigger-12345678-123123"
            event_type = "shown"
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }

        "/notification/mp_sponsor_campaign_day_trigger"(platform: "/mobile") {
            news_id = "mp_sponsor-campaign_day_trigger-12345678-123123"
            event_type = "shown"
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }

        "/notification/mp_seller_campaign_start_campaign"(platform: "/mobile") {
            news_id = "mp_seller-campaign_start_campaign-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_seller_campaign_end_campaign"(platform: "/mobile") {
            news_id = "mp_seller-campaign_end_campaignn-12345678-123123"
            event_type = "shown"
        }
        "/notification/mp_seller_campaign_resume_campaign"(platform: "/mobile") {
            news_id = "mp_seller-campaign_resume_campaign-12345678-123123"
            event_type = "shown"
        }
        "/notification/mp_seller_marketplace_must"(platform: "/mobile") {
            news_id = "mp_seller_marketplace_must-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_seller_generic_wish"(platform: "/mobile") {
            news_id = "mp_seller_generic_wish-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_seller_discount_center_must"(platform: "/mobile") {
            news_id = "mp_seller_discount_center_must-12345678-123123"
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

        "/notification/credits_merchants_em_to_expire_01"(platform: "/mobile") {
            news_id = "credits-merchants_em_to_expire_01-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_expired_no_charges_today"(platform: "/mobile") {
            news_id = "credits-merchants_em_expired_no_charges_today-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_expired_daily_charges_01"(platform: "/mobile") {
            news_id = "credits-merchants_em_expired_daily_charges_01-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_expired_daily_charges_04"(platform: "/mobile") {
            news_id = "credits-merchants_em_expired_daily_charges_04-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_expired_daily_charges_07"(platform: "/mobile") {
            news_id = "credits-merchants_em_expired_daily_charges_07-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_expired_daily_charges_10"(platform: "/mobile") {
            news_id = "credits-merchants_em_expired_daily_charges_10-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_congrats"(platform: "/mobile") {
            news_id = "credits_merchants_em_congrats-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_collected"(platform: "/mobile") {
            news_id = "credits_merchants_em_collected-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_congrats"(platform: "/mobile") {
            news_id = "credits_merchants_spl_congrats-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_expired_05_push"(platform: "/mobile") {
            news_id = "credits_merchants-spl_expired_05_push-1234"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_expired_45_push"(platform: "/mobile") {
            news_id = "credits_merchants-spl_expired_45_push-1234"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_to_expire_00_push"(platform: "/mobile") {
            news_id = "credits_merchants-spl_expired_00_push-1234"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_to_expire_01_push"(platform: "/mobile") {
            news_id = "credits_merchants-spl_expired_01_push-1234"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_to_expire_10_push"(platform: "/mobile") {
            news_id = "credits_merchants-spl_expired_10_push-1234"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_finished_loan_payment"(platform: "/mobile") {
            news_id = "credits_merchants_std_finished_loan_payment-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_expired_daily_charges_30"(platform: "/mobile") {
            news_id = "credits_merchants_std_expired_daily_charges_30-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_expired_daily_charges_60"(platform: "/mobile") {
            news_id = "credits_merchants_std_expired_daily_charges_60-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_expired_daily_charges_75"(platform: "/mobile") {
            news_id = "credits_merchants_std_expired_daily_charges_75-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_expired_daily_charges_90"(platform: "/mobile") {
            news_id = "credits_merchants_std_expired_daily_charges_90-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_expired_daily_charges_110"(platform: "/mobile") {
            news_id = "credits_merchants_std_expired_daily_charges_110-9876"
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
        "/notification/credit_card_compulsory_debit_equal_min_payment"(platform: "/mobile") {
            news_id = "credit_card_compulsory_debit_equal_min_payment-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_compulsory_debit_less_min_payment"(platform: "/mobile") {
            news_id = "credit_card_compulsory_debit_less_min_payment-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_compulsory_debit_money_refund"(platform: "/mobile") {
            news_id = "ccredit_card_compulsory_debit_money_refund-12345678"
            event_type = "shown"
        }

        //Merchant
        "/notification/merchants_growth_mgm"(platform: "/mobile") {
            gift_reason_id = "test"
            event_type = "open"
        }
        "/notification/merchants_growth_fdv_failure"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_fdv_recovery"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_fdv_success"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_fdv_warning"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_paper_roll_first_request"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_paper_roll_recurrent_request"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_paper_roll_reminder"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_resellers_caps"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_resellers_newland_nfc_launch"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_resellers_prizes"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_resellers_pro2_launch"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_resellers_smart_launch"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_sameday"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_reverse_screening_fraud"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_reverse_screening_conflict"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_pricing_point_scl_down"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_pricing_point_scl_onboarding"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_pricing_point_scl_maintain"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_pricing_point_scl_up"(platform: "/mobile") {
            event_type = "open"
        }

        "/notification/money_transfer_received"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/money_transfer_sender"(platform: "/mobile") {
            news_id = "money-transfer_sender-186785675-1122-993783123"
            event_type = "open"
        }

        "/notification/moneyin_debin_approved"(platform: "/") {
            news_id = "moneyin_debin-approved-12345678"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/moneyin_debin_in_process"(platform: "/") {
            news_id = "moneyin_debin-process-12345678"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/moneyin_debin_rejected"(platform: "/") {
            news_id = "moneyin_debin-rejected-12345678"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/hub_transfer_new_approved"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/hub_transfer_manualreview"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/hub_transfer_new_rejected"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/hub_transfer_rejected"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/hub_transfer_screening_one"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/hub_transfer_screening_two"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_handoff_user_notification_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_handoff_user_notification_mp"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_user_notification_mp"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_user_notification_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_bo_success"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/killers_loser_item_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/killers_winner_item_recover"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/killers_winner_item_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/killers_winner_item_lost"(platform: "/mobile") {
            news_id = "killers-winner_item_lost-MLA123-19712790"
            event_type = "open"
        }
        "/notification/killers_losing_item_buybox"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_afip_user_notification_mp"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/money_transfer_request"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/money_split_started"(platform: "/mobile"){
            news_id = "money_split_started-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_rejected_push"(platform: "/mobile"){
            news_id = "money_split_rejected_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_rejected"(platform: "/mobile"){
            news_id = "money_split_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_paid_push"(platform: "/mobile"){
            news_id = "money_split_paid_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_paid"(platform: "/mobile"){
            news_id = "money_split_paid-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_started"(platform: "/mobile"){
            news_id = "money_request_started-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_rejected_push"(platform: "/mobile") {
            news_id = "money_request_rejected_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_rejected"(platform: "/mobile") {
            news_id = "money_request_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_finished"(platform: "/mobile") {
            news_id = "money_request_finished-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashout"(platform: "/mobile") {
            news_id = "money_out_cashout-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_finished"(platform: "/mobile") {
            news_id = "money_split_finished-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_paid_push"(platform: "/mobile") {
            news_id = "money_request_paid_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashoutmlb_rejected_manualreview"(platform: "/mobile") {
            news_id = "money_out_cashoutmlb_rejected_manualreview-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashoutmlb_rejected"(platform: "/mobile") {
            news_id = "money_out_cashoutmlb_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashoutmlb_pending"(platform: "/mobile") {
            news_id = "money_out_cashoutmlb_pending-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashoutmlb_approved"(platform: "/mobile") {
            news_id = "money_out_cashoutmlb_approved-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashout_withdrawn"(platform: "/mobile") {
            news_id = "money_out_cashout_withdrawn-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashout_reversed"(platform: "/mobile") {
            news_id = "money_out_cashout_reversed-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_in_cashin_exceeded_cap"(platform: "/mobile") {
            news_id = "money_in_cashin_exceeded_cap-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_started"(platform: "/mobile"){
            news_id = "money_request_started-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_rejected_push"(platform: "/mobile"){
            news_id = "money_request_rejected_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_rejected"(platform: "/mobile"){
            news_id = "money_request_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_finished"(platform: "/mobile"){
            news_id = "money_request_finished-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashout"(platform: "/mobile"){
            news_id = "money_out_cashout-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/moneyin_cashin_accredited"(platform: "/mobile") {
            news_id = "moneyin_cashin_accredited-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/moneyin_cashin_rejected"(platform: "/mobile") {
            news_id = "moneyin_cashin_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/loyalty_milestone"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
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
        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_for_fee"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount_for_fee-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
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
        "/notification/prepaid_card_transaction_capture_after_ttl"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_capture_after_ttl-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_transaction_capture_less_than_amount"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_capture_less_than_amount-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
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
        "/notification/prepaid_card_reprogrammed"(platform: "/mobile"){
            news_id = "prepaid_card_reprogrammed-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
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

        "/notification/prepaid_card_transaction_invalid_amount_option_credit"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_invalid_amount_option_credit-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
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

        "/notification/prepaid_card_transaction_rejected_international_authorization_by_invalid_amount"(platform: "/mobile"){
            news_id = "prepaid_card_transaction_rejected_international_authorization_by_invalid_amount-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_international_authorization_by_fraud_prevention"(platform: "/mobile"){
            news_id = "prepaid_card_transaction_rejected_international_authorization_by_fraud_prevention-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount_with_avaible_balance-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_by_kyc"(platform: "/mobile"){
            news_id = "prepaid_card_transaction_rejected_by_kyc-51AO96HEQ"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_compliant_kyc"(platform: "/mobile"){
            news_id = "prepaid_card_compliant_kyc-51AO96HEQ"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_challenge_bolbradesco_reminder"(platform: "/mobile") {
            news_id = "prepaid_card-challenge_bolbradesco_reminder-186785675"
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
        "/notification/card_kyc_data_completed_physical_acquisition"(platform: "/mobile") {
            news_id = "card_kyc_data_completed_physical_acquisition-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_nfc_acquisition"(platform: "/mobile") {
            news_id = "card_kyc_data_completed_nfc_acquisition-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_virtual"(platform: "/mobile") {
            news_id = "card_kyc_data_completed_virtual-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_unlock"(platform: "/mobile") {
            news_id = "card_kyc_data_completed_unlock-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_prepaid_acquisition_first"(platform: "/mobile") {
            news_id = "card_kyc_data_completed_prepaid_acquisition_first-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_prepaid_acquisition_second"(platform: "/mobile") {
            news_id = "card_kyc_data_completed_prepaid_acquisition_second-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_prepaid_acquisition_third"(platform: "/mobile") {
            news_id = "card_kyc_data_completed_prepaid_acquisition_fthird-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_unlock_incentive_zero_day_owner"(platform: "/mobile") {
            news_id = "card_unlock_incentive_zero_day_owner-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_virtual_acquisition"(platform: "/mobile") {
            news_id = "card_kyc_data_completed_virtual_acquisition-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_correios_strike_delayed"(platform: "/mobile") {
            news_id = "card_correios_strike_delayed-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_unlock_incentive_zero_day"(platform: "/mobile") {
            news_id = "card_unlock_incentive_zero_day-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_unlock_incentive_second_day"(platform: "/mobile") {
            news_id = "card_unlock_incentive_second_day-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
            has_money = true
        }

        "/notification/card_unlock_incentive_zero_day_somewhere"(platform: "/mobile") {
            news_id = "card_unlock_incentive_zero_day_somewhere-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_unlock_incentive_zero_day_point"(platform: "/mobile") {
            news_id = "card_unlock_incentive_zero_day_point-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_unlock_incentive_zero_day_known_person"(platform: "/mobile") {
            news_id = "card_unlock_incentive_zero_day_known_person-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_unlock_incentive_fifth_day"(platform: "/mobile") {
            news_id = "card_unlock_incentive_fifth_day-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_unlock_incentive_fifteenth_day"(platform: "/mobile") {
            news_id = "card_unlock_incentive_fifteenth_day-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_unlock_incentive_twentyfifth_day"(platform: "/mobile") {
            news_id = "card_unlock_incentive_twentyfifth_day-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/claim_pdd_first_rescue"(platform: "/mobile"){
            news_id = "claim_pdd_first_rescue-186785675-76283123"
            event_type = "open"
        }

        "/notification/claim_pdd_second_rescue"(platform: "/mobile"){
            news_id = "claim_pdd_second_rescue-186785675-76283123"
            event_type = "open"
        }

        "/notification/claim_return_allowed_seller_action_decorator"(platform: "/mobile"){
            news_id = "claim_return_allowed_seller_action_decorator-186785675-76283123"
            event_type = "open"
        }

        "/notification/claim_return_allowed_reminder_timeout_decorator"(platform: "/mobile"){
            news_id = "claim_return_allowed_reminder_timeout_decorator-186785675-76283123"
            event_type = "open"
        }
        "/notification/claim_return_allowed_seller_action"(platform: "/mobile"){
            news_id = "claim_return_allowed_seller_action-186785675-76283123"
            event_type = "open"
            order_id = 123
        }
        "/notification/claim_return_allowed_reminder_timeout"(platform: "/mobile"){
            news_id = "claim_return_allowed_reminder_timeout-186785675-76283123"
            event_type = "open"
            order_id = 123
        }
        "/notification/claim_closed_seller_refund_decorator"(platform: "/mobile"){
            news_id = "claim_closed_seller_refund_decorator-186785675-76283123"
            event_type = "open"
        }

        "/notification/claim_complainant_to_respondent_message"(platform: "/mobile"){
            news_id = "claim_complainant_to_respondent_message-186785675-76283123"
            event_type = "open"
        }

        "/notification/claim_respondent_to_complainant_message"(platform: "/mobile"){
            news_id = "claim_respondent_to_complainant_message-186785675-76283123"
            event_type = "open"
        }

        "/notification/claim_closed_seller_refund"(platform: "/mobile"){
            news_id = "claim_closed_seller_refund-186785675-76283123"
            event_type = "open"
            order_id = 123
        }
        
        "/notification/point_pos_closed"(platform: "/mobile") {
            news_id = "point_pos_closed-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/point_pos_close_soon"(platform: "/mobile") {
            news_id = "point_pos_close_soon-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/point_pix"(platform: "/mobile") {
            news_id = "point_pix-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/point_improvement"(platform: "/mobile") {
            news_id = "point_improvement-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/point_voucher_sodexo"(platform: "/mobile") {
            news_id = "point_voucher_sodexo-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/mp_shipping_on_way"(platform:"/mobile"){
            news_id="mp_shipping-on_way-789827052"
            event_type="arrived"
            notification_type="deep_linking"
        }
        "/notification/mp_shipping_not_delivered"(platform: "/mobile"){
            news_id="mp_shipping-not_delivered-788142312"
            event_type="arrived"
            notification_type="deep_linking"
        }
        "/notification/mp_shipping_label"(platform: "/mobile"){
            news_id="mp_shipping-label-788142312"
            event_type="arrived"
            notification_type="deep_linking"
        }
        "/notification/pix_transfer_mo_rejected"(platform: "/mobile") {
            news_id = "pix_transfer_mo_rejected-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_transfer_mo_manual_review"(platform: "/mobile") {
            news_id = "pix_transfer_mo_manual_review-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_transfer_mi_approved"(platform: "/mobile") {
            news_id = "pix_transfer_mi_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_transfer_mo_approved"(platform: "/mobile") {
            news_id = "pix_transfer_mo_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_portability_request"(platform: "/mobile") {
            news_id = "pix_key_portability_request-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_portability_rejected"(platform: "/mobile") {
            news_id = "pix_key_portability_rejected-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_portability_approved"(platform: "/mobile") {
            news_id = "pix_key_portability_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_claim_request"(platform: "/mobile") {
            news_id = "pix_key_claim_request-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_claim_rejected"(platform: "/mobile") {
            news_id = "pix_key_claim_rejected-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_claim_key_expired"(platform: "/mobile") {
            news_id = "pix_key_claim_key_expired-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_claim_key_deleted"(platform: "/mobile") {
            news_id = "pix_key_claim_key_deleted-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_claim_approved"(platform: "/mobile") {
            news_id = "pix_key_claim_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/pix_mediation_blocked_amount"(platform: "/mobile") {
            activity_id = "merchant_order_purchase-5c306f621d857f0dddf355d957eb8f2ee9eb14c9"
            news_id = "pix_mediation-blocked_amount-186785675-17811118042"
            payment_id = "17811118042"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_mediation_unblocked_amount"(platform: "/mobile") {
            activity_id = "merchant_order_purchase-5c306f621d857f0dddf355d957eb8f2ee9eb14c9"
            news_id = "pix_mediation-unblocked_amount-186785675-17811118042"
            payment_id = "17811118042"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_mediation_refunded"(platform: "/mobile") {
            activity_id = "merchant_order_purchase-5c306f621d857f0dddf355d957eb8f2ee9eb14c9"
            news_id = "pix_mediation-refunded-186785675-17811118042"
            payment_id = "17811118042"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification_center/pix_mediation_blocked_amount"(platform: "/mobile") {
            activity_id = "merchant_order_purchase-5c306f621d857f0dddf355d957eb8f2ee9eb14c9"
            latest_news_type= "pix_mediation_blocked_amount"
            latest_news_id= "pix_mediation-blocked_amount-186785675-17811118042"
            payment_id = "17811118042"
        }
        "/notification_center/pix_mediation_unblocked_amount"(platform: "/mobile") {
            activity_id = "merchant_order_purchase-5c306f621d857f0dddf355d957eb8f2ee9eb14c9"
            latest_news_type= "pix_mediation_unblocked_amount"
            latest_news_id= "pix_mediation-unblocked_amount-186785675-17811118042"
            payment_id = "17811118042"
        }
        "/notification_center/pix_mediation_refunded"(platform: "/mobile") {
            activity_id = "merchant_order_purchase-5c306f621d857f0dddf355d957eb8f2ee9eb14c9"
            latest_news_type= "pix_mediation_refunded"
            latest_news_id= "pix_mediation-refunded-186785675-17811118042"
            payment_id = "17811118042"
        }


        "/notification/point_shipping_ready_to_ship"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/point_fill_in"(platform: "/mobile") {
            news_id = "point_fill_in-123"
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
        "/notification/point_audit_cash"(platform: "/mobile") {
            news_id = "point_audit_cash-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/point_qr_login_new"(platform: "/mobile") {
            news_id = "point-qr_login_new-a34rb3"
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

        "/notification/single_player_directv_smartcard_expiration"(platform: "/mobile") {
            news_id = "single_player_directv_smartcard_expiration_123"
            event_type = "open"
        }

        "/notification/single_player_payment_reminder"(platform: "/mobile") {
            news_id = "single_player_payment_reminder_123"
            event_type = "open"
            debt_id=123
        }
        "/notification/single_player_recharge_fail_ml"(platform: "/mobile") {
            news_id = "single_player_recharge_fail_ml_123"
            event_type = "open"
        }
        "/notification/single_player_recharge_success_ml"(platform: "/mobile") {
            news_id = "single_player_recharge_success_ml_123"
            event_type = "open"
        }
        "/notification/single_player_recharge_fail_mp"(platform: "/mobile") {
            news_id = "single_player_recharge_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_recharge_success_mp"(platform: "/mobile") {
            news_id = "single_player_recharge_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_utility_success_mp"(platform: "/mobile") {
            news_id = "single_player_utility_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_utility_refused_am"(platform: "/mobile") {
            news_id = "single_player_utility_refused_am-123"
            event_type = "open"
        }
        "/notification/single_player_utility_refused_cc"(platform: "/mobile") {
            news_id = "single_player_utility_refused_cc-123"
            event_type = "open"
        }
        "/notification/single_player_utility_fail_mp"(platform: "/mobile") {
            news_id = "single_player_utility_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_utility_success_mp"(platform: "/mobile") {
            news_id = "single_player_utility_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_utility_refused_am"(platform: "/mobile") {
            news_id = "single_player_utility_refused_am-123"
            event_type = "open"
        }
        "/notification/single_player_utility_refused_cc"(platform: "/mobile") {
            news_id = "single_player_utility_refused_cc-123"
            event_type = "open"
        }
        "/notification/single_player_transport_success_mp"(platform: "/mobile") {
            news_id = "single_player_transport_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_transport_fail_mp"(platform: "/mobile") {
            news_id = "single_player_transport_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_prepaid_toll_success_mp"(platform: "/mobile") {
            news_id = "single_player_prepaid_toll_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_prepaid_toll_fail_mp"(platform: "/mobile") {
            news_id = "single_player_prepaid_toll_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_antenna_fail_mp"(platform: "/mobile") {
            news_id = "single_player_antenna_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_balance_expiration_transport_mp"(platform: "/mobile") {
            news_id = "single_player_balance_expiration_transport_mp_123"
            event_type = "open"
        }
        "/notification/single_player_new_debt_utility_mp"(platform: "/mobile") {
            news_id = "single_player_new_debt_utility_mp_123"
            event_type = "open"
            debt_id=123
        }
        "/notification/single_player_expired_debt_utility_mp"(platform: "/mobile") {
            news_id = "single_player_expired_debt_utility_mp_123"
            event_type = "open"
            debt_id=123
        }
        "/notification/single_player_antenna_success_mp"(platform: "/mobile") {
            news_id = "single_player_antenna_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_antenna_fail_mp"(platform: "/mobile") {
            news_id = "single_player_antenna_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_generic_balance_expiration"(platform: "/mobile") {
            news_id = "single_player_generic_balance_expiration_123"
            event_type = "open"
        }
        "/notification/single_player_payment_reminder_new_grouped_debt"(platform: "/mobile") {
            news_id = "single_player_payment_reminder_new_grouped_debt_123"
            event_type = "open"
            debt_id=123
        }
        "/notification/single_player_payment_reminder_new_solo_debt"(platform: "/mobile") {
            news_id = "single_player_payment_reminder_new_solo_debt"
            event_type = "open"
            debt_id=123
        }

        "/notification/single_player_payg_unlock_device_mp"(platform: "/mobile") {
            news_id = "single_player_payg_unlock_device_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_new_debt_without_block_mp"(platform: "/mobile") {
            news_id = "single_player_payg_new_debt_without_block_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_create_device_success_mp"(platform: "/mobile") {
            news_id = "single_player_payg_create_device_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_create_device_fail_mp"(platform: "/mobile") {
            news_id = "single_player-payg_create_device_fail_mp-315571651-5678-1479249799770"
            event_type = "open"
        }
        "/notification/single_player_payg_blocked_device_mp"(platform: "/mobile") {
            news_id = "single_player_payg_blocked_device_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_cashback_mp"(platform: "/mobile") {
            news_id = "single_player_payg_cashback_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_change_device_number_success_mp"(platform: "/mobile") {
            news_id = "single_player_payg_change_device_number_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_change_device_number_fail_mp"(platform: "/mobile") {
            news_id = "single_player_payg_change_device_number_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_grouped_rejected"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_grouped_rejected"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_grouped_reminder"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_grouped_reminder"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_grouped_success"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_grouped_success"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_solo_rejected"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_solo_rejected"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_solo_reminder"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_solo_reminder"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_pixtransfer_grouped_insufficient_amount"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_pixtransfer_grouped_insufficient_amount"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_pixtransfer_solo_insufficient_amount"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_pixtransfer_solo_insufficient_amount"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_pixtransfer_grouped_reminder"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_pixtransfer_grouped_reminder"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_pixtransfer_solo_reminder"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_pixtransfer_solo_reminder"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_solo_success"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_solo_success"
            event_type = "open"
        }
        "/notification/single_player_payment_reminder_expiring_grouped_debt"(platform: "/mobile") {
            news_id = "single_player_payment_reminder_expiring_grouped_debt_123"
            event_type = "open"
            debt_id=123
        }
        "/notification/single_player_self_service_schedule_new_debt"(platform: "/mobile") {
            news_id = "single_player-self_service_schedule_new_debt-315571651-123456789"
            event_type = "open"
            debt_id=123
            seller_name="Hendel"
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

        "/notification/wallet_integrator_payment_success"(platform: "/mobile") {
            news_id = "wallet_integrator-payment_success-186785675"
            event_type = "open"
        }

        "/notification/wallet_integrator_insufficient_funds"(platform: "/mobile") {
            news_id = "wallet_integrator-insufficient_funds-186785675"
            event_type = "open"
        }

        "/notification/wallet_integrator_personal_loan"(platform: "/mobile") {
            news_id = "wallet_integrator_personal_loan-186785675"
            event_type = "open"
        }

        //Withdrawal
        "/notification/withdraw_approved_contingency"(platform: "/mobile") {
            news_id = "withdraw-approved_contingency-186785675"
            event_type = "open"
        }
        "/notification/withdraw_approved"(platform: "/mobile") {
            news_id = "withdraw-approved-186785675"
            event_type = "open"
        }

        "/notification/discount_central_missing_data"(platform: "/mobile") {
            news_id = "discount_central-missing_data-12332323"
            event_type = "shown"
        }
        "/notification/dismiss"(platform: "/mobile") {
            news_id = "dismiss-12332323"
            event_type = "dismiss"
        }
        "/notification/cards_send_card"(platform: "/mobile") {
            news_id = "cards_send_card-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_compromised_virtual"(platform: "/mobile") {
            news_id = "card_compromised_virtual-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_compromised_physical"(platform: "/mobile") {
            news_id = "card_compromised_physical-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_contactless_transaction_rejected_authorization_contactless_freeze"(platform: "/mobile") {
            news_id = "card_contactless_transaction_rejected_authorization_contactless_freeze-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type = "deep_linking"
        }

        "/notification_center/insurtech_imei_activation"(platform: "/") {
            latest_news_type= "insurtech_imei_activation"
            latest_news_id= "insurtech_imei_activation-143816022-MLB1013046714"
        }
        "/notification_center/insurtech_kyc_roda_pre_activacion"(platform: "/") {
            latest_news_type= "insurtech_kyc_roda_pre_activacion"
            latest_news_id= "insurtech_kyc_roda_pre_activacion-143816022-MLB1013046714"
        }
        "/notification/insurtech_imei_activation"(platform: "/mobile") {
            news_id = "insurtech_imei_activation_123"
            event_type = "open"
        }
        "/notification/insurtech_kyc_roda_pre_activacion"(platform: "/mobile") {
            news_id = "insurtech_kyc_roda_pre_activacion-123"
            event_type = "open"
        }
        "/notification_center/insurtech_pending_payment"(platform: "/") {
            latest_news_type= "insurtech_pending_payment"
            latest_news_id= "insurtech_pending_payment-143816022-MLB1013046714"
        }
        "/notification/insurtech_payment_recovery"(platform: "/mobile") {
            news_id = "insurtech_payment_recovery-315571651-4600610652-2021-06-29"
            event_type = "open"
        }

        "/notification_center/insurtech_money_in"(platform: "/") {
            latest_news_type= "insurtechinsurtech_purchase_money_in"
            latest_news_id= "insurtech_money_in-315571651-4600610652-2021-06-29"
        }
        "/notification/insurtech_money_in"(platform: "/mobile") {
            news_id = "insurtech_money_in-315571651-4600610652-2021-06-29"
            event_type = "open"
        }
        "/notification/insurtech_pending_payment"(platform: "/mobile") {
            news_id = "insurtech_pending_payment_123"
            event_type = "open"
        }

        "/notification_center/insurtech_cancellation"(platform: "/") {
            latest_news_type= "insurtech_cancellation"
            latest_news_id= "insurtech_cancellation-143816022-MLB1013046714"
        }

        "/notification/insurtech_cancellation"(platform: "/mobile") {
            news_id = "insurtech_cancellation_123"
            event_type = "open"
        }

        "/notification_center/insurtech_purchase"(platform: "/") {
            latest_news_type= "insurtech_purchase"
            latest_news_id= "insurtech_pending_payment-143816022-02f6a0f5-4e88-4797-aa47-eeb1a9a1e01b"
        }

        "/notification/insurtech_purchase"(platform: "/mobile") {
            news_id = "insurtech_pending_payment-143816022-02f6a0f5-4e88-4797-aa47-eeb1a9a1e01b"
            event_type = "open"
        }

        "/notification_center/insurtech_new_claim"(platform: "/") {
            latest_news_type= "insurtech_new_claim"
            latest_news_id= "insurtech_new_claim-143816022-02f6a0f5-4e88-4797-aa47-eeb1a9a1e01b"
        }

        "/notification/insurtech_new_claim"(platform: "/mobile") {
            news_id = "insurtech_new_claim-143816022-02f6a0f5-4e88-4797-aa47-eeb1a9a1e01b"
            event_type = "open"
        }

         "/notification_center/insurtech_payment_recovery"(platform: "/") {
            latest_news_type= "insurtech_payment_recovery"
            latest_news_id= "insurtech_payment_recovery-315571651-4600610652-2021-06-29"
        }

        "/notification/insurtech_payment_recovery"(platform: "/mobile") {
            news_id = "insurtech_payment_recovery-315571651-4600610652-2021-06-29"
            event_type = "open"
        }

        "/notification_center/insurtech_money_in"(platform: "/") {
            latest_news_type= "insurtech_money_in"
            latest_news_id= "insurtech_money_in-315571651-4600610652-2021-06-29"
        }

        "/notification/insurtech_money_in"(platform: "/mobile") {
            news_id = "insurtech_money_in-315571651-4600610652-2021-06-29"
            event_type = "open"
        }

        "/notification_center/insurtech_payment_recovery_cards"(platform: "/") {
            latest_news_type= "insurtech_payment_recovery_cards"
            latest_news_id= "insurtech_payment_recovery_cards-315571651-4600610652-2021-06-29"
        }

        "/notification/insurtech_payment_recovery_cards"(platform: "/mobile") {
            news_id = "insurtech_payment_recovery_cards-315571651-4600610652-2021-06-29"
            event_type = "open"
        }

        "/notification_center/insurtech_post_service_poll"(platform: "/") {
            latest_news_type= "insurtech_post_service_poll"
            latest_news_id= "insurtech-post_service_poll-315571651-roda-02f6a0f5-4e88-4797-aa47-eeb1a9a1e01b"
        }

        "/notification/insurtech_post_service_poll"(platform: "/mobile") {
            news_id = "insurtech-post_service_poll-767964524-roda-c20f60b9-9922-42f6-80a0-8513a9d18772"
            event_type = "open"
        }

         "/notification/abandoned_cart_buyer"(platform: "/mobile") {
            event_type = "open"
        }

         "/notification/abandoned_cart_link_payer"(platform: "/mobile") {
            event_type = "open"
        }

        "/notification/card_wallet_resume_token"(platform: "/mobile") {
            news_id = "card_wallet_resume_token-51AO96HEQBssK6rdZvm"
            event_type = "auto_dismiss"
            notification_type = "deep_linking"
        }

        //Registration
        "/notification/registration_under_age_authorized"(platform: "/mobile") {
            news_id = "registration_under_age_authorized-123"
            event_type = "shown"
        }
        "/notification/registration_under_age_rejected"(platform: "/mobile") {
            news_id = "registration_under_age_rejected-123"
            event_type = "shown"
        }
        "/notification/registry_recovery"(platform: "/mobile") {
            news_id = "registry_recovery-123"
            event_type = "shown"
        }

        "/notification_center/insurtech_imei_cancellation_advice"(platform: "/") {
            latest_news_type= "insurtech_imei_cancellation_advice"
            latest_news_id= "insurtech_imei_cancellation_advice-143816022-MLB1013046714"
        }

        "/notification/insurtech_imei_cancellation_advice"(platform: "/mobile") {
            news_id = "insurtech_imei_cancellation_advice_123"
            event_type = "open"
        }

        //Under Age
        "/notification/under_age_responsible_info"(platform: "/") {
            news_id = "under_age-responsible_info-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_responsible_authorization_legacy"(platform: "/") {
            news_id = "under_age_responsible_authorization_legacy-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_minor_rejected"(platform: "/") {
            news_id = "under_age_minor_rejected-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_minor_approved"(platform: "/") {
            news_id = "under_age_minor_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_responsible_info_ml"(platform: "/") {
            news_id = "under_age-responsible_info-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_responsible_authorization_legacy_ml"(platform: "/") {
            news_id = "under_age_responsible_authorization_legacy-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_minor_rejected_ml"(platform: "/") {
            news_id = "under_age_minor_rejected-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_minor_approved_ml"(platform: "/") {
            news_id = "under_age_minor_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        //NFC

        "/notification/nfc_wallet"(platform: "/") {
            news_id = "1234-e567-MERCADOPAGO"
            event_type = "open"
            correlation_id = '1234e'
        }

        "/notification/nfc_command"(platform: "/") {
            news_id = "1234-e567-MERCADOPAGO"
            event_type = "open"
            command = 'fire_direct_enrollment'
        }

        "/notification/wallet_connect_binding_error"(platform: "/") {
            news_id = "wallet_connect-binding_error-84060496"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/wallet_connect_binding_with_card_and_cash"(platform: "/") {
            news_id = "wallet_connect-binding_with_card_and_cash-84060496"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/wallet_connect_binding_with_cash"(platform: "/") {
            news_id = "wallet_connect-binding_with_cash-84060496"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/wallet_connect_rejected_payment"(platform: "/") {
            news_id = "wallet_connect-rejected_payment-84060496"
            event_type = "open"
            notification_type= "deep_linking"
        }

        // Delay Compensation
        "/notification/shipping_delay_compensation_cashback"(platform: "/mobile"){
            news_id = "shipping_delay_compensation-cashback-786729047-40778713229"
            event_type = "open"
            notification_type= "deep_linking"
            shipment_id = 123
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
        "/notification_center/config"(platform: "/mobile", type: TrackType.View) {
        }
        "/notification_center"(platform: "/mobile"){}
        "/notification_center/abort"(platform: "/mobile"){}
        "/notification_center/abandoned_cart_buyer"(platform: "/mobile"){
            latest_news_type= "abandoned_cart_buyer"
            latest_news_id= "abandoned_cart_buyer-126635313"
        }
        "/notification_center/abandoned_cart_link_payer"(platform: "/mobile"){
            latest_news_type= "abandoned_cart_link_payer"
            latest_news_id= "abandoned_cart_link_payer-126635313"
        }
        "/notification_center/account_balance-cvu"(platform: "/mobile"){
            latest_news_type= "account_balance-cvu"
            latest_news_id= "account_balance-cvu-126635313"
        }
        "/notification_center/account_fund_approved_mlc_tc"(platform: "/mobile"){
            latest_news_type= "account_fund_approved_mlc_tc"
            latest_news_id= "account_fund_approved_mlc_tc-126635313"
        }
        "/notification_center/addresses_update"(platform: "/mobile"){
            latest_news_type= "addresses_update"
            latest_news_id= "addresses_update-126635313"
        }
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
        "/notification_center/under_age_responsible_info"(platform: "/") {
            latest_news_type= "under_age_responsible_info"
            latest_news_id= "under_age-responsible_info-186785675"
        }
        "/notification_center/under_age_responsible_authorization_legacy"(platform: "/") {
            latest_news_type= "under_age_responsible_authorization_legacy"
            latest_news_id= "under_age_responsible_authorization_legacy-186785675"
        }
        "/notification_center/under_age_minor_rejected"(platform: "/") {
            latest_news_type= "under_age_minor_rejected"
            latest_news_id= "under_age_minor_rejected-186785675"
        }
        "/notification_center/under_age_minor_approved"(platform: "/") {
            latest_news_type= "under_age_minor_approved"
            latest_news_id= "under_age_minor_approved-186785675"
        }
        "/notification_center/under_age_responsible_info_ml"(platform: "/") {
            latest_news_type= "under_age_responsible_info"
            latest_news_id= "under_age-responsible_info-186785675"
        }
        "/notification_center/under_age_responsible_authorization_legacy_ml"(platform: "/") {
            latest_news_type= "under_age_responsible_authorization_legacy"
            latest_news_id= "under_age_responsible_authorization_legacy-186785675"
        }
        "/notification_center/under_age_minor_rejected_ml"(platform: "/") {
            latest_news_type= "under_age_minor_rejected"
            latest_news_id= "under_age_minor_rejected-186785675"
        }
        "/notification_center/under_age_minor_approved_ml"(platform: "/") {
            latest_news_type= "under_age_minor_approved"
            latest_news_id= "under_age_minor_approved-186785675"
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

        "/notification_center/wrong_address_driver_action"(platform: "/mobile") {
            latest_news_type= "shipping-wrong_address_driver_action"
            latest_news_id= "shipping-wrong_address_driver_action-186785675-123123-20191120"
            shipment_id = 21409256437
        }
        "/notification_center/whatsapp-enrollment"(platform: "/mobile") {
            latest_news_type= "whatsapp-enrollment"
            latest_news_id= "whatsapp-enrollment-186785675-123123-20191120"
        }
        "/notification_center/payroll_portability"(platform: "/mobile"){
            latest_news_type = "payroll_portability"
            latest_news_id = "payroll_portability-143816022-MLB1013046714"
            portability_id = "123"
        }
        "/notification_center/payroll_portability_request"(platform: "/mobile"){
            latest_news_type = "payroll_portability_request"
            latest_news_id = "payroll_portability_request-143816022-MLB1013046714"
            portability_request_id = "123"
        }
        "/notification_center/payroll_kyc_approved"(platform: "/mobile"){
            latest_news_type = "payroll_kyc_approved"
            latest_news_id = "payroll_kyc_approved-143816022-MLB1013046714"
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

        "/notification_center/institutional_generic"(platform: "/mobile"){
            latest_news_type= "institutional_generic"
            latest_news_id= "institutional_generic-143816022-MLB1013046714"
            campaign_id= "institutional_generic"
            newsgroup_id= "institutional_generic-MLU102_07_02_2017-56626993"
            status= "unread"
            type_layout= "picture"
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
        }
        "/notification_center/ingate_tokenization_verification_code"(platform: "/") {
            latest_news_type= "ingate_tokenization_verification_code"
            latest_news_id= "ingate_tokenization-verification_code-315571651"
        }
        "/notification_center/mpinstitutional_generic"(platform: "/mobile"){
            latest_news_type= "mpinstitutional_generic"
            latest_news_id= "mpinstitutional_generic-143816022-MLB1013046714"
            campaign_id= "mpinstitutional_generic"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            newsgroup_id= "mpinstitutional_generic-MLU102_07_02_2017-56626993"
            status= "unread"
            type_layout= "picture"
            sent_date= "20180508"
            batch_id= "MLB_PACK_20180508_2"
        }
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
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
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
            mantika_id="26491bbb-b9d2-4dac-8ce7-7f739ea74d7b"
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
        "/notification_center/credit_card_transaction_chout_purchase"(platform: "/") {
            latest_news_type= "credit_card_transaction_chout_purchase"
            latest_news_id= "credit_card-transaction_chout_purchase-12"
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
        "/notification_center/da_kyc_manual_review"(platform: "/mobile"){
            latest_news_type= "da_kyc_manual_review"
            latest_news_id= "da_kyc_manual_review-143816022-MLB1013046714"
        }
        "/notification_center/data_privacy_export"(platform: "/mobile"){
            latest_news_type= "data_privacy_export"
            latest_news_id= "data_privacy_export-143816022-MLB1013046714"
        }
        "/notification_center/dangerous_substances"(platform: "/mobile"){
            latest_news_type= "dangerous_substances"
            latest_news_id= "dangerous_substances-143816022-MLB1013046714"
        }
        "/notification_center/disbursement_wu_successful"(platform: "/mobile"){
            latest_news_type= "disbursement_wu_successful"
            latest_news_id= "disbursement_wu_successful-143816022-MLB1013046714"
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
        "/notification_center/fraud_delivery_cancellation"(platform: "/mobile"){
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
        "/notification_center/fraud_delivery_cancellation_stop_mp"(platform: "/mobile") {
            latest_news_type= "fraud_delivery_cancellation_stop_mp"
            latest_news_id= "fraud_delivery_cancellation_stop_mp-143816022-MLB1013046714"
        }
        "/notification_center/fraud_poc_trust_vote_second_score"(platform: "/mobile") {
            latest_news_type= "fraud_poc_trust_vote_second_score"
            latest_news_id= "fraud_poc_trust_vote_second_score-143816022-MLB1013046714"
        }
        "/notification_center/fraud_delivery_cancellation_mp"(platform: "/mobile") {
            latest_news_type= "fraud_delivery_cancellation_mp"
            latest_news_id= "fraud_delivery_cancellation_mp-143816022-MLB1013046714"
        }
        "/notification_center/fbm_withdrawals_delayed"(platform: "/mobile") {
            latest_news_type= "fbm_withdrawals_delayed"
            latest_news_id= "fbm_withdrawals_delayed-143816022-MLB1013046714"
        }
        "/notification_center/fiscal_data_mp_business_registration"(platform: "/mobile") {
            latest_news_type= "fiscal_data_mp_business_registration"
            latest_news_id= "fiscal_data_mp_business_registration-143816022-MLB1013046714"
        }
        "/notification_center/gating_accreditation_approved"(platform: "/mobile") {
            latest_news_type= "gating_accreditation_approved"
            latest_news_id= "gating_accreditation_approved-143816022-MLB1013046714"
        }
        "/notification_center/gating_accreditation_rejected"(platform: "/mobile") {
            latest_news_type= "gating_accreditation_rejected"
            latest_news_id= "gating_accreditation_rejected-143816022-MLB1013046714"
        }
        "/notification_center/hub_transfer_new_scheduled"(platform: "/mobile") {
            latest_news_type= "hub_transfer_new_scheduled"
            latest_news_id= "hub_transfer_new_scheduled-143816022-MLB1013046714"
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

        "/notification_center/payments_release"(platform: "/mobile") {
            notification_id = "12345"
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
        "/notification_center/me_flex_rehunting_generic"(platform: "/mobile"){
            latest_news_type= "me_flex_rehunting_generic"
            latest_news_id= "me_flex_rehunting_generic-143816022-MLB1013046714"
        }
        "/notification_center/me_flex_rehunting_address"(platform: "/mobile"){
            latest_news_type= "me_flex_rehunting_address"
            latest_news_id= "me_flex_rehunting_address-143816022-MLB1013046714"
        }
        "/notification_center/me_flex_rehunting_reputation"(platform: "/mobile"){
            latest_news_type= "me_flex-rehunting_reputation"
            latest_news_id= "me_flex-rehunting_reputation-315571651"
        }
        "/notification_center/me_flex_hunting_generic"(platform: "/mobile"){
            latest_news_type= "me_flex_hunting_generic"
            latest_news_id= "me_flex_hunting_generic-143816022-MLB1013046714"
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
        "/notification_center/mediations_v2"(platform: "/", type: TrackType.Event) {
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
        "/notification_center/purchase_invoice"(platform: "/mobile"){
            newsgroup_id= "purchases-invoice-1000000016305386"
            status= "read"
            event_type= "open"
            deeplink= "https://myaccount.mercadolibre.com.mx/purchases/1000000016305386/detail"
            type_layout= "standard"
            latest_news_type= "purchase_invoice"
            latest_news_id= "purchase_invoice-1000000016305386"
        }
        "/notification_center/partners_pin_ml"(platform: "/mobile") {
            latest_news_type= "partners_pin_ml"
            latest_news_id= "partners_pin_ml-1000000016305386"
            partner= "123"
        }
        "/notification_center/partners_pin_mp"(platform: "/mobile") {
            latest_news_type= "partners_pin_mp"
            latest_news_id= "partners_pin_mp-1000000016305386"
            partner= "123"
        }
        "/notification_center/point_pos_closed"(platform: "/mobile") {
            latest_news_type= "point_pos_closed"
            latest_news_id= "point_pos_closed-1000000016305386"
        }
        "/notification_center/point_pos_close_soon"(platform: "/mobile") {
            latest_news_type= "point_pos_close_soon"
            latest_news_id= "point_pos_close_soon-1000000016305386"
        }
        "/notification_center/point_pix"(platform: "/mobile") {
            latest_news_type= "point_pix"
            latest_news_id= "point_pix-1000000016305386"
        }
        "/notification_center/point_voucher_sodexo"(platform: "/mobile") {
            latest_news_type= "point_voucher_sodexo"
            latest_news_id= "point_voucher_sodexo-1000000016305386"
        }
        "/notification_center/pix_transfer_mo_rejected"(platform: "/mobile") {
            latest_news_type= "pix_transfer_mo_rejected"
            latest_news_id= "pix_transfer_mo_rejected-1000000016305386"
        }
        "/notification_center/pix_transfer_mo_manual_review"(platform: "/mobile") {
            latest_news_type= "pix_transfer_mo_manual_review"
            latest_news_id= "pix_transfer_mo_manual_review-1000000016305386"
        }
        "/notification_center/pix_transfer_mi_approved"(platform: "/mobile") {
            latest_news_type= "pix_transfer_mi_approved"
            latest_news_id= "pix_transfer_mi_approved-1000000016305386"
        }
        "/notification_center/pix_transfer_mo_approved"(platform: "/mobile") {
            latest_news_type= "pix_transfer_mo_approved"
            latest_news_id= "pix_transfer_mo_approved-1000000016305386"
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
        "/notification_center/security_enroll_screenlock_app"(platform: "/mobile") {
            latest_news_type= "security_enroll_screenlock_app"
            latest_news_id= "security_enroll_screenlock_app-1000000016305386"
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
        "/notification_center/quotes_answer_send"(platform: "/mobile") {
            latest_news_type= "quotes_answer_send"
            latest_news_id= "quotes_answer_send-123-123"
        }
        "/notification_center/quotes_answer_pending"(platform: "/mobile") {
            latest_news_type= "quotes_answer_pending"
            latest_news_id= "quotes_answer_pending-123-123"
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
        "/notification_center/account_fund-cvu"(platform: "/mobile"){
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
        "/notification_center/account_fund_active_disabled_clabe"(platform: "/mobile"){
            newsgroup_id= "account_fund_active_disabled_clabe-12345678"
            latest_news_id= "account_fund_active_disabled_clabe-12345678"
            latest_news_type= "account_fund_active_disabled_clabe"
            status= "unread"
        }
        "/notification_center/account_fund_iv_cvu_spb"(platform: "/mobile"){
            newsgroup_id= "account_fund_iv_cvu_spb-12345678"
            latest_news_id= "account_fund_iv_cvu_spb-12345678"
            latest_news_type= "account_fund_iv_cvu_spb"
            status= "unread"
        }
        "/notification_center/account_fund_ticket"(platform: "/mobile"){
            newsgroup_id= "account_fund_ticket-12345678"
            latest_news_id= "account_fund_ticket-12345678"
            latest_news_type= "account_fund_ticket"
            status= "unread"
        }
        "/notification_center/asset_management_warm_up"(platform: "/mobile"){
            newsgroup_id= "asset_management-warm_up-186785675-76283123"
            latest_news_id= "asset_management-warm_up-186785675-76283123"
            latest_news_type= "asset_management_warm_up"
            status= "read"
        }
        "/notification_center/asset_management_missing_docs"(platform: "/mobile"){
            newsgroup_id= "asset_management-missing_docs-186785675-76283123"
            latest_news_id= "asset_management-missing_docs-186785675-76283123"
            latest_news_type= "asset_management_missing_docs"
            status= "read"
        }
        "/notification_center/asset_management_investing"(platform: "/mobile"){
            newsgroup_id= "asset_management-investing-186785675-76283123"
            latest_news_id= "asset_management-investing-186785675-76283123"
            latest_news_type= "asset_management_investing"
            status= "read"
        }
        "/notification_center/asset_management_failed"(platform: "/mobile"){
            newsgroup_id= "asset_management-failed-186785675-76283123"
            latest_news_id= "asset_management-failed-186785675-76283123"
            latest_news_type= "asset_management_failed"
            status= "read"
        }
        "/notification_center/asset_management_rejected"(platform: "/mobile"){
            newsgroup_id= "asset_management-rejected-186785675-76283123"
            latest_news_id= "asset_management-rejected-186785675-76283123"
            latest_news_type= "asset_management_rejected"
            status= "read"
        }
        "/notification_center/asset_management_underage_approved"(platform: "/mobile"){
            newsgroup_id= "asset_management-underage_approved-186785675-76283123"
            latest_news_id= "asset_management-underage_approved-186785675-76283123"
            latest_news_type= "asset_management_underage_approved"
            status= "read"
        }
        "/notification_center/asset_management_underage_rejected"(platform: "/mobile"){
            newsgroup_id= "asset_management-underage_rejected-186785675-76283123"
            latest_news_id= "asset_management-underage_rejected186785675-76283123"
            latest_news_type= "asset_management_underage_rejected"
            status= "read"
        }
        "/notification_center/asset_management_underage_request"(platform: "/mobile"){
            newsgroup_id= "asset_management-underage_request-186785675-76283123"
            latest_news_id= "asset_management-underage_request-186785675-76283123"
            latest_news_type= "asset_management_underage_request"
            status= "read"
        }
        "/notification_center/alwayson_bsas_a"(platform: "/") {
            latest_news_type= "alwayson_bsas_a"
            latest_news_id= "alwayson_bsas_a-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_bsas_h"(platform: "/") {
            latest_news_type= "alwayson_bsas_h"
            latest_news_id= "alwayson_bsas_h-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_caba_a"(platform: "/") {
            latest_news_type= "alwayson_caba_a"
            latest_news_id= "alwayson_caba_a-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_caba_b"(platform: "/") {
            latest_news_type= "alwayson_caba_b"
            latest_news_id= "alwayson_caba_b-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_caba_c"(platform: "/") {
            latest_news_type= "alwayson_caba_c"
            latest_news_id= "alwayson_caba_c-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_caba_h"(platform: "/") {
            latest_news_type= "alwayson_caba_h"
            latest_news_id= "alwayson_caba_h-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_iva_a"(platform: "/") {
            latest_news_type= "alwayson_iva_a"
            latest_news_id= "alwayson_iva_a-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_iva_b"(platform: "/") {
            latest_news_type= "alwayson_iva_b"
            latest_news_id= "alwayson_iva_b-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_iva_h"(platform: "/") {
            latest_news_type= "alwayson_iva_h"
            latest_news_id= "alwayson_iva_h-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_sirtac_a"(platform: "/") {
            latest_news_type= "alwayson_sirtac_a"
            latest_news_id= "alwayson_sirtac_a-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_sirtac_b"(platform: "/") {
            latest_news_type= "alwayson_sirtac_b"
            latest_news_id= "alwayson_sirtac_b-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_sirtac_c"(platform: "/") {
            latest_news_type= "alwayson_sirtac_c"
            latest_news_id= "alwayson_sirtac_c-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }

        "/notification_center/alwayson_sirtac_h"(platform: "/") {
            latest_news_type= "alwayson_sirtac_h"
            latest_news_id= "alwayson_sirtac_h-143816022"
            sent_date = "2018-03-18T16:03:00.009-04:00"
        }
        "/notification_center/billing_mpoff"(platform: "/mobile"){
            newsgroup_id= "billing-mpoff-186785675-76283123"
            latest_news_id= "billing-mpoff-186785675-76283123"
            latest_news_type= "billing_mpoff"
            status= "read"
        }
        "/notification_center/billing_iva_isr_mp"(platform: "/") {
            latest_news_type= "billing_iva_isr_mp"
            latest_news_id= "billing-iva_isr_mp-186785675-20200522"
        }
        "/notification_center/billing_iva_ganancias_reactive"(platform: "/mobile"){
            latest_news_type= "billing_iva_ganancias_reactive"
            latest_news_id= "billing_iva_ganancias_reactive-143816022-MLB1013046714"
        }
        "/notification_center/billing_newtaxhabituality"(platform: "/mobile"){
            latest_news_type= "billing_newtaxhabituality"
            latest_news_id= "billing_newtaxhabituality-143816022-MLB1013046714"
        }
        "/notification_center/billing_newtax"(platform: "/mobile"){
            latest_news_type= "billing_newtax"
            latest_news_id= "billing_newtax-143816022-MLB1013046714"
        }
        "/notification_center/billing_responsable_inscripto_reminder"(platform: "/mobile"){
            latest_news_type= "billing_responsable_inscripto_reminder"
            latest_news_id= "billing_responsable_inscripto_reminder-143816022-MLB1013046714"
        }
        "/notification_center/billing_iva_isr_meli"(platform: "/mobile"){
            latest_news_type= "billing_iva_isr_meli"
            latest_news_id= "billing_iva_isr_meli-143816022-MLB1013046714"
        }
        "/notification_center/buybox_forced_item"(platform: "/mobile"){
            newsgroup_id= "buybox_forced_item-186785675-76283123"
            latest_news_id= "buybox_forced_item-186785675-76283123"
            latest_news_type= "buybox_forced_item"
            status= "read"
        }
        "/notification_center/buybox_forewarning"(platform: "/mobile"){
            newsgroup_id= "buybox_forewarning-186785675-76283123"
            latest_news_id= "buybox_forewarning-186785675-76283123"
            latest_news_type= "buybox_forewarning"
            status= "read"
        }
        "/notification_center/buybox_losing_item"(platform: "/mobile"){
            newsgroup_id= "buybox_losing_item-186785675-76283123"
            latest_news_id= "buybox_losing_item-186785675-76283123"
            latest_news_type= "buybox_losing_item"
            status= "read"
        }
        "/notification_center/buybox_losing_many"(platform: "/mobile"){
            newsgroup_id= "buybox_losing_many-186785675-76283123"
            latest_news_id= "buybox_losing_many-186785675-76283123"
            latest_news_type= "buybox_losing_many"
            status= "read"
        }
        "/notification_center/chargeback_payer_high_agree_repayment_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_high_agree_repayment_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_high_agree_repayment_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_high_agree_repayment_mp"
            case_id = "158213000000"
            status= "read"
        }
        "/notification_center/chargeback_payer_high_n_chargebacks_agree_repayment_mp"(platform: "/mobile"){
            newsgroup_id= "chargeback-payer_high_n_chargebacks_agree_repayment_mp-186785675-76283123"
            latest_news_id= "chargeback-payer_high_n_chargebacks_agree_repayment_mp-186785675-76283123"
            latest_news_type= "chargeback_payer_high_n_chargebacks_agree_repayment_mp"
            case_id = "158213000000"
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
            installment_id = 123
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
        "/notification_center/credits_merchants_em_to_expire_01"(platform: "/mobile") {
            newsgroup_id = "credits_merchants-em_to_expire_01-186785675-76283123"
            latest_news_id = "credits_merchants-em_to_expire_01-186785675-76283123"
            latest_news_type = "credits_merchants_em_to_expire_01"
            status = "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_em_expired_no_charges_today"(platform: "/mobile") {
            newsgroup_id = "credits_merchants_em_expired_no_charges_today-186785675-76283123"
            latest_news_id = "credits_merchants_em_expired_no_charges_today-186785675-76283123"
            latest_news_type = "credits_merchants_em_expired_no_charges_today"
            status = "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_em_expired_daily_charges_01"(platform: "/mobile") {
            newsgroup_id = "credits_merchants_em_expired_daily_charges_01-186785675-76283123"
            latest_news_id = "credits_merchants_em_expired_daily_charges_01-186785675-76283123"
            latest_news_type = "credits_merchants_em_expired_daily_charges_01"
            status = "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_em_expired_daily_charges_04"(platform: "/mobile") {
            newsgroup_id = "credits_merchants_em_expired_daily_charges_04-186785675-76283123"
            latest_news_id = "credits_merchants_em_expired_daily_charges_04-186785675-76283123"
            latest_news_type = "credits_merchants_em_expired_daily_charges_04"
            status = "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_em_expired_daily_charges_07"(platform: "/mobile") {
            newsgroup_id = "credits_merchants_em_expired_daily_charges_07-186785675-76283123"
            latest_news_id = "credits_merchants_em_expired_daily_charges_07-186785675-76283123"
            latest_news_type = "credits_merchants_em_expired_daily_charges_07"
            status = "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_em_expired_daily_charges_10"(platform: "/mobile") {
            newsgroup_id = "credits_merchants_em_expired_daily_charges_10-186785675-76283123"
            latest_news_id = "credits_merchants_em_expired_daily_charges_10-186785675-76283123"
            latest_news_type = "credits_merchants_em_expired_daily_charges_10"
            status = "read"
            installment_id = 123
        }
        "/notification_center/credits_merchants_educational"(platform: "/mobile"){
            newsgroup_id= "credits_merchants-educational-186785675-76283123"
            latest_news_id= "credits_merchants-educational-186785675-76283123"
            latest_news_type= "credits_merchants_educational"
            status= "read"
            loan_id = 123
        }
        "/notification_center/credits_merchants_std_expired_daily_charges_110"(platform: "/mobile"){
            newsgroup_id= "credits_merchants_std_expired_daily_charges_110-186785675-76283123"
            latest_news_id= "credits_merchants_std_expired_daily_charges_110-186785675-76283123"
            latest_news_type= "credits_merchants_std_expired_daily_charges_110"
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
        "/notification_center/fraud_remedies_trust_vote_ml"(platform: "/mobile"){
            newsgroup_id= "fraud_remedies_trust_vote_ml-186785675-76283123"
            latest_news_id= "fraud_remedies_trust_vote_ml-186785675-76283123"
            latest_news_type= "fraud_remedies_trust_vote_ml"
            status= "read"
        }
        "/notification_center/flows_default"(platform: "/mobile"){
            initiative_code= "123"
            latest_news_id= "flows_default-186785675-76283123"
            latest_news_type= "flows_default"
            status= "read"
        }
        "/notification_center/instore_buyer_qr"(platform: "/mobile"){
            newsgroup_id= "instore-buyer_qr-186785675-76283123"
            latest_news_id= "instore-buyer_qr-186785675-76283123"
            latest_news_type= "instore_buyer_qr"
            status= "read"
        }
        "/notification_center/multiplayer_money_request"(platform: "/mobile"){
            newsgroup_id= "multiplayer-money_request-186785675-76283123"
            latest_news_id= "multiplayer-money_request-186785675-76283123"
            latest_news_type= "multiplayer-money_request"
            status= "read"
        }
        "/notification_center/multiplayer_ml_money_request"(platform: "/mobile"){
            newsgroup_id= "multiplayer_ml_money_request-186785675-76283123"
            latest_news_id= "multiplayer_ml_money_request-186785675-76283123"
            latest_news_type= "multiplayer_ml_money_request"
            status= "read"
        }
        "/notification_center/multiplayer_regulation"(platform: "/mobile"){
            newsgroup_id= "multiplayer_regulation-186785675-76283123"
            latest_news_id= "multiplayer_regulation-186785675-76283123"
            latest_news_type= "multiplayer_regulation"
            status= "read"
        }
        "/notification_center/multiplayer_regulation_validated"(platform: "/mobile"){
            newsgroup_id= "multiplayer_regulation_validated-186785675-76283123"
            latest_news_id= "multiplayer_regulation_validated-186785675-76283123"
            latest_news_type= "multiplayer_regulation_validated"
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
        "/notification_center/merchants_growth_resellers"(platform: "/mobile"){
            newsgroup_id= "merchants_growth-resellers-186785675-76283123"
            latest_news_id= "merchants_growth-resellers-186785675-76283123"
            latest_news_type= "merchants_growth_resellers"
            status= "read"
        }
        "/notification_center/merchants_growth_fdv"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_fdv-186785675-76283123"
            latest_news_id= "merchants_growth_fdv-186785675-76283123"
            latest_news_type= "merchants_growth_fdv"
            status= "read"
        }
        "/notification_center/merchants_growth_paper_roll"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_paper_roll-186785675-76283123"
            latest_news_id= "merchants_growth_paper_roll-186785675-76283123"
            latest_news_type= "merchants_growth_paper_roll"
            status= "read"
        }
        "/notification_center/merchants_growth_resellers_smart_launch"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_resellers_smart_launch-186785675-76283123"
            latest_news_id= "merchants_growth_resellers_smart_launch-186785675-76283123"
            latest_news_type= "merchants_growth_resellers_smart_launch"
            status= "read"
        }
        "/notification_center/merchants_growth_sameday"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_sameday-186785675-76283123"
            latest_news_id= "merchants_growth_sameday-186785675-76283123"
            latest_news_type= "merchants_growth_sameday"
            status= "read"
        }
        "/notification_center/merchants_growth_reverse_screening"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_reverse_screening-186785675-76283123"
            latest_news_id= "merchants_growth_reverse_screening-186785675-76283123"
            latest_news_type= "merchants_growth_reverse_screening"
            status= "read"
        }
        "/notification_center/merchants_growth_pricing_point"(platform: "/mobile"){
            newsgroup_id= "merchants_growth_pricing_point-186785675-76283123"
            latest_news_id= "merchants_growth_pricing_point-186785675-76283123"
            latest_news_type= "merchants_growth_pricing_point"
            status= "read"
        }
        "/notification_center/money-transfer_request"(platform: "/mobile"){
            newsgroup_id= "money-transfer_request-186785675-76283123"
            latest_news_id= "money-transfer_request-186785675-76283123"
            latest_news_type= "money-transfer_request"
            status= "read"
        }
        "/notification_center/money_advance"(platform: "/mobile"){
            latest_news_id= "money_advance-186785675-76283123"
            latest_news_type= "money_advance"
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
            campaign_data = "MLB1234"
            sent_date = "20181211"
        }
        "/notification_center/subscription_expiring_notice"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_expiring_notice"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_option = "Citibanamex"
        }
        "/notification_center/subscription_payment_congrats"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_congrats"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_type = 'successful_payment'
            female_gender = true
        }
        "/notification_center/subscription_payment_error"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_error"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            error_type = "card_code"
            female_gender = true
        }
        "/notification_center/subscription_payment_instructions"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_instructions"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_option = "Citibanamex"
            female_gender = true
        }
        "/notification_center/subscription_payment_pending"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_pending"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            female_gender = true
            payment_type = 'successful_payment'
        }
        "/notification_center/subscription_disney_activation_on"(platform: "/mobile") {
            newsgroup_id = "subscription_disney_activation_on-186785675"
            latest_news_id= "subscription_disney_activation_on-186785675"
            latest_news_type= "subscription_disney_activation_on"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification_center/subscription_disney_activation_off"(platform: "/mobile") {
            newsgroup_id = "subscription_disney_activation_off-186785675"
            latest_news_id= "subscription_disney_activation_off-186785675"
            latest_news_type= "subscription_disney_activation_off"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification_center/subscription_disney_activation_free_trial"(platform: "/mobile") {
            newsgroup_id = "subscription_disney_activation_free_trial-186785675"
            latest_news_id= "subscription_disney_activation_free_trial-186785675"
            latest_news_type= "subscription_disney_activation_free_trial"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification/subscription_free_content_level_drop"(platform: "/mobile") {
            news_id = "subscription_free_content_level_drop-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification/subscription_free_content_previous"(platform: "/mobile") {
            news_id = "subscription_free_content_previous-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification_center/subscription_free_content_grace_period"(platform: "/mobile") {
            newsgroup_id = "subscription_free_content_grace_period-186785675"
            latest_news_id= "subscription_free_content_grace_period-186785675"
            latest_news_type= "subscription_free_content_grace_period"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            type = "activate_before"
        }
        "/notification_center/subscription_free_content_level_drop"(platform: "/mobile") {
            newsgroup_id = "subscription_free_content_level_drop-186785675"
            latest_news_id= "subscription_free_content_level_drop-186785675"
            latest_news_type= "subscription_free_content_level_drop"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification_center/subscription_free_content_previous"(platform: "/mobile") {
            newsgroup_id = "subscription_free_content_previous-186785675"
            latest_news_id= "subscription_free_content_previous-186785675"
            latest_news_type= "subscription_free_content_previous"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification_center/subscription_free_content_payment_pending"(platform: "/mobile") {
            newsgroup_id = "subscription_free_content_payment_pending-186785675"
            latest_news_id= "subscription_free_content_payment_pending-186785675"
            latest_news_type= "subscription_free_content_payment_pending"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            type = "activate_before"
        }
        "/notification_center/subscription_free_content_last_day_to_pay"(platform: "/mobile") {
            newsgroup_id = "subscription_free_content_last_day_to_pay-186785675"
            latest_news_id= "subscription_free_content_last_day_to_pay-186785675"
            latest_news_type= "subscription_free_content_last_day_to_pay"
            status= "read"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            type = "activate_before"
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
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_sponsor_campaign_create_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_campaign_create_campaign-143816022-MLB1013046714"
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_sponsor_campaign_web_eligible_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_campaign_web_eligible_campaign-143816022-MLB1013046714"
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_sponsor_campaign_budget_trigger"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor-campaign_budget_trigger-143816022-MLB1013046714"
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_sponsor_campaign_day_trigger"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor-campaign_day_trigger-143816022-MLB1013046714"
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_seller_campaign_start_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_seller-campaign_start_campaign-143816022-MLB1013046714"
        }
        "/notification_center/mp_shipping_label"(platform: "/mobile") {
            latest_news_type= "mp_shipping_label"
            latest_news_id= "mp_shipping_label-143816022-MLB1013046714"
        }
        "/notification_center/mp_shipping_not_delivered"(platform: "/mobile") {
            latest_news_type= "mp_shipping_not_delivered"
            latest_news_id= "mp_shipping_not_delivered-143816022-MLB1013046714"
        }
        "/notification_center/mp_shipping_on_way"(platform: "/mobile") {
            latest_news_type= "mp_shipping_on_way"
            latest_news_id= "mp_shipping_on_way-143816022-MLB1013046714"
        }
        "/notification_center/mp_sponsor_campaign_create_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_campaign_create_campaign-143816022-MLB1013046714"
            campaign_id= "080677f9877e454f917ca55ea1bbbb24"
            end_date= "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/mp_sponsor_campaign_web_eligible_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_sponsor_campaign_web_eligible_campaign-143816022-MLB1013046714"
            campaign_id= "080677f9877e454f917ca55ea1bbbb24"
            end_date= "2019-09-17T12:19:56.234-04:00"
        }
        "/notification_center/card_first_use_incentive"(platform: "/mobile") {
            latest_news_type= "card_first_use_incentive"
            latest_news_id= "card_first_use_incentive-143816022-MLB1013046714"
        }
        "/notification_center/mp_seller_campaign_end_campaign"(platform: "/mobile") {
            latest_news_type= "mpcampaing"
            latest_news_id= "mp_seller-campaign_end_campaign-143816022-MLB1013046714"
        }
        "/notification_center/mp_seller_moderation"(platform: "/mobile") {
            latest_news_type= "mp_seller_moderation"
            latest_news_id= "mp_seller_moderation-143816022-MLB1013046714"
        }
        "/notification_center/mp_seller_campaign_moderation"(platform: "/mobile") {
            latest_news_type= "mp_seller_campaign_moderation"
            latest_news_id= "mp_seller_campaign_moderation-143816022-MLB1013046714"
        }
        "/notification_center/moneyin_debin_approved"(platform: "/") {
            latest_news_type= "moneyin_debin_approved"
            latest_news_id= "moneyin_debin-approved-12345678"
        }
        "/notification_center/moneyin_debin_in_process"(platform: "/") {
            latest_news_type= "moneyin_debin_process"
            latest_news_id= "moneyin_debin-process-12345678"
        }
        "/notification_center/moneyin_debin_rejected"(platform: "/") {
            latest_news_type= "moneyin_debin_rejected"
            latest_news_id= "moneyin_debin-rejected-12345678"
        }
        "/notification_center/mss_gplay"(platform: "/mobile") {
            latest_news_type= "mss_gplay"
            latest_news_id= "mss_gplay-143816022-MLB1013046714"
        }
        "/notification_center/no_maquinables_items_sellers"(platform: "/mobile") {
            latest_news_type= "no_maquinables_items_sellers"
            latest_news_id= "no_maquinables_items_sellers-143816022-MLB1013046714"
        }
        "/notification_center/not_shippable_by_dimensions_items_sellers"(platform: "/mobile") {
            latest_news_type= "not_shippable_by_dimensions_items_sellers"
            latest_news_id= "not_shippable_by_dimensions_items_sellers-143816022-MLB1013046714"
        }
        "/notification_center/flammables_notification"(platform: "/mobile"){
            latest_news_id= "flammables_notification-186785675-76283123"
            latest_news_type= "flammables_notification"
        }
        "/notification_center/growth_tooling_mgm_kyc_booster"(platform: "/mobile"){
            latest_news_id= "growth_tooling_mgm_kyc_booster-186785675-76283123"
            latest_news_type= "growth_tooling_mgm_kyc_booster"
        }
        "/notification_center/growth_tooling_mgm_kyc_guest"(platform: "/mobile"){
            latest_news_id= "growth_tooling_mgm_kyc_guest-186785675-76283123"
            latest_news_type= "growth_tooling_mgm_kyc_guest"
        }
        "/notification_center/kyc_handoff_user_notification_ml"(platform: "/mobile"){
            latest_news_id= "kyc_handoff_user_notification_ml-186785675-76283123"
            latest_news_type= "kyc_handoff_user_notification_ml"
        }
        "/notification_center/kyc_handoff_user_notification_mp"(platform: "/mobile"){
            latest_news_id= "kyc_handoff_user_notification_mp-186785675-76283123"
            latest_news_type= "kyc_handoff_user_notification_mp"
        }
        "/notification_center/kyc_user_notification_mp_web"(platform: "/mobile"){
            latest_news_id= "kyc_user_notification_mp_web-186785675-76283123"
            latest_news_type= "kyc_user_notification_mp_web"
        }
        "/notification_center/kyc_user_notification_mp"(platform: "/mobile"){
            latest_news_id= "kyc_user_notification_mp-186785675-76283123"
            latest_news_type= "kyc_user_notification_mp"
        }
        "/notification_center/kyc_user_notification_ml"(platform: "/mobile"){
            latest_news_id= "kyc_user_notification_ml-186785675-76283123"
            latest_news_type= "kyc_user_notification_ml"
        }
        "/notification_center/kyc_legal_entity_notification_mp"(platform: "/mobile"){
            latest_news_id= "kyc_legal_entity_notification_mp-186785675-76283123"
            latest_news_type= "kyc_legal_entity_notification_mp"
        }
        "/notification_center/kyc_afip_user_notification_mp"(platform: "/mobile"){
            latest_news_id= "kyc_afip_user_notification_mp-186785675-76283123"
            latest_news_type= "kyc_afip_user_notification_mp"
        }
        "/notification_center/kyc_bo_success"(platform: "/mobile"){
            latest_news_id= "kyc_bo_success-186785675-76283123"
            latest_news_type= "kyc_bo_success"
        }
        "/notification_center/killers_winner_item_recover"(platform: "/mobile"){
            latest_news_id= "killers_winner_item_recover-186785675-76283123"
            latest_news_type= "killers_winner_item_recover"
        }
        "/notification_center/killers_winner_item_new"(platform: "/mobile"){
            latest_news_id= "killers_winner_item_new-186785675-76283123"
            latest_news_type= "killers_winner_item_new"
        }
        "/notification_center/killers-winner_item_new"(platform: "/mobile"){
            latest_news_id= "killers-winner_item_new-186785675-76283123"
            latest_news_type= "killers-winner_item_new"
        }
        "/notification_center/killers-winner_item_lost"(platform: "/mobile") {
            latest_news_id= "killers-winner_item_lost-MLA123-19712790"
            latest_news_type= "killers_winner_item_lost"
        }
        "/notification_center/killers_losing_item_buybox"(platform: "/mobile"){
            latest_news_id= "killers_losing_item_buybox-186785675-76283123"
            latest_news_type= "killers_losing_item_buybox"
        }
        "/notification_center/killers_loser_item_new"(platform: "/mobile"){
            latest_news_id= "killers_loser_item_new-186785675-76283123"
            latest_news_type= "killers_loser_item_new"
        }
        "/notification_center/killers-loser_item_new"(platform: "/mobile"){
            latest_news_id= "killers-loser_item_new-186785675-76283123"
            latest_news_type= "killers-loser_item_new"
        }
        "/notification_center/killers-losing_item_buybox"(platform: "/mobile"){
            latest_news_id= "killers-losing_item_buybox-186785675-76283123"
            latest_news_type= "killers-losing_item_buybox"
        }
        "/notification_center/killers-winner_item_recover"(platform: "/mobile"){
            latest_news_id= "killers-winner_item_recover-186785675-76283123"
            latest_news_type= "killers-winner_item_recover"
        }
        "/notification_center/kyc_continue_from_desktop_person_notification_ml"(platform: "/mobile"){
            latest_news_id= "kyc_continue_from_desktop_person_notification_ml-186785675-76283123"
            latest_news_type= "kyc_continue_from_desktop_person_notification_ml"
        }
        "/notification_center/kyc_legal_entity_notification_ml"(platform: "/mobile"){
            latest_news_id= "kyc_legal_entity_notification_ml-186785675-76283123"
            latest_news_type= "kyc_legal_entity_notification_ml"
        }
        "/notification_center/kyc_user_notification_ml_web"(platform: "/mobile"){
            latest_news_id= "kyc_user_notification_ml_web-186785675-76283123"
            latest_news_type= "kyc_user_notification_ml_web"
        }
        "/notification_center/kyc_afip_user_notification_ml"(platform: "/mobile"){
            latest_news_id= "kyc_afip_user_notification_ml-186785675-76283123"
            latest_news_type= "kyc_afip_user_notification_ml"
        }
        "/notification_center/money_split_started"(platform: "/mobile") {
            latest_news_id= "money_split_started-186785675-76283123"
            latest_news_type= "money_split_started"
        }
        "/notification_center/money_split_rejected_push"(platform: "/mobile") {
            latest_news_id= "money_split_rejected_push-186785675-76283123"
            latest_news_type= "money_split_rejected_push"
        }
        "/notification_center/money_split_rejected"(platform: "/mobile") {
            latest_news_id= "money_split_rejected-186785675-76283123"
            latest_news_type= "money_split_rejected"
        }
        "/notification_center/money_split_paid_push"(platform: "/mobile") {
            latest_news_id= "money_split_paid_push-186785675-76283123"
            latest_news_type= "money_split_paid_push"
        }
        "/notification_center/money_split_paid"(platform: "/mobile") {
            latest_news_id= "money_split_paid-186785675-76283123"
            latest_news_type= "money_split_paid"
        }
        "/notification_center/money_request_started"(platform: "/mobile") {
            latest_news_id= "money_request_started-186785675-76283123"
            latest_news_type= "money_request_started"
        }
        "/notification_center/money_request_rejected_push"(platform: "/mobile") {
            latest_news_id= "money_request_rejected_push-186785675-76283123"
            latest_news_type= "money_request_rejected_push"
        }
        "/notification_center/money_request_rejected"(platform: "/mobile") {
            latest_news_id= "money_request_rejected-186785675-76283123"
            latest_news_type= "money_request_rejected"
        }
        "/notification_center/money_request_finished"(platform: "/mobile") {
            latest_news_id= "money_request_finished-186785675-76283123"
            latest_news_type= "money_splmoney_request_finishedit_paid"
        }
        "/notification_center/money_out_cashout"(platform: "/mobile") {
            latest_news_id= "money_out_cashout-186785675-76283123"
            latest_news_type= "money_out_cashout"
        }
        "/notification_center/money_transfer_received"(platform: "/mobile") {
            latest_news_id= "money_transfer_received-186785675-76283123"
            latest_news_type= "money_transfer_received"
        }
        "/notification_center/money_transfer_sender"(platform: "/mobile") {
            latest_news_id= "money-transfer_sender-186785675-1122-993783123"
            latest_news_type= "money_transfer_sender"
        }
        "/notification_center/card_transactions"(platform: "/mobile") {
            latest_news_id= "card_transactions-186785675-76283123"
            latest_news_type= "card_transactions"
        }
        "/notification_center/hub_transfer_new_approved"(platform: "/mobile") {
            latest_news_id= "hub_transfer_new_approved-186785675-76283123"
            latest_news_type= "hub_transfer_new_approved"
        }
        "/notification_center/hub_transfer_manualreview"(platform: "/mobile") {
            latest_news_id= "hub_transfer_manualreview-186785675-76283123"
            latest_news_type= "hub_transfer_manualreview"
        }
        "/notification_center/hub_transfer_new_rejected"(platform: "/mobile") {
            latest_news_id= "hub_transfer_new_rejected-186785675-76283123"
            latest_news_type= "hub_transfer_new_rejected"
        }
        "/notification_center/hub_transfer_rejected"(platform: "/mobile") {
            latest_news_id= "hub_transfer_rejected-186785675-76283123"
            latest_news_type= "hub_transfer_rejected"
        }
        "/notification_center/hub_transfer_screening_one"(platform: "/mobile") {
            latest_news_id= "hub_transfer_screening_one-186785675-76283123"
            latest_news_type= "hub_transfer_screening_one"
        }
        "/notification_center/package-buyer"(platform: "/mobile"){
            latest_news_type= "shipping-rts_in_packing_list"
            latest_news_id= "shipping-rts_in_packing_list-21409256437"
            shipment_id = 21409256437
        }
        "/notification_center/hub_transfer_screening_two"(platform: "/mobile") {
            latest_news_id= "hub_transfer_screening_two-186785675-76283123"
            latest_news_type= "hub_transfer_screening_two"
        }
        "/notification_center/money_split_finished"(platform: "/mobile") {
            latest_news_id= "money_split_finished-186785675-76283123"
            latest_news_type= "money_split_finished"
        }
        "/notification_center/money_request_paid_push"(platform: "/mobile") {
            latest_news_id= "money_request_paid_push-186785675-76283123"
            latest_news_type= "money_request_paid_push"
        }
        "/notification_center/money_request_paid"(platform: "/mobile") {
            latest_news_id= "money_request_paid-186785675-76283123"
            latest_news_type= "money_request_paid"
        }
        "/notification_center/moneyin_cashin_accredited"(platform: "/mobile") {
            latest_news_id= "moneyin_cashin_accredited-186785675-76283123"
            latest_news_type= "moneyin_cashin_accredited"
        }
        "/notification_center/moneyin_cashin_exceeded_cap"(platform: "/mobile") {
            latest_news_id= "moneyin_cashin_exceeded_cap-186785675-76283123"
            latest_news_type= "moneyin_cashin_exceeded_cap"
        }
        "/notification_center/mp_dx_credentials"(platform: "/mobile") {
            latest_news_id= "mp_dx_credentials-186785675-76283123"
            latest_news_type= "mp_dx_credentials"
        }
        "/notification_center/mp_dx_credentials_seller_received_request"(platform: "/mobile") {
            latest_news_id= "mp_dx_credentials_seller_received_request-186785675-76283123"
            latest_news_type= "mp_dx_credentials_seller_received_request"
        }
        "/notification_center/mp_seller_campaign_resume_campaign"(platform: "/mobile") {
            latest_news_id= "mp_seller_campaign_resume_campaign-186785675-76283123"
            latest_news_type= "mp_seller_campaign_resume_campaign"
        }
        "/notification_center/money_out_cashoutmlb_rejected_manualreview"(platform: "/mobile") {
            latest_news_id= "money_out_cashoutmlb_rejected_manualreview-186785675-76283123"
            latest_news_type= "money_out_cashoutmlb_rejected_manualreview"
        }
        "/notification_center/money_out_cashoutmlb_rejected"(platform: "/mobile") {
            latest_news_id= "money_out_cashoutmlb_rejected-186785675-76283123"
            latest_news_type= "money_out_cashoutmlb_rejected"
        }
        "/notification_center/money_out_cashoutmlb_pending"(platform: "/mobile") {
            latest_news_id= "money_out_cashoutmlb_pending-186785675-76283123"
            latest_news_type= "money_out_cashoutmlb_pending"
        }
        "/notification_center/money_out_cashoutmlb_approved"(platform: "/mobile") {
            latest_news_id= "money_out_cashoutmlb_approved-186785675-76283123"
            latest_news_type= "money_out_cashoutmlb_approved"
        }
        "/notification_center/money_out_cashout_withdrawn"(platform: "/mobile") {
            latest_news_id= "money_out_cashout_withdrawn-186785675-76283123"
            latest_news_type= "money_out_cashout_withdrawn"
        }
        "/notification_center/money_out_cashout_reversed"(platform: "/mobile") {
            latest_news_id= "money_out_cashout_reversed-186785675-76283123"
            latest_news_type= "money_out_cashout_reversed"
        }
        "/notification_center/money_in_cashin_exceeded_cap"(platform: "/mobile") {
            latest_news_id= "money_in_cashin_exceeded_cap-186785675-76283123"
            latest_news_type= "money_in_cashin_exceeded_cap"
        }
        "/notification_center/money_request_started"(platform: "/mobile") {
            latest_news_id= "money_request_started-186785675-76283123"
            latest_news_type= "money_request_started"
        }
        "/notification_center/money_request_rejected_push"(platform: "/mobile") {
            latest_news_id= "money_request_rejected_push-186785675-76283123"
            latest_news_type= "money_request_rejected_push"
        }
        "/notification_center/money_request_rejected"(platform: "/mobile") {
            latest_news_id= "money_request_rejected-186785675-76283123"
            latest_news_type= "money_request_rejected"
        }
        "/notification_center/money_request_finished"(platform: "/mobile") {
            latest_news_id= "money_request_finished-186785675-76283123"
            latest_news_type= "money_request_finished"
        }
        "/notification_center/money_out_cashout"(platform: "/mobile") {
            latest_news_id= "money_out_cashout-186785675-76283123"
            latest_news_type= "money_out_cashout"
        }
        "/notification_center/card_request_challenge"(platform: "/mobile"){
            newsgroup_id= "card_request_challenge-pending-186785675-76283123"
            latest_news_id= "card_request_challenge-pending-186785675-76283123"
            latest_news_type= "card_request_challenge-pending"
            status= "read"
        }
        "/notification_center/card_correios_strike"(platform: "/mobile"){
            newsgroup_id= "card_correios_strike-delayed-186785675-76283123"
            latest_news_id= "card_correios_strike-delayed-186785675-76283123"
            latest_news_type= "card_correios_strike-delayed"
            status= "read"
        }
        "/notification_center/card_flow_incentive"(platform: "/mobile"){
            newsgroup_id= "card_flow_incentive-186785675-76283123"
            latest_news_id= "card_flow_incentive-186785675-76283123"
            latest_news_type= "card_flow_incentive"
            status= "read"
        }
        "/notification_center/card_flow_incentive_prepaid_acquisition_first"(platform: "/mobile"){
            newsgroup_id= "card_flow_incentive_prepaid_acquisition_first-186785675-76283123"
            latest_news_id= "card_flow_incentive_prepaid_acquisition_first-186785675-76283123"
            latest_news_type= "card_flow_incentive_prepaid_acquisition_first"
            status= "read"
        }
        "/notification_center/card_flow_incentive_prepaid_acquisition_second"(platform: "/mobile"){
            newsgroup_id= "card_flow_incentive_prepaid_acquisition_second-186785675-76283123"
            latest_news_id= "card_flow_incentive_prepaid_acquisition_second-186785675-76283123"
            latest_news_type= "card_flow_incentive_prepaid_acquisition_second"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed_nfc_acquisition"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed_nfc_acquisition-186785675-76283123"
            latest_news_id= "card_kyc_data_completed_nfc_acquisition-186785675-76283123"
            latest_news_type= "card_kyc_data_completed_nfc_acquisition"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed_prepaid_acquisition_first"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed_prepaid_acquisition_first-186785675-76283123"
            latest_news_id= "card_kyc_data_completed_prepaid_acquisition_first-186785675-76283123"
            latest_news_type= "card_kyc_data_completed_prepaid_acquisition_first"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed_prepaid_acquisition_second"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed_prepaid_acquisition_second-186785675-76283123"
            latest_news_id= "card_kyc_data_completed_prepaid_acquisition_second-186785675-76283123"
            latest_news_type= "card_kyc_data_completed_prepaid_acquisition_second"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed_prepaid_acquisition_third"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed_prepaid_acquisition_third-186785675-76283123"
            latest_news_id= "card_kyc_data_completed_prepaid_acquisition_third-186785675-76283123"
            latest_news_type= "card_kyc_data_completed_prepaid_acquisition_third"
            status= "read"
        }
        "/notification_center/card_nip"(platform: "/mobile"){
            newsgroup_id= "card_nip-186785675-76283123"
            latest_news_id= "card_nip-186785675-76283123"
            latest_news_type= "card_nip"
            status= "read"
        }
        "/notification_center/card_reminders_virtual_digital_services"(platform: "/mobile"){
            newsgroup_id= "card_reminders_virtual_digital_services-186785675-76283123"
            latest_news_id= "card_reminders_virtual_digital_services-186785675-76283123"
            latest_news_type= "card_reminders_virtual_digital_services"
            status= "read"
        }
        "/notification_center/card_subscription"(platform: "/mobile"){
            newsgroup_id= "card_subscription-186785675-76283123"
            latest_news_id= "card_subscription-186785675-76283123"
            latest_news_type= "card_subscription"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_fifteenth_day"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_fifteenth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_fifteenth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_fifteenth_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_fifth_day"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_fifth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_fifth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_fifth_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_twentyfifth_day"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_twentyfifth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_twentyfifth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_twentyfifth_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_zero_day"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_zero_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_zero_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_zero_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_zero_day_known_person"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_zero_day_known_person-186785675-76283123"
            latest_news_id= "card_unlock_incentive_zero_day_known_person-186785675-76283123"
            latest_news_type= "card_unlock_incentive_zero_day_known_person"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_zero_day_owner"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_zero_day_owner-186785675-76283123"
            latest_news_id= "card_unlock_incentive_zero_day_owner-186785675-76283123"
            latest_news_type= "card_unlock_incentive_zero_day_owner"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_zero_day_point"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_zero_day_point-186785675-76283123"
            latest_news_id= "card_unlock_incentive_zero_day_point-186785675-76283123"
            latest_news_type= "card_unlock_incentive_zero_day_point"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_zero_day_somewhere"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_zero_day_somewhere-186785675-76283123"
            latest_news_id= "card_unlock_incentive_zero_day_somewhere-186785675-76283123"
            latest_news_type= "card_unlock_incentive_zero_day_somewhere"
            status= "read"
        }
        "/notification_center/card_freeze"(platform: "/mobile"){
            newsgroup_id= "card_freeze-186785675-76283123"
            latest_news_id= "card_freeze-186785675-76283123"
            latest_news_type= "card_freeze"
            status= "read"
        }
        "/notification_center/card_limit"(platform: "/mobile"){
            newsgroup_id= "card_limit-186785675-76283123"
            latest_news_id= "card_limit-186785675-76283123"
            latest_news_type= "card_limit"
            status= "read"
        }
        "/notification_center/card_pin"(platform: "/mobile"){
            newsgroup_id= "card_pin-186785675-76283123"
            latest_news_id= "card_pin-186785675-76283123"
            latest_news_type= "card_pin"
            status= "read"
        }
        "/notification_center/card_reminders"(platform: "/mobile"){
            newsgroup_id= "card_reminders-186785675-76283123"
            latest_news_id= "card_reminders-186785675-76283123"
            latest_news_type= "card_reminders"
            status= "read"
        }
        "/notification_center/card_request_challenge"(platform: "/mobile"){
            newsgroup_id= "card_request_challenge-186785675-76283123"
            latest_news_id= "card_request_challenge-186785675-76283123"
            latest_news_type= "card_request_challenge"
            status= "read"
        }
        "/notification_center/card_wallet"(platform: "/mobile"){
            newsgroup_id= "card_wallet-186785675-76283123"
            latest_news_id= "card_wallet-186785675-76283123"
            latest_news_type= "card_wallet"
            status= "read"
        }
        "/notification_center/card_offering_physical_card"(platform: "/mobile"){
            newsgroup_id= "card_offering_physical_card-186785675-76283123"
            latest_news_id= "card_offering_physical_card-186785675-76283123"
            latest_news_type= "card_offering_physical_card"
            status= "read"
        }
        "/notification_center/card_offering_transaction_generic_opt_in_ppd_to_hybrid"(platform: "/mobile"){
            newsgroup_id= "card_offering_transaction_generic_opt_in_ppd_to_hybrid-186785675-76283123"
            latest_news_id= "card_offering_transaction_generic_opt_in_ppd_to_hybrid-186785675-76283123"
            latest_news_type= "card_offering_transaction_generic_opt_in_ppd_to_hybrid"
            status= "read"
        }
        "/notification_center/card_offering_transaction_opt_in_ppd_to_hybrid"(platform: "/mobile"){
            newsgroup_id= "card_offering_transaction_opt_in_ppd_to_hybrid-186785675-76283123"
            latest_news_id= "card_offering_transaction_opt_in_ppd_to_hybrid-186785675-76283123"
            latest_news_type= "card_offering_transaction_opt_in_ppd_to_hybrid"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-virtual-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-virtual-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-virtual"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-unlock-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-unlock-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-unlock"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-physical_acquisition-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-physical_acquisition-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-physical_acquisition"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-prepaid_acquisition_first-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-prepaid_acquisition_first-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-prepaid_acquisition_first"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-prepaid_acquisition_second-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-prepaid_acquisition_second-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-prepaid_acquisition_second"
            status= "read"
        }
        "/notification_center/card_kyc_data_completed"(platform: "/mobile"){
            newsgroup_id= "card_kyc_data_completed-prepaid_acquisition_third-186785675-76283123"
            latest_news_id= "card_kyc_data_completed-prepaid_acquisition_third-186785675-76283123"
            latest_news_type= "card_kyc_data_completed-prepaid_acquisition_third"
            status= "read"
        }
        "/notification_center/card_unlock_incentive"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive-zero_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive-zero_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive-zero_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive_second_day"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_second_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_second_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_second_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_fifth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_fifth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_fifth_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_fifteenth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_fifteenth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_fifteenth_day"
            status= "read"
        }
        "/notification_center/card_unlock_incentive"(platform: "/mobile"){
            newsgroup_id= "card_unlock_incentive_twentyfifth_day-186785675-76283123"
            latest_news_id= "card_unlock_incentive_twentyfifth_day-186785675-76283123"
            latest_news_type= "card_unlock_incentive_twentyfifth_day"
            status= "read"
        }
        "/notification_center/cashoutmlb_rejected_manualreview"(platform: "/mobile"){
            newsgroup_id= "cashoutmlb_rejected_manualreview-186785675-76283123"
            latest_news_id= "cashoutmlb_rejected_manualreview-186785675-76283123"
            latest_news_type= "cashoutmlb_rejected_manualreview"
            status= "read"
        }
        "/notification_center/chargeback_payer_high_agree_repayment_ml"(platform: "/mobile"){
            newsgroup_id= "chargeback_payer_high_agree_repayment_ml-186785675-76283123"
            latest_news_id= "chargeback_payer_high_agree_repayment_ml-186785675-76283123"
            latest_news_type= "chargeback_payer_high_agree_repayment_ml"
            status= "read"
            case_id= "123"
        }
        "/notification_center/card_delivery_tracking"(platform: "/mobile"){
            newsgroup_id= "card_delivery_tracking-soon_deliver-186785675-76283123"
            latest_news_id= "card_delivery_tracking-soon_deliver-186785675-76283123"
            latest_news_type= "card_delivery_tracking-soon_deliver"
            status= "read"
            branch_time_elapsed = true
        }
        "/notification_center/card_prepaid_tracking"(platform: "/mobile"){
            newsgroup_id= "card_prepaid_tracking-soon_deliver-186785675-76283123"
            latest_news_id= "card_prepaid_tracking-soon_deliver-186785675-76283123"
            latest_news_type= "card_prepaid_tracking-soon_deliver"
            status= "read"
            branch_case = true
        }
        "/notification_center/claim"(platform: "/mobile"){
            newsgroup_id= "claim_186785675-76283123"
            latest_news_id= "claim_186785675-76283123"
            latest_news_type= "claim_186785675-76283123"
            status= "read"
        }
        "/notification_center/fraud_kyc_validation"(platform: "/mobile") {
            latest_news_type= "fraud_kyc_validation"
            latest_news_id= "fraud-kyc_validation-186785675"
        }
        "/notification_center/fraud_remedies_identity_start_second_score"(platform: "/mobile") {
            newsgroup_id= "fraud_remedies_identity_start_second_score-222222222-123456789"
            latest_news_id= "fraud_remedies_identity_start_second_score-222222222-123456789"
            latest_news_type = "fraud_remedies_identity_start_second_score"
            status= "read"
        }
        "/notification_center/fraud_remedies_identity_reminder_second_score"(platform: "/mobile") {
            newsgroup_id= "fraud_remedies_identity_reminder_second_score-222222222-123456789"
            latest_news_id= "fraud_remedies_identity_reminder_second_score-222222222-123456789"
            latest_news_type = "fraud_remedies_identity_reminder_second_score"
            status= "read"
        }
        "/notification_center/fraud_remedies_card_start_second_score"(platform: "/mobile") {
            newsgroup_id= "fraud_remedies_card_start_second_score-222222222-123456789"
            latest_news_id= "fraud_remedies_card_start_second_score-222222222-123456789"
            latest_news_type = "fraud_remedies_card_start_second_score"
            status= "read"
        }
        "/notification_center/fraud_remedies_card_reminder_second_score"(platform: "/mobile") {
            newsgroup_id= "fraud_remedies_card_reminder_second_score-222222222-123456789"
            latest_news_id= "fraud_remedies_card_reminder_second_score-222222222-123456789"
            latest_news_type = "fraud_remedies_card_reminder_second_score"
            status= "read"
        }
        "/notification_center/prepaid_card"(platform: "/mobile"){
            newsgroup_id= "prepaid_card-delayed_p1-186785675-76283123"
            latest_news_id= "prepaid_card-delayed_p1-186785675-76283123"
            latest_news_type= "prepaid_card_delayed_p1"
            status= "read"
        }

        "/notification_center/prepaid_card_reprogrammed"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_reprogrammed-186785675-76283123"
            latest_news_id= "prepaid_card_reprogrammed-186785675-76283123"
            latest_news_type= "prepaid_card_reprogrammed"
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
        "/notification_center/transaction_rejected_withdraw_by_invalid_amount_for_fee"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_withdraw_by_invalid_amount_for_fee-186785675-76283123"
            latest_news_id= "transaction_rejected_withdraw_by_invalid_amount_for_fee-186785675-76283123"
            latest_news_type= "transaction_rejected_withdraw_by_invalid_amount_for_fee"
            status= "read"
        }
        "/notification_center/transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee-186785675-76283123"
            latest_news_id= "transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee-186785675-76283123"
            latest_news_type= "transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee"
            status= "read"
        }
        "/notification_center/prepaid_card_transaction_rejected_activation_reminder"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_transaction_rejected_activation_reminder-186785675-76283123"
            latest_news_id= "prepaid_card_transaction_rejected_activation_reminder-186785675-76283123"
            latest_news_type= "prepaid_card_transaction_rejected_activation_reminder"
            status= "read"
        }
        "/notification_center/prepaid_card_reprogrammed"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_reprogrammed-186785675-76283123"
            latest_news_id= "prepaid_card_reprogrammed-186785675-76283123"
            latest_news_type= "prepaid_card_reprogrammed"
            status= "read"
        }
        "/notification_center/prepaid_card_challenge_bolbradesco_reminder"(platform: "/mobile"){
            newsgroup_id= "prepaid_card_challenge_bolbradesco_reminder-186785675-76283123"
            latest_news_id= "prepaid_card_challenge_bolbradesco_reminder-186785675-76283123"
            latest_news_type= "prepaid_card_challenge_bolbradesco_reminder"
            status= "read"
        }
        "/notification/prepaid_card_transaction_rejected_international_authorization_by_invalid_amount"(platform: "/mobile"){
            news_id = "prepaid_card_transaction_rejected_international_authorization_by_invalid_amount-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_international_authorization_by_fraud_prevention"(platform: "/mobile"){
            news_id = "prepaid_card_transaction_rejected_international_authorization_by_fraud_prevention-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_by_kyc"(platform: "/mobile"){
            news_id = "prepaid_card_transaction_rejected_by_kyc-51AO96HEQ"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_compliant_kyc"(platform: "/mobile"){
            news_id = "prepaid_card_compliant_kyc-51AO96HEQ"
            event_type = "arrived"
            notification_type= "deep_linking"
        }

        "/notification_center/single_player_utility_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_utility_success_mp"
            latest_news_id= "single_player_utility_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_utility_fail_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_utility_fail_mp"
            latest_news_id= "single_player_utility_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_transport_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_transport_success_mp"
            latest_news_id= "single_player_transport_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_transport_fail_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_transport_fail_mp"
            latest_news_id= "single_player_transport_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_prepaid_toll_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_prepaid_toll_success_mp"
            latest_news_id= "single_player_prepaid_toll_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_prepaid_toll_fail_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_prepaid_toll_fail_mp"
            latest_news_id= "single_player_prepaid_toll_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_antenna_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_antenna_success_mp"
            latest_news_id= "single_player_antenna_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_balance_expiration_transport_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_balance_expiration_transport_mp"
            latest_news_id= "single_player_balance_expiration_transport_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_antenna_fail_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_antenna_fail_mp"
            latest_news_id= "single_player_antenna_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_expired_debt_utility_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_expired_debt_utility_mp"
            latest_news_id= "single_player_expired_debt_utility_mp-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/single_player_generic_balance_expiration"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_generic_balance_expiration"
            latest_news_id= "single_player_generic_balance_expiration-143816022-MLB1013046714"
        }
        "/notification_center/single_player_new_debt_utility_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_new_debt_utility_mp"
            latest_news_id= "single_player_new_debt_utility_mp-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/single_player_payment_reminder_new_grouped_debt"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payment_reminder_new_grouped_debt"
            latest_news_id= "single_player_payment_reminder_new_grouped_debt-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/single_player_payment_reminder_new_solo_debt"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payment_reminder_new_solo_debt"
            latest_news_id= "single_player_payment_reminder_new_solo_debt-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/single_player_payg_unlock_device_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_unlock_device_mp"
            latest_news_id= "single_player_payg_unlock_device_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_new_debt_without_block_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_new_debt_without_block_mp"
            latest_news_id= "single_player_payg_new_debt_without_block_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_create_device_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_create_device_success_mp"
            latest_news_id= "single_player_payg_create_device_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_create_device_fail_mp"(platform: "/mobile") {
            latest_news_type= "single_player_payg_create_device_fail_mp"
            latest_news_id= "single_player-payg_create_device_fail_mp-315571651-5678-1479249799770"
        }
        "/notification_center/single_player_payg_blocked_device_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_blocked_device_mp"
            latest_news_id= "single_player_payg_blocked_device_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_cashback_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_cashback_mp"
            latest_news_id= "single_player_payg_cashback_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_change_device_number_success_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_change_device_number_success_mp"
            latest_news_id= "single_player_payg_change_device_number_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payg_change_device_number_fail_mp"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payg_change_device_number_fail_mp"
            latest_news_id= "single_player_payg_change_device_number_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility"
            latest_news_id= "single_player_scheduled_payment_utility-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_grouped_rejected"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_grouped_rejected"
            latest_news_id= "single_player_scheduled_payment_utility_grouped_rejected-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_grouped_reminder"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_grouped_reminder"
            latest_news_id= "single_player_scheduled_payment_utility_grouped_reminder-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_grouped_success"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_grouped_success"
            latest_news_id= "single_player_scheduled_payment_utility_grouped_success-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_solo_rejected"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_solo_rejected"
            latest_news_id= "single_player_scheduled_payment_utility_solo_rejected-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_solo_reminder"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_solo_reminder"
            latest_news_id= "single_player_scheduled_payment_utility_solo_reminder-143816022-MLB1013046714"
        }
        "/notification_center/single_player_scheduled_payment_utility_solo_success"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_scheduled_payment_utility_solo_success"
            latest_news_id= "single_player_scheduled_payment_utility_solo_success-143816022-MLB1013046714"
        }
        "/notification_center/single_player_payment_reminder_expiring_grouped_debt"(platform: "/", type: TrackType.Event) {
            latest_news_type= "single_player_payment_reminder_expiring_grouped_debt"
            latest_news_id= "single_player_payment_reminder_expiring_grouped_debt-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/transaction_rejected_international_authorization_by_invalid_amount"(platform: "/mobile"){
            latest_news_type= "transaction_rejected_international_authorization_by_invalid_amount"
            latest_news_id= "transaction_rejected_international_authorization_by_invalid_amount-143816022-MLB1013046714"
        }
        "/notification_center/transaction_invalid_amount_option_credit"(platform: "/mobile"){
            latest_news_type= "transaction_invalid_amount_option_credit"
            latest_news_id= "transaction_invalid_amount_option_credit-143816022-MLB1013046714"
        }
        "/notification_center/point_qr_login_new"(platform: "/mobile") {
            latest_news_type= "point_qr_login_new"
            latest_news_id= "point-qr_login_new-a34rb3"
        }
        "/notification_center/point_fill_in"(platform: "/mobile") {
            latest_news_type= "point_fill_in"
            latest_news_id= "point-fill_in-a34rb3"
        }
        "/notification_center/promotions_msg"(platform: "/mobile") {
            latest_news_type= "promotions_msg"
            latest_news_id= "promotions-msg-a34rb3"
        }
        "/notification_center/promotions_volume"(platform: "/mobile") {
            latest_news_type= "promotions_volume"
            latest_news_id= "promotions-volume-a34rb3"
        }
        "/notification_center/protected_purchase_order_reminder_purchase_protection"(platform: "/mobile") {
            latest_news_type= "protected_purchase_order_reminder_purchase_protection"
            latest_news_id= "protected_purchase-order_reminder_purchase_protection-a34rb3"
        }
        "/notification_center/transaction_rejected_authorization_by_invalid_amount"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_authorization_by_invalid_amount-186785675-76283123"
            latest_news_id= "transaction_rejected_authorization_by_invalid_amount-186785675-76283123"
            latest_news_type= "transaction_rejected_authorization_by_invalid_amount"
            status= "read"
        }
        "/notification_center/transaction_rejected_authorization_contactless_freeze_decorator"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_authorization_contactless_freeze_decorator-186785675-76283123"
            latest_news_id= "transaction_rejected_authorization_contactless_freeze_decorator-186785675-76283123"
            latest_news_type= "transaction_rejected_authorization_contactless_freeze_decorator"
            status= "read"
        }
        "/notification_center/transfer_online_approved"(platform: "/mobile"){
            newsgroup_id= "transfer_online_approved-186785675-76283123"
            latest_news_id= "transfer_online_approved-186785675-76283123"
            latest_news_type= "transfer_online_approved"
            status= "read"
        }
        "/notification_center/transfer_online_rejected"(platform: "/mobile"){
            newsgroup_id= "transfer_online_rejected-186785675-76283123"
            latest_news_id= "transfer_online_rejected-186785675-76283123"
            latest_news_type= "transfer_online_rejected"
            status= "read"
        }
        "/notification_center/transfer_online_scheduled"(platform: "/mobile"){
            newsgroup_id= "transfer_online_scheduled-186785675-76283123"
            latest_news_id= "transfer_online_scheduled-186785675-76283123"
            latest_news_type= "transfer_online_scheduled"
            status= "read"
        }
        "/notification_center/transaction_rejected_withdraw_by_invalid_amount"(platform: "/mobile"){
            newsgroup_id= "transaction_rejected_withdraw_by_invalid_amount-186785675-76283123"
            latest_news_id= "transaction_rejected_withdraw_by_invalid_amount-186785675-76283123"
            latest_news_type= "transaction_rejected_withdraw_by_invalid_amount"
            status= "read"
        }

        "/notification_center/shipping_moderation_cross_docking_release_below"(platform: "/mobile"){
            latest_news_type= "shipping_moderation_cross_docking_release_below"
            latest_news_id= "shipping_moderation_cross_docking_release_below-143816022-MLB1013046714"
        }
        "/notification_center/shipping_proximity"(platform: "/mobile"){
            latest_news_type= "shipping_proximity"
            latest_news_id= "shipping_proximity-143816022-MLB1013046714"
        }
        "/notification_center/shipping_scoring_keyword_created"(platform: "/mobile"){
            latest_news_type= "shipping_scoring_keyword_created"
            latest_news_id= "shipping_scoring_keyword_created-143816022-MLB1013046714"
            shipment_id = 123
        }
        "/notification_center/shipping_shipped_out_for_delivery"(platform: "/mobile"){
            latest_news_type= "shipping_shipped_out_for_delivery"
            latest_news_id= "shipping_shipped_out_for_delivery-143816022-MLB1013046714"
            shipment_id = 123
        }
        "/notification_center/shipping_shipped_soon_deliver"(platform: "/mobile"){
            latest_news_type= "shipping_shipped_soon_deliver"
            latest_news_id= "shipping_shipped_soon_deliver-143816022-MLB1013046714"
            shipment_id = 123
        }
        "/notification_center/shipping_special_milkrun"(platform: "/mobile"){
            latest_news_type= "shipping_special_milkrun"
            latest_news_id= "shipping_special_milkrun-143816022-MLB1013046714"
        }
        "/notification_center/shipping_moderation_cross_docking_recovery"(platform: "/mobile"){
            latest_news_type= "shipping_moderation_cross_docking_recovery"
            latest_news_id= "shipping_moderation_cross_docking_recovery-143816022-MLB1013046714"
        }
        "/notification_center/shipping_moderation_cross_docking_downgrade"(platform: "/mobile"){
            latest_news_type= "shipping_moderation_cross_docking_downgrade"
            latest_news_id= "shipping_moderation_cross_docking_downgrade-143816022-MLB1013046714"
        }
        "/notification_center/buyer_absent_driver_action"(platform: "/mobile"){
            latest_news_type= "buyer_absent_driver_action"
            latest_news_id= "buyer_absent_driver_action-143816022-MLB1013046714"
            shipment_id = 123
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
        "/notification_center/point_qr_login_new"(platform: "/mobile") {
            latest_news_type= "point_qr_login_new"
            latest_news_id= "point-qr_login_new-a34rb3"
        }
        "/notification_center/point_fill_in"(platform: "/mobile") {
            latest_news_type= "point_fill_in"
            latest_news_id= "point-fill_in-a34rb3"
        }
        "/notification_center/promotions_msg"(platform: "/mobile") {
            latest_news_type= "promotions_msg"
            latest_news_id= "promotions-msg-a34rb3"
        }
        "/notification_center/promotions_volume"(platform: "/mobile") {
            latest_news_type= "promotions_volume"
            latest_news_id= "promotions-volume-a34rb3"
        }
        "/notification_center/protected_purchase_order_reminder_purchase_protection"(platform: "/mobile") {
            latest_news_type= "protected_purchase_order_reminder_purchase_protection"
            latest_news_id= "protected_purchase-order_reminder_purchase_protection-a34rb3"
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
            latest_news_type= "withdraw_rejected_contingency"
            latest_news_id= "withdraw_rejected_contingency-143816022-MLB1013046714"
        }
        "/notification_center/withdraw_approved"(platform: "/mobile") {
            latest_news_type= "withdraw_approved"
            latest_news_id= "withdraw_approved-143816022-MLB1013046714"
        }
        "/notification_center/withdraw_rejected"(platform: "/mobile") {
            latest_news_type= "withdraw_rejected"
            latest_news_id= "withdraw_rejected-143816022-MLB1013046714"
        }
        "/notification_center/wallet_connect_binding_error"(platform: "/") {
            latest_news_type= "wallet_connect_binding_error"
            latest_news_id= "wallet_connect-binding_error-84060496"
        }
        "/notification_center/wallet_connect_binding_with_card_and_cash"(platform: "/") {
            latest_news_type= "wallet_connect_binding_with_card_and_cash"
            latest_news_id= "wallet_connect-binding_with_card_and_cash-84060496"
        }
        "/notification_center/wallet_connect_binding_with_cash"(platform: "/") {
            latest_news_type= "wallet_connect_binding_with_cash"
            latest_news_id= "wallet_connect-binding_with_cash-84060496"
        }
        "/notification_center/wallet_connect_rejected_payment"(platform: "/") {
            latest_news_type= "wallet_connect_rejected_payment"
            latest_news_id= "wallet_connect-rejected_payment-84060496"
        }
        "/notification_center/wallet_integrator_insufficient_amount"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator-insufficient_amount-186785675-76283123"
            latest_news_id= "wallet_integrator-insufficient_amount-186785675-76283123"
            latest_news_type= "wallet_integrator_insufficient_amount"
            status= "read"
        }
        "/notification_center/wallet_integrator_payment_success"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator-payment_success-186785675-76283123"
            latest_news_id= "wallet_integrator-payment_success-186785675-76283123"
            latest_news_type= "wallet_integrator_payment_success"
            status= "read"
        }
        "/notification_center/wallet_integrator_insufficient_funds"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator-insufficient_funds-186785675-76283123"
            latest_news_id= "wallet_integrator-insufficient_funds-186785675-76283123"
            latest_news_type= "wallet_integrator_insufficient_funds"
            status= "read"
        }
        "/notification_center/wallet_integrator_personal_loan"(platform: "/mobile"){
            newsgroup_id= "wallet_integrator_personal_loan-186785675-76283123"
            latest_news_id= "wallet_integrator_personal_loan-186785675-76283123"
            latest_news_type= "wallet_integrator_personal_loan"
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
            latest_news_type= "seller_journey_congrats"
            latest_news_id= "seller_journey_congrats-143816022-MLB1013046714"
        }
        "/notification_center/seller_journey_keep_it_up"(platform: "/mobile"){
            step_id= 123
            latest_news_type= "seller_journey_keep_it_up"
            latest_news_id= "seller_journey_keep_it_up-143816022-MLB1013046714"
        }
        "/notification_center/seller_journey_work_harder"(platform: "/mobile"){
            step_id= 123
            latest_news_type= "seller_journey_work_harder"
            latest_news_id= "seller_journey_work_harder-143816022-MLB1013046714"
        }
        "/notification_center/seller_journey_do_something"(platform: "/mobile"){
            step_id= 123
            latest_news_type= "seller_journey_work_harder"
            latest_news_id= "seller_journey_work_harder-143816022-MLB1013046714"
        }

        "/notification_center/single_player_directv_smartcard_expiration"(platform: "/") {
            latest_news_type= "single_player_directv_smartcard_expiration"
            latest_news_id= "single_player_directv_smartcard_expiration-143816022-MLB1013046714"
        }

        "/notification_center/single_player_payment_reminder"(platform: "/") {
            latest_news_type= "single_player_payment_reminder"
            latest_news_id= "single_player_payment_reminder-143816022-MLB1013046714"
            debt_id=123
        }
        "/notification_center/single_player_recharge_fail_ml"(platform: "/") {
            latest_news_type= "single_player_recharge_fail_ml"
            latest_news_id= "single_player_recharge_fail_ml-143816022-MLB1013046714"
        }
        "/notification_center/single_player_recharge_success_ml"(platform: "/") {
            latest_news_type= "single_player_recharge_success_ml"
            latest_news_id= "single_player_recharge_success_ml-143816022-MLB1013046714"
        }
        "/notification_center/single_player_recharge_fail_mp"(platform: "/") {
            latest_news_type= "single_player_recharge_fail_mp"
            latest_news_id= "single_player_recharge_fail_mp-143816022-MLB1013046714"
        }
        "/notification_center/single_player_recharge_success_mp"(platform: "/") {
            latest_news_type= "single_player_recharge_success_mp"
            latest_news_id= "single_player_recharge_success_mp-143816022-MLB1013046714"
        }
        "/notification_center/moneyin_cca_approved"(platform: "/") {
            latest_news_type= "moneyin_cca_approved"
            latest_news_id= "moneyin_cca-approved-12345678"
        }
        "/notification_center/moneyin_cca_rejected"(platform: "/") {
            latest_news_type= "moneyin_cca_rejected"
            latest_news_id= "moneyin_cca-rejected-12345678"
        }

        "/notification_center/moneyin_open_finance_approved"(platform: "/") {
            latest_news_type= "moneyin_open_finance_approved"
            latest_news_id= "moneyin_open_finance-approved-12345678"
        }
        "/notification_center/moneyin_open_finance_in_process"(platform: "/") {
            latest_news_type= "moneyin_open_finance_rejected"
            latest_news_id= "moneyin_open_finance-rejected-12345678"
        }
        "/notification_center/moneyin_open_finance_rejected"(platform: "/") {
            latest_news_type= "moneyin_open_finance_rejected"
            latest_news_id= "moneyin_open_finance-rejected-12345678"
        }

        "/notification_center/disbursement_kwai_received"(platform: "/") {
            latest_news_type= "disbursement_kwai_received"
            latest_news_id= "disbursement_kwai-received-12345678"
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

        "/notification/account_fund_approved_ml"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_ml-12345678"
            event_type = "shown"
        }
        "/notification/account_fund_approved_mlc_tc"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_ml_tc-12345678"
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

        "/notification/account_fund_active_disabled_clabe"(platform: "/mobile") {
            news_id = "account_fund_active_disabled_clabe-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_bank_transfer"(platform: "/mobile") {
            news_id = "account_fund_bank_transfer-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_iv_cvu_spb"(platform: "/mobile") {
            news_id = "account_fund_iv_cvu_spb-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_pending_clabe"(platform: "/mobile") {
            news_id = "account_fund_pending_clabe-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_ticket"(platform: "/mobile") {
            news_id = "account_fund_ticket-12345678"
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
        //Always On

        "/notification/alwayson_bsasa"(platform: "/") {
            news_id = "alwayson-bsasa-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_bsash"(platform: "/") {
            news_id = "alwayson-bsash-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_cabaa"(platform: "/") {
            news_id = "alwayson-cabaa-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_cabab"(platform: "/") {
            news_id = "alwayson-cabab-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_cabac"(platform: "/") {
            news_id = "alwayson-cabac-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_cabah"(platform: "/") {
            news_id = "alwayson-cabah-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_ivaa"(platform: "/") {
            news_id = "alwayson-ivaa-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_ivab"(platform: "/") {
            news_id = "alwayson-ivab-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_ivah"(platform: "/") {
            news_id = "alwayson-ivah-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_sirtaca"(platform: "/") {
            news_id = "alwayson-sirtaca-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_sirtacb"(platform: "/") {
            news_id = "alwayson-sirtacb-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_sirtacc"(platform: "/") {
            news_id = "alwayson-sirtacc-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/alwayson_sirtach"(platform: "/") {
            news_id = "alwayson-sirtach-186785675"
            sent_date = "2018-03-18T16:03:00.009-04:00"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/account_balance_create_ted_account"(platform: "/mobile") {
            news_id = "account_balance_create_ted_account-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_overlimit_active"(platform: "/") {
            news_id = "credit_card_overlimit_active-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_overlimit_inactive"(platform: "/") {
            news_id = "credit_card_overlimit_inactive-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_transaction_chout_purchase"(platform: "/") {
            news_id = "credit_card-transaction_chout_purchase-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_10"(platform: "/") {
            news_id = "credit_card-waitlist_10-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_40"(platform: "/") {
            news_id = "credit_card-waitlist_40-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_blacklist"(platform: "/") {
            news_id = "credit_card-waitlist_blacklist-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_collection_due_in_10"(platform: "/mobile") {
            news_id = "credit_card_collection_due_in_10-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_due_in_05"(platform: "/mobile") {
            news_id = "credit_card_collection_due_in_05-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_due_in_01"(platform: "/mobile") {
            news_id = "credit_card_collection_due_in_01-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_due_in_00"(platform: "/mobile") {
            news_id = "credit_card_collection_due_in_00-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_01"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_01-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_04"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_04-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_05"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_05-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_10"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_10-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_15"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_15-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_19"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_19-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_20"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_20-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_29"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_29-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_30"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_30-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_50"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_50-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_53"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_53-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_collection_expired_58"(platform: "/mobile") {
            news_id = "credit_card_collection_expired_58-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_acquisition"(platform: "/mobile") {
            news_id = "credit_card_transaction_acquisition-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_choff_purchase"(platform: "/mobile") {
            news_id = "credit_card_transaction_choff_purchase-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_statement_payment"(platform: "/mobile") {
            news_id = "credit_card_transaction_statement_payment-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_purchase"(platform: "/mobile") {
            news_id = "credit_card_transaction_purchase-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_withdrawal"(platform: "/mobile") {
            news_id = "credit_card_transaction_withdrawal-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_transaction_kyc_onboarding"(platform: "/mobile") {
            news_id = "credit_card_transaction_kyc_onboarding-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_thirdth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_thirdth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_thirdth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_thirdth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_fourteenth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_fourteenth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_seventh_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_seventh_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_twentyoneth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_twentyoneth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_flow_incentive_prepaid_acquisition_first"(platform: "/mobile") {
            news_id = "card_flow_incentive_prepaid_acquisition_first-12345678"
            event_type = "shown"
        }
        "/notification/card_flow_incentive_prepaid_acquisition_second"(platform: "/mobile") {
            news_id = "card_flow_incentive_prepaid_acquisition_second-12345678"
            event_type = "shown"
        }
        "/notification/card_freeze_rejected_withdraw"(platform: "/mobile") {
            news_id = "card_freeze_rejected_withdraw-12345678"
            event_type = "shown"
        }
        "/notification/card_limit_rejected_withdraw_by_limit"(platform: "/mobile") {
            news_id = "card_limit_rejected_withdraw_by_limit-12345678"
            event_type = "shown"
        }
        "/notification/card_limit_rejected_withdraw_by_maximum_limit"(platform: "/mobile") {
            news_id = "card_limit_rejected_withdraw_by_maximum_limit-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_invalid_pin_first_tries"(platform: "/mobile") {
            news_id = "card_pin_invalid_pin_first_tries-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_invalid_pin_fourth_try"(platform: "/mobile") {
            news_id = "card_pin_invalid_pin_fourth_try-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_pin_blocked"(platform: "/mobile") {
            news_id = "card_pin_pin_blocked-12345678"
            event_type = "shown"
        }
        "/notification/card_reminders_pin_reminder"(platform: "/mobile") {
            news_id = "card_reminders_pin_reminder-12345678"
            event_type = "shown"
        }
        "/notification/card_reminders_virtual_digital_services"(platform: "/mobile") {
            news_id = "card_reminders_virtual_digital_services-12345678"
            event_type = "shown"
        }
        "/notification/card_request_challenge_expired"(platform: "/mobile") {
            news_id = "card_request_challenge_expired-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_physical_card"(platform: "/mobile") {
            news_id = "card_offering_physical_card-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_transaction_generic_opt_in_ppd_to_hybrid"(platform: "/mobile") {
            news_id = "card_offering_transaction_generic_opt_in_ppd_to_hybrid-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_transaction_opt_in_ppd_to_hybrid"(platform: "/mobile") {
            news_id = "card_offering_transaction_opt_in_ppd_to_hybrid-12345678"
            event_type = "shown"
        }
        "/notification/card_transactions_approved_authorization_whatsapp"(platform: "/mobile") {
            news_id = "card_transactions-approved_authorization_whatsapp-debit_authorization_1ba2b28e8a12db8c1c7e27e7c07fd7ns6a28"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_fund_money_in_whatsapp"(platform: "/mobile") {
            news_id = "card_transactions-fund_money_in_whatsapp-debit_authorization_1ba2b28e8a12db8c1c7e27e7c07fd7ns6a28"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_virtual_already_cancelled"(platform: "/mobile") {
            news_id = "card_transactions-rejected_authorization_virtual_already_cancelled-95AO96H14JInssK6rdZvm1r3Zwv20yFesI1bhlDmv1rj4LrpP0Sn8nQ5pbT35Ti9"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_virtual_inactive"(platform: "/mobile") {
            news_id = "card_transactions-rejected_authorization_virtual_inactive-95AO96H14JInssK6rdZvm1r3Zwv20yFesI1bhlDmv1rj4LrpP0Sn8nQ5pbT35Ti9"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_withdraw_international_by_invalid_amount"(platform: "/mobile") {
            news_id = "card_transactions-rejected_withdraw_international_by_invalid_amount-95AO96H14JInssK6rdZvm1r3Zwv20yFesI1bhlDmv1rj4LrpP0Sn8nQ5pbT35Ti9"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification_center/credit_card_adhoc_communication"(platform: "/") {
            latest_news_type= "credit_card_adhoc_communication"
            latest_news_id= "credit_card-adhoc_communication-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_collection"(platform: "/") {
            latest_news_type= "credit_card_collection"
            latest_news_id= "credit_card-collection-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_overlimit"(platform: "/") {
            latest_news_type= "credit_card_overlimit"
            latest_news_id= "credit_card_overlimit-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_transaction_acquisition"(platform: "/") {
            latest_news_type= "credit_card_transaction_acquisition"
            latest_news_id= "credit_card_transaction_acquisition-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_transaction_choff_purchase"(platform: "/") {
            latest_news_type= "credit_card_transaction_choff_purchase"
            latest_news_id= "credit_card_transaction_choff_purchase-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_transaction_purchase"(platform: "/") {
            latest_news_type= "credit_card_transaction_purchase"
            latest_news_id= "credit_card_transaction_purchase-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_transaction_statement_payment"(platform: "/") {
            latest_news_type= "credit_card_transaction_statement_payment"
            latest_news_id= "credit_card_transaction_statement_payment-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_transaction_withdrawal"(platform: "/") {
            latest_news_type= "credit_card_transaction_withdrawal"
            latest_news_id= "credit_card_transaction_withdrawal-148801678-free-annuity-20211405"
        }
        "/notification_center/credit_card_waitlist"(platform: "/") {
            latest_news_type= "credit_card_waitlist"
            latest_news_id= "credit_card_waitlist-148801678-free-annuity-20211405"
        }
        "/notification_center/credits_merchants_spl_congrats"(platform: "/") {
            latest_news_type= "credits_merchants_spl_congrats"
            latest_news_id= "credits_merchants_spl_congrats-148801678-free-annuity-20211405"
        }
        "/notification_center/credits_merchants_spl_expired_0_ws"(platform: "/") {
            latest_news_type= "credits_merchants_spl_expired_0_ws"
            latest_news_id= "credits_merchants_spl_expired_0_ws-148801678-free-annuity-20211405"
        }
        "/notification_center/credits_merchants_spl_expired_30_ws"(platform: "/") {
            latest_news_type= "credits_merchants_spl_expired_30_ws"
            latest_news_id= "credits_merchants_spl_expired_30_ws-148801678-free-annuity-20211405"
        }
        "/notification_center/credits_merchants_std_expired_daily_charges_75"(platform: "/") {
            latest_news_type= "credits_merchants_std_expired_daily_charges_75"
            latest_news_id= "credits_merchants_std_expired_daily_charges_75-148801678-free-annuity-20211405"
        }
        "/notification/anses_payment_date"(platform: "/mobile") {
            news_id = "anses_payment_date-12345678-123"
            event_type = "shown"
        }

        "/notification/anses_paid_benefit"(platform: "/mobile") {
            news_id = "anses_paid_benefit-12345678-123"
            event_type = "shown"
        }

        "/notification/addresses_update_bad_address"(platform: "/mobile") {
            news_id = "addresses_update_bad_address-12345678-123"
            event_type = "shown"
        }

        "/notification/addresses_update_bad_address_delivered"(platform: "/mobile") {
            news_id = "addresses_update_bad_address_delivered-12345678-123"
            event_type = "shown"
        }

        "/notification/billing_iva_ganancias_reactive"(platform: "/mobile"){
            news_id = "billing_iva_ganancias_reactive-12345678-123"
            event_type = "shown"
        }
        "/notification/billing_newtaxhabituality"(platform: "/mobile"){
            news_id = "billing_newtaxhabituality-12345678-123"
            event_type = "shown"
        }
        "/notification/billing_newtax"(platform: "/mobile"){
            news_id = "billing_newtax-12345678-123"
            event_type = "shown"
        }
        "/notification/billing_responsable_inscripto_reminder"(platform: "/mobile"){
            news_id = "billing_responsable_inscripto_reminder-12345678-123"
            event_type = "shown"
        }
        "/notification/billing_iva_isr_meli"(platform: "/mobile"){
            news_id = "billing_iva_isr_meli-12345678-123"
            event_type = "shown"
        }
        "/notification/billing_iva_isr"(platform: "/") {
            news_id = "billing-iva_isr_mp-186785675-20200522"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/billing_iva_isr_mp"(platform: "/") {
            news_id = "billing-iva_isr_mp-186785675-20200522"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/buybox_forced_item"(platform: "/mobile"){
            news_id = "buybox_forced_item-12345678-123"
            event_type = "shown"
        }
        "/notification/buybox_forewarning"(platform: "/mobile"){
            news_id = "buybox_forewarning-12345678-123"
            event_type = "shown"
        }
        "/notification/buybox_losing_item"(platform: "/mobile"){
            news_id = "buybox_losing_item-12345678-123"
            event_type = "shown"
        }
        "/notification/buybox_losing_many"(platform: "/mobile"){
            news_id = "buybox_losing_many-12345678-123"
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
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
        }

        "/notification/campaigns_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
        }
        "/notification/mpcampaigns_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
        }

        "/notification/institutional_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
        }
        "/notification/mpinstitutional_sms"(platform: "/"){
            segment_name= "segment"
            experiment_name= "experiment"
            communication_data = "{\"item_id\":\"MLB12345\"}"
            communication_id= "TESTa0cf-c3c7-488c-b07e-0728be370bb0"
            campaign_type= "ADHOC"
            sent_date= "20180508"
            event_type= "sent"
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

        "/notification/campaigns_schedule"(platform: "/") {
            news_id = "12332323"
            event_type = "open"
            notification_type= "deep_linking"
            campaign_id = "MLB22"
            campaign_type = "xp_cupones"
            campaign_data = "{\"item_id\":\"MLB12345\"}"
            batch_id = "actividad"
            test_notification = false
            send_health_check = false
            schedule_date = "2021-09-30T16:03:00.009-04:00"
            schedule_id = "schedule_id_test"
            sent_date = "20180516"
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
        "/notification/chargeback_payer_high_agree_repayment_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_high_agree_repayment_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }
        "/notification/chargeback_payer_high_n_chargebacks_agree_repayment_ml"(platform: "/mobile") {
            news_id = "chargeback_payer_high_n_chargebacks_agree_repayment_ml-21680059-20180516"
            event_type = "shown"
            case_id = "158213000000"
        }

        "/notification/credits_consumer_expired_n_loans_fourth_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_fourth_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/chargeback_payer_high_agree_repayment_mp"(platform: "/mobile") {
            news_id = "chargeback-payer_high_agree_repayment_mp-14363307744123"
            event_type = "shown"
            case_id = "158213000000"
            notification_type= "deep_linking"
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
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_about_to_expire_first_notice"(platform: "/mobile") {
            news_id = "credits_consumer_about_to_expire_first_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_last_notice"(platform: "/mobile") {
            news_id = "credits_consumer_expired_last_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_mp_first_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_mp_first_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_mp_fortyfive_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_mp_fortyfive_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_mp_fourth_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_mp_fourth_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_mp_second_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_mp_second_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_mp_third_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_mp_third_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_sixty_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_sixty_mp_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_first_time_use_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_first_time_use_mp_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_on_due_day_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_on_due_day_mp_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_expired_n_loans_last_notice"(platform: "/mobile") {
            news_id = "credits_consumer_expired_n_loans_last_notice-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_on_due_day_notice"(platform: "/mobile") {
            news_id = "credits_consumer_on_due_day_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_expired_sixty_notice"(platform: "/mobile") {
            news_id = "credits-consumer_expired_n_loans_third_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_about_to_expire_n_loans_first_notice"(platform: "/mobile") {
            news_id = "credits-consumer_about_to_expire_n_loans_first_notice-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_opt_in_telcel_data_privacy"(platform: "/mobile") {
            news_id = "credits_consumer-opt_in_telcel_data_privacy-21680059-20180516"
            event_type = "shown"
        }

        "/notification/credits_consumer_congrats_microlines"(platform: "/mobile") {
            news_id = "credits-credits_consumer_congrats_microlines-21680059-20180516"
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

        "/notification/credits_consumer_expired_sixty_notice"(platform: "/mobile") {
            news_id = "credits_consumer_expired_sixty_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_expired_fortyfive_notice"(platform: "/mobile") {
            news_id = "credits_consumer_expired_fortyfive_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }

        "/notification/credits_consumer_about_to_expire_first_notice"(platform: "/mobile") {
            news_id = "credits_consumer_about_to_expire_first_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_about_to_expire_first_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_about_to_expire_first_mp_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_about_to_expire_mp_second_notice"(platform: "/mobile") {
            news_id = "credits-consumer_about_to_expire_mp_second_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_closing_date_mp_notice"(platform: "/mobile") {
            news_id = "credits-consumer_closing_date_mp_notice-186785675-20180409"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_congrats_personal_loans"(platform: "/mobile") {
            news_id = "credits_consumer_congrats_personal_loans-21680059-20180516"
            event_type = "shown"
        }
        "/notification/credits_consumer_expired_last_notice"(platform: "/mobile") {
            news_id = "credits_consumer_expired_last_notice-21680059-20180516"
            event_type = "shown"
            installment_id= 9876
            loan_id= 12345433
        }
        "/notification/credits_consumer_on_due_day_notice"(platform: "/mobile") {
            news_id = "credits_consumer_on_due_day_notice-21680059-20180516"
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
        "/notification/credit_card_adhoc_communication"(platform: "/") {
            news_id = "credit_card-adhoc_communication-148801678-free-annuity-20211405"
            event_type = "dismiss"
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

        "/notification/instore_buyer_qr"(platform: "/mobile"){
            news_id = "instore-buyer_qr-321953606"
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

        "/notification/me_crowd_multiple_offers_available"(platform: "/mobile"){
            news_id = "me_crowd-multiple_offers_available-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_upcoming_trip_forewarn"(platform: "/mobile"){
            news_id = "me_crowd_upcoming_trip_forewarn-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_canceled_order_warning"(platform: "/mobile"){
            news_id = "me_crowd_canceled_order_warning-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/messages_driver_flex"(platform: "/mobile"){
            news_id = "messages-driver_flex-321953606"
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

        "/notification/me_flex_rehunting_generic"(platform: "/mobile"){
            news_id = "me_flex_rehunting_generic-315571651"
            event_type = "sent"
        }

        "/notification/me_flex_rehunting_address"(platform: "/mobile"){
            news_id = "me_flex_rehunting_address-315571651"
            event_type = "sent"
        }

        "/notification/me_flex_rehunting_reputation"(platform: "/mobile"){
            news_id = "me_flex-rehunting_reputation-315571651"
            event_type = "sent"
        }

        "/notification/me_flex_hunting_generic"(platform: "/mobile"){
            news_id = "me_flex_hunting_generic-315571651"
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

        //Money Advance
        "/notification/money_advance_congrats"(platform: "/mobile"){
            news_id = "money_advance_congrats-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_advance_fail"(platform: "/mobile"){
            news_id = "money_advance_fail-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_started"(platform: "/mobile"){
            news_id = "money_split_started-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_rejected_push"(platform: "/mobile"){
            news_id = "money_split_rejected_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_rejected"(platform: "/mobile"){
            news_id = "money_split_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_paid_push"(platform: "/mobile"){
            news_id = "money_split_paid_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_paid"(platform: "/mobile"){
            news_id = "money_split_paid-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_started"(platform: "/mobile"){
            news_id = "money_request_started-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_rejected_push"(platform: "/mobile") {
            news_id = "money_request_rejected_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_rejected"(platform: "/mobile") {
            news_id = "money_request_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_finished"(platform: "/mobile") {
            news_id = "money_request_finished-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashout"(platform: "/mobile") {
            news_id = "money_out_cashout-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_split_finished"(platform: "/mobile") {
            news_id = "money_split_finished-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_paid_push"(platform: "/mobile") {
            news_id = "money_request_paid_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashoutmlb_rejected_manualreview"(platform: "/mobile") {
            news_id = "money_out_cashoutmlb_rejected_manualreview-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashoutmlb_rejected"(platform: "/mobile") {
            news_id = "money_out_cashoutmlb_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashoutmlb_pending"(platform: "/mobile") {
            news_id = "money_out_cashoutmlb_pending-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashoutmlb_approved"(platform: "/mobile") {
            news_id = "money_out_cashoutmlb_approved-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashout_withdrawn"(platform: "/mobile") {
            news_id = "money_out_cashout_withdrawn-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashout_reversed"(platform: "/mobile") {
            news_id = "money_out_cashout_reversed-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_in_cashin_exceeded_cap"(platform: "/mobile") {
            news_id = "money_in_cashin_exceeded_cap-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_started"(platform: "/mobile"){
            news_id = "money_request_started-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_rejected_push"(platform: "/mobile"){
            news_id = "money_request_rejected_push-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_rejected"(platform: "/mobile"){
            news_id = "money_request_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_request_finished"(platform: "/mobile"){
            news_id = "money_request_finished-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/money_out_cashout"(platform: "/mobile"){
            news_id = "money_out_cashout-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }

        "/notification/moneyin_cashin_accredited"(platform: "/mobile") {
            news_id = "moneyin_cashin_accredited-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/moneyin_cashin_rejected"(platform: "/mobile") {
            news_id = "moneyin_cashin_rejected-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }

        "/notification/multiplayer_money_request"(platform: "/mobile"){
            news_id = "multiplayer-money_request-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/multiplayer_ml_money_request"(platform: "/mobile"){
            news_id = "multiplayer_ml_money_request-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/multiplayer_regulation"(platform: "/mobile"){
            news_id = "multiplayer_regulation-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
        }
        "/notification/multiplayer_regulation_validated"(platform: "/mobile"){
            news_id = "multiplayer_regulation_validated-1004906131-ACAVAUNHASHRELINDOYRELOCO"
            event_type = "open"
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
            communication_id = "test"
            sent_date = "20180516"
            batch_id = "RECOVERY_CHECKOUT_MLB_60m-65m"
            deal_id = "RMK_MCO"
            execution_id = 123456
        }
        "/notification/campaigns_control_group"(platform: "/mobile") {
            news_id = "CIbDQhDb3hMYCQ==-5e22992d1b3518a"
            event_type = "discarded"
            campaign_id = "RECOVERY_CHECKOUT_MLB_60m-65m_20180516_CG"
            communication_id = "test"
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
        "/notification/quotes_answer_send"(platform: "/mobile") {
            news_id = "quotes_answer_send-123"
            event_type = "open"
        }
        "/notification/quotes_answer_pending"(platform: "/mobile") {
            news_id = "quotes_answer_pending-123"
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
        "/notification/orders_deliver_confirmation_newbie_seller"(platform: "/mobile") {
            news_id = "orders-deliver_confirmation_newbie_seller-1004906131"
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
        "/notification/orders_ticket_boleto_payment_pending"(platform: "/mobile") {
            news_id = "orders-ticket_boleto_payment_pending-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            device_status = "not_engaged"
            order_id = 1957429460
        }
        "/notification/orders_ticket_payment_pending"(platform: "/mobile") {
            news_id = "orders_ticket_payment_pending-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            device_status = "not_engaged"
            order_id = 1957429460
        }
        "/notification/orders_ticket_payment_pending_day_expiration_general_notice"(platform: "/mobile") {
            news_id = "orders-ticket_payment_pending_day_expiration_general_notice-1957429460"
            event_type = "dismiss"
            experiment_id = "TICKET_RECOVERY_MLA_20190312_PROD"
            notification_style = "c"
            device_id = "f140e3faf4c6ee7d"
            device_status = "not_engaged"
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
        "/notification/payments_ticket_boleto_pending_reminder"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            order_id = 12132
            item_id = "MLA122211"
        }
        "/notification/purchase_invoice"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }
        "/notification/partners_pin_ml"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            partner= "123"
        }
        "/notification/partners_pin_mp"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            partner= "123"
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

        "/notification/single_player_directv_smartcard_expiration"(platform: "/mobile") {
            news_id = "single_player_directv_smartcard_expiration_123"
            event_type = "open"
        }
        "/notification/single_player_payment_reminder"(platform: "/mobile") {
            news_id = "single_player_payment_reminder_123"
            event_type = "open"
            debt_id=123
        }
        "/notification/single_player_recharge_fail_ml"(platform: "/mobile") {
            news_id = "single_player_recharge_fail_ml_123"
            event_type = "open"
        }
        "/notification/single_player_recharge_success_ml"(platform: "/mobile") {
            news_id = "single_player_recharge_success_ml_123"
            event_type = "open"
        }
        "/notification/single_player_recharge_fail_mp"(platform: "/mobile") {
            news_id = "single_player_recharge_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_recharge_success_mp"(platform: "/mobile") {
            news_id = "single_player_recharge_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_utility_success_mp"(platform: "/mobile") {
            news_id = "single_player_utility_success_mp_123"
            event_type = "open"
        }

        "/notification/single_player_utility_fail_mp"(platform: "/mobile") {
            news_id = "single_player_utility_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_utility_success_mp"(platform: "/mobile") {
            news_id = "single_player_utility_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_utility_refused_am"(platform: "/mobile") {
            news_id = "single_player_utility_refused_am-123"
            event_type = "open"
        }
        "/notification/single_player_utility_refused_cc"(platform: "/mobile") {
            news_id = "single_player_utility_refused_cc-123"
            event_type = "open"
        }
        "/notification/single_player_transport_success_mp"(platform: "/mobile") {
            news_id = "single_player_transport_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_transport_fail_mp"(platform: "/mobile") {
            news_id = "single_player_transport_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_prepaid_toll_success_mp"(platform: "/mobile") {
            news_id = "single_player_prepaid_toll_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_prepaid_toll_fail_mp"(platform: "/mobile") {
            news_id = "single_player_prepaid_toll_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_antenna_fail_mp"(platform: "/mobile") {
            news_id = "single_player_antenna_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_new_debt_utility_mp"(platform: "/mobile") {
            news_id = "single_player_new_debt_utility_mp_123"
            event_type = "open"
            debt_id=123
        }
        "/notification/single_player_expired_debt_utility_mp"(platform: "/mobile") {
            news_id = "single_player_expired_debt_utility_mp_123"
            event_type = "open"
            debt_id=123
        }
        "/notification/single_player_antenna_success_mp"(platform: "/mobile") {
            news_id = "single_player_antenna_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_balance_expiration_transport_mp"(platform: "/mobile") {
            news_id = "single_player_balance_expiration_transport_mp_123"
            event_type = "open"
        }
        "/notification/single_player_generic_balance_expiration"(platform: "/mobile") {
            news_id = "single_player_generic_balance_expiration_123"
            event_type = "open"
        }
        "/notification/single_player_payment_reminder_new_grouped_debt"(platform: "/mobile") {
            news_id = "single_player_payment_reminder_new_grouped_debt_123"
            event_type = "open"
            debt_id=123
        }
        "/notification/single_player_payment_reminder_new_solo_debt"(platform: "/mobile") {
            news_id = "single_player_payment_reminder_new_solo_debt"
            event_type = "open"
            debt_id=123
        }
        "/notification/single_player_payg_unlock_device_mp"(platform: "/mobile") {
            news_id = "single_player_payg_unlock_device_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_new_debt_without_block_mp"(platform: "/mobile") {
            news_id = "single_player_payg_new_debt_without_block_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_create_device_success_mp"(platform: "/mobile") {
            news_id = "single_player_payg_create_device_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_create_device_fail_mp"(platform: "/mobile") {
            news_id = "single_player-payg_create_device_fail_mp-315571651-5678-1479249799770"
            event_type = "open"
        }
        "/notification/single_player_payg_blocked_device_mp"(platform: "/mobile") {
            news_id = "single_player_payg_blocked_device_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_cashback_mp"(platform: "/mobile") {
            news_id = "single_player_payg_cashback_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_change_device_number_success_mp"(platform: "/mobile") {
            news_id = "single_player_payg_change_device_number_success_mp_123"
            event_type = "open"
        }
        "/notification/single_player_payg_change_device_number_fail_mp"(platform: "/mobile") {
            news_id = "single_player_payg_change_device_number_fail_mp_123"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_grouped_rejected"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_grouped_rejected"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_grouped_reminder"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_grouped_reminder"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_grouped_success"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_grouped_success"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_solo_rejected"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_solo_rejected"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_solo_reminder"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_solo_reminder"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_pixtransfer_grouped_insufficient_amount"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_pixtransfer_grouped_insufficient_amount"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_pixtransfer_solo_insufficient_amount"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_pixtransfer_solo_insufficient_amount"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_pixtransfer_grouped_reminder"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_pixtransfer_grouped_reminder"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_pixtransfer_solo_reminder"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_pixtransfer_solo_reminder"
            event_type = "open"
        }
        "/notification/single_player_scheduled_payment_utility_solo_success"(platform: "/mobile") {
            news_id = "single_player_scheduled_payment_utility_solo_success"
            event_type = "open"
        }
        "/notification/single_player_payment_reminder_expiring_grouped_debt"(platform: "/mobile") {
            news_id = "single_player_payment_reminder_expiring_grouped_debt_123"
            event_type = "open"
            debt_id=123
        }

        "/notification/point_pos_closed"(platform: "/mobile") {
            news_id = "point_pos_closed-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/point_pos_close_soon"(platform: "/mobile") {
            news_id = "point_pos_close_soon-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/point_pix"(platform: "/mobile") {
            news_id = "point_pix-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/point_improvement"(platform: "/mobile") {
            news_id = "point_improvement-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/point_voucher_sodexo"(platform: "/mobile") {
            news_id = "point_voucher_sodexo-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/mp_shipping_label"(platform: "/mobile"){
            news_id="mp_shipping-label-788142312"
            event_type="arrived"
            notification_type="deep_linking"
        }
        "/notification/mp_shipping_on_way"(platform:"/mobile"){
            news_id="mp_shipping-on_way-789827052"
            event_type="arrived"
            notification_type="deep_linking"
        }
        "/notification/mp_shipping_not_delivered"(platform: "/mobile"){
            news_id="mp_shipping-not_delivered-788142312"
            event_type="arrived"
            notification_type="deep_linking"
        }
        "/notification/mp_shipping_label"(platform: "/mobile"){
            news_id="mp_shipping-label-788142312"
            event_type="arrived"
            notification_type="deep_linking"
        }
        "/notification/pix_transfer_mo_rejected"(platform: "/mobile") {
            news_id = "pix_transfer_mo_rejected-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_transfer_mo_manual_review"(platform: "/mobile") {
            news_id = "pix_transfer_mo_manual_review-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_transfer_mi_approved"(platform: "/mobile") {
            news_id = "pix_transfer_mi_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_transfer_mo_approved"(platform: "/mobile") {
            news_id = "pix_transfer_mo_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_portability_request"(platform: "/mobile") {
            news_id = "pix_key_portability_request-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_portability_rejected"(platform: "/mobile") {
            news_id = "pix_key_portability_rejected-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_portability_approved"(platform: "/mobile") {
            news_id = "pix_key_portability_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_claim_request"(platform: "/mobile") {
            news_id = "pix_key_claim_request-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_claim_rejected"(platform: "/mobile") {
            news_id = "pix_key_claim_rejected-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_claim_key_expired"(platform: "/mobile") {
            news_id = "pix_key_claim_key_expired-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_claim_key_deleted"(platform: "/mobile") {
            news_id = "pix_key_claim_key_deleted-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/pix_key_claim_approved"(platform: "/mobile") {
            news_id = "pix_key_claim_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/shipping_shipped"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_shipped_same_day"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_soon_deliver_same_day"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_shipped_partial_cancellations"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_delivered_partial_cancellations"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_rts_in_packing_list"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_shipped_out_for_delivery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_shipped_outside_me"(platform: "/mobile") {
            news_id = "shipping_shipped_outside_me-12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_shipped_retained_sender"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_shipped_soon_deliver"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }

        "/notification/shipping_delivered"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_express_return"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_without_express_return"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_express_return"(platform: "/mobile") {
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
        "/notification/shipping_wrong_address_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_shipped_withdrawal_to_agency_places"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_shipped_to_agency_places"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_reminder_places_withdrawal"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_not_delivered_waiting_for_withdrawal"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_not_delivered_soon_to_be_returned"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_cart_without_express_return"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_delivered_cart_express_return"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_buyer_absent_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_handling_agency_unavailable"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_wrong_address_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_agency_receiver_for_failed_delivery"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }

        "/notification/shipping_moderation_cross_docking_release_below"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/shipping_moderation_cross_docking_recovery"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/shipping_moderation_cross_docking_downgrade"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
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

        "/notification/protected_purchase_order_reminder_purchase_protection"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }

        "/notification/mediations_complainant"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
        }

        "/notification/mediations_v2_pdd_dispute_with_timeout_buyer"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
        }

        "/notification/mediations_v2_pdd_dispute_elected_action_reminder_buyer"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "auto_dismiss"
            notification_style = "BigTextStyle"
            claim_id = 3123
            action_type = "favorite"
        }

        "/notification/mediations_v2_pdd_dispute_without_timeout_buyer"(platform: "/mobile") {
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
            news_id = "mediations_v2-respondent-1013715421-5b0d7ee426e063333fe0c582"
            event_type = "shown"
            notification_style = "c"
            claim_id = 1013715459
        }

        "/notification/mediations_v2_pdd_dispute_with_timeout_seller"(platform: "/mobile") {
            news_id = "mediations_v2-pdd_dispute_with_timeout_seller-1013715421-5b0d7ee426e063333fe0c582"
            event_type = "shown"
            notification_style = "c"
            claim_id = 1013715459
        }

        "/notification/mediations_v2_pdd_dispute_without_timeout_seller"(platform: "/mobile") {
            news_id = "mediations_v2-pdd_dispute_without_timeout_seller-1013715421-5b0d7ee426e063333fe0c582"
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

        /* ============================================================ */
        /* Team: IT Payments - Payroll | Initiative: Salary Portability */
        /*                       contact: payroll-devs@mercadolibre.com */
        "/notification/payroll_portability_request_accepted"(platform: "/mobile") {
            news_id = "payroll-portability_request_accepted-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_accepted"(platform: "/mobile") {
            news_id = "payroll-portability_request_accepted-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_accepted"(platform: "/mobile") {
            news_id = "payroll-portability_request_accepted-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_denied"(platform: "/mobile") {
            news_id = "payroll-portability_request_denied-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_denied"(platform: "/mobile") {
            news_id = "payroll-portability_request_denied-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_denied"(platform: "/mobile") {
            news_id = "payroll-portability_request_denied-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_failed"(platform: "/mobile") {
            news_id = "payroll-portability_request_failed-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_failed"(platform: "/mobile") {
            news_id = "payroll-portability_request_failed-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_failed"(platform: "/mobile") {
            news_id = "payroll-portability_request_failed-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_integrated"(platform: "/mobile") {
            news_id = "payroll-portability_request_integrated-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_integrated"(platform: "/mobile") {
            news_id = "payroll-portability_request_integrated-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_request_integrated"(platform: "/mobile") {
            news_id = "payroll-portability_request_integrated-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_request_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        // Portability
        "/notification/payroll_portability_first_salary"(platform: "/mobile") {
            news_id = "payroll-portability_first_salary-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_first_salary"(platform: "/mobile") {
            news_id = "payroll-portability_first_salary-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_first_salary"(platform: "/mobile") {
            news_id = "payroll-portability_first_salary-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_ted_rejected"(platform: "/mobile") {
            news_id = "payroll-portability_ted_rejected-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "open"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_ted_rejected"(platform: "/mobile") {
            news_id = "payroll-portability_ted_rejected-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "dismiss"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_ted_rejected"(platform: "/mobile") {
            news_id = "payroll-portability_ted_rejected-d869c411-b7c5-4b1b-944f-7b90b15912c0"
            event_type = "auto_dismiss"
            portability_id = "d869c411-b7c5-4b1b-944f-7b90b15912c0"
        }

        "/notification/payroll_portability_disabled"(platform: "/mobile") {
            news_id = "payroll-portability_disabled-492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
            event_type = "open"
            portability_id = "492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
        }

        "/notification/payroll_portability_first_notice"(platform: "/mobile") {
            news_id = "payroll-portability_first_notice-492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
            event_type = "open"
            portability_id = "492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
        }

        "/notification/payroll_portability_second_notice"(platform: "/mobile") {
            news_id = "payroll-portability_second_notice-492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
            event_type = "open"
            portability_id = "492db5c7-4111-4e49-85c3-ee8d7fbf63fb"
        }

        // KYC
        "/notification/payroll_kyc_accepted"(platform: "/mobile") {
            news_id = "payroll-kyc_accepted-1234"
            event_type = "open"
        }

        "/notification/payroll_kyc_accepted"(platform: "/mobile") {
            news_id = "payroll-kyc_accepted-1234"
            event_type = "dismiss"
        }

        "/notification/payroll_kyc_accepted"(platform: "/mobile") {
            news_id = "payroll-kyc_accepted-1234"
            event_type = "auto_dismiss"
        }

        "/notification/payroll_kyc_approved"(platform: "/mobile") {
            news_id = "payroll_kyc_approved-1234"
            event_type = "open"
        }

        "/notification/payroll_kyc_approved"(platform: "/mobile") {
            news_id = "payroll_kyc_approved-1234"
            event_type = "dismiss"
        }

        "/notification/payroll_kyc_approved"(platform: "/mobile") {
            news_id = "payroll_kyc_approved-1234"
            event_type = "auto_dismiss"
        }

        /* ------------------------------------------------------------ */

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
            mantika_id="26491bbb-b9d2-4dac-8ce7-7f739ea74d7b"
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
        "/notification/returns_return_to_buyer_shipped"(platform: "/mobile") {
            news_id = "returns-return_to_buyer_shipped-1674717959-216070768"
            event_type = "arrived"
            order_id = 1703754979
        }
        "/notification/returns_return_cancelled_buyer"(platform: "/mobile") {
            news_id = "returns-return_cancelled_buyer-1234-186785675"
            event_type = "arrived"
            order_id = 1234
        }
        "/notification/returns_return_failed_return_to_buyer"(platform: "/mobile") {
            news_id = "returns-return_failed_return_to_buyer-1234-186785675"
            event_type = "arrived"
            order_id = 1234
        }
        "/notification/returns_return_delivered_long_way"(platform: "/mobile") {
            news_id = "returns-return_delivered_long_way-1234-186785675"
            event_type = "arrived"
            order_id = 1234
        }
        "/notification/returns_return_failed_shipment_not_delivered"(platform: "/mobile") {
            news_id = "returns-return_failed_shipment_not_delivered-1234-186785675"
            event_type = "arrived"
            order_id = 1234
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

        "/notification/returns_refund_account_money"(platform: "/mobile") {
            news_id = "returns_refund_account_money-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_no_shipping_option"(platform: "/mobile") {
            news_id = "returns_no_shipping_option-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_label_unavailable"(platform: "/mobile") {
            news_id = "returns_label_unavailable-1703067817-269729837"
            event_type = "sent"
            order_id = 1703067817
        }

        "/notification/returns_refund_bank_transfer"(platform: "/mobile") {
            news_id = "returns_refund_bank_transfer-1703067817-269729837"
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
        "/notification/security_enroll_screenlock_app"(platform: "/mobile") {
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
        "/notification/fraud_kyc_validation"(platform: "/mobile") {
            news_id = "fraud-kyc_validation-186785675"
            event_type = "open"
        }
        "/notification/da_kyc_manual_review"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
        }
        "/notification/data_privacy_about_to_expire"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
        }
        "/notification/data_privacy_extend_expiration"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
        }
        "/notification/data_privacy_ready"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
        }
        "/notification/driver_logistics_allocated_dock"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/driver_logistics_deassigned_dock"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/driver_logistics_modified_dock"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/driver_logistics_resend_allocated_dock"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/fraud_delivery_cancellation_stop_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/fraud_delivery_cancellation_stop_mp"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/fraud_poc_trust_vote_second_score"(platform: "/mobile") {
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

        "/notification/fraud_remedies_trust_vote_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/flows_default"(platform: "/mobile"){
            initiative_code= "123"
            news_id= "123"
            event_type= "open"
        }
        "/notification/growth_tooling_mgm_kyc_booster"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
        }
        "/notification/growth_tooling_mgm_kyc_guest"(platform: "/mobile"){
            news_id= "123"
            event_type= "open"
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
        "/notification/account_fund_approved_mlc_tc"(platform: "/mobile") {
            news_id = "account_fund-account_fund-approved_ml_tc-12345678"
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

        "/notification/account_fund_active_disabled_clabe"(platform: "/mobile") {
            news_id = "account_fund_active_disabled_clabe-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_bank_transfer"(platform: "/mobile") {
            news_id = "account_fund_bank_transfer-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_iv_cvu_spb"(platform: "/mobile") {
            news_id = "account_fund_iv_cvu_spb-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_pending_clabe"(platform: "/mobile") {
            news_id = "account_fund_pending_clabe-12345678"
            event_type = "shown"
        }

        "/notification/account_fund_ticket"(platform: "/mobile") {
            news_id = "account_fund_ticket-12345678"
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

        "/notification/account_balance_create_ted_account"(platform: "/mobile") {
            news_id = "account_balance_create_ted_account-12345678"
            event_type = "shown"
        }
        "/notification/credit_card_overlimit_active"(platform: "/") {
            news_id = "credit_card_overlimit_active-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_overlimit_inactive"(platform: "/") {
            news_id = "credit_card_overlimit_inactive-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_transaction_chout_purchase"(platform: "/") {
            news_id = "credit_card-transaction_chout_purchase-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_10"(platform: "/") {
            news_id = "credit_card-waitlist_10-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_40"(platform: "/") {
            news_id = "credit_card-waitlist_40-12"
            event_type = "dismiss"
        }
        "/notification/credit_card_waitlist_blacklist"(platform: "/") {
            news_id = "credit_card-waitlist_blacklist-12"
            event_type = "dismiss"
        }
        "/notification/card_first_use_incentive_first_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_first_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_thirdth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_thirdth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_fourteenth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_fourteenth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_seventh_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_seventh_day-12345678"
            event_type = "shown"
        }
        "/notification/card_first_use_incentive_twentyoneth_day"(platform: "/mobile") {
            news_id = "card_first_use_incentive_twentyoneth_day-12345678"
            event_type = "shown"
        }
        "/notification/card_flow_incentive_prepaid_acquisition_first"(platform: "/mobile") {
            news_id = "card_flow_incentive_prepaid_acquisition_first-12345678"
            event_type = "shown"
        }
        "/notification/card_flow_incentive_prepaid_acquisition_second"(platform: "/mobile") {
            news_id = "card_flow_incentive_prepaid_acquisition_second-12345678"
            event_type = "shown"
        }
        "/notification/card_freeze_rejected_authorization"(platform: "/mobile") {
            news_id = "card_freeze_rejected_authorization-12345678"
            event_type = "shown"
        }
        "/notification/ingate_tokenization_verification_code"(platform: "/") {
            news_id = "ingate_tokenization-verification_code-315571651"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_freeze_rejected_withdraw"(platform: "/mobile") {
            news_id = "card_freeze_rejected_withdraw-12345678"
            event_type = "shown"
        }
        "/notification/card_limit_rejected_withdraw_by_limit"(platform: "/mobile") {
            news_id = "card_limit_rejected_withdraw_by_limit-12345678"
            event_type = "shown"
        }
        "/notification/card_limit_rejected_withdraw_by_maximum_limit"(platform: "/mobile") {
            news_id = "card_limit_rejected_withdraw_by_maximum_limit-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_invalid_pin_first_tries"(platform: "/mobile") {
            news_id = "card_pin_invalid_pin_first_tries-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_invalid_pin_fourth_try"(platform: "/mobile") {
            news_id = "card_pin_invalid_pin_fourth_try-12345678"
            event_type = "shown"
        }
        "/notification/card_pin_pin_blocked"(platform: "/mobile") {
            news_id = "card_pin_pin_blocked-12345678"
            event_type = "shown"
        }
        "/notification/card_reminders_pin_reminder"(platform: "/mobile") {
            news_id = "card_reminders_pin_reminder-12345678"
            event_type = "shown"
        }
        "/notification/card_reminders_virtual_digital_services"(platform: "/mobile") {
            news_id = "card_reminders_virtual_digital_services-12345678"
            event_type = "shown"
        }
        "/notification/card_request_challenge_expired"(platform: "/mobile") {
            news_id = "card_request_challenge_expired-12345678"
            event_type = "shown"
        }
        "/notification/card_request_challenge_pending"(platform: "/mobile") {
            news_id = "card_request_challenge_pending-12345678"
            event_type = "shown"
        }
        "/notification/card_request_challenge_pre_expired"(platform: "/mobile") {
            news_id = "card_request_challenge_pre_expired-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_physical_card"(platform: "/mobile") {
            news_id = "card_offering_physical_card-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_transaction_generic_opt_in_ppd_to_hybrid"(platform: "/mobile") {
            news_id = "card_offering_transaction_generic_opt_in_ppd_to_hybrid-12345678"
            event_type = "shown"
        }
        "/notification/card_offering_transaction_opt_in_ppd_to_hybrid"(platform: "/mobile") {
            news_id = "card_offering_transaction_opt_in_ppd_to_hybrid-12345678"
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

        "/notification/addresses_update_bad_address"(platform: "/mobile") {
            news_id = "addresses_update_bad_address-12345678-123"
            event_type = "shown"
        }

        "/notification/addresses_update_bad_address_delivered"(platform: "/mobile") {
            news_id = "addresses_update_bad_address_delivered-12345678-123"
            event_type = "shown"
        }

        "/notification/asset_management_warm_up"(platform: "/mobile") {
            news_id = "asset-management_warm_up-12345678-123123"
            event_type = "shown"
        }
        
        "/notification/asset_management_missing_docs"(platform: "/mobile") {
            news_id = "asset-management_missing_docs-12345678-123123"
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

        "/notification/asset_management_failed"(platform: "/mobile") {
            news_id = "asset-management_failed-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_rejected"(platform: "/mobile") {
            news_id = "asset-management_rejected-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_underage_approved"(platform: "/mobile") {
            news_id = "asset-management_underage_approved-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_underage_rejected"(platform: "/mobile") {
            news_id = "asset-management_underage_rejected-12345678-123123"
            event_type = "shown"
        }

        "/notification/asset_management_underage_request"(platform: "/mobile") {
            news_id = "asset-management_underage_request-12345678-123123"
            event_type = "shown"
        }

        "/notification/institutional_generic"(platform: "/mobile"){
            event_type = "open"
            campaign_id= "institutional_generic1"
            sent_date= "20180508"
            batch_id = "MLA_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLA1234"
        }

        "/notification/mpinstitutional_generic"(platform: "/mobile"){
            event_type = "open"
            campaign_id= "mpinstitutional_generic1"
            sent_date= "20180508"
            batch_id = "MLA_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLA1234"
        }

        "/notification/institutional_control_group"(platform: "/mobile"){
            event_type="discarded"
            campaign_id= "institutional-control_group1"
            sent_date= "20210624"
            batch_id = "MLA_PACK_20180508_3"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLA1234"
        }

        "/notification/mpinstitutional_control_group"(platform: "/mobile"){
            event_type="discarded"
            campaign_id= "mpinstitutional-control_group1"
            sent_date= "20210624"
            batch_id = "MLA_MPPACK_20180508_4"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLA12345"
        }

        "/notification/mpcampaigns_campaigns"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
            campaign_id = "mkt_campaign_co"
            batch_id = "MLB_PACK_20180508_2"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLB1234"
        }

        "/notification/subscription_expiring_notice"(platform: "/mobile") {
            news_id = "subscription-expiring_notice-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_option = "Citibanamex"
        }

        "/notification/subscription_payment_congrats"(platform: "/mobile") {
            news_id = "subscription-payment_congrats-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_type = "successful_payment"
            female_gender = true
        }

        "/notification/subscription_payment_error"(platform: "/mobile") {
            news_id = "subscription-payment_error-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            error_type = "card_code"
            female_gender = true
        }

        "/notification/subscription_payment_instructions"(platform: "/mobile") {
            news_id = "subscription-payment_instructions-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_option = "Citibanamex"
            female_gender = true
        }

        "/notification/subscription_payment_pending"(platform: "/mobile") {
            news_id = "subscription-payment_pending-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_type = "successful_payment"
            female_gender = true
        }

        "/notification/subscription_disney_activation_on"(platform: "/mobile") {
            news_id = "subscription_disney_activation_on-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification/subscription_disney_activation_off"(platform: "/mobile") {
            news_id = "subscription_disney_activation_off-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
        }
        "/notification/subscription_disney_activation_free_trial"(platform: "/mobile") {
            news_id = "subscription_disney_activation_free_trial-186785675-hbo-20181211"
            event_type = "open"
            provider = "hbo"
            provider_name = "Disney"
            date = "20181211"
            female_gender = true
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
            execution_id = 123456
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
            campaign_id = "123123"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }

        "/notification/mp_sponsor_campaign_budget_trigger"(platform: "/mobile") {
            news_id = "mp_sponsor-campaign_budget_trigger-12345678-123123"
            event_type = "shown"
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }

        "/notification/mp_sponsor_campaign_day_trigger"(platform: "/mobile") {
            news_id = "mp_sponsor-campaign_day_trigger-12345678-123123"
            event_type = "shown"
            campaign_id = "080677f9877e454f917ca55ea1bbbb24"
            end_date = "2019-09-17T12:19:56.234-04:00"
        }

        "/notification/mp_seller_campaign_start_campaign"(platform: "/mobile") {
            news_id = "mp_seller-campaign_start_campaign-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_seller_campaign_end_campaign"(platform: "/mobile") {
            news_id = "mp_seller-campaign_end_campaignn-12345678-123123"
            event_type = "shown"
        }
        "/notification/mp_seller_campaign_resume_campaign"(platform: "/mobile") {
            news_id = "mp_seller-campaign_resume_campaign-12345678-123123"
            event_type = "shown"
        }
        "/notification/mp_seller_marketplace_must"(platform: "/mobile") {
            news_id = "mp_seller_marketplace_must-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_seller_generic_wish"(platform: "/mobile") {
            news_id = "mp_seller_generic_wish-12345678-123123"
            event_type = "shown"
        }

        "/notification/mp_seller_discount_center_must"(platform: "/mobile") {
            news_id = "mp_seller_discount_center_must-12345678-123123"
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
        "/notification/credits_merchants_em_to_expire_01"(platform: "/mobile") {
            news_id = "credits-merchants_em_to_expire_01-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_expired_no_charges_today"(platform: "/mobile") {
            news_id = "credits-merchants_em_expired_no_charges_today-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_expired_daily_charges_01"(platform: "/mobile") {
            news_id = "credits-merchants_em_expired_daily_charges_01-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_expired_daily_charges_04"(platform: "/mobile") {
            news_id = "credits-merchants_em_expired_daily_charges_04-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_expired_daily_charges_07"(platform: "/mobile") {
            news_id = "credits-merchants_em_expired_daily_charges_07-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_expired_daily_charges_10"(platform: "/mobile") {
            news_id = "credits-merchants_em_expired_daily_charges_10-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_congrats"(platform: "/mobile") {
            news_id = "credits_merchants_em_congrats-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_em_collected"(platform: "/mobile") {
            news_id = "credits_merchants_em_collected-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_congrats"(platform: "/mobile") {
            news_id = "credits_merchants_spl_congrats-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_expired_05_push"(platform: "/mobile") {
            news_id = "credits_merchants-spl_expired_05_push-1234"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_expired_45_push"(platform: "/mobile") {
            news_id = "credits_merchants-spl_expired_45_push-1234"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_to_expire_00_push"(platform: "/mobile") {
            news_id = "credits_merchants-spl_expired_00_push-1234"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_to_expire_01_push"(platform: "/mobile") {
            news_id = "credits_merchants-spl_expired_01_push-1234"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_spl_to_expire_10_push"(platform: "/mobile") {
            news_id = "credits_merchants-spl_expired_10_push-1234"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_finished_loan_payment"(platform: "/mobile") {
            news_id = "credits_merchants_std_finished_loan_payment-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_expired_daily_charges_30"(platform: "/mobile") {
            news_id = "credits_merchants_std_expired_daily_charges_30-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_expired_daily_charges_60"(platform: "/mobile") {
            news_id = "credits_merchants_std_expired_daily_charges_60-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_expired_daily_charges_75"(platform: "/mobile") {
            news_id = "credits_merchants_std_expired_daily_charges_75-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_expired_daily_charges_90"(platform: "/mobile") {
            news_id = "credits_merchants_std_expired_daily_charges_90-9876"
            event_type = "shown"
            installment_id = 123
        }
        "/notification/credits_merchants_std_expired_daily_charges_110"(platform: "/mobile") {
            news_id = "credits_merchants_std_expired_daily_charges_110-9876"
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

        "/notification/melichat_message_mp"(platform: "/mobile"){
            case_id= 12345678
            event_type = "sent"
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
            gift_reason_id = "test"
            event_type = "open"
        }
        "/notification/merchants_growth_fdv_failure"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_fdv_recovery"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_fdv_success"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_fdv_warning"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_paper_roll_first_request"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_paper_roll_recurrent_request"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_paper_roll_reminder"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_resellers_caps"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_resellers_newland_nfc_launch"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_resellers_prizes"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_resellers_pro2_launch"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_resellers_smart_launch"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_sameday"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_reverse_screening_fraud"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_reverse_screening_conflict"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_pricing_point_scl_down"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_pricing_point_scl_onboarding"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_pricing_point_scl_maintain"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/merchants_growth_pricing_point_scl_up"(platform: "/mobile") {
            event_type = "open"
        }

        "/notification/money_transfer_received"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }

        "/notification/money_transfer_sender"(platform: "/mobile") {
            news_id = "money-transfer_sender-186785675-1122-993783123"
            event_type = "open"
        }

        "/notification/moneyin_debin_approved"(platform: "/") {
            news_id = "moneyin_debin-approved-12345678"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/moneyin_debin_in_process"(platform: "/") {
            news_id = "moneyin_debin-process-12345678"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/moneyin_debin_rejected"(platform: "/") {
            news_id = "moneyin_debin-rejected-12345678"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/hub_transfer_new_approved"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/hub_transfer_manualreview"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/hub_transfer_new_rejected"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/hub_transfer_rejected"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/hub_transfer_screening_one"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/hub_transfer_screening_two"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_handoff_user_notification_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_handoff_user_notification_mp"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_user_notification_mp"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_user_notification_ml"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_bo_success"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/killers_loser_item_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/killers_winner_item_recover"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/killers_winner_item_new"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/killers_winner_item_lost"(platform: "/mobile") {
            news_id = "killers-winner_item_lost-MLA123-19712790"
            event_type = "open"
        }
        "/notification/killers_losing_item_buybox"(platform: "/mobile") {
            news_id = "123"
            event_type = "open"
        }
        "/notification/kyc_afip_user_notification_mp"(platform: "/mobile") {
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
        "/notification/prepaid_card_delivery"(platform: "/mobile") {
            news_id = "prepaid_card-delivery-186785675"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_soon_deliver"(platform: "/mobile") {
            news_id = "prepaid_card_soon_deliver-186785675"
            event_type = "auto_dismiss"
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
        "/notification/prepaid_card_reprogrammed"(platform: "/mobile"){
            news_id = "prepaid_card_reprogrammed-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_delivery"(platform: "/mobile") {
            news_id = "prepaid_card-delivery-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
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

        "/notification/prepaid_card_transaction_rejected_invalid_pin"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_invalid_pin-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_for_fee"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount_for_fee-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
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
        "/notification/prepaid_card_transaction_capture_after_ttl"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_capture_after_ttl-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_transaction_capture_less_than_amount"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_capture_less_than_amount-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/prepaid_card_transaction_canceled_withdraw"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_canceled_withdraw-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_invalid_amount_option_credit"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_invalid_amount_option_credit-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
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

        "/notification/prepaid_card_transaction_invalid_amount_option_credit"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_invalid_amount_option_credit-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "open"
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

        "/notification/prepaid_card_transaction_rejected_for_not_transaction"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_for_not_transaction-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_correios_strike_delayed"(platform: "/mobile"){
            news_id= "card_correios_strike_delayed-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_virtual"(platform: "/mobile"){
            news_id= "card_kyc_data_completed_virtual-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_unlock"(platform: "/mobile"){
            news_id= "card_kyc_data_completed_unlock-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_nfc_acquisition"(platform: "/mobile"){
            news_id= "card_kyc_data_completed_nfc_acquisition-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_physical_acquisition"(platform: "/mobile"){
            news_id= "card_kyc_data_completed_physical_acquisition-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_prepaid_acquisition_first"(platform: "/mobile"){
            news_id= "card_kyc_data_completed_prepaid_acquisition_first-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_prepaid_acquisition_third"(platform: "/mobile"){
            news_id= "card_kyc_data_completed_prepaid_acquisition_third-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_prepaid_acquisition_second"(platform: "/mobile"){
            news_id= "card_kyc_data_completed_prepaid_acquisition_second-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_kyc_data_completed_virtual_acquisition"(platform: "/mobile") {
            news_id = "card_kyc_data_completed_virtual_acquisition-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_unlock_incentive_zero_day_owner"(platform: "/mobile") {
            news_id = "card_unlock_incentive_zero_day_owner-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_unlock_incentive_zero_day"(platform: "/mobile") {
            news_id = "card_unlock_incentive_zero_day-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_unlock_incentive_second_day"(platform: "/mobile") {
            news_id = "card_unlock_incentive_second_day-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
            has_money = true
        }

        "/notification/card_unlock_incentive_zero_day_somewhere"(platform: "/mobile") {
            news_id = "card_unlock_incentive_zero_day_somewhere-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_unlock_incentive_zero_day_point"(platform: "/mobile") {
            news_id = "card_unlock_incentive_zero_day_point-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_unlock_incentive_zero_day_known_person"(platform: "/mobile") {
            news_id = "card_unlock_incentive_zero_day_known_person-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_unlock_incentive_fifth_day"(platform: "/mobile") {
            news_id = "card_unlock_incentive_fifth_day-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_unlock_incentive_fifteenth_day"(platform: "/mobile") {
            news_id = "card_unlock_incentive_fifteenth_day-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_unlock_incentive_twentyfifth_day"(platform: "/mobile") {
            news_id = "card_unlock_incentive_twentyfifth_day-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_delivery_tracking_ready_to_ship"(platform: "/mobile") {
            news_id = "card_delivery_tracking_ready_to_ship-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_delivery_tracking_shipped"(platform: "/mobile") {
            news_id = "card_delivery_tracking_shipped-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_delivery_tracking_soon_deliver"(platform: "/mobile") {
            news_id = "card_delivery_tracking_soon_deliver-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_delivery_tracking_delayed"(platform: "/mobile") {
            news_id = "card_delivery_tracking_delayed-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_delivery_tracking_branch"(platform: "/mobile") {
            news_id = "card_delivery_tracking_branch-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_delivery_tracking_not_delivered"(platform: "/mobile") {
            news_id = "card_delivery_tracking_not_delivered-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
            branch_time_elapsed = true
        }


        "/notification/card_first_use_incentive_nfc_first_day_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_nfc-first_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_first_use_incentive_nfc_first_day_no_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_nfc-first_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_first_use_incentive_nfc_fifth_day_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_nfc-first_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_first_use_incentive_nfc_fifth_day_no_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_nfc-first_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_first_use_incentive_nfc_fifth_day_am_virtual_inactive"(platform: "/mobile") {
            news_id = "card_first_use_incentive_nfc-fifth_day_am_virtual_inactive-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_first_use_incentive_nfc_fifth_day_no_am_virtual_inactive"(platform: "/mobile") {
            news_id = "card_first_use_incentive_nfc-fifth_day_no_am_virtual_inactive-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_first_use_incentive_nfc_seventh_day_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_nfc-seventh_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_first_use_incentive_nfc_seventh_day_no_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_nfc-seventh_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification_center/card_first_use_incentive_nfc"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_nfc-first_day_am-186785675-76283123"
            latest_news_id= "card_first_use_incentive_nfc-first_day_am-186785675-76283123"
            latest_news_type= "card_first_use_incentive_nfc-first_day_am"
            status= "read"
        }
        "/notification_center/card_first_use_incentive_nfc"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_nfc_first_day_no_am-186785675-76283123"
            latest_news_id= "card_first_use_incentive_nfc_first_day_no_am-186785675-76283123"
            latest_news_type= "card_first_use_incentive_nfc_first_day_no_am"
            status= "read"
        }
        "/notification_center/card_first_use_incentive_nfc"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_nfc_fifth_day_am-186785675-76283123"
            latest_news_id= "card_first_use_incentive_nfc_fifth_day_am-186785675-76283123"
            latest_news_type= "card_first_use_incentive_nfc_fifth_day_am"
            status= "read"
        }
        "/notification_center/card_first_use_incentive_nfc"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_nfc_fifth_day_no_am-186785675-76283123"
            latest_news_id= "card_first_use_incentive_nfc_fifth_day_no_am-186785675-76283123"
            latest_news_type= "card_first_use_incentive_nfc_fifth_day_no_am"
            status= "read"
        }
        "/notification_center/card_first_use_incentive_nfc"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_nfc_fifth_day_am_virtual_inactive-186785675-76283123"
            latest_news_id= "card_first_use_incentive_nfc_fifth_day_am_virtual_inactive-186785675-76283123"
            latest_news_type= "card_first_use_incentive_nfc_fifth_day_am_virtual_inactive"
            status= "read"
        }
        "/notification_center/card_first_use_incentive_nfc"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_nfc_fifth_day_no_am_virtual_inactive-186785675-76283123"
            latest_news_id= "card_first_use_incentive_nfc_fifth_day_no_am_virtual_inactive-186785675-76283123"
            latest_news_type= "card_first_use_incentive_nfc_fifth_day_no_am_virtual_inactive"
            status= "read"
        }

        "/notification_center/card_first_use_incentive_nfc"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_nfc-seventh_day_am-186785675-76283123"
            latest_news_id= "card_first_use_incentive_nfc-seventh_day_am-186785675-76283123"
            latest_news_type= "card_first_use_incentive_nfc-seventh_day_am"
            status= "read"
        }
        "/notification_center/card_first_use_incentive_nfc"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_nfc-seventh_day_no_am-186785675-76283123"
            latest_news_id= "card_first_use_incentive_nfc-seventh_day_no_am-186785675-76283123"
            latest_news_type= "card_first_use_incentive_nfc-seventh_day_no_am"
            status= "read"
        }

        // Notification Center - First Use Incentive Virtual
        "/notification_center/card_first_use_incentive_virtual"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_virtual-first_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_id= "card_first_use_incentive_virtual-first_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_type= "card_first_use_incentive_virtual-first_day_am"
            status= "read"
        }

        "/notification_center/card_first_use_incentive_virtual"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_virtual-first_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_id= "card_first_use_incentive_virtual-first_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_type= "card_first_use_incentive_virtual-first_day_no_am"
            status= "read"
        }

        "/notification_center/card_first_use_incentive_virtual"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_virtual-fifth_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_id= "card_first_use_incentive_virtual-fifth_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_type= "card_first_use_incentive_virtual-fifth_day_am"
            status= "read"
        }

        "/notification_center/card_first_use_incentive_virtual"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_virtual-fifth_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_id= "card_first_use_incentive_virtual-fifth_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_type= "card_first_use_incentive_virtual-fifth_day_no_am"
            status= "read"
        }

        "/notification_center/card_first_use_incentive_virtual"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_virtual-fifth_day_am_nfc_inactive-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_id= "card_first_use_incentive_virtual-fifth_day_am_nfc_inactive-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_type= "card_first_use_incentive_virtual-fifth_day_am_nfc_inactive"
            status= "read"
        }

        "/notification_center/card_first_use_incentive_virtual"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_virtual-fifth_day_no_am_nfc_inactive-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_id= "card_first_use_incentive_virtual-fifth_day_no_am_nfc_inactive-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_type= "card_first_use_incentive_virtual-fifth_day_no_am_nfc_inactive"
            status= "read"
        }

        "/notification_center/card_first_use_incentive_virtual"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_virtual-seventh_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_id= "card_first_use_incentive_virtual-seventh_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_type= "card_first_use_incentive_virtual-seventh_day_no_am"
            status= "read"
        }

        "/notification_center/card_first_use_incentive_virtual"(platform: "/mobile"){
            newsgroup_id= "card_first_use_incentive_virtual-seventh_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_id= "card_first_use_incentive_virtual-seventh_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            latest_news_type= "card_first_use_incentive_virtual-seventh_day_am"
            status= "read"
        }

        // Notification - First Use Incentive Virtual
        "/notification/card_first_use_incentive_virtual_first_day_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_virtual-first_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_first_use_incentive_virtual_first_day_no_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_virtual-first_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_first_use_incentive_virtual_fifth_day_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_virtual-fifth_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_first_use_incentive_virtual_fifth_day_no_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_virtual-fifth_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_first_use_incentive_virtual_fifth_day_am_nfc_inactive"(platform: "/mobile") {
            news_id = "card_first_use_incentive_virtual-fifth_day_am_nfc_inactive-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_first_use_incentive_virtual_fifth_day_no_am_nfc_inactive"(platform: "/mobile") {
            news_id = "card_first_use_incentive_virtual-fifth_day_no_am_nfc_inactive-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_first_use_incentive_virtual_seventh_day_no_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_virtual-seventh_day_no_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_first_use_incentive_virtual_seventh_day_am"(platform: "/mobile") {
            news_id = "card_first_use_incentive_virtual-seventh_day_am-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/card_prepaid_tracking_ready_to_ship"(platform: "/mobile") {
            news_id = "card_prepaid_tracking_ready_to_ship-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_prepaid_tracking_ready_to_ship_challenged"(platform: "/mobile") {
            news_id = "card_prepaid_tracking_ready_to_ship_challenged-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_prepaid_tracking_shipped"(platform: "/mobile") {
            news_id = "card_prepaid_tracking_shipped-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_prepaid_tracking_soon_deliver"(platform: "/mobile") {
            news_id = "card_prepaid_tracking_soon_deliver-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_prepaid_tracking_delayed"(platform: "/mobile") {
            news_id = "card_prepaid_tracking_delayed-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_prepaid_tracking_delayed_extended"(platform: "/mobile") {
            news_id = "card_prepaid_tracking_delayed_extended-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_prepaid_tracking_branch_with_address"(platform: "/mobile") {
            news_id = "card_prepaid_tracking_branch_with_address-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_prepaid_tracking_not_delivered"(platform: "/mobile") {
            news_id = "card_prepaid_tracking_not_delivered-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
            branch_case = true
        }
        "/notification/card_prepaid_tracking_delivered"(platform: "/mobile") {
            news_id = "card_prepaid_tracking_delivered-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/card_prepaid_tracking_reprogrammed"(platform: "/mobile") {
            news_id = "card_prepaid_tracking_reprogrammed-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }

        "/notification/claim_pdd_first_rescue"(platform: "/mobile"){
            news_id = "claim_pdd_first_rescue-186785675-76283123"
            event_type = "open"
        }

        "/notification/claim_pdd_second_rescue"(platform: "/mobile"){
            news_id = "claim_pdd_second_rescue-186785675-76283123"
            event_type = "open"
        }

        "/notification/claim_return_allowed_seller_action_decorator"(platform: "/mobile"){
            news_id = "claim_return_allowed_seller_action_decorator-186785675-76283123"
            event_type = "open"
        }

        "/notification/claim_return_allowed_reminder_timeout_decorator"(platform: "/mobile"){
            news_id = "claim_return_allowed_reminder_timeout_decorator-186785675-76283123"
            event_type = "open"
        }
        "/notification/claim_return_allowed_seller_action"(platform: "/mobile"){
            news_id = "claim_return_allowed_seller_action-186785675-76283123"
            event_type = "open"
            order_id = 123
        }
        "/notification/claim_return_allowed_reminder_timeout"(platform: "/mobile"){
            news_id = "claim_return_allowed_reminder_timeout-186785675-76283123"
            event_type = "open"
            order_id = 123
        }
        "/notification/claim_closed_seller_refund_decorator"(platform: "/mobile"){
            news_id = "claim_closed_seller_refund_decorator-186785675-76283123"
            event_type = "open"
        }
        "/notification/claim_closed_seller_refund"(platform: "/mobile"){
            news_id = "claim_closed_seller_refund-186785675-76283123"
            event_type = "open"
            order_id = 123
        }
        "/notification/point_shipping_ready_to_ship"(platform: "/mobile") {
            news_id = "123"
            event_type = "auto_dismiss"
            notification_type= "deep_linking"
        }
        "/notification/point_fill_in"(platform: "/mobile") {
            news_id = "point_fill_in-123"
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
        "/notification/point_audit_cash"(platform: "/mobile") {
            news_id = "point_audit_cash-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/point_qr_login_new"(platform: "/mobile") {
            news_id = "point-qr_login_new-a34rb3"
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

        "/notification/wallet_integrator_payment_success"(platform: "/mobile") {
            news_id = "wallet_integrator-payment_success-186785675"
            event_type = "open"
        }

        "/notification/wallet_integrator_insufficient_funds"(platform: "/mobile") {
            news_id = "wallet_integrator-insufficient_funds-186785675"
            event_type = "open"
        }

        "/notification/wallet_integrator_personal_loan"(platform: "/mobile") {
            news_id = "wallet_integrator_personal_loan-186785675"
            event_type = "open"
        }

        //Withdrawal
        "/notification/withdraw_approved_contingency"(platform: "/mobile") {
            news_id = "withdraw_approved_contingency-186785675"
            event_type = "open"
        }

        "/notification/installs_checker"(platform: "/mobile"){
            date_created= "2020-01-20T10:31:18.162-04:00"
            advertising_id= "4066c329-d684-4196-8db4-3633148fc1a5"
            event_type = "sent"
        }

        "/notification/uninstalls_checker"(platform: "/mobile"){
            execution_id= "160295629"
            advertising_id= "4066c329-d684-4196-8db4-3633148fc1a5"
            event_type = "sent"
        }

        "/notification/cards_send_card"(platform: "/mobile") {
            news_id = "cards_send_card-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/dismiss"(platform: "/mobile") {
            news_id = "dismiss-12332323"
            event_type = "dismiss"
        }
        "/notification/shipping_wrong_address_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            shipment_id = 123
        }
        "/notification/shipping_buyer_absent_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            shipment_id = 123
        }
        "/notification/shipping_handling_agency_unavailable"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_wrong_address_driver_action"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            deeplink = "meli://sales/11222#shipping"
            shipment_id = 1234
        }
        "/notification/shipping_scoring_keyword_created"(platform: "/mobile"){
            news_id = "12332323"
            event_type = "arrived"
            shipment_id = 123
        }
        "/notification/shipping_rts_in_packing_list"(platform: "/mobile"){
            news_id = "shipping-rts_in_packing_list-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_shipped_bad_address"(platform: "/mobile"){
            news_id = "shipping-shipped_bad_address-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_shipped_same_day"(platform: "/mobile"){
            news_id = "shipping-shipped_same_day-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_shipped_same_day_scoring_key_pass"(platform: "/mobile"){
            news_id = "shipping-shipped_same_day_scoring_key_pass-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_shipped_waiting_for_confirmation"(platform: "/mobile"){
            news_id = "shipping-shipped_waiting_for_confirmation-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_soon_deliver_same_day"(platform: "/mobile"){
            news_id = "shipping-soon_deliver_same_day-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_shipped_partial_cancellations"(platform: "/mobile"){
            news_id = "shipping-soon_deliver_same_day-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_delivered_partial_cancellations"(platform: "/mobile"){
            news_id = "shipping-soon_deliver_same_day-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/shipping_soon_deliver_same_day_scoring_key_pass"(platform: "/mobile"){
            news_id = "shipping-soon_deliver_same_day_scoring_key_pass-21409256437"
            event_type = "arrived"
            shipment_id = 21409256437
        }
        "/notification/card_contactless_transaction_rejected_authorization_contactless_freeze"(platform: "/mobile") {
            news_id = "card_contactless_transaction_rejected_authorization_contactless_freeze-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg"
            event_type = "auto_dismiss"
            notification_type = "deep_linking"
        }

        "/notification_center/insurtech_imei_activation"(platform: "/") {
            latest_news_type= "insurtech_imei_activation"
            latest_news_id= "insurtech_imei_activation-143816022-MLB1013046714"
        }
        "/notification_center/insurtech_kyc_roda_pre_activacion"(platform: "/") {
            latest_news_type= "insurtech_kyc_roda_pre_activacion"
            latest_news_id= "insurtech_kyc_roda_pre_activacion-143816022-MLB1013046714"
        }
        "/notification/insurtech_imei_activation"(platform: "/mobile") {
            news_id = "insurtech_imei_activation_123"
            event_type = "open"
        }
        "/notification/insurtech_kyc_roda_pre_activacion"(platform: "/mobile") {
            news_id = "insurtech_kyc_roda_pre_activacion-123"
            event_type = "open"
        }
        "/notification_center/insurtech_pending_payment"(platform: "/") {
            latest_news_type= "insurtech_pending_payment"
            latest_news_id= "insurtech_pending_payment-143816022-MLB1013046714"
        }
        "/notification/insurtech_payment_recovery"(platform: "/mobile") {
            news_id = "insurtech_payment_recovery-315571651-4600610652-2021-06-29"
            event_type = "open"
        }

        "/notification_center/insurtech_money_in"(platform: "/") {
            latest_news_type= "insurtech_money_in"
            latest_news_id= "insurtech_money_in-315571651-4600610652-2021-06-29"
        }
        "/notification/insurtech_money_in"(platform: "/mobile") {
            news_id = "insurtech_money_in-315571651-4600610652-2021-06-29"
            event_type = "open"
        }
        "/notification/insurtech_pending_payment"(platform: "/mobile") {
            news_id = "insurtech_pending_payment_123"
            event_type = "open"
        }

        "/notification_center/insurtech_cancellation"(platform: "/") {
            latest_news_type= "insurtech_cancellation"
            latest_news_id= "insurtech_cancellation-143816022-MLB1013046714"
        }

        "/notification/insurtech_cancellation"(platform: "/mobile") {
            news_id = "insurtech_cancellation_123"
            event_type = "open"
        }

        "/notification_center/insurtech_purchase"(platform: "/") {
            latest_news_type= "insurtech_purchase"
            latest_news_id= "insurtech_pending_payment-143816022-02f6a0f5-4e88-4797-aa47-eeb1a9a1e01b"
        }

        "/notification/insurtech_purchase"(platform: "/mobile") {
            news_id = "insurtech_pending_payment-143816022-02f6a0f5-4e88-4797-aa47-eeb1a9a1e01b"
            event_type = "open"
        }

        "/notification_center/insurtech_payment_recovery"(platform: "/") {
            latest_news_type= "insurtech_payment_recovery"
            latest_news_id= "insurtech_payment_recovery-315571651-4600610652-2021-06-29"
        }

        "/notification/insurtech_payment_recovery"(platform: "/mobile") {
            news_id = "insurtech_payment_recovery-315571651-4600610652-2021-06-29"
            event_type = "open"
        }

        "/notification_center/insurtech_money_in"(platform: "/") {
            latest_news_type= "insurtech_money_in"
            latest_news_id= "insurtech_money_in-315571651-4600610652-2021-06-29"
        }

        "/notification/insurtech_money_in"(platform: "/mobile") {
            news_id = "insurtech_money_in-315571651-4600610652-2021-06-29"
            event_type = "open"
        }

        "/notification_center/insurtech_payment_recovery_cards"(platform: "/") {
            latest_news_type= "insurtech_payment_recovery_cards"
            latest_news_id= "insurtech_payment_recovery_cards-315571651-4600610652-2021-06-29"
        }

        "/notification/insurtech_payment_recovery_cards"(platform: "/mobile") {
            news_id = "insurtech_payment_recovery_cards-315571651-4600610652-2021-06-29"
            event_type = "open"
        }

        "/notification/abandoned_cart_buyer"(platform: "/mobile") {
            event_type = "open"
        }

         "/notification/abandoned_cart_link_payer"(platform: "/mobile") {
            event_type = "open"
        }

        "/notification/card_wallet_resume_token"(platform: "/mobile") {
            news_id = "card_wallet_resume_token-51AO96HEQBssK6rdZvm"
            event_type = "auto_dismiss"
            notification_type = "deep_linking"
        }

        // Proximity Marketplace Order Manager
        "/notification/pm_om_notification_store_opening"(platform: "/") {
            news_id = "pm_om_notification-store_opening-753913118-d4d5811d-6ed7-4564-859c-2a6e00a35d67"
            event_type = "open"
            notification_type = "deep_linking"
        }
        "/notification/pm_om_notification_store_opening_retry"(platform: "/") {
            news_id = "pm_om_notification-store_opening_retry-753913118-d4d5811d-6ed7-4564-859c-2a6e00a35d67"
            event_type = "sent"
        }
        "/notification/pm_om_notification_new_sale"(platform: "/") {
            news_id = "pm_om_notification-new_sale-753913118-d4d5811d-6ed7-4564-859c-2a6e00a35d67"
            event_type = "open"
        }
        "/notification/pm_om_notification_new_sale_retry"(platform: "/") {
            news_id = "pm_om_notification-new_sale_retry-753913118-d4d5811d-6ed7-4564-859c-2a6e00a35d67"
            event_type = "sent"
        }
        "/notification/pm_om_notification_buyer_cancellation"(platform: "/") {
            news_id = "pm_om_notification-buyer_cancellation-753913118-d4d5811d-6ed7-4564-859c-2a6e00a35d67"
            event_type = "open"
        }

        "/notification_center/pm_om_notification-store_opening"(platform: "/") {
            news_id = "pm_om_notification-store_opening-753913118-d4d5811d-6ed7-4564-859c-2a6e00a35d67"
            event_type = "open"
        }
        "/notification_center/pm_om_notification-new_sale"(platform: "/") {
            news_id = "pm_om_notification-notification-new_sale-753913118-d4d5811d-6ed7-4564-859c-2a6e00a35d67"
            event_type = "open"
        }
        "/notification_center/pm_om_notification-buyer_cancellation"(platform: "/") {
            news_id = "pm_om_notification-buyer_cancellation-753913118-d4d5811d-6ed7-4564-859c-2a6e00a35d67"
            event_type = "open"
        }

        "/notification/disbursement_kwai_received"(platform: "/") {
            news_id = "disbursement_kwai-received-12345678"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/moneyin_cca_approved"(platform: "/") {
            news_id = "moneyin_cca-approved-12345678"
            event_type = "open"
        }
        
        "/notification/moneyin_cca_rejected"(platform: "/") {
            news_id = "moneyin_cca-rejected-12345678"
            event_type = "open"
        }

        "/notification/moneyin_open_finance_approved"(platform: "/") {
            news_id = "moneyin_open_finance-approved-12345678"
            event_type = "open"
        }
        "/notification/moneyin_open_finance_in_process"(platform: "/") {
            news_id = "moneyin_open_finance-in_process-12345678"
            event_type = "open"
        }
        "/notification/moneyin_open_finance_rejected"(platform: "/") {
            news_id = "moneyin_open_finance-rejected-12345678"
            event_type = "open"
        }

        "/notification/open_finance_consent_recovery"(platform: "/mobile") {
            event_type = "open"
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
        "/notification/withdraw_approved"(platform: "/web") {
            news_id = "withdraw_approved-186785675"
            event_type = "open"
        }
        "/notification/withdraw_rejected"(platform: "/web") {
            news_id = "withdraw_rejected-186785675"
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

        // Delay Compensation
        "/notification/shipping_delay_compensation_cashback"(platform: "/web"){
            news_id = "shipping_delay_compensation-cashback-786729047-40778713229"
            event_type = "open"
            shipment_id = 123
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

        "/notification/payments_release"(platform: "/mobile") {
            notification_id = "12345"
            event_type = "open"
        }

        "/notification/installs_checker"(platform: "/mobile"){
            date_created= "2020-01-20T10:31:18.162-04:00"
            advertising_id= "4066c329-d684-4196-8db4-3633148fc1a5"
            event_type = "sent"
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

        "/notification_center/payments_release"(platform: "/mobile") {
            notification_id = "12345"
        }

        "/notification_center/sll_items_activate_items"(platform: "/web") {
            site_id="MLA"
            seller_id="1234567"
            items_count=5
            event_type = "open"
        }

        "/notification/prepaid_card_transaction_rejected_for_not_transaction"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_rejected_for_not_transaction-186785675"
            event_type = "open"
             notification_type= "deep_linking"
        }


        "/notification/card_nip_first_try"(platform: "/mobile") {
            news_id = "card_nip_first_try-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_nip_second_try"(platform: "/mobile") {
            news_id = "card_nip_second_try-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_nip_nip_block"(platform: "/mobile") {
            news_id = "card_nip_nip_block-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_nip_set_nip"(platform: "/mobile") {
            news_id = "card_nip_set_nip-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_authorization_extracash"(platform: "/mobile") {
            news_id = "card_transactions_approved_authorization_extracash-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_authorization_extracash_mute"(platform: "/mobile") {
            news_id = "card_transactions_approved_authorization_extracash_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/cards_whatsapp_enrollment_confirmation"(platform: "/mobile") {
            news_id = "cards_whatsapp_enrollment_confirmation-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_cancelled_authorization_whatsapp"(platform: "/mobile") {
            news_id = "card_transactions_cancelled_authorization_whatsapp-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_cancelled_authorization_whatsapp_mute"(platform: "/mobile") {
            news_id = "card_transactions_cancelled_authorization_whatsapp_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_transaction_invalid_amount_option_express_money"(platform: "/mobile") {
            news_id = "card_transactions_transaction_invalid_amount_option_express_money-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_subscription_visa_vai"(platform: "/mobile") {
            news_id = "/notification/card_subscription_visa_vai-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        
        "/notification/card_transactions_approved_partial_authorization"(platform: "/mobile") {
            news_id = "/notification/card_transactions_approved_partial_authorization-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_partial_authorization_mute"(platform: "/mobile") {
            news_id = "/notification/card_transactions_approved_partial_authorization_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_partial_authorization_nfc"(platform: "/mobile") {
            news_id = "/notification/card_transactions_approved_partial_authorization_nfc-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_partial_authorization_nfc_mute"(platform: "/mobile") {
            news_id = "/notification/card_transactions_approved_partial_authorization_nfc_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_cancelled_partial_authorization"(platform: "/mobile") {
            news_id = "/notification/card_transactions_cancelled_partial_authorization-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }


        "/notification/card_transactions_cancelled_partial_authorization_mute"(platform: "/mobile") {
            news_id = "/notification/card_transactions_cancelled_partial_authorization_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_cancelled_partial_authorization_nfc_mute"(platform: "/mobile") {
            news_id = "/notification/card_transactions_cancelled_partial_authorization_nfc_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_cancelled_partial_authorization_nfc"(platform: "/mobile") {
            news_id = "/notification/card_transactions_cancelled_partial_authorization_nfc-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/balance_inquiry"(platform: "/mobile") {
            news_id = "/notification/balance_inquiry-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/prepaid_card_transaction_invalid_amount_option_express_money"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_invalid_amount_option_express_money-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_withdraw_extracash"(platform: "/mobile") {
            news_id = "card_transactions_approved_withdraw_extracash-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/protected_purchase_order_reminder_purchase_protection"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }

        "/notification/card_limit_rejected_withdraw_by_maximum_limit"(platform: "/mobile") {
            news_id = "card_limit-rejected_withdraw_by_maximum_limit-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg-1565881200"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_balance_atm"(platform: "/mobile") {
            news_id = "card_transactions_balance_atm-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions-approved_authorization_whatsapp"(platform: "/mobile") {
            news_id = "card_transactions-approved_authorization_whatsapp-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions-approved_withdraw_mute"(platform: "/mobile") {
            news_id = "card_transactions-approved_withdraw_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions-fund_money_in_whatsapp"(platform: "/mobile") {
            news_id = "card_transactions-fund_money_in_whatsapp-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions-fund_money_in_whatsapp_mute"(platform: "/mobile") {
            news_id = "card_transactions-fund_money_in_whatsapp_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_payment_reject_whit_contactless"(platform: "/mobile") {
            news_id = "card_transactions_payment_reject_whit_contactless-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_authorization"(platform: "/mobile") {
            news_id = "card_transactions_approved_authorization-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_approved_authorization_with_partitions"(platform: "/mobile") {
            news_id = "card_transactions_approved_authorization_with_partitions-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_approved_withdraw"(platform: "/mobile") {
            news_id = "card_transactions_approved_withdraw-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_cancelled_authorization"(platform: "/mobile") {
            news_id = "card_transactions_cancelled_authorization-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_cancelled_authorization_with_partitions"(platform: "/mobile") {
            news_id = "card_transactions_cancelled_authorization_with_partitions-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_capture_exceed_amount"(platform: "/mobile") {
            news_id = "card_transactions_capture_exceed_amount-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_first_transaction_chip_pin"(platform: "/mobile") {
            news_id = "card_transactions_first_transaction_chip_pin-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_by_invalid_amount"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_by_invalid_amount-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_use_magnetic_stripe"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_use_magnetic_stripe-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_by_invalid_amount_with_partitions"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_by_invalid_amount_with_partitions-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_by_invalid_amount_with_unavailable_balance"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_by_invalid_amount_with_unavailable_balance-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_international_by_invalid_amount"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_international_by_invalid_amount-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_withdraw_by_invalid_amount"(platform: "/mobile") {
            news_id = "card_transactions_rejected_withdraw_by_invalid_amount-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_withdraw_by_invalid_amount_with_unavailable_balance"(platform: "/mobile") {
            news_id = "card_transactions_rejected_withdraw_by_invalid_amount_with_unavailable_balance-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_cancelled_withdraw"(platform: "/mobile") {
            news_id = "card_transactions_cancelled_withdraw-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_capture_after_ttl"(platform: "/mobile") {
            news_id = "card_transactions_capture_after_ttl-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_capture_expired_ttl"(platform: "/mobile") {
            news_id = "card_transactions_capture_expired_ttl-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_capture_less_than_amount"(platform: "/mobile") {
            news_id = "card_transactions_capture_less_than_amount-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_chargeback_reimbursed"(platform: "/mobile") {
            news_id = "card_transactions_chargeback_reimbursed-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_virtual_wrong_cvv"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_virtual_wrong_cvv-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_transaction_invalid_amount_option_credit"(platform: "/mobile") {
            news_id = "card_transactions_transaction_invalid_amount_option_credit-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_wallet_insufficient_account_balance"(platform: "/mobile") {
            news_id = "card_wallet_insufficient_account_balance-186785675"
            event_type = "open"
            notification_type= "deep_linking"
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
        "/notification/withdraw_approved"(platform: "/web") {
            news_id = "withdraw_approved-186785675"
            event_type = "open"
        }
        "/notification/withdraw_rejected"(platform: "/web") {
            news_id = "withdraw_rejected-186785675"
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
        "/notification/cancellations_warning_seller_too_many"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/cancellations_notice_delayed_reimbursement"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/cancellations_notice_cancelled_purchase"(platform: "/mobile") {
            event_type = "open"
        }
        "/notification/cancellations_notice_cancelled_purchase_proximity"(platform: "/mobile") {
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

        "/notification/payments_release"(platform: "/mobile") {
            notification_id = "12345"
            event_type = "open"
        }

        "/notification/installs_checker"(platform: "/mobile"){
            date_created= "2020-01-20T10:31:18.162-04:00"
            advertising_id= "4066c329-d684-4196-8db4-3633148fc1a5"
            event_type = "sent"
        }

        "/notification/uninstalls_checker"(platform: "/mobile"){
            execution_id= "160295629"
            advertising_id= "4066c329-d684-4196-8db4-3633148fc1a5"
            event_type = "sent"
        }

        "/notification_center/billing_iva_ganancias_reactive"(platform: "/mobile"){
            latest_news_type= "billing_iva_ganancias_reactive"
            latest_news_id= "billing_iva_ganancias_reactive-143816022-MLB1013046714"
        }
        "/notification_center/billing_newtaxhabituality"(platform: "/mobile"){
            latest_news_type= "billing_newtaxhabituality"
            latest_news_id= "billing_newtaxhabituality-143816022-MLB1013046714"
        }
        "/notification_center/billing_newtax"(platform: "/mobile"){
            latest_news_type= "billing_newtax"
            latest_news_id= "billing_newtax-143816022-MLB1013046714"
        }
        "/notification_center/billing_responsable_inscripto_reminder"(platform: "/mobile"){
            latest_news_type= "billing_responsable_inscripto_reminder"
            latest_news_id= "billing_responsable_inscripto_reminder-143816022-MLB1013046714"
        }
        "/notification_center/billing_iva_isr_meli"(platform: "/mobile"){
            latest_news_type= "billing_iva_isr_meli"
            latest_news_id= "billing_iva_isr_meli-143816022-MLB1013046714"
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

        "/notification_center/payments_release"(platform: "/mobile") {
            notification_id = "12345"
        }

        "/notification_center/discount_central_missing_data"(platform: "/mobile"){
            latest_news_type= "discount_central_missing_data"
            latest_news_id= "discount_central_missing_data-12345"
        }
        "/notification_center/sll_items_activate_items"(platform: "/web") {
            site_id="MLA"
            seller_id="1234567"
            items_count=5
            event_type = "open"
        }
        "/notification_center/subscription_expiring_notice"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_expiring_notice"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_option = "Citibanamex"
        }
        "/notification_center/subscription_payment_congrats"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_congrats"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_type = 'successful_payment'
            female_gender = true
        }
        "/notification_center/subscription_payment_error"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_error"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            error_type = "card_code"
            female_gender = true
        }
        "/notification_center/subscription_payment_instructions"(platform: "/mobile") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_instructions"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            payment_option = "Citibanamex"
            female_gender = true
        }
        "/notification_center/subscription_payment_pending"(platform: "/") {
            newsgroup_id = "subscription-hbo-186785675"
            latest_news_id= "subscription-hbo-186785675"
            latest_news_type= "subscription_payment_pending"
            status= "read"
            provider = "hbo"
            provider_name = "HBO GO"
            date = "20181211"
            female_gender = true
            payment_type = 'successful_payment'
        }

        "/notification/card_nip_first_try"(platform: "/mobile") {
            news_id = "card_nip_first_try-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_nip_second_try"(platform: "/mobile") {
            news_id = "card_nip_second_try-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_nip_nip_block"(platform: "/mobile") {
            news_id = "card_nip_nip_block-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_nip_set_nip"(platform: "/mobile") {
            news_id = "card_nip_set_nip-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_authorization_extracash"(platform: "/mobile") {
            news_id = "card_transactions_approved_authorization_extracash-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_authorization_extracash_mute"(platform: "/mobile") {
            news_id = "card_transactions_approved_authorization_extracash_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/cards_whatsapp_enrollment_confirmation"(platform: "/mobile") {
            news_id = "cards_whatsapp_enrollment_confirmation-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_cancelled_authorization_whatsapp"(platform: "/mobile") {
            news_id = "card_transactions_cancelled_authorization_whatsapp-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_cancelled_authorization_whatsapp_mute"(platform: "/mobile") {
            news_id = "card_transactions_cancelled_authorization_whatsapp_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_transaction_invalid_amount_option_express_money"(platform: "/mobile") {
            news_id = "card_transactions_transaction_invalid_amount_option_express_money-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        
        "/notification/card_subscription_visa_vai"(platform: "/mobile") {
            news_id = "/notification/card_subscription_visa_vai-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_partial_authorization"(platform: "/mobile") {
            news_id = "/notification/card_transactions_approved_partial_authorization-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_partial_authorization_mute"(platform: "/mobile") {
            news_id = "/notification/card_transactions_approved_partial_authorization_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_partial_authorization_nfc"(platform: "/mobile") {
            news_id = "/notification/card_transactions_approved_partial_authorization_nfc-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_partial_authorization_nfc_mute"(platform: "/mobile") {
            news_id = "/notification/card_transactions_approved_partial_authorization_nfc_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_cancelled_partial_authorization"(platform: "/mobile") {
            news_id = "/notification/card_transactions_cancelled_partial_authorization-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }


        "/notification/card_transactions_cancelled_partial_authorization_mute"(platform: "/mobile") {
            news_id = "/notification/card_transactions_cancelled_partial_authorization_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_cancelled_partial_authorization_nfc_mute"(platform: "/mobile") {
            news_id = "/notification/card_transactions_cancelled_partial_authorization_nfc_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_cancelled_partial_authorization_nfc"(platform: "/mobile") {
            news_id = "/notification/card_transactions_cancelled_partial_authorization_nfc-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/balance_inquiry"(platform: "/mobile") {
            news_id = "/notification/balance_inquiry-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        
        "/notification/prepaid_card_transaction_invalid_amount_option_express_money"(platform: "/mobile") {
            news_id = "prepaid_card_transaction_invalid_amount_option_express_money-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        
        "/notification/card_transactions_approved_authorization_extracash_mute"(platform: "/mobile") {
            news_id = "card_transactions_approved_authorization_extracash_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/protected_purchase_order_reminder_purchase_protection"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "open"
        }

        "/notification/card_limit_rejected_withdraw_by_maximum_limit"(platform: "/mobile") {
            news_id = "card_limit-rejected_withdraw_by_maximum_limit-51AO96HEQBssK6rdZvm1r3ZwvwMldsI1bhlDmv1rj4LrpP0Sn8nZGQMQ5pbTZBrg-1565881200"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_balance_atm"(platform: "/mobile") {
            news_id = "card_transactions_balance_atm-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions-approved_authorization_whatsapp"(platform: "/mobile") {
            news_id = "card_transactions-approved_authorization_whatsapp-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions-approved_withdraw_mute"(platform: "/mobile") {
            news_id = "card_transactions-approved_withdraw_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions-fund_money_in_whatsapp"(platform: "/mobile") {
            news_id = "card_transactions-fund_money_in_whatsapp-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions-fund_money_in_whatsapp_mute"(platform: "/mobile") {
            news_id = "card_transactions-fund_money_in_whatsapp_mute-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_payment_reject_whit_contactless"(platform: "/mobile") {
            news_id = "card_transactions_payment_reject_whit_contactless-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/card_transactions_approved_authorization"(platform: "/mobile") {
            news_id = "card_transactions_approved_authorization-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_approved_withdraw"(platform: "/mobile") {
            news_id = "card_transactions_approved_withdraw-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_cancelled_authorization"(platform: "/mobile") {
            news_id = "card_transactions_cancelled_authorization-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_capture_exceed_amount"(platform: "/mobile") {
            news_id = "card_transactions_capture_exceed_amount-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_first_transaction_chip_pin"(platform: "/mobile") {
            news_id = "card_transactions_first_transaction_chip_pin-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_by_invalid_amount"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_by_invalid_amount-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_use_magnetic_stripe"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_use_magnetic_stripe-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_by_invalid_amount_with_unavailable_balance"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_by_invalid_amount_with_unavailable_balance-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_international_by_invalid_amount"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_international_by_invalid_amount-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_withdraw_by_invalid_amount"(platform: "/mobile") {
            news_id = "card_transactions_rejected_withdraw_by_invalid_amount-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_withdraw_by_invalid_amount_with_unavailable_balance"(platform: "/mobile") {
            news_id = "card_transactions_rejected_withdraw_by_invalid_amount_with_unavailable_balance-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_cancelled_withdraw"(platform: "/mobile") {
            news_id = "card_transactions_cancelled_withdraw-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_capture_after_ttl"(platform: "/mobile") {
            news_id = "card_transactions_capture_after_ttl-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_capture_expired_ttl"(platform: "/mobile") {
            news_id = "card_transactions_capture_expired_ttl-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_capture_less_than_amount"(platform: "/mobile") {
            news_id = "card_transactions_capture_less_than_amount-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_chargeback_reimbursed"(platform: "/mobile") {
            news_id = "card_transactions_chargeback_reimbursed-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_rejected_authorization_virtual_wrong_cvv"(platform: "/mobile") {
            news_id = "card_transactions_rejected_authorization_virtual_wrong_cvv-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_transactions_transaction_invalid_amount_option_credit"(platform: "/mobile") {
            news_id = "card_transactions_transaction_invalid_amount_option_credit-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/card_wallet_insufficient_account_balance"(platform: "/mobile") {
            news_id = "card_wallet_insufficient_account_balance-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        //Registration
        "/notification/registration_under_age_authorized"(platform: "/mobile") {
            news_id = "registration_under_age_authorized-123"
            event_type = "shown"
        }
        "/notification/registration_under_age_rejected"(platform: "/mobile") {
            news_id = "registration_under_age_rejected-123"
            event_type = "shown"
        }
        "/notification/registry_recovery"(platform: "/mobile") {
            news_id = "registry_recovery-123"
            event_type = "shown"
        }

        "/notification_center/insurtech_imei_cancellation_advice"(platform: "/") {
            latest_news_type= "insurtech_imei_cancellation_advice"
            latest_news_id= "insurtech_imei_cancellation_advice-143816022-MLB1013046714"
        }

        "/notification/insurtech_imei_cancellation_advice"(platform: "/mobile") {
            news_id = "insurtech_imei_cancellation_advice_123"
            event_type = "open"
        }

        //Under Age
        "/notification/under_age_responsible_info"(platform: "/") {
            news_id = "under_age-responsible_info-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_responsible_authorization_legacy"(platform: "/") {
            news_id = "under_age_responsible_authorization_legacy-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_minor_rejected"(platform: "/") {
            news_id = "under_age_minor_rejected-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_minor_approved"(platform: "/") {
            news_id = "under_age_minor_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_responsible_info_ml"(platform: "/") {
            news_id = "under_age-responsible_info-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_responsible_authorization_legacy_ml"(platform: "/") {
            news_id = "under_age_responsible_authorization_legacy-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_minor_rejected_ml"(platform: "/") {
            news_id = "under_age_minor_rejected-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/under_age_minor_approved_ml"(platform: "/") {
            news_id = "under_age_minor_approved-186785675"
            event_type = "open"
            notification_type= "deep_linking"
        }

        //NFC

        "/notification/nfc_wallet"(platform: "/") {
            news_id = "1234-e567-MERCADOPAGO"
            event_type = "open"
            correlation_id = '1234e'
        }

        "/notification/nfc_command"(platform: "/") {
            news_id = "1234-e567-MERCADOPAGO"
            event_type = "open"
            command = 'fire_direct_enrollment'
        }

        "/notification/wallet_connect_binding_error"(platform: "/") {
            news_id = "wallet_connect-binding_error-84060496"
            event_type = "open"
            notification_type= "deep_linking"
        }

        "/notification/wallet_connect_binding_with_card_and_cash"(platform: "/") {
            news_id = "wallet_connect-binding_with_card_and_cash-84060496"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/wallet_connect_binding_with_cash"(platform: "/") {
            news_id = "wallet_connect-binding_with_cash-84060496"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/wallet_connect_rejected_payment"(platform: "/") {
            news_id = "wallet_connect-rejected_payment-84060496"
            event_type = "open"
            notification_type= "deep_linking"
        }
        "/notification/disbursement_kwai_received"(platform: "/") {
            news_id = "disbursement_kwai-received-12345678"
            event_type = "open"
        }
    }

    defaultBusiness = "mercadoenvios"
    test("Mobile Notifications mercadoenvios"){
        "/notification/driver_logistics_changed_address"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }
        "/notification/driver_logistics_send_returns"(platform: "/mobile") {
            news_id = "driver_logistics_send_returns-12332323"
            event_type = "arrived"
        }
        "/notification/driver_logistics_driver_with_route"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }

        "/notification/driver_logistics_retry_collect"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }

        "/notification/driver_logistics_retry_delivery"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }

        "/notification/messages_driver_logistics"(platform: "/mobile") {
            news_id = "12332323"
            event_type = "arrived"
        }

        "/notification/me_crowd_city_registration"(platform: "/mobile"){
            news_id = "me_crowd_city_registration-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_select_service_center_registration"(platform: "/mobile"){
            news_id = "me_crowd_select_service_center_registration-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_registration_incomplete"(platform: "/mobile"){
            news_id = "me_crowd_registration_incomplete-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_registration_complete"(platform: "/mobile"){
            news_id = "me_crowd_registration_complete-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_cnh_registration"(platform: "/mobile"){
            news_id = "me_crowd_cnh_registration-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_tutorial_registration"(platform: "/mobile"){
            news_id = "me_crowd_tutorial_registration-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_geo_city_registration"(platform: "/mobile"){
            news_id = "me_crowd_geo_city_registratoin-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_city_registration"(platform: "/mobile/android"){
            news_id = "me_crowd_city_registration-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_select_service_center_registration"(platform: "/mobile/android"){
            news_id = "me_crowd_select_service_center_registration-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_registration_incomplete"(platform: "/mobile/android"){
            news_id = "me_crowd_registration_incomplete-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_registration_complete"(platform: "/mobile/android"){
            news_id = "me_crowd_registration_complete-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_cnh_registration"(platform: "/mobile/android"){
            news_id = "me_crowd_cnh_registration-699997492-1611784275"
            event_type = "sent"
        }

        "/notification/me_crowd_tutorial_registration"(platform: "/mobile/android"){
            news_id = "me_crowd_tutorial_registration-699997492-1611784275"
            event_type = "sent"
        }
        "/notification/me_crowd_cnh_validation"(platform: "/mobile/android"){
            news_id = "me_crowd_cnh_validation-699997492-1611784275"
            event_type = "sent"
        }
        "/notification/messages_driver_extra"(platform: "/mobile/android"){
            news_id = "messages_driver_extra-699997492-1611784275"
            event_type = "sent"
        }
        "/notification/me_crowd_geo_city_registration"(platform: "/mobile/android"){
            news_id = "me_crowd_geo_city_registratoin-699997492-1611784275"
            event_type = "sent"
        }
        "/notification/me_campaigns_crowd_generic"(platform: "/mobile/android"){
            news_id = "me_campaigns_crowd_generic-123"
            event_type = "discarded"
            campaign_id = "MLA_ME_PRUEBA_G_20181211_CG"
            batch_id = "MLA_ME_PRUEBA_G_20181211"
            sent_date = "20181211"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLV515515631,MLV515515632,MLV515515633"
        }
        "/notification/me_campaigns_flex_generic"(platform: "/mobile/android"){
            news_id = "me_campaigns_flex_generic-123"
            event_type = "discarded"
            campaign_id = "MLA_ME_PRUEBA_G_20181211_CG"
            batch_id = "MLA_ME_PRUEBA_G_20181211"
            sent_date = "20181211"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLV515515631,MLV515515632,MLV515515633"
        }
        "/notification/me_campaigns_logistics_generic"(platform: "/mobile/android"){
            news_id = "me_campaigns_logistics_generic-123"
            event_type = "discarded"
            campaign_id = "MLA_ME_PRUEBA_G_20181211_CG"
            batch_id = "MLA_ME_PRUEBA_G_20181211"
            sent_date = "20181211"
            communication_id = "7bae547c-bb6b-4190-953e-4cf3907972b7"
            campaign_type = "adhoc"
            campaign_data = "MLV515515631,MLV515515632,MLV515515633"
        }
    }

}
