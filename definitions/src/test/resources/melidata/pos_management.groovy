                    package src.test.resources.melidata

                    import com.ml.melidata.TrackType
                    import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

                    trackTests {
                        defaultBusiness = "mercadopago"

                        test("pos setup views") {
                            "/pos_setup/onboarding_step_1"(platform: "/", type: TrackType.View) {}
                            "/pos_setup/onboarding_step_2"(platform: "/", type: TrackType.View) {}
                            "/pos_setup/stores_list"(platform: "/", type: TrackType.View) {}
                            "/pos_setup/opt_in"(platform: "/", type: TrackType.View) {}
                            "/pos_setup/opt_out_cash"(platform: "/", type: TrackType.View) {}
                        }

                        test("pos setup events") {
                            "/pos_setup/finish_onboarding"(platform: "/", type: TrackType.Event) {}
                            "/pos_setup/opt_out_cash_confirm"(platform: "/", type: TrackType.Event) {}
                            "/pos_setup/open_faqs"(platform: "/", type: TrackType.Event) {}
                            "/pos_setup/reports"(platform: "/", type: TrackType.Event) {}
                            "/pos_setup/opt_in"(platform: "/", type: TrackType.Event) {
                                cash_management_enabled= true
                                pos_management_enabled= false
                            }
                        }

                        test("pos management views") {
                            "/pos_management/start_working_day/cash"(platform: "/", type: TrackType.View) {}
                            "/pos_management/start_working_day/no_cash"(platform: "/", type: TrackType.View) {}
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
                            "/pos_management/start_working_day"(platform: "/", type: TrackType.Event) {
                                cash_management_enabled= true
                            }
                            "/pos_management/change_pos"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/open_faqs"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/open_stores_abm"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/open_survey"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/cash_in"(platform: "/", type: TrackType.Event) {}
                            "/pos_management/cash_out"(platform: "/", type: TrackType.Event) {}
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

