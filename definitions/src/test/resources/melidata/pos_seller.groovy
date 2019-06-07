    package src.test.resources.melidata

    import com.ml.melidata.TrackType
    import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

    trackTests {
        defaultBusiness = "mercadopago"

        test("start views") {


            "/pos_seller/new_payment"(platform: "/mobile", type: TrackType.View) {
                flow_id =  "UUID1213"
                flow_origin = "shortcut"
                amount = "100"
                currency =  "ARS"
            }

            "/pos_seller/chooser"(platform: "/mobile", type: TrackType.View) {
                flow_id =  "UUID1213"
                flow_origin = "shortcut"
                amount = "100"
                currency =  "ARS"
            }

            "/pos_seller/point/card_reader"(platform: "/mobile", type: TrackType.View) {
                flow_id =  "UUID1213"
                flow_origin = "shortcut"
                amount = "100"
                currency =  "ARS"
            }

            "/pos_seller/point/pairing"(platform: "/mobile", type: TrackType.View) {
                flow_id =  "UUID1213"
                flow_origin = "shortcut"
                amount = "100"
                currency =  "ARS"
            }
        }






        test("start event") {
            "/pos_seller/start"(platform: "/mobile", type: TrackType.Event) {
                flow_id= "UUID"
                description= "nuevo cobro"
                amount= 2.00
                flow_origin= "shortcut"
                mode= "amount"
                payment_channel= "point"
            }

        }


        test("start event") {
            "/pos_seller/start"(platform: "/mobile", type: TrackType.Event) {
                flow_id= "UUID"
                description= "nuevo cobro"
                amount= 20.00
                flow_origin= "shortcut"
                mode= "cart"
                payment_channel= "point"
                discount= 10 
                discount_type= "percentage"    
                items= 3
            }

        }
        test("end event") {
            "/pos_seller/end"(platform: "/mobile", type: TrackType.Event) {
                flow_id= "UUID"
                description= "nuevo cobro"
                amount= 20.00
                flow_origin= "shortcut"
                mode= "cart"
                payment_channel= "point"
                discount= 10 
                discount_type= "percentage"    
                items= 3
                payment_method_id ="visa"
                card_read_tag = "swipe"
                first_six = "11111"
                last_four = "3245" 
                is_fallback = true
                has_chip = false
                request_signature = true
            }

        }


        test("waiting for card event") {
            "/pos_seller/point/waiting_for_card"(platform: "/mobile", type: TrackType.Event) {
                payment_method_type= "credit"
                poi_id= "BBPOS10101" 
                installments= 3
                flow_id= "UUID"
                description= "nuevo cobro"
                amount= 2.00
                flow_origin= "shortcut"
                mode= "amount"
                payment_channel= "point"
            }
        }

        test("device pairing") {

            "/pos_seller/point/pairing_cancel"(platform: "/mobile", type: TrackType.Event) {
                card_readers= "0101010101|919191010"      
            }


            "/pos_seller/point/pairing_scan"(platform: "/mobile", type: TrackType.Event) {

            }


            "/pos_seller/point/pairing_end"(platform: "/mobile", type: TrackType.Event) {
                card_readers = "0101010101|919191010"      
                card_reader_selected= "010101020292"
            }





            "/pos_seller/point/pairing_start"(platform: "/mobile", type: TrackType.Event) {
                card_readers= "0101010101|919191010"      
                card_reader_selected= "010101020292"

            }
        }


        test("Point Seller Friction tests") {

         "/pos_seller/friction/device_comm_error"(platform: "/mobile", type: TrackType.Event) {
             context = "settings/reader_update"
             message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
             attributable_to = "reader"
             extra_info = [ poi: "CHB123456789012-LE", progress: 25.5 ]
         }

         "/pos_seller/friction/server_comm_error"(platform: "/mobile", type: TrackType.Event) {
             context = "settings/reader_update"
             message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
             attributable_to = "reader"
             extra_info = [ poi: "CHB123456789012-LE", progress: 25.5 ]
         }

         "/pos_seller/friction/battery_low_error"(platform: "/mobile", type: TrackType.Event) {
             context = "settings/reader_update"
             message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
             attributable_to = "reader"
             extra_info = [ poi: "CHB123456789012-LE"]
         }

         "/pos_seller/friction/reader_update_failed"(platform: "/mobile", type: TrackType.Event) {
             context = "settings/reader_update"
             message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
             attributable_to = "device"
             extra_info = [ poi: "CHB123456789012-LE", progress: 25.5 ]
         }

         "/pos_seller/friction/start"(platform: "/mobile", type: TrackType.Event) {
           context = "settings/reader_update"
           message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
           attributable_to = "device"
           extra_info = [ poi: "CHB123456789012-LE", progress: 25.5 ]
       }

        "/pos_seller/friction/pairing"(platform: "/mobile", type: TrackType.Event) {
         context = "settings/reader_update"
         message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
         attributable_to = "device"
         extra_info = [ poi: "CHB123456789012-LE", progress: 25.5 ]
     }

     "/pos_seller/friction/waiting_for_card"(platform: "/mobile", type: TrackType.Event) {
         context = "settings/reader_update"
         message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
         attributable_to = "device"
         extra_info = [ poi: "CHB123456789012-LE", progress: 25.5 ]

     }

     "/pos_seller/friction/card_reader"(platform: "/mobile", type: TrackType.Event) {
        context = "settings/reader_update"
        message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
        attributable_to = "device"
        extra_info = [ poi: "CHB123456789012-LE", progress: 25.5 ]
    }
    }

    } 
