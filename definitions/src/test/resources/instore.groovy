import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Instore") {

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Instore Meli
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        // Error
        "/instore/generic_error"(platform: "/mobile", type: TrackType.View) {
            additional_info = {
                message = "Escanear código QR"
                icon = "error"
                description = "Solo puedes pagar usando códigos de Mercado Pago"
                message = "¿Estas seguro que ese código es para pagar?"
                actions = [{
                               id = "try_again"
                               link = "meli://mp/scan_qr"
                               label = "Intentar nuevamente"
                               type = "link"
                           }]
            }
        }

        // Scan QR
        "/instore/scan_qr"(platform: "/mobile", type: TrackType.View) {}
        "/instore/qr_first_time_use"(platform: "/mobile", type: TrackType.View) {}
        "/instore/scan_qr/read"(platform: "/mobile", type: TrackType.Event) {
            data = "Any scanned data"
        }

        // Permissions
        "/instore/camera_permission"(platform: "/mobile", type: TrackType.View) {}
        "/instore/permission/location"(platform: "/mobile", type: TrackType.View) {}

        // Amount
        "/instore/amount/calculator"(platform: "/mobile", type: TrackType.View) {}
        "/instore/amount/price_list"(platform: "/mobile", type: TrackType.View) {}

        // Shell
        "/instore/gas_station_shell"(platform: "/mobile", type: TrackType.View) {}
        "/instore/shell_first_time_use"(platform: "/mobile", type: TrackType.View) {}

        // Vending
        "/instore/vending/select_product"(platform: "/mobile", type: TrackType.View) {}

        // Waiting
        "/instore/waiting"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/gas_jockey"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/gas_pump"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/gas_clock"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/gastronomy_cashier"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/gastronomy_order"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/generic_cashier"(platform: "/mobile", type: TrackType.View) {}
        "/instore/waiting/generic_ticket"(platform: "/mobile", type: TrackType.View) {}

        // Required action
        "/instore/required_action/data_required"(platform: "/mobile", type: TrackType.View) {}
        "/instore/required_action/data_required/dni"(platform: "/mobile", type: TrackType.View) {}
        "/instore/required_action/bluetooth_permission"(platform: "/mobile", type: TrackType.View) {}

        // Deprecated
        "/instore/map"(platform: "/mobile", type: TrackType.View) {}
        "/instore/required_action/bluetooth_on"(platform: "/mobile", type: TrackType.View) {}
        "/instore/map"(platform: "/mobile", type: TrackType.View) {}
        "/instore/scan_qr/ftu"(platform: "/mobile", type: TrackType.View) {}
        "/instore/manual_price"(platform: "/mobile", type: TrackType.View) {}

        // Error
        "/instore/generic_error"(platform: "/mobile", type: TrackType.View) {
            additional_info = {
                message = "Escanear código QR"
                icon = "error"
                description = "Solo puedes pagar usando códigos de Mercado Pago"
                message = "¿Estas seguro que ese código es para pagar?"
                actions = [{
                               id = "try_again"
                               link = "meli://mp/scan_qr"
                               label = "Intentar nuevamente"
                               type = "link"
                           }]
            }
        }

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Mercado Pago
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        // Error
        "/instore/generic_error"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {
            additional_info = {
                message = "Escanear código QR"
                icon = "error"
                description = "Solo puedes pagar usando códigos de Mercado Pago"
                message = "¿Estas seguro que ese código es para pagar?"
                actions = [{
                               id = "try_again"
                               link = "meli://mp/scan_qr"
                               label = "Intentar nuevamente"
                               type = "link"
                           }]
            }
        }

        // Scan QR
        "/instore/scan_qr"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/qr_first_time_use"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/scan_qr/read"(platform: "/mobile", business:"mercadopago", type: TrackType.Event) {
            data = "Any scanned data"
        }

        // Permissions
        "/instore/camera_permission"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/permission/location"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}

        // Amount
        "/instore/amount/calculator"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/amount/price_list"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}

        // Shell
        "/instore/gas_station_shell"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/shell_first_time_use"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}

        // Vending
        "/instore/vending/select_product"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}

        // Waiting
        "/instore/waiting"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/gas_jockey"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/gas_pump"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/gas_clock"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/gastronomy_cashier"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/gastronomy_order"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/generic_cashier"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/waiting/generic_ticket"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}

        // Required action
        "/instore/required_action/data_required"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/required_action/data_required/dni"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/required_action/bluetooth_permission"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}

        // Deprecated
        "/instore/map"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/required_action/bluetooth_on"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/map"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/scan_qr/ftu"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
        "/instore/manual_price"(platform: "/mobile", business:"mercadopago", type: TrackType.View) {}
    }
}
