package catalog.melidata

import com.ml.melidata.TrackType
    import com.ml.melidata.catalog.PropertyType

    import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

    tracks {

        initiative = "1046"

        /**
        * pos seller screen tracks
        */

        "/pos_seller"(platform: "/mobile", isAbstract: true) {
            flow_id (required: false, type: PropertyType.String, description: "Flow id.")
            flow_origin(required: false, type: PropertyType.String, description: "flow origin",values: ["shortcut", "menu"])
            payment_method_type(required: false, type: PropertyType.String, description: "card type",values: ["credit_card", "debit_card", "voucher_card"])
            poi_id(required: false, type: PropertyType.String, description: "poi device id")
            poi_type(required: false, type: PropertyType.String, description: "poi device type")
            mode(required: false, type: PropertyType.String, description: "flow origin",values: ["cart", "amount"])
            payment_channel(required: false, type: PropertyType.String , description:  "payment channel selected by the user",values:["qr","point","share_social","cash","chooser","caixa"])
            amount(required: false, type: PropertyType.Numeric, description: "payment amount")
            currency(required: false, type: PropertyType.String, description: "payment currency")
            installments(required: false, type: PropertyType.Numeric, description: "payment amount")
            description (required: false, type: PropertyType.String, description: "payment detail")
            discount(required: false, type: PropertyType.Numeric, description: "payment discount")
            discount_type(required: false, type: PropertyType.String,description: "discount type", values:["percentage","amount" ])
            items(required: false, type: PropertyType.Numeric, description: "number of items in the cart")
            store(required: false, type: PropertyType.String, description: "store/branch name")
            pos(required: false, type: PropertyType.String, description: "cashier name")
            account_type(required: false, type: PropertyType.String, description: "account type", values:["checking", "savings"])
            tax(required: false, type: PropertyType.String, description: "tax")
        }


        propertyDefinitions {
            card_read_tag(required: true, type: PropertyType.String, description: "card tag",values:["swipe","chip","nfc","swipe_nfc","chip_nfc"])
            first_six(required: true, type: PropertyType.String,description: "first six card numbers")
            last_four(required: true, type: PropertyType.String,description: "last four card numbers")
            is_fallback(required: true, type: PropertyType.Boolean,description: "is a payment through fallback")
            has_chip(required: false, type: PropertyType.Boolean, description: "It is a payment by chip")
            request_signature(required: true, type: PropertyType.Boolean, description: "Is the signature necessary")
        }
 
        propertyGroups {
        cardData(card_read_tag, first_six, last_four, is_fallback, has_chip, request_signature)
        }


        "/pos_seller/congrats"(platform: "/mobile", type: TrackType.View) {
            payment_method_id(required: true, type: PropertyType.String, description: "payment method id")
            payment_id(required: true, type: PropertyType.String, description: "payment id")
            cardData
        }

        "/pos_seller/point"(platform: "/mobile", isAbstract: true) {}
        
        "/pos_seller/new_payment"(platform: "/", type: TrackType.View) {}

        "/pos_seller/chooser"(platform: "/", type: TrackType.View) {}

        "/pos_seller/point/card_reader"(platform: "/", type: TrackType.View) {}

        "/pos_seller/point/pairing"(platform: "/mobile", type: TrackType.View) {}

        "/pos_seller/onboarding/point_preorder"(platform: "/mobile", type: TrackType.View) {}


        "/pos_seller/point/idempotency"(platform: "/mobile", isAbstract: true) {
            cardData
        }

        "/pos_seller/point/duplicated_payment_warning"(platform: "/mobile", isAbstract: true) {
            cardData
            idempotency(required: true, type: PropertyType.Boolean, description: "came form idempotency flow")
        }

        "/pos_seller/onboarding"(platform: "/mobile", type: TrackType.View, isAbstract: true, parentPropertiesInherited: false) {
            payment_channel(required: true, type: PropertyType.String, description: "payment channel selected by the user", values: ["qr","point","share_social","cash","chooser"])
            flow_id (required: false, type: PropertyType.String, description: "Flow id.")
        }

       "/pos_seller/onboarding/pricing"(platform: "/mobile", type: TrackType.View) {}

        "/pos_seller/version_blacklist"(platform: "/mobile", type: TrackType.View) {
            update_later(required: true, type: PropertyType.Boolean, description: "If the update later button is shown")
            receive_time(required: false, type: PropertyType.String, description: "Last dateTime version blacklist response received")
            point_status(required: true, type: PropertyType.String, description: "Point section blacklist status", values: ["upToDate", "updateAvailable", "updateMandatory", "ACTIVE", "UPDATABLE", "INACTIVE"])
            qr_status(required: true, type: PropertyType.String, description: "QR section blacklist status", values: ["upToDate", "updateAvailable", "updateMandatory", "ACTIVE", "UPDATABLE", "INACTIVE"])
            share_social_status(required: true, type: PropertyType.String, description: "Link section blacklist status", values: ["upToDate", "updateAvailable", "updateMandatory", "ACTIVE", "UPDATABLE", "INACTIVE"])
            cash_status(required: true, type: PropertyType.String, description: "Cash section blacklist status", values: ["upToDate", "updateAvailable", "updateMandatory", "ACTIVE", "UPDATABLE", "INACTIVE"])
        }

        "/pos_seller/nfce"(platform: "/", type: TrackType.View, isAbstract: true) {}

        "/pos_seller/nfce/client"(platform: "/", type: TrackType.View) {}

        "/pos_seller/address_selection"(platform: "/mobile", type: TrackType.View) {}

        "/pos_seller/onboarding/liable_for_tax"(platform: "/mobile", type: TrackType.View) {}

        "/pos_seller/point/tax"(platform: "/mobile", type: TrackType.View) {}

        "/pos_seller/point/account_type"(platform: "/mobile", type: TrackType.View) {}

        /**
        * pos seller event tracks
        */

        // start new payment
        "/pos_seller/start"(platform: "/mobile", type: TrackType.Event) {}

        "/pos_seller/point/waiting_for_card"(platform: "/mobile", type: TrackType.Event) {}

        // end payment
        "/pos_seller/end"(platform: "/mobile", type: TrackType.Event) {
            cardData
            payment_method_id(required: true, type: PropertyType.String, description: "payment method id")
            payment_id(required: true, type: PropertyType.String, description: "payment id")
        }

        // device pairing
        "/pos_seller/point/pairing_scan"(platform: "/mobile", type: TrackType.Event) {}

        "/pos_seller/point/pairing_start"(platform: "/mobile", type: TrackType.Event) {
            card_reader_selected(required: true, type: PropertyType.String, description: "selected card reader")
            card_readers(required: true, type: PropertyType.String, description: "visible card readers")
        
        }
        "/pos_seller/point/pairing_end"(platform: "/mobile", type: TrackType.Event) {
            card_reader_selected(required: true, type: PropertyType.String, description: "selected card reader")
            card_readers(required: false, type: PropertyType.String, description: "visible card readers")
        }

        "/pos_seller/point/pairing_cancel"(platform: "/mobile", type: TrackType.Event) {
            card_readers(required: true, type: PropertyType.String, description: "visible card readers")
        
        }

        // post payment
        "/pos_seller/point/post_payment"(platform: "/mobile", type: TrackType.Event) {
            ignore_duplicate(required: true, type: PropertyType.Boolean, description: "force duplicated payment")
            idempotency(required: true, type: PropertyType.Boolean, description: "came form idempotency flow")
            cardData
        
        }

        //idempotencie
        "/pos_seller/point/duplicated_payment_warning_exit"(platform: "/mobile", type: TrackType.Event) {
            cardData     
        }

        "/pos_seller/point/idempotency_exit"(platform: "/mobile", type: TrackType.Event) {
            cardData
        }


        /**
        * pos seller Frictions
        */

         "/pos_seller/onboarding/pricing_confirmation"(platform: "/mobile", type: TrackType.Event) {
            processing_fee(required: true, type: PropertyType.Numeric,description: "Processing fee selected by the user")
            release_days(required: true, type: PropertyType.String,description: "Release days selected by the user")
        }


         def PosSellerFrictionMessage = objectSchemaDefinitions {
            style(type: PropertyType.String, required: true, description: "Style showed, window, dialog, toast.. ", values: ["dialog", "screen", "snackbar-alert"])
            title(type: PropertyType.String, required: false)
            content(type: PropertyType.String, required: true)
            primary_button(type: PropertyType.String, required: true)
            secondary_button(type: PropertyType.String, required: false)
        }

        def PosSellerOTAFrictionExtraInfo = objectSchemaDefinitions {
            progress(type: PropertyType.Numeric, required: false)
            poi(required: false, type: PropertyType.String, description: "poi device id")
        }
       

       propertyDefinitions {
          flow_origin(required: true, type: PropertyType.String, description: "flow origin",values: ["shortcut", "menu"])
          flow_id (required: true, type: PropertyType.String, description: "Flow id.")
          payment_method_type(required: false, type: PropertyType.String, description: "card type",values: ["credit_card", "debit_card", "voucher_card"])
          mode(required: true, false: PropertyType.String, description: "flow origin",values: ["cart", "amount"])
          payment_channel(required: true, type: PropertyType.String , description:  "payment channel selected by the user",values:["qr","point","share_social","cash","chooser","external_payments"])
          amount(required: true, type: PropertyType.Numeric, description: "payment amount")
          currency(required: true, type: PropertyType.String, description: "payment currency")
          installments(required: false, type: PropertyType.Numeric, description: "installments")
          description (required: false, type: PropertyType.String, description: "payment description")
          discount(required: false, type: PropertyType.Numeric, description: "payment discount")
          discount_type(required: false, type: PropertyType.String,description: "discount type", values:["percentage","amount" ])
          items(required: false, type: PropertyType.Numeric, description: "number of items in the cart")
          payment_method_id(required: false, type: PropertyType.String, description: "payment method id")
          store(required: true, type: PropertyType.String, description: "store id")
          pos(required: true, type: PropertyType.String, description: "pos id")
          account_type(required: false, type: PropertyType.String, description: "account type", values:["checking", "savings"])
          tax(required: false, type: PropertyType.String, description: "tax")
        }
 
        propertyGroups {
        paymentData(flow_origin, payment_method_type, mode,payment_channel,amount,currency,installments,description,discount,discount_type,items,payment_method_id, account_type, tax)
        paymentDataWeb(flow_id, amount, items, mode, payment_channel, currency, store, pos, installments, payment_method_type)
        }

        def PosSellerStartFrictionExtraInfo = objectSchemaDefinitions {
            flow_origin(required: true, type: PropertyType.String, description: "flow origin",values: ["shortcut", "menu"])
            paymentData
        }

         def PosSellerWaitingCardFrictionExtraInfo = objectSchemaDefinitions {
            error_type(PropertyType.String, required: true)
            paymentData
            poi_id(required: false, type: PropertyType.String, description: "poi device id")
            
        }

        def PosSellerPairingFrictionExtraInfo = objectSchemaDefinitions {
            error_type(PropertyType.String, required: true)
            card_readers(PropertyType.String, required: false)
            card_reader_selected(required: false, type: PropertyType.String)
        }

        def PosSellerCardFrictionExtraInfo = objectSchemaDefinitions {
            error_type(PropertyType.String, required: true)
            paymentData
            poi_id(required: true, type: PropertyType.String, description: "poi device id")
            card_read_tag(required: false, type: PropertyType.String, description: "card tag",values:["swipe","chip","nfc","swipe_nfc","chip_nfc"])
            first_six(required: false, type: PropertyType.String,description: "first six card numbers")
            last_four(required: false, type: PropertyType.String,description: "last four card numbers")
            is_fallback(required: false, type: PropertyType.Boolean,description: "is a payment through fallback")
            has_chip(required: false, type: PropertyType.Boolean, description: "It is a payment by chip")
            request_signature(required: false, type: PropertyType.Boolean, description: "Is the signature necessary")
            payment_id(required: false, type: PropertyType.String, description: "payment id")
            error_message(PropertyType.String, required: false)
        }

        def PosSellerCardFrictionExtraInfoWeb = objectSchemaDefinitions {
            error_type(PropertyType.String, required: true)
            paymentDataWeb
        }

        "/pos_seller/friction"(platform: "/mobile", type: TrackType.Event, isAbstract: true) {
            flow_id(required: false, type: PropertyType.String, description: "Flow id.")
            context (required: true, type: PropertyType.String, description: "Friction context")
            message (required: true, type: PropertyType.Map(PosSellerFrictionMessage), description: "Message shown map")
            attributable_to(required: false, type: PropertyType.String, values: ["user", "reader", "network", "device", "card", "unknown"], description: "Friction main category reason")
           
        }


        "/pos_seller/friction/device_comm_error"(platform: "/mobile", type: TrackType.Event) {
             extra_info (required: true, type: PropertyType.Map(PosSellerOTAFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/server_comm_error"(platform: "/mobile", type: TrackType.Event) {
             extra_info (required: true, type: PropertyType.Map(PosSellerOTAFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/battery_low_error"(platform: "/mobile", type: TrackType.Event) {
             extra_info (required: true, type: PropertyType.Map(PosSellerOTAFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/reader_update_failed"(platform: "/mobile", type: TrackType.Event) {
             extra_info (required: true, type: PropertyType.Map(PosSellerOTAFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/start"(platform: "/mobile", type: TrackType.Event) {
              extra_info (required: true, type: PropertyType.Map(PosSellerStartFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/pairing"(platform: "/mobile", type: TrackType.Event) {
            extra_info (required: true, type: PropertyType.Map(PosSellerPairingFrictionExtraInfo), description: "Friction extra data map")
        }
       
        "/pos_seller/friction/card_reader"(platform: "/mobile", type: TrackType.Event) {
           extra_info (required: true, type: PropertyType.Map(PosSellerCardFrictionExtraInfo), description: "Friction extra data map") 
        }

        "/pos_seller/friction/sat_unavailable"(platform: "/", type: TrackType.View) {}

        "/pos_seller/friction/sat_not_found"(platform: "/", type: TrackType.View) {}


        // ----------- WEB -------------
        /**
        * abstract paths
        */

        "/pos_seller/point"(platform: "/web", isAbstract: true) {}
        "/pos_seller/qr"(platform: "/web", isAbstract: true) {}
        "/pos_seller/vouchers"(platform: "/web", isAbstract: true) {}

        /**
        * pos seller web view tracks
        */

        /**
        * COLLECTION FUNNEL
        */

        //Collection funnel start
        "/pos_seller/collect"(platform: "/web", type: TrackType.View) {}
        "/pos_seller/start"(platform: "/web", type: TrackType.View) {}

        //Point Pro Flow
        "/pos_seller/point/card_type"(platform: "/web", type: TrackType.View) {}
        "/pos_seller/point/installments"(platform: "/web", type: TrackType.View) {}
        "/pos_seller/point/waiting_for_card"(platform: "/web", type: TrackType.View) {
            paymentDataWeb
        }
        //QR Flow
        "/pos_seller/qr/waiting_for_scan"(platform: "/web", type: TrackType.View) {
            paymentDataWeb
        }
        //Collection funnel end success
        "/pos_seller/end"(platform: "/web", type: TrackType.View) {
            paymentDataWeb
        }

        //Vouchers
        "/pos_seller/vouchers"(platform: "/web", type: TrackType.View) {}
        "/pos_seller/vouchers/detail"(platform: "/web", type: TrackType.View) {
            name (required: true, type: PropertyType.String, description: "Voucher name")
        }
        "/pos_seller/vouchers/access-denied"(platform: "/web", type: TrackType.View) {}
        "/pos_seller/vouchers/error"(platform: "/web", type: TrackType.View) {}

        //Misc
        "/pos_seller/mobile_shield"(platform: "/web", type: TrackType.View) {}


        /**
        * pos seller web event tracks
        */
        "/pos_seller/select_method"(platform: "/web", type: TrackType.Event) {
            paymentDataWeb
        }
        "/pos_seller/point/set_financing_cost"(platform: "/web", type: TrackType.Event) {
            financing_cost(required: false, type: PropertyType.String, description: "interest expense",values: ["seller", "buyer"])
        }
        "/pos_seller/friction/card_reader"(platform: "/web", type: TrackType.Event) {
            context (required: true, type: PropertyType.String, description: "Friction context")
            message (required: true, type: PropertyType.Map(PosSellerFrictionMessage), description: "Message shown map")
            extra_info (required: true, type: PropertyType.Map(PosSellerCardFrictionExtraInfoWeb), description: "Friction extra data map")
        }

        //Misc
        "/pos_seller/mobile_shield/start"(platform: "/web", type: TrackType.Event) {}
}
