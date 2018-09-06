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
            trackData()
        }
        "/wms/return"(platform: "/mobile/android") {
            trackData()
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
    }
}
