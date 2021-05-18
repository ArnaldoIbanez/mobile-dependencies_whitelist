package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("seller central bulk view") {
        "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {}
    }

    test("seller central bulk onboarding") {
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

    test("seller central bulk view") {
        "/seller_central/bulk/domain"(platform: "/", type: TrackType.Event) {
            id = "technical_specification"
        }
    }

    test("seller central bulk filters and search") {
        "/seller_central/bulk/filters"(platform: "/", type: TrackType.Event) {
            filters = ["active", "inactive"]
        }
    }

    test("seller central bulk filters and search") {
        "/seller_central/bulk/undo_changes"(platform: "/", type: TrackType.Event) {}
        "/seller_central/bulk/search"(platform: "/", type: TrackType.Event) {}
    }


    test("seller central bulk columns") {
        "/seller_central/bulk/columns"(platform: "/", type: TrackType.Event) {
            columns = ["price", "quantity"]
        }
    }

    test("seller central bulk changes price") {
        "/seller_central/bulk/changes/price"(platform: "/", type: TrackType.Event) {
            oldValue = "20"
            newValue = "25"
            item_id = "MLB341920"
        }
    }

    test("seller central bulk changes price mshops") {
        "/seller_central/bulk/changes/price_mshops"(platform: "/", type: TrackType.Event) {
            old_value = "20"
            new_value = "25"
            item_id = "MLB341920"
        }
    }

    test("seller central bulk changes listing type") {
        "/seller_central/bulk/massive_action/listing_type"(platform: "/", type: TrackType.Event) {
            listing_type = "gold_special"
        }
    }

    test("seller central bulk changes quantity") {
        "/seller_central/bulk/massive_action/quantity"(platform: "/", type: TrackType.Event) {
            quantity = 20
        }
    }

    test("seller central bulk changes shipping method") {
        "/seller_central/bulk/massive_action/shipping_method"(platform: "/", type: TrackType.Event) {
            operation_id = "ADD_SHIPPING"
        }
    }

    test("seller central bulk changes syncro price") {
        "/seller_central/bulk/massive_action/syncro_price"(platform: "/", type: TrackType.Event) {
            operation_id = "YES"
        }
    }

    test("seller central bulk changes delete inactivess") {
       "/seller_central/bulk/massive_action/delete_inactive"(platform: "/", type: TrackType.Event) {
            operation_id = "DELETE"
        }
    }

   test("seller central bulk changes status") {
       "/seller_central/bulk/massive_action/status"(platform: "/", type: TrackType.Event) {
            operation_id = "ACTIVATE"
        }
    }

    test("seller central bulk shipping tooltip") {
        "/seller_central/bulk/shipping/tooltip"(platform: "/", type: TrackType.Event) {
            item_id = "MLB341920"
        }
    }

    test("seller central open tooltip view") {
        "/seller_central/bulk/open_tooltip"(platform: "/", type: TrackType.View) {}
    }
}

