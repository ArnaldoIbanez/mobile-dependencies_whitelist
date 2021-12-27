package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks

  {
      initiative = "1047"

      def crypto_info_amount_definition = objectSchemaDefinitions {
          price(
            description: "Current price of the cryptocurrency",
            type:  PropertyType.Numeric,
            required: true
          )
          variation(
            description: "Percentage variation of the crypto currency",
            type:  PropertyType.Numeric,
            required: true
          )
          holdings(
            description: "Holding the cryptocurrency",
            type:  PropertyType.Numeric,
            required: true
          )

        }

      def crypto_definition = objectSchemaDefinitions {
          melicoin(
                  description: "Data about crypto Melicoin",
                  type:  PropertyType.Map(crypto_info_amount_definition),
                  required: false
          )
          bitcoin(
                  description: "Data about crypto Bitcoin",
                  type: PropertyType.Map(crypto_info_amount_definition),
                  required: false
          )
          ethereum(
                  description: "Data about crypto Ethereum",
                  type: PropertyType.Map(crypto_info_amount_definition),
                  required: false
          )
          usdp(
                  description: "Data about crypto USDP",
                  type: PropertyType.Map(crypto_info_amount_definition),
                  required: false
          )
      }

      def quote_definition = objectSchemaDefinitions {
          quote_id(
                  description: "identifier of quote_id",
                  type:  PropertyType.String,
                  required: false
          )
          value(
                  description: "value of the quotation by currency",
                  type: PropertyType.Numeric,
                  required: false
          )
      }

      def payment_definition = objectSchemaDefinitions {
          id(
                  description: "Identificator of payment",
                  type:  PropertyType.String,
                  required: false
          )
          status(
                  description: "Status of payment",
                  type: PropertyType.String,
                  required: true
          )
          paid_amount(
                  description: "",
                  type:  PropertyType.Numeric,
                  required: false
          )
          payment_method(
                  description: "payment method",
                  type: PropertyType.String,
                  required: true
          )
      }

      def operation_definition = objectSchemaDefinitions {
          operation_type(
                  description: "Operation Type",
                  type: PropertyType.String,
                  required: true,
                  values:["sell_crypto", "buy_crypto"]
          )
          crypto(
                  description: "Name of Crypto Currency",
                  type: PropertyType.String,
                  required: true
          )
          amount(
                  description: "Gross transaction value",
                  type: PropertyType.Numeric,
                  required: true
          )
          operation_date(
                  description: "Date of operation",
                  type: PropertyType.String,
                  required: true
          )
      }
    //Crypto tracks

      // Dashboard Tracks

      "/crypto" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        kyc_challenge_shown (type: PropertyType.String, required: false, description: 'If the user is KYC compliant',values:['yes','no'])
        crypto (type:  PropertyType.Map(crypto_definition), required: false, description: 'Cryptocurrency information')
      }
      "/crypto/tap_educational" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        kyc_challenge_shown(type: PropertyType.String, required: true, description: 'If the user is KYC compliant',values:['yes','no'])
        crypto(type: PropertyType.Map(crypto_definition), required: true, description: 'Cryptocurrency information')
        event_category(type: PropertyType.String, required: true, description: 'Category of event', values:['crypto'])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event', values:['tap'])
        event_label(type: PropertyType.String, required: true, description: 'Label to identify the event', values:['slider_educational'])
      }
      "/crypto/buy_intention" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        kyc_challenge_shown(type: PropertyType.String, required: true, description: 'If the user is KYC compliant',values:['yes','no'])
        crypto(type: PropertyType.Map(crypto_definition), required: true, description: 'Cryptocurrency information')
        event_category(type: PropertyType.String, required: true, description: 'Category of event', values:['crypto'])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event', values:['buy_intention'])
        event_label(type: PropertyType.String, required: true, description: 'Label to identify the event', values:['crypto_home'])
      }
      "/crypto/sell_intention" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        kyc_challenge_shown(type: PropertyType.String, required: false, description: 'If the user is KYC compliant',values:['yes','no'])
        crypto(type: PropertyType.Map(crypto_definition), required: true, description: 'Cryptocurrency information')
        event_category(type: PropertyType.String, required: true, description: 'Category of event',values:["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event',values:["sell_intention"])
        event_label(type: PropertyType.String, required: true, description: 'Label to identify the event',values:["crypto_home"])
      }

      // Blocking screens
      "/crypto/juridical_person" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
      }

      "/crypto/kyc" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        context(type: PropertyType.String, required: true, description: 'Indicate which view it comes from', values:["buy_attempt", "crypto_home_row"])
      }

      "/crypto/kyc/pending" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        context(type: PropertyType.String, required: true, description: 'Indicate which view it comes from', values:["buy_attempt", "crypto_home_row"])
      }

      "/crypto/identity/pending_validation" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        context(type: PropertyType.String, required: true, description: 'Indicate which view it comes from', values:["buy_attempt", "crypto_home_row"])
        operationType(type: PropertyType.String, required: true, description: 'Indicate which view it comes from', values:["sell_crypto","buy_crypto"])
      }

      "/crypto/identity/rejected_validation" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        context(type: PropertyType.String, required: true, description: 'Indicate which view it comes from', values:["buy_attempt", "crypto_home_row"])
        operationType(type: PropertyType.String, required: true, description: 'Indicate which view it comes from', values:["sell_crypto","buy_crypto"])
      }

      "/crypto/money_in_required" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        context(type: PropertyType.String, required: true, description: 'Indicate which view it comes from', values:["buy_attempt", "crypto_home_row"])
        operationType(type: PropertyType.String, required: true, description: 'Indicate which view it comes from', values:["sell_crypto","buy_crypto"])
      }

      //Detail
      "/crypto/balance" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        kyc_challenge_shown(type: PropertyType.String, required: false, description: 'If the user is KYC compliant')
        crypto(type: PropertyType.Map(crypto_definition), required: true, description: 'Cryptocurrency information')
      }

      "/crypto/balance/buy_intention" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        crypto(type: PropertyType.Map(crypto_definition), required: true, description: 'Cryptocurrency information')
        event_category(type: PropertyType.String, required: true, description: 'Category of event', values: ["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event', values: ["buy_intention"])
        event_label(type: PropertyType.String, required: true, description: 'Label to identify the event', values: ["crypto_balance"])
      }

      "/crypto/balance/sell_intention" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        crypto(type: PropertyType.Map(crypto_definition), required: true, description: 'Cryptocurrency information')
        event_category(type: PropertyType.String, required: true, description: 'Category of event', values: ["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event', values: ["sell_intention"])
        event_label(type: PropertyType.String, required: true, description: 'Label to identify the event', values: ["crypto_balance"])
      }

      //Calculate view
      "/crypto/buy" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        crypto(type: PropertyType.String, required: false, description: 'Cryptocurrency name', values: ["bitcoin", "ethereum","melicoin","usdp" ])
        available_amount (type: PropertyType.Numeric, required: false, description: 'Quantity available for operation')
      }

      "/crypto/buy/insert_invalid_amount" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        crypto(type: PropertyType.String, required: true, description: 'Cryptocurrency name', values: ["bitcoin", "ethereum","melicoin","usdp"] )
        available_amount(type: PropertyType.Numeric, required: true, description: 'Quantity available for operation')
        event_category(type: PropertyType.String, required: true, description: 'Category of event', values: ["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event', values: ["insert_invalid_amunt"])
        event_label(type: PropertyType.String, required: true, description: 'Label to identify the event', values: ["exceeds_holdings","exceeds_operation_cap","exceeds_weekly_cap","exceeds_daily_cap","exceeds_mounthly_cap"])
      }

      "/crypto/buy/confirm_buy_amount" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        amount (type: PropertyType.Numeric, required: true, description: 'Amount of operation')
        crypto(type: PropertyType.String, required: true, description: 'Cryptocurrency name', values: ["bitcoin", "ethereum","melicoin","usdp"] )
        event_category(type: PropertyType.String, required: true, description: 'Category of event', values: ["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event', values: ["confirm_buy_amount"])
      }

      "/crypto/sell" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        crypto(type: PropertyType.String, required: false, description: 'Cryptocurrency information', values: ["bitcoin", "ethereum","melicoin","usdp"] )
      }

      "/crypto/sell/insert_invalid_amount" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        crypto(type: PropertyType.String, required: true, description: 'Cryptocurrency information', values: ["bitcoin", "ethereum","melicoin","usdp"] )
        event_category(type: PropertyType.String, required: true, description: 'Category of event', values: ["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event', values: ["insert_invalid_amunt"])
        event_label(type: PropertyType.String, required: true, description: 'Label to identify the event', values: ["exceeds_holdings"])
      }

      "/crypto/sell/confirm_sell_amount" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        crypto(type: PropertyType.String, required: true, description: 'Cryptocurrency information', values: ["bitcoin", "ethereum","melicoin","usdp"] )
        amount (type: PropertyType.Numeric, required: true, description: 'Amount of operation')
        event_category(type: PropertyType.String, required: true, description: 'Category of event', values: ["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event', values: ["sell_all","confirm_sell_amount"])
      }

      // Review Paqe
      "/crypto/sell/review" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        amount(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        crypto(type: PropertyType.String, required: true, description: 'the market of the cryptoCurrency',  values: ["bitcoin", "ethereum","melicoin","usdp" ])
        fee(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        quote(type: PropertyType.Map(quote_definition), required: true, description: 'Quote offer by proveedor')
      }

      "/crypto/sell/review/confirm_sell" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        amount(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        fee(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        quote(type: PropertyType.Map(quote_definition), required: true, description: 'Quote offer by proveedor')
        event_category(type: PropertyType.String, required: true, description: 'Category of event', values: ["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event', values: ["confirm_sell"])
        event_label(type: PropertyType.String, required: true, description: 'Label to identify the event', values: ["bitcoin", "ethereum","melicoin","usdp" ])
      }

      "/crypto/buy/review" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        amount(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        crypto(type: PropertyType.String, required: true, description: 'the market of the cryptoCurrency',values: ["bitcoin", "ethereum","melicoin","usdp"] )
        fee(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        quote(type: PropertyType.Map(quote_definition), required: true, description: 'Quote offer by proveedor')
      }
      "/crypto/buy/review/confirm_buy" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        amount(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        fee(type: PropertyType.Numeric, required: true, description: 'fee of operation')
        quote(type: PropertyType.Map(quote_definition), required: true, description: 'Quote offer by proveedor')
        event_category(type: PropertyType.String, required: true, description: 'Category of event', values: ["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event', values: ["confirm_buy"])
        event_label(type: PropertyType.String, required: true, description: 'Label to identify the event', values: ["bitcoin", "ethereum","melicoin","usdp" ])
      }

      // Congrats
      "/crypto/buy/congrats" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        amount(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        crypto(type: PropertyType.String, required: true, description: 'Type of crypto', values: ["bitcoin", "ethereum","melicoin","usdp" ])
        payment(type: PropertyType.Map(payment_definition), required: false, description: 'Info about payment')
        quote(type: PropertyType.Map(quote_definition), required: false, description: 'Quote offer by proveedor')
        congrats_status(type: PropertyType.String, required: true, description: 'Status of congrats')
      }

      "/crypto/sell/congrats" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        amount(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        crypto(type: PropertyType.String, required: true, description: 'Type of crypto', values: ["bitcoin", "ethereum","melicoin","usdp" ])
        payment(type: PropertyType.Map(payment_definition), required: false, description: 'Info about payment')
        quote(type: PropertyType.Map(quote_definition), required: false, description: 'Quote offer by proveedor')
        congrats_status(type: PropertyType.String, required: true, description: 'Status of congrats')
      }

      "/crypto/movements/detail" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: false, description: 'Profile of user')
        context (type: PropertyType.String, required: true, description: 'Indicate which view it comes from', values:["movements_detail"])
        crypto(type: PropertyType.String, required: true, description: 'Type of crypto', values: ["bitcoin", "ethereum","melicoin","usdp" ])
        operation_type (type: PropertyType.String, required: true, description: 'Type of operaton', values: ["sell_crypto", "buy_crypto" ])
        operation_date (type: PropertyType.String, required: true, description: 'Date of operation')
        fee(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        payment(type: PropertyType.Map(payment_definition), required: true, description: 'Info about payment')
        quote(type: PropertyType.Map(quote_definition), required: true, description: 'Quote offer by proveedor')
      }
      "/crypto/movements/detail/need_help" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: false, description: 'Profile of user')
        context (type: PropertyType.String, required: true, description: 'Indicate which view it comes from', values:["movements_detail"])
        crypto(type: PropertyType.String, required: true, description: 'Type of crypto', values: ["bitcoin", "ethereum","melicoin","usdp" ])
        operation_type (type: PropertyType.String, required: true, description: 'Type of operaton', values: ["sell_crypto", "buy_crypto" ])
        operation_date (type: PropertyType.String, required: true, description: 'Date of operation')
        fee(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
        payment(type: PropertyType.Map(payment_definition), required: true, description: 'Info about payment')
        quote(type: PropertyType.Map(quote_definition), required: true, description: 'Quote offer by proveedor')
        event_category(type: PropertyType.String, required: true, description: 'Category of event',values: ["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event',values: ["need_help"])
        event_label(type: PropertyType.String, required: true, description: 'Label to identify the event', values: ["bitcoin", "ethereum","melicoin","usdp" ])
      }
      "/crypto/movements" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: false, description: 'Profile of user')
        operation(type: PropertyType.ArrayList(PropertyType.Map(operation_definition)), required: false, description: 'lists of operations')
      }
      "/crypto/onboarding" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: false, description: 'Profile of user')
      }
      "/crypto/onboarding/opt_in" (platform: "/mobile", type: TrackType.Event) {
        user_profile(type: PropertyType.String, required: true, description: 'Profile of user')
        event_category(type: PropertyType.String, required: true, description: 'Category of event',values: ["crypto"])
        event_action(type: PropertyType.String, required: true, description: 'Action name of event',values: ["opt_in"])
      }
      "/crypto/load_error" (platform: "/mobile", type: TrackType.View) {
        user_profile(type: PropertyType.String, required: false, description: 'Profile of user')
        errors(type: PropertyType.String, required: false, description: 'Type of error', values: ["no_internet_connection", "not_available_on_country", "no_site_connection","cant_show_data"])
      }
      "/crypto/educational" (platform: "/", type: TrackType.View) {
          crypto(required: false, type: PropertyType.String, description: "Currency Name")
      }
  }
