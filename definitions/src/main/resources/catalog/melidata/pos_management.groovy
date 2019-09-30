    import com.ml.melidata.TrackType
    import com.ml.melidata.catalog.PropertyType

    import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

    tracks {

        /**
        * pos management screen tracks
        */

        "/pos_setup"(platform: "/", isAbstract: true) {}
        "/pos_management"(platform: "/", isAbstract: true) {}

        //OPT IN

        "/pos_setup/onboarding_step_1"(platform: "/", type: TrackType.View) {}
        "/pos_setup/onboarding_step_2"(platform: "/", type: TrackType.View) {}
        "/pos_setup/finish_onboarding"(platform: "/", type: TrackType.Event) {}

        "/pos_setup/stores_list"(platform: "/", type: TrackType.View) {}
        "/pos_setup/open_faqs"(platform: "/", type: TrackType.Event) {}

        "/pos_setup/opt_in"(platform: "/", type: TrackType.View) {}
        "/pos_setup/opt_in"(platform: "/", type: TrackType.Event) {
            cash_management_enabled(required: false, type: PropertyType.Boolean,description: "cash management is enabled")
            pos_management_enabled(required: false, type: PropertyType.Boolean,description: "pos management is enabled")
        }
        "/pos_setup/reports"(platform: "/", type: TrackType.Event) {}

        "/pos_setup/opt_out_cash"(platform: "/", type: TrackType.View) {}
        "/pos_setup/opt_out_cash_confirm"(platform: "/", type: TrackType.Event) {}

        //START WORKING DAY

        "/pos_management/start_working_day/cash"(platform: "/", type: TrackType.View) {}
        "/pos_management/start_working_day"(platform: "/", type: TrackType.Event) {
            cash_management_enabled(required: false, type: PropertyType.Boolean,description: "cash management is enabled")
        }
        "/pos_management/start_working_day/no_cash"(platform: "/", type: TrackType.View) {}

        "/pos_management/change_pos"(platform: "/", type: TrackType.View) {}
        "/pos_management/change_pos"(platform: "/", type: TrackType.Event) {}

        //POS DETAIL

        "/pos_management/working_day"(platform: "/", type: TrackType.View) {}
        "/pos_management/open_faqs"(platform: "/", type: TrackType.Event) {}
        "/pos_management/open_stores_abm"(platform: "/", type: TrackType.Event) {}
        "/pos_management/open_survey"(platform: "/", type: TrackType.Event) {}

        //CASH

        "/pos_management/cash_in"(platform: "/", type: TrackType.View) {}
        "/pos_management/cash_in"(platform: "/", type: TrackType.Event) {}
        "/pos_management/cash_out"(platform: "/", type: TrackType.View) {}
        "/pos_management/cash_out"(platform: "/", type: TrackType.Event) {}
        "/pos_management/cash_detail"(platform: "/", type: TrackType.View) {}
        "/pos_management/cash_activities"(platform: "/", type: TrackType.View) {}
        "/pos_management/cash_activity"(platform: "/", type: TrackType.View) {}

        //FINISH WORKING DAY

        "/pos_management/reports"(platform: "/", type: TrackType.View) {}
        "/pos_management/remaining_cash"(platform: "/", type: TrackType.View) {}
        "/pos_management/finish_working_day"(platform: "/", type: TrackType.Event) {
            cash_management_enabled(required: false, type: PropertyType.Boolean,description: "cash management is enabled")
            has_difference(required: false, type: PropertyType.Boolean,description: "finish working day with cash difference")
        }
        "/pos_management/cash_difference"(platform: "/", type: TrackType.View) {}
        "/pos_management/report"(platform: "/", type: TrackType.View) {}
        "/pos_management/go_to_start"(platform: "/", type: TrackType.Event) {}

}
