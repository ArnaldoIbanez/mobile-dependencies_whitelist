package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Advertising manager basic track") {
        "/advertising/pads2/manager"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
            chart_visible = true
            detailsMeli_visible = true
            share_visible = true
        }

        "/advertising/pads2/manager"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
            chart_visible = true
            detailsMeli_visible = true
            share_visible = true
            matching_status = "matching_inversion"
        }

        "/advertising/pads2/manager/update_campaign_status"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            previous_status = "paused"
        }

        "/advertising/pads2/manager/update_campaign_budget"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            previous_budget = "222.22"
        }

        "/advertising/pads2/manager/update_ad_status"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            item_id = "MLA22"
            ad_status = "active"
            previous_ad_status = "paused"
        }
        "/advertising/pads2/manager/onboarding/steps/show"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
        }
        "/advertising/pads2/manager/onboarding/steps/finish"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
        }
        "/advertising/pads2/manager/onboarding/modal/show"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
        }
        "/advertising/pads2/manager/onboarding/modal/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
        }
    }

    test("Advertising landing") {
        "/advertising/pads2/landing"(platform: "/", type: TrackType.View) {
            free_trial_ad = true
            budget = 500
        }

        "/advertising/pads2/landing"(platform: "/", type: TrackType.View) {
            free_trial_ad = true
            budget = 500
            experiment = true
        }

        "/advertising/pads2/landing/main_action"(platform: "/", type: TrackType.Event) {
            button = "top"
            free_trial_ad = true
            budget = 500
        }

        "/advertising/pads2/landing/main_action"(platform: "/", type: TrackType.Event) {
            button = "top"
            free_trial_ad = true
            budget = 500
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing/main_action"(platform: "/", type: TrackType.Event) {
            button = "top"
            free_trial_ad = true
            budget = 500
            experiment = true
        }

        "/advertising/pads2/landing/from_main_slider"(platform: "/web", type: TrackType.Event) {
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing/contract_confirmation"(platform: "/", type: TrackType.View) {
            free_trial_ad = true
        }

        "/advertising/pads2/landing/contract_confirmation/confirm"(platform: "/", type: TrackType.Event) {
            budget = "22.22"
            free_trial_ad = true
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing/contract_confirmation/confirmOfficialStore"(platform: "/", type: TrackType.Event) {
            budget = "22.22"
            free_trial_ad = false
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing/contract_confirmation/confirmOfficialStore"(platform: "/", type: TrackType.Event) {
            budget = "22.22"
            free_trial_ad = false
            id = "adq_pads"
            position = "home_desktop"
            experiment = true
        }

        "/advertising/pads2/landing/contract_confirmation/contractofficialstore"(platform: "/", type: TrackType.Event) {
            budget = "22.22"
            free_trial_ad = false
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing/contract_confirmation/confirm"(platform: "/", type: TrackType.Event) {
            budget = "22.22"
            free_trial_ad = true
            id = "adq_pads"
            position = "home_desktop"
            experiment = true
        }

        "/advertising/pads2/landing/contract_confirmation/change_budget"(platform: "/web", type: TrackType.Event) {
            free_trial_ad = false
        }

        "/advertising/pads2/landing/change_budget"(platform: "/web", type: TrackType.Event) {
            free_trial_ad = false
        }

        "/advertising/pads2/landing/contract_confirmation/change_budget/confirm"(platform: "/web", type: TrackType.Event) {
            budget = "22.22"
            free_trial_ad = false
        }

    }

    test("Advertising privacy") {
        "/advertising/privacy"(platform: "/", type: TrackType.View) {
        }

        "/advertising/privacy/modal"(platform: "/", type: TrackType.Event) {
        }

        "/advertising/privacy/modal/show"(platform: "/", type: TrackType.Event) {
            switch_status = "enabled"
        }

        "/advertising/privacy/modal/deactivate_ads"(platform: "/", type: TrackType.Event) {            
        }

        "/advertising/privacy/modal/keep_ads_active"(platform: "/", type: TrackType.Event) {
        }

        "/advertising/privacy/modal/dismiss"(platform: "/", type: TrackType.Event) {
            switch_status = "deactivate"
        }

        "/advertising/privacy/switch"(platform: "/", type: TrackType.Event) {
        }

        "/advertising/privacy/switch/activated"(platform: "/", type: TrackType.Event) {
            switch_status = "activated"
        }
    }

    test("Advertising upselling") {
        "/advertising/pads2/manager/upselling/modal/show"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            multi = false
            status = "active"
            budget = "500"
            budget_suggested = "1000"
        }

        "/advertising/pads2/manager/upselling/modal/go"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            multi = false
            status = "active"
            budget = "500"
            budget_suggested = "1000"
            budget_selected = "800"
        }

        "/advertising/pads2/manager/upselling/modal/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            multi = false
            status = "active"
            budget = "500"
            budget_suggested = "1000"
            budget_selected = "800"
        }

        "/advertising/pads2/manager/upselling/banner/show"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
            budget_new = "1000"
        }

        "/advertising/pads2/manager/upselling/banner/go"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
            budget_new = "1000"
        }

        "/advertising/pads2/manager/upselling/banner/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
            budget_new = "1000"
        }

        "/advertising/pads2/manager/upselling/mark"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            multi = false
            status = "active"
            budget = "500"
        }

        "/advertising/pads2/manager/upselling/tooltip/go"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            multi = false
            status = "active"
            budget = "500"
        }

        "/advertising/pads2/manager/upselling/tooltip/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            multi = false
            status = "active"
            budget = "500"
        }

        "/advertising/pads2/manager/box/upselling/go"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            multi = false
            status = "active"
            budget = "500"
        }

        "/advertising/pads2/manager/box"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
        }

        "/advertising/pads2/manager/box/upselling"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            multi = false
            status = "active"
            budget = "500"
        }

        "/advertising/pads2/manager/upselling/tooltip"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
        }
  
    }

    test("Landing congrats") {
        "/advertising/landings/pads2/mail/congrats"(platform: "/", type: TrackType.View) {
            user_id = "2222222"
            items_id = "MLA1,MLA2,MLA3,MLA4,MLA5"
        }
    }

    test("Landing free trial") {
        "/advertising/pads2/landing_freetrial"(platform: "/", type: TrackType.View) {
            free_trial_type = "F"
            budget = "500"
        }

        "/advertising/pads2/landing_freetrial"(platform: "/", type: TrackType.View) {
            free_trial_type = "D"
            budget = "500"
        }

        "/advertising/pads2/landing_freetrial"(platform: "/", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
        }

        "/advertising/pads2/landing_freetrial"(platform: "/", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
            experiment = true
        }

        "/advertising/pads2/landing_freetrial/cta"(platform: "/", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
            button = "top"
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing_freetrial/cta"(platform: "/", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
            button = "top"
        }

        "/advertising/pads2/landing_freetrial/cta"(platform: "/", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
            button = "top"
            experiment = true
        }

        "/advertising/pads2/landing_freetrial/confirm"(platform: "/", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
        }

        "/advertising/pads2/landing_freetrial/confirm"(platform: "/", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
            experiment = true
        }

        "/advertising/pads2/landing_freetrial/confirm/cta"(platform: "/", type: TrackType.Event) {
            free_trial_type = "M"
            budget = "500"
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing_freetrial/confirm/cta"(platform: "/", type: TrackType.Event) {
            free_trial_type = "M"
            budget = "500"
        }

        "/advertising/pads2/landing_freetrial/confirm/cta"(platform: "/", type: TrackType.Event) {
            free_trial_type = "M"
            budget = "500"
            experiment = true
        }
    }

    test("Advertising Lift") {
        "/advertising/pads2/manager/lift/details/show"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/details/close"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }

        "/advertising/pads2/manager/lift/chart/show"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/chart/close"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }

        "/advertising/pads2/manager/lift/tooltip/adv_sales"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/tooltip/meli_sales"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/tooltip/info"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/tooltip/prints"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/tooltip/clics"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/tooltip/income"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/tooltip/investment"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/tooltip/take_rate"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }

        "/advertising/pads2/manager/lift/modal/open"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/modal/pause"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/modal/continue"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/modal/close"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
    }

    test("Advertising manager SLL") {
        "/advertising/pads2/manager/card/sll"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            sll_total = "10"
        }

        "/advertising/pads2/manager/card/sll"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            sll_total = "10"
        }

        "/advertising/pads2/manager/ssl/landing"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            sll_total = "10"
        }

        "/advertising/pads2/manager/ssl/landing/activated"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            sll_total_activated = "10"
        }

        "/advertising/pads2/manager/ssl/landing/breadcrumb"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            sll_total = "10"
        }

        "/advertising/pads2/manager/card/upselling"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            budget = "10"
            budget_new = "20"
        }

        "/advertising/pads2/manager/card/upselling"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            budget = "10"
            budget_new = "20"
        }

    }
    test("Advertising Dynamic budget update "){
        "/advertising/pads2/manager/update/budget"(platform: "/", type: TrackType.Event) {
        }
        "/advertising/pads2/manager/update/budget/tooltip"(platform: "/", type: TrackType.Event) {
            budget = 3990
            campaign_id = 235666
            budget_type = "D"
        }

    }
    
    test("Advertising Dynamic budget ") {
        "/advertising/pads2/manager/budget/edit_pencil"(platform: "/", type: TrackType.Event) {
            budget = 3990
            campaign_id = 235666
            budget_type = "D"
        }
        "/advertising/pads2/manager/budget/tooltip"(platform: "/", type: TrackType.Event) {
            budget = 3990
            campaign_id = 235666
            budget_type = "D"
        }
        "/advertising/pads2/manager/budget/tooltip/edit_new"(platform: "/", type: TrackType.Event) {
            budget = 3990
            campaign_id = 235666
            budget_type = "D"
        }
        "/advertising/pads2/hub/budget"(platform: "/", type: TrackType.Event) {
        }
        "/advertising/pads2/hub/budget/edit_pencil"(platform: "/", type: TrackType.Event) {
            budget = 3990
            campaign_id = 235666
            budget_type = "D"
        }
    }

    test("Advertising buybox opportunity") {
        "/advertising/pads2/manager/card/buy_box_winner"(platform: "/web", type: TrackType.View) {
            winners_suggested = "20"
            campaign_id = "2222222"
        }

        "/advertising/pads2/manager/card/buybox_landing"(platform: "/web", type: TrackType.View){
            winners_suggested = "20"
            campaign_id = "2222222"
        }

        "/advertising/pads2/manager/card/buybox_landing/activated"(platform: "/web", type: TrackType.Event) {
            winners_suggested = "20"
            winners_activated = "10"
            campaign_id = "2222222"
        }

        "/advertising/pads2/manager/buybox_winners/landing/breadcrumb"(platform: "/web", type: TrackType.Event){
            winners_suggested = "20"
            campaign_id = "2222222"
        }
        "/advertising/pads2/manager/catalog/edit/publication"(platform: "/web", type: TrackType.Event){
            campaign_id = 123
            ad_status = "active"
            ad_id = "MLC123"
        }
    }

    test("Advertising Matching") {
        "/advertising/pads2/manager/winbacks/onboarding"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "paused"
            budget = "400"
            step= "1"
        }
        "/advertising/pads2/manager/winbacks/onboarding/cta"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "paused"
            budget = "400"
            step= "3"
        }
        "/advertising/pads2/manager/winbacks/onboarding/cta/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "paused"
            budget = "400"
            step= "3"
        }
        "/advertising/pads2/manager/winbacks/confirmation"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "paused"
            budget = "400"
            new_budget = "600"
        }
        "/advertising/pads2/manager/winbacks/confirmation/cta"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "paused"
            budget = "400"
            new_budget = "600"
        }
        "/advertising/pads2/manager/winbacks/confirmation/cta/close"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "paused"
            budget = "400"
            new_budget = "600"
        }
    }

    test("Advertising credits deals") {
        "/advertising/pads2/manager/credits"(platform: "/", type: TrackType.View) {
            mode = "AUTOMATIC"
            campaign_id = 290783009
            status = "active"
            available_credit = 600
            close_duedate = true
        }
        "/advertising/pads2/manager/credits/go"(platform: "/", type: TrackType.Event) {
            mode = "AUTOMATIC"
            campaign_id = 290783009
            status = "active"
            available_credit = 600
        }
        "/advertising/pads2/manager/credits/details"(platform: "/", type: TrackType.View) {
            mode = "AUTOMATIC"
            campaign_id = 290783009
            status = "active"
            available_credit = 600
            used_credit = 1000
            close_duedate = true
        }
        "/advertising/pads2/manager/credits/download"(platform: "/", type: TrackType.Event) {
            mode = "AUTOMATIC"
            campaign_id = 290783009
        }
        "/advertising/pads2/manager/credits/duedate_tooltip"(platform: "/", type: TrackType.View) {
            mode = "AUTOMATIC"
            campaign_id = 290783009
        }
        "/advertising/pads2/hub/credits"(platform: "/", type: TrackType.View) {
            mode = "custom"
            available_credit = 600
            close_duedate = true
        }
        "/advertising/pads2/hub/credits/go"(platform: "/", type: TrackType.Event) {
            mode = "custom"
            available_credit = 600
        }
        "/advertising/pads2/hub/credits/details"(platform: "/", type: TrackType.View) {
            mode = "custom"
            available_credit = 600
            used_credit = 1000
            close_duedate = true
        }
        "/advertising/pads2/hub/credits/download"(platform: "/", type: TrackType.Event) {
            mode = "custom"
        }
        "/advertising/pads2/hub/credits/duedate_tooltip"(platform: "/", type: TrackType.View) {
            mode = "custom"
        }
    }

    test("Advertising manager Sort Filters") {
        "/advertising/pads2/manager/sort"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            sort_by = "price"
            sort_value= "asc"
            multi = true
            budget = "4000"
            status = "active"
        }
        "/advertising/pads2/manager/sort"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            sort_by = "sales"
            sort_value= "asc"
            multi = true
            budget = "4000"
            status = "active"
        }
        "/advertising/pads2/manager/sort"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            sort_by = "sales"
            sort_value= "desc"
            multi = true
            budget = "4000"
            status = "active"
        }
        "/advertising/pads2/manager/filters"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            filters = [:]
            multi = true
            status = "active"
            budget = "70"
        }
        "/advertising/pads2/manager/filters"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            multi = true
            status = "active"
            budget = "70"
            filters = [
                status: "A",
                release_date: "less_than_seven_days",
                category: "x",
                features: "x",
                query: "x",
                catalog: "buy_box_winner",
                sll: "true",
                date_created: "2020-07-01"
            ]
        }
    }

    test("Advertising manager Range") {
        "/advertising/pads2/manager/metrics_range"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = "2222222"
            status = "active"
            budget = "70"
            days = 31
            to = "2020-03-20"
            from = "2020-02-19"
        }
    }

    test("Advertising manager Massive Actions") {
        "/advertising/pads2/manager/massive_actions"(platform: "/web", type: TrackType.Event) {
            multi = false
            campaign_id = "2222222"
            status = "active"
            budget = "70"
            action = "active"
            total_items = 167
        }
    }

    test("Advertising manager SortFilters Modal -> Show") {
        "/advertising/pads2/manager/sort_filters/modal/show"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "70"
        }
    }

    test("Advertising manager SortFilters Modal -> Confirm") {
        "/advertising/pads2/manager/sort_filters/modal/confirm"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "70"
            step= 2
        }
    }

    test("Advertising manager SortFilters Modal -> NextStep") {
        "/advertising/pads2/manager/sort_filters/modal/next_step"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "70"
            step= 2
        }
    }

    test("Advertising manager SortFilters Modal -> PrevStep") {
        "/advertising/pads2/manager/sort_filters/modal/prev_step"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "70"
            step= 2
        }
    }

    test("Advertising manager SortFilters Modal -> ShowLater") {
        "/advertising/pads2/manager/sort_filters/modal/show_later"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "70"
            step= 2
        }
    }

    test("Advertising multicampaña") {
        "/advertising/pads2/hub"(platform: "/", type: TrackType.View) {
            tab = "ads"
            campaigns = [
                    campaign_id: "222222",
                    budget: "333",
                    status: "active"
            ]
        }

        "/advertising/pads2/hub/createcampaign"(platform: "/web", type: TrackType.Event) {
            tab = "ads"
        }

        "/advertising/pads2/hub/campaign"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/hub/campaign/update"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/hub/campaign/update/name"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/hub/campaign/update/name/pencil"(platform: "/web", type: TrackType.Event) {
        campaign_id = "2222222"
        campaign_name = "celulares"
        status = "active"
        }

        "/advertising/pads2/hub/campaign/update/name/go"(platform: "/web", type: TrackType.Event) {
        campaign_id = "2222222"
        campaign_name = "Celulares"
        name_new = "Celular"
        status = "active"
        }

        "/advertising/pads2/hub/campaign/update/name/close"(platform: "/web", type: TrackType.Event) {
        campaign_id = "2222222"
        campaign_name = "celulares"
        name_new = "celuar"
        status = "active"
        }

        "/advertising/pads2/hub/campaign/update/budget"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/hub/campaign/update/budget/pencil"(platform: "/web", type: TrackType.Event) {
        campaign_id = "2222222"
        budget = "4000"
        status = "active"
        }

        "/advertising/pads2/hub/campaign/update/budget/go"(platform: "/web", type: TrackType.Event) {
        campaign_id = "2222222"
        budget = "4000"
        budget_new = "5600"
        status = "active"
        }

        "/advertising/pads2/hub/campaign/update/budget/close"(platform: "/web", type: TrackType.Event) {
        campaign_id = "2222222"
        budget = "4000"
        budget_new = "5600"
        status = "active"
        }

        "/advertising/pads2/hub/metrics_range"(platform: "/web", type: TrackType.Event) {
        days = 31
        tab = "ads"
        from = "2020-02-19"
        to = "to"
        }

        "/advertising/pads2/hub/massive_actions"(platform: "/web", type: TrackType.Event) {
        action = "active"
        total_items = 167
        }

        "/advertising/pads2/hub/filters"(platform: "/web", type: TrackType.Event) {
        filters = [
                    query: "x",
                ]
        }

        "/advertising/pads2/hub/moveads"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/hub/moveads/go"(
        platform: "/web",
        type: TrackType.Event) {
            check = "avtive"
            q_ads = "ads_q"
        }

        "/advertising/pads2/hub/moveads/cancel"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/hub/moveads/filters"(platform: "/web", type: TrackType.Event) {
            query = "search"
        }

        "/advertising/pads2/createcampaign"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step1"(platform: "/web", type: TrackType.View) {
        campaign_name = "celulares"
        budget = 4000
        }

        "/advertising/pads2/createcampaign/step1/next"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = 4000
        }

        "/advertising/pads2/createcampaign/step1/breadcrumb"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step1/helperbudget"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step2"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = 4000
        }

        "/advertising/pads2/createcampaign/step2/createcampaign"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = 4000
        ads = "ads_1"
        check_active = "true"
        }

        "/advertising/pads2/createcampaign/step2/breadcrumb"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = 4000
        ads = "ads_1"
        check_active = "true"
        }

        "/advertising/pads2/createcampaign/step2/helperbudget"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = 4000
        ads = "ads_1"
        check_active = "true"
        }

        "/advertising/pads2/createcampaign/step2/update"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step2/update/name"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step2/update/name/pencil"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        }

        "/advertising/pads2/createcampaign/step2/update/name/go"(platform: "/web", type: TrackType.Event) {
        name_previous = "celulares"
        name_new = "Televisores"
        }

        "/advertising/pads2/createcampaign/step2/update/name/close"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        }

        "/advertising/pads2/createcampaign/step2/update/budget"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step2/update/budget/pencil"(platform: "/web", type: TrackType.Event) {
        budget = "4000"
        }

        "/advertising/pads2/createcampaign/step2/update/budget/go"(platform: "/web", type: TrackType.Event) {
        budget_previous = "4000"
        budget_new = "5600"
        }

        "/advertising/pads2/createcampaign/step2/update/budget/close"(platform: "/web", type: TrackType.Event) {
        budget = "4000"
        }

        "/advertising/pads2/createcampaign/step2/addads"(platform: "/web", type: TrackType.Event) {
        total_ads = 35
        }

        "/advertising/pads2/createcampaign/step2/filters"(platform: "/web", type: TrackType.Event) {
            filters = [
                    query: "x",
                ]
        }

        "/advertising/pads2/createcampaign/step2/editads"(platform: "/web", type: TrackType.Event) {
            campaign_name = "celulares"
            budget = 4000
        }

        "/advertising/pads2/createcampaign/step2/editads/deleteall"(platform: "/web", type: TrackType.Event) {
            total_ads_deleted = 10
        }

        "/advertising/pads2/createcampaign/step2/editads/filters"(platform: "/web", type: TrackType.Event) {
           filters = [
                    query: "x",
                ]
        }

        "/advertising/pads2/createcampaign/step2/editads/delete"(platform: "/web", type: TrackType.Event) {
            ad_id = "333333"
            filters = [
                    query: "x",
                ]
        }

        "/advertising/pads2/createcampaign/step2/editads/cancel"(platform: "/web", type: TrackType.Event) {
            total_ads = 35
            total_ads_deleted = 10
        }

        "/advertising/pads2/createcampaign/step2/editads/confirm"(platform: "/web", type: TrackType.Event) {
            total_ads = 35
            total_ads_deleted = 10
        }

        "/advertising/pads2/createcampaign/step2/editads/undo"(platform: "/web", type: TrackType.Event) {
            ad_id = "333333"
            filters = [
                    query: "x",
                ]
        }

        "/advertising/pads2/createcampaign/step2/activeads"(platform: "/web", type: TrackType.Event) {
            status_check = "true"
        }

        "/advertising/pads2/createcampaign/confirm"(platform: "/web", type: TrackType.Event) {
            status_check = "true"
            campaign_name = "celulares"
            budget = 4000
            ads = 1
        }

        "/advertising/pads2/createcampaign/seecampaign"(platform: "/web", type: TrackType.Event) {
            campaign_name = "celulares"
            budget = "4000"
            ads = 1
        }

        "/advertising/pads2/createcampaign/gocampaign"(platform: "/web", type: TrackType.Event) {
            campaign_name = "celulares"
            budget = "4000"
            ads = 1
        }

        "/advertising/pads2/manager/addads"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "4000"
        }
        "/advertising/pads2/manager/addads/budget"(platform: "/web", type: TrackType.Event) {

        }
        "/advertising/pads2/manager/addads/budget/tooltip"(platform: "/web", type: TrackType.Event) {
            budget = "4000"
            campaign_id = "2222222"
            budget_type = "D"
        }

        "/advertising/pads2/manager/addads/breadcrumb"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "4000"
        }

        "/advertising/pads2/manager/addads/filters"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "4000"
            filters = [
                    query: "x",
                ]
        }

        "/advertising/pads2/manager/addads/add"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "4000"
            total_ads = 2
        }

        "/advertising/pads2/manager/addads/confirm"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "4000"
            ads = "ads_1"
            new_ads= 2
        }

        "/advertising/pads2/manager/addads/editads"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "4000"
            ads = "ads_1"
            new_ads= "new_ads_1"
        }

        "/advertising/pads2/manager/addads/editads/deleteall"(platform: "/web", type: TrackType.Event) {
            total_ads_deleted = 10
        }

        "/advertising/pads2/manager/addads/editads/filters"(platform: "/web", type: TrackType.Event) {
            filters = [
                    query: "x",
                ]
        }

        "/advertising/pads2/manager/addads/editads/delete"(platform: "/web", type: TrackType.Event) {
            ad_id = "333333"
            filters = [
                    query: "x",
                ]
        }

        "/advertising/pads2/manager/addads/editads/cancel"(platform: "/web", type: TrackType.Event) {
                total_ads = 35
                total_ads_deleted = 10
        }

        "/advertising/pads2/manager/addads/editads/confirm"(platform: "/web", type: TrackType.Event) {
            total_ads = 35
            total_ads_deleted = 10
        }

        "/advertising/pads2/manager/addads/editads/undo"(platform: "/web", type: TrackType.Event) {
            ad_id = "333333"
            filters = [
                    query: "x",
                ]
        }

        "/advertising/pads2/manager/update"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/manager/update/name"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/manager/update/name/pencil"(platform: "/web", type: TrackType.Event) {
            multi = true
            campaign_id = "2222222"
            campaign_name = "celulares"
        }

        "/advertising/pads2/manager/update/name/go"(platform: "/web", type: TrackType.Event) {
            multi = true
            campaign_id = "2222222"
            name_previous = "celulares"
            name_new = "Televisores"
        }

        "/advertising/pads2/manager/update/name/close"(platform: "/web", type: TrackType.Event) {
            multi = true
            campaign_id = "2222222"
            campaign_name = "celulares"
        }

        "/advertising/pads2/manager/update/budget"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/manager/update/budget/pencil"(platform: "/web", type: TrackType.Event) {
            multi = true
            campaign_id = "2222222"
            budget = "4000"
        }

        "/advertising/pads2/manager/update/budget/go"(platform: "/", type: TrackType.Event) {
            multi = false
            campaign_id = "2222222"
            budget_previous = 4000
            budget = "4000"
            budget_new = 5600
            budget_type = "D"
            budget_pct_new = "18.8"
            budget_type_new = "D"
            budget_pct_old = "17.0"
        }

        "/advertising/pads2/manager/update/budget/close"(platform: "/", type: TrackType.Event) {
            multi = false
            campaign_id = "2222222"
            budget = "4000"
            budget_type = "D"
        }

        "/advertising/pads2/manager/massive_actions"(platform: "/web", type: TrackType.Event) {
            multi = true
            action = "active"
            total_items = 167
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
        }

        "/advertising/pads2/manager"(platform: "/web", type: TrackType.View) {
            multi = true
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
        }

        "/advertising/pads2/manager/filters"(platform: "/", type: TrackType.Event) {
            multi = true
            filters = [
                    multi: "x",
                    query: "x",
                ]
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
        }

        "/advertising/pads2/manager/metrics_range"(platform: "/", type: TrackType.Event) {
            multi = true
            days = 31
            from = "2020-02-19"
            to = "to_1"
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
        }

        "/advertising/pads2/manager/sort"(platform: "/", type: TrackType.Event) {
            sort_by = "price"
            sort_value= "asc"
            campaign_id = "2222222"
            multi = true
            budget = "4000"
            status = "active"
        }
    }

    test("Advertising multicampaña Sads New") {

        "/advertising/pads2/hub/card"(platform: "/web", type: TrackType.View) {}

        "/advertising/pads2/hub/card/sads_new"(platform: "/web", type: TrackType.View) {
            tab = "ads"
            sads_total = 10
        }

        "/advertising/pads2/hub/card/sads_new/go"(platform: "/web", type: TrackType.Event) {
            tab = "ads"
            sads_total = 10
        }

        "/advertising/pads2/hub/sads_new"(platform: "/web", type: TrackType.View) {}

        "/advertising/pads2/hub/sads_new/landing"(platform: "/web", type: TrackType.View) {
            sads_total = 10
        }

        "/advertising/pads2/hub/sads_new/createcampaign"(platform: "/web", type: TrackType.Event) {
            sads_total = 10
            sads_selected = 5
        }

        "/advertising/pads2/hub/sads_new/moveads"(platform: "/web", type: TrackType.Event) {
            sads_total = 10
            sads_selected = 5
        }

        "/advertising/pads2/hub/sads_new/filters"(platform: "/web", type: TrackType.Event) {
            filters = [
                query: "search"
            ]
        }

        "/advertising/pads2/hub/sads_new/moveads/go"(platform: "/web", type: TrackType.Event) {
            check = true
            q_ads = 7
        }

        "/advertising/pads2/hub/sads_new/moveads/cancel"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/hub/sads_new/moveads/filters"(platform: "/web", type: TrackType.Event) {
            query = "search"
        }

    }

    test("Advertising multicampaña Sads Paused") {

        "/advertising/pads2/hub/card/sads_paused"(platform: "/web", type:TrackType.View){
            tab = "ads"
            sads_total = 10
        }

        "/advertising/pads2/hub/card/sads_paused/go"(platform: "/web", type:TrackType.Event){
            tab="ads"
            sads_total = 10
        }

        "/advertising/pads2/hub/sads_paused"(platform: "/web", type:TrackType.View){}

        "/advertising/pads2/hub/sads_paused/landing"(platform: "/web", type:TrackType.View){
            sads_total = 10
            campaigns = [
                        {
                             campaign_id: 99999
                             pads: 20
                        }
            ]
        }

        "/advertising/pads2/hub/sads_paused/landing/activated"(platform: "/web", type:TrackType.Event){
            sads_activated = 10
            campaigns = [
                        {
                             campaign_id: 99999
                             pads: 20
                        }
            ]
        }

        "/advertising/pads2/hub/sads_paused/landing/breadcrumb"(platform: "/web", type:TrackType.Event){
            sads_total = 10
            campaigns = [
                        {
                             campaign_id: 99999
                             pads: 20
                        }
            ]
        }

        "/advertising/pads2/hub/sads_paused/landing/see_campaign"(platform: "/web", type:TrackType.Event){
            campaign_id = 99999
            sads_total = 10
        }

        "/advertising/pads2/sads_paused"(platform: "/web", type:TrackType.Event){}

        "/advertising/pads2/sads_paused/landing"(platform: "/web", type:TrackType.View){
            sads_total = 10
            campaign_id = 99999
        }

        "/advertising/pads2/sads_paused/landing/activated"(platform: "/web", type:TrackType.Event){
            sads_total = 10
            sads_total_activated = 10
            campaign_id = 99999
        }

        "/advertising/pads2/sads_paused/landing/breadcrumb"(platform: "/web", type:TrackType.Event){
            sads_total = 10
            campaign_id = 99999
        }

        "/advertising/pads2/sads_paused/landing/filters"(platform: "/", type: TrackType.Event) {
            filters = [
                    query: "search"
            ]
        }

    }

    test("Advertising multicampaña Upselling") {

        "/advertising/pads2/hub/upselling/tooltip"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/hub/upselling/tooltip/show"(platform: "/web", type: TrackType.Event) {
            campaign_id = 123
            budget = 1000
            status = "active"
        }

        "/advertising/pads2/hub/upselling/tooltip/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = 123
            budget = 1000
            status = "paused"
        }

        "/advertising/pads2/hub/upselling/tooltip/go"(platform: "/web", type: TrackType.Event) {
            campaign_id = 1234
            budget = 1500
            status = "active"
        }

        "/advertising/pads2/hub/upselling/modal"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/hub/upselling/modal/show"(platform: "/web", type: TrackType.Event) {
            campaign_id = 1234
            budget = 1500
            status = "active"
            budget_suggested = 1700
        }

        "/advertising/pads2/hub/upselling/modal/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = 1234
            budget = 1500
            status = "active"
            budget_suggested = 1700
        }

        "/advertising/pads2/hub/upselling/modal/go"(platform: "/web", type: TrackType.Event) {
            campaign_id = 1234
            budget = 1500
            status = "paused"
            budget_suggested = 1700
            budget_selected = 2000
        }

        "/advertising/pads2/hub/upselling"(platform: "/web", type: TrackType.View) {
            campaign_id = 123
            budget = 1500
            status = "paused"
        }

        "/advertising/pads2/manager/box/upselling/close"(platform: "/web", type: TrackType.Event) {
            multi = true
            campaign_id = 123
            budget = 1500
            status = "paused"
        }
    }

    test("Advertising multicampaña Upselling x Campaigns") {

        "/advertising/pads2/hub/box/upselling"(platform: "/web", type: TrackType.View) {
            total_campaigns = 10
        }

        "/advertising/pads2/hub/box/upselling/close"(platform: "/web", type: TrackType.Event) {
            total_campaigns = 10
        }


        "/advertising/pads2/hub/box/upselling/go"(platform: "/web", type: TrackType.Event) {
            total_campaigns = 10
        }

        "/advertising/pads2/hub/upselling/landing"(platform: "/web", type: TrackType.View) {
            total_campaigns = 10
            campaigns = [
                    {
                        campaign_id: 123456
                        budget_old: 2000
                        budget_new: 3000
                    }
            ]
        }

        "/advertising/pads2/hub/upselling/landing/breadcrumb"(platform: "/web", type: TrackType.Event) {
            total_campaigns = 10
            campaigns = [
                    {
                        campaign_id: 123456
                        budget_old: 2000
                        budget_new: 3000
                    }
            ]
        }

        "/advertising/pads2/hub/upselling/landing/go"(platform: "/web", type: TrackType.Event) {
            total_campaigns = 10
            campaigns = [
                    {
                        campaign_id: 123456
                        budget_old: 2000
                        budget_new: 3000
                    }
            ]
        }


    }

    test("Multicampaña - winbacks") {

        "/advertising/pads2/hub/winbacks"(platform: "/web", type: TrackType.Event) {
        }

        "/advertising/pads2/hub/winbacks/modal"(platform: "/web", type: TrackType.Event) {
        }

        "/advertising/pads2/hub/winbacks/modal/show"(platform: "/web", type: TrackType.Event) {
            campaign_id = 123
            status = "paused"
            budget = 2000
            step = 1
        }

        "/advertising/pads2/hub/winbacks/modal/go"(platform: "/web", type: TrackType.Event) {
            campaign_id = 123
            status = "paused"
            budget = 2000
            step = 3
        }

        "/advertising/pads2/hub/winbacks/modal/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = 123
            status = "paused"
            budget = 2000
            step = 1
        }

        "/advertising/pads2/hub/winbacks/confirmation"(platform: "/web", type: TrackType.Event) {
        }

        "/advertising/pads2/hub/winbacks/confirmation/show"(platform: "/web", type: TrackType.Event) {
            campaign_id = 123
            status = "paused"
            budget = 2000
            new_budget = 2500
        }

        "/advertising/pads2/hub/winbacks/confirmation/go"(platform: "/web", type: TrackType.Event) {
            campaign_id = 123
            status = "paused"
            budget = 2000
            new_budget = 2500
        }

        "/advertising/pads2/hub/winbacks/confirmation/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = 123
            status = "paused"
            budget = 2000
            new_budget = 2500
        }

        "/advertising/pads2/hub/winbacks/createcampaign"(platform: "/web", type: TrackType.Event) {
        }

        "/advertising/pads2/hub/winbacks/createcampaign/show"(platform: "/web", type: TrackType.Event) {
        }

        "/advertising/pads2/hub/winbacks/createcampaign/go"(platform: "/web", type: TrackType.Event) {
        }

        "/advertising/pads2/hub/winbacks/pause"(platform: "/web", type: TrackType.Event) {
        }

        "/advertising/pads2/hub/winbacks/pause/show"(platform: "/web", type: TrackType.Event) {
        }

        "/advertising/pads2/hub/winbacks/pause/go"(platform: "/web", type: TrackType.Event) {
        }

        "/advertising/pads2/hub/winbacks/pause/close"(platform: "/web", type: TrackType.Event) {
        }

    }

    test("Advertising Admin Mobile") {

        "/advertising/pads2/manager/faqs"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
            has_problem = "true"
            problem_type = "test"
        }

        "/advertising/pads2/manager/budget"(platform: "/", type: TrackType.View) {
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
            suggested_budget = "7000"
        }

        "/advertising/pads2/manager/budget/suggested"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
            suggested_budget = "7000"
        }
    }

    test("Advertising Manager Traces") {
        
        "/advertising/pads2/manager/traces"(platform: "/", type: TrackType.Event) {
            action = "Access_Campaign_Tab"
            owner_id = 666
            collaborator_id = 777
            is_collaborator = true
            quantity = 1
            previous_value = "previous"
            next_value = "next"
            campaign_id = 1
        }

        "/advertising/pads2/manager/traces"(platform: "/", type: TrackType.Event) {
            action = "Access_Campaign_Tab"
            owner_id = 666
            is_collaborator = false
        }
    }

    test("Bidding Create campaign") {
        
        "/advertising/pads2/createcampaign/strategy"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/createcampaign/strategy/next"(platform: "/", type: TrackType.Event) {
            strategy = "LAUNCHING"
        }
        "/advertising/pads2/createcampaign/strategy/breadcrumb"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step1/helper"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step1/helper/trtarget"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step1/helper/strategy"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step2/trtarget"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step2/trtarget/pencil"(platform: "/", type: TrackType.Event) {
            campaign_name = "track"
            budget = 900
            strategy = "LAUNCHING"
            trtarget = 20
        }
        "/advertising/pads2/createcampaign/step2/modal"(platform: "/", type: TrackType.Event) {}
        "/advertising/pads2/createcampaign/step2/modal/bidding"(platform: "/", type: TrackType.Event) {}
        "/advertising/pads2/createcampaign/step2/modal/bidding/trtarget"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step2/modal/bidding/trtarget/changestrategy"(platform: "/", type: TrackType.Event) {
            campaign_name = "track"
            budget = 900
            strategy = "LAUNCHING"
            trtarget = 20
        }
        "/advertising/pads2/createcampaign/step2/modal/bidding/strategy"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step2/modal/bidding/strategy/show"(platform: "/", type: TrackType.View) {
            campaign_name = "track"
            budget = 900
            strategy = "LAUNCHING"
            trtarget = 20
        }
        "/advertising/pads2/createcampaign/step2/modal/bidding/strategy/helper"(platform: "/", type: TrackType.Event) {
            campaign_name = "track"
            budget = 900
            strategy = "LAUNCHING"
        }
        "/advertising/pads2/createcampaign/step2/modal/bidding/strategy/go"(platform: "/", type: TrackType.Event) {
            campaign_name = "track"
            budget = 900
            strategy_previous = "LAUNCHING"
            strategy_new = "PROFITABILITY"
        }
        "/advertising/pads2/createcampaign/step2/modal/bidding/trtarget/show"(platform: "/", type: TrackType.View) {
            campaign_name = "track"
            budget = 900
            strategy = "LAUNCHING"
            trtarget = 20
        }
        "/advertising/pads2/createcampaign/step2/modal/bidding/trtarget/helper"(platform: "/", type: TrackType.Event) {
            campaign_name = "track"
            budget = 900
            strategy = "LAUNCHING"
            trtarget = 20
        }
        "/advertising/pads2/createcampaign/step2/modal/bidding/impact"(platform: "/", type: TrackType.Event) {}
        "/advertising/pads2/createcampaign/step2/modal/bidding/impact/helper"(platform: "/", type: TrackType.Event) {
            campaign_name = "track"
            budget = 900
            strategy = "LAUNCHING"
            trtarget = 20
        }
        "/advertising/pads2/createcampaign/step2/modal/bidding/trtarget/go"(platform: "/", type: TrackType.Event) {
            campaign_name = "track"
            budget = 900
            strategy = "PROFITABILITY"
            trtarget_previous = 35
            trtarget_new = 40
        }
    }

    test("Bidding HUB") {
        "/advertising/pads2/hub/onboarding"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/hub/onboarding/bidding"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/hub/onboarding/bidding/show"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/hub/onboarding/bidding/go"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/hub/tooltip"(platform: "/", type: TrackType.Event) {} 

        "/advertising/pads2/hub/tooltip/bidding"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/hub/tooltip/bidding/objective"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/hub/tooltip/bidding/show"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
        }

        "/advertising/pads2/hub/tooltip/bidding/go"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
        }

        "/advertising/pads2/hub/modal"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/hub/modal/bidding"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/hub/modal/bidding/strategy"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/hub/modal/bidding/strategy/show"(platform: "/", type: TrackType.View) {
            campaign_id = 1
        }

        "/advertising/pads2/hub/modal/bidding/strategy/go"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
            strategy_previous = "LAUNCHING"
            strategy_new = "PROFITABILITY"
        }

        "/advertising/pads2/hub/modal/bidding/strategy/helper"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
        }

        "/advertising/pads2/hub/modal/bidding/trtarget"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/hub/modal/bidding/trtarget/show"(platform: "/", type: TrackType.View) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 35
        }

        "/advertising/pads2/hub/modal/bidding/trtarget/go"(platform: "/", type: TrackType.Event) {
            campaign_id = 35
            strategy = "PROFITABILITY"
            trtarget_previous = 35
            trtarget_new = 40
        }

        "/advertising/pads2/hub/modal/bidding/trtarget/helper"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 35
        }

        "/advertising/pads2/hub/modal/bidding/trtarget/helper/takerate"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
            strategy = "PROFITABILITY"
            trtarget = 5
        }

        "/advertising/pads2/hub/modal/bidding/trtarget/helper/impact"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
            strategy = "PROFITABILITY"
            trtarget = 5
        }

        "/advertising/pads2/hub/modal/bidding/trtarget/changestrategy"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 35
        }

        "/advertising/pads2/hub/update"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/hub/update/bidding"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/hub/update/bidding/trtarget"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/hub/update/budget"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/hub/update/budget/go"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            budget = "4000"
            budget_new = 5600
            budget_type = "D"
            budget_pct_new = "18.8"
            budget_type_new = "D"
            budget_pct_old = "17.0"
        }
        "/advertising/pads2/hub/update/budget/close"(platform: "/", type: TrackType.Event) {
            campaign_id = "2222222"
            budget = "4000"
            budget_type = "D"
        }
        "/advertising/pads2/hub/update/budget/tooltip"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            budget = "4000"
            budget_type = "D"
        }
        "/advertising/pads2/hub/update/bidding/trtarget/pencil"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 5
        }

        "/advertising/pads2/hub/modal/bidding/warning"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/hub/modal/bidding/warning/changetime"(platform: "/", type: TrackType.View) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 5
            days_since_modif = 2
        }

        "/advertising/pads2/hub/modal/bidding/warning/changetime/show"(platform: "/", type: TrackType.View) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 5
            days_since_modif = 2
        }

        "/advertising/pads2/hub/modal/bidding/warning/changetime/stay"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 5
            days_since_modif = 2
        }

        "/advertising/pads2/hub/modal/bidding/warning/changetime/change"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 5
            days_since_modif = 2
        }
    }

    test("Bidding Dashboard") {

        "/advertising/pads2/manager/bidding"(platform: "/", type: TrackType.Event) {}
        "/advertising/pads2/manager/bidding/strategy"(platform: "/", type: TrackType.Event) {}
        "/advertising/pads2/manager/bidding/strategy/helper"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget = 3
        }

        "/advertising/pads2/manager/bidding/trtarget"(platform: "/", type: TrackType.Event) {}
        "/advertising/pads2/manager/bidding/trtarget/pencil"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 3
        }

        "/advertising/pads2/manager/modal"(platform: "/", type: TrackType.Event) {}
        "/advertising/pads2/manager/modal/bidding"(platform: "/", type: TrackType.Event) {}
        "/advertising/pads2/manager/modal/bidding/strategy"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/manager/modal/bidding/strategy/show"(platform: "/", type: TrackType.View) {
            multi = false
            campaign_id = 1
            strategy = "PROFITABILITY"
            trtarget = 15
        }

        "/advertising/pads2/manager/modal/bidding/strategy/go"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 1
            strategy_previous = "PROFITABILITY"
            strategy_new = "LAUNCHING"
        }

        "/advertising/pads2/manager/modal/bidding/strategy/helper"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 1
            strategy = "PROFITABILITY"
        }

        "/advertising/pads2/manager/modal/bidding/trtarget"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/manager/modal/bidding/trtarget/show"(platform: "/", type: TrackType.View) {
            multi = true
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget = 3
        }

        "/advertising/pads2/manager/modal/bidding/trtarget/go"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget_previous = 20
            trtarget_new = 45
        }

        "/advertising/pads2/manager/modal/bidding/trtarget/helper"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget = 3
        }

        "/advertising/pads2/manager/modal/bidding/trtarget/helper/takerate"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 34
            strategy = "PROFITABILITY"
            trtarget = 10
        }

        "/advertising/pads2/manager/modal/bidding/trtarget/helper/impact"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 34
            strategy = "PROFITABILITY"
            trtarget = 3
        }

        "/advertising/pads2/manager/modal/bidding/impact"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/manager/modal/bidding/impact/helper"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget = 3
        }

        "/advertising/pads2/manager/modal/bidding/trtarget/changestrategy"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget = 3
        }

        "/advertising/pads2/manager/modal/bidding/warning"(platform: "/", type: TrackType.View) {}
        "/advertising/pads2/manager/modal/bidding/warning/changetime"(platform: "/", type: TrackType.View) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 5
            multi = true
            days_since_modif = 2
        }

        "/advertising/pads2/manager/modal/bidding/warning/changetime/show"(platform: "/", type: TrackType.View) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 5
            multi = true
            days_since_modif = 2
        }
        "/advertising/pads2/manager/modal/bidding/warning/changetime/stay"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 5
            multi = true
            days_since_modif = 2
        }
        "/advertising/pads2/manager/modal/bidding/warning/changetime/change"(platform: "/", type: TrackType.Event) {
            campaign_id = 1
            strategy = "LAUNCHING"
            trtarget = 5
            multi = true
            days_since_modif = 2
        }
    }

    test("Opportunities Bidding (Hub)") {

        "/advertising/pads2/hub/bidding"(platform: "/", type: TrackType.Event){}
        "/advertising/pads2/hub/bidding/upgrade"(platform: "/", type: TrackType.Event){}
        "/advertising/pads2/hub/bidding/upgrade/row"(platform: "/", type: TrackType.Event){}

        "/advertising/pads2/hub/bidding/upgrade/row/show"(platform: "/", type: TrackType.View) {
            total_campaigns = 5
            campaigns = [
                    {
                        campaign_id: 222
                        strategy: "PROFITABILITY"
                        trtarget: 5
                    }
            ]
        }

        "/advertising/pads2/hub/bidding/upgrade/row/go"(platform: "/", type: TrackType.Event) {
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget = 3
        }

        "/advertising/pads2/hub/bidding/upgrade/tooltip"(platform: "/", type: TrackType.Event){}

        "/advertising/pads2/hub/bidding/upgrade/tooltip/go"(platform: "/", type: TrackType.Event) {
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget = 3
        }

        "/advertising/pads2/hub/bidding/upgrade/modal"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/hub/bidding/upgrade/modal/show"(platform: "/", type: TrackType.View) {
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget_previous = 20
            trtarget_new = 45
        }

        "/advertising/pads2/hub/bidding/upgrade/modal/go"(platform: "/", type: TrackType.Event) {
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget_previous = 20
            trtarget_new = 45
        }

    }

    test("Opportunities Bidding (Dashboard)"){

        "/advertising/pads2/manager/bidding/upgrade"(platform: "/", type: TrackType.Event) {}
        "/advertising/pads2/manager/bidding/upgrade/box"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/manager/bidding/upgrade/box/show"(platform: "/", type: TrackType.View) {
            multi = true
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget = 3
        }

        "/advertising/pads2/manager/bidding/upgrade/box/go"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget = 3
        }
 
        "/advertising/pads2/manager/bidding/upgrade/modal"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/manager/bidding/upgrade/modal/show"(platform: "/", type: TrackType.View) {
            multi = true
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget_previous = 20
            trtarget_new = 45
        }

        "/advertising/pads2/manager/bidding/upgrade/modal/go"(platform: "/", type: TrackType.Event) {
            multi = true
            campaign_id = 34
            strategy = "LAUNCHING"
            trtarget_previous = 20
            trtarget_new = 45
        }

    }

    test("Advertising Adserver"){
        "/advertising/adserver/ads/view"(platform: "/", type: TrackType.View) {
            c_id = "home/top_home_banner"
            c_category = "nike_2"
            c_event = "view"
            c_original_target = "meli://test"
        }
    }

    test("Advertising - Campaign Transition"){
        "/advertising/pads2/configuration"(platform: "/", type: TrackType.Event) {
            campaign_id = 123
            status = "active"
            mode = "automatic"
        }

        "/advertising/pads2/configuration"(platform: "/", type: TrackType.Event) {
            mode = "custom"
        }

        "/advertising/pads2/configuration/mode"(platform: "/", type: TrackType.View) {
            campaign_id = 123
            status = "active"
            mode = "automatic"
        }

        "/advertising/pads2/configuration/mode"(platform: "/", type: TrackType.View) {
            mode = "custom"
        }

        "/advertising/pads2/configuration/mode/change"(platform: "/", type: TrackType.Event) {
            campaign_id = 123
            status = "active"
            mode_previous = "automatic"
            mode_new = "custom"
        }

        "/advertising/pads2/configuration/mode/change"(platform: "/", type: TrackType.Event) {
            mode_previous = "custom"
            mode_new = "automatic"
        }

        "/advertising/pads2/configuration/mode/details"(platform: "/", type: TrackType.View) {
            campaign_id = 123
            status = "active"
            mode_previous = "automatic"
            mode_new = "custom"
        }

        "/advertising/pads2/configuration/mode/details"(platform: "/", type: TrackType.View) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
            ads_active = 1
            ads_deleted = 1
        }

        "/advertising/pads2/configuration/mode/details/next"(platform: "/", type: TrackType.Event) {
            campaign_id = 123
            status = "active"
            mode_previous = "automatic"
            mode_new = "custom"
        }

        "/advertising/pads2/configuration/mode/details/next"(platform: "/", type: TrackType.Event) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
            ads_active = 1
            ads_deleted = 1
        }

        "/advertising/pads2/configuration/mode/confirmation"(platform: "/", type: TrackType.View) {
            campaign_id = 123
            status = "active"
            mode = "automatic"
        }

        "/advertising/pads2/configuration/mode/confirmation"(platform: "/", type: TrackType.View) {
            mode = "custom"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
            total_ads = 1
        }

        "/advertising/pads2/configuration/mode/confirmation/cta"(platform: "/", type: TrackType.Event) {
            campaign_id = 123
            status = "active"
            mode = "automatic"
        }

        "/advertising/pads2/configuration/mode/confirmation/cta"(platform: "/", type: TrackType.Event) {
            mode = "custom"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
            total_ads = 1
        }

        "/advertising/pads2/configuration/emptystate"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/configuration/mode/strategy"(platform: "/", type: TrackType.View) {
            mode_previous = "custom"
            mode_new = "automatic"
        }

        "/advertising/pads2/configuration/mode/strategy/next"(platform: "/", type: TrackType.Event) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
        }

        "/advertising/pads2/configuration/mode/settings"(platform: "/", type: TrackType.View) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
        }

        "/advertising/pads2/configuration/mode/settings/next"(platform: "/", type: TrackType.Event) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
        }

        "/advertising/pads2/configuration/mode/addads"(platform: "/", type: TrackType.View) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
        }

        "/advertising/pads2/configuration/mode/addads/add"(platform: "/", type: TrackType.Event) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
            total_ads = 1
        }

        "/advertising/pads2/configuration/mode/addads/editads"(platform: "/", type: TrackType.Event) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
            total_ads = 1
        }

        "/advertising/pads2/configuration/mode/addads/editads/confirm"(platform: "/", type: TrackType.Event) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
            total_ads = 1
            total_ads_deleted = 1
        }

        "/advertising/pads2/configuration/mode/addads/confirm"(platform: "/", type: TrackType.View) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
            total_ads = 1
        }

        "/advertising/pads2/configuration/mode/details/showads"(platform: "/", type: TrackType.Event) {
            mode_previous = "custom"
            mode_new = "automatic"
            strategy = "PROFITABILITY"
            campaign_name = "campaign name"
            budget = 1
            trtarget = 1
            ads_active = 1
            ads_deleted = 1
        }

        "/advertising/pads2/manager/auto/modal/show"(platform: "/", type: TrackType.View) {
            campaign_id = 123
            status = "active"
            mode = "automatic"
        }

        "/advertising/pads2/manager/auto/modal/show"(platform: "/", type: TrackType.View) {
            mode = "custom"
        }

        "/advertising/pads2/manager/auto/modal/close"(platform: "/", type: TrackType.Event) {
            campaign_id = 123
            status = "active"
            mode = "automatic"
        }

        "/advertising/pads2/manager/auto/modal/close"(platform: "/", type: TrackType.Event) {
            mode = "custom"
        }

        "/advertising/pads2/manager/auto/modal/go"(platform: "/", type: TrackType.Event) {
            campaign_id = 123
            status = "active"
            mode = "automatic"
        }

        "/advertising/pads2/manager/auto/modal/go"(platform: "/", type: TrackType.Event) {
            mode = "custom"
        }
    }
}
