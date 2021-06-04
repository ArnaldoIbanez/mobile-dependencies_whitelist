package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("seller central bulk view mp") {
        "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {}
    }

    test("seller central bulk onboarding mp") {
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "start"
            viewId = "fulfillment"
        }
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "dismiss"
            page = 2
        }
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "rollback"
        }
    }

    test("seller central bulk view mp") {
        "/seller_central/bulk/domain"(platform: "/", type: TrackType.Event) {
            id = "technical_specification"
        }
    }

    test("seller central bulk filters and search mp") {
        "/seller_central/bulk/filters"(platform: "/", type: TrackType.Event) {
            filters = ["active", "inactive"]
        }
    }

    test("seller central bulk filters and search mp") {
        "/seller_central/bulk/undo_changes"(platform: "/", type: TrackType.Event) {}
        "/seller_central/bulk/search"(platform: "/", type: TrackType.Event) {}
    }


    test("seller central bulk columns mp") {
        "/seller_central/bulk/columns"(platform: "/", type: TrackType.Event) {
            columns = ["price", "quantity"]
        }
    }

    test("seller central bulk changes price mp") {
        "/seller_central/bulk/changes/price"(platform: "/", type: TrackType.Event) {
            oldValue = "20"
            newValue = "25"
            item_id = "MLB341920"
        }
    }

      test("seller central bulk changes price mp column mshops") {
        "/seller_central/bulk/changes/price_mshops"(platform: "/", type: TrackType.Event) {
            old_value = "20"
            new_value = "25"
            item_id = "MLB341920"
        }
    }

     test("seller central bulk changes massive actions mp") {
        "/seller_central/bulk/massive_action"(platform: "/", type: TrackType.Event) {
            column_id = "price"
            operation_id = "increase_price_value"
        }
    }

    test("seller central bulk shipping tooltip mp") {
        "/seller_central/bulk/shipping/tooltip"(platform: "/", type: TrackType.Event) {
            item_id = "MLB341920"
        }
    }

    test("seller central open tooltip view mp") {
        "/seller_central/bulk/open_tooltip"(platform: "/", type: TrackType.View) {}
    }
}

