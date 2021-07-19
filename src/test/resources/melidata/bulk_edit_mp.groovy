package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("seller central bulk view mp") {
        "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {
            seller_reputation = "5_green"
            user_type = "normal"
            user_shops_status = "active"
        }
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

   test("seller central bulk changes massive actions price mp") {
        "/seller_central/bulk/massive_action/price"(platform: "/", type: TrackType.Event) {
            column_id = "price"
            operation_id = "increase_price_value"
            price = 200
        }
    }
    test("seller central bulk changes massive actions channel mp") {
        "/seller_central/bulk/massive_action/channel"(platform: "/", type: TrackType.Event) {
            column_id = "channel"
            operation_id = "none"
            value_id =  "ml_mshops"
            value_name = "ml_mshops"
        }
    }


    test("seller central bulk changes massive actions quantity mp") {
        "/seller_central/bulk/massive_action/quantity"(platform: "/", type: TrackType.Event) {
            column_id = "quantity"
            operation_id = "none"
            quantity = 2;
        }
    }
    
    test("seller central bulk changes massive actions listing_type mp") {
        "/seller_central/bulk/massive_action/listing_type"(platform: "/", type: TrackType.Event) {
            column_id = "listing_type"
            operation_id = "none"
            listing_type = "gold_special";
        }
    }

    test("seller central bulk changes massive actions secondary_action mp") {
        "/seller_central/bulk/massive_action/secondary_action"(platform: "/", type: TrackType.Event) {
            column_id = "secondary_actions_column"
            operation_id = "DELETE"
            secondary_actions = "massive_secondary_action_modal_delete";
        }
    }

      test("seller central bulk changes massive actions shipping_type mp") {
        "/seller_central/bulk/massive_action/shipping_type"(platform: "/", type: TrackType.Event) {
            column_id = "shipping_type"
            operation_id = "UPDATE_SHIPPING_TYPE"
            local_pickup = true
        }
    }
    
    test("seller central bulk changes massive actions manufacturing_time mp") {
        "/seller_central/bulk/massive_action/manufacturing_time"(platform: "/", type: TrackType.Event) {
            column_id = "manufacturing_time"
            operation_id = "ADD_MANUFACTURING_TIME"
            time = 200
        }
    }
      test("seller central bulk changes massive actions warranty mp") {
        "/seller_central/bulk/massive_action/warranty"(platform: "/", type: TrackType.Event) {
            column_id = "warranty"
            operation_id = "WARRANTY"
            type_value = "2230280"
            time_option = "day"
            time_value = 30
        }
    }

     test("seller central bulk changes massive actions shipping_method mp") {
        "/seller_central/bulk/massive_action/shipping_method"(platform: "/", type: TrackType.Event) {
            column_id = "shipping_method"
            operation_id = "none"
        }
    }

    test("seller central bulk changes massive actions status mp") {
        "/seller_central/bulk/massive_action/status"(platform: "/", type: TrackType.Event) {
            column_id = "status"
            operation_id = "none"
        }
    }
    test("seller central bulk changes massive actions sync_price mp") {
        "/seller_central/bulk/massive_action/sync_price"(platform: "/", type: TrackType.Event) {
            column_id = "sync_price"
            operation_id = "none"
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

