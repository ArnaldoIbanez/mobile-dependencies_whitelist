import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks


tracks {

    /**
    * INSTORES Screen Tracks
    */

    "/instore"(platform: "/mobile", isAbstract: true) {
        session_id(required: false, PropertyType.String, description: "a unique identifier to track the users flow through the app since they enters the view until they exist")
        new_session(required: false, PropertyType.Boolean, description: "indicates if a new session_id was created")
    }

    // Scan QR
    "/instore/scan_qr"(platform: "/mobile", type: TrackType.View) {
        camera_permissions(required: false, PropertyType.Boolean)
        location_permissions(required: false, PropertyType.Boolean)
        notification_permissions(required: false, PropertyType.Boolean)
        // Deprecated. Typo on Android
        notifications_permissions(required: false, PropertyType.Boolean)
        bluetooth_permissions(required: false, PropertyType.Boolean)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/scan_qr/qr_discovery"(platform: "/mobile", type: TrackType.Event) {
        qr_discovery_time_in_millis(required: false, PropertyType.String)
        camera_flash(required: false, PropertyType.Boolean)
    }
    "/instore/scan_qr/qr_resolved"(platform: "/mobile", type: TrackType.Event) {
        qr_data(required: false, PropertyType.String)
        qr_discovery_time_in_millis(required: false, PropertyType.String)
        qr_server_time_in_millis(required: false, PropertyType.String)
        camera_flash(required: false, PropertyType.Boolean)
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        success(required: false, PropertyType.Boolean)
        next_step_deeplink(required: false, PropertyType.String)
        currency(required: false, PropertyType.String)
    }
    "/instore/scan_qr/flash"(platform: "/mobile", type: TrackType.Event) {
        camera_flash(required: false, PropertyType.Boolean)
    }
    "/instore/scan_qr/abort"(platform: "/mobile", type: TrackType.Event) {
        view_time_in_millis(required: false, PropertyType.String)
        camera_flash(required: false, PropertyType.Boolean)
    }
    "/instore/scan_qr/help"(platform: "/mobile", type: TrackType.Event) {
    }
	"/instore/scan_qr/back"(platform: "/mobile", type: TrackType.Event) {
        view_time_in_millis(required: false, PropertyType.String)
        camera_flash(required: false, PropertyType.Boolean)
    }

    // Amount
    "/instore/amount"(platform: "/mobile", isAbstract: true) {}
    "/instore/amount/calculator"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/amount/calculator/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/amount/price_list"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        available_prices(required: false, PropertyType.String)
        available_prices(required: false, PropertyType.ArrayList)
        visible_prices(required: false, PropertyType.Numeric)
    }
    "/instore/amount/price_list/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }

    // Generic Error
    "/instore/error"(platform: "/mobile", isAbstract: true) {}
    "/instore/error/unrecognized_qr_code"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/unrecognized_qr_code"(platform: "/mobile", isAbstract: true) {}
    "/instore/error/unrecognized_qr_code/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/unrecognized_qr_code/abort"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/something_went_wrong"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/something_went_wrong"(platform: "/mobile", isAbstract: true) {}
    "/instore/error/something_went_wrong/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/something_went_wrong/abort"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/something_went_wrong/retry"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/gas_station_cant_process_qr_payment"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/gas_station_cant_process_qr_payment"(platform: "/mobile", isAbstract: true) {}
    "/instore/error/gas_station_cant_process_qr_payment/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/gas_station_cant_process_qr_payment/abort"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/cant_pay_to_yourself"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/cant_pay_to_yourself"(platform: "/mobile", isAbstract: true) {}
    "/instore/error/cant_pay_to_yourself/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/cant_pay_to_yourself/abort"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/cant_pay_to_yourself/retry"(platform: "/mobile", type: TrackType.Event) {
        qr_data(required: true, PropertyType.String)
        collector_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/error/payment_timeout"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/payment_timeout"(platform: "/mobile", isAbstract: true) {}
    "/instore/error/payment_timeout/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/payment_timeout/abort"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/error/cant_pay_in_different_sites"(platform: "/mobile", type: TrackType.View) {
        qr_data(required: false, PropertyType.String, description: "data scanned on the payment flow")
        collector_id(required: false, PropertyType.String, description: "collector user unique identifier")
        store_id(required: false, PropertyType.String, description: "collector store unique identifier")
        pos_id(required: false, PropertyType.String, description: "collector point of sale unique identifier")
    }
    "/instore/error/cant_pay_in_different_sites/back"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/error/cant_pay_in_different_sites/abort"(platform: "/mobile", type: TrackType.Event) {}

    // Permissions
    "/ask_device_permission"(platform: "/mobile", isAbstract: true) {
        session_id(required: false, PropertyType.String, description: "a unique identifier to track the users flow through the app since they enters the view until they exist")
        new_session(required: false, PropertyType.Boolean, description: "indicates if a new session_id was created")
    }
    "/ask_device_permission/location"(platform: "/mobile", type: TrackType.View) {
        context(required: true, PropertyType.String, values: ["/instore", "/instore/map"])
        location_permission_enabled(required: false, PropertyType.Boolean)
        device_gps_enabled(required: false, PropertyType.Boolean)
        type(required: false, PropertyType.String, description: "type of app launching the map")
        tags(required: false, PropertyType.ArrayList(PropertyType.String), description: "an array of strings used to know the type of stores to show on the map")
    }
    "/ask_device_permission/location/back"(platform: "/mobile", type: TrackType.Event) {
    }
    "/ask_device_permission/location/granted"(platform: "/mobile", type: TrackType.Event) {
    }
    "/ask_device_permission/location/rejected"(platform: "/mobile", type: TrackType.Event) {
    }
    "/ask_device_permission/bluetooth"(platform: "/mobile", type: TrackType.View) {
        context(required: true, PropertyType.String)
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/ask_device_permission/bluetooth"(platform: "/mobile", isAbstract: true) {}
    "/ask_device_permission/bluetooth/back"(platform: "/mobile", type: TrackType.Event) {
        context(required: true, PropertyType.String)
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/ask_device_permission/bluetooth/granted"(platform: "/mobile", type: TrackType.Event) {
        context(required: true, PropertyType.String)
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/ask_device_permission/bluetooth/rejected"(platform: "/mobile", type: TrackType.Event) {
        context(required: true, PropertyType.String)
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/ask_device_permission/camera"(platform: "/mobile", type: TrackType.View) {
        context(required: true, PropertyType.String)
    }
    "/ask_device_permission/camera/"(platform: "/mobile", isAbstract: true) {}
    "/ask_device_permission/camera/back"(platform: "/mobile", type: TrackType.Event) {
        context(required: true, PropertyType.String)
    }
    "/ask_device_permission/camera/granted"(platform: "/mobile", type: TrackType.Event) {
        context(required: true, PropertyType.String)
    }
    "/ask_device_permission/camera/rejected"(platform: "/mobile", type: TrackType.Event) {
        context(required: true, PropertyType.String)
    }

    // FTU
    "/instore/qr_first_time_use"(platform: "/mobile", type: TrackType.View) {}
    "/instore/qr_first_time_use"(platform: "/mobile", isAbstract: true) {}
    "/instore/qr_first_time_use/next"(platform: "/mobile", type: TrackType.Event) {
        view_time_in_millis(required: false, PropertyType.String)
    }
    "/instore/qr_first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {
        view_time_in_millis(required: false, PropertyType.String)
    }
    "/instore/shell_first_time_use"(platform: "/mobile", type: TrackType.View) {}
    "/instore/shell_first_time_use"(platform: "/mobile", isAbstract: true) {}
    "/instore/shell_first_time_use/next"(platform: "/mobile", type: TrackType.Event) {
        view_time_in_millis(required: false, PropertyType.String)
    }
    "/instore/shell_first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/shell_first_time_use/back"(platform: "/mobile", type: TrackType.Event) {}

    "/instore/qr_first_time_use/back"(platform: "/mobile", type: TrackType.Event) {
        view_time_in_millis(required: false, PropertyType.String)
    }

    // Waiting
    "/instore/waiting"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting/gas_jockey"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gas_jockey"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting/gas_jockey/next"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gas_jockey/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gas_pump"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gas_pump"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting/gas_pump/next"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gas_pump/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gas_clock"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gas_clock"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting/gas_clock/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gastronomy_cashier"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gastronomy_cashier"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting/gastronomy_cashier/next"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gastronomy_cashier/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gastronomy_order"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/gastronomy_order"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting/gastronomy_order/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/generic_cashier"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/generic_cashier"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting/generic_cashier/next"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/generic_cashier/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/generic_ticket"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/waiting/generic_ticket"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting/generic_ticket/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }

    // Shell
    "/instore/shell"(platform: "/mobile", isAbstract: true) {}
    "/instore/shell/pump_code"(platform: "/mobile", type: TrackType.View) {}
    "/instore/shell/pump_code_check"(platform: "/mobile", type: TrackType.Event) {
        pump_code(required: false, PropertyType.String)
        latitude(required: false, PropertyType.String)
        longitude(required: false, PropertyType.String)
    }
    "/instore/shell/pump_code_resolved"(platform: "/mobile", type: TrackType.Event) {
        pump_code(required: false, PropertyType.String)
        success(required: true, PropertyType.Boolean)
        next_step(required: true, PropertyType.String)
    }
    "/instore/shell/pump_code/abort"(platform: "/mobile", type: TrackType.Event) {}

    // Required action
    "/instore/data_required"(platform: "/mobile", isAbstract: true) {}
    "/instore/data_required/identification_number"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        data_key(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }
    "/instore/data_required/identification_number/back"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        data_key(required: false, PropertyType.String)
        qr_data(required: false, PropertyType.String)
    }

    // Vending
    "/instore/waiting"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting/vending_product_selection"(platform: "/mobile", type: TrackType.View) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/vending"(platform: "/mobile", isAbstract: true) {
        collector_id(required: true, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        vending_id(required: true, PropertyType.String)
        external_reference(required: true, PropertyType.String)
        id(required: true, PropertyType.Numeric)
        status(required: true, PropertyType.String)
        status_detail(required: true, PropertyType.String)
    }
    "/instore/vending/st_machine_disconnected"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/vending/machine_response_final_result"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/vending/st_machine_connection_error"(platform: "/mobile", type: TrackType.Event) {
        st_machine_connection_error(required: true, PropertyType.String)
    }
    "/instore/vending/machine_response_state"(platform: "/mobile", type: TrackType.Event) {
        machine_response_state(required: true, PropertyType.String)
    }
    "/instore/vending/st_machine_not_available"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/vending/st_machine_connected"(platform: "/mobile", type: TrackType.Event) {}
    "/instore/vending/response_end_transaction"(platform: "/mobile", type: TrackType.Event) {
        end_transaction_status(required: true, PropertyType.String)
        item_price(required: false, PropertyType.Numeric)
    }
    "/instore/post_payment"(platform: "/mobile", type: TrackType.Event) {
        // Possible fields for Android & IOS
        currency_id(required: false, PropertyType.String)
        statement_descriptor(required: false, PropertyType.String)
        collector_id(required: false, PropertyType.String)
        status(required: false, PropertyType.String)
        payment_method_id(required: false, PropertyType.String)
        site_id(required: false, PropertyType.String)
        date_created(required: false, PropertyType.String)
        status_detail(required: false, PropertyType.String)
        operation_type(required: false, PropertyType.String)
        installments(required: false, PropertyType.Numeric)
        id(required: false, PropertyType.Numeric)
        payer_id(required: false, PropertyType.Numeric)
        collector(required: false, description: "collector information")
        issuer_id(required: false, PropertyType.Numeric)
        payer(required: false, description: "payer information")
        transaction_amount(required: false, PropertyType.Numeric)
        coupon_amount(required: false, PropertyType.Numeric)
        marketplace(required: false, PropertyType.String)

        // Possible fields only for IOS
        shipping_amount(required: false, PropertyType.Numeric)
        coupon_id(required: false, PropertyType.Numeric)
        captured(required: false, PropertyType.Boolean)
        fee_details(required: false, description: "Free details information")
        date_created(required: false, PropertyType.String)
        date_last_updated(required: false, PropertyType.String)
        api_version(required: false, PropertyType.String)
        id(required: false, PropertyType.Numeric)
        money_release_days(required: false, PropertyType.Numeric)
        order(required: false, description: "order information")
        external_reference(required: false, PropertyType.String)
        description(required: false, PropertyType.String)
        transaction_details(required: false, description: "transaction information details")
        client_id(required: false, PropertyType.String)
        binary_mode(required: false, PropertyType.Boolean)
        transaction_id(required: false, PropertyType.String)
        installments(required: false, PropertyType.Numeric)
        money_release_date(required: false, PropertyType.String)
        internal_metadata(required: false, description: "transaction information details")
        transaction_amount_refunded(required: false, PropertyType.Numeric)
        payment_type_id (required: false, PropertyType.String)
        notification_url(required: false, PropertyType.String)
        sponsor_id(required: false, PropertyType.Numeric)
        vending_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
    }
    "/instore/payment_info"(platform: "/mobile", type: TrackType.Event) {
        payment_info_tag(required: false, "Execute post payment")
        remaining_attempts(required: false, PropertyType.Numeric)
    }

    // Deprecated. Only for old versions in IOS!
    "/instore/post_payment"(platform: "/mobile", type: TrackType.Event) {
        raw(required: false, description: "Raw with post payment information")
    }
    "/instore/required_action"(platform: "/mobile", isAbstract: true) {}
    "/instore/required_action/data_required"(platform: "/mobile", type: TrackType.View) {}
    "/instore/required_action/data_required/dni"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting"(platform: "/mobile", type: TrackType.View) {}
    "/instore/permission"(platform: "/mobile", isAbstract: true) {}
    "/instore/permission/location"(platform: "/mobile", type: TrackType.View) {}
    "/instore/camera_permission"(platform: "/mobile", type: TrackType.View) {}
    "/instore/generic_error"(platform: "/mobile", type: TrackType.View) {
            additional_info (required:false, description: "Extra info")
    }
    "/instore/scan_qr/read"(platform: "/mobile", type: TrackType.Event) {
        data(required:true, type: PropertyType.String)
    }
    "/instore/required_action/bluetooth_permission"(platform: "/mobile", type: TrackType.View) {}
    "/instore/required_action/bluetooth_on"(platform: "/mobile", type: TrackType.View) {}
    "/instore/map"(platform: "/mobile", type: TrackType.View) {}
    "/instore/scan_qr/ftu"(platform: "/mobile", type: TrackType.View) {}
    "/instore/manual_price"(platform: "/mobile", type: TrackType.View) {}
    "/instore/activity"(platform: "/mobile", isAbstract: true) {}
    "/instore/activity/list"(platform: "/mobile", type: TrackType.View) {}
    "/instore/price_picker"(platform: "/mobile", type: TrackType.View) {}

    // Discovery
    "/instore/map"(platform: "/mobile", type: TrackType.View) {
        type(required: true, inheritable: false, PropertyType.String, description: "type of stores to show on the map")
        tags(required: true, inheritable: false, PropertyType.ArrayList(PropertyType.String), description: "an array of strings used to know the type of stores to show on the map")
    }
    "/instore/map/first_user_location"(platform: "/mobile", type: TrackType.Event) {
        northeast(required: true, PropertyType.String, description: "latitude and longitude of the northeast corner of the visible area on the map")
        southwest(required: true, PropertyType.String, description: "latitude and longitude of the southwest corner of the visible area on the map")
        location(required: true, PropertyType.String)
    }
    "/instore/map/data_retrieved"(platform: "/mobile", type: TrackType.Event) {
        action_type(required: true, PropertyType.String, description: "type of action that triggered the data request", values: ["init", "search_in_this_area", "filters_applied", "text_search"])
        stores_quantity(required: true, PropertyType.String)
    }
    "/instore/map/pin_selected"(platform: "/mobile", type: TrackType.Event) {
        store_name(required: true, PropertyType.String, description: "the name of the selected store")
        store_id(required: true, PropertyType.String, description: "the store's id")
        store_location(required: true, PropertyType.String, description: "the stores lat and long")
    }
    "/instore/map/locate_by_gps"(platform: "/mobile", type: TrackType.Event) {
    }
    "/instore/map/search_in_this_area"(platform: "/mobile", type: TrackType.Event) {
        northeast(required: true, PropertyType.String, description: "latitude and longitude of the northeast corner of the visible area on the map")
        southwest(required: true, PropertyType.String, description: "latitude and longitude of the southwest corner of the visible area on the map")
        tags(required: true, PropertyType.ArrayList(PropertyType.String), description: "an array of strings used to know the type of stores to show on the map")
        includes_user_position(required: true, PropertyType.Boolean)
        center(required: true, PropertyType.String)
    }
    "/instore/map/navigate_to_store"(platform: "/mobile", type: TrackType.Event) {
        store_name(required: true, PropertyType.String)
        store_location(required: true, PropertyType.String)
        navigation_apps(required: true, PropertyType.ArrayList(PropertyType.String), description: "all the apps available to handle the requested navigation")
    }
    "/instore/map/navigate_to_store_app_chosen"(platform: "/mobile", type: TrackType.Event) {
        store_name(required: true, PropertyType.String)
        store_location(required: true, PropertyType.String)
        navigation_apps(required: true, PropertyType.ArrayList(PropertyType.String))
        chosen_app(required: true, PropertyType.String)
        view_time_in_millis(required: true, PropertyType.String)
    }
    "/instore/map/quick_filters_selected"(platform: "/mobile", type: TrackType.Event) {
        selected_filters(required: true, PropertyType.ArrayList(PropertyType.String))
    }
    "/instore/map/back"(platform: "/mobile", type: TrackType.Event) {
        view_time_in_millis(required: true, PropertyType.String)
    }
    "/instore/map/error"(platform: "/mobile", isAbstract: true) {}
    "/instore/map/error/server_error"(platform: "/mobile", type: TrackType.View) {
        style(required: true, PropertyType.String, descriptio: "how the error is presented to the user (screen, snackbar")
        id(required: true, PropertyType.String, description:"an identifer for the type of error")
        message(required: true, PropertyType.String, description: "server error description")
        attributable_to(required: true, PropertyType.String)
    }

}
