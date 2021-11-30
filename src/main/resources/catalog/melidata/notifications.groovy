package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1237"

      /**
       * NOTIFICATIONS TRAY
       **/
      "/notification"(platform: "/") {
          event_type(required: true,
            type: PropertyType.String,
            values: ["sent", "resent", "arrived", "received", "dismiss", "discarded", "open", "auto_dismiss", "shown", "action_open", "control", "carousel","purged_token", "swipe"],
            description: "Type of notification event")
          action_type(required: false,
            type: PropertyType.String,
            values: ["deeplinking", "directions", "favorite", "reply", "ask", "postpone", "twitter_bar", "picture", "answer", "messages", "vop", "claims", "received", "tracking", "shipping_print_label", "feedback", "buy"],
            description: "Type of the notification action")
          notification_type(required: false,
            type: PropertyType.String,
            values: ["deep_linking", "directions", "favorite", "reply", "ask", "postpone", "twitter_bar", "picture", "answer", "messages", "vop", "claims", "received", "tracking", "shipping_print_label", "feedback", "buy"],
            description: "Type of the notification")
          deeplink(required: false, 
            type: PropertyType.String,
            description: "The link were the notification should navigate to, if applies")

          //For event_type:autodismiss, indicates why the notification was dismissed
          source(required: false,
            type: PropertyType.String,
            values: ["notification_center","logout","overwrite","dismiss_notification"], description: "Source of the notification")

          discard_reason(required: false, 
          description: "The discarded reason of the notification", 
          values: ["invalid_payload","invalid_user", "settings_disabled"], 
          type: PropertyType.String)

          notification_created_error(required: false, description: "The notification created error", type: PropertyType.String)

          news_id(required: false, type: PropertyType.String, description: "Identifier of the notification generated")
          notification_style(required: false, type: PropertyType.String, description: "The notification style used when displaying the notification to the user.")

          status(required: false, type: PropertyType.String, values: ["read", "unread"], deprecated: true, description: "*Deprecated*: Just for old NotifCenter.")

          device_id(required: false, type: PropertyType.String, description: "The real device_id, may differ from device field")
          device_status(required: false, type: PropertyType.String, values: ["active", "not_engaged"], description: "Device status at the moment")

          context(required: false, type: PropertyType.String, description: "Context of the notification")

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
      "/notification/account_fund_approved_mlc_tc"(platform: "/") {}
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

    //Alwayson
    "/notification/alwayson_bsasa"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_bsash"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_cabaa"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_cabab"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_cabac"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_cabah"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_ivaa"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_ivab"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_ivah"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_sirtaca"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_sirtacb"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_sirtacc"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }
    "/notification/alwayson_sirtach"(platform: "/") {
        sent_date(required: true, type: PropertyType.String, description: "Sent date")
    }

    //Claims 2.0
    //Collection
    "/notification/claim_pdd_first_rescue"(platform: "/") {}
    "/notification/claim_closed_seller_refund"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "Order Id.")
    }
    "/notification/claim_return_allowed_reminder_timeout"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "Order Id.")
    }
    "/notification/claim_return_allowed_seller_action"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "Order Id.")
    }
    "/notification/claim_pdd_second_rescue"(platform: "/") {}
    "/notification/claim_return_allowed_seller_action_decorator"(platform: "/") {}
    "/notification/claim_return_allowed_reminder_timeout_decorator"(platform: "/") {}
    "/notification/claim_closed_seller_refund_decorator"(platform: "/") {}
    "/notification/claim_complainant_to_respondent_message"(platform: "/") {}
    "/notification/claim_respondent_to_complainant_message"(platform: "/") {}

    // Credits - Credit Card
    // Collection
    "/notification/credit_card_adhoc_communication"(platform: "/") {}
    "/notification/credit_card_transaction_chout_purchase"(platform: "/") {}
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
    "/notification/credit_card_compulsory_debit_equal_min_payment"(platform: "/") {}
    "/notification/credit_card_compulsory_debit_less_min_payment"(platform: "/") {}
    "/notification/credit_card_compulsory_debit_money_refund"(platform: "/") {}

    // Overlimit
    "/notification/credit_card_overlimit_active"(platform: "/") {}
    "/notification/credit_card_overlimit_inactive"(platform: "/") {}

    // Transaction
    "/notification/credit_card_transaction_acquisition"(platform: "/") {}
    "/notification/credit_card_transaction_choff_purchase"(platform: "/") {}
    "/notification/credit_card_transaction_statement_payment"(platform: "/") {}
    "/notification/credit_card_transaction_purchase"(platform: "/") {}
    "/notification/credit_card_transaction_withdrawal"(platform: "/") {}
    "/notification/credit_card_transaction_kyc_onboarding"(platform: "/") {}
    "/notification/credit_card_waitlist_10"(platform: "/") {}
    "/notification/credit_card_waitlist_40"(platform: "/") {}
    "/notification/credit_card_waitlist_blacklist"(platform: "/") {}

    // CardUpdater
    "/notification/card_updater_expiry"(platform: "/mobile") { }
    "/notification/card_updater_update"(platform: "/mobile") { }

      //ChargeBack
      "/notification/chargeback_payer_high_agree_repayment_mp"(platform: "/") {
          case_id(required: true, type: PropertyType.String, description: "Case Id")
      }

      "/notification/credits_consumer_about_to_expire_second_notice"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }
    "/notification/card_transactions_rejected_authorization_use_magnetic_stripe"(platform: "/") {}
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
      "/notification/credits_consumer_about_to_expire_first_mp_notice"(platform: "/") {
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
      }
      "/notification/credits_consumer_about_to_expire_mp_second_notice"(platform: "/") {
          loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
          installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
      }
      "/notification/credits_consumer_closing_date_mp_notice"(platform: "/") {
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
    "/notification/credits_consumer_congrats_personal_loans"(platform: "/") {}
    "/notification/credits_consumer_registration_journey_mp"(platform: "/") {}
    "/notification/credits_consumer_expired_mp_first_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_expired_mp_fortyfive_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_expired_mp_fourth_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_expired_mp_second_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_expired_mp_third_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_expired_last_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_expired_n_loans_last_notice"(platform: "/") {}
    "/notification/credits_consumer_expired_sixty_mp_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_first_time_use_mp_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_on_due_day_mp_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_consumer_on_due_day_notice"(platform: "/") {
        loan_id(required: true, type: PropertyType.Numeric, description: "Id of loan.")
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }

    "/notification/credits_consumer_onboarding_mp_notice"(platform: "/") {}
    "/notification/credits_consumer_onboarding_notice"(platform: "/") {}

    "/notification/credits_consumer_opt_in_telcel_data_privacy"(platform: "/") {}
    "/notification/credits_consumer_congrats_microlines"(platform: "/") {}

      "/notification/credits_consumer_expired_n_loans_first_notice"(platform: "/") {}
      "/notification/credits_consumer_about_to_expire_n_loans_first_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_n_loans_fourth_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_n_loans_second_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_n_loans_third_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_fortyfive_notice"(platform: "/") {}
      "/notification/credits_consumer_expired_sixty_notice"(platform: "/") {}

    "/notification/credits_consumer_expired_eighty_notice"(platform: "/") {}
    "/notification/credits_consumer_expired_two_notice"(platform: "/") {}
    "/notification/credits_consumer_expired_nine_notice"(platform: "/") {}
    "/notification/credits_consumer_expired_fifteen_notice"(platform: "/") {}
    "/notification/credits_consumer_expired_on_due_date_notice"(platform: "/") {}
    "/notification/credits_consumer_expired_thirteen_notice"(platform: "/") {}
    "/notification/credits_consumer_expired_twentythree_notice"(platform: "/") {}
    "/notification/credits_consumer_expired_thirtyone_notice"(platform: "/") {}
    "/notification/credits_consumer_expired_ninety_notice"(platform: "/") {}

    // Chatbot
    "/notification/credits_consumer_chatbot_how_to_use"(platform: "/") {}
    "/notification/credits_consumer_chatbot_requirements"(platform: "/") {}
    "/notification/credits_consumer_chatbot_how_to_pay"(platform: "/") {}
    "/notification/credits_consumer_chatbot_credit_limit"(platform: "/") {}
    "/notification/credits_consumer_chatbot_financing_rate"(platform: "/") {}
    "/notification/credits_consumer_chatbot_duedate"(platform: "/") {}
    "/notification/credits_consumer_chatbot_purchase_trouble"(platform: "/") {}
    "/notification/credits_consumer_chatbot_mc_unavailable"(platform: "/") {}
    "/notification/credits_consumer_chatbot_less_money"(platform: "/") {}
    "/notification/credits_consumer_chatbot_early_payment"(platform: "/") {}
    "/notification/credits_consumer_chatbot_cancel_loan"(platform: "/") {}
    "/notification/credits_consumer_chatbot_payment_promise_info"(platform: "/") {}
    "/notification/credits_consumer_chatbot_accredited_time"(platform: "/") {}
    "/notification/credits_consumer_chatbot_initial_greeting"(platform: "/") {}
    "/notification/credits_consumer_chatbot_no_match"(platform: "/") {}
    "/notification/credits_consumer_chatbot_no_match_v2"(platform: "/") {}
    "/notification/credits_consumer_chatbot_ask_feedback"(platform: "/") {}
    "/notification/credits_consumer_chatbot_sensitive_info"(platform: "/") {}
    "/notification/credits_consumer_chatbot_appreciate"(platform: "/") {}
    "/notification/credits_consumer_chatbot_no_multimedia"(platform: "/") {}
    "/notification/credits_consumer_chatbot_feedback_numeric"(platform: "/") {}
    "/notification/credits_consumer_chatbot_feedback_written"(platform: "/") {}
    "/notification/credits_consumer_chatbot_feedback_omitted"(platform: "/") {}
    "/notification/credits_consumer_chatbot_early_payment"(platform: "/") {}
    "/notification/credits_consumer_chatbot_payment_promise"(platform: "/") {}
    "/notification/credits_consumer_chatbot_payment_promise_info_v2"(platform: "/") {}


      //Billing
      "/notification/billing_iva_ganancias_reactive"(platform: "/") {}
      "/notification/billing_newtax"(platform: "/") {}
      "/notification/billing_newtaxhabituality"(platform: "/") {}
      "/notification/billing_responsable_inscripto_reminder"(platform: "/") {}
      "/notification/billing_iva_isr_meli"(platform: "/") {}
      "/notification/billing_iva_isr"(platform: "/") {}
      "/notification/billing_iva_isr_mp"(platform: "/") {}

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

      //Melichat
      "/notification/melichat_message_mp"(platform: "/mobile") {
          case_id(required: true, type: PropertyType.Numeric, description: "Id of cx case.")
      }
      "/notification/melichat_message_ml"(platform: "/mobile") {
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
      "/notification/chargeback_payer_high_n_chargebacks_agree_repayment_ml"(platform: "/") {
          case_id(required: true, type: PropertyType.String, description: "Id of chargeback.")
      }

    //Data
    "/notification/da_kyc_manual_review"(platform: "/") {}
    "/notification/data_privacy_about_to_expire"(platform: "/") {}
    "/notification/data_privacy_extend_expiration"(platform: "/") {}
    "/notification/data_privacy_ready"(platform: "/") {}

    //Drive Logistics
    "/notification/driver_logistics_allocated_dock"(platform: "/") {}
    "/notification/driver_logistics_deassigned_dock"(platform: "/") {}
    "/notification/driver_logistics_modified_dock"(platform: "/") {}
    "/notification/driver_logistics_resend_allocated_dock"(platform: "/") {}

    "/notification/instore_discover_activities"(platform: "/") {}
    "/notification/instore_buyer_qr"(platform: "/") {}

    //Ingate Tokenization
    "/notification/ingate_tokenization_verification_code"(platform: "/") {}

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

    //Money in debin
    "/notification/moneyin_debin_approved"(platform: "/") {}
    "/notification/moneyin_debin_in_process"(platform: "/") {}
    "/notification/moneyin_debin_rejected"(platform: "/") {}

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

      "/notification/shipping_delivered_places_without_return"(platform: "/") {
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
    "/notification/shipping_handling_agency_unavailable"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_shipped_same_day"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    "/notification/shipping_shipped_same_day_scoring_key_pass"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    "/notification/shipping_shipped_waiting_for_confirmation"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    "/notification/shipping_soon_deliver_same_day"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    "/notification/shipping_soon_deliver_same_day_scoring_key_pass"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    "/notification/shipping_wrong_address_driver_action"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_agency_receiver_for_failed_delivery"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }

    //Same day

    "/notification/shipping_shipped_same_day"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_soon_deliver_same_day"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }
    "/notification/shipping_rts_in_packing_list"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }

    //Cancelaciones Parciales
    "/notification/shipping_delivered_partial_cancellations"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }

    "/notification/shipping_shipped_partial_cancellations"(platform: "/") {
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
      "/notification/orders_deliver_confirmation_newbie_seller"(platform: "/") {
          order_id(required: true, type: PropertyType.Numeric, description: "Order Id")
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
          execution_id(required: false, type: PropertyType.String, description: "Execution id.")
      }

      "/notification/campaigns_sms"(platform: "/") {
          segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
          experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
          communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
          communication_data(required: false, type: PropertyType.String, description: "Extra data")
          campaign_type(required: false, type: PropertyType.String, description: "Communication type")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
      }

      "/notification/mpcampaigns_sms"(platform: "/") {
          segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
          experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
          communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
          communication_data(required: false, type: PropertyType.String, description: "Extra data")
          campaign_type(required: false, type: PropertyType.String, description: "Communication type")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
      }

    "/notification/institutional_sms"(platform: "/") {
        segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
        experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
        communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
        communication_data(required: false, type: PropertyType.String, description: "Extra data")
        campaign_type(required: false, type: PropertyType.String, description: "Communication type")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
    }

    "/notification/mpinstitutional_sms"(platform: "/") {
        segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
        experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
        communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
        communication_data(required: false, type: PropertyType.String, description: "Extra data")
        campaign_type(required: false, type: PropertyType.String, description: "Communication type")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
    }

    "/notification/campaigns_wpp_sms"(platform: "/") {
        segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
        experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
        communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
        communication_data(required: false, type: PropertyType.String, description: "Extra data")
        campaign_type(required: false, type: PropertyType.String, description: "Communication type")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
    }

    "/notification/mpcampaigns_wpp_sms"(platform: "/") {
        segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
        experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
        communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
        communication_data(required: false, type: PropertyType.String, description: "Extra data")
        campaign_type(required: false, type: PropertyType.String, description: "Communication type")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
    }

    "/notification/institutional_wpp_sms"(platform: "/") {
        segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
        experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
        communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
        communication_data(required: false, type: PropertyType.String, description: "Extra data")
        campaign_type(required: false, type: PropertyType.String, description: "Communication type")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
    }

    "/notification/mpinstitutional_wpp_sms"(platform: "/") {
        segment_name(required: true, type: PropertyType.String, description: "Segment name of hermes communication")
        experiment_name(required: false, type: PropertyType.String, description: "Experiment name of hermes communication's segment")
        communication_id(required: true, type: PropertyType.String, description: "Hermes communication id.")
        communication_data(required: false, type: PropertyType.String, description: "Extra data")
        campaign_type(required: false, type: PropertyType.String, description: "Communication type")
        sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
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
      "/notification/me_flex_rehunting_reputation"(platform: "/") {}

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

      //MediationsV2
      "/notification/mediations_v2_pdd_dispute_with_timeout_buyer"(platform: "/") {
          claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
      }
      "/notification/mediations_v2_pdd_dispute_elected_action_reminder_buyer"(platform: "/") {
          claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
      }
      "/notification/mediations_v2_pdd_dispute_without_timeout_buyer"(platform: "/") {
          claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
      }
      "/notification/mediations_v2_pdd_dispute_with_timeout_seller"(platform: "/") {
          claim_id(required: true, type: PropertyType.Numeric, description:"Id of claim.")
      }
      "/notification/mediations_v2_pdd_dispute_without_timeout_seller"(platform: "/") {
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

      "/notification/vouchers_payments_refund"(platform: "/mobile") {}

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

      "/notification/payroll_portability_disabled"(platform: "/") {
          portability_id(required: true, type: PropertyType.String, description: "Portability Id")
      }

      "/notification/payroll_portability_first_notice"(platform: "/") {
          portability_id(required: true, type: PropertyType.String, description: "Portability Id")
      }

      "/notification/payroll_portability_second_notice"(platform: "/") {
          portability_id(required: true, type: PropertyType.String, description: "Portability Id")
      }

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

    "/notification/moneyin_cashin_accredited"(platform: "/") {}
    "/notification/moneyin_cashin_rejected"(platform: "/") {}

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
          campaign_id(required: true, type: PropertyType.String, description: "Id of the campaign related to the notification sent.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
          hash(required: false, type: PropertyType.String, description: "Hash of the message in claim check.")
          mantika_id(required: false, type: PropertyType.String, description: "Id of Mantika XP.")
          items_recommendations(required: false, type: PropertyType.String, description: "Items sent from recommendations.")
          items_history(required: false, type: PropertyType.String, description: "Items sent from history.")
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
          execution_id(required: false, type: PropertyType.String, description: "Execution id.")
      }

      "/notification/campaigns_schedule"(platform: "/") {
          campaign_id(required: true, type: PropertyType.String, description: "Id of the campaign related to the notification sent.")
          test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
          sent_date(required: true, type: PropertyType.String, description: "date of send notification.")
          batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
          campaign_type(required: true, type: PropertyType.String, description: "Campaign type")
          campaign_data(required: false, type: PropertyType.String, description: "Campaign data")
          communication_id(required: false, type: PropertyType.String, description: "Communication Id")
          schedule_id(required: true, type: PropertyType.String, description: "Schedule Id")
          schedule_date(required: true, type: PropertyType.String, description: "Schedule date")
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
      "/notification/fraud_kyc_validation"(platform: "/") {}

      //Fraud Remedies
      "/notification/fraud_remedies_identity_start_second_score"(platform: "/") {}
      "/notification/fraud_remedies_identity_reminder_second_score"(platform: "/") {}
      "/notification/fraud_remedies_card_start_second_score"(platform: "/") {}
      "/notification/fraud_remedies_card_reminder_second_score"(platform: "/") {}


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
    "/notification/returns_return_to_buyer_shipped"(platform: "/") {
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
    "/notification/returns_return_cancelled_buyer"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
    }
    "/notification/returns_return_failed_return_to_buyer"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
    }
    "/notification/returns_return_delivered_long_way"(platform: "/") {
        order_id(required: true, type: PropertyType.Numeric, description: "Id of order.")
    }
    "/notification/returns_return_failed_shipment_not_delivered"(platform: "/") {
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
    "/notification_center/asset_management_missing_docs"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification/asset_management_warm_up"(platform: "/mobile") {}
    "/notification/asset_management_investing"(platform: "/mobile") {}
    "/notification/asset_management_pending"(platform: "/mobile") {}
    "/notification/asset_management_disabled"(platform: "/mobile") {}
    "/notification/asset_management_failed"(platform: "/mobile") {}
    "/notification/asset_management_rejected"(platform: "/mobile") {}
    "/notification/asset_management_underage_approved"(platform: "/mobile") {}
    "/notification/asset_management_underage_rejected"(platform: "/mobile") {}
    "/notification/asset_management_underage_request"(platform: "/mobile") {}
    "/notification/asset_management_missing_docs"(platform: "/mobile") {}


    //Campañas
    "/notification/mpcampaigns_campaigns"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
        campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
        sent_date(required: false, type: PropertyType.String, description: "Campaign sent date.")
        execution_id(required: false, type: PropertyType.String, description: "Execution id.")
    }
    "/notification/mpcampaigns_control_group"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
        test_notification(required: false, type: PropertyType.Boolean, description: "Indicates if notification is for test")
        sent_date(required: false, type: PropertyType.String, description: "Campaign sent date.")
        batch_id(required: false, type: PropertyType.String, description: "Id of batch.")
        deal_id(required: false, type: PropertyType.String, description: "Id of deal.")
        execution_id(required: false, type: PropertyType.String, description: "Execution id.")
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

    "/notification/subscription_free_content_grace_period"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Failure for the first payment attempt on the subscription.")
    }
    "/notification/subscription_free_content_level_drop"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: false, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification/subscription_free_content_previous"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: false, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification/subscription_free_content_payment_pending"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Failure due to second payment attempt on subscription.")
    }

    "/notification/subscription_free_content_last_day_to_pay"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: false, type: PropertyType.String, description: "Date of the notification sent.")
        type(required: false, type: PropertyType.String, description: "Failure for the last payment attempt on the subscription.")
    }

    "/notification/subscription_payment_congrats"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        payment_type(required: true, type: PropertyType.String, description: "Payment pending type.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification/subscription_payment_error"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender")
        error_type(required: true, type: PropertyType.String, description: "Error type")
    }
    "/notification/subscription_payment_instructions"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
        payment_option(required: true, type: PropertyType.String, description: "Payment option.")
    }
    "/notification/subscription_payment_pending"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        payment_type(required: true, type: PropertyType.String, description: "Payment pending type.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification/subscription_disney_activation_on"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification/subscription_disney_activation_off"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }
    "/notification/subscription_disney_activation_free_trial"(platform: "/mobile") {
        provider(required: true, type: PropertyType.String, description: "Provider of the subscription.")
        provider_name(required: true, type: PropertyType.String, description: "Provider name of the subscription.")
        date(required: true, type: PropertyType.String, description: "Date of the notification sent.")
        female_gender(required: true, type: PropertyType.Boolean, description: "Female Gender.")
    }

    "/notification/mp_sponsor_campaign_start_campaign"(platform: "/mobile") {
        campaign_id(required: false, type: PropertyType.String, description:"Corresponds to the campaign_id of the newsgroup that is showing.")
        end_date(required: false, type: PropertyType.String, description:"Corresponds to the end_date the newsgroup that is showing.")
    }
    "/notification/mp_sponsor_campaign_budget_trigger"(platform: "/mobile") {
        campaign_id(required: false, type: PropertyType.String, description:"Corresponds to the campaign_id of the newsgroup that is showing.")
        end_date(required: false, type: PropertyType.String, description:"Corresponds to the end_date the newsgroup that is showing.")
    }
    "/notification/mp_sponsor_campaign_day_trigger"(platform: "/mobile") {
        campaign_id(required: false, type: PropertyType.String, description:"Corresponds to the campaign_id of the newsgroup that is showing.")
        end_date(required: false, type: PropertyType.String, description:"Corresponds to the end_date the newsgroup that is showing.")
    }
    "/notification/mp_seller_campaign_start_campaign"(platform: "/mobile") {}
    "/notification/mp_seller_campaign_end_campaign"(platform: "/mobile") {}
    "/notification/mp_seller_marketplace_must"(platform: "/mobile") {}
    "/notification/mp_seller_generic_wish"(platform: "/mobile") {}
    "/notification/mp_seller_discount_center_must"(platform: "/mobile") {}
    "/notification/mp_seller_campaign_resume_campaign"(platform: "/") {}

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
    "/notification/credits_merchants_spl_expired_05_push"(platform: "/") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_spl_expired_45_push"(platform: "/") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_spl_to_expire_00_push"(platform: "/") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_spl_to_expire_01_push"(platform: "/") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_spl_to_expire_10_push"(platform: "/") {
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

    //Dismiss
    "/notification/dismiss"(platform: "/") {}

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
    "/notification/merchants_growth_reverse_screening_fraud"(platform: "/mobile") {}
    "/notification/merchants_growth_reverse_screening_conflict"(platform: "/mobile") {}
    "/notification/merchants_growth_pricing_point_scl_down"(platform: "/mobile") {}
    "/notification/merchants_growth_pricing_point_scl_onboarding"(platform: "/mobile") {}
    "/notification/merchants_growth_pricing_point_scl_maintain"(platform: "/mobile") {}
    "/notification/merchants_growth_pricing_point_scl_up"(platform: "/mobile") {}

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
    "/notification/killers_winner_item_lost"(platform: "/") {}
    "/notification/killers_losing_item_buybox"(platform: "/mobile") {}
    "/notification/killers_loser_item_new"(platform: "/mobile") {}

    //kyc
    "/notification/kyc_handoff_user_notification_ml"(platform: "/") {}
    "/notification/kyc_handoff_user_notification_mp"(platform: "/mobile") {}
    "/notification/kyc_user_notification_mp"(platform: "/mobile") {}
    "/notification/kyc_user_notification_ml"(platform: "/") {}
    "/notification/kyc_bo_success"(platform: "/mobile") {}
    "/notification/kyc_afip_user_notification_mp"(platform: "/mobile") {}
    "/notification/kyc_bo_success"(platform: "/") {}

    //Money
    "/notification/money_transfer_received"(platform: "/mobile") {}
    "/notification/money_transfer_request"(platform: "/mobile") {}
    "/notification/money_transfer_sender"(platform: "/") {}

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

    //Cards Hybrid
    "/notification/card_first_use_incentive_nfc_first_day_am"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_nfc_first_day_no_am"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_nfc_fifth_day_am"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_nfc_fifth_day_no_am"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_nfc_fifth_day_am_virtual_inactive"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_nfc_fifth_day_no_am_virtual_inactive"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_nfc_seventh_day_no_am"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_nfc_seventh_day_am"(platform: "/mobile") {}
    "/notification/card_request_challenge_pending"(platform: "/") {}
    "/notification/card_request_challenge_pre_expired"(platform: "/") {}
    "/notification/card_first_use_incentive_thirdth_day"(platform: "/") {}
    "/notification/card_correios_strike_delayed"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_first_day"(platform: "/") {}
    "/notification/card_first_use_incentive_thirdth_day"(platform: "/") {}
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
    "/notification/card_kyc_data_completed_nfc_acquisition"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_physical_acquisition"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_unlock"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_virtual"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_prepaid_acquisition_first"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_prepaid_acquisition_second"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_prepaid_acquisition_third"(platform: "/mobile") {}
    "/notification/card_kyc_data_completed_virtual_acquisition"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_zero_day_owner"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_zero_day_point"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_zero_day_somewhere"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_zero_day_known_person"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_zero_day"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_second_day"(platform: "/mobile") {
        has_money(required: true, type: PropertyType.Boolean)
    }
    "/notification/card_unlock_incentive_fifth_day"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_fifteenth_day"(platform: "/mobile") {}
    "/notification/card_unlock_incentive_twentyfifth_day"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_ready_to_ship"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_shipped"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_soon_deliver"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_delayed"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_branch"(platform: "/mobile") {}
    "/notification/card_delivery_tracking_not_delivered"(platform: "/") {
        branch_time_elapsed(required: true, type: PropertyType.Boolean, description: "Branch Time Elapsed")
    }
    "/notification/cards_send_card"(platform: "/mobile") {}
    "/notification/card_compromised_virtual"(platform: "/mobile") {}
    "/notification/card_compromised_physical"(platform: "/mobile") {}
    "/notification/card_nip_first_try"(platform: "/mobile") {}
    "/notification/card_nip_second_try"(platform: "/mobile") {}
    "/notification/card_nip_nip_block"(platform: "/mobile") {}
    "/notification/card_nip_set_nip"(platform: "/mobile") {}
    "/notification/card_wallet_resume_token"(platform: "/mobile") {}
    "/notification/card_transactions_approved_authorization_extracash"(platform: "/mobile") {}
    "/notification/card_transactions_approved_authorization_extracash_mute"(platform: "/mobile") {}
    "/notification/cards_whatsapp_enrollment_confirmation"(platform: "/mobile") {}
    "/notification/card_transactions_approved_withdraw_extracash"(platform: "/mobile") {}
    "/notification/card_transactions_cancelled_authorization_whatsapp"(platform: "/mobile") {}
    "/notification/card_transactions_cancelled_authorization_whatsapp_mute"(platform: "/mobile") {}
    "/notification/card_transactions_transaction_invalid_amount_option_express_money"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_invalid_amount_option_express_money"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_capture_after_ttl"(platform: "/") {}
    "/notification/prepaid_card_transaction_capture_less_than_amount"(platform: "/") {}
    "/notification/card_subscription_visa_vai"(platform: "/mobile") {}
    "/notification/card_transactions_approved_partial_authorization"(platform: "/mobile") {}
    "/notification/card_transactions_approved_partial_authorization_mute"(platform: "/mobile") {}
    "/notification/card_transactions_approved_partial_authorization_nfc"(platform: "/mobile") {}
    "/notification/card_transactions_approved_partial_authorization_nfc_mute"(platform: "/mobile") {}
    "/notification/card_transactions_cancelled_partial_authorization"(platform: "/mobile") {}
    "/notification/card_transactions_cancelled_partial_authorization_mute"(platform: "/mobile") {}
    "/notification/card_transactions_cancelled_partial_authorization_nfc"(platform: "/mobile") {}
    "/notification/card_transactions_cancelled_partial_authorization_nfc_mute"(platform: "/mobile") {}
    "/notification/balance_inquiry"(platform: "/mobile") {}


    // PREPAID, HYBRID, MPCARD
    "/notification/card_transactions_payment_authorization"(platform: "/mobile") {}

    //Cards Prepaid
    "/notification/card_transactions_balance_atm"(platform: "/mobile") {}
    "/notification/card_transactions_payment_reject_whit_contactless"(platform: "/mobile") {}

    "/notification/card_transactions_approved_authorization"(platform: "/mobile") {}
    "/notification/card_transactions_approved_authorization_with_partitions"(platform: "/mobile") {}
    "/notification/card_transactions_approved_withdraw"(platform: "/mobile") {}
    "/notification/card_transactions_cancelled_authorization"(platform: "/mobile") {}
    "/notification/card_transactions_cancelled_authorization_with_partitions"(platform: "/mobile") {}
    "/notification/card_transactions_capture_exceed_amount"(platform: "/mobile") {}
    "/notification/card_transactions_first_transaction_chip_pin"(platform: "/mobile") {}
    "/notification/card_transactions_rejected_authorization_by_invalid_amount"(platform: "/mobile") {}
    "/notification/card_transactions_rejected_authorization_by_invalid_amount_with_partitions"(platform: "/mobile") {}
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
    "/notification/card_transactions_approved_authorization_whatsapp"(platform: "/") {}
    "/notification/card_transactions_fund_money_in_whatsapp"(platform: "/") {}
    "/notification/card_transactions_rejected_authorization_virtual_already_cancelled"(platform: "/") {}
    "/notification/card_transactions_rejected_authorization_virtual_inactive"(platform: "/") {}
    "/notification/card_transactions_rejected_withdraw_international_by_invalid_amount"(platform: "/") {}

    "/notification/card_wallet_insufficient_account_balance"(platform: "/mobile") {}

    "/notification/card_prepaid_tracking_ready_to_ship"(platform: "/mobile") {}
    "/notification/card_prepaid_tracking_ready_to_ship_challenged"(platform: "/mobile") {}
    "/notification/card_prepaid_tracking_shipped"(platform: "/mobile") {}
    "/notification/card_prepaid_tracking_delivered"(platform: "/mobile") {}
    "/notification/card_prepaid_tracking_reprogrammed"(platform: "/mobile") {}
    "/notification/card_prepaid_tracking_soon_deliver"(platform: "/mobile") {}
    "/notification/card_prepaid_tracking_delayed"(platform: "/mobile") {}
    "/notification/card_prepaid_tracking_delayed_extended"(platform: "/mobile") {}
    "/notification/card_prepaid_tracking_branch_with_address"(platform: "/mobile") {}
    "/notification/card_prepaid_tracking_not_delivered"(platform: "/") {
        branch_case(required: true, type: PropertyType.Boolean, description: "Has been in a branch office before")
    }

    //Cards NFC
    "/notification/nfc_wallet"(platform: "/") {
        correlation_id(required: true, type: PropertyType.String, description: "Correlation Id")
    }
    "/notification/nfc_command"(platform: "/") {
        command(required: true, type: PropertyType.String, description: "Command")
    }

    //Prepaidbuild.gradle
    "/notification/prepaid_card_shipped"(platform: "/mobile") {}
    "/notification/prepaid_card_waiting_for_withdrawal"(platform: "/mobile") {}
    "/notification/prepaid_card_delivered"(platform: "/mobile") {}
    "/notification/prepaid_card_delayed_p1"(platform: "/mobile") {}
    "/notification/prepaid_card_not_delivered"(platform: "/mobile") {}
    "/notification/prepaid_card_delivery"(platform: "/mobile") {}
    "/notification/prepaid_card_soon_deliver"(platform: "/mobile") {}
    "/notification/prepaid_card_reprogrammed"(platform: "/mobile") {}

    "/notification/prepaid_card_transaction_rejected_for_not_transaction"(platform: "/mobile") {}
    "/notification/prepaid_card_third_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_second_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_invalid_pin"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_for_fee"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount_smaller_that_fee"(platform: "/mobile") {}
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
    "/notification/prepaid_card_challenge_bolbradesco_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_red_link_bug"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_authorization_by_invalid_amount"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_international_authorization_by_invalid_amount"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_international_authorization_by_fraud_prevention"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_withdraw_by_invalid_amount"(platform: "/mobile") {}
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

    // Pix mediations
    "/notification/pix_mediation_blocked_amount"(platform: "/mobile") {
        payment_id(required: true, type: PropertyType.String, description: "Payment Id")
        activity_id(required: true, type: PropertyType.String, description: "Activity Id")
    }
    "/notification/pix_mediation_unblocked_amount"(platform: "/mobile") {
        payment_id(required: true, type: PropertyType.String, description: "Payment Id")
        activity_id(required: true, type: PropertyType.String, description: "Activity Id")
    }
    "/notification/pix_mediation_refunded"(platform: "/mobile") {
        payment_id(required: true, type: PropertyType.String, description: "Payment Id")
        activity_id(required: true, type: PropertyType.String, description: "Activity Id")
    }

    "/notification_center/pix_mediation_blocked_amount"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        payment_id(required: true, type: PropertyType.String, description: "Payment Id")
        activity_id(required: true, type: PropertyType.String, description: "Activity Id")
    }
    "/notification_center/pix_mediation_unblocked_amount"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        payment_id(required: true, type: PropertyType.String, description: "Payment Id")
        activity_id(required: true, type: PropertyType.String, description: "Activity Id")
    }
    "/notification_center/pix_mediation_refunded"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
        payment_id(required: true, type: PropertyType.String, description: "Payment Id")
        activity_id(required: true, type: PropertyType.String, description: "Activity Id")
    }


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
    "/notification/point_qr_login_new"(platform: "/") {}
    "/notification/point_fill_in"(platform: "/") {}

    //ShippingOff
    "/notification/mp_shipping_label"(platform: "/mobile"){}
    "/notification/mp_shipping_not_delivered"(platform: "/mobile"){}
    "/notification/mp_shipping_on_way"(platform: "/mobile"){}

    //ShippingOff
    "/notification/mp_shipping_label"(platform: "/mobile"){}
    "/notification/mp_shipping_not_delivered"(platform: "/mobile"){}
    "/notification/mp_shipping_on_way"(platform: "/mobile"){}

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
    "/notification/single_player_utility_refused_am"(platform: "/") {}
    "/notification/single_player_utility_refused_cc"(platform: "/") {}

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
    "/notification/single_player_balance_expiration_transport_mp"(platform: "/mobile") {}
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
    "/notification/single_player_payg_create_device_fail_mp"(platform: "/") {}
    "/notification/single_player_payg_blocked_device_mp"(platform: "/mobile") {}
    "/notification/single_player_payg_cashback_mp"(platform: "/mobile") {}
    "/notification/single_player_payg_change_device_number_success_mp"(platform: "/mobile") {}
    "/notification/single_player_payg_change_device_number_fail_mp"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_grouped_rejected"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_grouped_reminder"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_grouped_success"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_solo_rejected"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_solo_reminder"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_utility_solo_success"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_pixtransfer_grouped_insufficient_amount"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_pixtransfer_solo_insufficient_amount"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_pixtransfer_grouped_reminder"(platform: "/mobile") {}
    "/notification/single_player_scheduled_payment_pixtransfer_solo_reminder"(platform: "/mobile") {}

    //Single player - Self-Service
    "/notification/single_player_self_service_schedule_new_debt"(platform: "/mobile") {
        debt_id(required: true, type: PropertyType.Numeric, description: "Corresponds to the id of the debt payer that is showing")
        seller_name(required: true, type: PropertyType.String, description: "Corresponds to the name of the seller that is showing")
    }

    //Shipping
    "/notification/shipping_moderation_cross_docking_release_below"(platform: "/") {}
    "/notification/shipping_moderation_cross_docking_recovery"(platform: "/") {}
    "/notification/shipping_moderation_cross_docking_downgrade"(platform: "/") {}
    "/notification/shipping_rts_in_packing_list"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    "/notification/shipping_shipped_bad_address"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    "/notification/shipping_shipped_outside_me"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }
    "/notification/shipping_shipped_bad_address_on_way"(platform: "/") {
        shipment_id(required: true, type: PropertyType.Numeric, description: "Corresponds to Id of shipment.")
    }

    //Shipping-Scoring
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

    //Wallet connect
    "/notification/wallet_connect_binding_error"(platform: "/") {}
    "/notification/wallet_connect_binding_with_card_and_cash"(platform: "/") {}
    "/notification/wallet_connect_binding_with_cash"(platform: "/") {}
    "/notification/wallet_connect_rejected_payment"(platform: "/") {}

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

    //Under age
    "/notification/under_age_responsible_info"(platform: "/") {}
    "/notification/under_age_responsible_authorization_legacy"(platform: "/") {}
    "/notification/under_age_minor_rejected"(platform: "/") {}
    "/notification/under_age_minor_approved"(platform: "/") {}
    "/notification/under_age_responsible_info_ml"(platform: "/") {}
    "/notification/under_age_responsible_authorization_legacy_ml"(platform: "/") {}
    "/notification/under_age_minor_rejected_ml"(platform: "/") {}
    "/notification/under_age_minor_approved_ml"(platform: "/") {}

    "/notification/institutional_generic"(platform: "/") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
        campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
        sent_date(required: false, type: PropertyType.String, description: "")
    }
    "/notification/mpinstitutional_generic"(platform: "/") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: true, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
        campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
        sent_date(required: false, type: PropertyType.String, description:"")
    }

    "/notification/institutional_control_group"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        communication_id(required: false, type: PropertyType.String, description: "Hermes communication id")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign Type.")
        campaign_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
        sent_date(required: false, type: PropertyType.String, description:"")
    }

    "/notification/mpinstitutional_control_group"(platform: "/mobile") {
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
    "/notification/insurtech_cancellation"(platform: "/mobile") {}
    "/notification/insurtech_purchase"(platform: "/mobile") {}
    "/notification/insurtech_new_claim"(platform: "/mobile") {}
    "/notification/insurtech_payment_recovery"(platform: "/mobile") {}
    "/notification/insurtech_money_in"(platform: "/mobile") {}
    "/notification/insurtech_imei_cancellation_advice"(platform: "/mobile") {}
    "/notification/insurtech_payment_recovery_cards"(platform: "/mobile") {}
    "/notification/insurtech_kyc_roda_pre_activacion"(platform: "/") {}
    "/notification/insurtech_pending_payment"(platform: "/") {}

    // Abandoned Cart
    "/notification/abandoned_cart_buyer"(platform: "/mobile") {}

    "/notification/abandoned_cart_link_payer"(platform: "/mobile") {}

    //Registration
    "/notification/registration_under_age_authorized"(platform: "/mobile") {}
    "/notification/registration_under_age_rejected"(platform: "/mobile") {}
    "/notification/registry_recovery"(platform: "/mobile") {}

    // Proximity Marketplace Order Manager
    "/notification/pm_om_notification_store_opening"(platform: "/") {}
    "/notification/pm_om_notification_store_opening_retry"(platform: "/") {}
    "/notification/pm_om_notification_new_sale"(platform: "/") {}
    "/notification/pm_om_notification_new_sale_retry"(platform: "/") {}
    "/notification/pm_om_notification_buyer_cancellation"(platform: "/") {}
    "/notification_center/pm_om_notification-store_opening"(platform: "/", type: TrackType.Event) {
        news_id(required: true, type: PropertyType.String, description: "Corresponds to Id of notification.")
    }
    "/notification_center/pm_om_notification-new_sale"(platform: "/", type: TrackType.Event) {
        news_id(required: true, type: PropertyType.String, description: "Corresponds to Id of notification.")
    }
    "/notification_center/pm_om_notification-buyer_cancellation"(platform: "/", type: TrackType.Event) {
        news_id(required: true, type: PropertyType.String, description: "Corresponds to Id of notification.")
    }

    // Delay Compensation
    "/notification/shipping_delay_compensation_cashback"(platform: "/"){
        shipment_id(required: true, type: PropertyType.Numeric, description: "Id of shipment.")
    }

    // Disbursement Kwai
    "/notification/disbursement_kwai_received"(platform: "/") {}
    
    // Money In CCA
    "/notification_center/moneyin_cca_approved"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification_center/moneyin_cca_rejected"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description: "Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
    "/notification/moneyin_cca_approved"(platform: "/") {}
    "/notification/moneyin_cca_rejected"(platform: "/") {}

    // Cards virtual
    "/notification/card_first_use_incentive_virtual_first_day_am"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_virtual_first_day_no_am"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_virtual_fifth_day_am"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_virtual_fifth_day_no_am"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_virtual_fifth_day_am_nfc_inactive"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_virtual_fifth_day_no_am_nfc_inactive"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_virtual_seventh_day_no_am"(platform: "/mobile") {}
    "/notification/card_first_use_incentive_virtual_seventh_day_am"(platform: "/mobile") {}

    "/notification_center/card_first_use_incentive_virtual"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }

    "/notification_center/card_first_use_incentive_nfc"(platform: "/", type: TrackType.Event) {
        latest_news_type(required: true, type: PropertyType.String, description: "Corresponds to the type of the latest news of the newsgroup that is showing.")
        latest_news_id(required: true, type: PropertyType.String, description:"Corresponds to the id of the latest news of the newsgroup that is showing.")
    }
}
