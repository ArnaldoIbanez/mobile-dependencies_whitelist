                    package src.test.resources.melidata

                    import com.ml.melidata.TrackType
                    import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

                    trackTests {
                        defaultBusiness = "mercadopago"

                        test("start views") {

                            "/pos_seller/onboarding/point_preorder"(platform: "/mobile", type: TrackType.View) {}

                            "/pos_seller/new_payment"(platform: "/", type: TrackType.View) {}

                            "/pos_seller/chooser"(platform: "/", type: TrackType.View) {}

                            "/pos_seller/point/card_reader"(platform: "/", type: TrackType.View) {}

                            "/pos_seller/point/pairing"(platform: "/mobile", type: TrackType.View) {
                                flow_id =  "UUID1213"
                                flow_origin = "shortcut"
                                amount = "100"
                                currency =  "ARS"
                            }
                 

                            "/pos_seller/point/idempotency"(platform: "/mobile", type: TrackType.View) {
                                payment_method_type= "credit_card"
                                poi_id= "BBPOS10101" 
                                installments= 3
                                flow_id= "UUID"
                                description= "nuevo cobro"
                                amount= 2.00
                                flow_origin= "shortcut"
                                mode= "amount"
                                payment_channel= "point"
                                card_read_tag = "chip"
                                first_six = "123433"
                                last_four = "1111"
                                is_fallback =false
                                has_chip =true
                                request_signature=true
                            }



                            "/pos_seller/point/duplicated_payment_warning"(platform: "/mobile", type: TrackType.View) {
                                payment_method_type= "credit_card"
                                poi_id= "BBPOS10101" 
                                installments= 3
                                flow_id= "UUID"
                                description= "nuevo cobro"
                                amount= 2.00
                                flow_origin= "shortcut"
                                mode= "amount"
                                payment_channel= "point"
                                card_read_tag = "chip"
                                first_six = "123433"
                                last_four = "1111"
                                is_fallback =false
                                has_chip =true
                                request_signature=true
                                idempotency = false
                            }


                            "/pos_seller/congrats"(platform: "/mobile", type: TrackType.View) {
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
                                payment_id = "1111111"
                                is_fallback = true
                                has_chip = false
                                request_signature = true
                            }

                           "/pos_seller/onboarding/pricing"(platform: "/mobile", type: TrackType.View) {
                               payment_channel =  "point"
                            }

                            "/pos_seller/version_blacklist"(platform: "/mobile", type: TrackType.View) {
                                update_later = true
                                point_status = "updateAvailable"
                                qr_status = "updateMandatory"
                                share_social_status = "upToDate"
                                cash_status = "upToDate"
                            }

                            "/pos_seller/nfce/client"(platform: "/", type: TrackType.View) {}

                            "/pos_seller/address_selection"(platform: "/mobile", type: TrackType.View) {}

                            "/pos_seller/onboarding/liable_for_tax"(platform: "/mobile", type: TrackType.View) {
                                payment_channel =  "point"
                            }

                            "/pos_seller/point/tax"(platform: "/mobile", type: TrackType.View) {
                                flow_id= "UUID"
                                description= "nuevo cobro"
                                amount= 2.00
                                flow_origin= "shortcut"
                                mode= "amount"
                                payment_channel= "point"
                            }

                            "/pos_seller/point/account_type"(platform: "/mobile", type: TrackType.View) {
                                payment_method_type= "debit_card"
                                flow_id= "UUID"
                                description= "nuevo cobro"
                                amount= 2.00
                                flow_origin= "shortcut"
                                mode= "amount"
                                payment_channel= "point"
                            }

                            "/pos_seller/friction/sat_unavailable"(platform: "/", type: TrackType.View) {}

                            "/pos_seller/friction/sat_not_found"(platform: "/", type: TrackType.View) {}

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
                                payment_id = "123456123456"
                            }

                        }

                        test("waiting for card event") {
                            "/pos_seller/point/waiting_for_card"(platform: "/mobile", type: TrackType.Event) {
                                payment_method_type= "credit_card"
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


                           test("avoid duplicated payment") {
                            "/pos_seller/point/duplicated_payment_warning_exit"(platform: "/mobile", type: TrackType.Event) {
                                payment_method_type= "credit_card"
                                poi_id= "BBPOS10101" 
                                installments= 3
                                flow_id= "UUID"
                                description= "nuevo cobro"
                                amount= 2.00
                                flow_origin= "shortcut"
                                mode= "amount"
                                payment_channel= "point"
                                card_read_tag = "swipe"
                                first_six = "11111"
                                last_four = "3245" 
                                is_fallback = true
                                has_chip = false
                                request_signature = true
                            }
                        }



                        test("idempotency exit") {
                            "/pos_seller/point/idempotency_exit"(platform: "/mobile", type: TrackType.Event) {
                                payment_method_type= "credit_card"
                                poi_id= "BBPOS10101" 
                                installments= 3
                                flow_id= "UUID"
                                description= "nuevo cobro"
                                amount= 2.00
                                flow_origin= "shortcut"
                                mode= "amount"
                                payment_channel= "point"
                                card_read_tag = "swipe"
                                first_six = "11111"
                                last_four = "3245" 
                                is_fallback = true
                                has_chip = false
                                request_signature = true
                            }
                        }

                        test("idempotency exit") {
                            "/pos_seller/point/post_payment"(platform: "/mobile", type: TrackType.Event) {
                                payment_method_type= "credit_card"
                                poi_id= "BBPOS10101" 
                                installments= 3
                                flow_id= "UUID"
                                description= "nuevo cobro"
                                amount= 2.00
                                flow_origin= "shortcut"
                                mode= "amount"
                                payment_channel= "point"
                                card_read_tag = "swipe"
                                first_six = "11111"
                                last_four = "3245" 
                                is_fallback = true
                                has_chip = false
                                request_signature = true
                                ignore_duplicate= true
                                idempotency= true
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


                        test("Point pricing screen confirmation event") {
                            "/pos_seller/onboarding/pricing_confirmation"(platform: "/mobile", type: TrackType.Event) {
                                payment_channel= "point"
                                processing_fee= 2.74
                                release_days= "En 14 días"
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
                           context = "pos_seller/calculator"
                           message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
                           attributable_to = "device"
                           extra_info = [ flow_origin: "shortcut", mode: "cart", payment_channel: "point", amount: 2.0 ,currency:"ARS" ]
                         }  

                         "/pos_seller/friction/pairing"(platform: "/mobile", type: TrackType.Event) {
                          context = "pos_seller/pairing"
                          message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
                          attributable_to = "device"
                          extra_info = [ card_readers: "CHB123456789012-LE", card_reader_selected: "CHB123456789012-LE", error_type: "pairing"]
                         }

                         "/pos_seller/friction/card_reader"(platform: "/mobile", type: TrackType.Event) {
                         context = "pos_seller/card_reader"
                         message = [ style: "dialog", title: "Titulo", content: "Mensaje de error", primary_button: "Reintentar", secondary_button: "Volver" ]
                         attributable_to = "device"
                         extra_info = [ flow_origin: "shortcut", mode: "cart", payment_channel: "point", amount: 2.0 ,currency:"ARS",error_type: "card_reader", payment_method_type: "credit_card", 
                                        poi_id: "CHB123456789012-LE", description: "venta presencial"]
                        }
                    }

                    // WEB
                    test("pos seller web views") {
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
                            flow_id= "UUID"
                            amount= 2.00
                            items= 1
                            mode= "amount"
                            payment_channel= "point"
                            currency =  "ARS"
                            store= "13040339"
                            pos= "13040340"
                            payment_method_type= "credit_card"
                            installments= 3
                        }
                        //QR Flow
                        "/pos_seller/qr/waiting_for_scan"(platform: "/web", type: TrackType.View) {
                            flow_id= "UUID"
                            amount= 2.00
                            items= 1
                            mode= "amount"
                            payment_channel= "qr"
                            currency =  "ARS"
                            store= "13040339"
                            pos= "13040340"
                            payment_method_type= "credit_card"
                            installments= 3
                        }
                        
                        //Collection funnel end success
                        "/pos_seller/end"(platform: "/web", type: TrackType.View) {
                            flow_id= "UUID"
                            amount= 2.00
                            items= 1
                            mode= "amount"
                            payment_channel= "point"
                            currency =  "ARS"
                            store= "13040339"
                            pos= "13040340"
                            payment_method_type= "credit_card"
                            installments= 3
                        }

                        //Vouchers
                        "/pos_seller/vouchers"(platform: "/web", type: TrackType.View) {}
                        "/pos_seller/vouchers/detail"(platform: "/web", type: TrackType.View) {
                            name= "sodexo"
                        }
                        "/pos_seller/vouchers/access-denied"(platform: "/web", type: TrackType.View) {}
                        "/pos_seller/vouchers/error"(platform: "/web", type: TrackType.View) {}
                         
                        /**
                        *MISC
                        */
                        "/pos_seller/mobile_shield"(platform: "/web", type: TrackType.View) {}
                    }

                    test("pos seller web events") {
                        /**
                        * COLLECTION FUNNEL
                        */
                        "/pos_seller/select_method"(platform: "/web", type: TrackType.Event) {
                            flow_id= "UUID"
                            amount= 2.00
                            items= 1
                            mode= "amount"
                            payment_channel= "point"
                            currency =  "ARS"
                            store= "13040339"
                            pos= "13040340"
                        }
                        "/pos_seller/point/set_financing_cost"(platform: "/web", type: TrackType.Event) {
                            financing_cost= "seller"
                        }
                        "/pos_seller/friction/card_reader"(platform: "/web", type: TrackType.Event) {
                            context = "pos_seller/card_reader"
                            message = [ style: "dialog", title: "Title", content: "Message", primary_button: "Retry", secondary_button: "Back" ]
                            extra_info = [ 
                                error_type: "card_reader",
                                flow_id: "UUID",
                                amount: 2.00,
                                items: 1,
                                mode: "amount",
                                payment_channel: "point",
                                currency :  "ARS",
                                store: "13040339",
                                pos: "13040340",
                                payment_method_type: "credit_card",
                                installments: 3,
                            ]
                        }

                        /**
                        *MISC
                        */
                        "/pos_seller/mobile_shield/start"(platform: "/web", type: TrackType.Event) {}
                    }

} 

