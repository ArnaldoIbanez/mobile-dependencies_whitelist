package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Advertising manager basic track") {
        "/advertising/pads2/manager"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
            chart_visible = true
            detailsMeli_visible = true
            share_visible = true
        }

        "/advertising/pads2/manager"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
            chart_visible = true
            detailsMeli_visible = true
            share_visible = true
            matching_status = "matching_inversion"
        }

        "/advertising/pads2/manager/box/upselling"(platform: "/web", type: TrackType.Event) {
            campaign_id = "283973028"
            status = "active"
            budget = "65"
            version = "view1"
        }

        "/advertising/pads2/manager/update_campaign_status"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            previous_status = "paused"
        }

        "/advertising/pads2/manager/update_campaign_budget"(platform: "/web", type: TrackType.Event) {
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
        "/advertising/pads2/landing"(platform: "/web", type: TrackType.View) {
            free_trial_ad = true
            budget = 500
        }

        "/advertising/pads2/landing/main_action"(platform: "/web", type: TrackType.Event) {
            button = "top"
            free_trial_ad = true
            budget = 500
        }

        "/advertising/pads2/landing/main_action"(platform: "/web", type: TrackType.Event) {
            button = "top"
            free_trial_ad = true
            budget = 500
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing/from_main_slider"(platform: "/web", type: TrackType.Event) {
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing/contract_confirmation"(platform: "/web", type: TrackType.View) {
            free_trial_ad = true
        }

        "/advertising/pads2/landing/contract_confirmation/confirm"(platform: "/web", type: TrackType.Event) {
            budget = "22.22"
            free_trial_ad = true
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing/contract_confirmation/confirmOfficialStore"(platform: "/web", type: TrackType.Event) {
            budget = "22.22"
            free_trial_ad = false
            id = "adq_pads"
            position = "home_desktop"
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

    test("Advertising upselling") {
        "/advertising/pads2/manager/upselling/modal/show"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
            budget_new = "1000"
        }

        "/advertising/pads2/manager/upselling/modal/go"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
            budget_new = "1000"
        }

        "/advertising/pads2/manager/upselling/modal/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
            budget_new = "1000"
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
            campaign_id = "283973028"
            status = "active"
            budget = "65"
            version = "view1"
        }
  
    }

    test("Landing congrats") {
        "/advertising/landings/pads2/mail/congrats"(platform: "/web", type: TrackType.View) {
            user_id = "2222222"
            items_id = "MLA1,MLA2,MLA3,MLA4,MLA5"
        }
    }

    test("Landing free trial") {
        "/advertising/pads2/landing_freetrial"(platform: "/web", type: TrackType.View) {
            free_trial_type = "F"
            budget = "500"
        }

        "/advertising/pads2/landing_freetrial"(platform: "/web", type: TrackType.View) {
            free_trial_type = "D"
            budget = "500"
        }

        "/advertising/pads2/landing_freetrial"(platform: "/web", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
        }

        "/advertising/pads2/landing_freetrial/cta"(platform: "/web", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
            button = "top"
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing_freetrial/cta"(platform: "/web", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
            button = "top"
        }

        "/advertising/pads2/landing_freetrial/confirm"(platform: "/web", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
        }

        "/advertising/pads2/landing_freetrial/confirm/cta"(platform: "/web", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
            id = "adq_pads"
            position = "home_desktop"
        }

        "/advertising/pads2/landing_freetrial/confirm/cta"(platform: "/web", type: TrackType.View) {
            free_trial_type = "M"
            budget = "500"
        }
    }

    test("Advertising Lift") {
        "/advertising/pads2/manager/lift/details/show"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/details/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }

        "/advertising/pads2/manager/lift/chart/show"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/chart/close"(platform: "/web", type: TrackType.Event) {
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

        "/advertising/pads2/manager/lift/modal/open"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/modal/pause"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/modal/continue"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/modal/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
    }

    test("Advertising manager SLL") {
        "/advertising/pads2/manager/card/sll"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            sll_total = "10"
        }

        "/advertising/pads2/manager/card/sll"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            sll_total = "10"
        }

        "/advertising/pads2/manager/ssl/landing"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            sll_total = "10"
        }

        "/advertising/pads2/manager/ssl/landing/activated"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            sll_total_activated = "10"
        }

        "/advertising/pads2/manager/ssl/landing/breadcrumb"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            sll_total = "10"
        }

        "/advertising/pads2/manager/card/upselling"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            budget = "10"
            budget_new = "20"
        }

        "/advertising/pads2/manager/card/upselling"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            budget = "10"
            budget_new = "20"
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
            campaign_id = "2222222"
        }
    }

    test("Advertising Matching") {
        "/advertising/pads2/manager/winbacks/onboarding"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "paused"
            budget = "400"
            step= "1"
        }
        "/advertising/pads2/manager/winbacks/onboarding/cta"(platform: "/web", type: TrackType.Event) {
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
        "/advertising/pads2/manager/winbacks/confirmation"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "paused"
            budget = "400"
            new_budget = "600"
        }
        "/advertising/pads2/manager/winbacks/confirmation/cta"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "paused"
            budget = "400"
            new_budget = "600"
        }
        "/advertising/pads2/manager/winbacks/confirmation/cta/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "paused"
            budget = "400"
            new_budget = "600"
        }
    }

    test("Advertising manager Sort Filters") {
        "/advertising/pads2/manager/sort"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            sort_by = "price"
            sort_value= "asc"
            multi = true
            budget = "4000"
            status = "active"
        }
        "/advertising/pads2/manager/sort"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            sort_by = "sales"
            sort_value= "asc"
            multi = true
            budget = "4000"
            status = "active"
        }
        "/advertising/pads2/manager/sort"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            sort_by = "sales"
            sort_value= "desc"
            multi = true
            budget = "4000"
            status = "active"
        }
        "/advertising/pads2/manager/filters"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            filters = [:]
            multi = true
            status = "active"
            budget = "70"
        }
        "/advertising/pads2/manager/filters"(platform: "/web", type: TrackType.Event) {
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
                catalog: "buy_box_winner"
            ]
        }
    }

    test("Advertising manager Range") {
        "/advertising/pads2/manager/metrics_range"(platform: "/web", type: TrackType.Event) {
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
        "/advertising/pads2/hub"(platform: "/web", type: TrackType.View) {
            tab = "ads"
            campaigs = [
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
            campaign_id_from = "2222222"
            status_from = "active"
            campaign_id_to = "1111111"
            status_to = "active"
            check = "avtive"
            q_Ads = "ads_q"
        }

        "/advertising/pads2/hub/moveads/cancel"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/hub/moveads/filters"(platform: "/web", type: TrackType.Event) {
        filters = [
                    query: "x",
                ]
        }

        "/advertising/pads2/createcampaign"(platform: "/web", type: TrackType.Event) {}

        "/advertising/pads2/createcampaign/step1"(platform: "/web", type: TrackType.View) {
        campaign_name = "celulares"
        budget = "4000"
        }

        "/advertising/pads2/createcampaign/step1/next"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = "4000"
        }

        "/advertising/pads2/createcampaign/step1/breadcrumb"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = "4000"
        }

        "/advertising/pads2/createcampaign/step1/helperbudget"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = "4000"
        }

        "/advertising/pads2/createcampaign/step2"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = "4000"
        }

        "/advertising/pads2/createcampaign/step2/createcampaign"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = "4000"
        ads = "ads_1"
        check_active = "true"
        }

        "/advertising/pads2/createcampaign/step2/breadcrumb"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = "4000"
        ads = "ads_1"
        check_active = "true"
        }

        "/advertising/pads2/createcampaign/step2/helperbudget"(platform: "/web", type: TrackType.Event) {
        campaign_name = "celulares"
        budget = "4000"
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
            budget = "4000"
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
            budget = "4000"
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
            new_ads= "2"
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

        "/advertising/pads2/manager/update/budget/go"(platform: "/web", type: TrackType.Event) {
            multi = true
            campaign_id = "2222222"
            budget_previous = 4000
            budget_new = 5600
        }

        "/advertising/pads2/manager/update/budget/close"(platform: "/web", type: TrackType.Event) {
            multi = true
            campaign_id = "2222222"
            budget = "4000"
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

        "/advertising/pads2/manager/filters"(platform: "/web", type: TrackType.Event) {
            multi = true
            filters = [
                    multi: "x",
                    query: "x",
                ]
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
        }

        "/advertising/pads2/manager/metrics_range"(platform: "/web", type: TrackType.Event) {
            multi = true
            days = 31
            from = "2020-02-19"
            to = "to_1"
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
        }

        "/advertising/pads2/manager/sort"(platform: "/web", type: TrackType.Event) {
            sort_by = "price"
            sort_value= "asc"
            campaign_id = "2222222"
            multi = true
            budget = "4000"
            status = "active"
        }
    }

    test("Advertising Admin Mobile") {

        "/advertising/pads2/manager/faqs"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
            has_problem = "error"
            problem_type = "test"
        }

        "/advertising/pads2/manager/budget"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
            suggested_budget = "7000"
        }

        "/advertising/pads2/manager/budget/suggested"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
            suggested_budget = "7000"
        }

        "/advertising/pads2/manager/budget/suggested"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            budget = "4000"
            status = "active"
            suggested_budget = "7000"
        }
    }
}
