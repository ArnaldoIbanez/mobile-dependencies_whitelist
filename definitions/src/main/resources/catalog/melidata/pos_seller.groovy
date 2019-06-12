    import com.ml.melidata.TrackType
    import com.ml.melidata.catalog.PropertyType

    import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

    tracks {

        /**
        * pos seller screen tracks
        */

        "/pos_seller"(platform: "/mobile", isAbstract: true) {
            flow_id (required: false, type: PropertyType.String, description: "Flow id.")
            flow_origin(required: false, type: PropertyType.String, description: "flow origin",values: ["shortcut", "menu"])
            payment_method_type(required: false, type: PropertyType.String, description: "card type",values: ["credit_card", "debit_card"])
            poi_id(required: false, type: PropertyType.String, description: "poi device id")
            poi_type(required: false, type: PropertyType.String, description: "poi device type")
            mode(required: false, type: PropertyType.String, description: "flow origin",values: ["cart", "amount"])
            payment_channel(required: false, type: PropertyType.String , description:  "payment channel selected by the user",values:["qr","point","share_social","cash","chooser"])
            amount(required: false, type: PropertyType.Numeric, description: "payment amount")
            currency(required: false, type: PropertyType.String, description: "payment currency")
            installments(required: false, type: PropertyType.Numeric, description: "payment amount")
            description (required: false, type: PropertyType.String, description: "payment detail")
            discount(required: false, type: PropertyType.Numeric, description: "payment discount")
            discount_type(required: false, type: PropertyType.String,description: "discount type", values:["percentage","amount" ])
            items(required: false, type: PropertyType.Numeric, description: "number of items in the cart")
          
        }


        "/pos_seller/point"(platform: "/mobile", isAbstract: true) {}
        
        "/pos_seller/new_payment"(platform: "/mobile", type: TrackType.View) {}

        "/pos_seller/chooser"(platform: "/mobile", type: TrackType.View) {}

        "/pos_seller/point/card_reader"(platform: "/mobile", type: TrackType.View) {}

        "/pos_seller/point/pairing"(platform: "/mobile", type: TrackType.View) {}

        /**
        * pos seller event tracks
        */


        // start new payment
        "/pos_seller/start"(platform: "/mobile", type: TrackType.Event) {}

        "/pos_seller/point/waiting_for_card"(platform: "/mobile", type: TrackType.Event) {}

        // end payment
        "/pos_seller/end"(platform: "/mobile", type: TrackType.Event) {

            payment_method_id(required: true, type: PropertyType.String, description: "payment method id")
            card_read_tag(required: true, type: PropertyType.String, description: "card tag",values:["swipe","chip","nfc"])
            first_six(required: true, type: PropertyType.String,description: "first six card numbers")
            last_four(required: true, type: PropertyType.String,description: "last four card numbers")
            is_fallback(required: true, type: PropertyType.Boolean,description: "is a payment through fallback")
            has_chip(required: true, type: PropertyType.Boolean, description: "It is a payment by chip")
            request_signature(required: true, type: PropertyType.Boolean, description: "Is the signature necessary")
        }

        "/pos_seller/point/pairing_scan"(platform: "/mobile", type: TrackType.Event) {}

        "/pos_seller/point/pairing_start"(platform: "/mobile", type: TrackType.Event) {
            card_reader_selected(required: true, type: PropertyType.String, description: "selected card reader")
            card_readers(required: true, type: PropertyType.String, description: "visible card readers")
        
        }
        "/pos_seller/point/pairing_end"(platform: "/mobile", type: TrackType.Event) {
            card_reader_selected(required: true, type: PropertyType.String, description: "selected card reader")
            card_readers(required: true, type: PropertyType.String, description: "visible card readers")
        }

        "/pos_seller/point/pairing_cancel"(platform: "/mobile", type: TrackType.Event) {
            card_readers(required: true, type: PropertyType.String, description: "visible card readers")
        
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
       

        def PosSellerStartFrictionExtraInfo = objectSchemaDefinitions {
            error_type(PropertyType.String, required: true)
            http_status(PropertyType.String, required: false)
            http_message(PropertyType.String, required: false)
            flow_origin(required: true, type: PropertyType.String, description: "flow origin",values: ["shortcut", "menu"])
            payment_method_type(required: false, type: PropertyType.String, description: "card type",values: ["credit", "debit"])
            mode(required: true, false: PropertyType.String, description: "flow origin",values: ["cart", "amount"])
            payment_channel(required: true, type: PropertyType.String , description:  "payment channel selected by the user",values:["qr","point","share_social","cash","chooser"])
            amount(required: true, type: PropertyType.Numeric, description: "payment amount")
            currency(required: true, type: PropertyType.String, description: "payment currency")
            installments(required: false, type: PropertyType.Numeric, description: "installments")
            description (required: true, type: PropertyType.String, description: "payment description")
            discount(required: false, type: PropertyType.Numeric, description: "payment discount")
            discount_type(required: false, type: PropertyType.String,description: "discount type", values:["percentage","amount" ])
            items(required: false, type: PropertyType.Numeric, description: "number of items in the cart")
        }

         def PosSellerWaitingCardFrictionExtraInfo = objectSchemaDefinitions {
            error_type(PropertyType.String, required: true)
            http_status(PropertyType.String, required: false)
            http_message(PropertyType.String, required: false)
            flow_origin(required: true, type: PropertyType.String, description: "flow origin",values: ["shortcut", "menu"])
            payment_method_type(required: false, type: PropertyType.String, description: "card type",values: ["credit", "debit"])
            mode(required: true, type: PropertyType.String, description: "flow origin",values: ["cart", "amount"])
            payment_channel(required: true, type: PropertyType.String , description:  "payment channel selected by the user",values:["qr","point","share_social","cash","chooser"])
            amount(required: true, type: PropertyType.Numeric, description: "payment amount")
            currency(required: true, type: PropertyType.String, description: "payment currency")
            installments(required: false, type: PropertyType.Numeric, description: "installments")
            description (required: true, type: PropertyType.String, description: "payment description")
            discount(required: false, type: PropertyType.Numeric, description: "payment discount")
            discount_type(required: false, type: PropertyType.String,description: "discount type", values:["percentage","amount" ])
            items(required: false, type: PropertyType.Numeric, description: "number of items in the cart")
            poi_id(required: false, type: PropertyType.String, description: "poi device id")
            
        }

        def PosSellerPairingFrictionExtraInfo = objectSchemaDefinitions {
            error_type(PropertyType.String, required: true)
            error_message(PropertyType.String, required: false)
            card_readers(PropertyType.String, required: false)
            card_reader_selected(required: false, type: PropertyType.String)
        }

        def PosSellerCardFrictionExtraInfo = objectSchemaDefinitions {
            error_type(PropertyType.String, required: false)
            http_status(PropertyType.String, required: false)
            http_message(PropertyType.String, required: false)
            flow_origin(required: true, type: PropertyType.String, description: "flow origin",values: ["shortcut", "menu"])
            payment_method_type(required: true, type: PropertyType.String, description: "card type",values: ["credit", "debit"])
            poi_id(required: true, type: PropertyType.String, description: "poi device id")
            poi_type(required: true, type: PropertyType.String, description: "poi device type")
            mode(required: true, type: PropertyType.String, description: "flow origin",values: ["cart", "amount"])
            payment_channel(required: true, type: PropertyType.String , description:  "payment channel selected by the user",values:["qr","point","share_social","cash","chooser"])
            amount(required: true, type: PropertyType.Numeric, description: "payment amount")
            currency(required: true, type: PropertyType.String, description: "payment currency")
            installments(required: false, type: PropertyType.Numeric, description: "installments")
            description (required: true, type: PropertyType.String, description: "payment description")
            discount(required: false, type: PropertyType.Numeric, description: "payment discount")
            discount_type(required: false, type: PropertyType.String,description: "discount type", values:["percentage","amount" ])
            items(required: false, type: PropertyType.Numeric, description: "number of items in the cart")
            card_read_tag(required: false, type: PropertyType.String, description: "card tag",values:["swipe","chip","nfc"])
            first_six(required: false, type: PropertyType.String,description: "first six card numbers")
            last_four(required: false, type: PropertyType.String,description: "last four card numbers")
            is_fallback(required: false, type: PropertyType.Boolean,description: "is a payment through fallback")
            has_chip(required: false, type: PropertyType.Boolean, description: "It is a payment by chip")
            request_signature(required: false, type: PropertyType.Boolean, description: "Is the signature necessary")
        }

        "/pos_seller/friction"(platform: "/mobile", type: TrackType.Event, isAbstract: true) {
            flow_id(required: false, type: PropertyType.String, description: "Flow id.")
            context (required: true, type: PropertyType.String, description: "Friction context")
            message (required: true, type: PropertyType.Map(PosSellerFrictionMessage), description: "Message shown map")
            attributable_to(required: true, type: PropertyType.String, values: ["user", "reader", "network", "device", "card", "unknown"], description: "Friction main category reason")
           
        }


        "/pos_seller/friction/device_comm_error"(platform: "/mobile", type: TrackType.Event) {
             extra_info (required: false, type: PropertyType.Map(PosSellerOTAFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/server_comm_error"(platform: "/mobile", type: TrackType.Event) {
             extra_info (required: false, type: PropertyType.Map(PosSellerOTAFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/battery_low_error"(platform: "/mobile", type: TrackType.Event) {
             extra_info (required: false, type: PropertyType.Map(PosSellerOTAFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/reader_update_failed"(platform: "/mobile", type: TrackType.Event) {
             extra_info (required: false, type: PropertyType.Map(PosSellerOTAFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/start"(platform: "/mobile", type: TrackType.Event) {
              extra_info (required: false, type: PropertyType.Map(PosSellerStartFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/pairing"(platform: "/mobile", type: TrackType.Event) {
            extra_info (required: false, type: PropertyType.Map(PosSellerPairingFrictionExtraInfo), description: "Friction extra data map")
        }
        "/pos_seller/friction/waiting_for_card"(platform: "/mobile", type: TrackType.Event) {
            extra_info (required: false, type: PropertyType.Map(PosSellerWaitingCardFrictionExtraInfo), description: "Friction extra data map")
        
        }

        "/pos_seller/friction/card_reader"(platform: "/mobile", type: TrackType.Event) {
           extra_info (required: false, type: PropertyType.Map(PosSellerCardFrictionExtraInfo), description: "Friction extra data map") 
        }

        "/pos_seller/friction/pairing"(platform: "/mobile", type: TrackType.Event) {
            extra_info (required: false, type: PropertyType.Map(PosSellerWaitingCardFrictionExtraInfo), description: "Friction extra data map")
        
        }
      
}
