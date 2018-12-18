package src.test.resources

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    def trackData = {
        error_type = "SERVER"
        feedback_type = "WARNING"
        feedback_message = "Some feedback message"
    }

    def trackDataForAudit = {
        warehouse_id = "BRWT01"
        error_type = "SERVER"
        feedback_type = "WARNING"
        feedback_message = "Some feedback message"
        audit_id = 1234
        inbound_id = 5678
        inventory_id = "AAAA00001"
        address_id = "RS-0-001-000-00-00"
        damaged_quantity = 1
        quantity = 1
        from_count_around = "false"
    }

    def trackDataForPickingDefault = {
        checkpoint_id = 1
    }

    def trackDataForPickingForItemAndDestination = {
        checkpoint_id = 1
        inventory_id = 'AAAA00001'
        destination_address = 'CA-0-001-000-00-00'
        checkpoint_status = 'picked_up'
    }

    test("WMS App") {

        //Views
        "/wms/login"(platform: "/mobile/android") {
            trackData()
        }
        "/wms/home"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/receiving"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/put_away"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/confirmation"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/scan_cart"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/scan_inventory"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/item"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
            inventory_id = "AAAA00001"
            quantity = 123
        }
        "/wms/inbound_audit"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/confirmation"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/scan_shelf"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/item"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/item/damaged_item"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/count_around"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/congrats"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/transfer"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/found"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/restock"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/picking"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/confirmation"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
        }
        "/wms/picking/confirmation/scan_closest_address"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/confirmation/floor_selection"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/scan_container"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/scan_shelf"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/item"(platform: "/mobile/android") {
            trackDataForPickingForItemAndDestination()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/scan_destination"(platform: "/mobile/android") {
            trackDataForPickingForItemAndDestination()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/change_floor_confirmation"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/change_floor_scan"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/congrats"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/return"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/cycle_count/confirmation"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/cycle_count/scan_shelf"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/scan_inventory"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/scan_inventory/finish_cycle_count"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/item"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
            inventory_id = "AAAA11111"
            quantity = 1
        }
        "/wms/withdrawals_removal"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            removal_id = "1"
        }
        "/wms/withdrawals_removal/authorization"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/withdrawals_removal/scan_shelf"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            removal_id = "1"
            address_id = "RO-0-001-001-00-00"
        }
        "/wms/withdrawals_removal/confirmation"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            removal_id = "1"
        }
        "/wms/withdrawals_collector"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/withdrawals_collector/confirmation"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/withdrawals_collector/scan_container"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/withdrawals_collector/scan_shelf"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_address = "CA-0-100-000-00-00"
            pickup_id = "1"
        }
        "/wms/withdrawals_collector/item"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
            inventory_id = "AAAA11111"
            checkpoint_id = "2"
        }
        "/wms/withdrawals_collector/scan_destination"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/withdrawals_collector/congrats"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/problem_solver"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/problem_solver/take/scan_inbound_shipment"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/problem_solver/take/scan_destination"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            inbound_id = "1234"
            destination_address = "destination_address"
        }

        //Events
        "/wms/scan"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            context = "/wms/picking/scan_container"
            input_data = "CA-0-001-000-00-00"
            source = "scanner"
        }
        "/wms/put_away/scan_cart/start_put_away"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/scan_inventory/post_item"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
            is_retry = true
            idempotency_key = "AbCdFgHi"
        }
    
        "/wms/put_away/scan_inventory/cancel_put_away"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/scan_inventory/end_put_away"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }  
        "/wms/inbound_audit/confirmation/start_audit"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/item/reset_audit"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/item/finish_checkpoint"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/item/item_not_found"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/item/damaged_item_confirmation"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/count_around/start_count_around"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/inbound_audit/count_around/skip_count_around"(platform: "/mobile/android") {
            trackDataForAudit()
            warehouse_id = "BRWT01"
        }
        "/wms/cycle_count/confirmation/start_cycle_count"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/cycle_count/scan_inventory/finish_address"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/scan_inventory/finish_cycle_count"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/item/finish_address"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
            inventory_id = "AAAA11111"
            quantity = 1
        }
        "/wms/cycle_count/item/reset_address"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
            inventory_id = "AAAA11111"
            quantity = 1
            navigate_to_home = true
        }
        "/wms/cycle_count/item/finish_cycle_count"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
            inventory_id = "AAAA11111"
            quantity = 1
        }
        "/wms/picking/confirmation/start_pickup"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/item/item_not_found"(platform: "/mobile/android") {
            trackDataForPickingForItemAndDestination()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/item/finish_checkpoint"(platform: "/mobile/android") {
            trackDataForPickingForItemAndDestination()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/scan_destination/finish_checkpoint"(platform: "/mobile/android") {
            trackDataForPickingForItemAndDestination()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/picking/congrats/finish_pickup"(platform: "/mobile/android") {
            trackDataForPickingDefault()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/withdrawals_removal/authorization/start_removal"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            removal_id = "1"
        }
        "/wms/withdrawals_removal/confirmation/finish_removal"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            removal_id = "1"
        }
        "/wms/withdrawals_collector/confirmation/start_withdrawal"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/withdrawals_collector/item/update_checkpoint"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
            inventory_id = "AAAA11111"
            checkpoint_id = "2"
        }
        "/wms/withdrawals_collector/item/item_not_found"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
            inventory_id = "AAAA11111"
            checkpoint_id = "2"
        }
        "/wms/withdrawals_collector/item/start_unload_cart"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
            inventory_id = "AAAA11111"
            checkpoint_id = "2"
        }
        "/wms/withdrawals_collector/congrats/finish_unload_cart"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/withdrawals_collector/congrats/finish_withdrawal"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            pickup_id = "1"
        }
        "/wms/problem_solver/take"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
    }
}
