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
            lift_visible = true
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

    test("Advertising Lift") {
        "/advertising/pads2/manager/lift/details/show"(platform: "/web", type: TrackType.Event) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
            share_value = "20"
        }
        "/advertising/pads2/manager/lift/details/hide"(platform: "/web", type: TrackType.Event) {
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
        "/advertising/pads2/manager/lift/chart/hide"(platform: "/web", type: TrackType.Event) {
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
}
