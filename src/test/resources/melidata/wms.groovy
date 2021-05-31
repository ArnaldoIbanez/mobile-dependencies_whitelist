package src.test.resources.melidata

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
        "/wms/inventory"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/receiving"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/receiving/scan_inbound_shipment"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/receiving/scan_destination"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            inbound_id = 1234
            receiving_id = 1234
        }
        "/wms/receiving/scan_inbound_shipment/start_receiving"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/receiving/scan_destination/finish_receiving"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            inbound_id = 1234
            receiving_id = 1234
        }
        // new receiving
        "/wms/receiving/scan_dock"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/receiving/scan_volume"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/receiving/scan_pallet"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/receiving/scan_inbound_shipment"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/receiving/volume_rejection"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/receiving/volume_rejection/confirmation"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/receiving/inbound_shipment_rejection"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/receiving/inbound_shipment_rejection/confirmation"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/receiving/inbound_rejection"(platform: "/mobile/android") {
            trackData()
            inbound_id = 1234
            receiving_id = "1234abv"
            rejection_reason = "key01"
            warehouse_id = "BRWT01"
        }

        "/wms/receiving/receiving_finished"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            receiving_id = "1234abc"
        }

        "/wms/receiving/volume_rejection"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            receiving_id = "1234abv"
            rejection_reason = "key01"
            volume_label = "1234456/12"
        }

        "/wms/receiving/inbound_shipment_rejection"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            receiving_id = "1234abc"
            rejection_reason = "key01"
            inbound_id = 1234
        }

        // new put away
        "/wms/put_away/scan_origin"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/put_away/scan_product"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/put_away/scan_product_destination"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/sorter/scan_origin"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }

        "/wms/put_away/scan_product/cancel"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            putaway_id = 111
        }

        "/wms/put_away/scan_product/finish"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            putaway_id = 111
            inventory_id = "ABCD12345"
        }

        // put away
        "/wms/receiving/device/printer/mobile/reprint"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            receiving_id = 1234
            volume_label = "1234/12"
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
            count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/scan_inventory"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/scan_inventory/finish_count"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/item"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            count_id = 123
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
        "/wms/withdrawals_collector/scan_shelf/start_unload_cart"(platform: "/mobile/android") {
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
        "/wms/problem_solver_inbound_tasks"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/problem_solver_inbound_tasks/take/scan_inbound_shipment"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/problem_solver_inbound_tasks/take/scan_destination"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            inbound_id = "1234"
            destination_address = "destination_address"
        }
        "/wms/problem_solver_inbound_tasks/returns/scan_destination"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/problem_solver_inbound_tasks/returns/scan_inbound_shipment"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            destination_address = "destination_address"
        }
        "/wms/problem_solver_inbound_tasks/returns/single_selection"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            inbound_id = "1234"
            destination_address = "destination_address"
        }
        "/wms/problem_solver_inbound_tasks/returns/single_selection/confirmation"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            inbound_id = "1234"
            destination_address = "destination_address"
            return_type = "return_type"
        }
        "/wms/problem_solver_inbound_tasks/returns/scan_stage_in_destination"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            inbound_id = "1234"
            destination_address = "destination_address"
            return_type = "return_type"
        }

        //Problem Solver - Flan
        "/wms/problem_solver/menu"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRTW01"
        }

        "/wms/problem_solver/scan_inbound_shipment"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRTW01"
        }

        "/wms/problem_solver/manual_input_inbound_shipment"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRTW01"
        }

        "/wms/problem_solver/scan_case"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRTW01"
        }

        "/wms/problem_solver/manual_input_case"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRTW01"
        }

        "/wms/problem_solver/scan_transaction_destination"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRTW01"
        }

        "/wms/problem_solver/scan_origin"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRTW01"
        }

        //Events
        "/wms/login_successful"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRTW01"
        }
        "/wms/logout_successful"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRTW01"
        }
        "/wms/scan"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            context = "/wms/picking/scan_container"
            input_data = "CA-0-001-000-00-00"
            source = "scanner"
        }
        "/wms/feedback"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            context = "/wms/picking/scan_container"
            type="error"
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
        "/wms/cycle_count/confirmation/start_count"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/cycle_count/scan_inventory/finish_address"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/scan_inventory/finish_count"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/item/finish_address"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            count_id = 123
            address_id = "RS-0-001-001-00-00"
            inventory_id = "AAAA11111"
            quantity = 1
        }
        "/wms/cycle_count/item/reset_address"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            count_id = 123
            address_id = "RS-0-001-001-00-00"
            inventory_id = "AAAA11111"
            quantity = 1
            navigate_to_home = true
        }
        "/wms/cycle_count/item/finish_count"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
            count_id = 123
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
        "/wms/problem_solver_inbound_tasks/take"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/problem_solver_inbound_tasks/returns"(platform: "/mobile/android") {
            trackData()
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/scan_address"(platform: "/mobile/android") {
            task_id = 123
            cross_counting = true
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/scan_inventory"(platform: "/mobile/android") {
            task_id = 123
            address_id = "RS-0-001-001-01-01"
            cross_counting = false
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/scan_inventory/empty_address"(platform: "/mobile/android") {
            task_id = 123
            address_id = "RS-0-001-001-01-01"
            cross_counting = false
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/scan_address/empty_address"(platform: "/mobile/android") {
            task_id = 123
            address_id = "RS-0-001-001-01-01"
            cross_counting = false
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/item"(platform: "/mobile/android") {
            task_id = 123
            address_id = "RS-0-001-001-01-01"
            inventory_id = "AAAA11111"
            cross_counting = true
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/item/finish_address"(platform: "/mobile/android") {
            task_id = 123
            address_id = "RS-0-001-001-01-01"
            inventory_id = "AAAA11111"
            cross_counting = true
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/item/restart_task"(platform: "/mobile/android") {
            task_id = 123
            address_id = "RS-0-001-001-01-01"
            inventory_id = "AAAA11111"
            cross_counting = true
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/cross_counting/confirmation"(platform: "/mobile/android") {
            task_id = 123
            warehouse_id = "BRWT01"
            address_id = "RS-0-001-001-01-01"
        }
        "/wms/stock_audit/cross_counting/confirmation/confirm"(platform: "/mobile/android") {
            task_id = 123
            warehouse_id = "BRWT01"
            address_id = "RS-0-001-001-01-01"
        }
        "/wms/stock_audit/cross_counting/confirmation/skip"(platform: "/mobile/android") {
            task_id = 123
            warehouse_id = "BRWT01"
            address_id = "RS-0-001-001-01-01"
        }
        "/wms/wall_in/scan_container"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
        }
        "/wms/wall_in/scan_inventory"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            container_address = "CA-0-001-000-00-00"
        }
        "/wms/wall_in/scan_inventory/finish_task"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            container_address = "CA-0-001-000-00-00"
        }
        "/wms/wall_in/to_restock"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            container_address = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
        }
        "/wms/wall_in/to_restock/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            container_address = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
        }
        "/wms/wall_in/to_found"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            container_address = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
        }
        "/wms/wall_in/to_found/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            container_address = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
        }
        "/wms/wall_out/scan_section"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
        }
        "/wms/wall_out/scan_slot"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            section_address = "PW-0-001-000-00-00"
        }
        "/wms/wall_out/scan_box"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            slot_address = "PW-0-001-000-00-00"
        }
        "/wms/wall_out/to_packing"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            slot_address = "PW-0-001-000-00-00"
            box_address = "BX-0-001-000-00-00"
        }
        "/wms/wall_out/to_packing/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            slot_address = "PW-0-001-000-00-00"
            box_address = "BX-0-001-000-00-00"
        }
        "/wms/wall_out/empty_wall"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            section_address = "PW-0-001-000-00-00"
        }
        "/wms/wall_out/empty_wall/retry"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            section_address = "PW-0-001-000-00-00"
        }

        "/wms/quarantine/report/scan_address_from"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
        }
        "/wms/quarantine/report/scan_inventory"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
        }
        "/wms/quarantine/report/scan_inventory/cancel"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
        }
        "/wms/quarantine/report/scan_inventory/finish_address"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
        }
        "/wms/quarantine/report/select_problem"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
        }
        "/wms/quarantine/report/select_problem/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
            problem_type = "damaged"
        }
        "/wms/quarantine/report/select_problem/cancel"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
        }
        "/wms/quarantine/report/select_problem/other"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
        }
        "/wms/quarantine/report/select_problem/other/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
            description = "Es fraudulento"
        }
        "/wms/quarantine/report/confirmation"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
            problem_type = "wet"
        }
        "/wms/quarantine/report/confirmation/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
            problem_type = "wet"
        }
        "/wms/quarantine/report/confirmation/cancel"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
            problem_type = "wet"
        }
        "/wms/quarantine/picking/scan_inventory"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            pickup_id = "1234"
            checkpoint_id = "1234"
        }
        "/wms/quarantine/picking/scan_inventory/cancel"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            pickup_id = "1234"
            checkpoint_id = "1234"
        }
        "/wms/quarantine/picking/select_problem"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            pickup_id = "1234"
            checkpoint_id = "1234"
        }
        "/wms/quarantine/picking/select_problem/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            pickup_id = "1234"
            checkpoint_id = "1234"
            problem_type = "wet"
        }
        "/wms/quarantine/picking/select_problem/other"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            pickup_id = "1234"
            checkpoint_id = "1234"
        }
        "/wms/quarantine/picking/select_problem/other/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            pickup_id = "1234"
            checkpoint_id = "1234"
            description = "Es fraudulento"
        }
        "/wms/quarantine/picking/select_problem/cancel"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            pickup_id = "1234"
            checkpoint_id = "1234"
        }
        "/wms/quarantine/picking/confirmation"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            pickup_id = "1234"
            checkpoint_id = "1234"
            problem_type = "wet"
        }
        "/wms/quarantine/picking/confirmation/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            pickup_id = "1234"
            checkpoint_id = "1234"
            problem_type = "wet"
        }
        "/wms/quarantine/picking/confirmation/cancel"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            pickup_id = "1234"
            checkpoint_id = "1234"
            problem_type = "wet"
        }
        "/wms/quarantine/transfer/scan_inventory"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
        }
        "/wms/quarantine/transfer/scan_address_destination"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
        }
        "/wms/quarantine/transfer/select_problem"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
            address_from_id = "RR-0-001-000-00-00"
        }
        "/wms/quarantine/transfer/select_problem/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA11880"
            address_from_id = "RR-0-001-000-00-00"
            problem_type = "wet"
        }
         "/wms/quarantine/resolve/confirmation"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
        }
        "/wms/quarantine/resolve/confirmation/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
        }
        "/wms/quarantine/resolve/confirmation/cancel"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
        }
        "/wms/quarantine/resolve/scan_address_from"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
        }
        "/wms/quarantine/resolve/item"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
        }
        "/wms/quarantine/resolve/item/not_found"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
        }
        "/wms/quarantine/resolve/confirm_problem"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
        }
        "/wms/quarantine/resolve/confirm_problem/continue"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
            confirmed = true
        }
        "/wms/quarantine/resolve/select_problem"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
        }
        "/wms/quarantine/resolve/select_problem/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
            problem_type = "wet"
        }
        "/wms/quarantine/resolve/select_subtype"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
            problem_type = "other"
        }
        "/wms/quarantine/resolve/select_subtype/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
            problem_type = "other"
            problem_sub_type = "wet"
        }
        "/wms/quarantine/resolve/select_subtype/other"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
            problem_type = "other"
        }
        "/wms/quarantine/resolve/select_subtype/other/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
            problem_type = "other"
            description = "Es fraudulento"
        }
        "/wms/quarantine/resolve/summary"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
            problem_type = "other"
        }
        "/wms/quarantine/resolve/summary/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
            problem_type = "other"
        }
        "/wms/quarantine/resolve/summary/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
            problem_type = "damaged"
            sub_problem_type = "broken"
        }
        "/wms/quarantine/resolve/scan_address_destination"(platform: "/mobile/android") {
            warehouse_id = "BRTW01"
            task_id = 1234
        }

        "/wms/area_count/confirmation"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/area_count/confirmation/start_count"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/area_count/item"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/area_count/item/finish_address"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/area_count/item/finish_count"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/area_count/item/reset_address"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
            navigate_to_home = true
        }
        "/wms/area_count/scan_inventory"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/area_count/scan_inventory/finish_address"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/area_count/scan_inventory/finish_count"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/area_count/scan_shelf"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }

        "/wms/quarantine/transfer/scan_address_from"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/quarantine/transfer/select_problem/other"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
            address_from_id = "CA-0-001-000-00-00"
            inventory_id = "AAAA00001"
        }
        "/wms/quarantine/transfer/select_problem/other/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
            description = "Problem not catalogued"
            inventory_id = "AAAA00001"
            address_from_id = "CA-0-001-000-00-00"
        }

        "/wms/range_count/confirmation"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/range_count/confirmation/start_count"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/range_count/item"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/range_count/item/finish_address"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/range_count/item/finish_count"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/range_count/item/reset_address"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
            navigate_to_home = true
        }
        "/wms/range_count/scan_inventory"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/range_count/scan_inventory/finish_address"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/range_count/scan_inventory/finish_count"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/range_count/scan_shelf"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }

        "/wms/sku_count/confirmation"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/sku_count/confirmation/start_count"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/sku_count/item"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/sku_count/item/finish_address"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/sku_count/item/finish_count"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/sku_count/item/reset_address"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
            navigate_to_home = true
        }
        "/wms/sku_count/scan_inventory"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/range_count/scan_shelf"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/sku_count/scan_inventory/finish_address"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/sku_count/scan_inventory/finish_count"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/sku_count/scan_shelf"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }

        "/wms/stock_audit/confirmation"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/confirmation/cancel"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/confirmation/confirm"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/empty_tasks"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/stock_audit/empty_tasks/retry"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
        }
        "/wms/wall_in/scan_slot"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
            container_address = "CA-0-001-000-00-00"
            inventory_id = "AAAA00001"
        }
        "/wms/wall_in/scan_slot/inventory_does_not_fit"(platform: "/mobile/android") {
            warehouse_id = "BRWT01"
            container_address = "CA-0-001-000-00-00"
            inventory_id = "AAAA00001"
        }
    }
}
