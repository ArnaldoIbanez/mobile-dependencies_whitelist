package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1194"

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

    "/wms/feedback"(platform: "/mobile/android", type: TrackType.View) {
        context(required: true, type: PropertyType.String, description: "The context in which this feedback was shown.")
        type(required: true,
                type: PropertyType.String,
                values: ["success", "error", "warning", "locked"],
                description: "Type of feedback shown.")
        error_type(required: false, type: PropertyType.String, description: "Optional error type.")
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
    "/wms/login_successful"(platform: "/mobile/android", type: TrackType.Event) {
        serial_number(required: true, type: PropertyType.String, description: "serial number")
        user_nickname(required: true, type: PropertyType.String, description: "user nickname")
    }
    "/wms/logout_successful"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/home"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/transfer"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/found"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/restock"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/return"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/inventory"(platform: "/mobile/android", type: TrackType.View) {}

    /* Receiving tracks */
    "/wms/receiving"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/scan_inbound_shipment"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/scan_destination"(platform: "/mobile/android", type: TrackType.View) {
        inbound_id(required: true, type: PropertyType.Numeric, description: "Inbound id")
        receiving_id(required: true, type: PropertyType.Numeric, description: "Receiving id")
    }
    "/wms/receiving/scan_inbound_shipment/start_receiving"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/receiving/scan_destination/finish_receiving"(platform: "/mobile/android", type: TrackType.Event) {}

    /* new Receiving tracks */
    "/wms/receiving/scan_dock"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/scan_volume"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/scan_pallet"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/scan_inbound_shipment"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/volume_rejection"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/volume_rejection/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/inbound_shipment_rejection"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/inbound_shipment_rejection/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/receiving/inbound_rejection"(platform: "/mobile/android", type: TrackType.Event) {
        inbound_id(required: true, type: PropertyType.Numeric, description: "Inbound id")
        receiving_id(required: true, type: PropertyType.String, description: "Receiving id")
        rejection_reason(required: true, type: PropertyType.String, description: "Rejection reason selected to track")
    }

    "/wms/receiving/receiving_finished"(platform: "/mobile/android", type: TrackType.Event) {
        receiving_id(required: true, type: PropertyType.String, description: "Id of the receiving to track")
    }

    "/wms/receiving/volume_rejection"(platform: "/mobile/android", type: TrackType.Event) {
        receiving_id(required: false, type: PropertyType.String, description: "Id of the receiving to track")
        rejection_reason(required: false, type: PropertyType.String, description: "Rejection reason selected to track")
        volume_label(required: false, type: PropertyType.String, description: "Volume label to track")
    }

    "/wms/receiving/inbound_shipment_rejection"(platform: "/mobile/android", type: TrackType.Event) {
        receiving_id(required: false, type: PropertyType.String, description: "Id of the receiving to track")
        rejection_reason(required: false, type: PropertyType.String, description: "Rejection reason selected to track")
        inbound_id(required: false, type: PropertyType.Numeric, description: "Inbound Shipment id to track")
    }

    /* New Put away tracks */
    "/wms/put_away/scan_origin"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/put_away/scan_product"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/put_away/scan_product_destination"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/put_away/scan_product/cancel"(platform: "/mobile/android", type: TrackType.Event) {
        putaway_id(required: false, type: PropertyType.Numeric, description: "Put away id")
    }
    "/wms/put_away/scan_product/finish"(platform: "/mobile/android", type: TrackType.Event) {
        putaway_id(required: false, type: PropertyType.Numeric, description: "Put away id")
        inventory_id(required: false, type: PropertyType.String, description: "inventory id")
    }

    "/wms/sorter/scan_origin"(platform: "/mobile/android", type: TrackType.View) {}

    "/wms/receiving/device/printer/mobile/reprint"(platform: "/mobile/android", type: TrackType.Event) {
        receiving_id(required: true, type: PropertyType.Numeric, description: "Id of the receiving to track")
        volume_label(required: true, type: PropertyType.String, description: "Volume label to track")
    }


    /* Cycle count tracks */
    "/wms/cycle_count"(platform: "/mobile/android", type: TrackType.View, isAbstract: true) {
        count_id(required: false, type: PropertyType.Numeric, description: "Count id")
        address_id(required: false, type: PropertyType.String, description: "Address id")
    }
    "/wms/cycle_count/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/cycle_count/scan_shelf"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/cycle_count/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/cycle_count/item"(platform: "/mobile/android", type: TrackType.View) {
        inventory_id(required: false, type: PropertyType.String, description: "Inventory id")
        quantity(required: false, type: PropertyType.Numeric, description: "Item quantity")
    }

    "/wms/cycle_count/confirmation/start_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/scan_inventory/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/item/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/scan_inventory/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/scan_inventory/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/item/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/cycle_count/item/reset_address"(platform: "/mobile/android", type: TrackType.Event) {
        navigate_to_home(required: true, type: PropertyType.Boolean, description: "Whether or not the reset event is triggered by the user navigating to the home screen.")
    }

    /* Area count tracks */
    "/wms/area_count"(platform: "/mobile/android", type: TrackType.View, isAbstract: true) {
        count_id(required: false, type: PropertyType.Numeric, description: "Count id")
        address_id(required: false, type: PropertyType.String, description: "Address id")
    }
    "/wms/area_count/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/area_count/scan_shelf"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/area_count/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/area_count/item"(platform: "/mobile/android", type: TrackType.View) {
        inventory_id(required: false, type: PropertyType.String, description: "Inventory id")
        quantity(required: false, type: PropertyType.Numeric, description: "Item quantity")
    }

    "/wms/area_count/confirmation/start_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/area_count/scan_inventory/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/area_count/item/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/area_count/scan_inventory/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/area_count/scan_inventory/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/area_count/item/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/area_count/item/reset_address"(platform: "/mobile/android", type: TrackType.Event) {
        navigate_to_home(required: true, type: PropertyType.Boolean, description: "Whether or not the reset event is triggered by the user navigating to the home screen.")
    }

    /* Range count tracks */
    "/wms/range_count"(platform: "/mobile/android", type: TrackType.View, isAbstract: true) {
        count_id(required: false, type: PropertyType.Numeric, description: "Count id")
        address_id(required: false, type: PropertyType.String, description: "Address id")
    }
    "/wms/range_count/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/range_count/scan_shelf"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/range_count/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/range_count/item"(platform: "/mobile/android", type: TrackType.View) {
        inventory_id(required: false, type: PropertyType.String, description: "Inventory id")
        quantity(required: false, type: PropertyType.Numeric, description: "Item quantity")
    }

    "/wms/range_count/confirmation/start_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/range_count/scan_inventory/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/range_count/item/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/range_count/scan_inventory/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/range_count/scan_inventory/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/range_count/item/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/range_count/item/reset_address"(platform: "/mobile/android", type: TrackType.Event) {
        navigate_to_home(required: true, type: PropertyType.Boolean, description: "Whether or not the reset event is triggered by the user navigating to the home screen.")
    }

    /* SKU count tracks */
    "/wms/sku_count"(platform: "/mobile/android", isAbstract: true) {
        count_id(required: false, type: PropertyType.Numeric, description: "Count id")
        address_id(required: false, type: PropertyType.String, description: "Address id")
    }
    "/wms/sku_count/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/sku_count/scan_shelf"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/sku_count/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/sku_count/item"(platform: "/mobile/android", type: TrackType.View) {
        inventory_id(required: false, type: PropertyType.String, description: "Inventory id")
        quantity(required: false, type: PropertyType.Numeric, description: "Item quantity")
    }

    "/wms/sku_count/confirmation/start_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/sku_count/scan_inventory/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/sku_count/item/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/sku_count/scan_inventory/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/sku_count/scan_inventory/finish_count"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/sku_count/item/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/sku_count/item/reset_address"(platform: "/mobile/android", type: TrackType.Event) {
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

    "/wms/withdrawals_collector/confirmation/start_withdrawal"(platform: "/mobile/android", type: TrackType.Event) {
    }
    "/wms/withdrawals_collector/item/update_checkpoint"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/withdrawals_collector/item/item_not_found"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/withdrawals_collector/item/start_unload_cart"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/withdrawals_collector/congrats/finish_unload_cart"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/withdrawals_collector/congrats/finish_withdrawal"(platform: "/mobile/android", type: TrackType.Event) {
        pickup_id(required: true, type: PropertyType.String, description: "Id of the pickup for the withdrawal flow")
    }

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
    "/wms/problem_solver_inbound_tasks/returns/scan_destination"(platform: "/mobile/android", type: TrackType.View) {
    }
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

    /* Problem Solver - Flan */
    "/wms/problem_solver/scan_inbound_shipment"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/problem_solver/manual_input_inbound_shipment"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/problem_solver/scan_case"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/problem_solver/manual_input_case"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/problem_solver/scan_transaction_destination"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/problem_solver/scan_origin"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/problem_solver/menu"(platform: "/mobile/android", type: TrackType.View) {}

    /* Stock audit*/
    "/wms/stock_audit/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/stock_audit/confirmation/confirm"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/stock_audit/confirmation/cancel"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/stock_audit/scan_address"(platform: "/mobile/android", type: TrackType.View) {
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")
        cross_counting(required: true, type: PropertyType.Boolean, description: "Whether is a cross counting")
    }

    "/wms/stock_audit/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {
        address_id(required: true, type: PropertyType.String, description: "Address id")
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")
        cross_counting(required: true, type: PropertyType.Boolean, description: "Whether is a cross counting")
    }

    "/wms/stock_audit/scan_inventory/empty_address"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/stock_audit/scan_address/empty_address"(platform: "/mobile/android", type: TrackType.Event) {
        address_id(required: true, type: PropertyType.String, description: "Address id")
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")
        cross_counting(required: true, type: PropertyType.Boolean, description: "Whether is a cross counting")
    }

    "/wms/stock_audit/item"(platform: "/mobile/android", type: TrackType.View) {
        address_id(required: true, type: PropertyType.String, description: "Address id")
        inventory_id(required: false, type: PropertyType.String, description: "Inventory id")
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")
        cross_counting(required: false, type: PropertyType.Boolean, description: "Whether is a cross counting")
    }
    "/wms/stock_audit/item/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/stock_audit/item/restart_task"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/stock_audit/cross_counting/confirmation"(platform: "/mobile/android", type: TrackType.View) {
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")
        address_id(required: true, type: PropertyType.String, description: "Address id")
    }
    "/wms/stock_audit/cross_counting/confirmation/confirm"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/stock_audit/cross_counting/confirmation/skip"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/stock_audit/empty_tasks"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/stock_audit/empty_tasks/retry"(platform: "/mobile/android", type: TrackType.Event) {}


    /* Wall in */
    "/wms/wall_in"(platform: "/mobile/android", isAbstract: true) {}

    "/wms/wall_in/scan_container"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/wall_in/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {
        container_address(required: true, type: PropertyType.String, description: "Wall in container address.")
    }
    "/wms/wall_in/scan_inventory/finish_task"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/wall_in/scan_slot"(platform: "/mobile/android", type: TrackType.View) {
        container_address(required: true, type: PropertyType.String, description: "Wall in container address.")
        inventory_id(required: true, type: PropertyType.String, description: "Inventory id currently being processed.")
    }
    "/wms/wall_in/scan_slot/inventory_does_not_fit"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/wall_in/to_restock"(platform: "/mobile/android", type: TrackType.View) {
        container_address(required: true, type: PropertyType.String, description: "Wall in container address.")
        inventory_id(required: true, type: PropertyType.String, description: "Inventory id currently being processed.")
    }
    "/wms/wall_in/to_restock/confirm"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/wall_in/to_found"(platform: "/mobile/android", type: TrackType.View) {
        container_address(required: true, type: PropertyType.String, description: "Wall in container address.")
        inventory_id(required: true, type: PropertyType.String, description: "Inventory id currently being processed.")
    }
    "/wms/wall_in/to_found/confirm"(platform: "/mobile/android", type: TrackType.Event) {}


    /* Wall out */
    "/wms/wall_out"(platform: "/mobile/android", isAbstract: true) {}

    "/wms/wall_out/scan_section"(platform: "/mobile/android", type: TrackType.View) {}

    "/wms/wall_out/scan_slot"(platform: "/mobile/android", type: TrackType.View) {
        section_address(required: true, type: PropertyType.String, description: "Wall out section address.")
    }

    "/wms/wall_out/scan_box"(platform: "/mobile/android", type: TrackType.View) {
        slot_address(required: true, type: PropertyType.String, description: "Slot currently being processed.")
    }

    "/wms/wall_out/to_packing"(platform: "/mobile/android", type: TrackType.View) {
        slot_address(required: true, type: PropertyType.String, description: "Slot currently being processed.")
        box_address(required: true, type: PropertyType.String, description: "Box in use for processing current order.")
    }
    "/wms/wall_out/to_packing/confirm"(platform: "/mobile/android", type: TrackType.Event) {}

    "/wms/wall_out/empty_wall"(platform: "/mobile/android", type: TrackType.View) {
        section_address(required: true, type: PropertyType.String, description: "Wall out section address.")
    }
    "/wms/wall_out/empty_wall/retry"(platform: "/mobile/android", type: TrackType.Event) {}

    /* Quarantine */
    "/wms/quarantine"(platform: "/mobile/android", isAbstract: true) {}

    /* Report */
    "/wms/quarantine/report"(platform: "/mobile/android", isAbstract: true) {}

    "/wms/quarantine/report/scan_address_from"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/quarantine/report/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {
        address_from_id(required: true, type: PropertyType.String, description: "Address id")
    }
    "/wms/quarantine/report/scan_inventory/cancel"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/report/select_problem"(platform: "/mobile/android", type: TrackType.View) {
        address_from_id(required: true, type: PropertyType.String, description: "Address id")
        inventory_id(required: true, type: PropertyType.String, description: "Inventory id")
    }
    "/wms/quarantine/report/select_problem/confirm"(platform: "/mobile/android", type: TrackType.Event) {
        problem_type(required: true, type: PropertyType.String, description: "Problem type")
    }
    "/wms/quarantine/report/select_problem/cancel"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/report/select_problem/other"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/quarantine/report/select_problem/other/confirm"(platform: "/mobile/android", type: TrackType.Event) {
        description(required: true, type: PropertyType.String, description: "Manual input problem type description")
    }
    "/wms/quarantine/report/confirmation"(platform: "/mobile/android", type: TrackType.View) {
        address_from_id(required: true, type: PropertyType.String, description: "Address id")
        inventory_id(required: true, type: PropertyType.String, description: "Inventory id")
        problem_type(required: true, type: PropertyType.String, description: "Problem type")
    }
    "/wms/quarantine/report/confirmation/confirm"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/report/confirmation/cancel"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/report/scan_inventory/finish_address"(platform: "/mobile/android", type: TrackType.Event) {}

    /* Picking */
    "/wms/quarantine/picking"(platform: "/mobile/android", isAbstract: true) {
        pickup_id(required: true, type: PropertyType.String, description: "Pickup id")
        checkpoint_id(required: true, type: PropertyType.String, description: "Checkpoint id")
    }

    "/wms/quarantine/picking/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/quarantine/picking/scan_inventory/cancel"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/picking/select_problem"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/quarantine/picking/select_problem/confirm"(platform: "/mobile/android", type: TrackType.Event) {
        problem_type(required: true, type: PropertyType.String, description: "Problem type")
    }
    "/wms/quarantine/picking/select_problem/cancel"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/picking/select_problem/other"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/quarantine/picking/select_problem/other/confirm"(platform: "/mobile/android", type: TrackType.Event) {
        description(required: true, type: PropertyType.String, description: "Manual input problem type description")
    }
    "/wms/quarantine/picking/confirmation"(platform: "/mobile/android", type: TrackType.View) {
        problem_type(required: true, type: PropertyType.String, description: "Problem type")
    }
    "/wms/quarantine/picking/confirmation/confirm"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/picking/confirmation/cancel"(platform: "/mobile/android", type: TrackType.Event) {}

    /* Transfer */
    "/wms/quarantine/transfer"(platform: "/mobile/android", isAbstract: true) {}

    "/wms/quarantine/transfer/scan_address_from"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/quarantine/transfer/scan_inventory"(platform: "/mobile/android", type: TrackType.View) {
        address_from_id(required: true, type: PropertyType.String, description: "Address id")
    }
    "/wms/quarantine/transfer/scan_address_destination"(platform: "/mobile/android", type: TrackType.View) {
        address_from_id(required: true, type: PropertyType.String, description: "Address from id")
        inventory_id(required: true, type: PropertyType.String, description: "Inventory id")
    }
    "/wms/quarantine/transfer/select_problem"(platform: "/mobile/android", type: TrackType.View) {
        address_from_id(required: true, type: PropertyType.String, description: "Address from id")
        inventory_id(required: true, type: PropertyType.String, description: "Inventory id")
    }
    "/wms/quarantine/transfer/select_problem/confirm"(platform: "/mobile/android", type: TrackType.Event) {
        problem_type(required: true, type: PropertyType.String, description: "Problem type")
    }
    "/wms/quarantine/transfer/select_problem/other"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/quarantine/transfer/select_problem/other/confirm"(platform: "/mobile/android", type: TrackType.Event) {
        description(required: true, type: PropertyType.String, description: "Manual input problem type description")
    }

    /* Resolve */
    "/wms/quarantine/resolve"(platform: "/mobile/android", isAbstract: true) {}

    "/wms/quarantine/resolve/confirmation"(platform: "/mobile/android", type: TrackType.View) {}
    "/wms/quarantine/resolve/confirmation/confirm"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/resolve/confirmation/cancel"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/resolve/scan_address_from"(platform: "/mobile/android", type: TrackType.View) {
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")

    }
    "/wms/quarantine/resolve/item"(platform: "/mobile/android", type: TrackType.View) {
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")

    }
    "/wms/quarantine/resolve/item/not_found"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/resolve/confirm_problem"(platform: "/mobile/android", type: TrackType.View) {
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")

    }
    "/wms/quarantine/resolve/confirm_problem/continue"(platform: "/mobile/android", type: TrackType.Event) {
        confirmed(required: true, type: PropertyType.Boolean, description: "Whether problem is confirmed or not")
    }
    "/wms/quarantine/resolve/select_problem"(platform: "/mobile/android", type: TrackType.View) {
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")
    }
    "/wms/quarantine/resolve/select_problem/confirm"(platform: "/mobile/android", type: TrackType.Event) {
        problem_type(required: true, type: PropertyType.String, description: "Problem type")
    }
    "/wms/quarantine/resolve/select_subtype"(platform: "/mobile/android", type: TrackType.View) {
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")
        problem_type(required: true, type: PropertyType.String, description: "Problem type")
    }
    "/wms/quarantine/resolve/select_subtype/confirm"(platform: "/mobile/android", type: TrackType.Event) {
        problem_sub_type(required: false, type: PropertyType.String, description: "Problem type")
    }
    "/wms/quarantine/resolve/select_subtype/other"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/resolve/select_subtype/other/confirm"(platform: "/mobile/android", type: TrackType.Event) {
        description(required: true, type: PropertyType.String, description: "Manual input problem type description")
    }
    "/wms/quarantine/resolve/summary"(platform: "/mobile/android", type: TrackType.View) {
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")
        problem_type(required: false, type: PropertyType.String, description: "Problem type")
        sub_problem_type(required: false, type: PropertyType.String, description: "Sub Problem type")
    }
    "/wms/quarantine/resolve/summary/confirm"(platform: "/mobile/android", type: TrackType.Event) {}
    "/wms/quarantine/resolve/scan_address_destination"(platform: "/mobile/android", type: TrackType.View) {
        task_id(required: true, type: PropertyType.Numeric, description: "Task id")
    }
}
