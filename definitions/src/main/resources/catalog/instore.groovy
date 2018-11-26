import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * INSTORES Screen Tracks
    */

    "/instore"(platform: "/mobile", isAbstract: true) {}

    // Scan QR
    "/instore/scan_qr"(platform: "/mobile", type: TrackType.View) {
        camera_permissions(required: false, PropertyType.Boolean)
        location_permissions(required: false, PropertyType.Boolean)
        notification_permissions(required: false, PropertyType.Boolean)
        // Deprecated. Typo on Android
        notifications_permissions(required: false, PropertyType.Boolean)
    }
    "/instore/scan_qr"(platform: "/mobile", isAbstract: true) {}
    "/instore/scan_qr/qr_discovery"(platform: "/mobile", type: TrackType.Event) {
        qr_data(required: false, PropertyType.String)
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
    }
    "/instore/scan_qr/flash"(platform: "/mobile", type: TrackType.Event) {
        camera_flash(required: false, PropertyType.Boolean)
    }
    "/instore/scan_qr/abort"(platform: "/mobile", type: TrackType.Event) {
        view_time_in_millis(required: false, PropertyType.String)
        camera_flash(required: false, PropertyType.Boolean)
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

    // Permissions
    "/ask_device_permission"(platform: "/mobile", isAbstract: true) {}
    "/ask_device_permission/location"(platform: "/mobile", type: TrackType.View) {
        context(required: true, PropertyType.String)
    }
    "/ask_device_permission/location/"(platform: "/mobile", isAbstract: true) {}
    "/ask_device_permission/location/back"(platform: "/mobile", type: TrackType.Event) {
        context(required: true, PropertyType.String)
    }
    "/ask_device_permission/location/granted"(platform: "/mobile", type: TrackType.Event) {
        context(required: true, PropertyType.String)
    }
    "/ask_device_permission/location/rejected"(platform: "/mobile", type: TrackType.Event) {
        context(required: true, PropertyType.String)
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
    "/instore/shell_first_time_use/abort"(platform: "/mobile", type: TrackType.Event) {
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
    "/instore/vending"(platform: "/mobile", isAbstract: true) {}
    "/instore/vending/st_machine_disconnected"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/vending/machine_response_final_result"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        machine_response_final_result(required: false, PropertyType.String)
    }
    "/instore/vending/st_machine_connection_error"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        st_machine_connection_error(required: false, PropertyType.String)
    }
    "/instore/vending/machine_response_state"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        machine_response_state(required: false, PropertyType.String)
    }
    "/instore/vending/st_machine_not_available"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/vending/st_machine_connected"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
    }
    "/instore/vending/response_end_transaction"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        response_end_transaction(required: false, description: "Transaction response")
    }
    "/instore/vending/response_payment"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, PropertyType.String)
        brand_name(required: false, PropertyType.String)
        store_id(required: false, PropertyType.String)
        pos_id(required: false, PropertyType.String)
        response_payment(required: false, description: "Payment response")
    }

    "/instore/post_payment"(platform: "/mobile", type: TrackType.Event) {
        // Possible fields for Android & IOS
        currency_id(required: false, PropertyType.String)
        statement_descriptor(required: false, PropertyType.String)
        collector_id(required: false, PropertyType.Numeric)
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


    }
    "/instore/payment_info"(platform: "/mobile", type: TrackType.Event) {
        payment_info_tag(required: false, "Execute post payment")
    }

    // Deprecated. Only for old versions in IOS!
    "/instore/post_payment"(platform: "/mobile", type: TrackType.Event) {
        raw(required: false, description: "Raw with post payment information")
    }
    "/instore/vending/select_product"(platform: "/mobile", type: TrackType.View) {}
    "/instore/required_action"(platform: "/mobile", isAbstract: true) {}
    "/instore/required_action/data_required"(platform: "/mobile", type: TrackType.View) {}
    "/instore/required_action/data_required/dni"(platform: "/mobile", type: TrackType.View) {}
    "/instore/gas_station_shell"(platform: "/mobile", type: TrackType.View) {}
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
    // Deprecated PX
    "/instore/checkout"(platform: "/mobile", isAbstract: true) {}
    "/instore/checkout/payment_method_search"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/review_and_confirm"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/result"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/payment_option"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/review"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/card_installments"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/card_number"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/card_vault credit_card"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/card_holder_name"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/card_expiry_date"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/card_security_code"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/identification_number"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/installments"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/card/installments"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/security_code_card"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/card"(platform: "/mobile", isAbstract: true) {}
    "/instore/checkout/card/credit_card"(platform: "/mobile", isAbstract: true) {}
    "/instore/checkout/card/credit_card/security_code"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/card/debit_card"(platform: "/mobile", isAbstract: true) {}
    "/instore/checkout/card/debit_card/security_code"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/congrats"(platform: "/mobile", isAbstract: true) {}
    "/instore/checkout/congrats/business"(platform: "/mobile", type: TrackType.View) {}
    "/instore/checkout/congrats/rejected"(platform: "/mobile", type: TrackType.View) {}
}
