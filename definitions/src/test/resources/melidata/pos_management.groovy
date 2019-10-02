                    package src.test.resources.melidata

                    import com.ml.melidata.TrackType
                    import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

                    trackTests {
                        defaultBusiness = "mercadopago"

                        test("pos setup views") {
                            "/pos_setup/onboarding/intro"(platform: "/", type: TrackType.View) {}
                            "/pos_setup/onboarding/usage"(platform: "/", type: TrackType.View) {}
                            "/pos_setup/stores_list"(platform: "/", type: TrackType.View) {}
                            "/pos_setup/opt_in"(platform: "/", type: TrackType.View) {}
                            "/pos_setup/opt_out_cash"(platform: "/", type: TrackType.View) {}
                        }

                        test("pos setup events") {
                            "/pos_setup/onboarding/finish"(platform: "/", type: TrackType.Event) {}
                            "/pos_setup/opt_out_cash/confirm"(platform: "/", type: TrackType.Event) {}
                            "/pos_setup/open_faqs"(platform: "/", type: TrackType.Event) {}
                            "/pos_setup/reports"(platform: "/", type: TrackType.Event) {}
                            "/pos_setup/opt_in/change"(platform: "/", type: TrackType.Event) {
                                cash_management_enabled= true
                                pos_management_enabled= false
                            }
                        }

                        test("pos management views") {
                            "/pos_management/start_working_day"(platform: "/", type: TrackType.View) {
                                cash_management_enabled= true
                            }
                            "/pos_management/change_pos"(platform: "/", type: TrackType.View) {}
                            "/pos_management/working_day"(platform: "/", type: TrackType.View) {}
                            "/pos_management/cash_in"(platform: "/", type: TrackType.View) {}
                            "/pos_management/cash_out"(platform: "/", type: TrackType.View) {}
                            "/pos_management/cash_detail"(platform: "/", type: TrackType.View) {}
                            "/pos_management/cash_activities"(platform: "/", type: TrackType.View) {}
                            "/pos_management/cash_activity"(platform: "/", type: TrackType.View) {}
                            "/pos_management/reports"(platform: "/", type: TrackType.View) {}
                            "/pos_management/remaining_cash"(platform: "/", type: TrackType.View) {}
                            "/pos_management/cash_difference"(platform: "/", type: TrackType.View) {}
                            "/pos_management/report"(platform: "/", type: TrackType.View) {}
                        }

                        test("pos management events") {
                            "/pos_management/start_working_day/confirm"(platform: "/", type: TrackType.Event) {
                                cash_management_enabled= false
                            }
                            "/pos_management/change_pos/select"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/open_faqs"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/open_stores_abm"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/open_survey"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/cash_in/confirm"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/cash_out/confirm"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/finish_working_day"(platform: "/", type: TrackType.Event) {
                                cash_management_enabled= true
                                has_difference= false
                            }
                            "/pos_management/go_to_start"(platform: "/", type: TrackType.Event) {}
                        }

                        test("finish working day no difference") {
                            "/pos_management/finish_working_day"(platform: "/", type: TrackType.Event) {
                                cash_management_enabled= false
                            }
                        }
                    }

