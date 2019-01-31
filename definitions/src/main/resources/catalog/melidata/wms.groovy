import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/wms"(platform: "/mobile/android", type: TrackType.View, isAbstract: true) {
        warehouse_id(required: true, type: PropertyType.String,
        	description: "Id of the warehouse to track")
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

    "/wms/scan"(platform: "/mobile/android", type: TrackType.Event) {
        input_data(required: true, type: PropertyType.String, description: "The data received from the scanner.")
        context(required: true, type: PropertyType.String, description: "The context in which the scan was made.")
        source(required: true,
                type: PropertyType.String,
                values: ["scanner", "manual_input"],
                description: "The source of the input data, can be scanner or manual_input")
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
    "/wms/put_away/scan_inventory/post_item"(platform: "/mobile/android", type: TrackType.Event) {
        is_retry(required: true, type: PropertyType.Boolean, description: "If the request is a retry or not")
        idempotency_key(required: true, type: PropertyType.String, description: "Idempotency key of request")
    }
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
    "/wms/inbound_audit/item/damaged_item"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/inbound_audit/count_around"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/inbound_audit/congrats"(platform: "/mobile/android", type: TrackType.View) {}

    "/wms/inbound_audit/confirmation/start_audit"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/item/reset_audit"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/item/finish_checkpoint"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/item/item_not_found"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/item/damaged_item_confirmation"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/count_around/start_count_around"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/inbound_audit/count_around/skip_count_around"(platform: "/mobile/android", type: TrackType.Event) {}

    /* Picking tracks */
    "/wms/picking"(platform: "/mobile/android", type: TrackType.View) {
        pickup_id(required: true, type: PropertyType.String, description: "Id of the Pickup")
        checkpoint_id(required: false, type: PropertyType.String, description: "Id of the Checkpoint")
    }
    "/wms/picking/confirmation"(platform: "/mobile/android", type: TrackType.View) {
        pickup_id(required: false, type: PropertyType.String, description: "Id of the Pickup")
    }
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
    "/wms/picking/confirmation/scan_closest_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/picking/confirmation/floor_selection"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/picking/item/item_not_found"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/picking/item/finish_checkpoint"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/picking/scan_destination/finish_checkpoint"(platform: "/mobile/android", type: TrackType.Event) {}
	"/wms/picking/congrats/finish_pickup"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/login"(platform: "/mobile/android", type: TrackType.View) {
        warehouse_id(required: false, type: PropertyType.String,
            description: "Id of the warehouse to track")
    }
    "/wms/login"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/logout"(platform: "mobile/android", type: TrackType.Event) {}
	
    "/wms/home"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/transfer"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/found"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/restock"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/return"(platform: "/mobile/android", type: TrackType.View) {}

    /* Receiving tracks */
    "/wms/receiving"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/scan_inbound_shipment"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/scan_destination"(platform: "/mobile/android", type: TrackType.View) {
        inbound_id(required: true, type: PropertyType.String, description: "Inbound id")
        receiving_id(required: true, type: PropertyType.String, description: "Receiving id")
    } 
    "/wms/receiving/scan_destination/start_receiving"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/receiving/scan_destination/finish_receiving"(platform: "/mobile/android", type: TrackType.Event) {}
	
    /* Cycle count tracks */
    "/wms/cycle_count"(platform: "/mobile/android", type: TrackType.View, isAbstract: true) {
        cycle_count_id(required: false, type: PropertyType.Numeric, description: "Cycle count id")
        address_id(required: false, type: PropertyType.String, description: "Address id")
    }
    "/wms/cycle_count/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/cycle_count/scan_shelf"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/cycle_count/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/cycle_count/item"(platform: "/mobile/android", type: TrackType.View) {
        inventory_id(required: false, type: PropertyType.String, description: "Inventory id")
        quantity(required: false, type: PropertyType.Numeric, description: "Item quantity")
    }

    "/wms/cycle_count/confirmation/start_cycle_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/scan_inventory/finish_cycle_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/item/finish_cycle_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/scan_inventory/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/scan_inventory/finish_cycle_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/item/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/item/reset_address"(platform: "/mobile/android", type: TrackType.Event) {
        navigate_to_home(required: true, type: PropertyType.Boolean, description: "Whether or not the reset event is triggered by the user navigating to the home screen.")
    }

    /* Withdrawals Removal tracks */
    "/wms/withdrawals_removal"(platform: "/mobile/android", type: TrackType.View) {
        removal_id(required: true, type: PropertyType.String, description: "Removal id")
    }
    "/wms/withdrawals_removal/authorization"(platform: "/mobile/android", type: TrackType.View) {
        removal_id(required: false, type: PropertyType.String, description: "Removal id")
    }
    "/wms/withdrawals_removal/scan_shelf"(platform: "/mobile/android", type: TrackType.View) {
        address_id(required: true, type: PropertyType.String, description: "Address id")
    }
    "/wms/withdrawals_removal/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/withdrawals_removal/authorization/start_removal"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/withdrawals_removal/confirmation/finish_removal"(platform: "/mobile/android", type: TrackType.Event) {}

    /* Withdrawals Collector tracks */
    "/wms/withdrawals_collector"(platform: "/mobile/android", type: TrackType.View) {
        pickup_id(required: true, type: PropertyType.String, description: "Id of the pickup for the withdrawal flow")
    }
    "/wms/withdrawals_collector/confirmation"(platform: "/mobile/android", type: TrackType.View) {
        pickup_id(required: false, type: PropertyType.String, description: "Id of the pickup for the withdrawal flow")
    }
    "/wms/withdrawals_collector/scan_container"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/withdrawals_collector/scan_shelf"(platform: "/mobile/android", type: TrackType.View) {
        pickup_address(required: false, type: PropertyType.String, description: "Address where items are being picked up.")
    }
    "/wms/withdrawals_collector/scan_shelf/start_unload_cart"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/withdrawals_collector/item"(platform: "/mobile/android", type: TrackType.View) {
        inventory_id(required: true, type: PropertyType.String, description: "Id of the item")
        checkpoint_id(required: false, type: PropertyType.String, description: "Id of checkpoint for the pickup")
    }
    "/wms/withdrawals_collector/scan_destination"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/withdrawals_collector/congrats"(platform: "/mobile/android", type: TrackType.View) {}

    "/wms/withdrawals_collector/confirmation/start_withdrawal"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/withdrawals_collector/item/update_checkpoint"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/withdrawals_collector/item/item_not_found"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/withdrawals_collector/item/start_unload_cart"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/withdrawals_collector/congrats/finish_unload_cart"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/withdrawals_collector/congrats/finish_withdrawal"(platform: "/mobile/android", type: TrackType.Event) {}

    /* Inbound Problem solver tracks */
    "/wms/problem_solver_inbound_tasks"(platform: "/mobile/android", type: TrackType.View) {}

    /* Take sub flow */
    "/wms/problem_solver_inbound_tasks/take"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/problem_solver_inbound_tasks/take/scan_inbound_shipment"(platform: "/mobile/android", type: TrackType.View) {
    }
    "/wms/problem_solver_inbound_tasks/take/scan_destination"(platform: "/mobile/android", type: TrackType.View) {
        inbound_id(required: true, type: PropertyType.String, description: "Inbound id")
        destination_address(required: false, type: PropertyType.String, 
            description: "Address to put the items. Is sent after the scan action")
    }

    /* Returns sub flow */
    "/wms/problem_solver_inbound_tasks/returns"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/problem_solver_inbound_tasks/returns/scan_destination"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/problem_solver_inbound_tasks/returns/scan_inbound_shipment"(platform: "/mobile/android", type: TrackType.View) {
        destination_address(required: false, type: PropertyType.String, 
            description: "Address to put the items. Is sent after the scan action")
    }
    "/wms/problem_solver_inbound_tasks/returns/single_selection"(platform: "/mobile/android", type: TrackType.View) {
        inbound_id(required: true, type: PropertyType.String, description: "Inbound id")
        destination_address(required: false, type: PropertyType.String, 
            description: "Address to put the items. Is sent after the scan action")
    }

    "/wms/problem_solver_inbound_tasks/returns/single_selection/confirmation"(platform: "/mobile/android", type: TrackType.Event) {
        inbound_id(required: true, type: PropertyType.String, description: "Inbound id")
        destination_address(required: false, type: PropertyType.String, 
            description: "Address to put the items. Is sent after the scan action")
        return_type(required: false, type: PropertyType.String, 
            description: "Return type selected by the user")
    }

    "/wms/problem_solver_inbound_tasks/returns/scan_stage_in_destination"(platform: "/mobile/android", type: TrackType.View) {
        inbound_id(required: true, type: PropertyType.String, description: "Inbound id")
        destination_address(required: false, type: PropertyType.String, 
            description: "Address to put the items. Is sent after the scan action")
        return_type(required: false, type: PropertyType.String, 
            description: "Return type selected by the user")
    }


}
