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
            multi = false
            status = "active"
            budget = "500"
            budget_suggested = "1000"
            version = "view1"
            budget_new = "800"
        }

        "/advertising/pads2/manager/upselling/modal/go"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            multi = false
            status = "active"
            budget = "500"
            budget_suggested = "1000"
            budget_selected = "800"
            budget_new = "800"
            version = "view1"
        }

        "/advertising/pads2/manager/upselling/modal/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            multi = false
            status = "active"
            budget = "500"
            budget_suggested = "1000"
            budget_selected = "800"
            budget_new = "800"            

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
            multi = false
            status = "active"
            budget = "500"
            version = "view1"
        }

        "/advertising/pads2/manager/upselling/tooltip/go"(platform: "/web", type: TrackType.Event) {
            campaign_id = "283973028"
            multi = false
            status = "active"
            budget = "500"
            version = "view1"
            budget_new = "800"
        }

        "/advertising/pads2/manager/upselling/tooltip/close"(platform: "/web", type: TrackType.Event) {
            campaign_id = "283973028"
            multi = false
            status = "active"
            budget = "500"
            version = "view1"
            budget_new = "800"
        }

        "/advertising/pads2/manager/box/upselling/go"(platform: "/web", type: TrackType.Event) {
            campaign_id = "283973028"
            multi = false
            status = "active"
            budget = "500"
        }

        "/advertising/pads2/manager/box"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
        }

        "/advertising/pads2/manager/box/upselling"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
        }

        "/advertising/pads2/manager/upselling/tooltip"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "500"
            budget_new = "1000"
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

    test("Advertising manager Sort Filters") {
        "/advertising/pads2/manager/sort"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            sort_by = "price"
            sort_value= "asc"
        }
        "/advertising/pads2/manager/sort"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            sort_by = "sales"
            sort_value= "asc"
        }
        "/advertising/pads2/manager/sort"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            sort_by = "sales"
            sort_value= "desc"
        }
        "/advertising/pads2/manager/filters"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            filters = [:]
        }
        "/advertising/pads2/manager/filters"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "70"
            filters = [
                status: "A",
                release_date: "less_than_seven_days",
                category: "x",
                features: "x",
                query: "x",
            ]
        }
    }

    test("Advertising manager Range") {
        "/advertising/pads2/manager/metrics_range"(platform: "/web", type: TrackType.Event) {
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

}
