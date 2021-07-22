package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("seller central bulk view") {
        "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
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
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }

    test("seller central bulk changes price mshops") {
        "/seller_central/bulk/changes/price_mshops"(platform: "/", type: TrackType.Event) {
            old_value = "20"
            new_value = "25"
            item_id = "MLB341920"
        }
    }

   test("seller central bulk changes massive actions price") {
        "/seller_central/bulk/massive_action/price"(platform: "/", type: TrackType.Event) {
            column_id = "price"
            operation_id = "increase_price_value"
            price = 200
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }

    test("seller central bulk changes massive actions channel") {
        "/seller_central/bulk/massive_action/channel"(platform: "/", type: TrackType.Event) {
            column_id = "channel"
            operation_id = "none"
            value_id = "ml_mshops"
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }

    test("seller central bulk changes massive actions quantity") {
        "/seller_central/bulk/massive_action/quantity"(platform: "/", type: TrackType.Event) {
            column_id = "quantity"
            operation_id = "none"
            quantity = 2;
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }
    
    test("seller central bulk changes massive actions listing_type") {
        "/seller_central/bulk/massive_action/listing_type"(platform: "/", type: TrackType.Event) {
            column_id = "listing_type"
            operation_id = "none"
            listing_type = "gold_special";
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }

    test("seller central bulk changes massive actions secondary_action") {
        "/seller_central/bulk/massive_action/secondary_action"(platform: "/", type: TrackType.Event) {
            column_id = "secondary_actions_column"
            operation_id = "DELETE"
            secondary_actions = "massive_secondary_action_modal_delete";
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }

      test("seller central bulk changes massive actions shipping_type") {
        "/seller_central/bulk/massive_action/shipping_type"(platform: "/", type: TrackType.Event) {
            column_id = "shipping_type"
            operation_id = "UPDATE_SHIPPING_TYPE"
            local_pickup = true
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }

    test("seller central bulk changes massive actions manufacturing_time") {
        "/seller_central/bulk/massive_action/manufacturing_time"(platform: "/", type: TrackType.Event) {
            column_id = "manufacturing_time"
            operation_id = "ADD_MANUFACTURING_TIME"
            time= 200
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }
      test("seller central bulk changes massive actions warranty") {
        "/seller_central/bulk/massive_action/warranty"(platform: "/", type: TrackType.Event) {
            column_id = "warranty"
            operation_id = "WARRANTY"
            type_value = "2230280"
            time_option = "day"
            time_value = 30
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }

     test("seller central bulk changes massive actions shipping_method") {
        "/seller_central/bulk/massive_action/shipping_method"(platform: "/", type: TrackType.Event) {
            column_id = "shipping_method"
            operation_id = "none"
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }

    test("seller central bulk changes massive actions status") {
        "/seller_central/bulk/massive_action/status"(platform: "/", type: TrackType.Event) {
            column_id = "status"
            operation_id = "none"
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
        }
    }
    test("seller central bulk changes massive actions sync_price") {
        "/seller_central/bulk/massive_action/sync_price"(platform: "/", type: TrackType.Event) {
            column_id = "sync_price"
            operation_id = "none"
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
            session_id = "515106248-edition-72151975d676"
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

