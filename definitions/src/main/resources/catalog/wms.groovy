import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/wms"(platform: "/mobile/android", type: TrackType.View, isAbstract: true) {
        warehouse_id(required: false, type: PropertyType.String,
        	description: "Id of the warehouse to track")
        email(required: false, type: PropertyType.String)
        first_name(required: false, type: PropertyType.String)
        last_name(required: false, type: PropertyType.String)
        error_type(
        	required: false,
        	values: ["SERVER", "NETWORK", "ZRP", "TIMEOUT"],
        	type: PropertyType.String,
            description: "Type of error event")
        feedback_type(
        	required: false,
        	values: ["SUCCESS", "ERROR", "WARNING", "LOCKED"],
        	type: PropertyType.String,
            description: "Type of feedback event")
        feedback_message(
            required: false,
            type: PropertyType.String,
            description: "Message of feedback screen.")
    }

    /* Put away tracks */
	"/wms/put_away"(platform: "/mobile/android", type: TrackType.View) {
		put_away_id(required: false, type: PropertyType.String, description: "Put away id")
		check_in_id(required: false, type: PropertyType.String, description: "Check in id")
		cart_address(required: false, type: PropertyType.String, description: "Cart used for put away")
	}
	"/wms/put_away/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/put_away/scan_cart"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/put_away/scan_cart/start_put_away"(platform: "/mobile/android", type: TrackType.Event) {}
	"/wms/put_away/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/put_away/scan_inventory/end_put_away"(platform: "/mobile/android", type: TrackType.Event) {}
	"/wms/put_away/scan_inventory/cancel_put_away"(platform: "/mobile/android", type: TrackType.Event) {}
	"/wms/put_away/item"(platform: "/mobile/android", type: TrackType.View) {
		inventory_id(required: true, type: PropertyType.String, description: "Inventory id")
		quantity(required: true, type: PropertyType.Numeric, description: "Quantity")
	}

    /* Inbound Audit tracks */
    "/wms/inbound_audit"(platform: "/mobile/android", type: TrackType.View) {
        audit_id(required: false, type: PropertyType.Numeric, description: "Audit id")
        inbound_id(required: false, type: PropertyType.Numeric, description: "Inbound id")
        inventory_id(required: false, type: PropertyType.String, description: "Inventory id")
        address_id(required: false, type: PropertyType.String, description: "Address id")
        damaged_quantity(required: false, type: PropertyType.Numeric, description: "Damaged quantity")
        quantity(required: false, type: PropertyType.Numeric, description: "Item quantity")
        from_count_around(required: false, 
            type: PropertyType.String, 
            values: ["true", "false"], 
            description: "From count around")
    }
    "/wms/inbound_audit/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/inbound_audit/scan_shelf"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/inbound_audit/item"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/inbound_audit/damaged_item"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/inbound_audit/count_around"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/inbound_audit/congrats"(platform: "/mobile/android", type: TrackType.View) {}

    "/wms/inbound_audit/start_audit"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/reset_audit"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/finish_checkpoint"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/item_not_found"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/damaged_item_confirmation"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/start_count_around"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/skip_count_around"(platform: "/mobile/android", type: TrackType.Event) {}

    /* Picking tracks */
    "/wms/picking"(platform: "/mobile/android", type: TrackType.View) {
        pickup_id(required: false, type: PropertyType.String, description: "Id of the Pickup")
        checkpoint_id(required: false, type: PropertyType.String, description: "Id of the Checkpoint")
    }
    "/wms/picking/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/picking/scan_closest_address"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/picking/floor_selection"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/picking/scan_container"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/picking/scan_shelf"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/picking/item"(platform: "/mobile/android", type: TrackType.View) {
        inventory_id(required: false, type: PropertyType.String, 
            description: "Id of the picked up item")
        destination_address(required: false, type: PropertyType.String, 
            description: "Address to where the item is picked up")
        checkpoint_status(required: false, type: PropertyType.String, 
            description: "Status of the current checkpoint")
    }
    "/wms/picking/scan_destination"(platform: "/mobile/android", type: TrackType.View) {
        inventory_id(required: false, type: PropertyType.String, 
            description: "Id of the picked up item")
        destination_address(required: false, type: PropertyType.String, 
            description: "Address to where the item is picked up")
        checkpoint_status(required: false, type: PropertyType.String, 
            description: "Status of the current checkpoint")
    }
    "/wms/picking/change_floor_confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/picking/change_floor_scan"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/picking/congrats"(platform: "/mobile/android", type: TrackType.View) {}

    "/wms/picking/confirmation/start_pickup"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/picking/item/item_not_found"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/picking/item/finish_checkpoint"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/picking/scan_destination/finish_checkpoint"(platform: "/mobile/android", type: TrackType.Event) {}
	"/wms/picking/congrats/finish_pickup"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/login"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/home"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/transfer"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/found"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/restock"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/return"(platform: "/mobile/android", type: TrackType.View) {}

    /* Cycle count tracks */
    "/wms/cycle_count"(platform: "/mobile/android", type: TrackType.View, isAbstract: true) {
        cycle_count_id(required: false, type: PropertyType.Numeric, description: "Cycle count id")
        address_id(required: false, type: PropertyType.String, description: "Address id")
    }
    "/wms/cycle_count/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/cycle_count/scan_shelf"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/cycle_count/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/cycle_count/item"(platform: "/mobile/android", type: TrackType.View) {
        inventory_id(required: true, type: PropertyType.String, description: "Inventory id")
        quantity(required: true, type: PropertyType.Numeric, description: "Item quantity")
    }

    "/wms/cycle_count/confirmation/start_cycle_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/scan_inventory/finish_cycle_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/item/finish_cycle_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/scan_inventory/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/item/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/item/reset_address"(platform: "/mobile/android", type: TrackType.Event) {}
}