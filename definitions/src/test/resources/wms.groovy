package src.test.resources

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    def trackData = {
        warehouse_id = "BRWT01"
        email = "email@mercadolibre.com.ar"
        first_name = "Some first name"
        last_name = "Some last name"
        error_type = "SERVER"
        feedback_type = "WARNING"
        feedback_message = "Some feedback message"
    }

    def trackDataForAudit = {
        warehouse_id = "BRWT01"
        email = "email@mercadolibre.com.ar"
        first_name = "Some first name"
        last_name = "Some last name"
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
        warehouse_id = "BRWT01"
        email = "email@mercadolibre.com.ar"
        first_name = "Some first name"
        last_name = "Some last name"
        pickup_id = 1
        checkpoint_id = 1
    }

    def trackDataForPickingForItemAndDestination = {
        warehouse_id = "BRWT01"
        email = "email@mercadolibre.com.ar"
        first_name = "Some first name"
        last_name = "Some last name"
        pickup_id = 1
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
        }
        "/wms/receiving"(platform: "/mobile/android") {
            trackData()
        }
        "/wms/put_away"(platform: "/mobile/android") {
            trackData()
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/confirmation"(platform: "/mobile/android") {
            trackData()
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/scan_cart"(platform: "/mobile/android") {
            trackData()
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/scan_inventory"(platform: "/mobile/android") {
            trackData()
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/item"(platform: "/mobile/android") {
            trackData()
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
            inventory_id = "AAAA00001"
            quantity = 123
        }
        "/wms/inbound_audit"(platform: "/mobile/android") {
            trackDataForAudit()
        }
        "/wms/inbound_audit/confirmation"(platform: "/mobile/android") {
            trackDataForAudit()
        }
        "/wms/inbound_audit/scan_shelf"(platform: "/mobile/android") {
            trackDataForAudit()
        }
        "/wms/inbound_audit/item"(platform: "/mobile/android") {
            trackDataForAudit()
        }
        "/wms/inbound_audit/damaged_item"(platform: "/mobile/android") {
            trackDataForAudit()
        }
        "/wms/inbound_audit/count_around"(platform: "/mobile/android") {
            trackDataForAudit()
        }
        "/wms/inbound_audit/congrats"(platform: "/mobile/android") {
            trackDataForAudit()
        }
        "/wms/transfer"(platform: "/mobile/android") {
            trackDataForAudit()
        }
        "/wms/found"(platform: "/mobile/android") {
            trackData()
        }
        "/wms/restock"(platform: "/mobile/android") {
            trackData()
        }
        "/wms/picking"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
        "/wms/picking/confirmation"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
        "/wms/picking/scan_closest_address"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
        "/wms/picking/floor_selection"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
        "/wms/picking/scan_container"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
        "/wms/picking/scan_shelf"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
        "/wms/picking/item"(platform: "/mobile/android") {
            trackDataForPickingForItemAndDestination()
        }
        "/wms/picking/scan_destination"(platform: "/mobile/android") {
            trackDataForPickingForItemAndDestination()
        }
        "/wms/picking/change_floor_confirmation"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
        "/wms/picking/change_floor_scan"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
        "/wms/picking/congrats"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
        "/wms/return"(platform: "/mobile/android") {
            trackData()
        }
        "/wms/cycle_count/confirmation"(platform: "/mobile/android") {
            trackData()
        }
        "/wms/cycle_count/scan_shelf"(platform: "/mobile/android") {
            trackData()
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/scan_inventory"(platform: "/mobile/android") {
            trackData()
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/item"(platform: "/mobile/android") {
            trackData()
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
            inventory_id = "AAAA11111"
            quantity = 1
        }

        //Events
        "/wms/put_away/scan_cart/start_put_away"(platform: "/mobile/android") {
            trackData()
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/scan_inventory/cancel_put_away"(platform: "/mobile/android") {
            trackData()
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/put_away/scan_inventory/end_put_away"(platform: "/mobile/android") {
            trackData()
            put_away_id = "1234"
            check_in_id = "4567"
            cart_address = "CA-0-001-000-00-00"
        }
        "/wms/cycle_count/confirmation/start_cycle_count"(platform: "/mobile/android") {
            trackData()
        }
        "/wms/cycle_count/scan_inventory/finish_address"(platform: "/mobile/android") {
            trackData()
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/scan_inventory/finish_cycle_count"(platform: "/mobile/android") {
            trackData()
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
        }
        "/wms/cycle_count/item/finish_address"(platform: "/mobile/android") {
            trackData()
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
            inventory_id = "AAAA11111"
            quantity = 1
        }
        "/wms/cycle_count/item/reset_address"(platform: "/mobile/android") {
            trackData()
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
            inventory_id = "AAAA11111"
            quantity = 1
        }
        "/wms/cycle_count/item/finish_cycle_count"(platform: "/mobile/android") {
            trackData()
            cycle_count_id = 123
            address_id = "RS-0-001-001-00-00"
            inventory_id = "AAAA11111"
            quantity = 1
        }
        "/wms/picking/confirmation/start_pickup"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
        "/wms/picking/item/item_not_found"(platform: "/mobile/android") {
            trackDataForPickingForItemAndDestination()
        }
        "/wms/picking/item/finish_checkpoint"(platform: "/mobile/android") {
            trackDataForPickingForItemAndDestination()
        }
        "/wms/picking/scan_destination/finish_checkpoint"(platform: "/mobile/android") {
            trackDataForPickingForItemAndDestination()
        }
        "/wms/picking/congrats/finish_pickup"(platform: "/mobile/android") {
            trackDataForPickingDefault()
        }
    }
}
