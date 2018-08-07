package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Advertising manager basic track") {
        "/advertising/pads2/manager"(platform: "/web", type: TrackType.View) {
            campaign_id = "2222222"
            status = "active"
            budget = "22.22"
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
    }

    test("Advertising generic landing") {
        "/advertising/pads2/generic_landing"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/generic_landing/main_action"(platform: "/", type: TrackType.Event) {
            button = "top"
        }

        "/advertising/pads2/generic_landing/change_budget"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/generic_landing/contract_confirmation"(platform: "/", type: TrackType.View) {}

        "/advertising/pads2/generic_landing/contract_confirmation/change_budget"(platform: "/", type: TrackType.Event) {}

        "/advertising/pads2/generic_landing/contract_confirmation/change_budget/confirm"(platform: "/", type: TrackType.Event) {
            budget = "22.22"
        }

        "/advertising/pads2/generic_landing/contract_confirmation/confirm"(platform: "/", type: TrackType.Event) {
            budget = "22.22"
        }
    }
}
